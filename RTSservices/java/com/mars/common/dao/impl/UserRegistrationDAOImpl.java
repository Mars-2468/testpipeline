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

import com.mars.common.dao.UserRegistrationDAO;
import com.mars.common.model.UserRegistrationDetails;

@Repository("UserRegistartionDAO")
public class UserRegistrationDAOImpl extends HibernateDaoSupport implements UserRegistrationDAO {
	
	private static final Log log = LogFactory.getLog(UserDAOImpl.class);

	   @Autowired
		public void init(SessionFactory factory) {
			setSessionFactory(factory);
		}
	
	@Override
	public void save(UserRegistrationDetails entity) {
		// TODO Auto-generated method stub
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method with User object is called ");
				
				log.debug(entity.getMobileNo());
			}

			getHibernateTemplate().save(entity);

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
		
		if (log.isDebugEnabled()) {
			log.debug("save Method with User object is called ");
			
			log.debug(entity.getFirstName());
		}
	}
	
	@Override
	public UserRegistrationDetails getUser(String email) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with user name is called " + email);
			}
			UserRegistrationDetails userList = (UserRegistrationDetails) getHibernateTemplate().get(UserRegistrationDetails.class,new String(email));
			if (userList != null ) {
				
				log.info("got this user"+userList.getEmail());
				return userList;
			}
			return null;
			// return (User) getHibernateTemplate().findByNamedParam("select user from User user",
			// "userName", userName)[0];
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
	public UserRegistrationDetails getUserByMobileNo(String number) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with user name is called " + number);
			}
			/*
			 * String query1 =
			 * "select userregistrationdetails from UserRegistrationDetails userregistrationdetails where userregistrationdetails.mobileNo=:number"
			 * ;
			 * 
			 * Query query= getSession().createQuery(query1);
			 * query.setParameter("number",number); if (log.isDebugEnabled()) {
			 * 
			 * log.debug("get Method with user name is called " + number); }
			 * List<UserRegistrationDetails> user = query.list();
			 * 
			 * 
			 * if (user != null ) {
			 * 
			 * return user.get(0); }
			 */
			
			
			log.info("invoking getRTIApplicationNoting  ");
			String queryString = "select userRegistrationDetails from UserRegistrationDetails userRegistrationDetails where userRegistrationDetails.mobileNo="+number;
			 
		    Query queryObject = getSession().createQuery(queryString);
		
	   		
		    List<UserRegistrationDetails> rtiApplicationNotingList = queryObject.list();
		    
		    if(!rtiApplicationNotingList.isEmpty()){
		    	return rtiApplicationNotingList.get(0);
		    }else{
		    	return null;
		    }
	
		} catch (NullPointerException nullpointerexception) {
			return null;
		} catch (HibernateException hibernateException) {
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
		
	}

}
