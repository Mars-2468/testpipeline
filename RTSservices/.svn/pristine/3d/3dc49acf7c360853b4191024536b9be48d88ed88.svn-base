package com.mars.common.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.Section;
import com.mars.common.search.SectionSearch;
/**
 * <p>Title: SectionDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for Section</p>

 * @see com.mars.common.model.Section
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface SectionDAO {

  
	/**
	 * This method returns Section object for a given Id
	 * 
	 * @param id as long
	 * @return Section as model object
	 */
	public Section get(long id);
		
    
    /**
	 * This method save/updates the Section information to the database.
	 * 
	 * @param Section object
	 * 
	 */
	public void save(Section entity);
	
     /**
	 * This method to merge the Section information to the database.
	 * 
	 * @param Section object
	 * 
	 */
    public Section merge(Section entity);
    
    /**
	 * This method delete Section for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Section from the database
	 * 
	 * @return List of Section
	 */
	public List<Section> getAll();
	
	/**
     * This method save/updates a list of Section information to the database.
     * 
     * @param listSection as List
     * 
     */
    public void saveAll(List<Section> listSection);
    
    
    /**
     * This method is used to delete a list of Section records from the database.
     * 
     * @param listSection as List
     */
    public void deleteAll(List<Section> listSection);
    
	    /**
		 * This method returns list of the Section objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Section> getSectionList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the Section objects available based on Search.
		 * 
		 * @param SectionSearch searchSection
		 * @return List
		 * @exception Exception
		 */
		public List<Section> getSectionListBySearch(SectionSearch searchSection);
		
		
		
		
		/**
		 * This method returns count of the Section objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getSectionCount();
	
	
	    public long getSectionCountBySearch(SectionSearch searchSection);

		
	/**
	 * This method returns list of Section objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Section> findByProperty(String propertyName, Object value);

	/**
	 * This method returns Section object for a given data
	 * 
	 * @param Section as department
	 * @return Section as model object
	 */
	public Section checkForDuplicates(Section department);
	
	/**
	 * This method returns list of Section objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Section> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of Section objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Section> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
}

