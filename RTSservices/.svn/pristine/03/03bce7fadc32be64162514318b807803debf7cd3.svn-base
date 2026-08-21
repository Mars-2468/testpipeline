package com.mars.common.model;

/**
 * <p>Title: UserRole.java </p>

 * <p>Description: Model class for UserRole</p>

 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * @author : Mars Telecom Systems Pvt Ltd
 * 
 */

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
@Table(name = "user_role", schema = "egovcommon")
public class UserRole implements java.io.Serializable
{

	@Id	
    @Column(name="user_role_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="user_role_seq", sequenceName="user_role_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="user_role_seq") 
	private long userRoleId;

	@Column(name = "user_role_st_date", unique = true, nullable = true)
	private String userRoleStDate;

	@Column(name = "user_role_end_date", unique = true, nullable = true)
	private String userRoleEndDate;
	
	/*
	 * @Column(name = "is_default", unique = true, nullable = true) private Integer
	 * isDefault;
	 */
	
	@Column(name="application_id")
	private Integer applicationId;
	
	@Column(name = "tenancyid", unique = true, nullable = true)
	private Long  tenancyid;

    @ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
    private Role role = new Role();

    public UserRole()
    {
    }

    public UserRole(String userRoleStDate, String userRoleEndDate, Integer applicationId, User user, Role role)
    {
	this.userRoleStDate = userRoleStDate;
	this.userRoleEndDate = userRoleEndDate;
	//this.isDefault = isDefault;
	this.user = user;
	this.role = role;
	this.applicationId=applicationId;
    }

    public long getUserRoleId()
    {
	return this.userRoleId;
    }

    public void setUserRoleId(long userRoleId)
    {
	this.userRoleId = userRoleId;
    }

    public String getUserRoleStDate()
    {
	return this.userRoleStDate;
    }

    public void setUserRoleStDate(String userRoleStDate)
    {
	this.userRoleStDate = userRoleStDate;
    }

    public String getUserRoleEndDate()
    {
	return this.userRoleEndDate;
    }

    public void setUserRoleEndDate(String userRoleEndDate)
    {
	this.userRoleEndDate = userRoleEndDate;
    }

/*    public Integer getIsDefault()
    {
	return this.isDefault;
    }

    public void setIsDefault(Integer isDefault)
    {
	this.isDefault = isDefault;
    }*/

    public User getUser()
    {
	return this.user;
    }

    public void setUser(User user)
    {
	this.user = user;
    }

    public Role getRole()
    {
	return this.role;
    }

    public void setRole(Role role)
    {
	this.role = role;
    }

	public Long getTenancyid() {
		return tenancyid;
	}

	public void setTenancyid(Long tenancyid) {
		this.tenancyid = tenancyid;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

//	public Integer getIsDefault() {
//		return isDefault;
//	}
//
//	public void setIsDefault(Integer isDefault) {
//		this.isDefault = isDefault;
//	}
    
}
