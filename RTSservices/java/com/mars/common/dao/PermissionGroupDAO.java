package com.mars.common.dao;



import java.util.List;

import com.mars.common.model.PermissionGroup;

/**
 * <p>Title: PermissionGroupDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for PermissionGroup</p>

 * @see com.mars.common.model.PermissionGroup
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 * 
 */

public interface PermissionGroupDAO {

  
	/**
	 * This method returns PermissionGroup object for a given Id
	 * 
	 * @param id as long
	 * @return PermissionGroup as model object
	 */
	public PermissionGroup get(long id);
	
	/**
	 * This method returns PermissionGroup object for a given name & permissionGroupId
	 * 
	 * @param name as String
	 * @param permissionGroupId as long
	 * @return PermissionGroup as model object
	 */
	public PermissionGroup getByName(String name, long permissionGroupId);
    
    /**
	 * This method save/updates the PermissionGroup information to the database.
	 * 
	 * @param PermissionGroup object
	 * 
	 */
	public void save(PermissionGroup entity);
	
    
    /**
	 * This method delete PermissionGroup for a given Id
	 * 
	 * @param id as long
	 * 
	 */
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all PermissionGroup from the database
	 * 
	 * @return List of PermissionGroup
	 */
	public List<PermissionGroup> getAll();
	
	/**
     * This method save/updates a list of PermissionGroup information to the database.
     * 
     * @param listPermissionGroup as List
     * 
     */
    public void saveAll(List<PermissionGroup> listPermissionGroup);
    
    
    /**
     * This method is used to delete a list of PermissionGroup records from the database.
     * 
     * @param listPermissionGroup as List
     */
    public void deleteAll(List<PermissionGroup> listPermissionGroup);
    
    /**
	 * This method returns list of the PermissionGroup objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<PermissionGroup> getPermissionGroupList(long pageNumber,String orderBy, String sortBy);
	
	/**
	 * This method returns count of the PermissionGroup objects from the database
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getPermissionGroupCount();
	/**
	 * 
	 * @param searchOptions
	 * @param pageNumber
	 * @param orderBy
	 * @param sortBy
	 * @return
	 */
    public List<PermissionGroup> getPermissionGroupListBySearch(PermissionGroup searchOptions);
	/**
	 * 
	 * @param searchOptions
	 * @param pageNumber
	 * @param orderBy
	 * @param sortBy
	 * @return
	 */
    public long getPermissionGroupCountBySearchOption(PermissionGroup searchOptions);
}

