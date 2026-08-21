package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "mtp_details", schema = "egovrti")
public class MTPDetails {
	@Id
	@Column(name = "mtp_details_id", nullable = false, unique = true)
	@SequenceGenerator(name = "mtp_details_ser_seq", sequenceName = "mtp_details_ser_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mtp_details_ser_seq")
	private long mtpDetailsId;
	

	@Column(name = "medical_practitoner_seq", nullable = true )
	private String medical_practitoner_seq;
	
	@Column(name = "medical_practitoner_name", nullable = true )
	private String medical_practitoner_name;
	
	@Column(name = "medical_practitoner_qualification", nullable = true )
	private String medical_practitoner_qualification;
	
	@Column(name = "medical_practitoner_fullparttime", nullable = true )
	private String medical_practitoner_fullparttime;
	

	@Column(name = "medical_practitoner_experience", nullable = true )
	private String medical_practitoner_experience;
	

	@Column(name = "mbbs", nullable = true )
	private String mbbs;
	

	@Column(name = "pg", nullable = true )
	private String pg;
	
	@Column(name = "mmc", nullable = true )
	private String mmc;
	
	@Column(name = "marriagecertificate", nullable = true )
 	private String marriageCertificate;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "mtpid", nullable = false)
	private MTPRegistrationCertificate mTPRegistrationCertificate;

	public long getMtpDetailsId() {
		return mtpDetailsId;
	}

	public void setMtpDetailsId(long mtpDetailsId) {
		this.mtpDetailsId = mtpDetailsId;
	}

	public String getMedical_practitoner_seq() {
		return medical_practitoner_seq;
	}

	public void setMedical_practitoner_seq(String medical_practitoner_seq) {
		this.medical_practitoner_seq = medical_practitoner_seq;
	}

	public String getMedical_practitoner_name() {
		return medical_practitoner_name;
	}

	public void setMedical_practitoner_name(String medical_practitoner_name) {
		this.medical_practitoner_name = medical_practitoner_name;
	}

	public String getMedical_practitoner_qualification() {
		return medical_practitoner_qualification;
	}

	public void setMedical_practitoner_qualification(String medical_practitoner_qualification) {
		this.medical_practitoner_qualification = medical_practitoner_qualification;
	}

	public String getMedical_practitoner_fullparttime() {
		return medical_practitoner_fullparttime;
	}

	public void setMedical_practitoner_fullparttime(String medical_practitoner_fullparttime) {
		this.medical_practitoner_fullparttime = medical_practitoner_fullparttime;
	}

	public String getMedical_practitoner_experience() {
		return medical_practitoner_experience;
	}

	public void setMedical_practitoner_experience(String medical_practitoner_experience) {
		this.medical_practitoner_experience = medical_practitoner_experience;
	}



	public MTPRegistrationCertificate getmTPRegistrationCertificate() {
		return mTPRegistrationCertificate;
	}

	public void setmTPRegistrationCertificate(MTPRegistrationCertificate mTPRegistrationCertificate) {
		this.mTPRegistrationCertificate = mTPRegistrationCertificate;
	}

	 @Column(name = "rti_ref_id", nullable = true )
	  private long rti_ref_id;

	public long getRti_ref_id() {
		return rti_ref_id;
	}

	public void setRti_ref_id(long rti_ref_id) {
		this.rti_ref_id = rti_ref_id;
	}

	public String getMbbs() {
		return mbbs;
	}

	public void setMbbs(String mbbs) {
		this.mbbs = mbbs;
	}

	public String getPg() {
		return pg;
	}

	public void setPg(String pg) {
		this.pg = pg;
	}

	public String getMmc() {
		return mmc;
	}

	public void setMmc(String mmc) {
		this.mmc = mmc;
	}

	public String getMarriageCertificate() {
		return marriageCertificate;
	}

	public void setMarriageCertificate(String marriageCertificate) {
		this.marriageCertificate = marriageCertificate;
	}
	 
	 
	 
	 
	

	
}
