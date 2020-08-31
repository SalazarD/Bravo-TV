package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Stb;
import com.bean.StbType;
import com.utilities.DbCon;

public class StbDao extends AbstractDao<Stb> {

	@Override
	protected String getTableName() {
		return "CASE_STB_Inventory";
	}

	@Override
	protected Stb getNewBean() {
		return new Stb();
	}
	
	public Stb findAllSTB(int stb_type_id) {
		Stb box = new Stb();
		
		Connection con = DbCon.getConnection();
		try {
			String qry = "SELECT * from case_stb_inventory WHERE assigned_customer_id=-1 AND stb_type_id=? LIMIT 1";
			
			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1, stb_type_id);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				box.setStd_id(rs.getInt(1));
				box.setStb_type_id(rs.getInt(2));
				box.setSerial_num(rs.getString(3));
				box.setMac_id(rs.getString(4));
				box.setRemote_asset_id(rs.getString(5));
				box.setDish_asset_id(rs.getString(6));
				box.setStatus(rs.getString(7));
				box.setAssigned_retailer_id(rs.getInt(8));
				box.setAssigned_customer_id(rs.getInt(9));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return box;
	}
	

}
