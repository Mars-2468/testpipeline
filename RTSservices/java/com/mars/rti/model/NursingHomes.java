package com.mars.rti.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "nursinghomes_reg_new", schema = "egovrti")
public class NursingHomes {
	@Id
	@Column(name = "nursinghomes_new_reg_id", nullable = false, unique = true)
	@SequenceGenerator(name = "nursinghomes_reg__seq", sequenceName = "nursinghomes_reg__seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nursinghomes_reg__seq")
	private long nursinghomesregId;
	
	@Column(name = "registrationdate")
    private String registrationDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "applicantaddress")
    private String applicantAddress;

    @Column(name = "techqul")
    private String techQul;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "situationof")
    private String situationOf;

    @Column(name = "nameregnursinghome")
    private String nameRegNursingHome;

    @Column(name = "placeofnstaff")
    private String placeOfNStaff;

    @Column(name = "autocad")
    private String autoCad;

    @Column(name = "connnectionofpremises")
    private String connectionOfPremises;

    @Column(name = "maternitypatients")
    private String maternityPatients;

    @Column(name = "nobedopatient")
    private String noBedOPatient;

    @Column(name = "nursingstaffaccomdated")
    private String nursingStaffAccommodated;

    @Column(name = "qualifiednurse")
    private String qualifiedNurse;

    @Column(name = "unregmedunquilnursingstaff")
    private String unregMedUnquilNursingStaff;

    @Column(name = "qulnursemidwife")
    private String qulnurseMidwife;

    @Column(name = "unregmedunquilnursing")
    private String unregMedUnquilNursing;

    @Column(name = "aliennationality")
    private String alienNationality;

    @Column(name = "applicantintereste")
    private String applicantInterestE;

    @Column(name = "zoneno")
    private String zoneNo;

    @Column(name = "rti_appl_ref_no")
    private String rtiApplRefNo;

    @Column(name = "rti_ref_id")
    private long rtiRefId;
    
    @Column(name="fees")
    private double fees;

	@Column(name = "hq_doc")
	private String hqdoc;
	
	@Column(name = "zmo_doc")
	private String zmodoc;

	@Transient
	private String filesPath;
	
	@Column(name="certificate_issued_date")
	private String certificateIssuedDate;
	
	//OneToMapping 
	
	@OneToMany(mappedBy = "nursingHomes")
   private List<NurseDetails> nd = new ArrayList<NurseDetails>();
	
	
	@OneToMany(mappedBy = "nursingHomes")
   private List<SurgeonsDetails> sd = new ArrayList<SurgeonsDetails>();
	
	@Column(name="renewal_date")
	private String renewalDate;

	@Column(name="renewal_status")
	private int renewalStatus;

	@Column(name="existing_ursing_home_id")
	private String renewalNursingHome;
	
	@Column(name="unregistered_medical_practitionar")
	private String unregisteredMedicalPractitionar;
	
	@Column(name="mho_remark")
	private String mhoRemark;
	
	@Column(name="hq_remark")
	private String hQRemark;
	
	public long getNursinghomesregId() {
		return nursinghomesregId;
	}


	public void setNursinghomesregId(long nursinghomesregId) {
		this.nursinghomesregId = nursinghomesregId;
	}


	public String getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getApplicantAddress() {
		return applicantAddress;
	}


	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}


	public String getTechQul() {
		return techQul;
	}


	public void setTechQul(String techQul) {
		this.techQul = techQul;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getSituationOf() {
		return situationOf;
	}


	public void setSituationOf(String situationOf) {
		this.situationOf = situationOf;
	}


	public String getNameRegNursingHome() {
		return nameRegNursingHome;
	}


	public void setNameRegNursingHome(String nameRegNursingHome) {
		this.nameRegNursingHome = nameRegNursingHome;
	}


	public String getPlaceOfNStaff() {
		return placeOfNStaff;
	}


	public void setPlaceOfNStaff(String placeOfNStaff) {
		this.placeOfNStaff = placeOfNStaff;
	}


	public String getAutoCad() {
		return autoCad;
	}


	public void setAutoCad(String autoCad) {
		this.autoCad = autoCad;
	}


	public String getConnectionOfPremises() {
		return connectionOfPremises;
	}


	public void setConnectionOfPremises(String connectionOfPremises) {
		this.connectionOfPremises = connectionOfPremises;
	}


	public String getMaternityPatients() {
		return maternityPatients;
	}


	public void setMaternityPatients(String maternityPatients) {
		this.maternityPatients = maternityPatients;
	}


	public String getNoBedOPatient() {
		return noBedOPatient;
	}


	public void setNoBedOPatient(String noBedOPatient) {
		this.noBedOPatient = noBedOPatient;
	}


	public String getNursingStaffAccommodated() {
		return nursingStaffAccommodated;
	}


	public void setNursingStaffAccommodated(String nursingStaffAccommodated) {
		this.nursingStaffAccommodated = nursingStaffAccommodated;
	}


	public String getQualifiedNurse() {
		return qualifiedNurse;
	}


	public void setQualifiedNurse(String qualifiedNurse) {
		this.qualifiedNurse = qualifiedNurse;
	}


	public String getUnregMedUnquilNursingStaff() {
		return unregMedUnquilNursingStaff;
	}


	public void setUnregMedUnquilNursingStaff(String unregMedUnquilNursingStaff) {
		this.unregMedUnquilNursingStaff = unregMedUnquilNursingStaff;
	}


	public String getQulnurseMidwife() {
		return qulnurseMidwife;
	}


	public void setQulnurseMidwife(String qulnurseMidwife) {
		this.qulnurseMidwife = qulnurseMidwife;
	}


	public String getUnregMedUnquilNursing() {
		return unregMedUnquilNursing;
	}


	public void setUnregMedUnquilNursing(String unregMedUnquilNursing) {
		this.unregMedUnquilNursing = unregMedUnquilNursing;
	}


	public String getAlienNationality() {
		return alienNationality;
	}


	public void setAlienNationality(String alienNationality) {
		this.alienNationality = alienNationality;
	}


	public String getApplicantInterestE() {
		return applicantInterestE;
	}


	public void setApplicantInterestE(String applicantInterestE) {
		this.applicantInterestE = applicantInterestE;
	}


	public String getZoneNo() {
		return zoneNo;
	}


	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}


	public String getRtiApplRefNo() {
		return rtiApplRefNo;
	}


	public void setRtiApplRefNo(String rtiApplRefNo) {
		this.rtiApplRefNo = rtiApplRefNo;
	}


	public long getRtiRefId() {
		return rtiRefId;
	}


	public void setRtiRefId(long rtiRefId) {
		this.rtiRefId = rtiRefId;
	}


	public double getFees() {
		return fees;
	}


	public void setFees(double fees) {
		this.fees = fees;
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


	public String getFilesPath() {
		return filesPath;
	}


	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}


	public List<NurseDetails> getNd() {
		return nd;
	}


	public void setNd(List<NurseDetails> nd) {
		this.nd = nd;
	}


	public List<SurgeonsDetails> getSd() {
		return sd;
	}


	public void setSd(List<SurgeonsDetails> sd) {
		this.sd = sd;
	}


	public String getCertificateIssuedDate() {
		return certificateIssuedDate;
	}


	public void setCertificateIssuedDate(String certificateIssuedDate) {
		this.certificateIssuedDate = certificateIssuedDate;
	}


	public String getRenewalNursingHome() {
		return renewalNursingHome;
	}


	public void setRenewalNursingHome(String renewalNursingHome) {
		this.renewalNursingHome = renewalNursingHome;
	}


	public String getRenewalDate() {
		return renewalDate;
	}


	public void setRenewalDate(String renewalDate) {
		this.renewalDate = renewalDate;
	}


	public String getUnregisteredMedicalPractitionar() {
		return unregisteredMedicalPractitionar;
	}


	public void setUnregisteredMedicalPractitionar(String unregisteredMedicalPractitionar) {
		this.unregisteredMedicalPractitionar = unregisteredMedicalPractitionar;
	}


	public int getRenewalStatus() {
		return renewalStatus;
	}


	public void setRenewalStatus(int renewalStatus) {
		this.renewalStatus = renewalStatus;
	}


	public String getMhoRemark() {
		return mhoRemark;
	}


	public void setMhoRemark(String mhoRemark) {
		this.mhoRemark = mhoRemark;
	}


	public String gethQRemark() {
		return hQRemark;
	}


	public void sethQRemark(String hQRemark) {
		this.hQRemark = hQRemark;
	}
	

	
	
	
	
}
    
    