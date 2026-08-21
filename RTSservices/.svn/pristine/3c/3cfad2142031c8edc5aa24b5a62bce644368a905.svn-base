package com.mars.workflow.model;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class TaskHistoryDetails implements java.io.Serializable {

	private String taskId;

	private String Comments;

	private Date createTime;

	private Date endTime;

	private String assignee;

	private String activityName;

	private String outcome;

	private String executionId;

	private String entityName;

	private String entityId;
	
	private String entityDetails;

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		if(StringUtils.isNotEmpty(outcome)){
			if(outcome.equalsIgnoreCase("jbpm_no_task_outcome_specified_jbpm"))
				outcome = "Discarded";
		}
		this.outcome = outcome;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getEntityDetails() {
		return entityDetails;
	}

	public void setEntityDetails(String entityDetails) {
		this.entityDetails = entityDetails;
	}
}
