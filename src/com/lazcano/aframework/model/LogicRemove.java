/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.aframework.model;



/**
 *  Clase abstracta que se utiliza para identificar los modelos que tienen baja l�gica
 *  y no f�sica 
 * @author ilazcang
 */
public interface LogicRemove{
    
	/**
	 * M�todo que establece el valor del campo baja
	 * @param valor true indicara que el objeto esto de baja, false que est� de alta
	 */
    public void setBaja(Boolean valor);
    
    /**
     * M�todo que devuelve si el objeto esta de baja en la B.B.D.D.
     * @return true si est� de baja, false en caso contrario.
     */
    public Boolean isBaja();
    
    
    
}
