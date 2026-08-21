package com.mars.workflow.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.workflow.dao.WorkflowTemplateTaskDAO;
import com.mars.workflow.model.WorkflowTemplateTask;
import com.mars.workflow.service.WorkflowTemplateTaskService;
 /**

 * <p>Title: WorkflowTemplateTaskServiceImpl.java </p>

 * @see com.mars.workflow.model.WorkflowTemplateTask
 
 * <p>Description: This class is used for hibernate operations for WorkflowTemplateTask module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("workflowTemplateTaskService") 
public class WorkflowTemplateTaskServiceImpl implements WorkflowTemplateTaskService {

    private static final Log log = LogFactory.getLog(WorkflowTemplateTaskServiceImpl.class);

  	
	@Autowired
	private WorkflowTemplateTaskDAO workflowTemplateTaskDAO;

	public void setWorkflowTemplateTaskDAO(WorkflowTemplateTaskDAO workflowTemplateTaskDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setWorkflowTemplateTaskDAO Method is called ");
		}
		this.workflowTemplateTaskDAO = workflowTemplateTaskDAO;
	}

	/**
	 * This method is saves the WorkflowTemplateTask object
	 * 
	 * @param entity as WorkflowTemplateTask object
	 * @return
	 * 
	 */
	public void save(WorkflowTemplateTask entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		workflowTemplateTaskDAO.save(entity);
	}

     /**
	 * This method to merge the WorkflowTemplateTask information to the database.
	 * 
	 * @param WorkflowTemplateTask object
	 * 
	 */
    public WorkflowTemplateTask merge(WorkflowTemplateTask entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return workflowTemplateTaskDAO.merge(entity);
	}

	/**
	 * This method delete the workflowTemplateTask
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		workflowTemplateTaskDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a WorkflowTemplateTask Object
	 * 
	 */
	public WorkflowTemplateTask get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return workflowTemplateTaskDAO.get(id);
	}
	
	/**
	 * This method will return a list of all WorkflowTemplateTask from the database
	 * 
	 * @return List of WorkflowTemplateTask
	 */
	public List<WorkflowTemplateTask> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return workflowTemplateTaskDAO.getAll();
	}
	
		/**
		 * This method returns list of the WorkflowTemplateTask objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<WorkflowTemplateTask> getWorkflowTemplateTaskList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getWorkflowTemplateTaskList Method is called");
			}
			return workflowTemplateTaskDAO.getWorkflowTemplateTaskList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * This method returns count of the WorkflowTemplateTask objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getWorkflowTemplateTaskCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getWorkflowTemplateTaskCount Method is called");
			}
			return workflowTemplateTaskDAO.getWorkflowTemplateTaskCount();
		}	
	
	
	/**
     * This method save/updates a list of WorkflowTemplateTask information to the database.
     * 
     * @param listWorkflowTemplateTask as List
     * 
     */
    public void saveAll(List<WorkflowTemplateTask> listWorkflowTemplateTask){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		workflowTemplateTaskDAO.saveAll(listWorkflowTemplateTask);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listWorkflowTemplateTask as List
     */
    public void deleteAll(List<WorkflowTemplateTask> listWorkflowTemplateTask){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		workflowTemplateTaskDAO.deleteAll(listWorkflowTemplateTask);
    }
    
    /**
	 * This method returns list of WorkflowTemplateTask objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateTask> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return workflowTemplateTaskDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns WorkflowTemplateTask object for a given data
	 * 
	 * @param WorkflowTemplateTask as workflowTemplateTask
	 * @return WorkflowTemplateTask as model object
	 */
	public WorkflowTemplateTask checkForDuplicates(WorkflowTemplateTask workflowTemplateTask)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return workflowTemplateTaskDAO.checkForDuplicates(workflowTemplateTask);
		
	}
	
	    /**
	 * This method returns list of WorkflowTemplateTask objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateTask> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return workflowTemplateTaskDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}

    /**
	 * This method returns list of WorkflowTemplateTask objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateTask> getListByHqlQuery(String hqlQuery) 
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByHqlQuery Method is called");
		}
		return workflowTemplateTaskDAO.getListByHqlQuery(hqlQuery);
	}

    /**
	 * This method returns list of WorkflowTemplateTask objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateTask> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return workflowTemplateTaskDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return workflowTemplateTaskDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
}

