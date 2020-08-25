package com.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author Christopher Madrigal
 * 
 * Denotes a field that corresponds to a column in a table.
 */
@Target({ FIELD })
@Retention(RUNTIME)
public @interface Value {
	
	public static final String DEFAULT = "";
	
	/**
	 * The name of the field in the table, if different
	 * from the field's name.
	 */
	public String name() default DEFAULT;
}
