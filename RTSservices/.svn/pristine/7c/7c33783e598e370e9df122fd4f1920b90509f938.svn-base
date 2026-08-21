package com.mars.rti.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.rti.model.FeeMaster;
import com.mars.rti.search.FeeMasterSearch;
/**
 * <p>Title: CityDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for FeeMaster</p>

 * @see com.mars.common.model.FeeMaster
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface FeeMasterDAO {

  
	/**
	 * This method returns FeeMaster object for a given Id
	 * 
	 * @param id as long
	 * @return FeeMaster as model object
	 */
	public FeeMaster get(long id);
		
    
    /**
	 * This method save/updates the FeeMaster information to the database.
	 * 
	 * @param FeeMaster object
	 * 
	 */
	public void save(FeeMaster entity);
	
     /**
	 * This method to merge the FeeMaster information to the database.
	 * 
	 * @param FeeMaster object
	 * 
	 */
    public FeeMaster merge(FeeMaster entity);
    
    /**
	 * This method delete FeeMaster for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all FeeMaster from the database
	 * 
	 * @return List of FeeMaster
	 */
	public List<FeeMaster> getAll();
	
	/**
     * This method save/updates a list of FeeMaster information to the database.
     * 
     * @param listFeeMaster as List
     * 
     */
    public void saveAll(List<FeeMaster> listFeeMaster);
    
    
    /**
     * This method is used to delete a list of FeeMaster records from the database.
     * 
     * @param listFeeMaster as List
     */
    public void deleteAll(List<FeeMaster> listFeeMaster);
    
	    /**
		 * This method returns list of the FeeMaster objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<FeeMaster> getFeeMasterList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the FeeMaster objects available based on Search.
		 * 
		 * @param FeeMasterSearch searchFeeMaster
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<FeeMaster> getFeeMasterListBySearch(FeeMasterSearch searchFeeMaster);
		
		
		/**
		 * This method returns count of the FeeMaster objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getFeeMasterCount();
		
		/**
		 * This method returns count of the FeeMaster objects from the database based on search
		 * @param FeeMasterSearch searchFeeMaster
		 * @return long
		 * @exception Exception
		 */
		public long getFeeMasterCountBySearch(FeeMasterSearch searchFeeMaster);
	
	
	/**
	 * This method returns list of FeeMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<FeeMaster> findByProperty(String propertyName, Object value);

	/**
	 * This method returns FeeMaster object for a given data
	 * 
	 * @param FeeMaster as feeMaster
	 * @return FeeMaster as model object
	 */
	public List checkForDuplicates(FeeMaster feeMaster);
	
	/**
	 * This method returns list of FeeMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<FeeMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of FeeMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<FeeMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
	public FeeMaster getAmount();	
	
	public FeeMaster getApplicationCopyFeeDetails(String createdDate,int feeCategory);
	
	public FeeMaster getApplicationFeeDetails();
}

