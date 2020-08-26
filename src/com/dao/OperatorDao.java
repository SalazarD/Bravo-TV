package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Customer;
import com.bean.Operator;
import com.utilities.DbCon;

public class OperatorDao extends AbstractDao<Operator> {
	@Override
	protected String getTableName() {
		return "Case_Operator";
	}

	@Override
	protected Operator getNewBean() {
		return new Operator();
	}
	
	public ArrayList<Customer> getAllCustomerWithGivenOperator(int operatorID) {
		System.out.print("test");
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			
			Connection con = DbCon.getConnection();
			// Query for all beans
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Case_Customer where assigned_operator_id=?");
			ps.setInt(1, operatorID);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metadata = rs.getMetaData();
			
			// Save results
			while(rs.next()) {
				Customer customer = new Customer();
				String columnNames[] = customer.getColumnNames();
				Object[] columnValues = new Object[columnNames.length];
				
				for (int i = 0; i < columnValues.length; i++) {
					columnValues[i] = AbstractDao.getValueByName(rs, metadata, columnNames[i]);
				}
				customer.setColumnValues(columnValues);
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return list;
	} 

}
