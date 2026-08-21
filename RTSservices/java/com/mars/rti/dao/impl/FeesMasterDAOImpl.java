package com.mars.rti.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.FeesMasterDAO;
import com.mars.rti.model.FeesMaster;


@Repository
public class FeesMasterDAOImpl extends HibernateDaoSupport implements FeesMasterDAO  {

	private static final Log log = LogFactory.getLog(FeesMasterDAOImpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public FeesMaster getFees(long rtiapplicationserviceid) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiapplicationserviceid);
			}
			return (FeesMaster) getHibernateTemplate().get(FeesMaster.class, new Long(rtiapplicationserviceid));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
}
