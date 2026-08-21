package com.mars.common.dao.impl;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.ReceivedModeDAO;
import com.mars.common.model.ReceivedMode;
import com.mars.common.search.ReceivedModeSearch;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
 /**

 * <p>Title: BankDaoImpl.java </p>

 * @see com.mars.common.model.Bank
 
 * <p>Description: This class is used for hibernate operations for Bank module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
 @Repository("receivedModeDAO")
public class ReceivedModeDAOImpl extends HibernateDaoSupport implements  ReceivedModeDAO {

    private static final Log log = LogFactory.getLog(ReceivedModeDAOImpl.class);
    
    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public ReceivedMode get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (ReceivedMode) getHibernateTemplate().get(ReceivedMode.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(ReceivedMode entity) {
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

	@Override
	public ReceivedMode merge(ReceivedMode entity) {
		try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (ReceivedMode) getHibernateTemplate().merge(entity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(long id) {
		 try {
	    		if(log.isDebugEnabled()){
	        		log.debug("deleting  instance");
	        	}
	    		ReceivedMode entity = (ReceivedMode) getHibernateTemplate().load(ReceivedMode.class, new Long(id));
				getHibernateTemplate().delete(entity);
	            log.debug("delete successful");
			} catch (Exception exception)
			{
		    	log.error(exception.getStackTrace());
		    	exception.printStackTrace();
			}
	}

	@Override
	public List<ReceivedMode> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called ");
			}
			return getHibernateTemplate().loadAll(ReceivedMode.class);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveAll(List<ReceivedMode> listNode) {
		try
		{
	    	if (log.isDebugEnabled())
	    	{
				log.debug("saveAll Method is called ");
	    	}
	    	getHibernateTemplate().saveOrUpdateAll(listNode);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		
	}

	@Override
	public void deleteAll(List<ReceivedMode> listNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReceivedMode> getReceivedModeCountList(long pageNumber, String orderBy, String sortBy) {
		try {
			String fromClause = "select ReceivedMode from ReceivedMode ReceivedMode";
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
			List<ReceivedMode> list = query.list();
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

	@Override
	public List<ReceivedMode> getReceivedModeListBySearch(ReceivedModeSearch receivedModeSearch) {
		if(log.isDebugEnabled()){
			log.debug("getListBySearch Method is called");
		}
		
		try{
			long pageNumber=receivedModeSearch.getCurrentPage();
			String orderBy=receivedModeSearch.getOrderBy();
			String sortBy=receivedModeSearch.getSortBy();
			
			String name=CommonUtils.getEscapedSQLString(receivedModeSearch.getName());			
			StringBuffer sql=new StringBuffer();
			String fromClause="select receivedMode from ReceivedMode receivedMode";
			List<ReceivedMode> list=null;
			boolean flag=false;
			
			if(name!=null && name.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(receivedMode.receivedModeName) like upper(:name)");
			}			
			
			sql.insert(0, fromClause).append(" order by " + orderBy + " "+ sortBy);
			Query query=getSession().createQuery(sql.toString());
			
			if(name!=null && name.length()>0)
			query.setString("name", "%"+name.toUpperCase()+"%");
	

			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue()) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}
			list=query.list();
			return list;
		}catch (NullPointerException nullpointerexception) {
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

	@Override
	public long getReceivedModeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getReceivedModeCountBySearch(ReceivedModeSearch receivedModeSearch) {

		if(log.isDebugEnabled()){
			log.debug("getCountBySearch Method is called");
		}
		
		try{
			String name=CommonUtils.getEscapedSQLString(receivedModeSearch.getName());
			
			StringBuffer sql=new StringBuffer();
			String fromClause="select count(receivedMode) from ReceivedMode receivedMode";
			List list=null;
			boolean flag=false;
			
			if(name!=null && name.length()>0){
				if(!flag){
					flag=true;
					sql.append(" where ");
				}else
					sql.append(" and ");
				
				    sql.append("upper(receivedMode.receivedModeName) like upper(:name)");
			}
			
			sql.insert(0, fromClause);
			Query query=getSession().createQuery(sql.toString());
			
			if(name!=null && name.length()>0)
			query.setString("name", "%"+name.toUpperCase()+"%");


			list=query.list();
			
			if(list!=null && list.size()>0)
				return Long.parseLong(list.get(0).toString());
			else
				return 0;
		}catch (NullPointerException nullpointerexception) {
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

	@Override
	public List<ReceivedMode> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceivedMode checkForDuplicates(ReceivedMode receivedMode) {
		// TODO Auto-generated method stub
		try {
			log.info("Check For Duplicate");
			String queryString = "select receivedMode from ReceivedMode receivedMode where receivedMode.receivedModeName= ? ";
			if(receivedMode.getReceivedModeId()>0){
				queryString = queryString+" and receivedMode.receivedModeId <> "+receivedMode.getReceivedModeId();
			}
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, receivedMode.getReceivedModeName());
			List<ReceivedMode> list = queryObject.list();
			 
			if(list!= null && list.size()>0){
				return list.get(0);
			}
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
		return null;
	}

	@Override
	public List<ReceivedMode> getListByNamedQuery(String namedQuery,
			Hashtable<String, Object> hstKeyValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReceivedMode> getEntityListBySQLQuery(String strSql,
			Hashtable<String, NullableType> hstDataTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArrayList> getListBySQLQuery(String strSql,
			Hashtable<String, NullableType> hstDataTypes) {
		// TODO Auto-generated method stub
		return null;
	}    
	
}

