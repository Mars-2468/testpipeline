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
@Table(name="nurse_details",schema="egovrti")
public class NurseDetails {

	
	@Id
	@SequenceGenerator(name="nurse_details_seq",sequenceName = "nurse_details_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "nurse_details_seq")
	@Column(name="nurse_details_id")
	private long nurseDetailsId;
	
	@Column(name="nurse_name")
	private String nurseName;
	
	@Column(name="nurse_age")
	private String nurseAge;

	@Column(name="nurse_education")
	private String nurseEducation;

	@Column(name="nurse_reg_no")
	private String nurseRegNo;
	
	@ManyToOne
	@JoinColumn(name="nursinghomes_new_reg_id")		
	private NursingHomes nursingHomes;

	public long getNurseDetailsId() {
		return nurseDetailsId;
	}

	public void setNurseDetailsId(long nurseDetailsId) {
		this.nurseDetailsId = nurseDetailsId;
	}

	public String getNurseName() {
		return nurseName;
	}

	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}

	public String getNurseAge() {
		return nurseAge;
	}

	public void setNurseAge(String nurseAge) {
		this.nurseAge = nurseAge;
	}

	public String getNurseEducation() {
		return nurseEducation;
	}

	public void setNurseEducation(String nurseEducation) {
		this.nurseEducation = nurseEducation;
	}

	public String getNurseRegNo() {
		return nurseRegNo;
	}

	public void setNurseRegNo(String nurseRegNo) {
		this.nurseRegNo = nurseRegNo;
	}

	public NursingHomes getNursingHomes() {
		return nursingHomes;
	}

	public void setNursingHomes(NursingHomes nursingHomes) {
		this.nursingHomes = nursingHomes;
	}
	
	
	
}
