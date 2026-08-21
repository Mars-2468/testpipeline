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
@Table(name = "mtpbloodbankdetails", schema = "egovrti")
public class MTPBloodBankDetails {
	
	@Id
	@Column(name = "mtp_details_id", nullable = false, unique = true)
	@SequenceGenerator(name = "mtpbloodbankdetails_seq", sequenceName = "mtpbloodbankdetails_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mtpbloodbankdetails_seq")
	private long mtpDetailsId;
	
	@Column(name = "bloodbanksr", nullable = true )
	private String bloodbankSr;

	@Column(name = "bloodbankname", nullable = true )
	private String bloodbankName;
	
	@Column(name = "bloodbregistrationnumber", nullable = true )
	private String bloodbregistrationNumber;
	
	@Column(name = "bloodbregistrationvalidity", nullable = true )
	private String bloodbregistrationValidity;
	
	@Column(name = "bloodbdistancefromapprovedplace", nullable = true )
	private String bloodbdistanceFromApprovedPlace;
	
	@Column(name = "bloodbmobilenum", nullable = true )
	private String bloodbmobilenum;

	@Column(name = "undertaking", nullable = true )
	private String undertaking;
	
	public long getMtpDetailsId() {
		return mtpDetailsId;
	}

	public void setMtpDetailsId(long mtpDetailsId) {
		this.mtpDetailsId = mtpDetailsId;
	}

	public String getBloodbankName() {
		return bloodbankName;
	}

	public void setBloodbankName(String bloodbankName) {
		this.bloodbankName = bloodbankName;
	}

	public String getBloodbregistrationNumber() {
		return bloodbregistrationNumber;
	}

	public void setBloodbregistrationNumber(String bloodbregistrationNumber) {
		this.bloodbregistrationNumber = bloodbregistrationNumber;
	}

	public String getBloodbregistrationValidity() {
		return bloodbregistrationValidity;
	}

	public void setBloodbregistrationValidity(String bloodbregistrationValidity) {
		this.bloodbregistrationValidity = bloodbregistrationValidity;
	}

	public String getBloodbdistanceFromApprovedPlace() {
		return bloodbdistanceFromApprovedPlace;
	}

	public void setBloodbdistanceFromApprovedPlace(String bloodbdistanceFromApprovedPlace) {
		this.bloodbdistanceFromApprovedPlace = bloodbdistanceFromApprovedPlace;
	}

	public String getBloodbmobilenum() {
		return bloodbmobilenum;
	}

	public void setBloodbmobilenum(String bloodbmobilenum) {
		this.bloodbmobilenum = bloodbmobilenum;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "mtpid", nullable = false)
	private MTPRegistrationCertificate mTPRegistrationCertificate;

	public MTPRegistrationCertificate getmTPRegistrationCertificate() {
		return mTPRegistrationCertificate;
	}

	public void setmTPRegistrationCertificate(MTPRegistrationCertificate mTPRegistrationCertificate) {
		this.mTPRegistrationCertificate = mTPRegistrationCertificate;
	}

	public String getBloodbankSr() {
		return bloodbankSr;
	}

	public void setBloodbankSr(String bloodbankSr) {
		this.bloodbankSr = bloodbankSr;
	}

	public String getUndertaking() {
		return undertaking;
	}

	public void setUndertaking(String undertaking) {
		this.undertaking = undertaking;
	}
	
	
	
}
