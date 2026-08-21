   package com.mars.rti.dao.impl;


   
import com.mars.common.utils.Constants;
import com.mars.rti.dao.StatueCleaningDAO;
import com.mars.rti.model.RTIApplication;
//import com.mars.rti.model.ShiftMaster;
import com.mars.rti.model.StatueCleaning;
//import com.mars.rti.model.ToiletCleaningBlockUnit;
//import com.mars.rti.model.ToiletCleaningZones;
import com.mars.rti.search.RTIApplicationSearch;
//import com.mars.rti.search.StatueCleaningSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import java.time.LocalTime;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

    
@Repository("StatueCleaning")
public class StatueCleaningDAOImpl extends HibernateDaoSupport implements StatueCleaningDAO {
   private static final Log log = LogFactory.getLog(StatueCleaning.class);

   @Autowired
   public void init(SessionFactory factory) {
      this.setSessionFactory(factory);
   }
   
  
       @Autowired
       private SessionFactory sessionFactory;

      
       @Override
       public String getCurrentShiftFromDB() {
           LocalTime now = LocalTime.now();

           // Convert to java.sql.Time for exact SQL TIME compatibility
           java.sql.Time sqlTime = java.sql.Time.valueOf(now);

           String hql = "FROM ShiftMaster WHERE "
               + "((startTime <= endTime AND :now BETWEEN startTime AND endTime) "
               + "OR (startTime > endTime AND (:now >= startTime OR :now <= endTime)))";

           Query query = getSession().createQuery(hql);
           query.setParameter("now", sqlTime);

          // List<ShiftMaster> shifts = query.list();
//           if (shifts != null && !shifts.isEmpty()) {
//               return shifts.get(0).getShiftName();
//           }
           return null;
       }



