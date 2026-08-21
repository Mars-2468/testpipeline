package com.mars.workflow.model;

import java.util.ArrayList;
import java.util.List;

public class WorkflowTaskDefinition implements java.io.Serializable {

	private long taskPosition;

	private String taskName;

	private String assignee;

	private long escalationDueDays = 1;

	List<WorkflowTaskTransition> transitionList = new ArrayList<WorkflowTaskTransition>();

	/**
	 * @return the taskPosition
	 */
	public long getTaskPosition() {
		return taskPosition;
	}

	/**
	 * @param taskPosition
	 *            the taskPosition to set
	 */
	public void setTaskPosition(long taskPosition) {
		this.taskPosition = taskPosition;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName
	 *            the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the assignee
	 */
	public String getAssignee() {
		return assignee;
	}

	/**
	 * @param assignee
	 *            the assignee to set
	 */
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	/**
	 * @return the transitionList
	 */
	public List<WorkflowTaskTransition> getTransitionList() {
		return transitionList;
	}

	/**
	 * @param transitionList
	 *            the transitionList to set
	 */
	public void setTransitionList(List<WorkflowTaskTransition> transitionList) {
		this.transitionList = transitionList;
	}

	public long getEscalationDueDays() {
		return escalationDueDays;
	}

	public void setEscalationDueDays(long escalationDueDays) {
		this.escalationDueDays = escalationDueDays;
	}

}
