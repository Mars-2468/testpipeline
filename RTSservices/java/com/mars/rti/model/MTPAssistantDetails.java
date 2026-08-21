
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
@Table(name = "mtp_assistant_details", schema = "egovrti")
public class MTPAssistantDetails {

	@Id
	@Column(name = "mtp_assistant_details_id", nullable = false, unique = true)
	@SequenceGenerator(name = "mtp_assistant_details_seq", sequenceName = "mtp_assistant_details_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mtp_assistant_details_seq")
	private long mtpAssistantDetailsId;
	

	@Column(name = "assistant_name", nullable = true )
	private String assistantName;
	
	@Column(name = "assistant_qualification", nullable = true )
	private String assistantQualification;
	
	@Column(name = "assistantfullparttime", nullable = true )
	private String assistantFullparttime;
	
	@Column(name = "assistantexperience", nullable = true )
	private String assistantExperience;
	
	@Column(name = "mbbscertificate", nullable = true )
	private String mbbsCertificate;
	

	@Column(name = "pgcertificate", nullable = true )
	private String pgCertificate;
	

	@Column(name = "mmccertificate", nullable = true )
	private String mmcCertificate;
	


	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "mtpid", nullable = false)

	private MTPRegistrationCertificate mTPRegistrationCertificate;


	public long getMtpAssistantDetailsId() {
		return mtpAssistantDetailsId;
	}


	public void setMtpAssistantDetailsId(long mtpAssistantDetailsId) {
		this.mtpAssistantDetailsId = mtpAssistantDetailsId;
	}


	public String getAssistantName() {
		return assistantName;
	}


	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}


	public String getAssistantQualification() {
		return assistantQualification;
	}


	public void setAssistantQualification(String assistantQualification) {
		this.assistantQualification = assistantQualification;
	}


	public String getAssistantFullparttime() {
		return assistantFullparttime;
	}


	public void setAssistantFullparttime(String assistantFullparttime) {
		this.assistantFullparttime = assistantFullparttime;
	}


	public String getAssistantExperience() {
		return assistantExperience;
	}


	public void setAssistantExperience(String assistantExperience) {
		this.assistantExperience = assistantExperience;
	}



	public MTPRegistrationCertificate getmTPRegistrationCertificate() {
		return mTPRegistrationCertificate;
	}


	public void setmTPRegistrationCertificate(MTPRegistrationCertificate mTPRegistrationCertificate) {
		this.mTPRegistrationCertificate = mTPRegistrationCertificate;
	}


	public String getMbbsCertificate() {
		return mbbsCertificate;
	}


	public void setMbbsCertificate(String mbbsCertificate) {
		this.mbbsCertificate = mbbsCertificate;
	}


	public String getPgCertificate() {
		return pgCertificate;
	}


	public void setPgCertificate(String pgCertificate) {
		this.pgCertificate = pgCertificate;
	}


	public String getMmcCertificate() {
		return mmcCertificate;
	}


	public void setMmcCertificate(String mmcCertificate) {
		this.mmcCertificate = mmcCertificate;
	}


}