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

import com.mars.rti.dao.TradeLicenseTransferDAO;
import com.mars.rti.model.TradeLicenseTransfer;
import com.mars.rti.model.TradeTypes;

@Repository
public class TradeLicenseTransferDAOImpl extends HibernateDaoSupport implements TradeLicenseTransferDAO {
	private static final Log log = LogFactory.getLog(TradeLicenseTransferDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveTradeLicenseTransfer(TradeLicenseTransfer tradeLicenseTransfer) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("TradeLicenseTransfer save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(tradeLicenseTransfer);
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
	public long tradeLicenseTransferSave(TradeLicenseTransfer tradeLicenseTransfer) {
		TradeLicenseTransfer b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (TradeLicenseTransfer) getHibernateTemplate().merge(tradeLicenseTransfer);

			if (b != null) {
				return b.getTradeLicenseTransferId();
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
		return b.getTradeLicenseTransferId();
	}

	@Override
	public TradeLicenseTransfer get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (TradeLicenseTransfer) getHibernateTemplate().get(TradeLicenseTransfer.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
	@Override
	public TradeLicenseTransfer getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select tradeLicenseTransfer from TradeLicenseTransfer tradeLicenseTransfer where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (TradeLicenseTransfer) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<TradeTypes> gettradeTypes() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select tradeTypes from TradeTypes tradeTypes order by tradeTypes.Id";

			//String strQuery = "select tradeTypes from TradeTypes tradeTypes order by tradeTypes.Id";
			Query query = getSession().createQuery(strQuery);
			List<TradeTypes> tradeTypes = query.list();
			if (tradeTypes != null && tradeTypes.size() > 0)
				return tradeTypes;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

}
