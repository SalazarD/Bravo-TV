package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.utilities.DbCon;

public class ChangePasswordDao {
	public void changePassword(String user_name, String newPassword) {
		String sql="update Case_Auth set user_password=? where user_name=?";
		int resultset;
		Connection connect=DbCon.getConnection();	
		try
		{
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
			stmt.setString(1,newPassword);
			stmt.setString(2,user_name);
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
	public void changeFirstTimeUser(String user_name) {
		String sql="update Case_Auth set first_time_user=false where user_name=?";
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
