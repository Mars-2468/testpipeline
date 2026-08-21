package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.TalukaDAO;
import com.mars.common.model.Taluka;
import com.mars.common.search.TalukaSearch;
import com.mars.common.service.TalukaService;
 /**

 * <p>Title: TalukaServiceImpl.java </p>

 * @see com.mars.common.model.Taluka
 
 * <p>Description: This class is used for hibernate operations for Taluka module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("talukaService")
public class TalukaServiceImpl implements TalukaService {

    private static final Log log = LogFactory.getLog(TalukaServiceImpl.class);

  	
	@Autowired
	private TalukaDAO talukaDAO;

	public void setTalukaDAO(TalukaDAO talukaDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setTalukaDAO Method is called ");
		}
		this.talukaDAO = talukaDAO;
	}

	/**
	 * This method is saves the Taluka object
	 * 
	 * @param entity as Taluka object
	 * @return
	 * 
	 */
	public void save(Taluka entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		talukaDAO.save(entity);
	}

     /**
	 * This method to merge the Taluka information to the database.
	 * 
	 * @param Taluka object
	 * 
	 */
    public Taluka merge(Taluka entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return talukaDAO.merge(entity);
	}

	/**
	 * This method delete the taluka
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		talukaDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Taluka Object
	 * 
	 */
	public Taluka get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return talukaDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Taluka from the database
	 * 
	 * @return List of Taluka
	 */
	public List<Taluka> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return talukaDAO.getAll();
	}
	
		/**
		 * This method returns list of the Taluka objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Taluka> getTalukaList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getTalukaList Method is called");
			}
			return talukaDAO.getTalukaList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * This method returns list of the Taluka objects available based on Search.
		 * 
		 * @param TalukaSearch searchTaluka
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<Taluka> getTalukaListBySearch(TalukaSearch searchTaluka){
		
			if (log.isDebugEnabled()) {
				log.debug("getTalukaListBySearch Method is called");
			}
			return talukaDAO.getTalukaListBySearch(searchTaluka);
		}
		
		/**
		 * This method returns count of the Taluka objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getTalukaCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getTalukaCount Method is called");
			}
			return talukaDAO.getTalukaCount();
		}	
	
		
		/**
		 * This method returns count of the Taluka objects available based on search criteria.
		 *@param TalukaSearch searchTaluka 
		 * @return long
		 * @exception Exception
		 */
		public long getTalukaCountBySearch(TalukaSearch searchTaluka){
		    if (log.isDebugEnabled()) {
				log.debug("getTalukaCountBySearch Method is called");
			}
			return talukaDAO.getTalukaCountBySearch(searchTaluka);
		}
	
	/**
     * This method save/updates a list of Taluka information to the database.
     * 
     * @param listTaluka as List
     * 
     */
    public void saveAll(List<Taluka> listTaluka){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		talukaDAO.saveAll(listTaluka);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listTaluka as List
     */
    public void deleteAll(List<Taluka> listTaluka){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		talukaDAO.deleteAll(listTaluka);
    }
    
    /**
	 * This method returns list of Taluka objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Taluka> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return talukaDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Taluka object for a given data
	 * 
	 * @param Taluka as taluka
	 * @return Taluka as model object
	 */
	public Taluka checkForDuplicates(Taluka taluka)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return talukaDAO.checkForDuplicates(taluka);
		
	}
	
	    /**
	 * This method returns list of Taluka objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Taluka> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return talukaDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Taluka objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Taluka> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return talukaDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
	}
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return talukaDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
}

