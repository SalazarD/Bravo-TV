package com.bean;

/**
 * A Bean interface that every bean should implement.
 */
public interface Bean {
	
	/**
	 * Gets an array of the Bean's column names. Each name should appear in
	 * the same order as its value from Bean.getColumnValues().
	 * 
	 * The first name must be the name of the unique id used by the Bean.
	 * Therefore, the array must have at least one element.
	 * 
	 * It is advisable to have a static and final pre-defined array in
	 * your Bean class that is returned by this call.
	 * 
	 * @return An array of column names
	 */
	String[] getColumnNames();
	
	/**
	 * Gets an array of the Bean's column values. Each value should appear in
	 * the same order as its name from Bean.getColumnNames().
	 * 
	 * The first value must be the unique id used by the Bean.
	 * Therefore, the array must have at least one element.
	 * 
	 * @return An array of values
	 */
	Object[] getColumnValues();
	
	/**
	 * Sets the Bean's column values. Each value should appear in
	 * the same order as its name from Bean.getColumnNames().
	 * 
	 * The first value is the unique id used by the Bean.
	 * Therefore, the array will have at least one element.
	 * 
	 * @param values An array of values
	 */
	void setColumnValues(Object[] values);
}
