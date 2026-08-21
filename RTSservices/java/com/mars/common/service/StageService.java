package com.mars.common.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.Stage;
import com.mars.common.search.StageSearch;
/**
* <p>Title: StageService.java </p>

 * <p>Description: This interface is used for service implementations related to Stage</p>

 * @see com.mars.common.model.Stage
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface StageService {
  
	/**
	 * This method returns Stage object for a given Id
	 * 
	 * @param id as long
	 * @return Stage as model object
	 */
	public Stage get(long id);
		
    /**
	 * This method save/updates the Stage information to the database.
	 * 
	 * @param Stage object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(Stage entity);
	  
	/**
	 * This method to merge the Stage information to the database.
	 * 
	 * @param Stage object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public Stage merge(Stage entity); 
	    
    /**
	 * This method delete Stage for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Stage from the database
	 * 
	 * @return List of Stage
	 */
	public List<Stage> getAll();
	
	/**
     * This method save/updates a list of Stage information to the database.
     * 
     * @param listStage as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Stage> listStage);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listStage as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Stage> listStage);
    
    /**
	 * This method returns list of the Stage objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<Stage> getStageList(long pageNumber,String orderBy, String sortBy);
	
	/**
	 * This method returns list of the Stage objects available based on Search.
	 * 
	 * @param StageSearch searchStage
	 * @param 
	 * @param 
	 * @return List
	 * @exception Exception
	 */
	public List<Stage> getStageListBySearch(StageSearch searchStage);
	
	/**
	 * This method returns count of the Stage objects from the database
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getStageCount();


	/**
	 * This method returns count of the Stage objects from the database based on Search
	 * @param StageSearch searchStage
	 * @return long
	 * @exception Exception
	 */
	public long getStageCountBySearch(StageSearch searchStage);
		
	/**
	 * This method returns list of Stage objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Stage> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns Stage object for a given data
	 * 
	 * @param Stage as stage
	 * @return Stage as model object
	 */
	public Stage checkForDuplicates(Stage stage);    

    /**
	 * This method returns list of Stage objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Stage> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Stage objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Stage> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
}

