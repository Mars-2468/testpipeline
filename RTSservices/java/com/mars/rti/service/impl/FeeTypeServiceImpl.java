package com.mars.rti.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FeeTypeDAO;
import com.mars.rti.model.FeeType;
import com.mars.rti.search.FeeTypeSearch;
import com.mars.rti.service.FeeTypeService;
 /**

 * <p>Title: FeeTypeServiceImpl.java </p>

 * @see com.mars.rti.FeeType
 
 * <p>Description: This class is used for hibernate operations for FeeType module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("feeTypeService") 
public class FeeTypeServiceImpl implements FeeTypeService {

    private static final Log log = LogFactory.getLog(FeeTypeServiceImpl.class);

  	
	@Autowired
	private FeeTypeDAO feeTypeDAO;

	public void setFeeTypeDAO(FeeTypeDAO feeTypeDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setFeeTypeDAO Method is called ");
		}
		this.feeTypeDAO = feeTypeDAO;
	}

	/**
	 * This method is saves the FeeType object
	 * 
	 * @param entity as FeeType object
	 * @return
	 * 
	 */
	public void save(FeeType entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		feeTypeDAO.save(entity);
	}

     /**
	 * This method to merge the FeeType information to the database.
	 * 
	 * @param FeeType object
	 * 
	 */
    public FeeType merge(FeeType entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return feeTypeDAO.merge(entity);
	}

	/**
	 * This method delete the feeType
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		feeTypeDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a FeeType Object
	 * 
	 */
	public FeeType get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return feeTypeDAO.get(id);
	}
	
	/**
	 * This method will return a list of all FeeType from the database
	 * 
	 * @return List of FeeType
	 */
	public List<FeeType> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return feeTypeDAO.getAll();
	}
	
		/**
		 * This method returns list of the FeeType objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<FeeType> getFeeTypeList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getFeeTypeList Method is called");
			}
			return feeTypeDAO.getFeeTypeList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * This method returns list of the FeeType objects available based on Search.
		 * 
		 * @param FeeTypeSearch searchFeeType
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<FeeType> getFeeTypeListBySearch(FeeTypeSearch searchFeeType){
			if(log.isDebugEnabled()){
				log.debug("getFeeTypeListBySerach Method is called");
			}
			
			return feeTypeDAO.getFeeTypeListBySearch(searchFeeType);
		}
		
		
		/**
		 * This method returns count of the FeeType objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getFeeTypeCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getFeeTypeCount Method is called");
			}
			return feeTypeDAO.getFeeTypeCount();
		}	
		
		/**
		 * This method returns count of the FeeType objects available based on search criteria.
		 * @param FeeTypeSearch searchFeeType
		 * @return long
		 * @exception Exception
		 */
		public long getFeeTypeCountBySearch(FeeTypeSearch searchFeeType){
			if(log.isDebugEnabled()){
				log.debug("getFeeTypeCountBySearch Method is called");
			}
			
			return feeTypeDAO.getFeeTypeCountBySearch(searchFeeType);
		}
	
	
	/**
     * This method save/updates a list of FeeType information to the database.
     * 
     * @param listFeeType as List
     * 
     */
    public void saveAll(List<FeeType> listFeeType){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		feeTypeDAO.saveAll(listFeeType);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listFeeType as List
     */
    public void deleteAll(List<FeeType> listFeeType){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		feeTypeDAO.deleteAll(listFeeType);
    }
    
    /**
	 * This method returns list of FeeType objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<FeeType> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return feeTypeDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns FeeType object for a given data
	 * 
	 * @param FeeType as feeType
	 * @return FeeType as model object
	 */
	public FeeType checkForDuplicates(FeeType feeType)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return feeTypeDAO.checkForDuplicates(feeType);
		
	}
	
	    /**
	 * This method returns list of FeeType objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<FeeType> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return feeTypeDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of FeeType objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<FeeType> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return feeTypeDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return feeTypeDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	
}

