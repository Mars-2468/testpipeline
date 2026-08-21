package com.mars.rti.ws.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@SuppressWarnings("serial")

@JsonPropertyOrder({ "applicantTitle", "applicantName", "applicantFatherName", "applicantSurname","userMobileNumber",

	"husbandOccupationOthers","firstwitndate","firstaadhaarno","secondwitndate","secondaadhaarno","thirdwitndate","thirdaadhaarno",
		"applicantFullName", "applicantpinCode", "applicantaadhaarNo", "applicantemail", "applicantmobileNumber",
		"applicantfullAddress", "marriageDate", "marriagePlace", "marriageLawReligion", "husbandTitle",
		"husbandLastName", "husbandFirstName", "husbandFatherName", "husbandAadhaarNo", "husbandAltName",
		"husbandBirthReligion", "husbandAdoptReligion", "husbandFullAddr", "husbandSolemAgeYear",
		"husbandSolemAgeMonth", "husbanndAgeProof", "husbandOccup", "husbandOccupOthers", "husbandOfficeAddr",
		"husbandStatus", "husbandWitnSignAndDate", "husbandPhotograph", "wifeTitle", "wifeLastName", "wifeFirstName",
		"wifeFatherName", "wifeAadhaarNo", "wifealtName", "wifeBirthReligion", "wifeAdoptReligion", "wifeFullAddress",
		"wifeSolemAgeYear", "wifeSolemAgeMonth", "wifeAgeProof", "wifeStatus", "wifeWitnSignAndDate", "wifePhotograph",
		"firstWitnFullName", "firstWitnFullAddr", "firstWitnOccup", "firstWitnOfficeAddr", "firstWitnRelMarCouple",
		"firstWitnSignAndDate", "firstWitnPhotograph", "secondWitnFullName", "secondWitnFullAddr", "secondWitnOccup",
		"secondWitnOfficeAddr", "secondWitnRelMarCouple", "secondWitnSignAndDate", "secondWitnPhotograph",
		"thirdWitnFullName", "thirdWitnFullAddr", "thirdWitnOccup", "zoneNo", "thirdWitnOfficeAddr",
		"thirdWitnRelMarCouple", "thirdWitnSignAndDate", "thirdWitnPhotograph", "priestName", "priestFullAddr",
		"priestReligion", "priestAge", "priestSignAndDate", "daysCalculatedForCertificate", "feeApplicable",
		"firstOccupOthers", "firstRelationOthers", "secondOccupOthers", "secondRelationOthers", "thirdOccupOthers",
		"thirdRelationOthers", "pdfUploadFromPortal", "result", "responseCode", "responseStatus", "status",
		"marriageCard", "husbandDivorcedProof", "propertyTaxPaid", "proofOfResidence", "courtFeeStamps", "affidavit",
		"photoOfHusbandAndWife", "deathCertificateOfSpouse" })
public class MarriageCertificateRestDTO implements Serializable {

	private String applicantTitle;

	private String applicantName;

	private String applicantFatherName;

	private String applicantSurname;

	private String applicantFullName;

	private int applicantpinCode;

	private long applicantaadhaarNo;

	private String applicantemail;

	private long applicantmobileNumber;

	private String applicantfullAddress;

	private String marriageDate;

	private String marriagePlace;

	private String marriageLawReligion;

	/* Husband/Wife(Bride/Groom Details) */

	private String husbandTitle;

	private String husbandLastName;

	private String husbandFirstName;

	private String husbandFatherName;

	private long husbandAadhaarNo;

	private String husbandAltName;

	private String husbandBirthReligion;

	private String husbandAdoptReligion;

	private String husbandFullAddr;

	private long husbandSolemAgeYear;

	private long husbandSolemAgeMonth;

	private String husbandOccup;

	private String husbandOccupOthers;

	private String husbandOfficeAddr;

	private String husbandStatus;

	private String wifeTitle;

	private String wifeLastName;

	private String wifeFirstName;

	private String wifeFatherName;

	private long wifeAadhaarNo;

	private String wifealtName;

	private String wifeBirthReligion;

