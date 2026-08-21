package com.mars.rti.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FeeMasterDAO;
import com.mars.rti.model.FeeMaster;
import com.mars.rti.search.FeeMasterSearch;
import com.mars.rti.service.FeeMasterService;
 /**

 * <p>Title: FeeMasterServiceImpl.java </p>

 * @see com.mars.rti.FeeMaster
 
 * <p>Description: This class is used for hibernate operations for FeeMaster module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("feeMasterService") 
public class FeeMasterServiceImpl implements FeeMasterService {

    private static final Log log = LogFactory.getLog(FeeMasterServiceImpl.class);

  	
	@Autowired
	private FeeMasterDAO feeMasterDAO;

	public void setFeeMasterDAO(FeeMasterDAO feeMasterDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setFeeMasterDAO Method is called ");
		}
		this.feeMasterDAO = feeMasterDAO;
	}

	/**
	 * This method is saves the FeeMaster object
	 * 
	 * @param entity as FeeMaster object
	 * @return
	 * 
	 */
	public void save(FeeMaster entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		feeMasterDAO.save(entity);
	}

     /**
	 * This method to merge the FeeMaster information to the database.
	 * 
	 * @param FeeMaster object
	 * 
	 */
    public FeeMaster merge(FeeMaster entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return feeMasterDAO.merge(entity);
	}

	/**
	 * This method delete the feeMaster
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		feeMasterDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a FeeMaster Object
	 * 
	 */
	public FeeMaster get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return feeMasterDAO.get(id);
	}
	
	/**
	 * This method will return a list of all FeeMaster from the database
	 * 
	 * @return List of FeeMaster
	 */
	public List<FeeMaster> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return feeMasterDAO.getAll();
	}
	
		/**
		 * This method returns list of the FeeMaster objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<FeeMaster> getFeeMasterList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getFeeMasterList Method is called");
			}
			return feeMasterDAO.getFeeMasterList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * This method returns list of the FeeMaster objects available based on Search.
		 * 
		 * @param FeeMasterSearch searchFeeMaster
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<FeeMaster> getFeeMasterListBySearch(FeeMasterSearch searchFeeMaster){
			if(log.isDebugEnabled()){
				log.debug("getFeeMasterListBySerach Method is called");
			}
			
			return feeMasterDAO.getFeeMasterListBySearch(searchFeeMaster);
		}
		
		
		/**
		 * This method returns count of the FeeMaster objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getFeeMasterCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getFeeMasterCount Method is called");
			}
			return feeMasterDAO.getFeeMasterCount();
		}	
		
		/**
		 * This method returns count of the FeeMaster objects available based on search criteria.
		 * @param FeeMasterSearch searchFeeMaster
		 * @return long
		 * @exception Exception
		 */
		public long getFeeMasterCountBySearch(FeeMasterSearch searchFeeMaster){
			if(log.isDebugEnabled()){
				log.debug("getFeeMasterCountBySearch Method is called");
			}
			
			return feeMasterDAO.getFeeMasterCountBySearch(searchFeeMaster);
		}
	
	
	/**
     * This method save/updates a list of FeeMaster information to the database.
     * 
     * @param listFeeMaster as List
     * 
     */
    public void saveAll(List<FeeMaster> listFeeMaster){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		feeMasterDAO.saveAll(listFeeMaster);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listFeeMaster as List
     */
    public void deleteAll(List<FeeMaster> listFeeMaster){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		feeMasterDAO.deleteAll(listFeeMaster);
    }
    
    /**
	 * This method returns list of FeeMaster objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<FeeMaster> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return feeMasterDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns FeeMaster object for a given data
	 * 
	 * @param FeeMaster as feeMaster
	 * @return FeeMaster as model object
	 */
	public List checkForDuplicates(FeeMaster feeMaster)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return feeMasterDAO.checkForDuplicates(feeMaster);
		
	}
	
	    /**
	 * This method returns list of FeeMaster objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<FeeMaster> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return feeMasterDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of FeeMaster objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<FeeMaster> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return feeMasterDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return feeMasterDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	
	public FeeMaster getAmount(){
		if (log.isDebugEnabled()) 
    	{
			log.debug("getAmount Method is called");
		}
		return feeMasterDAO.getAmount();
	}
	
	public FeeMaster getApplicationCopyFeeDetails(String createdDate,int feeCategory){
		
		if (log.isDebugEnabled()) 
    	{
			log.debug("getApplicationCopyFeeDetails Method is called");
		}
		return feeMasterDAO.getApplicationCopyFeeDetails(createdDate,feeCategory);
	}
	
	public FeeMaster getApplicationFeeDetails(){
		
		if (log.isDebugEnabled()) 
    	{
			log.debug("getApplicationFeeDetails Method is called");
		}
		return feeMasterDAO.getApplicationFeeDetails();
	}
}

