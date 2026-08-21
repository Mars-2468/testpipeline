package com.mars.common.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.Plot;
import com.mars.common.search.PlotSearch;
/**
 * <p>Title: PlotDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for Plot</p>

 * @see com.mars.common.model.Plot
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface PlotDAO {

  
	/**
	 * This method returns Plot object for a given Id
	 * 
	 * @param id as long
	 * @return Plot as model object
	 */
	public Plot get(long id);
		
    
    /**
	 * This method save/updates the Plot information to the database.
	 * 
	 * @param Plot object
	 * 
	 */
	public void save(Plot entity);
	
     /**
	 * This method to merge the Plot information to the database.
	 * 
	 * @param Plot object
	 * 
	 */
    public Plot merge(Plot entity);
    
    /**
	 * This method delete Plot for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Plot from the database
	 * 
	 * @return List of Plot
	 */
	public List<Plot> getAll();
	
	/**
     * This method save/updates a list of Plot information to the database.
     * 
     * @param listPlot as List
     * 
     */
    public void saveAll(List<Plot> listPlot);
    
    
    /**
     * This method is used to delete a list of Plot records from the database.
     * 
     * @param listPlot as List
     */
    public void deleteAll(List<Plot> listPlot);
    
	    /**
		 * This method returns list of the Plot objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Plot> getPlotList(long pageNumber,String orderBy, String sortBy);
		
		
		/**
		 * This method returns list of the Plot objects available based on Search.
		 * 
		 * @param PlotSearch searchPlot
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<Plot> getPlotListBySearch(PlotSearch searchPlot);
		
		
		
		/**
		 * This method returns count of the Plot objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getPlotCount();
	
		
		/**
		 * This method returns count of the Plot objects from the database based on Search
		 * @param PlotSearch searchPlot
		 * @return long
		 * @exception Exception
		 */
		public long getPlotCountBySearch(PlotSearch searchPlot);
	
	/**
	 * This method returns list of Plot objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Plot> findByProperty(String propertyName, Object value);

	/**
	 * This method returns Plot object for a given data
	 * 
	 * @param Plot as plot
	 * @return Plot as model object
	 */
	public Plot checkForDuplicates(Plot plot);
	
	/**
	 * This method returns list of Plot objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Plot> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of Plot objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Plot> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
}

