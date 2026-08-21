package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.CitizenHospitalDAO;
import com.mars.rti.model.CitizenHospital;

@Repository
public class CitizenHospitalDAOImpl extends HibernateDaoSupport implements CitizenHospitalDAO{
	
	private static final Log log = LogFactory.getLog(CitizenHospitalDAOImpl.class);
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<CitizenHospital> getAllHospitalList(String zoneNo) {
		try{

			List<CitizenHospital> list=null;
			
			String sqlQuery="select ch from CitizenHospital ch where ch.zone_id = "+zoneNo;

			Query query = getSession().createQuery(sqlQuery);

			 list = query.list();

			if (list != null && list.size() > 0)     
				return list;
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	

}
