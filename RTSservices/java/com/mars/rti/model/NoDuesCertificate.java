package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "no_dues_certificate", schema = "egovrti")
public class NoDuesCertificate {

	@Id
	@Column(name = "ndc_id", nullable = false, unique = true)
	@SequenceGenerator(name = "ndc_id_ser_seq", sequenceName = "ndc_id_ser_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ndc_id_ser_seq")
	private long ndcId;

	@Column(name = "property_holder_name")
	private String propertyHolderName;

	@Column(name = "plot_no")
	private String plotNo;

	@Column(name = "building_name")
	private String buildingName;

	@Column(name = "street_name")
	private String streetName;

	@Column(name = "area_name")
	private String areaName;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "landmark")
	private String landmark;

	@Column(name = "part_name")
	private String partName;

	@Column(name = "geo_location")
	private String geoLocation;

	@Column(name = "city_survey_number")
	private String citySurveyNumber;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "tap_account_number")
	private String tapAccountNumber;

	@Column(name = "electric_meter_number")
	private String electricMeterNumber;

	@Column(name = "zonal_office")
	private String zonalOffice;

	@Column(name = "no_dues_reason")
	private String noDuesReason;

	@Column(name = "rti_appl_ref_no", nullable = true)
	private String rtiapplrefno;
	
	@Column(name = "rti_ref_id", nullable = true )
	private long rti_ref_id;

	public long getRti_ref_id() {
		return rti_ref_id;
	}

	public void setRti_ref_id(long rti_ref_id) {
		this.rti_ref_id = rti_ref_id;
	}


	public long getNdcId() {
		return ndcId;
	}

	public void setNdcId(long ndcId) {
		this.ndcId = ndcId;
	}

	public String getPropertyHolderName() {
		return propertyHolderName;
	}

	public void setPropertyHolderName(String propertyHolderName) {
		this.propertyHolderName = propertyHolderName;
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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	public String getCitySurveyNumber() {
		return citySurveyNumber;
	}

	public void setCitySurveyNumber(String citySurveyNumber) {
		this.citySurveyNumber = citySurveyNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTapAccountNumber() {
		return tapAccountNumber;
	}

	public void setTapAccountNumber(String tapAccountNumber) {
		this.tapAccountNumber = tapAccountNumber;
	}

	public String getElectricMeterNumber() {
		return electricMeterNumber;
	}

	public void setElectricMeterNumber(String electricMeterNumber) {
		this.electricMeterNumber = electricMeterNumber;
	}

	public String getZonalOffice() {
		return zonalOffice;
	}

	public void setZonalOffice(String zonalOffice) {
		this.zonalOffice = zonalOffice;
	}

	public String getNoDuesReason() {
		return noDuesReason;
	}

	public void setNoDuesReason(String noDuesReason) {
		this.noDuesReason = noDuesReason;
	}

	public String getRtiapplrefno() {
		return rtiapplrefno;
	}

	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}

}
