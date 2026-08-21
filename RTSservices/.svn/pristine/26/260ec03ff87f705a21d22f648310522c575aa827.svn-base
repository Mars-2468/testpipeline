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

import com.mars.rti.dao.NewlyConstructedPropertyDAO;
import com.mars.rti.model.NewlyConstructedProperty;

@Repository
public class NewlyConstructedPropertyDAOImpl extends HibernateDaoSupport implements NewlyConstructedPropertyDAO {

	private static final Log log = LogFactory.getLog(NewlyConstructedPropertyDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveNewlyConstructedProperty(NewlyConstructedProperty newlyConstructedProperty) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Mandap save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(newlyConstructedProperty);
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
	public long newlyConstructedPropertySave(NewlyConstructedProperty newlyConstructedProperty) {
		NewlyConstructedProperty b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (NewlyConstructedProperty) getHibernateTemplate().merge(newlyConstructedProperty);

			if (b != null) {
				return b.getNewlyConstructedPropertyId();
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
		return b.getNewlyConstructedPropertyId();
	}
	

	@Override
	public NewlyConstructedProperty get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (NewlyConstructedProperty) getHibernateTemplate().get(NewlyConstructedProperty.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
	@Override
	public NewlyConstructedProperty getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select newlyConstructedProperty from NewlyConstructedProperty newlyConstructedProperty where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (NewlyConstructedProperty) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NewlyConstructedProperty merge(NewlyConstructedProperty newlyConstructedProperty) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (NewlyConstructedProperty) getHibernateTemplate().merge(newlyConstructedProperty);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	

	
}
