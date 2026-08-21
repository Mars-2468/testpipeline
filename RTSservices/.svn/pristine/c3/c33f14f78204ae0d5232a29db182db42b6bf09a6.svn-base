package com.mars.common.model;

/**
 * <p>Title: User.java </p>

 * <p>Description: Model class for User</p>

 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * @author : Mars Telecom Systems Pvt Ltd
 * 
 */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name = "users", schema = "egovcommon")
@DataTransferObject(type = "hibernate3")
@FilterDef(name = "tenancyFilter", parameters = { @ParamDef(name = "tenancyId", type = "integer") })
@Filters({ @Filter(name = "tenancyFilter", condition = "tenancyid = :tenancyId") })

public class User implements java.io.Serializable {
	@Id
	@Column(name = "user_id", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.user_seq", sequenceName = "egovcommon.user_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.user_seq")
	@RemoteProperty
	private long userId;

	@Column(name = "user_name", unique = true, nullable = false)
	@RemoteProperty
	private String userName;

	@Column(name = "password", unique = true, nullable = false)
	private String password;

	@Column(name = "first_name", unique = true, nullable = false)
	@RemoteProperty
	private String firstName;

	@Column(name = "middle_name", unique = true, nullable = true)
	private String middleName;

	@Column(name = "email", unique = true, nullable = false)
	private String email = "";

	@Column(name = "last_name", unique = true, nullable = true)
	@RemoteProperty
	private String lastName;

	@Column(name = "employee_id", unique = true, nullable = false)
	private Long employeeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = true)
	private Department department = new Department();

	
	  @ManyToOne(fetch=FetchType.LAZY)
	  
	  @JoinColumn(name = "designation_id", nullable = true) private Designation
	  designation = null;
	 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenancyid", nullable = true)
	private Tenancy tenancy = null;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<UserApplication> userApplicationSet = new HashSet<UserApplication>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@OrderBy(value = "userRoleId")
	private Set<UserRole> userRoleSet = new HashSet<UserRole>();

	@Transient
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserApplicationSettings userApplicationSettings = null;

	@Column(name = "status", nullable = false)
	private int status;

	@Column(name = "user_zone", nullable = true)
	private String zone;

	@Column(name = "mobile_number", nullable = true)
	private String mobileNumber;

	@ManyToOne
	@JoinColumn(name = "section_id", nullable = true)
	private Section section = null;

	// new Column

	@Column(name = "user_level")
	private String userLevel;

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the designation
	 */
	
	  public Designation getDesignation() { return designation; }
	  
	 /**
		 * @param designation the designation to set
		 */
			  public void setDesignation(Designation designation) { this.designation =
			  designation; }
			 

	public Tenancy getTenancy() {
		return tenancy;
	}

	public void setTenancy(Tenancy tenancy) {
		this.tenancy = tenancy;
	}

	public User() {
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public User(String userName, String password, Set<UserRole> userRoleSet, String firstName, String lastName,
			String middleName) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.userRoleSet = userRoleSet;
	}

	public User(String userName, String password, Set<UserRole> userRoleSet, String firstName, String lastName,
			String middleName, Set<UserApplication> userApplicationSet) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.userRoleSet = userRoleSet;
		this.userApplicationSet = userApplicationSet;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<UserRole> getUserRoleSet() {
		return this.userRoleSet;
	}

	public void setUserRoleSet(Set<UserRole> userRoleSet) {
		this.userRoleSet = userRoleSet;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setUserApplicationSet(Set<UserApplication> userApplicationSet) {
		this.userApplicationSet = userApplicationSet;
	}

	public Set<UserApplication> getUserApplicationSet() {
		return userApplicationSet;
	}

	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFullName() {
		String fullName = getFirstName() + " ";
		if (getMiddleName() != null)
			fullName = fullName + getMiddleName() + " ";

		fullName = fullName + getLastName();
		return fullName;
	}

	public int compareTo(User o) {

		return this.getFullName().compareTo(o.getFullName());
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the userApplicationSettings
	 */
	public UserApplicationSettings getUserApplicationSettings() {
		return userApplicationSettings;
	}

	/**
	 * @param userApplicationSettings the userApplicationSettings to set
	 */
	public void setUserApplicationSettings(UserApplicationSettings userApplicationSettings) {
		this.userApplicationSettings = userApplicationSettings;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	
	

}
