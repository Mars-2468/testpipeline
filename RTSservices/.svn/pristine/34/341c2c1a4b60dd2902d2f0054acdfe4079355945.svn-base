package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nmc_user", schema = "egovcommon")
public class UserRegistrationDetails {

	/*
	 * @Id
	 * 
	 * @Column(name="user_id", nullable=false ,unique=true)
	 * 
	 * @SequenceGenerator(name="egovcommon.user_seq",
	 * sequenceName="egovcommon.user_seq")
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE
	 * ,generator="egovcommon.user_seq")
	 * 
	 * @RemoteProperty private long userId;
	 */
	@Id
	@Column(name = "user_mobile_no",unique = true, nullable = false)
	private String mobileNo;
	
	@Column(name = "user_email",unique = true, nullable = false)
	private String email;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	

	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "last_login")
	private String lastLogin;

	
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

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	/*
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "created_at", updatable=false) private Date createDate;
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "updated_at", updatable=true) private Date modifyDate;
	 */
	
	
	
}
