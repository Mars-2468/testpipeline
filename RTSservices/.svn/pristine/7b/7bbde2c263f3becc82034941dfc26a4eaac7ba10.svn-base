package com.mars.common.dao.impl;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.RolePermissionDAO;
import com.mars.common.model.RolePermission;
import com.mars.common.utils.Constants;

 /**

 * <p>Title: RolePermissionDaoImpl.java </p>

 * @see com.mars.common.model.RolePermission
 
 * <p>Description: This class is used for hibernate operations for RolePermission module</p>

 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 
 */
@Repository("RolePermissionDAO") 
public class RolePermissionDAOImpl extends HibernateDaoSupport implements RolePermissionDAO {

    private static final Log log = LogFactory.getLog(RolePermissionDAOImpl.class);

    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns RolePermission object for a given Id
	 * 
	 * @param id as long
	 * @return RolePermission as model object
	 */
	public RolePermission get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (RolePermission) getHibernateTemplate().get(RolePermission.class,new Long(id));
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
	 * This method save/updates the RolePermission information to the database.
	 * 
	 * @param RolePermission object
	 * 
	 */
	public void save(RolePermission entity) {
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
        		log.debug("deleting RolePermission instance");
        	}
        	RolePermission entity = (RolePermission) getHibernateTemplate().load(RolePermission.class, new Long(id));
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
	 * This method will return a list of all RolePermission from the database
	 * 
	 * @return List of RolePermission
	 */
	public List<RolePermission> getAll() {
		try {

			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for RolePermission");
			}
			return getHibernateTemplate().loadAll(RolePermission.class);
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
     * @param listRolePermission as List
     */
    public void deleteAll(List<RolePermission> listRolePermission)
    {
		try
		{
	    	if (log.isDebugEnabled())
	   		{
				log.debug("deleteAll Method is called for RolePermission");
	    	}
	    	getHibernateTemplate().deleteAll(listRolePermission);
	    	log.debug("deleted successfuly a list of RolePermission records from database");
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
     * This method save/updates a list of RolePermission information to the database.
     * 
     * @param listRolePermission as List
     * 
     */
    public void saveAll(List<RolePermission> listRolePermission)
    {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listRolePermission);
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
	 * This method returns list of the RolePermission objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String orderBy
	 * @param String sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<RolePermission> getRolePermissionList(long pageNumber,String orderBy, String sortBy){
	
	try {
			String fromClause = "select rolePermission from RolePermission rolePermission";
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
			
			List<RolePermission> list = query.list();
			
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
	 * This method returns count of the RolePermission objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getRolePermissionCount(){
	    try {
			String fromClause = "select count(*) from RolePermission rolePermission";
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
    
}

