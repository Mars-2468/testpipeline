package com.mars.common.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.User;
import com.mars.common.search.UserSearch;

/**
 * <p>Title: UserDAO.java </p>

 * <p>Description: This interface is used for hibernate operations for User</p>

 * @see com.mars.common.model.User
 
 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 * 
 */

public interface UserDAO
{

    /**
     * This method returns User object for a given Id
     * 
     * @param id as long
     * @return User as model object
     */
    public User get(long id);

    /**
     * This method returns User object for a given User Name
     * 
     * @param userName as String
     * @return User as model object
     */
    public User get(String userName);
    
    /**
     * This method returns User object for a given Username & UserId
     * 
     * @param userName as String
     * @param userId as long
     * @return User as model object
     */
    public User getByName(String userName, long userId);

    /**
     * This method save/updates the User information to the database.
     * 
     * @param User object
     * @param deleteIds as String
     * @return
     * 
     */
    public void save(User entity, String deleteIds);

    //Keeping it , as it is used in AuthenticationController for ChnagePassword
    /**
     * This method save/updates the User information to the database.
     * 
     * @param User object
     * @return
     * 
     */
    public void save(User entity);

    /**
     * This method delete User for a given Id
     * 
     * @param id as long
     * 
     */
    public void delete(long id);

    /**
     * This method will return a list of all User from the database
     * 
     * @return List of User
     */
    public List<User> getAll();

    /**
     * This method save/updates a list of User information to the database.
     * 
     * @param listUser as List
     * 
     */
    public void saveAll(List<User> listUser);

    /**
     * This method is used to delete a list of User records from the database.
     * 
     * @param listUser as List
     */
    public void deleteAll(List<User> listUser);

    /**
     * This method returns list of the User objects available based page number.
     * 
     * @param long PageNumber
     * @param String orderBy
     * @param String sortBy
     * @return List
     * @exception Exception
     */
    public List<User> getUserList(long pageNumber, String orderBy, String sortBy);
    
    /**
     * This method returns list of the User objects available based page number.
     * 
     * @param UserSearch searchOptions
     * @return List
     * @exception Exception
     */
    public List<User> getUserByType(UserSearch searchOptions);

    /**
     * This method returns count of the User objects from the database
     * 
     * @return long
     * @exception Exception
     */
    public long getUserCount();
    
    /**
     * This method returns count of the User objects from the database
     * 
     * @param UserSearch searchOptions
     * @return long
     * @exception Exception
     */
    public long getUserCountBySearchOption(UserSearch searchOptions);
    
    /**
     * This method returns list of the User objects available based page number.
     * @param roleName as String
     * @param OfficeId as long 
     * @param userId as long
     * @return List
     * @exception Exception
     */
    public List<User> getUsersListByRoleName(String roleName, long OfficeId,long userId);
    
    /**
     * This method returns User object for a Employee
     * 
     * @param employeeId
     * @return
     */
	public User getUserByEmployeeId(long employeeId);
	
	 /**
	 * This method returns list of Grievance objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<User> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Grievance objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<User> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    public List<User> findByProperty(String propertyName, Object value);	    
    
    public List<User> findByCondition(String condition);
    
    public User merge(User user);  
   
    public long saveToDb(String a);
    
    public List<User> getUserListForWorkFlow(UserSearch searchOptions);
    
    public List<User> getUserByApplication(int applicationId);
}
