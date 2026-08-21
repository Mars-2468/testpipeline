package com.mars.common.service.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.DictionaryDAO;
import com.mars.common.model.Dictionary;
import com.mars.common.service.DictionaryService;
 /**

 * <p>Title: DictionaryServiceImpl.java </p>

 * @see com.mars.property.model.Dictionary
 
 * <p>Description: This class is used for hibernate operations for Dictionary module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

    private static final Log log = LogFactory.getLog(DictionaryServiceImpl.class);

  	
	@Autowired
	private DictionaryDAO dictionaryDAO;

	public void setDictionaryDAO(DictionaryDAO dictionaryDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setDictionaryDAO Method is called ");
		}
		this.dictionaryDAO = dictionaryDAO;
	}

	/**
	 * This method is saves the Dictionary object
	 * 
	 * @param entity as Dictionary object
	 * @return
	 * 
	 */
	public void save(Dictionary entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		dictionaryDAO.save(entity);
	}

     /**
	 * This method to merge the Dictionary information to the database.
	 * 
	 * @param Dictionary object
	 * 
	 */
    public Dictionary merge(Dictionary entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return dictionaryDAO.merge(entity);
	}

	/**
	 * This method delete the dictionary
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		dictionaryDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Dictionary Object
	 * 
	 */
	public Dictionary get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return dictionaryDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Dictionary from the database
	 * 
	 * @return List of Dictionary
	 */
	public List<Dictionary> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return dictionaryDAO.getAll();
	}
	
		/**
		 * This method returns list of the Dictionary objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Dictionary> getDictionaryList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getDictionaryList Method is called");
			}
			return dictionaryDAO.getDictionaryList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * This method returns count of the Dictionary objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getDictionaryCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getDictionaryCount Method is called");
			}
			return dictionaryDAO.getDictionaryCount();
		}	
	
	
	/**
     * This method save/updates a list of Dictionary information to the database.
     * 
     * @param listDictionary as List
     * 
     */
    public void saveAll(List<Dictionary> listDictionary){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		dictionaryDAO.saveAll(listDictionary);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listDictionary as List
     */
    public void deleteAll(List<Dictionary> listDictionary){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		dictionaryDAO.deleteAll(listDictionary);
    }
    
    /**
	 * This method returns list of Dictionary objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Dictionary> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return dictionaryDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Dictionary object for a given data
	 * 
	 * @param Dictionary as dictionary
	 * @return Dictionary as model object
	 */
	public Dictionary checkForDuplicates(Dictionary dictionary)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return dictionaryDAO.checkForDuplicates(dictionary);
		
	}
	
	    /**
	 * This method returns list of Dictionary objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Dictionary> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return dictionaryDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Dictionary objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Dictionary> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return dictionaryDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return dictionaryDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	
	public Dictionary getObjectBykey(String key)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getObjectBykey Method is called");
		}
		List<Dictionary> dictionaryList = null; 
		dictionaryList = findByProperty("key", key);
		if(dictionaryList != null & dictionaryList.size() > 0)
			return dictionaryList.get(0);
		else
			return null;
		
	}
	
	public String getValueByKey(String key)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getValueByKey Method is called");
		}
		List<Dictionary> dictionaryList = null; 
		dictionaryList = findByProperty("key", key);
		if(dictionaryList != null & dictionaryList.size() > 0)
			return dictionaryList.get(0).getValue();
		else
			return "";
		
	}
	
}

