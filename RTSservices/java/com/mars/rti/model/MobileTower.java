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
@Table(name = "mobile_tower", schema = "egovrti")
public class MobileTower {
	@Id
	@Column(name = "mobile_tower_id", nullable = false, unique = true)
	@SequenceGenerator(name = "mobile_tower_seq", sequenceName = "mobile_tower_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobile_tower_seq")
	private long mobileTowerId;

	@Column(name = "name", nullable = true)

	private String name;

	@Column(name = "address", nullable = true)
	private String address;

	@Column(name = "owner_name", nullable = true)
	private String ownerName;

	@Column(name = "owner_address", nullable = true)
	private String ownerAddress;

	@Column(name = "plot_no", nullable = true)
	private String plotNo;

	@Column(name = "area", nullable = true)
	private String area;

	@Column(name = "street_name", nullable = true)
	private String streetName;

	@Column(name = "applicant_mouza", nullable = true)
	private String applicantMouza;

	@Column(name = "pincode", nullable = true)
	private String pincode;

	@Column(name = "aadhaar_no", nullable = true)
	private String aadhaarNo;

	@Column(name = "email", nullable = true)
	private String email;

	@Column(name = "mobile_no", nullable = true)
	private String mobileNo;

	@Column(name = "current_address", nullable = true)
	private String currentAddress;
	
	@Column(name = "mouza", nullable = true)
	private String mouza;
	
	@Column(name = "sheet_no", nullable = true)
	private String sheetNo;
	
	@Column(name = "city_survey_no", nullable = true)
	private String citySurveyNo;
	
	@Column(name = "zone_no", nullable = true)
	private String zoneNo;
	
	@Column(name = "ward_no", nullable = true)
	private String wardNo;

	@Column(name = "municipal_mouza", nullable = true)
	private String municipalMouza;

	@Column(name = "upin", nullable = true)
	private String upin;

	@Column(name = "society_name", nullable = true)
	private String societyName;

	@Column(name = "building_owner", nullable = true)
	private String buildingOwner;

	@Column(name = "mobile_tower_company_name", nullable = true)
	private String mobileTowerCompanyName;

	@Column(name = "tower_type", nullable = true)
	private String towerType;
	
	@Column(name = "started_date", nullable = true)
	private String startedDate;
	
	@Column(name = "tower_category", nullable = true)
	private String pob;
	
	@Column(name = "manora_area", nullable = true)
	private String manoraArea;
	
	@Column(name = "site_address", nullable = true)
	private String siteAddress;
	
	@Column(name = "diesel_generator_sector", nullable = true)
	private String dieselGeneratorSector;
	
	@Column(name = "panel_control_room_area", nullable = true)
	private String panelControlRoomArea;
	
	@Column(name = "total_area", nullable = true)
	private String totalArea;
	
	@Column(name = "scrutiny_fees", nullable = true)
	private String scrutinyFees;
	
	@Column(name = "total_fees", nullable = true)
	private double totalFees;
	
	@Column(name = "existing_height", nullable = true)
	private String existingHeight;
	
	@Column(name = "total_height", nullable = true)
	private String totalHeight;
	
	@Column(name = "latitude_and_longitude", nullable = true)
	private String latitudeAndLongitude;
	
	@Column(name = "ownership_document", nullable = true)
	private String ownershipDocument;
	
	@Column(name = "building_occupancy", nullable = true)
	private String buildingOccupancy;
	
	@Column(name = "location_plan", nullable = true)
	private String locationPlan;
	
	@Column(name = "structural_stability_certificate", nullable = true)
	private String structuralStabilityCertificate;
	
	@Column(name = "no_objection_certificate", nullable = true)
	private String noObjectionCertificate;
	
	@Column(name = "tax_receipt", nullable = true)
	private String taxReceipt;
	
	@Column(name = "housing_society", nullable = true)
	private String housingSociety;
	
	@Column(name = "diesel_generators", nullable = true)
	private String dieselGenerators;
	
	@Column(name = "fire_dept", nullable = true)
	private String fireDept;
	
	@Column(name = "no_encroachment_certificate", nullable = true)
	private String noEncroachmentCertificate;
	
	@Column(name = "exemption_certificate", nullable = true)
	private String exemptionCertificate;
	
	@Column(name = "certificate_of_term_cell", nullable = true)
	private String certificateOfTermCell;
	
	@Column(name = "agreement", nullable = true)
	private String agreement;
	
	@Column(name = "letterOf_guarantee", nullable = true)
	private String letterOfGuarantee;
	
	@Column(name = "structural_engineer", nullable = true)
	private String structuralEngineer;
	
	@Column(name = "advisoory_committee", nullable = true)
	private String advisooryCommittee;
	
	@Transient
	private String filesPath;

	@Column(name = "rti_application_ref_id", nullable = true)
	private String rtiapplrefno;

	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;

	public long getMobileTowerId() {
		return mobileTowerId;
	}

