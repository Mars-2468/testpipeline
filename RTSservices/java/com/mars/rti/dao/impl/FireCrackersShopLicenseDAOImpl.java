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

import com.mars.rti.dao.FireCrackersShopLicenseDAO;
import com.mars.rti.model.FireCrackersShopLicense;
@Repository
public class FireCrackersShopLicenseDAOImpl extends HibernateDaoSupport implements FireCrackersShopLicenseDAO{

	private static final Log log = LogFactory.getLog(FireCrackersShopLicenseDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public void saveFireCrackersShopLicense(FireCrackersShopLicense fireCrackersShopLicense) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Durga Utsav Mandap Permission save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(fireCrackersShopLicense);
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
	public long fireCrackersShopLicenseSave(FireCrackersShopLicense fireCrackersShopLicense) {
		FireCrackersShopLicense b;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (FireCrackersShopLicense) getHibernateTemplate().merge(fireCrackersShopLicense);

			if (b != null) {
				return b.getFireCrackersShopLicenseId();
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
		return b.getFireCrackersShopLicenseId();
	}

	@Override
	public FireCrackersShopLicense get(long id) {
		// TODO Auto-generated method stub
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (FireCrackersShopLicense) getHibernateTemplate().get(FireCrackersShopLicense.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	@Override
	public FireCrackersShopLicense merge(FireCrackersShopLicense fireCrackersShopLicense) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (FireCrackersShopLicense) getHibernateTemplate().merge(fireCrackersShopLicense);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public FireCrackersShopLicense getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select fireCrackersShopLicense from FireCrackersShopLicense fireCrackersShopLicense where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (FireCrackersShopLicense) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	

}
