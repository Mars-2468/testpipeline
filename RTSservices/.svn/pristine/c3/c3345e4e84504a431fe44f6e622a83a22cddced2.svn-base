package com.mars.rti.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.MobileTowerDAO;
import com.mars.rti.model.MobileTower;

@Repository
public class MobileTowerDAOImpl extends HibernateDaoSupport implements MobileTowerDAO{

	private static final Log log = LogFactory.getLog(MobileTowerDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	
	@Override
	public void saveMobileTower(MobileTower mobilTower) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Mobile save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(mobilTower);
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
	public long mobileTowerSave(MobileTower mobileTower) {
		MobileTower b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (MobileTower) getHibernateTemplate().merge(mobileTower);

			if (b != null) {
				return b.getMobileTowerId();
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
		return b.getMobileTowerId();
	}
	@Override
	public MobileTower get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (MobileTower) getHibernateTemplate().get(MobileTower.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

}
