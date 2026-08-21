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
@Table(name="occupancy_certificate",schema="egovrti")

public class OccupancyCertificate {
	
	@Id
	@Column(name = "occupancy_certificate_id", nullable = false, unique = true)
	@SequenceGenerator(name = "occupancy_certificate_ser_seq", sequenceName = "occupancy_certificate_ser_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "occupancy_certificate_ser_seq")
	private long occupancyCertificateId;
	
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
	
	@Column(name="aadhaar_no", nullable = true)
    private String aadharNo ;
	
	@Column(name="address", nullable = true)
    private String address;
	
	@Column(name="pincode", nullable = true)
    private int pinCode;

	
	@Column(name = "email_id", nullable = true )
	private String email;
	
	@Column(name = "mobile_no", nullable = true )
	private String mobileNo;
	
	@Column(name = "building_no", nullable = true )
	private String buildingNo;
	
	@Column(name = "plot_no", nullable = true )
	private String plotNo;
	
	@Column(name = "revenue_no", nullable = true )
	private String revenueNo;
	
	@Column(name = "gat_no", nullable = true )
	private String gatNo;
	
	@Column(name = "khasara_no", nullable = true )
	private String khasaraNo;
	
	@Column(name = "citysurvey_no", nullable = true )
	private String citySurveyNo;
	
	@Column(name = "finalplot_no", nullable = true )
	private String finalPlotNo;
	
	@Column(name = "mouje", nullable = true )
	private String mouje;
	
	@Column(name = "architect_name", nullable = true )
	private String architectName;
	
	@Column(name = "structural_licenseno", nullable = true )
	private String structuralLicenseNo;
	
	@Column(name = "occupancy_certificate", nullable = true )
	private String occupancyCertificate;
	
	@Column(name = "total_area", nullable = true )
	private String area;
	
	@Column(name = "zone_no", nullable = true )
	private String zoneNo;
	
	@Column(name = "fees_applicable", nullable = true )
	private int feesApplicable;

	@Column(name = "rti_appl_ref_no", nullable = true )
	private String rtiapplrefno;
	
	@Column(name = " rti_ref_id", nullable = true )
	private long rti_ref_id;
	
	@Column(name = "mouza_zone", nullable = true)
	private String mouzaZone;
	
	
	@Transient
	private String filesPath;
	
	
	
	public String getFilesPath() {
		return filesPath;
	}


	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}


	public long getOccupancyCertificateId() {
		return occupancyCertificateId;
	}


	public void setOccupancyCertificateId(long occupancyCertificateId) {
		this.occupancyCertificateId = occupancyCertificateId;
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


	public String getBuildingNo() {
		return buildingNo;
	}


	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
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


	public String getCitySurveyNo() {
		return citySurveyNo;
	}


	public void setCitySurveyNo(String citySurveyNo) {
		this.citySurveyNo = citySurveyNo;
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


	public String getArchitectName() {
		return architectName;
	}


	public void setArchitectName(String architectName) {
		this.architectName = architectName;
	}


	

	public String getStructuralLicenseNo() {
		return structuralLicenseNo;
	}


	public void setStructuralLicenseNo(String structuralLicenseNo) {
		this.structuralLicenseNo = structuralLicenseNo;
	}


	public String getOccupancyCertificate() {
		return occupancyCertificate;
	}


	public void setOccupancyCertificate(String occupancyCertificate) {
		this.occupancyCertificate = occupancyCertificate;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public int getFeesApplicable() {
		return feesApplicable;
	}


	public void setFeesApplicable(int feesApplicable) {
		this.feesApplicable = feesApplicable;
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


	public String getMouzaZone() {
		return mouzaZone;
	}


	public void setMouzaZone(String mouzaZone) {
		this.mouzaZone = mouzaZone;
	}


	

}