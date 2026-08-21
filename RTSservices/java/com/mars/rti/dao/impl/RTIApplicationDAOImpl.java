package com.mars.rti.dao.impl;

import com.mars.common.model.User;
import com.mars.common.utils.Constants;
import com.mars.rti.controller.RTIApplicationDTO;
import com.mars.rti.dao.RTIApplicationDAO;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.RTIApplicationNoting;
import com.mars.rti.model.RTIApplicationPark;
import com.mars.rti.model.RTIApplicationReAssignAcceptance;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.workflow.model.WorkflowTemplateUserMappingDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("rtiApplicationDAO")
public class RTIApplicationDAOImpl extends HibernateDaoSupport implements RTIApplicationDAO {
   private static final Log log = LogFactory.getLog(RTIApplicationDAOImpl.class);

   @Autowired
   public void init(SessionFactory factory) {
      this.setSessionFactory(factory);
   }

   public RTIApplication get(long id) {
      try {
         if (log.isDebugEnabled()) {
            log.debug("get Method is called " + id);
         }

         return (RTIApplication)this.getHibernateTemplate().get(RTIApplication.class, new Long(id));
      } catch (Exception var4) {
         log.error(var4.getStackTrace(), var4);
         var4.printStackTrace();
         return null;
      }
   }

   public void save(RTIApplication entity, String deleteRTIApplicationServiceDetails, String deleteRTIApplicationAddonDetails) {
      try {
         if (log.isDebugEnabled()) {
            log.debug("save Method is called ");
         }

         entity.getRtiApplicationId();
         this.getHibernateTemplate().saveOrUpdate(entity);
      } catch (NullPointerException var5) {
         log.error(var5.getStackTrace());
         throw new NullPointerException();
      } catch (HibernateException var6) {
         var6.printStackTrace();
         log.error(var6.getStackTrace());
         throw new HibernateException(var6.getMessage());
      } catch (Exception var7) {
         var7.printStackTrace();
         log.error(var7.getStackTrace());
         throw new RuntimeException(var7.getCause());
      }
   }

   public void save(RTIApplication entity) {
      try {
         if (log.isDebugEnabled()) {
            log.debug("save Method is called ");
         }

         this.getHibernateTemplate().saveOrUpdate(entity);
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

   public RTIApplication merge(RTIApplication entity) {
      try {
         if (log.isDebugEnabled()) {
            log.debug("merge Method is called ");
         }

         return (RTIApplication)this.getHibernateTemplate().merge(entity);
      } catch (Exception var3) {
         log.error(var3.getStackTrace(), var3);
         var3.printStackTrace();
         return null;
      }
   }

   public void delete(long id) {
      try {
         if (log.isDebugEnabled()) {
            log.debug("deleting RTIApplication instance");
         }

         RTIApplication entity = (RTIApplication)this.getHibernateTemplate().load(RTIApplication.class, new Long(id));
         this.getHibernateTemplate().delete(entity);
         log.debug("delete successful");
      } catch (Exception var4) {
         log.error(var4.getStackTrace(), var4);
         var4.printStackTrace();
      }

   }

   public List<RTIApplication> getAll() {
      try {
         if (log.isDebugEnabled()) {
            log.debug("get all Method is called for RTIApplication");
         }

         return this.getHibernateTemplate().loadAll(RTIApplication.class);
      } catch (Exception var2) {
         log.error(var2.getStackTrace(), var2);
         var2.printStackTrace();
         return null;
      }
   }

   public void deleteAll(List<RTIApplication> listRTIApplication) {
      try {
         if (log.isDebugEnabled()) {
            log.debug("deleteAll Method is called for RTIApplication");
         }

         this.getHibernateTemplate().deleteAll(listRTIApplication);
         log.debug("deleted successfuly a list of RTIApplication records from database");
      } catch (Exception var3) {
         log.error(var3.getStackTrace(), var3);
         var3.printStackTrace();
      }

   }

   public void saveAll(List<RTIApplication> listRTIApplication) {
      try {
         if (log.isDebugEnabled()) {
            log.debug("saveAll Method is called ");
         }

         this.getHibernateTemplate().saveOrUpdateAll(listRTIApplication);
      } catch (Exception var3) {
         log.error(var3.getStackTrace(), var3);
         var3.printStackTrace();
      }

   }

   public List<RTIApplication> getRTIApplicationList(RTIApplicationSearch searchOptions) {
      try {
         long pageNumber = searchOptions.getCurrentPage();
         String orderBy = searchOptions.getOrderBy();
         String sortBy = searchOptions.getSortBy();
         String sqlString = "select rtiApplication from RTIApplication rtiApplication";
         String fromClause = this.getSearchQuery(searchOptions);
         sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " where " + fromClause : sqlString;
         if (searchOptions.getZone() <= 0 && searchOptions.getRtiserviceid() <= 0 && searchOptions.getRtiApplicationNumber() == null) {
            fromClause = sqlString + " " + "where" + " rtiApplication.rtiApplnNumber IS NOT NULL and rtiApplication.rtiApplnNumber != ''" + " order by " + orderBy + " " + sortBy;
         } else {
            fromClause = sqlString + " " + "and" + " " + "rtiApplication.rtiApplnNumber IS NOT NULL and rtiApplication.rtiApplnNumber != ''" + " order by " + orderBy + " " + sortBy;
         }

         Query query = this.getSession().createQuery(fromClause);
         log.info(fromClause);
         if (pageNumber != (long)Constants.DEFAULT_PAGINATION_ALL_ROWS) {
            if (pageNumber > 1L) {
               query.setFirstResult((int)((pageNumber - 1L) * (long)Constants.DEFAULT_ROWS_PER_PAGE));
               query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
            } else {
               query.setFirstResult(0);
               query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
            }
         }

         List<RTIApplication> list = query.list();
         if (list != null && list.size() > 0) {
            return list;
         }
      } catch (Exception var10) {
         log.error(var10.getStackTrace(), var10);
         var10.printStackTrace();
      }

      return null;
   }

   public List<RTIApplication> getRTIApplicationListProfile(RTIApplicationSearch searchOptions) {
      try {
         long pageNumber = searchOptions.getCurrentPage();
         String orderBy = searchOptions.getOrderBy();
         String sortBy = searchOptions.getSortBy();
         String sqlString = "select rtiApplication from RTIApplication rtiApplication";
         String fromClause = this.getSearchQuery(searchOptions);
         sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " where " + fromClause : sqlString;
         fromClause = sqlString + " order by " + orderBy + " " + sortBy;
         Query query = this.getSession().createQuery(fromClause);
         log.info(fromClause);
         query.setFirstResult(0);
         query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
         List<RTIApplication> list = query.list();
         if (list != null && list.size() > 0) {
            return list;
         }
      } catch (Exception var10) {
         log.error(var10.getStackTrace(), var10);
         var10.printStackTrace();
      }

      return null;
   }

   private String getSearchQuery(RTIApplicationSearch searchOptions) {
      String condition = " and ";
      String fromClause = "";
      boolean conditionFound = false;
      long tenancyId = searchOptions.getTenancyId();
      if (searchOptions != null) {
         String searchrtiApplnNumber = searchOptions.getRtiApplicationNumber();
         String refNumber = searchOptions.getReceivedFileRefNo();
         String RegistrationFromDate = searchOptions.getCreationFromDate();
         String RegistrationToDate = searchOptions.getCreationToDate();
         long department = searchOptions.getAssignedDepartment();
         long section = searchOptions.getAssignedSection();
         long user = searchOptions.getAssignedUser();
         String finalStatus = searchOptions.getFinalStatus();
         int rtiServiceId = searchOptions.getRtiserviceid();
         String name = searchOptions.getName();
         String mobileNumber = searchOptions.getMobileNumber();
         String phoneNumber = searchOptions.getPhoneNumber();
         int zoneNo = searchOptions.getZone();
         String templatename = searchOptions.getTemplatename();
         if (StringUtils.isNotEmpty(searchrtiApplnNumber)) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + "rtiApplnNumber='" + searchrtiApplnNumber + "'";
            conditionFound = true;
         }

         if (zoneNo != 0) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + "zone='" + zoneNo + "'";
            conditionFound = true;
         }

         if (StringUtils.isNotEmpty(name)) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + "applicantName='" + name + "'";
            conditionFound = true;
         }

         if (StringUtils.isNotEmpty(templatename)) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + "templateName='" + templatename + "'";
            conditionFound = true;
         }

