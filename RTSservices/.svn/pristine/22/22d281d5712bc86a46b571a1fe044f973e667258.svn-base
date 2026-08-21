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

import com.mars.rti.dao.WaterQualityComplaintDAO;
import com.mars.rti.model.WaterQualityComplaint;

@Repository
public class WaterQualityComplaintDAOImpl extends HibernateDaoSupport implements WaterQualityComplaintDAO {

	private static final Log log = LogFactory.getLog(WaterQualityComplaintDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	@Override
	public void saveWarterQualityComplaint(WaterQualityComplaint waterQualityComplaint) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Mandap save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(waterQualityComplaint);
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
	public long waterQualityComplaintSave(WaterQualityComplaint waterQualityComplaint) {
		WaterQualityComplaint b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (WaterQualityComplaint) getHibernateTemplate().merge(waterQualityComplaint);

			if (b != null) {
				return b.getNewWaterQualityComplaintId();
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
		return b.getNewWaterQualityComplaintId();
	}
	@Override
	public WaterQualityComplaint get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (WaterQualityComplaint) getHibernateTemplate().get(WaterQualityComplaint.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	@Override
	public List<WaterQualityComplaint> getAll() {
	try {

	      if (log.isDebugEnabled()) {
	        log.debug("get all Method is called for Permission");
	      }
		    return (List<WaterQualityComplaint>) getHibernateTemplate().loadAll(WaterQualityComplaint.class);
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
	@Override
	public WaterQualityComplaint getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select waterQualityComplaint from WaterQualityComplaint waterQualityComplaint where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (WaterQualityComplaint) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public WaterQualityComplaint merge(WaterQualityComplaint waterQualityComplaint) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (WaterQualityComplaint) getHibernateTemplate().merge(waterQualityComplaint);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}


}

