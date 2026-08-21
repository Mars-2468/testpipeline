package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.FireFloorTypesDAO;
import com.mars.rti.model.FireFloorTypes;
import com.mars.rti.model.SubTypeOfbuilding;

@Repository
public class FireFloorTypesDAOImpl extends HibernateDaoSupport implements FireFloorTypesDAO {
	private static final Log log = LogFactory.getLog(FireRecommendationTypeOfBuildingDAOimpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<FireFloorTypes> getFireFloorTypes() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select fireFloorTypes from FireFloorTypes fireFloorTypes order by fireFloorTypes.fireFloorTypesId";
			Query query = getSession().createQuery(strQuery);
			List<FireFloorTypes> fireFloorTypes = query.list();
			if (fireFloorTypes != null && fireFloorTypes.size() > 0)
				return fireFloorTypes;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	@Override
	public List<FireFloorTypes> getList(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select fireFloorTypes from FireFloorTypes fireFloorTypes where fireFloorTypesId ="+id+" order by fireFloorTypes.fireFloorTypesId";
			Query query = getSession().createQuery(strQuery);
			List<FireFloorTypes> fireFloorTypes = query.list();
			if (fireFloorTypes != null && fireFloorTypes.size() > 0)
				return fireFloorTypes;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
	
}
