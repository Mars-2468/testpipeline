package com.mars.common.model;

/**
 * <p>Title: RolePermission.java </p>

 * <p>Description: Model class for RolePermission</p>

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
@Table(name = "role_permission", schema = "egovcommon")
public class RolePermission implements java.io.Serializable
{
	
	@Id	
    @Column(name="role_permission_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="egovcommon.role_permission_seq", sequenceName="egovcommon.role_permission_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="egovcommon.role_permission_seq") 
    private long rolePermissionId;
    
	@Column(name="tenancyid", nullable=true ,unique=true)	
	private int tenancyid;

    @ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
    private Role role = new Role();

    @ManyToOne
	@JoinColumn(name = "permission_id", nullable = false)
    private Permission permission = new Permission();
    
    @ManyToOne
	@JoinColumn(name = "application_id", nullable = true)
	private Application application = new Application();

    public RolePermission()
    {
    }

    public RolePermission(Role role, Permission permission)
    {
	this.role = role;
	this.permission = permission;
    }

    public long getRolePermissionId()
    {
	return this.rolePermissionId;
    }

    public void setRolePermissionId(long rolePermissionId)
    {
	this.rolePermissionId = rolePermissionId;
    }

    public Role getRole()
    {
	return this.role;
    }

    public void setRole(Role role)
    {
	this.role = role;
    }

    public Permission getPermission()
    {
	return this.permission;
    }

    public void setPermission(Permission permission)
    {
	this.permission = permission;
    }

	public int getTenancyid() {
		return tenancyid;
	}

	public void setTenancyid(int tenancyid) {
		this.tenancyid = tenancyid;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
    
}
