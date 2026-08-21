package com.mars.common.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.dao.DepartmentLevelDAO;
import com.mars.common.model.DepartmentLevel;


@Repository
public class DepartmentLevelDAOImpl extends HibernateDaoSupport implements DepartmentLevelDAO{

	
	private static final Log log = LogFactory.getLog(DepartmentLevelDAOImpl.class);
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	
	@Override
	public List<DepartmentLevel> getAll() {
		try {

		      if (log.isDebugEnabled()) {
		        log.debug("get all Method is called for Permission");
		      }
			    return getHibernateTemplate().loadAll(DepartmentLevel.class);
		    } catch (NullPointerException nullpointerexception) {
		      log.error(nullpointerexception.getStackTrace());
		      throw new NullPointerException();
		    } catch (HibernateException hibernateException) {
		      log.error(hibernateException.getStackTrace());
		      throw new HibernateException(hibernateException.getMessage());
		    } catch (Exception exception) {
		      log.error(exception.getStackTrace());
		      throw new RuntimeException(exception.getCause());
		    }
		  }

	@Override
	public DepartmentLevel getByName(String name) {
		try{
			
			String sqlQuery="select departmentLevel from DepartmentLevel departmentLevel where departmentLevel.userDepartmentLevel = "+name;

			Query query = getSession().createQuery(sqlQuery);

			 List<DepartmentLevel> list = query.list();

			if (list != null && list.size() > 0)     
				return list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
}
