package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "property_ward", schema = "egovrti")
public class PropertyWard {

	@Id
	@Column(name = "ward_id", nullable = false, unique = true)
	@SequenceGenerator(name = "ward_id", sequenceName = "ward_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ward_id")
	private long wardId;

	@Column(name="ward_no")
	private String wardNo;
	
	@Column(name = "ward_name", nullable = true)
	private String wardName;

	@Column(name="zone_id")
	private int zoneId;
	
	public long getWardId() {
		return wardId;
	}

	public void setWardId(long wardId) {
		this.wardId = wardId;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	
	
	
	
}
