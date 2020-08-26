package com.bean;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * A Bean interface that every bean should implement.
 */
public interface Bean {
	
	/**
	 * Gets the name of the Bean's unique identifier.
	 * It is advised to return a string literal.
	 * 
	 * @return The name of the Bean's unique identifier
	 */
	String getUniqueIDName();
	
	/**
	 * Gets a map of the Bean's property names to their respective values.
	 * 
	 * Every Bean implements a unique identifier. Therefore, the map must have at least one element.
	 * 
	 * @return The property map.
	 */
	default Map<String, Object> getProperties() {
		HashMap<String, Object> properties = new HashMap<String, Object>();
		Field[] declaredFields = this.getClass().getDeclaredFields();
		for (Field f : declaredFields) try {
			boolean flag = f.isAccessible();
			f.setAccessible(true);
			properties.put(f.getName(), f.get(this));
			f.setAccessible(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	/**
	 * Sets the Bean's properties according to the values in the map.
	 * 
	 * Every Bean implements a unique identifier. Therefore, the map must have at least one element.
	 */
	default void setProperties(Map<String, Object> properties) {
		Field[] declaredFields = this.getClass().getDeclaredFields();
		for (Field f : declaredFields) if (properties.containsKey(f.getName())) try {
			boolean flag = f.isAccessible();
			f.setAccessible(true);
			f.set(this, properties.get(f.getName()));
			f.setAccessible(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
