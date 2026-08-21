package com.mars.rti.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.LayoutDAO;
import com.mars.rti.model.LayoutOfBuilding;

@Repository("LayoutDAO")
public class LayoutDAOImpl extends HibernateDaoSupport implements LayoutDAO {

	private static final Log log = LogFactory.getLog(LayoutDAO.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void layoutRegistrationCerfificate(LayoutOfBuilding layoutOfBuilding) {
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    getHibernateTemplate().saveOrUpdate(layoutOfBuilding);
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
	public long layoutOfBuildingSave(LayoutOfBuilding layOutOfBuilding) {
		// TODO Auto-generated method stub
		LayoutOfBuilding b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (LayoutOfBuilding) getHibernateTemplate().merge(layOutOfBuilding);

			if (b != null) {
				return b.getLayoutRegistrationId();
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
		return b.getLayoutRegistrationId();
	}

	@Override
	public LayoutOfBuilding get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (LayoutOfBuilding) getHibernateTemplate().get(LayoutOfBuilding.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	

}
