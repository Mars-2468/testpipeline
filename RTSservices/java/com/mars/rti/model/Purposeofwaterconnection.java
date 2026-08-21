package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="water_connection_purpose",schema="egovrti")

public class Purposeofwaterconnection {

	@Id
	@Column(name = "purpose_id", nullable = false, unique = true)
	private long purposeconnectionid;
	
	@Column(name = "purpose_name_value", nullable = false)
    private String purposeconnection;

	public long getPurposeconnectionid() {
		return purposeconnectionid;
	}

	public void setPurposeconnectionid(long purposeconnectionid) {
		this.purposeconnectionid = purposeconnectionid;
	}

	public String getPurposeconnection() {
		return purposeconnection;
	}

	public void setPurposeconnection(String purposeconnection) {
		this.purposeconnection = purposeconnection;
	}
	
	
}
