package com.mars.common.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.Sector;
import com.mars.common.model.Ward;
import com.mars.common.model.WardSector;
import com.mars.common.search.WardSearch;
/**
* <p>Title: WardService.java </p>

 * <p>Description: This interface is used for service implementations related to Ward</p>

 * @see com.mars.common.model.Ward
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface WardService {
  
	/**
	 * This method returns Ward object for a given Id
	 * 
	 * @param id as long
	 * @return Ward as model object
	 */
	public Ward get(long id);
		
    /**
	 * This method save/updates the Ward information to the database.
	 * 
	 * @param Ward object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(Ward entity);
	  
	/**
	 * This method to merge the Ward information to the database.
	 * 
	 * @param Ward object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public Ward merge(Ward entity); 
	    
    /**
	 * This method delete Ward for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Ward from the database
	 * 
	 * @return List of Ward
	 */
	public List<Ward> getAll();
	
	/**
     * This method save/updates a list of Ward information to the database.
     * 
     * @param listWard as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Ward> listWard);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listWard as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Ward> listWard);
    
	    /**
		 * This method returns list of the Ward objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Ward> getWardList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the Ward objects available based on Search
		 * 
		 * @param WardSearch searchWard
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<Ward> getWardListBySearch(WardSearch searchWard);
		
		
		/**
		 * This method returns count of the Ward objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getWardCount();
		
		
		/**
		 * This method returns count of the Ward objects from the database based on search
		 * @param WardSearch searchWard
		 * @return long
		 * @exception Exception
		 */
		public long getWardCountBySearch(WardSearch searchWard);
	
	
	/**
	 * This method returns list of Ward objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Ward> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns Ward object for a given data
	 * 
	 * @param Ward as ward
	 * @return Ward as model object
	 */
	public Ward checkForDuplicates(Ward ward);    

    /**
	 * This method returns list of Ward objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Ward> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Ward objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Ward> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveWardSectors(Ward ward,Set<WardSector> wardSectorSet,String deletedWardSectorIds);
	
	public List<Sector> getSectorsOnWard(long wardId);
	
	public List<Sector> getSectorsOnWardAndNode(long wardId,long nodeMasterId);
}

