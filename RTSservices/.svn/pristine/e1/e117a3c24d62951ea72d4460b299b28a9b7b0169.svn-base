package com.mars.common.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.Tenancy;
import com.mars.common.search.TenancySearch;
/**
* <p>Title: TenancyService.java </p>

 * <p>Description: This interface is used for service implementations related to Tenancy</p>

 * @see com.mars.common.model.Tenancy
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface TenancyService {
  
	/**
	 * This method returns Tenancy object for a given Id
	 * 
	 * @param id as long
	 * @return Tenancy as model object
	 */
	public Tenancy get(long id);
		
    /**
	 * This method save/updates the Tenancy information to the database.
	 * 
	 * @param Tenancy object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(Tenancy entity);
	  
	/**
	 * This method to merge the Tenancy information to the database.
	 * 
	 * @param Tenancy object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public Tenancy merge(Tenancy entity); 
	    
    /**
	 * This method delete Tenancy for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Tenancy from the database
	 * 
	 * @return List of Tenancy
	 */
	public List<Tenancy> getAll();
	
	/**
     * This method save/updates a list of Tenancy information to the database.
     * 
     * @param listTenancy as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Tenancy> listTenancy);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listTenancy as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Tenancy> listTenancy);
    
	    /**
		 * This method returns list of the Tenancy objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Tenancy> getTenancyList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the Tenancy objects available based on Search.
		 * 
		 * @param TenancySearch searchTenancy
		 * @return List
		 */
		public List<Tenancy> getTenancyListBySearch(TenancySearch searchTenancy); 
		
		/**
		 * This method returns count of the Tenancy objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getTenancyCount();
		
		/**
		 * This method returns count of the Tenancy objects from the database
		 * @param TenancySearch SearchTenancy
		 * @return long
		 * @exception Exception
		 */
		public long getTenancyCountBySearch(TenancySearch searchTenancy);
	
	
	/**
	 * This method returns list of Tenancy objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Tenancy> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns Tenancy object for a given data
	 * 
	 * @param Tenancy as tenancy
	 * @return Tenancy as model object
	 */
	public Tenancy checkForDuplicates(Tenancy tenancy);    

    /**
	 * This method returns list of Tenancy objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Tenancy> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Tenancy objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Tenancy> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
	
	public String getTenancyId(String tenancyName);
	
}