	private String wifeAdoptReligion;

	private String wifeFullAddress;

	private long wifeSolemAgeYear;

	private long wifeSolemAgeMonth;

	private String wifeStatus;

	/* Witness(3) Details */

	private String firstWitnFullName;

	private String firstWitnFullAddr;

	private String firstWitnOccup;

	private String firstWitnOfficeAddr;

	private String firstWitnRelMarCouple;

	private String secondWitnFullName;

	private String secondWitnFullAddr;

	private String secondWitnOccup;

	private String secondWitnOfficeAddr;

	private String secondWitnRelMarCouple;

	private String thirdWitnFullName;

	private String thirdWitnFullAddr;

	private String thirdWitnOccup;

	private int zoneNo;

	private String thirdWitnOfficeAddr;

	private String thirdWitnRelMarCouple;

	/* Priest Details */

	private String priestName;

	private String priestFullAddr;

	private String priestReligion;

	private String priestAge;

	private String daysCalculatedForCertificate;

	private double feeApplicable;

	private String firstOccupOthers;

	private String firstRelationOthers;

	private String secondOccupOthers;

	private String secondRelationOthers;

	private String thirdOccupOthers;

	private String thirdRelationOthers;

	private String pdfUploadFromPortal;

	private String result;

	private long responseCode;

	private String responseStatus;

	private String status;

	// pdf
	private String husbandWitnSignAndDate;

	private String husbanndAgeProof;
	private String husbandPhotograph;

	private String wifeAgeProof;
	private String wifeWitnSignAndDate;

	private String wifePhotograph;

	private String firstWitnSignAndDate;

	private String firstWitnPhotograph;

	private String secondWitnSignAndDate;

	private String secondWitnPhotograph;

	private String thirdWitnSignAndDate;

	private String thirdWitnPhotograph;

	private String priestSignAndDate;

	//
	private String marriageCard;

	private String husbandDivorcedProof;

	private String wifeDivorcedProof;

	private String propertyTaxPaid;

	private String proofOfResidence;

	private String courtFeeStamps;

	private String affidavit;

	private String photoOfHusbandAndWife;

	private String deathCertificateOfSpouse;

	private long userMobileNumber;
	//new fields
	private String husbandOccupationOthers;

	private String firstwitndate;

	private String firstaadhaarno;
	private String secondwitndate;
	private String secondaadhaarno;

	private String thirdwitndate;
	private String thirdaadhaarno;

	@XmlElement(name = "userMobileNumber")
	public long getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	@XmlElement(name = "pdfUploadFromPortal")
	public String getPdfUploadFromPortal() {
		return pdfUploadFromPortal;
	}

	public void setPdfUploadFromPortal(String pdfUploadFromPortal) {
		this.pdfUploadFromPortal = pdfUploadFromPortal;
	}

	@XmlElement(name = "applicantTitle")
	public String getApplicantTitle() {
		return applicantTitle;
	}

	
	@XmlElement(name = "applicantName")
	public String getApplicantName() {
		return applicantName;
	}

	@XmlElement(name = "applicantFatherName")
	public String getApplicantFatherName() {
		return applicantFatherName;
	}

	@XmlElement(name = "applicantSurname")
	public String getApplicantSurname() {
		return applicantSurname;
	}

	@XmlElement(name = "applicantFullName")
	public String getApplicantFullName() {
		return applicantFullName;
	}

	@XmlElement(name = "applicantpinCode")
	public int getApplicantpinCode() {
		return applicantpinCode;
	}

	@XmlElement(name = "applicantaadhaarNo")
	public long getApplicantaadhaarNo() {
		return applicantaadhaarNo;
	}

	@XmlElement(name = "applicantemail")
	public String getApplicantemail() {
		return applicantemail;
	}

	@XmlElement(name = "applicantfullAddress")
	public String getApplicantfullAddress() {
		return applicantfullAddress;
	}

	@XmlElement(name = "marriageDate")
	public String getMarriageDate() {
		return marriageDate;
	}

	@XmlElement(name = "marriagePlace")
	public String getMarriagePlace() {
		return marriagePlace;
	}

