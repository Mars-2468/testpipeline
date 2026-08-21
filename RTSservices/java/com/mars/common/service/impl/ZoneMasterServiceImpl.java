package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.ZoneMasterDAO;
import com.mars.common.model.ZoneMaster;
import com.mars.common.search.ZoneMasterSearch;
import com.mars.common.service.ZoneMasterService;
 /**

 * <p>Title: ZoneMasterServiceImpl.java </p>

 * @see com.mars.common.model.ZoneMaster
 
 * <p>Description: This class is used for hibernate operations for ZoneMaster module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("zoneMasterService")
public class ZoneMasterServiceImpl implements ZoneMasterService {

    private static final Log log = LogFactory.getLog(ZoneMasterServiceImpl.class);

  	
	@Autowired
	private ZoneMasterDAO zoneMasterDAO;

	public void setZoneMasterDAO(ZoneMasterDAO zoneMasterDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setZoneMasterDAO Method is called ");
		}
		this.zoneMasterDAO = zoneMasterDAO;
	}

	/**
	 * This method is saves the ZoneMaster object
	 * 
	 * @param entity as ZoneMaster object
	 * @return
	 * 
	 */
	public void save(ZoneMaster entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		zoneMasterDAO.save(entity);
	}

     /**
	 * This method to merge the ZoneMaster information to the database.
	 * 
	 * @param ZoneMaster object
	 * 
	 */
    public ZoneMaster merge(ZoneMaster entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return zoneMasterDAO.merge(entity);
	}

	/**
	 * This method delete the zoneMaster
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		zoneMasterDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a ZoneMaster Object
	 * 
	 */
	public ZoneMaster get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return zoneMasterDAO.get(id);
	}
	
	/**
	 * This method will return a list of all ZoneMaster from the database
	 * 
	 * @return List of ZoneMaster
	 */
	public List<ZoneMaster> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return zoneMasterDAO.getAll();
	}
	
		/**
		 * This method returns list of the ZoneMaster objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<ZoneMaster> getZoneMasterList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getZoneMasterList Method is called");
			}
			return zoneMasterDAO.getZoneMasterList(pageNumber,orderBy,sortBy);
		}
		
		/**
		 * This method returns list of the ZoneMaster objects available based on search
		 * 
		 * @param searchZoneMaster
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		
		public long getZoneMasterCount(ZoneMasterSearch searchOptions) {
			if (log.isDebugEnabled()) {
				log.debug("getZoneMasterCount Method is called");
			}
			return zoneMasterDAO.getZoneMasterCount(searchOptions);
		}

		
		public List<ZoneMaster> getZoneMasterListBySearch(ZoneMasterSearch searchZoneMaster){
		
			if (log.isDebugEnabled()) {
				log.debug("getZoneMasterList Method is called");
			}
			return zoneMasterDAO.getZoneMasterListBySearch(searchZoneMaster);
		}
		
		/**
		 * This method returns count of the ZoneMaster objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getZoneMasterCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getZoneMasterCount Method is called");
			}
			return zoneMasterDAO.getZoneMasterCount();
		}	
	
		/**
		 * This method returns count of the ZoneMaster objects available based on search criteria.
		 * @param searchZoneMaster 
		 * @return long
		 * @exception Exception
		 */
		public long getZoneMasterCountBySearch(ZoneMasterSearch searchZoneMaster){
		    if (log.isDebugEnabled()) {
				log.debug("getZoneMasterCount Method is called");
			}
			return zoneMasterDAO.getZoneMasterCountBySearch(searchZoneMaster);
		}
		
	/**
     * This method save/updates a list of ZoneMaster information to the database.
     * 
     * @param listZoneMaster as List
     * 
     */
    public void saveAll(List<ZoneMaster> listZoneMaster){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		zoneMasterDAO.saveAll(listZoneMaster);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listZoneMaster as List
     */
    public void deleteAll(List<ZoneMaster> listZoneMaster){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		zoneMasterDAO.deleteAll(listZoneMaster);
    }
    
    /**
	 * This method returns list of ZoneMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<ZoneMaster> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return zoneMasterDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns ZoneMaster object for a given data
	 * 
	 * @param ZoneMaster as zoneMaster
	 * @return ZoneMaster as model object
	 */
	public ZoneMaster checkForDuplicates(ZoneMaster zoneMaster)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return zoneMasterDAO.checkForDuplicates(zoneMaster);
		
	}
	
	    /**
	 * This method returns list of ZoneMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<ZoneMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return zoneMasterDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of ZoneMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<ZoneMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return zoneMasterDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return zoneMasterDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}

	public List<ZoneMaster> getZoneMasterList(ZoneMasterSearch searchOptions) {

		if (log.isDebugEnabled()) {
			log.debug("getZoneMasterList Method is called");
		}
		return zoneMasterDAO.getZoneMasterList(searchOptions);
	}
	
	public List<ZoneMaster> getZoneMasterListBasedOnCityId(long id){
		if (log.isDebugEnabled()) {
			log.debug("getZoneMasterListBasedOnCityId Method is called");
		}
		return zoneMasterDAO.getZoneMasterListBasedOnCityId(id);
	}
}

