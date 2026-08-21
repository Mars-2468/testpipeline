package com.mars.common.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.UserRoleDAO;
import com.mars.common.model.UserRole;
import com.mars.common.service.UserRoleService;

/**
 * 
 * <p>
 * Title: UserRoleServiceImpl.java
 * </p>
 * 
 * @see com.mars.common.model.UserRole <p>
 *      Description: This class is used for hibernate operations for UserRole module
 *      </p>
 * 
 *      Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd
 * 
 * @version: 1.0
 * 
 * 
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	private static final Log log = LogFactory.getLog(UserRoleServiceImpl.class);

	@Autowired
	private UserRoleDAO userRoleDAO;

	public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setUserRoleDAO Method is called ");
		}
		this.userRoleDAO = userRoleDAO;
	}

	/**
	 * This method is saves the UserRole object
	 * 
	 * @param entity
	 *            as UserRole object
	 * @return
	 * 
	 */
	public void save(UserRole entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		userRoleDAO.save(entity);
	}

	/**
	 * This method delete the userRole
	 * 
	 * @param Id
	 *            as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		userRoleDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using hibernate based on id
	 * 
	 * @param Id
	 *            as long
	 * @return a UserRole Object
	 * 
	 */
	public UserRole get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return userRoleDAO.get(id);
	}

	/**
	 * This method will return a list of all UserRole from the database
	 * 
	 * @return List of UserRole
	 */
	public List<UserRole> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return userRoleDAO.getAll();
	}

	/**
	 * This method returns list of the UserRole objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String
	 *            orderBy
	 * @param String
	 *            sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<UserRole> getUserRoleList(long pageNumber, String orderBy, String sortBy) {

		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return userRoleDAO.getUserRoleList(pageNumber, orderBy, sortBy);
	}

	/**
	 * This method returns count of the UserRole objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getUserRoleCount() {
		if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		return userRoleDAO.getUserRoleCount();
	}

	/**
	 * This method save/updates a list of UserRole information to the database.
	 * 
	 * @param listUserRole
	 *            as List
	 * 
	 */
	public void saveAll(List<UserRole> listUserRole) {
		if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		userRoleDAO.saveAll(listUserRole);
	}

	/**
	 * This method is used to delete a list of Module records from the database.
	 * 
	 * @param listUserRole
	 *            
	 */
	public void deleteAll(List<UserRole> listUserRole) {
		if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		userRoleDAO.deleteAll(listUserRole);
	}

	/**
	 * This method returns UserRole object
	 * 
	 * @param userId
	 * @return
	 */
	public UserRole getByUserId(long userId) {
		if (log.isDebugEnabled()) {
			log.debug("getByUserId Method is called");
		}
		return userRoleDAO.getByUserId(userId);
	}

}
