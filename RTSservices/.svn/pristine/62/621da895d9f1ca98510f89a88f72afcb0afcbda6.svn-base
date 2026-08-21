package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.PropertyWardDAO;
import com.mars.rti.model.PropertyWard;

@Repository
public class PropertyWardDAOImpl extends HibernateDaoSupport implements PropertyWardDAO{

	private static final Log log = LogFactory.getLog(PropertyWardDAOImpl.class);
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	@Override
	public List<PropertyWard> getWards(String ward) {
		try{
		
			int zone = Integer.parseInt(ward);
			String sqlQuery="select propertyWard from PropertyWard propertyWard where propertyWard.zoneId = "+ward;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return list;
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
}
