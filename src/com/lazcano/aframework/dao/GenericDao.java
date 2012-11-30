/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.aframework.dao;




import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.eclipse.persistence.jpa.JpaHelper;
import org.eclipse.persistence.queries.QueryByExamplePolicy;
import org.eclipse.persistence.queries.ReadObjectQuery;

import com.lazcano.aframework.model.LogicRemove;

/**
 * Clase que proporciona las funcionalidades básicas para los daos.
 * @author ilazcang
 */
public abstract class GenericDao <T>{
    
    
    private EntityManager entityManager;
    
    protected abstract Class<T> getTClass();
    
    public GenericDao(){
        this.entityManager=EntityManagerControler.getInstance().getEntityManager();
    }
    
    /**
     * Método que guarda el objeto en la base de datos
     * @param objeto El objeto a guardar
     * @return el objeto con sus campos actualizados después de guardarlo
     */
    public T guardar(T objeto){
        objeto=this.entityManager.merge(objeto);
        this.entityManager.persist(objeto);
        return objeto;
    }
    
    /**
     * Método que carga un objeto dado su clave.
     * @param clave La clave del objeto a cargar
     * @return El objeto, o null si no existe.
     */
    public T cargar(Integer clave){
        return this.entityManager.find(getTClass(), clave);
    }
    
    /**
     * Método que borra un objeto de la BD
     * @param clave Clave del objeto a eliminar 
     */
    public void borrar(Integer clave){
        T elementoa=this.cargar(clave);
        if(elementoa!=null){
            if(elementoa instanceof LogicRemove){
                LogicRemove lr=(LogicRemove)elementoa;
                lr.setBaja(Boolean.TRUE);
                this.guardar(elementoa);
            }else{
                this.entityManager.remove(elementoa);
            }
        }
            
    }
    
    /**
     * Método que elimina un objeto de la base de datos 
     * @param elemento El objeto a eliminar.
     */
    public void borrar(T elemento ){
        if(elemento!=null){
            if(elemento instanceof LogicRemove){
                LogicRemove lr=(LogicRemove)elemento;
                lr.setBaja(Boolean.TRUE);
                this.guardar(elemento);
            }else{
                this.entityManager.remove(elemento);
            }
        }
            
    }
    
    @SuppressWarnings("unchecked")
	protected List<T> buscar(String sql,Map<String,Object> parametros){
        Query query= this.entityManager.createQuery(sql);
        for(String izena:parametros.keySet()){
            query.setParameter(izena, parametros.get(izena));
        }
        return  query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    protected List<T> buscar(String galdera,Map<String,Object> parametroak,Integer tope){
        Query query= this.entityManager.createQuery(galdera);
        for(String izena:parametroak.keySet()){
            query.setParameter(izena, parametroak.get(izena));
        }
        return query.setMaxResults(tope).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<T> buscarPorEjemplo(T plantilla){
        QueryByExamplePolicy policy = new QueryByExamplePolicy();
        ReadObjectQuery q = new ReadObjectQuery(plantilla, policy);
        Query query = JpaHelper.createQuery(q, this.entityManager); 
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public PaginationResult<T> buscarPorEjemplo(PaginationRequest request){
        QueryByExamplePolicy policy = new QueryByExamplePolicy();
        ReadObjectQuery q = new ReadObjectQuery(request.getTemplate(), policy);
        Query query = JpaHelper.createQuery(q, this.entityManager); 
        PaginationResult<T> result= new PaginationResult<T>();
        List<T> data=query.getResultList();
        int ultimo=request.getOffSet()+request.getMaxResult();
        if(ultimo>data.size()){
            ultimo=data.size();
        }
        result.setDataList(data.subList(request.getOffSet(), ultimo));
        result.setTotal(data.size());
        result.setMaxResult(request.getMaxResult());
        result.setOffSet(request.getOffSet());
        return result;
    }
}
