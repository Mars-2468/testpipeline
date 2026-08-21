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

import com.mars.rti.dao.DurgaUtsavDAO;
import com.mars.rti.model.DurgaUtsavMandapPermission;

@Repository
public class DurgaUtsavDAOImpl extends HibernateDaoSupport implements DurgaUtsavDAO{

	private static final Log log = LogFactory.getLog(DurgaUtsavDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public void saveDurgaUtsavMandapPermission(
			DurgaUtsavMandapPermission mandapPermission) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Durga Utsav Mandap Permission save Method is called");
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
	public long ganeshMandapPermissionSave(
			DurgaUtsavMandapPermission mandapPermission) {
		DurgaUtsavMandapPermission b;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (DurgaUtsavMandapPermission) getHibernateTemplate().merge(mandapPermission);

			if (b != null) {
				return b.getDurgaUtsavMandapPermissionId();
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
		return b.getDurgaUtsavMandapPermissionId();
	}
	
	
	@Override
	public DurgaUtsavMandapPermission get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (DurgaUtsavMandapPermission) getHibernateTemplate().get(DurgaUtsavMandapPermission.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}


	@Override
	public DurgaUtsavMandapPermission merge(
			DurgaUtsavMandapPermission mandapPermission) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (DurgaUtsavMandapPermission) getHibernateTemplate().merge(mandapPermission);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public DurgaUtsavMandapPermission getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select durgaUtsavMandapPermission from DurgaUtsavMandapPermission durgaUtsavMandapPermission where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (DurgaUtsavMandapPermission) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
}
