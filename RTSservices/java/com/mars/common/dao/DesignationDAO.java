package com.mars.common.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.Designation;
import com.mars.common.search.DesignationSearch;
/**
 * <p>Title: DesignationDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for Designation</p>

 * @see com.mars.common.model.Designation
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface DesignationDAO {

  
	/**
	 * This method returns Designation object for a given Id
	 * 
	 * @param id as long
	 * @return Designation as model object
	 */
	public Designation get(long id);
		
    
    /**
	 * This method save/updates the Designation information to the database.
	 * 
	 * @param Designation object
	 * 
	 */
	public void save(Designation entity);
	
     /**
	 * This method to merge the Designation information to the database.
	 * 
	 * @param Designation object
	 * 
	 */
    public Designation merge(Designation entity);
    
    /**
	 * This method delete Designation for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Designation from the database
	 * 
	 * @return List of Designation
	 */
	public List<Designation> getAll();
	
	/**
     * This method save/updates a list of Designation information to the database.
     * 
     * @param listDesignation as List
     * 
     */
    public void saveAll(List<Designation> listDesignation);
    
    
    /**
     * This method is used to delete a list of Designation records from the database.
     * 
     * @param listDesignation as List
     */
    public void deleteAll(List<Designation> listDesignation);
    
	    /**
		 * This method returns list of the Designation objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Designation> getDesignationList(long pageNumber,String orderBy, String sortBy);
		
		
		/**
		 * This method returns list of the Designation objects available based on Search.
		 * 
		 * @param DesignationSearch searchDesignation
		 * @return List
		 * @exception Exception
		 */
		public List<Designation> getDesignationListBySearch(DesignationSearch searchDesignation);
		
		
		/**
		 * This method returns count of the Designation objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getDesignationCount();
	
	
	    public Long getDesignationCountBySearch(DesignationSearch searchDesignation);

	/**
	 * This method returns list of Designation objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Designation> findByProperty(String propertyName, Object value);

	/**
	 * This method returns Designation object for a given data
	 * 
	 * @param Designation as designation
	 * @return Designation as model object
	 */
	public Designation checkForDuplicates(Designation designation);
	
	/**
	 * This method returns list of Designation objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Designation> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of Designation objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Designation> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
}

