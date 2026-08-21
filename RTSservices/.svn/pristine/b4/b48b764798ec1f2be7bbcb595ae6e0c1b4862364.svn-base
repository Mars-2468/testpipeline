package com.mars.common.dao.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.EmployeeDAO;
import com.mars.common.model.Employee;
import com.mars.common.search.EmployeeSearch;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: EmployeeDaoImpl.java </p>

 * @see com.mars.common.model.Employee
 
 * <p>Description: This class is used for hibernate operations for Employee module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("EmployeeDAO") 
public class EmployeeDAOImpl extends HibernateDaoSupport implements EmployeeDAO {

    private static final Log log = LogFactory.getLog(EmployeeDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
  
	/**
	 * This method returns Employee object for a given Id
	 * 
	 * @param id as long
	 * @return Employee as model object
	 */
	public Employee get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (Employee) getHibernateTemplate().get(Employee.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the Employee information to the database.
	 * 
	 * @param Employee object
	 * 
	 */
	public void save(Employee entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
	}
    
     /**
	 * This method to merge the Employee information to the database.
	 * 
	 * @param Employee object
	 * 
	 */
    public Employee merge(Employee entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (Employee) getHibernateTemplate().merge(entity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
  }
    
    /**
	 * This method is used to delete a record from the database using hibernate.
	 * 
	 * @param id as long
	 */
    public void delete(long id) {
        try {
    		if(log.isDebugEnabled()){
        		log.debug("deleting Employee instance");
        	}
        	Employee entity = (Employee) getHibernateTemplate().load(Employee.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all Employee from the database
	 * 
	 * @return List of Employee
	 */
	public List<Employee> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for Employee");
			}
			return getHibernateTemplate().loadAll(Employee.class);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
     /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listEmployee as List
     */
    public void deleteAll(List<Employee> listEmployee)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for Employee");
	    	}
	    	getHibernateTemplate().deleteAll(listEmployee);
	    	log.debug("deleted successfuly a list of Employee records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of Employee information to the database.
     * 
     * @param listEmployee as List
     * 
     */
    public void saveAll(List<Employee> listEmployee)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listEmployee);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
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
	public List<Employee> getEmployeeList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select employee from Employee employee";
			fromClause = fromClause+ " order by "+ orderBy +" "+sortBy;
			Query query = getSession().createQuery(fromClause);
			
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber-1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}
			List<Employee> list = query.list();
			if (list != null && list.size() > 0) {
				return list;
			}
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * This method returns count of the Employee objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getEmployeeCount(){
	    try {
			String fromClause = "select count(*) from Employee employee";
			Query query = getSession().createQuery(fromClause);
			List list = query.list();
			
			if (list != null && list.size() > 0) {
				return Long.parseLong(list.get(0).toString());
			}
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return 0;
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
		try 
	  	{
		    Query queryObject = getSession().getNamedQuery(namedQuery);
			if(hstKeyValues!=null && hstKeyValues.size()>0)
			{
				Enumeration<String> enumeration = hstKeyValues.keys();
				while(enumeration.hasMoreElements())
				{
				    String strKey = enumeration.nextElement();
				    if(hstKeyValues.get(strKey) instanceof Collection)
						queryObject.setParameterList(strKey,(Collection)hstKeyValues.get(strKey));
				    else 
				    	queryObject.setParameter(strKey,hstKeyValues.get(strKey));
				}
			}
	   		return queryObject.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
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
		try{
			if (log.isDebugEnabled())
			{
		    	log.debug("getEntitytListBySQLQuery Method is called ");
			}
			SQLQuery query = getSession().createSQLQuery(strSql);
			if (hstDataTypes != null && hstDataTypes.size() > 0)
			{
		    	Enumeration<String> enumeration = hstDataTypes.keys();
		    	while (enumeration.hasMoreElements())
		    	{
					String strKey = enumeration.nextElement();
					query.addScalar(strKey, (NullableType) hstDataTypes.get(strKey));
		    	}
			}
			query.addEntity(Employee.class);
			return query.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
    }	
    
    /**
	 * This method returns list selected columns as list based on the SQL query and parameters.
	 * @param String SQL Query
	 * @return List
	 * @exception Exception
	 */
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
	{
		try{
			List<ArrayList> listContents = null;
			if (log.isDebugEnabled())
			{
		    	log.debug("getListBySQLQuery Method is called ");
			}
			SQLQuery query = getSession().createSQLQuery(strSql);
			if (hstDataTypes != null && hstDataTypes.size() > 0)
			{
		    	Enumeration<String> enumeration = hstDataTypes.keys();
		    	while (enumeration.hasMoreElements())
		    	{
					String strKey = enumeration.nextElement();
					query.addScalar(strKey, (NullableType) hstDataTypes.get(strKey));
		    	}
			}
			List listQueryData = query.list();
			
			if(listQueryData!=null && listQueryData.size()>0)
			{
				listContents = new ArrayList<ArrayList>();
				
				//Adding Columns Names to the list
				String strColumnNames[] = query.getReturnAliases();
				ArrayList<Object> listColumns = new ArrayList<Object>();
				for(int k=0;k<strColumnNames.length;k++)
				{
					listColumns.add(strColumnNames[k]);
				}
				listContents.add(listColumns);

				// Adding data to the list
				for(int i=0;i<listQueryData.size();i++)
				{
					ArrayList<Object> listData = new ArrayList<Object>();
					Object[] objectArray = (Object[])listQueryData.get(i);
					for(int j=0;j<objectArray.length;j++)
					{
						if(objectArray[j] instanceof Integer )
							listData.add(Integer.parseInt(objectArray[j].toString()));
						else if (objectArray[j] instanceof Long )
							listData.add(Long.parseLong(objectArray[j].toString()));
						else if(objectArray[j] instanceof Double )
							listData.add(Double.parseDouble(objectArray[j].toString()));
						else 
							listData.add(objectArray[j].toString());
							
						listContents.add(listData);
					}
				}
			}
			return listContents;
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
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
		try 
	  	{
		  	log.info("finding Employee instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select employee from Employee employee where employee."+ propertyName + "= ?";
		    Query queryObject = getSession().createQuery(queryString);
		    queryObject.setParameter(0, value);
	   		return queryObject.list();
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}	

	/**
	 * This method returns Employee object for a given data
	 * 
	 * @param Employee as employee
	 * @return Employee as model object
	 */
	public Employee checkForDuplicates(Employee employee)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select employee from Employee employee where " ;

			if(employee.getEmployeeId() > 0)		
				fromClause = fromClause +" employeeId <> "+employee.getEmployeeId()+" and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" employee.{Many-to-one}.{Many-to-one}Id = "+employee.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			//fromClause = fromClause +" (upper(name) = upper('"+ CommonUtils.getEscapedSQLString(employee.getName()) +"')) " ;
		
			Query query = getSession().createQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (Employee) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}

	/**
	 * This method will return a list of all Employees Who doesn't have User
	 * 
	 * @return List of Employee
	 */
	public List<Employee> getAllWithoutUser() {
		try {
			if (log.isDebugEnabled()) {

				log.debug("getAllWithoutUser Method is called for Employee");
			}

			String fromClause = "select employee from Employee employee where employee.employeeId not in " + 
			"(select user.employee.employeeId from User user) " + " order by upper(employee.firstName) ";

			Query query = getSession().createQuery(fromClause);

			List<Employee> list = query.list();

			if (list != null && list.size() > 0) {
				return list;
			}
			return null;

		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
	}

	
	
	
	
	public List<Employee> getEmployeeByType(EmployeeSearch searchOptions) {
		if (log.isDebugEnabled()) {
			log.debug("getEmployeeByType Method is called");
		}

		try {
			long pageNumber = searchOptions.getCurrentPage();
			String orderBy = searchOptions.getOrderBy();
			String sortBy = searchOptions.getSortBy();
			
			StringBuffer sql = getHqlQueryOnSearch(searchOptions);
			String fromClause = "select employee from Employee employee ";
			List<Employee> list = null;			

			sql.insert(0, fromClause).append(" order by " + orderBy + " " + sortBy);

			Query query = getSession().createQuery(sql.toString());

			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue()) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}

			list = query.list();

			return list;
		} catch (NullPointerException nullpointerexception) {
			nullpointerexception.printStackTrace();
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
	}

	
	
	
	public long getEmployeeCountBySearchOption(EmployeeSearch searchOptions) {
		if (log.isDebugEnabled()) {
			log.debug("getEmployeeCountBySearchOption Method is called");
		}

		try {
			StringBuffer sql = getHqlQueryOnSearch(searchOptions);
			String fromClause = "select count(*) from Employee employee ";
			List list = null;

			sql.insert(0, fromClause);
			Query query = getSession().createQuery(sql.toString());
			list = query.list();

			if (list != null && list.size() > 0)
				return Long.parseLong(list.get(0).toString());
			else
				return 0;
		} catch (NullPointerException nullpointerexception) {
			nullpointerexception.printStackTrace();
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
	}
	
	
	
	
	
	
private StringBuffer getHqlQueryOnSearch(EmployeeSearch searchOptions){
    	
		String firstName = searchOptions.getFirstName();
		String lastName = searchOptions.getLastName();
		long designationId = searchOptions.getDesignationId();
		long departmentId = searchOptions.getDepartmentId();
		//long applicationId = searchOptions.getApplicationId();

		StringBuffer sql = new StringBuffer();
		int count = 0;
		
		/*if (applicationId > 0) {
			count++;
			sql.append("inner join user.userApplicationSet userApplication where userApplication.application.applicationId=" + applicationId + " ");
		}*/


		if (firstName != null && firstName.length() > 0 && firstName!=" ") {
			if (count == 0) {
				count++;
				sql.append(" where ");
			} else
				sql.append(" and ");

			sql.append("upper(employee.firstName) like upper('%" + firstName + "%') ");
		}
		
		if (lastName != null && lastName.length() > 0) {
			if (count == 0) {
				count++;
				sql.append(" where ");
			} else
				sql.append(" and ");

			sql.append("upper(employee.lastName) like upper('%" + lastName + "%') ");
		}
	
		
		if (designationId > 0) {
			if (count == 0) {
				count++;
				sql.append(" where ");
			} else
				sql.append(" and ");

			sql.append("employee.designation.designationId=" + designationId + " ");
		}
		if (departmentId> 0) {
			if (count == 0) {
				count++;
				sql.append(" where ");
			} else
				sql.append(" and ");

			sql.append("employee.department.departmentId=" + departmentId + " ");
		}
		return sql;
    }
}

