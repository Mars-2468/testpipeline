package com.mars.common.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.State;
import com.mars.common.search.StateSearch;
/**
* <p>Title: StateService.java </p>

 * <p>Description: This interface is used for service implementations related to State</p>

 * @see com.mars.common.model.State
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface StateService {
  
	/**
	 * This method returns State object for a given Id
	 * 
	 * @param id as long
	 * @return State as model object
	 */
	public State get(long id);
		
    /**
	 * This method save/updates the State information to the database.
	 * 
	 * @param State object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(State entity);
	  
	/**
	 * This method to merge the State information to the database.
	 * 
	 * @param State object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public State merge(State entity); 
	    
    /**
	 * This method delete State for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all State from the database
	 * 
	 * @return List of State
	 */
	public List<State> getAll();
	
	/**
     * This method save/updates a list of State information to the database.
     * 
     * @param listState as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<State> listState);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listState as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<State> listState);
    
	    /**
		 * This method returns list of the State objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<State> getStateList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns list of the State objects available based on Search.
		 * 
		 * @param searchState
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<State> getStateListBySearch(StateSearch searchState);
		
		/**
		 * This method returns count of the State objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getStateCount();
	
		
		/**
		 * This method returns count of the State objects from the database based on search
		 * @param searchState
		 * @return long
		 * @exception Exception
		 */
		public long getStateCountBySearch(StateSearch searchState);
	
	/**
	 * This method returns list of State objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<State> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns State object for a given data
	 * 
	 * @param State as state
	 * @return State as model object
	 */
	public State checkForDuplicates(State state);    

    /**
	 * This method returns list of State objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<State> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of State objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<State> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
}

