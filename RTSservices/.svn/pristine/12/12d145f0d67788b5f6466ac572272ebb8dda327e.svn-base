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

import com.mars.rti.dao.TradeLicencePartnerChangeDAO;
import com.mars.rti.model.TradeLicencePartnerChange;

@Repository("TradeLicencePartnerChange")
public class TradeLicencePartnerChangeDAOImpl  extends HibernateDaoSupport implements TradeLicencePartnerChangeDAO {

private static final Log log = LogFactory.getLog(ZoneCertificatesDAOImpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}	
	
	
	@Override
	public void saveTradeLicence(TradeLicencePartnerChange tradeLicencePartnerChange) {
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    getHibernateTemplate().saveOrUpdate(tradeLicencePartnerChange);
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
	public long getTradeLicenceId(TradeLicencePartnerChange tradeLicencePartnerChange) {
		TradeLicencePartnerChange b=null;
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    b=(TradeLicencePartnerChange)getHibernateTemplate().merge(tradeLicencePartnerChange);
		    
		    if(b!=null){
		    	return b. getTradeLicencePartnerChangeId();
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
		return b. getTradeLicencePartnerChangeId();
}
	

	@Override
	public TradeLicencePartnerChange get(long rtiApplicationRefId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiApplicationRefId);
			}
			return (TradeLicencePartnerChange) getHibernateTemplate().get(TradeLicencePartnerChange.class, new Long(rtiApplicationRefId));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public TradeLicencePartnerChange getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select tradeLicencePartnerChange from TradeLicencePartnerChange tradeLicencePartnerChange where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (TradeLicencePartnerChange) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	

	
	
	
}