         if (StringUtils.isNotEmpty(mobileNumber)) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + "phoneNumber='" + phoneNumber + "'";
            conditionFound = true;
         }

         if (StringUtils.isNotEmpty(mobileNumber)) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + "mobileNumber='" + mobileNumber + "'";
            conditionFound = true;
         }

         if (rtiServiceId > 0) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + "rtiserviceid=" + rtiServiceId;
            conditionFound = true;
         }

         if (StringUtils.isNotEmpty(refNumber)) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + "receivedRefNo='" + refNumber + "'";
            conditionFound = true;
         }

         if (RegistrationFromDate != null && RegistrationFromDate.length() > 0 && RegistrationToDate != null && RegistrationToDate.length() > 0) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + " (to_timestamp(rtiApplication.registrationDate,'DD/MM/YYYY HH24:MI:SS') between to_timestamp('" + RegistrationFromDate + "','DD/MM/YYYY HH24:MI:SS') " + "and to_timestamp('" + RegistrationToDate + "','DD/MM/YYYY HH24:MI:SS'))";
            conditionFound = true;
         }

         if (searchOptions.getRtiAplicationReceivedDepartment() > 0L) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + " rtiApplication.applicationDepartment.departmentId=" + searchOptions.getRtiAplicationReceivedDepartment() + " ";
            conditionFound = true;
         }

         if (department > 0L) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + " rtiApplication.assignedDepartment.departmentId=" + department + " ";
            conditionFound = true;
         }

         if (section > 0L) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + " rtiApplication.assignedSection.sectionId=" + section + " ";
            conditionFound = true;
         }

         if (user > 0L) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + " rtiApplication.assigneeUserId.userId=" + user + " ";
            conditionFound = true;
         }

         if (tenancyId < 0L) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + "rtiApplication.tenancy.tenancyId=" + tenancyId + " ";
            conditionFound = true;
         }

         if (finalStatus != null && finalStatus.length() > 0 && finalStatus.equalsIgnoreCase("Closed_Not_Re_Assign")) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + "upper(rtiApplication.finalStatus) = upper('" + finalStatus + "') ";
            conditionFound = true;
         } else if (finalStatus != null && !finalStatus.equals("") && finalStatus.length() > 0 && !finalStatus.equalsIgnoreCase("all")) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + "upper(rtiApplication.finalStatus) = upper('" + finalStatus + "') ";
            conditionFound = true;
         }

         if (searchOptions.getIsRTIAppealApplication() != null) {
            if (conditionFound) {
               fromClause = fromClause + condition;
            }

            fromClause = fromClause + " rtiApplication.isRTIAppealApplication  =" + searchOptions.getIsRTIAppealApplication() + " ";
            conditionFound = true;
         }
      }

      return fromClause;
   }

   public long getRTIApplicationCount(RTIApplicationSearch searchOptions) {
      try {
         String sqlString = "select count(*) from RTIApplication rtiApplication";
         String fromClause = this.getSearchQuery(searchOptions);
         sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " where " + fromClause : sqlString;
         Query query = this.getSession().createQuery(sqlString);
         List list = query.list();
         if (list != null && list.size() > 0) {
            return Long.parseLong(list.get(0).toString());
         }
      } catch (Exception var6) {
         log.error(var6.getStackTrace(), var6);
         var6.printStackTrace();
      }

      return 0L;
   }

   public List<RTIApplication> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) {
      try {
         Query queryObject = this.getSession().getNamedQuery(namedQuery);
         if (hstKeyValues != null && hstKeyValues.size() > 0) {
            Enumeration enumeration = hstKeyValues.keys();

            while(enumeration.hasMoreElements()) {
               String strKey = (String)enumeration.nextElement();
               if (hstKeyValues.get(strKey) instanceof Collection) {
                  queryObject.setParameterList(strKey, (Collection)hstKeyValues.get(strKey));
               } else {
                  queryObject.setParameter(strKey, hstKeyValues.get(strKey));
               }
            }
         }

         return queryObject.list();
      } catch (Exception var6) {
         log.error(var6.getStackTrace(), var6);
         var6.printStackTrace();
         return null;
      }
   }

   public List<RTIApplication> getListByHqlQuery(String hqlQuery) {
      try {
         Query query = this.getSession().createQuery(hqlQuery);
         List list = query.list();
         if (list != null && list.size() > 0) {
            return list;
         }
      } catch (Exception var4) {
         log.error(var4.getStackTrace(), var4);
         var4.printStackTrace();
      }

      return null;
   }

   public List<RTIApplication> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes) {
      try {
         if (log.isDebugEnabled()) {
            log.debug("getEntitytListBySQLQuery Method is called ");
         }

         SQLQuery query = this.getSession().createSQLQuery(strSql);
         if (hstDataTypes != null && hstDataTypes.size() > 0) {
            Enumeration enumeration = hstDataTypes.keys();

            while(enumeration.hasMoreElements()) {
               String strKey = (String)enumeration.nextElement();
               query.addScalar(strKey, (NullableType)hstDataTypes.get(strKey));
            }
         }

         query.addEntity(RTIApplication.class);
         return query.list();
      } catch (Exception var6) {
         log.error(var6.getStackTrace(), var6);
         var6.printStackTrace();
         return null;
      }
   }

   public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes) {
      try {
         List<ArrayList> listContents = null;
         if (log.isDebugEnabled()) {
            log.debug("getListBySQLQuery Method is called ");
         }

         SQLQuery query = this.getSession().createSQLQuery(strSql);
         if (hstDataTypes != null && hstDataTypes.size() > 0) {
            Enumeration enumeration = hstDataTypes.keys();

            while(enumeration.hasMoreElements()) {
               String strKey = (String)enumeration.nextElement();
               query.addScalar(strKey, (NullableType)hstDataTypes.get(strKey));
            }
         }

         List listQueryData = query.list();
         if (listQueryData != null && listQueryData.size() > 0) {
            listContents = new ArrayList();
            String[] strColumnNames = query.getReturnAliases();
            ArrayList<Object> listColumns = new ArrayList();

            int i;
            for(i = 0; i < strColumnNames.length; ++i) {
               listColumns.add(strColumnNames[i]);
            }

            listContents.add(listColumns);

            for(i = 0; i < listQueryData.size(); ++i) {
               ArrayList<Object> listData = new ArrayList();
               Object[] objectArray = (Object[])listQueryData.get(i);

               for(int j = 0; j < objectArray.length; ++j) {
                  if (objectArray[j] instanceof Integer) {
                     listData.add(Integer.parseInt(objectArray[j].toString()));
                  } else if (objectArray[j] instanceof Long) {
                     listData.add(Long.parseLong(objectArray[j].toString()));
                  } else if (objectArray[j] instanceof Double) {
                     listData.add(Double.parseDouble(objectArray[j].toString()));
                  } else {
                     listData.add(objectArray[j].toString());
                  }
               }

               listContents.add(listData);
            }
         }

         return listContents;
      } catch (Exception var12) {
         log.error(var12.getStackTrace(), var12);
         var12.printStackTrace();
         return null;
      }
   }

   public RTIApplication findByRTIApplicationNumber(String rtiApplnNumber) {
      (new StringBuilder("select * from egovrti.rti_application ra where ra.rti_application_number=")).append(rtiApplnNumber).toString();
      RTIApplication rtiapp = null;
      String sqlquery = "select rTIApplication from RTIApplication rTIApplication where rTIApplication.rtiApplnNumber ='" + rtiApplnNumber + "'";
      List<RTIApplication> list = null;
      Query query = this.getSession().createQuery(sqlquery);
      list = query.list();
      if (list != null && list.size() > 0) {
         rtiapp = (RTIApplication)list.get(0);
      }

      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@" + rtiapp);
      return rtiapp;
   }

   public RTIApplication findByRTIApplicationNumberId(long refid) {
      (new StringBuilder("select * from egovrti.rti_application ra where ra.rti_application_id=")).append(refid).toString();
      RTIApplication rtiapp = null;
      String sqlquery = "select rTIApplication from RTIApplication rTIApplication where rTIApplication.rtiApplicationId ='" + refid + "'";
      List<RTIApplication> list = null;
      Query query = this.getSession().createQuery(sqlquery);
      list = query.list();
      if (list != null && list.size() > 0) {
         rtiapp = (RTIApplication)list.get(0);
      }

      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@" + rtiapp);
      return rtiapp;
   }

   public RTIApplication checkForDuplicates(RTIApplication rtiApplication) {
      if (log.isDebugEnabled()) {
         log.debug("checkForDuplicates Method is called");
      }

      try {
         String fromClause = "select rtiApplication from RTIApplication rtiApplication where ";
         if (rtiApplication.getRtiApplicationId() > 0L) {
            fromClause = fromClause + " rtiApplicationId <> " + rtiApplication.getRtiApplicationId() + " and ";
         }

         Query query = this.getSession().createQuery(fromClause);
         List list = query.list();
         if (list != null && list.size() > 0) {
            return (RTIApplication)list.get(0);
         }
      } catch (Exception var5) {
         log.error(var5.getStackTrace(), var5);
         var5.printStackTrace();
      }

      return null;
   }

   public List<RTIApplicationDetails> getApplicationHistoryDetails(String propertyName, Object value) {
      try {
         log.info("finding ApplicationHistoryDetails with property: " + propertyName + ", value: " + value);
         String queryString = "select rtiApplicationDetails from RTIApplicationDetails rtiApplicationDetails where rtiApplicationDetails." + propertyName + "= ?";
         queryString = queryString + " order by rtiApplicationDetails.rtiApplicationDetailsId desc";
         Query queryObject = this.getSession().createQuery(queryString);
         queryObject.setParameter(0, value);
         return queryObject.list();
      } catch (Exception var5) {
         log.error(var5.getStackTrace());
         var5.printStackTrace();
         return null;
      }
   }

   public RTIApplicationDetails getRTIApplicationDetailsById(long rtiApplicationDetailsId) {
      try {
         if (log.isDebugEnabled()) {
            log.debug("getRTIApplicationDetailsId  Method is called " + rtiApplicationDetailsId);
         }

         return (RTIApplicationDetails)this.getHibernateTemplate().get(RTIApplicationDetails.class, rtiApplicationDetailsId);
      } catch (Exception var4) {
         log.error(var4.getStackTrace());
         var4.printStackTrace();
         return null;
      }
   }

   public RTIApplicationDetails getRTIApplicationDetailsByRTIApplicationIdandStatus(long rtiApplicationId, int status) {
      try {
         log.info("finding \tRTIApplicationDetails based on getRTIApplicationDetailsByRTIApplicationIdandStatus ");
         String queryString = "select rtiApplicationDetails from RTIApplicationDetails rtiApplicationDetails  where rtiApplicationDetails.rtiApplication.rtiApplicationId= ? and rtiApplicationDetails.assignToStatus=?";
         Query queryObject = this.getSession().createQuery(queryString);
         queryObject.setParameter(0, rtiApplicationId);
         queryObject.setParameter(1, status);
         List<RTIApplicationDetails> RTIApplicationDetailsList = queryObject.list();
         return !RTIApplicationDetailsList.isEmpty() && RTIApplicationDetailsList.size() > 0 ? (RTIApplicationDetails)RTIApplicationDetailsList.get(0) : null;
      } catch (Exception var7) {
         log.error(var7.getStackTrace());
         var7.printStackTrace();
         return null;
      }
   }

   public RTIApplicationDetails getRTIApplicationDetailsByRTIApplicationIdandWFLevel(long rtiApplicationId, int wfLevel) {
      try {
         log.info("finding RTIApplicationDetails  ");
         String queryString = "select rtiApplicationDetails from RTIApplicationDetails rtiApplicationDetails  where rtiApplicationDetails.rtiApplication.rtiApplicationId= ? and rtiApplicationDetails.workflowLevel=?  Order BY rtiApplicationDetails.rtiApplicationDetailsId Desc";
         Query queryObject = this.getSession().createQuery(queryString);
         queryObject.setParameter(0, rtiApplicationId);
         queryObject.setParameter(1, wfLevel);
         List<RTIApplicationDetails> RTIApplicationDetailsList = queryObject.list();
         return !RTIApplicationDetailsList.isEmpty() ? (RTIApplicationDetails)RTIApplicationDetailsList.get(0) : null;
      } catch (Exception var7) {
         log.error(var7.getStackTrace());
         var7.printStackTrace();
         return null;
      }
   }

   public RTIApplicationNoting getRTIApplicationNoting(long rtiApplicationNotingId) {
      try {
         log.info("invoking getRTIApplicationNoting  ");
         String queryString = "select rtiApplicationNoting from RTIApplicationNoting rtiApplicationNoting  where  rtiApplicationNoting.rtiApplicationNotingId=?";
         Query queryObject = this.getSession().createQuery(queryString);
         queryObject.setParameter(0, rtiApplicationNotingId);
         List<RTIApplicationNoting> rtiApplicationNotingList = queryObject.list();
         return !rtiApplicationNotingList.isEmpty() ? (RTIApplicationNoting)rtiApplicationNotingList.get(0) : null;
      } catch (Exception var6) {
         log.error(var6.getStackTrace());
         var6.printStackTrace();
         return null;
      }
   }

   public RTIApplicationPark getRTIApplicationParkByRTIApplicationIdandStatus(long rtiApplicationId, int status) {
      try {
         log.info("finding RTIApplicationPark  ");
         String queryString = "select rtiApplicationPark from RTIApplicationPark rtiApplicationPark  where rtiApplicationPark.rtiApplication.rtiApplicationId= ? and rtiApplicationPark.status=?";
         Query queryObject = this.getSession().createQuery(queryString);
         queryObject.setParameter(0, rtiApplicationId);
         queryObject.setParameter(1, status);
         List<RTIApplicationPark> rtiApplicationParkList = queryObject.list();
         return !rtiApplicationParkList.isEmpty() && rtiApplicationParkList.size() == 1 ? (RTIApplicationPark)rtiApplicationParkList.get(0) : null;
      } catch (Exception var7) {
         log.error(var7.getStackTrace());
         var7.printStackTrace();
         return null;
      }
   }

   public List<RTIApplicationReAssignAcceptance> getRTIApplicationReAssignedTask(long assignedUser, int acceptStatus) {
      try {
         log.info("finding getRTIApplicationReAssignedTask  ");
         String queryString = "select rtiApplicationReAssignAcceptance from RTIApplicationReAssignAcceptance rtiApplicationReAssignAcceptance  where rtiApplicationReAssignAcceptance.assignedTo.userId=? and rtiApplicationReAssignAcceptance.acceptStatus=?";
         Query queryObject = this.getSession().createQuery(queryString);
         queryObject.setParameter(0, assignedUser);
         queryObject.setParameter(1, acceptStatus);
         return queryObject.list();
      } catch (Exception var6) {
         log.error(var6.getStackTrace());
         var6.printStackTrace();
         return null;
      }
   }

   public RTIApplicationReAssignAcceptance getRTIApplicationReAssignedTaskByRTIApplicationIdAndStatus(long rtiApplicationId, int acceptStatus) {
      try {
         log.info("finding getRTIApplicationReAssignedTask  ");
         String queryString = "select rtiApplicationReAssignAcceptance from RTIApplicationReAssignAcceptance rtiApplicationReAssignAcceptance  where rtiApplicationReAssignAcceptance.rtiApplication.rtiApplicationId=? and rtiApplicationReAssignAcceptance.acceptStatus=?";
         Query queryObject = this.getSession().createQuery(queryString);
         queryObject.setParameter(0, rtiApplicationId);
         queryObject.setParameter(1, acceptStatus);
         List<RTIApplicationReAssignAcceptance> rtiApplicationReAssignAcceptanceList = queryObject.list();
         return !rtiApplicationReAssignAcceptanceList.isEmpty() && rtiApplicationReAssignAcceptanceList.size() != 0 && rtiApplicationReAssignAcceptanceList.size() <= 1 ? (RTIApplicationReAssignAcceptance)rtiApplicationReAssignAcceptanceList.get(0) : null;
      } catch (Exception var7) {
         log.error(var7.getStackTrace());
         var7.printStackTrace();
         return null;
      }
   }

   public List<RTIApplicationReAssignAcceptance> getRTIApplicationReAssignedTaskHistory(User usr) {
      try {
         log.info("finding getRTIApplicationReAssignedTaskHistory  ");
         String queryString = "select rtiApplicationReAssignAcceptance from RTIApplicationReAssignAcceptance rtiApplicationReAssignAcceptance  where (rtiApplicationReAssignAcceptance.assignedTo.userId=? OR rtiApplicationReAssignAcceptance.assignedBy.userId=?  OR rtiApplicationReAssignAcceptance.rtiApplication.applicationDepartment.departmentId=?  )  and rtiApplicationReAssignAcceptance.acceptStatus!=?";
         Query queryObject = this.getSession().createQuery(queryString);
         queryObject.setParameter(0, usr.getUserId());
         queryObject.setParameter(1, usr.getUserId());
         queryObject.setParameter(2, usr.getDepartment().getDepartmentId());
         queryObject.setParameter(3, 0);
         return queryObject.list();
      } catch (Exception var4) {
         log.error(var4.getStackTrace());
         var4.printStackTrace();
         return null;
      }
   }

   public List<RTIApplication> getRTIApplicationForPay(RTIApplicationSearch searchOptions) {
      try {
         long pageNumber = searchOptions.getCurrentPage();
         String orderBy = searchOptions.getOrderBy();
         String sortBy = searchOptions.getSortBy();
         String sqlString = "select rtiApplication from RTIApplication rtiApplication";
         String fromClause = this.getSearchQuery(searchOptions);
         sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " where " + fromClause : sqlString;
         fromClause = sqlString + " and workflow_status=3 order by " + orderBy + " " + sortBy;
         Query query = this.getSession().createQuery(fromClause);
         if (pageNumber != (long)Constants.DEFAULT_PAGINATION_ALL_ROWS) {
            if (pageNumber > 1L) {
               query.setFirstResult((int)((pageNumber - 1L) * (long)Constants.DEFAULT_ROWS_PER_PAGE));
               query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
            } else {
               query.setFirstResult(0);
               query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
            }
         }

         List<RTIApplication> list = query.list();
         if (list != null && list.size() > 0) {
            return list;
         }
      } catch (Exception var10) {
         log.error(var10.getStackTrace(), var10);
         var10.printStackTrace();
      }

      return null;
   }

   public RTIApplication getRtiByApplicationNum(RTIApplicationSearch searchOptions) {
      try {
         long pageNumber = searchOptions.getCurrentPage();
         String orderBy = searchOptions.getOrderBy();
         String sortBy = searchOptions.getSortBy();
         String sqlString = "select rtiApplication from RTIApplication rtiApplication";
         String fromClause = this.getSearchQuery(searchOptions);
         sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " where " + fromClause : sqlString;
         fromClause = sqlString + " order by " + orderBy + " " + sortBy;
         Query query = this.getSession().createQuery(fromClause);
         List list = query.list();
         if (list != null && list.size() > 0) {
            return (RTIApplication)list.get(0);
         }
      } catch (Exception var10) {
         log.error(var10.getStackTrace(), var10);
         var10.printStackTrace();
      }

      return null;
   }

   public List<RTIApplication> findByProperty(String propertyName, Object value) {
      try {
         log.debug("finding rtiApplication instance with property: " + propertyName + ", value: " + value);
         String queryString = "select rtiApplication from RTIApplication rtiApplication where rtiApplication." + propertyName + "= ?";
         Query queryObject = this.getSession().createQuery(queryString);
         queryObject.setParameter(0, value);
         return queryObject.list();
      } catch (Exception var5) {
         log.error(var5.getStackTrace(), var5);
         var5.printStackTrace();
         return null;
      }
   }

   public RTIApplicationDetails getDetails(long rtiApplicationId) {
      try {
         String sqlQuery = "select rTIApplicationDetails from RTIApplicationDetails rTIApplicationDetails where rti_application_id = " + rtiApplicationId;
         Query query = this.getSession().createQuery(sqlQuery);
         List list = query.list();
         if (list != null && list.size() > 0) {
            return (RTIApplicationDetails)list.get(0);
         }
      } catch (Exception var6) {
         log.error(var6.getStackTrace());
         var6.printStackTrace();
      }

      return null;
   }

   public List<RTIApplication> getMyApplicationDetails(String userMobileNo) {
      try {
         String queryString = "select rtiapplication from RTIApplication rtiapplication where rtiapplication.userRegistrationDetails.mobileNo=" + userMobileNo;
         Query query = this.getSession().createQuery(queryString);
         List<RTIApplication> list = query.list();
         if (list != null && list.size() > 0) {
            return list;
         }
      } catch (Exception var5) {
         log.error(var5.getStackTrace());
         var5.printStackTrace();
      }

      return null;
   }

   public long getRTIApplicationCountByCount(RTIApplicationSearch applicationSearch) {
      try {
         String sqlString = "select count(*) from RTIApplication rtiApplication";
         String fromClause = this.getSearchQuery(applicationSearch);
         sqlString = StringUtils.isNotEmpty(fromClause) ? sqlString + " where " + fromClause : sqlString;
         if (applicationSearch.getZone() <= 0 && applicationSearch.getRtiserviceid() <= 0) {
            fromClause = sqlString + " " + "where" + " rtiApplication.rtiApplnNumber IS NOT NULL and rtiApplication.rtiApplnNumber != ''";
         } else {
            fromClause = sqlString + " " + "and" + " " + "rtiApplication.rtiApplnNumber IS NOT NULL and rtiApplication.rtiApplnNumber != ''";
         }

         Query query = this.getSession().createQuery(fromClause);
         List list = query.list();
         if (list != null && list.size() > 0) {
            return Long.parseLong(list.get(0).toString());
         }
      } catch (Exception var6) {
         log.error(var6.getStackTrace(), var6);
         var6.printStackTrace();
      }

      return 0L;
   }

   public void savePaymentList(List<RTIApplication> listrts) {
      try {
         if (log.isDebugEnabled()) {
            log.debug("SavePaymentList save Method is called");
         }

         this.getHibernateTemplate().saveOrUpdateAll(listrts);
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

   public List<RTIApplication> getPendingTaskList(String username, long userDept, String zoneNo, long pageNumber, List<WorkflowTemplateUserMappingDetails> workflowTemplateUserMapping) {
      String sqlQuery = null;

      try {
         if (username != null && username.length() > 0 && (userDept == 6L || userDept == 10L || userDept == 4L || userDept == 2L)) {
            String updateZoneNo = zoneNo != null && !zoneNo.isEmpty() ? " and ra.zone = " + zoneNo : "";
            sqlQuery = "SELECT DISTINCT ra.* FROM egovrti.rti_application ra JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id     AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id WHERE wtumd.user_name = '" + username + "' " + updateZoneNo + "  AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " + "  AND (" + "    (wtt.assignee_place_holder = 'SendDemand' AND ra.workflow_status  IN (0, 9, 10, 1, 2, 3, 5 ,11)) " + "    OR " + "    (wtt.assignee_place_holder = 'CloseApplication' AND ra.workflow_status  IN (0, 9, 10, 1, 2, 3, 5 ,11)) " + ") " + "ORDER BY ra.rti_application_id DESC";
         } else if (zoneNo != null && username != null && zoneNo.length() > 0 && username.length() > 0) {
            sqlQuery = "SELECT DISTINCT ra.* FROM egovrti.rti_application ra JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id     AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id WHERE wtumd.user_name = '" + username + "' " + "  AND ra.zone = '" + zoneNo + "' " + "  AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " + "  AND (" + "    (wtt.assignee_place_holder = 'SendDemand' AND ra.workflow_status IN (0, 3, 5)) " + "    OR " + "    (wtt.assignee_place_holder = 'CloseApplication' AND ra.workflow_status IN (1, 2, 5)) " + ") " + "ORDER BY ra.rti_application_id DESC";
         } else if (workflowTemplateUserMapping != null && workflowTemplateUserMapping.size() > 0) {
            sqlQuery = "SELECT DISTINCT ra.* FROM egovrti.rti_application ra JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id     AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id WHERE wtumd.user_name = '" + username + "' " + "  AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " + "  AND (" + "    (wtt.assignee_place_holder = 'SendDemand' AND ra.workflow_status IN (0, 3, 5)) " + "    OR " + "    (wtt.assignee_place_holder = 'CloseApplication' AND ra.workflow_status IN (1, 2, 5)) " + ") " + "ORDER BY ra.rti_application_id DESC";
         } else {
            sqlQuery = "SELECT DISTINCT ra.* FROM egovrti.rti_application ra WHERE ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' AND ra.workflow_status IN (0, 3, 5,2,1)ORDER BY ra.rti_application_id DESC";
         }

         SQLQuery query = this.getSession().createSQLQuery(sqlQuery);
         List listQueryData = query.list();
         if (listQueryData != null && listQueryData.size() > 0) {
            List<RTIApplication> listcbs = null;
            query.addEntity(RTIApplication.class);
            if (pageNumber != (long)Constants.DEFAULT_PAGINATION_ALL_ROWS) {
               if (pageNumber > 1L) {
                  query.setFirstResult((int)((pageNumber - 1L) * (long)Constants.DEFAULT_ROWS_PER_PAGE));
                  query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
               } else {
                  query.setFirstResult(0);
                  query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
               }
            }

            listcbs = query.list();
            return listcbs;
         }
      } catch (Exception var12) {
         log.error(var12.getStackTrace(), var12);
         var12.printStackTrace();
      }

      return null;
   }

   public long getPendingTaskListCount(String username, long userDept, String zoneNo, long pageNumber, List<WorkflowTemplateUserMappingDetails> workflowTemplateUserMapping) {
      try {
         String sqlQuery = null;
         if (username == null || username.length() <= 0 || userDept != 6L && userDept != 10L && userDept != 4L && userDept != 2L) {
            if (zoneNo != null && username != null && zoneNo.length() > 0 && username.length() > 0) {
               sqlQuery = "SELECT COUNT(DISTINCT ra.*) FROM egovrti.rti_application ra JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id     AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id WHERE wtumd.user_name = '" + username + "' " + "  AND ra.zone = '" + zoneNo + "' " + "  AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " + "  AND (" + "    (wtt.assignee_place_holder = 'SendDemand' AND ra.workflow_status IN (0, 3, 5)) " + "    OR " + "    (wtt.assignee_place_holder = 'CloseApplication' AND ra.workflow_status IN (1, 2, 5)) " + "  ) " + "GROUP BY ra.rti_application_id " + "ORDER BY ra.rti_application_id DESC";
            } else if (workflowTemplateUserMapping != null && workflowTemplateUserMapping.size() > 0) {
               sqlQuery = "SELECT COUNT(DISTINCT ra.*) FROM egovrti.rti_application ra JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id     AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id WHERE wtumd.user_name = '" + username + "' " + "  AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " + "  AND (" + "    (wtt.assignee_place_holder = 'SendDemand' AND ra.workflow_status IN (0, 3, 5)) " + "    OR " + "    (wtt.assignee_place_holder = 'CloseApplication' AND ra.workflow_status IN (1, 2, 5)) " + "  ) " + "GROUP BY ra.rti_application_id " + "ORDER BY ra.rti_application_id DESC";
            } else {
               sqlQuery = "SELECT ra.rti_application_id, COUNT(*) AS row_count FROM egovrti.rti_application ra WHERE ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' AND ra.workflow_status IN (0, 3, 5,2,1)GROUP BY ra.rti_application_id ORDER BY ra.rti_application_id DESC";
            }
         } else {
            String updateZoneNo = zoneNo != null && !zoneNo.isEmpty() ? " and ra.zone = " + zoneNo : "";
            sqlQuery = "SELECT COUNT(DISTINCT ra.*) FROM egovrti.rti_application ra JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id     AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id WHERE wtumd.user_name = '" + username + "' " + updateZoneNo + "  AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " + "  AND (" + "    (wtt.assignee_place_holder = 'SendDemand' AND ra.workflow_status IN (0, 9, 10, 1, 2, 3, 5 ,11)) " + "    OR " + "    (wtt.assignee_place_holder = 'CloseApplication' AND ra.workflow_status IN (0, 9, 10, 1, 2, 3, 5 ,11)) " + "  ) " + "GROUP BY ra.rti_application_id " + "ORDER BY ra.rti_application_id DESC";
         }

         SQLQuery query = this.getSession().createSQLQuery(sqlQuery);
         List<RTIApplication> list = query.list();
         if (list != null && list.size() > 0) {
            return (long)list.size();
         }
      } catch (Exception var11) {
         log.error(var11.getStackTrace(), var11);
         var11.printStackTrace();
      }

      return 0L;
   }

   public List<RTIApplication> getRTSApplicationList(String username, long userDept, String zoneNo, long pageNumber, long serviceId, List<WorkflowTemplateUserMappingDetails> workflowTemplateUserMapping) {
      try {
         String sqlQuery = null;
         if (username != null && username.length() > 0 && (userDept == 6L || userDept == 10L || userDept == 4L || userDept == 12L)) {
            String updateZoneNo = zoneNo != null && !zoneNo.isEmpty() ? " and ra.zone = " + zoneNo : "";
            sqlQuery = "SELECT DISTINCT ra.* FROM egovrti.rti_application ra JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id     AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id WHERE wtumd.user_name = '" + username + "' " + updateZoneNo + "  AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " + "  AND ra.rti_service_id = " + serviceId + " " + "  AND (" + "    (wtt.assignee_place_holder = 'SendDemand' AND ra.workflow_status IN (0, 9, 10, 1, 2, 3, 5 ,11)) " + "    OR " + "    (wtt.assignee_place_holder = 'CloseApplication' AND ra.workflow_status IN (0, 9, 10, 1, 2, 3, 5 ,11)) " + ") " + "ORDER BY ra.rti_application_id DESC";
         } else if (zoneNo != null && username != null && zoneNo.length() > 0 && username.length() > 0) {
            sqlQuery = "SELECT DISTINCT ra.* FROM egovrti.rti_application ra JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id     AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id WHERE wtumd.user_name = '" + username + "' " + "  AND ra.zone = '" + zoneNo + "' " + "  AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " + "  AND ra.rti_service_id = " + serviceId + " " + "  AND (" + "    (wtt.assignee_place_holder = 'SendDemand' AND ra.workflow_status IN (0, 3, 5)) " + "    OR " + "    (wtt.assignee_place_holder = 'CloseApplication' AND ra.workflow_status IN (1, 2, 5)) " + ") " + "ORDER BY ra.rti_application_id DESC";
         } else if (workflowTemplateUserMapping != null && workflowTemplateUserMapping.size() > 0) {
            sqlQuery = "SELECT DISTINCT ra.* FROM egovrti.rti_application ra JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id     AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id WHERE wtumd.user_name = '" + username + "' " + "  AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " + "  AND ra.rti_service_id = " + serviceId + " " + "  AND (" + "    (wtt.assignee_place_holder = 'SendDemand' AND ra.workflow_status IN (0, 3, 5)) " + "    OR " + "    (wtt.assignee_place_holder = 'CloseApplication' AND ra.workflow_status IN (1, 2, 5)) " + ") " + "ORDER BY ra.rti_application_id DESC";
         } else {
            sqlQuery = "SELECT DISTINCT ra.* FROM egovrti.rti_application ra WHERE ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' AND ra.workflow_status IN (0, 3, 5,2,1)  AND ra.rti_service_id = " + serviceId + " " + "ORDER BY ra.rti_application_id DESC";
         }

         SQLQuery query = this.getSession().createSQLQuery(sqlQuery);
         List listQueryData = query.list();
         if (listQueryData != null && listQueryData.size() > 0) {
            List<RTIApplication> listcbs = null;
            query.addEntity(RTIApplication.class);
            if (pageNumber != (long)Constants.DEFAULT_PAGINATION_ALL_ROWS) {
               if (pageNumber > 1L) {
                  query.setFirstResult((int)((pageNumber - 1L) * (long)Constants.DEFAULT_ROWS_PER_PAGE));
                  query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
               } else {
                  query.setFirstResult(0);
                  query.setMaxResults(Constants.DEFAULT_ROWS_PER_PAGE);
               }
            }

            listcbs = query.list();
            return listcbs;
         }
      } catch (Exception var14) {
         log.error(var14.getStackTrace(), var14);
         var14.printStackTrace();
      }

      return null;
   }

   public long getRTSApplicationListCount(String username, long userDept, String zoneNo, long pageNumber, long serviceId, List<WorkflowTemplateUserMappingDetails> workflowTemplateUserMapping) {
      try {
         String sqlQuery = null;
         if (username != null && username.length() > 0 && (userDept == 6L || userDept == 10L || userDept == 4L || userDept == 12L)) {
            String updateZoneNo = zoneNo != null && !zoneNo.isEmpty() ? " and ra.zone = " + zoneNo : "";
            sqlQuery = "SELECT COUNT(DISTINCT ra.*) FROM egovrti.rti_application ra JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id     AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id WHERE wtumd.user_name = '" + username + "' " + updateZoneNo + "  AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " + "  AND ra.rti_service_id = " + serviceId + " " + "  AND (" + "    (wtt.assignee_place_holder = 'SendDemand' AND ra.workflow_status IN (0, 9, 10, 1, 2, 3, 5 ,11)) " + "    OR " + "    (wtt.assignee_place_holder = 'CloseApplication' AND ra.workflow_status IN (0, 9, 10, 1, 2, 3, 5 ,11)) " + "  ) " + "GROUP BY ra.rti_application_id " + "ORDER BY ra.rti_application_id DESC";
         } else if (zoneNo != null && username != null && zoneNo.length() > 0 && username.length() > 0) {
            sqlQuery = "SELECT COUNT(DISTINCT ra.*) FROM egovrti.rti_application ra JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id     AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id WHERE wtumd.user_name = '" + username + "' " + "  AND ra.zone = '" + zoneNo + "' " + "  AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " + "  AND ra.rti_service_id = " + serviceId + " " + "  AND (" + "    (wtt.assignee_place_holder = 'SendDemand' AND ra.workflow_status IN (0, 3, 5)) " + "    OR " + "    (wtt.assignee_place_holder = 'CloseApplication' AND ra.workflow_status IN (1, 2, 5)) " + "  ) " + "GROUP BY ra.rti_application_id " + "ORDER BY ra.rti_application_id DESC";
         } else if (workflowTemplateUserMapping != null && workflowTemplateUserMapping.size() > 0) {
            sqlQuery = "SELECT COUNT(DISTINCT ra.*) FROM egovrti.rti_application ra JOIN egovrti.workflow_template wt ON ra.template_name = wt.workflow_template_name JOIN egovrti.workflow_template_task wtt ON wtt.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping wtum ON wtum.workflow_template_id = wt.workflow_template_id JOIN egovrti.workflow_tmplt_usr_mapping_dtls wtumd ON wtumd.workflow_tmplt_usr_mapping_id = wtum.workflow_tmplt_usr_mapping_id     AND wtumd.workflow_template_task_id = wtt.workflow_template_task_id WHERE wtumd.user_name = '" + username + "' " + "  AND ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' " + "  AND ra.rti_service_id = " + serviceId + " " + "  AND (" + "    (wtt.assignee_place_holder = 'SendDemand' AND ra.workflow_status IN (0, 3, 5)) " + "    OR " + "    (wtt.assignee_place_holder = 'CloseApplication' AND ra.workflow_status IN (1, 2, 5)) " + "  ) " + "GROUP BY ra.rti_application_id " + "ORDER BY ra.rti_application_id DESC";
         } else {
            sqlQuery = "SELECT COUNT(DISTINCT ra.*) FROM egovrti.rti_application ra WHERE ra.rti_application_number IS NOT NULL AND ra.rti_application_number != '' AND ra.workflow_status IN (0, 3, 5,2,1)  AND ra.rti_service_id = " + serviceId + " " + "GROUP BY ra.rti_application_id " + "ORDER BY ra.rti_application_id DESC";
         }

         SQLQuery query = this.getSession().createSQLQuery(sqlQuery);
         List<RTIApplication> list = query.list();
         if (list != null && list.size() > 0) {
            return (long)list.size();
         }
      } catch (Exception var13) {
         log.error(var13.getStackTrace(), var13);
         var13.printStackTrace();
      }

      return 0L;
   }

   public RTIApplication findByServiceIdApplicationSearch(String rtsappNo) {
      try {
         String queryString = "select rtiApplication from RTIApplication rtiApplication where rtiApplication.rtiApplnNumber ='" + rtsappNo + "'";
         Query queryObject = this.getSession().createQuery(queryString);
         List list = queryObject.list();
         if (list != null && list.size() > 0) {
            return (RTIApplication)list.get(0);
         }
      } catch (Exception var5) {
         log.error(var5.getStackTrace(), var5);
         var5.printStackTrace();
      }

      return null;
   }

   public List<RTIApplication> getListByServiceId(int serviceId) {
      try {
         String queryString = "select rtiApplication from RTIApplication rtiApplication where rtiApplication.workFlowStatus!=1 and rtiApplication.workFlowStatus!=5 and rtiApplication.rtiserviceid=" + serviceId;
         Query queryObject = this.getSession().createQuery(queryString);
         List list = queryObject.list();
         return list;
      } catch (Exception var5) {
         log.error(var5.getStackTrace(), var5);
         var5.printStackTrace();
         return null;
      }
   }

   public List<RTIApplicationDTO> getList(long id) {
      try {
         String sqlQuery = "SELECT r.*, cb.collection_id AS collectionId FROM nmcrti.rti_application r JOIN nmcrti.collection cb ON r.rti_application_id = cb.rti_application_id WHERE cb.rti_application_id = :id";
         SQLQuery query = this.getSession().createSQLQuery(sqlQuery);
         query.addEntity("r", RTIApplication.class);
         query.addScalar("collectionId", Hibernate.LONG);
         query.setParameter("id", id);
         List<Object[]> result = query.list();
         List<RTIApplicationDTO> resultList = new ArrayList();
         Iterator var8 = result.iterator();

         while(var8.hasNext()) {
            Object[] row = (Object[])var8.next();
            RTIApplication rtiApplication = (RTIApplication)row[0];
            Long collectionId = (Long)row[1];
            resultList.add(new RTIApplicationDTO(rtiApplication, collectionId));
         }

         return resultList;
      } catch (Exception var11) {
         log.error(var11.getStackTrace(), var11);
         var11.printStackTrace();
         return null;
      }
   }

   public RTIApplication findZOneTransferApplicationNumber(String rtiApplnNumber) {
      RTIApplication rtiapp = null;
      String sqlquery = "select rTIApplication from RTIApplication rTIApplication where  rTIApplication.workFlowStatus=0 and rTIApplication.rtiApplnNumber ='" + rtiApplnNumber + "'";
      List<RTIApplication> list = null;
      Query query = this.getSession().createQuery(sqlquery);
      list = query.list();
      if (list != null && list.size() > 0) {
         rtiapp = (RTIApplication)list.get(0);
      }

      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@" + rtiapp);
      return rtiapp;
   }

   public RTIApplication getApplicationDataForBirthCertificate(String applicationNumber) {
      (new StringBuilder("select * from egovrti.rti_application ra where ra.rti_application_number=")).append(applicationNumber).toString();
      RTIApplication rtiapp = null;
      String sqlquery = "select rTIApplication from RTIApplication rTIApplication where rTIApplication.rtiApplnNumber ='" + applicationNumber + "'";
      List<RTIApplication> list = null;
      Query query = this.getSession().createQuery(sqlquery);
      list = query.list();
      if (list != null && list.size() > 0) {
         rtiapp = (RTIApplication)list.get(0);
      }

      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@" + rtiapp);
      return rtiapp;
   }
   
   @Override
   public RTIApplication findByRTIApplicationNumberUserMobileNo(String rtiApplnNumber,
                                                                String userMobileNo) {

       String hql = "FROM RTIApplication r " +
                    "WHERE r.rtiApplnNumber = :appNo " +
                    "AND r.userRegistrationDetails.mobileNo = :mobileNo";

       Query query = getSession().createQuery(hql);
       query.setParameter("appNo", rtiApplnNumber);
       query.setParameter("mobileNo", userMobileNo);

       return (RTIApplication) query.uniqueResult();
   }
   
   

}

