package com.mars.common.dao;

import java.util.Hashtable;
import java.util.List;

import com.mars.common.model.Permission;
import com.mars.common.search.PermissionSearch;

/**
 * <p>Title: PermissionDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for Permission</p>

 * @see com.mars.common.model.Permission
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 * 
 */

public interface PermissionDAO
{

    /**
     * This method returns Permission object for a given Id
     * 
     * @param id as long
     * @return Permission as model object
     */
    public Permission get(long id);
    
    /**
     * This method returns Permission object for a given linkUrl & permissionId
     * 
     * @param linkUrl as String
     * @param permissionId as long
     * @return Permission as model object
     */
    public Permission getByUrl(String linkUrl, long permissionId);
    
    /**
     * This method returns Permission object for a given linkName, permissionGroupId & permissionId
     * 
     * @param linkName as String
     * @param permissionGroupId as long
     * @param permissionId as long
     * @return Permission as model object
     */
    public Permission getByNameGroup(String linkName, long permissionGroupId, long permissionId);

    /**
     * This method save/updates the Permission information to the database.
     * 
     * @param Permission object
     * 
     */
    public void save(Permission entity);

    /**
     * This method delete Permission for a given Id
     * 
     * @param id as long
     * 
     */
    public void delete(long id);

    /**
     * This method will return a list of all Permission from the database
     * 
     * @return List of Permission
     */
    public List<Permission> getAll();

    /**
     * This method save/updates a list of Permission information to the database.
     * 
     * @param listPermission as List
     * 
     */
    public void saveAll(List<Permission> listPermission);

    /**
     * This method is used to delete a list of Permission records from the database.
     * 
     * @param listPermission as List
     */
    public void deleteAll(List<Permission> listPermission);

    /**
     * This method returns list of the Permission objects available based page number.
     * 
     * @param long PageNumber
     * @param String orderBy
     * @param String sortBy
     * @return List
     * @exception Exception
     */
    public List<Permission> getPermissionList(long pageNumber, String orderBy, String sortBy);
    
    /**
     * This method returns list of the Permission objects available based page number.
     * 
     * @param PermissionSearch searchOptions
     * @return List
     * @exception Exception
     */
    public List<Permission> getPermissionByType(PermissionSearch searchOptions);

    /**
     * This method returns count of the Permission objects from the database
     * 
     * @return long
     * @exception Exception
     */
    public long getPermissionCount();
    
    /**
     * This method returns count of the Permission objects from the database
     * 
     * @return PermissionSearch searchOptions
     * @exception Exception
     */
    public long getPermissionCountBySearchOption(PermissionSearch searchOptions);

    /**
     * This method is used to permissions and associated roles.
     * 
     * @param Hashtable of permission and rols
     */
    public Hashtable<String, String> getRolePermissions();
    
    public Hashtable<String, String> getRolePermissions(long applicationId);
    
    /**
     * This method is used to permission links for roleIds .
     * 
     * @param Hashtable of permission and rols
     */
    public Hashtable<String, String> getPermissionsByRoleIds(String roleIds);
    

    public Hashtable<String, String> getPermissionsByRoleIds(String roleIds,long applicationId);
    
    public void setDefaultSchema();
    public Hashtable<String, String> getPermissionsByRoleNames(String roleName);
}
