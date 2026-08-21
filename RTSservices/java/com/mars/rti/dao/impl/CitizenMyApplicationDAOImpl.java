package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.CitizenMyApplicationDAO;
import com.mars.rti.model.RTIApplication;

@Repository
public class CitizenMyApplicationDAOImpl extends HibernateDaoSupport implements CitizenMyApplicationDAO
{

	private static final Log log = LogFactory.getLog(CitizenMyApplicationDAOImpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<RTIApplication> getListOfCitizen(long mobileNo) {
		try 
	  	{
			String queryString = "select rtiapplication from RTIApplication rtiapplication where rtiapplication.mobileAppUserNumber="+mobileNo;
			
			Query query = getSession().createQuery(queryString);

			List<RTIApplication> list = query.list();

			if (list != null && list.size() > 0)     
				return list;
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
}