	@XmlElement(name = "marriageLawReligion")
	public String getMarriageLawReligion() {
		return marriageLawReligion;
	}

	@XmlElement(name = "husbandTitle")
	public String getHusbandTitle() {
		return husbandTitle;
	}

	@XmlElement(name = "husbandLastName")
	public String getHusbandLastName() {
		return husbandLastName;
	}

	@XmlElement(name = "husbandFirstName")
	public String getHusbandFirstName() {
		return husbandFirstName;
	}

	@XmlElement(name = "husbandFatherName")
	public String getHusbandFatherName() {
		return husbandFatherName;
	}

	@XmlElement(name = "husbandAadhaarNo")
	public long getHusbandAadhaarNo() {
		return husbandAadhaarNo;
	}

	@XmlElement(name = "husbandAltName")
	public String getHusbandAltName() {
		return husbandAltName;
	}

	@XmlElement(name = "husbandBirthReligion")
	public String getHusbandBirthReligion() {
		return husbandBirthReligion;
	}

	@XmlElement(name = "husbandAdoptReligion")
	public String getHusbandAdoptReligion() {
		return husbandAdoptReligion;
	}

	@XmlElement(name = "husbandFullAddr")
	public String getHusbandFullAddr() {
		return husbandFullAddr;
	}

	@XmlElement(name = "husbandSolemAgeYear")
	public long getHusbandSolemAgeYear() {
		return husbandSolemAgeYear;
	}

	@XmlElement(name = "husbandSolemAgeMonth")
	public long getHusbandSolemAgeMonth() {
		return husbandSolemAgeMonth;
	}

	@XmlElement(name = "husbanndAgeProof")
	public String getHusbanndAgeProof() {
		return husbanndAgeProof;
	}

	@XmlElement(name = "husbandOccup")
	public String getHusbandOccup() {
		return husbandOccup;
	}

	@XmlElement(name = "husbandOccupOthers")
	public String getHusbandOccupOthers() {
		return husbandOccupOthers;
	}

	@XmlElement(name = "husbandOfficeAddr")
	public String getHusbandOfficeAddr() {
		return husbandOfficeAddr;
	}

	@XmlElement(name = "husbandStatus")
	public String getHusbandStatus() {
		return husbandStatus;
	}

	@XmlElement(name = "husbandWitnSignAndDate")
	public String getHusbandWitnSignAndDate() {
		return husbandWitnSignAndDate;
	}

	@XmlElement(name = "husbandPhotograph")
	public String getHusbandPhotograph() {
		return husbandPhotograph;
	}

	@XmlElement(name = "wifeTitle")
	public String getWifeTitle() {
		return wifeTitle;
	}

	@XmlElement(name = "wifeLastName")
	public String getWifeLastName() {
		return wifeLastName;
	}

	@XmlElement(name = "wifeFirstName")
	public String getWifeFirstName() {
		return wifeFirstName;
	}

	@XmlElement(name = "wifeFatherName")
	public String getWifeFatherName() {
		return wifeFatherName;
	}

	@XmlElement(name = "wifeAadhaarNo")
	public long getWifeAadhaarNo() {
		return wifeAadhaarNo;
	}

	@XmlElement(name = "wifealtName")
	public String getWifealtName() {
		return wifealtName;
	}

	@XmlElement(name = "wifeBirthReligion")
	public String getWifeBirthReligion() {
		return wifeBirthReligion;
	}

	@XmlElement(name = "wifeAdoptReligion")
	public String getWifeAdoptReligion() {
		return wifeAdoptReligion;
	}

	@XmlElement(name = "wifeFullAddress")
	public String getWifeFullAddress() {
		return wifeFullAddress;
	}

	@XmlElement(name = "wifeSolemAgeYear")
	public long getWifeSolemAgeYear() {
		return wifeSolemAgeYear;
	}

	@XmlElement(name = "wifeSolemAgeMonth")
	public long getWifeSolemAgeMonth() {
		return wifeSolemAgeMonth;
	}

