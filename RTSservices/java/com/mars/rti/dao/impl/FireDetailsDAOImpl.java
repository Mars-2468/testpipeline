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

import com.mars.rti.dao.FireDetailsDao;
import com.mars.rti.model.CitizenHospital;
import com.mars.rti.model.FireDetails;
import com.mars.rti.model.RTIApplication;

@Repository
public class FireDetailsDAOImpl extends HibernateDaoSupport implements FireDetailsDao{
	
	private static final Log log =LogFactory.getLog(FireDetailsDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	
	public void saveFireDetails(FireDetails fireDetails) {
		// TODO Auto-generated method stub
		
				try
				{
				    if (log.isDebugEnabled())
				    {
					log.debug("save Method is called ");
				    }
				    getHibernateTemplate().saveOrUpdate(fireDetails);
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
	public List<FireDetails> getFireDetails(long id){
		try{

			List<FireDetails> list=null;
			
			String sqlQuery="select ch from FireDetails ch where ch.fireRecommendation = "+id;

			Query query = getSession().createQuery(sqlQuery);

			 list = query.list();

			if (list != null && list.size() > 0)     
				return list;
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleting RTIApplication instance");
			}
			FireDetails entity = (FireDetails) getHibernateTemplate().load(FireDetails.class, new Long(id));
			getHibernateTemplate().delete(entity);
			log.debug("delete successful");
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
	}
	
	
}
