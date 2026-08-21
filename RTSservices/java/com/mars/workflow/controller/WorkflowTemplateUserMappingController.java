package com.mars.workflow.controller;

import com.mars.common.model.Tenancy;
import com.mars.common.model.User;
import com.mars.common.search.UserSearch;
import com.mars.common.service.AreaService;
import com.mars.common.service.DesignationService;
import com.mars.common.service.TenancyService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonRequestUtils;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;
import com.mars.workflow.model.WorkflowTemplate;
import com.mars.workflow.model.WorkflowTemplateTask;
import com.mars.workflow.model.WorkflowTemplateUserMapping;
import com.mars.workflow.model.WorkflowTemplateUserMappingDetails;
import com.mars.workflow.model.WorkflowTemplateUserMappingSearch;
import com.mars.workflow.service.WorkflowTemplateService;
import com.mars.workflow.service.WorkflowTemplateTaskService;
import com.mars.workflow.service.WorkflowTemplateUserMappingDetailsService;
import com.mars.workflow.service.WorkflowTemplateUserMappingService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class WorkflowTemplateUserMappingController extends MultiActionController implements InitializingBean {
   private static String const_OrderBy = "OrderBy";
   private static String const_SortBy = "SortBy";
   private static Log log = LogFactory.getLog(WorkflowTemplateUserMappingController.class);
   @Autowired
   private WorkflowTemplateUserMappingService workflowTemplateUserMappingService;
   @Autowired
   private WorkflowTemplateService workflowTemplateService;
   @Autowired
   private AreaService areaService;
   @Autowired
   private UserService userService;
   @Autowired
   private DesignationService designationService;
   @Autowired
   private WorkflowTemplateTaskService workflowTemplateTaskService;
   @Autowired
   private WorkflowTemplateUserMappingDetailsService workflowTemplateUserMappingDetailsService;
   @Autowired
   private TenancyService tenancyService;

   public void setWorkflowTemplateUserMappingService(WorkflowTemplateUserMappingService workflowTemplateUserMappingService) {
      this.workflowTemplateUserMappingService = workflowTemplateUserMappingService;
   }

   public void setWorkflowTemplateService(WorkflowTemplateService workflowTemplateService) {
      this.workflowTemplateService = workflowTemplateService;
   }

   public WorkflowTemplateTaskService getWorkflowTemplateTaskService() {
      return this.workflowTemplateTaskService;
   }

   public void setWorkflowTemplateTaskService(WorkflowTemplateTaskService workflowTemplateTaskService) {
      this.workflowTemplateTaskService = workflowTemplateTaskService;
   }

   public WorkflowTemplateUserMappingService getWorkflowTemplateUserMappingService() {
      return this.workflowTemplateUserMappingService;
   }

   public WorkflowTemplateService getWorkflowTemplateService() {
      return this.workflowTemplateService;
   }

   public void setAreaService(AreaService areaService) {
      this.areaService = areaService;
   }

   public UserService getUserService() {
      return this.userService;
   }

   public void setUserService(UserService userService) {
      this.userService = userService;
   }

   public DesignationService getDesignationService() {
      return this.designationService;
   }

   public void setDesignationService(DesignationService designationService) {
      this.designationService = designationService;
   }

   public void setWorkflowTemplateUserMappingDetailsService(WorkflowTemplateUserMappingDetailsService workflowTemplateUserMappingDetailsService) {
      this.workflowTemplateUserMappingDetailsService = workflowTemplateUserMappingDetailsService;
   }

   public void setTenancyService(TenancyService tenancyService) {
      this.tenancyService = tenancyService;
   }

   public void afterPropertiesSet() throws Exception {
   }

   @InitBinder
   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
      SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
      df.setLenient(true);
      binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
   }

   @RequestMapping({"/workflowtemplateusermapping/saveWorkflowTemplateUserMapping.do"})
   public ModelAndView saveWorkflowTemplateUserMapping(HttpServletRequest request, HttpServletResponse response, WorkflowTemplateUserMapping workflowTemplateUserMapping) throws ServletException, Exception {
      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      User user = this.userService.get(sessionUser.getUserId());
      if (log.isDebugEnabled()) {
         log.debug("Invoking saveWorkflowTemplateUserMapping");
      }

      if (workflowTemplateUserMapping != null) {
         workflowTemplateUserMapping.setWorkflowTemplateUserMappingDetailsSet(this.getWorkflowTemplateUserMappingDetailsSet(request, workflowTemplateUserMapping));
         if (workflowTemplateUserMapping.getWorkflowTemplate() != null || request.getParameter("workflowTemplateId") != null && request.getParameter("workflowTemplateId").length() > 0) {
            long workflowTemplateId = Long.parseLong(request.getParameter("workflowTemplateId"));
            if (workflowTemplateUserMapping.getWorkflowTemplate() != null && workflowTemplateUserMapping.getWorkflowTemplate().getWorkflowTemplateId() > 0L) {
               workflowTemplateId = workflowTemplateUserMapping.getWorkflowTemplate().getWorkflowTemplateId();
            }

            workflowTemplateUserMapping.setWorkflowTemplate(this.workflowTemplateService.get(workflowTemplateId));
         }

         if (workflowTemplateUserMapping.getArea() != null || request.getParameter("areaId") != null && request.getParameter("areaId").length() > 0) {
            long areaId = Long.parseLong(request.getParameter("areaId"));
            if (workflowTemplateUserMapping.getArea() != null && workflowTemplateUserMapping.getArea().getAreaId() > 0L) {
               areaId = workflowTemplateUserMapping.getArea().getAreaId();
            }

            workflowTemplateUserMapping.setArea(this.areaService.get(areaId));
         }

         WorkflowTemplateUserMapping workflowTemplateUserMappingObj = null;
         workflowTemplateUserMappingObj = this.workflowTemplateUserMappingService.checkForDuplicates(workflowTemplateUserMapping);
         if (CommonTokenUtils.allowFormSubmit(request)) {
            if (workflowTemplateUserMappingObj != null) {
               session.setAttribute("message", "Workflow Template User Mapping for same Workflow Template and Area already exists.");
            } else {
               this.workflowTemplateUserMappingService.save(workflowTemplateUserMapping);
               session.setAttribute("message", "Workflow Template User Mapping details saved successfully");
            }
         }
      }

      request.setAttribute("workflowTemplateList", this.workflowTemplateService.getAll());
      request.setAttribute("areaList", this.areaService.getAll());
      request.setAttribute("designationtionList", this.designationService.getAll());
      UserSearch searchOptions = new UserSearch();
      searchOptions.setCurrentPage((long)Constants.DEFAULT_PAGINATION_ALL_ROWS);
      searchOptions.setOrderBy("upper(user.firstName)");
      searchOptions.setApplicationId(23L);
      searchOptions.setDepartmentId(sessionUser.getDepartmentId());
      request.setAttribute("userList", this.userService.getUserByType(searchOptions));
      ModelAndView modelandView = new ModelAndView("manageWorkflowTemplateUserMapping");
      modelandView.addObject("workflowTemplateUserMapping", workflowTemplateUserMapping);
      return modelandView;
   }

   private Set<WorkflowTemplateUserMappingDetails> getWorkflowTemplateUserMappingDetailsSet(HttpServletRequest request, WorkflowTemplateUserMapping workflowTemplateUserMapping) throws Exception {
      Set<WorkflowTemplateUserMappingDetails> workflowTemplateUserMappingDetailsSet = null;
      long[] workflowTemplateTaskId = CommonRequestUtils.getLongParameters(request, "workflowTemplateTaskId");
      long[] workflowTemplateUserMappingDetailsId = CommonRequestUtils.getLongParameters(request, "workflowTemplateUserMappingDetailsId");
      String[] userName = CommonRequestUtils.getStringParameters(request, "userName");
      int[] tenancyIds = CommonRequestUtils.getIntParameters(request, "tenancyId");
      if (workflowTemplateTaskId != null && workflowTemplateTaskId.length > 0) {
         workflowTemplateUserMappingDetailsSet = new LinkedHashSet();

         for(int i = 0; i < workflowTemplateTaskId.length; ++i) {
            WorkflowTemplateUserMappingDetails workflowTemplateUserMappingDetails = new WorkflowTemplateUserMappingDetails();
            workflowTemplateUserMappingDetails.setWorkflowTemplateUserMappingDetailsId(workflowTemplateUserMappingDetailsId[i]);
            workflowTemplateUserMappingDetails.setUserName(userName[i]);
            Tenancy a = new Tenancy();
            a.setTenancyId(1L);
            workflowTemplateUserMappingDetails.setTenancy(a);
            workflowTemplateUserMappingDetails.setWorkflowTemplateTask(this.workflowTemplateTaskService.get(workflowTemplateTaskId[i]));
            workflowTemplateUserMappingDetails.setWorkflowTemplateUserMapping(workflowTemplateUserMapping);
            workflowTemplateUserMappingDetailsSet.add(workflowTemplateUserMappingDetails);
         }
      }

      return workflowTemplateUserMappingDetailsSet;
   }

   @RequestMapping({"/workflowtemplateusermapping/editWorkflowTemplateUserMapping.do"})
   public ModelAndView editWorkflowTemplateUserMapping(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      if (log.isDebugEnabled()) {
         log.debug("Invoking editWorkflowTemplateUserMapping");
      }

      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      long tenancyId = sessionUser.getTenancyId();
      WorkflowTemplateUserMapping workflowTemplateUserMapping = null;
      String workflowTemplateUserMappingId = request.getParameter("workflowTemplateUserMappingId");
      if (StringUtils.isNotEmpty(workflowTemplateUserMappingId)) {
         workflowTemplateUserMapping = this.workflowTemplateUserMappingService.get(Long.parseLong(workflowTemplateUserMappingId));
         if (workflowTemplateUserMapping != null && workflowTemplateUserMapping.getWorkflowTemplateUserMappingDetailsSet().size() == 0 && workflowTemplateUserMapping.getWorkflowTemplate().getWorkflowTemplateTaskSet().size() == 0) {
            WorkflowTemplate workflowTemplate = workflowTemplateUserMapping.getWorkflowTemplate();
            String strHqlQuery = "Select workflowTemplateTask from WorkflowTemplateTask workflowTemplateTask where workflowTemplateTask.workflowTemplate.workflowTemplateId = " + workflowTemplateUserMapping.getWorkflowTemplate().getWorkflowTemplateId() + " and workflowTemplateTask.tenancy is NULL";
            List<WorkflowTemplateTask> workflowTemplateTaskList = this.workflowTemplateTaskService.getListByHqlQuery(strHqlQuery);
            Set<WorkflowTemplateTask> newWorkflowTemplateTaskList = new LinkedHashSet();

            for(WorkflowTemplateTask workflowTemplateTask : workflowTemplateTaskList) {
               WorkflowTemplateTask wfTempTask = new WorkflowTemplateTask();
               wfTempTask.setAssigneePlaceHolder(workflowTemplateTask.getAssigneePlaceHolder());
               wfTempTask.setDurationInDays(workflowTemplateTask.getDurationInDays());
               wfTempTask.setLevel(workflowTemplateTask.getLevel());
               wfTempTask.setWorkflowTemplate(workflowTemplate);
               wfTempTask.setTenancy(this.tenancyService.get((long)((int)tenancyId)));
               newWorkflowTemplateTaskList.add(wfTempTask);
            }

            workflowTemplate.setWorkflowTemplateTaskSet(newWorkflowTemplateTaskList);
         }
      } else {
         workflowTemplateUserMapping = new WorkflowTemplateUserMapping();
      }

      request.setAttribute("workflowTemplateList", this.workflowTemplateService.getAll());
      request.setAttribute("areaList", this.areaService.getAll());
      request.setAttribute("designationtionList", this.designationService.getAll());
      UserSearch searchOptions = new UserSearch();
      searchOptions.setTenancyId(tenancyId);
      searchOptions.setCurrentPage((long)Constants.DEFAULT_PAGINATION_ALL_ROWS);
      searchOptions.setOrderBy("user.firstName");
      searchOptions.setApplicationId(23L);
      request.setAttribute("userList", this.userService.getUserByType(searchOptions));
      searchOptions.setDepartmentId(sessionUser.getDepartmentId());
      CommonTokenUtils.setNewToken(request);
      return new ModelAndView("manageWorkflowTemplateUserMapping", "workflowTemplateUserMapping", workflowTemplateUserMapping);
   }

   @RequestMapping({"/workflowtemplateusermapping/listWorkflowTemplateUserMapping.do"})
   public ModelAndView listWorkflowTemplateUserMapping(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      if (log.isDebugEnabled()) {
         log.debug("Invoking listWorkflowTemplateUserMapping");
      }

      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      long tenancyId = sessionUser.getTenancyId();
      WorkflowTemplateUserMappingSearch searchWorkflowTemplateUserMapping = new WorkflowTemplateUserMappingSearch();
      searchWorkflowTemplateUserMapping.setTenancyid(tenancyId);
      this.setSearchParameters(searchWorkflowTemplateUserMapping, request);
      List<WorkflowTemplateUserMapping> WorkflowTemplateUserMappingList = this.workflowTemplateUserMappingService.getWorkflowTemplateUserMappingListBySearch(searchWorkflowTemplateUserMapping);
      long totalCount = this.workflowTemplateUserMappingService.getWorkflowTemplateUserMappingCountBySearch(searchWorkflowTemplateUserMapping);
      request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
      request.setAttribute("totalCount", totalCount);
      if (WorkflowTemplateUserMappingList == null) {
         WorkflowTemplateUserMappingList = new ArrayList();
      }

      request.setAttribute("workflowTemplateList", this.workflowTemplateService.getAll());
      request.setAttribute("areaList", this.areaService.getAll());
      request.setAttribute("currentPage", searchWorkflowTemplateUserMapping.getCurrentPage());
      request.setAttribute(const_OrderBy, searchWorkflowTemplateUserMapping.getOrderBy());
      request.setAttribute(const_SortBy, searchWorkflowTemplateUserMapping.getSortBy());
      request.setAttribute("searchWorkflowTemplateUserMapping", searchWorkflowTemplateUserMapping);
      return new ModelAndView("listWorkflowTemplateUserMapping", "WorkflowTemplateUserMappingList", WorkflowTemplateUserMappingList);
   }

   private void setSearchParameters(WorkflowTemplateUserMappingSearch searchWorkflowTemplateUserMapping, HttpServletRequest request) throws Exception {
      if (log.isDebugEnabled()) {
         log.debug("setSearchParameters Method is called");
      }

      long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
      String orderBy = request.getParameter(const_OrderBy);
      String sortBy = request.getParameter(const_SortBy);
      if (orderBy == null || orderBy.length() < 1) {
         orderBy = "workflowTemplateUserMappingId";
         sortBy = "desc";
      }

      searchWorkflowTemplateUserMapping.setCurrentPage(longCurrentPage);
      searchWorkflowTemplateUserMapping.setOrderBy(orderBy);
      searchWorkflowTemplateUserMapping.setSortBy(sortBy);
      if (request.getParameter("searchWorkflowTemplateId") != null && request.getParameter("searchWorkflowTemplateId").length() > 0) {
         searchWorkflowTemplateUserMapping.setWorkflowTemplateId(Long.parseLong(request.getParameter("searchWorkflowTemplateId")));
      }

      if (request.getParameter("searchAreaId") != null && request.getParameter("searchAreaId").length() > 0) {
         searchWorkflowTemplateUserMapping.setAreaId(Long.parseLong(request.getParameter("searchAreaId")));
      }

      if (request.getParameter("tenancyId") != null && request.getParameter("tenancyId").length() > 0) {
         searchWorkflowTemplateUserMapping.setTenancyid((long)Integer.parseInt(request.getParameter("tenancyId")));
      }

   }

   @RequestMapping({"/workflowtemplateusermapping/deleteWorkflowTemplateUserMapping.do"})
   public ModelAndView deleteWorkflowTemplateUserMapping(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      HttpSession session = request.getSession();
      if (log.isDebugEnabled()) {
         log.debug("Invoking deleteWorkflowTemplateUserMapping");
      }

      String workflowTemplateUserMappingId = request.getParameter("workflowTemplateUserMappingId");
      if (StringUtils.isNotEmpty(workflowTemplateUserMappingId)) {
         WorkflowTemplateUserMapping workflowTemplateUserMapping = this.workflowTemplateUserMappingService.get(Long.parseLong(workflowTemplateUserMappingId));
         if (workflowTemplateUserMapping != null) {
            try {
               this.workflowTemplateUserMappingService.delete(Long.parseLong(workflowTemplateUserMappingId));
               session.setAttribute("message", "Workflow Template User Mapping details deleted successfully");
            } catch (Exception var7) {
               session.setAttribute("message", "Cannot delete this record as it is used in other page");
               return this.editWorkflowTemplateUserMapping(request, response);
            }
         } else {
            session.setAttribute("message", "The Workflow Template User Mapping details you are trying to delete is already deleted.");
         }
      }

      return this.listWorkflowTemplateUserMapping(request, response);
   }
}
