package com.mars.rti.ws.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "title", "fullname", "name", "fathername", "surname", "plot", "building", "street", "city", "zone",
		"pincode", "landmark", "phone", "techqul", "nationality", "nameofother", "nursingplace", "briefdesc",
		"situation", "floorspace", "arrangemedimmu", "floorspaceofrooms", "convdetailsofemp", "detailsstoragefood",
		"equipment", "carryingnursinghome", "nobedmpatient", "nobedopatient", "pdetailsnuringemp", "placeofnstaff",
		"qualification", "qualifiednurse", "unregmedunquilnursingstaff", "qulnursemidwife", "email",
		"unregmedunquilnursing", "aliennationality", "applicantintereste", "noandexpdate", "rtiapplrefno", "rti_ref_id",
		"applicantName", "name_and_otherParticulars", "nursinghomePlace", "totalPatients", "maternityPatients",
		"otherPatients", "registrationDate", "renewalDate", "applicantAddress", "applicantAddress1", "nationality1",
		"outwardNo", "zoneNo", "fees", "result", "responseCode", "responseStatus", "status", "qualifiedNuerseDoc",
		"pdetailsnuringdoc", "qulnursemidwifedoc", "unregmedunquilnursingDoc", "mmc_file", "mnc_file",
		"bio_medical_file", "fire_noc_file", "pollution_file", "water_tax_file", "notarized_file", "sign_and_date_file",
		"userMobileNumber", "renewalFromDate", "renewalToDate", "feesChargeToPatients", "nursing_registration_file",
		"fire_noc_form_b_file" })
public class NursingHomeRenewalRestDTO implements Serializable {

	private String title;

	private String fullname;

	private String name;

	private String fathername;

	private String surname;

	private String plot;

	private String building;

	private String street;

	private String city;

	private int zone;

	private String pincode;

	private String landmark;

	private String phone;

	private String techqul;

	private String nationality;

	private String nameofother;

	private String nursingplace;

	private String briefdesc;

	private String situation;

	private String floorspace;

	private String arrangemedimmu;

	private String floorspaceofrooms;

	private String convdetailsofemp;

	private String detailsstoragefood;

	private String equipment;

	private String carryingnursinghome;

	private String nobedmpatient;

	private String nobedopatient;

	private String pdetailsnuringemp;

	private String placeofnstaff;

	private String qualification;

	private String qualifiednurse;

	private String unregmedunquilnursingstaff;

	private String qulnursemidwife;

	private String email;

	private String unregmedunquilnursing;

	private String aliennationality;

	private String applicantintereste;

	private String noandexpdate;

	private String rtiapplrefno;

	private long rti_ref_id;

	private String applicantName;

	private String name_and_otherParticulars;

	private String nursinghomePlace;

	private String totalPatients;

	private String maternityPatients;

	private String otherPatients;

	private String registrationDate;

	private String renewalDate;

	private String applicantAddress;

	private String applicantAddress1;

	private String nationality1;

	private String outwardNo;

	private String zoneNo;

	private double fees;

	private String result;

	private int responseCode;

	private String responseStatus;

	private String status;

	// pdf

	private String qualifiedNuerseDoc;

	private String pdetailsnuringdoc;

	private String qulnursemidwifedoc;

	private String unregmedunquilnursingDoc;

	private String mmc_file;

	private String mnc_file;

	private String bio_medical_file;

	private String fire_noc_file;

	private String pollution_file;

	private String water_tax_file;

	private String notarized_file;

	private String sign_and_date_file;

	private long userMobileNumber;

	// new
	private String renewalFromDate;

	private String renewalToDate;

	private double feesChargeToPatients;

	// new file
	private String nursing_registration_file;

	private String fire_noc_form_b_file;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTechqul() {
		return techqul;
	}

