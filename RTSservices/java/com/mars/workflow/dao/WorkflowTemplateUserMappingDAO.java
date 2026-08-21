package com.mars.workflow.dao;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.workflow.model.WorkflowTemplateUserMapping;
import com.mars.workflow.model.WorkflowTemplateUserMappingSearch;
/**
 * <p>Title: WorkflowTemplateUserMappingDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for WorkflowTemplateUserMapping</p>

 * @see com.mars.workflow.model.WorkflowTemplateUserMapping
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

public interface WorkflowTemplateUserMappingDAO {

  
	/**
	 * This method returns WorkflowTemplateUserMapping object for a given Id
	 * 
	 * @param id as long
	 * @return WorkflowTemplateUserMapping as model object
	 */
	public WorkflowTemplateUserMapping get(long id);
		
    
    /**
	 * This method save/updates the WorkflowTemplateUserMapping information to the database.
	 * 
	 * @param WorkflowTemplateUserMapping object
	 * 
	 */
	public void save(WorkflowTemplateUserMapping entity);
	
     /**
	 * This method to merge the WorkflowTemplateUserMapping information to the database.
	 * 
	 * @param WorkflowTemplateUserMapping object
	 * 
	 */
    public WorkflowTemplateUserMapping merge(WorkflowTemplateUserMapping entity);
    
    /**
	 * This method delete WorkflowTemplateUserMapping for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all WorkflowTemplateUserMapping from the database
	 * 
	 * @return List of WorkflowTemplateUserMapping
	 */
	public List<WorkflowTemplateUserMapping> getAll();
	
	/**
     * This method save/updates a list of WorkflowTemplateUserMapping information to the database.
     * 
     * @param listWorkflowTemplateUserMapping as List
     * 
     */
    public void saveAll(List<WorkflowTemplateUserMapping> listWorkflowTemplateUserMapping);
    
    
    /**
     * This method is used to delete a list of WorkflowTemplateUserMapping records from the database.
     * 
     * @param listWorkflowTemplateUserMapping as List
     */
    public void deleteAll(List<WorkflowTemplateUserMapping> listWorkflowTemplateUserMapping);
    
	    /**
		 * This method returns list of the WorkflowTemplateUserMapping objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<WorkflowTemplateUserMapping> getWorkflowTemplateUserMappingList(long pageNumber,String orderBy, String sortBy);
		
		/**
		 * This method returns count of the WorkflowTemplateUserMapping objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getWorkflowTemplateUserMappingCount();
	
	
	/**
	 * This method returns list of WorkflowTemplateUserMapping objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<WorkflowTemplateUserMapping> findByProperty(String propertyName, Object value);

	/**
	 * This method returns WorkflowTemplateUserMapping object for a given data
	 * 
	 * @param WorkflowTemplateUserMapping as workflowTemplateUserMapping
	 * @return WorkflowTemplateUserMapping as model object
	 */
	public WorkflowTemplateUserMapping checkForDuplicates(WorkflowTemplateUserMapping workflowTemplateUserMapping);
	
	/**
	 * This method returns list of WorkflowTemplateUserMapping objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMapping> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);

    /**
	 * This method returns list of WorkflowTemplateUserMapping objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMapping> getListByHqlQuery(String hqlQuery);
	
    /**
	 * This method returns list of WorkflowTemplateUserMapping objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMapping> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
	public WorkflowTemplateUserMapping getByEntityAndArea(long workflowTemplateId,long areaId);
	
	public List<WorkflowTemplateUserMapping> getWorkflowTemplateUserMappingListBySearch(WorkflowTemplateUserMappingSearch searchWorkflowTemplateUserMapping);
	
	public long getWorkflowTemplateUserMappingCountBySearch(WorkflowTemplateUserMappingSearch searchWorkflowTemplateUserMapping);
	public List<WorkflowTemplateUserMapping> getByArea(long areaId);



}

