package com.mars.common.service;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.Role;
import com.mars.common.model.RolePermission;
import com.mars.common.search.RoleSearch;

/**
 * <p>Title: RoleService.java </p>

 * <p>Description: This interface is used for service implementations related to Role</p>

 * @see com.mars.common.model.Role
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 * 
 */
@Transactional(readOnly = true)
public interface RoleService
{

    /**
     * This method returns Role object for a given Id
     * 
     * @param id as long
     * @return Role as model object
     */
    public Role get(long id);

    /**
     * This method returns Role object for a given Role name & Role Id
     * 
     * @param roleName as String
     * @param roleId as long
     * @return Role as model object
     */
    public Role getByName(String roleName, long roleId);

    /**
     * This method save/updates the Role information to the database.
     * @param entity  as Role object
     * @param rolePermissionSet set Of role Permissions to Add
     * @param deleteIds as String
     * 
     * @param Role object
     * 
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void save(Role entity, Set<RolePermission> rolePermissionSet, String deleteIds);

    /**
     * This method delete Role for a given Id
     * 
     * @param id as long
     * 
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id);

    /**
     * This method will return a list of all Role from the database
     * 
     * @return List of Role
     */
    public List<Role> getAll();

    /**
     * This method save/updates a list of Role information to the database.
     * 
     * @param listRole as List
     * 
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Role> listRole);

    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listRole as List
     */
    @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Role> listRole);

    /**
     * This method returns list of the Role objects available based page number.
     * 
     * @param long PageNumber
     * @param String orderBy
     * @param String sortBy
     * @return List
     * @exception Exception
     */
    public List<Role> getRoleList(long pageNumber, String orderBy, String sortBy);

    /**
     * This method returns list of the Role objects available based page number.
     * 
     * @param RoleSearch searchOptions
     * @return List
     * @exception Exception
     */
    public List<Role> getRoleByType(RoleSearch searchOptions);

    /**
     * This method returns count of the Role objects from the database
     * 
     * @return long
     * @exception Exception
     */
    public long getRoleCount();

    /**
     * This method returns count of the Role objects from the database
     * 
     * @return RoleSearch searchOptions
     * @exception Exception
     */
    public long getRoleCountBySearchOption(RoleSearch searchOptions);

    /**
     * This method returns count of the Role objects from the database
     * @param roleId as long
     * @return list of objects
     * @exception Exception
     */
    public List<Object> getAssociatedPermissionsByRoleId(long roleId);
    
    /**
     * This method returns Role object from the database
     * 
     * @param roleName
     * @return
     */
	public Role getByRoleName(String roleName);
}
