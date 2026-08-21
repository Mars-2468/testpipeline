package com.mars.common.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.Application;
import com.mars.common.search.ApplicationSearch;
/**
 * <p>Title: ApplicationDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for Application</p>

 * @see com.mars.common.model.Application
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface ApplicationDAO {

  
	/**
	 * This method returns Application object for a given Id
	 * 
	 * @param id as long
	 * @return Application as model object
	 */
	public Application get(long id);
		
    
    /**
	 * This method save/updates the Application information to the database.
	 * 
	 * @param Application object
	 * 
	 */
	public void save(Application entity);
	
     /**
	 * This method to merge the Application information to the database.
	 * 
	 * @param Application object
	 * 
	 */
    public Application merge(Application entity);
    
    /**
	 * This method delete Application for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Application from the database
	 * 
	 * @return List of Application
	 */
	public List<Application> getAll();
	
	/**
     * This method save/updates a list of Application information to the database.
     * 
     * @param listApplication as List
     * 
     */
    public void saveAll(List<Application> listApplication);
    
    
    /**
     * This method is used to delete a list of Application records from the database.
     * 
     * @param listApplication as List
     */
    public void deleteAll(List<Application> listApplication);
    
	    /**
		 * This method returns list of the Application objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Application> getApplicationList(long pageNumber,String orderBy, String sortBy);
		
		
		/**
		 * This method returns list of the Application objects available based on Search.
		 * 
		 * @param ApplicationSearch ApplicationBank
		 * @return List
		 * @exception Exception
		 */
		public List<Application> getApplicationListBySearch(ApplicationSearch searchApplication);
		
		
		
		/**
		 * This method returns count of the Application objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getApplicationCount();
	
	
	/**
	 * This method returns list of Application objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
		
    public Long getApplicationCountBySearch(ApplicationSearch searchApplication);

		
		
    public List<Application> findByProperty(String propertyName, Object value);

	/**
	 * This method returns Application object for a given data
	 * 
	 * @param Application as application
	 * @return Application as model object
	 */
	public Application checkForDuplicates(Application application);
	
	/**
	 * This method returns list of Application objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Application> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of Application objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Application> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
}


