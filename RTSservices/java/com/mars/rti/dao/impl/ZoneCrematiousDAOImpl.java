package com.mars.rti.dao.impl;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.ZoneCrematiousDAO;
import com.mars.rti.model.ZoneCrematious;
@Repository
public class ZoneCrematiousDAOImpl  extends HibernateDaoSupport implements ZoneCrematiousDAO {
	
	private static final Log log = LogFactory.getLog(ZoneCrematiousDAOImpl.class);
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
//	@Override
//	public List<ZoneCrematious> getAllZoneCrematiousList(Integer zoneNo) {
//		try{
//
//			List<ZoneCrematious> list=null;
//			
//			String sqlQuery="select ch from ZoneCrematious ch where ch.zoneId = "+zoneNo;
//
//			Query query = getSession().createQuery(sqlQuery);
//
//			 list = query.list();
//
//			if (list != null && list.size() > 0)     
//				return list;
//		}catch(Exception e){
//			log.error(e.getStackTrace());
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@Override
	public List<ZoneCrematious> getAllZoneCrematiousList(Integer zoneNo) {

	    List<ZoneCrematious> list = new ArrayList<>();

	    try {
	        String hql = "FROM ZoneCrematious z WHERE z.isActive = true";

	        if (zoneNo != null) {
	            hql += " AND z.zoneId = :zoneId";
	        }

	        hql += " ORDER BY z.zoneId, z.crematoriumName";

	        Query query = getSession().createQuery(hql);

	        if (zoneNo != null) {
	            query.setParameter("zoneId", zoneNo);
	        }

	        list = query.list();

	    } catch (Exception e) {
	        log.error("Error fetching Zone Crematorium list", e);
	    }

	    return list; // NEVER return null
	}

}
