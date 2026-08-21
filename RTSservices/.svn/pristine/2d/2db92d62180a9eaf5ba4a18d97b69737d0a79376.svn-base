package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.CityDAO;
import com.mars.common.model.City;
import com.mars.common.search.CitySearch;
import com.mars.common.service.CityService;
 /**

 * <p>Title: CityServiceImpl.java </p>

 * @see com.mars.common.model.City
 
 * <p>Description: This class is used for hibernate operations for City module</p>

 * Copyright (c) 2008 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("cityService")
public class CityServiceImpl implements CityService {

    private static final Log log = LogFactory.getLog(CityServiceImpl.class);

  	
	@Autowired
	private CityDAO cityDAO;

	public void setCityDAO(CityDAO cityDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setCityDAO Method is called ");
		}
		this.cityDAO = cityDAO;
	}

	/**
	 * This method is saves the City object
	 * 
	 * @param entity as City object
	 * @return
	 * 
	 */
	public void save(City entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		cityDAO.save(entity);
	}

     /**
	 * This method to merge the City information to the database.
	 * 
	 * @param City object
	 * 
	 */
    public City merge(City entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return cityDAO.merge(entity);
	}

	/**
	 * This method delete the city
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		cityDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a City Object
	 * 
	 */
	public City get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return cityDAO.get(id);
	}
	
	/**
	 * This method will return a list of all City from the database
	 * 
	 * @return List of City
	 */
	public List<City> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return cityDAO.getAll();
	}
	
		/**
		 * This method returns list of the City objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<City> getCityList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getCityList Method is called");
			}
			return cityDAO.getCityList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * This method returns list of the City objects available based on Search.
		 * 
		 * @param CitySearch searchCity
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<City> getCityListBySearch(CitySearch searchCity){
			if(log.isDebugEnabled()){
				log.debug("getCityListBySerach Method is called");
			}
			
			return cityDAO.getCityListBySearch(searchCity);
		}
		
		
		/**
		 * This method returns count of the City objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getCityCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getCityCount Method is called");
			}
			return cityDAO.getCityCount();
		}	
		
		/**
		 * This method returns count of the City objects available based on search criteria.
		 * @param CitySearch searchCity
		 * @return long
		 * @exception Exception
		 */
		public long getCityCountBySearch(CitySearch searchCity){
			if(log.isDebugEnabled()){
				log.debug("getCityCountBySearch Method is called");
			}
			
			return cityDAO.getCityCountBySearch(searchCity);
		}
	
	
	/**
     * This method save/updates a list of City information to the database.
     * 
     * @param listCity as List
     * 
     */
    public void saveAll(List<City> listCity){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		cityDAO.saveAll(listCity);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listCity as List
     */
    public void deleteAll(List<City> listCity){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		cityDAO.deleteAll(listCity);
    }
    
    /**
	 * This method returns list of City objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<City> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return cityDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns City object for a given data
	 * 
	 * @param City as city
	 * @return City as model object
	 */
	public City checkForDuplicates(City city)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return cityDAO.checkForDuplicates(city);
		
	}
	
	    /**
	 * This method returns list of City objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<City> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return cityDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of City objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<City> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return cityDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return cityDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}

	@Override
	public List<City> getAllByTenancy(long tenancyId) {
		if (log.isDebugEnabled()) 
    	{
			log.debug("getAllByTenancy Method is called");
		}
		return cityDAO.getAllByTenancy(tenancyId);
	}	
	public City getByName(String name) {
		if (log.isDebugEnabled()) {
			log.debug("getByName Method is called");
		}
		return cityDAO.getByName(name);
	}

	@Override
	public City getByTenancyId(long tenancyId) {
		if (log.isDebugEnabled()) 
    	{
			log.debug("getAllByTenancy Method is called");
		}
		return cityDAO.getByTenancyId(tenancyId);
	}
	
}

