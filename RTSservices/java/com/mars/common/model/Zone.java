package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zone", schema = "egovrti")
public class Zone {
	@Id
	@Column(name = "zone_id", nullable = true, unique = true)
	//@SequenceGenerator(name = "egovrti.TOM_PLANNNING_RTS_SERVICES_SEQ", sequenceName = "egovcommon.WARD_SECTOR_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long zoneId;
	
	@Column(name = "name", nullable = true)
	private String name;
	private String address;
	private String ph_no;
	private String email;
	private String group_no;
	private String area_name;
	private long ward_no;
	public long getZoneId() {
		return zoneId;
	}
	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPh_no() {
		return ph_no;
	}
	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGroup_no() {
		return group_no;
	}
	public void setGroup_no(String group_no) {
		this.group_no = group_no;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public long getWard_no() {
		return ward_no;
	}
	public void setWard_no(long ward_no) {
		this.ward_no = ward_no;
	}
	
	
}
