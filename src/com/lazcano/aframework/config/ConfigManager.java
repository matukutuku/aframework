package com.lazcano.aframework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Gestor de configuración del framework, carga los parámetros de configuración
 * del fichero aframework.properties, que se debe encontrar en el classpath de la 
 * aplicación.
 * @author ilazcang
 *
 */
public class ConfigManager {
	
	private static ConfigManager configManager;
	private Properties properties;
	private static String FILE_NAME="aframework.propeties";
	private static String PU_NAME="puName";
	
	private ConfigManager(){
		properties = new Properties();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(FILE_NAME);
		try{
			properties.load(inputStream);
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
	
	public static ConfigManager getInstance(){
		if(configManager==null){
			configManager= new ConfigManager();
		}
		return configManager;
	}
	
	public String getPuName(){
		return this.properties.getProperty(PU_NAME);
	}
}
