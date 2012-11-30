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
import com.lazcano.aframework.model.PrimaryKeyModel;


/**
 *
 * @author ilazcang
 */
public abstract class GenericManager<T extends PrimaryKeyModel> {
     
    protected abstract GenericDao<T> getDao();
        
    public void gorde(T elemento){
            EntityTransaction t=EntityManagerControler.getInstance().getEntityManager().getTransaction();
            t.begin();
            this.getDao().guardar(elemento);
            t.commit();
        }
        
        public void ezabatu(Integer gakoa){
            EntityTransaction t=EntityManagerControler.getInstance().getEntityManager().getTransaction();
            t.begin();
            this.getDao().borrar(gakoa);
            t.commit();
        }
        
        public void borrar(T elemento){
            EntityTransaction t=EntityManagerControler.getInstance().getEntityManager().getTransaction();
            t.begin();
            this.getDao().borrar(elemento);
            t.commit();
        }
        
        
        public T eskuratu(Integer gakoa){
            return (T)this.getDao().cargar(gakoa);
        }
        
        public List<T> buscarPorEjemplo(T plantilla){
            return this.getDao().buscarPorEjemplo(plantilla);
        }
        
        public PaginationResult<T> buscarPorEjemplo(PaginationRequest request){
            return this.getDao().buscarPorEjemplo(request);
        }
}
