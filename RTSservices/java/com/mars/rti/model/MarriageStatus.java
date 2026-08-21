package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marriaage_status",schema="egovcommon")
public class MarriageStatus {

	@Id
	@Column(name="status_id")
	private long statusId;
	
	@Column(name="status")
	private String status;

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
