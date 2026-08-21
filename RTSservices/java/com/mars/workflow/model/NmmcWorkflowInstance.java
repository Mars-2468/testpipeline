package com.mars.workflow.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NmmcWorkflowInstance {

	public String status = "";
	public String id = "";
	public String name = "";
	public String relatedEntityName = "";
	public String relatedEntityId = "";
	public String desc = "";
	public Date startDate;
	public Date dueDate;
	public long priority;
	public long taskId;

	public List<NmmcWorkflowTransition> transitions = new ArrayList<NmmcWorkflowTransition>();

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRelatedEntityName() {
		return relatedEntityName;
	}

	public void setRelatedEntityName(String relatedEntityName) {
		this.relatedEntityName = relatedEntityName;
	}

	public String getRelatedEntityId() {
		return relatedEntityId;
	}

	public void setRelatedEntityId(String relatedEntityId) {
		this.relatedEntityId = relatedEntityId;
	}

	public List<NmmcWorkflowTransition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<NmmcWorkflowTransition> transitions) {
		this.transitions = transitions;
	}

	public long getPriority() {
		return priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the taskId
	 */
	public long getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            the taskId to set
	 */
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

}
