package com.mars.rti.service.impl;

import com.mars.common.model.User;
import com.mars.common.service.RegNumGenarationService;
import com.mars.rti.controller.RTIApplicationDTO;
import com.mars.rti.dao.RTIApplicationDAO;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.RTIApplicationNoting;
import com.mars.rti.model.RTIApplicationPark;
import com.mars.rti.model.RTIApplicationReAssignAcceptance;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.RTIApplicationService;
import com.mars.workflow.model.WorkflowTemplateUserMappingDetails;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rtiApplicationService")
public class RTIApplicationServiceImpl implements RTIApplicationService {
   private static final Log log = LogFactory.getLog(RTIApplicationServiceImpl.class);
   private static String rti_application_screen = "RTI_APPLICATION_SCREEN";
   private static String property = "entityName";
   @Autowired
   private RegNumGenarationService regNumGenarationService;
   @Autowired
   private RTIApplicationDAO rtiApplicationDAO;

   public void setRegNumGenarationService(RegNumGenarationService regNumGenarationService) {
      this.regNumGenarationService = regNumGenarationService;
   }

   public void save(RTIApplication entity, String deleteRTIApplicationServiceDetails, String deleteRTIApplicationAddonDetails) {
      if (log.isDebugEnabled()) {
         log.debug("save Method is called ");
      }

      this.rtiApplicationDAO.save(entity, deleteRTIApplicationServiceDetails, deleteRTIApplicationAddonDetails);
   }

   public void save(RTIApplication entity) {
      if (log.isDebugEnabled()) {
         log.debug("save Method is called ");
      }

      this.setRegistrationNumber(entity);
      this.rtiApplicationDAO.save(entity);
   }

   private void setRegistrationNumber(RTIApplication entity) {
      if (entity.getRtiApplicationId() <= 0L) {
         String regEntityName = rti_application_screen + "_" + entity.getApplicationDepartment().getDepartmentId();
         String preFix = "RTI/[YEAR]/[DEPT_CODE]/";
         String postFix = "";
         Boolean resetFlag = true;
         int year = Integer.parseInt(entity.getRegistrationDate().substring(6, 10));
         String rtiApplnNumber = this.regNumGenarationService.getRegistrationNumber(property, regEntityName, preFix, postFix, year);
         if (rtiApplnNumber != null) {
            rtiApplnNumber = rtiApplnNumber.replace("[YEAR]", Integer.toString(year));
            rtiApplnNumber = rtiApplnNumber.replace("[DEPT_CODE]", entity.getApplicationDepartment().getName().substring(0, 3));
            entity.setRtiApplnNumber(rtiApplnNumber);
         }
      }

   }

   public RTIApplication merge(RTIApplication entity) {
      if (log.isDebugEnabled()) {
         log.debug("merge Method is called ");
      }

      return this.rtiApplicationDAO.merge(entity);
   }

   public void delete(long id) {
      if (log.isDebugEnabled()) {
         log.debug("delete Method is called ");
      }

      this.rtiApplicationDAO.delete(id);
   }

   public RTIApplication get(long id) {
      if (log.isDebugEnabled()) {
         log.debug("get Method is called");
      }

      return this.rtiApplicationDAO.get(id);
   }

   public List<RTIApplication> getAll() {
      if (log.isDebugEnabled()) {
         log.debug("getAll Method is called");
      }

      return this.rtiApplicationDAO.getAll();
   }

   public List<RTIApplication> getRTIApplicationList(RTIApplicationSearch searchOptions) {
      if (log.isDebugEnabled()) {
         log.debug("getRTIApplicationList Method is called");
      }

      return this.rtiApplicationDAO.getRTIApplicationList(searchOptions);
   }

   public List<RTIApplication> getRTIApplicationListProfile(RTIApplicationSearch searchOptions) {
      if (log.isDebugEnabled()) {
         log.debug("getRTIApplicationList Method is called");
      }

      return this.rtiApplicationDAO.getRTIApplicationListProfile(searchOptions);
   }

