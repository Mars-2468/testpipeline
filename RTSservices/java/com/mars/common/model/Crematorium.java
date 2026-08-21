package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crematorium", schema = "egovrti")
public class Crematorium {
	
	@Id
	@Column(name = "crematorium_id", nullable = true, unique = true)
	//@SequenceGenerator(name = "egovrti.TOM_PLANNNING_RTS_SERVICES_SEQ", sequenceName = "egovcommon.WARD_SECTOR_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long crematoriumId;
	
	@Column(name = "crematorium_name", nullable = true)
	private String name;

	public long getCrematoriumId() {
		return crematoriumId;
	}

	public void setCrematoriumId(long crematoriumId) {
		this.crematoriumId = crematoriumId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
