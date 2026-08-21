package com.mars.common.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.City;
import com.mars.common.search.CitySearch;
/**
 * <p>Title: CityDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for City</p>

 * @see com.mars.common.model.City
 
 * Copyright (c) 2008 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface CityDAO {

  
	/**
	 * This method returns City object for a given Id
	 * 
	 * @param id as long
	 * @return City as model object
	 */
	public City get(long id);
		
    
    /**
	 * This method save/updates the City information to the database.
	 * 
	 * @param City object
	 * 
	 */
	public void save(City entity);
	
     /**
	 * This method to merge the City information to the database.
	 * 
	 * @param City object
	 * 
	 */
    public City merge(City entity);
    
    /**
	 * This method delete City for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all City from the database
	 * 
	 * @return List of City
	 */
	public List<City> getAll();
	
	/**
     * This method save/updates a list of City information to the database.
     * 
     * @param listCity as List
     * 
     */
    public void saveAll(List<City> listCity);
    
    
    /**
     * This method is used to delete a list of City records from the database.
     * 
     * @param listCity as List
     */
    public void deleteAll(List<City> listCity);
    
	    /**
		 * This method returns list of the City objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<City> getCityList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the City objects available based on Search.
		 * 
		 * @param CitySearch searchCity
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<City> getCityListBySearch(CitySearch searchCity);
		
		
		/**
		 * This method returns count of the City objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getCityCount();
		
		/**
		 * This method returns count of the City objects from the database based on search
		 * @param CitySearch searchCity
		 * @return long
		 * @exception Exception
		 */
		public long getCityCountBySearch(CitySearch searchCity);
	
	
	/**
	 * This method returns list of City objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<City> findByProperty(String propertyName, Object value);

	/**
	 * This method returns City object for a given data
	 * 
	 * @param City as city
	 * @return City as model object
	 */
	public City checkForDuplicates(City city);
	
	/**
	 * This method returns list of City objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<City> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of City objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<City> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);


	public List<City> getAllByTenancy(long tenancyId);
	
	public City getByName(String name);
	public City getByTenancyId(long tenancyId);
    
}