   public long getRTIApplicationCount(RTIApplicationSearch searchOptions) {
      if (log.isDebugEnabled()) {
         log.debug("getRTIApplicationCount Method is called");
      }

      return this.rtiApplicationDAO.getRTIApplicationCount(searchOptions);
   }

   public void saveAll(List<RTIApplication> listRTIApplication) {
      if (log.isDebugEnabled()) {
         log.debug("saveAll Method is called");
      }

      this.rtiApplicationDAO.saveAll(listRTIApplication);
   }

   public void deleteAll(List<RTIApplication> listRTIApplication) {
      if (log.isDebugEnabled()) {
         log.debug("deleteAll Method is called");
      }

      this.rtiApplicationDAO.deleteAll(listRTIApplication);
   }

   public RTIApplication findByRTIApplicationNumber(String applicationNumber) {
      return this.rtiApplicationDAO.findByRTIApplicationNumber(applicationNumber);
   }

   public RTIApplication findByRTIApplicationNumberId(long refid) {
      return this.rtiApplicationDAO.findByRTIApplicationNumberId(refid);
   }

   public List<RTIApplication> findByProperty(String propertyName, Object value) {
      if (log.isDebugEnabled()) {
         log.debug("findByProperty Method is called");
      }

      return this.rtiApplicationDAO.findByProperty(propertyName, value);
   }

   public RTIApplication checkForDuplicates(RTIApplication rtiApplication) {
      if (log.isDebugEnabled()) {
         log.debug("checkForDuplicates Method is called");
      }

      return this.rtiApplicationDAO.checkForDuplicates(rtiApplication);
   }

