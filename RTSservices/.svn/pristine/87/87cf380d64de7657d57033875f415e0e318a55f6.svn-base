package com.mars.workflow.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.workflow.dao.WorkflowTemplateUserMappingDAO;
import com.mars.workflow.model.WorkflowTemplateUserMapping;
import com.mars.workflow.model.WorkflowTemplateUserMappingSearch;
import com.mars.workflow.service.WorkflowTemplateUserMappingService;
 /**

 * <p>Title: WorkflowTemplateUserMappingServiceImpl.java </p>

 * @see com.mars.workflow.model.WorkflowTemplateUserMapping
 
 * <p>Description: This class is used for hibernate operations for WorkflowTemplateUserMapping module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("workflowTemplateUserMappingService") 
public class WorkflowTemplateUserMappingServiceImpl implements WorkflowTemplateUserMappingService {

    private static final Log log = LogFactory.getLog(WorkflowTemplateUserMappingServiceImpl.class);

  	
	@Autowired
	private WorkflowTemplateUserMappingDAO workflowTemplateUserMappingDAO;

	public void setWorkflowTemplateUserMappingDAO(WorkflowTemplateUserMappingDAO workflowTemplateUserMappingDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setWorkflowTemplateUserMappingDAO Method is called ");
		}
		this.workflowTemplateUserMappingDAO = workflowTemplateUserMappingDAO;
	}

	/**
	 * This method is saves the WorkflowTemplateUserMapping object
	 * 
	 * @param entity as WorkflowTemplateUserMapping object
	 * @return
	 * 
	 */
	public void save(WorkflowTemplateUserMapping entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		workflowTemplateUserMappingDAO.save(entity);
	}

     /**
	 * This method to merge the WorkflowTemplateUserMapping information to the database.
	 * 
	 * @param WorkflowTemplateUserMapping object
	 * 
	 */
    public WorkflowTemplateUserMapping merge(WorkflowTemplateUserMapping entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return workflowTemplateUserMappingDAO.merge(entity);
	}

	/**
	 * This method delete the workflowTemplateUserMapping
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		workflowTemplateUserMappingDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a WorkflowTemplateUserMapping Object
	 * 
	 */
	public WorkflowTemplateUserMapping get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return workflowTemplateUserMappingDAO.get(id);
	}
	
	/**
	 * This method will return a list of all WorkflowTemplateUserMapping from the database
	 * 
	 * @return List of WorkflowTemplateUserMapping
	 */
	public List<WorkflowTemplateUserMapping> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return workflowTemplateUserMappingDAO.getAll();
	}
	
		/**
		 * This method returns list of the WorkflowTemplateUserMapping objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<WorkflowTemplateUserMapping> getWorkflowTemplateUserMappingList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getWorkflowTemplateUserMappingList Method is called");
			}
			return workflowTemplateUserMappingDAO.getWorkflowTemplateUserMappingList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * This method returns count of the WorkflowTemplateUserMapping objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getWorkflowTemplateUserMappingCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getWorkflowTemplateUserMappingCount Method is called");
			}
			return workflowTemplateUserMappingDAO.getWorkflowTemplateUserMappingCount();
		}	
	
	
	/**
     * This method save/updates a list of WorkflowTemplateUserMapping information to the database.
     * 
     * @param listWorkflowTemplateUserMapping as List
     * 
     */
    public void saveAll(List<WorkflowTemplateUserMapping> listWorkflowTemplateUserMapping){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		workflowTemplateUserMappingDAO.saveAll(listWorkflowTemplateUserMapping);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listWorkflowTemplateUserMapping as List
     */
    public void deleteAll(List<WorkflowTemplateUserMapping> listWorkflowTemplateUserMapping){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		workflowTemplateUserMappingDAO.deleteAll(listWorkflowTemplateUserMapping);
    }
    
    /**
	 * This method returns list of WorkflowTemplateUserMapping objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMapping> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return workflowTemplateUserMappingDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns WorkflowTemplateUserMapping object for a given data
	 * 
	 * @param WorkflowTemplateUserMapping as workflowTemplateUserMapping
	 * @return WorkflowTemplateUserMapping as model object
	 */
	public WorkflowTemplateUserMapping checkForDuplicates(WorkflowTemplateUserMapping workflowTemplateUserMapping)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return workflowTemplateUserMappingDAO.checkForDuplicates(workflowTemplateUserMapping);
		
	}
	
	    /**
	 * This method returns list of WorkflowTemplateUserMapping objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMapping> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return workflowTemplateUserMappingDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}

    /**
	 * This method returns list of WorkflowTemplateUserMapping objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMapping> getListByHqlQuery(String hqlQuery) 
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByHqlQuery Method is called");
		}
		return workflowTemplateUserMappingDAO.getListByHqlQuery(hqlQuery);
	}

    /**
	 * This method returns list of WorkflowTemplateUserMapping objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMapping> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return workflowTemplateUserMappingDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return workflowTemplateUserMappingDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	
	public WorkflowTemplateUserMapping getByEntityAndArea(long workflowTemplateId,long areaId) 
	{
		if (log.isDebugEnabled()) {
			log.debug("getByEntityAndArea Method is called");
		}
		return workflowTemplateUserMappingDAO.getByEntityAndArea(workflowTemplateId,areaId);
	}
	public List<WorkflowTemplateUserMapping> getWorkflowTemplateUserMappingListBySearch(WorkflowTemplateUserMappingSearch searchWorkflowTemplateUserMapping)
	{
		if (log.isDebugEnabled()) {
			log.debug("getWorkflowTemplateUserMappingListBySearch Method is called");
		}
		return workflowTemplateUserMappingDAO.getWorkflowTemplateUserMappingListBySearch(searchWorkflowTemplateUserMapping);
	}
	public long getWorkflowTemplateUserMappingCountBySearch(WorkflowTemplateUserMappingSearch searchWorkflowTemplateUserMapping)
	{
		if (log.isDebugEnabled()) {
			log.debug("getWorkflowTemplateUserMappingCountBySearch Method is called");
		}
		return workflowTemplateUserMappingDAO.getWorkflowTemplateUserMappingCountBySearch(searchWorkflowTemplateUserMapping);

	}

	@Override
	public List<WorkflowTemplateUserMapping> getByArea(long parseLong) {
		// TODO Auto-generated method stub
		return workflowTemplateUserMappingDAO.getByArea(parseLong);
	}

	
	
}

