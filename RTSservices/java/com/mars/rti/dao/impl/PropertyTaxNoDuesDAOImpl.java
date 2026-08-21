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

import com.mars.rti.dao.PropertyTaxNoDuesDAO;
import com.mars.rti.model.PropertyTaxNoDues;
//import com.mars.rti.dao.PropertyTaxNoDuesDAO;
//import com.mars.rti.model.PropertyTaxNoDues;
@Repository
public class PropertyTaxNoDuesDAOImpl extends HibernateDaoSupport implements PropertyTaxNoDuesDAO{
	private static final Log log = LogFactory.getLog(PropertyTaxNoDuesDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void savePropertyTaxNoDues(PropertyTaxNoDues propertyTaxNoDues) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("PropertyTaxNoDues save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(propertyTaxNoDues);
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
	public long propertyTaxNoDuesSave(PropertyTaxNoDues propertyTaxNoDues) {
		PropertyTaxNoDues b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (PropertyTaxNoDues) getHibernateTemplate().merge(propertyTaxNoDues);

			if (b != null) {
				return b.getPropertyTaxNoDuesId();
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
		return b.getPropertyTaxNoDuesId();
	}

	@Override
	public PropertyTaxNoDues get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (PropertyTaxNoDues) getHibernateTemplate().get(PropertyTaxNoDues.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	@Override
	public PropertyTaxNoDues getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select propertyTaxNoDues from PropertyTaxNoDues propertyTaxNoDues where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (PropertyTaxNoDues) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PropertyTaxNoDues merge(PropertyTaxNoDues propertyTaxNoDues) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (PropertyTaxNoDues) getHibernateTemplate().merge(propertyTaxNoDues);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}


}
