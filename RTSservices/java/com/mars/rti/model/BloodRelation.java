package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="blood_relation",schema="egovcommon")
public class BloodRelation {

	@Id
	@Column(name = "bloodrelationId", nullable = false, unique = true)
	private long bloodRelationId;
	
	@Column(name = "blood_relation", nullable = false)
    private String bloodRelation;

	public long getBloodRelationId() {
		return bloodRelationId;
	}

	public void setBloodRelationId(long bloodRelationId) {
		this.bloodRelationId = bloodRelationId;
	}

	public String getBloodRelation() {
		return bloodRelation;
	}

	public void setBloodRelation(String bloodRelation) {
		this.bloodRelation = bloodRelation;
	}
	
	
	
	
}
