package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.WardMasterDAO;
import com.mars.common.model.WardMaster;
import com.mars.common.search.WardMasterSearch;
import com.mars.common.service.WardMasterService;
 /**

 * <p>Title: WardMasterServiceImpl.java </p>

 * @see com.mars.common.model.WardMaster
 
 * <p>Description: This class is used for hibernate operations for WardMaster module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("wardMasterService") 
public class WardMasterServiceImpl implements WardMasterService {

    private static final Log log = LogFactory.getLog(WardMasterServiceImpl.class);

  	
	@Autowired
	private WardMasterDAO wardMasterDAO;

	public void setWardMasterDAO(WardMasterDAO wardMasterDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setWardMasterDAO Method is called ");
		}
		this.wardMasterDAO = wardMasterDAO;
	}

	/**
	 * This method is saves the WardMaster object
	 * 
	 * @param entity as WardMaster object
	 * @return
	 * 
	 */
	public void save(WardMaster entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		wardMasterDAO.save(entity);
	}

     /**
	 * This method to merge the WardMaster information to the database.
	 * 
	 * @param WardMaster object
	 * 
	 */
    public WardMaster merge(WardMaster entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return wardMasterDAO.merge(entity);
	}

	/**
	 * This method delete the wardMaster
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		wardMasterDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a WardMaster Object
	 * 
	 */
	public WardMaster get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return wardMasterDAO.get(id);
	}
	
	/**
	 * This method will return a list of all WardMaster from the database
	 * 
	 * @return List of WardMaster
	 */
	public List<WardMaster> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return wardMasterDAO.getAll();
	}
	
		/**
		 * This method returns list of the WardMaster objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<WardMaster> getWardMasterList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getWardMasterList Method is called");
			}
			return wardMasterDAO.getWardMasterList(pageNumber,orderBy,sortBy);
		}
		
		/**
		 * This method returns list of the WardMaster objects available based on Search.
		 * 
		 * @param WardMasterSearch searchWardMaster
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<WardMaster> getWardMasterListBySearch(WardMasterSearch searchWardMaster){
			if(log.isDebugEnabled()){
				log.debug("getWardMasterListBySearch Method is called");
			}
			
			return wardMasterDAO.getWardMasterListBySearch(searchWardMaster);
		}
		
		
		/**
		 * This method returns count of the WardMaster objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getWardMasterCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getWardMasterCount Method is called");
			}
			return wardMasterDAO.getWardMasterCount();
		}	
		
		/**
		 * This method returns count of the WardMaster objects available based on search criteria.
		 * @param WardMasterSearch searchWardMaster
		 * @return long
		 * @exception Exception
		 */
		public long getWardMasterCountBySearch(WardMasterSearch searchWardMaster){
			if(log.isDebugEnabled()){
				log.debug("getWardMasterCountBySearch Method is called");
			}
			
			return wardMasterDAO.getWardMasterCountBySearch(searchWardMaster);
		}
	
	
	/**
     * This method save/updates a list of WardMaster information to the database.
     * 
     * @param listWardMaster as List
     * 
     */
    public void saveAll(List<WardMaster> listWardMaster){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		wardMasterDAO.saveAll(listWardMaster);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listWardMaster as List
     */
    public void deleteAll(List<WardMaster> listWardMaster){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		wardMasterDAO.deleteAll(listWardMaster);
    }
    
    /**
	 * This method returns list of WardMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<WardMaster> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return wardMasterDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns WardMaster object for a given data
	 * 
	 * @param WardMaster as wardMaster
	 * @return WardMaster as model object
	 */
	public WardMaster checkForDuplicates(WardMaster wardMaster)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return wardMasterDAO.checkForDuplicates(wardMaster);
		
	}
	
	    /**
	 * This method returns list of WardMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WardMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return wardMasterDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of WardMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WardMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return wardMasterDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return wardMasterDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	
	public List<WardMaster> getWardList(WardMasterSearch searchOptions) {

		if (log.isDebugEnabled()) {
			log.debug("getWardList Method is called");
		}
		return wardMasterDAO.getWardList(searchOptions);
	}
	
	
	public long getWardCount(WardMasterSearch searchOptions) {
		if (log.isDebugEnabled()) {
			log.debug("getWardCount Method is called");
		}
		return wardMasterDAO.getWardCount(searchOptions);
	}

	public List<WardMaster> getWardMasterListBasedOnZoneId(long id){
		if (log.isDebugEnabled()) {
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return wardMasterDAO.getWardMasterListBasedOnZoneId(id);

	}
	
}

