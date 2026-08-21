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

import com.mars.rti.dao.ChangeInOwnershipTypeDAO;
import com.mars.rti.model.ChangeInOwnershipType;

@Repository
public class ChangeInOwnershipTypeDAOImpl extends HibernateDaoSupport implements ChangeInOwnershipTypeDAO {
	
	private static final Log log = (Log) LogFactory.getLog(ChangeInOwnershipTypeDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}


	@Override
	public void saveChangeInOwnershipType(ChangeInOwnershipType changeInOwnershipType) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			System.out.println(changeInOwnershipType);
			getHibernateTemplate().saveOrUpdate(changeInOwnershipType);
		} catch (Exception exception) {
			log.error(exception.getMessage());
			System.out.println(exception);
			exception.printStackTrace();
		}
	}

	@Override
	public long changeInOwnershipTypeSave(ChangeInOwnershipType changeInOwnershipType) {
		ChangeInOwnershipType ownershipType = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			ownershipType = (ChangeInOwnershipType) getHibernateTemplate().merge(changeInOwnershipType);

			if (ownershipType != null) {
				return ownershipType.getChangeOwnershipID();
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
		return ownershipType.getChangeOwnershipID();
	}


	@Override
	public ChangeInOwnershipType get(long rtiApplicationRefId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + rtiApplicationRefId);
			}
			return (ChangeInOwnershipType) getHibernateTemplate().get(ChangeInOwnershipType.class,
					new Long(rtiApplicationRefId));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}


	@Override
	public List<ChangeInOwnershipType> getAllChangeInOwnershipType() {
		try {

		      if (log.isDebugEnabled()) {
		        log.debug("get all Method is called for Permission");
		      }
			    return (List<ChangeInOwnershipType>) getHibernateTemplate().loadAll(ChangeInOwnershipType.class);
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
	public ChangeInOwnershipType getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select changeInOwnershipType from ChangeInOwnershipType changeInOwnershipType where rtiRefId = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (ChangeInOwnershipType) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ChangeInOwnershipType merge(ChangeInOwnershipType changeInOwnershipType) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (ChangeInOwnershipType) getHibernateTemplate().merge(changeInOwnershipType);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}



}