   public List<RTIApplication> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues) {
      if (log.isDebugEnabled()) {
         log.debug("getListByNamedQuery Method is called");
      }

      return this.rtiApplicationDAO.getListByNamedQuery(namedQuery, hstKeyValues);
   }

   public List<RTIApplication> getListByHqlQuery(String hqlQuery) {
      if (log.isDebugEnabled()) {
         log.debug("getListByHqlQuery Method is called");
      }

      return this.rtiApplicationDAO.getListByHqlQuery(hqlQuery);
   }

   public List<RTIApplication> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes) {
      if (log.isDebugEnabled()) {
         log.debug("getEntitytListBySQLQuery Method is called");
      }

      return this.rtiApplicationDAO.getEntityListBySQLQuery(strSql, hstDataTypes);
   }

   public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes) {
      if (log.isDebugEnabled()) {
         log.debug("getEntitytListBySQLQuery Method is called");
      }

      return this.rtiApplicationDAO.getListBySQLQuery(strSql, hstDataTypes);
   }

   public List<RTIApplicationDetails> getApplicationHistoryDetails(String propertyName, Object value) {
      if (log.isDebugEnabled()) {
         log.debug("getApplicationHistoryDetails Method is called");
      }

      return this.rtiApplicationDAO.getApplicationHistoryDetails(propertyName, value);
   }

   public RTIApplicationDetails getRTIApplicationDetailsById(long rtiApplicationDetailsId) {
      return this.rtiApplicationDAO.getRTIApplicationDetailsById(rtiApplicationDetailsId);
   }

   public RTIApplicationDetails getRTIApplicationDetailsByRTIApplicationIdandStatus(long rtiApplicationId, int status) {
      return this.rtiApplicationDAO.getRTIApplicationDetailsByRTIApplicationIdandStatus(rtiApplicationId, status);
   }

   public RTIApplicationDetails getRTIApplicationDetailsByRTIApplicationIdandWFLevel(long rtiApplicationId, int wfLevel) {
      return this.rtiApplicationDAO.getRTIApplicationDetailsByRTIApplicationIdandWFLevel(rtiApplicationId, wfLevel);
   }

   public RTIApplicationNoting getRTIApplicationNoting(long rtiApplicationNotingId) {
      return this.rtiApplicationDAO.getRTIApplicationNoting(rtiApplicationNotingId);
   }

   public RTIApplicationPark getRTIApplicationParkByRTIApplicationIdandStatus(long rtiApplicationId, int status) {
      return this.rtiApplicationDAO.getRTIApplicationParkByRTIApplicationIdandStatus(rtiApplicationId, status);
   }

   public List<RTIApplicationReAssignAcceptance> getRTIApplicationReAssignedTask(long assignedUser, int acceptStatus) {
      return this.rtiApplicationDAO.getRTIApplicationReAssignedTask(assignedUser, acceptStatus);
   }

   public RTIApplicationReAssignAcceptance getRTIApplicationReAssignedTaskByRTIApplicationIdAndStatus(long rtiApplicationId, int acceptStatus) {
      return this.rtiApplicationDAO.getRTIApplicationReAssignedTaskByRTIApplicationIdAndStatus(rtiApplicationId, acceptStatus);
   }

   public List<RTIApplicationReAssignAcceptance> getRTIApplicationReAssignedTaskHistory(User assignedUser) {
      return this.rtiApplicationDAO.getRTIApplicationReAssignedTaskHistory(assignedUser);
   }

   public RTIApplicationDetails getDetails(long rtiApplicationId) {
      return this.rtiApplicationDAO.getDetails(rtiApplicationId);
   }

   public List<RTIApplication> getMyApplicationDetails(String userMobileNo) {
      return this.rtiApplicationDAO.getMyApplicationDetails(userMobileNo);
   }

   public long getRTIApplicationCountByCount(RTIApplicationSearch applicationSearch) {
      return this.rtiApplicationDAO.getRTIApplicationCountByCount(applicationSearch);
   }

   public void savePaymentList(List<RTIApplication> listrts) {
      this.rtiApplicationDAO.savePaymentList(listrts);
   }

   public List<RTIApplication> getPendingTaskList(String username, long userDept, String zoneNo, long pageNumber, List<WorkflowTemplateUserMappingDetails> workflowTemplateUserMapping) {
      return this.rtiApplicationDAO.getPendingTaskList(username, userDept, zoneNo, pageNumber, workflowTemplateUserMapping);
   }

   public long getPendingTaskListCount(String username, long userDept, String zoneNo, long pageNumber, List<WorkflowTemplateUserMappingDetails> workflowTemplateUserMapping) {
      return this.rtiApplicationDAO.getPendingTaskListCount(username, userDept, zoneNo, pageNumber, workflowTemplateUserMapping);
   }

   public List<RTIApplication> getRTSApplicationList(String username, long userDept, String zoneNo, long pageNumber, long serviceId, List<WorkflowTemplateUserMappingDetails> workflowTemplateUserMapping) {
      return this.rtiApplicationDAO.getRTSApplicationList(username, userDept, zoneNo, pageNumber, serviceId, workflowTemplateUserMapping);
   }

   public long getRTSApplicationListCount(String username, long userDept, String zoneNo, long pageNumber, long serviceId, List<WorkflowTemplateUserMappingDetails> workflowTemplateUserMapping) {
      return this.rtiApplicationDAO.getRTSApplicationListCount(username, userDept, zoneNo, pageNumber, serviceId, workflowTemplateUserMapping);
   }

   public RTIApplication findByServiceIdApplicationSearch(String rtsappNo) {
      return this.rtiApplicationDAO.findByServiceIdApplicationSearch(rtsappNo);
   }

   public List<RTIApplication> getListByServiceId(int serviceId) {
      return this.rtiApplicationDAO.getListByServiceId(serviceId);
   }

   public List<RTIApplicationDTO> getList(long id) {
      return this.rtiApplicationDAO.getList(id);
   }

   public RTIApplication findZOneTransferApplicationNumber(String rtiApplnNumber) {
      return this.rtiApplicationDAO.findZOneTransferApplicationNumber(rtiApplnNumber);
   }

   public RTIApplication getApplicationDataForBirthCertificate(String applicationNumber) {
      return this.rtiApplicationDAO.getApplicationDataForBirthCertificate(applicationNumber);
   }
   
   public RTIApplication findByRTIApplicationNumberUserMobileNo(String var1,String var2) {
	      return this.rtiApplicationDAO.findByRTIApplicationNumberUserMobileNo(var1,var2);

   }

}

