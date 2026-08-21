package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.NOCOfTradeDAO;
import com.mars.rti.model.NOCOfTrade;

@Repository
public class NOCOfTradeDAOImpl extends HibernateDaoSupport implements NOCOfTradeDAO{

	private static final Log log = LogFactory.getLog(NOCOfTradeDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveNOCOfTrade(NOCOfTrade nocTrade) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("NOCOfTrade save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(nocTrade);
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
	}

	@Override
	public long nocTradeSave(NOCOfTrade nocTrade) {
		NOCOfTrade b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (NOCOfTrade) getHibernateTemplate().merge(nocTrade);

			if (b != null) {
				return b.getNocTradeId();
			}
		} catch (NullPointerException nullpointerexception) {
			log.error(nullpointerexception.getStackTrace());
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
			log.error(hibernateException.getStackTrace());
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error(exception.getStackTrace());
			throw new RuntimeException(exception.getCause());
		}
		return b.getNocTradeId();
	}

	@Override
	public NOCOfTrade get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (NOCOfTrade) getHibernateTemplate().get(NOCOfTrade.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	@Override
	public NOCOfTrade getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select nocTrade from NOCOfTrade nocTrade where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (NOCOfTrade) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

}
