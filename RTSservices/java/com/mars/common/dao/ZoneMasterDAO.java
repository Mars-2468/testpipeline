package com.mars.common.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.ZoneMaster;
import com.mars.common.search.ZoneMasterSearch;
/**
 * <p>Title: ZoneMasterDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for ZoneMaster</p>

 * @see com.mars.common.model.ZoneMaster
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface ZoneMasterDAO {

  
	/**
	 * This method returns ZoneMaster object for a given Id
	 * 
	 * @param id as long
	 * @return ZoneMaster as model object
	 */
	public ZoneMaster get(long id);
		
    
    /**
	 * This method save/updates the ZoneMaster information to the database.
	 * 
	 * @param ZoneMaster object
	 * 
	 */
	public void save(ZoneMaster entity);
	
     /**
	 * This method to merge the ZoneMaster information to the database.
	 * 
	 * @param ZoneMaster object
	 * 
	 */
    public ZoneMaster merge(ZoneMaster entity);
    
    /**
	 * This method delete ZoneMaster for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all ZoneMaster from the database
	 * 
	 * @return List of ZoneMaster
	 */
	public List<ZoneMaster> getAll();
	
	/**
     * This method save/updates a list of ZoneMaster information to the database.
     * 
     * @param listZoneMaster as List
     * 
     */
    public void saveAll(List<ZoneMaster> listZoneMaster);
    
    
    /**
     * This method is used to delete a list of ZoneMaster records from the database.
     * 
     * @param listZoneMaster as List
     */
    public void deleteAll(List<ZoneMaster> listZoneMaster);
    
	    /**
		 * This method returns list of the ZoneMaster objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<ZoneMaster> getZoneMasterList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the ZoneMaster objects available based on Search
		 * 
		 * @param searchZoneMaster
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<ZoneMaster> getZoneMasterListBySearch(ZoneMasterSearch searchZoneMaster);
		
		
		/**
		 * This method returns count of the ZoneMaster objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getZoneMasterCount();
	
		/**
		 * This method returns count of the ZoneMaster objects from the database based on search
		 * @param searchZoneMaster
		 * @return long
		 * @exception Exception
		 */
		public long getZoneMasterCountBySearch(ZoneMasterSearch searchZoneMaster);
		
	
	/**
	 * This method returns list of ZoneMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<ZoneMaster> findByProperty(String propertyName, Object value);

	/**
	 * This method returns ZoneMaster object for a given data
	 * 
	 * @param ZoneMaster as zoneMaster
	 * @return ZoneMaster as model object
	 */
	public ZoneMaster checkForDuplicates(ZoneMaster zoneMaster);
	
	/**
	 * This method returns list of ZoneMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<ZoneMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of ZoneMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<ZoneMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
	public List<ZoneMaster> getZoneMasterList(ZoneMasterSearch searchOptions);

	public long getZoneMasterCount(ZoneMasterSearch searchOptions);
	
	public List<ZoneMaster> getZoneMasterListBasedOnCityId(long id);


}

