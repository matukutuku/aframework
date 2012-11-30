package com.lazcano.aframework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Gestor de configuración del framework, carga los parámetros de configuración
 * del fichero aframework.properties, que se debe encontrar en el classpath de la 
 * aplicación. Dicho fichero debe contener los siguientes parámetros.
 * puName= Nombre del PU para la persistencia utilizando JPA
 * @author ilazcang
 *
 */
public class ConfigManager {
	
	private static ConfigManager configManager;
	private Properties properties;
	private static final String FILE_NAME="aframework.propeties";
	private static final String PU_NAME="puName";
	
	
	/**
	 * Nos aseguramos que se sigue el patrón Singleton
	 */
	private ConfigManager(){
		properties = new Properties();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(FILE_NAME);
		try{
			properties.load(inputStream);
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Método para obtener la instancia de la clase.
	 * @return La instancia de la clase.
	 */
	public static ConfigManager getInstance(){
		if(configManager==null){
			configManager= new ConfigManager();
		}
		return configManager;
	}
	
	/**
	 * Método que devuelve el nombre del PU de la aplicación
	 * @return El PU JPA de la aplicación
	 */
	public String getPuName(){
		return this.properties.getProperty(PU_NAME);
	}
}
