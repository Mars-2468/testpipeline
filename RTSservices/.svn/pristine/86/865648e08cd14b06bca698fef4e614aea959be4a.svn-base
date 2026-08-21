package com.mars.workflow.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.workflow.dao.WorkflowTemplateDAO;
import com.mars.workflow.model.WorkflowTemplate;
import com.mars.workflow.service.WorkflowTemplateService;
 /**

 * <p>Title: WorkflowTemplateServiceImpl.java </p>

 * @see com.mars.workflow.model.WorkflowTemplate
 
 * <p>Description: This class is used for hibernate operations for WorkflowTemplate module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("workflowTemplateService") 
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private static final Log log = LogFactory.getLog(WorkflowTemplateServiceImpl.class);

  	
	@Autowired
	private WorkflowTemplateDAO workflowTemplateDAO;

	public void setWorkflowTemplateDAO(WorkflowTemplateDAO workflowTemplateDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setWorkflowTemplateDAO Method is called ");
		}
		this.workflowTemplateDAO = workflowTemplateDAO;
	}

	/**
	 * This method is saves the WorkflowTemplate object
	 * 
	 * @param entity as WorkflowTemplate object
	 * @return
	 * 
	 */
	public void save(WorkflowTemplate entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		workflowTemplateDAO.save(entity);
	}

     /**
	 * This method to merge the WorkflowTemplate information to the database.
	 * 
	 * @param WorkflowTemplate object
	 * 
	 */
    public WorkflowTemplate merge(WorkflowTemplate entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return workflowTemplateDAO.merge(entity);
	}

	/**
	 * This method delete the workflowTemplate
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		workflowTemplateDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a WorkflowTemplate Object
	 * 
	 */
	public WorkflowTemplate get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return workflowTemplateDAO.get(id);
	}
	
	/**
	 * This method will return a list of all WorkflowTemplate from the database
	 * 
	 * @return List of WorkflowTemplate
	 */
	public List<WorkflowTemplate> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return workflowTemplateDAO.getAll();
	}
	
		/**
		 * This method returns list of the WorkflowTemplate objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<WorkflowTemplate> getWorkflowTemplateList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getWorkflowTemplateList Method is called");
			}
			return workflowTemplateDAO.getWorkflowTemplateList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * This method returns count of the WorkflowTemplate objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getWorkflowTemplateCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getWorkflowTemplateCount Method is called");
			}
			return workflowTemplateDAO.getWorkflowTemplateCount();
		}	
	
	
	/**
     * This method save/updates a list of WorkflowTemplate information to the database.
     * 
     * @param listWorkflowTemplate as List
     * 
     */
    public void saveAll(List<WorkflowTemplate> listWorkflowTemplate){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		workflowTemplateDAO.saveAll(listWorkflowTemplate);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listWorkflowTemplate as List
     */
    public void deleteAll(List<WorkflowTemplate> listWorkflowTemplate){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		workflowTemplateDAO.deleteAll(listWorkflowTemplate);
    }
    
    /**
	 * This method returns list of WorkflowTemplate objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplate> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return workflowTemplateDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns WorkflowTemplate object for a given data
	 * 
	 * @param WorkflowTemplate as workflowTemplate
	 * @return WorkflowTemplate as model object
	 */
	public WorkflowTemplate checkForDuplicates(WorkflowTemplate workflowTemplate)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return workflowTemplateDAO.checkForDuplicates(workflowTemplate);
		
	}
	
	    /**
	 * This method returns list of WorkflowTemplate objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplate> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return workflowTemplateDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}

    /**
	 * This method returns list of WorkflowTemplate objects available based on the query names passed.
	 * @param String hqlQuery
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplate> getListByHqlQuery(String hqlQuery) 
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByHqlQuery Method is called");
		}
		return workflowTemplateDAO.getListByHqlQuery(hqlQuery);
	}

    /**
	 * This method returns list of WorkflowTemplate objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowTemplate> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return workflowTemplateDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return workflowTemplateDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}

	@Override
	public List<WorkflowTemplate> findByProperty(String propertyName,Object value, long tenancyId) {
		if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return workflowTemplateDAO.findByProperty(propertyName,value,tenancyId);
	}	
}

