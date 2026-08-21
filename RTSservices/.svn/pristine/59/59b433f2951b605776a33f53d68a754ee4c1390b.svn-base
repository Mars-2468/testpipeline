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

import com.mars.rti.dao.WaterDisconnectionDAO;
import com.mars.rti.model.WaterDisconnection;

@Repository
public class WaterDisconnectionDAOImpl extends HibernateDaoSupport implements WaterDisconnectionDAO {
	private static final Log log = LogFactory.getLog(WaterDisconnectionDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveWaterDisconnection(WaterDisconnection waterDisconnection) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("WaterDisconnection save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(waterDisconnection);
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
	public long waterDisconnectionSave(WaterDisconnection waterDisconnection) {
		WaterDisconnection b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (WaterDisconnection) getHibernateTemplate().merge(waterDisconnection);

			if (b != null) {
				return b.getWaterDisconnectionId();
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
		return b.getWaterDisconnectionId();
	}

	@Override
	public WaterDisconnection get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (WaterDisconnection) getHibernateTemplate().get(WaterDisconnection.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
	@Override
	public List<WaterDisconnection> getAllWaterDisconnection() {
		try {

		      if (log.isDebugEnabled()) {
		        log.debug("get all Method is called for Permission");
		      }
			    return (List<WaterDisconnection>) getHibernateTemplate().loadAll(WaterDisconnection.class);
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
	public WaterDisconnection getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select waterDisconnection from WaterDisconnection waterDisconnection where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (WaterDisconnection) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public WaterDisconnection merge(WaterDisconnection waterDisconnection) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (WaterDisconnection) getHibernateTemplate().merge(waterDisconnection);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}



}
