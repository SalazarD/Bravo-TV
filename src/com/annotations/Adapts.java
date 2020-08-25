package com.annotations;

import com.dao.DaoAdapter;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Denotes that a field uses an adapter class
 * to transform data from the field type (input) to the
 * column type (output) in a table.
 */
@Target({ FIELD })
@Retention(RUNTIME)
public @interface Adapts {
	
	/**
	 * The class of the adapter for the field.
	 */
	public Class<? extends DaoAdapter<?, ?>> using();
}
