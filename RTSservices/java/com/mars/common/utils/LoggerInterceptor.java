package com.mars.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.mars.common.service.PermissionService;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.RTIApplicationService;
import com.mars.workflow.model.NmmcWorkflowInstance;
import com.mars.workflow.model.TaskHistoryDetails;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;




public class LoggerInterceptor implements HandlerInterceptor {

	@Autowired
	private RTIApplicationService rtiApplicationService;
	
	private static Log logger = LogFactory.getLog(LoggerInterceptor.class);

	public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2, ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (sessionUser != null) {
			// Change language
			String strLang = request.getParameter("lang");
			if (StringUtils.isNotEmpty(strLang))
				switchLanguage(request, sessionUser);

			// Load values for workflow
			String strEntityName = (String) request.getAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME);
			String strEntityId = String.valueOf(request.getAttribute(WorkflowConstants.WORKFLOW_ENTITYID));
			if (StringUtils.isNotEmpty(strEntityName) && StringUtils.isNotEmpty(strEntityId))
				loadWorkflowDetails(request, strEntityId, strEntityName, sessionUser.getUserName());
		}
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

		return true;
	}

	private void switchLanguage(HttpServletRequest request, SessionUser sessionUser) {
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		VelocityEngine velocityEngine = (VelocityEngine) applicationContext.getBean("velocityEngine");
		PermissionService permissionService = (PermissionService) applicationContext.getBean("permissionService");

		Hashtable hstRolesPermissions = permissionService.getPermissionsByRoleIds(sessionUser.getRoleIds());

		Hashtable<String, Object> hstContents = new Hashtable<String, Object>();
		hstContents.put("contextRoot", request.getContextPath());
		hstContents.put("rolesPermissions", hstRolesPermissions);

		// Added by balu for velocityTemplate
		SessionLocaleResolver localeResolver = (SessionLocaleResolver) applicationContext.getBean("localeResolver");
		Locale locale = localeResolver.resolveLocale(request);
		ReloadableResourceBundleMessageSource messageSource = (ReloadableResourceBundleMessageSource) applicationContext.getBean("messageSource");
		MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(messageSource, locale);
		hstContents.put("messageSource", messageSourceAccessor);

		String strContent = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "leftNavigation.vm", hstContents);
		request.getSession().setAttribute("leftNavigationContent", strContent);
	}

	private void loadWorkflowDetails(HttpServletRequest request, String strEntityId, String strEntityName, String strUserName) {
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		WorkflowProcessDetailsService workflowProcessDetailsService = (WorkflowProcessDetailsService) applicationContext.getBean("workflowProcessDetailsService");
		WorkflowService workflowService = (WorkflowService) applicationContext.getBean("workflowService");

		WorkflowProcessDetails workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(Long.parseLong(strEntityId), strEntityName);
		

		if (workflowProcessDetails != null) {
			long id = workflowProcessDetails.getEntityId();
			RTIApplication rtiApplication = rtiApplicationService.get(id);
			
			Integer status = rtiApplication.getWorkFlowStatus();
			String processId = workflowProcessDetails.getProcessId();
			String taskId = workflowService.getCurrentTaskId(processId);
			String userName = workflowProcessDetails.getUserName();
			boolean blnJob = false;
			if (userName.equalsIgnoreCase(strUserName)) {
				blnJob = true;
			}
			
			else if (userName.equalsIgnoreCase(WorkflowConstants.WORKFLOW_USER_NAME)) {
				blnJob = true;
			}
			NmmcWorkflowInstance workflowInstance = new NmmcWorkflowInstance();
			workflowInstance.setId(workflowProcessDetails.getProcessId());

			request.setAttribute(WorkflowConstants.WORKFLOW_JOB_ID, processId);
			request.setAttribute(WorkflowConstants.WORKFLOW_TASK_ID, taskId);

			request.setAttribute("nmmcWorkflowInstance", workflowInstance);
			List<List<TaskHistoryDetails>> listTaskHistory = new ArrayList<List<TaskHistoryDetails>>();
			List<WorkflowProcessDetails> listProcessDetails = workflowProcessDetailsService.getAllWorkflowProcessDetailsByEntityDetails(Long.parseLong(strEntityId), strEntityName);
			if(listProcessDetails != null)
			{
				for (WorkflowProcessDetails process : listProcessDetails) {

				    List<TaskHistoryDetails> taskHistory;

				    if (process.getWorkflowStatus() != WorkflowConstants.WORKFLOW_STATUS_ABORTED) {
				        taskHistory = workflowService.getTaskHistory(process.getProcessId());
				    } else {
				        taskHistory = workflowService.getTaskHistoryAll(process.getProcessId());
				    }

				    Collections.sort(taskHistory, new Comparator<TaskHistoryDetails>() {
				        @Override
				        public int compare(TaskHistoryDetails o1, TaskHistoryDetails o2) {
				            return o2.getTaskId().compareTo(o1.getTaskId());   // Descending
				        }
				    });

				    listTaskHistory.add(taskHistory);
				}
			}
			request.setAttribute("TASK_HISTORY", listTaskHistory);
			request.setAttribute("PROCESS_ENDED", false);

			if (!workflowService.isProcessEnded(processId)) {
				request.setAttribute("WORKFLOW_TRANSISTIONS", workflowService.getTaskTransitions(taskId));
				request.setAttribute("WORKFLOW_TASK_DETAILS", workflowService.getTaskDetails(taskId));
				boolean blnMyTask = workflowService.isMyTask(taskId, strUserName);
				
				if (!blnMyTask && status == 2 || !blnMyTask && status == 9 || !blnMyTask && status == 11 || !blnMyTask && status == 12) {
					request.setAttribute("WORKFLOW_COMMENTS", "Task Details - <span style='color:red'>Currently you do not have permission to work on this task.</span>");
					request.setAttribute("IS_MY_TASK", blnMyTask);
					request.setAttribute("IS_MY_JOB", blnJob);
				}else if(status == 3){
					request.setAttribute("WORKFLOW_COMMENTS", "Task Details - <span style='color:green'>Please take necessary actions by clicking on action buttons.</span>");
					blnMyTask = true;
					request.setAttribute("IS_MY_TASK", blnMyTask);
					request.setAttribute("IS_MY_JOB", blnJob);
				}else {
					
					request.setAttribute("WORKFLOW_COMMENTS", "Task Details - <span style='color:green'>Please take necessary actions by clicking on action buttons.</span>");
					request.setAttribute("IS_MY_TASK", blnMyTask);
					request.setAttribute("IS_MY_JOB", blnJob);
				}
				
			} else {
				request.setAttribute("WORKFLOW_COMMENTS", "Task Details - <span style='color:green'>Workflow completed successfully.</span>");
				request.setAttribute("PROCESS_ENDED", true);
			}
			
		}
	}
}