	public void setMobileTowerId(long mobileTowerId) {
		this.mobileTowerId = mobileTowerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getApplicantMouza() {
		return applicantMouza;
	}

	public void setApplicantMouza(String applicantMouza) {
		this.applicantMouza = applicantMouza;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
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

	
	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getMouza() {
		return mouza;
	}

	public void setMouza(String mouza) {
		this.mouza = mouza;
	}

	public String getCitySurveyNo() {
		return citySurveyNo;
	}

	public void setCitySurveyNo(String citySurveyNo) {
		this.citySurveyNo = citySurveyNo;
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

	public String getMunicipalMouza() {
		return municipalMouza;
	}

	public void setMunicipalMouza(String municipalMouza) {
		this.municipalMouza = municipalMouza;
	}

	public String getUpin() {
		return upin;
	}

	public void setUpin(String upin) {
		this.upin = upin;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public String getBuildingOwner() {
		return buildingOwner;
	}

	public void setBuildingOwner(String buildingOwner) {
		this.buildingOwner = buildingOwner;
	}

	public String getMobileTowerCompanyName() {
		return mobileTowerCompanyName;
	}

	public void setMobileTowerCompanyName(String mobileTowerCompanyName) {
		this.mobileTowerCompanyName = mobileTowerCompanyName;
	}

	public String getTowerType() {
		return towerType;
	}

	public void setTowerType(String towerType) {
		this.towerType = towerType;
	}

	public String getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(String startedDate) {
		this.startedDate = startedDate;
	}

	public String getPob() {
		return pob;
	}

	public void setPob(String pob) {
		this.pob = pob;
	}

	public String getManoraArea() {
		return manoraArea;
	}

	public void setManoraArea(String manoraArea) {
		this.manoraArea = manoraArea;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public String getDieselGeneratorSector() {
		return dieselGeneratorSector;
	}

	public void setDieselGeneratorSector(String dieselGeneratorSector) {
		this.dieselGeneratorSector = dieselGeneratorSector;
	}

	public String getPanelControlRoomArea() {
		return panelControlRoomArea;
	}

	public void setPanelControlRoomArea(String panelControlRoomArea) {
		this.panelControlRoomArea = panelControlRoomArea;
	}

	public String getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(String totalArea) {
		this.totalArea = totalArea;
	}

	public String getScrutinyFees() {
		return scrutinyFees;
	}

	public void setScrutinyFees(String scrutinyFees) {
		this.scrutinyFees = scrutinyFees;
	}

	public double getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(double totalFees) {
		this.totalFees = totalFees;
	}

	public String getExistingHeight() {
		return existingHeight;
	}

	public void setExistingHeight(String existingHeight) {
		this.existingHeight = existingHeight;
	}

	public String getTotalHeight() {
		return totalHeight;
	}

	public void setTotalHeight(String totalHeight) {
		this.totalHeight = totalHeight;
	}

	public String getLatitudeAndLongitude() {
		return latitudeAndLongitude;
	}

	public void setLatitudeAndLongitude(String latitudeAndLongitude) {
		this.latitudeAndLongitude = latitudeAndLongitude;
	}

	public String getOwnershipDocument() {
		return ownershipDocument;
	}

	public void setOwnershipDocument(String ownershipDocument) {
		this.ownershipDocument = ownershipDocument;
	}

	public String getBuildingOccupancy() {
		return buildingOccupancy;
	}

	public void setBuildingOccupancy(String buildingOccupancy) {
		this.buildingOccupancy = buildingOccupancy;
	}

	public String getLocationPlan() {
		return locationPlan;
	}

	public void setLocationPlan(String locationPlan) {
		this.locationPlan = locationPlan;
	}

	public String getStructuralStabilityCertificate() {
		return structuralStabilityCertificate;
	}

	public void setStructuralStabilityCertificate(String structuralStabilityCertificate) {
		this.structuralStabilityCertificate = structuralStabilityCertificate;
	}

	public String getNoObjectionCertificate() {
		return noObjectionCertificate;
	}

	public void setNoObjectionCertificate(String noObjectionCertificate) {
		this.noObjectionCertificate = noObjectionCertificate;
	}

	public String getTaxReceipt() {
		return taxReceipt;
	}

	public void setTaxReceipt(String taxReceipt) {
		this.taxReceipt = taxReceipt;
	}

	public String getHousingSociety() {
		return housingSociety;
	}

	public void setHousingSociety(String housingSociety) {
		this.housingSociety = housingSociety;
	}

	public String getDieselGenerators() {
		return dieselGenerators;
	}

	public void setDieselGenerators(String dieselGenerators) {
		this.dieselGenerators = dieselGenerators;
	}

	public String getFireDept() {
		return fireDept;
	}

	public void setFireDept(String fireDept) {
		this.fireDept = fireDept;
	}

	public String getNoEncroachmentCertificate() {
		return noEncroachmentCertificate;
	}

	public void setNoEncroachmentCertificate(String noEncroachmentCertificate) {
		this.noEncroachmentCertificate = noEncroachmentCertificate;
	}

	public String getExemptionCertificate() {
		return exemptionCertificate;
	}

	public void setExemptionCertificate(String exemptionCertificate) {
		this.exemptionCertificate = exemptionCertificate;
	}

	public String getCertificateOfTermCell() {
		return certificateOfTermCell;
	}

	public void setCertificateOfTermCell(String certificateOfTermCell) {
		this.certificateOfTermCell = certificateOfTermCell;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getLetterOfGuarantee() {
		return letterOfGuarantee;
	}

	public void setLetterOfGuarantee(String letterOfGuarantee) {
		this.letterOfGuarantee = letterOfGuarantee;
	}

	public String getStructuralEngineer() {
		return structuralEngineer;
	}

	public void setStructuralEngineer(String structuralEngineer) {
		this.structuralEngineer = structuralEngineer;
	}

	public String getAdvisooryCommittee() {
		return advisooryCommittee;
	}

	public void setAdvisooryCommittee(String advisooryCommittee) {
		this.advisooryCommittee = advisooryCommittee;
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

	public String getSheetNo() {
		return sheetNo;
	}

	public void setSheetNo(String sheetNo) {
		this.sheetNo = sheetNo;
	}

	
}

