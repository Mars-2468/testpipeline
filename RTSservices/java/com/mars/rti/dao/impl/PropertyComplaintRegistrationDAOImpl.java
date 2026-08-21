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

import com.mars.rti.dao.PropertyComplaintRegistrationDAO;
import com.mars.rti.model.PropertyComplaintRegistration;

@Repository
public class PropertyComplaintRegistrationDAOImpl extends HibernateDaoSupport implements PropertyComplaintRegistrationDAO{

private static final Log log = LogFactory.getLog(TaxExemptionNonResidentialDAOImpl.class);

@Autowired
public void init(SessionFactory factory) {
	setSessionFactory(factory);
}

@Override
public void saveTaxExemptionNonResidential(PropertyComplaintRegistration taxExemptionNonResidential) {
	
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("save Method is called ");
	    }
	    getHibernateTemplate().saveOrUpdate(taxExemptionNonResidential);
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    hibernateException.printStackTrace();
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    exception.printStackTrace();
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
	
}

@Override
public long getTaxExemptionNonResidentialId(PropertyComplaintRegistration taxExemptionNonResidential) {
	PropertyComplaintRegistration b=null;
	try
	{
	    if (log.isDebugEnabled())
	    {
		log.debug("save Method is called ");
	    }
	    b=(PropertyComplaintRegistration)getHibernateTemplate().merge(taxExemptionNonResidential);
	    
	    if(b!=null){
	    	return b.getPropertyComplaintRegistrationID();
	    }
	} catch (NullPointerException nullpointerexception)
	{
	    log.error(nullpointerexception.getStackTrace());
	    throw new NullPointerException();
	} catch (HibernateException hibernateException)
	{
	    hibernateException.printStackTrace();
	    log.error(hibernateException.getStackTrace());
	    throw new HibernateException(hibernateException.getMessage());
	} catch (Exception exception)
	{
	    exception.printStackTrace();
	    log.error(exception.getStackTrace());
	    throw new RuntimeException(exception.getCause());
	}
	return  b.getPropertyComplaintRegistrationID();
}

@Override
public PropertyComplaintRegistration get(long rtiApplicationRefId) {
	try {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called " + rtiApplicationRefId);
		}
		return (PropertyComplaintRegistration) getHibernateTemplate().get(PropertyComplaintRegistration.class, new Long(rtiApplicationRefId));
	} catch (Exception exception) {
		log.error(exception.getStackTrace(), exception);
		exception.printStackTrace();
	}
	return null;
}


@Override
public PropertyComplaintRegistration getDetails(long rtiApplicationId) {
	try{

		String sqlQuery="select taxExemptionNonResidential from PropertyComplaintRegistration taxExemptionNonResidential where rti_ref_id = "+rtiApplicationId;

		Query query = getSession().createQuery(sqlQuery);

		List list = query.list();

		if (list != null && list.size() > 0)     
			return (PropertyComplaintRegistration) list.get(0);
	}catch(Exception e){
		log.error(e.getStackTrace());
		e.printStackTrace();
	}
	return null;
}

@Override
public PropertyComplaintRegistration merge(PropertyComplaintRegistration propertyComplaintRegistration) {
	try {
		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return (PropertyComplaintRegistration) getHibernateTemplate().merge(propertyComplaintRegistration);
	} catch (Exception exception) {
		log.error(exception.getStackTrace(), exception);
		exception.printStackTrace();
	}
	return null;
}



}

