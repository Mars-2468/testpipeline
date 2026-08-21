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

import com.mars.rti.dao.CollectionBufferDAO;
import com.mars.rti.model.CollectionBuffer;

@Repository("CollectionBufferDAO")
public class CollectionBufferDAOImpl extends HibernateDaoSupport implements CollectionBufferDAO {
	
	
	private static final Log log =LogFactory.getLog(CollectionBufferDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	
	@Override
	public CollectionBuffer saveCollectionBuffer(CollectionBuffer collectionBuffer) {
		try {
      		if (log.isDebugEnabled()) 
      		{
        		log.debug("merge Method is called ");
      		}
		    return (CollectionBuffer) getHibernateTemplate().merge(collectionBuffer);
		} catch (Exception exception)
		{
	    	log.error(exception.getStackTrace());
	    	exception.printStackTrace();
		}
		return null;
	}
	
	
	public CollectionBuffer getBufferPgData(String UniqPgid) {
		try {
			
          System.out.println("IDUNIQ#####="+UniqPgid);
			String sqlString = "select collectionBuffer from CollectionBuffer collectionBuffer where collectionBuffer.UniqPgid= "+"'"+UniqPgid+"'";

			

			
			Query query = getSession().createQuery(sqlString);

			
			List list = query.list();

			if (list != null && list.size() > 0)
				return (CollectionBuffer) list.get(0);

		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public CollectionBuffer getCollection(long id) {
		// TODO Auto-generated method stub
		try{

			String sqlQuery="select collection from CollectionBuffer collection where rti_application_id = "+id;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (CollectionBuffer) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public CollectionBuffer saveCollection(CollectionBuffer collectionBuffer, String id) {
		CollectionBuffer b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (CollectionBuffer) getHibernateTemplate().merge(collectionBuffer);

			if (b != null) {
				return b;
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
		return null;
	}
	
	
	
	@Override
	public CollectionBuffer getCollections(String rtiApplicationId) {
		try{

			String sqlQuery="select collection from CollectionBuffer collection where rti_application_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (CollectionBuffer) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	
}


	@Override
	public void saveCollectionBufferList(
			List<CollectionBuffer> listcollectionbuffer) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("SaveCollectionBufferList save Method is called");
			}
			getHibernateTemplate().saveOrUpdateAll(listcollectionbuffer);
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
	public CollectionBuffer getCollectionId(Long i) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + i);
			}
			return (CollectionBuffer) getHibernateTemplate().get(CollectionBuffer.class, new Long(i));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}
	
	
}
