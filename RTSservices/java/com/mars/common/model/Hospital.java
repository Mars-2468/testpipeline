package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospital", schema = "egovrti")
public class Hospital {
	@Id
	@Column(name = "hospital_id", nullable = true, unique = true)
	//@SequenceGenerator(name = "egovrti.TOM_PLANNNING_RTS_SERVICES_SEQ", sequenceName = "egovcommon.WARD_SECTOR_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long hospitalId;
	
	@Column(name = "hospital_name", nullable = true)
	private String name;

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
