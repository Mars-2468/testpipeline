package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.TradeTypeDAO;
import com.mars.rti.model.TradeType;

@Repository
public class TradeTypeDAOImpl extends HibernateDaoSupport implements TradeTypeDAO{

	private static final Log log = LogFactory.getLog(TradeTypeDAOImpl.class);

	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<TradeType> getall() {
		try{                                     
			
			 if (log.isDebugEnabled()) {
			        log.debug("get all Method is called for Permission");
			      }
	    return (List<TradeType>) getHibernateTemplate().loadAll(TradeType.class);
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
