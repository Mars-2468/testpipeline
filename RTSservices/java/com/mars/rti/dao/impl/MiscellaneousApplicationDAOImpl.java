package com.mars.rti.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.MiscellaneousApplicationDAO;
import com.mars.rti.model.MisPurposeWithAmount;
import com.mars.rti.model.MiscellaneousApplication;
import com.mars.rti.model.WaterProposedTapSize;
@Repository
public class MiscellaneousApplicationDAOImpl extends HibernateDaoSupport implements MiscellaneousApplicationDAO{

	

		private static final Log log = LogFactory.getLog(MiscellaneousApplicationDAOImpl.class);

		@Autowired
		public void init(SessionFactory factory) {
			setSessionFactory(factory);
		}

		
		@Override
		public MiscellaneousApplication saveMiscellaneousApplication(MiscellaneousApplication miscellaneousApplication) {
		    try {
		        if (log.isDebugEnabled()) {
		            log.debug("MiscellaneousApplication save Method is called");
		        }

		        Serializable id = getHibernateTemplate().save(miscellaneousApplication);
		        getHibernateTemplate().flush(); // optional, ensures DB sync

		        miscellaneousApplication = getHibernateTemplate().get(MiscellaneousApplication.class, id);

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
		    return miscellaneousApplication;
		}

		
		@Override
		public MiscellaneousApplication findById(Long miscId) {
		    try {
		        if (log.isDebugEnabled()) {
		            log.debug("MiscellaneousApplication findById Method is called with ID: " + miscId);
		        }
		        return getHibernateTemplate().get(MiscellaneousApplication.class, miscId);
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
		public List<MisPurposeWithAmount> getPurposeWithAmount() {
			try {
				if (log.isDebugEnabled()) {
					log.debug("get Method with Market Name List called");
				}
				String strQuery = "select misPurposeWithAmount from MisPurposeWithAmount misPurposeWithAmount order by misPurposeWithAmount.purposeId";
				Query query = getSession().createQuery(strQuery);
				List<MisPurposeWithAmount> misPurposeWithAmount = query.list();
				if (misPurposeWithAmount != null && misPurposeWithAmount.size() > 0)
					return misPurposeWithAmount;
			} catch (Exception exception) {
				log.error(exception.getStackTrace(), exception);
				exception.printStackTrace();
			}
			return null;
		}


}
