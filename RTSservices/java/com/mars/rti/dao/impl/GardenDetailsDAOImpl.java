package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.GardenDetailsDAO;
import com.mars.rti.model.GardenDetails;
import com.mars.rti.model.GardenFeedBacKDetails;

@Repository
public class GardenDetailsDAOImpl extends HibernateDaoSupport implements GardenDetailsDAO{

	private static final Log log = LogFactory.getLog(MandapPermissionDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public GardenDetails getGardenDetails(long zoneId, long gardenId) {
		try{

			String sqlQuery="select gardenDetails from GardenDetails gardenDetails where gardenDetails.gardendetailsid = "+gardenId+" and gardenDetails.zoneid="+zoneId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (GardenDetails) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public GardenFeedBacKDetails saveGardenFeedBack(GardenFeedBacKDetails gd) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (GardenFeedBacKDetails) getHibernateTemplate().merge(gd);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	
}
