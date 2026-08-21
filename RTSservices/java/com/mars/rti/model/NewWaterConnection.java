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
@Table(name = "new_water_connection", schema = "egovrti")
public class NewWaterConnection {

	@Id
	@Column(name = "new_water_connection_id", nullable = false, unique = true)
	@SequenceGenerator(name = "new_water_connection_seq", sequenceName = "new_water_connection_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "new_water_connection_seq")
	private long newWaterConnectionId;

	@Column(name = "title", nullable = true)

	private String title;
	
	@Column(name = "city", nullable = true)
	private String city;

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
	private String pinCode;

	@Column(name = "email_id", nullable = true)
	private String email;

	@Column(name = "mobile_no", nullable = true)
	private long mobileNo;

	@Column(name = "aadhaar_no", nullable = true)
	private String aadhaarNo;

	@Column(name = "plot_no", nullable = true)
	private String plotNo;

	@Column(name = "building_name", nullable = true)
	private String buildingName;

	@Column(name = "layout_name", nullable = true)
	private String layoutName;
	
	@Column(name = "road_name", nullable = true)
	private String roadName;
	
	@Column(name = "landmark", nullable = true)
	private String landmark;
	
	@Column(name = "purpose_of_water", nullable = true)
	private String purposeOfWater;
	
	@Column(name = "residential", nullable = true)
	private String residential;

	@Column(name = "slum", nullable = true)
	private String slum;

	@Column(name = "total_no_of_plot", nullable = true)
	private String totalPlotNo;
	
	@Column(name = "zone", nullable = true)
	private String zoneNo;

	@Column(name = "group_housing_apartment", nullable = true)
	private String groupHousingApartment;

	@Column(name = "total_number_of_residential_flats", nullable = true)
	private String totalNumberOfResidentialFlats;

	@Column(name = "total_no_residential_units_not_used", nullable = true)
	private String totalNoResidentialUnitsNotUsed;
	
	@Column(name = "total_no_residential_units_used", nullable = true)
	private String total_no_residential_units;
	
	@Column(name = "total_no_flats_used_for_business", nullable = true)
	private String totalNoResidentialUnitsUsed;
	
	@Column(name = "applicantIdProof", nullable = true)
	private String applicantIdProof;
	
	@Column(name = "currentBill", nullable = true)
	private String currentBill;
	
	@Column(name = "registrySaleDeed", nullable = true)
	private String registrySaleDeed;
	
	@Column(name = "photographs", nullable = true)
	private String photographs;
	
	@Column(name = "slumCertificate", nullable = true)
	private String slumCertificate;
	
	@Column(name = "kabjaPatra", nullable = true)
	private String kabjaPatra;
	
	@Column(name = "photographs1", nullable = true)
	private String photographs1;
	
	@Column(name = "registrySaleDeed1", nullable = true)
	private String registrySaleDeed1;
	
	@Column(name = "gumastaLicense", nullable = true)
	private String gumastaLicense;
	
	@Column(name = "sanctionedBuildingPlan", nullable = true)
	private String sanctionedBuildingPlan;
	
	@Column(name = "photographs2", nullable = true)
	private String photographs2;
	
	@Column(name = "registrySaleDeed2", nullable = true)
	private String registrySaleDeed2;
	
	@Column(name = "consentLetter", nullable = true)
	private String consentLetter;
	
	@Column(name = "dod", nullable = true)
	private String dod;
	
	@Column(name = "nmc_nit", nullable = true)
	private String nmcNit;
	
	@Column(name = "architectCompletionCertificate", nullable = true)
	private String architectCompletionCertificate;
	
	@Column(name = "buildersApplication", nullable = true)
	private String buildersApplication;
	
	@Column(name = "photographs3", nullable = true)
	private String photographs3;
	
	@Transient
	private String filesPath;

	@Column(name = "rti_application_ref_id", nullable = true)
	private String rtiapplrefno;

	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;


	
	@Column(name = "approvalremark", nullable = true)
	private String approvalRemark;
	
	public long getNewWaterConnectionId() {
		return newWaterConnectionId;
	}

	public void setNewWaterConnectionId(long newWaterConnectionId) {
		this.newWaterConnectionId = newWaterConnectionId;
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

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAadharNo() {
		return aadhaarNo;
	}

	public void setAadharNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
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

	public String getLayoutName() {
		return layoutName;
	}

	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPurposeOfWater() {
		return purposeOfWater;
	}

	public void setPurposeOfWater(String purposeOfWater) {
		this.purposeOfWater = purposeOfWater;
	}

	public String getResidential() {
		return residential;
	}

	public void setResidential(String residential) {
		this.residential = residential;
	}

	public String getSlum() {
		return slum;
	}

	public void setSlum(String slum) {
		this.slum = slum;
	}

	public String getTotalPlotNo() {
		return totalPlotNo;
	}

	public void setTotalPlotNo(String totalPlotNo) {
		this.totalPlotNo = totalPlotNo;
	}

	public String getGroupHousingApartment() {
		return groupHousingApartment;
	}

	public void setGroupHousingApartment(String groupHousingApartment) {
		this.groupHousingApartment = groupHousingApartment;
	}

	public String getTotalNumberOfResidentialFlats() {
		return totalNumberOfResidentialFlats;
	}

	public void setTotalNumberOfResidentialFlats(String totalNumberOfResidentialFlats) {
		this.totalNumberOfResidentialFlats = totalNumberOfResidentialFlats;
	}

	public String getTotalNoResidentialUnitsNotUsed() {
		return totalNoResidentialUnitsNotUsed;
	}

	public void setTotalNoResidentialUnitsNotUsed(String totalNoResidentialUnitsNotUsed) {
		this.totalNoResidentialUnitsNotUsed = totalNoResidentialUnitsNotUsed;
	}

	public String getTotalNoResidentialUnitsUsed() {
		return totalNoResidentialUnitsUsed;
	}

	public void setTotalNoResidentialUnitsUsed(String totalNoResidentialUnitsUsed) {
		this.totalNoResidentialUnitsUsed = totalNoResidentialUnitsUsed;
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

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getTotal_no_residential_units() {
		return total_no_residential_units;
	}

	public void setTotal_no_residential_units(String total_no_residential_units) {
		this.total_no_residential_units = total_no_residential_units;
	}

	public String getApplicantIdProof() {
		return applicantIdProof;
	}

	public void setApplicantIdProof(String applicantIdProof) {
		this.applicantIdProof = applicantIdProof;
	}

	public String getCurrentBill() {
		return currentBill;
	}

	public void setCurrentBill(String currentBill) {
		this.currentBill = currentBill;
	}

	public String getRegistrySaleDeed() {
		return registrySaleDeed;
	}

	public void setRegistrySaleDeed(String registrySaleDeed) {
		this.registrySaleDeed = registrySaleDeed;
	}

	public String getPhotographs() {
		return photographs;
	}

	public void setPhotographs(String photographs) {
		this.photographs = photographs;
	}

	public String getSlumCertificate() {
		return slumCertificate;
	}

	public void setSlumCertificate(String slumCertificate) {
		this.slumCertificate = slumCertificate;
	}

	public String getKabjaPatra() {
		return kabjaPatra;
	}

	public void setKabjaPatra(String kabjaPatra) {
		this.kabjaPatra = kabjaPatra;
	}

	public String getPhotographs1() {
		return photographs1;
	}

	public void setPhotographs1(String photographs1) {
		this.photographs1 = photographs1;
	}

	public String getRegistrySaleDeed1() {
		return registrySaleDeed1;
	}

	public void setRegistrySaleDeed1(String registrySaleDeed1) {
		this.registrySaleDeed1 = registrySaleDeed1;
	}

	public String getGumastaLicense() {
		return gumastaLicense;
	}

	public void setGumastaLicense(String gumastaLicense) {
		this.gumastaLicense = gumastaLicense;
	}

	public String getSanctionedBuildingPlan() {
		return sanctionedBuildingPlan;
	}

	public void setSanctionedBuildingPlan(String sanctionedBuildingPlan) {
		this.sanctionedBuildingPlan = sanctionedBuildingPlan;
	}

	public String getPhotographs2() {
		return photographs2;
	}

	public void setPhotographs2(String photographs2) {
		this.photographs2 = photographs2;
	}

	public String getRegistrySaleDeed2() {
		return registrySaleDeed2;
	}

	public void setRegistrySaleDeed2(String registrySaleDeed2) {
		this.registrySaleDeed2 = registrySaleDeed2;
	}

	public String getConsentLetter() {
		return consentLetter;
	}

	public void setConsentLetter(String consentLetter) {
		this.consentLetter = consentLetter;
	}

	public String getDod() {
		return dod;
	}

	public void setDod(String dod) {
		this.dod = dod;
	}

	public String getNmcNit() {
		return nmcNit;
	}

	public void setNmcNit(String nmcNit) {
		this.nmcNit = nmcNit;
	}

	public String getArchitectCompletionCertificate() {
		return architectCompletionCertificate;
	}

	public void setArchitectCompletionCertificate(String architectCompletionCertificate) {
		this.architectCompletionCertificate = architectCompletionCertificate;
	}

	public String getBuildersApplication() {
		return buildersApplication;
	}

	public void setBuildersApplication(String buildersApplication) {
		this.buildersApplication = buildersApplication;
	}

	public String getPhotographs3() {
		return photographs3;
	}

	public void setPhotographs3(String photographs3) {
		this.photographs3 = photographs3;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}
	@Column(name = "demand_fees", nullable = true)
	private String demandfees;
	
	@Column(name = "uploaded_demand", nullable = true)
	private String uploadedDemand;
	
	@Column(name = "payment_status", nullable = true)
	private String paymentStatus;
	
	@Column(name = "acknowledgement", nullable = true)
	private String acknowledgement;

	@Column(name = "tap_size", nullable = true)
	private String tapSize;

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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getTapSize() {
		return tapSize;
	}

	public void setTapSize(String tapSize) {
		this.tapSize = tapSize;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "altermobileno", nullable = true)
	private String alterMobileNo;

	public String getAlterMobileNo() {
		return alterMobileNo;
	}

	public void setAlterMobileNo(String alterMobileNo) {
		this.alterMobileNo = alterMobileNo;
	}
	 
	@Column(name = "instcategory", nullable = true)
	private String instCategory;
	
	@Column(name = "commcategory", nullable = true)
	private String commCategory;

	public String getInstCategory() {
		return instCategory;
	}

	public void setInstCategory(String instCategory) {
		this.instCategory = instCategory;
	}

	public String getCommCategory() {
		return commCategory;
	}

	public void setCommCategory(String commCategory) {
		this.commCategory = commCategory;
	}

	

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
		
	@Column(name = "supportingdoc", nullable = true)
	private String supportingdoc;

	public String getSupportingdoc() {
		return supportingdoc;
	}

	public void setSupportingdoc(String supportingdoc) {
		this.supportingdoc = supportingdoc;
	}
	
	


	
	

}
