package com.mars.common.dao.impl;


import java.util.ArrayList;
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

import com.mars.common.dao.DepartmentDAO;
import com.mars.common.model.Department;
import com.mars.common.search.DepartmentSearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: DepartmentDaoImpl.java </p>

 * @see com.mars.common.model.Department
 
 * <p>Description: This class is used for hibernate operations for Department module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
 @Repository("DepartmentDAO")
public class DepartmentDAOImpl extends HibernateDaoSupport implements DepartmentDAO {

    private static final Log log = LogFactory.getLog(DepartmentDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns Department object for a given Id
	 * 
	 * @param id as long
	 * @return Department as model object
	 */
	public Department get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (Department) getHibernateTemplate().get(Department.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the Department information to the database.
	 * 
	 * @param Department object
	 * 
	 */
	public void save(Department entity) {
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
	 * This method to merge the Department information to the database.
	 * 
	 * @param Department object
	 * 
	 */
    public Department merge(Department entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (Department) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting Department instance");
        	}
        	Department entity = (Department) getHibernateTemplate().load(Department.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all Department from the database
	 * 
	 * @return List of Department
	 */
	public List<Department> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for Department");
			}
			return getHibernateTemplate().loadAll(Department.class);
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
     * @param listDepartment as List
     */
    public void deleteAll(List<Department> listDepartment)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for Department");
	    	}
	    	getHibernateTemplate().deleteAll(listDepartment);
	    	log.debug("deleted successfuly a list of Department records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of Department information to the database.
     * 
     * @param listDepartment as List
     * 
     */
    public void saveAll(List<Department> listDepartment)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listDepartment);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
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
	public List<Department> getDepartmentList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select department from Department department";
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
			List<Department> list = query.list();
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
	 * This method returns list of the Department objects available based on Search.
	 * 
	 * @param Departmentsearch searchDepartment
	 * @return List
	 * @exception Exception
	 */
	public List<Department> getDepartmentListBySearch(DepartmentSearch searchDepartment){
		
		if (log.isDebugEnabled()) {
			log.debug("getDepartmentListBySearch Method is called");
		}

		try {
			long pageNumber = searchDepartment.getCurrentPage();
			String orderBy = searchDepartment.getOrderBy();
			String sortBy = searchDepartment.getSortBy();

			String name = CommonUtils.getEscapedSQLString(searchDepartment.getName());
			String status = searchDepartment.getStatus();
			StringBuffer sql = new StringBuffer();
			String fromClause = "select department from Department department ";
			List<Department> list = null;
			boolean flag = false;
			
			if (name != null && name.length() > 0) {
				if (!flag) {
					flag=true;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("upper(department.name) like upper('%" + name + "%') ");
				
			}
			
			if (status != null ) {
				if (!flag) {
					flag=true;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append(" department.status="+status+" ");
				
			}
			
			sql.insert(0, fromClause).append("order by " + orderBy + " " + sortBy);

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
			log.error(nullpointerexception.getStackTrace());
			nullpointerexception.printStackTrace();
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
		
	}
	
	/**
	 * This method returns count of the Department objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getDepartmentCount(){
	    try {
			String fromClause = "select count(*) from Department department";
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
	 * This method returns count of the Department objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getDepartmentCountBySearch(DepartmentSearch searchDepartment){
		if (log.isDebugEnabled()) {
			log.debug("getApplicationCountBySearch Method is called");
		}
		
		try {
			long pageNumber = searchDepartment.getCurrentPage();
			String orderBy = searchDepartment.getOrderBy();
			String sortBy = searchDepartment.getSortBy();

			String name = CommonUtils.getEscapedSQLString(searchDepartment.getName());
			String status = searchDepartment.getStatus();
			
			//int count = 0;
			StringBuffer sql = new StringBuffer();
			String fromClause = "select count(department) from Department department ";
			List list = null;
			boolean flag = false;
			
			if (name != null && name.length() > 0) {
				if (!flag) {
					flag=true;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("upper(department.name) like upper('%" + name + "%') ");
			}
			
			
			if (status != null ) {
				if (!flag) {
					flag=true;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append(" department.status="+status+" ");
				
			}
			
			sql.insert(0, fromClause);
			Query query = getSession().createQuery(sql.toString());
			list = query.list();
			
			if (list != null && list.size() > 0)
				return Long.parseLong(list.get(0).toString());
			else
				return 0;
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			exception.printStackTrace();
			throw new RuntimeException(exception.getCause());
		}		
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
		try 
	  	{
		    Query queryObject = getSession().getNamedQuery(namedQuery);
			if(hstKeyValues!=null && hstKeyValues.size()>0)
			{
				Enumeration<String> enumeration = hstKeyValues.keys();
				while(enumeration.hasMoreElements())
				{
				    String strKey = enumeration.nextElement();
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
	 * This method returns list of Department objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Department> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(Department.class);
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
	 * This method returns list of Department objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Department> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding Department instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select department from Department department where department."+ propertyName + "= ?";
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
	 * This method returns Department object for a given data
	 * 
	 * @param Department as department
	 * @return Department as model object
	 */
	public Department checkForDuplicates(Department department)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select department from Department department where " ;

			if(department.getDepartmentId() > 0)		
				fromClause = fromClause +" departmentId <> "+department.getDepartmentId()+" and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" department.{Many-to-one}.{Many-to-one}Id = "+department.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			fromClause = fromClause +" (upper(name) = upper('"+ CommonUtils.getEscapedSQLString(department.getName()) +"')) " ;
		
			Query query = getSession().createQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (Department) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
	
}

