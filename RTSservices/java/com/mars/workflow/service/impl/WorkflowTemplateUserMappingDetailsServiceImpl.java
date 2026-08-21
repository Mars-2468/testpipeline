package com.mars.workflow.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.workflow.dao.WorkflowTemplateUserMappingDetailsDAO;
import com.mars.workflow.model.WorkflowTemplateUserMappingDetails;
import com.mars.workflow.service.WorkflowTemplateUserMappingDetailsService;
 /**

 * <p>Title: WorkflowTemplateUserMappingDetailsServiceImpl.java </p>

 * @see com.mars.workflow.model.WorkflowTemplateUserMappingDetails
 
 * <p>Description: This class is used for hibernate operations for WorkflowTemplateUserMappingDetails module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("workflowTemplateUserMappingDetailsService") 
public class WorkflowTemplateUserMappingDetailsServiceImpl implements WorkflowTemplateUserMappingDetailsService {

    private static final Log log = LogFactory.getLog(WorkflowTemplateUserMappingDetailsServiceImpl.class);

  	
	@Autowired
	private WorkflowTemplateUserMappingDetailsDAO workflowTemplateUserMappingDetailsDAO;

	public void setWorkflowTemplateUserMappingDetailsDAO(WorkflowTemplateUserMappingDetailsDAO workflowTemplateUserMappingDetailsDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setWorkflowTemplateUserMappingDetailsDAO Method is called ");
		}
		this.workflowTemplateUserMappingDetailsDAO = workflowTemplateUserMappingDetailsDAO;
	}

	/**
	 * This method is saves the WorkflowTemplateUserMappingDetails object
	 * 
	 * @param entity as WorkflowTemplateUserMappingDetails object
	 * @return
	 * 
	 */
	public void save(WorkflowTemplateUserMappingDetails entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		workflowTemplateUserMappingDetailsDAO.save(entity);
	}

     /**
	 * This method to merge the WorkflowTemplateUserMappingDetails information to the database.
	 * 
	 * @param WorkflowTemplateUserMappingDetails object
	 * 
	 */
    public WorkflowTemplateUserMappingDetails merge(WorkflowTemplateUserMappingDetails entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return workflowTemplateUserMappingDetailsDAO.merge(entity);
	}

	/**
	 * This method delete the workflowTemplateUserMappingDetails
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		workflowTemplateUserMappingDetailsDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a WorkflowTemplateUserMappingDetails Object
	 * 
	 */
	public WorkflowTemplateUserMappingDetails get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return workflowTemplateUserMappingDetailsDAO.get(id);
	}
	
	/**
	 * This method will return a list of all WorkflowTemplateUserMappingDetails from the database
	 * 
	 * @return List of WorkflowTemplateUserMappingDetails
	 */
	public List<WorkflowTemplateUserMappingDetails> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return workflowTemplateUserMappingDetailsDAO.getAll();
	}
	
		/**
		 * This method returns list of the WorkflowTemplateUserMappingDetails objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<WorkflowTemplateUserMappingDetails> getWorkflowTemplateUserMappingDetailsList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getWorkflowTemplateUserMappingDetailsList Method is called");
			}
			return workflowTemplateUserMappingDetailsDAO.getWorkflowTemplateUserMappingDetailsList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * This method returns count of the WorkflowTemplateUserMappingDetails objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getWorkflowTemplateUserMappingDetailsCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getWorkflowTemplateUserMappingDetailsCount Method is called");
			}
			return workflowTemplateUserMappingDetailsDAO.getWorkflowTemplateUserMappingDetailsCount();
		}	
	
	
	/**
     * This method save/updates a list of WorkflowTemplateUserMappingDetails information to the database.
     * 
     * @param listWorkflowTemplateUserMappingDetails as List
     * 
     */
    public void saveAll(List<WorkflowTemplateUserMappingDetails> listWorkflowTemplateUserMappingDetails){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		workflowTemplateUserMappingDetailsDAO.saveAll(listWorkflowTemplateUserMappingDetails);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listWorkflowTemplateUserMappingDetails as List
     */
    public void deleteAll(List<WorkflowTemplateUserMappingDetails> listWorkflowTemplateUserMappingDetails){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		workflowTemplateUserMappingDetailsDAO.deleteAll(listWorkflowTemplateUserMappingDetails);
    }
    
    /**
	 * This method returns list of WorkflowTemplateUserMappingDetails objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMappingDetails> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return workflowTemplateUserMappingDetailsDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns WorkflowTemplateUserMappingDetails object for a given data
	 * 
	 * @param WorkflowTemplateUserMappingDetails as workflowTemplateUserMappingDetails
	 * @return WorkflowTemplateUserMappingDetails as model object
	 */
	public WorkflowTemplateUserMappingDetails checkForDuplicates(WorkflowTemplateUserMappingDetails workflowTemplateUserMappingDetails)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return workflowTemplateUserMappingDetailsDAO.checkForDuplicates(workflowTemplateUserMappingDetails);
		
	}
	
	    /**
	 * This method returns list of WorkflowTemplateUserMappingDetails objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMappingDetails> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return workflowTemplateUserMappingDetailsDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}

    /**
	 * This method returns list of WorkflowTemplateUserMappingDetails objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMappingDetails> getListByHqlQuery(String hqlQuery) 
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByHqlQuery Method is called");
		}
		return workflowTemplateUserMappingDetailsDAO.getListByHqlQuery(hqlQuery);
	}

    /**
	 * This method returns list of WorkflowTemplateUserMappingDetails objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplateUserMappingDetails> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return workflowTemplateUserMappingDetailsDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return workflowTemplateUserMappingDetailsDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}

	@Override
	public List<WorkflowTemplateUserMappingDetails> getByName(String userName) {
		// TODO Auto-generated method stub
		return workflowTemplateUserMappingDetailsDAO.getByName(userName);
	}	
}

