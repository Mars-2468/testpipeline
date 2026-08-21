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

import com.mars.rti.dao.TradeLicencePartnerCountUpdateDAO;
import com.mars.rti.model.TradeLicencePartnerCountUpdate;

@Repository("TradeLicencePartnerCountUpdate")
public class TradeLicencePartnerCountUpdateDAOImpl extends HibernateDaoSupport implements TradeLicencePartnerCountUpdateDAO  {

	
private static final Log log = LogFactory.getLog(TradeLicencePartnerCountUpdateDAOImpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}	
	
	
	@Override
	public void saveTradeLicence(TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate) {
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    getHibernateTemplate().saveOrUpdate(tradeLicencePartnerCountUpdate);
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
	public long getTradeLicenceId(TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate) {
		TradeLicencePartnerCountUpdate b=null;
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    b=(TradeLicencePartnerCountUpdate)getHibernateTemplate().merge(tradeLicencePartnerCountUpdate);
		    
		    if(b!=null){
		    	return b. getTradeLicencePartnerCountUpdateId();
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
		return b. getTradeLicencePartnerCountUpdateId();
}
	

	@Override
	public TradeLicencePartnerCountUpdate get(long rtiApplicationRefId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiApplicationRefId);
			}
			return (TradeLicencePartnerCountUpdate) getHibernateTemplate().get(TradeLicencePartnerCountUpdate.class, new Long(rtiApplicationRefId));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public TradeLicencePartnerCountUpdate getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select tradeLicencePartnerCountUpdate from TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (TradeLicencePartnerCountUpdate) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}


	
	
	
}