	@XmlElement(name = "wifeAgeProof")
	public String getWifeAgeProof() {
		return wifeAgeProof;
	}

	@XmlElement(name = "wifeStatus")
	public String getWifeStatus() {
		return wifeStatus;
	}

	@XmlElement(name = "wifeWitnSignAndDate")
	public String getWifeWitnSignAndDate() {
		return wifeWitnSignAndDate;
	}

	@XmlElement(name = "wifePhotograph")
	public String getWifePhotograph() {
		return wifePhotograph;
	}

	@XmlElement(name = "firstWitnFullName")
	public String getFirstWitnFullName() {
		return firstWitnFullName;
	}

	@XmlElement(name = "firstWitnFullAddr")
	public String getFirstWitnFullAddr() {
		return firstWitnFullAddr;
	}

	@XmlElement(name = "firstWitnOccup")
	public String getFirstWitnOccup() {
		return firstWitnOccup;
	}

	@XmlElement(name = "firstWitnOfficeAddr")
	public String getFirstWitnOfficeAddr() {
		return firstWitnOfficeAddr;
	}

	@XmlElement(name = "firstWitnRelMarCouple")
	public String getFirstWitnRelMarCouple() {
		return firstWitnRelMarCouple;
	}

	@XmlElement(name = "firstWitnSignAndDate")
	public String getFirstWitnSignAndDate() {
		return firstWitnSignAndDate;
	}

	@XmlElement(name = "firstWitnPhotograph")
	public String getFirstWitnPhotograph() {
		return firstWitnPhotograph;
	}

	@XmlElement(name = "secondWitnFullName")
	public String getSecondWitnFullName() {
		return secondWitnFullName;
	}

	@XmlElement(name = "secondWitnFullAddr")
	public String getSecondWitnFullAddr() {
		return secondWitnFullAddr;
	}

	@XmlElement(name = "secondWitnOccup")
	public String getSecondWitnOccup() {
		return secondWitnOccup;
	}

	@XmlElement(name = "secondWitnOfficeAddr")
	public String getSecondWitnOfficeAddr() {
		return secondWitnOfficeAddr;
	}

	@XmlElement(name = "secondWitnRelMarCouple")
	public String getSecondWitnRelMarCouple() {
		return secondWitnRelMarCouple;
	}

	@XmlElement(name = "secondWitnSignAndDate")
	public String getSecondWitnSignAndDate() {
		return secondWitnSignAndDate;
	}

	@XmlElement(name = "secondWitnPhotograph")
	public String getSecondWitnPhotograph() {
		return secondWitnPhotograph;
	}

	@XmlElement(name = "thirdWitnFullName")
	public String getThirdWitnFullName() {
		return thirdWitnFullName;
	}

	@XmlElement(name = "thirdWitnFullAddr")
	public String getThirdWitnFullAddr() {
		return thirdWitnFullAddr;
	}

	@XmlElement(name = "thirdWitnOccup")
	public String getThirdWitnOccup() {
		return thirdWitnOccup;
	}

	@XmlElement(name = "zoneNo")
	public int getZoneNo() {
		return zoneNo;
	}

	@XmlElement(name = "priestFullAddr")
	public String getPriestFullAddr() {
		return priestFullAddr;
	}

	@XmlElement(name = "thirdWitnOfficeAddr")
	public String getThirdWitnOfficeAddr() {
		return thirdWitnOfficeAddr;
	}

	@XmlElement(name = "thirdWitnRelMarCouple")
	public String getThirdWitnRelMarCouple() {
		return thirdWitnRelMarCouple;
	}

	@XmlElement(name = "thirdWitnSignAndDate")
	public String getThirdWitnSignAndDate() {
		return thirdWitnSignAndDate;
	}

	@XmlElement(name = "thirdWitnPhotograph")
	public String getThirdWitnPhotograph() {
		return thirdWitnPhotograph;
	}

	@XmlElement(name = "priestName")
	public String getPriestName() {
		return priestName;
	}

	@XmlElement(name = "priestReligion")
	public String getPriestReligion() {
		return priestReligion;
	}

