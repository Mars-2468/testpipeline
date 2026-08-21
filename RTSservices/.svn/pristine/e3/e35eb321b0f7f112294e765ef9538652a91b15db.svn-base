package com.mars.workflow.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.workflow.model.WorkflowTemplateTask;
/**
* <p>Title: WorkflowTemplateTaskService.java </p>

 * <p>Description: This interface is used for service implementations related to WorkflowTemplateTask</p>

 * @see com.mars.workflow.model.WorkflowTemplateTask
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface WorkflowTemplateTaskService {
  
	/**
	 * This method returns WorkflowTemplateTask object for a given Id
	 * 
	 * @param id as long
	 * @return WorkflowTemplateTask as model object
	 */
	public WorkflowTemplateTask get(long id);
		
    /**
	 * This method save/updates the WorkflowTemplateTask information to the database.
	 * 
	 * @param WorkflowTemplateTask object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(WorkflowTemplateTask entity);
	  
	/**
	 * This method to merge the WorkflowTemplateTask information to the database.
	 * 
	 * @param WorkflowTemplateTask object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public WorkflowTemplateTask merge(WorkflowTemplateTask entity); 
	    
    /**
	 * This method delete WorkflowTemplateTask for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all WorkflowTemplateTask from the database
	 * 
	 * @return List of WorkflowTemplateTask
	 */
	public List<WorkflowTemplateTask> getAll();
	
	/**
     * This method save/updates a list of WorkflowTemplateTask information to the database.
     * 
     * @param listWorkflowTemplateTask as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<WorkflowTemplateTask> listWorkflowTemplateTask);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listWorkflowTemplateTask as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<WorkflowTemplateTask> listWorkflowTemplateTask);
    
	    /**
		 * This method returns list of the WorkflowTemplateTask objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<WorkflowTemplateTask> getWorkflowTemplateTaskList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns count of the WorkflowTemplateTask objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getWorkflowTemplateTaskCount();
	
	
	/**
	 * This method returns list of WorkflowTemplateTask objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<WorkflowTemplateTask> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns WorkflowTemplateTask object for a given data
	 * 
	 * @param WorkflowTemplateTask as workflowTemplateTask
	 * @return WorkflowTemplateTask as model object
	 */
	public WorkflowTemplateTask checkForDuplicates(WorkflowTemplateTask workflowTemplateTask);    

    /**
	 * This method returns list of WorkflowTemplateTask objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateTask> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of WorkflowTemplateTask objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateTask> getListByHqlQuery(String hqlQuery);
	
    /**
	 * This method returns list of WorkflowTemplateTask objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateTask> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
}

