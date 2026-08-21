package com.mars.rti.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.FireFeesMainDAO;
import com.mars.rti.model.FireFeesMain;

@Repository
public class FireFessMainDAOImpl extends HibernateDaoSupport implements FireFeesMainDAO{
	private static final Log log = LogFactory.getLog(FireFessMainDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	@Override
	public FireFeesMain getFireMainFees(long fireBuildingType, long fireBuildingHeight) {
	    try {
	        if (log.isDebugEnabled()) {
	            log.debug("getFireMainFees method called");
	        }

	        String strQuery = "FROM FireFeesMain ffm WHERE ffm.typeOfBuildingId = :fireBuildingType AND ffm.fireHeightOfBuildingID = :fireBuildingHeight";

	        Query query = getSession().createQuery(strQuery);
	        query.setParameter("fireBuildingType", fireBuildingType);
	        query.setParameter("fireBuildingHeight", fireBuildingHeight);

	        FireFeesMain fireFeesMain = (FireFeesMain) query.uniqueResult(); // Use uniqueResult to get a single result

	        return fireFeesMain;
	    } catch (Exception exception) {
	        log.error(exception.getStackTrace(), exception);
	        exception.printStackTrace();
	    }
	    return null;
	}

}
