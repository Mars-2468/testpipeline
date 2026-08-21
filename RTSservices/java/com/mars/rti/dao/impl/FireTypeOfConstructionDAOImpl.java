package com.mars.rti.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.FireTypeOfConstructionDAO;
import com.mars.rti.model.FireTypeOfConstruction;

@Repository
public class FireTypeOfConstructionDAOImpl extends HibernateDaoSupport implements FireTypeOfConstructionDAO {
	private static final Log log = LogFactory.getLog(FireTypeOfConstructionDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public List<FireTypeOfConstruction> getTypeOfConstruction() {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method with Market Name List called");
			}
			String strQuery = "SELECT fireTypeOfConstruction\r\n"
					+ "FROM FireTypeOfConstruction fireTypeOfConstruction\r\n"
					+ "ORDER BY fireTypeOfConstruction.fireBuildingconstructionTypeId ASC\r\n"
					+ "";
			Query query = getSession().createQuery(strQuery);
			List<FireTypeOfConstruction> fireTypeOfStructure = query.list();
			if (fireTypeOfStructure != null && fireTypeOfStructure.size() > 0)
				return fireTypeOfStructure;
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
	@Override
	public FireTypeOfConstruction getTypeOfConstruction(long buildingConstructionId) {
	    try {
	        if (log.isDebugEnabled()) {
	            log.debug("get Method with Market Name List called");
	        }
	        
	        // Use a parameterized query to avoid SQL injection
	        String strQuery = "FROM FireTypeOfConstruction ff WHERE ff.fireBuildingconstructionTypeId = :buildingConstructionId";
	        
	        Query query = getSession().createQuery(strQuery);
	        query.setParameter("buildingConstructionId", buildingConstructionId);
	        
	        FireTypeOfConstruction fireTypeOfStructure = (FireTypeOfConstruction) query.uniqueResult(); // Use uniqueResult to get a single result
	        
	        return fireTypeOfStructure;
	    } catch (Exception exception) {
	        log.error(exception.getStackTrace(), exception);
	        exception.printStackTrace();
	    }
	    return null;
	}

	
	
}
