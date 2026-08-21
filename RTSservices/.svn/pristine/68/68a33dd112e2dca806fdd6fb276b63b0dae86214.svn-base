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

import com.mars.common.dao.TenancyDAO;
import com.mars.common.model.Tenancy;
import com.mars.common.search.TenancySearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: TenancyDaoImpl.java </p>

 * @see com.mars.common.model.Tenancy
 
 * <p>Description: This class is used for hibernate operations for Tenancy module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
 @Repository("TenancyDAO")
public class TenancyDAOImpl extends HibernateDaoSupport implements TenancyDAO {

    private static final Log log = LogFactory.getLog(TenancyDAOImpl.class);
    
    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
  
	/**
	 * This method returns Tenancy object for a given Id
	 * 
	 * @param id as long
	 * @return Tenancy as model object
	 */
	public Tenancy get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			//return (Tenancy) getHibernateTemplate().get(Tenancy.class,new Integer((int) id));
			return (Tenancy) getHibernateTemplate().get(Tenancy.class,id);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
    
    
    /**
	 * This method save/updates the Tenancy information to the database.
	 * 
	 * @param Tenancy object
	 * 
	 */
	public void save(Tenancy entity) {
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
	 * This method to merge the Tenancy information to the database.
	 * 
	 * @param Tenancy object
	 * 
	 */
    public Tenancy merge(Tenancy entity) {
    	try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (Tenancy) getHibernateTemplate().merge(entity);
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
        		log.debug("deleting Tenancy instance");
        	}
        	Tenancy entity = (Tenancy) getHibernateTemplate().load(Tenancy.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
    
	/**
	 * This method will return a list of all Tenancy from the database
	 * 
	 * @return List of Tenancy
	 */
	public List<Tenancy> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for Tenancy");
			}
			return getHibernateTemplate().loadAll(Tenancy.class);
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
     * @param listTenancy as List
     */
    public void deleteAll(List<Tenancy> listTenancy)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for Tenancy");
	    	}
	    	getHibernateTemplate().deleteAll(listTenancy);
	    	log.debug("deleted successfuly a list of Tenancy records from database");
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }

    
    /**
     * This method save/updates a list of Tenancy information to the database.
     * 
     * @param listTenancy as List
     * 
     */
    public void saveAll(List<Tenancy> listTenancy)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listTenancy);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
    }
  
	/**
	 * This method returns list of the Tenancy objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<Tenancy> getTenancyList(long pageNumber,String orderBy, String sortBy)
	{
		try {
			String fromClause = "select tenancy from Tenancy tenancy";
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
			List<Tenancy> list = query.list();
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
	 * This method returns list of the Tenancy objects available based on Search.
	 * 
	 * @param Tenancysearch searchTenancy
	 * @return List
	 * @exception Exception
	 */
	public List<Tenancy> getTenancyListBySearch(TenancySearch searchTenancy){
		
		if (log.isDebugEnabled()) {
			log.debug("getTenancyListBySearch Method is called");
		}

		try {
			long pageNumber = searchTenancy.getCurrentPage();
			String orderBy = searchTenancy.getOrderBy();
			String sortBy = searchTenancy.getSortBy();

			String name = CommonUtils.getEscapedSQLString(searchTenancy.getName());
			String code = searchTenancy.getCode();
			String category = searchTenancy.getCategory();

			StringBuffer sql = new StringBuffer();
			String fromClause = "select tenancy from Tenancy tenancy ";
			List<Tenancy> list = null;
			boolean flag = false;
			
			if (name != null && name.length() > 0) {
				if (!flag) {
					flag=true;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("upper(tenancy.name) like :name  ");
			}
			
			if (code != null && code.length() > 0) {
				if (!flag) {
					flag=true;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("upper(tenancy.code) like :code  ");
			}
			
			if (category != null) {
				if (!flag) {
					flag=true;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("upper(tenancy.category) like :category ");
			}
			sql.insert(0, fromClause).append("order by " + orderBy + " " + sortBy);

			Query query = getSession().createQuery(sql.toString());
			if (name != null && name.length() > 0)
				query.setParameter("name", "%"+name.toUpperCase()+"%");
			if (code != null && code.length() > 0)
				query.setParameter("code", "%"+code.toUpperCase()+"%");
			if (category != null)
				query.setParameter("category", "%"+category.toUpperCase()+"%");
			
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
	 * This method returns count of the Tenancy objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getTenancyCount(){
	    try {
			String fromClause = "select count(*) from Tenancy tenancy";
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
	 * This method returns count of the Tenancy objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getTenancyCountBySearch(TenancySearch searchTenancy){
		if (log.isDebugEnabled()) {
			log.debug("getTenancyCountBySearch Method is called");
		}
		
		try {
			String name = CommonUtils.getEscapedSQLString(searchTenancy.getName());
			String code = searchTenancy.getCode();
			String category = searchTenancy.getCategory();

			StringBuffer sql = new StringBuffer();
			String fromClause = "select count(tenancy) from Tenancy tenancy ";
			List list = null;
			boolean flag = false;
			
			if (name != null && name.length() > 0) {
				if (!flag) {
					flag=true;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("upper(tenancy.name) like :name ");
			}
			
			if (code != null && code.length() > 0) {
				if (!flag) {
					flag=true;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("upper(tenancy.code) like :code ");
			}
			if (category != null) {
				if (!flag) {
					flag=true;
					sql.append("where ");
				} else
					sql.append("and ");

				sql.append("upper(tenancy.category) like :category ");
			}
			sql.insert(0, fromClause);
			Query query = getSession().createQuery(sql.toString());
			if (name != null && name.length() > 0)
				query.setParameter("name", "%"+name.toUpperCase()+"%");
			if (code != null && code.length() > 0)
				query.setParameter("code", "%"+code.toUpperCase()+"%");
			if (category != null)
				query.setParameter("category", "%"+category.toUpperCase()+"%");
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
	 * This method returns list of Tenancy objects available based on the query names passed.
	 * @param String namedQuery
	 * @param hstKeyValues as Hashatble containing the Parameter name as key and value.
	 * @return List
	 * @exception Exception
	 */
	public List<Tenancy> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) 
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
	 * This method returns list of Tenancy objects available based on the SQL query and parameters.
	 * @param String SQL Query
	 * @param hstDataTypes as Hashatble containing the Scalar Variable and Value
	 * @return List
	 * @exception Exception
	 */
	public List<Tenancy> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes)
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
			query.addEntity(Tenancy.class);
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
	 * This method returns list of Tenancy objects available based on the value for a particular property.
	 * @param String propertyName
	 * @param Object value
	 * @return List
	 * @exception Exception
	 */
	public List<Tenancy> findByProperty(String propertyName, Object value) 
    {
		try 
	  	{
		  	log.info("finding Tenancy instance with property: "+ propertyName + ", value: " + value);
			String queryString = "select tenancy from Tenancy tenancy where tenancy."+ propertyName + "= ?";
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
	 * This method returns Tenancy object for a given data
	 * 
	 * @param Tenancy as tenancy
	 * @return Tenancy as model object
	 */
	public Tenancy checkForDuplicates(Tenancy tenancy)
	{
		if( log.isDebugEnabled() ) {
			log.debug( "checkForDuplicates Method is called" );
		}
		try {
			String fromClause = "select tenancy from Tenancy tenancy where " ;

			if(tenancy.getTenancyId() > 0)		
				fromClause = fromClause +" tenancyId <> "+tenancy.getTenancyId()+" and ";
			
			//Sample Code update accordingly
			//fromClause = fromClause +" tenancy.{Many-to-one}.{Many-to-one}Id = "+tenancy.get{Many-to-one}().get{Many-to-one}Id()+" and ";
			fromClause = fromClause +" (upper(tenancy.name) = :name) " ;
		
			Query query = getSession().createQuery(fromClause);	
			query.setParameter("name", CommonUtils.getEscapedSQLString(tenancy.getName()).toUpperCase());
			List list = query.list();

			if (list != null && list.size() > 0) 
				return (Tenancy) list.get(0);

		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;	
	}
	
	@Override
	public String getTenancyId(String tenancyName){
		try {
			String fromClause = "select tenancy.tenancyId from Tenancy tenancy where upper(tenancy.name) like :tenancyNamee";
			Query query = getSession().createQuery(fromClause);
			query.setString("tenancyNamee", "%"+tenancyName.toUpperCase()+"%");	

			List list = query.list();
			
			if (list != null && list.size() > 0) {
				return list.get(0).toString();
			}
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
}

