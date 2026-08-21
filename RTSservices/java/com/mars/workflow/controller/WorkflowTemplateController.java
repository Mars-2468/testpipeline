package com.mars.workflow.controller;

import com.mars.common.model.Tenancy;
import com.mars.common.model.User;
import com.mars.common.search.UserSearch;
import com.mars.common.service.TenancyService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonRequestUtils;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;
import com.mars.workflow.model.WorkflowTemplate;
import com.mars.workflow.model.WorkflowTemplateTask;
import com.mars.workflow.service.WorkflowTemplateService;
import com.mars.workflow.service.WorkflowTemplateTaskService;
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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class WorkflowTemplateController extends MultiActionController implements InitializingBean {
   private static String const_OrderBy = "OrderBy";
   private static String const_SortBy = "SortBy";
   private static Log log = LogFactory.getLog(WorkflowTemplateController.class);
   @Autowired
   private WorkflowTemplateService workflowTemplateService;
   @Autowired
   private WorkflowTemplateTaskService workflowTemplateTaskService;
   @Autowired
   private UserService userService;
   @Autowired
   private TenancyService tenancyService;

   public void setWorkflowTemplateService(WorkflowTemplateService workflowTemplateService) {
      this.workflowTemplateService = workflowTemplateService;
   }

   public void setWorkflowTemplateTaskService(WorkflowTemplateTaskService workflowTemplateTaskService) {
      this.workflowTemplateTaskService = workflowTemplateTaskService;
   }

   public UserService getUserService() {
      return this.userService;
   }

   public void setTenancyService(TenancyService tenancyService) {
      this.tenancyService = tenancyService;
   }

   public void setUserService(UserService userService) {
      this.userService = userService;
   }

   public void afterPropertiesSet() throws Exception {
   }

   @InitBinder
   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
      SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
      df.setLenient(true);
      binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
   }

   @RequestMapping({"/workflowtemplate/saveWorkflowTemplate.do"})
   public ModelAndView saveWorkflowTemplate(HttpServletRequest request, HttpServletResponse response, WorkflowTemplate workflowTemplate) throws Exception {
      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      String workflowTemplateId = request.getParameter("workflowTemplateId");
      long tenancyId = sessionUser.getTenancyId();
      User user = this.userService.get(sessionUser.getUserId());
      if (log.isDebugEnabled()) {
         log.debug("Invoking saveWorkflowTemplate");
      }

      if (workflowTemplate != null) {
         workflowTemplate.setWorkflowTemplateTaskSet(this.getWorkflowTemplateTaskSet(request, workflowTemplate));
         WorkflowTemplate workflowTemplateObj = null;
         workflowTemplateObj = this.workflowTemplateService.checkForDuplicates(workflowTemplate);
         if (CommonTokenUtils.allowFormSubmit(request)) {
            if (workflowTemplateObj != null) {
               session.setAttribute("errMessage", "Workflow Template with the same name already exists.");
            } else {
               try {
                  workflowTemplate = this.workflowTemplateService.merge(workflowTemplate);
               } catch (DataIntegrityViolationException var12) {
                  session.setAttribute("errMessage", "Cannot delete the marked child as it is used in User Mappings.");
                  return this.editWorkflowTemplate(request, response);
               }

               session.setAttribute("message", "Workflow Template details saved successfully");
            }
         }
      }

      request.setAttribute("rowsize", workflowTemplate.getWorkflowTemplateTaskSet().size());
      UserSearch searchOptions = new UserSearch();
      searchOptions.setCurrentPage((long)Constants.DEFAULT_PAGINATION_ALL_ROWS);
      searchOptions.setOrderBy("user.firstName");
      searchOptions.setApplicationId(23L);
      request.setAttribute("userList", this.userService.getUserByType(searchOptions));
      ModelAndView modelandView = new ModelAndView("manageWorkflowTemplate");
      modelandView.addObject("workflowTemplate", workflowTemplate);
      return modelandView;
   }

   private Set<WorkflowTemplateTask> getWorkflowTemplateTaskSet(HttpServletRequest request, WorkflowTemplate workflowTemplate) throws Exception {
      Set<WorkflowTemplateTask> workflowTemplateTaskSet = null;
      String[] strDeleteIds = null;
      String deleteWorkflowTemplateTaskIds = request.getParameter("deleteWorkflowTemplateTaskIds");
      if (deleteWorkflowTemplateTaskIds != null && deleteWorkflowTemplateTaskIds.length() > 0) {
         strDeleteIds = deleteWorkflowTemplateTaskIds.split(",");
      }

      long[] workflowTemplateTaskId = CommonRequestUtils.getLongParameters(request, "workflowTemplateTaskId");
      String[] userName = CommonRequestUtils.getStringParameters(request, "userName");
      long[] durationInDays = CommonRequestUtils.getLongParameters(request, "durationInDays");
      int[] tenancy = CommonRequestUtils.getIntParameters(request, "tenancyId");
      int[] level = CommonRequestUtils.getIntParameters(request, "level");
      String[] assigneePlaceHolder = CommonRequestUtils.getStringParameters(request, "assigneePlaceHolder");
      if (assigneePlaceHolder != null && assigneePlaceHolder.length > 0) {
         int arrayLength = assigneePlaceHolder.length;
         workflowTemplateTaskSet = new LinkedHashSet();

         for(int i = 0; i < arrayLength; ++i) {
            boolean blndeletedId = false;
            if (strDeleteIds != null && strDeleteIds.length > 0) {
               for(String deleteId : strDeleteIds) {
                  if (Long.parseLong(deleteId) == workflowTemplateTaskId[i]) {
                     blndeletedId = true;
                  }
               }
            }

            if (!blndeletedId) {
               WorkflowTemplateTask workflowTemplateTask = new WorkflowTemplateTask();
               workflowTemplateTask.setAssigneePlaceHolder(assigneePlaceHolder[i]);
               workflowTemplateTask.setWorkflowTemplateTaskId(workflowTemplateTaskId[i]);
               workflowTemplateTask.setDefaultUserName(userName[i]);
               workflowTemplateTask.setDurationInDays(durationInDays[i]);
               workflowTemplateTask.setLevel((long)level[i]);
               if (workflowTemplateTaskId[i] > 0L) {
                  workflowTemplateTask.setLevel((long)level[i]);
               } else {
                  workflowTemplateTask.setLevel((long)(i + 1));
               }

               Tenancy a = new Tenancy();
               a.setTenancyId(1L);
               workflowTemplateTask.setTenancy(a);
               workflowTemplateTask.setWorkflowTemplate(workflowTemplate);
               workflowTemplateTaskSet.add(workflowTemplateTask);
            }
         }
      }

      return workflowTemplateTaskSet;
   }

   @RequestMapping({"/workflowtemplate/editWorkflowTemplate.do"})
   public ModelAndView editWorkflowTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      if (log.isDebugEnabled()) {
         log.debug("Invoking editWorkflowTemplate");
      }

      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      long tenancyId = sessionUser.getTenancyId();
      WorkflowTemplate workflowTemplate = null;
      String workflowTemplateId = request.getParameter("workflowTemplateId");
      if (StringUtils.isNotEmpty(workflowTemplateId)) {
         workflowTemplate = this.workflowTemplateService.get(Long.parseLong(workflowTemplateId));
         String workflowName = workflowTemplate.getWorkflowTemplateName();
         if (workflowTemplate != null && workflowTemplate.getWorkflowTemplateTaskSet().size() == 0) {
            String strHqlQuery = "Select workflowTemplateTask from WorkflowTemplateTask workflowTemplateTask where workflowTemplateTask.workflowTemplate.workflowTemplateId = " + workflowTemplate.getWorkflowTemplateId() + " and workflowTemplateTask.tenancy IS NULL order by workflowTemplateTask.level asc";
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
         } else {
            for(WorkflowTemplateTask workflowTemplateTask : workflowTemplate.getWorkflowTemplateTaskSet()) {
               UserSearch searchOptions = new UserSearch();
               searchOptions.setTenancyId(tenancyId);
            }
         }
      } else {
         workflowTemplate = new WorkflowTemplate();
      }

      request.setAttribute("rowsize", workflowTemplate.getWorkflowTemplateTaskSet().size());
      UserSearch searchOptions = new UserSearch();
      searchOptions.setTenancyId(tenancyId);
      searchOptions.setCurrentPage((long)Constants.DEFAULT_PAGINATION_ALL_ROWS);
      searchOptions.setOrderBy("user.firstName");
      String applicationName = request.getContextPath();
      searchOptions.setApplicationId(23L);
      request.setAttribute("userList", this.userService.getUserByType(searchOptions));
      CommonTokenUtils.setNewToken(request);
      return new ModelAndView("manageWorkflowTemplate", "workflowTemplate", workflowTemplate);
   }

   @RequestMapping({"/workflowtemplate/listWorkflowTemplate.do"})
   public ModelAndView listWorkflowTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      if (log.isDebugEnabled()) {
         log.debug("Invoking listWorkflowTemplate");
      }

      long longCurrentPage = CommonUtils.checkPaginationAttributes(request);
      String orderBy = request.getParameter(const_OrderBy);
      String sortBy = request.getParameter(const_SortBy);
      if (orderBy == null || orderBy.length() < 1) {
         orderBy = "workflowTemplateId";
         sortBy = "desc";
      }

      List<WorkflowTemplate> WorkflowTemplateList = this.workflowTemplateService.getWorkflowTemplateList(longCurrentPage, orderBy, sortBy);
      long totalCount = this.workflowTemplateService.getWorkflowTemplateCount();
      request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
      request.setAttribute("totalCount", totalCount);
      if (WorkflowTemplateList == null) {
         WorkflowTemplateList = new ArrayList();
      }

      request.setAttribute("currentPage", new Long(longCurrentPage));
      request.setAttribute(const_OrderBy, orderBy);
      request.setAttribute(const_SortBy, sortBy);
      return new ModelAndView("listWorkflowTemplate", "WorkflowTemplateList", WorkflowTemplateList);
   }

   @RequestMapping({"/workflowtemplate/deleteWorkflowTemplate.do"})
   public ModelAndView deleteWorkflowTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      HttpSession session = request.getSession();
      if (log.isDebugEnabled()) {
         log.debug("Invoking deleteWorkflowTemplate");
      }

      String workflowTemplateId = request.getParameter("workflowTemplateId");
      if (StringUtils.isNotEmpty(workflowTemplateId)) {
         WorkflowTemplate workflowTemplate = this.workflowTemplateService.get(Long.parseLong(workflowTemplateId));
         if (workflowTemplate != null) {
            try {
               this.workflowTemplateService.delete(Long.parseLong(workflowTemplateId));
               session.setAttribute("message", "Workflow Template details deleted successfully");
            } catch (Exception var7) {
               session.setAttribute("message", "Cannot delete this record as it is used in other page");
               return this.editWorkflowTemplate(request, response);
            }
         } else {
            session.setAttribute("message", "The Workflow Template details you are trying to delete is already deleted.");
         }
      }

      return this.listWorkflowTemplate(request, response);
   }
}
