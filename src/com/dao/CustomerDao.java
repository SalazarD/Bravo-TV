package com.dao;

import com.bean.Customer;
import com.utilities.DbCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDao extends AbstractDao<Customer> {
	
	private static String TABLE_NAME = "CASE_Customer";
	
	@Override
	protected String getTableName() {
		return TABLE_NAME;
	}

	@Override
	protected Customer getNewBean() {
		return new Customer();
	}

	public boolean validateCustomer(String email, String password) {
		boolean exists = false;

		Connection con = DbCon.getConnection();

		try {
			String qry = "select count(*) count from "+TABLE_NAME+" where email_id='"+email+"' and password='"+password+"'";
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
			String qry = "select * from "+TABLE_NAME+" where email_id=?";
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
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return customer;
	}
}