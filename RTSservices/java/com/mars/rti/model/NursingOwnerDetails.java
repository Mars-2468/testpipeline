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
@Table(name="nursing_owner_details" ,schema="egovrti")
public class NursingOwnerDetails {

	@Id
	@Column(name = "nbc_id", nullable = false, unique = true)
	@SequenceGenerator(name = "nbcs_id_seq", sequenceName = "nbcs_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nbcs_id_seq")
	private long nursingOwnerDetailsId;
	
	@Column(name="owner_name")
	private String additionOwnerName;
	
	@Column(name="owner_address")
	private String additionAddress;
	
	@Column(name="owner_mobile_no")
	private String additionMobileNo;
	
	@ManyToOne
	@JoinColumn(name="nhca_id")
	private NursingHomeChangesApplication nursingHomeChangesApplication;

	@Column(name="email")
	private String email;
	

	public long getNursingOwnerDetailsId() {
		return nursingOwnerDetailsId;
	}

	public void setNursingOwnerDetailsId(long nursingOwnerDetailsId) {
		this.nursingOwnerDetailsId = nursingOwnerDetailsId;
	}

	public String getAdditionOwnerName() {
		return additionOwnerName;
	}

	public void setAdditionOwnerName(String additionOwnerName) {
		this.additionOwnerName = additionOwnerName;
	}

	public String getAdditionAddress() {
		return additionAddress;
	}

	public void setAdditionAddress(String additionAddress) {
		this.additionAddress = additionAddress;
	}

	public String getAdditionMobileNo() {
		return additionMobileNo;
	}

	public void setAdditionMobileNo(String additionMobileNo) {
		this.additionMobileNo = additionMobileNo;
	}

	public NursingHomeChangesApplication getNursingHomeChangesApplication() {
		return nursingHomeChangesApplication;
	}

	public void setNursingHomeChangesApplication(NursingHomeChangesApplication nursingHomeChangesApplication) {
		this.nursingHomeChangesApplication = nursingHomeChangesApplication;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
