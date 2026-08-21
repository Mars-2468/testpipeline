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

import com.mars.rti.dao.DikshaBhumiDAO;
import com.mars.rti.model.DikshaBhumiMandapPermission;

@Repository
public class DikshaBhumiDAOImpl extends HibernateDaoSupport implements DikshaBhumiDAO {

	private static final Log log = LogFactory.getLog(DikshaBhumiDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public void saveDikshaBhumiMandapPermission(
			DikshaBhumiMandapPermission mandapPermission) {
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
	public long dikshaBhumiMandapPermissionSave(
			DikshaBhumiMandapPermission mandapPermission) {
		DikshaBhumiMandapPermission b;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (DikshaBhumiMandapPermission) getHibernateTemplate().merge(mandapPermission);

			if (b != null) {
				return b.getDikshaBhumiMandapPermissionId();
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
		return b.getDikshaBhumiMandapPermissionId();
	}

	@Override
	public DikshaBhumiMandapPermission get(long id) {
		// TODO Auto-generated method stub
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (DikshaBhumiMandapPermission) getHibernateTemplate().get(DikshaBhumiMandapPermission.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	@Override
	public DikshaBhumiMandapPermission merge(
			DikshaBhumiMandapPermission mandapPermission) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (DikshaBhumiMandapPermission) getHibernateTemplate().merge(mandapPermission);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public DikshaBhumiMandapPermission getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select dikshaBhumiMandapPermission from DikshaBhumiMandapPermission dikshaBhumiMandapPermission where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (DikshaBhumiMandapPermission) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	

}
