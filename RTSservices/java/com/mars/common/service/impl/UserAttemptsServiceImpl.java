package com.mars.common.service.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.UserAttemptsDAO;
import com.mars.common.model.UserAttempts;
import com.mars.common.service.UserAttemptsService;

/**

* <p>Title: UserAttemptsServiceImpl.java </p>

* @see com.mars.common.model.UserAttempts

* <p>Description: This class is used for hibernate operations for UserAttempts module</p>

* Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

* @version: 1.0

* @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>

*/
 @Service("userAttemptsService")
public class UserAttemptsServiceImpl implements UserAttemptsService  {
	 
	 private static final Log log = LogFactory.getLog(UserAttemptsServiceImpl.class);

	  	
		@Autowired
		private UserAttemptsDAO userAttemptsDAO;

		public void setUserAttemptsDAO(UserAttemptsDAO userAttemptsDAO) {
			if (log.isDebugEnabled()) {
				log.debug("setUserAttemptsDAO Method is called ");
			}
			this.userAttemptsDAO = userAttemptsDAO;
		}

		/**
		 * This method is saves the UserAttempts object
		 * 
		 * @param entity as UserAttempts object
		 * @return
		 * 
		 */
		public void save(UserAttempts entity) {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			userAttemptsDAO.save(entity);
		}

	     /**
		 * This method to merge the UserAttempts information to the database.
		 * 
		 * @param UserAttempts object
		 * 
		 */
	    public UserAttempts merge(UserAttempts entity){
	    		if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return userAttemptsDAO.merge(entity);
		}

		/**
		 * This method delete the userAttempts
		 * 
		 * @param Id as long
		 * @return
		 * 
		 */
		public void delete(long id) {
			if (log.isDebugEnabled()) {
				log.debug("delete Method is called ");
			}
			userAttemptsDAO.delete(id);
		}

		/**
		 * This method is used to get the Model object from the database using
		 * hibernate based on id
		 * 
		 * @param Id as long
		 * @return a UserAttempts Object
		 * 
		 */
		public UserAttempts get(long id) {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called");
			}
			return userAttemptsDAO.get(id);
		}
		
		/**
		 * This method will return a list of all UserAttempts from the database
		 * 
		 * @return List of UserAttempts
		 */
		public List<UserAttempts> getAll() {
			if (log.isDebugEnabled()) {
				log.debug("getAll Method is called");
			}
			return userAttemptsDAO.getAll();
		}
		
			/**
			 * This method returns list of the UserAttempts objects available based page number.
			 * 
			 * @param long PageNumber
			 * @param String orderBy
			 * @param String sortBy
			 * @return List
			 * @exception Exception
			 */
			public List<UserAttempts> getUserAttemptsList(long pageNumber,String orderBy, String sortBy){
			
				if (log.isDebugEnabled()) {
					log.debug("getUserAttemptsList Method is called");
				}
				return userAttemptsDAO.getUserAttemptsList(pageNumber,orderBy,sortBy);
			}
			
			/**
			 * This method returns count of the UserAttempts objects available based on search criteria.
			 * 
			 * @return long
			 * @exception Exception
			 */
			public long getUserAttemptsCount(){
			    if (log.isDebugEnabled()) {
					log.debug("getUserAttemptsCount Method is called");
				}
				return userAttemptsDAO.getUserAttemptsCount();
			}	
			
		/**
	     * This method save/updates a list of UserAttempts information to the database.
	     * 
	     * @param listUserAttempts as List
	     * 
	     */
	    public void saveAll(List<UserAttempts> listUserAttempts){
	    	if (log.isDebugEnabled()) {
				log.debug("saveAll Method is called");
			}
			userAttemptsDAO.saveAll(listUserAttempts);
	    }
	    
	    
	    /**
	     * This method is used to delete a list of Module records from the database.
	     * 
	     * @param listUserAttempts as List
	     */
	    public void deleteAll(List<UserAttempts> listUserAttempts){
	        if (log.isDebugEnabled()) {
				log.debug("deleteAll Method is called");
			}
			userAttemptsDAO.deleteAll(listUserAttempts);
	    }
	    
	    /**
		 * This method returns list of UserAttempts objects available based on the value for a particular property.
		 * @param String propertyName
		 * @param Object value
		 * @return List
		 * @exception Exception
		 */
		public List<UserAttempts> findByProperty(String propertyName, Object value) 
	    {
	    	if (log.isDebugEnabled()) 
	    	{
				log.debug("findByProperty Method is called");
			}
			return userAttemptsDAO.findByProperty(propertyName,value);
	    }
		  /**
		 * This method returns list of UserAttempts objects available based on the query names passed.
		 * @param String namedQuery
		 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
		 * @return List
		 * @exception Exception
		 */
		public List<UserAttempts> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
		{
			if (log.isDebugEnabled()) 
	    	{
				log.debug("getListByNamedQuery Method is called");
			}
			return userAttemptsDAO.getListByNamedQuery(namedQuery,hstKeyValues);
		}


	    /**
		 * This method returns list of UserAttempts objects available based on the SQL query and parameters.
		 * @param String SQL Query
		 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
		 * @return List
		 * @exception Exception
		 */
		public List<UserAttempts> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
		{
			if (log.isDebugEnabled()) 
	    	{
				log.debug("getEntitytListBySQLQuery Method is called");
			}
			return userAttemptsDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
			return userAttemptsDAO.getListBySQLQuery(strSql,hstDataTypes);
			
		}

		@Override
		public UserAttempts getByUserName(String userName) {
			if (log.isDebugEnabled()) 
	    	{
				log.debug("getByUserName Method is called");
			}
			return userAttemptsDAO.getByUserName(userName);
		}

		@Override
		public void delete(UserAttempts userAttempts) {
			if (log.isDebugEnabled()) 
	    	{
				log.debug("delete Method is called");
			}
			 userAttemptsDAO.delete(userAttempts);;
			
		}	
 }	
	
