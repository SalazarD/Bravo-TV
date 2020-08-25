package com.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.Case_Retailer;
import com.utilities.DbCon;

public class RetailerDao {

private static String table = "CASE_Retailer";
	
	public int insert(Case_Retailer obj) {
		
		int code = 0;
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "INSERT INTO " + table + 
					" (retailer_name, contact_num1, contact_num2, address_1, address_2, " +
					"zip_code, city, state_province, set_top_box_limit, credit_limit, " + 
					"commission_rate, service_charges, inventory_list, retailer_creation_date, " +
					"total_cost_of_inventory, oncreate_retailer, total_retailer_in_city, password, first_time_user) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement st = con.prepareStatement(qry);
			
			st.setString(1, obj.getRetailer_name());
			st.setString(2, obj.getContact_num1());
			st.setString(3, obj.getContact_num2());
			st.setString(4, obj.getAddress_1());
			st.setString(5, obj.getAddress_2());
			st.setString(6, obj.getZip_code());
			st.setString(7, obj.getCity());
			st.setString(8, obj.getState_province());
			st.setString(9, obj.getSet_top_box_limit());
			st.setBigDecimal(10, obj.getCredit_limit());
			st.setBigDecimal(11, obj.getCommission_rate());
			st.setBigDecimal(12, obj.getService_charges());
			st.setString(13, obj.getInventory_list());
			st.setString(14, obj.getRetailer_creation_date());
			st.setBigDecimal(15, obj.getTotal_cost_of_inventory());
			st.setString(16, obj.getOncreate_retailer());
			st.setString(17, obj.getTotal_reatiler_in_city());
			st.setString(18, obj.getPassword());
			st.setBoolean(19, obj.getFirst_time_user());

			code = st.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return code;
	}
	
	public int update(Case_Retailer retailer) {
		int code = 0;
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "UPDATE " + table + 
					" SET retailer_name=?, contact_num1=?, contact_num2=?, address_1=?, address_2=?, zip_code=?, city=?, state_province=?, set_top_box_limit=?, credit_limit=?, " + 
					"commission_rate=?, service_charges=?, inventory_list=?, retailer_creation_date=?, total_cost_of_inventory=?, oncreate_retailer=?, total_retailer_in_city=?, password=?, first_time_user=? " +
					"WHERE retailer_id=?";
			
			PreparedStatement st = con.prepareStatement(qry);
			
			st.setString(1, retailer.getRetailer_name());
			st.setString(2, retailer.getContact_num1());
			st.setString(3, retailer.getContact_num2());
			st.setString(4, retailer.getAddress_1());
			st.setString(5, retailer.getAddress_2());
			st.setString(6, retailer.getZip_code());
			st.setString(7, retailer.getCity());
			st.setString(8, retailer.getState_province());
			st.setString(9, retailer.getSet_top_box_limit());
			st.setBigDecimal(10, retailer.getCredit_limit());
			st.setBigDecimal(11, retailer.getCommission_rate());
			st.setBigDecimal(12, retailer.getService_charges());
			st.setString(13, retailer.getInventory_list());
			st.setString(14, retailer.getRetailer_creation_date());
			st.setBigDecimal(15, retailer.getTotal_cost_of_inventory());
			st.setString(16, retailer.getOncreate_retailer());
			st.setString(17, retailer.getTotal_reatiler_in_city());
			st.setString(18, retailer.getPassword());
			st.setBoolean(19, retailer.getFirst_time_user());
			st.setInt(20, retailer.getRetailer_id());
			
			code = st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return code;
	}
	
	public int delete(Case_Retailer retailer) {
		int code = 0;
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "DELETE FROM " + table + " WHERE retailer_id=?";
			
			PreparedStatement st = con.prepareStatement(qry);
			
			st.setInt(1, retailer.getRetailer_id());
			
			code = st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return code;
	}
	
	public Case_Retailer getById(int id) {
		
		Case_Retailer retailer = new Case_Retailer();
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "SELECT * FROM " + table + " WHERE retailer_id=?";
			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				retailer.setRetailer_id(rs.getInt("retailer_id"));
				retailer.setRetailer_name(rs.getString("retailer_name"));
				retailer.setContact_num1(rs.getString("contact_num1"));
				retailer.setContact_num2(rs.getString("contact_num2"));
				retailer.setAddress_1(rs.getString("address_1"));
				retailer.setAddress_2(rs.getString("address_2"));
				retailer.setZip_code(rs.getString("zip_code"));
				retailer.setCity(rs.getString("city"));
				retailer.setState_province(rs.getString("state_province"));
				retailer.setSet_top_box_limit(rs.getString("set_top_box_limit"));
				retailer.setCredit_limit(rs.getBigDecimal("credit_limit"));
				retailer.setCommission_rate(rs.getBigDecimal("commission_rate"));
				retailer.setService_charges(rs.getBigDecimal("service_charges"));
				retailer.setInventory_list(rs.getString("inventory_list"));
				retailer.setRetailer_creation_date(rs.getString("retailer_creation_date"));
				retailer.setTotal_cost_of_inventory(rs.getBigDecimal("total_cost_of_inventory"));
				retailer.setOncreate_retailer(rs.getString("oncreate_retailer"));
				retailer.setTotal_reatiler_in_city(rs.getString("total_retailer_in_city"));
				retailer.setPassword(rs.getString("password"));
				retailer.setFirst_time_user(rs.getBoolean("first_time_user"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return retailer;
	}
	
	public ArrayList<Case_Retailer> getAll() {
		
		ArrayList<Case_Retailer> retailers = new ArrayList<>();
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "SELECT * FROM " + table;
			PreparedStatement st = con.prepareStatement(qry);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				
				Case_Retailer retailer = new Case_Retailer();
				retailer.setRetailer_id(rs.getInt("retailer_id"));
				retailer.setRetailer_name(rs.getString("retailer_name"));
				retailer.setContact_num1(rs.getString("contact_num1"));
				retailer.setContact_num2(rs.getString("contact_num2"));
				retailer.setAddress_1(rs.getString("address_1"));
				retailer.setAddress_2(rs.getString("address_2"));
				retailer.setZip_code(rs.getString("zip_code"));
				retailer.setCity(rs.getString("city"));
				retailer.setState_province(rs.getString("state_province"));
				retailer.setSet_top_box_limit(rs.getString("set_top_box_limit"));
				retailer.setCredit_limit(rs.getBigDecimal("credit_limit"));
				retailer.setCommission_rate(rs.getBigDecimal("commission_rate"));
				retailer.setService_charges(rs.getBigDecimal("service_charges"));
				retailer.setInventory_list(rs.getString("inventory_list"));
				retailer.setRetailer_creation_date(rs.getString("retailer_creation_date"));
				retailer.setTotal_cost_of_inventory(rs.getBigDecimal("total_cost_of_inventory"));
				retailer.setOncreate_retailer(rs.getString("oncreate_retailer"));
				retailer.setTotal_reatiler_in_city(rs.getString("total_retailer_in_city"));
				retailer.setPassword(rs.getString("password"));
				retailer.setFirst_time_user(rs.getBoolean("first_time_user"));

				retailers.add(retailer);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return retailers;
	}
}
