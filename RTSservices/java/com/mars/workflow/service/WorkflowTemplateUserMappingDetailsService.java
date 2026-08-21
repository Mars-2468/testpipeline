package com.mars.workflow.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.workflow.model.WorkflowTemplateUserMappingDetails;
/**
* <p>Title: WorkflowTemplateUserMappingDetailsService.java </p>

 * <p>Description: This interface is used for service implementations related to WorkflowTemplateUserMappingDetails</p>

 * @see com.mars.workflow.model.WorkflowTemplateUserMappingDetails
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface WorkflowTemplateUserMappingDetailsService {
  
	/**
	 * This method returns WorkflowTemplateUserMappingDetails object for a given Id
	 * 
	 * @param id as long
	 * @return WorkflowTemplateUserMappingDetails as model object
	 */
	public WorkflowTemplateUserMappingDetails get(long id);
		
    /**
	 * This method save/updates the WorkflowTemplateUserMappingDetails information to the database.
	 * 
	 * @param WorkflowTemplateUserMappingDetails object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(WorkflowTemplateUserMappingDetails entity);
	  
	/**
	 * This method to merge the WorkflowTemplateUserMappingDetails information to the database.
	 * 
	 * @param WorkflowTemplateUserMappingDetails object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public WorkflowTemplateUserMappingDetails merge(WorkflowTemplateUserMappingDetails entity); 
	    
    /**
	 * This method delete WorkflowTemplateUserMappingDetails for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all WorkflowTemplateUserMappingDetails from the database
	 * 
	 * @return List of WorkflowTemplateUserMappingDetails
	 */
	public List<WorkflowTemplateUserMappingDetails> getAll();
	
	/**
     * This method save/updates a list of WorkflowTemplateUserMappingDetails information to the database.
     * 
     * @param listWorkflowTemplateUserMappingDetails as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<WorkflowTemplateUserMappingDetails> listWorkflowTemplateUserMappingDetails);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listWorkflowTemplateUserMappingDetails as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<WorkflowTemplateUserMappingDetails> listWorkflowTemplateUserMappingDetails);
    
	    /**
		 * This method returns list of the WorkflowTemplateUserMappingDetails objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<WorkflowTemplateUserMappingDetails> getWorkflowTemplateUserMappingDetailsList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns count of the WorkflowTemplateUserMappingDetails objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getWorkflowTemplateUserMappingDetailsCount();
	
	
	/**
	 * This method returns list of WorkflowTemplateUserMappingDetails objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<WorkflowTemplateUserMappingDetails> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns WorkflowTemplateUserMappingDetails object for a given data
	 * 
	 * @param WorkflowTemplateUserMappingDetails as workflowTemplateUserMappingDetails
	 * @return WorkflowTemplateUserMappingDetails as model object
	 */
	public WorkflowTemplateUserMappingDetails checkForDuplicates(WorkflowTemplateUserMappingDetails workflowTemplateUserMappingDetails);    

    /**
	 * This method returns list of WorkflowTemplateUserMappingDetails objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMappingDetails> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of WorkflowTemplateUserMappingDetails objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMappingDetails> getListByHqlQuery(String hqlQuery);
	
    /**
	 * This method returns list of WorkflowTemplateUserMappingDetails objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMappingDetails> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
	public List<WorkflowTemplateUserMappingDetails> getByName(String userName);

}

