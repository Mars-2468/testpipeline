package com.mars.common.service;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.UserRole;

/**
* <p>Title: UserRoleService.java </p>

 * <p>Description: This interface is used for service implementations related to UserRole</p>

 * @see com.mars.common.model.UserRole
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 * 
 */
@Transactional(readOnly = true)
public interface UserRoleService {
  
	/**
	 * This method returns UserRole object for a given Id
	 * 
	 * @param id as long
	 * @return UserRole as model object
	 */
	public UserRole get(long id);
		
    /**
	 * This method save/updates the UserRole information to the database.
	 * 
	 * @param UserRole object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(UserRole entity);
	    
    /**
	 * This method delete UserRole for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all UserRole from the database
	 * 
	 * @return List of UserRole
	 */
	public List<UserRole> getAll();
	
	/**
     * This method save/updates a list of UserRole information to the database.
     * 
     * @param listUserRole as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<UserRole> listUserRole);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listUserRole as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<UserRole> listUserRole);
    
    /**
	 * This method returns list of the UserRole objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<UserRole> getUserRoleList(long pageNumber,String orderBy, String sortBy);
	
	/**
	 * This method returns count of the UserRole objects from the database
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getUserRoleCount();
	
	/**
	 * This method returns UserRole object
	 * 
	 * @param userId
	 * @return
	 */
	public UserRole getByUserId(long userId);

}

