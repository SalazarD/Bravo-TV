package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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


}
