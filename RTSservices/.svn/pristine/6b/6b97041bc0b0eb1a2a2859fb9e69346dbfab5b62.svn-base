package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="trade_license_transfer")
@Entity
public class TradeLicenseTransfer {
	

		@Id
		@Column(name = "trade_license_transfer_id", nullable = false, unique = true)
		@SequenceGenerator(name = "tradelicensetransfer_seq", sequenceName = "tradelicensetransfer_seq")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tradelicensetransfer_seq")
		
		private long tradeLicenseTransferId;

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
		private long pinCode;
		
		@Column(name = "aadhaar_no", nullable = true)
		private String aadhaarNo;

		@Column(name = "email", nullable = true)
		private String email;

		@Column(name = "mobile_no", nullable = true)
		private String mobileNo;

		@Column(name = "address", nullable = true)
		private String address; 
		
		@Column(name = "zone_no", nullable = true)
		private String zoneNo;

		@Column(name = "ward_no", nullable = true)
		private String wardNo;

		@Column(name = "area_name", nullable = true)
		private String nameOfArea;
		
		@Column(name = "trade_license_no", nullable = true)
		private String tradeLicenseNo;
		
		@Column(name = "updated_trade_name", nullable = true)
		private String updatedTradeName;

		@Column(name = "updated_trade_type", nullable = true)
		private String updatedTradeType;
		
		@Column(name = "updated_owner_name", nullable = true)
		private String updatedOwnerName;
		
		@Column(name = "updated_partner_count", nullable = true)
		private String updatedPartnerCount;
		
		@Transient
		private String filesPath;
		
//		@Column(name = "noc_doc", nullable = true)
//		private String nocDoc;
	//	
//		@Column(name = "former_licence", nullable = true)
//		private String formerLicence;
	//	
//		@Column(name = "no_due_certificate", nullable = true)
//		private String nodueCertificate;
	//	
//		@Column(name = "copy_of_building", nullable = true)
//		private String copyofBuilding;

		@Column(name = "rti_application_ref_id", nullable = true)
		private String rtiapplrefno;

		@Column(name = "rti_ref_id", nullable = true)
		private long rti_ref_id;

		public long getTradeLicenseTransferId() {
			return tradeLicenseTransferId;
		}

		public void setTradeLicenseTransferId(long tradeLicenseTransferId) {
			this.tradeLicenseTransferId = tradeLicenseTransferId;
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

		public long getPinCode() {
			return pinCode;
		}

		public void setPinCode(long pinCode) {
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

		public String getNameOfArea() {
			return nameOfArea;
		}

		public void setNameOfArea(String nameOfArea) {
			this.nameOfArea = nameOfArea;
		}

		public String getTradeLicenseNo() {
			return tradeLicenseNo;
		}

		public void setTradeLicenseNo(String tradeLicenseNo) {
			this.tradeLicenseNo = tradeLicenseNo;
		}

		public String getUpdatedTradeName() {
			return updatedTradeName;
		}

		public void setUpdatedTradeName(String updatedTradeName) {
			this.updatedTradeName = updatedTradeName;
		}

		public String getUpdatedTradeType() {
			return updatedTradeType;
		}

		public void setUpdatedTradeType(String updatedTradeType) {
			this.updatedTradeType = updatedTradeType;
		}

		public String getUpdatedOwnerName() {
			return updatedOwnerName;
		}

		public void setUpdatedOwnerName(String updatedOwnerName) {
			this.updatedOwnerName = updatedOwnerName;
		}

		public String getUpdatedPartnerCount() {
			return updatedPartnerCount;
		}

		public void setUpdatedPartnerCount(String updatedPartnerCount) {
			this.updatedPartnerCount = updatedPartnerCount;
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

//		@Column(name = "no_of_certificates", nullable = true)
//		private String calnumber;
//
		@Column(name = "fees_applicable", nullable = true)
       	private double feesApplicable;
//		

		public double getFeesApplicable() {
			return feesApplicable;
		}

		public void setFeesApplicable(double feesApplicable) {
			this.feesApplicable = feesApplicable;
		}
		

}
