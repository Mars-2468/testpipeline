package com.mars.common.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.UserApplication;
/**
 * <p>Title: UserApplicationDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for UserApplication</p>

 * @see com.mars.common.model.UserApplication
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface UserApplicationDAO {

  
	/**
	 * This method returns UserApplication object for a given Id
	 * 
	 * @param id as long
	 * @return UserApplication as model object
	 */
	public UserApplication get(long id);
		
    
    /**
	 * This method save/updates the UserApplication information to the database.
	 * 
	 * @param UserApplication object
	 * 
	 */
	public void save(UserApplication entity);
	
     /**
	 * This method to merge the UserApplication information to the database.
	 * 
	 * @param UserApplication object
	 * 
	 */
    public UserApplication merge(UserApplication entity);
    
    /**
	 * This method delete UserApplication for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all UserApplication from the database
	 * 
	 * @return List of UserApplication
	 */
	public List<UserApplication> getAll();
	
	/**
     * This method save/updates a list of UserApplication information to the database.
     * 
     * @param listUserApplication as List
     * 
     */
    public void saveAll(List<UserApplication> listUserApplication);
    
    
    /**
     * This method is used to delete a list of UserApplication records from the database.
     * 
     * @param listUserApplication as List
     */
    public void deleteAll(List<UserApplication> listUserApplication);
    
	    /**
		 * This method returns list of the UserApplication objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<UserApplication> getUserApplicationList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns count of the UserApplication objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getUserApplicationCount();
	
	
	/**
	 * This method returns list of UserApplication objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<UserApplication> findByProperty(String propertyName, Object value);

	/**
	 * This method returns UserApplication object for a given data
	 * 
	 * @param UserApplication as userApplication
	 * @return UserApplication as model object
	 */
	public UserApplication checkForDuplicates(UserApplication userApplication);
	
	/**
	 * This method returns list of UserApplication objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<UserApplication> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of UserApplication objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<UserApplication> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	public List<UserApplication> getUserApplicationForUser(long userId);
	public void deleteByUserId(long userId, String applicationIds);
}


