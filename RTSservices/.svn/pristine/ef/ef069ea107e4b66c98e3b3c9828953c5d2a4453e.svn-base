package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.FireFeesMasterUpdatedDAO;
import com.mars.rti.model.FireFeesMasterUpdated;

@Repository
public class FireFeesMasterUpdatedDAOImpl extends HibernateDaoSupport implements FireFeesMasterUpdatedDAO {
	private static final Log log = LogFactory.getLog(FireFeesMasterUpdatedDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<FireFeesMasterUpdated> getFireFeesMasterUpdated(long typeOfBuilding,long typeOfConstruction,long typeOfHeight,long catagory,long floorName) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select fireFeesMasterUpdated from FireFeesMasterUpdated fireFeesMasterUpdated order by fireFeesMasterUpdated.fireFeesMasterUpdatedId";
			Query query = getSession().createQuery(strQuery);
			List<FireFeesMasterUpdated> fireFeesMasterUpdated = query.list();
			if (fireFeesMasterUpdated != null && fireFeesMasterUpdated.size() > 0)
				return fireFeesMasterUpdated;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	@Override
	public FireFeesMasterUpdated getList(long typeOfBuilding,long typeOfConstruction,long typeOfHeight,long catagory,long floorName) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select fireFeesMasterUpdated from FireFeesMasterUpdated fireFeesMasterUpdated where categories ="+floorName+" and typeOfConstructions ="+typeOfConstruction+" and heightOfBuilding = "+typeOfHeight+" and typeOfBuilding = "+typeOfBuilding+" and catagory="+catagory+" order by fireFeesMasterUpdated.fireFeesMasterUpdatedId";
			Query query = getSession().createQuery(strQuery);
			List list = query.list();
			
			if(list!=null && list.size()>0){
				return (FireFeesMasterUpdated) list.get(0);
			}
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
	
	
}
