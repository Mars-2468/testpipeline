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

import com.mars.rti.dao.TradeLicenseCancellationDAO;
import com.mars.rti.model.TradeLicenseCancellation;
@Repository
public class TradeLicenseCancellationDAOImpl extends HibernateDaoSupport implements TradeLicenseCancellationDAO {

	private static final Log log = (Log) LogFactory.getLog(TradeLicenseCancellationDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveTradeLicenseCancel(TradeLicenseCancellation tradeLicenseCancellation) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			System.out.println(tradeLicenseCancellation);
			getHibernateTemplate().saveOrUpdate(tradeLicenseCancellation);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			System.out.println(exception);
			exception.printStackTrace();
		}
	}
	
	@Override
	public long tradeLicenseCancelSave(TradeLicenseCancellation tradeLicenseCancellation) {
		TradeLicenseCancellation tradeLicenseCancel = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			tradeLicenseCancel = (TradeLicenseCancellation) getHibernateTemplate().merge(tradeLicenseCancellation);

			if (tradeLicenseCancel != null) {
				return tradeLicenseCancel.getTradeLicenseCancellationID();
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
		return tradeLicenseCancel.getTradeLicenseCancellationID();
		
	}

	@Override
	public TradeLicenseCancellation get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (TradeLicenseCancellation) getHibernateTemplate().get(TradeLicenseCancellation.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
	@Override
	public TradeLicenseCancellation getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select tradeLicenseCancellation from TradeLicenseCancellation tradeLicenseCancellation where rtiRefId = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (TradeLicenseCancellation) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	


}
