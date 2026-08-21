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

import com.mars.rti.dao.OTPDAO;
import com.mars.rti.model.OTP;


@Repository
public class OTPDAOImpl extends HibernateDaoSupport implements OTPDAO{

	private static final Log log = LogFactory.getLog(OTPDAOImpl.class);
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public OTP merge(OTP otp) {
		OTP b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (OTP) getHibernateTemplate().merge(otp);

			if(b!=null) {
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
	public OTP getOtpDetails(long mobileNo) {
		try{

			List list=null;
			
			String sqlQuery="select otp from OTP otp where otp.mobileno = "+mobileNo;

			Query query = getSession().createQuery(sqlQuery);

			 list = query.list();

			if (list != null && list.size() > 0)     
				return (OTP) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}

}
