package com.config.load.property;

import java.util.Objects;
import java.util.Properties;

public class CommonConfig {

	private Properties PROPERTY_CONFIG = null;
	
	protected void initProperty(Properties prop) {
		PROPERTY_CONFIG = prop;
	}
	public String getValue(String key) {
		if(Objects.isNull(key)){
			return null;
		}
		return PROPERTY_CONFIG.getProperty(key);
	}
	
	public String getValue(String key, String defaultValue) {
		if(Objects.isNull(key)){
			return defaultValue;
		}
		return PROPERTY_CONFIG.getProperty(key, defaultValue);
	}
	
}