	public void setTechqul(String techqul) {
		this.techqul = techqul;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNameofother() {
		return nameofother;
	}

	public void setNameofother(String nameofother) {
		this.nameofother = nameofother;
	}

	public String getNursingplace() {
		return nursingplace;
	}

	public void setNursingplace(String nursingplace) {
		this.nursingplace = nursingplace;
	}

	public String getBriefdesc() {
		return briefdesc;
	}

	public void setBriefdesc(String briefdesc) {
		this.briefdesc = briefdesc;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getFloorspace() {
		return floorspace;
	}

	public void setFloorspace(String floorspace) {
		this.floorspace = floorspace;
	}

	public String getArrangemedimmu() {
		return arrangemedimmu;
	}

	public void setArrangemedimmu(String arrangemedimmu) {
		this.arrangemedimmu = arrangemedimmu;
	}

	public String getFloorspaceofrooms() {
		return floorspaceofrooms;
	}

	public void setFloorspaceofrooms(String floorspaceofrooms) {
		this.floorspaceofrooms = floorspaceofrooms;
	}

	public String getConvdetailsofemp() {
		return convdetailsofemp;
	}

	public void setConvdetailsofemp(String convdetailsofemp) {
		this.convdetailsofemp = convdetailsofemp;
	}

	public String getDetailsstoragefood() {
		return detailsstoragefood;
	}

	public void setDetailsstoragefood(String detailsstoragefood) {
		this.detailsstoragefood = detailsstoragefood;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getCarryingnursinghome() {
		return carryingnursinghome;
	}

	public void setCarryingnursinghome(String carryingnursinghome) {
		this.carryingnursinghome = carryingnursinghome;
	}

	public String getNobedmpatient() {
		return nobedmpatient;
	}

	public void setNobedmpatient(String nobedmpatient) {
		this.nobedmpatient = nobedmpatient;
	}

	public String getNobedopatient() {
		return nobedopatient;
	}

	public void setNobedopatient(String nobedopatient) {
		this.nobedopatient = nobedopatient;
	}

	public String getPdetailsnuringemp() {
		return pdetailsnuringemp;
	}

	public void setPdetailsnuringemp(String pdetailsnuringemp) {
		this.pdetailsnuringemp = pdetailsnuringemp;
	}

	public String getPlaceofnstaff() {
		return placeofnstaff;
	}

	public void setPlaceofnstaff(String placeofnstaff) {
		this.placeofnstaff = placeofnstaff;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getQualifiednurse() {
		return qualifiednurse;
	}

	public void setQualifiednurse(String qualifiednurse) {
		this.qualifiednurse = qualifiednurse;
	}

	public String getUnregmedunquilnursingstaff() {
		return unregmedunquilnursingstaff;
	}

	public void setUnregmedunquilnursingstaff(String unregmedunquilnursingstaff) {
		this.unregmedunquilnursingstaff = unregmedunquilnursingstaff;
	}

	public String getQulnursemidwife() {
		return qulnursemidwife;
	}

	public void setQulnursemidwife(String qulnursemidwife) {
		this.qulnursemidwife = qulnursemidwife;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUnregmedunquilnursing() {
		return unregmedunquilnursing;
	}

	public void setUnregmedunquilnursing(String unregmedunquilnursing) {
		this.unregmedunquilnursing = unregmedunquilnursing;
	}

	public String getAliennationality() {
		return aliennationality;
	}

	public void setAliennationality(String aliennationality) {
		this.aliennationality = aliennationality;
	}

	public String getApplicantintereste() {
		return applicantintereste;
	}

	public void setApplicantintereste(String applicantintereste) {
		this.applicantintereste = applicantintereste;
	}

	public String getNoandexpdate() {
		return noandexpdate;
	}

	public void setNoandexpdate(String noandexpdate) {
		this.noandexpdate = noandexpdate;
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

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getName_and_otherParticulars() {
		return name_and_otherParticulars;
	}

	public void setName_and_otherParticulars(String name_and_otherParticulars) {
		this.name_and_otherParticulars = name_and_otherParticulars;
	}

	public String getNursinghomePlace() {
		return nursinghomePlace;
	}

	public void setNursinghomePlace(String nursinghomePlace) {
		this.nursinghomePlace = nursinghomePlace;
	}

	public String getTotalPatients() {
		return totalPatients;
	}

	public void setTotalPatients(String totalPatients) {
		this.totalPatients = totalPatients;
	}

	public String getMaternityPatients() {
		return maternityPatients;
	}

	public void setMaternityPatients(String maternityPatients) {
		this.maternityPatients = maternityPatients;
	}

	public String getOtherPatients() {
		return otherPatients;
	}

	public void setOtherPatients(String otherPatients) {
		this.otherPatients = otherPatients;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(String renewalDate) {
		this.renewalDate = renewalDate;
	}

	public String getApplicantAddress() {
		return applicantAddress;
	}

	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}

	public String getApplicantAddress1() {
		return applicantAddress1;
	}

	public void setApplicantAddress1(String applicantAddress1) {
		this.applicantAddress1 = applicantAddress1;
	}

	public String getNationality1() {
		return nationality1;
	}

	public void setNationality1(String nationality1) {
		this.nationality1 = nationality1;
	}

	public String getOutwardNo() {
		return outwardNo;
	}

	public void setOutwardNo(String outwardNo) {
		this.outwardNo = outwardNo;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQualifiedNuerseDoc() {
		return qualifiedNuerseDoc;
	}

	public void setQualifiedNuerseDoc(String qualifiedNuerseDoc) {
		this.qualifiedNuerseDoc = qualifiedNuerseDoc;
	}

	public String getPdetailsnuringdoc() {
		return pdetailsnuringdoc;
	}

	public void setPdetailsnuringdoc(String pdetailsnuringdoc) {
		this.pdetailsnuringdoc = pdetailsnuringdoc;
	}

	public String getQulnursemidwifedoc() {
		return qulnursemidwifedoc;
	}

	public void setQulnursemidwifedoc(String qulnursemidwifedoc) {
		this.qulnursemidwifedoc = qulnursemidwifedoc;
	}

	public String getUnregmedunquilnursingDoc() {
		return unregmedunquilnursingDoc;
	}

	public void setUnregmedunquilnursingDoc(String unregmedunquilnursingDoc) {
		this.unregmedunquilnursingDoc = unregmedunquilnursingDoc;
	}

	public String getMmc_file() {
		return mmc_file;
	}

	public void setMmc_file(String mmc_file) {
		this.mmc_file = mmc_file;
	}

	public String getMnc_file() {
		return mnc_file;
	}

	public void setMnc_file(String mnc_file) {
		this.mnc_file = mnc_file;
	}

	public String getBio_medical_file() {
		return bio_medical_file;
	}

	public void setBio_medical_file(String bio_medical_file) {
		this.bio_medical_file = bio_medical_file;
	}

	public String getFire_noc_file() {
		return fire_noc_file;
	}

	public void setFire_noc_file(String fire_noc_file) {
		this.fire_noc_file = fire_noc_file;
	}

	public String getPollution_file() {
		return pollution_file;
	}

	public void setPollution_file(String pollution_file) {
		this.pollution_file = pollution_file;
	}

	public String getWater_tax_file() {
		return water_tax_file;
	}

	public void setWater_tax_file(String water_tax_file) {
		this.water_tax_file = water_tax_file;
	}

	public String getNotarized_file() {
		return notarized_file;
	}

	public void setNotarized_file(String notarized_file) {
		this.notarized_file = notarized_file;
	}

	public String getSign_and_date_file() {
		return sign_and_date_file;
	}

	public void setSign_and_date_file(String sign_and_date_file) {
		this.sign_and_date_file = sign_and_date_file;
	}

	public long getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	public String getRenewalFromDate() {
		return renewalFromDate;
	}

	public void setRenewalFromDate(String renewalFromDate) {
		this.renewalFromDate = renewalFromDate;
	}

	public String getRenewalToDate() {
		return renewalToDate;
	}

	public void setRenewalToDate(String renewalToDate) {
		this.renewalToDate = renewalToDate;
	}

	public double getFeesChargeToPatients() {
		return feesChargeToPatients;
	}

	public void setFeesChargeToPatients(double feesChargeToPatients) {
		this.feesChargeToPatients = feesChargeToPatients;
	}

	public String getNursing_registration_file() {
		return nursing_registration_file;
	}

	public void setNursing_registration_file(String nursing_registration_file) {
		this.nursing_registration_file = nursing_registration_file;
	}

	public String getFire_noc_form_b_file() {
		return fire_noc_form_b_file;
	}

	public void setFire_noc_form_b_file(String fire_noc_form_b_file) {
		this.fire_noc_form_b_file = fire_noc_form_b_file;
	}

}
