package com.mars.common.model;

/**
 * <p>Title: Role.java </p>

 * <p>Description: Model class for Role</p>

 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * @author : Mars Telecom Systems Pvt Ltd>
 * 
 */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;

@Entity
@Table(name = "role", schema = "egovcommon")
@DataTransferObject(type = "hibernate3")

public class Role implements java.io.Serializable
{
	@Id
	@Column(name = "role_id", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.role_seq", sequenceName = "egovcommon.role_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.role_seq")
	
    private long roleId;

	@Column(name = "ROLE_NAME", nullable = false)
    private String role_name;
    
	@Column(name = "TENANCYID", nullable = true)
    private Long tenancyId;
	
	@ManyToOne
	@JoinColumn(name = "application_id", nullable = true)
	private Application application = new Application();

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "role")
    private Set<RolePermission> rolePermissionSet = new HashSet<RolePermission>();
	
    public Role()
    {
    }

	public Long getTenancyId() {
		return tenancyId;
	}

	public void setTenancyId(Long tenancyId) {
		this.tenancyId = tenancyId;
	}

	public Role(String role_name)
    {
	this.role_name = role_name;
    }

    public Role(String role_name, Set rolePermissionSet)
    {
	this.role_name = role_name;
	this.rolePermissionSet = rolePermissionSet;
    }

    public long getRoleId()
    {
	return this.roleId;
    }

    public void setRoleId(long roleId)
    {
	this.roleId = roleId;
    }

    public String getRole_name()
    {
	return this.role_name;
    }

    public void setRole_name(String role_name)
    {
	this.role_name = role_name;
    }
  
	public Set getRolePermissionSet()
    {
	return this.rolePermissionSet;
    }

    public void setRolePermissionSet(Set rolePermissionSet)
    {
	this.rolePermissionSet = rolePermissionSet;
    }

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
    
}
