package com.mars.common.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.UserAttempts;


/**
* <p>Title: UserAttemptsService.java </p>

 * <p>Description: This interface is used for service implementations related to UserAttempts</p>

 * @see com.mars.common.model.UserAttempts
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface UserAttemptsService {
	
	/**
	 * This method returns UserAttempts object for a given Id
	 * 
	 * @param id as long
	 * @return UserAttempts as model object
	 */
	public UserAttempts get(long id);
		
    /**
	 * This method save/updates the UserAttempts information to the database.
	 * 
	 * @param UserAttempts object
	 * 
	 */
   @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(UserAttempts entity);
	  
	/**
	 * This method to merge the UserAttempts information to the database.
	 * 
	 * @param UserAttempts object
	 * 
	 */
   @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public UserAttempts merge(UserAttempts entity); 
	    
    /**
	 * This method delete UserAttempts for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	 
	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	 public void delete(UserAttempts userAttempts);
	
	/**
	 * This method will return a list of all UserAttempts from the database
	 * 
	 * @return List of UserAttempts
	 */
	public List<UserAttempts> getAll();
	
	/**
     * This method save/updates a list of UserAttempts information to the database.
     * 
     * @param listUserAttempts as List
     * 
     */
	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<UserAttempts> listUserAttempts);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listUserAttempts as List
     */
	 @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<UserAttempts> listUserAttempts);
    
    /**
	 * This method returns list of the UserAttempts objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<UserAttempts> getUserAttemptsList(long pageNumber,String orderBy, String sortBy);
	
	
	/**
	 * This method returns count of the UserAttempts objects from the database
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getUserAttemptsCount();
	
	/**
	 * This method returns list of UserAttempts objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<UserAttempts> findByProperty(String propertyName, Object value);	    

    /**
	 * This method returns list of UserAttempts objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<UserAttempts> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of UserAttempts objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<UserAttempts> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);

	 public UserAttempts getByUserName(String  userName); 



}
