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

import com.mars.rti.dao.TradeLicenseOutdatedRenewalDAO;
import com.mars.rti.model.TradeLicenseOutdatedRenewalNotice;

@Repository
public class TradeLicenseOutdatedRenewalDAOImpl extends HibernateDaoSupport implements TradeLicenseOutdatedRenewalDAO {
	
	private static final Log log = (Log) LogFactory.getLog(TradeLicenseOutdatedRenewalDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveTradeLicenseOutdatedRenewal(TradeLicenseOutdatedRenewalNotice tradeLicenseOutdatedRenewalNotice) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			System.out.println(tradeLicenseOutdatedRenewalNotice);
			getHibernateTemplate().saveOrUpdate(tradeLicenseOutdatedRenewalNotice);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			System.out.println(exception);
			exception.printStackTrace();
		}

	}

	@Override
	public long tradeLicenseOutdatedRenewalSave(TradeLicenseOutdatedRenewalNotice tradeLicenseOutdatedRenewalNotice) {
		
		TradeLicenseOutdatedRenewalNotice tradeLicenseOutdatedRenewal = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			tradeLicenseOutdatedRenewal = (TradeLicenseOutdatedRenewalNotice) getHibernateTemplate().merge(tradeLicenseOutdatedRenewalNotice);

			if (tradeLicenseOutdatedRenewal != null) {
				return tradeLicenseOutdatedRenewal.getTradeLicenseOutdatedRenewalID();
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
		return tradeLicenseOutdatedRenewal.getTradeLicenseOutdatedRenewalID();
	}

	@Override
	public TradeLicenseOutdatedRenewalNotice get(long id) {
		
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (TradeLicenseOutdatedRenewalNotice) getHibernateTemplate().get(TradeLicenseOutdatedRenewalNotice.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
	@Override
	public TradeLicenseOutdatedRenewalNotice getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select tradeLicenseOutdatedRenewalNotice from TradeLicenseOutdatedRenewalNotice tradeLicenseOutdatedRenewalNotice where rtiRefId = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (TradeLicenseOutdatedRenewalNotice) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

	}


