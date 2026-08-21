package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/**
 * <p>Title: Permission.java </p>

 * <p>Description: Model class for Permission</p>

 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 
 */
@Entity
@Table(name = "PERMISSIONS", schema = "egovcommon")
@DataTransferObject(type = "hibernate3")
public class Permission implements java.io.Serializable
{

	@Id
	@Column(name = "PERMISSION_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.PERMISSION_seq", sequenceName = "egovcommon.PERMISSION_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.PERMISSION_seq")
	@RemoteProperty
    private long permissionId;

	@Column(name = "LINK_NAME", nullable = false)
    private String linkName;

	@Column(name = "LINK_URL", nullable = false)
    private String linkUrl;
    
	@Column(name = "TENANCYID", nullable = true)
    private long tenancyId;
	
	@ManyToOne
	@JoinColumn(name = "application_id", nullable = false)
	private Application application = new Application();


	@ManyToOne
	@JoinColumn(name = "PERMISSION_GROUP_ID", nullable = false)
    private PermissionGroup permissionGroup = new PermissionGroup();
    
    //This is not part of hbm. Using it internally to differentiate whether a permission is assigned or not 
    //while displaying the Permissions Tree  in manageRole.jsp.
	@Transient
    private long assignedRolePermissionId = 0;

    public Permission()
    {
    }

    public Permission(String linkName, String linkUrl)
    {
	this.linkName = linkName;
	this.linkUrl = linkUrl;
    }

    public Permission(String linkName, String linkUrl, PermissionGroup permissionGroup)
    {
	this.linkName = linkName;
	this.linkUrl = linkUrl;
	this.permissionGroup = permissionGroup;
    }

    public long getPermissionId()
    {
	return this.permissionId;
    }

    public void setPermissionId(long permissionId)
    {
	this.permissionId = permissionId;
    }

    public String getLinkName()
    {
	return this.linkName;
    }

    public void setLinkName(String linkName)
    {
	this.linkName = linkName;
    }

    public String getLinkUrl()
    {
	return this.linkUrl;
    }

    public void setLinkUrl(String linkUrl)
    {
	this.linkUrl = linkUrl;
    }

    public long getTenancyId() {
		return tenancyId;
	}

	public void setTenancyId(long tenancyId) {
		this.tenancyId = tenancyId;
	}

	public PermissionGroup getPermissionGroup()
    {
	return this.permissionGroup;
    }

    public void setPermissionGroup(PermissionGroup permissionGroup)
    {
	this.permissionGroup = permissionGroup;
    }

	/**
	 * @return the assignedRolePermissionId
	 */
	public long getAssignedRolePermissionId() {
		return assignedRolePermissionId;
	}

	/**
	 * @param assignedRolePermissionId the assignedRolePermissionId to set
	 */
	public void setAssignedRolePermissionId(long assignedRolePermissionId) {
		this.assignedRolePermissionId = assignedRolePermissionId;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
}
