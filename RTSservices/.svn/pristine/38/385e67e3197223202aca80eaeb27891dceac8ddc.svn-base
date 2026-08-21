package com.mars.common.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.WardMaster;
import com.mars.common.search.WardMasterSearch;
/**
 * <p>Title: WardMasterDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for WardMaster</p>

 * @see com.mars.common.model.WardMaster
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface WardMasterDAO {

  
	/**
	 * This method returns WardMaster object for a given Id
	 * 
	 * @param id as long
	 * @return WardMaster as model object
	 */
	public WardMaster get(long id);
		
    
    /**
	 * This method save/updates the WardMaster information to the database.
	 * 
	 * @param WardMaster object
	 * 
	 */
	public void save(WardMaster entity);
	
     /**
	 * This method to merge the WardMaster information to the database.
	 * 
	 * @param WardMaster object
	 * 
	 */
    public WardMaster merge(WardMaster entity);
    
    /**
	 * This method delete WardMaster for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all WardMaster from the database
	 * 
	 * @return List of WardMaster
	 */
	public List<WardMaster> getAll();
	
	/**
     * This method save/updates a list of WardMaster information to the database.
     * 
     * @param listWardMaster as List
     * 
     */
    public void saveAll(List<WardMaster> listWardMaster);
    
    
    /**
     * This method is used to delete a list of WardMaster records from the database.
     * 
     * @param listWardMaster as List
     */
    public void deleteAll(List<WardMaster> listWardMaster);
    
	    /**
		 * This method returns list of the WardMaster objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<WardMaster> getWardMasterList(long pageNumber,String orderBy, String sortBy);
		
		
		/**
		 * This method returns list of the WardMaster objects available based on Search.
		 * 
		 * @param WardMasterSearch searchWardMaster
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<WardMaster> getWardMasterListBySearch(WardMasterSearch searchWardMaster);
		
		
		
		/**
		 * This method returns count of the WardMaster objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getWardMasterCount();
	
		
		/**
		 * This method returns count of the WardMaster objects from the database based on Search
		 * @param WardMasterSearch searchWardMaster
		 * @return long
		 * @exception Exception
		 */
		public long getWardMasterCountBySearch(WardMasterSearch searchWardMaster);
	
	/**
	 * This method returns list of WardMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<WardMaster> findByProperty(String propertyName, Object value);

	/**
	 * This method returns WardMaster object for a given data
	 * 
	 * @param WardMaster as wardMaster
	 * @return WardMaster as model object
	 */
	public WardMaster checkForDuplicates(WardMaster wardMaster);
	
	/**
	 * This method returns list of WardMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WardMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of WardMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WardMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
	public List<WardMaster> getWardList(WardMasterSearch searchOptions);
	
	public long getWardCount(WardMasterSearch searchOptions);
	
	public List<WardMaster> getWardMasterListBasedOnZoneId(long id);



}


