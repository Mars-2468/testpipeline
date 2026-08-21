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

import com.mars.common.dao.UserRoleDAO;
import com.mars.common.model.UserRole;
import com.mars.common.utils.Constants;

/**
 * 
 * <p>
 * Title: UserRoleDaoImpl.java
 * </p>
 * 
 * @see com.mars.common.model.UserRole <p>
 *      Description: This class is used for hibernate operations for UserRole module
 *      </p>
 * 
 *      Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd
 * 
 * @version: 1.0
 * 
 * 
 */
@Repository("UserRoleDAO")
public class UserRoleDAOImpl extends HibernateDaoSupport implements UserRoleDAO {

	private static final Log log = LogFactory.getLog(UserRoleDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	/**
	 * This method returns UserRole object for a given Id
	 * 
	 * @param id
	 *            as long
	 * @return UserRole as model object
	 */
	public UserRole get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (UserRole) getHibernateTemplate().get(UserRole.class, new Long(id));
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
	 * This method save/updates the UserRole information to the database.
	 * 
	 * @param UserRole
	 *            object
	 * 
	 */
	public void save(UserRole entity) {
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
	 * @param id
	 *            as long
	 */
	public void delete(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleting UserRole instance");
			}
			UserRole entity = (UserRole) getHibernateTemplate().load(UserRole.class, new Long(id));
			getHibernateTemplate().delete(entity);
			log.debug("delete successful");
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
	 * This method will return a list of all UserRole from the database
	 * 
	 * @return List of UserRole
	 */
	public List<UserRole> getAll() {
		try {

			if (log.isDebugEnabled()) {
				log.debug("get all Method is called for UserRole");
			}
			return getHibernateTemplate().loadAll(UserRole.class);
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
	 * @param listUserRole
	 *            as List
	 */
	public void deleteAll(List<UserRole> listUserRole) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleteAll Method is called for UserRole");
			}
			getHibernateTemplate().deleteAll(listUserRole);
			log.debug("deleted successfuly a list of UserRole records from database");
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
	 * This method save/updates a list of UserRole information to the database.
	 * 
	 * @param listUserRole
	 *            as List
	 * 
	 */
	public void saveAll(List<UserRole> listUserRole) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("saveAll Method is called ");
			}
			getHibernateTemplate().saveOrUpdateAll(listUserRole);
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
	 * This method returns list of the UserRole objects available based page number.
	 * 
	 * @param long PageNumber
	 * @param String
	 *            orderBy
	 * @param String
	 *            sortBy
	 * @return List
	 * @exception Exception
	 */
	public List<UserRole> getUserRoleList(long pageNumber, String orderBy, String sortBy) {

		try {
			String fromClause = "select userRole from UserRole userRole";
			fromClause = fromClause + " order by " + orderBy + " " + sortBy;
			Query query = getSession().createQuery(fromClause);

			if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS.intValue()) {
				if (pageNumber > 1) {
					query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				} else {
					query.setFirstResult(0);
					query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE.intValue());
				}
			}

			List<UserRole> list = query.list();

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
	 * This method returns count of the UserRole objects available based on search criteria.
	 * 
	 * @return long
	 * @exception Exception
	 */
	public long getUserRoleCount() {
		try {
			String fromClause = "select count(*) from UserRole userRole";
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

	/**
	 * This method returns UserRole object
	 * 
	 * @param userId
	 * @return
	 */
	public UserRole getByUserId(long userId) {

		try {
			String fromClause = "select userRole from UserRole userRole where userRole.user.userId=" + userId + "";

			Query query = getSession().createQuery(fromClause);

			List<UserRole> list = query.list();

			if (list != null && list.size() > 0) {
				return list.get(0);
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

}
