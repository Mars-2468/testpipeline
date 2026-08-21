package com.mars.common.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.PlotType;
import com.mars.common.search.PlotTypeSearch;
/**
 * <p>Title: PlotTypeDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for PlotType</p>

 * @see com.mars.common.model.PlotType
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface PlotTypeDAO {

  
	/**
	 * This method returns PlotType object for a given Id
	 * 
	 * @param id as long
	 * @return PlotType as model object
	 */
	public PlotType get(long id);
		
    
    /**
	 * This method save/updates the PlotType information to the database.
	 * 
	 * @param PlotType object
	 * 
	 */
	public void save(PlotType entity);
	
     /**
	 * This method to merge the PlotType information to the database.
	 * 
	 * @param PlotType object
	 * 
	 */
    public PlotType merge(PlotType entity);
    
    /**
	 * This method delete PlotType for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all PlotType from the database
	 * 
	 * @return List of PlotType
	 */
	public List<PlotType> getAll();
	
	/**
     * This method save/updates a list of PlotType information to the database.
     * 
     * @param listPlotType as List
     * 
     */
    public void saveAll(List<PlotType> listPlotType);
    
    
    /**
     * This method is used to delete a list of PlotType records from the database.
     * 
     * @param listPlotType as List
     */
    public void deleteAll(List<PlotType> listPlotType);
    
	    /**
		 * This method returns list of the PlotType objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<PlotType> getPlotTypeList(long pageNumber,String orderBy, String sortBy);
		
		
		/**
		 * This method returns list of the PlotType objects available based on Search.
		 * 
		 * @param PlotTypeSearch searchPlotType
		 * @param
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<PlotType> getPlotTypeListBySearch(PlotTypeSearch searchPlotType);
		
		/**
		 * This method returns count of the PlotType objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getPlotTypeCount();
	
		/**
		 * This method returns count of the PlotType objects from the database based on search
		 * @param PlotTypeSearch searchPlotType
		 * @return long
		 * @exception Exception
		 */
		public long getPlotTypeCountBySearch(PlotTypeSearch searchPlotType);
		
	/**
	 * This method returns list of PlotType objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<PlotType> findByProperty(String propertyName, Object value);

	/**
	 * This method returns PlotType object for a given data
	 * 
	 * @param PlotType as plotType
	 * @return PlotType as model object
	 */
	public PlotType checkForDuplicates(PlotType plotType);
	
	/**
	 * This method returns list of PlotType objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<PlotType> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of PlotType objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<PlotType> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
}

