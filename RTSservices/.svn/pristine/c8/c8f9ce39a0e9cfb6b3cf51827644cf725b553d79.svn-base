package com.mars.rti.dao.impl;

import com.mars.common.utils.Constants;
import com.mars.rti.dao.DashBoardDAO;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.DashBoardLabelSearch;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DashBoardDAOImpl extends HibernateDaoSupport implements DashBoardDAO {
   private static final Log log = LogFactory.getLog(DashBoardDAOImpl.class);

   @Autowired
   public void init(SessionFactory factory) {
      this.setSessionFactory(factory);
   }

   public long getPieChartOrBarChartData(String userZone, String serviceId, String currentYear) {
      if (log.isDebugEnabled()) {
         log.debug("getPieChartOrBarChartData Method is called");
      }

      try {
         new ArrayList();
         StringBuffer sql = new StringBuffer();
         String fromClause;
         if (userZone != null && !userZone.isEmpty()) {
            fromClause = "select count(r) from RTIApplication r WHERE r.rtiApplnNumber is not null and r.workFlowStatus in (0,1,2,3,5,9,10,11) and r.rtiApplnNumber!='' and r.zone='" + userZone + "' and r.rtiserviceid in(" + serviceId + ") AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         } else {
            fromClause = "select count(r) from RTIApplication r WHERE r.rtiApplnNumber is not null and r.rtiApplnNumber!='' and r.workFlowStatus in (0,1,2,3,5,9,10,11) and r.rtiserviceid in(" + serviceId + ") AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         }

         sql.insert(0, fromClause);
         Query query = this.getSession().createQuery(sql.toString());
         List<Long> list = query.list();
         return list != null && list.size() > 0 ? Long.parseLong(((Long)list.get(0)).toString()) : 0L;
      } catch (NullPointerException var8) {
         log.error(var8.getStackTrace());
         throw new NullPointerException();
      } catch (HibernateException var9) {
         log.error(var9.getStackTrace());
         throw new HibernateException(var9.getMessage());
      } catch (Exception var10) {
         log.error(var10.getStackTrace());
         var10.printStackTrace();
         throw new RuntimeException(var10.getCause());
      }
   }

   public long getPieChartOrBarChartData(String condValue, String userZone, String serviceId, String currentYear) {
      if (log.isDebugEnabled()) {
         log.debug("getPieChartOrBarChartData Method is called");
      }

      try {
         new ArrayList();
         StringBuffer sql = new StringBuffer();
         String fromClause;
         if (userZone != null && !userZone.isEmpty()) {
            if (condValue.equals("0")) {
               fromClause = "select count(r) from RTIApplication r where r.workFlowStatus in (9,10,11,'" + condValue + "') and  r.zone='" + userZone + "' and r.rtiApplnNumber is not null and r.rtiApplnNumber!='' and r.rtiserviceid in(" + serviceId + ") AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
            } else {
               fromClause = "select count(r) from RTIApplication r where r.workFlowStatus = '" + condValue + "' and  r.zone='" + userZone + "' and r.rtiApplnNumber is not null and r.rtiApplnNumber!='' and r.rtiserviceid in(" + serviceId + ") AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
            }
         } else if (condValue.equals("0")) {
            fromClause = "select count(r) from RTIApplication r where r.workFlowStatus in (9,10,11,'" + condValue + "') and r.rtiApplnNumber is not null and r.rtiApplnNumber!='' and r.rtiserviceid in(" + serviceId + ") AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         } else {
            fromClause = "select count(r) from RTIApplication r where r.workFlowStatus ='" + condValue + "' and r.rtiApplnNumber is not null and r.rtiApplnNumber!='' and r.rtiserviceid in(" + serviceId + ") AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         }

         sql.insert(0, fromClause);
         Query query = this.getSession().createQuery(sql.toString());
         List<Long> list = query.list();
         return list != null && list.size() > 0 ? Long.parseLong(((Long)list.get(0)).toString()) : 0L;
      } catch (NullPointerException var9) {
         log.error(var9.getStackTrace());
         throw new NullPointerException();
      } catch (HibernateException var10) {
         log.error(var10.getStackTrace());
         throw new HibernateException(var10.getMessage());
      } catch (Exception var11) {
         log.error(var11.getStackTrace());
         var11.printStackTrace();
         throw new RuntimeException(var11.getCause());
      }
   }

   public long getPieChartOrBarChartData(String condValue1, String condValue2, String condValue3, String userZone, String serviceId, String currentYear) {
      if (log.isDebugEnabled()) {
         log.debug("getPieChartOrBarChartData Method is called");
      }

      try {
         new ArrayList();
         StringBuffer sql = new StringBuffer();
         String fromClause;
         if (userZone != null && !userZone.isEmpty()) {
            fromClause = "select count(r) from RTIApplication r where r.workFlowStatus=3 and r.zone='" + userZone + "' and r.rtiApplnNumber is not null and r.rtiApplnNumber!='' and r.rtiserviceid in(" + serviceId + ") AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         } else {
            fromClause = "select count(r) from RTIApplication r where r.workFlowStatus=3 and r.rtiApplnNumber is not null and r.rtiApplnNumber!='' and r.rtiserviceid in(" + serviceId + ")  AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         }

         sql.insert(0, fromClause);
         Query query = this.getSession().createQuery(sql.toString());
         List<Long> list = query.list();
         return list != null && list.size() > 0 ? Long.parseLong(((Long)list.get(0)).toString()) : 0L;
      } catch (NullPointerException var11) {
         log.error(var11.getStackTrace());
         throw new NullPointerException();
      } catch (HibernateException var12) {
         log.error(var12.getStackTrace());
         throw new HibernateException(var12.getMessage());
      } catch (Exception var13) {
         log.error(var13.getStackTrace());
         var13.printStackTrace();
         throw new RuntimeException(var13.getCause());
      }
   }

   public List<BigInteger> getPieChartOrBarChartBasedOnSearch(String registrtionFromDate, String registrtionToDate, String departments, String services, String userZone, String serviceId, String currentYear) {
      try {
         new ArrayList();
         StringBuffer sql = new StringBuffer();
         String fromClause = "";
         String userZoneCondition;
         String userServiceIdCondition;

if (departments != null && !departments.isEmpty() && services != null && !services.isEmpty() && registrtionFromDate != null && !registrtionFromDate.isEmpty() && registrtionToDate != null && !registrtionToDate.isEmpty()) {
    // Combination 1: department, service, both dates
    System.out.println("Condition 1: Searching by department, service, and both dates.");
	userZoneCondition = userZone != null && !userZone.isEmpty() ? " and r.zone = " + userZone : "";
       userServiceIdCondition = serviceId != null && !serviceId.isEmpty() ? " and r.rti_service_id IN (" + serviceId + ")" : "";
	   fromClause = fromClause + 
	   "select count(r) as allCount from egovrti.rti_application r where r.workflow_status in(0,1,2,3,5,9,10,11) and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	   "select count(r) as receivedCount from egovrti.rti_application r where r.workflow_status in (9,10,11,0) and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	   "select count(r) as rejectedCount from egovrti.rti_application r where r.workflow_status=5 and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	   "select count(r) as closedCount from egovrti.rti_application r where r.workflow_status=1 and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	   "select count(r) as approvedCount from egovrti.rti_application r where r.workflow_status=2 and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	   "select count(r) as pendingCount from egovrti.rti_application r where r.workflow_status=3 and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	   "select CAST(SUM(r.application_cost) AS numeric) as totalCount from egovrti.rti_application r where r.workflow_status in (2,1) and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	   "select count(r) as policecount from egovrti.rti_application r where r.police_noc is not null and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN  to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	   "select count(r) as trafficcount from egovrti.rti_application r where r.traffic_noc is not null and r.rti_application_number is not null and r.rti_application_number !=''  and date_trunc('day',date(r.created_date)) BETWEEN  to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	   "select count(r) as firecount from egovrti.rti_application r where r.fire_noc is not null and r.rti_application_number is not null and r.rti_application_number !=''  and date_trunc('day',date(r.created_date)) BETWEEN  to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "') " + userZoneCondition + userServiceIdCondition + "and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "')";


} else if (departments != null && !departments.isEmpty() && (services == null || services.isEmpty()) && registrtionFromDate != null && !registrtionFromDate.isEmpty() && registrtionToDate != null && !registrtionToDate.isEmpty()) {
    // Combination 2: department and both dates
    System.out.println("Condition 2: Searching by department and both dates.");
	 userZoneCondition = userZone != null && !userZone.isEmpty() ? " and r.zone = " + userZone : "";
     userServiceIdCondition = serviceId != null && !serviceId.isEmpty() ? " and r.rti_service_id IN (" + serviceId + ")" : "";
     fromClause = fromClause + 
	 "select count(r) as allCount from egovrti.rti_application r where r.workflow_status in(0,1,2,3,5,9,10,11) and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + "and r.department IN ('" + departments + "') UNION ALL " + 
	 "select count(r) as receivedCount from egovrti.rti_application r where r.workflow_status in (9,10,11,0) and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	 "select count(r) as rejectedCount from egovrti.rti_application r where r.workflow_status=5 and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	 "select count(r) as closedCount from egovrti.rti_application r where r.workflow_status=1 and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	 "select count(r) as approvedCount from egovrti.rti_application r where r.workflow_status=2 and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	 "select count(r) as pendingCount from egovrti.rti_application r where r.workflow_status=3 and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	 "select CAST(SUM(r.application_cost) AS numeric) as totalCount from egovrti.rti_application r where r.workflow_status in (2,1) and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	 "select count(r) as policecount from egovrti.rti_application r where r.police_noc is not null and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN  to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	 "select count(r) as trafficcount from egovrti.rti_application r where r.traffic_noc is not null and r.rti_application_number is not null and r.rti_application_number !=''  and date_trunc('day',date(r.created_date)) BETWEEN  to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	 "select count(r) as firecount from egovrti.rti_application r where r.fire_noc is not null and r.rti_application_number is not null and r.rti_application_number !=''  and date_trunc('day',date(r.created_date)) BETWEEN  to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "') " + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "')";
       
} else if (departments != null && !departments.isEmpty() && services != null && !services.isEmpty() && (registrtionFromDate == null || registrtionFromDate.isEmpty() || registrtionToDate == null || registrtionToDate.isEmpty())) {
    // Combination 3: department and service
    System.out.println("Condition 3: Searching by department and service.");
	userZoneCondition = userZone != null && !userZone.isEmpty() ? " and r.zone = " + userZone : "";
    userServiceIdCondition = serviceId != null && !serviceId.isEmpty() ? " and r.rti_service_id IN (" + serviceId + ")" : "";
    fromClause = fromClause + 
	"select count(r) as allCount from egovrti.rti_application r where r.workflow_status in(0,1,2,3,5,9,10,11) and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	"select count(r) as receivedCount from egovrti.rti_application r where r.workflow_status in (9,10,11,0) and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	"select count(r) as rejectedCount from egovrti.rti_application r where r.workflow_status=5 and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	"select count(r) as closedCount from egovrti.rti_application r where r.workflow_status=1 and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	"select count(r) as approvedCount from egovrti.rti_application r where r.workflow_status=2 and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	"select count(r) as pendingCount from egovrti.rti_application r where r.workflow_status=3 and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	"select CAST(SUM(r.application_cost) AS numeric) as totalCount from egovrti.rti_application r where r.workflow_status in (2,1) and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	"select count(r) as policecount from egovrti.rti_application r where r.police_noc is not null and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	"select count(r) as trafficcount from egovrti.rti_application r where r.traffic_noc is not null and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "') UNION ALL " + 
	"select count(r) as firecount from egovrti.rti_application r where r.fire_noc is not null and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') and r.rti_service_id IN ('" + services + "')";
         
//} else if (registrtionFromDate != null && !registrtionFromDate.isEmpty() && registrtionToDate != null && !registrtionToDate.isEmpty() && (departments == null || departments.isEmpty()) || (services == null || services.isEmpty())) {
} else if (registrtionFromDate != null && !registrtionFromDate.isEmpty()
        && registrtionToDate != null && !registrtionToDate.isEmpty()
        && (departments == null || departments.isEmpty())
        && (services == null || services.isEmpty())) {
   

    // Combination 4: both dates
    System.out.println("Condition 4: Searching by both dates.");
	userZoneCondition = userZone != null && !userZone.isEmpty() ? " and r.zone = " + userZone : "";
    userServiceIdCondition = serviceId != null && !serviceId.isEmpty() ? " and r.rti_service_id IN (" + serviceId + ")" : "";
    fromClause = fromClause + 
	"select count(r) as allCount from egovrti.rti_application r where r.workflow_status in(0,1,2,3,5,9,10,11) and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " UNION ALL " + 
	"select count(r) as receivedCount from egovrti.rti_application r where r.workflow_status in (9,10,11,0) and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " UNION ALL " + 
	"select count(r) as rejectedCount from egovrti.rti_application r where r.workflow_status=5 and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " UNION ALL " + 
	"select count(r) as closedCount from egovrti.rti_application r where r.workflow_status=1 and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " UNION ALL " + 
	"select count(r) as approvedCount from egovrti.rti_application r where r.workflow_status=2 and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " UNION ALL " + 
	"select count(r) as pendingCount from egovrti.rti_application r where r.workflow_status=3 and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " UNION ALL " + 
	"select CAST(SUM(r.application_cost) AS numeric) as totalCount from egovrti.rti_application r where r.workflow_status in (2,1) and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " UNION ALL " + 
	"select count(r) as policecount from egovrti.rti_application r where r.police_noc is not null and r.rti_application_number is not null and r.rti_application_number !='' and date_trunc('day',date(r.created_date)) BETWEEN  to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " UNION ALL " + 
	"select count(r) as trafficcount from egovrti.rti_application r where r.traffic_noc is not null and r.rti_application_number is not null and r.rti_application_number !=''  and date_trunc('day',date(r.created_date)) BETWEEN  to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "')" + userZoneCondition + userServiceIdCondition + " UNION ALL " + 
	"select count(r) as firecount from egovrti.rti_application r where r.fire_noc is not null and r.rti_application_number is not null and r.rti_application_number !=''  and date_trunc('day',date(r.created_date)) BETWEEN  to_date('" + registrtionFromDate + "','" + "dd/MM/yyyy" + "') and  to_date('" + registrtionToDate + "','" + "dd/MM/yyyy" + "') " + userZoneCondition + userServiceIdCondition;
         
} else {
    // Default case: No valid combination provided
    System.out.println("No valid combination of fields provided for search.");
	userZoneCondition = userZone != null && !userZone.isEmpty() ? " and r.zone = " + userZone : "";
    userServiceIdCondition = serviceId != null && !serviceId.isEmpty() ? " and r.rti_service_id IN (" + serviceId + ")" : "";
    fromClause = fromClause + 
	"select count(r) as allCount from egovrti.rti_application r where r.workflow_status in(0,1,2,3,5,9,10,11) and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	"select count(r) as receivedCount from egovrti.rti_application r where r.workflow_status in (9,10,11,0) and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	"select count(r) as rejectedCount from egovrti.rti_application r where r.workflow_status=5 and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	"select count(r) as closedCount from egovrti.rti_application r where r.workflow_status=1 and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	"select count(r) as approvedCount from egovrti.rti_application r where r.workflow_status=2 and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	"select count(r) as pendingCount from egovrti.rti_application r where r.workflow_status=3 and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	"select CAST(SUM(r.application_cost) AS numeric) as totalCount from egovrti.rti_application r where r.workflow_status in (2,1) and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	"select count(r) as policecount from egovrti.rti_application r where r.police_noc is not null and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	"select count(r) as trafficcount from egovrti.rti_application r where r.traffic_noc is not null and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "') UNION ALL " + 
	"select count(r) as firecount from egovrti.rti_application r where r.fire_noc is not null and r.rti_application_number is not null and r.rti_application_number !=''" + userZoneCondition + userServiceIdCondition + " and r.department IN ('" + departments + "')";
         
}

         sql.insert(0, fromClause);
         log.info(sql.toString());
         Query query = this.getSession().createSQLQuery(sql.toString());
         List<Object[]> resultList = query.list();
         List<BigInteger> receiptsCountList = new ArrayList();
         Iterator var15 = resultList.iterator();

         while(var15.hasNext()) {
            Object result = var15.next();
            if (result != null) {
               if (result instanceof BigInteger) {
                  receiptsCountList.add((BigInteger)result);
               } else if (result instanceof BigDecimal) {
                  receiptsCountList.add(((BigDecimal)result).toBigInteger());
               } else {
                  receiptsCountList.add(((BigDecimal)result).toBigInteger());
               }
            } else {
               receiptsCountList.add(BigInteger.valueOf(0L));
            }
         }

         if (receiptsCountList != null && !receiptsCountList.isEmpty()) {
            return receiptsCountList;
         } else {
            return null;
         }
      } catch (NullPointerException var16) {
         log.error(var16.getStackTrace());
         throw new NullPointerException();
      } catch (HibernateException var17) {
         log.error(var17.getStackTrace());
         throw new HibernateException(var17.getMessage());
      } catch (Exception var18) {
         log.error(var18.getStackTrace());
         var18.printStackTrace();
         throw new RuntimeException(var18.getCause());
      }
   }

   public List<RTIApplication> getRTIApplicationListByLabel(DashBoardLabelSearch dashBoardLabelSearch, String userZone, String serviceId, String currentYear, String searchrtiApplnNumber) {
      if (log.isDebugEnabled()) {
         log.debug("getRTIApplicationListByLabel Method is called");
      }

      try {
         long pageNumber = dashBoardLabelSearch.getCurrentPage();
         String orderBy = dashBoardLabelSearch.getOrderBy();
         String sortBy = dashBoardLabelSearch.getSortBy();
         String fromDate = dashBoardLabelSearch.getRegistrationFromDate();
         String toDate = dashBoardLabelSearch.getRegistrationToDate();
         String department = dashBoardLabelSearch.getDepartments();
         String services = dashBoardLabelSearch.getServices();
         String currentYearCondition = (department == null || department.isEmpty() || department.length() <= 0) && (fromDate == null || fromDate.isEmpty() || toDate == null || toDate.isEmpty()) ? " AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'" : "";
         String searchrtiApplnNumberCond = searchrtiApplnNumber != null && !searchrtiApplnNumber.isEmpty() ? " and r.rtiApplnNumber = '" + searchrtiApplnNumber + "'" : "";
         StringBuffer sql = new StringBuffer();
         String fromClause;
         if (userZone != null && !userZone.isEmpty()) {
            fromClause = "select r from RTIApplication r where r.rtiApplnNumber is not null and r.rtiApplnNumber!='' and r.zone='" + userZone + "' " + currentYearCondition + searchrtiApplnNumberCond;
         } else {
            fromClause = "select r from RTIApplication r where r.rtiApplnNumber is not null and r.rtiApplnNumber!='' " + currentYearCondition + searchrtiApplnNumberCond;
         }

         List<RTIApplication> list = null;
         boolean flag = false;
         if (dashBoardLabelSearch != null) {
            if (dashBoardLabelSearch.getReceiptSatus() != null && dashBoardLabelSearch.getReceiptSatus().length() > 0) {
               if (!dashBoardLabelSearch.getReceiptSatus().equals("All")) {
                  if (!flag) {
                     flag = true;
                     sql.append(" and ");
                  } else {
                     sql.append(" and ");
                  }
               }

               if (dashBoardLabelSearch.getReceiptSatus().contains("Approved")) {
                  sql.append(" r.workFlowStatus=2 and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().contains("Rejected")) {
                  sql.append(" r.workFlowStatus=5 and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().contains("Pending")) {
                  sql.append(" r.workFlowStatus=3 and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().contains("Closed")) {
                  sql.append(" r.workFlowStatus=1 and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().contains("Received")) {
                  sql.append(" r.workFlowStatus in (0,9,10,11 ) and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().equals("All")) {
                  sql.append("and r.workFlowStatus in (0,1,2,3,5,9,10,11) and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().equals("PoliceNoc")) {
                  sql.append(" r.policeNoc is not null and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().equals("TrafficNoc")) {
                  sql.append(" r.trafficNoc is not null and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().equals("FireNoc")) {
                  sql.append(" r.fireNoc is not null and r.rtiserviceid in(" + serviceId + ")");
               } else {
                  sql.append(" r.workFlowStatus in(1,2) and r.rtiserviceid in(" + serviceId + ")");
               }
            }

            if (dashBoardLabelSearch.getDepartments() != null && !dashBoardLabelSearch.getDepartments().isEmpty() || dashBoardLabelSearch.getServices() != null && !dashBoardLabelSearch.getServices().isEmpty()) {
               if (!flag) {
                  flag = true;
                  sql.append(" and ");
               } else {
                  sql.append(" and ");
               }

               String serviceSequence;
               if (dashBoardLabelSearch.getDepartments() != null && !dashBoardLabelSearch.getDepartments().isEmpty()) {
                  serviceSequence = dashBoardLabelSearch.getDepartments();
                  sql.append("r.department IN ('" + serviceSequence + "') ");
               }

               if (dashBoardLabelSearch.getServices() != null && !dashBoardLabelSearch.getServices().isEmpty()) {
                  if (dashBoardLabelSearch.getDepartments() != null && !dashBoardLabelSearch.getDepartments().isEmpty()) {
                     sql.append("and ");
                  }

                  serviceSequence = dashBoardLabelSearch.getServices();
                  sql.append("r.rtiserviceid IN ('" + serviceSequence + "') ");
               }
            }

            if (dashBoardLabelSearch.getRegistrationFromDate() != null && dashBoardLabelSearch.getRegistrationFromDate().length() > 0 && dashBoardLabelSearch.getRegistrationToDate() != null && dashBoardLabelSearch.getRegistrationToDate().length() > 0) {
               if (!flag) {
                  flag = true;
                  sql.append(" and ");
               } else {
                  sql.append(" and ");
               }

               sql.append("date_trunc('day',date(r.createdDate)) between to_date('" + dashBoardLabelSearch.getRegistrationFromDate() + "','" + "dd/MM/yyyy" + "')  and to_date('" + dashBoardLabelSearch.getRegistrationToDate() + "','" + "dd/MM/yyyy" + "')");
            }
         }

         sql.insert(0, fromClause).append(" order by " + orderBy + " " + sortBy);
         Query query = this.getSession().createQuery(sql.toString());
         if (pageNumber != (long)Constants.DEFAULT_PAGINATION_ALL_ROWS) {
            if (pageNumber > 1L) {
               query.setFirstResult((int)((pageNumber - 1L) * (long)Constants.DEFAULT_ROWS_PER_PAGE));
               query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
            } else {
               query.setFirstResult(0);
               query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
            }
         }

         list = query.list();
         if (pageNumber > 1L) {
            int startSerialNumber = (int)((pageNumber - 1L) * (long)Constants.DEFAULT_ROWS_PER_PAGE + 1L);
            this.adjustSerialNumbers(list, startSerialNumber);
         } else {
            this.adjustSerialNumbers(list, 1);
         }

         return list;
      } catch (NullPointerException var22) {
         log.error(var22.getStackTrace());
         var22.printStackTrace();
         throw new NullPointerException();
      } catch (HibernateException var23) {
         log.error(var23.getStackTrace());
         throw new HibernateException(var23.getMessage());
      } catch (Exception var24) {
         log.error(var24.getStackTrace());
         throw new RuntimeException(var24.getCause());
      }
   }

   public List<RTIApplication> getRTIApplicationListByLabelAll(DashBoardLabelSearch dashBoardLabelSearch, String userZone, String serviceId, String currentYear, String searchrtiApplnNumber) {
      if (log.isDebugEnabled()) {
         log.debug("getRTIApplicationListByLabel Method is called");
      }

      try {
         String orderBy = dashBoardLabelSearch.getOrderBy();
         String sortBy = dashBoardLabelSearch.getSortBy();
         StringBuffer sql = new StringBuffer();
         String fromDate = dashBoardLabelSearch.getRegistrationFromDate();
         String toDate = dashBoardLabelSearch.getRegistrationToDate();
         String department = dashBoardLabelSearch.getDepartments();
         String currentYearCondition = (department == null || department.isEmpty() || department.length() <= 0) && (fromDate == null || fromDate.isEmpty() || toDate == null || toDate.isEmpty()) ? " AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'" : "";
         String searchrtiApplnNumberCond = searchrtiApplnNumber != null && !searchrtiApplnNumber.isEmpty() ? " and r.rtiApplnNumber = '" + searchrtiApplnNumber + "'" : "";
         String fromClause;
         if (userZone != null && !userZone.isEmpty()) {
            fromClause = "select r from RTIApplication r where r.rtiApplnNumber is not null and r.rtiApplnNumber!='' and r.zone='" + userZone + "' " + currentYearCondition + searchrtiApplnNumberCond;
         } else {
            fromClause = "select r from RTIApplication r where r.rtiApplnNumber is not null and r.rtiApplnNumber!=''" + currentYearCondition + searchrtiApplnNumberCond;
         }

         List<RTIApplication> list = null;
         boolean flag = false;
         if (dashBoardLabelSearch != null) {
            if (dashBoardLabelSearch.getReceiptSatus() != null && dashBoardLabelSearch.getReceiptSatus().length() > 0) {
               if (!dashBoardLabelSearch.getReceiptSatus().equals("All")) {
                  if (!flag) {
                     flag = true;
                     sql.append(" and ");
                  } else {
                     sql.append(" and ");
                  }
               }

               if (dashBoardLabelSearch.getReceiptSatus().contains("Approved")) {
                  sql.append(" r.workFlowStatus=2 and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().contains("Rejected")) {
                  sql.append(" r.workFlowStatus=5 and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().contains("Pending")) {
                  sql.append(" r.workFlowStatus=3 and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().contains("Closed")) {
                  sql.append(" r.workFlowStatus=1 and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().contains("Received")) {
                  sql.append(" r.workFlowStatus in (0,9,10,11) and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().equals("All")) {
                  sql.append(" and r.workFlowStatus in (0,1,2,3,5,9,10,11) and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().equals("PoliceNoc")) {
                  sql.append(" r.policeNoc is not null and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().equals("TrafficNoc")) {
                  sql.append(" r.trafficNoc is not null and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().equals("FireNoc")) {
                  sql.append(" r.fireNoc is not null and r.rtiserviceid in(" + serviceId + ")");
               } else {
                  sql.append(" r.workFlowStatus in (1,2) and r.rtiserviceid in(" + serviceId + ")");
               }
            }

            if (dashBoardLabelSearch.getDepartments() != null && !dashBoardLabelSearch.getDepartments().isEmpty() || dashBoardLabelSearch.getServices() != null && !dashBoardLabelSearch.getServices().isEmpty()) {
               if (!flag) {
                  flag = true;
                  sql.append(" and ");
               } else {
                  sql.append(" and ");
               }

               String serviceSequence;
               if (dashBoardLabelSearch.getDepartments() != null && !dashBoardLabelSearch.getDepartments().isEmpty()) {
                  serviceSequence = dashBoardLabelSearch.getDepartments();
                  sql.append("r.department IN ('" + serviceSequence + "') ");
               }

               if (dashBoardLabelSearch.getServices() != null && !dashBoardLabelSearch.getServices().isEmpty()) {
                  if (dashBoardLabelSearch.getDepartments() != null && !dashBoardLabelSearch.getDepartments().isEmpty()) {
                     sql.append("and ");
                  }

                  serviceSequence = dashBoardLabelSearch.getServices();
                  sql.append("r.rtiserviceid IN ('" + serviceSequence + "') ");
               }
            }

            if (dashBoardLabelSearch.getRegistrationFromDate() != null && dashBoardLabelSearch.getRegistrationFromDate().length() > 0 && dashBoardLabelSearch.getRegistrationToDate() != null && dashBoardLabelSearch.getRegistrationToDate().length() > 0) {
               if (!flag) {
                  flag = true;
                  sql.append(" and ");
               } else {
                  sql.append(" and ");
               }

               sql.append("date_trunc('day',date(r.createdDate)) between to_date('" + dashBoardLabelSearch.getRegistrationFromDate() + "','" + "dd/MM/yyyy" + "')  and to_date('" + dashBoardLabelSearch.getRegistrationToDate() + "','" + "dd/MM/yyyy" + "')");
            }
         }

         sql.insert(0, fromClause).append(" order by " + orderBy + " " + sortBy);
         Query query = this.getSession().createQuery(sql.toString());
         list = query.list();
         return list;
      } catch (NullPointerException var18) {
         log.error(var18.getStackTrace());
         var18.printStackTrace();
         throw new NullPointerException();
      } catch (HibernateException var19) {
         log.error(var19.getStackTrace());
         throw new HibernateException(var19.getMessage());
      } catch (Exception var20) {
         log.error(var20.getStackTrace());
         throw new RuntimeException(var20.getCause());
      }
   }

   public long getRTIApplicationCountByLabel(DashBoardLabelSearch dashBoardLabelSearch, String userZone, String serviceId, String currentYear, String searchrtiApplnNumber) {
      if (log.isDebugEnabled()) {
         log.debug("getRTIApplicationCountByLabel Method is called");
      }

      try {
         StringBuffer sql = new StringBuffer();
         String fromDate = dashBoardLabelSearch.getRegistrationFromDate();
         String toDate = dashBoardLabelSearch.getRegistrationToDate();
         String department = dashBoardLabelSearch.getDepartments();
         String currentYearCondition = (department == null || department.isEmpty() || department.length() <= 0) && (fromDate == null || fromDate.isEmpty() || toDate == null || toDate.isEmpty()) ? " AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'" : "";
         String searchrtiApplnNumberCond = searchrtiApplnNumber != null && !searchrtiApplnNumber.isEmpty() ? " and r.rtiApplnNumber = '" + searchrtiApplnNumber + "'" : "";
         String fromClause;
         if (userZone != null && !userZone.isEmpty()) {
            fromClause = "select count(r) from RTIApplication r where r.rtiApplnNumber is not null and r.rtiApplnNumber!='' and r.zone='" + userZone + "' " + currentYearCondition + searchrtiApplnNumberCond;
         } else {
            fromClause = "select count(r) from RTIApplication r where r.rtiApplnNumber is not null and r.rtiApplnNumber!=''" + currentYearCondition + searchrtiApplnNumberCond;
         }

         List list = null;
         boolean flag = false;
         if (dashBoardLabelSearch != null) {
            if (dashBoardLabelSearch.getReceiptSatus() != null && dashBoardLabelSearch.getReceiptSatus().length() > 0) {
               if (!dashBoardLabelSearch.getReceiptSatus().equals("All")) {
                  if (!flag) {
                     flag = true;
                     sql.append(" and ");
                  } else {
                     sql.append(" and ");
                  }
               }

               if (dashBoardLabelSearch.getReceiptSatus().contains("Approved")) {
                  sql.append(" r.workFlowStatus=2 and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().contains("Rejected")) {
                  sql.append(" r.workFlowStatus=5 and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().contains("Pending")) {
                  sql.append(" r.workFlowStatus=3 and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().contains("Closed")) {
                  sql.append(" r.workFlowStatus=1 and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().contains("Received")) {
                  sql.append(" r.workFlowStatus in (0,9,10,11 ) and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().equals("All")) {
                  sql.append(" and r.workFlowStatus in (0,1,2,3,5,9,10,11) and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().equals("PoliceNoc")) {
                  sql.append(" r.policeNoc is not null and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().equals("TrafficNoc")) {
                  sql.append(" r.trafficNoc is not null and r.rtiserviceid in(" + serviceId + ")");
               } else if (dashBoardLabelSearch.getReceiptSatus().equals("FireNoc")) {
                  sql.append(" r.fireNoc is not null and r.rtiserviceid in(" + serviceId + ")");
               } else {
                  sql.append(" r.workFlowStatus in(1,2) and r.rtiserviceid in(" + serviceId + ")");
               }
            }

            if (dashBoardLabelSearch.getDepartments() != null && !dashBoardLabelSearch.getDepartments().isEmpty() || dashBoardLabelSearch.getServices() != null && !dashBoardLabelSearch.getServices().isEmpty()) {
               if (!flag) {
                  flag = true;
                  sql.append(" and ");
               } else {
                  sql.append(" and ");
               }

               String serviceSequence;
               if (dashBoardLabelSearch.getDepartments() != null && !dashBoardLabelSearch.getDepartments().isEmpty()) {
                  serviceSequence = dashBoardLabelSearch.getDepartments();
                  sql.append("r.department IN ('" + serviceSequence + "') ");
               }

               if (dashBoardLabelSearch.getServices() != null && !dashBoardLabelSearch.getServices().isEmpty()) {
                  if (dashBoardLabelSearch.getDepartments() != null && !dashBoardLabelSearch.getDepartments().isEmpty()) {
                     sql.append("and ");
                  }

                  serviceSequence = dashBoardLabelSearch.getServices();
                  sql.append("r.rtiserviceid IN ('" + serviceSequence + "') ");
               }
            }

            if (dashBoardLabelSearch.getRegistrationFromDate() != null && dashBoardLabelSearch.getRegistrationFromDate().length() > 0 && dashBoardLabelSearch.getRegistrationToDate() != null && dashBoardLabelSearch.getRegistrationToDate().length() > 0) {
               if (!flag) {
                  flag = true;
                  sql.append(" and ");
               } else {
                  sql.append(" and ");
               }

               sql.append("date_trunc('day',date(r.createdDate)) between to_date('" + dashBoardLabelSearch.getRegistrationFromDate() + "','" + "dd/MM/yyyy" + "')  and to_date('" + dashBoardLabelSearch.getRegistrationToDate() + "','" + "dd/MM/yyyy" + "')");
            }
         }

         sql.insert(0, fromClause);
         Query query = this.getSession().createQuery(sql.toString());
         list = query.list();
         return list != null && list.size() > 0 ? Long.parseLong(list.get(0).toString()) : 0L;
      } catch (NullPointerException var16) {
         log.error(var16.getStackTrace());
         throw new NullPointerException();
      } catch (HibernateException var17) {
         log.error(var17.getStackTrace());
         throw new HibernateException(var17.getMessage());
      } catch (Exception var18) {
         log.error(var18.getStackTrace());
         var18.printStackTrace();
         throw new RuntimeException(var18.getCause());
      }
   }

   public double getPieChartOrBarChartDatas(String userZone, String serviceId, String currentYear) {
      if (log.isDebugEnabled()) {
         log.debug("getPieChartOrBarChartData Method is called");
      }

      try {
         String sqlString;
         if (userZone != null && !userZone.isEmpty()) {
            sqlString = "select sum(applicationCost) from RTIApplication r where workFlowStatus in(2,1) and r.rtiApplnNumber is not null and r.rtiApplnNumber!='' and r.zone='" + userZone + "' and r.rtiserviceid in(" + serviceId + ")  AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         } else {
            sqlString = "select sum(applicationCost) from RTIApplication r where workFlowStatus in(2,1) and r.rtiApplnNumber is not null and r.rtiApplnNumber!='' and r.rtiserviceid in(" + serviceId + ")  AND EXTRACT(YEAR FROM TO_TIMESTAMP(r.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         }

         System.out.println("sqlString" + sqlString);
         Query query = this.getSession().createQuery(sqlString);
         List list = query.list();
         if (list != null && list.size() > 0) {
            System.out.println("sqlString" + list.get(0).toString());
         }

         return Double.valueOf(list.get(0).toString());
      } catch (Exception var7) {
         log.error(var7.getStackTrace(), var7);
         var7.printStackTrace();
         return 0.0D;
      }
   }

   public long getPieChartOrBarChartDataForPoliceNoc(String userZone, String serviceId, String currentYear) {
      if (log.isDebugEnabled()) {
         log.debug("getPieChartOrBarChartData Method is called");
      }

      try {
         new ArrayList();
         StringBuffer sql = new StringBuffer();
         String fromClause;
         if (userZone != null && !userZone.isEmpty()) {
            fromClause = "SELECT COUNT(ra) FROM RTIApplication ra where ra.policeNoc IS NOT NULL AND ra.rtiApplnNumber IS NOT NULL AND ra.rtiApplnNumber != '' AND ra.zone='" + userZone + "' and ra.rtiserviceid in(" + serviceId + ")  AND EXTRACT(YEAR FROM TO_TIMESTAMP(ra.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         } else {
            fromClause = "SELECT COUNT(ra) FROM RTIApplication ra where ra.policeNoc IS NOT NULL AND ra.rtiApplnNumber IS NOT NULL AND ra.rtiApplnNumber != '' and ra.rtiserviceid in(" + serviceId + ")  AND EXTRACT(YEAR FROM TO_TIMESTAMP(ra.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         }

         sql.insert(0, fromClause);
         Query query = this.getSession().createQuery(sql.toString());
         List<Long> list = query.list();
         return list != null && list.size() > 0 ? Long.parseLong(((Long)list.get(0)).toString()) : 0L;
      } catch (NullPointerException var8) {
         log.error(var8.getStackTrace());
         throw new NullPointerException();
      } catch (HibernateException var9) {
         log.error(var9.getStackTrace());
         throw new HibernateException(var9.getMessage());
      } catch (Exception var10) {
         log.error(var10.getStackTrace());
         var10.printStackTrace();
         throw new RuntimeException(var10.getCause());
      }
   }

   public long getPieChartOrBarChartDataForTrafficNoc(String userZone, String serviceId, String currentYear) {
      if (log.isDebugEnabled()) {
         log.debug("getPieChartOrBarChartData Method is called");
      }

      try {
         new ArrayList();
         StringBuffer sql = new StringBuffer();
         String fromClause;
         if (userZone != null && !userZone.isEmpty()) {
            fromClause = "SELECT COUNT(ra) FROM RTIApplication ra where ra.trafficNoc IS NOT NULL AND ra.rtiApplnNumber IS NOT NULL AND ra.rtiApplnNumber != '' AND ra.zone='" + userZone + "' and ra.rtiserviceid in(" + serviceId + ")  AND EXTRACT(YEAR FROM TO_TIMESTAMP(ra.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         } else {
            fromClause = "SELECT COUNT(ra) FROM RTIApplication ra where ra.trafficNoc IS NOT NULL AND ra.rtiApplnNumber IS NOT NULL AND ra.rtiApplnNumber != '' and ra.rtiserviceid in(" + serviceId + ") AND EXTRACT(YEAR FROM TO_TIMESTAMP(ra.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         }

         sql.insert(0, fromClause);
         Query query = this.getSession().createQuery(sql.toString());
         List<Long> list = query.list();
         return list != null && list.size() > 0 ? Long.parseLong(((Long)list.get(0)).toString()) : 0L;
      } catch (NullPointerException var8) {
         log.error(var8.getStackTrace());
         throw new NullPointerException();
      } catch (HibernateException var9) {
         log.error(var9.getStackTrace());
         throw new HibernateException(var9.getMessage());
      } catch (Exception var10) {
         log.error(var10.getStackTrace());
         var10.printStackTrace();
         throw new RuntimeException(var10.getCause());
      }
   }

   public long getPieChartOrBarChartDataForFireNoc(String userZone, String serviceId, String currentYear) {
      if (log.isDebugEnabled()) {
         log.debug("getPieChartOrBarChartData Method is called");
      }

      try {
         new ArrayList();
         StringBuffer sql = new StringBuffer();
         String fromClause;
         if (userZone != null && !userZone.isEmpty()) {
            fromClause = "SELECT COUNT(ra) FROM RTIApplication ra where ra.fireNoc IS NOT NULL AND ra.rtiApplnNumber IS NOT NULL AND ra.rtiApplnNumber != '' AND ra.zone='" + userZone + "' and ra.rtiserviceid in(" + serviceId + ")  AND EXTRACT(YEAR FROM TO_TIMESTAMP(ra.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         } else {
            fromClause = "SELECT COUNT(ra) FROM RTIApplication ra where ra.fireNoc IS NOT NULL AND ra.rtiApplnNumber IS NOT NULL AND ra.rtiApplnNumber != '' and ra.rtiserviceid in(" + serviceId + ")  AND EXTRACT(YEAR FROM TO_TIMESTAMP(ra.createdDate, 'DD/MM/YYYY HH24:MI:SS')) ='" + currentYear + "'";
         }

         sql.insert(0, fromClause);
         Query query = this.getSession().createQuery(sql.toString());
         List<Long> list = query.list();
         return list != null && list.size() > 0 ? Long.parseLong(((Long)list.get(0)).toString()) : 0L;
      } catch (NullPointerException var8) {
         log.error(var8.getStackTrace());
         throw new NullPointerException();
      } catch (HibernateException var9) {
         log.error(var9.getStackTrace());
         throw new HibernateException(var9.getMessage());
      } catch (Exception var10) {
         log.error(var10.getStackTrace());
         var10.printStackTrace();
         throw new RuntimeException(var10.getCause());
      }
   }

   public List<Object> getServiceId(String sql) {
      try {
         Query query = this.getSession().createSQLQuery(sql.toString());
         log.info(sql.toString());
         List<Object> resultList = query.list();
         return resultList;
      } catch (Exception var4) {
         var4.printStackTrace();
         return null;
      }
   }

   private void adjustSerialNumbers(List<RTIApplication> resultList, int startSerialNumber) {
      for(int i = 0; i < resultList.size(); ++i) {
         ((RTIApplication)resultList.get(i)).setRowNumber((long)(startSerialNumber + i));
      }

   }
}

