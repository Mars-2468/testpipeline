package com.mars.common.service.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.UserDAO;
import com.mars.common.model.User;
import com.mars.common.search.UserSearch;
import com.mars.common.service.UserService;

/**
 * 
 * <p>
 * Title: UserServiceImpl.java
 * </p>
 * 
 * @see com.mars.common.model.User
 * 
 * <p>
 * Description: This class is used for hibernate operations for User module
 * </p>
 * 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd
 * 
 * @version: 1.0
 * 
 * 
 * 
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Log log = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setUserDAO Method is called ");
		}
		this.userDAO = userDAO;
	}

	/**
	 * This method is saves the User object
	 * 
	 * @param entity
	 *            as User object
	 * @param deleteIds
	 *            as String
	 * @return
	 * 
	 */
	public void save(User entity, String deleteIds) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		userDAO.save(entity, deleteIds);
	}


	/**
	 * This method is saves the User object
	 * 
	 * @param entity
	 *            as User object
	 * @return
	 * 
	 */
	public void save(User entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		userDAO.save(entity);
		
	}

	/**
	 * This method delete the user
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
		userDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id
	 *            as long
	 * @return a User Object
	 * 
	 */
	public User get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return userDAO.get(id);
	}

	/**
	 * This method returns User object for a given User Name
	 * 
	 * @param userName
	 *            as String
	 * @return User as model object
	 */
	public User get(String userName) {
		if (log.isDebugEnabled()) {
			log.debug("get with user name Method is called");
		}
		return userDAO.get(userName);
	}

	/**
	 * This method returns User object for a given Username & UserId
	 * 
	 * @param userName
	 *            as String
	 * @param userId
	 *            as long
	 * @return User as model object
	 */
	public User getByName(String userName, long userId) {
		if (log.isDebugEnabled()) {
			log.debug("getByName Method is called on " + userName);
		}
		return userDAO.getByName(userName, userId);
	}

	/**
	 * This method will return a list of all User from the database
	 * 
	 * @return List of User
	 */
	public List<User> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return userDAO.getAll();
	}

	/**
	 * This method returns list of the User objects available based page number.
	 * 
	 * @param long
	 *            PageNumber
	 * @param String
	 *            orderBy
	 * @param String
	 *            sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<User> getUserList(long pageNumber, String orderBy, String sortBy) {

		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return userDAO.getUserList(pageNumber, orderBy, sortBy);
	}

	/**
	 * This method returns list of the User objects available based page number.
	 * 
	 * @param UserSearch
	 *            searchOptions
	 * @return List
	 * @exception Exception
	 */
	public List<User> getUserByType(UserSearch searchOptions) {
		if (log.isDebugEnabled()) {
			log.debug("getUserByType Method is called");
		}

		return userDAO.getUserByType(searchOptions);
	}

	/**
	 * This method returns count of the User objects available based on search
	 * criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getUserCount() {
		if (log.isDebugEnabled()) {
			log.debug("getUserCount Method is called");
		}
		return userDAO.getUserCount();
	}

	/**
	 * This method returns count of the User objects from the database
	 * 
	 * @param UserSearch
	 *            searchOptions
	 * @return long
	 * @exception Exception
	 */
	public long getUserCountBySearchOption(UserSearch searchOptions) {
		if (log.isDebugEnabled()) {
			log.debug("getUserCountBySearchOption Method is called");
		}

		return userDAO.getUserCountBySearchOption(searchOptions);
	}

	/**
	 * This method save/updates a list of User information to the database.
	 * 
	 * @param listUser
	 *            as List
	 * 
	 */
	public void saveAll(List<User> listUser) {
		if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		userDAO.saveAll(listUser);
	}

	/**
	 * This method is used to delete a list of Module records from the database.
	 * 
	 * @param listUser
	 *            as List
	 */
	public void deleteAll(List<User> listUser) {
		if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		userDAO.deleteAll(listUser);
	}

	/**
	 * This method returns list of the User objects available based page number.
	 * 
	 * @param roleName
	 *            as String
	 * @param OfficeId
	 *            as long
	 * @param userId
	 *            as long
	 * @return List
	 * @exception Exception
	 */
	public List<User> getUsersListByRoleName(String roleName, long OfficeId, long userId) {
		if (log.isDebugEnabled()) {
			log.debug("getUsersListByRoleName Method is called");
		}
		return userDAO.getUsersListByRoleName(roleName, OfficeId, userId);
	}

	/**
	 * This method returns User object for a Employee
	 * 
	 * @param employeeId
	 * @return
	 */
	public User getUserByEmployeeId(long employeeId) {
		if (log.isDebugEnabled()) {
			log.debug("getUserByEmployeeId Method is called");
		}
		return userDAO.getUserByEmployeeId(employeeId);
	}
	
	
	public List<User> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return userDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Grievance objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<User> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return userDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
	}
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return userDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	

	public List<User> findByProperty(String propertyName, Object value) 
	{
		if (log.isDebugEnabled()) 
		{
			log.debug("findByProperty Method is called");
		}
		return userDAO.findByProperty(propertyName,value);
	}

	public List<User> findByCondition(String condition)
	{
		if (log.isDebugEnabled()) 
		{
			log.debug("findByCondition Method is called");
		}
		return userDAO.findByCondition(condition);
		
	}	
	 public User merge(User user){
 		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return userDAO.merge(user);
	}

	 public long saveToDb(String a){
		 if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return userDAO.saveToDb(a);
	 }

	@Override
	public List<User> getUserListForWorkFlow(UserSearch searchOptions) {
		if (log.isDebugEnabled()) {
			log.debug("getUserListForWorkFlow Method is called");
		}

		return userDAO.getUserListForWorkFlow(searchOptions);
	}
	
	
	 @Override
		public List<User> getUserByApplication(int applicationId) {
			if (log.isDebugEnabled()) {
				log.debug("getUserByApplication Method is called");
			}

			return userDAO.getUserByApplication(applicationId);
		}
}
