package com.dao;

/**
 * @author Christopher Madrigal
 *
 * @param <I> The type of the object corresponding to a field.
 * @param <O> The type of the object output to the database.
 */
public interface DaoAdapter<I, O> {
	
	/**
	 * Adapts the given input value into the output type.
	 * This function should be implemented such that
	 * <code>adaptToOutput(adaptToInput(o)) == o</code>
	 * 
	 * @param value An input-type value
	 * @return The corresponding output-type value
	 */
	public O adaptToOutput(I value);
	
	/**
	 * Adapts the given output value into the input type.
	 * This function should be implemented such that
	 * <code>adaptToInput(adaptToOutput(i)) == i</code>
	 * 
	 * @param value An output-type value
	 * @return The corresponding input-type value
	 */
	public I adaptToInput(O value);
}
