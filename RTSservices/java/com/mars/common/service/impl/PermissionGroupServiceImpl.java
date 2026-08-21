package com.mars.common.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.PermissionGroupDAO;
import com.mars.common.model.PermissionGroup;
import com.mars.common.service.PermissionGroupService;

/**
 * 
 * <p>
 * Title: PermissionGroupServiceImpl.java
 * </p>
 * 
 * @see com.mars.common.model.PermissionGroup <p>
 *      Description: This class is used for hibernate operations for
 *      PermissionGroup module
 *      </p>
 * 
 *      Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd
 * 
 * @version: 1.0
 * 
 * 
 */
@Service("permissionGroupService")
public class PermissionGroupServiceImpl implements PermissionGroupService {

  private static final Log log = LogFactory.getLog(PermissionGroupServiceImpl.class);

  @Autowired
  private PermissionGroupDAO permissionGroupDAO;

  public void setPermissionGroupDAO(PermissionGroupDAO permissionGroupDAO) {
    if (log.isDebugEnabled()) {
      log.debug("setPermissionGroupDAO Method is called ");
    }
    this.permissionGroupDAO = permissionGroupDAO;
  }

  /**
   * This method is saves the PermissionGroup object
   * 
   * @param entity
   *          as PermissionGroup object
   * @return
   * 
   */
  public void save(PermissionGroup entity) {
    if (log.isDebugEnabled()) {
      log.debug("save Method is called ");
    }
    permissionGroupDAO.save(entity);
  }

  /**
   * This method delete the permissionGroup
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
    permissionGroupDAO.delete(id);
  }

  /**
   * This method is used to get the Model object from the database using
   * hibernate based on id
   * 
   * @param Id
   *          as long
   * @return a PermissionGroup Object
   * 
   */
  public PermissionGroup get(long id) {
    if (log.isDebugEnabled()) {
      log.debug("get Method is called");
    }
    return permissionGroupDAO.get(id);
  }

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on name & permissionGroupId
	 * 
	 * @param name as String
	 * @param permissionGroupId as long
	 * @return a PermissionGroup Object
	 * 
	 */
	public PermissionGroup getByName(String name, long permissionGroupId) {
		if (log.isDebugEnabled()) {
			log.debug("getByName Method is called on " + name);
		}
		return permissionGroupDAO.getByName(name,permissionGroupId);
	}
	
  /**
   * This method will return a list of all PermissionGroup from the database
   * 
   * @return List of PermissionGroup
   */
  public List<PermissionGroup> getAll() {
    if (log.isDebugEnabled()) {
      log.debug("get Method is called");
    }
    return permissionGroupDAO.getAll();
  }

  /**
   * This method returns list of the PermissionGroup objects available based
   * page number.
   * 
   * @param long PageNumber
   * @param String
   *          orderBy
   * @param String
   *          sortBy
   * @return List
   * @exception Exception
   */
  public List<PermissionGroup> getPermissionGroupList(long pageNumber, String orderBy, String sortBy) {

    if (log.isDebugEnabled()) {
      log.debug("get Method is called");
    }
    return permissionGroupDAO.getPermissionGroupList(pageNumber, orderBy, sortBy);
  }

  /**
   * This method returns count of the PermissionGroup objects available based on
   * search criteria.
   * 
   * @return long
   * @exception Exception
   */
  public long getPermissionGroupCount() {
    if (log.isDebugEnabled()) {
      log.debug("saveAll Method is called");
    }
    return permissionGroupDAO.getPermissionGroupCount();
  }

  /**
   * This method save/updates a list of PermissionGroup information to the
   * database.
   * 
   * @param listPermissionGroup
   *          as List
   * 
   */
  public void saveAll(List<PermissionGroup> listPermissionGroup) {
    if (log.isDebugEnabled()) {
      log.debug("saveAll Method is called");
    }
    permissionGroupDAO.saveAll(listPermissionGroup);
  }

  /**
   * This method is used to delete a list of Module records from the database.
   * 
   * @param listPermissionGroup
   *          as List
   */
  public void deleteAll(List<PermissionGroup> listPermissionGroup) {
    if (log.isDebugEnabled()) {
      log.debug("deleteAll Method is called");
    }
    permissionGroupDAO.deleteAll(listPermissionGroup);
  }
  /**
   * 
   */
  public List<PermissionGroup> getPermissionGroupListBySearch(PermissionGroup searchOptions)
  {
	  if (log.isDebugEnabled()) {
	      log.debug("getPermissionGroupListBySearch Method is called");
	    }
	    return permissionGroupDAO.getPermissionGroupListBySearch(searchOptions);  
  }
  /**
   * 
   */
  public long getPermissionGroupCountBySearchOption(PermissionGroup searchOptions)
  {
	  if (log.isDebugEnabled()) {
	      log.debug("getPermissionGroupCountBySearchOption Method is called");
	    }
	    return permissionGroupDAO.getPermissionGroupCountBySearchOption(searchOptions); 
  }
}
