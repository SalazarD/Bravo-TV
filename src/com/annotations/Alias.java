package com.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Denotes the name used by a database if different from that of the field.
 */
@Target({ FIELD })
@Retention(RUNTIME)
public @interface Alias {
	
	/**
	 * The name of the field in its table.
	 */
	public String value();
}
