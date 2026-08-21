package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="country_details",schema="egovcommon")

public class Country {

	@Id
	@Column(name = "countryid", nullable = false, unique = true)
	private long countryid;
	
	@Column(name = "country", nullable = false)
    private String country;

	public long getCountryid() {
		return countryid;
	}

	public void setCountryid(long countryid) {
		this.countryid = countryid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