	@XmlElement(name = "priestAge")
	public String getPriestAge() {
		return priestAge;
	}

	@XmlElement(name = "priestSignAndDate")
	public String getPriestSignAndDate() {
		return priestSignAndDate;
	}

	@XmlElement(name = "daysCalculatedForCertificate")
	public String getDaysCalculatedForCertificate() {
		return daysCalculatedForCertificate;
	}

	@XmlElement(name = "feeApplicable")
	public double getFeeApplicable() {
		return feeApplicable;
	}

	@XmlElement(name = "firstOccupOthers")
	public String getFirstOccupOthers() {
		return firstOccupOthers;
	}

	@XmlElement(name = "firstRelationOthers")
	public String getFirstRelationOthers() {
		return firstRelationOthers;
	}

	@XmlElement(name = "secondOccupOthers")
	public String getSecondOccupOthers() {
		return secondOccupOthers;
	}

	@XmlElement(name = "secondRelationOthers")
	public String getSecondRelationOthers() {
		return secondRelationOthers;
	}

	@XmlElement(name = "thirdOccupOthers")
	public String getThirdOccupOthers() {
		return thirdOccupOthers;
	}

	@XmlElement(name = "thirdRelationOthers")
	public String getThirdRelationOthers() {
		return thirdRelationOthers;
	}

	public void setApplicantTitle(String applicantTitle) {
		this.applicantTitle = applicantTitle;
	}

	
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public void setApplicantFatherName(String applicantFatherName) {
		this.applicantFatherName = applicantFatherName;
	}

	public void setApplicantSurname(String applicantSurname) {
		this.applicantSurname = applicantSurname;
	}

	public void setApplicantFullName(String applicantFullName) {
		this.applicantFullName = applicantFullName;
	}

	public void setApplicantaadhaarNo(long applicantaadhaarNo) {
		this.applicantaadhaarNo = applicantaadhaarNo;
	}

	public void setApplicantemail(String applicantemail) {
		this.applicantemail = applicantemail;
	}

	public void setApplicantfullAddress(String applicantfullAddress) {
		this.applicantfullAddress = applicantfullAddress;
	}

	public void setMarriageDate(String marriageDate) {
		this.marriageDate = marriageDate;
	}

	public void setMarriagePlace(String marriagePlace) {
		this.marriagePlace = marriagePlace;
	}

	public void setMarriageLawReligion(String marriageLawReligion) {
		this.marriageLawReligion = marriageLawReligion;
	}

	public void setHusbandTitle(String husbandTitle) {
		this.husbandTitle = husbandTitle;
	}

	public void setHusbandLastName(String husbandLastName) {
		this.husbandLastName = husbandLastName;
	}

	public void setHusbandFirstName(String husbandFirstName) {
		this.husbandFirstName = husbandFirstName;
	}

	public void setHusbandFatherName(String husbandFatherName) {
		this.husbandFatherName = husbandFatherName;
	}

	public void setHusbandAadhaarNo(long husbandAadhaarNo) {
		this.husbandAadhaarNo = husbandAadhaarNo;
	}

	public void setHusbandAltName(String husbandAltName) {
		this.husbandAltName = husbandAltName;
	}

	public void setHusbandBirthReligion(String husbandBirthReligion) {
		this.husbandBirthReligion = husbandBirthReligion;
	}

	public void setHusbandAdoptReligion(String husbandAdoptReligion) {
		this.husbandAdoptReligion = husbandAdoptReligion;
	}

	public void setHusbandFullAddr(String husbandFullAddr) {
		this.husbandFullAddr = husbandFullAddr;
	}

	public void setHusbandSolemAgeYear(long husbandSolemAgeYear) {
		this.husbandSolemAgeYear = husbandSolemAgeYear;
	}

	public void setHusbandSolemAgeMonth(long husbandSolemAgeMonth) {
		this.husbandSolemAgeMonth = husbandSolemAgeMonth;
	}

	public void setHusbanndAgeProof(String husbanndAgeProof) {
		this.husbanndAgeProof = husbanndAgeProof;
	}

	public void setHusbandOccup(String husbandOccup) {
		this.husbandOccup = husbandOccup;
	}

