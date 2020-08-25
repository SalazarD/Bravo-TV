package com.dao;

import com.bean.Case_Customer;
import com.utilities.DbCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO {
	private static String table="CASE_Customer";
	
	public int insert(Case_Customer obj) {
		int code = 0;
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "insert into "+table+" (first_name, last_name, email_id, phone_number,"+
							" address_one, oddress_two, land_mark, zip_code, city, state,"+
							" customer_creation_date, assigned_operator, assigned_retailer,"+
							" purchased_stb, purchased_package, purchased_channel, password, first_time_user) "+
							"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement st = con.prepareStatement(qry);
			
			st.setString(1, obj.getFirst_name());
			st.setString(2, obj.getLast_name());
			st.setString(3, obj.getEmail_id());
			st.setString(4, obj.getPhone_number());
			st.setString(5, obj.getAddress_one());
			st.setString(6, obj.getAddress_two());
			st.setString(7, obj.getLand_mark());
			st.setInt(8, obj.getZip_code());
			st.setString(9, obj.getCity());
			st.setString(10, obj.getState());
			st.setString(11, obj.getCustomer_creation_date());
			st.setString(12, obj.getAssigned_operator());
			st.setString(13, obj.getAssigned_retailer());
			st.setInt(14, obj.getPurchased_stb());
			st.setInt(15, obj.getPurchased_package());
			st.setInt(16, obj.getPurchased_channel());
			st.setString(17, obj.getPassword());
			st.setBoolean(18, obj.getFirst_time_user());
			
			code = st.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return code;
	}
	
	public int update(Case_Customer obj) {
		int code = 0;
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "update "+table+" set first_name=?, last_name=?, email_id=?, phone_number=?, "
					+ "address_one=?, address_two=?, land_mark=?, zip_code=?, city=?, state=?, customer_creation_date=?, "
					+ "assigned_operator=?, assigned_retailer=?, purchased_stb=?, purchased_package=?, purchased_channel=?, password=?, first_time_user=?"
					+ " where customer_id=?";
			
			PreparedStatement st = con.prepareStatement(qry);
			
			st.setString(1, obj.getFirst_name());
			st.setString(2, obj.getLast_name());
			st.setString(3, obj.getEmail_id());
			st.setString(4, obj.getPhone_number());
			st.setString(5, obj.getAddress_one());
			st.setString(6, obj.getAddress_two());
			st.setString(7, obj.getLand_mark());
			st.setInt(8, obj.getZip_code());
			st.setString(9, obj.getCity());
			st.setString(10, obj.getState());
			st.setString(11, obj.getCustomer_creation_date());
			st.setString(12, obj.getAssigned_operator());
			st.setString(13, obj.getAssigned_retailer());
			st.setInt(14, obj.getPurchased_stb());
			st.setInt(15, obj.getPurchased_package());
			st.setInt(16, obj.getPurchased_channel());
			st.setString(17, obj.getPassword());
			st.setBoolean(18, obj.getFirst_time_user());
			st.setInt(19, obj.getCustomer_id());
			
			code = st.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		
		return code;
	}
	
	public boolean validateCustomer(String email, String password) {
		boolean exists = false;
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "select count(*) count from "+table+" where email_id='"+email+"' and password='"+password+"'";
			PreparedStatement st = con.prepareStatement(qry);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt(1) == 1) {
					exists = true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return exists;
	}
	
	public Case_Customer getCustomer(String email) {
		Case_Customer customer = new Case_Customer();
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "select * from "+table+" where email_id=?";
			PreparedStatement st = con.prepareStatement(qry);
			
			st.setString(1, email);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				customer.setCustomer_id(rs.getInt(1));
				customer.setFirst_name(rs.getString(2));
				customer.setLast_name(rs.getString(3));
				customer.setEmail_id(rs.getString(4));
				customer.setPhone_number(rs.getString(5));
				customer.setAddress_one(rs.getString(6));
				customer.setAddress_two(rs.getString(7));
				customer.setLand_mark(rs.getString(8));
				customer.setZip_code(rs.getInt(9));
				customer.setCity(rs.getString(10));
				customer.setState(rs.getString(11));
				customer.setCustomer_creation_date(rs.getString(12));
				customer.setAssigned_operator(rs.getString(13));
				customer.setAssigned_retailer(rs.getString(14));
				customer.setPurchased_stb(rs.getInt(15));
				customer.setPurchased_package(rs.getInt(16));
				customer.setPurchased_channel(rs.getInt(17));
				customer.setFirst_time_user(rs.getBoolean(19));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return customer;
	}
	
	public Case_Customer getCustomerById(int id) {
		Case_Customer customer = new Case_Customer();
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "select * from "+table+" where customer_id=?";
			PreparedStatement st = con.prepareStatement(qry);
			
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				customer.setCustomer_id(rs.getInt(1));
				customer.setFirst_name(rs.getString(2));
				customer.setLast_name(rs.getString(3));
				customer.setEmail_id(rs.getString(4));
				customer.setPhone_number(rs.getString(5));
				customer.setAddress_one(rs.getString(6));
				customer.setAddress_two(rs.getString(7));
				customer.setLand_mark(rs.getString(8));
				customer.setZip_code(rs.getInt(9));
				customer.setCity(rs.getString(10));
				customer.setState(rs.getString(11));
				customer.setCustomer_creation_date(rs.getString(12));
				customer.setAssigned_operator(rs.getString(13));
				customer.setAssigned_retailer(rs.getString(14));
				customer.setPurchased_stb(rs.getInt(15));
				customer.setPurchased_package(rs.getInt(16));
				customer.setPurchased_channel(rs.getInt(17));
				customer.setPassword(rs.getString(18));
				customer.setFirst_time_user(rs.getBoolean(19));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return customer;
	}
}
