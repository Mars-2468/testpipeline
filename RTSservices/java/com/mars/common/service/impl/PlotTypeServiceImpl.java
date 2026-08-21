package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.PlotTypeDAO;
import com.mars.common.model.PlotType;
import com.mars.common.search.PlotTypeSearch;
import com.mars.common.service.PlotTypeService;
 /**

 * <p>Title: PlotTypeServiceImpl.java </p>

 * @see com.mars.common.model.PlotType
 
 * <p>Description: This class is used for hibernate operations for PlotType module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
 @Service("plotTypeService")
public class PlotTypeServiceImpl implements PlotTypeService {

    private static final Log log = LogFactory.getLog(PlotTypeServiceImpl.class);

  	
	@Autowired
	private PlotTypeDAO plotTypeDAO;

	public void setPlotTypeDAO(PlotTypeDAO plotTypeDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setPlotTypeDAO Method is called ");
		}
		this.plotTypeDAO = plotTypeDAO;
	}

	/**
	 * This method is saves the PlotType object
	 * 
	 * @param entity as PlotType object
	 * @return
	 * 
	 */
	public void save(PlotType entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		plotTypeDAO.save(entity);
	}

     /**
	 * This method to merge the PlotType information to the database.
	 * 
	 * @param PlotType object
	 * 
	 */
    public PlotType merge(PlotType entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return plotTypeDAO.merge(entity);
	}

	/**
	 * This method delete the plotType
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		plotTypeDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a PlotType Object
	 * 
	 */
	public PlotType get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return plotTypeDAO.get(id);
	}
	
	/**
	 * This method will return a list of all PlotType from the database
	 * 
	 * @return List of PlotType
	 */
	public List<PlotType> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return plotTypeDAO.getAll();
	}
	
		/**
		 * This method returns list of the PlotType objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<PlotType> getPlotTypeList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getPlotTypeList Method is called");
			}
			return plotTypeDAO.getPlotTypeList(pageNumber,orderBy,sortBy);
		}
		
		/**
		 * This method returns list of the PlotType objects available based on Search.
		 * 
		 * @param PlotTypeSearch searchPlotType
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<PlotType> getPlotTypeListBySearch(PlotTypeSearch searchPlotType){
			if(log.isDebugEnabled()){
				log.debug("getPlotTypeListBySearch");
			}
			
			return plotTypeDAO.getPlotTypeListBySearch(searchPlotType);
		}
		
		
		/**
		 * This method returns count of the PlotType objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getPlotTypeCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getPlotTypeCount Method is called");
			}
			return plotTypeDAO.getPlotTypeCount();
		}	
	 
		/**
		 * This method returns count of the PlotType objects available based on search criteria.
		 * @param PlotTypeSearch searchPlotType
		 * @return long
		 * @exception Exception
		 */
		public long getPlotTypeCountBySearch(PlotTypeSearch searchPlotType){
			if(log.isDebugEnabled()){
				log.debug("getPlotTypeCountBySearch Method is called");
			}
			
			return plotTypeDAO.getPlotTypeCountBySearch(searchPlotType);
		}
	
	/**
     * This method save/updates a list of PlotType information to the database.
     * 
     * @param listPlotType as List
     * 
     */
    public void saveAll(List<PlotType> listPlotType){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		plotTypeDAO.saveAll(listPlotType);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listPlotType as List
     */
    public void deleteAll(List<PlotType> listPlotType){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		plotTypeDAO.deleteAll(listPlotType);
    }
    
    /**
	 * This method returns list of PlotType objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<PlotType> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return plotTypeDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns PlotType object for a given data
	 * 
	 * @param PlotType as plotType
	 * @return PlotType as model object
	 */
	public PlotType checkForDuplicates(PlotType plotType)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return plotTypeDAO.checkForDuplicates(plotType);
		
	}
	
	    /**
	 * This method returns list of PlotType objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<PlotType> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return plotTypeDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of PlotType objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<PlotType> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return plotTypeDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return plotTypeDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
}

