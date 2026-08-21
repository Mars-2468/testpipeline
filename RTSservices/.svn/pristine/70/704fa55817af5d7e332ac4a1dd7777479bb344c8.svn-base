package com.mars.common.dao;



import java.util.List;

import com.mars.common.model.RolePermission;

/**
 * <p>Title: RolePermissionDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for RolePermission</p>

 * @see com.mars.common.model.RolePermission
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 * 
 */

public interface RolePermissionDAO {

  
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
	public void save(RolePermission entity);
	
    
    /**
	 * This method delete RolePermission for a given Id
	 * 
	 * @param id as long
	 * 
	 */
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
    public void saveAll(List<RolePermission> listRolePermission);
    
    
    /**
     * This method is used to delete a list of RolePermission records from the database.
     * 
     * @param listRolePermission as List
     */
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

