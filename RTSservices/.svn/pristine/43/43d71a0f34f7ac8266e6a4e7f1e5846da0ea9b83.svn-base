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
@Table(name = "property_complaint_registration", schema = "egovrti")
public class PropertyComplaintRegistration {

	
		@Id
		@Column(name = "property_complaint_registration_id", nullable = false, unique = true)
		@SequenceGenerator(name = "property_complaint_registration_seq", sequenceName = "property_complaint_registration_seq", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "property_complaint_registration_seq")
		
		private long propertyComplaintRegistrationID;
		
		@Column(name = "title", nullable = true)
		private String appTitle;
		
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
		
		@Column(name = "nearby_landmark", nullable = true)
		private String landmark;
		
		@Column(name = "pincode", nullable = true)
		private String pincode;

		@Column(name = "aadhar_no", nullable = true)
		private String adhaarNo;

		@Column(name = "email_id", nullable = true)
		private String emailId;
		
		@Column(name = "mobile_no", nullable = true)
		private String mobileNo;
		
		@Column(name = "address_for_correspondence", nullable = true)
		private String addressForCorrespondence;
		
		@Column(name="reason")
		private String reason;
	
		@Column(name = "zone_no", nullable = true)
		private String zoneNo;
		
		@Column(name = "ward_no", nullable = true)
		private String wardNo;
		
		@Column(name = "name_of_area", nullable = true)
		private String areaName;
		
		@Column(name = "house_no", nullable = true)
		private String houseNo;
		
		@Column(name = "index_no", nullable = true)
		private String indexNo;
		
		@Column(name = "upin_no", nullable = true)
		private String upinNo;
		
		@Column(name = "property_area", nullable = true)
		private String propertyArea;
		
		@Column(name = "property_type", nullable = true)
		private String propertyType;
		
		@Column(name = "holders_name", nullable = true)
		private String holdersName;
		
		@Column(name = "built_area", nullable = true)
		private String builtArea;
		
		@Column(name = "building_use", nullable = true)
		private String buildingUse;
		
		@Column(name = "property_address", nullable = true)
		private String propertyAddress;
		
		@Column(name = "app_id_proof", nullable = true)
		private String applicantsIdProof;
		
		@Column(name = "noduescertificate", nullable = true)
		private String noduesCertificate;
		
		@Column(name = "applicantsignature", nullable = true)
		private String applicantSignature;
		
		@Column(name = "partitiondeed", nullable = true)
		private String partitionDeed;
		
		@Column(name = "fees", nullable = true)
		private double fees;
			
		@Column(name = "objection_remarks", nullable = true)
		private String objectionRemarks;
		
		@Column(name = "ntb", nullable = true)
		private String ntb;

		@Column(name = "built_up_area", nullable = true)
		private String builtUpArea;

		@Column(name = "factor_usage", nullable = true)
		private String factorUsage;
		
		@Column(name = "address", nullable = true)
		private String address;
		
		@Column(name = "age_factor", nullable = true)
		private String ageFactor;	

		@Column(name = "rti_appl_ref_no", nullable = true)
		private String rtiapplrefno;
		
		//new fields
		@Column(name = "old_ntb", nullable = true)
		private String oldntb;
		
		@Column(name = "old_factor_usage", nullable = true)
		private String oldfactorUsage;
		
		@Column(name = "old_age_factor", nullable = true)
		private String oldageFactor;
		
		@Column(name = "old_built_up_area", nullable = true)
		private String oldbuiltUpArea;
		
		@Column(name = "rti_ref_id", nullable = true)
		private long rti_ref_id;
		
		@Column(name="payment_receipt")
		private String paymentReceipt;
		
		@Transient
		private String oldntbId;
		
		@Transient
		private String oldfactorUsageId;
		
		@Transient
		private String oldageFactorId;
		
		
		
		
		@Transient
		private String filesPath;
		 
		public long getPropertyComplaintRegistrationID() {
			return propertyComplaintRegistrationID;
		}

		public void setPropertyComplaintRegistrationID(long propertyComplaintRegistrationID) {
			this.propertyComplaintRegistrationID = propertyComplaintRegistrationID;
		}

		public String getAppTitle() {
			return appTitle;
		}

