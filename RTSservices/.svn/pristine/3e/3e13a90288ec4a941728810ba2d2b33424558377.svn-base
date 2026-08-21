package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="blood_group",schema="egovcommon")
public class BloodGroup {

	
	@Id
	@Column(name = "bloodgroupId", nullable = false, unique = true)
	private long bloodGroupId;
	
	@Column(name = "blood_group", nullable = false)
    private String bloodGroup;

	public long getBloodGroupId() {
		return bloodGroupId;
	}

	public void setBloodGroupId(long bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	
	
	
}
