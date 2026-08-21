package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.WardDAO;
import com.mars.common.model.Sector;
import com.mars.common.model.Ward;
import com.mars.common.model.WardSector;
import com.mars.common.search.WardSearch;
import com.mars.common.service.WardService;
 /**

 * <p>Title: WardServiceImpl.java </p>

 * @see com.mars.common.model.Ward
 
 * <p>Description: This class is used for hibernate operations for Ward module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("wardService") 
public class WardServiceImpl implements WardService {

    private static final Log log = LogFactory.getLog(WardServiceImpl.class);

  	
	@Autowired
	private WardDAO wardDAO;

	public void setWardDAO(WardDAO wardDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setWardDAO Method is called ");
		}
		this.wardDAO = wardDAO;
	}

	/**
	 * This method is saves the Ward object
	 * 
	 * @param entity as Ward object
	 * @return
	 * 
	 */
	public void save(Ward entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		wardDAO.save(entity);
	}

     /**
	 * This method to merge the Ward information to the database.
	 * 
	 * @param Ward object
	 * 
	 */
    public Ward merge(Ward entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return wardDAO.merge(entity);
	}

	/**
	 * This method delete the ward
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		wardDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Ward Object
	 * 
	 */
	public Ward get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return wardDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Ward from the database
	 * 
	 * @return List of Ward
	 */
	public List<Ward> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return wardDAO.getAll();
	}
	
		/**
		 * This method returns list of the Ward objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Ward> getWardList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getWardList Method is called");
			}
			return wardDAO.getWardList(pageNumber,orderBy,sortBy);
		}
		
		/**
		 * This method returns list of the Ward objects available based on Search.
		 * 
		 * @param WardSearch searchWard
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<Ward> getWardListBySearch(WardSearch searchWard){
			if(log.isDebugEnabled()){
				log.debug("getWardListBySearch Method is called");
			}
			
			return wardDAO.getWardListBySearch(searchWard);
		}
		
		
		/**
		 * This method returns count of the Ward objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getWardCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getWardCount Method is called");
			}
			return wardDAO.getWardCount();
		}	
		
		/**
		 * This method returns count of the Ward objects available based on search criteria.
		 * @param WardSearch searchWard
		 * @return long
		 * @exception Exception
		 */
		public long getWardCountBySearch(WardSearch searchWard){
			if(log.isDebugEnabled()){
				log.debug("getWardCountBySearch Method is called");
			}
			
			return wardDAO.getWardCountBySearch(searchWard);
		}
	
	
	/**
     * This method save/updates a list of Ward information to the database.
     * 
     * @param listWard as List
     * 
     */
    public void saveAll(List<Ward> listWard){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		wardDAO.saveAll(listWard);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listWard as List
     */
    public void deleteAll(List<Ward> listWard){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		wardDAO.deleteAll(listWard);
    }
    
    /**
	 * This method returns list of Ward objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Ward> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return wardDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Ward object for a given data
	 * 
	 * @param Ward as ward
	 * @return Ward as model object
	 */
	public Ward checkForDuplicates(Ward ward)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return wardDAO.checkForDuplicates(ward);
		
	}
	
	    /**
	 * This method returns list of Ward objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Ward> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return wardDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Ward objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Ward> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return wardDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return wardDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	
	public void saveWardSectors(Ward ward,Set<WardSector> wardSectorSet,String deletedWardSectorIds)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("saveWardSectors Method is called");
		}
		wardDAO.saveWardSectors(ward,wardSectorSet,deletedWardSectorIds);
	}
	
	public List<Sector>getSectorsOnWard(long wardId)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getSectorsOnWard Method is called");
		}
		return wardDAO.getSectorsOnWard(wardId);		
	}
	
	public List<Sector> getSectorsOnWardAndNode(long wardId,long nodeMasterId)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getSectorsOnWardAndNode Method is called");
		}
		return wardDAO.getSectorsOnWardAndNode(wardId,nodeMasterId);	
	}
}

