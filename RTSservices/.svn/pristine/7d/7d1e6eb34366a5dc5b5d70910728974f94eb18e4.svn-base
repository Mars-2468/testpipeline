package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.SubTypeOfbuildingDAO;
import com.mars.rti.model.SubTypeOfbuilding;

@Repository
public class SubTypeOfbuildingDAOImpl extends HibernateDaoSupport implements SubTypeOfbuildingDAO {
	private static final Log log = LogFactory.getLog(FireRecommendationTypeOfBuildingDAOimpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<SubTypeOfbuilding> getSubTypeOfbuilding() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select subTypeOfbuilding from SubTypeOfbuilding subTypeOfbuilding order by subTypeOfbuilding.subTypeOfBuildingId";
			Query query = getSession().createQuery(strQuery);
			List<SubTypeOfbuilding> subTypeOfbuilding = query.list();
			if (subTypeOfbuilding != null && subTypeOfbuilding.size() > 0)
				return subTypeOfbuilding;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	@Override
	public List<SubTypeOfbuilding> getList(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select subTypeOfbuilding from SubTypeOfbuilding subTypeOfbuilding where fireTypeOfBuildingId ="+id+" order by subTypeOfbuilding.subTypeOfBuildingId";
			Query query = getSession().createQuery(strQuery);
			List<SubTypeOfbuilding> subTypeOfbuilding = query.list();
			if (subTypeOfbuilding != null && subTypeOfbuilding.size() > 0)
				return subTypeOfbuilding;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
	
}
