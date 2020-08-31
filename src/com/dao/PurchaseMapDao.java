package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.ChannelPackage;
import com.utilities.DbCon;

public class PurchaseMapDao {
	
	/**
	 * Adds a package to the list of packages purchased by the customer.
	 * @param customer_id The ID of the customer
	 * @param package_id The ID of the package
	 * @return True if the purchase was successful, false otherwise.
	 */
	public boolean addPackagePurchase(int customer_id, int package_id) {
		boolean success = false;
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO CASE_Purchase_Map (customer_id, package_id) VALUES (?, ?)");
			ps.setInt(1, customer_id);
			ps.setInt(2, package_id);
			
			success = ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return success;
	}
	
	/**
	 * Removes a package from the list of packages purchased by the customer.
	 * @param customer_id The ID of the customer
	 * @param package_id The ID of the package
	 * @return True if successful, false otherwise.
	 */
	public boolean removePackagePurchase(int customer_id, int package_id) {
		boolean success = false;
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM CASE_Purchase_Map WHERE customer_id = ? AND package_id = ?");
			ps.setInt(1, customer_id);
			ps.setInt(2, package_id);
			
			success = ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return success;
	}

	/**
	 * Clears all purchases by the customer.
	 * @param customer_id The ID of the customer
	 * @return True if successful, false otherwise.
	 */
	public boolean removeAllPurchases(int customer_id) {
		boolean success = false;
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM CASE_Purchase_Map WHERE customer_id = ?");
			ps.setInt(1, customer_id);
			
			ps.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return success;
	}
	
	/**
	 * Gets a list of all packages purchased by the customer, including default packages
	 * @param customer_id The ID of the customer
	 * @return A list with all the packages purchased by the customer. Empty if 
	 *         the customer has no packages, or if the operation failed.
	 */
	public ArrayList<ChannelPackage> getPurchasedPackages(int customer_id) {
		ArrayList<ChannelPackage> list = new ArrayList<>();
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM CASE_Channel_Package "
				  + "WHERE package_id IN (SELECT package_id FROM CASE_Purchase_Map WHERE customer_id = ?)"
			);
			ps.setInt(1, customer_id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ChannelPackage cp = new ChannelPackage();
				AbstractDao.readBeanFromResultSet(rs, rs.getMetaData(), cp);
				list.add(cp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return list;
	}
	
	/**
	 * Gets a list of all packages NOT yet purchased by the customer, including default packages
	 * @param customer_id The ID of the customer
	 * @return A list with all the packages not yet purchased by the customer. Empty if 
	 *         the customer has purchased all packages, or if the operation failed.
	 */
	public ArrayList<ChannelPackage> getNonPurchasedPackages(int customer_id) {
		ArrayList<ChannelPackage> list = new ArrayList<>();
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM CASE_Channel_Package "
				  + "WHERE package_id NOT IN (SELECT package_id FROM CASE_Purchase_Map WHERE customer_id = ?) "
				  /*+ "AND package_transmission_type IN ("
				  + 	"SELECT type FROM CASE_STB_Type WHERE stb_type_id IN ("
				  + 		"SELECT stb_type_id FROM CASE_STB_Inventory WHERE assigned_customer_id = ?))"*/
			);
			ps.setInt(1, customer_id);
			//ps.setInt(2, customer_id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ChannelPackage cp = new ChannelPackage();
				AbstractDao.readBeanFromResultSet(rs, rs.getMetaData(), cp);
				list.add(cp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return list;
	}
	
	/**
	 * Gets a list of all package IDs that a customer CAN purchase, regardless if the package has already been purchased
	 * @param customer_id The ID of the customer
	 * @return A list with all the packages IDs that CAN be purchased by the customer. Empty if 
	 *         the customer cannot purchased any packages, or if the operation failed.
	 */
	public ArrayList<Integer> getAvailablePackageIds(int customer_id) {
		ArrayList<Integer> list = new ArrayList<>();
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT package_id FROM CASE_Channel_Package "
				  /*+ "WHERE package_transmission_type IN ("
				  + 	"SELECT type FROM CASE_STB_Type WHERE stb_type_id IN ("
				  + 		"SELECT stb_type_id FROM CASE_STB_Inventory WHERE assigned_customer_id = ?))"*/
			);
			//ps.setInt(1, customer_id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return list;
	}
}
