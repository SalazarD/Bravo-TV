package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.Mock;
import com.utilities.DbCon;

public class MockDao {
	
	public static ArrayList<Mock> getAllMocks() {
		ArrayList<Mock> result = new ArrayList<Mock>();
		Connection con = DbCon.getConnection();
		try {
			PreparedStatement s = con.prepareStatement("SELECT * FROM Mock");
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				result.add(DaoHelper.getTupleAsBean(rs, Mock.class));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DbCon.closeConnection();
		}
		return result;
	}
	
}
