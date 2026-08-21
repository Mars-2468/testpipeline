package com.mars.common.service.impl;

import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.PermissionDAO;
import com.mars.common.model.Permission;
import com.mars.common.search.PermissionSearch;
import com.mars.common.service.PermissionService;

/**
 * 
 * <p>
 * Title: PermissionServiceImpl.java
 * </p>
 * 
 * @see com.mars.common.model.Permission <p>
 *      Description: This class is used for hibernate operations for Permission
 *      module
 *      </p>
 * 
 *      Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd
 * 
 * @version: 1.0
 * 
 * 
 */
  @Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

  private static final Log log = LogFactory.getLog(PermissionServiceImpl.class);

  @Autowired
  private PermissionDAO permissionDAO;

  public void setPermissionDAO(PermissionDAO permissionDAO) {
    if (log.isDebugEnabled()) {
      log.debug("setPermissionDAO Method is called ");
    }
    this.permissionDAO = permissionDAO;
  }

  /**
   * This method is saves the Permission object
   * 
   * @param entity
   *          as Permission object
   * @return
   * 
   */
  public void save(Permission entity) {
    if (log.isDebugEnabled()) {
      log.debug("save Method is called ");
    }
    permissionDAO.save(entity);
  }

  /**
   * This method delete the permission
   * 
   * @param Id
   *          as long
   * @return
   * 
   */
  public void delete(long id) {
    if (log.isDebugEnabled()) {
      log.debug("delete Method is called ");
    }
    permissionDAO.delete(id);
  }

  /**
   * This method is used to get the Model object from the database using
   * hibernate based on id
   * 
   * @param Id
   *          as long
   * @return a Permission Object
   * 
   */
  public Permission get(long id) {
    if (log.isDebugEnabled()) {
      log.debug("get Method is called");
    }
    return permissionDAO.get(id);
  }

  /**
   * This method is used to get the Model object from the database using
   * hibernate based on linkUrl & permissionId
   * 
   * @param linkUrl as String
   * @param permissionId as long
   * @return a Permission Object
   * 
   */
  public Permission getByUrl(String linkUrl, long permissionId) {
    if (log.isDebugEnabled()) {
      log.debug("getByUrl Method is called on " + linkUrl);
    }
    return permissionDAO.getByUrl(linkUrl,permissionId);
  }
  
  /**
   * This method is used to get the Model object from the database using
   * hibernate based on linkName, permissionGroupId & permissionId
   * 
   * @param linkName as String
   * @param permissionGroupId as long
   * @param permissionId as long
   * @return a Permission Object
   * 
   */
  public Permission getByNameGroup(String linkName, long permissionGroupId, long permissionId) {
    if (log.isDebugEnabled()) {
      log.debug("getByNameGroup Method is called on " + linkName);
    }
    return permissionDAO.getByNameGroup(linkName,permissionGroupId,permissionId);
  }
  
  /**
   * This method will return a list of all Permission from the database
   * 
   * @return List of Permission
   */
  public List<Permission> getAll() {
    if (log.isDebugEnabled()) {
      log.debug("get Method is called");
    }
    return permissionDAO.getAll();
  }

  /**
   * This method returns list of the Permission objects available based page
   * number.
   * 
   * @param long PageNumber
   * @param String
   *          orderBy
   * @param String
   *          sortBy
   * @return List
   * @exception Exception
   */
  public List<Permission> getPermissionList(long pageNumber, String orderBy, String sortBy) {

    if (log.isDebugEnabled()) {
      log.debug("get Method is called");
    }
    return permissionDAO.getPermissionList(pageNumber, orderBy, sortBy);
  }
  
  /**
   * This method returns list of the Permission objects available based page number.
   * 
   * @param PermissionSearch searchOptions
   * @return List
   * @exception Exception
   */
  public List<Permission> getPermissionByType(PermissionSearch searchOptions) {
	  if (log.isDebugEnabled()) {
	      log.debug("getPermissionByType Method is called");
	  }
	  
	  return permissionDAO.getPermissionByType(searchOptions);
  }

  /**
   * This method returns count of the Permission objects available based on
   * search criteria.
   * 
   * @return long
   * @exception Exception
   */
  public long getPermissionCount() {
    if (log.isDebugEnabled()) {
      log.debug("saveAll Method is called");
    }
    return permissionDAO.getPermissionCount();
  }
  
  /**
   * This method returns count of the Permission objects from the database
   * 
   * @return PermissionSearch searchOptions
   * @exception Exception
   */
  public long getPermissionCountBySearchOption(PermissionSearch searchOptions) {
	  if (log.isDebugEnabled()) {
	      log.debug("getPermissionCountBySearchOption Method is called");
	  }
	  
	  return permissionDAO.getPermissionCountBySearchOption(searchOptions);
  }

  /**
   * This method save/updates a list of Permission information to the database.
   * 
   * @param listPermission
   *          as List
   * 
   */
  public void saveAll(List<Permission> listPermission) {
    if (log.isDebugEnabled()) {
      log.debug("saveAll Method is called");
    }
    permissionDAO.saveAll(listPermission);
  }

  /**
   * This method is used to delete a list of Module records from the database.
   * 
   * @param listPermission
   *          as List
   */
  public void deleteAll(List<Permission> listPermission) {
    if (log.isDebugEnabled()) {
      log.debug("deleteAll Method is called");
    }
    permissionDAO.deleteAll(listPermission);
  }

  /**
   * This method is used to permissions and associated roles.
   * 
   * @param Hashtable
   *          of permission and rols
   */
  public Hashtable<String, String> getRolePermissions() {
    if (log.isDebugEnabled()) {
      log.debug("getRolePermissions Method is called");
    }
    return permissionDAO.getRolePermissions();
  }

  /**
   * This method is used to permission links for roleIds .
   * 
   * @param Hashtable
   *          of permission and rols
   */
  public Hashtable<String, String> getPermissionsByRoleIds(String roleIds) {
    if (log.isDebugEnabled()) {
      log.debug("getPermissionsByRoleIds Method is called");
    }
    return permissionDAO.getPermissionsByRoleIds(roleIds);
  }
  
  
  public void setDefaultSchema(){
	  if (log.isDebugEnabled()) {
	  log.debug("setDefaultSchema Method is called");
	  }
	  permissionDAO.setDefaultSchema();
	  }

	@Override
	public Hashtable<String, String> getRolePermissions(long applicationId) {
		 if (log.isDebugEnabled()) {
		      log.debug("getRolePermissions Method is called");
		    }
		    return permissionDAO.getRolePermissions(applicationId);
	}
	
	@Override
	public Hashtable<String, String> getPermissionsByRoleIds(String roleIds,long applicationId) {
		if (log.isDebugEnabled()) {
		      log.debug("getPermissionsByRoleIds Method is called");
		    }
		    return permissionDAO.getPermissionsByRoleIds(roleIds,applicationId);
	}

	@Override
	public Hashtable<String, String> getPermissionsByRoleNames(String roleName){
		  if (log.isDebugEnabled()) {
		      log.debug("getPermissionsByRoleNames Method is called");
		    }
		    return permissionDAO.getPermissionsByRoleNames(roleName);
	 }
}
