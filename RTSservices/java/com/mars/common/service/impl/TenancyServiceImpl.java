package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.TenancyDAO;
import com.mars.common.model.Tenancy;
import com.mars.common.search.TenancySearch;
import com.mars.common.service.TenancyService;
 /**

 * <p>Title: TenancyServiceImpl.java </p>

 * @see com.mars.common.model.Tenancy
 
 * <p>Description: This class is used for hibernate operations for Tenancy module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("tenancyService") 
public class TenancyServiceImpl implements TenancyService {

    private static final Log log = LogFactory.getLog(TenancyServiceImpl.class);

  	
	@Autowired
	private TenancyDAO tenancyDAO;

	public void setTenancyDAO(TenancyDAO tenancyDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setTenancyDAO Method is called ");
		}
		this.tenancyDAO = tenancyDAO;
	}

	/**
	 * This method is saves the Tenancy object
	 * 
	 * @param entity as Tenancy object
	 * @return
	 * 
	 */
	public void save(Tenancy entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		tenancyDAO.save(entity);
	}

     /**
	 * This method to merge the Tenancy information to the database.
	 * 
	 * @param Tenancy object
	 * 
	 */
    public Tenancy merge(Tenancy entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return tenancyDAO.merge(entity);
	}

	/**
	 * This method delete the tenancy
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		tenancyDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Tenancy Object
	 * 
	 */
	public Tenancy get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return tenancyDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Tenancy from the database
	 * 
	 * @return List of Tenancy
	 */
	public List<Tenancy> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return tenancyDAO.getAll();
	}
	
		/**
		 * This method returns list of the Tenancy objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Tenancy> getTenancyList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getTenancyList Method is called");
			}
			return tenancyDAO.getTenancyList(pageNumber,orderBy,sortBy);
		}
		/**
		 * 
		 * @param searchOptions
		 * @return
		 */
		public List<Tenancy> getTenancyListBySearch(TenancySearch searchTenancy){
			if (log.isDebugEnabled()) {
				log.debug("getTenancyListBySearch Method is called");
			}
			return tenancyDAO.getTenancyListBySearch(searchTenancy);
			
		}
		
		
		/**
		 * This method returns count of the Tenancy objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getTenancyCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getTenancyCount Method is called");
			}
			return tenancyDAO.getTenancyCount();
		}	
	
	
	/**
     * This method save/updates a list of Tenancy information to the database.
     * 
     * @param listTenancy as List
     * 
     */
    public void saveAll(List<Tenancy> listTenancy){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		tenancyDAO.saveAll(listTenancy);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listTenancy as List
     */
    public void deleteAll(List<Tenancy> listTenancy){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		tenancyDAO.deleteAll(listTenancy);
    }
    
    /**
	 * This method returns list of Tenancy objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Tenancy> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return tenancyDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Tenancy object for a given data
	 * 
	 * @param Tenancy as tenancy
	 * @return Tenancy as model object
	 */
	public Tenancy checkForDuplicates(Tenancy tenancy)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return tenancyDAO.checkForDuplicates(tenancy);
		
	}
	
	    /**
	 * This method returns list of Tenancy objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Tenancy> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return tenancyDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Tenancy objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Tenancy> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return tenancyDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return tenancyDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}

	public long getTenancyCountBySearch(TenancySearch searchTenancy) {
		if (log.isDebugEnabled()) 
    	{
			log.debug("getTenancyCountBySearch Method is called");
		}
		return tenancyDAO.getTenancyCountBySearch(searchTenancy);
	}
	public String getTenancyId(String tenancyName){
		if (log.isDebugEnabled()) 
    	{
			log.debug("getTenancyCountBySearch Method is called");
		}
		return tenancyDAO.getTenancyId(tenancyName);
	}
}

