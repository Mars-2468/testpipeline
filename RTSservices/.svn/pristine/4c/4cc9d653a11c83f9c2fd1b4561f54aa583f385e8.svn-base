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

import com.mars.rti.dao.WaterConnectionNoDueDAO;
import com.mars.rti.model.WaterConnectionNoDue;

@Repository
public class WaterConnectionNoDueDAOImpl extends HibernateDaoSupport implements WaterConnectionNoDueDAO {

	private static final Log log = (Log) LogFactory.getLog(WaterConnectionNoDueDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveWaterConnection(WaterConnectionNoDue waterConnectionNoDue) {
		try {
//			if (log.isDebugEnabled()) {
//				log.debug("save Method is called ");
//			}
			System.out.println(waterConnectionNoDue);
			getHibernateTemplate().saveOrUpdate(waterConnectionNoDue);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			System.out.println(exception);
			exception.printStackTrace();
		}

	}

	@Override
	public long getWaterCertificate(WaterConnectionNoDue waterConnectionNoDue) {
		WaterConnectionNoDue waterConnection=null;
		try
		{
		    if (log.isDebugEnabled())
		    {
			log.debug("save Method is called ");
		    }
		    waterConnection=(WaterConnectionNoDue)getHibernateTemplate().merge(waterConnectionNoDue);
		    
		    if(waterConnection!=null){
		    	return waterConnection.getWaterConnectionId();
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
		return waterConnection.getWaterConnectionId();
	}
	
	@Override
	public WaterConnectionNoDue get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (WaterConnectionNoDue) getHibernateTemplate().get(WaterConnectionNoDue.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	@Override
	public List<WaterConnectionNoDue> getAllWaterNoDueCertificate() {
		try {

		      if (log.isDebugEnabled()) {
		        log.debug("get all Method is called for Permission");
		      }
			    return (List<WaterConnectionNoDue>) getHibernateTemplate().loadAll(WaterConnectionNoDue.class);
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
	public WaterConnectionNoDue getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select waterConnectionNoDue from WaterConnectionNoDue waterConnectionNoDue where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (WaterConnectionNoDue) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public WaterConnectionNoDue merge(WaterConnectionNoDue waterConnectionNoDue) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (WaterConnectionNoDue) getHibernateTemplate().merge(waterConnectionNoDue);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
		
}