	public void setHusbandOccupOthers(String husbandOccupOthers) {
		this.husbandOccupOthers = husbandOccupOthers;
	}

	public void setHusbandOfficeAddr(String husbandOfficeAddr) {
		this.husbandOfficeAddr = husbandOfficeAddr;
	}

	public void setHusbandStatus(String husbandStatus) {
		this.husbandStatus = husbandStatus;
	}

	public void setHusbandWitnSignAndDate(String husbandWitnSignAndDate) {
		this.husbandWitnSignAndDate = husbandWitnSignAndDate;
	}

	public void setHusbandPhotograph(String husbandPhotograph) {
		this.husbandPhotograph = husbandPhotograph;
	}

	public void setWifeTitle(String wifeTitle) {
		this.wifeTitle = wifeTitle;
	}

	public void setWifeLastName(String wifeLastName) {
		this.wifeLastName = wifeLastName;
	}

	public void setWifeFirstName(String wifeFirstName) {
		this.wifeFirstName = wifeFirstName;
	}

	public void setWifeFatherName(String wifeFatherName) {
		this.wifeFatherName = wifeFatherName;
	}

	public void setWifeAadhaarNo(long wifeAadhaarNo) {
		this.wifeAadhaarNo = wifeAadhaarNo;
	}

	public void setWifealtName(String wifealtName) {
		this.wifealtName = wifealtName;
	}

	public void setWifeBirthReligion(String wifeBirthReligion) {
		this.wifeBirthReligion = wifeBirthReligion;
	}

	public void setWifeAdoptReligion(String wifeAdoptReligion) {
		this.wifeAdoptReligion = wifeAdoptReligion;
	}

	public void setWifeFullAddress(String wifeFullAddress) {
		this.wifeFullAddress = wifeFullAddress;
	}

	public void setWifeSolemAgeYear(long wifeSolemAgeYear) {
		this.wifeSolemAgeYear = wifeSolemAgeYear;
	}

	public void setWifeSolemAgeMonth(long wifeSolemAgeMonth) {
		this.wifeSolemAgeMonth = wifeSolemAgeMonth;
	}

	public void setWifeAgeProof(String wifeAgeProof) {
		this.wifeAgeProof = wifeAgeProof;
	}

	public void setWifeStatus(String wifeStatus) {
		this.wifeStatus = wifeStatus;
	}

	public void setWifeWitnSignAndDate(String wifeWitnSignAndDate) {
		this.wifeWitnSignAndDate = wifeWitnSignAndDate;
	}

	public void setWifePhotograph(String wifePhotograph) {
		this.wifePhotograph = wifePhotograph;
	}

	public void setFirstWitnFullName(String firstWitnFullName) {
		this.firstWitnFullName = firstWitnFullName;
	}

	public void setFirstWitnFullAddr(String firstWitnFullAddr) {
		this.firstWitnFullAddr = firstWitnFullAddr;
	}

	public void setFirstWitnOccup(String firstWitnOccup) {
		this.firstWitnOccup = firstWitnOccup;
	}

	public void setFirstWitnOfficeAddr(String firstWitnOfficeAddr) {
		this.firstWitnOfficeAddr = firstWitnOfficeAddr;
	}

	public void setFirstWitnRelMarCouple(String firstWitnRelMarCouple) {
		this.firstWitnRelMarCouple = firstWitnRelMarCouple;
	}

	public void setFirstWitnSignAndDate(String firstWitnSignAndDate) {
		this.firstWitnSignAndDate = firstWitnSignAndDate;
	}

	public void setFirstWitnPhotograph(String firstWitnPhotograph) {
		this.firstWitnPhotograph = firstWitnPhotograph;
	}

	public void setSecondWitnFullName(String secondWitnFullName) {
		this.secondWitnFullName = secondWitnFullName;
	}

	public void setSecondWitnFullAddr(String secondWitnFullAddr) {
		this.secondWitnFullAddr = secondWitnFullAddr;
	}

	public void setSecondWitnOccup(String secondWitnOccup) {
		this.secondWitnOccup = secondWitnOccup;
	}

