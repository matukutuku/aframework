/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.aframework.manager;



import java.util.List;
import javax.persistence.EntityTransaction;

import com.lazcano.aframework.dao.EntityManagerControler;
import com.lazcano.aframework.dao.GenericDao;
import com.lazcano.aframework.dao.PaginationRequest;
import com.lazcano.aframework.dao.PaginationResult;


/**
 * Clase base para implementar managers para un tipo de dato dado
 * @author ilazcang
 */
public abstract class GenericManager<T> {
     
    protected abstract GenericDao<T> getDao();
        
    /**
     * M�todo que guarda un elemento
     * @param elemento Elemento a guardar
     */
    public void guardar(T elemento){
            EntityTransaction t=EntityManagerControler.getInstance().getEntityManager().getTransaction();
            t.begin();
            this.getDao().guardar(elemento);
            t.commit();
        }
        
        
    /**
     * M�todo que borra un elemento
     * @param elemento Elemento a borrar.
     */
        public void borrar(T elemento){
            EntityTransaction t=EntityManagerControler.getInstance().getEntityManager().getTransaction();
            t.begin();
            this.getDao().borrar(elemento);
            t.commit();
        }
        
        
        /**
         * M�todo que carga un elemento
         * @param clave Clave del elemento a cargar
         * @return El elemento que coincide con la clave
         */
        public T cargar(Object clave){
            return (T)this.getDao().cargar(clave);
        }
        
        /**
         * M�todo que busca los elementos que coinciden con los atributos del 
         * elemento dado
         * @param plantilla Elemento al que se deben "parecer"
         * @return La lista de elementos coincidentes.
         */
        public List<T> buscarPorEjemplo(T plantilla){
            return this.getDao().buscarPorEjemplo(plantilla);
        }
        
        
        /**
         * M�todo que busca los elementos que coinciden con los atributos del 
         * elemento dado y los obtiene paginados
         * @param petici�n con los par�metros de b�squeda y paginaci�n
         * @return Resultado con la lista y par�metros de paginaci�n.
         */
        public PaginationResult<T> buscarPorEjemplo(PaginationRequest request){
            return this.getDao().buscarPorEjemplo(request);
        }
}
