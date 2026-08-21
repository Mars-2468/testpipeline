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

import com.mars.rti.dao.WaterConnectionUsageDAO;
import com.mars.rti.model.WaterConnectionUsage;
import com.mars.rti.model.WaterProposedCategoryType;
import com.mars.rti.model.WaterProposedTapSize;


@Repository
public class WaterConnectionUsageDAOImpl extends HibernateDaoSupport implements WaterConnectionUsageDAO {
	private static final Log log = LogFactory.getLog(WaterConnectionUsageDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void saveWaterConnectionUsage(WaterConnectionUsage waterConnectionUsage) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("WaterConnectionUsage save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(waterConnectionUsage);
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
	public long waterConnectionUsageSave(WaterConnectionUsage waterConnectionUsage) {
		WaterConnectionUsage b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (WaterConnectionUsage) getHibernateTemplate().merge(waterConnectionUsage);

			if (b != null) {
				return b.getWaterConnectionUsageId();
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
		return b.getWaterConnectionUsageId();
	}

	@Override
	public WaterConnectionUsage get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (WaterConnectionUsage) getHibernateTemplate().get(WaterConnectionUsage.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	@Override
	public List<WaterConnectionUsage> getAllWaterConnectionUsage() {
		try {

		      if (log.isDebugEnabled()) {
		        log.debug("get all Method is called for Permission");
		      }
			    return (List<WaterConnectionUsage>) getHibernateTemplate().loadAll(WaterConnectionUsage.class);
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
	public WaterConnectionUsage getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select waterConnectionUsage from WaterConnectionUsage waterConnectionUsage where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (WaterConnectionUsage) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public WaterConnectionUsage merge(WaterConnectionUsage waterConnectionUsage) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (WaterConnectionUsage) getHibernateTemplate().merge(waterConnectionUsage);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public List<WaterProposedCategoryType> getProposedCategory(){
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "select proposedCategoryType from WaterProposedCategoryType proposedCategoryType order by proposedCategoryType.categorytypeId";
			Query query = getSession().createQuery(strQuery);
			List<WaterProposedCategoryType> proposedCategoryType = query.list();
			if (proposedCategoryType != null && proposedCategoryType.size() > 0)
				return proposedCategoryType;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}


}