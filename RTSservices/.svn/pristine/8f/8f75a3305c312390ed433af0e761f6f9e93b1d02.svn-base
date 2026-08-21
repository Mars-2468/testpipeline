package com.mars.rti.dao.impl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.BiologicalWasteDisposalDAO;
import com.mars.rti.model.BiologicalWasteDisposal;

	@Repository
	public class BiologicalWasteDisposalDAOImpl extends HibernateDaoSupport implements BiologicalWasteDisposalDAO {

		private static final Log log = LogFactory.getLog(BiologicalWasteDisposalDAOImpl.class);

		@Autowired
		public void init(SessionFactory factory) {
			setSessionFactory(factory);
		}

		
		@Override
		public void saveBiologicalDisposal(BiologicalWasteDisposal biologicalWasteDisposal){
			try {
				if (log.isDebugEnabled()) {
					log.debug("Tree Biological save Method is called");
				}
				getHibernateTemplate().saveOrUpdate(biologicalWasteDisposal);
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
		public long biologicalDisposalSave(BiologicalWasteDisposal biologicalWasteDisposal) {
			// TODO Auto-generated method stub {
			// TODO Auto-generated method stub
			BiologicalWasteDisposal b = null;
			try {
				if (log.isDebugEnabled()) {
					log.debug("save Method is called ");
				}
				b = (BiologicalWasteDisposal) getHibernateTemplate().merge(biologicalWasteDisposal);

				if (b != null) {
					return b.getBwdId();
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
			return b.getBwdId();
		}

		@Override
		public BiologicalWasteDisposal get(long id) {
			try {
				if (log.isDebugEnabled()) {
					log.debug("get Method is called " + id);
				}
				return (BiologicalWasteDisposal) getHibernateTemplate().get(BiologicalWasteDisposal.class, new Long(id));
			} catch (Exception exception) {
				log.error(exception.getStackTrace(), exception);
				exception.printStackTrace();
			}
			return null;

		}


		@Override
		public BiologicalWasteDisposal merge(BiologicalWasteDisposal biologicalWasteDisposal) {
			try {
				if (log.isDebugEnabled()) {
					log.debug("merge Method is called ");
				}
				return (BiologicalWasteDisposal) getHibernateTemplate().merge(biologicalWasteDisposal);
			} catch (Exception exception) {
				log.error(exception.getStackTrace(), exception);
				exception.printStackTrace();
			}
			return null;
		}

		@Override
		public long BiologicalWasteDisposalSave(BiologicalWasteDisposal biologicalWasteDisposal) {
			BiologicalWasteDisposal d=null;
			try
			{
			    if (log.isDebugEnabled())
			    {
				log.debug("save Method is called ");
			    }
			    d=(BiologicalWasteDisposal)getHibernateTemplate().merge(biologicalWasteDisposal);
			    
			    if(d!=null){
			    	return d.getRti_ref_id();
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
			return d.getRti_ref_id();
		
		}
	
	}

