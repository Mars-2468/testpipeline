package com.mars.common.service.impl;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.RolePermissionDAO;
import com.mars.common.model.RolePermission;
import com.mars.common.service.RolePermissionService;
 /**

 * <p>Title: RolePermissionServiceImpl.java </p>

 * @see com.mars.common.model.RolePermission
 
 * <p>Description: This class is used for hibernate operations for RolePermission module</p>

 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 
 */
 @Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {

    private static final Log log = LogFactory.getLog(RolePermissionServiceImpl.class);

  	
	@Autowired
	private RolePermissionDAO rolePermissionDAO;

	public void setRolePermissionDAO(RolePermissionDAO rolePermissionDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setRolePermissionDAO Method is called ");
		}
		this.rolePermissionDAO = rolePermissionDAO;
	}

	/**
	 * This method is saves the RolePermission object
	 * 
	 * @param entity as RolePermission object
	 * @return
	 * 
	 */
	public void save(RolePermission entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		rolePermissionDAO.save(entity);
	}

	/**
	 * This method delete the rolePermission
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		rolePermissionDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a RolePermission Object
	 * 
	 */
	public RolePermission get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return rolePermissionDAO.get(id);
	}
	
	/**
	 * This method will return a list of all RolePermission from the database
	 * 
	 * @return List of RolePermission
	 */
	public List<RolePermission> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return rolePermissionDAO.getAll();
	}
	
	/**
	 * This method returns list of the RolePermission objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<RolePermission> getRolePermissionList(long pageNumber,String orderBy, String sortBy){
	
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return rolePermissionDAO.getRolePermissionList(pageNumber,orderBy,sortBy);
	}
	
	
	/**
	 * This method returns count of the RolePermission objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getRolePermissionCount(){
	    if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		return rolePermissionDAO.getRolePermissionCount();
	}	
	
	/**
     * This method save/updates a list of RolePermission information to the database.
     * 
     * @param listRolePermission as List
     * 
     */
    public void saveAll(List<RolePermission> listRolePermission){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		rolePermissionDAO.saveAll(listRolePermission);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listRolePermission as List
     */
    public void deleteAll(List<RolePermission> listRolePermission){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		rolePermissionDAO.deleteAll(listRolePermission);
    }
    
}

