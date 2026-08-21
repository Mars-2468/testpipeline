package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.ApplicationDAO;
import com.mars.common.model.Application;
import com.mars.common.search.ApplicationSearch;
import com.mars.common.service.ApplicationService;

/**

* <p>Title: ApplicationServiceImpl.java </p>

* @see com.mars.common.model.Bank

* <p>Description: This class is used for hibernate operations for Bank module</p>

* Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

* @version: 1.0

* @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>

*/
@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {

    private static final Log log = LogFactory.getLog(ApplicationServiceImpl.class);

  	
	@Autowired
	private ApplicationDAO applicationDAO;

	public void setApplicationDAO(ApplicationDAO applicationDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setApplicationDAO Method is called ");
		}
		this.applicationDAO = applicationDAO;
	}

	/**
	 * This method is saves the Application object
	 * 
	 * @param entity as Application object
	 * @return
	 * 
	 */
	public void save(Application entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		applicationDAO.save(entity);
	}

     /**
	 * This method to merge the Application information to the database.
	 * 
	 * @param Application object
	 * 
	 */
    public Application merge(Application entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return applicationDAO.merge(entity);
	}

	/**
	 * This method delete the application
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		applicationDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Application Object
	 * 
	 */
	public Application get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return applicationDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Application from the database
	 * 
	 * @return List of Application
	 */
	public List<Application> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return applicationDAO.getAll();
	}
	
		/**
		 * This method returns list of the Application objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Application> getApplicationList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getApplicationList Method is called");
			}
			return applicationDAO.getApplicationList(pageNumber,orderBy,sortBy);
		}
		
		
		
		/**
		 * 
		 * @param searchOptions
		 * @return
		 */
			public List<Application> getApplicationListBySearch(ApplicationSearch searchApplication){

			if (log.isDebugEnabled()) {
				log.debug("getApplicationListBySearch Method is called");
			}
			return applicationDAO.getApplicationListBySearch(searchApplication);
			
		}
		
		
		
		
		/**
		 * This method returns count of the Application objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getApplicationCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getApplicationCount Method is called");
			}
			return applicationDAO.getApplicationCount();
		}	
	
	
	/**
     * This method save/updates a list of Application information to the database.
     * 
     * @param listApplication as List
     * 
     */
    public void saveAll(List<Application> listApplication){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		applicationDAO.saveAll(listApplication);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listApplication as List
     */
    public void deleteAll(List<Application> listApplication){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		applicationDAO.deleteAll(listApplication);
    }
    
    /**
	 * This method returns list of Application objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Application> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return applicationDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Application object for a given data
	 * 
	 * @param Application as application
	 * @return Application as model object
	 */
	public Application checkForDuplicates(Application application)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return applicationDAO.checkForDuplicates(application);
		
	}
	
	    /**
	 * This method returns list of Application objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Application> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return applicationDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Application objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Application> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return applicationDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return applicationDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}

	public Long getApplicationCountBySearch(ApplicationSearch searchApplication) {
		if (log.isDebugEnabled()) 
    	{
			log.debug("getApplicationCountBySearch Method is called");
		}
		return applicationDAO.getApplicationCountBySearch(searchApplication);
	}	
}


