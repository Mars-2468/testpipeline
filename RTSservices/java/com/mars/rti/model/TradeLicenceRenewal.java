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
@Table(name="trade_renewal", schema= "egovrti")


public class TradeLicenceRenewal {

	@Id
	@Column(name = "trade_renewal_id", nullable = false, unique = true)
	@SequenceGenerator(name = "trade_renewal_ser_seq", sequenceName = "trade_renewal_ser_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trade_renewal_ser_seq")
	private long tradeRenewalId;
	
	@Column(name="title", nullable = true)
	private String title;
	
	
	@Column(name="first_name", nullable = true)
    private String firstName;
    
	@Column(name="middle_name", nullable = true)
    private String middleName;
	
	@Column(name="last_name", nullable = true)
    private String lastName;
	
	@Column(name="full_name", nullable = true)
    private String fullName;
	
	@Column(name="pincode", nullable = true)
    private int pinCode;

	@Column(name="aadhaar_no", nullable = true)
    private String aadhaarNo;
	
	@Column(name = "email_id", nullable = true )
	private String email;
	
	@Column(name = "mobile_no", nullable = true )
	private String mobileNo;
	
	@Column(name="address", nullable = true)
    private String address;
	
	 @Column(name = "application_for", nullable = true ) 
	  private String applicationFor;
	
	@Column(name="name_of_business", nullable = true)
    private String nameOfBusiness;
	
	@Column(name="business_details", nullable = true)
    private String businessDetails;
	
	@Column(name="business_done_est_date", nullable = true)
    private String businesDoneDate;
	
	@Column(name="space_type", nullable = true)
    private String spaceType;
	
	@Column(name="trade_length", nullable = true)
    private String length;
	
	@Column(name="trade_height", nullable = true)
    private String height;
	
	@Column(name="trade_width", nullable = true)
    private String width;
	
	@Column(name="zone_no", nullable = true)
    private String zoneNo;
	
	@Column(name="ward_no", nullable = true)
    private String wardNo;
	
	@Column(name="area_name", nullable = true)
    private String areaName;
	
	@Column(name="trade_licenseno", nullable = true)
    private String tradeLicenseNo;
	
	@Column(name="full_address", nullable = true)
    private String businessUsagePlace;
	
	@Column(name = "rti_application_ref_id", nullable = true )
	private String rtiapplrefno;
                                                                                                   
	@Column(name = "rti_ref_id", nullable = true )                                               
	private long rti_ref_id;
	
	@Column(name="fees_applicable", nullable = true)
    private int fees;
	
	@Column(name="updated_trade_type", nullable = true)
    private String updatedTradeType;
	
	public String getUpdatedTradeType() {
		return updatedTradeType;
	}

	public void setUpdatedTradeType(String updatedTradeType) {
		this.updatedTradeType = updatedTradeType;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Transient
	private String filesPath;
	
	
	

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

	public long getTradeRenewalId() {
		return tradeRenewalId;
	}

	public void setTradeRenewalId(long tradeRenewalId) {
		this.tradeRenewalId = tradeRenewalId;
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

	public String getNameOfBusiness() {
		return nameOfBusiness;
	}

	public void setNameOfBusiness(String nameOfBusiness) {
		this.nameOfBusiness = nameOfBusiness;
	}

	public String getBusinessDetails() {
		return businessDetails;
	}

	public void setBusinessDetails(String businessDetails) {
		this.businessDetails = businessDetails;
	}

	public String getBusinesDoneDate() {
		return businesDoneDate;
	}

	public void setBusinesDoneDate(String businesDoneDate) {
		this.businesDoneDate = businesDoneDate;
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

	public String getTradeLicenseNo() {
		return tradeLicenseNo;
	}

	public void setTradeLicenseNo(String tradeLicenseNo) {
		this.tradeLicenseNo = tradeLicenseNo;
	}

	public String getBusinessUsagePlace() {
		return businessUsagePlace;
	}

	public void setBusinessUsagePlace(String businessUsagePlace) {
		this.businessUsagePlace = businessUsagePlace;
	}
	
	
}
