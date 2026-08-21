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

import com.mars.common.dao.DeliveryModeDAO;
import com.mars.common.model.DeliveryMode;
 /**

 * <p>Title: BankDaoImpl.java </p>

 * @see com.mars.common.model.Bank
 
 * <p>Description: This class is used for hibernate operations for Bank module</p>

 * Copyright (c) 2014 for Mars Telecom India Pvt Ltd 

 * @version: 1.0

 * 
 
 */
 @Repository("deliveryModeDAO")
public class DeliveryModeDAOImpl extends HibernateDaoSupport implements DeliveryModeDAO {

    private static final Log log = LogFactory.getLog(DeliveryModeDAOImpl.class);
    
    @Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public DeliveryMode get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (DeliveryMode) getHibernateTemplate().get(DeliveryMode.class,new Long(id));
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(DeliveryMode entity) {
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
	public DeliveryMode merge(DeliveryMode entity) {
		try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (DeliveryMode) getHibernateTemplate().merge(entity);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	 

	@Override
	public List<DeliveryMode> getAll() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get all Method is called ");
			}
			return getHibernateTemplate().loadAll(DeliveryMode.class);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}

	@Override
	public long getDeliveryModeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DeliveryMode> findByProperty(String propertyName,
			Object value) {
		try {
			log.info("finding DeliveryMode instance with property: "
					+ propertyName + ", value: " + value);
			String queryString = "select DeliveryMode from DeliveryMode DeliveryMode where DeliveryMode."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			List<DeliveryMode> list = queryObject.list();
			return list;
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

	@Override
	public DeliveryMode checkForDuplicates(DeliveryMode DeliveryMode) {
		// TODO Auto-generated method stub
		try {
			log.info("Check For Duplicate");
			String queryString = "select deliveryMode from DeliveryMode deliveryMode where deliveryMode.deliveryModeName= ? ";
			if(DeliveryMode.getDeliveryModeId()>0){
				queryString = queryString+" and deliveryMode.deliveryModeId <> "+DeliveryMode.getDeliveryModeId();
			}
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, DeliveryMode.getDeliveryModeName());
			List<DeliveryMode> list = queryObject.list();
			 
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

	 

	 
 
	 
 
 
  
    
	
}

