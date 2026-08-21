package com.mars.rti.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.DogtypeDAO;
import com.mars.rti.model.Dogtype;

@Repository
public class DogtypeDAOImpl extends HibernateDaoSupport implements DogtypeDAO{

	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<Dogtype> getDogtype(String dogtype) {
		try{

			String sqlQuery = "SELECT d FROM Dogtype d WHERE d.dogtype = '" + dogtype + "'";
			Query query = getSession().createQuery(sqlQuery);

			List<Dogtype> list = query.list();

			if (list != null && list.size() > 0)     
				return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Dogtype getDogtypes(String dogtype) {
		try{

			String sqlQuery = "SELECT d FROM Dogtype d WHERE d.dogtype = '" + dogtype + "'";
			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (Dogtype)list.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
