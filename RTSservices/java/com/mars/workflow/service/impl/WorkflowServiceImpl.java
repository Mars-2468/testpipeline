package com.mars.workflow.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ManagementService;
import org.jbpm.api.NewDeployment;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.history.HistoryActivityInstance;
import org.jbpm.api.history.HistoryComment;
import org.jbpm.api.history.HistoryTask;
import org.jbpm.api.identity.Group;
import org.jbpm.api.identity.User;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.jbpm.pvm.internal.task.TaskImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.mars.workflow.model.TaskHistoryDetails;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Service("workflowService")
public class WorkflowServiceImpl implements WorkflowService {

	private static Log log = LogFactory.getLog(WorkflowServiceImpl.class);

	private List<String> processDefinitions;

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private ExecutionService executionService;

	
	@Autowired
	private TaskService taskService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private ManagementService managementService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private ProcessEngine processEngine;

	@Autowired
	private VelocityEngine velocityEngine;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void setWorkflowProcessDetailsService(WorkflowProcessDetailsService workflowProcessDetailsService) {
		this.workflowProcessDetailsService = workflowProcessDetailsService;
	}

	public void setExecutionService(ExecutionService executionService) {
		this.executionService = executionService;
	}

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}

	public void setManagementService(ManagementService managementService) {
		this.managementService = managementService;
	}

	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public void setProcessDefinitions(List<String> processDefinitions) {
		this.processDefinitions = processDefinitions;
	}

	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}

	public void createProcessDefinitions() {
		try {
			for (String processDefinition : processDefinitions) {
				NewDeployment deployment = repositoryService.createDeployment();
				deployment.addResourceFromUrl(new ClassPathResource(processDefinition).getURL());
				deployment.deploy();
			}
		} catch (IOException e) {
			log.info("IOException occurred: ", e);
			throw new RuntimeException("An error occured while trying to deploy a process definition", e);
		}
	}

	public void createProcessDefinitionFromTemplate(Hashtable<String, Object> hstContents) {
		try {
			if (hstContents != null && hstContents.containsKey("TEMPLATE_NAME")) {
				String strContent = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, hstContents.get("TEMPLATE_NAME").toString(), hstContents);
				NewDeployment deployment = repositoryService.createDeployment();
				File file = File.createTempFile(RandomStringUtils.randomAlphanumeric(10) + "_" + hstContents.get("PROCESS_NAME").toString(), ".jpdl.xml");
				FileUtils.writeByteArrayToFile(file, strContent.getBytes());
				deployment.addResourceFromFile(file);
				deployment.deploy();
				file.deleteOnExit();
			}
		} catch (Exception exception) {
			log.error("Exception while creating deployment.");
		}
	}

	public String createWorkflow(String workflowName, Map<String, Object> vars) {
		log.info("Entering --*create workflow method*--");
		ExecutionImpl execution = (ExecutionImpl) executionService.startProcessInstanceByKey(workflowName, vars);
		log.info("Getting execution details"+execution);
		if (vars.containsKey(WorkflowConstants.WORKFLOW_ENTITYNAME) && vars.containsKey(WorkflowConstants.WORKFLOW_ENTITYID)) {
			// Setting workflow process details
			WorkflowProcessDetails processDetails = new WorkflowProcessDetails();
			processDetails.setProcessId(execution.getId());
			processDetails.setEntityId(Long.parseLong(vars.get(WorkflowConstants.WORKFLOW_ENTITYID).toString()));
			if (vars.get(WorkflowConstants.WORKFLOW_ENTITY_DETAILS) != null)
				processDetails.setEntityDetails(vars.get(WorkflowConstants.WORKFLOW_ENTITY_DETAILS).toString());
			processDetails.setEntityName(vars.get(WorkflowConstants.WORKFLOW_ENTITYNAME).toString());
			processDetails.setUserName(vars.get(WorkflowConstants.WORKFLOW_USER_NAME).toString());
			processDetails.setWorkflowStatus(WorkflowConstants.WORKFLOW_STATUS_STARTED);
			workflowProcessDetailsService.save(processDetails);
			log.info("workflow process details saved successfully"+processDetails);
			String taskId = getCurrentTaskId(execution.getId());
			log.info("getting taskId"+taskId);
			String workflowComments = "Workflow Created automatically";
			if(vars.get(WorkflowConstants.WORKFLOW_COMMENTS) != null)
				workflowComments = vars.get(WorkflowConstants.WORKFLOW_COMMENTS).toString();
			Task task = taskService.getTask(taskId);
			task.setDescription(workflowComments);
			taskService.addTaskComment(taskId, workflowComments);
			taskService.saveTask(task);
			log.info("task saved successfully");
		}
		return execution.getId();
	}

	public List<Task> getPersonalTasks(String userName) {
		List<Task> tasks = taskService.findPersonalTasks(userName);
		return tasks;
	}

	public long getPersonalTasksCount(String userName) {
		List<Task> tasks = taskService.findPersonalTasks(userName);
		if (tasks != null)
			return tasks.size();
		return 0;
	}

	public long getGroupTasksCount(String userName) {
		List<Task> tasks = taskService.findGroupTasks(userName);
		if (tasks != null)
			return tasks.size();
		return 0;
	}

	public List<Task> getGroupTasks(String userName) {
		List<Task> tasks = taskService.findGroupTasks(userName);
		return tasks;
	}

	public void createUserGroup(String strGroupName) {
		identityService.createGroup(strGroupName);
	}

	private void createUser(String userName, String firstName, String lastName, String email) {
		if (!checkUsergroupExists(WorkflowConstants.WORKFLOW_DEFAULT_GROUP))
			createUserGroup(WorkflowConstants.WORKFLOW_DEFAULT_GROUP);
		identityService.createUser(userName, firstName, lastName, email);
		createUserToUserGroup(userName, WorkflowConstants.WORKFLOW_DEFAULT_GROUP);
	}

	private void createUserToUserGroup(String userName, String strGroupName) {
		identityService.createMembership(userName, strGroupName);
	}

	public void takeTask(String taskId, String userName) {
		taskService.takeTask(taskId, userName);
	}

	public void takeMultipleTasks(String taskIds, String userName) {
		if (StringUtils.isNotEmpty(taskIds)) {
			String strIds[] = taskIds.split(",");
			for (String taskId : strIds)
				taskService.takeTask(taskId, userName);
		}
	}

	public void completeTask(String taskId, String transitionName, String wofklowComments, int priority, Date dueDate) {
		if (taskId != null) {
			Task task = taskService.getTask(taskId);
			if (task != null) {
				taskService.addTaskComment(taskId, wofklowComments);
				taskService.completeTask(taskId, transitionName);
				getNextTask(task.getExecutionId(), wofklowComments, priority, dueDate);
			}
		}
	}

	public void saveToGroup(String taskId) {
		taskService.assignTask(taskId, null);
	}

	public void reassignTask(String taskId, String userName) {
		taskService.assignTask(taskId, userName);

	}

	public List<String> getTaskTransitions(String taskId) {
		if (taskId != null) {
			Set<String> setTransistions = taskService.getOutcomes(taskId);
			if (setTransistions != null) {
				List<String> listTransistions = new ArrayList<String>();
				listTransistions.addAll(setTransistions);
				Collections.sort(listTransistions);
				return listTransistions;
			}
		}

		return null;
	}

	public void getNextTask(String strProcessId, String workflowComments, int priority, Date duedate) {
		ProcessInstance instance = executionService.findProcessInstanceById(strProcessId);
		if (instance != null && !instance.isEnded()) {
			List<Task> listNextTasks = taskService.createTaskQuery().processInstanceId(strProcessId).list();
			for (Task task : listNextTasks) {
				TaskImpl impl = (TaskImpl) task;
				if (impl.isSignalling()) {
					task.setPriority(priority);
					// task.setDuedate(duedate);
					task.setDescription(workflowComments);
					taskService.saveTask(task);
				}
			}
		}
	}

	public void endProcess(String strProcessId, String taskComments) {
		ProcessInstance instance = executionService.findProcessInstanceById(strProcessId);
		if (instance != null) {
			String taskId = getCurrentTaskId(strProcessId);
			taskService.addTaskComment(taskId, taskComments);
			executionService.endProcessInstance(strProcessId, "active");
		}
	}

	public String getCurrentTaskId(String strProcessId) {
		ProcessInstance instance = executionService.findProcessInstanceById(strProcessId);
		if (instance != null && !instance.isEnded()) {
			List<Task> listNextTasks = taskService.createTaskQuery().processInstanceId(strProcessId).list();
			for (Task task : listNextTasks) {
				TaskImpl impl = (TaskImpl) task;
				if (impl.isSignalling())
					return task.getId();
			}
		}
		return null;
	}

	public List<TaskHistoryDetails> getTaskHistory(String strProcessId) {
		boolean blnLoadData = false;
		List<HistoryActivityInstance> listTasks = historyService.createHistoryActivityInstanceQuery().processInstanceId(strProcessId).list();
		if (listTasks != null && listTasks.size() > 0) {
			List<TaskHistoryDetails> taskHistory = new ArrayList<TaskHistoryDetails>();
			for (HistoryActivityInstance historyActivityTask : listTasks) {
				if (!strProcessId.equalsIgnoreCase(historyActivityTask.getExecutionId())) {
					blnLoadData = true;
					historyActivityTask = (HistoryActivityInstance) historyActivityTask;
					List<HistoryTask> listHistoryTask = historyService.createHistoryTaskQuery().executionId(historyActivityTask.getExecutionId()).state("completed").list();
					for (HistoryTask historyTask : listHistoryTask) {
						List<HistoryComment> listComments = taskService.getTaskComments(historyTask.getId());
						if (listComments != null && listComments.size() > 0) {
							Collections.reverse(listComments);
							for (HistoryComment comment : listComments) {
								TaskHistoryDetails historyDetails = new TaskHistoryDetails();
								historyDetails.setTaskId(historyTask.getId());
								historyDetails.setCreateTime(historyTask.getCreateTime());
								historyDetails.setEndTime(historyTask.getEndTime());
								historyDetails.setAssignee(historyTask.getAssignee());
								historyDetails.setOutcome(historyTask.getOutcome());
								historyDetails.setComments(comment.getMessage());
								taskHistory.add(historyDetails);
							}
							if(listComments.size()>1){
								WorkflowProcessDetails details = workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(strProcessId);
								if(details!=null) {
									TaskHistoryDetails historyDetails  = taskHistory.get(taskHistory.size()-1);
									historyDetails.setAssignee(details.getUserName());
									historyDetails.setOutcome("Workflow Created");
								}	
							}
						} else {
							TaskHistoryDetails historyDetails = new TaskHistoryDetails();
							historyDetails.setTaskId(historyTask.getId());
							historyDetails.setCreateTime(historyTask.getCreateTime());
							historyDetails.setEndTime(historyTask.getEndTime());
							historyDetails.setAssignee(historyTask.getAssignee());
							historyDetails.setOutcome(historyTask.getOutcome());
							taskHistory.add(historyDetails);
						}
					}
				}
			}

			if (!blnLoadData) {
				List<HistoryTask> listHistoryTask = historyService.createHistoryTaskQuery().executionId(strProcessId).state("completed").list();
				for (HistoryTask historyTask : listHistoryTask) {
					List<HistoryComment> listComments = taskService.getTaskComments(historyTask.getId());
					if (listComments != null && listComments.size() > 0) {
						Collections.reverse(listComments);
						for (HistoryComment comment : listComments) {
							TaskHistoryDetails historyDetails = new TaskHistoryDetails();
							historyDetails.setTaskId(historyTask.getId());
							historyDetails.setCreateTime(historyTask.getCreateTime());
							historyDetails.setEndTime(historyTask.getEndTime());
							historyDetails.setAssignee(historyTask.getAssignee());
							historyDetails.setOutcome(historyTask.getOutcome());
							historyDetails.setComments(comment.getMessage());
							taskHistory.add(historyDetails);
						}
						if(listComments.size()>1){
							WorkflowProcessDetails details = workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(strProcessId);
							if(details!=null) {
								TaskHistoryDetails historyDetails  = taskHistory.get(taskHistory.size()-1);
								historyDetails.setAssignee(details.getUserName());
								historyDetails.setOutcome("Workflow Created");
							}	
						}
					} else {
						TaskHistoryDetails historyDetails = new TaskHistoryDetails();
						historyDetails.setTaskId(historyTask.getId());
						historyDetails.setCreateTime(historyTask.getCreateTime());
						historyDetails.setEndTime(historyTask.getEndTime());
						historyDetails.setAssignee(historyTask.getAssignee());
						historyDetails.setOutcome(historyTask.getOutcome());
						taskHistory.add(historyDetails);
					}
				}
			}
			return taskHistory;
		}
		return null;
	}

	public List<TaskHistoryDetails> getTaskHistoryAll(String strProcessId) {
		boolean blnLoadData = false;
		List<HistoryActivityInstance> listTasks = historyService.createHistoryActivityInstanceQuery().processInstanceId(strProcessId).list();
		if (listTasks != null && listTasks.size() > 0) {
			List<TaskHistoryDetails> taskHistory = new ArrayList<TaskHistoryDetails>();
			for (HistoryActivityInstance historyActivityTask : listTasks) {
				if (!strProcessId.equalsIgnoreCase(historyActivityTask.getExecutionId())) {
					blnLoadData = true;
					historyActivityTask = (HistoryActivityInstance) historyActivityTask;
					List<HistoryTask> listHistoryTask = historyService.createHistoryTaskQuery().executionId(historyActivityTask.getExecutionId()).list();
					for (HistoryTask historyTask : listHistoryTask) {
						List<HistoryComment> listComments = taskService.getTaskComments(historyTask.getId());
						if (listComments != null && listComments.size() > 0) {
							Collections.reverse(listComments);
							for (HistoryComment comment : listComments) {
								TaskHistoryDetails historyDetails = new TaskHistoryDetails();
								historyDetails.setTaskId(historyTask.getId());
								historyDetails.setCreateTime(historyTask.getCreateTime());
								historyDetails.setEndTime(historyTask.getEndTime());
								historyDetails.setAssignee(historyTask.getAssignee());
								historyDetails.setOutcome(historyTask.getOutcome());
								historyDetails.setComments(comment.getMessage());
								taskHistory.add(historyDetails);
							}
							if(listComments.size()>1){
								WorkflowProcessDetails details = workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(strProcessId);
								if(details!=null) {
									TaskHistoryDetails historyDetails  = taskHistory.get(taskHistory.size()-1);
									historyDetails.setAssignee(details.getUserName());
									historyDetails.setOutcome("Workflow Created");
								}	
							}
						} else {
							TaskHistoryDetails historyDetails = new TaskHistoryDetails();
							historyDetails.setTaskId(historyTask.getId());
							historyDetails.setCreateTime(historyTask.getCreateTime());
							historyDetails.setEndTime(historyTask.getEndTime());
							historyDetails.setAssignee(historyTask.getAssignee());
							historyDetails.setOutcome(historyTask.getOutcome());
							taskHistory.add(historyDetails);
						}
					}
				}
			}

			if (!blnLoadData) {
				List<HistoryTask> listHistoryTask = historyService.createHistoryTaskQuery().executionId(strProcessId).list();
				for (HistoryTask historyTask : listHistoryTask) {
					List<HistoryComment> listComments = taskService.getTaskComments(historyTask.getId());
					if (listComments != null && listComments.size() > 0) {
						Collections.reverse(listComments);
						for (HistoryComment comment : listComments) {
							TaskHistoryDetails historyDetails = new TaskHistoryDetails();
							historyDetails.setTaskId(historyTask.getId());
							historyDetails.setCreateTime(historyTask.getCreateTime());
							historyDetails.setEndTime(historyTask.getEndTime());
							historyDetails.setAssignee(historyTask.getAssignee());
							historyDetails.setOutcome(historyTask.getOutcome());
							historyDetails.setComments(comment.getMessage());
							taskHistory.add(historyDetails);
						}
					} else {
						TaskHistoryDetails historyDetails = new TaskHistoryDetails();
						historyDetails.setTaskId(historyTask.getId());
						historyDetails.setCreateTime(historyTask.getCreateTime());
						historyDetails.setEndTime(historyTask.getEndTime());
						historyDetails.setAssignee(historyTask.getAssignee());
						historyDetails.setOutcome(historyTask.getOutcome());
						taskHistory.add(historyDetails);
					}
				}
			}
			return taskHistory;
		}
		return null;
	}

	public List<TaskHistoryDetails> getCompletedTasks(String userName) {
		List<HistoryTask> listHistoryTask = historyService.createHistoryTaskQuery().assignee(userName).state("completed").orderDesc("endTime").list();
		List<TaskHistoryDetails> taskHistory = new ArrayList<TaskHistoryDetails>();
		for (HistoryTask historyTask : listHistoryTask) {
			TaskHistoryDetails historyDetails = new TaskHistoryDetails();
			historyDetails.setTaskId(historyTask.getId());
			historyDetails.setCreateTime(historyTask.getCreateTime());
			historyDetails.setEndTime(historyTask.getEndTime());
			historyDetails.setAssignee(historyTask.getAssignee());
			historyDetails.setOutcome(historyTask.getOutcome());

			// historyDetails.setActivityName(historyActivityTask.getActivityName());

			List<HistoryComment> listComments = taskService.getTaskComments(historyTask.getId());
			if (listComments != null && listComments.size() > 0) {
				HistoryComment comment = listComments.get(0);
				historyDetails.setComments(comment.getMessage());
			}
			taskHistory.add(historyDetails);
			String strExecutionId = historyTask.getExecutionId();
			String strArray[] = strExecutionId.split("\\.");
			if (strArray.length > 2) {
				strExecutionId = strArray[0] + "." + strArray[1];
			}
			WorkflowProcessDetails processDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(strExecutionId);
			if (processDetails != null) {
				historyDetails.setEntityName(processDetails.getEntityName());
				historyDetails.setEntityId("" + processDetails.getEntityId());
				historyDetails.setExecutionId(processDetails.getProcessId());
				historyDetails.setEntityDetails(processDetails.getEntityDetails());
			}
		}
		return taskHistory;
	}

	public boolean isProcessEnded(String strProcessId) {
		ProcessInstance instance = executionService.findProcessInstanceById(strProcessId);
		if (instance != null && !instance.isEnded())
			return false;
		return true;
	}

	public boolean isGroupTask(String strTaskId) {
		Task task = taskService.getTask(strTaskId);
		if (task != null && task.getAssignee() == null) {
			return true;
		}
		return false;
	}

	public boolean isMyTask(String taskId, String userName) {
		Task task = taskService.getTask(taskId);
		if (task != null && task.getAssignee() != null && task.getAssignee().equalsIgnoreCase(userName)) {
			return true;
		}
		return false;
	}

	public Task getTaskDetails(String strTaskId) {
		Task task = taskService.getTask(strTaskId);
		return task;
	}

	public boolean checkUserExists(String userName) {
		User user = identityService.findUserById(userName);
		if (user != null)
			return true;
		return false;
	}

	public boolean checkUsergroupExists(String userGroupName) {
		Group group = identityService.findGroupById(userGroupName);
		if (group != null)
			return true;
		return false;
	}

	public void saveOrUpdateUser(String userName, String firstName, String lastName, String email) {
		if (checkUserExists(userName)) {
			if (isDataModified(userName, firstName, lastName, email)) {
				deleteUser(userName);
				createUser(userName, firstName, lastName, email);
			}
		} else {
			createUser(userName, firstName, lastName, email);
		}
	}

	public void deleteUser(String userName) {
		User user = identityService.findUserById(userName);
		if (user != null) {
			identityService.deleteMembership(userName, WorkflowConstants.WORKFLOW_DEFAULT_GROUP, null);
			identityService.deleteUser(userName);
		}
	}

	private boolean isDataModified(String userName, String firstName, String lastName, String email) {
		User user = identityService.findUserById(userName);
		boolean blnUpdated = false;
		if (user != null) {
			if (email != null && !email.equalsIgnoreCase(user.getBusinessEmail()))
				blnUpdated = true;
			if (firstName != null && !firstName.equalsIgnoreCase(user.getGivenName()))
				blnUpdated = true;
			if (lastName != null && !lastName.equalsIgnoreCase(user.getFamilyName()))
				blnUpdated = true;
		}
		return blnUpdated;
	}
}
