package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.SectorDAO;
import com.mars.common.model.Sector;
import com.mars.common.search.SectorSearch;
import com.mars.common.service.SectorService;
 /**

 * <p>Title: SectorServiceImpl.java </p>

 * @see com.mars.common.model.Sector
 
 * <p>Description: This class is used for hibernate operations for Sector module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
 @Service("sectorService")
public class SectorServiceImpl implements SectorService {

    private static final Log log = LogFactory.getLog(SectorServiceImpl.class);

  	
	@Autowired
	private SectorDAO sectorDAO;

	public void setSectorDAO(SectorDAO sectorDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setSectorDAO Method is called ");
		}
		this.sectorDAO = sectorDAO;
	}

	/**
	 * This method is saves the Sector object
	 * 
	 * @param entity as Sector object
	 * @return
	 * 
	 */
	public void save(Sector entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		sectorDAO.save(entity);
	}

     /**
	 * This method to merge the Sector information to the database.
	 * 
	 * @param Sector object
	 * 
	 */
    public Sector merge(Sector entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return sectorDAO.merge(entity);
	}

	/**
	 * This method delete the sector
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		sectorDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Sector Object
	 * 
	 */
	public Sector get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return sectorDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Sector from the database
	 * 
	 * @return List of Sector
	 */
	public List<Sector> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return sectorDAO.getAll();
	}
	
		/**
		 * This method returns list of the Sector objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Sector> getSectorList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getSectorList Method is called");
			}
			return sectorDAO.getSectorList(pageNumber,orderBy,sortBy);
		}
		
		/**
		 * This method returns list of the Sector objects available based on Search.
		 * 
		 * @param SectorSearch searchSector
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<Sector> getSectorListBySearch(SectorSearch searchSector){
			if(log.isDebugEnabled()){
				log.debug("getSectorListBySearch Method is called");
			}
			
			return sectorDAO.getSectorListBySearch(searchSector);
		}
		
		
		/**
		 * This method returns count of the Sector objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getSectorCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getSectorCount Method is called");
			}
			return sectorDAO.getSectorCount();
		}	
	
		/**
		 * This method returns count of the Sector objects available based on search criteria.
		 * @param SectorSearch searchSector
		 * @return long
		 * @exception Exception
		 */
		public long getSectorCountBySearch(SectorSearch searchSector){
			if(log.isDebugEnabled()){
				log.debug("getSectorCountBySearch Method is called");
			}
			
			return sectorDAO.getSectorCountBySearch(searchSector);
		}
		
		
	/**
     * This method save/updates a list of Sector information to the database.
     * 
     * @param listSector as List
     * 
     */
    public void saveAll(List<Sector> listSector){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		sectorDAO.saveAll(listSector);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listSector as List
     */
    public void deleteAll(List<Sector> listSector){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		sectorDAO.deleteAll(listSector);
    }
    
    /**
	 * This method returns list of Sector objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Sector> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return sectorDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Sector object for a given data
	 * 
	 * @param Sector as sector
	 * @return Sector as model object
	 */
	public Sector checkForDuplicates(Sector sector)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return sectorDAO.checkForDuplicates(sector);
		
	}
	
	    /**
	 * This method returns list of Sector objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Sector> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return sectorDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Sector objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Sector> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return sectorDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return sectorDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
}

