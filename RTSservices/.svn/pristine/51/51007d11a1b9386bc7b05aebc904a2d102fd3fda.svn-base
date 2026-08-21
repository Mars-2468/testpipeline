package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="space_type",schema="egovcommon")

public class Space {
	
	@Id
	@Column(name = "spaceid", nullable = false, unique = true)
	private long spaceid;
	
	@Column(name = "space", nullable = false)
    private String space;

	public long getSpaceid() {
		return spaceid;
	}

	public void setSpaceid(long spaceid) {
		this.spaceid = spaceid;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}
	
	

}
