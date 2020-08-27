package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.bean.Bean;
import com.utilities.DbCon;

/**
 * An abstract class the implements the CRUD interface. CRUD operations can be
 * overwritten if needed. Extra operations should be implemented on a Dao-by-Dao basis.
 * 
 * Java types should map to the following MySQL types:
 * 
 * null                 <=> NULL
 * Integer              <=> INT, BIGINT
 * Boolean              <=> BOOLEAN, BIT
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
	 * its new unique identifier
	 * 
	 * It is advised to set the Bean's unique identifier to a known value
	 * before this operation and verify that it has changed afterwards.
	 * 
	 * @param bean The Bean to insert into its table.
	 * @return true if inserted successfully; false otherwise
	 */
	public boolean create(T bean) {
		boolean successful = false;
		try {

			// Get connection
			Connection con = DbCon.getConnection();

			// Get Bean properties... this should have at least one element
			Map<String, Object> properties = bean.getProperties();
			if (!(properties.size() > 0)) {
				throw new SQLException("Property map is not at least size 1.");
			}
			properties.put(bean.getUniqueIDName(), null);

			// INSERT INTO <table> (<key1>, <key2>, ..., <keyN>) VALUES (?, ?, ..., ?)
			PreparedStatement ps = AbstractDao.prepareInsertStatement(con, this.getTableName(), properties);

			// Execute and get the new unique id
			successful = (ps.executeUpdate() == 1);
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				properties.put(bean.getUniqueIDName(), AbstractDao.getValueByIndex(rs, rs.getMetaData(), 1));
				bean.setProperties(properties);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return successful;
	}
	
	/**
	 * Reads the Bean's data from its table by matching the Bean's
	 * unique identifier to a record. The Bean's unique identifier should
	 * be set before this operation.
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

			// Get Bean properties... this should have at least one element
			Map<String, Object> properties = bean.getProperties();

			// SELECT * FROM <table> WHERE <uniqueId>=?
			String sql = "SELECT * FROM "+this.getTableName()+" WHERE "+bean.getUniqueIDName()+"=?";

			// Prepare SELECT statement
			PreparedStatement ps = con.prepareStatement(sql);
			AbstractDao.prepareValue(ps, properties.get(bean.getUniqueIDName()), 1);

			// Get results
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metadata = rs.getMetaData();
			if (successful = rs.next()) {
				properties = AbstractDao.getProperties(rs, metadata);
				bean.setProperties(properties);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return successful;
	}

	/**
	 * Updates the Bean's data to its table by matching the Bean's
	 * unique identifier to a record. The Bean's unique identifier should
	 * be set before this operation.
	 * 
	 * @param bean The bean whose data will be updated, with the correct id set
	 * @return true if updated successfully; false otherwise
	 */
	public boolean update(T bean) {
		boolean successful = false;
		try {

			// Get connection
			Connection con = DbCon.getConnection();

			// Get Bean properties... this should have at least one element
			Map<String, Object> properties = bean.getProperties();

			// UPDATE <table> SET <key1>=?, <key2>=?, ..., <keyN>=? WHERE <uniqueId>=?
			PreparedStatement ps = AbstractDao.prepareUpdateStatement(con, this.getTableName(), properties, bean.getUniqueIDName());
			
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
	 * Deletes the Bean's record from its table. The Bean's unique identifier should
	 * be set before this operation.
	 * 
	 * @param bean The bean whose data will be deleted, with the correct id set
	 * @return true if deleted successfully; false, otherwise
	 */
	public boolean delete(T bean) {
		boolean successful = false;
		try {

			// Get connection
			Connection con = DbCon.getConnection();

			// Get Bean properties... this should have at least one element
			Map<String, Object> properties = bean.getProperties();

			// DELETE FROM <table> WHERE <uniqueId>=?
			String sql = "DELETE FROM "+this.getTableName()+" WHERE "+bean.getUniqueIDName()+"=?";

			// Prepare DELETE statement
			PreparedStatement ps = con.prepareStatement(sql);
			AbstractDao.prepareValue(ps, properties.get(bean.getUniqueIDName()), 1);

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
	 * Finds the Bean associated with the given unique identifier.
	 * @param uniqueId The unique identifier for the bean
	 * @return A Bean, or null if no Bean could be found.
	 */
	public T get(Object uniqueId) {
		T bean = this.getNewBean();
		Map<String, Object> properties = bean.getProperties();
		if(properties.get(bean.getUniqueIDName()).getClass() != uniqueId.getClass()) {
			throw new IllegalArgumentException("The given Unique ID is not the same type as in property map.");
		}
		properties.put(bean.getUniqueIDName(), uniqueId);
		if (read(bean)) {
			return bean;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Retrieves all Beans in the table.
	 * 
	 * @return A list of all beans in the table.
	 */
	public ArrayList<T> getAll() {
		ArrayList<T> list = new ArrayList<>();
		try {
			
			// Get connection
			Connection con = DbCon.getConnection();
			
			// SELECT * FROM <table>
			PreparedStatement ps = con.prepareStatement("SELECT * FROM "+getTableName());
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metadata = rs.getMetaData();
			
			// Save results
			while(rs.next()) {
				HashMap<String, Object> properties = AbstractDao.getProperties(rs, metadata);
				T bean = this.getNewBean();
				bean.setProperties(properties);
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
	 * Retrieves the table name on which the Dao operates.
	 * It is advised to return a String literal.
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

	
	
	/* Methods for internal use */
	
	/**
	 * Generates a PreparedStatement to execute an Insert operation
	 * @param con The Connection for the PreparedStatement
	 * @param tableName The name of the table in which to insert
	 * @param properties The set of properties to insert into the table
	 * @return A PreparedStatement that can return the last generated key
	 * @throws SQLException If the statement could not be made
	 */
	protected static PreparedStatement prepareInsertStatement(Connection con, String tableName, Map<String, Object> properties) throws SQLException {
		
		// Keep track of the values in the order we see them
		Object[] valuesInOrder = new Object[properties.size()];
		
		// Build the SQL command: INSERT INTO <table> (<key1>, <key2>, ..., <keyN>) VALUES (?, ?, ..., ?)
		StringBuilder columns = new StringBuilder();
		StringBuilder values = new StringBuilder();
		
		int index = 0;
		for (Entry<String, Object> prop : properties.entrySet()) {
			valuesInOrder[index] = prop.getValue();
			columns.append(prop.getKey());
			values.append('?');
			if (index < properties.size() - 1) {
				columns.append(',');
				values.append(',');
			}
			index++;
		}
		
		// Create the statement
		String sql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columns.toString(), values.toString());
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		// prepare all the values into the insert statement
		for (int i = 0; i < valuesInOrder.length; i++) {
			AbstractDao.prepareValue(ps, valuesInOrder[i], i + 1);
		}
		
		return ps;
	}

	/**
	 * Generates a PreparedStatement to execute an Update operation
	 * @param con The Connection for the PreparedStatement
	 * @param tableName The name of the table in which to update
	 * @param properties The set of properties to update into the table
	 * @param uniqueIDName The name of the unique identifier that identifies the row to update
	 * @return A PreparedStatement
	 * @throws SQLException If the statement could not be made
	 */
	protected static PreparedStatement prepareUpdateStatement(Connection con, String tableName, Map<String, Object> properties, String uniqueIDName) throws SQLException {

		// Keep track of the values in the order we see them
		Object[] valuesInOrder = new Object[properties.size() + 1];
		
		// Build the command: UPDATE <table> SET <key1>=?, <key2>=?, ..., <keyN>=? WHERE <uniqueId>=?
		StringBuilder args = new StringBuilder();
		
		int index = 0;
		for (Entry<String, Object> prop : properties.entrySet()) {
			valuesInOrder[index] = prop.getValue();
			args.append(prop.getKey());
			args.append("=?");
			if (index < properties.size() - 1) {
				args.append(',');
			}
			index++;
		}
		valuesInOrder[valuesInOrder.length - 1] = properties.get(uniqueIDName);
		
		// Create the statement
		String sql = String.format("UPDATE %s SET %s WHERE %s=?", tableName, args.toString(), uniqueIDName);
		PreparedStatement ps = con.prepareStatement(sql);
		
		// prepare all the values into the insert statement
		for (int i = 0; i < valuesInOrder.length; i++) {
			AbstractDao.prepareValue(ps, valuesInOrder[i], i + 1);
		}
		
		return ps;
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
			throw new SQLException("Unsupported Java type " + value.getClass().getName());
		}
	}

	/**
	 * Gets an Object with the appropriate Java type from the ResultSet at the
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
	 * Gets an Object with the appropriate Java type from the ResultSet at the
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
			case java.sql.Types.BIGINT:
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
	
	/**
	 * Retrieves the properties in the current record of the ResultSet
	 * @param rs The ResultSet
	 * @param metadata The ResultSet's metadata
	 * @return A map of all column names to their values in the current row
	 * @throws SQLException If data could not be read
	 */
	protected static HashMap<String, Object> getProperties(ResultSet rs, ResultSetMetaData metadata) throws SQLException {
		HashMap<String, Object> properties = new HashMap<>();
		for (int col = 1; col <= metadata.getColumnCount(); col ++) {
			properties.put(metadata.getColumnName(col), AbstractDao.getValueByIndex(rs, metadata, col));
		}
		return properties;
	}
}
