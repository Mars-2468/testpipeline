package com.mars.workflow.controller;

import com.mars.common.model.User;
import com.mars.common.service.DepartmentService;
import com.mars.common.service.DocumentMasterService;
import com.mars.common.service.SectionService;
import com.mars.common.service.TenancyService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.dms.service.DmsDocumentCheckListService;
import com.mars.dms.service.DmsDocumentService;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.RTIApplicationService;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.PersoalTaskCompartor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class ReassignWorkflowController extends MultiActionController implements InitializingBean {
   private static String const_OrderBy = "OrderBy";
   private static String const_SortBy = "SortBy";
   private String DMS_ENTITY_NAME = "FTS_FILE_CREATION_NEW";
   private String DMS_ENTITY_FOLDER_PATH = "/NEW_CREATION";
   @Autowired
   private WorkflowService workflowService;
   @Autowired
   private WorkflowProcessDetailsService workflowProcessDetailsService;
   @Autowired
   private TaskService taskService;
   @Autowired
   private UserService userService;
   @Autowired
   private DepartmentService departmentService;
   @Autowired
   private RTIApplicationService rtiApplicationService;
   @Autowired
   private TenancyService tenancyService;
   @Autowired
   private SectionService sectionService;
   @Autowired
   private DmsDocumentService dmsDocumentService;
   @Autowired
   private DocumentMasterService documentMasterService;
   @Autowired
   private DmsDocumentCheckListService dmsDocumentCheckListService;
   private static Log log = LogFactory.getLog(ReassignWorkflowController.class);

   public void setWorkflowService(WorkflowService workflowService) {
      this.workflowService = workflowService;
   }

   public void setWorkflowProcessDetailsService(WorkflowProcessDetailsService workflowProcessDetailsService) {
      this.workflowProcessDetailsService = workflowProcessDetailsService;
   }

   public void setTaskService(TaskService taskService) {
      this.taskService = taskService;
   }

   public void setUserService(UserService userService) {
      this.userService = userService;
   }

   public void afterPropertiesSet() throws Exception {
   }

   @RequestMapping({"/reassignworkflow/manageReAssignRTIApplicationTask.do"})
   public ModelAndView manageReAssignRTIApplicationTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
      if (log.isDebugEnabled()) {
         log.debug("Invoking manageReAssignRTIApplicationTask");
      }

      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      RTIApplication fileCreation = null;
      RTIApplicationDetails fileCreationDetails = null;
      String fileCreationId = request.getParameter("manageRTIApplicationId");
      if (StringUtils.isNotEmpty(fileCreationId) && !fileCreationId.equals("0")) {
         fileCreation = this.rtiApplicationService.get(Long.parseLong(fileCreationId));
         fileCreationDetails = this.rtiApplicationService.getRTIApplicationDetailsByRTIApplicationIdandStatus(Long.parseLong(fileCreationId), 0);
         if (fileCreation == null && fileCreationDetails == null) {
            return this.getAllUserTask(request, response);
         } else {
            request.setAttribute("workflowRequired", "true");
            request.setAttribute("WORKFLOW_NAME", "rtiApplication");
            request.setAttribute("WORKFLOW_ENTITYNAME", "rtiApplication");
            request.setAttribute("WORKFLOW_ENTITYID", fileCreationId);
            WorkflowProcessDetails workflowProcessDetails = null;
            WorkflowProcessDetails processDetails = null;
            workflowProcessDetails = this.workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(fileCreation.getRtiApplicationId(), "rtiApplication");
            if (workflowProcessDetails != null) {
               String processId = workflowProcessDetails.getProcessId();
               if (processId != null) {
                  processDetails = this.workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId);
               }

               if (!this.workflowService.isProcessEnded(processId)) {
                  String taskId = this.workflowService.getCurrentTaskId(processId);
                  Task task = null;
                  if (taskId != null) {
                     task = this.taskService.getTask(taskId);
                  }

                  if (processDetails != null) {
                     PersonalTask personalTask = new PersonalTask();
                     personalTask.setTask(task);
                     personalTask.setEntityId(processDetails.getEntityId());
                     personalTask.setEntityName(processDetails.getEntityName());
                     personalTask.setWorkflowInitator(processDetails.getUserName());
                     personalTask.setEntityDetails(processDetails.getEntityDetails());
                     request.setAttribute("personalTask", personalTask);
                  }

                  if (task != null && sessionUser.getUserName().equals(task.getAssignee())) {
                     request.setAttribute("userAccess", 1);
                  }

                  request.setAttribute("workFlowTask", task);
               } else {
                  request.setAttribute("workFlowCompleted", "1");
               }
            }

            request.setAttribute("departmentList", this.departmentService.getAll());
            request.setAttribute("tenancyList", this.tenancyService.getAll());
            request.setAttribute("rtiApplicationDetails", fileCreationDetails);
            request.setAttribute("actionOnFile", request.getParameter("actionTaken"));
            session.setAttribute("manageUploadToken", session.getAttribute("_synchronizerToken"));
            CommonTokenUtils.setNewToken(request);
            this.setDMSParameters(request, fileCreation);
            return new ModelAndView("manageReAssignRTIApplicationTask", "rtiApplication", fileCreation);
         }
      } else {
         return this.getAllUserTask(request, response);
      }
   }

   @RequestMapping({"reassignworkflow/getAllUserTask.do"})
   public ModelAndView getAllUserTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      long tenancyId = sessionUser.getTenancyId();
      RTIApplicationSearch searchOptions = new RTIApplicationSearch();
      searchOptions.setTenancyId(tenancyId);
      this.setSearchParameters(searchOptions, request);
      List<RTIApplication> fileCreationList = this.rtiApplicationService.getRTIApplicationList(searchOptions);

      try {
         long totalCount = this.rtiApplicationService.getRTIApplicationCount(searchOptions);
         request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
         request.setAttribute("totalCount", totalCount);
      } catch (Exception e) {
         log.error(e.getMessage());
      }

      request.setAttribute("currentPage", searchOptions.getCurrentPage());
      request.setAttribute(const_OrderBy, searchOptions.getOrderBy());
      request.setAttribute(const_SortBy, searchOptions.getSortBy());
      request.setAttribute("SearchOptions", searchOptions);
      request.setAttribute("departmentList", this.departmentService.getAll());
      request.setAttribute("tenancyId", tenancyId);
      if (fileCreationList != null) {
         List<PersonalTask> listPersonalTask = new ArrayList();

         for(RTIApplication fileCreation : fileCreationList) {
            RTIApplicationDetails fileCreationDetails = this.rtiApplicationService.getRTIApplicationDetailsByRTIApplicationIdandStatus(fileCreation.getRtiApplicationId(), 0);
            WorkflowProcessDetails processDetails = this.workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(fileCreation.getRtiApplicationId(), "rtiApplication");
            if (processDetails != null) {
               String processId = processDetails.getProcessId();
               if (processDetails != null) {
                  String taskId = this.workflowService.getCurrentTaskId(processId);
                  Task task = null;
                  if (taskId != null) {
                     task = this.taskService.getTask(taskId);
                  }

                  if (task != null) {
                     PersonalTask personalTask = new PersonalTask();
                     personalTask.setTask(task);
                     personalTask.setEntityId(processDetails.getEntityId());
                     personalTask.setEntityName(processDetails.getEntityName());
                     personalTask.setWorkflowInitator(processDetails.getUserName());
                     personalTask.setEntityDetails(processDetails.getEntityDetails());
                     personalTask.setRtiApplicationDetails(fileCreationDetails);
                     personalTask.setRtiApplication(this.rtiApplicationService.get(processDetails.getEntityId()));
                     listPersonalTask.add(personalTask);
                  }
               }
            }
         }

         request.setAttribute("PersonalTasksList", listPersonalTask);
      }

      User user = this.userService.get(sessionUser.getUserId());
      request.setAttribute("user", user);
      request.setAttribute("displaymode", "inbox");
      request.setAttribute("pageHeading", "Re-Assign Task");
      return new ModelAndView("listReAssignRTIApplicationask");
   }

   private void setDMSParameters(HttpServletRequest request, Object entity) {
      HttpSession session = request.getSession();
      this.clearSessionAttributes(session);
      RTIApplication rtiApplication = (RTIApplication)entity;
      long entityId = rtiApplication.getRtiApplicationId();
      String entityName = this.DMS_ENTITY_NAME;
      String folderPath = this.DMS_ENTITY_FOLDER_PATH;
      folderPath = folderPath.replace("[ENTITY_ID]", "" + entityId);
      request.setAttribute("DMS_WORKSPACE_NAME", "RTI");
      request.setAttribute("DMS_FOLDER_PATH", folderPath);
      request.setAttribute("DMS_ENTITY_NAME", entityName);
      request.setAttribute("DMS_ENTITY_ID", entityId);
      request.setAttribute("dmsDocumentsList", this.dmsDocumentService.getDocumentsByEntity(entityName, entityId));
      session.setAttribute("workspace", "RTI");
      session.setAttribute("selectedFolderPath", folderPath);
      session.setAttribute("entityName", entityName);
      session.setAttribute("entityId", entityId);
      session.setAttribute("selectedDocumentType", entityName + "_DOC");
   }

   public void clearSessionAttributes(HttpSession session) {
      session.setAttribute("workspace", (Object)null);
      session.setAttribute("selectedFolderPath", (Object)null);
      session.setAttribute("entityName", (Object)null);
      session.setAttribute("entityId", "");
      session.setAttribute("uploadType", (Object)null);
      session.setAttribute("selectedDocumentType", (Object)null);
      session.setAttribute("dmsDocumentCheckListId", "");
      session.setAttribute("documentMasterId", "");
   }

   private void setSearchParameters(RTIApplicationSearch searchFileCreate, HttpServletRequest request) {
      if (log.isDebugEnabled()) {
         log.debug("setSearchParameters Method is called");
      }

      try {
         long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
         String orderBy = request.getParameter(const_OrderBy);
         String sortBy = request.getParameter(const_SortBy);
         if (orderBy == null || orderBy.length() < 1) {
            orderBy = "rtiApplicationId";
            sortBy = "desc";
         }

         searchFileCreate.setCurrentPage(longCurrentPage);
         searchFileCreate.setOrderBy(orderBy);
         searchFileCreate.setSortBy(sortBy);
         searchFileCreate.setRtiApplicationNumber(request.getParameter("rtiApplicationNumber"));
         searchFileCreate.setSubject(request.getParameter("subject"));
         searchFileCreate.setCreationToDate(request.getParameter("creationToDate"));
         searchFileCreate.setCreationFromDate(request.getParameter("creationFromDate"));
         if (request.getParameter("assignedDepartment") != null && !request.getParameter("assignedDepartment").equals("")) {
            searchFileCreate.setAssignedDepartment(Long.parseLong(request.getParameter("assignedDepartment")));
         }

         if (request.getParameter("assignedSection") != null && !request.getParameter("assignedSection").equals("")) {
            searchFileCreate.setAssignedSection(Long.parseLong(request.getParameter("assignedSection")));
         }

         if (request.getParameter("assignedUser") != null && !request.getParameter("assignedUser").equals("")) {
            searchFileCreate.setAssignedUser(Long.parseLong(request.getParameter("assignedUser")));
         }

         searchFileCreate.setReceivedFileRefNo(request.getParameter("receivedFileRefNo"));
         String fileStatus = request.getParameter("finalStatus");
         searchFileCreate.setFinalStatus(fileStatus);
      } catch (Exception err) {
         log.error(err.getMessage());
      }

   }

   @RequestMapping({"reassignworkflow/listUserTasks.do"})
   public ModelAndView listUserTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
      if (log.isDebugEnabled()) {
         log.debug("Invoking listUserTasks Method");
      }

      HttpSession session = request.getSession();
      request.setAttribute("userList", this.userService.getAll());
      String frmUserName = request.getParameter("frmUserName");
      if (frmUserName != null) {
         List<Task> tasksList = this.workflowService.getPersonalTasks(frmUserName);
         Collections.sort(tasksList, new PersoalTaskCompartor("startDate"));
         if (tasksList != null && tasksList.size() > 0) {
            List<PersonalTask> personalTasksList = new ArrayList();

            for(Task task : tasksList) {
               String strExecutionId = task.getExecutionId();
               if (strExecutionId.indexOf(task.getName()) != -1) {
                  strExecutionId = strExecutionId.split("." + task.getName())[0];
               }

               try {
                  WorkflowProcessDetails processDetails = this.workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(strExecutionId);
                  if (processDetails != null) {
                     PersonalTask personalTask = new PersonalTask();
                     personalTask.setTask(task);
                     personalTask.setEntityId(processDetails.getEntityId());
                     personalTask.setEntityName(processDetails.getEntityName());
                     personalTask.setWorkflowInitator(processDetails.getUserName());
                     personalTask.setEntityDetails(processDetails.getEntityDetails());
                     personalTasksList.add(personalTask);
                  } else {
                     log.debug("Work flow process entry not found in table WORKFLOW_PROCESS_DETAILS for execution ID = " + strExecutionId + " and for Task ID = " + task.getId());
                  }
               } catch (Exception e1) {
                  log.debug("Work flow process entry not found in table WORKFLOW_PROCESS_DETAILS for execution ID = " + strExecutionId + " and for Task ID = " + task.getId());
                  log.error(e1.getMessage(), e1);
               }
            }

            request.setAttribute("personalTasksList", personalTasksList);
         }

         request.setAttribute("frmUserName", frmUserName);
      }

      CommonTokenUtils.setNewToken(request);
      return new ModelAndView("manageReassignWorkflow");
   }

   @RequestMapping({"reassignworkflow/reassignWorkflowTask.do"})
   public ModelAndView reassignWorkflowTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
      if (log.isDebugEnabled()) {
         log.debug("Invoking reassignWorkflowTask Method");
      }

      HttpSession session = request.getSession();
      if (CommonTokenUtils.allowFormSubmit(request) && request.getParameter("selectedTaskIds") != null) {
         String[] taskIds = org.springframework.util.StringUtils.tokenizeToStringArray(request.getParameter("selectedTaskIds"), ",");
         String toUserName = request.getParameter("toUserName");

         for(String taskId : taskIds) {
            this.workflowService.reassignTask(taskId, toUserName);
         }

         session.setAttribute("message", this.getMessageSourceAccessor().getMessage("reassignworkflow.save.success") + " " + toUserName);
      }

      request.setAttribute("toUserName", request.getParameter("toUserName"));
      return this.listUserTasks(request, response);
   }
}
