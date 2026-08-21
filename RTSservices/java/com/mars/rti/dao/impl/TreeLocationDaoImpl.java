package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.TreeLocationDao;
import com.mars.rti.model.TreeLocation;
@Repository
public class TreeLocationDaoImpl extends HibernateDaoSupport implements  TreeLocationDao {

	private static final Log log = LogFactory.getLog(TreeLocationDaoImpl.class);
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<TreeLocation> gettrLocations() {
		try{
			
			 if (log.isDebugEnabled()) {
			        log.debug("get all Method is called for Permission");
			      }
			 
			    return (List<TreeLocation>) getHibernateTemplate().loadAll(TreeLocation.class);
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
}
