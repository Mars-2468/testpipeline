package com.mars.common.service.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.DepartmentDAO;
import com.mars.common.model.Department;
import com.mars.common.search.DepartmentSearch;
import com.mars.common.service.DepartmentService;
 /**

 * <p>Title: DepartmentServiceImpl.java </p>

 * @see com.mars.common.model.Department
 
 * <p>Description: This class is used for hibernate operations for Department module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd>
 
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    private static final Log log = LogFactory.getLog(DepartmentServiceImpl.class);

  	
	@Autowired
	private DepartmentDAO departmentDAO;

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		if (log.isDebugEnabled()) {
			log.debug("setDepartmentDAO Method is called ");
		}
		this.departmentDAO = departmentDAO;
	}

	/**
	 * This method is saves the Department object
	 * 
	 * @param entity as Department object
	 * @return
	 * 
	 */
	public void save(Department entity) {
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		departmentDAO.save(entity);
	}

     /**
	 * This method to merge the Department information to the database.
	 * 
	 * @param Department object
	 * 
	 */
    public Department merge(Department entity){
    		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return departmentDAO.merge(entity);
	}

	/**
	 * This method delete the department
	 * 
	 * @param Id as long
	 * @return
	 * 
	 */
	public void delete(long id) {
		if (log.isDebugEnabled()) {
			log.debug("delete Method is called ");
		}
		departmentDAO.delete(id);
	}

	/**
	 * This method is used to get the Model object from the database using
	 * hibernate based on id
	 * 
	 * @param Id as long
	 * @return a Department Object
	 * 
	 */
	public Department get(long id) {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called");
		}
		return departmentDAO.get(id);
	}
	
	/**
	 * This method will return a list of all Department from the database
	 * 
	 * @return List of Department
	 */
	public List<Department> getAll() {
		if (log.isDebugEnabled()) {
			log.debug("getAll Method is called");
		}
		return departmentDAO.getAll();
	}
	
		/**
		 * This method returns list of the Department objects available based page number.
		 * 
		 * @param long PageNumber
		 * @param String orderBy
		 * @param String sortBy
		 * @return List
		 * @exception Exception
		 */
		public List<Department> getDepartmentList(long pageNumber,String orderBy, String sortBy){
		
			if (log.isDebugEnabled()) {
				log.debug("getDepartmentList Method is called");
			}
			return departmentDAO.getDepartmentList(pageNumber,orderBy,sortBy);
		}
		
		
		/**
		 * 
		 * @param searchOptions
		 * @return
		 */
			public List<Department> getDepartmentListBySearch(DepartmentSearch searchDepartment){

			if (log.isDebugEnabled()) {
				log.debug("getApplicationListBySearch Method is called");
			}
			return departmentDAO.getDepartmentListBySearch(searchDepartment);
			
		}
		
		/**
		 * This method returns count of the Department objects available based on search criteria.
		 * 
		 * @return long
		 * @exception Exception
		 */
		public long getDepartmentCount(){
		    if (log.isDebugEnabled()) {
				log.debug("getDepartmentCount Method is called");
			}
			return departmentDAO.getDepartmentCount();
		}	
	
	
	/**
     * This method save/updates a list of Department information to the database.
     * 
     * @param listDepartment as List
     * 
     */
    public void saveAll(List<Department> listDepartment){
    	if (log.isDebugEnabled()) {
			log.debug("saveAll Method is called");
		}
		departmentDAO.saveAll(listDepartment);
    }
    
    
    /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listDepartment as List
     */
    public void deleteAll(List<Department> listDepartment){
        if (log.isDebugEnabled()) {
			log.debug("deleteAll Method is called");
		}
		departmentDAO.deleteAll(listDepartment);
    }
    
    /**
	 * This method returns list of Department objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Department> findByProperty(String propertyName, Object value) 
    {
    	if (log.isDebugEnabled()) 
    	{
			log.debug("findByProperty Method is called");
		}
		return departmentDAO.findByProperty(propertyName,value);
    }
	/**
	 * This method returns Department object for a given data
	 * 
	 * @param Department as department
	 * @return Department as model object
	 */
	public Department checkForDuplicates(Department department)
	{
    	if (log.isDebugEnabled()) 
    	{
			log.debug("checkForDuplicates Method is called");
		}
		return departmentDAO.checkForDuplicates(department);
		
	}
	
	    /**
	 * This method returns list of Department objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Department> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getListByNamedQuery Method is called");
		}
		return departmentDAO.getListByNamedQuery(namedQuery,hstKeyValues);
	}


    /**
	 * This method returns list of Department objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Department> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		if (log.isDebugEnabled()) 
    	{
			log.debug("getEntitytListBySQLQuery Method is called");
		}
		return departmentDAO.getEntityListBySQLQuery(strSql,hstDataTypes);
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
		return departmentDAO.getListBySQLQuery(strSql,hstDataTypes);
		
	}	
	
	public Long getDepartmentCountBySearch(DepartmentSearch searchDepartment) {
		if (log.isDebugEnabled()) 
    	{
			log.debug("getApplicationCountBySearch Method is called");
		}
		return departmentDAO.getDepartmentCountBySearch(searchDepartment);
	}	
}

