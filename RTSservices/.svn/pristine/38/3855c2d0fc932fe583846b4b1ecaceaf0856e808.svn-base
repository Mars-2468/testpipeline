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

import com.mars.rti.dao.PropertyAssessmentDAO;
import com.mars.rti.model.PropertyAssessmentTrasScript;

@Repository
public class PropertyAssessmentDAOImpl extends HibernateDaoSupport implements PropertyAssessmentDAO{
	
	private static final Log log = (Log) LogFactory.getLog(PropertyAssessmentDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void savePropertyAssessment(PropertyAssessmentTrasScript propertyAssessmentTrasScript) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			System.out.println(propertyAssessmentTrasScript);
			getHibernateTemplate().saveOrUpdate(propertyAssessmentTrasScript);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			System.out.println(exception);
			exception.printStackTrace();
		}

	}

	@Override
	public long propertyAssessmentSave(PropertyAssessmentTrasScript propertyAssessmentTrasScript) {
		PropertyAssessmentTrasScript propertyAssessment = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			propertyAssessment = (PropertyAssessmentTrasScript) getHibernateTemplate()
					.merge(propertyAssessmentTrasScript);

			if (propertyAssessment != null) {
				return propertyAssessment.getPropertyAssessmentID();
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
		return propertyAssessment.getPropertyAssessmentID();
	}

	@Override
	public PropertyAssessmentTrasScript get(long rtiApplicationRefId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiApplicationRefId);
			}
			return (PropertyAssessmentTrasScript) getHibernateTemplate().get(PropertyAssessmentTrasScript.class,
					new Long(rtiApplicationRefId));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
	@Override
	public PropertyAssessmentTrasScript getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select propertyAssessmentTrasScript from PropertyAssessmentTrasScript propertyAssessmentTrasScript where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (PropertyAssessmentTrasScript) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PropertyAssessmentTrasScript merge(PropertyAssessmentTrasScript propertyAssessmentTrasScript) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (PropertyAssessmentTrasScript) getHibernateTemplate().merge(propertyAssessmentTrasScript);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

}
