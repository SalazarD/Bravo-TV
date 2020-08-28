package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.ChannelPackage;
import com.utilities.DbCon;

public class PurchasePackageDao {
	
	public boolean addPackagePurchase(int customer_id, int package_id) {
		boolean success = false;
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO CASE_PurchaseMap (customer_id, package_id) VALUES (?, ?)");
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
	
	public boolean removePackagePurchase(int customer_id, int package_id) {
		boolean success = false;
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELTE FROM CASE_PurchaseMap WHERE customer_id = ? AND package_id = ?");
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
	
	public boolean hasPackagePurchase(int customer_id, int package_id) {
		boolean success = false;
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM CASE_PurchaseMap WHERE customer_id = ? AND package_id = ?");
			ps.setInt(1, customer_id);
			ps.setInt(2, package_id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				success = rs.getInt(1) == 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return success;
	}
	
	public ArrayList<ChannelPackage> getPurchasedPackages(int customer_id) {
		
		// Get the ids of all purchased packages
		ArrayList<Integer> packageIds = new ArrayList<>();
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT package_id FROM CASE_PurchaseMap WHERE customer_id = ?");
			ps.setInt(1, customer_id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				packageIds.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		// get packages corresponding to ids
		ArrayList<ChannelPackage> list = new ArrayList<>();
		ChannelPackageDao pd = new ChannelPackageDao();
		for (Integer package_id : packageIds) {
			ChannelPackage p = new ChannelPackage();
			p.setPackage_id(package_id);
			if (pd.read(p)) {
				list.add(p);
			}
		}
		
		return list;
	}
}
