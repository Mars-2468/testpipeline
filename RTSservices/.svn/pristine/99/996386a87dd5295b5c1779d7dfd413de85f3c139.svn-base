package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.DistrictDAO;
import com.mars.common.model.District;
import com.mars.common.search.DistrictSearch;
import com.mars.common.service.DistrictService;
 /**

 * <p>Title: DistrictServiceImpl.java </p>

 * @see com.mars.common.model.District
 
 * <p>Description: This class is used for hibernate operations for District module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("districtService")
public class DistrictServiceImpl implements DistrictService {

    private static final Log log = LogFactory.getLog(DistrictServiceImpl.class);

  	
	@Autowired
	private DistrictDAO districtDAO;

	public void setDistrictDAO(DistrictDAO districtDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setDistrictDAO Method is called ");
		}
		this.districtDAO = districtDAO;
	}

	/**
	 * This method is saves the District object
	 * 
	 * @param entity as District object
	 * @return
	 * 
	 */
	public void save(District entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		districtDAO.save(entity);
	}

     /**
	 * This method to merge the District information to the database.
	 * 
	 * @param District object
	 * 
	 */
    public District merge(District entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return districtDAO.merge(entity);
	}

	/**
	 * This method delete the district
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		districtDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a District Object
	 * 
	 */
	public District get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return districtDAO.get(id);
	}
	
	/**
	 * This method will return a list of all District from the database
	 * 
	 * @return List of District
	 */
	public List<District> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return districtDAO.getAll();
	}
	
		/**
		 * This method returns list of the District objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<District> getDistrictList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getDistrictList Method is called");
			}
			return districtDAO.getDistrictList(pageNumber,orderBy,sortBy);
		}
		
		/**
		 * This method returns list of the District objects available based on search
		 * 
		 * @param searchDistrict
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<District> getDistrictListBySearch(DistrictSearch searchDistrict){
		
			if (log.isDebugEnabled()) {
				log.debug("getDistrictList Method is called");
			}
			return districtDAO.getDistrictListBySearch(searchDistrict);
		}
		
		/**
		 * This method returns count of the District objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getDistrictCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getDistrictCount Method is called");
			}
			return districtDAO.getDistrictCount();
		}	
	
		/**
		 * This method returns count of the District objects available based on search criteria.
		 * @param searchDistrict 
		 * @return long
		 * @exception Exception
		 */
		public long getDistrictCountBySearch(DistrictSearch searchDistrict){
		    if (log.isDebugEnabled()) {
				log.debug("getDistrictCount Method is called");
			}
			return districtDAO.getDistrictCountBySearch(searchDistrict);
		}
		
	/**
     * This method save/updates a list of District information to the database.
     * 
     * @param listDistrict as List
     * 
     */
    public void saveAll(List<District> listDistrict){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		districtDAO.saveAll(listDistrict);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listDistrict as List
     */
    public void deleteAll(List<District> listDistrict){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		districtDAO.deleteAll(listDistrict);
    }
    
    /**
	 * This method returns list of District objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<District> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return districtDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns District object for a given data
	 * 
	 * @param District as district
	 * @return District as model object
	 */
	public District checkForDuplicates(District district)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return districtDAO.checkForDuplicates(district);
		
	}
	
	    /**
	 * This method returns list of District objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<District> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return districtDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of District objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<District> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return districtDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return districtDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
}

