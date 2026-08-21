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

import com.mars.rti.dao.MarriageCertificateDAO;
import com.mars.rti.model.MarriageCertificate;
import com.mars.rti.model.RTIApplication;

@Repository
public class MarriageCertificateDAOImpl extends HibernateDaoSupport implements MarriageCertificateDAO {

	private static final Log log = (Log) LogFactory.getLog(MarriageCertificateDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	 public void saveMarriageCertificate(MarriageCertificate marriageCertificate) {

		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			System.out.println(marriageCertificate);
			getHibernateTemplate().saveOrUpdate(marriageCertificate);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			System.out.println(exception);
			exception.printStackTrace();
		}
	}

	@Override
	public long marriageCertificateSave(MarriageCertificate marriageCertificate) {
		MarriageCertificate b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (MarriageCertificate) getHibernateTemplate().merge(marriageCertificate);

			if (b != null) {
				return b.getMarriageCertificateID();
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
		return b.getMarriageCertificateID();
	}

	@Override
	public MarriageCertificate get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (MarriageCertificate) getHibernateTemplate().get(MarriageCertificate.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	@Override
	public MarriageCertificate merge(MarriageCertificate marriageCertificate) {
		MarriageCertificate b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (MarriageCertificate) getHibernateTemplate().merge(marriageCertificate);

			if (b != null) {
				return b;
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
		return null;
	}
	@Override
	public MarriageCertificate saveOrUpdate(MarriageCertificate entity) {
	    try {
	        if (log.isDebugEnabled()) {
	            log.debug("update Method is called for entity with ID: " + entity.getRti_ref_id());
	        }
	        MarriageCertificate updatedEntity = getHibernateTemplate().merge(entity); // Merges and returns updated entity
	        getHibernateTemplate().flush(); // Ensures changes are persisted immediately
	        return updatedEntity;
	    } catch (Exception exception) {
	        log.error("Error updating RTIApplication entity with ID: " + entity.getRti_ref_id(), exception);
	        throw new RuntimeException("Error updating RTIApplication entity", exception);
	    }
	}


	@Override
	public MarriageCertificate getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select marriageCertificate from MarriageCertificate marriageCertificate where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (MarriageCertificate) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
}

