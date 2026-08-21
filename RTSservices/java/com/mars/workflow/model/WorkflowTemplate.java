package com.mars.workflow.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;


/**
 * WorkflowTemplate 
 */
    @Entity
    @Table(name = "WORKFLOW_TEMPLATE", schema = "egovrti")
    @FilterDef(name="tenancyFilter", parameters={
    		@ParamDef( name="tenancyid", type="long" )
    })
    public class WorkflowTemplate  implements java.io.Serializable {

	@Id	
    @Column(name="workflow_template_id", nullable=true ,unique=true)	
    @SequenceGenerator(name="WORKFLOW_TEMPLATE_seq", sequenceName="WORKFLOW_TEMPLATE_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="WORKFLOW_TEMPLATE_seq") 
    private long workflowTemplateId;
	
	@Column(name = "WORKFLOW_TEMPLATE_NAME", unique = true, nullable = false)
    private String workflowTemplateName;
	 
	@Column(name = "STATUS", unique = true, nullable = false)
    private long status;
	 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "workflowTemplate", fetch=FetchType.EAGER)
	@Filters({
	    @Filter(name="tenancyFilter", condition=":tenancyid = tenancyId")
	 })
	@OrderBy
    private Set<WorkflowTemplateTask> workflowTemplateTaskSet = new LinkedHashSet<WorkflowTemplateTask>();

    public WorkflowTemplate() {
    }

	
    public WorkflowTemplate(long status) {
        this.status = status;
    }
    public WorkflowTemplate(String workflowTemplateName, long status) {
       this.workflowTemplateName = workflowTemplateName;
       this.status = status;
    }
   
    public long getWorkflowTemplateId() {
        return this.workflowTemplateId;
    }
    
    public void setWorkflowTemplateId(long workflowTemplateId) {
        this.workflowTemplateId = workflowTemplateId;
    }

    public long getStatus() {
        return this.status;
    }
    
    public void setStatus(long status) {
        this.status = status;
    }


	/**
	 * @return the workflowTemplateName
	 */
	public String getWorkflowTemplateName() {
		return workflowTemplateName;
	}


	/**
	 * @param workflowTemplateName the workflowTemplateName to set
	 */
	public void setWorkflowTemplateName(String workflowTemplateName) {
		this.workflowTemplateName = workflowTemplateName;
	}


	/**
	 * @return the workflowTemplateTaskSet
	 */
	public Set<WorkflowTemplateTask> getWorkflowTemplateTaskSet() {
		return workflowTemplateTaskSet;
	}


	/**
	 * @param workflowTemplateTaskSet the workflowTemplateTaskSet to set
	 */
	public void setWorkflowTemplateTaskSet(
			Set<WorkflowTemplateTask> workflowTemplateTaskSet) {
		this.workflowTemplateTaskSet = workflowTemplateTaskSet;
	}
	
}


