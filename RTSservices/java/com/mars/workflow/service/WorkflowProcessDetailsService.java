package com.mars.workflow.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.workflow.model.WorkflowProcessDetails;

/**
 * <p>
 * Title: WorkflowProcessDetailsService.java
 * </p>
 * 
 * <p>
 * Description: This interface is used for service implementations related to
 * WorkflowProcessDetails
 * </p>
 * 
 * @see com.egov.common.model.WorkflowProcessDetails
 * 
 * Copyright (c) 2014 for eGovernance Goa
 * 
 * @version: 1.0
 * 
 * 
 * 
 */
@Transactional(readOnly = true)
public interface WorkflowProcessDetailsService {

	/**
	 * This method returns WorkflowProcessDetails object for a given Id
	 * 
	 * @param id
	 *            as long
	 * @return WorkflowProcessDetails as model object
	 */
	public WorkflowProcessDetails get(long id);

	/**
	 * This method save/updates the WorkflowProcessDetails information to the
	 * database.
	 * 
	 * @param WorkflowProcessDetails
	 *            object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(WorkflowProcessDetails entity);

	/**
	 * This method delete WorkflowProcessDetails for a given Id
	 * 
	 * @param id
	 *            as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void delete(long id);

	/**
	 * This method will return a list of all WorkflowProcessDetails from the
	 * database
	 * 
	 * @return List of WorkflowProcessDetails
	 */
	public List<WorkflowProcessDetails> getAll();

	/**
	 * This method save/updates a list of WorkflowProcessDetails information to
	 * the database.
	 * 
	 * @param listWorkflowProcessDetails
	 *            as List
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveAll(List<WorkflowProcessDetails> listWorkflowProcessDetails);

	/**
	 * This method is used to delete a list of Module records from the database.
	 * 
	 * @param listWorkflowProcessDetails
	 *            as List
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void deleteAll(List<WorkflowProcessDetails> listWorkflowProcessDetails);

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
	public List<WorkflowProcessDetails> getWorkflowProcessDetailsList(long pageNumber, String orderBy, String sortBy);

	/**
	 * This method returns count of the WorkflowProcessDetails objects from the
	 * database
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getWorkflowProcessDetailsCount();

	/**
	 * This method returns WorkflowProcessDetails objects from the database by
	 * process Id
	 * 
	 * @param processId
	 * @return WorkflowProcessDetails
	 * @exception Exception
	 */
	public WorkflowProcessDetails getWorkflowProcessDetailsByProcessId(String processId);

	/**
	 * This method returns WorkflowProcessDetails objects from the database by
	 * entity Id and entity Name
	 * 
	 * @param entityId
	 * @param entityName
	 * @return WorkflowProcessDetails
	 * @exception Exception
	 */
	public WorkflowProcessDetails getWorkflowProcessDetailsByEntityDetails(long entityId, String entityName);

	/**
	 * This method returns list of taskinstnces for the processId
	 * 
	 * @param processId
	 * @return list of TaskInstances
	 * @exception Exception
	 */
	
	// public List<TaskInstance> getTaskHistory(long processId);

	 /**
	 * This method returns WorkflowProcessDetails objects from the database by
	 * entity Id and entity Name
	 * 
	 * @param entityId
	 * @param entityName
	 * @return List of WorkflowProcessDetails
	 * @exception Exception
	 */
	public List<WorkflowProcessDetails> getAllWorkflowProcessDetailsByEntityDetails(long entityId, String entityName);
	
	public List<WorkflowProcessDetails> getAllWorkflowProcessDetailsByEntityId(long entityId);
	
}
