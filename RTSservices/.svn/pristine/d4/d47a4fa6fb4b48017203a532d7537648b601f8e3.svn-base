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

import com.mars.rti.dao.ZoneCertificatesDAO;
import com.mars.rti.model.ZoneCertificates;


@Repository("ZoneCertificate")
public class ZoneCertificatesDAOImpl extends HibernateDaoSupport implements ZoneCertificatesDAO {

private static final Log log = LogFactory.getLog(ZoneCertificatesDAOImpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	
	@Override
	public void saveZoneApplication(ZoneCertificates zoneCertificates) {
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    getHibernateTemplate().saveOrUpdate(zoneCertificates);
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
	public long getZoneApplicationId(ZoneCertificates zoneCertificates) {
		// TODO Auto-generated method stub
		ZoneCertificates b=null;
				try
				{
				    if (log.isDebugEnabled())
				    {
					log.debug("save Method is called ");
				    }
				    b=(ZoneCertificates)getHibernateTemplate().merge(zoneCertificates);
				    
				    if(b!=null){
				    	return b.getZoneCertificatesId();
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
				return b.getZoneCertificatesId();
	}
	
	
	@Override
	public ZoneCertificates get(long rtiApplicationRefId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiApplicationRefId);
			}
			return (ZoneCertificates) getHibernateTemplate().get(ZoneCertificates.class, new Long(rtiApplicationRefId));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	@Override
	public ZoneCertificates getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select zoneCertificates from ZoneCertificates zoneCertificates where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (ZoneCertificates) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ZoneCertificates merge(ZoneCertificates zoneCertificates) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (ZoneCertificates) getHibernateTemplate().merge(zoneCertificates);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
	}


