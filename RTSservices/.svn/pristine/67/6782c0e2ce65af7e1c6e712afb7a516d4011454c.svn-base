package com.mars.common.service;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.RolePermission;

/**
* <p>Title: RolePermissionService.java </p>

 * <p>Description: This interface is used for service implementations related to RolePermission</p>

 * @see com.mars.common.model.RolePermission
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 * 
 */
@Transactional(readOnly = true)
public interface RolePermissionService {
  
	/**
	 * This method returns RolePermission object for a given Id
	 * 
	 * @param id as long
	 * @return RolePermission as model object
	 */
	public RolePermission get(long id);
		
    /**
	 * This method save/updates the RolePermission information to the database.
	 * 
	 * @param RolePermission object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(RolePermission entity);
	    
    /**
	 * This method delete RolePermission for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all RolePermission from the database
	 * 
	 * @return List of RolePermission
	 */
	public List<RolePermission> getAll();
	
	/**
     * This method save/updates a list of RolePermission information to the database.
     * 
     * @param listRolePermission as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<RolePermission> listRolePermission);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listRolePermission as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<RolePermission> listRolePermission);
    
    /**
	 * This method returns list of the RolePermission objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<RolePermission> getRolePermissionList(long pageNumber,String orderBy, String sortBy);
	
	/**
	 * This method returns count of the RolePermission objects from the database
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getRolePermissionCount();

}

