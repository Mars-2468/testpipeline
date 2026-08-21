package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "nmc_user1", schema = "egovcommon")
public class UserRegistrationDetails1 {
	
	@Id
	@Column(name = "user_id", nullable = false, unique = true)
	@SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
	private long userId;

	
	@Column(name = "user_email",unique = true, nullable = false)
	private String email;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "user_mobile_no",unique = true, nullable = false)
	private String mobileNo;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "last_login")
	private String lastLogin;

	public long getUserId() {
		return userId;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
}
