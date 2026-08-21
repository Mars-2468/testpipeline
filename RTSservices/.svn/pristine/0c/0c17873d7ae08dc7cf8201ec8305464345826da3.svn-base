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
@Table(name = "illegal_waterConnection", schema = "egovrti")
public class IllegalWaterConnectionComplaint {
	
	@Id
	@Column(name = "illegal_waterconnectionid", nullable = false, unique = true)
	@SequenceGenerator(name = "illegalwaterconnection_seq", sequenceName = "illegalwaterconnection_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "illegalwaterconnection_seq")
	
	private long illegalWaterConnectionID;
	
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
	
	@Column(name = "plot_no", nullable = true)
	private String plotNo;
	
	@Column(name = "name_of_building", nullable = true)
	private String buildingName;
	
	@Column(name = "name_of_street", nullable = true)
	private String streetName;
	
	@Column(name = "name_of_area", nullable = true)
	private String areaName;
	
	@Column(name = "nearby_landmark", nullable = true)
	private String landmark;
	
	@Column(name = "applicant_city", nullable = true)
	private String applicantcity;

	
	@Column(name = "pincode", nullable = true)
	private String pinCode;

	@Column(name = "aadhar_no", nullable = true)
	private String aadharNo;

	@Column(name = "email_id", nullable = true)
	private String emailId;
	
	@Column(name = "mobile_no", nullable = true)
	private String mobileNo;
	
	@Column(name = "address_for_correspondence", nullable = true)
	private String addressForCorrespondence;
	
	@Column(name = "cin_no", nullable = true)
	private String cinNo;

	@Column(name = "zone_no", nullable = true)
	private String zoneNo;
	
	@Column(name = "consumer_name", nullable = true)
	private String consumerName;

	@Column(name = "consumer_address", nullable = true)
	private String consumerAddress;
	
	@Column(name = "consumer_no", nullable = true)
	private String consumerNo;
	
	@Column(name = "meter_no", nullable = true)
	private String meterNo;

	@Column(name = "deposit_receipt_no", nullable = true)
	private String depositReceiptNo;
	
	@Column(name = "deposit_receipt_date", nullable = true)
	private String depositReceiptDate;
	
	@Transient
	private String filesPath;
	
	@Column(name = "rti_appl_refno",nullable = true)
	private String rtiApplRefNo;
	
	@Column(name = "rti_ref_id",nullable = true)
	private long rtiRefId;
	
	@Column(name = "consumer", nullable = true)
	private String consumer;
	

	@Column(name = "existing_esr", nullable = true)
	private String existingEsr;
	
	@Column(name = "esr", nullable = true)
	private String esr;
	
	@Column(name = "existing_zone", nullable = true)
	private String existingZone;
	
	@Column(name = "purpose_of_illegalConn", nullable = true)
	private String purposeOfIllegalConn;


	public long getIllegalWaterConnectionID() {
		return illegalWaterConnectionID;
	}


	public void setIllegalWaterConnectionID(long illegalWaterConnectionID) {
		this.illegalWaterConnectionID = illegalWaterConnectionID;
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


	public String getPlotNo() {
		return plotNo;
	}


	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}


	public String getBuildingName() {
		return buildingName;
	}


	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public String getAreaName() {
		return areaName;
	}


	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	public String getPinCode() {
		return pinCode;
	}


	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}


	public String getAadharNo() {
		return aadharNo;
	}


	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getAddressForCorrespondence() {
		return addressForCorrespondence;
	}


	public void setAddressForCorrespondence(String addressForCorrespondence) {
		this.addressForCorrespondence = addressForCorrespondence;
	}


	public String getCinNo() {
		return cinNo;
	}


	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}


	public String getZoneNo() {
		return zoneNo;
	}


	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}


	public String getConsumerName() {
		return consumerName;
	}


	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}


	public String getConsumerAddress() {
		return consumerAddress;
	}


	public void setConsumerAddress(String consumerAddress) {
		this.consumerAddress = consumerAddress;
	}


	public String getConsumerNo() {
		return consumerNo;
	}


	public void setConsumerNo(String consumerNo) {
		this.consumerNo = consumerNo;
	}


	public String getMeterNo() {
		return meterNo;
	}


	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}


	public String getDepositReceiptNo() {
		return depositReceiptNo;
	}


	public void setDepositReceiptNo(String depositReceiptNo) {
		this.depositReceiptNo = depositReceiptNo;
	}


	public String getDepositReceiptDate() {
		return depositReceiptDate;
	}


	public void setDepositReceiptDate(String depositReceiptDate) {
		this.depositReceiptDate = depositReceiptDate;
	}


	public String getFilesPath() {
		return filesPath;
	}


	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}


	public String getRtiApplRefNo() {
		return rtiApplRefNo;
	}


	public void setRtiApplRefNo(String rtiApplRefNo) {
		this.rtiApplRefNo = rtiApplRefNo;
	}


	public long getRtiRefId() {
		return rtiRefId;
	}


	public void setRtiRefId(long rtiRefId) {
		this.rtiRefId = rtiRefId;
	}


	public String getPurposeOfIllegalConn() {
		return purposeOfIllegalConn;
	}


	public void setPurposeOfIllegalConn(String purposeOfIllegalConn) {
		this.purposeOfIllegalConn = purposeOfIllegalConn;
	}


	public String getConsumer() {
		return consumer;
	}


	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}


	public String getExistingEsr() {
		return existingEsr;
	}


	public void setExistingEsr(String existingEsr) {
		this.existingEsr = existingEsr;
	}


	public String getEsr() {
		return esr;
	}


	public void setEsr(String esr) {
		this.esr = esr;
	}


	public String getExistingZone() {
		return existingZone;
	}


	public void setExistingZone(String existingZone) {
		this.existingZone = existingZone;
	}


	public String getApplicantcity() {
		return applicantcity;
	}


	public void setApplicantcity(String applicantcity) {
		this.applicantcity = applicantcity;
	}
	
	@Column(name = "tap_size", nullable = true)
	  private String tap_size;
	
	@Column(name = "category", nullable = true)
      private String category;
	
	@Column(name = "balance_arrears", nullable = true)
      private String balance_arrears;
	
	@Column(name = "cut_off_date", nullable = true)
      private String cut_off_date;

	public String getTap_size() {
		return tap_size;
	}

	public void setTap_size(String tap_size) {
		this.tap_size = tap_size;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBalance_arrears() {
		return balance_arrears;
	}

	public void setBalance_arrears(String balance_arrears) {
		this.balance_arrears = balance_arrears;
	}

	public String getCut_off_date() {
		return cut_off_date;
	}

	public void setCut_off_date(String cut_off_date) {
		this.cut_off_date = cut_off_date;
	}
	@Column(name = "demand_fees", nullable = true)
	private String demandfees;
	
	@Column(name = "uploaded_demand", nullable = true)
	private String uploadedDemand;
	
	@Column(name = "payment_status", nullable = true)
	private String paymentStatus;
	
	@Column(name = "acknowledgement", nullable = true)
	private String acknowledgement;

	public String getDemandfees() {
		return demandfees;
	}

	public void setDemandfees(String demandfees) {
		this.demandfees = demandfees;
	}

	public String getUploadedDemand() {
		return uploadedDemand;
	}

	public void setUploadedDemand(String uploadedDemand) {
		this.uploadedDemand = uploadedDemand;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getAcknowledgement() {
		return acknowledgement;
	}

	public void setAcknowledgement(String acknowledgement) {
		this.acknowledgement = acknowledgement;
	}
	
	
	
}
