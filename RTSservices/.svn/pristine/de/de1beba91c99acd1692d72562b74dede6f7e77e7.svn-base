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

import com.mars.rti.dao.FireComplianceCertificateDAO;
import com.mars.rti.model.FireComplianceCertificate;
import com.mars.rti.model.RTIApplication;

@Repository
public class FireComplianceCertificateDAOImpl extends HibernateDaoSupport implements FireComplianceCertificateDAO {
	
	private static final Log log = LogFactory.getLog(MandapPermissionDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public void savefireComplianceCertificateForm(FireComplianceCertificate fireComplianceCertificate) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Mandap save Method is called");
			}
			getHibernateTemplate().saveOrUpdate(fireComplianceCertificate);
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
	public long fireComplianceCertificate(FireComplianceCertificate fireComplianceCertificate) {
		FireComplianceCertificate b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (FireComplianceCertificate) getHibernateTemplate().merge(fireComplianceCertificate);

			if (b != null) {
				return b.getFirecompliancecertificateid();
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
		return b.getFirecompliancecertificateid();
	}

	@Override
	public FireComplianceCertificate get(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (FireComplianceCertificate) getHibernateTemplate().get(FireComplianceCertificate.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	@Override
	public List<RTIApplication> getnoc(long serviceid) {
		// TODO Auto-generated method stub
	try {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called " + serviceid);
		}
		String sqlString = "select rtiApplication from RTIApplication rtiApplication where rtiApplication.workFlowStatus=0 and rtiApplication.rtiserviceid="+serviceid;

		Query query = getSession().createQuery(sqlString);
		List<RTIApplication> list = query.list();
		return list;
		} catch (Exception exception) {
		log.error(exception.getStackTrace(), exception);
		exception.printStackTrace();
	}
	return null;
}

}
