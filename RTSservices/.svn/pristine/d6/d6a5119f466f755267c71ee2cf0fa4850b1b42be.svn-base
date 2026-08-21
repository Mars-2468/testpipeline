package com.mars.rti.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.EasebuzzWebhookDAO;
import com.mars.rti.model.EasebuzzWebhook;

@Repository
public class EasebuzzWebhookDAOImpl extends HibernateDaoSupport
		implements
			EasebuzzWebhookDAO {

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	@Override
	public void saveWebhook(EasebuzzWebhook dto) {

		try {
			getHibernateTemplate().saveOrUpdate(dto);
		} catch (NullPointerException nullpointerexception) {
			throw new NullPointerException();
		} catch (HibernateException hibernateException) {
			hibernateException.printStackTrace();
			throw new HibernateException(hibernateException.getMessage());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException(exception.getCause());
		}
	}

	@Override
	public EasebuzzWebhook getEasebuzz(String id) {
		// TODO Auto-generated method stub
		try{

			String sqlQuery="select easebuzzWebhook from EasebuzzWebhook easebuzzWebhook where status='success' and txnid = "+"'"+id+"'";

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (EasebuzzWebhook) list.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
