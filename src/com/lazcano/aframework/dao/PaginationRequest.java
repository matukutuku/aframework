/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.aframework.dao;




/**
 * Petici�n de b�squeda paginada
 * @author ilazcang
 */
public class PaginationRequest {
    
	// Elemento "Ejemplo"
	private Object template;
	// Desplazamiento en el paginado
	private Integer offSet;
	//N�mero m�ximo de resultados por p�gina.
    private Integer maxResult;

    /**
     * @return the template
     */
    public Object getTemplate() {
        return template;
    }

    /**
     * @param template the template to set
     */
    public void setTemplate(Object template) {
        this.template = template;
    }

    /**
     * @return the offSet
     */
    public Integer getOffSet() {
        return offSet;
    }

    /**
     * @param offSet the offSet to set
     */
    public void setOffSet(Integer offSet) {
        this.offSet = offSet;
    }

    /**
     * @return the maxResult
     */
    public Integer getMaxResult() {
        return maxResult;
    }

    /**
     * @param maxResult the maxResult to set
     */
    public void setMaxResult(Integer maxResult) {
        this.maxResult = maxResult;
    }
}
