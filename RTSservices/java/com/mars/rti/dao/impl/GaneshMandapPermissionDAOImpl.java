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

import com.mars.rti.dao.GaneshMandapPermissionDAO;
import com.mars.rti.model.GaneshMandapPermission;

@Repository
public class GaneshMandapPermissionDAOImpl extends HibernateDaoSupport implements GaneshMandapPermissionDAO{

	private static final Log log = LogFactory.getLog(GaneshMandapPermissionDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	
	@Override
	public void saveGaneshMandapPermission(
			GaneshMandapPermission mandapPermission) {
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
	public long ganeshMandapPermissionSave(
			GaneshMandapPermission mandapPermission) {
		GaneshMandapPermission b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (GaneshMandapPermission) getHibernateTemplate().merge(mandapPermission);

			if (b != null) {
				return b.getGaneshMandapPermissionId();
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
		return b.getGaneshMandapPermissionId();
	}

	@Override
	public GaneshMandapPermission get(long id) {
		// TODO Auto-generated method stub
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (GaneshMandapPermission) getHibernateTemplate().get(GaneshMandapPermission.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}


	@Override
	public GaneshMandapPermission merge(
			GaneshMandapPermission gneshMandapPermission) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (GaneshMandapPermission) getHibernateTemplate().merge(gneshMandapPermission);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}


	@Override
	public GaneshMandapPermission getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select ganeshMandapPermission from GaneshMandapPermission ganeshMandapPermission where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (GaneshMandapPermission) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
}
