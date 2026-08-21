package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.StateDAO;
import com.mars.common.model.State;
import com.mars.common.search.StateSearch;
import com.mars.common.service.StateService;
 /**

 * <p>Title: StateServiceImpl.java </p>

 * @see com.mars.common.model.State
 
 * <p>Description: This class is used for hibernate operations for State module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("stateService") 
public class StateServiceImpl implements StateService {

    private static final Log log = LogFactory.getLog(StateServiceImpl.class);

  	
	@Autowired
	private StateDAO stateDAO;

	public void setStateDAO(StateDAO stateDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setStateDAO Method is called ");
		}
		this.stateDAO = stateDAO;
	}

	/**
	 * This method is saves the State object
	 * 
	 * @param entity as State object
	 * @return
	 * 
	 */
	public void save(State entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		stateDAO.save(entity);
	}

     /**
	 * This method to merge the State information to the database.
	 * 
	 * @param State object
	 * 
	 */
    public State merge(State entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return stateDAO.merge(entity);
	}

	/**
	 * This method delete the state
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		stateDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a State Object
	 * 
	 */
	public State get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return stateDAO.get(id);
	}
	
	/**
	 * This method will return a list of all State from the database
	 * 
	 * @return List of State
	 */
	public List<State> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return stateDAO.getAll();
	}
	
		/**
		 * This method returns list of the State objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<State> getStateList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getStateList Method is called");
			}
			return stateDAO.getStateList(pageNumber,orderBy,sortBy);
		}
		
		/**
		 * This method returns list of the State objects available based on Search.
		 * 
		 * @param searchState
		 * @param
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<State> getStateListBySearch(StateSearch searchState){
			if(log.isDebugEnabled()){
				log.debug("getStateListBySearch Method is called");
			}
			
			return stateDAO.getStateListBySearch(searchState);
		}
		
		
		/**
		 * This method returns count of the State objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getStateCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getStateCount Method is called");
			}
			return stateDAO.getStateCount();
		}	
		
		/**
		 * This method returns count of the State objects from the database based on search
		 * @param searchState
		 * @return long
		 * @exception Exception
		 */
		public long getStateCountBySearch(StateSearch searchState){
			if(log.isDebugEnabled()){
				log.debug("getStateCountBysearch Method is called");
			}
			
			return stateDAO.getStateCountBySearch(searchState);
		}
	
	
	/**
     * This method save/updates a list of State information to the database.
     * 
     * @param listState as List
     * 
     */
    public void saveAll(List<State> listState){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		stateDAO.saveAll(listState);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listState as List
     */
    public void deleteAll(List<State> listState){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		stateDAO.deleteAll(listState);
    }
    
    /**
	 * This method returns list of State objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<State> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return stateDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns State object for a given data
	 * 
	 * @param State as state
	 * @return State as model object
	 */
	public State checkForDuplicates(State state)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return stateDAO.checkForDuplicates(state);
		
	}
	
	    /**
	 * This method returns list of State objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<State> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return stateDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of State objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<State> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return stateDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return stateDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
}

