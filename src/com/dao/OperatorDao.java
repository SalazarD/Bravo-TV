package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Case_Customer;
import com.utilities.DbCon;

public class OperatorDao {
	
	public void insertCustomer(Case_Customer customer) {
		// insert a new person
		System.out.println("called addperson");
		String sql="insert into case_customer (first_name, last_name, email_id,"
				+ " phone_number, address_one, address_two, land_mark, zip_code,"
				+ " city, state, customer_creation_date, assigned_operator,"
				+ " assigned_retailer, password, first_time_user) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int resultset;
		Connection connect=DbCon.getConnection();	
		try {
			System.out.println("called try-catch");
			System.out.println(customer.toString()+"in try catch");
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 			
			stmt.setString(1,customer.getFirst_name());
			stmt.setString(2,customer.getLast_name());
			stmt.setString(3,customer.getEmail_id());
			stmt.setString(4,customer.getPhone_number());
			stmt.setString(5,customer.getAddress_one());
			stmt.setString(6,customer.getAddress_two());
			stmt.setString(7,customer.getLand_mark());
			stmt.setInt(8,customer.getZip_code());
			stmt.setString(9,customer.getCity());
			stmt.setString(10,customer.getState());
			stmt.setString(11,customer.getCustomer_creation_date());
			stmt.setString(12,customer.getAssigned_operator());
			stmt.setString(13,customer.getCustomer_creation_date());


			stmt.setString(11,customer.getCustomer_creation_date());
		
			resultset=stmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
	}
	
	public void getAllCustomer() {
		
	}
	public void updateCustomer() {
		
	}
	public void insertRetailer() {
		
	}
	public void getAllRetailer() {
		
	}
	public void updateRetailer() {
		
	}
}
