package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Entity;


@Entity
@Table(name = "anaesthetistdetails", schema = "egovrti")
public class AnaesthetistDetails {
	
	@Id
	@Column(name = "mtp_details_id", nullable = false, unique = true)
	@SequenceGenerator(name = "anaesthetistdetails_seq", sequenceName = "anaesthetistdetails_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "anaesthetistdetails_seq")
	private long mtpDetailsId;
	

	@Column(name = "anaesthistsrno", nullable = true )
	private String anaesthistSrNo;

	@Column(name = "ancName", nullable = true )
	private String ancName;
	
	@Column(name = "anesthetistmbbs", nullable = true )
	private String anesthetistMbbs;
	
	@Column(name = "anesthetistpg", nullable = true )
	private String anesthetistPG;
	
	@Column(name = "anesthetistmmc", nullable = true )
	private String anesthetistMMC;
	
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "mtpid", nullable = false)
	private MTPRegistrationCertificate mTPRegistrationCertificate;


	public long getMtpDetailsId() {
		return mtpDetailsId;
	}


	public void setMtpDetailsId(long mtpDetailsId) {
		this.mtpDetailsId = mtpDetailsId;
	}


	public String getAnaesthistSrNo() {
		return anaesthistSrNo;
	}


	public void setAnaesthistSrNo(String anaesthistSrNo) {
		this.anaesthistSrNo = anaesthistSrNo;
	}


	public String getAncName() {
		return ancName;
	}


	public void setAncName(String ancName) {
		this.ancName = ancName;
	}


	public MTPRegistrationCertificate getmTPRegistrationCertificate() {
		return mTPRegistrationCertificate;
	}


	public void setmTPRegistrationCertificate(MTPRegistrationCertificate mTPRegistrationCertificate) {
		this.mTPRegistrationCertificate = mTPRegistrationCertificate;
	}


	public String getAnesthetistMbbs() {
		return anesthetistMbbs;
	}


	public void setAnesthetistMbbs(String anesthetistMbbs) {
		this.anesthetistMbbs = anesthetistMbbs;
	}


	public String getAnesthetistPG() {
		return anesthetistPG;
	}


	public void setAnesthetistPG(String anesthetistPG) {
		this.anesthetistPG = anesthetistPG;
	}


	public String getAnesthetistMMC() {
		return anesthetistMMC;
	}


	public void setAnesthetistMMC(String anesthetistMMC) {
		this.anesthetistMMC = anesthetistMMC;
	}
	
	

}
