package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.utilities.DbCon;

public class LoginDao {

	public boolean validateUser(String user_name, String password) {
		boolean exists = false;
		Connection con = DbCon.getConnection();

		try {
			String qry = "select count(*) count from Case_Auth"+" where user_name='"+user_name+"' and user_password='"+password+"'";
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
	public String checkType(String user_name, String password) {
		Connection con = DbCon.getConnection();
		try {
			String qry = "select user_type from Case_Auth"+" where user_name='"+user_name+"' and user_password='"+password+"'";
			PreparedStatement st = con.prepareStatement(qry);
			ResultSet rs = st.executeQuery();
		
			if(rs.next()) {
				return rs.getString("user_type");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return null;
	}
	public void viewPremission(HttpSession session,HttpServletRequest request,String menu_view,String add_channel_view,String channel_list_view,
								String add_package_view,String package_purchase_view,String add_stb_view,String stb_purchase_view,
								String register_customer_view, String register_operator_view,String register_operator_list_view,String register_retailer_view) {
		 	session = request.getSession();
			session.setAttribute("menu_view",menu_view );		
			session.setAttribute("add_channel_view",add_channel_view );		
			session.setAttribute("channel_list_view", channel_list_view);	
			session.setAttribute("add_package_view",add_package_view );		
			session.setAttribute("package_purchase_view",package_purchase_view );	
			session.setAttribute("add_stb_view",add_stb_view );		
			session.setAttribute("stb_purchase_view", stb_purchase_view);	
			session.setAttribute("register_customer_view", register_customer_view);		
			session.setAttribute("register_operator_view", register_operator_view);
			session.setAttribute("register_operator_list_view", register_operator_list_view);		
			session.setAttribute("register_retailer_view", register_retailer_view);	
	}
	public boolean checkFirstTimeUser(String user_name, String user_password) {
		boolean exists = false;
		Connection con = DbCon.getConnection();

		try {
			String qry = "select first_time_user from Case_Auth"+" where user_name='"+user_name+"' and user_password='"+user_password+"'";
			PreparedStatement st = con.prepareStatement(qry);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				exists =rs.getBoolean("first_time_user");
				return exists;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return exists;
	}

	public void insertUser(String user_name, String user_password, String user_type, boolean first_time_user) {
		System.out.println("called addperson");
		String sql="insert into Case_Auth (user_name,user_password,user_type,first_time_user) values "
				+ "(?,?,?,?)";
		
		int resultset;
		Connection connect=DbCon.getConnection();	
		try
		{
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
			stmt.setString(1,user_name);
			stmt.setString(2,user_password);
			stmt.setString(3,user_type);
			stmt.setBoolean(4,first_time_user);
			resultset=stmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
	}
	public void deleteUser(String user_name) {
		System.out.println("called addperson");
		String sql="DELETE FROM Case_auth WHERE user_name=?";
		
		int resultset;
		Connection connect=DbCon.getConnection();	
		try
		{
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
			stmt.setString(1,user_name);
			resultset=stmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
	}

}
