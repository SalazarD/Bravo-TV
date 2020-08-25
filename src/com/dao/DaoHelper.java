package com.dao;

import com.annotations.*;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Christopher Madrigal
 * 
 * The DaoHelper is meant to aide in the production of DAO objects.
 */
public class DaoHelper {

	/**
	 *<pre>public static final T getTupleAsBean({@link ResultSet} rs, {@link Class}{@literal <T>} clazz)
	 *    throws {@link SQLException}</pre>
	 * <div class="block">
	 * Retrieves an object from the current tuple in a ResultSet.
	 * A call to ResultSet.next() should precede this method call.<br/>
	 * A tuple produced by the following query matches the fields in the class...
	 *<code><pre>SELECT id, name, age FROM table;
	 *
	 *class DaoClass {
	 *  &#64;Value int id;
	 *  &#64;Value String name;
	 *  &#64;Value int age;
	 *}</pre></code>
	 * ...assuming those fields match the tuple element types. Fields must be marked with
	 * the {@link Value} annotation to be converted between formats. The target class must
	 * also implement a no-args constructor.
	 * </div>
	 * 
	 * @param <T> The type of the object to return.
	 * @param rs The ResultSet holding tuples
	 * @param clazz The class of the object to return.
	 * @return An object whose fields match those in the ResultSet tuple.
	 * @throws SQLException If an error occurs while reading the ResultSet.
	 */
	public static final <T> T getTupleAsBean(ResultSet rs, Class<T> clazz) throws SQLException {
		try {
			return deserialize(getTupleAsMap(rs), clazz);
		} catch (InstantiationException | IllegalAccessException e) {
			throw new SQLException(e);
		}
	}

	/**
	 *<pre>public static final Object[] getTupleAsArray({@link ResultSet} rs)
	 *    throws {@link SQLException}</pre>
	 * <div class="block">
	 * Retrieves an array from the current tuple in a ResultSet.
	 * A call to ResultSet.next() should precede this method call.<br/>
	 * A tuple produced by the following query matches those in the array...
	 *<code><pre>SELECT id, name, age FROM table;
	 *
	 *new Object[]{ new Integer(id), new String(name), new Integer(age) }</pre></code>
	 * ...assuming the array elements match the tuple data types.
	 * </div>
	 * 
	 * @param rs The ResultSet holding tuples.
	 * @return An array whose values match those in the ResutSet tuple,
	 *         in the same order as their corresponding rows.
	 * @throws SQLException If an error occurs while reading the ResultSet.
	 */
	public static final Object[] getTupleAsArray(ResultSet rs) throws SQLException {

		// find number of columns available
		ResultSetMetaData metadata = rs.getMetaData();

		// container for properties
		Object[] tuple = new Object[metadata.getColumnCount()];

		// iterate through each column and read the value
		for (int i = 1; i <= metadata.getColumnCount(); i++) {
			tuple[i - 1] = getValue(rs, metadata, i);
		}

		return tuple;
	}

	/**
	 *<pre>public static final {@link Map}{@literal <String, Object>} getTupleAsMap({@link ResultSet} rs)
	 *    throws {@link SQLException}</pre>
	 * <div class="block">
	 * Retrieves a Map from the current tuple in a ResultSet.
	 * A call to ResultSet.next() should precede this method call.<br/>
	 * A tuple produced by the following query matches the entries in the map...
	 *<code><pre>SELECT id, name, age FROM table;
	 *
	 *Map map = new Map();
	 *map.put("id", new Integer());
	 *map.put("name", new String());
	 *map.put("age", new Integer());</pre></code>
	 * ...assuming the Map entries match the tuple data types.
	 * </div>
	 *
	 * @param rs The ResultSet holding tuples.
	 * @return A Map in which the column names of the ResultSet correspond to
	 *         their respective values.
	 * @throws SQLException If an error occurs while reading the ResultSet
	 */
	public static final Map<String, Object> getTupleAsMap(ResultSet rs) throws SQLException {

		// container for properties
		HashMap<String, Object> props = new HashMap<>();

		// iterate through each column and read the value
		ResultSetMetaData metadata = rs.getMetaData();
		
		for (int i = 1; i <= metadata.getColumnCount(); i++) {
			props.put(metadata.getColumnLabel(i), getValue(rs, metadata, i));
		}

		return props;
	}
	
