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

import com.mars.rti.dao.PropertyTaxSelfAssessmentDAO;
import com.mars.rti.model.PropertyTaxSefAssessment;

@Repository
public class PropertyTaxSelfAssessmentDAOImpl extends HibernateDaoSupport  implements PropertyTaxSelfAssessmentDAO{
	private static final Log log = (Log) LogFactory.getLog(PropertyTaxSelfAssessmentDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	
	@Override
	public void savePropertyTaxSelfAssessment(PropertyTaxSefAssessment propertyTaxSefAssessment) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			System.out.println(propertyTaxSefAssessment);
			getHibernateTemplate().saveOrUpdate(propertyTaxSefAssessment);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			System.out.println(exception);
			exception.printStackTrace();
		}

	}
	@Override
	public long propertyTaxSelfAssessmentSave(PropertyTaxSefAssessment propertyTaxSefAssessment) {
		PropertyTaxSefAssessment propertyTax = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			propertyTax = (PropertyTaxSefAssessment) getHibernateTemplate().merge(propertyTaxSefAssessment);

			if (propertyTax != null) {
				return propertyTax.getPropertyTaxSelfAssessmentId();
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
		return propertyTax.getPropertyTaxSelfAssessmentId();
	}


	@Override
	public PropertyTaxSefAssessment get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiApplicationRefId);
			}
			return (PropertyTaxSefAssessment) getHibernateTemplate().get(PropertyTaxSefAssessment.class,
					new Long(rtiApplicationRefId));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
	@Override
	public PropertyTaxSefAssessment getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select propertyTaxSefAssessment from PropertyTaxSefAssessment propertyTaxSefAssessment where rtiRefId = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (PropertyTaxSefAssessment) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	
}
