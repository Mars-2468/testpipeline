package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "citizen_hospitals", schema = "egovcommon")
public class CitizenHospital {
	
	@Id
	@Column(name = "hospital_id", nullable = false, unique = true)
	@SequenceGenerator(name = "citizen_hospital_seq", sequenceName = "citizen_hospital_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citizen_hospital_seq")
	private long hospital_id;
	
	@Column(name ="hospitals_name")
	private String hospitals_name;
	
	@Column(name ="zone_id")
	private long zone_id;

	public long getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(long hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getHospitals_name() {
		return hospitals_name;
	}

	public void setHospitals_name(String hospitals_name) {
		this.hospitals_name = hospitals_name;
	}

	public long getZone_id() {
		return zone_id;
	}

	public void setZone_id(long zone_id) {
		this.zone_id = zone_id;
	}

}
