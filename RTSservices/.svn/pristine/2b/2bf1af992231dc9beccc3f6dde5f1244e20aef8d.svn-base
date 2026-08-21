package com.mars.common.dao.impl;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.PermissionGroupDAO;
import com.mars.common.model.PermissionGroup;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;

 /**

 * <p>Title: PermissionGroupDaoImpl.java </p>

 * @see com.mars.common.model.PermissionGroup
 
 * <p>Description: This class is used for hibernate operations for PermissionGroup module</p>

 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("PermissionGroupDAO") 
public class PermissionGroupDAOImpl extends HibernateDaoSupport implements PermissionGroupDAO {

    private static final Log log = LogFactory.getLog(PermissionGroupDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns PermissionGroup object for a given Id
	 * 
	 * @param id as long
	 * @return PermissionGroup as model object
	 */
	public PermissionGroup get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (PermissionGroup) getHibernateTemplate().get(PermissionGroup.class,new Long(id));
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
    
	/**
	 * This method returns PermissionGroup object for a given name & permissionGroupId
	 * 
	 * @param name as String
	 * @param permissionGroupId as long
	 * @return PermissionGroup as model object
	 */
	public PermissionGroup getByName(String name, long permissionGroupId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("getByName Method is called on " + name);
			}
			
			String fromClause = "select permissionGroup from PermissionGroup permissionGroup where upper(permissionGroup.name)=upper('"+name+"')";
			if(permissionGroupId > 0){
		    	fromClause = fromClause+" and permissionGroupId<>" + permissionGroupId;
		    }
		    Query query = getSession().createQuery(fromClause);
		    List list = query.list();

		    if (list != null && list.size() > 0)
		    	return (PermissionGroup) list.get(0);
		    else
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
    
    /**
	 * This method save/updates the PermissionGroup information to the database.
	 * 
	 * @param PermissionGroup object
	 * 
	 */
	public void save(PermissionGroup entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (NullPointerException nullpointerexception) {
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
    
    /**
	 * This method is used to delete a record from the database using hibernate.
	 * 
	 * @param id as long
	 */
    public void delete(long id) {
        try {
    		if(log.isDebugEnabled()){
        		log.debug("deleting PermissionGroup instance");
        	}
        	PermissionGroup entity = (PermissionGroup) getHibernateTemplate().load(PermissionGroup.class, new Long(id));
			getHibernateTemplate().delete(entity);
            log.debug("delete successful");
        }
        catch (NullPointerException nullpointerexception) {
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
    
	/**
	 * This method will return a list of all PermissionGroup from the database
	 * 
	 * @return List of PermissionGroup
	 */
	public List<PermissionGroup> getAll() {
		try {

			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for PermissionGroup");
			}
			return getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(PermissionGroup.class).addOrder( Order.asc("name").ignoreCase()).list();			
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
    
     /**
     * This method is used to delete a list of Module records from the database.
     * 
     * @param listPermissionGroup as List
     */
    public void deleteAll(List<PermissionGroup> listPermissionGroup)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for PermissionGroup");
	    	}
	    	getHibernateTemplate().deleteAll(listPermissionGroup);
	    	log.debug("deleted successfuly a list of PermissionGroup records from database");
		} catch (NullPointerException nullpointerexception)
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

    
    /**
     * This method save/updates a list of PermissionGroup information to the database.
     * 
     * @param listPermissionGroup as List
     * 
     */
    public void saveAll(List<PermissionGroup> listPermissionGroup)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listPermissionGroup);
		} catch (NullPointerException nullpointerexception)
		{
	    	log.error(nullpointerexception.getStackTrace());
	    	throw new NullPointerException();
		} catch (HibernateException hibernateException)
		{
	    	hibernateException.printStackTrace();
	    	log.error(hibernateException.getStackTrace());
	   		throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception)
		{
	    	exception.printStackTrace();
	    	log.error(exception.getStackTrace());
	    	throw new RuntimeException(exception.getCause());
		}
    }
    
	/**
	 * This method returns list of the PermissionGroup objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<PermissionGroup> getPermissionGroupList(long pageNumber,String orderBy, String sortBy){
	
	try {
			String fromClause = "select permissionGroup from PermissionGroup permissionGroup";
			fromClause = fromClause+ " order by "+ orderBy +" "+sortBy;
			Query query = getSession().createQuery(fromClause);
			
			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue()) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber-1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}
			
			List<PermissionGroup> list = query.list();
			
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
	
	
	/**
	 * This method returns count of the PermissionGroup objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getPermissionGroupCount(){
	    try {
			String fromClause = "select count(*) from PermissionGroup permissionGroup";
			Query query = getSession().createQuery(fromClause);
			List list = query.list();
			
			if (list != null && list.size() > 0) {
				return Long.parseLong(list.get(0).toString());
			}
			return 0;
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
	   public List<PermissionGroup> getPermissionGroupListBySearch(PermissionGroup searchOptions)
	   {
		   String name=CommonUtils.getEscapedSQLString(searchOptions.getName());
		   long pageNumber=searchOptions.getCurrentPage();
		   String orderBy=searchOptions.getOrderBy();
		   String sortBy=searchOptions.getSortBy();
		   try{
			   String fromClause="select permissionGroup from PermissionGroup permissionGroup where upper(permissionGroup.name) like  upper('%"+name+"%') ";
				fromClause = fromClause+ " order by "+ orderBy +" "+sortBy;
				Query query = getSession().createQuery(fromClause);
				  
			    if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue())
			    {
				if (pageNumber > 1)
				{
				    query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
				    query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else
				{
				    query.setFirstResult(0);
				    query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			    }
			    
			    List<PermissionGroup> list = query.list();
		
			    if (list != null && list.size() > 0)
			    {
				return list;
			    }
			    return null;
		   }
		   catch (NullPointerException nullpointerexception)
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
	   public long getPermissionGroupCountBySearchOption(PermissionGroup searchOptions)
	   {
		   String name=CommonUtils.getEscapedSQLString(searchOptions.getName());
		   try{
			   String fromClause="select count(*) from PermissionGroup permissionGroup where upper(permissionGroup.name) like upper('%"+name+"%') ";
				Query query = getSession().createQuery(fromClause);
				  

			    List list = query.list();
		
			    if (list != null && list.size() > 0)
			    {
			    	return Long.parseLong(list.get(0).toString());
			    }
			    return 0;
		   }
		   catch (NullPointerException nullpointerexception)
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
}

