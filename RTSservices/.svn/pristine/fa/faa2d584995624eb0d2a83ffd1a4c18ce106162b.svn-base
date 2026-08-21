package com.mars.common.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;

import com.mars.common.model.UserAttempts;



public interface UserAttemptsDAO {
	/**
     * This method returns UserAttempts object for a given Id
     * 
     * @param id as long
     * @return UserAttempts as model object
     */
    public UserAttempts get(long id);
    
    public UserAttempts getByUserName(String  userName);

    /**
     * This method returns UserAttempts object for a given UserAttempts Name
     * 
     * @param userAttemptsName as String
     * @return UserAttempts as model object
     */
    public UserAttempts get(String userAttemptsName);
    
    /**
     * This method returns UserAttempts object for a given UserAttemptsname & UserAttemptsId
     * 
     * @param userAttemptsName as String
     * @param userAttemptsId as long
     * @return UserAttempts as model object
     */
    public UserAttempts getByName(String userAttemptsName, long userAttemptsId);

    /**
     * This method save/updates the UserAttempts information to the database.
     * 
     * @param UserAttempts object
     * @param deleteIds as String
     * @return
     * 
     */
      public void save(UserAttempts entity);

    /**
     * This method delete UserAttempts for a given Id
     * 
     * @param id as long
     * 
     */
    public void delete(long id);
    
    public void delete(UserAttempts userAttempts);

    /**
     * This method will return a list of all UserAttempts from the database
     * 
     * @return List of UserAttempts
     */
    public List<UserAttempts> getAll();

    /**
     * This method save/updates a list of UserAttempts information to the database.
     * 
     * @param listUserAttempts as List
     * 
     */
    public void saveAll(List<UserAttempts> listUserAttempts);

    /**
     * This method is used to delete a list of UserAttempts records from the database.
     * 
     * @param listUserAttempts as List
     */
    public void deleteAll(List<UserAttempts> listUserAttempts);

    /**
     * This method returns list of the UserAttempts objects available based page number.
     * 
     * @param long PageNumber
     * @param String orderBy
     * @param String sortBy
     * @return List
     * @exception Exception
     */
    public List<UserAttempts> getUserAttemptsList(long pageNumber, String orderBy, String sortBy);
    
        /**
     * This method returns count of the UserAttempts objects from the database
     * 
     * @return long
     * @exception Exception
     */
    public long getUserAttemptsCount();
    
 
  
    
  
	public List<UserAttempts> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Grievance objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<UserAttempts> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    public List<UserAttempts> findByProperty(String propertyName, Object value);	    
    
    public List<UserAttempts> findByCondition(String condition);
    
    public UserAttempts merge(UserAttempts userAttempts);  
   

}
