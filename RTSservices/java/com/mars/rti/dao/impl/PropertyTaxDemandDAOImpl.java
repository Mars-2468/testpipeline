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

import com.mars.rti.dao.PropertyTaxDemandDAO;
import com.mars.rti.model.PropertyTaxDemand;

@Repository
public class PropertyTaxDemandDAOImpl  extends HibernateDaoSupport implements PropertyTaxDemandDAO{
	
	private static final Log log = (Log) LogFactory.getLog(PropertyTaxDemandDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void savePropertyTaxDemand(PropertyTaxDemand propertyTaxDemand) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			System.out.println(propertyTaxDemand);
			getHibernateTemplate().saveOrUpdate(propertyTaxDemand);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			System.out.println(exception);
			exception.printStackTrace();
		}

	}

	@Override
	public long propertyTaxDemandSave(PropertyTaxDemand propertyTaxDemand) {
		PropertyTaxDemand propertyTax = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			propertyTax = (PropertyTaxDemand) getHibernateTemplate().merge(propertyTaxDemand);

			if (propertyTax != null) {
				return propertyTax.getPropertyDemandID();
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
		return propertyTax.getPropertyDemandID();
	}

	@Override
	public PropertyTaxDemand get(long rtiApplicationRefId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiApplicationRefId);
			}
			return (PropertyTaxDemand) getHibernateTemplate().get(PropertyTaxDemand.class,
					new Long(rtiApplicationRefId));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
	@Override
	public PropertyTaxDemand getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select propertyTaxDemand from PropertyTaxDemand propertyTaxDemand where rtiRefId = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (PropertyTaxDemand) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	

}
