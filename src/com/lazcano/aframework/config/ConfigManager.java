package com.lazcano.aframework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Gestor de configuraci�n del framework, carga los par�metros de configuraci�n
 * del fichero aframework.properties, que se debe encontrar en el classpath de la 
 * aplicaci�n. Dicho fichero debe contener los siguientes par�metros.
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
	 * Nos aseguramos que se sigue el patr�n Singleton
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
	 * M�todo para obtener la instancia de la clase.
	 * @return La instancia de la clase.
	 */
	public static ConfigManager getInstance(){
		if(configManager==null){
			configManager= new ConfigManager();
		}
		return configManager;
	}
	
	/**
	 * M�todo que devuelve el nombre del PU de la aplicaci�n
	 * @return El PU JPA de la aplicaci�n
	 */
	public String getPuName(){
		return this.properties.getProperty(PU_NAME);
	}
}
