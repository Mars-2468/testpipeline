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

import com.mars.rti.dao.TradeLicenseDuplicateCopyDAO;
import com.mars.rti.model.TradeLicenseDuplicateCopy;

@Repository
public class TradeLicenseDuplicateCopyDAOImpl extends HibernateDaoSupport implements TradeLicenseDuplicateCopyDAO{
	
	private static final Log log = (Log) LogFactory.getLog(TradeLicenseDuplicateCopyDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveTradeLicenseDuplicateCopy(TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			System.out.println(tradeLicenseDuplicateCopy);
			getHibernateTemplate().saveOrUpdate(tradeLicenseDuplicateCopy);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			System.out.println(exception);
			exception.printStackTrace();
		}

	}

	@Override
	public long tradeLicenseDuplicateCopySave(TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy) {

		TradeLicenseDuplicateCopy tradeLicenseCopy = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			tradeLicenseCopy = (TradeLicenseDuplicateCopy) getHibernateTemplate().merge(tradeLicenseDuplicateCopy);

			if (tradeLicenseCopy != null) {
				return tradeLicenseCopy.getTradeLicenseDuplicateID();
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
		return tradeLicenseDuplicateCopy.getTradeLicenseDuplicateID();

	}

	@Override
	public TradeLicenseDuplicateCopy get(long id) {

		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (TradeLicenseDuplicateCopy) getHibernateTemplate().get(TradeLicenseDuplicateCopy.class,
					new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
	@Override
	public TradeLicenseDuplicateCopy getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select tradeLicenseDuplicateCopy from TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (TradeLicenseDuplicateCopy) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	

}
