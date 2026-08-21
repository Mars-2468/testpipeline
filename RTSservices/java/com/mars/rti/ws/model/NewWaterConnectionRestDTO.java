package com.mars.rti.ws.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("serial")
@JsonPropertyOrder({ "title", "name", "fatherName", "surname", "fullName", "pinCode", "email", "mobileNo",
		"address", "plotNo", "buildingName", "layoutName", "roadName", "landmark", "zoneNo", "city",
		"alternateMobileNo", "purposeOfWater", "residential", "residentialTapSize", "copyOfTaxReceiptresidentialPDF",
		"registrySaleDeedResidentialPDF", "slum", "slumCertificatePDF", "totalNoOfPlots",
		"registrySaleDeedOfFlatSchemePDF", "consonentLetterPDF", "dodPDF", "buildingSanactionPlanPDF",
		"architectCompletionCertificatePDF", "categoryOfInstitutional", "registrySaleDeedOfInstitutuionalPDF",
		"gumastaLicensePDF", "categoryOfCommercial", "applicantIdProofPDF", "copyOfTaxReceiptPDF", "photographsPDF",
		"mobileUserNo", "responseStatus", "responseCode", "result", "status" })
public class NewWaterConnectionRestDTO implements Serializable {

	private String title;

	private String name;

	private String fatherName;

	private String surname;

	private String fullName;

	private long pinCode;

	private String email;

	private long mobileNo;

	private String address;

	private String plotNo;

	private String buildingName;

	private String layoutName;

	private String roadName;

	private String landmark;

	private int zoneNo;

	// new fields
	private String city;

	private long alternateMobileNo;

	private String purposeOfWater;

	// if residential then
	private String residentialTapSize;

	// doc

	private String copyOfTaxReceiptresidentialPDF;

	private String registrySaleDeedResidentialPDF;

	// if slum then
	private String slum;

	// doc
	private String slumCertificatePDF;

	// if Flat Scheme
	private String totalNoOfPlots;

	// doc

	private String registrySaleDeedOfFlatSchemePDF;

	private String consonentLetterPDF;

	private String dodPDF;

	private String buildingSanactionPlanPDF;

	private String architectCompletionCertificatePDF;

	// If Institutional then
	private String categoryOfInstitutional;

	// doc
	private String registrySaleDeedOfInstitutuionalPDF;

	private String gumastaLicensePDF;

	// If Commericial then
	private String categoryOfCommercial;

	// doc same as institutional

	// Common Docs
	private String applicantIdProofPDF;

	private String copyOfTaxReceiptPDF;

	private String photographsPDF;
	
	//end

	private long mobileUserNo;

	private String responseStatus;

	private long responseCode;

	private String result;

