package com.mars.common.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.Dictionary;
/**
* <p>Title: DictionaryService.java </p>

 * <p>Description: This interface is used for service implementations related to Dictionary</p>

 * @see com.mars.property.model.Dictionary
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface DictionaryService {
  
	/**
	 * This method returns Dictionary object for a given Id
	 * 
	 * @param id as long
	 * @return Dictionary as model object
	 */
	public Dictionary get(long id);
		
    /**
	 * This method save/updates the Dictionary information to the database.
	 * 
	 * @param Dictionary object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(Dictionary entity);
	  
	/**
	 * This method to merge the Dictionary information to the database.
	 * 
	 * @param Dictionary object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public Dictionary merge(Dictionary entity); 
	    
    /**
	 * This method delete Dictionary for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Dictionary from the database
	 * 
	 * @return List of Dictionary
	 */
	public List<Dictionary> getAll();
	
	/**
     * This method save/updates a list of Dictionary information to the database.
     * 
     * @param listDictionary as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Dictionary> listDictionary);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listDictionary as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Dictionary> listDictionary);
    
	    /**
		 * This method returns list of the Dictionary objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Dictionary> getDictionaryList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns count of the Dictionary objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getDictionaryCount();
	
	
	/**
	 * This method returns list of Dictionary objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Dictionary> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns Dictionary object for a given data
	 * 
	 * @param Dictionary as dictionary
	 * @return Dictionary as model object
	 */
	public Dictionary checkForDuplicates(Dictionary dictionary);    

    /**
	 * This method returns list of Dictionary objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Dictionary> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Dictionary objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Dictionary> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
	
	public Dictionary getObjectBykey(String key);
	
	public String getValueByKey(String key);
}

