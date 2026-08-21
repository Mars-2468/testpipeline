package com.mars.workflow.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mars.common.model.Tenancy;

/**
 * WorkflowTemplateTask 
 */

    @Entity
    @Table(name = "WORKFLOW_TEMPLATE_TASK", schema = "egovrti")
    public class WorkflowTemplateTask  implements java.io.Serializable {

	@Id	
    @Column(name="WORKFLOW_TEMPLATE_TASK_ID", nullable=false ,unique=true)	
    @SequenceGenerator(name="WORKFLOW_TEMPLATE_TASK_seq", sequenceName="WORKFLOW_TEMPLATE_TASK_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="WORKFLOW_TEMPLATE_TASK_seq") 
    private long workflowTemplateTaskId;
	
	@Column(name = "ASSIGNEE_PLACE_HOLDER", unique = true, nullable = false)
    private String assigneePlaceHolder;
	 
	@Column(name = "DURATION_IN_DAYS", unique = true, nullable = false)
    private Long durationInDays;
	 
	@Column(name = "LEVEL", unique = true, nullable = false)
    private long level;
	 
	@ManyToOne
	@JoinColumn(name = "WORKFLOW_TEMPLATE_ID", nullable = false) 	
    private WorkflowTemplate workflowTemplate = new WorkflowTemplate();
	 
	@Column(name = "DEFAULT_USER_NAME", unique = false, nullable = false)
    private String defaultUserName;
	 
    @ManyToOne
	@JoinColumn(name = "tenancyid", nullable = true)
    private Tenancy tenancy = null;
     
    public WorkflowTemplateTask() {
    }
	
    public WorkflowTemplateTask(Long durationInDays, long level) {
        this.durationInDays = durationInDays;
        this.level = level;
    }
    
    public WorkflowTemplateTask(String assigneePlaceHolder, Long durationInDays, long level, WorkflowTemplate workflowTemplate) {
       this.assigneePlaceHolder = assigneePlaceHolder;
       this.durationInDays = durationInDays;
       this.level = level;
       this.workflowTemplate = workflowTemplate;
    }
   
    public long getWorkflowTemplateTaskId() {
        return this.workflowTemplateTaskId;
    }
    
    public void setWorkflowTemplateTaskId(long workflowTemplateTaskId) {
        this.workflowTemplateTaskId = workflowTemplateTaskId;
    }
    public String getAssigneePlaceHolder() {
        return this.assigneePlaceHolder;
    }
    
    public void setAssigneePlaceHolder(String assigneePlaceHolder) {
        this.assigneePlaceHolder = assigneePlaceHolder;
    }
    public Long getDurationInDays() {
        return this.durationInDays;
    }
    
    public void setDurationInDays(Long durationInDays) {
        this.durationInDays = durationInDays;
    }
    public long getLevel() {
        return this.level;
    }
    
    public void setLevel(long level) {
        this.level = level;
    }
    public WorkflowTemplate getWorkflowTemplate() {
        return this.workflowTemplate;
    }
    
    public void setWorkflowTemplate(WorkflowTemplate workflowTemplate) {
        this.workflowTemplate = workflowTemplate;
    }


	/**
	 * @param defaultUserName the defaultUserName to set
	 */
	public void setDefaultUserName(String defaultUserName) {
		this.defaultUserName = defaultUserName;
	}


	/**
	 * @return the defaultUserName
	 */
	public String getDefaultUserName() {
		return defaultUserName;
	}

	public Tenancy getTenancy() {
		return tenancy;
	}

	public void setTenancy(Tenancy tenancy) {
		this.tenancy = tenancy;
	}
	
}


