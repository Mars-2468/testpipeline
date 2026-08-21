package com.mars.rti.dao.impl;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.ZoneWardDAO;
import com.mars.rti.model.ZoneWard;
@Repository
public class ZoneWardDAOImpl  extends HibernateDaoSupport implements  ZoneWardDAO{
	private static final Log log = LogFactory.getLog(ZoneWardDAOImpl.class);
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	@Override
	public List<ZoneWard> getZoneWard(String zoneNo) {
		try{

			List<ZoneWard> list=null;
			
//			String sqlQuery="select ch from ZoneWard ch where ch.zone_id = "+zoneNo;
			
			String sqlQuery=   "select we from ZoneWard we  where we.zoneId  = "+zoneNo;

	
	Query query = getSession().createQuery(sqlQuery);

	 list = query.list();

	if (list != null && list.size() > 0)     
		return list;
   }
		catch(Exception e){
	log.error(e.getStackTrace());
	e.printStackTrace();
    }
   return null;
   }

	
		
	
}
