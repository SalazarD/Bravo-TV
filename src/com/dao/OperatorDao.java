package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bean.Customer;
import com.bean.Operator;
import com.utilities.DbCon;


public class OperatorDao extends AbstractDao<Operator> {

	@Override
	protected String getTableName() {
		return "CASE_Operator";
	}
	
	@Override
	protected Operator getNewBean() {
		return new Operator();
	}
	
	public Operator findById(int operatorId) {

		Connection con = DbCon.getConnection();
		Operator o = null;
		try
		{
			String qry = "SELECT * FROM "+"case_operator"+ " "+
					"WHERE operator_id = ?";

			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1,operatorId);
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				o = new Operator();
				o.setFirst_name(rs.getString("first_name"));
				o.setLast_name(rs.getString("last_name"));
				o.setEmail(rs.getString("email"));
				o.setPhone(rs.getString("phone"));
				o.setShift_start(rs.getTimestamp("shift_start"));
				o.setMax_customers(rs.getInt("max_customers"));
				o.setOperator_creation_date(rs.getTimestamp("operator_creation_date"));
				o.setOperator_id(operatorId);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
	
	public ArrayList<Operator> findAllO() {
		// TODO Auto-generated method stub
		ArrayList<Operator> operators = new ArrayList<>();

		try
		{
			Connection con = DbCon.getConnection();
			String qry = "SELECT * FROM CASE_Operator";
			PreparedStatement st = con.prepareStatement(qry);

			ResultSet rs = st.executeQuery(qry);

			while(rs.next())
			{
				Operator obj = new Operator();
				obj.setOperator_id(rs.getInt(1));
				obj.setFirst_name(rs.getString(2));
				obj.setLast_name(rs.getString(3));
				obj.setEmail(rs.getString(4));
				obj.setPhone(rs.getString(5));
				obj.setShift_start(rs.getTimestamp(6));
				obj.setMax_customers(rs.getInt(7));
				obj.setOperator_creation_date(rs.getTimestamp(8));

				operators.add(obj);			
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

		return operators;
	}


	
	//2
	public JSONArray totalOperatorCreated_WithinYear() {
		
		JSONArray array = new JSONArray();
		try {
			Connection conn = DbCon.getConnection();
			Statement st = conn.createStatement();
			ResultSet rSet = st.executeQuery("SELECT monthname(operator_creation_date) as month, count(*) FROM CASE_Operator group by month;");
			while (rSet.next()) {
				JSONObject record = new JSONObject();
				record.put("month", rSet.getString("month"));
				record.put("count", rSet.getString("count(*)"));
				array.put(record);
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally {

			DbCon.closeConnection();
		}

		return array;
	}
	
	
	
	//1
	public JSONArray totalOperator_InShift() {
		
		JSONArray array = new JSONArray();
		try {
			Connection conn = DbCon.getConnection();
			Statement st = conn.createStatement();
			ResultSet rSet = st.executeQuery("select date_format(shift_start, '%H:%i:%s') as shift, count(*) as count from CASE_Operator group by shift_start;");
			while (rSet.next()) {
				JSONObject record = new JSONObject();
				record.put("shift", rSet.getString("shift"));
				record.put("count", rSet.getString("count"));
				array.put(record);
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally {

			DbCon.closeConnection();
		}

		return array;
	}
	
	public Boolean checkExistOperatorEmail(String email) {
		Connection con = DbCon.getConnection();
		try {
			String qry = "select * from CASE_Operator where email=?";
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
	public boolean deleteUserWithEmail(String email) {
		String sql="DELETE FROM CASE_Operator\r\n" + 
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
	public Operator getOperator(String email) {
		Operator obj = new Operator();

		Connection con = DbCon.getConnection();

		try {
			String qry = "select * from CASE_Operator where email=?";
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, email);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				obj.setOperator_id(rs.getInt(1));
				obj.setFirst_name(rs.getString(2));
				obj.setLast_name(rs.getString(3));
				obj.setEmail(rs.getString(4));
				obj.setPhone(rs.getString(5));
				obj.setShift_start(rs.getTimestamp(6));
				obj.setMax_customers(rs.getInt(7));
				obj.setOperator_creation_date(rs.getTimestamp(8));
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return obj;
	}

}