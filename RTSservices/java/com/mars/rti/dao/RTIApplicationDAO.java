package com.mars.rti.dao;

import com.mars.common.model.User;
import com.mars.rti.controller.RTIApplicationDTO;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.RTIApplicationNoting;
import com.mars.rti.model.RTIApplicationPark;
import com.mars.rti.model.RTIApplicationReAssignAcceptance;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.workflow.model.WorkflowTemplateUserMappingDetails;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.hibernate.type.NullableType;

public interface RTIApplicationDAO {
   RTIApplication get(long var1);

   void save(RTIApplication var1);

   void save(RTIApplication var1, String var2, String var3);

   RTIApplication merge(RTIApplication var1);

   void delete(long var1);

   List<RTIApplication> getAll();

   void saveAll(List<RTIApplication> var1);

   void deleteAll(List<RTIApplication> var1);

   List<RTIApplication> getRTIApplicationList(RTIApplicationSearch var1);

   List<RTIApplication> getRTIApplicationListProfile(RTIApplicationSearch var1);

   long getRTIApplicationCount(RTIApplicationSearch var1);

   List<RTIApplication> findByProperty(String var1, Object var2);

   RTIApplication findByRTIApplicationNumber(String var1);

   RTIApplication findByRTIApplicationNumberId(long var1);

   RTIApplication checkForDuplicates(RTIApplication var1);

   List<RTIApplication> getListByNamedQuery(String var1, Hashtable<String, Object> var2);

   List<RTIApplication> getListByHqlQuery(String var1);

   List<ArrayList> getListBySQLQuery(String var1, Hashtable<String, NullableType> var2);

   List<RTIApplication> getEntityListBySQLQuery(String var1, Hashtable<String, NullableType> var2);

   List<RTIApplicationDetails> getApplicationHistoryDetails(String var1, Object var2);

   RTIApplicationDetails getRTIApplicationDetailsById(long var1);

   RTIApplicationDetails getRTIApplicationDetailsByRTIApplicationIdandStatus(long var1, int var3);

   RTIApplicationDetails getRTIApplicationDetailsByRTIApplicationIdandWFLevel(long var1, int var3);

   RTIApplicationNoting getRTIApplicationNoting(long var1);

   RTIApplicationPark getRTIApplicationParkByRTIApplicationIdandStatus(long var1, int var3);

   List<RTIApplicationReAssignAcceptance> getRTIApplicationReAssignedTask(long var1, int var3);

   RTIApplicationReAssignAcceptance getRTIApplicationReAssignedTaskByRTIApplicationIdAndStatus(long var1, int var3);

   List<RTIApplicationReAssignAcceptance> getRTIApplicationReAssignedTaskHistory(User var1);

   RTIApplicationDetails getDetails(long var1);

   List<RTIApplication> getMyApplicationDetails(String var1);

   long getRTIApplicationCountByCount(RTIApplicationSearch var1);

   void savePaymentList(List<RTIApplication> var1);

   List<RTIApplication> getPendingTaskList(String var1, long var2, String var4, long var5, List<WorkflowTemplateUserMappingDetails> var7);

   long getPendingTaskListCount(String var1, long var2, String var4, long var5, List<WorkflowTemplateUserMappingDetails> var7);

   List<RTIApplication> getRTSApplicationList(String var1, long var2, String var4, long var5, long var7, List<WorkflowTemplateUserMappingDetails> var9);

   long getRTSApplicationListCount(String var1, long var2, String var4, long var5, long var7, List<WorkflowTemplateUserMappingDetails> var9);

   RTIApplication findByServiceIdApplicationSearch(String var1);

   List<RTIApplication> getListByServiceId(int var1);

   List<RTIApplicationDTO> getList(long var1);

   RTIApplication findZOneTransferApplicationNumber(String var1);

   RTIApplication getApplicationDataForBirthCertificate(String var1);
   public RTIApplication findByRTIApplicationNumberUserMobileNo(String var1,String var2) ;

}

