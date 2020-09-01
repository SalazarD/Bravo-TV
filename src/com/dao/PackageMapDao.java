package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Channel;
import com.utilities.DbCon;

public class PackageMapDao {
	
	/**
	 * Adds a channel to the list of channels in the package.
	 * @param channel_id The ID of the channel
	 * @param package_id The ID of the package
	 * @return True if the change was successful, false otherwise.
	 */
	public boolean addChannel(int channel_id, int package_id) {
		boolean success = false;
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO CASE_Package_Map (channel_id, package_id) VALUES (?, ?)");
			ps.setInt(1, channel_id);
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
	 * Removes a channel from the list of channels in the package.
	 * @param channel_id The ID of the channel
	 * @param package_id The ID of the package
	 * @return True if the change was successful, false otherwise.
	 */
	public boolean removePackagePurchase(int channel_id, int package_id) {
		boolean success = false;
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM CASE_Package_Map WHERE channel_id = ? AND package_id = ?");
			ps.setInt(1, channel_id);
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
	 * Gets a list of all packages purchased by the customer, including default packages
	 * @param package_id The ID of the package
	 * @return A list with all the channels in the packages. Empty if 
	 *         the package has no channels, or if the operation failed.
	 */
	public ArrayList<Channel> getAllChannels(int package_id) {
		ArrayList<Channel> list = new ArrayList<>();
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM CASE_Channel "
				  + "WHERE channel_id IN (SELECT channel_id FROM CASE_Package_Map WHERE package_id = ?)"
			);
			ps.setInt(1, package_id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Channel c = new Channel();
				AbstractDao.readBeanFromResultSet(rs, rs.getMetaData(), c);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return list;
	}
}
