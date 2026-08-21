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

import com.mars.rti.dao.TaxExmeptionDAO;
import com.mars.rti.model.PropertyTaxExemption;

@Repository
public class TaxExmeptionDAOImpl extends HibernateDaoSupport implements TaxExmeptionDAO{

private static final Log log = LogFactory.getLog(TaxExemptionNonResidentialDAOImpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public void saveTaxExemptionNonResidential(PropertyTaxExemption taxExemptionNonResidential) {
		
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
	public long getTaxExemptionNonResidentialId(PropertyTaxExemption taxExemptionNonResidential) {
		PropertyTaxExemption b=null;
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    b=(PropertyTaxExemption)getHibernateTemplate().merge(taxExemptionNonResidential);
		    
		    if(b!=null){
		    	return b.getTaxExemptionId();
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
		return  b.getTaxExemptionId();
	}

	@Override
	public PropertyTaxExemption get(long rtiApplicationRefId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiApplicationRefId);
			}
			return (PropertyTaxExemption) getHibernateTemplate().get(PropertyTaxExemption.class, new Long(rtiApplicationRefId));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	@Override
	public PropertyTaxExemption getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select taxExemptionNonResidential from PropertyTaxExemption taxExemptionNonResidential where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (PropertyTaxExemption) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PropertyTaxExemption merge(PropertyTaxExemption propertyTaxExemption) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (PropertyTaxExemption) getHibernateTemplate().merge(propertyTaxExemption);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
}
