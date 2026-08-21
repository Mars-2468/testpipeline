package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "part_map", schema = "egovrti")
public class PartMap {

	@Id
	@Column(name = "part_map_id", nullable = false, unique = true)
	@SequenceGenerator(name = "part_map_seq", sequenceName = "part_map_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "part_map_seq")
	private long partMapId;

	@Column(name = "title", nullable = true)
	private String title;

	@Column(name = "first_name", nullable = true)
	private String firstName;

	@Column(name = "middle_name", nullable = true)
	private String middleName;

	@Column(name = "last_name", nullable = true)
	private String lastName;

	@Column(name = "full_name", nullable = true)
	private String fullName;
	
	@Column(name = "pincode", nullable = true)
	private int pinCode;

	@Column(name = "aadhar_no", nullable = true)
	private String aadharNo;
	
	@Column(name = "email_id", nullable = true)
	private String email;

	@Column(name = "mobile_no", nullable = true)
	private String mobileNo;

	@Column(name = "full_address", nullable = true)
	private String fullAddress;

	@Column(name = "khasara_no", nullable = true)
	private String khasaraNo;

	@Column(name = "city_survey_no", nullable = true)
	private String citySurveyNo;

	@Column(name = "mouje", nullable = true)
	private String mouje;

	@Column(name = "survey", nullable = true)
	private String survey;

	@Column(name = "survey_map", nullable = true)
	private String surveyMap;

	@Column(name = "khasara_map", nullable = true)
	private String khasaraMap;

	@Column(name = "zone_no", nullable = true)
	private String zoneNo;
	
	@Column(name = "mouza_zone", nullable = true)
	private String mouzaZone;
	
	@Transient
	private String filesPath;
	
	  @Column(name = "rti_application_ref_id", nullable = true ) 
	  private String rtiapplrefno;
	  
	  @Column(name = "rti_ref_id", nullable = true )
	  private long rti_ref_id;

	public long getPartMapId() {
		return partMapId;
	}

	public void setPartMapId(long partMapId) {
		this.partMapId = partMapId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	

	public String getCitySurveyNo() {
		return citySurveyNo;
	}

	public void setCitySurveyNo(String citySurveyNo) {
		this.citySurveyNo = citySurveyNo;
	}

	public String getMouje() {
		return mouje;
	}

	public void setMouje(String mouje) {
		this.mouje = mouje;
	}

	public String getSurvey() {
		return survey;
	}

	public void setSurvey(String survey) {
		this.survey = survey;
	}

	public String getSurveyMap() {
		return surveyMap;
	}

	public void setSurveyMap(String surveyMap) {
		this.surveyMap = surveyMap;
	}

	public String getKhasaraMap() {
		return khasaraMap;
	}

	public void setKhasaraMap(String khasaraMap) {
		this.khasaraMap = khasaraMap;
	}

	
	
	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	public String getRtiapplrefno() {
		return rtiapplrefno;
	}

	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}

	public long getRti_ref_id() {
		return rti_ref_id;
	}

	public void setRti_ref_id(long rti_ref_id) {
		this.rti_ref_id = rti_ref_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getMouzaZone() {
		return mouzaZone;
	}

	public void setMouzaZone(String mouzaZone) {
		this.mouzaZone = mouzaZone;
	}

	public String getKhasaraNo() {
		return khasaraNo;
	}

	public void setKhasaraNo(String khasaraNo) {
		this.khasaraNo = khasaraNo;
	}
	  
	  
	  
	  
}
