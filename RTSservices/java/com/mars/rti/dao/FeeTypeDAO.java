package com.mars.rti.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.rti.model.FeeType;
import com.mars.rti.search.FeeTypeSearch;
/**
 * <p>Title: CityDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for FeeType</p>

 * @see com.mars.common.model.FeeType
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface FeeTypeDAO {

  
	/**
	 * This method returns FeeType object for a given Id
	 * 
	 * @param id as long
	 * @return FeeType as model object
	 */
	public FeeType get(long id);
		
    
    /**
	 * This method save/updates the FeeType information to the database.
	 * 
	 * @param FeeType object
	 * 
	 */
	public void save(FeeType entity);
	
     /**
	 * This method to merge the FeeType information to the database.
	 * 
	 * @param FeeType object
	 * 
	 */
    public FeeType merge(FeeType entity);
    
    /**
	 * This method delete FeeType for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all FeeType from the database
	 * 
	 * @return List of FeeType
	 */
	public List<FeeType> getAll();
	
	/**
     * This method save/updates a list of FeeType information to the database.
     * 
     * @param listFeeType as List
     * 
     */
    public void saveAll(List<FeeType> listFeeType);
    
    
    /**
     * This method is used to delete a list of FeeType records from the database.
     * 
     * @param listFeeType as List
     */
    public void deleteAll(List<FeeType> listFeeType);
    
	    /**
		 * This method returns list of the FeeType objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<FeeType> getFeeTypeList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the FeeType objects available based on Search.
		 * 
		 * @param FeeTypeSearch searchFeeType
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<FeeType> getFeeTypeListBySearch(FeeTypeSearch searchFeeType);
		
		
		/**
		 * This method returns count of the FeeType objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getFeeTypeCount();
		
		/**
		 * This method returns count of the FeeType objects from the database based on search
		 * @param FeeTypeSearch searchFeeType
		 * @return long
		 * @exception Exception
		 */
		public long getFeeTypeCountBySearch(FeeTypeSearch searchFeeType);
	
	
	/**
	 * This method returns list of FeeType objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<FeeType> findByProperty(String propertyName, Object value);

	/**
	 * This method returns FeeType object for a given data
	 * 
	 * @param FeeType as feeType
	 * @return FeeType as model object
	 */
	public FeeType checkForDuplicates(FeeType feeType);
	
	/**
	 * This method returns list of FeeType objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<FeeType> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of FeeType objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<FeeType> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
}