	public void setSecondWitnOfficeAddr(String secondWitnOfficeAddr) {
		this.secondWitnOfficeAddr = secondWitnOfficeAddr;
	}

	public void setSecondWitnRelMarCouple(String secondWitnRelMarCouple) {
		this.secondWitnRelMarCouple = secondWitnRelMarCouple;
	}

	public void setSecondWitnSignAndDate(String secondWitnSignAndDate) {
		this.secondWitnSignAndDate = secondWitnSignAndDate;
	}

	public void setSecondWitnPhotograph(String secondWitnPhotograph) {
		this.secondWitnPhotograph = secondWitnPhotograph;
	}

	public void setThirdWitnFullName(String thirdWitnFullName) {
		this.thirdWitnFullName = thirdWitnFullName;
	}

	public void setThirdWitnFullAddr(String thirdWitnFullAddr) {
		this.thirdWitnFullAddr = thirdWitnFullAddr;
	}

	public void setThirdWitnOccup(String thirdWitnOccup) {
		this.thirdWitnOccup = thirdWitnOccup;
	}

	public void setZoneNo(int zoneNo) {
		this.zoneNo = zoneNo;
	}

	public void setThirdWitnOfficeAddr(String thirdWitnOfficeAddr) {
		this.thirdWitnOfficeAddr = thirdWitnOfficeAddr;
	}

	public void setThirdWitnRelMarCouple(String thirdWitnRelMarCouple) {
		this.thirdWitnRelMarCouple = thirdWitnRelMarCouple;
	}

	public void setThirdWitnSignAndDate(String thirdWitnSignAndDate) {
		this.thirdWitnSignAndDate = thirdWitnSignAndDate;
	}

	public void setThirdWitnPhotograph(String thirdWitnPhotograph) {
		this.thirdWitnPhotograph = thirdWitnPhotograph;
	}

	public void setPriestName(String priestName) {
		this.priestName = priestName;
	}

	public void setPriestReligion(String priestReligion) {
		this.priestReligion = priestReligion;
	}

	public void setPriestAge(String priestAge) {
		this.priestAge = priestAge;
	}

	public void setPriestSignAndDate(String priestSignAndDate) {
		this.priestSignAndDate = priestSignAndDate;
	}

	public void setDaysCalculatedForCertificate(String daysCalculatedForCertificate) {
		this.daysCalculatedForCertificate = daysCalculatedForCertificate;
	}

	public void setFeeApplicable(double feeApplicable) {
		this.feeApplicable = feeApplicable;
	}

	public void setFirstOccupOthers(String firstOccupOthers) {
		this.firstOccupOthers = firstOccupOthers;
	}

	public void setFirstRelationOthers(String firstRelationOthers) {
		this.firstRelationOthers = firstRelationOthers;
	}

	public void setSecondOccupOthers(String secondOccupOthers) {
		this.secondOccupOthers = secondOccupOthers;
	}

	public void setSecondRelationOthers(String secondRelationOthers) {
		this.secondRelationOthers = secondRelationOthers;
	}

	public void setThirdOccupOthers(String thirdOccupOthers) {
		this.thirdOccupOthers = thirdOccupOthers;
	}

	public void setThirdRelationOthers(String thirdRelationOthers) {
		this.thirdRelationOthers = thirdRelationOthers;
	}

	public void setPriestFullAddr(String priestFullAddr) {
		this.priestFullAddr = priestFullAddr;
	}

	@XmlElement(name = "applicantmobileNumber")
	public long getApplicantmobileNumber() {
		return applicantmobileNumber;
	}

	public void setApplicantmobileNumber(long applicantmobileNumber) {
		this.applicantmobileNumber = applicantmobileNumber;
	}

