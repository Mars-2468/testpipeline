package com.mars.common.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.Salutation;
/**
 * <p>Title: SalutationDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for Salutation</p>

 * @see com.mars.property.model.Salutation
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface SalutationDAO {

  
	/**
	 * This method returns Salutation object for a given Id
	 * 
	 * @param id as long
	 * @return Salutation as model object
	 */
	public Salutation get(long id);
		
    
    /**
	 * This method save/updates the Salutation information to the database.
	 * 
	 * @param Salutation object
	 * 
	 */
	public void save(Salutation entity);
	
     /**
	 * This method to merge the Salutation information to the database.
	 * 
	 * @param Salutation object
	 * 
	 */
    public Salutation merge(Salutation entity);
    
    /**
	 * This method delete Salutation for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Salutation from the database
	 * 
	 * @return List of Salutation
	 */
	public List<Salutation> getAll();
	
	/**
     * This method save/updates a list of Salutation information to the database.
     * 
     * @param listSalutation as List
     * 
     */
    public void saveAll(List<Salutation> listSalutation);
    
    
    /**
     * This method is used to delete a list of Salutation records from the database.
     * 
     * @param listSalutation as List
     */
    public void deleteAll(List<Salutation> listSalutation);
    
	    /**
		 * This method returns list of the Salutation objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Salutation> getSalutationList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns count of the Salutation objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getSalutationCount();
	
	
	/**
	 * This method returns list of Salutation objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Salutation> findByProperty(String propertyName, Object value);

	/**
	 * This method returns Salutation object for a given data
	 * 
	 * @param Salutation as salutation
	 * @return Salutation as model object
	 */
	public Salutation checkForDuplicates(Salutation salutation);
	
	/**
	 * This method returns list of Salutation objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Salutation> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of Salutation objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Salutation> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
}

