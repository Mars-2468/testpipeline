package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ward_entry",schema="egovcommon")

public class ZoneWard {
	
	@Id
	@Column(name = "ward_Id", nullable = false, unique = true)
	private long wardId;
	
	@Column(name = "zone_Id", nullable = false)
    private long zoneId;
	
	@Column(name = "ward_Name", nullable = false)
	private String wardName;
	

	public long getWardId() {
		return wardId;
	}

	public void setWardId(long wardId) {
		this.wardId = wardId;
	}

	public long getZoneId() {
		return zoneId;
	}

	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}
	
	
	
	
	
	
  
}

