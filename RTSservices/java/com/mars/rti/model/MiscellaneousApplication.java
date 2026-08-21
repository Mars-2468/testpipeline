package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="misc_application")
@Entity
public class MiscellaneousApplication {
	
	// Miscellaneous Application Model

		@Id
		@Column(name = "misc_id", nullable = false, unique = true)
		@SequenceGenerator(name = "misc_App_seq", sequenceName = "misc_App_seq")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "misc_App_seq")
		private long miscAppId;
		
		@Column(name = "date", nullable = true)
		private String date;
		
		@Column(name = "phone", nullable = true)
	    private String phone;
		
		@Column(name = "zone", nullable = true)
	    private String zone;
		
		@Column(name = "ward", nullable = true)
	    private String ward;
		
		@Column(name = "department", nullable = true)
	    private String department;
		
		@Column(name = "purpose", nullable = true)
	    private String purpose;
		
		@Column(name = "receivedFrom", nullable = true)
	    private String receivedFrom;
		
		@Column(name = "amount", nullable = true)
	    private double amount;
			
		@Column(name = "address", nullable = true)
	    private String address;
		
		@Column(name = "paymentMode", nullable = true)
	    private String paymentMode;
			
		@Column(name = "receivedBy", nullable = true)
	    private String receivedBy;

		public long getMiscAppId() {
			return miscAppId;
		}

		public void setMiscAppId(long miscAppId) {
			this.miscAppId = miscAppId;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getZone() {
			return zone;
		}

		public void setZone(String zone) {
			this.zone = zone;
		}

		public String getWard() {
			return ward;
		}

		public void setWard(String ward) {
			this.ward = ward;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getPurpose() {
			return purpose;
		}

		public void setPurpose(String purpose) {
			this.purpose = purpose;
		}

		public String getReceivedFrom() {
			return receivedFrom;
		}

		public void setReceivedFrom(String receivedFrom) {
			this.receivedFrom = receivedFrom;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPaymentMode() {
			return paymentMode;
		}

		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}

		public String getReceivedBy() {
			return receivedBy;
		}

		public void setReceivedBy(String receivedBy) {
			this.receivedBy = receivedBy;
		}

	   


}
