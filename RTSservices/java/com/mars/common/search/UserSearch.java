package com.mars.common.search;

import com.mars.common.utils.CommonUtils;

public class UserSearch extends BaseSearchObject {
	private static final long serialVersionUID = 1L;

	private String username;
	private String firstName;
	private String middleName;
	private String lastName;
	private long designationId;
	private long departmentId;
	private long applicationId;
	private String applicationName;
	private long tenancyId;
	private boolean employessOnly=false;
	private long sectionId;
	
	public UserSearch() {
		setOrderBy("firstName");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = CommonUtils.decodeString(username);
		if(this.username != null  && this.username.length() > 0)setSearchParamSet(true);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = CommonUtils.decodeString(firstName);
		if(this.firstName != null  && this.firstName.length() > 0)setSearchParamSet(true);
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = CommonUtils.decodeString(middleName);
		if(this.middleName != null  && this.middleName.length() > 0) setSearchParamSet(true);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = CommonUtils.decodeString(lastName);
		if(this.lastName != null  && this.lastName.length() > 0)setSearchParamSet(true);
	}

	public long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(long designationId) {
		this.designationId = designationId;
		if(this.designationId != 0)setSearchParamSet(true);
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public long getApplicationId() {
		return applicationId;
	}

	/**
	 * @return the applicationName
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * @param applicationName the applicationName to set
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public long getTenancyId() {
		return tenancyId;
	}

	public void setTenancyId(long tenancyId) {
		this.tenancyId = tenancyId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
		if(this.departmentId != 0)setSearchParamSet(true);
	}

	public boolean isEmployessOnly() {
		return employessOnly;
	}

	public void setEmployessOnly(boolean employessOnly) {
		this.employessOnly = employessOnly;
	}

	public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}
	
	
		
}
