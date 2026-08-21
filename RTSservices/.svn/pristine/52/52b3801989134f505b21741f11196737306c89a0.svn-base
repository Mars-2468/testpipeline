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

import com.mars.rti.dao.TradeLicenseTypeChangeDAO;
import com.mars.rti.model.TradeLicenseTypeChange;


@Repository
public class TradeLicenseTypeChangeDAOImpl extends HibernateDaoSupport implements TradeLicenseTypeChangeDAO{
	
	private static final Log log = (Log) LogFactory.getLog(TradeLicenseTypeChangeDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveTradeLicenseTypeChange(TradeLicenseTypeChange tradeLicenseTypeChange) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			System.out.println(tradeLicenseTypeChange);
			getHibernateTemplate().saveOrUpdate(tradeLicenseTypeChange);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			System.out.println(exception);
			exception.printStackTrace();
		}
	}
	
	@Override
	public long tradeLicenseTypeChangeSave(TradeLicenseTypeChange tradeLicenseTypeChange) {
		TradeLicenseTypeChange tradeLicenseType = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			tradeLicenseType = (TradeLicenseTypeChange) getHibernateTemplate().merge(tradeLicenseTypeChange);

			if (tradeLicenseType != null) {
				return tradeLicenseType.getTradeLicenseTypeID();
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
		return tradeLicenseType.getTradeLicenseTypeID();
		
	}

	@Override
	public TradeLicenseTypeChange get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (TradeLicenseTypeChange) getHibernateTemplate().get(TradeLicenseTypeChange.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
	@Override
	public TradeLicenseTypeChange getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select tradeLicenseTypeChange from TradeLicenseTypeChange tradeLicenseTypeChange where rtiRefId = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (TradeLicenseTypeChange) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}


}
