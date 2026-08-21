package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "zone_certificate", schema = "egovrti")
public class ZoneCertificate {

	@Id
	@Column(name = "zone_certificate_id", nullable = false, unique = true)
	@SequenceGenerator(name = "birth_registration_ser_seq", sequenceName = "birth_registration_ser_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "birth_registration_ser_seq")
	private long zonecertificateid;
	
	@Column(name = "applicant_address", nullable = true )
	private String address;
	
	@Column(name = "applicant_name", nullable = true )
	private String name;
	
	@Column(name = "mobile_no", nullable = true )
	private String ph_no;
	
	@Column(name = "email_id", nullable = true )
	private String email;
	
	@Column(name = "date_of_birth", nullable = true )
	private String dob;
	
	@Column(name = "area_name", nullable = true )
	private String areaName;
	
	@Column(name = "group_no", nullable = true )
	private String groupNo;
	
	@Column(name = "rti_appl_ref_no", nullable = true )
	private String rtiapplrefno;

	@Column(name = "rti_ref_id", nullable = true )
	private long rti_ref_id;
	
	@Column(name = "zone_no", nullable = true )
	private String zone;

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public long getRti_ref_id() {
		return rti_ref_id;
	}

	public void setRti_ref_id(long rti_ref_id) {
		this.rti_ref_id = rti_ref_id;
	}

	public String getRtiapplrefno() {
		return rtiapplrefno;
	}

	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}

	public long getZonecertificateid() {
		return zonecertificateid;
	}

	public void setZonecertificateid(long zonecertificateid) {
		this.zonecertificateid = zonecertificateid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
}