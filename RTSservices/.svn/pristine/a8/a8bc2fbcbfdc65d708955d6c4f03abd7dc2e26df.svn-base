package com.mars.common.service;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.Department;
import com.mars.common.search.DepartmentSearch;
/**
* <p>Title: DepartmentService.java </p>

 * <p>Description: This interface is used for service implementations related to Department</p>

 * @see com.mars.common.model.Department
 
 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Transactional(readOnly = true)
public interface DepartmentService {
  
	/**
	 * This method returns Department object for a given Id
	 * 
	 * @param id as long
	 * @return Department as model object
	 */
	public Department get(long id);
		
    /**
	 * This method save/updates the Department information to the database.
	 * 
	 * @param Department object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(Department entity);
	  
	/**
	 * This method to merge the Department information to the database.
	 * 
	 * @param Department object
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public Department merge(Department entity); 
	    
    /**
	 * This method delete Department for a given Id
	 * 
	 * @param id as long
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void delete(long id) ;
	
	/**
	 * This method will return a list of all Department from the database
	 * 
	 * @return List of Department
	 */
	public List<Department> getAll();
	
	/**
     * This method save/updates a list of Department information to the database.
     * 
     * @param listDepartment as List
     * 
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveAll(List<Department> listDepartment);
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listDepartment as List
     */
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void deleteAll(List<Department> listDepartment);
    
	    /**
		 * This method returns list of the Department objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Department> getDepartmentList(long pageNumber,String orderBy, String sortBy);
		
		
		
		
		
		/**
		 * This method returns list of the Department objects available based on Search.
		 * 
		 * @param DepartmentSearch searchDepartment
		 * @return List
		 */
		public List<Department> getDepartmentListBySearch(DepartmentSearch searchDepartment); 
		
		
		
		/**
		 * This method returns count of the Department objects from the database
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getDepartmentCount();
	
		
		public Long getDepartmentCountBySearch(DepartmentSearch searchDepartment);

		
	
	/**
	 * This method returns list of Department objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
    public List<Department> findByProperty(String propertyName, Object value);	    

	/**
	 * This method returns Department object for a given data
	 * 
	 * @param Department as department
	 * @return Department as model object
	 */
	public Department checkForDuplicates(Department department);    

    /**
	 * This method returns list of Department objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Department> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues);	

    /**
	 * This method returns list of Department objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Department> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);
	
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes);	
}

