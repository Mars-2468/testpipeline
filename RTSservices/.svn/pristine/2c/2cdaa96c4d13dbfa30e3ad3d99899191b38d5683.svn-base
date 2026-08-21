package com.mars.common.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.Employee;
import com.mars.common.search.EmployeeSearch;
/**
* <p>Title: EmployeeService.java </p>

 * <p>Description: This interface is used for service implementations related to Employee</p>

 * @see com.mars.common.model.Employee
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface EmployeeService {
  
	/**
	 * This method returns Employee object for a given Id
	 * 
	 * @param id as long
	 * @return Employee as model object
	 */
	public Employee get(long id);
		
    /**
	 * This method save/updates the Employee information to the database.
	 * 
	 * @param Employee object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(Employee entity);
	  
	/**
	 * This method to merge the Employee information to the database.
	 * 
	 * @param Employee object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public Employee merge(Employee entity); 
	    
    /**
	 * This method delete Employee for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Employee from the database
	 * 
	 * @return List of Employee
	 */
	public List<Employee> getAll();
	
	/**
     * This method save/updates a list of Employee information to the database.
     * 
     * @param listEmployee as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Employee> listEmployee);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listEmployee as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Employee> listEmployee);
    
	    /**
		 * This method returns list of the Employee objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Employee> getEmployeeList(long pageNumber,String orderBy, String sortBy);
		
		
	    public List<Employee> getEmployeeByType(EmployeeSearch searchOptions);

		
		/**
		 * This method returns count of the Employee objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getEmployeeCount();
	
	
	    public long getEmployeeCountBySearchOption(EmployeeSearch searchOptions);

		
	/**
	 * This method returns list of Employee objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Employee> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns Employee object for a given data
	 * 
	 * @param Employee as employee
	 * @return Employee as model object
	 */
	public Employee checkForDuplicates(Employee employee);    

    /**
	 * This method returns list of Employee objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Employee> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Employee objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Employee> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);

	/**
	 * This method will return a list of all Employees Who doesn't have User
	 * 
	 * @return List of Employee
	 */
	public List<Employee> getAllWithoutUser();	
}

