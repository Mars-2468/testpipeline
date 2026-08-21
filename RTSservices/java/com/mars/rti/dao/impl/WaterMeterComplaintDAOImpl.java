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

import com.mars.rti.dao.WaterMeterComplaintDAO;
import com.mars.rti.model.WaterMeterComplaint;
@Repository
public class WaterMeterComplaintDAOImpl extends HibernateDaoSupport implements WaterMeterComplaintDAO{

	private static final Log log = LogFactory.getLog(WaterMeterComplaintDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveWaterMeterComplaint(WaterMeterComplaint waterMeterComplaint) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("WaterMeterComplaint save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(waterMeterComplaint);
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
	public long waterMeterComplaintSave(WaterMeterComplaint waterMeterComplaint) {
		WaterMeterComplaint b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (WaterMeterComplaint) getHibernateTemplate().merge(waterMeterComplaint);

			if (b != null) {
				return b.getWaterMeterComplaintId();
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
		return b.getWaterMeterComplaintId();
	}

	@Override
	public WaterMeterComplaint get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (WaterMeterComplaint) getHibernateTemplate().get(WaterMeterComplaint.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	@Override
	public List<WaterMeterComplaint> getAllWaterMeterComplaint() {
		try {

		      if (log.isDebugEnabled()) {
		        log.debug("get all Method is called for Permission");
		      }
			    return (List<WaterMeterComplaint>) getHibernateTemplate().loadAll(WaterMeterComplaint.class);
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
	public WaterMeterComplaint getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select waterMeterComplaint from WaterMeterComplaint waterMeterComplaint where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (WaterMeterComplaint) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public WaterMeterComplaint merge(WaterMeterComplaint waterMeterComplaint) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (WaterMeterComplaint) getHibernateTemplate().merge(waterMeterComplaint);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}


}
