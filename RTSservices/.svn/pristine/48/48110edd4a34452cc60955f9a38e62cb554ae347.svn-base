package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.FireDepartmentWiseLoginDAO;
import com.mars.rti.model.FireDepartmentWiseLogin;

@Repository
public class FireDepartmentWiseLoginDAOImpl extends HibernateDaoSupport implements FireDepartmentWiseLoginDAO {

	private static final Log log = LogFactory.getLog(FireDepartmentWiseLoginDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<FireDepartmentWiseLogin> getFireDepartmentWiseLogin() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select fireDepartmentWiseLogin from FireDepartmentWiseLogin fireDepartmentWiseLogin order by fireDepartmentWiseLogin.fireDepartmentWiseLoginId asc";
			Query query = getSession().createQuery(strQuery);
			List<FireDepartmentWiseLogin> fireDepartmentWiseLogin = query.list();
			if (fireDepartmentWiseLogin != null && fireDepartmentWiseLogin.size() > 0)
				return fireDepartmentWiseLogin;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	@Override
	public List<FireDepartmentWiseLogin> getList(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select fireDepartmentWiseLogin from FireDepartmentWiseLogin fireDepartmentWiseLogin where fireDepartmentWiseLoginId ="+id+" order by fireDepartmentWiseLogin.fireDepartmentWiseLoginId";
			Query query = getSession().createQuery(strQuery);
			List<FireDepartmentWiseLogin> fireDepartmentWiseLogin = query.list();
			if (fireDepartmentWiseLogin != null && fireDepartmentWiseLogin.size() > 0)
				return fireDepartmentWiseLogin;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
}
