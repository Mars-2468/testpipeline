package com.mars.common.model;

/**
 * <p>Title: PermissionGroup.java </p>

 * <p>Description: Model class for PermissionGroup</p>

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

import com.mars.common.search.BaseSearchObject;

@Entity
@Table(name = "PERMISSION_GROUP", schema = "egovcommon")
@DataTransferObject(type = "hibernate3")
public class PermissionGroup extends BaseSearchObject implements java.io.Serializable
{

    private static final long serialVersionUID = 6816227180786181649L;

    @Id
	@Column(name = "PERMISSION_GROUP_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.PERMISSION_GROUP_seq", sequenceName = "egovcommon.PERMISSION_GROUP_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.PERMISSION_GROUP_seq")
    @RemoteProperty
    private long permissionGroupId;

	@Column(name = "NAME", nullable = true)
    private String name;

	@Transient
    private boolean checked;
    
    @Column(name = "TENANCYID", nullable = true)
    private long tenancyId;

    @ManyToOne
	@JoinColumn(name = "application_id", nullable = false)
	private Application application = new Application();

    
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "permissionGroup")
    private Set<Permission> permissionSet = new HashSet<Permission>();

    public PermissionGroup()
    {
    }

    public PermissionGroup(String name, Set permissionSet)
    {
	this.name = name;
	this.permissionSet = permissionSet;
    }

    public long getPermissionGroupId()
    {
	return this.permissionGroupId;
    }

    public void setPermissionGroupId(long permissionGroupId)
    {
	this.permissionGroupId = permissionGroupId;
    }

    public String getName()
    {
	return this.name;
    }

    public void setName(String name)
    {
	this.name = name;
	if(this.name != null && this.name.length() > 0)setSearchParamSet(true);
	}

    public Set getPermissionSet()
    {
	return this.permissionSet;
    }

    public void setPermissionSet(Set permissionSet)
    {
	this.permissionSet = permissionSet;
    }

    public boolean isChecked()
    {
	return checked;
    }

    public void setChecked(boolean checked)
    {
	this.checked = checked;
    }

	public long getTenancyId() {
		return tenancyId;
	}

	public void setTenancyId(long tenancyId) {
		this.tenancyId = tenancyId;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
}
