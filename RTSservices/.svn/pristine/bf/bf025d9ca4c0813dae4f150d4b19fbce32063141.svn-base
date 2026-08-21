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
@Table(name = "change_in_ownwership_type", schema = "egovrti")
public class ChangeInOwnershipType {
	
	@Id
	@Column(name = "changeownershiptype_id", nullable = false, unique = true)
	@SequenceGenerator(name = "changeOwnership_seq", sequenceName = "changeOwnership_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "changeOwnership_seq")
	
	private long changeOwnershipID;
	
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
	private String CINNo;

	@Column(name = "zone_no", nullable = true)
	private String zoneNo;
	
	@Column(name = "existing_consumername", nullable = true)
	private String existingConsumerName;
	
	@Column(name = "consumer_address", nullable = true)
	private String consumerAddress;

	@Column(name = "consumer_no", nullable = true)
	private String consumerNo;
	
	@Column(name = "update_consumer_name", nullable = true)
	private String updateConsumerName;
	
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
	
	@Column(name = "purpose_of_ownership", nullable = true)
	private String purposeOfOwnership;
	
	 @Column(name = "applicant_city")
	  private String applicantcity;
	 
	 @Column(name = "existing_esr")
	 private String existingEsr;
	 
	public long getChangeOwnershipID() {
		return changeOwnershipID;
	}

	public void setChangeOwnershipID(long changeOwnershipID) {
		this.changeOwnershipID = changeOwnershipID;
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

	
	public String getCINNo() {
		return CINNo;
	}

	public void setCINNo(String cINNo) {
		CINNo = cINNo;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getExistingConsumerName() {
		return existingConsumerName;
	}

	public void setExistingConsumerName(String existingConsumerName) {
		this.existingConsumerName = existingConsumerName;
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

	public String getUpdateConsumerName() {
		return updateConsumerName;
	}

	public void setUpdateConsumerName(String updateConsumerName) {
		this.updateConsumerName = updateConsumerName;
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

	public String getPurposeOfOwnership() {
		return purposeOfOwnership;
	}

	public void setPurposeOfOwnership(String purposeOfOwnership) {
		this.purposeOfOwnership = purposeOfOwnership;
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

	public String getExistingEsr() {
		return existingEsr;
	}

	public void setExistingEsr(String existingEsr) {
		this.existingEsr = existingEsr;
	}
	
	@Column(name = "altermobileno", nullable = true)
	private String alterMobileNo;

	public String getAlterMobileNo() {
		return alterMobileNo;
	}

	public void setAlterMobileNo(String alterMobileNo) {
		this.alterMobileNo = alterMobileNo;
	}
	
	@Column(name = "approvalremark", nullable = true)
	private String approvalRemark; 
	
	public String getApprovalRemark() {
		return approvalRemark;
	}

	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
	}
	
	@Column(name = "higherapprovalremark", nullable = true)
	private String higherapprovalRemark;

	public String getHigherapprovalRemark() {
		return higherapprovalRemark;
	}

	public void setHigherapprovalRemark(String higherapprovalRemark) {
		this.higherapprovalRemark = higherapprovalRemark;
	} 
	
	@Column(name = "agreement", nullable = true)
	private String agreement;

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}
	
	
	
	
}

