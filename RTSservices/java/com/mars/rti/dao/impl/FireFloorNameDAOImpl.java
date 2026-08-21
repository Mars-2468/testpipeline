package com.mars.rti.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.FireFloorNameDAO;
import com.mars.rti.model.FireFloorName;
import com.mars.rti.model.SubTypeOfbuilding;

@Repository
public class FireFloorNameDAOImpl extends HibernateDaoSupport implements FireFloorNameDAO {
	private static final Log log = LogFactory.getLog(FireFloorNameDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	@Override
	public List<FireFloorName> getFireFloorName() {
	    try {
	        if (log.isDebugEnabled()) {
	            log.debug("getFireMainFees method called");
	        }

//	        String strQuery = "SELECT fireFloorName\r\n"
//	        		+ "FROM FireFloorName fireFloorName\r\n"
//	        		+ "ORDER BY fireFloorName.fireFloorNameId\r\n"
//	        		+ "";
	        
	        String strQuery =
	        	    "SELECT fireFloorName " +
	        	    "FROM FireFloorName fireFloorName " +
	        	    "ORDER BY fireFloorName.displayOrder ASC";

	        Query query = getSession().createQuery(strQuery);
			List<FireFloorName> fireFloorName = query.list();
			if (fireFloorName != null && fireFloorName.size() > 0)
				return fireFloorName;
			} catch (Exception exception) {
	        log.error(exception.getStackTrace(), exception);
	        exception.printStackTrace();
	    }
	    return null;
	}
	
	@Override
	public List<FireFloorName> getList(long fireFloorTypesId) {
	    try {
	       // String strQuery = "from FireFloorName f where f.fireFloorTypesId = :id order by f.fireFloorNames";
	       
	    	 String strQuery = "FROM FireFloorName f "
                     + "WHERE f.fireFloorTypesId = :id "
                     + "ORDER BY f.displayOrder ASC";
	    	 
	        Query query = getSession().createQuery(strQuery);
	        // Pass as String directly, no long conversion
	        query.setParameter("id", String.valueOf(fireFloorTypesId));
	        
	        return query.list();
	    } catch (Exception e) {
	        log.error("Error fetching floor names for ID: " + fireFloorTypesId, e);
	        return new ArrayList<>();
	    }
	}
}
