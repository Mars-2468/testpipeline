package com.mars.workflow.filter;

import com.mars.common.model.User;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.service.WorkflowUsersService;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class WorkflowServletFilter extends OncePerRequestFilter {
   private static Log log = LogFactory.getLog(WorkflowServletFilter.class);

   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      ApplicationContext applicationContext = this.getContext(super.getFilterConfig());
      HttpSession httpSession = request.getSession();
      SessionUser sessionUser = (SessionUser)httpSession.getAttribute("SessionUser");
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
      Cookie[] cookies = request.getCookies();
      if (cookies != null && cookies.length > 0) {
         for(Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase("DWRSESSIONID")) {
               String sessionid = cookie.getValue();
               cookie.setMaxAge(0);
               response.setHeader("SET-COOKIE", "DWRSESSIONID=" + sessionid + "; Path=" + request.getContextPath() + "; HttpOnly; Secure");
            }
         }
      }

      if (applicationContext != null && sessionUser != null) {
         WorkflowService workflowService = (WorkflowService)applicationContext.getBean("workflowService");
         WorkflowProcessDetailsService workflowProcessDetailsService = (WorkflowProcessDetailsService)applicationContext.getBean("workflowProcessDetailsService");
         WorkflowUsersService workflowUsersService = (WorkflowUsersService)applicationContext.getBean("workflowUsersService");
         String strWorkflowAction = request.getParameter("WORKFLOW_ACTION");
         String workflow_id = request.getParameter("WORKFLOW_JOB_ID");
         String task_id = request.getParameter("WORKFLOW_TASK_ID");
         String workflow_name = request.getParameter("WORKFLOW_NAME");
         String workflow_assign = request.getParameter("WORKFLOW_REASSIGN_USER");
         String worfklow_tranistion = request.getParameter("WORKFLOW_TRANSISTION");
         String worfklow_entityname = request.getParameter("WORKFLOW_ENTITYNAME");
         String worfklow_entityid = request.getParameter("WORKFLOW_ENTITYID");
         String workflow_comments = request.getParameter("WORKFLOW_COMMENTS");
         String workflow_priority = request.getParameter("WORKFLOW_PRIORITY");
         String workflow_due_date = request.getParameter("WORKFLOW_DUE_DATE");
         int priority = 0;
         Calendar calendar = Calendar.getInstance();
         calendar.set(5, calendar.get(5) + 1);
         Date dueDate = calendar.getTime();
         if (StringUtils.isNotEmpty(workflow_priority)) {
            priority = Integer.parseInt(workflow_priority);
         }

         if (StringUtils.isNotEmpty(workflow_due_date)) {
            dueDate = CommonUtils.getFormattedDate(workflow_due_date);
         }

         if (StringUtils.isNotEmpty(strWorkflowAction)) {
            if (strWorkflowAction.equalsIgnoreCase("DEPLOY_PROCESSES")) {
               workflowService.createProcessDefinitions();
            } else if (strWorkflowAction.equalsIgnoreCase("CREATE_USERS")) {
               UserService userService = (UserService)applicationContext.getBean("userService");

               for(User user : userService.getAll()) {
                  log.info("Creating users" + user.getUserName());
                  if (!workflowService.checkUserExists(user.getUserName())) {
                     workflowService.saveOrUpdateUser(user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail());
                  }
               }
            } else if (strWorkflowAction.equalsIgnoreCase("CREATE_PROCESS")) {
               if (StringUtils.isNotEmpty(workflow_name)) {
                  HashMap<String, Object> workflowMap = new HashMap();
                  workflowMap.put("WORKFLOW_NAME", workflow_name);
                  workflowMap.put("WORKFLOW_USER", sessionUser.getUserName());
                  if (StringUtils.isNotEmpty(worfklow_entityname)) {
                     workflowMap.put("WORKFLOW_ENTITYNAME", worfklow_entityname);
                  }

                  if (StringUtils.isNotEmpty(worfklow_entityid)) {
                     workflowMap.put("WORKFLOW_ENTITYID", worfklow_entityid);
                  }

                  WorkflowProcessDetails processDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(Long.parseLong(worfklow_entityid), worfklow_entityname);
                  if (processDetails == null) {
                     workflowUsersService.getWorkflowUsers(workflowMap);

                     try {
                        if (StringUtils.isEmpty(workflow_comments)) {
                           workflow_comments = "Worklow started by " + sessionUser.getUserName();
                        }

                        workflowMap.put("WORKFLOW_COMMENTS", workflow_comments);
                        log.info("calling create workflow method");
                        String strProcessId = workflowService.createWorkflow(workflow_name, workflowMap);
                        log.info("The Workflow Process created" + strProcessId + " for " + worfklow_entityname);
                     } catch (Exception exception) {
                        request.setAttribute("workflow_error", "Workflow could not be created.");
                        exception.printStackTrace();
                        log.error(exception);
                     }
                  }
               }
            } else if (strWorkflowAction.equalsIgnoreCase("TAKE_TASK")) {
               if (StringUtils.isNotEmpty(workflow_id) && StringUtils.isNotEmpty(task_id)) {
                  workflowService.takeTask(task_id, sessionUser.getUserName());
               }
            } else if (strWorkflowAction.equalsIgnoreCase("COMPLETE_TASK")) {
               if (StringUtils.isNotEmpty(worfklow_tranistion) && StringUtils.isNotEmpty(task_id)) {
                  workflowService.completeTask(task_id, worfklow_tranistion, workflow_comments, priority, dueDate);
                  if (worfklow_tranistion.equalsIgnoreCase("end")) {
                     WorkflowProcessDetails processDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(Long.parseLong(worfklow_entityid), worfklow_entityname);
                     if (processDetails != null) {
                        processDetails.setWorkflowStatus(3L);
                        workflowProcessDetailsService.save(processDetails);
                     }
                  }
               }
            }else if (strWorkflowAction.equalsIgnoreCase("L1-Approve")) {
                if (StringUtils.isNotEmpty(workflow_id) && StringUtils.isNotEmpty(task_id)) {
                	 workflowService.completeTask(task_id, worfklow_tranistion, workflow_comments, priority, dueDate);
                 }
              } else if (strWorkflowAction.equalsIgnoreCase("ASSIGN_TASK")) {
               if (StringUtils.isNotEmpty(workflow_id) && StringUtils.isNotEmpty(task_id)) {
                  workflowService.reassignTask(task_id, workflow_assign);
               }
            } else if (strWorkflowAction.equalsIgnoreCase("BACK_TO_GROUP")) {
               if (StringUtils.isNotEmpty(workflow_id) && StringUtils.isNotEmpty(task_id)) {
                  workflowService.saveToGroup(task_id);
               }
            } else if (strWorkflowAction.equalsIgnoreCase("KILL_JOB") && StringUtils.isNotEmpty(workflow_id) && StringUtils.isNotEmpty(task_id)) {
               if (StringUtils.isEmpty(workflow_comments)) {
                  workflow_comments = "Workflow discarded by " + sessionUser.getUserName();
               }

               workflowService.endProcess(workflow_id, workflow_comments);
               WorkflowProcessDetails processDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(Long.parseLong(worfklow_entityid), worfklow_entityname);
               if (processDetails != null) {
                  processDetails.setWorkflowStatus(2L);
                  workflowProcessDetailsService.save(processDetails);
               }
            }
         } else if (StringUtils.isNotEmpty(workflow_id) && StringUtils.isNotEmpty(task_id)) {
            request.setAttribute("WORKFLOW_TRANSISTIONS", workflowService.getTaskTransitions(task_id));
            request.setAttribute("WORKFLOW_JOB_ID", workflow_id);
            request.setAttribute("WORKFLOW_TASK_ID", task_id);
         }
      }

      filterChain.doFilter(request, response);
   }

   protected ApplicationContext getContext(FilterConfig filterConfig) {
      return WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext());
   }
}
