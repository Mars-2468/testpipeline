package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.UserApplicationDAO;
import com.mars.common.model.UserApplication;
import com.mars.common.service.UserApplicationService;
 /**

 * <p>Title: UserApplicationServiceImpl.java </p>

 * @see com.mars.common.model.UserApplication
 
 * <p>Description: This class is used for hibernate operations for UserApplication module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("userApplicationService") 
public class UserApplicationServiceImpl implements UserApplicationService {

    private static final Log log = LogFactory.getLog(UserApplicationServiceImpl.class);

  	
	@Autowired
	private UserApplicationDAO userApplicationDAO;

	public void setUserApplicationDAO(UserApplicationDAO userApplicationDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setUserApplicationDAO Method is called ");
		}
		this.userApplicationDAO = userApplicationDAO;
	}

	/**
	 * This method is saves the UserApplication object
	 * 
	 * @param entity as UserApplication object
	 * @return
	 * 
	 */
	public void save(UserApplication entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		userApplicationDAO.save(entity);
	}

     /**
	 * This method to merge the UserApplication information to the database.
	 * 
	 * @param UserApplication object
	 * 
	 */
    public UserApplication merge(UserApplication entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return userApplicationDAO.merge(entity);
	}

	/**
	 * This method delete the userApplication
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		userApplicationDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a UserApplication Object
	 * 
	 */
	public UserApplication get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return userApplicationDAO.get(id);
	}
	
	/**
	 * This method will return a list of all UserApplication from the database
	 * 
	 * @return List of UserApplication
	 */
	public List<UserApplication> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return userApplicationDAO.getAll();
	}
	
		/**
		 * This method returns list of the UserApplication objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<UserApplication> getUserApplicationList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getUserApplicationList Method is called");
			}
			return userApplicationDAO.getUserApplicationList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * This method returns count of the UserApplication objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getUserApplicationCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getUserApplicationCount Method is called");
			}
			return userApplicationDAO.getUserApplicationCount();
		}	
	
	
	/**
     * This method save/updates a list of UserApplication information to the database.
     * 
     * @param listUserApplication as List
     * 
     */
    public void saveAll(List<UserApplication> listUserApplication){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		userApplicationDAO.saveAll(listUserApplication);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listUserApplication as List
     */
    public void deleteAll(List<UserApplication> listUserApplication){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		userApplicationDAO.deleteAll(listUserApplication);
    }
    
    /**
	 * This method returns list of UserApplication objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<UserApplication> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return userApplicationDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns UserApplication object for a given data
	 * 
	 * @param UserApplication as userApplication
	 * @return UserApplication as model object
	 */
	public UserApplication checkForDuplicates(UserApplication userApplication)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return userApplicationDAO.checkForDuplicates(userApplication);
		
	}
	
	    /**
	 * This method returns list of UserApplication objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<UserApplication> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return userApplicationDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of UserApplication objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<UserApplication> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return userApplicationDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return userApplicationDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	public List<UserApplication> getUserApplicationForUser(long userId)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getUserApplicationForUser Method is called");
		}
		return userApplicationDAO.getUserApplicationForUser(userId);
	}
	public void deleteByUserId(long userId, String applicationIds)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("deleteByUserId Method is called");
		}
		userApplicationDAO.deleteByUserId(userId, applicationIds);
	}

	
}


