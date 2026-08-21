package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "citizen_zone", schema = "egovcommon")
public class CitizenZone {
	
	@Id
	@Column(name = "zone_id", nullable = false, unique = true)
	@SequenceGenerator(name = "Zone_seq", sequenceName = "Zone_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Zone_seq")
	private long zone_Id;

	@Column(name = "zone_name", nullable = true)
	private String zoneName;
	


	public long getZone_Id() {
		return zone_Id;
	}

	public void setZone_Id(long zone_Id) {
		this.zone_Id = zone_Id;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
}
