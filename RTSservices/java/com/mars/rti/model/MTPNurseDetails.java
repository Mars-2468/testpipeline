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
@Table(name = "mtp_nursedetails", schema = "egovrti")
public class MTPNurseDetails {
	
	@Id
	@Column(name = "mtp_details_id", nullable = false, unique = true)
	@SequenceGenerator(name = "mtp_nursedetails_seq", sequenceName = "mtp_nursedetails_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mtp_nursedetails_seq")
	private long mtpDetailsId;

	@Column(name = "nursesno", nullable = true )
	private String nursesno;

	@Column(name = "nursename", nullable = true )
	private String nursename;
	
	@Column(name = "nursefullparttime", nullable = true )
	private String nursefullparttime;

	@Column(name = "nurseexperience", nullable = true )
	private String nurseexperience;
	
	@Column(name = "diplomacerti", nullable = true )
	private String diplomaCerti;
	
	@Column(name = "validcerti", nullable = true )
	private String validCerti;
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "mtpid", nullable = false)
	private MTPRegistrationCertificate mTPRegistrationCertificate;

	
	
	public long getMtpDetailsId() {
		return mtpDetailsId;
	}

	public void setMtpDetailsId(long mtpDetailsId) {
		this.mtpDetailsId = mtpDetailsId;
	}

	public String getNursesno() {
		return nursesno;
	}

	public void setNursesno(String nursesno) {
		this.nursesno = nursesno;
	}

	public String getNursename() {
		return nursename;
	}

	public void setNursename(String nursename) {
		this.nursename = nursename;
	}

	public String getNursefullparttime() {
		return nursefullparttime;
	}

	public void setNursefullparttime(String nursefullparttime) {
		this.nursefullparttime = nursefullparttime;
	}

	public String getNurseexperience() {
		return nurseexperience;
	}

	public void setNurseexperience(String nurseexperience) {
		this.nurseexperience = nurseexperience;
	}

	public MTPRegistrationCertificate getmTPRegistrationCertificate() {
		return mTPRegistrationCertificate;
	}

	public void setmTPRegistrationCertificate(MTPRegistrationCertificate mTPRegistrationCertificate) {
		this.mTPRegistrationCertificate = mTPRegistrationCertificate;
	}

	public String getDiplomaCerti() {
		return diplomaCerti;
	}

	public void setDiplomaCerti(String diplomaCerti) {
		this.diplomaCerti = diplomaCerti;
	}

	public String getValidCerti() {
		return validCerti;
	}

	public void setValidCerti(String validCerti) {
		this.validCerti = validCerti;
	}

	
	
}
