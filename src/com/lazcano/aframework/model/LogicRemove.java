/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.aframework.model;



/**
 *  Clase abstracta que se utiliza para identificar los modelos que tienen baja lógica
 *  y no física 
 * @author ilazcang
 */
public interface LogicRemove{
    
	/**
	 * Método que establece el valor del campo baja
	 * @param valor true indicara que el objeto esto de baja, false que está de alta
	 */
    public void setBaja(Boolean valor);
    
    /**
     * Método que devuelve si el objeto esta de baja en la B.B.D.D.
     * @return true si está de baja, false en caso contrario.
     */
    public Boolean isBaja();
    
    
    
}
