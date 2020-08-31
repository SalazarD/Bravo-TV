package com.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.bean.ChannelPackage;
import com.utilities.DbCon;

public class ChannelPackageDao extends AbstractDao<ChannelPackage> {

	@Override
	protected String getTableName() {
		return "CASE_Channel_Package";
	}

	@Override
	protected ChannelPackage getNewBean() {
		return new ChannelPackage();
	}
	
	public ArrayList<ChannelPackage> getAllDefaultPackages() {
		ArrayList<ChannelPackage> list = new ArrayList<>();
		Connection connection = DbCon.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM CASE_Channel_Package WHERE added_by_default = ?");
			ps.setBoolean(1, true);
			
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
}
