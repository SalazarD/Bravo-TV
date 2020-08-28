package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.StbType;
import com.utilities.DbCon;

public class StbTypeDao extends AbstractDao<StbType> {

	@Override
	protected String getTableName() {
		return "CASE_STB_Type";
	}

	@Override
	protected StbType getNewBean() {
		return new StbType();
	}

	public StbType getByTwoTypes(String type, String billing_type) {
		StbType box = new StbType();
		
		Connection con = DbCon.getConnection();
		try {
			String qry = "SELECT * from CASE_STB_Type WHERE type=? AND billing_type=? LIMIT 1";
			
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, type);
			st.setString(2, billing_type);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				box.setStb_type_id(rs.getInt("stb_type_id"));
				box.setType(rs.getString("type"));
				box.setFeatures(rs.getString("features"));
				box.setLength(rs.getBigDecimal("length"));
				box.setBreadth(rs.getBigDecimal("breadth"));
				box.setWidth(rs.getBigDecimal("width"));
				box.setPrice(rs.getBigDecimal("price"));
				box.setInstall_charges(rs.getBigDecimal("install_charges"));
				box.setUpgrade_charge(rs.getBigDecimal("upgrade_charge"));
				box.setDiscount(rs.getInt("discount"));
				box.setBilling_type(rs.getString("billing_type"));
				box.setRefundable_deposit(rs.getBigDecimal("refundable_deposit"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return box;
	}
}
