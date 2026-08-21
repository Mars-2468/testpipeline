package com.mars.rti.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.NursingOwnerDetailsDAO;
import com.mars.rti.model.NursingOwnerDetails;

@Repository
public class NursingOwnerDetailsDAOImpl extends HibernateDaoSupport implements NursingOwnerDetailsDAO{

	private static final Log log =LogFactory.getLog(NursingOwnerDetailsDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	
	@Override
	public NursingOwnerDetails mergeownerDetails(NursingOwnerDetails sd) {
		NursingOwnerDetails ndd=null;
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    ndd= getHibernateTemplate().merge(sd);
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
		return ndd;
}


	@Override
	public NursingOwnerDetails getOwnerDetails(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (NursingOwnerDetails) getHibernateTemplate().get(NursingOwnerDetails.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	

}
