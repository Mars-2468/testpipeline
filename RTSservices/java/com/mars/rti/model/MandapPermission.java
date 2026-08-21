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
@Table(name = "mandap_permission", schema = "egovrti")
public class MandapPermission {

	@Id
	@Column(name = "mandap_permission_id", nullable = false, unique = true)
	@SequenceGenerator(name = "mandap_permission_seq", sequenceName = "mandap_permission_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mandap_permission_seq")
	private long mandapPermissionId;

	public long getMandapPermissionId() {
		return mandapPermissionId;
	}

	public void setMandapPermissionId(long mandapPermissionId) {
		this.mandapPermissionId = mandapPermissionId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
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

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
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

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getReasonForCertificate() {
		return reasonForCertificate;
	}

	public void setReasonForCertificate(String reasonForCertificate) {
		this.reasonForCertificate = reasonForCertificate;
	}

	public String getPavilionLength() {
		return pavilionLength;
	}

	public void setPavilionLength(String pavilionLength) {
		this.pavilionLength = pavilionLength;
	}

	public String getPavilionBreadth() {
		return pavilionBreadth;
	}

	public void setPavilionBreadth(String pavilionBreadth) {
		this.pavilionBreadth = pavilionBreadth;
	}

	public String getPavilionstartDate() {
		return pavilionStartDate;
	}

	public void setPavilionstartDate(String pavilionstartDate) {
		this.pavilionStartDate = pavilionstartDate;
	}

	public String getPavilionEndDate() {
		return pavilionEndDate;
	}

	public String getPavilionStartDate() {
		return pavilionStartDate;
	}

	public void setPavilionStartDate(String pavilionStartDate) {
		this.pavilionStartDate = pavilionStartDate;
	}

	public void setPavilionEndDate(String pavilionEndDate) {
		this.pavilionEndDate = pavilionEndDate;
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

	public String getPoliceDepartment() {
		return policeDepartment;
	}

	public void setPoliceDepartment(String policeDepartment) {
		this.policeDepartment = policeDepartment;
	}

	public String getTrafficDepartment() {
		return trafficDepartment;
	}

	public void setTrafficDepartment(String trafficDepartment) {
		this.trafficDepartment = trafficDepartment;
	}

	public String getFireDepartment() {
		return fireDepartment;
	}

	public void setFireDepartment(String fireDepartment) {
		this.fireDepartment = fireDepartment;
	}
	

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(String totalSize) {
		this.totalSize = totalSize;
	}
	
	
	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getExhibitions() {
		return exhibitions;
	}

	public void setExhibitions(String exhibitions) {
		this.exhibitions = exhibitions;
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

	@Column(name = "address", nullable = true)
	private String address;

	@Column(name = "pincode", nullable = true)
	private int pinCode;

	@Column(name = "email_id", nullable = true)
	private String email;

	@Column(name = "mobile_no", nullable = true)
	private String mobileNo;

	@Column(name = "aadhar_no", nullable = true)
	private String aadharNo;

	@Column(name = "zone_no", nullable = true)
	private String zoneNo;

	@Column(name = "ward_no", nullable = true)
	private String wardNo;

	@Column(name = "purpose", nullable = true)
	private String purpose;
	
	@Column(name = "total_size", nullable = true)
	private String totalSize;
	
	@Column(name = "fees", nullable = true)
	private double fees;
	
	@Column(name = "exhibitions", nullable = true)
	private String exhibitions;
	
	@Column(name = "event_date", nullable = true)
	private String eventDate;

	@Column(name = "reason_for_certificate", nullable = true)
	private String reasonForCertificate;

	@Column(name = "pavilion_length", nullable = true)
	private String pavilionLength;

	@Column(name = "pavilion_breadth", nullable = true)
	private String pavilionBreadth;

	@Column(name = "pavilion_start_date", nullable = true)
	private String pavilionStartDate;

	@Column(name = "pavilion_end_date", nullable = true)
	private String pavilionEndDate;

	@Transient
	private String filesPath;

	@Column(name = "rti_application_ref_id", nullable = true)
	private String rtiapplrefno;

	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;

	@Column(name = "police_department", nullable = true)
	private String policeDepartment;

	@Column(name = "traffic_department", nullable = true)
	private String trafficDepartment;

	@Column(name = "fire_department", nullable = true)
	private String fireDepartment;

	@Column(name = "fees_demand", nullable = true)
	private String feesDemand;

	@Column(name = "send_demand_status", nullable = true)
	private Integer sendDemandStatus;

	public String getFeesDemand() {
		return feesDemand;
	}

	public void setFeesDemand(String feesDemand) {
		this.feesDemand = feesDemand;
	}

	public Integer getSendDemandStatus() {
		return sendDemandStatus;
	}

	public void setSendDemandStatus(Integer sendDemandStatus) {
		this.sendDemandStatus = sendDemandStatus;
	}

	
	

}
