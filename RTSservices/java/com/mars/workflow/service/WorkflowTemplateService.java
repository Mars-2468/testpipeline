package com.mars.workflow.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.workflow.model.WorkflowTemplate;
/**
* <p>Title: WorkflowTemplateService.java </p>

 * <p>Description: This interface is used for service implementations related to WorkflowTemplate</p>

 * @see com.mars.workflow.model.WorkflowTemplate
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface WorkflowTemplateService {
  
	/**
	 * This method returns WorkflowTemplate object for a given Id
	 * 
	 * @param id as long
	 * @return WorkflowTemplate as model object
	 */
	public WorkflowTemplate get(long id);
		
    /**
	 * This method save/updates the WorkflowTemplate information to the database.
	 * 
	 * @param WorkflowTemplate object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(WorkflowTemplate entity);
	  
	/**
	 * This method to merge the WorkflowTemplate information to the database.
	 * 
	 * @param WorkflowTemplate object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public WorkflowTemplate merge(WorkflowTemplate entity); 
	    
    /**
	 * This method delete WorkflowTemplate for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all WorkflowTemplate from the database
	 * 
	 * @return List of WorkflowTemplate
	 */
	public List<WorkflowTemplate> getAll();
	
	/**
     * This method save/updates a list of WorkflowTemplate information to the database.
     * 
     * @param listWorkflowTemplate as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<WorkflowTemplate> listWorkflowTemplate);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listWorkflowTemplate as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<WorkflowTemplate> listWorkflowTemplate);
    
	    /**
		 * This method returns list of the WorkflowTemplate objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<WorkflowTemplate> getWorkflowTemplateList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns count of the WorkflowTemplate objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getWorkflowTemplateCount();
	
	
	/**
	 * This method returns list of WorkflowTemplate objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<WorkflowTemplate> findByProperty(String propertyName, Object value);	    
    
    public List<WorkflowTemplate> findByProperty(String propertyName, Object value,long tenancyId);	    

	/**
	 * This method returns WorkflowTemplate object for a given data
	 * 
	 * @param WorkflowTemplate as workflowTemplate
	 * @return WorkflowTemplate as model object
	 */
	public WorkflowTemplate checkForDuplicates(WorkflowTemplate workflowTemplate);    

    /**
	 * This method returns list of WorkflowTemplate objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplate> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of WorkflowTemplate objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplate> getListByHqlQuery(String hqlQuery);
	
    /**
	 * This method returns list of WorkflowTemplate objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplate> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
}