       @Override
public void saveStatueCleaning(StatueCleaning statuecleaning) {
	try {
        if (log.isDebugEnabled()) {
           log.debug("save Method is called ");
        }
        this.getHibernateTemplate().saveOrUpdate(statuecleaning);
     } catch (NullPointerException var3) {
        log.error(var3.getStackTrace());
        throw new NullPointerException();
     } catch (HibernateException var4) {
        var4.printStackTrace();
        log.error(var4.getStackTrace());
        throw new HibernateException(var4.getMessage());
     } catch (Exception var5) {
        var5.printStackTrace();
        log.error(var5.getStackTrace());
        throw new RuntimeException(var5.getCause());
     }
	
}

@Override
public List<StatueCleaning> getStatueCleaningList() {
	try {

		String sqlQuery = "FROM StatueCleaning";

		Query query = getSession().createQuery(sqlQuery);

		List<StatueCleaning> statueCleaninglist = query.list();

		return statueCleaninglist;
	} catch (Exception e) {
		log.error(e.getStackTrace());
		e.printStackTrace();
	}
	return null;
}
 

@Override
public long getCleaningId(StatueCleaning var1) {
	
	StatueCleaning sc= null;

     try {
        if (log.isDebugEnabled()) {
           log.debug("save Method is called ");
        }
		sc = (StatueCleaning)this.getHibernateTemplate().merge(var1);
        if (sc != null) {
           return sc.getCleaningId();
        }
     } catch (NullPointerException var4) {
        log.error(var4.getStackTrace());
        throw new NullPointerException();
     } catch (HibernateException var5) {
        var5.printStackTrace();
        log.error(var5.getStackTrace());
        throw new HibernateException(var5.getMessage());
     } catch (Exception var6) {
        var6.printStackTrace();
        log.error(var6.getStackTrace());
        throw new RuntimeException(var6.getCause());
     }

     return sc.getCleaningId();
	
}

public StatueCleaning get(long cleaningId) {
	try {
		if (log.isDebugEnabled()) {
			log.debug("get Method is called " + cleaningId);
		}
		return (StatueCleaning) getHibernateTemplate().get(StatueCleaning.class,new Long(cleaningId));
	} catch (Exception exception)
	{
    	log.error(exception.getStackTrace());
    	exception.printStackTrace();
	}
	return null;
}

@Override
public StatueCleaning merge(StatueCleaning entity) {
	try {
		if (log.isDebugEnabled()) {
			log.debug("merge Method is called ");
		}
		return (StatueCleaning) getHibernateTemplate().merge(entity);
	} catch (Exception exception) {
		log.error(exception.getStackTrace(), exception);
		exception.printStackTrace();
	}
	return null;
}

/*
 * public List<StatueCleaning> getStatueCleaningList(StatueCleaningSearch
 * searchOptions) { try { long pageNumber = searchOptions.getCurrentPage();
 * String orderBy = searchOptions.getOrderBy(); String sortBy =
 * searchOptions.getSortBy();
 * 
 * 
 * String sqlString =
 * "select rtiApplication from RTIApplication rtiApplication";
 * 
 * String fromClause = getSearchQuery(searchOptions);
 * 
 * sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " where " +
 * fromClause : sqlString;
 * 
 * if(searchOptions.getZoneName()>0 || searchOptions.getRtiserviceid()>0 ||
 * searchOptions.getRtiApplicationNumber()!=null) { //fromClause = sqlString +
 * " order by " + orderBy + " " + sortBy; fromClause=sqlString+" "+"and"+" "
 * +"rtiApplication.rtiApplnNumber IS NOT NULL and rtiApplication.rtiApplnNumber != ''"
 * + " order by " + orderBy + " " + sortBy; }else { fromClause=sqlString + " "
 * +"where"+" rtiApplication.rtiApplnNumber IS NOT NULL and rtiApplication.rtiApplnNumber != ''"
 * + " order by " + orderBy + " " + sortBy; } Query query =
 * getSession().createQuery(fromClause); log.info(fromClause);
 * 
 * if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) { if (pageNumber >
 * 1) { query.setFirstResult((int) ((pageNumber - 1) *
 * Constants.DEFAULT_ROWS_PER_PAGE)); query.setMaxResults((int)
 * Constants.DEFAULT_ROWS_PER_PAGE); } else { query.setFirstResult(0);
 * query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE); } }
 * 
 * List<StatueCleaning> list = query.list();
 * 
 * if (list != null && list.size() > 0) { return list; } } catch (Exception
 * exception) { log.error(exception.getStackTrace(), exception);
 * exception.printStackTrace(); } return null; }
 */

//   
//public List<StatueCleaning> getStatueCleaningList(StatueCleaningSearch searchOptions) {
//	try {
//		long pageNumber = searchOptions.getCurrentPage();
//		String orderBy = searchOptions.getOrderBy();
//		String sortBy = searchOptions.getSortBy();
//		String Zone = searchOptions.getZone();
//		
//		if(Zone!=null && !Zone.isEmpty()) {
//		}
//
//		// Base query for StatueCleaning
//		String sqlString = "select statueCleaning from StatueCleaning statueCleaning where isDraft ='0'";
//
//		// Adding search conditions
//		String fromClause = getSearchQuery(searchOptions);
//		sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " AND  " + fromClause : sqlString;
//
//		if (StringUtils.isNotEmpty(fromClause))
//			fromClause = sqlString + " AND statueCleaning.cleaningId IS NOT NULL order by " + orderBy + " " + sortBy;
//		else
//			fromClause = sqlString + " AND statueCleaning.cleaningId IS NOT NULL order by " + orderBy + " " + sortBy;
//
//		Query query = getSession().createQuery(fromClause);
//		log.info(fromClause);
//
//		// Pagination logic
//		if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
//			int firstResult = (int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE);
//			query.setFirstResult(Math.max(firstResult, 0));
//			query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE);
//		}
//
//		List<StatueCleaning> list = query.list();
//		return (list != null && !list.isEmpty()) ? list : new ArrayList<>();
//
//	} catch (Exception exception) {
//		log.error("Error fetching StatueCleaning list", exception);
//		exception.printStackTrace();
//	}
//	return new ArrayList<>();
//}
//
//public List<StatueCleaning> getStatueCleaningDraftList(StatueCleaningSearch searchOptions,String todayDate,String currentShift) {
//	try {
//		long pageNumber = searchOptions.getCurrentPage();
//		String orderBy = searchOptions.getOrderBy();
//		String sortBy = searchOptions.getSortBy();
//		String Zone = searchOptions.getZone();
//		
//		if(Zone!=null && !Zone.isEmpty()) {
//		}
//
//		// Base query for StatueCleaning
//		String sqlString = "select statueCleaning from StatueCleaning statueCleaning where isDraft ='1'";
//
//		// Adding search conditions
//		String fromClause = getSearchQuery(searchOptions);
//		sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " AND  " + fromClause : sqlString;
//
//		if (StringUtils.isNotEmpty(fromClause))
//			fromClause = sqlString + " AND statueCleaning.cleaningId IS NOT NULL order by " + orderBy + " " + sortBy;
//		else
//			fromClause = sqlString + " AND statueCleaning.cleaningId IS NOT NULL order by " + orderBy + " " + sortBy;
//
//		Query query = getSession().createQuery(fromClause);
//		log.info(fromClause);
//
//		// Pagination logic
//		if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
//			int firstResult = (int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE);
//			query.setFirstResult(Math.max(firstResult, 0));
//			query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE);
//		}
//
//		List<StatueCleaning> list = query.list();
//		return (list != null && !list.isEmpty()) ? list : new ArrayList<>();
//
//	} catch (Exception exception) {
//		log.error("Error fetching StatueCleaning list", exception);
//		exception.printStackTrace();
//	}
//	return new ArrayList<>();
//}
//
//private String getSearchQuery(StatueCleaningSearch searchOptions) {
//
//	String fromClause = "";
//	String fromDate = searchOptions.getFromDate();
//	String toDate = searchOptions.getToDate();
//	String Zone = searchOptions.getZone();
//	
//	
//	if (searchOptions != null) {
//		if ((fromDate != null && fromDate.length() > 0) && (toDate != null && toDate.length() > 0)) {
//
//			fromClause = fromClause + (" (to_timestamp(cleaningDate,'YYYY-MM-DD HH24:MI:SS') between to_timestamp('"
//					+ fromDate + "','YYYY-MM-DD HH24:MI:SS') " + "and to_timestamp('" + toDate
//					+ "','YYYY-MM-DD HH24:MI:SS'))");
//		}
//		if((fromDate != null && fromDate.length() > 0) && (toDate != null && toDate.length() > 0) && Zone!=null && !Zone.isEmpty()) {
//			fromClause = fromClause + " AND statueCleaning.zoneid = '" + Zone + "'";
//		}
//		else if(Zone!=null && !Zone.isEmpty()) {
//			fromClause = fromClause + " statueCleaning.zoneid = '" + Zone + "'";
//		}
//
//	}
//	return fromClause;
//}
//
//public long getStatueCleanApplicationCount(StatueCleaningSearch searchOptions) {
//	try {
//
//		String sqlString = "select count(*) from StatueCleaning statueCleaning where isDraft='0'";
//		String fromClause = getSearchQuery(searchOptions);
//
//		sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " AND  " + fromClause : sqlString;
//		Query query = getSession().createQuery(sqlString);
//		List list = query.list();
//		if (list != null && list.size() > 0)
//			return Long.parseLong(list.get(0).toString());
//	} catch (Exception exception) {
//		log.error(exception.getStackTrace(), exception);
//		exception.printStackTrace();
//	}
//	return 0;
////}
//@Override
//public List<StatueCleaning> getStatueCleaningDraftList(StatueCleaningSearch searchOptions, String currentDate, String shift) {
//    try {
//        long pageNumber = searchOptions.getCurrentPage();
//        String orderBy = searchOptions.getOrderBy();
//        String sortBy = searchOptions.getSortBy();
//        String zone = searchOptions.getZone();
//
//        StringBuilder hql = new StringBuilder("FROM StatueCleaning statueCleaning WHERE statueCleaning.isDraft = '1' ");
//
//        if (StringUtils.isNotBlank(currentDate)) {
//            hql.append("AND statueCleaning.currentDate = :currentDate ");
//        }
//        if (StringUtils.isNotBlank(shift)) {
//            hql.append("AND statueCleaning.shift = :shift ");
//        }
//        if (StringUtils.isNotBlank(zone)) {
//            hql.append("AND statueCleaning.zoneName = :zone ");
//        }
//
//        String fromClause = getSearchQuery(searchOptions);
//        if (StringUtils.isNotEmpty(fromClause)) {
//            hql.append("AND ").append(fromClause).append(" ");
//        }
//
//        hql.append("AND statueCleaning.cleaningId IS NOT NULL ");
//        hql.append("ORDER BY ").append(orderBy).append(" ").append(sortBy);
//
//        Query query = getSession().createQuery(hql.toString());
//
//        if (StringUtils.isNotBlank(currentDate)) {
//            query.setParameter("currentDate", currentDate);
//        }
//        if (StringUtils.isNotBlank(shift)) {
//            query.setParameter("shift", shift);
//        }
//        if (StringUtils.isNotBlank(zone)) {
//            query.setParameter("zone", zone);
//        }
//
//        // Pagination
//        if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
//            int firstResult = (int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE);
//            query.setFirstResult(Math.max(firstResult, 0));
//            query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE);
//        }
//
//        List<StatueCleaning> list = query.list();
//        return (list != null && !list.isEmpty()) ? list : new ArrayList<>();
//    } catch (Exception exception) {
//        log.error("Error fetching StatueCleaning list", exception);
//        exception.printStackTrace();
//    }
//    return new ArrayList<>();
////}
//@Override
//public long getStatueCleanApplicationDraftCount(StatueCleaningSearch searchOptions, String currentDate, String shift) {
//    try {
//        StringBuilder hql = new StringBuilder("select count(*) from StatueCleaning statueCleaning where statueCleaning.isDraft = '1' ");
//
//        if (StringUtils.isNotBlank(currentDate)) {
//            hql.append("AND statueCleaning.currentDate = :currentDate ");
//        }
//        if (StringUtils.isNotBlank(shift)) {
//            hql.append("AND statueCleaning.shift = :shift ");
//        }
//        String zone = searchOptions.getZone();
//        if (StringUtils.isNotBlank(zone)) {
//            hql.append("AND statueCleaning.zoneName = :zone ");
//        }
//
//        String fromClause = getSearchQuery(searchOptions);
//        if (StringUtils.isNotEmpty(fromClause)) {
//            hql.append("AND ").append(fromClause).append(" ");
//        }
//
//        Query query = getSession().createQuery(hql.toString());
//
//        if (StringUtils.isNotBlank(currentDate)) {
//            query.setParameter("currentDate", currentDate);
//        }
//        if (StringUtils.isNotBlank(shift)) {
//            query.setParameter("shift", shift);
//        }
//        if (StringUtils.isNotBlank(zone)) {
//            query.setParameter("zone", zone);
//        }
//
//        List<?> list = query.list();
//        if (list != null && !list.isEmpty()) {
//            return (Long) list.get(0);
//        }
//    } catch (Exception exception) {
//        log.error("Error fetching StatueCleaning draft count", exception);
//        exception.printStackTrace();
//    }
//    return 0;
//}
//

public void save(StatueCleaning entity)
{
try
{
    if (log.isDebugEnabled())
    {
	log.debug("save Method is called ");
    }
    getHibernateTemplate().saveOrUpdate(entity);
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
//
//@Override
//public List<ToiletCleaningZones> getToiletCleaningZones() {
//	try {
//		if (log.isDebugEnabled()) {
//			log.debug("get Method with Market Name List called");
//		}
//		String strQuery = "select toiletCleaningZones from ToiletCleaningZones toiletCleaningZones order by toiletCleaningZones.id";
//		Query query = getSession().createQuery(strQuery);
//		List<ToiletCleaningZones> toiletCleaningZones = query.list();
//		if (toiletCleaningZones != null && toiletCleaningZones.size() > 0)
//			return toiletCleaningZones;
//	} catch (Exception exception) {
//		log.error(exception.getStackTrace(), exception);
//		exception.printStackTrace();
//	}
//	return null;
//}
//
//@Override
//public List<ToiletCleaningBlockUnit> getToiletCleaningBlockUnit() {
//	try {
//		if (log.isDebugEnabled()) {
//			log.debug("get Method with Market Name List called");
//		}
//		String strQuery = "select toiletCleaningBlockUnit from ToiletCleaningBlockUnit toiletCleaningBlockUnit order by toiletCleaningBlockUnit.id";
//		Query query = getSession().createQuery(strQuery);
//		List<ToiletCleaningBlockUnit> toiletCleaningBlockUnit = query.list();
//		if (toiletCleaningBlockUnit != null && toiletCleaningBlockUnit.size() > 0)
//			return toiletCleaningBlockUnit;
//	} catch (Exception exception) {
//		log.error(exception.getStackTrace(), exception);
//		exception.printStackTrace();
//	}
//	return null;
//}
@Override
public List<StatueCleaning> getBlockExistingNumberLists(String zone, String shift, String currentDate) {
    try {
        if (log.isDebugEnabled()) {
            log.debug("getBlockExistingNumberLists method called");
        }

        String hql = "select statueCleaning from StatueCleaning statueCleaning "
                     + "where statueCleaning.currentDate = :currentDate "
                     + "and statueCleaning.shift = :shift "
                     + "and statueCleaning.zoneid = :zone";

        Query query = getSession().createQuery(hql);
        query.setParameter("currentDate", currentDate);
        query.setParameter("shift", shift);
        query.setParameter("zone", zone);

        List<StatueCleaning> blockNumberList = query.list();

        return (blockNumberList != null) ? blockNumberList : Collections.emptyList();

    } catch (Exception exception) {
        log.error("Error in getBlockExistingNumberLists()", exception);
        exception.printStackTrace();
    }
    return Collections.emptyList();
}


public StatueCleaning findByBlockAndDate(String blockNo, String date, String shift) {

    String hql = "FROM StatueCleaning WHERE blockNo=:blockNo AND currentDate=:date AND shift=:shift";

    return (StatueCleaning) sessionFactory.getCurrentSession()
        .createQuery(hql)
        .setParameter("blockNo", blockNo)
        .setParameter("date", date)
        .setParameter("shift", shift)
        .uniqueResult();
}
@Override
@SuppressWarnings("unchecked")
public List<StatueCleaning> getDataByGroupId(String groupId) {

    try {

        String hql = "from StatueCleaning where entryGroupId = :groupId";

        Query query = getSession().createQuery(hql);
        query.setParameter("groupId", groupId);

        List<StatueCleaning> list = query.list();

        return (list != null && !list.isEmpty()) ? list : new ArrayList<>();

    } catch (Exception exception) {
        log.error("Error fetching StatueCleaning list", exception);
        exception.printStackTrace();
    }

    return new ArrayList<>();
}
//@Override
//public List<Object[]> getStatueCleaningDraft(StatueCleaningSearch searchOptions, String currentDate, String shift) {
//    StringBuilder sql = new StringBuilder();
//    try {
//        long pageNumber = searchOptions.getCurrentPage();
//        String zone = searchOptions.getZone();
//
//        sql.append(
//            "SELECT " +
//            "entry_group_id, " +
//            "MAX(zone_name) as zone_name, " +
//            "MAX(shift) as shift_name, " +
//            "MAX(currentdate) as cleaning_date, " +
//            "COUNT(cleaning_id) as total_blocks, " +
//            "STRING_AGG(block_no, ',') as block_numbers, " +
//            "STRING_AGG(blockunit, ',') as block_units " +
//            "FROM egovrti.toilet_cleaning " +
//            "WHERE is_draft = '1' "
//        );
//
//        if (StringUtils.isNotBlank(currentDate)) {
//            sql.append("AND currentdate = :currentDate ");
//        }
//        if (StringUtils.isNotBlank(shift)) {
//            sql.append("AND shift = :shift ");
//        }
//        if (StringUtils.isNotBlank(zone)) {
//            sql.append("AND zoneid = :zone ");
//        }
//
//        sql.append("GROUP BY entry_group_id ");
//        sql.append("ORDER BY MAX(cleaning_id) DESC ");
//
//        Query query = getSession().createSQLQuery(sql.toString());
//
//        if (StringUtils.isNotBlank(currentDate)) {
//            query.setParameter("currentDate", currentDate);
//        }
//        if (StringUtils.isNotBlank(shift)) {
//            query.setParameter("shift", shift);
//        }
//        if (StringUtils.isNotBlank(zone)) {
//            query.setParameter("zone", zone);
//        }
//
//        if (pageNumber != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
//            int firstResult = (int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE);
//            query.setFirstResult(Math.max(firstResult, 0));
//            query.setMaxResults((int) Constants.DEFAULT_ROWS_PER_PAGE);
//        }
//
//        List<Object[]> result = query.list();
//        log.info("Query returned " + result.size() + " rows");
//        return result;
//
//    } catch (Exception e) {
//        log.error("Error fetching grouped data: " + e.getMessage() + " | SQL: " + sql.toString(), e);
//        return new ArrayList<>();
//    }
//}
//
//
//@Override
//public long getStatueCleanApplicationDraft(StatueCleaningSearch searchOptions, String currentDate, String shift) {
//    try {
//
//        StringBuilder hql = new StringBuilder(
//            "SELECT COUNT(DISTINCT statueCleaning.entryGroupId) " +
//            "FROM StatueCleaning statueCleaning WHERE statueCleaning.isDraft = '1' "
//        );
//
//        if (StringUtils.isNotBlank(currentDate)) {
//            hql.append("AND statueCleaning.currentDate = :currentDate ");
//        }
//        if (StringUtils.isNotBlank(shift)) {
//            hql.append("AND statueCleaning.shift = :shift ");
//        }
//
//        String zone = searchOptions.getZone();
//        if (StringUtils.isNotBlank(zone)) {
//            hql.append("AND statueCleaning.zoneid = :zone ");
//        }
//
//        Query query = getSession().createQuery(hql.toString());
//
//        if (StringUtils.isNotBlank(currentDate)) {
//            query.setParameter("currentDate", currentDate);
//        }
//        if (StringUtils.isNotBlank(shift)) {
//            query.setParameter("shift", shift);
//        }
//        if (StringUtils.isNotBlank(zone)) {
//            query.setParameter("zone", zone);
//        }
//
//        Long count = (Long) query.uniqueResult();
//        return (count != null) ? count : 0;
//
//    } catch (Exception exception) {
//        log.error("Error fetching GROUPED draft count", exception);
//        exception.printStackTrace();
//    }
//    return 0;
//}
@Override
public List<StatueCleaning> getByGroupId(String groupId) {
    String hql = "FROM StatueCleaning WHERE entryGroupId = :groupId";

    return getSession().createQuery(hql)
            .setParameter("groupId", groupId)
            .list();
}


}