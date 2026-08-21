package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CITY_CATEGORY", schema = "egovcommon")
public class CityCategory implements java.io.Serializable{

	@Id
	@Column(name = "CATEGORY_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.CITY_CATEGORY_SEQ", sequenceName = "egovcommon.CITY_CATEGORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.CITY_CATEGORY_SEQ")
	private long cityCategoryId;
	
	@Column(name = "NAME", nullable = true)
	private String name;
	
	@Column(name = "NAME_RGL", nullable = true)
	private String name_rgl;
	
	@Column(name = "IS_VALID", nullable = true)
	private String valid;

	  
	public CityCategory() {
	}

	public CityCategory(String name, String name_rgl, String valid) {
		this.name = name;
		this.name_rgl = name_rgl;
		this.valid = valid;
	}

	public long getCityCategoryId() {
		return cityCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_mr() {
		return name_rgl;
	}

	public void setName_rgl(String name_rgl) {
		this.name_rgl = name_rgl;
	}

	public void setCityCategoryId(long cityCategoryId) {
		this.cityCategoryId = cityCategoryId;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

}
