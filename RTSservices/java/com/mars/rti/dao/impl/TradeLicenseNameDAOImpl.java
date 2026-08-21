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

import com.mars.rti.dao.TradeLicenseNameChangeDAO;
import com.mars.rti.model.TradeLicenseNameChange;
@Repository
public class TradeLicenseNameDAOImpl  extends HibernateDaoSupport implements TradeLicenseNameChangeDAO{

	private static final Log log = (Log) LogFactory.getLog(TradeLicenseNameDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveTradeLicenseNameChange(TradeLicenseNameChange tradeLicenseNameChange) {

		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			System.out.println(tradeLicenseNameChange);
			getHibernateTemplate().saveOrUpdate(tradeLicenseNameChange);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			System.out.println(exception);
			exception.printStackTrace();
		}
	}

	@Override
	public long tradeLicenseNameChangeSave(TradeLicenseNameChange tradeLicenseNameChange) {
		TradeLicenseNameChange b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (TradeLicenseNameChange) getHibernateTemplate().merge(tradeLicenseNameChange);

			if (b != null) {
				return b.getTradeLicenseNameID();
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
		return b.getTradeLicenseNameID();
	}

	@Override
	public TradeLicenseNameChange get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (TradeLicenseNameChange) getHibernateTemplate().get(TradeLicenseNameChange.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
	@Override
	public TradeLicenseNameChange getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select tradeLicenseNameChange from TradeLicenseNameChange tradeLicenseNameChange where rtiRefId = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (TradeLicenseNameChange) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}


}

