package com.dao;

import com.bean.Customer;
import com.utilities.DbCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	public boolean deleteUserWithEmail(String email) {
		String sql="DELETE FROM case_customer\r\n" + 
				"WHERE email = ?";
		int resultset;
		Connection connect=DbCon.getConnection();	
		try
		{
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
			stmt.setString(1,email);
			resultset=stmt.executeUpdate();
			System.out.println("deleted");
			return true;
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
		return false;
		
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


	public Customer findById(int customerId) {

		Connection con = DbCon.getConnection();
		Customer c = null;
		try
		{
			String qry = "SELECT * FROM "+"case_customer"+ " "+
					"WHERE customer_id = ?";

			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1,customerId);
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				c = new Customer();
				c.setFirst_name(rs.getString("first_name"));
				c.setLast_name(rs.getString("last_name"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setAddress_1(rs.getString("address_1"));
				c.setAddress_2(rs.getString("address_2"));
				c.setLand_mark(rs.getString("land_mark"));
				c.setZip_code(rs.getInt("zip_code"));
				c.setCity(rs.getString("city"));
				c.setState_province(rs.getString("state_province"));
				c.setCustomer_creation_date(rs.getTimestamp("customer_creation_date"));
				c.setPre_paid(rs.getBoolean("pre_paid"));
				c.setBalance(rs.getBigDecimal("balance"));
				c.setAssigned_operator_id(rs.getInt("assigned_operator_id"));
				c.setAssigned_retailer_id(rs.getInt("assigned_retailer_id"));
				c.setCustomer_id(customerId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}


	public Customer getCustomer(String email) {
		Customer obj = new Customer();

		Connection con = DbCon.getConnection();

		try {
			String qry = "select * from "+TABLE_NAME+" where email=?";
			PreparedStatement st = con.prepareStatement(qry);

			st.setString(1, email);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				obj.setCustomer_id(rs.getInt(1));
				obj.setFirst_name(rs.getString(2));
				obj.setLast_name(rs.getString(3));
				obj.setEmail(rs.getString(4));
				obj.setPhone(rs.getString(5));
				obj.setAddress_1(rs.getString(6));
				obj.setAddress_2(rs.getString(7));
				obj.setLand_mark(rs.getString(8));
				obj.setZip_code(rs.getInt(9));
				obj.setCity(rs.getString(10));
				obj.setState_province(rs.getString(11));
				obj.setCustomer_creation_date(rs.getTimestamp(12));
				obj.setPre_paid(rs.getBoolean(13));
				obj.setBalance(rs.getBigDecimal(14));
				obj.setAssigned_operator_id(rs.getInt(15));
				obj.setAssigned_retailer_id(rs.getInt(16));
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return obj;
	}
	public Boolean checkExistCustomerEmail(String email) {
		Connection con = DbCon.getConnection();
		try {
			String qry = "select * from "+TABLE_NAME+" where email=?";
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return false;
	}


	public ArrayList<Customer> findAllC() {
		// TODO Auto-generated method stub
		ArrayList<Customer> customers = new ArrayList<>();

		try
		{
			Connection con = DbCon.getConnection();
			String qry = "SELECT * FROM CASE_Customer";
			PreparedStatement st = con.prepareStatement(qry);

			ResultSet rs = st.executeQuery(qry);

			while(rs.next())
			{
				Customer obj = new Customer();
				obj.setCustomer_id(rs.getInt(1));
				obj.setFirst_name(rs.getString(2));
				obj.setLast_name(rs.getString(3));
				obj.setEmail(rs.getString(4));
				obj.setPhone(rs.getString(5));
				obj.setAddress_1(rs.getString(6));
				obj.setAddress_2(rs.getString(7));
				obj.setLand_mark(rs.getString(8));
				obj.setZip_code(rs.getInt(9));
				obj.setCity(rs.getString(10));
				obj.setState_province(rs.getString(11));
				obj.setCustomer_creation_date(rs.getTimestamp(12));
				obj.setPre_paid(rs.getBoolean(13));
				obj.setBalance(rs.getBigDecimal(14));
				obj.setAssigned_operator_id(rs.getInt(15));
				obj.setAssigned_retailer_id(rs.getInt(16));

				customers.add(obj);			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbCon.closeConnection();
		}

		return customers;
	}

}