package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.SectionDAO;
import com.mars.common.model.Section;
import com.mars.common.search.SectionSearch;
import com.mars.common.service.SectionService;
 /**

 * <p>Title: SectionServiceImpl.java </p>

 * @see com.mars.common.model.Section
 
 * <p>Description: This class is used for hibernate operations for Section module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("sectionService")
public class SectionServiceImpl implements SectionService {

    private static final Log log = LogFactory.getLog(SectionServiceImpl.class);

  	
	@Autowired
	private SectionDAO sectionDAO;

	public void setSectionDAO(SectionDAO sectionDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setSectionDAO Method is called ");
		}
		this.sectionDAO = sectionDAO;
	}

	/**
	 * This method is saves the Section object
	 * 
	 * @param entity as Section object
	 * @return
	 * 
	 */
	public void save(Section entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		sectionDAO.save(entity);
	}

     /**
	 * This method to merge the Section information to the database.
	 * 
	 * @param Section object
	 * 
	 */
    public Section merge(Section entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return sectionDAO.merge(entity);
	}

	/**
	 * This method delete the department
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		sectionDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Section Object
	 * 
	 */
	public Section get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return sectionDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Section from the database
	 * 
	 * @return List of Section
	 */
	public List<Section> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return sectionDAO.getAll();
	}
	
		/**
		 * This method returns list of the Section objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Section> getSectionList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getSectionList Method is called");
			}
			return sectionDAO.getSectionList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * 
		 * @param searchOptions
		 * @return
		 */
			public List<Section> getSectionListBySearch(SectionSearch searchSection){

			if (log.isDebugEnabled()) {
				log.debug("getApplicationListBySearch Method is called");
			}
			return sectionDAO.getSectionListBySearch(searchSection);
			
		}
		
		/**
		 * This method returns count of the Section objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getSectionCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getSectionCount Method is called");
			}
			return sectionDAO.getSectionCount();
		}	
	
	
	/**
     * This method save/updates a list of Section information to the database.
     * 
     * @param listSection as List
     * 
     */
    public void saveAll(List<Section> listSection){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
    	sectionDAO.saveAll(listSection);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listSection as List
     */
    public void deleteAll(List<Section> listSection){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
        sectionDAO.deleteAll(listSection);
    }
    
    /**
	 * This method returns list of Section objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Section> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return sectionDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Section object for a given data
	 * 
	 * @param Section as department
	 * @return Section as model object
	 */
	public Section checkForDuplicates(Section department)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return sectionDAO.checkForDuplicates(department);
		
	}
	
	    /**
	 * This method returns list of Section objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Section> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return sectionDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Section objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Section> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return sectionDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return sectionDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	
	public Long getSectionCountBySearch(SectionSearch searchSection) {
		if (log.isDebugEnabled()) 
    	{
			log.debug("getApplicationCountBySearch Method is called");
		}
		return sectionDAO.getSectionCountBySearch(searchSection);
	}	
}

