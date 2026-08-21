package com.mars.rti.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.DogDetailsDAO;
import com.mars.rti.model.DogDetails;

@Repository("dogDetailsDAO")
public class DogDetailsDAOImpl extends HibernateDaoSupport implements DogDetailsDAO {

	private static final Log log =LogFactory.getLog(DogDetailsDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	
	public void dogDetailsSave(DogDetails dogDetails) {
		// TODO Auto-generated method stub
		
				try
				{
				    if (log.isDebugEnabled())
				    {
					log.debug("save Method is called ");
				    }
				    getHibernateTemplate().saveOrUpdate(dogDetails);
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
	
	
}
