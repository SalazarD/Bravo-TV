package com.dao;

import com.bean.Customer;
import com.utilities.DbCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO {
	private static String table="CASE_Customer";

	public int insert(Customer obj) {
		int code = 0;

		Connection con = DbCon.getConnection();

		try {
			String qry = "insert into "+table+" (first_name, last_name, email_id, phone_number,"+
							" address_one, oddress_two, land_mark, zip_code, city, state,"+
							" customer_creation_date, assigned_operator, assigned_retailer,"+
							" password, first_time_user) "+
							"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement st = con.prepareStatement(qry);

			st.setString(1, obj.getFirst_name());
			st.setString(2, obj.getLast_name());
			st.setString(3, obj.getEmail());
			st.setString(4, obj.getPhone());
			st.setString(5, obj.getAddress_1());
			st.setString(6, obj.getAddress_2());
			st.setString(7, obj.getLand_mark());
			st.setInt(8, obj.getZip_code());
			st.setString(9, obj.getCity());
			st.setString(10, obj.getState_province());
			st.setTimestamp(11, obj.getCustomer_creation_date());
			st.setInt(12, obj.getAssigned_operator_id());
			st.setInt(13, obj.getAssigned_retailer_id());
			st.setString(14, obj.getPassword());
			st.setBoolean(15, obj.isFirst_time_user());

			code = st.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return code;
	}

	public int update(Customer obj) {
		int code = 0;

		Connection con = DbCon.getConnection();

		try {
			String qry = "update "+table+" set first_name=?, last_name=?, email_id=?, phone_number=?, "
					+ "address_one=?, address_two=?, land_mark=?, zip_code=?, city=?, state=?, customer_creation_date=?, "
					+ "assigned_operator=?, assigned_retailer=?, password=?, first_time_user=?"
					+ " where customer_id=?";

			PreparedStatement st = con.prepareStatement(qry);

			st.setString(1, obj.getFirst_name());
			st.setString(2, obj.getLast_name());
			st.setString(3, obj.getEmail());
			st.setString(4, obj.getPhone());
			st.setString(5, obj.getAddress_1());
			st.setString(6, obj.getAddress_2());
			st.setString(7, obj.getLand_mark());
			st.setInt(8, obj.getZip_code());
			st.setString(9, obj.getCity());
			st.setString(10, obj.getState_province());
			st.setTimestamp(11, obj.getCustomer_creation_date());
			st.setInt(12, obj.getAssigned_operator_id());
			st.setInt(13, obj.getAssigned_retailer_id());
			st.setString(14, obj.getPassword());
			st.setBoolean(15, obj.isFirst_time_user());
			st.setInt(16, obj.getCustomer_id());

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

	public Customer getCustomer(String email) {
		Customer customer = new Customer();

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
				customer.setEmail(rs.getString(4));
				customer.setPhone(rs.getString(5));
				customer.setAddress_1(rs.getString(6));
				customer.setAddress_2(rs.getString(7));
				customer.setLand_mark(rs.getString(8));
				customer.setZip_code(rs.getInt(9));
				customer.setCity(rs.getString(10));
				customer.setState_province(rs.getString(11));
				customer.setCustomer_creation_date(rs.getTimestamp(12));
				customer.setAssigned_operator_id(rs.getInt(13));
				customer.setAssigned_retailer_id(rs.getInt(14));
				customer.setPassword(rs.getString(15));
				customer.setFirst_time_user(rs.getBoolean(16));
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return customer;
	}

	public Customer getCustomerById(int id) {
		Customer customer = new Customer();

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
				customer.setEmail(rs.getString(4));
				customer.setPhone(rs.getString(5));
				customer.setAddress_1(rs.getString(6));
				customer.setAddress_2(rs.getString(7));
				customer.setLand_mark(rs.getString(8));
				customer.setZip_code(rs.getInt(9));
				customer.setCity(rs.getString(10));
				customer.setState_province(rs.getString(11));
				customer.setCustomer_creation_date(rs.getTimestamp(12));
				customer.setAssigned_operator_id(rs.getInt(13));
				customer.setAssigned_retailer_id(rs.getInt(14));
				customer.setPassword(rs.getString(15));
				customer.setFirst_time_user(rs.getBoolean(16));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return customer;
	}
}
