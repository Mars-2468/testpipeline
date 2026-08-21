package com.mars.rti.dao.impl;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.NOCFirerecommendationDAO;
import com.mars.rti.model.NOCFireRecommendation;
@Repository
public class NOCFirerecommendationDAOImpl extends HibernateDaoSupport implements  NOCFirerecommendationDAO {
	
	private static final Log log = LogFactory.getLog(NOCFirerecommendationDAOImpl.class);
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<NOCFireRecommendation> getNOCFirerecommendation() {
		try{
			
			 if (log.isDebugEnabled()) {
			        log.debug("get all Method is called for Permission");
			      }
			 
			    return (List<NOCFireRecommendation>) getHibernateTemplate().loadAll(NOCFireRecommendation.class);
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
	public NOCFireRecommendation get(long id) {
		try{
			
			 if (log.isDebugEnabled()) {
			        log.debug("get all Method is called for Permission");
			      }
			 
			    return (NOCFireRecommendation) getHibernateTemplate().get(NOCFireRecommendation.class, new Long(id));
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
