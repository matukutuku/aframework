/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.aframework.dao;

import java.util.List;



/**
 *
 * @author ilazcang
 */
public class PaginationResult<T>{
    private List<T> dataList;
    private Integer total;
    private Integer offSet;
    private Integer maxResult;

    /**
     * @return the dataList
     */
    public List<T> getDataList() {
        return dataList;
    }

    /**
     * @param dataList the dataList to set
     */
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
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
    
    public Integer currentPage(){
        int posicion=1;
        if(this.offSet>0){
            posicion=(this.offSet/this.maxResult)-1;
        }
        return posicion;
    }
    
    public Integer lastPage(){
        int last=1;
        if(this.total>this.maxResult){
            last=(this.total/this.maxResult);
        }
        return last;
    }
    
}
