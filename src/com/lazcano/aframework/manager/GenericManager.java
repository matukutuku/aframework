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
     * Método que guarda un elemento
     * @param elemento Elemento a guardar
     */
    public void guardar(T elemento){
            EntityTransaction t=EntityManagerControler.getInstance().getEntityManager().getTransaction();
            t.begin();
            this.getDao().guardar(elemento);
            t.commit();
        }
        
        
    /**
     * Método que borra un elemento
     * @param elemento Elemento a borrar.
     */
        public void borrar(T elemento){
            EntityTransaction t=EntityManagerControler.getInstance().getEntityManager().getTransaction();
            t.begin();
            this.getDao().borrar(elemento);
            t.commit();
        }
        
        
        /**
         * Método que carga un elemento
         * @param clave Clave del elemento a cargar
         * @return El elemento que coincide con la clave
         */
        public T cargar(Object clave){
            return (T)this.getDao().cargar(clave);
        }
        
        /**
         * Método que busca los elementos que coinciden con los atributos del 
         * elemento dado
         * @param plantilla Elemento al que se deben "parecer"
         * @return La lista de elementos coincidentes.
         */
        public List<T> buscarPorEjemplo(T plantilla){
            return this.getDao().buscarPorEjemplo(plantilla);
        }
        
        
        /**
         * Método que busca los elementos que coinciden con los atributos del 
         * elemento dado y los obtiene paginados
         * @param petición con los parámetros de búsqueda y paginación
         * @return Resultado con la lista y parámetros de paginación.
         */
        public PaginationResult<T> buscarPorEjemplo(PaginationRequest request){
            return this.getDao().buscarPorEjemplo(request);
        }
}
