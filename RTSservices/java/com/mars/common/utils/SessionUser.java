/**
 * 
 */
package com.mars.common.utils;

/**
 * <p>
 * Title: SessionUser.java
 * </p>
 * 
 * <p>
 * Description: Model class for Session User Info
 * </p>
 * 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd
 * 
 * @version: 1.0
 * 
 * @author : NMMC development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
public class SessionUser implements java.io.Serializable{

  private static final long serialVersionUID = 6816227180786181649L;
	
  private long userId;
  
  private long tenancyId;

  private String userName;

  private String password;

  private long employeeId;
  
  private long departmentId;

  private String firstName;

  private String middleName;
  
  private String email;

  private String lastName;

  private long designationId;

  private String designationName;

  private long officeId;

  private String officeName;

  private long sectionOfficeId;

  private long sectionId;

  private String sectionName;

  private String roleIds;
  
  private String roleNames;
  
  private long wardId;
  
  private String wardName;
  
  private long collectionCenterId;
  
  private String collectionCenterName;
  private String tenancyName;
  
  private String municipalName;
  
  private String redirectUrl;
  
  public String getWardName() {
	return wardName;
}

public void setWardName(String wardName) {
	this.wardName = wardName;
}

public long getCollectionCenterId() {
	return collectionCenterId;
}

public void setCollectionCenterId(long collectionCenterId) {
	this.collectionCenterId = collectionCenterId;
}

public String getCollectionCenterName() {
	return collectionCenterName;
}

public void setCollectionCenterName(String collectionCenterName) {
	this.collectionCenterName = collectionCenterName;
}

public String getRoleNames() {
    return roleNames;
  }

  public void setRoleNames(String roleNames) {
    this.roleNames = roleNames;
  }

  public String getRoleIds() {
    return roleIds;
  }

  public void setRoleIds(String roleIds) {
    this.roleIds = roleIds;
  }
  
  /**
   * @return the designationId
   */
  public long getDesignationId() {
    return designationId;
  }

  /**
   * @param designationId
   *          the designationId to set
   */
  public void setDesignationId(long designationId) {
    this.designationId = designationId;
  }

  /**
   * @return the officeId
   */
  public long getOfficeId() {
    return officeId;
  }

  /**
   * @param officeId
   *          the officeId to set
   */
  public void setOfficeId(long officeId) {
    this.officeId = officeId;
  }

  /**
   * @return the officeName
   */
  public String getOfficeName() {
    return officeName;
  }

  /**
   * @param officeName
   *          the officeName to set
   */
  public void setOfficeName(String officeName) {
    this.officeName = officeName;
  }

  /**
   * @return the sectionOfficeId
   */
  public long getSectionOfficeId() {
    return sectionOfficeId;
  }

  /**
   * @param sectionOfficeId
   *          the sectionOfficeId to set
   */
  public void setSectionOfficeId(long sectionOfficeId) {
    this.sectionOfficeId = sectionOfficeId;
  }

  /**
   * @return the sectionId
   */
  public long getSectionId() {
    return sectionId;
  }

  /**
   * @param sectionId
   *          the sectionId to set
   */
  public void setSectionId(long sectionId) {
    this.sectionId = sectionId;
  }

  /**
   * @return the sectionName
   */
  public String getSectionName() {
    return sectionName;
  }

  /**
   * @param sectionName
   *          the sectionName to set
   */
  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
  }

  /**
   * @return the userId
   */
  public long getUserId() {
    return userId;
  }

  /**
   * @param userId
   *          the userId to set
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getTenancyId() {
	return tenancyId;
}

public void setTenancyId(long tenancyId) {
	this.tenancyId = tenancyId;
}

/**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName
   *          the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password
   *          the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the employeeId
   */
  public long getEmployeeId() {
    return employeeId;
  }

  /**
   * @param employeeId
   *          the employeeId to set
   */
  public void setEmployeeId(long employeeId) {
    this.employeeId = employeeId;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName
   *          the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the middleName
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * @param middleName
   *          the middleName to set
   */
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName
   *          the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the designationName
   */
  public String getDesignationName() {
    return designationName;
  }

	  /**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

/**
   * @param designationName
   *          the designationName to set
   */
  public void setDesignationName(String designationName) {
    this.designationName = designationName;
  }

	/**
	 * @return the departmentId
	 */
	public long getDepartmentId() {
		return departmentId;
	}
	
	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the wardId
	 */
	public long getWardId() {
		return wardId;
	}

	/**
	 * @param wardId the wardId to set
	 */
	public void setWardId(long wardId) {
		this.wardId = wardId;
	}

	public String getTenancyName() {
		return tenancyName;
	}

	public void setTenancyName(String tenancyName) {
		this.tenancyName = tenancyName;
	}

	public String getMunicipalName() {
		return municipalName;
	}

	public void setMunicipalName(String municipalName) {
		this.municipalName = municipalName;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	

}
