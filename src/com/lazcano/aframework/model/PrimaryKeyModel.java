package com.lazcano.aframework.model;

/**
 * Interfaz que identifica a los elementos que tienen clave primaria
 * @author ilazcang
 *
 */
public interface PrimaryKeyModel {
	
	/**
	 * Devuelve la clave primaria del elemento
	 * @return El valor de la clave.
	 */
	public Object getPrimaryKey();
}
