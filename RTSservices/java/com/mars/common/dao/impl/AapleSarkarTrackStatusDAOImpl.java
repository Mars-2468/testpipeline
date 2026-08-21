package com.mars.common.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.AapleSarkarTrackStatusDAO;
import com.mars.rti.dao.impl.RTIApplicationDAOImpl;
import com.mars.rti.model.RTIApplication;

@Repository("aapleSarkarTrackStatusDAO")
public class AapleSarkarTrackStatusDAOImpl extends HibernateDaoSupport implements AapleSarkarTrackStatusDAO{
	
	private static final Log log = LogFactory.getLog(RTIApplicationDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	
	public RTIApplication findByRTIApplicationNumber(String rtiApplnNumber) {

	    // Normalize input also (remove / and trim)
	    String normalizedInput = rtiApplnNumber.replace("/", "").trim();

	    String hql = "from RTIApplication r " +
	                 "where replace(r.rtiApplnNumber, '/', '') = :appNo";

	    Query query = getSession().createQuery(hql);
	    query.setParameter("appNo", normalizedInput);

	    List<RTIApplication> list = query.list();

	    RTIApplication rtiapp = null;
	    if (list != null && !list.isEmpty()) {
	        rtiapp = list.get(0);
	    }

	    System.out.println("@@@@@@@@@@@@@@@@@@@@@ " + rtiapp);
	    return rtiapp;
	}

	public RTIApplication get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (RTIApplication) getHibernateTemplate().get(RTIApplication.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

}
