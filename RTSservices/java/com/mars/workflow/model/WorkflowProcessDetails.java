package com.mars.workflow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p>
 * Title: WorkflowProcessDetails.java
 * </p>
 * 
 * <p>
 * Description: Model class for WorkflowProcessDetails
 * </p>
 * 
 * Copyright (c) 2014 for eGovernance Rajasthan
 * 
 * @version: 1.0
 * 
 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */

    @Entity
    @Table(name = "WORKFLOW_PROCESS_DETAILS", schema = "egovrti")
    public class WorkflowProcessDetails implements java.io.Serializable {
	private static final long serialVersionUID = -5433457509373259719L;

	@Id	
    @Column(name="WORKFLOW_PROCESS_DETAILS_ID", nullable=false ,unique=true)	
    @SequenceGenerator(name="WORKFLOW_PROCESS_DETAILS_seq", sequenceName="WORKFLOW_PROCESS_DETAILS_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="WORKFLOW_PROCESS_DETAILS_seq") 
	private long workflowProcessDetailsId;

	@Column(name = "PROCESS_ID", unique = true, nullable = true)
	private String processId;

	@Column(name = "ENTITY_ID", unique = true, nullable = true)
	private long entityId;

	@Column(name = "ENTITY_NAME", unique = true, nullable = true)
	private String entityName;
	
	@Column(name = "ENTITY_DETAILS", unique = true, nullable = true)
	private String entityDetails;

	@Column(name = "STATUS", unique = true, nullable = false)
	private long workflowStatus;

	@Column(name = "USER_NAME", unique = true, nullable = true)
	private String userName;
	
	/*@Column(name = "TENANCYID", unique = true, nullable = true)
	private int tenancyid;*/
	
	public WorkflowProcessDetails() {
	}

	public WorkflowProcessDetails(String processId, long entityId, String entityName, long workflowStatus) {
		this.processId = processId;
		this.entityId = entityId;
		this.entityName = entityName;
		this.workflowStatus = workflowStatus;
	}

	public long getWorkflowProcessDetailsId() {
		return this.workflowProcessDetailsId;
	}

	public void setWorkflowProcessDetailsId(long workflowProcessDetailsId) {
		this.workflowProcessDetailsId = workflowProcessDetailsId;
	}

	public String getProcessId() {
		return this.processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public long getEntityId() {
		return this.entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return this.entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/**
	 * @return the entityDetails
	 */
	public String getEntityDetails() {
		return entityDetails;
	}

	/**
	 * @param entityDetails the entityDetails to set
	 */
	public void setEntityDetails(String entityDetails) {
		this.entityDetails = entityDetails;
	}

	public long getWorkflowStatus() {
		return workflowStatus;
	}

	public void setWorkflowStatus(long workflowStatus) {
		this.workflowStatus = workflowStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*public int getTenancyid() {
		return tenancyid;
	}

	public void setTenancyid(int tenancyid) {
		this.tenancyid = tenancyid;
	}*/
	
}
