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

import com.mars.rti.dao.PartMapDAO;
import com.mars.rti.model.PartMap;

@Repository
public class PartMapDAOImpl  extends HibernateDaoSupport implements PartMapDAO{


	private static final Log log = LogFactory.getLog(PartMapDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void savePartMap(PartMap partmap) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Mandap save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(partmap);
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
	public long partMapSave(PartMap partmap) {
		// TODO Auto-generated method stub
		PartMap b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (PartMap) getHibernateTemplate().merge(partmap);

			if (b != null) {
				return b.getPartMapId();
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
		return b.getPartMapId();
	}

	@Override
	public PartMap get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (PartMap) getHibernateTemplate().get(PartMap.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	@Override
	public PartMap getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select partMap from PartMap partMap where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (PartMap) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	

}
