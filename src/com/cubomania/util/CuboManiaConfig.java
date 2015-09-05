package com.cubomania.util;

import java.io.IOException;
import java.util.Properties;

public class CuboManiaConfig {
	
	public enum Property{
		DB_HOST,
		DB_USER,
		DB_PASSWORD,
		DB_DATABASE
		;
	}

	private static final String CUBOMANIA_ENV = "CUBOMANIA_ENV";
	
	private final Properties properties = new Properties();
	private static CuboManiaConfig CONFIG = new CuboManiaConfig();
	
	public static boolean isDevEnvironment() {
		return System.getenv(CUBOMANIA_ENV) != null ? true : false;
	}
	
	private CuboManiaConfig() {
		try {
			properties.load(CuboManiaConfig.class.getResourceAsStream("cubomaniaconfig.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Properties getProperties(){
		return this.properties;
	}
	
	public static String getValue(Property key){
		return CONFIG.getProperties().getProperty(key.toString());
	}
}
