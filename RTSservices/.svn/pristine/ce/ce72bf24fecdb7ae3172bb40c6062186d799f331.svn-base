package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.DesignationDAO;
import com.mars.common.model.Designation;
import com.mars.common.search.DesignationSearch;
import com.mars.common.service.DesignationService;
 /**

 * <p>Title: DesignationServiceImpl.java </p>

 * @see com.mars.common.model.Designation
 
 * <p>Description: This class is used for hibernate operations for Designation module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("designationService") 
public class DesignationServiceImpl implements DesignationService {

    private static final Log log = LogFactory.getLog(DesignationServiceImpl.class);

  	
	@Autowired
	private DesignationDAO designationDAO;

	public void setDesignationDAO(DesignationDAO designationDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setDesignationDAO Method is called ");
		}
		this.designationDAO = designationDAO;
	}

	/**
	 * This method is saves the Designation object
	 * 
	 * @param entity as Designation object
	 * @return
	 * 
	 */
	public void save(Designation entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		designationDAO.save(entity);
	}

     /**
	 * This method to merge the Designation information to the database.
	 * 
	 * @param Designation object
	 * 
	 */
    public Designation merge(Designation entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return designationDAO.merge(entity);
	}

	/**
	 * This method delete the designation
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		designationDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Designation Object
	 * 
	 */
	public Designation get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return designationDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Designation from the database
	 * 
	 * @return List of Designation
	 */
	public List<Designation> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return designationDAO.getAll();
	}
	
		/**
		 * This method returns list of the Designation objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Designation> getDesignationList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getDesignationList Method is called");
			}
			return designationDAO.getDesignationList(pageNumber,orderBy,sortBy);
		}
		
		
		
		/**
		 * 
		 * @param searchOptions
		 * @return
		 */
			public List<Designation> getDesignationListBySearch(DesignationSearch searchDesignation){

			if (log.isDebugEnabled()) {
				log.debug("getDesignationListBySearch Method is called");
			}
			return designationDAO.getDesignationListBySearch(searchDesignation);
			
		}
			
		/**
		 * This method returns count of the Designation objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getDesignationCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getDesignationCount Method is called");
			}
			return designationDAO.getDesignationCount();
		}	
	
	
	/**
     * This method save/updates a list of Designation information to the database.
     * 
     * @param listDesignation as List
     * 
     */
    public void saveAll(List<Designation> listDesignation){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		designationDAO.saveAll(listDesignation);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listDesignation as List
     */
    public void deleteAll(List<Designation> listDesignation){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		designationDAO.deleteAll(listDesignation);
    }
    
    /**
	 * This method returns list of Designation objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Designation> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return designationDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Designation object for a given data
	 * 
	 * @param Designation as designation
	 * @return Designation as model object
	 */
	public Designation checkForDuplicates(Designation designation)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return designationDAO.checkForDuplicates(designation);
		
	}
	
	    /**
	 * This method returns list of Designation objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Designation> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return designationDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Designation objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Designation> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return designationDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return designationDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	
	public Long getDesignationCountBySearch(DesignationSearch searchDesignation) {
		if (log.isDebugEnabled()) 
    	{
			log.debug("getDesignationCountBySearch Method is called");
		}
		return designationDAO.getDesignationCountBySearch(searchDesignation);
	}	
}

