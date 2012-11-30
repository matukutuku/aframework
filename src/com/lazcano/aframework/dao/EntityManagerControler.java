/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.aframework.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lazcano.aframework.config.ConfigManager;

/**
 * Clase que implementa un controlador para el entity manager de la aplicaci�n
 * @author ilazcang
 */
public class EntityManagerControler {

    
    private EntityManager em;
    private static EntityManagerControler gestor;
    
    /**
     * Nos aseguramos que sigue el patr�n Singleton
     */
    private EntityManagerControler(){
        String puName=ConfigManager.getInstance().getPuName();
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory(puName);
        em = emf.createEntityManager();
    }
    
    /**
     * M�todo para obtener la instancia de la clase.
     * @return La instancia
     */
    public static EntityManagerControler getInstance(){
        if(gestor==null){
            gestor=new EntityManagerControler();
        }
        return gestor;
    }
    
    /**
     * EntityManager de la aplicaci�n para JPA
     * @return El entityManager de la aplicaci�n.
     */
    public EntityManager getEntityManager(){
        return this.em;
    }
    
    
}
