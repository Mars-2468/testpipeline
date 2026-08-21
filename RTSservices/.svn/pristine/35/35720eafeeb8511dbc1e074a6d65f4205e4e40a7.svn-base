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

import com.mars.rti.dao.PropertyTaxMutationDAO;
import com.mars.rti.model.PropertyTaxMutation;

@Repository
public class PropertyTaxMutationDAOImpl extends HibernateDaoSupport implements PropertyTaxMutationDAO{


	private static final Log log = LogFactory.getLog(PropertyTaxMutationDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public void savePrpertyTaxMutationForm(PropertyTaxMutation propertytaxMutation) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Propertytax Mutation save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(propertytaxMutation);
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
	public long propertyTaxMutation(PropertyTaxMutation propertytaxMutation) {
		PropertyTaxMutation b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (PropertyTaxMutation) getHibernateTemplate().merge(propertytaxMutation);

			if (b != null) {
				return b.getPropertyTaxMutationId();
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
		return b.getPropertyTaxMutationId();
	}


	@Override
	public PropertyTaxMutation get(long rtiApplicationRefId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiApplicationRefId);
			}
			return (PropertyTaxMutation) getHibernateTemplate().get(PropertyTaxMutation.class, new Long(rtiApplicationRefId));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	@Override
	public PropertyTaxMutation getDeatils(long rtiApplicationId) {
		try{

			String sqlQuery="select propertyTaxMutation from PropertyTaxMutation propertyTaxMutation where propertyTaxMutation.rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (PropertyTaxMutation) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PropertyTaxMutation merge(PropertyTaxMutation propertytaxmutation) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (PropertyTaxMutation) getHibernateTemplate().merge(propertytaxmutation);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
}
