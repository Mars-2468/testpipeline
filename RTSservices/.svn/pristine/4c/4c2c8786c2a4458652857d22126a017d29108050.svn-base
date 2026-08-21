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
@Table(name="layout_registration_service",schema = "egovrti")
public class LayoutOfBuilding {

	@Id
	@Column(name = "layout_registration_id", nullable = false, unique = true)
	@SequenceGenerator(name = "layout_registration_ser_seq", sequenceName = "layout_registration_ser_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "layout_registration_ser_seq")

	private long layoutRegistrationId;
	
	@Column(name="title", nullable = true)
	private String title;
	
	@Column(name="zone_no", nullable = true)
	private String zoneNo;
	
	@Column(name = "applicant_fname", nullable = true )
	private String firstName;
	
	@Column(name = "applicant_mname", nullable = true )
	private String middleName;
	
	@Column(name = "applicant_lname", nullable = true )
	private String lastName;
	
	@Column(name = "full_name", nullable = true )
	private String fullName;
	
	@Column(name="adhar_number", nullable = true)
	private String AadhaarNo;
	
	@Column(name="pincode", nullable = true)
	private int pincode;
	
	@Column(name = "applicant_address", nullable = true )
	private String fullAddress;

	@Column(name = "mobile_no", nullable = true )
	private String mobileNo;
	
	@Column(name = "email_id", nullable = true )
	private String emailId;
	
	@Column(name="owner_name", nullable = true)
	private String ownerName;
	
	@Column(name="plot_no", nullable = true)
	private String plotNo;
	
	@Column(name="revenue_no", nullable = true)
	private String revenueNo;
	
	@Column(name="survey_no", nullable = true)
	private String surveyNo;
	
	@Column(name="gat_no", nullable = true)
	private String gatNo;
	
	@Column(name="khasara_no", nullable = true)
	private String khasaraNo;
	
	@Column(name="final_plot_no", nullable = true)
	private String finalPlotNo;
	
	@Column(name="mouje", nullable = true)
	private String mouje;
	
	@Column(name = "road", nullable = true )
	private String road;
	
	@Column(name = "society", nullable = true )
	private String society;
	
	@Column(name="license_no", nullable = true)
	private String licenseNo;

	@Column(name="address_of_owner", nullable = true)
	private String addressOfOwner;
	
	@Transient
	private String filesPath;

	 @Column(name = "rti_application_ref_id", nullable = true ) 
	  private String rtiapplrefno;
	  
	  @Column(name = "rti_ref_id", nullable = true )
	  private long rti_ref_id;
	  
	public long getLayoutRegistrationId() {
		return layoutRegistrationId;
	}

	public void setLayoutRegistrationId(long layoutRegistrationId) {
		this.layoutRegistrationId = layoutRegistrationId;
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

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getRevenueNo() {
		return revenueNo;
	}

	public void setRevenueNo(String revenueNo) {
		this.revenueNo = revenueNo;
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

	public String getMouje() {
		return mouje;
	}

	public void setMouje(String mouje) {
		this.mouje = mouje;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getSociety() {
		return society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getAddressOfOwner() {
		return addressOfOwner;
	}

	public void setAddressOfOwner(String addressOfOwner) {
		this.addressOfOwner = addressOfOwner;
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

	public String getAadhaarNo() {
		return AadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		AadhaarNo = aadhaarNo;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	
	
	
}