		public void setAppTitle(String appTitle) {
			this.appTitle = appTitle;
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

		public String getLandmark() {
			return landmark;
		}

		public void setLandmark(String landmark) {
			this.landmark = landmark;
		}

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

		public String getAdhaarNo() {
			return adhaarNo;
		}

		public void setAdhaarNo(String adhaarNo) {
			this.adhaarNo = adhaarNo;
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

		public String getHouseNo() {
			return houseNo;
		}

		public void setHouseNo(String houseNo) {
			this.houseNo = houseNo;
		}

		public String getIndexNo() {
			return indexNo;
		}

		public void setIndexNo(String indexNo) {
			this.indexNo = indexNo;
		}

		public String getPropertyArea() {
			return propertyArea;
		}

		public void setPropertyArea(String propertyArea) {
			this.propertyArea = propertyArea;
		}

		public String getPropertyType() {
			return propertyType;
		}

		public void setPropertyType(String propertyType) {
			this.propertyType = propertyType;
		}

		public String getBuiltArea() {
			return builtArea;
		}

		public void setBuiltArea(String builtArea) {
			this.builtArea = builtArea;
		}

		public String getBuildingUse() {
			return buildingUse;
		}

		public void setBuildingUse(String buildingUse) {
			this.buildingUse = buildingUse;
		}

		public String getPropertyAddress() {
			return propertyAddress;
		}

		public void setPropertyAddress(String propertyAddress) {
			this.propertyAddress = propertyAddress;
		}

		public String getApplicantsIdProof() {
			return applicantsIdProof;
		}

		public void setApplicantsIdProof(String applicantsIdProof) {
			this.applicantsIdProof = applicantsIdProof;
		}

		public String getNoduesCertificate() {
			return noduesCertificate;
		}

		public void setNoduesCertificate(String noduesCertificate) {
			this.noduesCertificate = noduesCertificate;
		}

		public String getApplicantSignature() {
			return applicantSignature;
		}

		public void setApplicantSignature(String applicantSignature) {
			this.applicantSignature = applicantSignature;
		}

		public String getPartitionDeed() {
			return partitionDeed;
		}

		public void setPartitionDeed(String partitionDeed) {
			this.partitionDeed = partitionDeed;
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

		
		public String getHoldersName() {
			return holdersName;
		}

		public void setHoldersName(String holdersName) {
			this.holdersName = holdersName;
		}

		public String getUpinNo() {
			return upinNo;
		}

		public void setUpinNo(String upinNo) {
			this.upinNo = upinNo;
		}

		public double getFees() {
			return fees;
		}

		public void setFees(double fees) {
			this.fees = fees;
		}

		public String getObjectionRemarks() {
			return objectionRemarks;
		}

		public void setObjectionRemarks(String objectionRemarks) {
			this.objectionRemarks = objectionRemarks;
		}

		public String getNtb() {
			return ntb;
		}

		public void setNtb(String ntb) {
			this.ntb = ntb;
		}

		public String getBuiltUpArea() {
			return builtUpArea;
		}

		public void setBuiltUpArea(String builtUpArea) {
			this.builtUpArea = builtUpArea;
		}

		public String getFactorUsage() {
			return factorUsage;
		}

		public void setFactorUsage(String factorUsage) {
			this.factorUsage = factorUsage;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getAgeFactor() {
			return ageFactor;
		}

		public void setAgeFactor(String ageFactor) {
			this.ageFactor = ageFactor;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		public String getOldntb() {
			return oldntb;
		}

		public void setOldntb(String oldntb) {
			this.oldntb = oldntb;
		}

		public String getOldfactorUsage() {
			return oldfactorUsage;
		}

		public void setOldfactorUsage(String oldfactorUsage) {
			this.oldfactorUsage = oldfactorUsage;
		}

		public String getOldageFactor() {
			return oldageFactor;
		}

		public void setOldageFactor(String oldageFactor) {
			this.oldageFactor = oldageFactor;
		}

		public String getOldbuiltUpArea() {
			return oldbuiltUpArea;
		}

		public void setOldbuiltUpArea(String oldbuiltUpArea) {
			this.oldbuiltUpArea = oldbuiltUpArea;
		}

		public long getRti_ref_id() {
			return rti_ref_id;
		}

		public void setRti_ref_id(long rti_ref_id) {
			this.rti_ref_id = rti_ref_id;
		}

		public String getPaymentReceipt() {
			return paymentReceipt;
		}

		public void setPaymentReceipt(String paymentReceipt) {
			this.paymentReceipt = paymentReceipt;
		}

		public String getOldntbId() {
			return oldntbId;
		}

		public void setOldntbId(String oldntbId) {
			this.oldntbId = oldntbId;
		}

		public String getOldfactorUsageId() {
			return oldfactorUsageId;
		}

		public void setOldfactorUsageId(String oldfactorUsageId) {
			this.oldfactorUsageId = oldfactorUsageId;
		}

		public String getOldageFactorId() {
			return oldageFactorId;
		}

		public void setOldageFactorId(String oldageFactorId) {
			this.oldageFactorId = oldageFactorId;
		}

		
		
		


}
