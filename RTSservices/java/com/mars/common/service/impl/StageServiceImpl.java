package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.StageDAO;
import com.mars.common.model.Stage;
import com.mars.common.search.StageSearch;
import com.mars.common.service.StageService;
 /**

 * <p>Title: StageServiceImpl.java </p>

 * @see com.mars.common.model.Stage
 
 * <p>Description: This class is used for hibernate operations for Stage module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("stageService") 
public class StageServiceImpl implements StageService {

    private static final Log log = LogFactory.getLog(StageServiceImpl.class);

  	
    @Autowired
	private StageDAO stageDAO;

	public void setStageDAO(StageDAO stageDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setStageDAO Method is called ");
		}
		this.stageDAO = stageDAO;
	}

	/**
	 * This method is saves the Stage object
	 * 
	 * @param entity as Stage object
	 * @return
	 * 
	 */
	public void save(Stage entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		stageDAO.save(entity);
	}

     /**
	 * This method to merge the Stage information to the database.
	 * 
	 * @param Stage object
	 * 
	 */
    public Stage merge(Stage entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return stageDAO.merge(entity);
	}

	/**
	 * This method delete the stage
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		stageDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Stage Object
	 * 
	 */
	public Stage get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return stageDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Stage from the database
	 * 
	 * @return List of Stage
	 */
	public List<Stage> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return stageDAO.getAll();
	}
	
		/**
		 * This method returns list of the Stage objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Stage> getStageList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getStageList Method is called");
			}
			return stageDAO.getStageList(pageNumber,orderBy,sortBy);
		}
		
		/**
		 * This method returns list of the Stage objects available based on Search.
		 * 
		 * @param StageSearch searchStage
		 * @param 
		 * @param 
		 * @return List
		 * @exception Exception
		 */
		public List<Stage> getStageListBySearch(StageSearch searchStage){
			if(log.isDebugEnabled()){
				log.debug("getListBySearch Method is called");
			}
			
			return stageDAO.getStageListBySearch(searchStage);
		}
		
		
		/**
		 * This method returns count of the Stage objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getStageCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getStageCount Method is called");
			}
			return stageDAO.getStageCount();
		}	
	
		/**
		 * This method returns count of the Stage objects available based on search criteria.
		 * @param StageSearch searchStage
		 * @return long
		 * @exception Exception
		 */
         public long getStageCountBySearch(StageSearch searchStage){
        	 if(log.isDebugEnabled()){
        		 log.debug("getStageCountBySearch Method is called");
        	 }
        	 
        	 return stageDAO.getStageCountBySearch(searchStage);
         }
		
	/**
     * This method save/updates a list of Stage information to the database.
     * 
     * @param listStage as List
     * 
     */
    public void saveAll(List<Stage> listStage){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		stageDAO.saveAll(listStage);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listStage as List
     */
    public void deleteAll(List<Stage> listStage){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		stageDAO.deleteAll(listStage);
    }
    
    /**
	 * This method returns list of Stage objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Stage> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return stageDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Stage object for a given data
	 * 
	 * @param Stage as stage
	 * @return Stage as model object
	 */
	public Stage checkForDuplicates(Stage stage)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return stageDAO.checkForDuplicates(stage);
		
	}
	
	    /**
	 * This method returns list of Stage objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Stage> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return stageDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Stage objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Stage> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return stageDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return stageDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
}

