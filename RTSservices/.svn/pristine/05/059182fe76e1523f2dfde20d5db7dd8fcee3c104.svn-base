package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.PlotDAO;
import com.mars.common.model.Plot;
import com.mars.common.search.PlotSearch;
import com.mars.common.service.PlotService;
 /**

 * <p>Title: PlotServiceImpl.java </p>

 * @see com.mars.common.model.Plot
 
 * <p>Description: This class is used for hibernate operations for Plot module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("plotService") 
public class PlotServiceImpl implements PlotService {

    private static final Log log = LogFactory.getLog(PlotServiceImpl.class);

  	
	@Autowired
	private PlotDAO plotDAO;

	public void setPlotDAO(PlotDAO plotDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setPlotDAO Method is called ");
		}
		this.plotDAO = plotDAO;
	}

	/**
	 * This method is saves the Plot object
	 * 
	 * @param entity as Plot object
	 * @return
	 * 
	 */
	public void save(Plot entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		plotDAO.save(entity);
	}

     /**
	 * This method to merge the Plot information to the database.
	 * 
	 * @param Plot object
	 * 
	 */
    public Plot merge(Plot entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return plotDAO.merge(entity);
	}

	/**
	 * This method delete the plot
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		plotDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Plot Object
	 * 
	 */
	public Plot get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return plotDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Plot from the database
	 * 
	 * @return List of Plot
	 */
	public List<Plot> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return plotDAO.getAll();
	}
	
		/**
		 * This method returns list of the Plot objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Plot> getPlotList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getPlotList Method is called");
			}
			return plotDAO.getPlotList(pageNumber,orderBy,sortBy);
		}
		
		/**
		 * This method returns list of the Plot objects available based on Search.
		 * 
		 * @param PlotSearch searchPlot
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<Plot> getPlotListBySearch(PlotSearch searchPlot){
			if(log.isDebugEnabled()){
				log.debug("getPlotListBySearch Method is called");
			}
			
			return plotDAO.getPlotListBySearch(searchPlot);
		}
		
		
		/**
		 * This method returns count of the Plot objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getPlotCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getPlotCount Method is called");
			}
			return plotDAO.getPlotCount();
		}	
		
		/**
		 * This method returns count of the Plot objects available based on search criteria.
		 * @param PlotSearch searchPlot
		 * @return long
		 * @exception Exception
		 */
		public long getPlotCountBySearch(PlotSearch searchPlot){
			if(log.isDebugEnabled()){
				log.debug("getPlotCountBySearch Method is called");
			}
			
			return plotDAO.getPlotCountBySearch(searchPlot);
		}
	
	
	/**
     * This method save/updates a list of Plot information to the database.
     * 
     * @param listPlot as List
     * 
     */
    public void saveAll(List<Plot> listPlot){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		plotDAO.saveAll(listPlot);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listPlot as List
     */
    public void deleteAll(List<Plot> listPlot){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		plotDAO.deleteAll(listPlot);
    }
    
    /**
	 * This method returns list of Plot objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Plot> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return plotDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Plot object for a given data
	 * 
	 * @param Plot as plot
	 * @return Plot as model object
	 */
	public Plot checkForDuplicates(Plot plot)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return plotDAO.checkForDuplicates(plot);
		
	}
	
	    /**
	 * This method returns list of Plot objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Plot> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return plotDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Plot objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Plot> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return plotDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return plotDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
}

