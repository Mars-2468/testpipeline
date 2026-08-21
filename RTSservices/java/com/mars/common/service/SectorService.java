package com.mars.common.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.Sector;
import com.mars.common.search.SectorSearch;
/**
* <p>Title: SectorService.java </p>

 * <p>Description: This interface is used for service implementations related to Sector</p>

 * @see com.mars.common.model.Sector
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface SectorService {
  
	/**
	 * This method returns Sector object for a given Id
	 * 
	 * @param id as long
	 * @return Sector as model object
	 */
	public Sector get(long id);
		
    /**
	 * This method save/updates the Sector information to the database.
	 * 
	 * @param Sector object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(Sector entity);
	  
	/**
	 * This method to merge the Sector information to the database.
	 * 
	 * @param Sector object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public Sector merge(Sector entity); 
	    
    /**
	 * This method delete Sector for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Sector from the database
	 * 
	 * @return List of Sector
	 */
	public List<Sector> getAll();
	
	/**
     * This method save/updates a list of Sector information to the database.
     * 
     * @param listSector as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Sector> listSector);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listSector as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Sector> listSector);
    
	    /**
		 * This method returns list of the Sector objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Sector> getSectorList(long pageNumber,String orderBy, String sortBy);
		
		
		/**
		 * This method returns list of the Sector objects available based on Search.
		 * 
		 * @param SectorSearch searchSector 
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<Sector> getSectorListBySearch(SectorSearch searchSector);
		
		/**
		 * This method returns count of the Sector objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getSectorCount();
		
		
		/**
		 * This method returns count of the Sector objects from the database based on search
		 * @param SectorSearch searchSector
		 * @return long
		 * @exception Exception
		 */
		public long getSectorCountBySearch(SectorSearch searchSector);
	
	
	/**
	 * This method returns list of Sector objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Sector> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns Sector object for a given data
	 * 
	 * @param Sector as sector
	 * @return Sector as model object
	 */
	public Sector checkForDuplicates(Sector sector);    

    /**
	 * This method returns list of Sector objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Sector> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Sector objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Sector> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
}

