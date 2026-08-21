package com.mars.workflow.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.workflow.dao.WorkflowProcessDetailsDAO;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;

/**
 * 
 * <p>
 * Title: WorkflowProcessDetailsServiceImpl.java
 * </p>
 * 
 * @see com.egov.common.model.WorkflowProcessDetails
 * 
 * <p>
 * Description: This class is used for hibernate operations for
 * WorkflowProcessDetails module
 * </p>
 * 
 * Copyright (c) 2014 for eGovernance Rajasthan
 * 
 * @version: 1.0
 * 
 * 
 * 
 */

@Service("workflowProcessDetailsService")
public class WorkflowProcessDetailsServiceImpl implements WorkflowProcessDetailsService {

	private static final Log log = LogFactory.getLog(WorkflowProcessDetailsServiceImpl.class);

	@Autowired
	private WorkflowProcessDetailsDAO workflowProcessDetailsDAO;

	public void setWorkflowProcessDetailsDAO(WorkflowProcessDetailsDAO workflowProcessDetailsDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setWorkflowProcessDetailsDAO Method is called ");
		}
		this.workflowProcessDetailsDAO = workflowProcessDetailsDAO;
	}

	/**
	 * This method is saves the WorkflowProcessDetails object
	 * 
	 * @param entity
	 *            as WorkflowProcessDetails object
	 * @return
	 * 
	 */
	public void save(WorkflowProcessDetails entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		workflowProcessDetailsDAO.save(entity);
	}

	/**
	 * This method delete the workflowProcessDetails
	 * 
	 * @param Id
	 *            as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		workflowProcessDetailsDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id
	 *            as long
	 * @return a WorkflowProcessDetails Object
	 * 
	 */
	public WorkflowProcessDetails get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return workflowProcessDetailsDAO.get(id);
	}

	/**
	 * This method will return a list of all WorkflowProcessDetails from the
	 * database
	 * 
	 * @return List of WorkflowProcessDetails
	 */
	public List<WorkflowProcessDetails> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return workflowProcessDetailsDAO.getAll();
	}

	/**
	 * This method returns list of the WorkflowProcessDetails objects available
	 * based page number.
	 * 
	 * @param long
	 *            PageNumber
	 * @param String
	 *            orderBy
	 * @param String
	 *            sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<WorkflowProcessDetails> getWorkflowProcessDetailsList(long pageNumber, String orderBy, String sortBy) {

		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return workflowProcessDetailsDAO.getWorkflowProcessDetailsList(pageNumber, orderBy, sortBy);
	}

	/**
	 * This method returns count of the WorkflowProcessDetails objects available
	 * based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getWorkflowProcessDetailsCount() {
		if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		return workflowProcessDetailsDAO.getWorkflowProcessDetailsCount();
	}

	/**
	 * This method save/updates a list of WorkflowProcessDetails information to
	 * the database.
	 * 
	 * @param listWorkflowProcessDetails
	 *            as List
	 * 
	 */
	public void saveAll(List<WorkflowProcessDetails> listWorkflowProcessDetails) {
		if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		workflowProcessDetailsDAO.saveAll(listWorkflowProcessDetails);
	}

	/**
	 * This method is used to delete a list of Module records from the database.
	 * 
	 * @param listWorkflowProcessDetails
	 *            as List
	 */
	public void deleteAll(List<WorkflowProcessDetails> listWorkflowProcessDetails) {
		if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		workflowProcessDetailsDAO.deleteAll(listWorkflowProcessDetails);
	}

	/**
	 * This method returns WorkflowProcessDetails objects from the database by
	 * process Id
	 * 
	 * @param processId
	 * @return WorkflowProcessDetails
	 * @exception Exception
	 */
	public WorkflowProcessDetails getWorkflowProcessDetailsByProcessId(String processId) {
		if (log.isDebugEnabled()) {
			log.debug("getWorkflowProcessDetailsByProcessId Method is called");
		}
		return workflowProcessDetailsDAO.getWorkflowProcessDetailsByProcessId(processId);
	}

	/**
	 * This method returns WorkflowProcessDetails objects from the database by
	 * entity Id and entity Name
	 * 
	 * @param entityId
	 * @param entityName
	 * @return WorkflowProcessDetails
	 * @exception Exception
	 */
	public WorkflowProcessDetails getWorkflowProcessDetailsByEntityDetails(long entityId, String entityName) {
		if (log.isDebugEnabled()) {
			log.debug("getWorkflowProcessDetailsByProcessId Method is called");
		}
		return workflowProcessDetailsDAO.getWorkflowProcessDetailsByEntityDetails(entityId, entityName);
	}

	/**
	 * This method returns WorkflowProcessDetails objects from the database by
	 * entity Id and entity Name
	 * 
	 * @param entityId
	 * @param entityName
	 * @return List of WorkflowProcessDetails
	 * @exception Exception
	 */
	public List<WorkflowProcessDetails> getAllWorkflowProcessDetailsByEntityDetails(long entityId, String entityName) {
		if (log.isDebugEnabled()) {
			log.debug("getWorkflowProcessDetailsByProcessId Method is called");
		}
		return workflowProcessDetailsDAO.getAllWorkflowProcessDetailsByEntityDetails(entityId, entityName);
	}

	public List<WorkflowProcessDetails> getAllWorkflowProcessDetailsByEntityId(long entityId){
			if (log.isDebugEnabled()) {
				log.debug("getWorkflowProcessDetailsByProcessId Method is called");
			}
			return workflowProcessDetailsDAO.getAllWorkflowProcessDetailsByEntityId(entityId);
		
	}
}
