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
@Table(name="building_registration_service",schema = "egovrti")
public class ConstructionOfBuilding {

	@Id
	@Column(name = "building_registration_id", nullable = false, unique = true)
	@SequenceGenerator(name = "building_registration_ser_seq", sequenceName = "building_registration_ser_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "building_registration_ser_seq")
	private long buildingRegistrationId;

	@Column(name="title", nullable = true)
	private String title;

	//	ConstructionOfBuilding constructionOfBuilding;

	@Column(name = "applicant_fname", nullable = true )
	private String firstName;

	@Column(name = "applicant_mname", nullable = true )
	private String middleName;

	@Column(name = "applicant_lname", nullable = true )
	private String lastName;
	
	@Column(name = "full_name", nullable = true )
	private String fullName;
	
	@Column(name="adhar_number", nullable = true)
	private String aadhaarNo;
	
	@Column(name = "applicant_address", nullable = true )
	private String address;

	@Column(name = "mobile_no", nullable = true )
	private String mobileNo;

	@Column(name = "email_id", nullable = true )
	private String email;

	@Column(name="pincode_no", nullable = true)
	private int pincode;

	@Column(name="owner_name", nullable = true)
	private String ownerName;

	@Column(name="revenue_no", nullable = true)
	private String revenueNo;

	@Column(name="property_no", nullable = true)
	private String peropertyNo;

	@Column(name="survey_no", nullable = true)
	private String surveyNo;

	@Column(name="gat_no", nullable = true)
	private String gatNo;

	@Column(name="khasara_no", nullable = true)
	private String khasaraNo;

	@Column(name="final_plot_no", nullable = true)
	private String finalPlotNo;

	@Column(name="property_address", nullable = true)
	private String propertyAddress;

	@Column(name = "property_usage", nullable = true )
	private String propertyUsage;

	@Column(name="license_no", nullable = true)
	private String licenseNo;

	@Column(name="zone_no", nullable = true)
	private String zoneNo;
	
	@Transient
	private String filesPath;
	
	@Column(name = "rti_application_ref_id", nullable = true ) 
	private String rtiapplrefno;

	@Column(name = "rti_ref_id", nullable = true )
	private long rti_ref_id;

	public long getBuildingRegistrationId() {
		return buildingRegistrationId;
	}

	public void setBuildingRegistrationId(long buildingRegistrationId) {
		this.buildingRegistrationId = buildingRegistrationId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getRevenueNo() {
		return revenueNo;
	}

	public void setRevenueNo(String revenueNo) {
		this.revenueNo = revenueNo;
	}

	public String getPeropertyNo() {
		return peropertyNo;
	}

	public void setPeropertyNo(String peropertyNo) {
		this.peropertyNo = peropertyNo;
	}

	public String getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}

	public String getGatNo() {
		return gatNo;
	}

	public void setGatNo(String gatNo) {
		this.gatNo = gatNo;
	}

	public String getKhasaraNo() {
		return khasaraNo;
	}

	public void setKhasaraNo(String khasaraNo) {
		this.khasaraNo = khasaraNo;
	}

	public String getFinalPlotNo() {
		return finalPlotNo;
	}

	public void setFinalPlotNo(String finalPlotNo) {
		this.finalPlotNo = finalPlotNo;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getPropertyUsage() {
		return propertyUsage;
	}

	public void setPropertyUsage(String propertyUsage) {
		this.propertyUsage = propertyUsage;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
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

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}
	

}
