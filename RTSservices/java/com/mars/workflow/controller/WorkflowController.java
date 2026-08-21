package com.mars.workflow.controller;

import com.mars.common.model.PendingTasksList;
import com.mars.common.model.Tenancy;
import com.mars.common.model.User;
import com.mars.common.search.UserSearch;
import com.mars.common.service.TenancyService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.RTIApplicationService;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.TaskHistoryDetails;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.model.WorkflowTemplateUserMappingDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.service.WorkflowTemplateService;
import com.mars.workflow.service.WorkflowTemplateTaskService;
import com.mars.workflow.service.WorkflowTemplateUserMappingDetailsService;
import com.mars.workflow.service.WorkflowTemplateUserMappingService;
import com.mars.workflow.utils.PersoalTaskCompartor;
import com.mars.workflow.utils.WorkflowConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class WorkflowController extends MultiActionController implements InitializingBean {
   private static String const_OrderBy = "OrderBy";
   private static String const_SortBy = "SortBy";
   @Autowired
   private WorkflowService workflowService;
   @Autowired
   private WorkflowTemplateService workflowTemplateService;
   @Autowired
   private WorkflowProcessDetailsService workflowProcessDetailsService;
   @Autowired
   private TaskService taskService;
   @Autowired
   private UserService userService;
   @Autowired
   private TenancyService tenancyService;
   @Autowired
   private RTIApplicationService rtiApplicationService;
   @Autowired
   private WorkflowTemplateTaskService workflowTemplateTaskService;
   @Autowired
   private WorkflowTemplateUserMappingService workflowTemplateUserMappingService;
   @Autowired
   private WorkflowTemplateUserMappingDetailsService workflowTemplateUserMappingDetailsService;
   private static Log log = LogFactory.getLog(WorkflowController.class);

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

   public void setTenancyService(TenancyService tenancyService) {
      this.tenancyService = tenancyService;
   }

   public void afterPropertiesSet() throws Exception {
   }

   @RequestMapping({"workflow/listTasks.do"})
   public ModelAndView listTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
      if (log.isDebugEnabled()) {
         log.debug("Invoking listTasks Method");
      }

      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      if (sessionUser == null) {
         return new ModelAndView("redirect:/login.do");
      } else {
         List<RTIApplication> rtiApplicationList = new ArrayList();
         List<PersonalTask> listPersonalTask = new ArrayList();
         RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
         long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
         RTIApplicationDetails rTIApplicationDetails = null;
         User user = null;
         user = this.userService.get(sessionUser.getUserId());
         List<WorkflowTemplateUserMappingDetails> workflowTemplateUserMappingDetails = null;
         if (user.getUserName() != null) {
            workflowTemplateUserMappingDetails = this.workflowTemplateUserMappingDetailsService.getByName(user.getUserName());
         }

         String userZone = null;
         String userName = null;
         long userDept = 0L;
         if (user != null) {
            userZone = user.getZone();
            userName = user.getUserName();
            userDept = sessionUser.getDepartmentId();
            rtiApplicationList = this.rtiApplicationService.getPendingTaskList(userName, userDept, userZone, longCurrentPage, workflowTemplateUserMappingDetails);
         }

         boolean found = false;
         if (rtiApplicationList != null) {
            for(RTIApplication rtiApplicationObj : rtiApplicationList) {
               PersonalTask personalTaskObj = new PersonalTask();
               rTIApplicationDetails = this.rtiApplicationService.getDetails(rtiApplicationObj.getRtiApplicationId());
               personalTaskObj.setRtiApplicationDetails(rTIApplicationDetails);
               personalTaskObj.setEntityName(this.getEntityName(rtiApplicationObj.getRtiserviceid()));
               if (rtiApplicationObj.getRtiApplicationRefId() != null) {
                  personalTaskObj.setEntityId(rtiApplicationObj.getRtiApplicationRefId());
                  personalTaskObj.setRtiApplication(rtiApplicationObj);
                  found = true;
               }

               if (found) {
                  listPersonalTask.add(personalTaskObj);
               }
            }

            if (listPersonalTask.size() > 0) {
               long totalCounts = this.rtiApplicationService.getPendingTaskListCount(userName, userDept, userZone, longCurrentPage, workflowTemplateUserMappingDetails);
               request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCounts)));
               request.setAttribute("totalCount", totalCounts);
            }
         } else {
            new PersonalTask();
         }

         request.setAttribute("currentPage", new Long(longCurrentPage));
         request.setAttribute("PersonalTasksList", listPersonalTask);
         request.setAttribute("user", user);
         request.setAttribute(const_OrderBy, applicationSearch.getOrderBy());
         request.setAttribute(const_SortBy, applicationSearch.getSortBy());
         request.setAttribute("displaymode", "inbox");
         request.setAttribute("pageHeading", "Personal Task List");
         return new ModelAndView("listTasks");
      }
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
         searchFileCreate.setRtiApplicationNumber(request.getParameter("searchrtiApplnNumber"));
         searchFileCreate.setRtiserviceid(Integer.parseInt(request.getParameter("serviceId")));
         searchFileCreate.setSubject(request.getParameter("subject"));
         searchFileCreate.setCreationToDate(request.getParameter("toDate"));
         searchFileCreate.setCreationFromDate(request.getParameter("fromDate"));
         if (request.getParameter("rtiAplicationReceivedDepartment") != null && !request.getParameter("rtiAplicationReceivedDepartment").equals("")) {
            searchFileCreate.setRtiAplicationReceivedDepartment(Long.parseLong(request.getParameter("rtiAplicationReceivedDepartment")));
         }

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
         if (request.getParameter("isRTIAppealApplication") != null && !request.getParameter("isRTIAppealApplication").equals("")) {
            searchFileCreate.setIsRTIAppealApplication(Integer.parseInt(request.getParameter("isRTIAppealApplication")));
         } else {
            searchFileCreate.setIsRTIAppealApplication((Integer)null);
         }
      } catch (Exception err) {
         log.error(err.getMessage());
      }

   }

   private String getEntityName(Integer rtiserviceid) {
      String entityname = "";
      if (rtiserviceid == 1) {
         entityname = "BirthRegistration";
      }

      if (rtiserviceid == 2) {
         entityname = "DeathRegistration";
      }

      if (rtiserviceid == 3) {
         entityname = "DogLicense";
      }

      if (rtiserviceid == 4) {
         entityname = "TreeTrimming";
      }

      if (rtiserviceid == 5) {
         entityname = "ZoneCertificate";
      }

      if (rtiserviceid == 6) {
         entityname = "MTPRegistrationCertificate";
      }

      if (rtiserviceid == 7) {
         entityname = "BiologicalWasteDisposal";
      }

      if (rtiserviceid == 8) {
         entityname = "NursingHomes";
      }

      if (rtiserviceid == 9) {
         entityname = "NoDuesCertificate";
      }

      if (rtiserviceid == 10) {
         entityname = "TreeCutting";
      }

      if (rtiserviceid == 11) {
         entityname = "MarriageRegistration";
      }

      if (rtiserviceid == 12) {
         entityname = "PropertyOwnerChange";
      }

      if (rtiserviceid == 13) {
         entityname = "WaterOwnerChange";
      }

      if (rtiserviceid == 14) {
         entityname = "RenewalDogLicense";
      }

      if (rtiserviceid == 15) {
         entityname = "RenewalNursingHome";
      }

      if (rtiserviceid == 16) {
         entityname = "NursingHomeChangesApplication";
      }

      if (rtiserviceid == 32) {
         entityname = "NOC Of Trade";
      }

      return entityname;
   }

   @RequestMapping({"workflow/listGroupTasks.do"})
   public ModelAndView listGroupTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
      if (log.isDebugEnabled()) {
         log.debug("Invoking listGrupTasks Method");
      }

      long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      List<Task> groupTasksList = this.workflowService.getGroupTasks(sessionUser.getUserName());
      long totalCount = this.workflowService.getGroupTasksCount(sessionUser.getUserName());
      if (totalCount > 0L) {
         request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
         request.setAttribute("totalCount", totalCount);
         int startIndex = 0;
         int endIndex = WorkflowConstants.WOFKFLOW_ROWS_PER_PAGE;
         if (longCurrentPage > 1L) {
            startIndex = (int)((longCurrentPage - 1L) * (long)WorkflowConstants.WOFKFLOW_ROWS_PER_PAGE);
            endIndex = (int)(longCurrentPage * (long)WorkflowConstants.WOFKFLOW_ROWS_PER_PAGE);
         }

         Collections.sort(groupTasksList, new PersoalTaskCompartor("startDate"));
         if ((long)endIndex > totalCount) {
            groupTasksList = groupTasksList.subList(startIndex, (int)totalCount);
         } else {
            groupTasksList = groupTasksList.subList(startIndex, endIndex);
         }
      }

      if (groupTasksList != null && groupTasksList.size() > 0) {
         List<PersonalTask> listGroupTask = new ArrayList();

         for(Task task : groupTasksList) {
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
                  listGroupTask.add(personalTask);
               } else {
                  log.debug("Work flow process entry not found in table WORKFLOW_PROCESS_DETAILS for execution ID = " + strExecutionId + " and for Task ID = " + task.getId());
               }
            } catch (Exception e1) {
               log.debug("Work flow process entry not found in table WORKFLOW_PROCESS_DETAILS for execution ID = " + strExecutionId + " and for Task ID = " + task.getId());
               log.error(e1.getMessage(), e1);
            }
         }

         request.setAttribute("GroupTasksList", listGroupTask);
      }

      request.setAttribute("currentPage", new Long(longCurrentPage));
      request.setAttribute("displaymode", "groupbox");
      request.setAttribute("defaultTabIndex", 2);
      request.setAttribute("pageHeading", "Group Task List");
      return new ModelAndView("listTasks");
   }

   @RequestMapping({"workflow/saveTaskOwnership.do"})
   public ModelAndView saveTaskOwnership(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
      if (log.isDebugEnabled()) {
         log.debug("Invoking saveTaskOwnership Method");
      }

      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      String taskId = request.getParameter("WORKFLOW_TASK_ID");
      this.workflowService.takeTask(taskId, sessionUser.getUserName());
      return this.listTasks(request, response);
   }

   @RequestMapping({"workflow/listCompletedTasks.do"})
   public ModelAndView listCompletedTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
      if (log.isDebugEnabled()) {
         log.debug("Invoking listTasks Method");
      }

      long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      List<TaskHistoryDetails> listCompletedTasks = this.workflowService.getCompletedTasks(sessionUser.getUserName());
      long totalCount = 0L;
      if (listCompletedTasks != null) {
         totalCount = (long)listCompletedTasks.size();
      }

      if (totalCount > 0L) {
         request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
         request.setAttribute("totalCount", totalCount);
         int startIndex = 0;
         int endIndex = WorkflowConstants.WOFKFLOW_ROWS_PER_PAGE;
         if (longCurrentPage > 1L) {
            startIndex = (int)((longCurrentPage - 1L) * (long)WorkflowConstants.WOFKFLOW_ROWS_PER_PAGE);
            endIndex = (int)(longCurrentPage * (long)WorkflowConstants.WOFKFLOW_ROWS_PER_PAGE);
         }

         if ((long)endIndex > totalCount) {
            listCompletedTasks = listCompletedTasks.subList(startIndex, (int)totalCount);
         } else {
            listCompletedTasks = listCompletedTasks.subList(startIndex, endIndex);
         }
      }

      request.setAttribute("CompletedTasksList", listCompletedTasks);
      request.setAttribute("currentPage", new Long(longCurrentPage));
      request.setAttribute("displaymode", "outbox");
      request.setAttribute("defaultTabIndex", 1);
      request.setAttribute("pageHeading", "Completed Task List");
      return new ModelAndView("listTasks");
   }

   @RequestMapping({"workflow/listAllPendingTaskTasks.do"})
   public ModelAndView listAllPendingTaskTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
      if (log.isDebugEnabled()) {
         log.debug("Invoking listAllPendingTasks Method");
      }

      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      Long tenancyId = sessionUser.getTenancyId();
      UserSearch searchOptions = new UserSearch();
      searchOptions.setTenancyId(tenancyId);
      List<User> userList = this.userService.getUserByType(searchOptions);
      long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
      Date personalPendingDate = null;
      long pendingHrs = 0L;
      long currentTotalCount = 0L;
      List<PersonalTask> listPersonalTask = new ArrayList();
      List<Task> tasksListAll = new ArrayList();

      for(User user : userList) {
         List<Task> tasksList = this.workflowService.getPersonalTasks(user.getUserName());
         if (tasksList != null && tasksList.size() > 0) {
            tasksListAll.addAll(tasksList);
         }
      }

      if (tasksListAll != null && tasksListAll.size() > 0) {
         for(Task task : tasksListAll) {
            personalPendingDate = task.getCreateTime();
            if (personalPendingDate != null) {
               pendingHrs = ((new Date()).getTime() - personalPendingDate.getTime()) / 3600000L;
            }

            if (pendingHrs >= 47L) {
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
                     listPersonalTask.add(personalTask);
                  } else {
                     log.debug("Work flow process entry not found in table WORKFLOW_PROCESS_DETAILS for execution ID = " + strExecutionId + " and for Task ID = " + task.getId());
                  }
               } catch (Exception e1) {
                  log.debug("Work flow process entry not found in table WORKFLOW_PROCESS_DETAILS for execution ID = " + strExecutionId + " and for Task ID = " + task.getId());
                  log.error(e1.getMessage(), e1);
               }
            }
         }
      }

      currentTotalCount = (long)listPersonalTask.size();
      request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(currentTotalCount)));
      request.setAttribute("totalCount", currentTotalCount);
      int startIndex = 0;
      int endIndex = WorkflowConstants.WOFKFLOW_ROWS_PER_PAGE;
      if (longCurrentPage > 1L) {
         startIndex = (int)((longCurrentPage - 1L) * (long)WorkflowConstants.WOFKFLOW_ROWS_PER_PAGE);
         endIndex = (int)(longCurrentPage * (long)WorkflowConstants.WOFKFLOW_ROWS_PER_PAGE);
      }

      Collections.sort(tasksListAll, new PersoalTaskCompartor("startDate"));
      List var25;
      if ((long)endIndex > currentTotalCount) {
         var25 = listPersonalTask.subList(startIndex, (int)currentTotalCount);
      } else {
         var25 = listPersonalTask.subList(startIndex, endIndex);
      }

      request.setAttribute("PersonalTasksList", var25);
      request.setAttribute("currentPage", new Long(longCurrentPage));
      request.setAttribute("displaymode", "inbox");
      request.setAttribute("pageHeading", "Pending Task List More Than 48 Hours");
      return new ModelAndView("listAllPendingTasks");
   }

   @RequestMapping({"/workflow/prinListAllPendingTaskTasks.do"})
   public void prinListAllPendingTaskTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      if (log.isDebugEnabled()) {
         log.debug("Invoking prinListAllPendingTaskTasks Report");
      }

      String strReportName = null;
      String strReportPath = "/reports/license/";
      String reportAs = "application/pdf";
      HashMap<String, Object> parameters = new HashMap();
      strReportName = "Pending_Tasks_List_By_Ulb";
      long tenancyId = sessionUser.getTenancyId();
      Tenancy tenancy = this.tenancyService.get(tenancyId);
      parameters.put("List_Personal_Task", this.getAllPersonalTask(request));
      parameters.put("name_rgl", tenancy.getName_rgl());
      parameters.put("category", tenancy.getCategory());
      request.setAttribute("strReportName", strReportName);
      request.setAttribute("strReportPath", strReportPath);
      request.setAttribute("reportParams", parameters);
      request.setAttribute("reportAs", reportAs);
      if (request.getHeader("referer") != null && (request.getHeader("referer") == null || request.getHeader("referer").indexOf(request.getServerName()) != -1)) {
         request.getRequestDispatcher("/report/generateReportFromScreenFromPOJO.do").forward(request, response);
      } else {
         response.sendRedirect("pages/common/exception.jsp");
      }
   }

   private ArrayList<PendingTasksList> getAllPersonalTask(HttpServletRequest request) {
      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      Long tenancyId = sessionUser.getTenancyId();
      UserSearch searchOptions = new UserSearch();
      searchOptions.setTenancyId(tenancyId);
      List<User> userList = this.userService.getUserByType(searchOptions);
      Date personalPendingDate = null;
      long pendingHrs = 0L;
      ArrayList<PendingTasksList> listPersonalTask = new ArrayList();
      List<Task> tasksListAll = new ArrayList();

      for(User user : userList) {
         List<Task> tasksList = this.workflowService.getPersonalTasks(user.getUserName());
         if (tasksList != null && tasksList.size() > 0) {
            tasksListAll.addAll(tasksList);
         }
      }

      if (tasksListAll != null && tasksListAll.size() > 0) {
         for(Task task : tasksListAll) {
            personalPendingDate = task.getCreateTime();
            if (personalPendingDate != null) {
               pendingHrs = ((new Date()).getTime() - personalPendingDate.getTime()) / 3600000L;
            }

            if (pendingHrs >= 47L) {
               String strExecutionId = task.getExecutionId();
               if (strExecutionId.indexOf(task.getName()) != -1) {
                  strExecutionId = strExecutionId.split("." + task.getName())[0];
               }

               try {
                  WorkflowProcessDetails processDetails = this.workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(strExecutionId);
                  if (processDetails != null) {
                     PendingTasksList pendingTasksList = new PendingTasksList();
                     pendingTasksList.setPenadingAt(task.getAssignee());
                     pendingTasksList.setEntityDetail(processDetails.getEntityDetails());
                     pendingTasksList.setEntityName(processDetails.getEntityName());
                     pendingTasksList.setTaskName(task.getName());
                     pendingTasksList.setPendingHours(pendingHrs);
                     listPersonalTask.add(pendingTasksList);
                  }
               } catch (Exception e1) {
                  log.debug("Work flow process entry not found in table WORKFLOW_PROCESS_DETAILS for execution ID = " + strExecutionId + " and for Task ID = " + task.getId());
                  log.error(e1.getMessage(), e1);
               }
            }
         }
      }

      return listPersonalTask;
   }
}
