package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="garden_details",schema="egovrti")
public class GardenDetails {
	
	@Id
	@SequenceGenerator(name = "garden_details_seq", sequenceName = "garden_details_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "garden_details_seq")
	private long gardendetailsid;
	
	private String parkname;
	
	private String ownership;
	
	private String  area;
	
	private String agency;
	
	private String mobile;
	
	private String authority;
	
	private long zoneid;
	
	private String image_name;

	public long getGardendetailsid() {
		return gardendetailsid;
	}

	public void setGardendetailsid(long gardendetailsid) {
		this.gardendetailsid = gardendetailsid;
	}

	public String getParkname() {
		return parkname;
	}

	public void setParkname(String parkname) {
		this.parkname = parkname;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public long getZoneid() {
		return zoneid;
	}

	public void setZoneid(long zoneid) {
		this.zoneid = zoneid;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}


	
	
	

}
