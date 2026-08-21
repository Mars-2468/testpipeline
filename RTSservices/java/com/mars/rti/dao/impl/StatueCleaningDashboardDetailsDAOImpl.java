package com.mars.rti.dao.impl;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.rti.dao.MiscellaneousApplicationDAO;

import com.mars.rti.dao.StatueCleaningDashboardDetailsDAO;


@Repository
public class StatueCleaningDashboardDetailsDAOImpl extends HibernateDaoSupport implements StatueCleaningDashboardDetailsDAO{
	private static final Log log = LogFactory.getLog(StatueCleaningDashboardDetailsDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public long getTotalCleanedCount(LocalDateTime startDate, LocalDateTime nextDay) {

	    String sql = "SELECT COUNT(*) FROM egovrti.statue_cleaning " +
	                 "WHERE CAST(cleaning_date AS TIMESTAMP) >= :startDate " +
	                 "AND CAST(cleaning_date AS TIMESTAMP) < :nextDay";

	    Object result = getSessionFactory()
	            .getCurrentSession()
	            .createSQLQuery(sql)
	            .setTimestamp("startDate", java.sql.Timestamp.valueOf(startDate))
	            .setTimestamp("nextDay", java.sql.Timestamp.valueOf(nextDay)) 
	            .uniqueResult();

	    return result != null ? ((Number) result).longValue() : 0;
	}


//	@Override
//	public long getTotalCleanedCount(LocalDateTime startDate, LocalDateTime endDate) {
//	    long count = 0;
//	    try {
//	        String sql = "SELECT COUNT(*) FROM egovrti.statue_cleaning " +
//	                     "WHERE cleaning_date BETWEEN :startDate AND :endDate";
//
//	        Object result = getSessionFactory()
//	                .getCurrentSession()
//	                .createSQLQuery(sql)
//	                .setString("startDate", startDate.toString())
//	                .setString("endDate", endDate.toString())
//	                .uniqueResult();
//
//	        if (result != null) {
//	            count = ((Number) result).longValue();
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        log.error("Error fetching total cleaned count", e);
//	    }
//	    return count;
//	}
//
//	@Override
//	@SuppressWarnings("unchecked")
//	public List<Object[]> getFirestationWiseCount(LocalDateTime startDate, LocalDateTime endDate) {
//	    List<Object[]> list = null;
//	    try {
//	        String sql = "SELECT fire_station_name, COUNT(*) " +
//	                     "FROM egovrti.statue_cleaning " +
//	                     "WHERE cleaning_date BETWEEN :startDate AND :endDate " +
//	                     "GROUP BY fire_station_name";
//
//	        list = getSessionFactory()
//	                .getCurrentSession()
//	                .createSQLQuery(sql)
//	                .setString("startDate", startDate.toString())
//	                .setString("endDate", endDate.toString())
//	                .list();
//
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        log.error("Error fetching firestation-wise count", e);
//	    }
//	    return list;
//	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getFirestationWiseCount(LocalDateTime startDate, LocalDateTime nextDay) {

	    String sql = "SELECT fire_station_name, COUNT(*) " +
	                 "FROM egovrti.statue_cleaning " +
	                 "WHERE CAST(cleaning_date AS TIMESTAMP) >= :startDate " +
	                 "AND CAST(cleaning_date AS TIMESTAMP) < :nextDay " +
	                 "GROUP BY fire_station_name";

	    return getSessionFactory()
	            .getCurrentSession()
	            .createSQLQuery(sql)
	            .setParameter("startDate", java.sql.Timestamp.valueOf(startDate))
	            .setParameter("nextDay", java.sql.Timestamp.valueOf(nextDay))
	            .list();
	}

}



