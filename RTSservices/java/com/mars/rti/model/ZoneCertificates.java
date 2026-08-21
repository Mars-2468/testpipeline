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
@Table(name="zone_certificates", schema= "egovrti")


public class ZoneCertificates {
	
	@Id
	@Column(name = "zone_certificates_id", nullable = false, unique = true)
	@SequenceGenerator(name = "zone_certificate_ser_seq", sequenceName = "zone_certificate_ser_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zone_certificate_ser_seq")
	private long zoneCertificatesId;

	
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
	
	@Column(name="aadhar_no", nullable = true)
    private String aadhaarNo;
	
	@Column(name="zone_no", nullable = true)
    private String zoneNo;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name="address", nullable = true)
    private String address;
	
	@Column(name="pincode", nullable = true)
    private long pinCode;

	
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
	

	@Column(name = "zone_certificate", nullable = true )
	private String calnumber;
	
	@Column(name = "fees_applicable", nullable = true )
	private int feesApplicable;

	@Column(name = "license_no", nullable = true )
	private String licenseNo;
	
	@Column(name = "mouza_zone", nullable = true)
	private String mouzaZone;
	
	
	/*
	 * @Column(name = "survey_doc", nullable = true ) private String surveyDoc;
	 * 
	 * @Column(name = "surveymap_doc", nullable = true ) private String
	 * surveymapDoc;
	 */
	@Column(name = "rti_appl_ref_no", nullable = true )
	private String rtiapplrefno;
                                                                                                   
	@Column(name = "rti_ref_id", nullable = true )                                               
	private long rti_ref_id;
	
	@Transient
	private String filesPath;
	
	/*
	 * @Transient private String files;
	 * 
	 * public String getFiles() { return files; }
	 * 
	 * public void setFiles(String files) { this.files = files; }
	 */

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

	public long getZoneCertificatesId() {
		return zoneCertificatesId;
	}

	public void setZoneCertificatesId(long zoneCertificatesId) {
		this.zoneCertificatesId = zoneCertificatesId;
	}
	
	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
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

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long l) {
		this.pinCode = l;
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



	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getCalnumber() {
		return calnumber;
	}

	public void setCalnumber(String calnumber) {
		this.calnumber = calnumber;
	}

	public int getFeesApplicable() {
		return feesApplicable;
	}

	public void setFeesApplicable(int feesApplicable) {
		this.feesApplicable = feesApplicable;
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


	@Column(name = "use_of_land", nullable = true )
	private String useOfLand;

	public String getUseOfLand() {
		return useOfLand;
	}

	public void setUseOfLand(String useOfLand) {
		this.useOfLand = useOfLand;
	}

	/*
	 * public String getSurveyDoc() { return surveyDoc; }
	 * 
	 * public void setSurveyDoc(String surveyDoc) { this.surveyDoc = surveyDoc; }
	 * 
	 * public String getSurveymapDoc() { return surveymapDoc; }
	 * 
	 * public void setSurveymapDoc(String surveymapDoc) { this.surveymapDoc =
	 * surveymapDoc; }
	 */

//	@Override
//	public String toString() {
//		return "ZoneCertificates [zoneCertificatesId=" + zoneCertificatesId + ", title=" + title + ", firstName="
//				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", address=" + address
//				+ ", pinCode=" + pinCode + ", email=" + email + ", mobileNo=" + mobileNo + ", buildingNo=" + buildingNo
//				+ ", plotNo=" + plotNo + ", revenueNo=" + revenueNo + ", gatNo=" + gatNo + ", khasaraNo=" + khasaraNo
//				+ ", citySurveyNo=" + citySurveyNo + ", finalPlotNo=" + finalPlotNo + ", mouje=" + mouje
//				+ ", architectName=" + architectName + ", zoneCertificate=" + zoneCertificate + ", feesApplicable="
//				+ feesApplicable + ", licenseNo=" + licenseNo + "]";
//	}
	
	
}