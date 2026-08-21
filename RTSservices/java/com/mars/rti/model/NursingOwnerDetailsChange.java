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
@Table(name="nursing_owner_details_change" ,schema="egovrti")
public class NursingOwnerDetailsChange {

	@Id
	@Column(name = "nbc_id", nullable = false, unique = true)
	@SequenceGenerator(name = "nbc_id_seq", sequenceName = "nbc_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nbc_id_seq")
	private long nursingNursingOwnerDetailsChangeId;
	
	@Column(name="change_owner_name")
	private String changeOwnerName;
	
	@Column(name="change_owner_address")
	private String changeAddress;
	
	@Column(name="change_owner_mobile_no")
	private String changeMobileNo;
	
	@ManyToOne
	@JoinColumn(name="nhca_id")
	private NursingHomeChangesApplication nursingHomeChangesApplication;

	@Column(name="change_email")
	private String changeEmail;
	
	public long getNursingNursingOwnerDetailsChangeId() {
		return nursingNursingOwnerDetailsChangeId;
	}

	public void setNursingNursingOwnerDetailsChangeId(long nursingNursingOwnerDetailsChangeId) {
		this.nursingNursingOwnerDetailsChangeId = nursingNursingOwnerDetailsChangeId;
	}

	public String getChangeOwnerName() {
		return changeOwnerName;
	}

	public void setChangeOwnerName(String changeOwnerName) {
		this.changeOwnerName = changeOwnerName;
	}

	public String getChangeAddress() {
		return changeAddress;
	}

	public void setChangeAddress(String changeAddress) {
		this.changeAddress = changeAddress;
	}

	public String getChangeMobileNo() {
		return changeMobileNo;
	}

	public void setChangeMobileNo(String changeMobileNo) {
		this.changeMobileNo = changeMobileNo;
	}

	public NursingHomeChangesApplication getNursingHomeChangesApplication() {
		return nursingHomeChangesApplication;
	}

	public void setNursingHomeChangesApplication(NursingHomeChangesApplication nursingHomeChangesApplication) {
		this.nursingHomeChangesApplication = nursingHomeChangesApplication;
	}

	public String getChangeEmail() {
		return changeEmail;
	}

	public void setChangeEmail(String changeEmail) {
		this.changeEmail = changeEmail;
	}

	

	
	
}
