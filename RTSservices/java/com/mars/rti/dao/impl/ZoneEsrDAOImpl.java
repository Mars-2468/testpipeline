package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.ZoneEsrDAO;
import com.mars.rti.model.ZoneEsr;

@Repository
public class ZoneEsrDAOImpl extends HibernateDaoSupport implements ZoneEsrDAO {

	private static final Log log = LogFactory.getLog(ZoneEsrDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public List<ZoneEsr> getall(long zoneNo) {
		try {

			List<ZoneEsr> list = null;
			String sqlQuery = "select ze from ZoneEsr ze  where ze.zoneId  = "
					+ zoneNo;

			Query query = getSession().createQuery(sqlQuery);

			list = query.list();

			if (list != null && list.size() > 0)
				return list;
		} catch (Exception e) {
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

}
