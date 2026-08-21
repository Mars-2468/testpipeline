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
@Table(name = "diksha_bhumi_mandap_permission", schema = "egovrti")
public class DikshaBhumiMandapPermission {

	@Id
	@Column(name = "diksha_bhumi_mandap_permissionId", nullable = false, unique = true)
	@SequenceGenerator(name = "diksha_bhumi_mandap_permission_seq", sequenceName = "diksha_bhumi_mandap_permission_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diksha_bhumi_mandap_permission_seq")
	private long dikshaBhumiMandapPermissionId;

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
	
	//new fields
	@Column(name = "gate_length", nullable = true)
	private String gateLength;
	
	@Column(name = "gate_breadth", nullable = true)
	private String gateBreadth;
	
	@Column(name = "gatetotalSize", nullable = true)
	private String gatetotalSize;
	
	@Column(name = "gatefees", nullable = true)
	private String gatefees;
	
	@Column(name="fire_noc")
	private String fireNoc;
	
	@Column(name="traffic_noc")
	private String trafficNoc;

	@Column(name="police_noc")
	private String policeNoc;

	@Column(name = "ploiceremarks", nullable = true)
	private String ploiceremarks;
	
	@Column(name = "trafficremarks", nullable = true)
	private String trafficremarks;
	
	@Column(name = "fireremarks", nullable = true)
	private String fireremarks;
	
	@Column(name = "totalfees", nullable = true)
	private String totalfees;
	
	

	public long getDikshaBhumiMandapPermissionId() {
		return dikshaBhumiMandapPermissionId;
	}

	public void setDikshaBhumiMandapPermissionId(
			long dikshaBhumiMandapPermissionId) {
		this.dikshaBhumiMandapPermissionId = dikshaBhumiMandapPermissionId;
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

	public String getPavilionStartDate() {
		return pavilionStartDate;
	}

	public void setPavilionStartDate(String pavilionStartDate) {
		this.pavilionStartDate = pavilionStartDate;
	}

	public String getPavilionEndDate() {
		return pavilionEndDate;
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

	public String getGateLength() {
		return gateLength;
	}

	public void setGateLength(String gateLength) {
		this.gateLength = gateLength;
	}

	public String getGateBreadth() {
		return gateBreadth;
	}

	public void setGateBreadth(String gateBreadth) {
		this.gateBreadth = gateBreadth;
	}

	public String getGatetotalSize() {
		return gatetotalSize;
	}

	public void setGatetotalSize(String gatetotalSize) {
		this.gatetotalSize = gatetotalSize;
	}

	public String getGatefees() {
		return gatefees;
	}

	public void setGatefees(String gatefees) {
		this.gatefees = gatefees;
	}

	public String getFireNoc() {
		return fireNoc;
	}

	public void setFireNoc(String fireNoc) {
		this.fireNoc = fireNoc;
	}

	public String getTrafficNoc() {
		return trafficNoc;
	}

	public void setTrafficNoc(String trafficNoc) {
		this.trafficNoc = trafficNoc;
	}

	public String getPoliceNoc() {
		return policeNoc;
	}

	public void setPoliceNoc(String policeNoc) {
		this.policeNoc = policeNoc;
	}

	public String getPloiceremarks() {
		return ploiceremarks;
	}

	public void setPloiceremarks(String ploiceremarks) {
		this.ploiceremarks = ploiceremarks;
	}

	public String getTrafficremarks() {
		return trafficremarks;
	}

	public void setTrafficremarks(String trafficremarks) {
		this.trafficremarks = trafficremarks;
	}

	public String getFireremarks() {
		return fireremarks;
	}

	public void setFireremarks(String fireremarks) {
		this.fireremarks = fireremarks;
	}

	public String getTotalfees() {
		return totalfees;
	}

	public void setTotalfees(String totalfees) {
		this.totalfees = totalfees;
	}

	
	
	

}
