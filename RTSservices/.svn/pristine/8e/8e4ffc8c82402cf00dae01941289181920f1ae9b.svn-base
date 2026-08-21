package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marriage_law",schema="egovcommon")
public class MarriageLaw {

	
	@Id
	@Column(name = "marriage_law_id", nullable = false, unique = true)
	private long marriageLawId;
	
	@Column(name = "marriage_law", nullable = false)
    private String marriageLaw;

	public long getMarriageLawId() {
		return marriageLawId;
	}

	public void setMarriageLawId(long marriageLawId) {
		this.marriageLawId = marriageLawId;
	}

	public String getMarriageLaw() {
		return marriageLaw;
	}

	public void setMarriageLaw(String marriageLaw) {
		this.marriageLaw = marriageLaw;
	}
	
	
	
	
}
