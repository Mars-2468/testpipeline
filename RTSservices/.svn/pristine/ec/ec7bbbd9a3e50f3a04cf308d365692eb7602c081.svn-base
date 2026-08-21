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

import com.mars.rti.dao.WaterPressureDAO;
import com.mars.rti.model.WaterPressure;

@Repository
public class WaterPressureDAOImpl extends HibernateDaoSupport implements WaterPressureDAO {

	
	private static final Log log = LogFactory.getLog(WaterPressureDAOImpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public void saveWaterConnectionPressure(WaterPressure waterPressure) {
	
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    getHibernateTemplate().saveOrUpdate(waterPressure);
		} catch (NullPointerException nullpointerexception)
		{
		    log.error(nullpointerexception.getStackTrace());
		    throw new NullPointerException();
		} catch (HibernateException hibernateException)
		{
		    hibernateException.printStackTrace();
		    log.error(hibernateException.getStackTrace());
		    throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception)
		{
		    exception.printStackTrace();
		    log.error(exception.getStackTrace());
		    throw new RuntimeException(exception.getCause());
		}
		
	}

	

	@Override
	public WaterPressure get(long rtiApplicationRefId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiApplicationRefId);
			}
			return (WaterPressure) getHibernateTemplate().get(WaterPressure.class, new Long(rtiApplicationRefId));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	

	@Override
	public long waterPressureSave(WaterPressure waterPressure) {
		WaterPressure b=null;
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    b=(WaterPressure)getHibernateTemplate().merge(waterPressure);
		    
		    if(b!=null){
		    	return b.getWaterPressureId();
		    }
		} catch (NullPointerException nullpointerexception)
		{
		    log.error(nullpointerexception.getStackTrace());
		    throw new NullPointerException();
		} catch (HibernateException hibernateException)
		{
		    hibernateException.printStackTrace();
		    log.error(hibernateException.getStackTrace());
		    throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception)
		{
		    exception.printStackTrace();
		    log.error(exception.getStackTrace());
		    throw new RuntimeException(exception.getCause());
		}
		return b.getWaterPressureId();
	}

	@Override
	public List<WaterPressure> getAllWaterPressureComplaint() {
		try {

		      if (log.isDebugEnabled()) {
		        log.debug("get all Method is called for Permission");
		      }
			    return (List<WaterPressure>) getHibernateTemplate().loadAll(WaterPressure.class);
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
	public WaterPressure getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select waterPressure from WaterPressure waterPressure where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (WaterPressure) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public WaterPressure merge(WaterPressure waterPressure) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (WaterPressure) getHibernateTemplate().merge(waterPressure);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}


}
