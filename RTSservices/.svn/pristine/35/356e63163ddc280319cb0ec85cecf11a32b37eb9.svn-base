package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.EmployeeDAO;
import com.mars.common.model.Employee;
import com.mars.common.search.EmployeeSearch;
import com.mars.common.service.EmployeeService;
 /**

 * <p>Title: EmployeeServiceImpl.java </p>

 * @see com.mars.common.model.Employee
 
 * <p>Description: This class is used for hibernate operations for Employee module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("employeeService") 
public class EmployeeServiceImpl implements EmployeeService {

    private static final Log log = LogFactory.getLog(EmployeeServiceImpl.class);

  	
	@Autowired
	private EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setEmployeeDAO Method is called ");
		}
		this.employeeDAO = employeeDAO;
	}

	/**
	 * This method is saves the Employee object
	 * 
	 * @param entity as Employee object
	 * @return
	 * 
	 */
	public void save(Employee entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		employeeDAO.save(entity);
	}

     /**
	 * This method to merge the Employee information to the database.
	 * 
	 * @param Employee object
	 * 
	 */
    public Employee merge(Employee entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return employeeDAO.merge(entity);
	}

	/**
	 * This method delete the employee
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		employeeDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Employee Object
	 * 
	 */
	public Employee get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return employeeDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Employee from the database
	 * 
	 * @return List of Employee
	 */
	public List<Employee> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return employeeDAO.getAll();
	}
	
		/**
		 * This method returns list of the Employee objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Employee> getEmployeeList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getEmployeeList Method is called");
			}
			return employeeDAO.getEmployeeList(pageNumber,orderBy,sortBy);
		}
		
		
		public List<Employee> getEmployeeByType(EmployeeSearch searchOptions) {
			if (log.isDebugEnabled()) {
				log.debug("getUserByType Method is called");
			}

			return employeeDAO.getEmployeeByType(searchOptions);
		}

		
		
		
		/**
		 * This method returns count of the Employee objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getEmployeeCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getEmployeeCount Method is called");
			}
			return employeeDAO.getEmployeeCount();
		}	
	
	
		public long getEmployeeCountBySearchOption(EmployeeSearch searchOptions) {
			if (log.isDebugEnabled()) {
				log.debug("getUserCountBySearchOption Method is called");
			}

			return employeeDAO.getEmployeeCountBySearchOption(searchOptions);
		}

		
		
	/**
     * This method save/updates a list of Employee information to the database.
     * 
     * @param listEmployee as List
     * 
     */
    public void saveAll(List<Employee> listEmployee){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		employeeDAO.saveAll(listEmployee);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listEmployee as List
     */
    public void deleteAll(List<Employee> listEmployee){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		employeeDAO.deleteAll(listEmployee);
    }
    
    /**
	 * This method returns list of Employee objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Employee> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return employeeDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Employee object for a given data
	 * 
	 * @param Employee as employee
	 * @return Employee as model object
	 */
	public Employee checkForDuplicates(Employee employee)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return employeeDAO.checkForDuplicates(employee);
		
	}
	
	    /**
	 * This method returns list of Employee objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Employee> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return employeeDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Employee objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Employee> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return employeeDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return employeeDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}

	/**
	 * This method will return a list of all Employees Who doesn't have User
	 * 
	 * @return List of Employee
	 */
	public List<Employee> getAllWithoutUser() {
		if (log.isDebugEnabled()) {
			log.debug("getAllWithoutUser Method is called");
		}
		return employeeDAO.getAllWithoutUser();
	}

	
}