	public void setApplicantpinCode(int applicantpinCode) {
		this.applicantpinCode = applicantpinCode;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public long getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(long responseCode) {
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

	@XmlElement(name = "marriageCard")
	public String getMarriageCard() {
		return marriageCard;
	}

	@XmlElement(name = "husbandDivorcedProof")
	public String getHusbandDivorcedProof() {
		return husbandDivorcedProof;
	}

	@XmlElement(name = "wifeDivorcedProof")
	public String getWifeDivorcedProof() {
		return wifeDivorcedProof;
	}

	@XmlElement(name = "propertyTaxPaid")
	public String getPropertyTaxPaid() {
		return propertyTaxPaid;
	}

	@XmlElement(name = "proofOfResidence")
	public String getProofOfResidence() {
		return proofOfResidence;
	}

	@XmlElement(name = "courtFeeStamps")
	public String getCourtFeeStamps() {
		return courtFeeStamps;
	}

	@XmlElement(name = "affidavit")
	public String getAffidavit() {
		return affidavit;
	}

	@XmlElement(name = "photoOfHusbandAndWife")
	public String getPhotoOfHusbandAndWife() {
		return photoOfHusbandAndWife;
	}

	@XmlElement(name = "deathCertificateOfSpouse")
	public String getDeathCertificateOfSpouse() {
		return deathCertificateOfSpouse;
	}

	public void setMarriageCard(String marriageCard) {
		this.marriageCard = marriageCard;
	}

	public void setHusbandDivorcedProof(String husbandDivorcedProof) {
		this.husbandDivorcedProof = husbandDivorcedProof;
	}

	public void setWifeDivorcedProof(String wifeDivorcedProof) {
		this.wifeDivorcedProof = wifeDivorcedProof;
	}

	public void setPropertyTaxPaid(String propertyTaxPaid) {
		this.propertyTaxPaid = propertyTaxPaid;
	}

	public void setProofOfResidence(String proofOfResidence) {
		this.proofOfResidence = proofOfResidence;
	}

	public void setCourtFeeStamps(String courtFeeStamps) {
		this.courtFeeStamps = courtFeeStamps;
	}

	public void setAffidavit(String affidavit) {
		this.affidavit = affidavit;
	}

	public void setPhotoOfHusbandAndWife(String photoOfHusbandAndWife) {
		this.photoOfHusbandAndWife = photoOfHusbandAndWife;
	}

	public void setDeathCertificateOfSpouse(String deathCertificateOfSpouse) {
		this.deathCertificateOfSpouse = deathCertificateOfSpouse;
	}
//new fields


	
	@XmlElement(name = "husbandOccupationOthers")
	public String getHusbandOccupationOthers() {
		return husbandOccupationOthers;
	}

	@XmlElement(name = "firstwitndate")
	public String getFirstwitndate() {
		return firstwitndate;
	}

	@XmlElement(name = "firstaadhaarno")
	public String getFirstaadhaarno() {
		return firstaadhaarno;
	}

	@XmlElement(name = "secondwitndate")
	public String getSecondwitndate() {
		return secondwitndate;
	}

	@XmlElement(name = "secondaadhaarno")
	public String getSecondaadhaarno() {
		return secondaadhaarno;
	}

	@XmlElement(name = "thirdwitndate")
	public String getThirdwitndate() {
		return thirdwitndate;
	}
	
	@XmlElement(name = "thirdaadhaarno")
	public String getThirdaadhaarno() {
		return thirdaadhaarno;
	}

	public void setHusbandOccupationOthers(String husbandOccupationOthers) {
		this.husbandOccupationOthers = husbandOccupationOthers;
	}

	public void setFirstwitndate(String firstwitndate) {
		this.firstwitndate = firstwitndate;
	}

	public void setFirstaadhaarno(String firstaadhaarno) {
		this.firstaadhaarno = firstaadhaarno;
	}

	public void setSecondwitndate(String secondwitndate) {
		this.secondwitndate = secondwitndate;
	}

	public void setSecondaadhaarno(String secondaadhaarno) {
		this.secondaadhaarno = secondaadhaarno;
	}

	public void setThirdwitndate(String thirdwitndate) {
		this.thirdwitndate = thirdwitndate;
	}

	public void setThirdaadhaarno(String thirdaadhaarno) {
		this.thirdaadhaarno = thirdaadhaarno;
	}
	
	
	
	
}