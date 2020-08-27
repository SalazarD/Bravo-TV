package com.bean;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.annotations.Alias;

/**
 * A Bean interface that every bean should implement.
 */
public interface Bean {
	
	/**
	 * Gets the name of the Bean's unique identifier in its table.
	 * When overriding, it is advised to return a string literal.
	 * 
	 * @return The name of the Bean's unique identifier, or null if none exists
	 */
	String getUniqueIDName();
	
	/**
	 * Gets a map of the Bean's property names to their respective values.
	 * The property names must be those that appear in the Bean's table.
	 * 
	 * Every Bean implements a unique identifier. Therefore, the map must have at least one element.
	 * 
	 * @return The property map
	 */
	default Map<String, Object> getProperties() {
		
		HashMap<String, Object> properties = new HashMap<String, Object>();
		Field[] declaredFields = this.getClass().getDeclaredFields();
		
		for (Field f : declaredFields) try {
			
			// Property name may differ from field name
			String propertyName = Bean.resolveFieldName(f);
			
			// Briefly set field to be accessible and read its value
			boolean flag = f.isAccessible();
			f.setAccessible(true);
			properties.put(propertyName, f.get(this));
			f.setAccessible(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	/**
	 * Sets the Bean's properties according to the values in the map.
	 * The property names must be those that appear in the Bean's table.
	 * 
	 * Every Bean implements a unique identifier. Therefore, the map must have at least one element.
	 */
	default void setProperties(Map<String, Object> properties) {
		
		Field[] declaredFields = this.getClass().getDeclaredFields();
		
		for (Field f : declaredFields) {
			
			// Property name may differ from field name
			String propertyName = Bean.resolveFieldName(f);

			if (properties.containsKey(propertyName)) try {
				// Briefly set field to be accessible and change its value
				boolean flag = f.isAccessible();
				f.setAccessible(true);
				f.set(this, properties.get(propertyName));
				f.setAccessible(flag);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Resolves the field's database name.
	 * @param f The field 
	 * @return The field's name, or its alias if annotated with Alias
	 */
	static String resolveFieldName(Field f) {
		if (f.getDeclaredAnnotation(Alias.class) != null) {
			return f.getDeclaredAnnotation(Alias.class).value();
		}
		else {
			return f.getName();
		}
	}
}
