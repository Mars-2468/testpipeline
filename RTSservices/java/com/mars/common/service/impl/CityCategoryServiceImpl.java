package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.CityCategoryDAO;
import com.mars.common.model.CityCategory;
import com.mars.common.service.CityCategoryService;
 /**

 * <p>Title: CityCategoryServiceImpl.java </p>

 * @see com.mars.pis.model.CityCategory
 
 * <p>Description: This class is used for hibernate operations for CityCategory module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("cityCategoryService")
public class CityCategoryServiceImpl implements CityCategoryService {

    private static final Log log = LogFactory.getLog(CityCategoryServiceImpl.class);

  	
	@Autowired
	private CityCategoryDAO cityCategoryDAO;

	public void setCityCategoryDAO(CityCategoryDAO cityCategoryDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setCityCategoryDAO Method is called ");
		}
		this.cityCategoryDAO = cityCategoryDAO;
	}

	/**
	 * This method is saves the CityCategory object
	 * 
	 * @param entity as CityCategory object
	 * @return
	 * 
	 */
	public void save(CityCategory entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		cityCategoryDAO.save(entity);
	}

     /**
	 * This method to merge the CityCategory information to the database.
	 * 
	 * @param CityCategory object
	 * 
	 */
    public CityCategory merge(CityCategory entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return cityCategoryDAO.merge(entity);
	}

	/**
	 * This method delete the cityCategory
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		cityCategoryDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a CityCategory Object
	 * 
	 */
	public CityCategory get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return cityCategoryDAO.get(id);
	}
	
	/**
	 * This method will return a list of all CityCategory from the database
	 * 
	 * @return List of CityCategory
	 */
	public List<CityCategory> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return cityCategoryDAO.getAll();
	}
	
		/**
		 * This method returns list of the CityCategory objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<CityCategory> getCityCategoryList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getCityCategoryList Method is called");
			}
			return cityCategoryDAO.getCityCategoryList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * This method returns count of the CityCategory objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getCityCategoryCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getCityCategoryCount Method is called");
			}
			return cityCategoryDAO.getCityCategoryCount();
		}	
	
	
	/**
     * This method save/updates a list of CityCategory information to the database.
     * 
     * @param listCityCategory as List
     * 
     */
    public void saveAll(List<CityCategory> listCityCategory){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		cityCategoryDAO.saveAll(listCityCategory);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listCityCategory as List
     */
    public void deleteAll(List<CityCategory> listCityCategory){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		cityCategoryDAO.deleteAll(listCityCategory);
    }
    
    /**
	 * This method returns list of CityCategory objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<CityCategory> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return cityCategoryDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns CityCategory object for a given data
	 * 
	 * @param CityCategory as cityCategory
	 * @return CityCategory as model object
	 */
	public CityCategory checkForDuplicates(CityCategory cityCategory)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return cityCategoryDAO.checkForDuplicates(cityCategory);
		
	}
	
	    /**
	 * This method returns list of CityCategory objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<CityCategory> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return cityCategoryDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}

    /**
	 * This method returns list of CityCategory objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<CityCategory> getListByHqlQuery(String hqlQuery) 
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByHqlQuery Method is called");
		}
		return cityCategoryDAO.getListByHqlQuery(hqlQuery);
	}

    /**
	 * This method returns list of CityCategory objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<CityCategory> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return cityCategoryDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
	}
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked") 
	 public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return cityCategoryDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
}

