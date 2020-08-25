package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.bean.Case_Customer;
import com.bean.Case_Retailer;
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
			stmt.setString(13,customer.getAssigned_retailer());
			stmt.setString(14,customer.getPassword());
			stmt.setBoolean(15,customer.getFirst_time_user());
			resultset=stmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
	}
	
	public ArrayList<Case_Customer> getAllCustomer() {
		
		ArrayList<Case_Customer> result=new ArrayList<Case_Customer>();
		String sql="select * from Case_Customer";
		Connection connect=DbCon.getConnection();
				ResultSet resultset=null;
				try
				{
					PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
					resultset=stmt.executeQuery();
					while(resultset.next()) {
						Case_Customer customer=new Case_Customer();
						customer.setCustomer_id(resultset.getInt("customer_id"));
						customer.setFirst_name(resultset.getNString("first_name"));
						customer.setLast_name(resultset.getNString("last_name"));
						customer.setEmail_id(resultset.getNString("email_id"));
						customer.setPhone_number(resultset.getNString("phone_number"));
						customer.setAddress_one(resultset.getNString("address_one"));
						customer.setAddress_two(resultset.getNString("address_two"));
						customer.setLand_mark(resultset.getNString("land_mark"));
						customer.setZip_code(resultset.getInt("zip_code"));
						customer.setCity(resultset.getNString("city"));
						customer.setState(resultset.getNString("state"));
						String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(resultset.getTimestamp("customer_creation_date"));
		                customer.setCustomer_creation_date(formattedDate);
						customer.setAssigned_operator(resultset.getNString("assigned_operator"));
						customer.setAssigned_retailer(resultset.getNString("assigned_retailer"));
						customer.setPassword(resultset.getNString("password"));
						customer.setFirst_time_user(resultset.getBoolean("first_time_user"));
						result.add(customer);
					}
				}catch(Exception e){
					System.out.println(e);
				}
				finally
				{
					DbCon.closeConnection();
				}
				return result;
		
	}
	public void updateCustomer(Case_Customer customer) {

		System.out.println("called update");
		String sql="update Case_Customer set first_name=?, last_name=?, email_id=?, phone_number=?, address_one=?,"
				+ " address_two=?, land_mark=?, zip_code=?, city=?, state=?, customer_creation_date=?,"
				+ " assigned_operator=?, assigned_retailer=?, password=?, first_time_user=? where customer_id=?";
		System.out.print(customer.toString()+"update");
		int resultset;
		Connection connect=DbCon.getConnection();	
		try
		{
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
			stmt.setString(13,customer.getAssigned_retailer());
			stmt.setString(14,customer.getPassword());
			stmt.setBoolean(15,customer.getFirst_time_user());
			stmt.setInt(16,customer.getCustomer_id());
			resultset=stmt.executeUpdate();
			System.out.println("updated");
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
	}
	
	
	public void insertRetailer(Case_Retailer retailer) {
		System.out.println("called addperson");
		String sql="insert into Case_Retailer (retailer_name, contact_num1, contact_num2,"
				+ " address_1, address_2, zip_code, city, state_province,"
				+ " set_top_box_limit, credit_limit, commission_rate, service_charges,"
				+ " inventory_list, retailer_creation_date, total_cost_of_inventory,oncreate_retailer,"
				+ "total_retailer_in_city,password,first_time_user) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int resultset;
		Connection connect=DbCon.getConnection();	
		try {
			System.out.println("called try-catch");
			System.out.println(retailer.toString()+"in try catch");
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 			
			stmt.setString(1,retailer.getRetailer_name());
			stmt.setString(2,retailer.getContact_num1());
			stmt.setString(3,retailer.getContact_num2());
			stmt.setString(4,retailer.getAddress_1());
			stmt.setString(5,retailer.getAddress_2());
			stmt.setString(6,retailer.getZip_code());
			stmt.setString(7,retailer.getCity());
			stmt.setString(8,retailer.getState_province());
			stmt.setString(9,retailer.getSet_top_box_limit());
			stmt.setBigDecimal(10,retailer.getCredit_limit());
			stmt.setBigDecimal(11,retailer.getCommission_rate());
			stmt.setBigDecimal(12,retailer.getService_charges());
			stmt.setString(13,retailer.getInventory_list());
			stmt.setString(14,retailer.getRetailer_creation_date());
			stmt.setBigDecimal(15,retailer.getTotal_cost_of_inventory());
			stmt.setString(16,retailer.getOncreate_retailer());
			stmt.setString(17,retailer.getTotal_reatiler_in_city());
			stmt.setString(18,retailer.getPassword());
			stmt.setBoolean(19,retailer.getFirst_time_user());
			resultset=stmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
		
	}
	public  ArrayList<Case_Retailer> getAllRetailer() {
		ArrayList<Case_Retailer> result=new ArrayList<Case_Retailer>();
		String sql="select * from Case_Retailer";
		Connection connect=DbCon.getConnection();
				ResultSet resultset=null;
				try
				{
					PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
					resultset=stmt.executeQuery();
					while(resultset.next()) {
						Case_Retailer retailer=new Case_Retailer();
						retailer.setRetailer_id(resultset.getInt("retailer_id"));
						retailer.setRetailer_name(resultset.getNString("retailer_name"));
						retailer.setContact_num1(resultset.getNString("contact_num1"));
						retailer.setContact_num2(resultset.getNString("contact_num2"));
						retailer.setAddress_1(resultset.getNString("address_1"));
						retailer.setAddress_2(resultset.getNString("address_2"));
						retailer.setZip_code(resultset.getNString("zip_code"));
						retailer.setCity(resultset.getNString("city"));
						retailer.setState_province(resultset.getNString("state_province"));
						retailer.setSet_top_box_limit(resultset.getNString("set_top_box_limit"));
						retailer.setCredit_limit(resultset.getBigDecimal("credit_limit"));
						retailer.setCommission_rate(resultset.getBigDecimal("commission_rate"));
						retailer.setService_charges(resultset.getBigDecimal("service_charges"));
						retailer.setInventory_list(resultset.getNString("inventory_list"));
						String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(resultset.getTimestamp("retailer_creation_date"));
						retailer.setRetailer_creation_date(formattedDate);
						retailer.setTotal_cost_of_inventory(resultset.getBigDecimal("total_cost_of_inventory"));
						retailer.setOncreate_retailer(resultset.getNString("oncreate_retailer"));
						retailer.setTotal_reatiler_in_city(resultset.getNString("total_retailer_in_city"));
						retailer.setPassword(resultset.getNString("password"));
						retailer.setFirst_time_user(resultset.getBoolean("first_time_user"));
						result.add(retailer);
					}
				}catch(Exception e){
					System.out.println(e);
				}
				finally
				{
					DbCon.closeConnection();
				}
				return result;
		
	}
	public void updateRetailer(Case_Retailer retailer) {
		System.out.println("called update");
		String sql="update Case_Retailer set retailer_name=?, contact_num1=?, contact_num2=?, "
				+ "address_1=?, address_2=?, zip_code=?, city=?, state_province=?, set_top_box_limit=?, credit_limit=?,"
				+ " commission_rate=?, service_charges=?, inventory_list=?, retailer_creation_date=?, total_cost_of_inventory=?, "
				+ "oncreate_retailer=?, total_retailer_in_city=?, password=?, first_time_user=? where retailer_id=?";
		System.out.print(retailer.toString()+"update");
		int resultset;
		Connection connect=DbCon.getConnection();	
		try
		{
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
			
			stmt.setString(1,retailer.getRetailer_name());
			stmt.setString(2,retailer.getContact_num1());
			stmt.setString(3,retailer.getContact_num2());
			stmt.setString(4,retailer.getAddress_1());
			stmt.setString(5,retailer.getAddress_2());
			stmt.setString(6,retailer.getZip_code());
			stmt.setString(7,retailer.getCity());
			stmt.setString(8,retailer.getState_province());
			stmt.setString(9,retailer.getSet_top_box_limit());
			stmt.setBigDecimal(10,retailer.getCredit_limit());
			stmt.setBigDecimal(11,retailer.getCommission_rate());
			stmt.setBigDecimal(12,retailer.getService_charges());
			stmt.setString(13,retailer.getInventory_list());
			stmt.setString(14,retailer.getRetailer_creation_date());
			stmt.setBigDecimal(15,retailer.getTotal_cost_of_inventory());
			stmt.setString(16,retailer.getOncreate_retailer());
			stmt.setString(17,retailer.getTotal_reatiler_in_city());
			stmt.setString(18,retailer.getPassword());
			stmt.setBoolean(19,retailer.getFirst_time_user());
			stmt.setInt(20, retailer.getRetailer_id());
			resultset=stmt.executeUpdate();
			System.out.println("updated");
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
	}
	public void deleteRetailer(Case_Retailer retailer) {

		System.out.println("called update");
		String sql="DELETE FROM Case_Retailer where retailer_id=?";
		System.out.print(retailer.toString()+"update");
		int resultset;
		Connection connect=DbCon.getConnection();	
		try
		{
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
			stmt.setInt(1,retailer.getRetailer_id());
			resultset=stmt.executeUpdate();
			System.out.println("deleted");
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
	}
	public void deleteCustomer(Case_Customer customer) {

		System.out.println("called update");
		String sql="DELETE FROM Case_Customer where retailer_id=?";
		int resultset;
		Connection connect=DbCon.getConnection();	
		try
		{
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
			stmt.setInt(1,customer.getCustomer_id());
			resultset=stmt.executeUpdate();
			System.out.println("deleted");
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
	}
}