	/**
	 * DO NOT USE
	 * Gets the appropriate Java type from the ResultSet at the give index.
	 * @param rs The ResultSet containing tuples.
	 * @param metadata The ResultSet's metadata
	 * @param i The index of the column in the set
	 * @return An object of the Java type corresponding to the SQL type of the selected column.
	 * @throws SQLException If an error occurs while reading the ResultSet or its metadata
	 */
	private static final Object getValue(ResultSet rs, ResultSetMetaData metadata, int i) throws SQLException {
		switch (metadata.getColumnType(i)) {
		case java.sql.Types.BOOLEAN:
			return rs.getBoolean(i);
		case java.sql.Types.INTEGER:
			return rs.getInt(i);
		case java.sql.Types.DATE:
			return rs.getDate(i);
		case java.sql.Types.VARCHAR:
		default:
			return rs.getString(i);
		}
	}

	/**
	 * DO NOT USE
	 * Instantiates and deserializes an object initializing its fields
	 * with the corresponding entries in the given map
	 * @param <T> The type of the object to return
	 * @param props A map containing the object's fields
	 * @param clazz The class of the object to return
	 * @return An object of the specified type
	 * @throws InstantiationException If an object of the specified type cannot be instantiated
	 * @throws IllegalAccessException If an object of the specified type cannot be instantiated
	 */
	@SuppressWarnings("unchecked")
	private static final <T> T deserialize(Map<String, Object> props, Class<T> clazz)
			throws InstantiationException, IllegalAccessException {

		// create an object that will act as the return value
		T result = clazz.newInstance();

		// iterate through all the class's fields, looking for any marked as Values
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {

			// get the Value annotation (and Adapter, if needed)
			Value value = field.getAnnotation(Value.class);
			Adapts adapts = field.getAnnotation(Adapts.class);
			if (value != null) {

				// get name of field
				String valueName = value.name().equals(Value.DEFAULT) ? field.getName() : value.name();

				// get adapter, if any
				DaoAdapter<Object, Object> adapter = null;
				if (adapts != null) try {
					adapter = (DaoAdapter<Object, Object>) adapts.using().newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}

				// finally we attempt to set the value
				Object genericValue = props.get(valueName);
				System.out.printf("%s -> %s", valueName, genericValue);
				if (adapter != null) {
					genericValue = adapter.adaptToInput(genericValue);
					System.out.printf(" (-> %s)", genericValue);
				}
				System.out.println();
				if (genericValue != null) try {
					field.setAccessible(true);
					field.set(result, genericValue);
					field.setAccessible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * DO NOT USE
	 * @param <T>
	 * @param o
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static final <T> Map<String, Object> serialize(T o, Class<T> clazz) {

		// container for properties
		HashMap<String, Object> props = new HashMap<>();

		// iterate through all the class's fields, looking for any marked as Values
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {

			// get the Value annotation (and Adapter, if needed)
			Value value = field.getAnnotation(Value.class);
			Adapts adapts = field.getAnnotation(Adapts.class);
			if (value != null) {

				// get name of field
				String valueName = (value.name() == Value.DEFAULT) ? field.getName() : value.name();

				// get adapter, if any
				DaoAdapter<Object, Object> adapter = null;
				if (adapts != null)
					try {
						adapter = (DaoAdapter<Object, Object>) adapts.using().newInstance();
					} catch (Exception e) {
						e.printStackTrace();
					}

				// save field
				try {
					field.setAccessible(true);
					Object genericValue = field.get(o);
					if (adapter != null) {
						genericValue = adapter.adaptToOutput(genericValue);
					}
					props.put(valueName, genericValue);
					field.setAccessible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return props;
	}
}
