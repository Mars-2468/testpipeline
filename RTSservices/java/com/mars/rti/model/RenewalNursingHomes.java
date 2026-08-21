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
@Table(name = "renewal_nursinghomes_reg", schema = "egovrti")
public class RenewalNursingHomes {
	
	@Id
	@Column(name = "renewal_nursinghomes_reg_id", nullable = false, unique = true)
	@SequenceGenerator(name = "renewal_nursinghomes_reg__seq", sequenceName = "renewal_nursinghomes_reg__seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "renewal_nursinghomes_reg__seq")
	private long renewalNursingHomesregId;
	
	@Column(name = "full_name", nullable = true)
	private String fullname;

	@Column(name = "first_name", nullable = true)
	private String name;

	@Column(name = "middle_name", nullable = true)
	private String fathername;

	@Column(name = "last_name", nullable = true)
	private String surname;

	@Column(name = "plot", nullable = true)
	private String plot;

	@Column(name = "building", nullable = true)
	private String building;

	@Column(name = "street", nullable = true)
	private String street;

	@Column(name = "area", nullable = true)
	private String area;

	@Column(name = "pin", nullable = true)
	private String pin;

	@Column(name = "landmark", nullable = true)
	private String landmark;

	@Column(name = "glocation", nullable = true)
	private String glocation;

//	
//	@Column(name = "city", nullable = true )
//	private String city;
//	

	@Column(name = "phone", nullable = true)
	private String phone;

	@Column(name = "tech_qul", nullable = true)
	private String techqul;

	@Column(name = "nationality", nullable = true)
	private String nationality;

	@Column(name = "name_of_other", nullable = true)
	private String nameofother;

	@Column(name = "nursing_place", nullable = true)
	private String nursingplace;

	@Column(name = "brief_desc", nullable = true)
	private String briefdesc;

	@Column(name = "situation_of_rprinciple", nullable = true)
	private String situation;

	@Column(name = "floor_space", nullable = true)
	private String floorspace;

	@Column(name = "arrange_med_immu", nullable = true)
	private String arrangemedimmu;

	@Column(name = "floor_space_of_rooms", nullable = true)
	private String floorspaceofrooms;

	@Column(name = "conv_details_of_emp", nullable = true)
	private String convdetailsofemp;

	@Column(name = "details_storage_food", nullable = true)
	private String detailsstoragefood;

	@Column(name = "equipment", nullable = true)
	private String equipment;

	@Column(name = "carrying_nursing_home", nullable = true)
	private String carryingnursinghome;

	@Column(name = "nobed_mpatient", nullable = true)
	private String nobedmpatient;

	@Column(name = "nobed_opatient", nullable = true)
	private String nobedopatient;

	@Column(name = "pdetails_nuringemp", nullable = true)
	private String pdetailsnuringemp;

	@Column(name = "place_of_nstaff", nullable = true)
	private String placeofnstaff;

	@Column(name = "pdetails_nuringdoc", nullable = true)
	private String pdetailsnuringdoc;

	@Column(name = "qualification", nullable = true)
	private String qualification;

	@Column(name = "qualified_nurse", nullable = true)
	private String qualifiednurse;

	// new
	@Column(name = "unregmedunquilnursingstaff")
	private String unregmedunquilnursingstaff;

	// neww
	@Column(name = "qualified_nurse_burese_doc", nullable = true)
	private String qualifiedNuerseDoc;

	@Column(name = "qul_nurse_midwife", nullable = true)
	private String qulnursemidwife;

	@Column(name = "email", nullable = true)
	private String email;

	// new
	@Column(name = "qul_nurse_mid_wife_doc")
	private String qulnursemidwifedoc;

	@Column(name = "unregmed_unquil_nursing", nullable = true)
	private String unregmedunquilnursing;

	// neww
	@Column(name = "unregmedunquilnursingDoc")
	private String unregmedunquilnursingDoc;

	@Column(name = "alien_nationality", nullable = true)
	private String aliennationality;

	@Column(name = "fee_charged", nullable = true )
	private String fee_charged;

	@Column(name = "applicant_intereste", nullable = true)
	private String applicantintereste;

	@Column(name = "no_and_expdate", nullable = true)
	private String noandexpdate;

	@Column(name = "rti_appl_ref_no", nullable = true)
	private String rtiapplrefno;

	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;

	@Column(name = "applicant_name", nullable = true)
	private String applicantName;

	@Column(name = "name_and_others", nullable = true)
	private String name_and_otherParticulars;

	@Column(name = "nursinghome_place", nullable = true)
	private String nursinghomePlace;

	@Column(name = "total_patients", nullable = true)
	private String totalPatients;

	@Column(name = "maternity_patients", nullable = true)
	private String maternityPatients;

	@Column(name = "other_patients", nullable = true)
	private String otherPatients;

	@Column(name = "registration_date", nullable = true)
	private String registrationDate;

	@Column(name = "renewal_date", nullable = true)
	private String renewalDate;

	// new one

	@Column(name = "applicant_address", nullable = true)
	private String applicantAddress;

	@Column(name = "title", nullable = true)
	private String title;

	@Column(name = "applicant_name1", nullable = true)
	private String fullname1;

	@Column(name = "applicant_address2", nullable = true)
	private String applicantAddress1;

	@Column(name = "nationality1", nullable = true)
	private String nationality1;


	@Column(name = "outward_no", nullable = true)
	private String outwardNo;

//ExtraFIeds Required
	@Column(name = "zone_no")
	private String zoneNo;

	@Transient
	private String filesPath;

	
	@Column(name = "renewal_from_date")
	private String renewal_from_date;
	
	@Column(name = "renewal_to_date")
	private String renewal_to_date;
	
	@Column(name = "hq_doc")
	private String hqdoc;
	
	@Column(name = "zmo_doc")
	private String zmodoc;
	
	@Column(name="fees")
	private double fees;

	public long getRenewalNursingHomesregId() {
		return renewalNursingHomesregId;
	}

	public void setRenewalNursingHomesregId(long renewalNursingHomesregId) {
		this.renewalNursingHomesregId = renewalNursingHomesregId;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getGlocation() {
		return glocation;
	}

	public void setGlocation(String glocation) {
		this.glocation = glocation;
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

	public String getPdetailsnuringdoc() {
		return pdetailsnuringdoc;
	}

	public void setPdetailsnuringdoc(String pdetailsnuringdoc) {
		this.pdetailsnuringdoc = pdetailsnuringdoc;
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

	public String getQualifiedNuerseDoc() {
		return qualifiedNuerseDoc;
	}

	public void setQualifiedNuerseDoc(String qualifiedNuerseDoc) {
		this.qualifiedNuerseDoc = qualifiedNuerseDoc;
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

	public String getQulnursemidwifedoc() {
		return qulnursemidwifedoc;
	}

	public void setQulnursemidwifedoc(String qulnursemidwifedoc) {
		this.qulnursemidwifedoc = qulnursemidwifedoc;
	}

	public String getUnregmedunquilnursing() {
		return unregmedunquilnursing;
	}

	public void setUnregmedunquilnursing(String unregmedunquilnursing) {
		this.unregmedunquilnursing = unregmedunquilnursing;
	}

	public String getUnregmedunquilnursingDoc() {
		return unregmedunquilnursingDoc;
	}

	public void setUnregmedunquilnursingDoc(String unregmedunquilnursingDoc) {
		this.unregmedunquilnursingDoc = unregmedunquilnursingDoc;
	}

	public String getAliennationality() {
		return aliennationality;
	}

	public void setAliennationality(String aliennationality) {
		this.aliennationality = aliennationality;
	}



	public String getFee_charged() {
		return fee_charged;
	}

	public void setFee_charged(String fee_charged) {
		this.fee_charged = fee_charged;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFullname1() {
		return fullname1;
	}

	public void setFullname1(String fullname1) {
		this.fullname1 = fullname1;
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

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	
	public String getRenewal_from_date() {
		return renewal_from_date;
	}

	public void setRenewal_from_date(String renewal_from_date) {
		this.renewal_from_date = renewal_from_date;
	}

	public String getRenewal_to_date() {
		return renewal_to_date;
	}

	public void setRenewal_to_date(String renewal_to_date) {
		this.renewal_to_date = renewal_to_date;
	}

	public String getHqdoc() {
		return hqdoc;
	}

	public void setHqdoc(String hqdoc) {
		this.hqdoc = hqdoc;
	}

	public String getZmodoc() {
		return zmodoc;
	}

	public void setZmodoc(String zmodoc) {
		this.zmodoc = zmodoc;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
	
	
	
	
}