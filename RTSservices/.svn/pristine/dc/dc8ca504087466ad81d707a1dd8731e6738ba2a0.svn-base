package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.MandapPermissionDAO;
import com.mars.rti.model.MandapPermission;

@Repository
public class MandapPermissionDAOImpl extends HibernateDaoSupport implements MandapPermissionDAO {

	private static final Log log = LogFactory.getLog(MandapPermissionDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveMandapPermission(MandapPermission mandapPermission) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Mandap save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(mandapPermission);
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

	@Override
	public long mandapPermissionSave(MandapPermission mandapPermission) {
		// TODO Auto-generated method stub
		MandapPermission b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (MandapPermission) getHibernateTemplate().merge(mandapPermission);

			if (b != null) {
				return b.getMandapPermissionId();
			}
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
		return b.getMandapPermissionId();
	}

	@Override
	public MandapPermission get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (MandapPermission) getHibernateTemplate().get(MandapPermission.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
	@Override
	public MandapPermission getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select mandapPermission from MandapPermission mandapPermission where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (MandapPermission) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public MandapPermission merge(MandapPermission mandapPermission) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (MandapPermission) getHibernateTemplate().merge(mandapPermission);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}



}
