package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="surgeon_details",schema="egovrti")
public class SurgeonsDetails {

	@Id
	@SequenceGenerator(name="surgeon_details_seq",sequenceName = "surgeon_details_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "surgeon_details_seq")
	@Column(name="surgeon_details_id")
	private long surgeonDeatilsId;
	
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="doctor_age")
	private String doctorAge;

	@Column(name="doctor_education")
	private String doctorEducation;

	@Column(name="doctor_reg_no")
	private String doctorRegNo;
	
	
	@ManyToOne
	@JoinColumn(name="nursinghomes_new_reg_id")
	private NursingHomes nursingHomes;


	public long getSurgeonDeatilsId() {
		return surgeonDeatilsId;
	}


	public void setSurgeonDeatilsId(long surgeonDeatilsId) {
		this.surgeonDeatilsId = surgeonDeatilsId;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public String getDoctorAge() {
		return doctorAge;
	}


	public void setDoctorAge(String doctorAge) {
		this.doctorAge = doctorAge;
	}


	


	public String getDoctorEducation() {
		return doctorEducation;
	}


	public void setDoctorEducation(String doctorEducation) {
		this.doctorEducation = doctorEducation;
	}


	public String getDoctorRegNo() {
		return doctorRegNo;
	}


	public void setDoctorRegNo(String doctorRegNo) {
		this.doctorRegNo = doctorRegNo;
	}


	public NursingHomes getNursingHomes() {
		return nursingHomes;
	}


	public void setNursingHomes(NursingHomes nursingHomes) {
		this.nursingHomes = nursingHomes;
	}


	
	
	
	
	
}
