package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="noc_of_trade")
@Entity
public class NOCOfTrade {

	@Id
	@Column(name = "noc_trade_id", nullable = false, unique = true)
	@SequenceGenerator(name = "noc_trade_seq", sequenceName = "noc_trade_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "noc_trade_seq")
	private long nocTradeId;
	
	
	public long getNocTradeId() {
		return nocTradeId;
	}

	public void setNocTradeId(long nocTradeId) {
		this.nocTradeId = nocTradeId;
	}

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
	
	@Column(name = "aadhaar_no", nullable = true)
	private String aadhaarNo;

	@Column(name = "email_id", nullable = true)
	private String email;

	@Column(name = "mobile_no", nullable = true)
	private String mobileNo;

	@Column(name = "address", nullable = true)
	private String address; 
	
	@Column(name="application_for",nullable=true)
	private String applicationFor;
	
	@Column(name="business_name",nullable=true)
	private String businessName;
	
	@Column(name="business_details",nullable=true)
	private String businessDetails;
	
	@Column(name="business_date",nullable=true)
	private String businessDate;
	
	@Column(name="space_type",nullable=true)
	private String spaceType;
	
	@Column(name="noc_length",nullable=true)
	private String length;
	
	@Column(name="noc_height",nullable=true)
	private String height;

	@Column(name="noc_width",nullable=true)
	private String width;

	@Transient
	private String filesPath;
	
	@Column(name = "zone_no", nullable = true)
	private String zoneNo;

	@Column(name = "ward_no", nullable = true)
	private String wardNo;

	@Column(name = "area_name", nullable = true)
	private String areaName;
	
	@Column(name = "licence_no", nullable = true)
	private String licenceNo;

	@Column(name = "full_address", nullable = true)
	private String fullAddress;

//	@Column(name = "noc_doc", nullable = true)
//	private String nocDoc;
//	
	@Column(name = "former_licence", nullable = true)
	private String formerLicence;
//	
//	@Column(name = "no_due_certificate", nullable = true)
//	private String nodueCertificate;
//	
//	@Column(name = "copy_of_building", nullable = true)
//	private String copyofBuilding;

	@Column(name = "rti_application_ref_id", nullable = true)
	private String rtiapplrefno;

	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;

	@Column(name = "no_of_certificates", nullable = true)
	private String calnumber;

	@Column(name = "fees_applicable", nullable = true)
	private double feesApplicable;
	
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getApplicationFor() {
		return applicationFor;
	}

	public void setApplicationFor(String applicationFor) {
		this.applicationFor = applicationFor;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessDetails() {
		return businessDetails;
	}

	public void setBusinessDetails(String businessDetails) {
		this.businessDetails = businessDetails;
	}

	public String getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}

	public String getSpaceType() {
		return spaceType;
	}

	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	
	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	public String getCalnumber() {
		return calnumber;
	}

	public void setCalnumber(String calnumber) {
		this.calnumber = calnumber;
	}

	public double getFeesApplicable() {
		return feesApplicable;
	}

	public void setFeesApplicable(double feesApplicable) {
		this.feesApplicable = feesApplicable;
	}

	public String getFormerLicence() {
		return formerLicence;
	}

	public void setFormerLicence(String formerLicence) {
		this.formerLicence = formerLicence;
	}

	
//	public String getNocDoc() {
//		return nocDoc;
//	}
//
//	public void setNocDoc(String nocDoc) {
//		this.nocDoc = nocDoc;
//	}
//
//	public String getFormerLicence() {
//		return formerLicence;
//	}
//
//	public void setFormerLicence(String formerLicence) {
//		this.formerLicence = formerLicence;
//	}
//
//	public String getNodueCertificate() {
//		return nodueCertificate;
//	}
//
//	public void setNodueCertificate(String nodueCertificate) {
//		this.nodueCertificate = nodueCertificate;
//	}
//
//	public String getCopyofBuilding() {
//		return copyofBuilding;
//	}
//
//	public void setCopyofBuilding(String copyofBuilding) {
//		this.copyofBuilding = copyofBuilding;
//	}

	
}
