package com.mars.rti.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.ConstructionOfBuildingDAO;
import com.mars.rti.model.ConstructionOfBuilding;

@Repository("ConstructionOfBuildingDAO")
public class ConstructionOfBuildingDAOImpl extends HibernateDaoSupport implements ConstructionOfBuildingDAO {
	
private static final Log log = LogFactory.getLog(ConstructionOfBuildingDAO.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void buildingRegistrationCerfificate(ConstructionOfBuilding constructionOfBuilding) {
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    getHibernateTemplate().saveOrUpdate(constructionOfBuilding);
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
	public long constructionOfBuildingSave(ConstructionOfBuilding constructionOfBuilding) {
		// TODO Auto-generated method stub
		ConstructionOfBuilding b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (ConstructionOfBuilding) getHibernateTemplate().merge(constructionOfBuilding);

			if (b != null) {
				return b.getBuildingRegistrationId();
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
		return b.getBuildingRegistrationId();
	}

	@Override
	public ConstructionOfBuilding get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (ConstructionOfBuilding) getHibernateTemplate().get(ConstructionOfBuilding.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
}
