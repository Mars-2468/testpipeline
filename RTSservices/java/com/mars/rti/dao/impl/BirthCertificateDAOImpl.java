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

import com.mars.rti.dao.BirthCertificateDAO;
import com.mars.rti.model.BirthCertificate;

@Repository("BirthCertificate")
public class BirthCertificateDAOImpl extends HibernateDaoSupport implements BirthCertificateDAO {

	private static final Log log = LogFactory
			.getLog(BirthCertificate.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public void birthRegistrationSave(BirthCertificate birthCertificate) {
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    getHibernateTemplate().saveOrUpdate(birthCertificate);
		}
		catch (NullPointerException nullpointerexception)
		{
		    log.error(nullpointerexception.getStackTrace());
		    throw new NullPointerException();
		}
		catch (HibernateException hibernateException)
		{
		    hibernateException.printStackTrace();
		    log.error(hibernateException.getStackTrace());
		    throw new HibernateException(hibernateException.getMessage());
		}
		catch (Exception exception)
		{
		    exception.printStackTrace();
		    log.error(exception.getStackTrace());
		    throw new RuntimeException(exception.getCause());
		}
}

	@Override
	public long birthCertificateSave(BirthCertificate birthCertificate) {
		BirthCertificate b=null;
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    b=(BirthCertificate)getHibernateTemplate().merge(birthCertificate);
		    
		    if(b!=null){
		    	return b.getBirthRegistrationId();
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
		return b.getBirthRegistrationId();
	}
	
	public BirthCertificate get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (BirthCertificate) getHibernateTemplate().get(BirthCertificate.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
	@Override
	public BirthCertificate getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select birthCertificate from BirthCertificate birthCertificate where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (BirthCertificate) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	

	
}
