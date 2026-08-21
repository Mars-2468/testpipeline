
package com.mars.rti.dao.impl;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.NewWaterconnectionPurposeDAO;
import com.mars.rti.model.NewWaterConnectionPurpose;


@Repository

public class NewWaterconnectionPurposeDAOimpl  extends HibernateDaoSupport implements  NewWaterconnectionPurposeDAO{
	
	private static final Log log = LogFactory.getLog(NewWaterconnectionPurposeDAOimpl.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<NewWaterConnectionPurpose> getPurpose() {
		try{
			 if (log.isDebugEnabled()) {
			        log.debug("get all Method is called for Permission");
			      }
			 
			    return (List<NewWaterConnectionPurpose>) getHibernateTemplate().loadAll(NewWaterConnectionPurpose.class);
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

}
