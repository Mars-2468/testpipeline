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

import com.mars.rti.dao.NewWaterConnectionDAO;
import com.mars.rti.model.NewWaterConnection;
import com.mars.rti.model.WaterConnectionPurpose;
import com.mars.rti.model.WaterProposedCategoryType;

@Repository
public class NewWaterConnectionDAOImpl extends HibernateDaoSupport implements NewWaterConnectionDAO {

	private static final Log log = LogFactory.getLog(NewWaterConnectionDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveNewWaterConnection(NewWaterConnection newWaterConnection) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("New Water Connection save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(newWaterConnection);
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
	public long newWaterConnectionSave(NewWaterConnection newWaterConnection) {
		NewWaterConnection b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (NewWaterConnection) getHibernateTemplate().merge(newWaterConnection);

			if (b != null) {
				return b.getNewWaterConnectionId();
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
		return b.getNewWaterConnectionId();
	}

	@Override
	public NewWaterConnection get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (NewWaterConnection) getHibernateTemplate().get(NewWaterConnection.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	@Override
	public List<NewWaterConnection> getAllNewWaterConnection() {
		try {

		      if (log.isDebugEnabled()) {
		        log.debug("get all Method is called for Permission");
		      }
			    return (List<NewWaterConnection>) getHibernateTemplate().loadAll(NewWaterConnection.class);
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
	public NewWaterConnection getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select newWaterConnection from NewWaterConnection newWaterConnection where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (NewWaterConnection) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public NewWaterConnection merge(NewWaterConnection newWaterConnection) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (NewWaterConnection) getHibernateTemplate().merge(newWaterConnection);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	

	@Override
	public List<WaterConnectionPurpose> getWaterConnectionPurpose(){
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select waterConnectionPurpose from WaterConnectionPurpose waterConnectionPurpose order by waterConnectionPurpose.purposeId";
			Query query = getSession().createQuery(strQuery);
			List<WaterConnectionPurpose> waterConnectionPurpose = query.list();
			if (waterConnectionPurpose != null && waterConnectionPurpose.size() > 0)
				return waterConnectionPurpose;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	
}
