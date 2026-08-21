package com.mars.common.model;

public class PendingTasksList {

	private String taskName;
	private String penadingAt;
	private String entityName;
	private String entityDetail;
	private long pendingHours;
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getPenadingAt() {
		return penadingAt;
	}
	public void setPenadingAt(String penadingAt) {
		this.penadingAt = penadingAt;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getEntityDetail() {
		return entityDetail;
	}
	public void setEntityDetail(String entityDetail) {
		this.entityDetail = entityDetail;
	}
	public long getPendingHours() {
		return pendingHours;
	}
	public void setPendingHours(long pendingHours) {
		this.pendingHours = pendingHours;
	}

	
	
	
}
