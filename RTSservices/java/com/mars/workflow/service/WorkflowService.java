package com.mars.workflow.service;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.jbpm.api.task.Task;
import org.springframework.transaction.annotation.Transactional;

import com.mars.workflow.model.TaskHistoryDetails;

@Transactional(readOnly = true)
public interface WorkflowService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void createProcessDefinitions();

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
     public String createWorkflow(String workflowName, Map<String, Object> vars);

	public List<Task> getPersonalTasks(String userName);

	public long getPersonalTasksCount(String userName);

	public List<Task> getGroupTasks(String userName);

	public long getGroupTasksCount(String userName);

	public void takeTask(String taskId, String userName);

	public void takeMultipleTasks(String taskIds, String userName);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void completeTask(String taskId, String transitionName, String wofklowComments, int priority, Date dueDate);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveToGroup(String taskId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
     public void reassignTask(String taskId, String userName);

	public List<String> getTaskTransitions(String taskId);

	public void endProcess(String strProcessId, String taskComments);

	public String getCurrentTaskId(String processId);

	public List<TaskHistoryDetails> getTaskHistory(String strProcessId);

	public List<TaskHistoryDetails> getTaskHistoryAll(String strProcessId);

	public boolean isProcessEnded(String strProcessId);

	public boolean isGroupTask(String strTaskId);

	public boolean isMyTask(String taskId, String userName);

	public Task getTaskDetails(String strTaskId);

	public boolean checkUserExists(String userName);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public boolean checkUsergroupExists(String userGroupName);

	public void createProcessDefinitionFromTemplate(Hashtable<String, Object> hstContents);

	public List<TaskHistoryDetails> getCompletedTasks(String userName);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public void saveOrUpdateUser(String userName, String firstName, String lastName, String email);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
      public void deleteUser(String userName);
}
