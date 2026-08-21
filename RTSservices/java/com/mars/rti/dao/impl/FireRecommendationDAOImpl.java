package com.mars.rti.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mars.common.search.ApplicationSearch;
import com.mars.common.utils.Constants;
import com.mars.rti.dao.FireRecommendationDAO;
import com.mars.rti.model.Collection;
import com.mars.rti.model.FireApplicationDTO;
import com.mars.rti.model.FireDetails;
import com.mars.rti.model.FireRecommendation;
import com.mars.rti.model.GaneshMandapPermission;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.RTIApplicationSearch;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FireRecommendationDAOImpl extends HibernateDaoSupport implements FireRecommendationDAO {

	private static final Log log = LogFactory.getLog(FireRecommendationDAOImpl.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public FireRecommendation saveFireRecommendation(FireRecommendation fireRecommendation) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("Mandap save Method is called");
			}
			return (FireRecommendation)getHibernateTemplate().merge(fireRecommendation);
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
	
	public FireRecommendation merge(FireRecommendation entity) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("merge Method is called ");
			}
			return (FireRecommendation) getHibernateTemplate().merge(entity);
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public long fireRecommendationSave(FireRecommendation fireRecommendation)  {
		// TODO Auto-generated method stub
		FireRecommendation b = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("save Method is called ");
			}
			b = (FireRecommendation) getHibernateTemplate().merge(fireRecommendation);

			if (b != null) {
				return b.getFireRecommendationId();
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
		return b.getFireRecommendationId();
	}

	@Override
	public FireRecommendation get(long id){
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + id);
			}
			return (FireRecommendation) getHibernateTemplate().get(FireRecommendation.class, new Long(id));
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;

	}

	@Override
	public List<RTIApplication> getnoc(long serviceId) {
		// TODO Auto-generated method stub
		
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + serviceId);
			}
			String sqlString = "select rtiApplication from RTIApplication rtiApplication where rtiApplication.workFlowStatus=0 and rtiApplication.rtiApplnNumber is not null and rtiApplication.rtiApplnNumber!='' and rtiApplication.rtiserviceid="+serviceId;

			Query query = getSession().createQuery(sqlString);
			List<RTIApplication> list = query.list();
			return list;
			} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public FireRecommendation getnocDetails(long serviceId) {

		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + serviceId);
			}
			String sqlString = "select fireRecommendation from FireRecommendation fireRecommendation where fireRecommendationId.rtiapplrefno is not null and fireRecommendationId.rtiapplrefno!='' and fireRecommendation.fireRecommendationId ="+serviceId;

			Query query = getSession().createQuery(sqlString);
			List list = query.list();
			return (FireRecommendation)list.get(0);
			} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FireDetails> getFireDetails(long fireRecommendationId) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + fireRecommendationId);
			}
			String sqlString = "select fireDetails from FireDetails fireDetails where fireDetails.fireRecommendation.fireRecommendationId="+fireRecommendationId;

			Query query = getSession().createQuery(sqlString);
			List<FireDetails> list = query.list();
			return list;
			} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}
	
	
	
	public void delete(long id) {
		try {
			if (log.isDebugEnabled()) {
				log.debug("deleting RTIApplication instance");
			}
			FireRecommendation entity = (FireRecommendation) getHibernateTemplate().load(FireRecommendation.class, new Long(id));
			getHibernateTemplate().delete(entity);
			log.debug("delete successful");
		} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
	}
	
	
	@Override
	public FireRecommendation getApplicationId(String  applicationId) {

		try {
			if (log.isDebugEnabled()) {
				log.debug("get Method is called " + applicationId);
			}
			String sqlString = "select fireRecommendation from FireRecommendation fireRecommendation where fireRecommendationId.rtiapplrefno is not null and fireRecommendationId.rtiapplrefno!='' and fireRecommendation.rtiapplrefno ="+"'"+applicationId+"'";

			Query query = getSession().createQuery(sqlString);
			List list = query.list();
			return (FireRecommendation)list.get(0);
			} catch (Exception exception) {
			log.error(exception.getStackTrace(), exception);
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public List<RTIApplication> getFireApplications(RTIApplicationSearch applicationSearch, String userZone,
	        String userLevel, boolean isZoneUser) {

	    List<RTIApplication> resultList = new ArrayList<>();

	    try {

	        StringBuilder sql = new StringBuilder();

	        sql.append(" SELECT ra.* ");
	        sql.append(" FROM egovrti.rti_application ra ");
	        sql.append(" JOIN egovrti.fire_recommendation_main frm ");
	        sql.append("   ON ra.rti_application_id = frm.rti_ref_id ");
	        sql.append(" WHERE 1=1 ");

//	        // 🔹 L1 Logic
//	        if ("L1".equalsIgnoreCase(userLevel)) {
//	            sql.append(" AND ra.zone = :zone ");
//	            sql.append(" AND frm.fire_sub_department_wise_login = '1' ");
//	        }
//
//	        // 🔹 L2 Logic
//	        else if ("L2".equalsIgnoreCase(userLevel)) {
//	            sql.append(" AND frm.fire_sub_department_wise_login IN ('1','2','3') ");
//	        }
//
//	        // 🔹 Optional Filters
//	        if (applicationSearch.getRtiApplicationNumber() != null &&
//	                !applicationSearch.getRtiApplicationNumber().isEmpty()) {
//
//	            sql.append(" AND ra.rti_application_number = :appNo ");
//	        }
	        
	        
	        // 🔹 L1 Logic && isZoneUser=false
	        if ("L1".equalsIgnoreCase(userLevel) && !isZoneUser) {
	            sql.append(" AND ra.zone = :zone ");
	            sql.append(" AND frm.fire_sub_department_wise_login = '1' ");
	            sql.append(" AND ra.workflow_status in ('0','5')");
	            sql.append(" AND (frm.remarkfor_l2 IS NULL OR TRIM(frm.remarkfor_l2) = '') ");
	            sql.append(" AND frm.forwarded_to_l1 = TRUE ");



	        }

	        // 🔹 L2 Logic && isZoneUser=true
	        else if ("L2".equalsIgnoreCase(userLevel) && isZoneUser) {
	            sql.append(" AND frm.fire_sub_department_wise_login IN ('2','3') ");
	            sql.append(" AND ra.workflow_status in ('0','5')");
	            sql.append(" AND (frm.remarkfor_l2 IS NULL OR TRIM(frm.remarkfor_l2) = '') ");
	            sql.append(" AND frm.forwarded_to_l1 = TRUE ");


	        }
	        // 🔹 L2 Logic && isZoneUser=false
	        else if ("L2".equalsIgnoreCase(userLevel) && !isZoneUser) {
	            sql.append(" AND frm.fire_sub_department_wise_login IN ('1','2','3') ");
	          //  sql.append(" AND frm.remarkfor_l2 IS NOT NULL ");
	          //  sql.append(" AND TRIM(frm.remarkfor_l2) <> '' ");
	            sql.append(" AND ra.workflow_status in ('0','3','2','1','5')");
	            sql.append(" AND frm.forwarded_to_l1 = FALSE ");


	        }

	        // 🔹 Optional Filters
	        if (applicationSearch.getRtiApplicationNumber() != null &&
	                !applicationSearch.getRtiApplicationNumber().isEmpty()) {

	            sql.append(" AND ra.rti_application_number = :appNo ");
	        }
	        
	        sql.append(" ORDER BY ra.rti_application_id DESC ");

	        SQLQuery query = getSession().createSQLQuery(sql.toString());
	        query.addEntity(RTIApplication.class);

	        // 🔹 Parameters
	        if ("L1".equalsIgnoreCase(userLevel)) {
	            query.setParameter("zone", userZone);
	        }

	        if (applicationSearch.getRtiApplicationNumber() != null &&
	                !applicationSearch.getRtiApplicationNumber().isEmpty()) {

	            query.setParameter("appNo", applicationSearch.getRtiApplicationNumber());
	        }

	        // 🔹 Pagination
	        Long pageNumber = applicationSearch.getCurrentPage();

            if (pageNumber != (long)Constants.DEFAULT_PAGINATION_ALL_ROWS) {

	            if (pageNumber > 1) {
	                query.setFirstResult((int) ((pageNumber - 1) * Constants.DEFAULT_ROWS_PER_PAGE));
	            } else {
	                query.setFirstResult(0);
	            }

	            query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
	        }

	        resultList = query.list();

	    } catch (Exception e) {
	        log.error("Error in getFireApplications", e);
	        e.printStackTrace();
	    }

	    return resultList;
	}
	
	@Override
	public long getFireApplicationsCount(RTIApplicationSearch applicationSearch, String userZone,
	        String userLevel, boolean isZoneUser) {

	    long count = 0;

	    try {

	        StringBuilder sql = new StringBuilder();

	        sql.append(" SELECT COUNT(*) ");
	        sql.append(" FROM egovrti.rti_application ra ");
	        sql.append(" JOIN egovrti.fire_recommendation_main frm ");
	        sql.append("   ON ra.rti_application_id = frm.rti_ref_id ");
	        sql.append(" WHERE 1=1 ");

//	        // 🔹 L1 Logic
//	        if ("L1".equalsIgnoreCase(userLevel)) {
//	            sql.append(" AND ra.zone = :zone ");
//	            sql.append(" AND frm.fire_sub_department_wise_login = '1' ");
//	        }
//
//	        // 🔹 L2 Logic
//	        else if ("L2".equalsIgnoreCase(userLevel)) {
//	            sql.append(" AND frm.fire_sub_department_wise_login IN ('1','2','3') ");
//	        }

	        // 🔹 L1 Logic && isZoneUser=false
	        if ("L1".equalsIgnoreCase(userLevel) && !isZoneUser) {
	            sql.append(" AND ra.zone = :zone ");
	            sql.append(" AND frm.fire_sub_department_wise_login = '1' ");
	            sql.append(" AND ra.workflow_status in ('0','5')");
	            sql.append(" AND (frm.remarkfor_l2 IS NULL OR TRIM(frm.remarkfor_l2) = '') ");
	            sql.append(" AND frm.forwarded_to_l1 = TRUE ");



	        }

	        // 🔹 L2 Logic && isZoneUser=true
	        else if ("L2".equalsIgnoreCase(userLevel) && isZoneUser) {
	            sql.append(" AND frm.fire_sub_department_wise_login IN ('2','3') ");
	            sql.append(" AND ra.workflow_status in ('0','5')");
	            sql.append(" AND (frm.remarkfor_l2 IS NULL OR TRIM(frm.remarkfor_l2) = '') ");
	            sql.append(" AND frm.forwarded_to_l1 = TRUE ");


	        }
	        // 🔹 L2 Logic && isZoneUser=false
	        else if ("L2".equalsIgnoreCase(userLevel) && !isZoneUser) {
	            sql.append(" AND frm.fire_sub_department_wise_login IN ('1','2','3') ");
	          //  sql.append(" AND frm.remarkfor_l2 IS NOT NULL ");
	          //  sql.append(" AND TRIM(frm.remarkfor_l2) <> '' ");
	            sql.append(" AND ra.workflow_status in ('0','3','2','1','5')");
	            sql.append(" AND frm.forwarded_to_l1 = FALSE ");


	        }

	        // 🔹 Optional Filter
	        if (applicationSearch.getRtiApplicationNumber() != null &&
	                !applicationSearch.getRtiApplicationNumber().isEmpty()) {

	            sql.append(" AND ra.rti_application_number = :appNo ");
	        }

	        SQLQuery query = getSession().createSQLQuery(sql.toString());

	        // 🔹 Parameters
	        if ("L1".equalsIgnoreCase(userLevel)) {
	            query.setParameter("zone", userZone);
	        }

	        if (applicationSearch.getRtiApplicationNumber() != null &&
	                !applicationSearch.getRtiApplicationNumber().isEmpty()) {

	            query.setParameter("appNo", applicationSearch.getRtiApplicationNumber());
	        }

	        Object result = query.uniqueResult();

	        if (result != null) {
	            count = ((Number) result).longValue();
	        }

	    } catch (Exception e) {
	        log.error("Error in getFireApplicationsCount", e);
	        e.printStackTrace();
	    }

	    return count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FireDetails> findByFireRecommendationId(long fireRecommendationId) {

	    return getSession().createQuery(
	            "FROM FireDetails WHERE fireRecommendation.fireRecommendationId = :id")
	            .setParameter("id", fireRecommendationId)
	            .list();
	}
	@Override
	public void update(FireRecommendation fireRecommendation) {
	    getSession().update(fireRecommendation);
	}
	
	@Override
	public FireRecommendation getDetails(long rtiApplicationId) {
		try{

			String sqlQuery="select fireRecommendation from FireRecommendation fireRecommendation where rti_ref_id = "+rtiApplicationId;

			Query query = getSession().createQuery(sqlQuery);

			List list = query.list();

			if (list != null && list.size() > 0)     
				return (FireRecommendation) list.get(0);
		}catch(Exception e){
			log.error(e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	



	@Override
	@Transactional
	public void saveUpdatedFees(Long fireId,
	                            String feesRemarks,
	                            String updatedScrutinyFees,
	                            String updatedTotalFees) {

	    try {

	        if (log.isDebugEnabled()) {
	            log.debug("saveUpdatedFees Method Called");
	        }

	        FireRecommendation fireRecommendation =
	                (FireRecommendation) getSession().get(
	                        FireRecommendation.class,
	                        fireId);

	        if (fireRecommendation != null) {

	            fireRecommendation.setFeesRemarks(feesRemarks);

	            fireRecommendation.setUpdatedScrutinyFees(
	                    updatedScrutinyFees);

	            fireRecommendation.setUpdatedTotalFees(
	                    updatedTotalFees);

	            getSession().update(fireRecommendation);

	            log.debug("Fees Updated Successfully");
	        }

	    } catch (Exception e) {

	        log.error(e.getStackTrace(), e);

	        e.printStackTrace();

	        throw new RuntimeException(e.getMessage());
	    }
	}
	@Override
	public String getForwardUser(
	        String zone,
	        String category){

	    Query query;

	    if("2".equals(category)
	            || "3".equals(category)){

	        query=getSession().createSQLQuery(

	        "select concat(first_name,' ',last_name) " +
	        "from egovcommon.users " +
	        "where user_level='L2' " +
	        "and department_id=12 " +
	        "limit 1");

	    }
	    else{

	        query=getSession().createSQLQuery(

	        "select concat(first_name,' ',last_name) " +
	        "from egovcommon.users " +
	        "where user_zone=:zone " +
	        "and user_level='L1' " +
	        "and department_id=12 " +
	        "limit 1")

	        .setParameter("zone",zone);
	    }

	    List list=query.list();

	    return list!=null && !list.isEmpty()
	            ? list.get(0).toString()
	            : "";
	}
	
	@Override
	public Map<Long, List<Collection>> getPaymentMap(List<RTIApplication> applications) {

	    Map<Long, List<Collection>> paymentMap = new HashMap<Long, List<Collection>>();

	    if (applications == null || applications.isEmpty()) {
	        return paymentMap;
	    }

	    for (RTIApplication app : applications) {
	        List<Collection> collections = getSession()
	                .createQuery("from Collection c where c.rtiApplication = :appId order by c.amount")
	                .setParameter("appId", app.getRtiApplicationId())
	                .list();

	        paymentMap.put(app.getRtiApplicationId(), collections);
	    }

	    return paymentMap;
	}
	@Override
	public List<RTIApplication> getCitizenApplications(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {

	    StringBuilder sql = new StringBuilder();

	    sql.append("SELECT ra.* ");
	    sql.append("FROM egovrti.rti_application ra ");
	    sql.append("JOIN egovrti.fire_recommendation_main frm ");
	    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
	    sql.append("WHERE 1=1 ");
	    sql.append("AND frm.forwarded_to_l1 = FALSE ");
	    sql.append("AND (frm.remarkfor_l2 IS NULL OR TRIM(frm.remarkfor_l2) = '') ");
	    sql.append("AND ra.workflow_status = 0 ");

	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
	        sql.append("AND ra.zone = :zone ");
	    }

	    if (applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
	        sql.append("AND ra.rti_application_number = :appNo ");
	    }

	    sql.append("ORDER BY ra.rti_application_id DESC");

	    SQLQuery query = getSession().createSQLQuery(sql.toString());
	    query.addEntity(RTIApplication.class);

	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
	        query.setParameter("zone", userZone.trim());
	    }

	    if (applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
	        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
	    }

	    if (applicationSearch.getCurrentPage() != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
	        int first = (int) ((applicationSearch.getCurrentPage() - 1)
	                * Constants.DEFAULT_ROWS_PER_PAGE);
	        query.setFirstResult(first);
	        query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
	    }

	    return query.list();
	}
	
	@Override
	public long getCitizenApplicationsCount(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {

	    boolean applyZoneFilter = !isZoneUser
	            && userZone != null
	            && !"".equals(userZone.trim());

	    boolean applyAppNoFilter = applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim());

	    StringBuilder sql = new StringBuilder();

	    sql.append("SELECT COUNT(*) ");
	    sql.append("FROM egovrti.rti_application ra ");
	    sql.append("JOIN egovrti.fire_recommendation_main frm ");
	    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
	    sql.append("WHERE 1=1 ");
	    sql.append("AND frm.forwarded_to_l1 = FALSE ");
	    sql.append("AND (frm.remarkfor_l2 IS NULL OR TRIM(frm.remarkfor_l2) = '') ");
	    sql.append("AND ra.workflow_status = 0 ");

	    if (applyZoneFilter) {
	        sql.append("AND ra.zone = :zone ");
	    }

	    if (applyAppNoFilter) {
	        sql.append("AND ra.rti_application_number = :appNo ");
	    }

	    SQLQuery query = getSession().createSQLQuery(sql.toString());

	    if (applyZoneFilter) {
	        query.setParameter("zone", userZone.trim());
	    }

	    if (applyAppNoFilter) {
	        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
	    }

	    return ((Number) query.uniqueResult()).longValue();
	}
	
	//forwarded
	@Override
	public List<RTIApplication> getForwardedApplications(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {

	    StringBuilder sql = new StringBuilder();

	    sql.append("SELECT ra.* ");
	    sql.append("FROM egovrti.rti_application ra ");
	    sql.append("JOIN egovrti.fire_recommendation_main frm ");
	    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
	    sql.append("WHERE 1=1 ");
	   	    
	    sql.append("AND frm.forwarded_to_l1=TRUE ");
        sql.append(" AND (frm.remarkfor_l2 IS NULL OR TRIM(frm.remarkfor_l2) = '') ");
	    sql.append("AND ra.workflow_status = 0 ");

	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
	        sql.append("AND ra.zone = :zone ");
	    }

	    if (applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
	        sql.append("AND ra.rti_application_number = :appNo ");
	    }

	    sql.append("ORDER BY ra.rti_application_id DESC");

	    SQLQuery query = getSession().createSQLQuery(sql.toString());
	    query.addEntity(RTIApplication.class);

	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
	        query.setParameter("zone", userZone.trim());
	    }

	    if (applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
	        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
	    }

	    if (applicationSearch.getCurrentPage() != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
	        int first = (int) ((applicationSearch.getCurrentPage() - 1)
	                * Constants.DEFAULT_ROWS_PER_PAGE);
	        query.setFirstResult(first);
	        query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
	    }

	    return query.list();
	}
	
	@Override
	public long getForwardedApplicationsCount(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {

	    boolean applyZoneFilter = !isZoneUser
	            && userZone != null
	            && !"".equals(userZone.trim());

	    boolean applyAppNoFilter = applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim());

	    StringBuilder sql = new StringBuilder();

	    sql.append("SELECT COUNT(*) ");
	    sql.append("FROM egovrti.rti_application ra ");
	    sql.append("JOIN egovrti.fire_recommendation_main frm ");
	    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
	    sql.append("WHERE 1=1 ");
	    sql.append("AND frm.forwarded_to_l1=TRUE ");
        sql.append(" AND (frm.remarkfor_l2 IS NULL OR TRIM(frm.remarkfor_l2) = '') ");
	    sql.append("AND ra.workflow_status = 0 ");

	    if (applyZoneFilter) {
	        sql.append("AND ra.zone = :zone ");
	    }

	    if (applyAppNoFilter) {
	        sql.append("AND ra.rti_application_number = :appNo ");
	    }

	    SQLQuery query = getSession().createSQLQuery(sql.toString());

	    if (applyZoneFilter) {
	        query.setParameter("zone", userZone.trim());
	    }

	    if (applyAppNoFilter) {
	        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
	    }

	    return ((Number) query.uniqueResult()).longValue();
	}
	
	//old
	
	@Override
	public List<RTIApplication> getL1Applications(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {

	    StringBuilder sql = new StringBuilder();

	    sql.append("SELECT ra.* ");
	    sql.append("FROM egovrti.rti_application ra ");
	    sql.append("JOIN egovrti.fire_recommendation_main frm ");
	    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
	    sql.append("WHERE 1=1 ");
	    sql.append("AND frm.forwarded_to_l1=FALSE ");
	    sql.append("AND COALESCE(TRIM(frm.remarkfor_l2),'') <> '' ");
	    sql.append("AND ra.workflow_status = 0 ");

	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
	        sql.append("AND ra.zone = :zone ");
	    }

	    if (applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
	        sql.append("AND ra.rti_application_number = :appNo ");
	    }

	    sql.append("ORDER BY ra.rti_application_id DESC");

	    SQLQuery query = getSession().createSQLQuery(sql.toString());
	    query.addEntity(RTIApplication.class);

	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
	        query.setParameter("zone", userZone.trim());
	    }

	    if (applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
	        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
	    }

	    if (applicationSearch.getCurrentPage() != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
	        int first = (int) ((applicationSearch.getCurrentPage() - 1)
	                * Constants.DEFAULT_ROWS_PER_PAGE);
	        query.setFirstResult(first);
	        query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
	    }

	    return query.list();
	}
	
	@Override
	public long getL1ApplicationsCount(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {

	    boolean applyZoneFilter = !isZoneUser
	            && userZone != null
	            && !"".equals(userZone.trim());

	    boolean applyAppNoFilter = applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim());

	    StringBuilder sql = new StringBuilder();

	    sql.append("SELECT COUNT(*) ");
	    sql.append("FROM egovrti.rti_application ra ");
	    sql.append("JOIN egovrti.fire_recommendation_main frm ");
	    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
	    sql.append("WHERE 1=1 ");
	    sql.append("AND frm.forwarded_to_l1=FALSE ");
	    sql.append("AND COALESCE(TRIM(frm.remarkfor_l2),'') <> '' ");
	    sql.append("AND ra.workflow_status = 0 ");

	    if (applyZoneFilter) {
	        sql.append("AND ra.zone = :zone ");
	    }

	    if (applyAppNoFilter) {
	        sql.append("AND ra.rti_application_number = :appNo ");
	    }

	    SQLQuery query = getSession().createSQLQuery(sql.toString());

	    if (applyZoneFilter) {
	        query.setParameter("zone", userZone.trim());
	    }

	    if (applyAppNoFilter) {
	        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
	    }

	    return ((Number) query.uniqueResult()).longValue();
	}
	
//	@Override
//	public List<RTIApplication> getTotalApplications(
//	        RTIApplicationSearch applicationSearch,
//	        String userZone,
//	        String userLevel,
//	        boolean isZoneUser){
//
//
//	    StringBuilder sql = new StringBuilder();
//	    
//
//	    sql.append("SELECT ra.* ");
//	    sql.append("FROM egovrti.rti_application ra ");
//	    sql.append("JOIN egovrti.fire_recommendation_main frm ");
//	    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
//	    sql.append("WHERE 1=1 ");
////	    sql.append("AND frm.forwarded_to_l1=FALSE ");
////	    sql.append("AND COALESCE(TRIM(frm.remarkfor_l2),'') <> '' ");
////	    sql.append("AND ra.workflow_status = 0 ");
//
//	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
//	        sql.append("AND ra.zone = :zone ");
//	    }
//
//	    if (applicationSearch.getRtiApplicationNumber() != null
//	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
//	        sql.append("AND ra.rti_application_number = :appNo ");
//	    }
//
//	    sql.append("ORDER BY ra.rti_application_id DESC");
//
//	    SQLQuery query = getSession().createSQLQuery(sql.toString());
//	    query.addEntity(RTIApplication.class);
//
//	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
//	        query.setParameter("zone", userZone.trim());
//	    }
//
//	    if (applicationSearch.getRtiApplicationNumber() != null
//	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
//	        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
//	    }
//
//	    if (applicationSearch.getCurrentPage() != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
//	        int first = (int) ((applicationSearch.getCurrentPage() - 1)
//	                * Constants.DEFAULT_ROWS_PER_PAGE);
//	        query.setFirstResult(first);
//	        query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
//	    }
//
//	    return query.list();
//	}
	
	@Override
	public List<FireApplicationDTO> getTotalApplications(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {

	    StringBuilder sql = new StringBuilder();

	    sql.append("SELECT ");
	    sql.append("ra.*, ");
	    sql.append("frm.forwarded_to_l1, ");
	    sql.append("frm.remarkfor_l2 ");
	    sql.append("FROM egovrti.rti_application ra ");
	    sql.append("JOIN egovrti.fire_recommendation_main frm ");
	    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
	    sql.append("WHERE 1=1 ");

	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
	        sql.append("AND ra.zone = :zone ");
	    }

	    if (applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
	        sql.append("AND ra.rti_application_number = :appNo ");
	    }

	    sql.append("ORDER BY ra.rti_application_id DESC");

	    SQLQuery query = getSession().createSQLQuery(sql.toString());

	    query.addEntity("ra", RTIApplication.class);
	    query.addScalar("forwarded_to_l1", Hibernate.BOOLEAN);
	    query.addScalar("remarkfor_l2", Hibernate.STRING);
	    
	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
	        query.setParameter("zone", userZone.trim());
	    }

	    if (applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
	        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
	    }

	    if (applicationSearch.getCurrentPage() != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
	        int first = (int) ((applicationSearch.getCurrentPage() - 1)
	                * Constants.DEFAULT_ROWS_PER_PAGE);

	        query.setFirstResult(first);
	        query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
	    }

	    List<Object[]> rows = query.list();

	    List<FireApplicationDTO> result = new ArrayList<FireApplicationDTO>();

	    for (Object[] row : rows) {

	        RTIApplication app = (RTIApplication) row[0];
	        Boolean forwarded = (Boolean) row[1];
	        String remark = row[2] == null ? "" : row[2].toString().trim();

	        FireApplicationDTO dto = new FireApplicationDTO();

	        dto.setApplication(app);

	        if (app.getWorkFlowStatus() == 0) {

	            if (!forwarded && remark.isEmpty()) {

	                dto.setApplicationStatus(
	                        "Citizen Form Submitted and scrutiny fee paid");

	            } else if (forwarded && remark.isEmpty()) {

	                dto.setApplicationStatus("Zone Transfer");

	            } else if (!forwarded && !remark.isEmpty()) {

	                dto.setApplicationStatus("Pending");

	            }

	        } else if (app.getWorkFlowStatus() == 3) {

	            dto.setApplicationStatus("Citizen Payment Pending");

	        } else if (app.getWorkFlowStatus() == 2) {

	            dto.setApplicationStatus("Citizen Payment Completed");

	        } else if (app.getWorkFlowStatus() == 1) {

	            dto.setApplicationStatus("Completed");

	        } else if (app.getWorkFlowStatus() == 5) {

	            dto.setApplicationStatus("Rejected");

	        } else {

	            dto.setApplicationStatus("N/A");
	        }

	        result.add(dto);
	    }

	    return result;
	}
	@Override
	public long getTotalApplicationsCount(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {
		  boolean applyZoneFilter = !isZoneUser
		            && userZone != null
		            && !"".equals(userZone.trim());

		    boolean applyAppNoFilter = applicationSearch.getRtiApplicationNumber() != null
		            && !"".equals(applicationSearch.getRtiApplicationNumber().trim());

		    StringBuilder sql = new StringBuilder();

		    sql.append("SELECT COUNT(*) ");
		    sql.append("FROM egovrti.rti_application ra ");
		    sql.append("JOIN egovrti.fire_recommendation_main frm ");
		    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
		    sql.append("WHERE 1=1 ");
//		    sql.append("AND frm.forwarded_to_l1=FALSE ");
//		    sql.append("AND COALESCE(TRIM(frm.remarkfor_l2),'') <> '' ");
//		    sql.append("AND ra.workflow_status = 0 ");

		    if (applyZoneFilter) {
		        sql.append("AND ra.zone = :zone ");
		    }

		    if (applyAppNoFilter) {
		        sql.append("AND ra.rti_application_number = :appNo ");
		    }

		    SQLQuery query = getSession().createSQLQuery(sql.toString());

		    if (applyZoneFilter) {
		        query.setParameter("zone", userZone.trim());
		    }

		    if (applyAppNoFilter) {
		        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
		    }

		    return ((Number) query.uniqueResult()).longValue();
		
	}
	
	
	@Override
	public List<RTIApplication> getCompletedApplications(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser){


	    StringBuilder sql = new StringBuilder();

	    sql.append("SELECT ra.* ");
	    sql.append("FROM egovrti.rti_application ra ");
	    sql.append("JOIN egovrti.fire_recommendation_main frm ");
	    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
	    sql.append("WHERE 1=1 ");
//	    sql.append("AND frm.forwarded_to_l1=FALSE ");
//	    sql.append("AND COALESCE(TRIM(frm.remarkfor_l2),'') <> '' ");
	    sql.append("AND ra.workflow_status = 1 ");

	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
	        sql.append("AND ra.zone = :zone ");
	    }

	    if (applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
	        sql.append("AND ra.rti_application_number = :appNo ");
	    }

	    sql.append("ORDER BY ra.rti_application_id DESC");

	    SQLQuery query = getSession().createSQLQuery(sql.toString());
	    query.addEntity(RTIApplication.class);

	    if (!isZoneUser && userZone != null && !"".equals(userZone.trim())) {
	        query.setParameter("zone", userZone.trim());
	    }

	    if (applicationSearch.getRtiApplicationNumber() != null
	            && !"".equals(applicationSearch.getRtiApplicationNumber().trim())) {
	        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
	    }

	    if (applicationSearch.getCurrentPage() != Constants.DEFAULT_PAGINATION_ALL_ROWS) {
	        int first = (int) ((applicationSearch.getCurrentPage() - 1)
	                * Constants.DEFAULT_ROWS_PER_PAGE);
	        query.setFirstResult(first);
	        query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
	    }

	    return query.list();
		
	}
	@Override
	public long getCompletedApplicationsCount(
	        RTIApplicationSearch applicationSearch,
	        String userZone,
	        String userLevel,
	        boolean isZoneUser) {
		  boolean applyZoneFilter = !isZoneUser
		            && userZone != null
		            && !"".equals(userZone.trim());

		    boolean applyAppNoFilter = applicationSearch.getRtiApplicationNumber() != null
		            && !"".equals(applicationSearch.getRtiApplicationNumber().trim());

		    StringBuilder sql = new StringBuilder();

		    sql.append("SELECT COUNT(*) ");
		    sql.append("FROM egovrti.rti_application ra ");
		    sql.append("JOIN egovrti.fire_recommendation_main frm ");
		    sql.append("ON ra.rti_application_id = frm.rti_ref_id ");
		    sql.append("WHERE 1=1 ");
//		    sql.append("AND frm.forwarded_to_l1=FALSE ");
//		    sql.append("AND COALESCE(TRIM(frm.remarkfor_l2),'') <> '' ");
		    sql.append("AND ra.workflow_status = 1 ");

		    if (applyZoneFilter) {
		        sql.append("AND ra.zone = :zone ");
		    }

		    if (applyAppNoFilter) {
		        sql.append("AND ra.rti_application_number = :appNo ");
		    }

		    SQLQuery query = getSession().createSQLQuery(sql.toString());

		    if (applyZoneFilter) {
		        query.setParameter("zone", userZone.trim());
		    }

		    if (applyAppNoFilter) {
		        query.setParameter("appNo", applicationSearch.getRtiApplicationNumber().trim());
		    }

		    return ((Number) query.uniqueResult()).longValue();
	}
	
	
}
