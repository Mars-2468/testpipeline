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

import com.mars.rti.dao.PropertyTaxTransferRegistrationDAO;
import com.mars.rti.model.PropertyTaxTransferRegistration;

@Repository
public class PropertyTaxTransferRegistrationDAOImpl extends HibernateDaoSupport implements PropertyTaxTransferRegistrationDAO{

	private static final Log log = LogFactory.getLog(PropertyTaxTransferRegistrationDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public void savePropertyTaxTransferRegistrationForm(
			PropertyTaxTransferRegistration propertyTaxTransferRegistration) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Propertytax Mutation save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(propertyTaxTransferRegistration);
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
	public long PropertyTaxTransferRegistration(
			PropertyTaxTransferRegistration propertyTaxTransferRegistration) {
		PropertyTaxTransferRegistration b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (PropertyTaxTransferRegistration) getHibernateTemplate().merge(propertyTaxTransferRegistration);

			if (b != null) {
				return b.getPropertyTransferRegistrationId();
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
		return 0;
	}
	@Override
	public PropertyTaxTransferRegistration get(long rtiApplicationRefId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiApplicationRefId);
			}
			return (PropertyTaxTransferRegistration) getHibernateTemplate().get(PropertyTaxTransferRegistration.class, new Long(rtiApplicationRefId));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	@Override
	public PropertyTaxTransferRegistration getDeatils(long rtiApplicationId) {
		try{

			String sqlQuery="select propertyTaxTransferRegistration from PropertyTaxTransferRegistration propertyTaxTransferRegistration where propertyTaxTransferRegistration.rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (PropertyTaxTransferRegistration) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public PropertyTaxTransferRegistration merge(
			PropertyTaxTransferRegistration propertyTaxTransferRegistration) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (PropertyTaxTransferRegistration) getHibernateTemplate().merge(propertyTaxTransferRegistration);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
}
