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

import com.mars.common.dao.UserApplicationDAO;
import com.mars.common.model.UserApplication;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: UserApplicationDAOImpl.java </p>

 * @see com.mars.common.model.UserApplication
 
 * <p>Description: This class is used for hibernate operations for UserApplication module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("UserApplicationDAO") 
public class UserApplicationDAOImpl extends HibernateDaoSupport implements UserApplicationDAO {

    private static final Log log = LogFactory.getLog(UserApplicationDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns UserApplication object for a given Id
	 * 
	 * @param id as long
	 * @return UserApplication as model object
	 */
	public UserApplication get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (UserApplication) getHibernateTemplate().get(UserApplication.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the UserApplication information to the database.
	 * 
	 * @param UserApplication object
	 * 
	 */
	public void save(UserApplication entity) {
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
	 * This method to merge the UserApplication information to the database.
	 * 
	 * @param UserApplication object
	 * 
	 */
    public UserApplication merge(UserApplication entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (UserApplication) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting UserApplication instance");
        	}
        	UserApplication entity = (UserApplication) getHibernateTemplate().load(UserApplication.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all UserApplication from the database
	 * 
	 * @return List of UserApplication
	 */
	public List<UserApplication> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for UserApplication");
			}
			return getHibernateTemplate().loadAll(UserApplication.class);
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
     * @param listUserApplication as List
     */
    public void deleteAll(List<UserApplication> listUserApplication)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for UserApplication");
	    	}
	    	getHibernateTemplate().deleteAll(listUserApplication);
	    	log.debug("deleted successfuly a list of UserApplication records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of UserApplication information to the database.
     * 
     * @param listUserApplication as List
     * 
     */
    public void saveAll(List<UserApplication> listUserApplication)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listUserApplication);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the UserApplication objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<UserApplication> getUserApplicationList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select userApplication from UserApplication userApplication";
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
			List<UserApplication> list = query.list();
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
	 * This method returns count of the UserApplication objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getUserApplicationCount(){
	    try {
			String fromClause = "select count(*) from UserApplication userApplication";
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
	 * This method returns list of UserApplication objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<UserApplication> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	 * This method returns list of UserApplication objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<UserApplication> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(UserApplication.class);
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
	 * This method returns list of UserApplication objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<UserApplication> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding UserApplication instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select userApplication from UserApplication userApplication where userApplication."+ propertyName + "= ?";
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
	 * This method returns UserApplication object for a given data
	 * 
	 * @param UserApplication as userApplication
	 * @return UserApplication as model object
	 */
	public UserApplication checkForDuplicates(UserApplication userApplication)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select userApplication from UserApplication userApplication where " ;

			if(userApplication.getUserApplicationId() > 0)		
				fromClause = fromClause +" userApplicationId <> "+userApplication.getUserApplicationId()+" and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" userApplication.{Many-to-one}.{Many-to-one}Id = "+userApplication.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			//fromClause = fromClause +" (upper(name) = upper('"+ CommonUtils.getEscapedSQLString(userApplication.getName()) +"')) " ;
		
			Query query = getSession().createQuery(fromClause);		
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (UserApplication) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
	public List<UserApplication> getUserApplicationForUser(long userId)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "getUserApplicationForUser Method is called" );
		}
		try {
			String fromClause = "select userApplication from UserApplication userApplication  " ;
			if(userId>0)
				fromClause = fromClause+" where user.userId ="+userId;
			Query query = getSession().createQuery(fromClause);
			List<UserApplication> list = query.list();
			
				return list;
			
			
		}catch (NullPointerException nullpointerexception)
		{
		    log.error(nullpointerexception.getStackTrace());
		    throw new NullPointerException();
		} catch (HibernateException hibernateException)
		{
		    log.error(hibernateException.getStackTrace());
		    throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception)
		{
		    log.error(exception.getStackTrace());
		    throw new RuntimeException(exception.getCause());
		}
	}
	
	public void deleteByUserId(long userId,String applicationIds)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "deleteByUserId Method is called" );
		}
		try {
			String fromClause = "delete from UserApplication userApplication where userApplication.user.userId="+userId;
			if(applicationIds != null && applicationIds.length() > 0)
				fromClause = fromClause +" and userApplication.application.applicationId not in ("+applicationIds+")";

			Query query = getSession().createQuery(fromClause);		
			int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
			
		}catch (Exception exception) {
			log.error(exception.getStackTrace(),exception);
			exception.printStackTrace();
		}
	}
}


