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

import com.mars.rti.dao.WaterConnectionTypeChangeDAO;
import com.mars.rti.model.FireRecommendationTypeOfBuilding;
import com.mars.rti.model.WaterConnectionTypeChange;
import com.mars.rti.model.WaterProposedTapSize;

@Repository
public class WaterConnectionTypeChangeDAOImpl extends HibernateDaoSupport implements WaterConnectionTypeChangeDAO {

	
		// TODO Auto-generated method stub
		private static final Log log = LogFactory.getLog(WaterConnectionTypeChangeDAOImpl.class);
		
		@Autowired
		public void init(SessionFactory factory) {
			setSessionFactory(factory);
		}
		
		@Override
		public void saveWaterConnectionType(WaterConnectionTypeChange waterConnectionTypeChange) {
			try
			{
			    if (log.isDebugEnabled())
			    {
				log.debug("save Method is called ");
			    }
			    getHibernateTemplate().saveOrUpdate(waterConnectionTypeChange);
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
		public long getWaterConnectionTypeChangeId(WaterConnectionTypeChange waterConnectionTypeChange) {
			WaterConnectionTypeChange b=null;
			try
			{
			    if (log.isDebugEnabled())
			    {
				log.debug("save Method is called ");
			    }
			    b=(WaterConnectionTypeChange)getHibernateTemplate().merge(waterConnectionTypeChange);
			    
			    if(b!=null){
			    	return b.getWaterConnectionId();
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
			return b.getWaterConnectionId();
		
}
		

		@Override
		public WaterConnectionTypeChange get(long rtiApplicationRefId) {
			try {
				if (log.isDebugEnabled()) {
					log.debug("get Method is called " + rtiApplicationRefId);
				}
				return (WaterConnectionTypeChange) getHibernateTemplate().get(WaterConnectionTypeChange.class, new Long(rtiApplicationRefId));
			} catch (Exception exception) {
				log.error(exception.getStackTrace(), exception);
				exception.printStackTrace();
			}
			return null;
		}

		@Override
		public List<WaterConnectionTypeChange> getAllWaterConnectionType() {
			try {

			      if (log.isDebugEnabled()) {
			        log.debug("get all Method is called for Permission");
			      }
				    return (List<WaterConnectionTypeChange>) getHibernateTemplate().loadAll(WaterConnectionTypeChange.class);
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
		public WaterConnectionTypeChange getDetails(long rtiApplicationId) {
			try{

				String sqlQuery="select waterConnectionTypeChange from WaterConnectionTypeChange waterConnectionTypeChange where rti_ref_id = "+rtiApplicationId;

				Query query = getSession().createQuery(sqlQuery);

				List list = query.list();

				if (list != null && list.size() > 0)     
					return (WaterConnectionTypeChange) list.get(0);
			}catch(Exception e){
				log.error(e.getStackTrace());
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		public WaterConnectionTypeChange merge(WaterConnectionTypeChange waterConnectionTypeChange) {
			try {
				if (log.isDebugEnabled()) {
					log.debug("merge Method is called ");
				}
				return (WaterConnectionTypeChange) getHibernateTemplate().merge(waterConnectionTypeChange);
			} catch (Exception exception) {
				log.error(exception.getStackTrace(), exception);
				exception.printStackTrace();
			}
			return null;
		}
		
		@Override
		public List<WaterProposedTapSize> getProposedTapSize() {
			try {
				if (log.isDebugEnabled()) {
					log.debug("get Method with Market Name List called");
				}
				String strQuery = "select proposedTapSize from WaterProposedTapSize proposedTapSize order by proposedTapSize.tapSizeId";
				Query query = getSession().createQuery(strQuery);
				List<WaterProposedTapSize> proposedTapSize = query.list();
				if (proposedTapSize != null && proposedTapSize.size() > 0)
					return proposedTapSize;
			} catch (Exception exception) {
				log.error(exception.getStackTrace(), exception);
				exception.printStackTrace();
			}
			return null;
		}

		}


