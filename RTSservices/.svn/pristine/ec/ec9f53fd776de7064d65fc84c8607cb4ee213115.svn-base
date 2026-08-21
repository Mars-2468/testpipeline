package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.FireSubDepartmentWiseLoginDAO;
import com.mars.rti.model.FireSubDepartmentWiseLogin;

@Repository
public class FireSubDepartmentWiseLoginDAOImpl extends HibernateDaoSupport implements FireSubDepartmentWiseLoginDAO {

	
	private static final Log log = LogFactory.getLog(FireDepartmentWiseLoginDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<FireSubDepartmentWiseLogin> getFireSubDepartmentWiseLogin() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select fireSubDepartmentWiseLogin from FireSubDepartmentWiseLogin fireSubDepartmentWiseLogin order by fireSubDepartmentWiseLogin.fireSubDepartmentWiseLoginId asc";
			Query query = getSession().createQuery(strQuery);
			List<FireSubDepartmentWiseLogin> fireSubDepartmentWiseLogin = query.list();
			if (fireSubDepartmentWiseLogin != null && fireSubDepartmentWiseLogin.size() > 0)
				return fireSubDepartmentWiseLogin;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	@Override
	public List<FireSubDepartmentWiseLogin> getList(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select fireSubDepartmentWiseLogin from FireSubDepartmentWiseLogin fireSubDepartmentWiseLogin where fireSubDepartmentWiseLoginId ="+id+" order by fireSubDepartmentWiseLogin.fireSubDepartmentWiseLoginId";
			Query query = getSession().createQuery(strQuery);
			List<FireSubDepartmentWiseLogin> fireSubDepartmentWiseLogin = query.list();
			if (fireSubDepartmentWiseLogin != null && fireSubDepartmentWiseLogin.size() > 0)
				return fireSubDepartmentWiseLogin;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
}
