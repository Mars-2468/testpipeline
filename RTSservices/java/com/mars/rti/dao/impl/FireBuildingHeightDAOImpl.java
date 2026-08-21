package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.FireBuildingHeightDAO;
import com.mars.rti.model.FireBuildingHeight;

@Repository
public class FireBuildingHeightDAOImpl extends HibernateDaoSupport implements FireBuildingHeightDAO{
	
	private static final Log log = LogFactory.getLog(FireBuildingHeightDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<FireBuildingHeight> getTypeOfBuildinhHeight() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select fireBuildingHeight from FireBuildingHeight fireBuildingHeight order by fireBuildingHeight.fireBuildingHeightId";
			Query query = getSession().createQuery(strQuery);
			List<FireBuildingHeight> fireBuidlingTypeHeight = query.list();
			if (fireBuidlingTypeHeight != null && fireBuidlingTypeHeight.size() > 0)
				return fireBuidlingTypeHeight;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
}