	private String status;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(int zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getAlternateMobileNo() {
		return alternateMobileNo;
	}

	public void setAlternateMobileNo(long alternateMobileNo) {
		this.alternateMobileNo = alternateMobileNo;
	}

	public String getPurposeOfWater() {
		return purposeOfWater;
	}

	public void setPurposeOfWater(String purposeOfWater) {
		this.purposeOfWater = purposeOfWater;
	}

	public String getResidentialTapSize() {
		return residentialTapSize;
	}

	public void setResidentialTapSize(String residentialTapSize) {
		this.residentialTapSize = residentialTapSize;
	}

	public String getCopyOfTaxReceiptresidentialPDF() {
		return copyOfTaxReceiptresidentialPDF;
	}

	public void setCopyOfTaxReceiptresidentialPDF(String copyOfTaxReceiptresidentialPDF) {
		this.copyOfTaxReceiptresidentialPDF = copyOfTaxReceiptresidentialPDF;
	}

	public String getRegistrySaleDeedResidentialPDF() {
		return registrySaleDeedResidentialPDF;
	}

	public void setRegistrySaleDeedResidentialPDF(String registrySaleDeedResidentialPDF) {
		this.registrySaleDeedResidentialPDF = registrySaleDeedResidentialPDF;
	}

	public String getSlum() {
		return slum;
	}

	public void setSlum(String slum) {
		this.slum = slum;
	}

	public String getSlumCertificatePDF() {
		return slumCertificatePDF;
	}

	public void setSlumCertificatePDF(String slumCertificatePDF) {
		this.slumCertificatePDF = slumCertificatePDF;
	}

	public String getTotalNoOfPlots() {
		return totalNoOfPlots;
	}

	public void setTotalNoOfPlots(String totalNoOfPlots) {
		this.totalNoOfPlots = totalNoOfPlots;
	}

	public String getRegistrySaleDeedOfFlatSchemePDF() {
		return registrySaleDeedOfFlatSchemePDF;
	}

	public void setRegistrySaleDeedOfFlatSchemePDF(String registrySaleDeedOfFlatSchemePDF) {
		this.registrySaleDeedOfFlatSchemePDF = registrySaleDeedOfFlatSchemePDF;
	}

	public String getConsonentLetterPDF() {
		return consonentLetterPDF;
	}

	public void setConsonentLetterPDF(String consonentLetterPDF) {
		this.consonentLetterPDF = consonentLetterPDF;
	}

	public String getDodPDF() {
		return dodPDF;
	}

	public void setDodPDF(String dodPDF) {
		this.dodPDF = dodPDF;
	}

	public String getBuildingSanactionPlanPDF() {
		return buildingSanactionPlanPDF;
	}

	public void setBuildingSanactionPlanPDF(String buildingSanactionPlanPDF) {
		this.buildingSanactionPlanPDF = buildingSanactionPlanPDF;
	}

	public String getArchitectCompletionCertificatePDF() {
		return architectCompletionCertificatePDF;
	}

	public void setArchitectCompletionCertificatePDF(String architectCompletionCertificatePDF) {
		this.architectCompletionCertificatePDF = architectCompletionCertificatePDF;
	}

	public String getCategoryOfInstitutional() {
		return categoryOfInstitutional;
	}

	public void setCategoryOfInstitutional(String categoryOfInstitutional) {
		this.categoryOfInstitutional = categoryOfInstitutional;
	}

	public String getRegistrySaleDeedOfInstitutuionalPDF() {
		return registrySaleDeedOfInstitutuionalPDF;
	}

	public void setRegistrySaleDeedOfInstitutuionalPDF(String registrySaleDeedOfInstitutuionalPDF) {
		this.registrySaleDeedOfInstitutuionalPDF = registrySaleDeedOfInstitutuionalPDF;
	}

	public String getGumastaLicensePDF() {
		return gumastaLicensePDF;
	}

	public void setGumastaLicensePDF(String gumastaLicensePDF) {
		this.gumastaLicensePDF = gumastaLicensePDF;
	}

	public String getCategoryOfCommercial() {
		return categoryOfCommercial;
	}

	public void setCategoryOfCommercial(String categoryOfCommercial) {
		this.categoryOfCommercial = categoryOfCommercial;
	}

	public String getApplicantIdProofPDF() {
		return applicantIdProofPDF;
	}

	public void setApplicantIdProofPDF(String applicantIdProofPDF) {
		this.applicantIdProofPDF = applicantIdProofPDF;
	}

	public String getCopyOfTaxReceiptPDF() {
		return copyOfTaxReceiptPDF;
	}

	public void setCopyOfTaxReceiptPDF(String copyOfTaxReceiptPDF) {
		this.copyOfTaxReceiptPDF = copyOfTaxReceiptPDF;
	}

	public String getPhotographsPDF() {
		return photographsPDF;
	}

	public void setPhotographsPDF(String photographsPDF) {
		this.photographsPDF = photographsPDF;
	}

	public long getMobileUserNo() {
		return mobileUserNo;
	}

	public void setMobileUserNo(long mobileUserNo) {
		this.mobileUserNo = mobileUserNo;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public long getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(long responseCode) {
		this.responseCode = responseCode;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
