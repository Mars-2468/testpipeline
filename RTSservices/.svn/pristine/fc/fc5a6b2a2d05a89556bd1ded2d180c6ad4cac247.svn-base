package com.mars.common.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.CityCategory;
/**
* <p>Title: CityCategoryService.java </p>

 * <p>Description: This interface is used for service implementations related to CityCategory</p>

 * @see com.mars.pis.model.CityCategory
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface CityCategoryService {
  
	/**
	 * This method returns CityCategory object for a given Id
	 * 
	 * @param id as long
	 * @return CityCategory as model object
	 */
	public CityCategory get(long id);
		
    /**
	 * This method save/updates the CityCategory information to the database.
	 * 
	 * @param CityCategory object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(CityCategory entity);
	  
	/**
	 * This method to merge the CityCategory information to the database.
	 * 
	 * @param CityCategory object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public CityCategory merge(CityCategory entity); 
	    
    /**
	 * This method delete CityCategory for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all CityCategory from the database
	 * 
	 * @return List of CityCategory
	 */
	public List<CityCategory> getAll();
	
	/**
     * This method save/updates a list of CityCategory information to the database.
     * 
     * @param listCityCategory as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<CityCategory> listCityCategory);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listCityCategory as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<CityCategory> listCityCategory);
    
	    /**
		 * This method returns list of the CityCategory objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<CityCategory> getCityCategoryList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns count of the CityCategory objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getCityCategoryCount();
	
	
	/**
	 * This method returns list of CityCategory objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<CityCategory> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns CityCategory object for a given data
	 * 
	 * @param CityCategory as cityCategory
	 * @return CityCategory as model object
	 */
	public CityCategory checkForDuplicates(CityCategory cityCategory);    

    /**
	 * This method returns list of CityCategory objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<CityCategory> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of CityCategory objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<CityCategory> getListByHqlQuery(String hqlQuery);
	
    /**
	 * This method returns list of CityCategory objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<CityCategory> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked") 
	 public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
}

