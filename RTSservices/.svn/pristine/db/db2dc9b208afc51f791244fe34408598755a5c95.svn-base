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

import com.mars.rti.dao.IllegalWaterConnectionDAO;
import com.mars.rti.model.IllegalWaterConnectionComplaint;
@Repository
public class IllegalWaterConnectionDAOImpl  extends HibernateDaoSupport implements IllegalWaterConnectionDAO{
	
	private static final Log log = (Log) LogFactory.getLog(IllegalWaterConnectionDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveIllegalWaterConnection(IllegalWaterConnectionComplaint illegalWaterConnection) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			System.out.println(illegalWaterConnection);
			getHibernateTemplate().saveOrUpdate(illegalWaterConnection);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			System.out.println(exception);
			exception.printStackTrace();
		}
	}

	@Override
	public long illegalWaterConnectionSave(IllegalWaterConnectionComplaint illegalWaterConnection) {
		IllegalWaterConnectionComplaint illegalWaterConnectionComplaint = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			illegalWaterConnectionComplaint = (IllegalWaterConnectionComplaint) getHibernateTemplate()
					.merge(illegalWaterConnection);

			if (illegalWaterConnectionComplaint != null) {
				return illegalWaterConnectionComplaint.getIllegalWaterConnectionID();
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
		return illegalWaterConnectionComplaint.getIllegalWaterConnectionID();
	}

	@Override
	public IllegalWaterConnectionComplaint get(long rtiApplicationRefId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiApplicationRefId);
			}
			return (IllegalWaterConnectionComplaint) getHibernateTemplate().get(IllegalWaterConnectionComplaint.class,
					new Long(rtiApplicationRefId));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public List<IllegalWaterConnectionComplaint> getAllIllegalWaterConnection() {
		
		try {

		      if (log.isDebugEnabled()) {
		        log.debug("get all Method is called for Permission");
		      }
			    return (List<IllegalWaterConnectionComplaint>) getHibernateTemplate().loadAll(IllegalWaterConnectionComplaint.class);
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
	public IllegalWaterConnectionComplaint getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select illegalWaterConnectionComplaint from IllegalWaterConnectionComplaint illegalWaterConnectionComplaint where rtiRefId = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (IllegalWaterConnectionComplaint) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public IllegalWaterConnectionComplaint merge(IllegalWaterConnectionComplaint illegalWaterConnection) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (IllegalWaterConnectionComplaint) getHibernateTemplate().merge(illegalWaterConnection);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
		



}
