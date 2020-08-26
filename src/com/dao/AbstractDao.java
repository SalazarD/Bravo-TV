package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Bean;
import com.utilities.DbCon;

/**
 * An abstract class the implements the CRUD interface. CRUD operations can be
 * overwritten if needed. Extra operations should be implemented on a Dao-by-Dao basis.
 * 
 * Java types should map to the following MySQL types:
 * 
 * null                 <=> NULL
 * Integer              <=> INT
 * Boolean              <=> BOOLEAN
 * String               <=> VARCHAR
 * java.math.BigDecimal <=> DECIMAL
 * java.sql.Date        <=> DATE
 * java.sql.Time        <=> TIME
 * java.sql.Timestamp   <=> DATETIME
 * 
 * @param <T> The bean type that corresponds to the table on which this Dao
 *            operates.
 */
public abstract class AbstractDao<T extends Bean> {

	/**
	 * Inserts the Bean's data into its table, and updates the Bean with
	 * its new id.
	 * 
	 * @param bean The Bean to insert into its table.
	 * @return true if inserted successfully; false otherwise
	 */
	public boolean create(T bean) {
		boolean successful = false;
		try {

			// Get connection
			Connection con = DbCon.getConnection();

			// Get Bean values... this should have at least one element
			String[] columnNames = bean.getColumnNames();
			Object[] columnValues = bean.getColumnValues();
			if (columnNames.length != columnValues.length) {
				throw new SQLException("Name and value arrays are not the same length.");
			}

			// INSERT INTO <table> (key1, key2, ..., keyN) VALUES (?, ?, ..., ?)
			String sql = "INSERT INTO "+this.getTableName()+" "+AbstractDao.makeKeyList(columnNames)+" VALUES "+AbstractDao.makeEmptyArgumentList(columnNames.length);

			// Prepare INSERT statement
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			columnValues[0] = null;
			AbstractDao.prepareStatement(ps, columnValues);

			// Execute and get the new unique id
			successful = (ps.executeUpdate() == 1);
			ResultSet keySet = ps.getGeneratedKeys();
			if (keySet.next()) {
				columnValues[0] = keySet.getInt(1);
				bean.setColumnValues(columnValues);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return successful;
	}
	

	/**
	 * Reads the Bean's data from its table, matching the unique id
	 * 
	 * @param bean     The Bean that will store the data, with the correct id set
	 * @param uniqueId The unique id of the desired bean
	 * @return true if read successfully; false otherwise
	 */
	public boolean read(T bean) {
		boolean successful = false;
		try {

			// Get connection
			Connection con = DbCon.getConnection();

			// Get Bean values... this should have at least one element
			String[] columnNames = bean.getColumnNames();
			Object[] columnValues = bean.getColumnValues();
			if (columnNames.length != columnValues.length) {
				throw new SQLException("Name and value arrays are not the same length.");
			}

			// SELECT * FROM WHERE <uniqueId>=?
			String sql = "SELECT * FROM "+this.getTableName()+" WHERE "+columnNames[0]+"=?";

			// Prepare SELECT statement
			PreparedStatement ps = con.prepareStatement(sql);
			AbstractDao.prepareValue(ps, columnValues[0], 1);

			// Get results
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metadata = rs.getMetaData();
			if (successful = rs.next()) {
				for (int i = 0; i < columnValues.length; i++) {
					columnValues[i] = AbstractDao.getValueByName(rs, metadata, columnNames[i]);
				}

				bean.setColumnValues(columnValues);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return successful;
	}

	/**
	 * Updates the Bean's data into its table, matching the unique id
	 * 
	 * @param bean The bean whose data will be updated, with the correct id set
	 * @return true if updated successfully; false otherwise
	 */
	public boolean update(T bean) {
		boolean successful = false;
		try {

			// Get connection
			Connection con = DbCon.getConnection();

			// Get Bean values... this should have at least one element
			String[] columnNames = bean.getColumnNames();
			Object[] columnValues = bean.getColumnValues();
			if (columnNames.length != columnValues.length) {
				throw new SQLException("Name and value arrays are not the same length.");
			}

			// UPDATE <table> SET key1=?, ..., keyN=? WHERE <uniqueId>=?
			String sql = "UPDATE "+this.getTableName()+" SET "+AbstractDao.makeArgumentList(columnNames)+" WHERE "+columnNames[0]+"=?";

			// Prepare UPDATE statement
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			AbstractDao.prepareStatement(ps, columnValues);
			AbstractDao.prepareValue(ps, columnValues[0], columnNames.length + 1);

			// Execute and get the result
			successful = (ps.executeUpdate() == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return successful;
	}

	/**
	 * Deletes a Bean's data from its table, matching the unique id
	 * 
	 * @param bean The bean whose data will be deleted, with the correct id set
	 * @return true if deleted successfully; false, otherwise
	 */
	public boolean delete(T bean) {
		boolean successful = false;
		try {

			// Get connection
			Connection con = DbCon.getConnection();

			// Get Bean values... this should have at least one element
			String[] columnNames = bean.getColumnNames();
			Object[] columnValues = bean.getColumnValues();
			if (columnNames.length != columnValues.length) {
				throw new SQLException("Name and value arrays are not the same length.");
			}

			// DELETE FROM <table> WHERE <uniqueId>=?
			String sql = "DELETE FROM "+this.getTableName()+" WHERE "+columnNames[0]+"=?";

			// Prepare DELETE statement
			PreparedStatement ps = con.prepareStatement(sql);
			AbstractDao.prepareValue(ps, columnValues[0], 1);

			// Execute and get the result
			successful = (ps.executeUpdate() == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return successful;
	}
	
	/**
	 * Retrieves all Beans in the table.
	 * 
	 * @return A list of all beans in the table.
	 */
	public List<T> getAll() {
		ArrayList<T> list = new ArrayList<>();
		try {
			
			// Get connection
			Connection con = DbCon.getConnection();
			
			// Query for all beans
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+getTableName());
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metadata = rs.getMetaData();
			
			// Save results
			while(rs.next()) {
				T bean = this.getNewBean();
				String columnNames[] = bean.getColumnNames();
				Object[] columnValues = new Object[columnNames.length];
				
				for (int i = 0; i < columnValues.length; i++) {
					columnValues[i] = AbstractDao.getValueByName(rs, metadata, columnNames[i]);
				}

				bean.setColumnValues(columnValues);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return list;
	}

	/**
	 * Retrieves the table name on which the Dao operates
	 * 
	 * @return The table name on which the Dao operates.
	 */
	protected abstract String getTableName();
	
	/**
	 * Creates a new instance of the Bean class.
	 * 
	 * @return The new Bean instance.
	 */
	protected abstract T getNewBean();

	/**
	 * Generates an argument list of the form (?,?,...,?)
	 * 
	 * @param numArgs The number of arguments to generate
	 * @return The argument string
	 */
	protected static final String makeEmptyArgumentList(int numArgs) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		
		for (int i = 0; i < numArgs - 1; i++) {
			sb.append("?,");
		}
		sb.append("?)");

		return sb.toString();
	}

	/**
	 * Generates a key list of the form (key1,key2,...,keyN)
	 * 
	 * @param numArgs The number of arguments to generate
	 * @return The argument string
	 */
	protected static final String makeKeyList(String[] keys) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		
		for (int i = 0; i < keys.length - 1; i++) {
			sb.append(keys[i]+",");
		}
		sb.append(keys[keys.length - 1]+")");

		return sb.toString();
	}

	/**
	 * Generates an argument list of the form
	 * 
	 * key1=?, key2=?, ..., keyN=?
	 * 
	 * where N is the number of key names
	 * 
	 * @param keyNames The names of each key in order of use
	 * @return The argument string
	 */
	protected static final String makeArgumentList(String[] keyNames) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < keyNames.length - 1; i++) {
			sb.append(String.format("%s=?, ", keyNames[i]));
		}
		sb.append(String.format("%s=?", keyNames[keyNames.length - 1]));

		return sb.toString();
	}

	/**
	 * Prepares the values into the Prepared Statement
	 * 
	 * @param ps     The PreparedStatement to prepare
	 * @param values The values with which to prepare the PreparedStatement
	 * @throws SQLException If a value could not be prepared.
	 */
	protected static final void prepareStatement(PreparedStatement ps, Object[] values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			AbstractDao.prepareValue(ps, values[i], i + 1);
		}
	}

	/**
	 * Prepares the given value into the PreparedStatement at the given column
	 * 
	 * @param ps         The PreparedStatement to prepare
	 * @param value      A value
	 * @param paramIndex The index into which the value will be prepared, starting
	 *                   at 1
	 * @throws SQLException If the value could not be prepared
	 */
	protected static final void prepareValue(PreparedStatement ps, Object value, int paramIndex) throws SQLException {
		if (value == null) {
			ps.setNull(paramIndex, java.sql.Types.NULL);
		}
		
		else if (value instanceof Integer) {
			ps.setInt(paramIndex, (Integer) value);
		}
		
		else if (value instanceof Boolean) {
			ps.setBoolean(paramIndex, (Boolean) value);
		}
		
		else if (value instanceof String) {
			ps.setString(paramIndex, (String) value);
		}
		
		else if (value instanceof java.math.BigDecimal) {
			ps.setBigDecimal(paramIndex, (java.math.BigDecimal) value);
		}
		
		else if (value instanceof java.sql.Date) {
			ps.setDate(paramIndex, (java.sql.Date) value);
		}
		
		else if (value instanceof java.sql.Time) {
			ps.setTime(paramIndex, (java.sql.Time) value);
		}
		
		else if (value instanceof java.sql.Timestamp) {
			ps.setTimestamp(paramIndex, (java.sql.Timestamp) value);
		}
		
		else {
			throw new SQLException("Unsupported Java type: " + value.getClass().getName());
		}
	}

	/**
	 * Gets an Object with the appropriate Java type from the Result Set at the
	 * given column
	 * 
	 * @param rs         The ResultSet
	 * @param metadata   The ResultSet's metadata
	 * @param columnName The name of the column from which to get a value
	 * @return A Java Object, or null if the target value is null
	 * @throws SQLException If a value could not be read from the result set
	 */
	protected static final Object getValueByName(ResultSet rs, ResultSetMetaData metadata, String columnName) throws SQLException {
		for (int col = 1; col <= metadata.getColumnCount(); col++) {
			if (metadata.getColumnName(col).equals(columnName)) {
				return getValueByIndex(rs, metadata, col);
			}
		}
		throw new SQLException("No column exists with the name " + columnName);
	}

	/**
	 * Gets an Object with the appropriate Java type from the Result Set at the
	 * given column
	 * 
	 * @param rs          The ResultSet
	 * @param metadata    The ResultSet's metadata
	 * @param columnIndex The index of the column from which to get a value,
	 *                    starting from 1
	 * @return A Java Object, or null if the target value is null
	 * @throws SQLException If a value could not be read from the result set
	 */
	protected static final Object getValueByIndex(ResultSet rs, ResultSetMetaData metadata, int columnIndex) throws SQLException {
		int typeCode = metadata.getColumnType(columnIndex);
		switch (typeCode) {
			case java.sql.Types.INTEGER:
				return rs.getInt(columnIndex);
			case java.sql.Types.BOOLEAN:
			case java.sql.Types.BIT:
				return rs.getBoolean(columnIndex);
			case java.sql.Types.VARCHAR:
				return rs.getString(columnIndex);
			case java.sql.Types.DECIMAL:
				return rs.getBigDecimal(columnIndex);
			case java.sql.Types.DATE:
				return rs.getDate(columnIndex);
			case java.sql.Types.TIME:
				return rs.getTime(columnIndex);
			case java.sql.Types.TIMESTAMP:
				return rs.getTimestamp(columnIndex);
			default:
				throw new SQLException("Unsupported SQL type (code " + typeCode + ")");
		}
	}
}
