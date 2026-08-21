package com.mars.workflow.model;

import java.io.Serializable;

import javax.persistence.Transient;

import org.jbpm.api.task.Task;

import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
 

public class PersonalTask implements Serializable{

	private static final long serialVersionUID = -7688406968444061862L;

	private Task task;

	private long entityId;

	private String entityName;

	private String workflowInitator;
	
	private String workflowName;
	
	private String entityDetails; 
	
	private RTIApplication rtiApplication;
	
	private RTIApplicationDetails rtiApplicationDetails;
	
	@Transient
	private String zoneName;

	public long getEntityId() {
		return entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public String getWorkflowInitator() {
		return workflowInitator;
	}

	public void setWorkflowInitator(String workflowInitator) {
		this.workflowInitator = workflowInitator;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getEntityDetails() {
		return entityDetails;
	}

	public void setEntityDetails(String entityDetails) {
		this.entityDetails = entityDetails;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public RTIApplication getRtiApplication() {
		return rtiApplication;
	}

	public void setRtiApplication(RTIApplication rtiApplication) {
		this.rtiApplication = rtiApplication;
	}

	public RTIApplicationDetails getRtiApplicationDetails() {
		return rtiApplicationDetails;
	}

	public void setRtiApplicationDetails(RTIApplicationDetails rtiApplicationDetails) {
		this.rtiApplicationDetails = rtiApplicationDetails;
	}
 
	

	
}
