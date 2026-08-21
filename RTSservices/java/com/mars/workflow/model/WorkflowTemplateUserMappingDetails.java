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
 * WorkflowTemplateUserMappingDetails
 */

@Entity
@Table(name = "WORKFLOW_TMPLT_USR_MAPPING_DTLS", schema = "egovrti")

public class WorkflowTemplateUserMappingDetails implements java.io.Serializable {

	@Id
	@Column(name = "WORKFLOW_TMPLT_USR_MAPPING_DTLS_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "WORKFLOW_TMPLT_USR_MAPPING_DTLS_seq", sequenceName = "WORKFLOW_TMPLT_USR_MAPPING_DTLS_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WORKFLOW_TMPLT_USR_MAPPING_DTLS_seq")
	private long workflowTemplateUserMappingDetailsId;

	@ManyToOne
	@JoinColumn(name = "WORKFLOW_TMPLT_USR_MAPPING_ID", nullable = false)
	private WorkflowTemplateUserMapping workflowTemplateUserMapping = new WorkflowTemplateUserMapping();

	@ManyToOne
	@JoinColumn(name = "WORKFLOW_TEMPLATE_TASK_ID", nullable = false)
	private WorkflowTemplateTask workflowTemplateTask = new WorkflowTemplateTask();

	@Column(name = "USER_NAME", unique = true, nullable = false)
	private String userName;

	@Column(name = "HEAD_OFF_USER_NAME", unique = true, nullable = true)
	private String headOffUserName;

	
	 @ManyToOne
	 @JoinColumn(name = "TENANCYID", unique = false, nullable = true) private
	 Tenancy tenancy = new Tenancy();
	 
	public WorkflowTemplateUserMappingDetails() {
	}

	public WorkflowTemplateUserMappingDetails(WorkflowTemplateUserMapping workflowTemplateUserMapping,
			WorkflowTemplateTask workflowTemplateTask) {
		this.workflowTemplateUserMapping = workflowTemplateUserMapping;
		this.workflowTemplateTask = workflowTemplateTask;
	}

	public long getWorkflowTemplateUserMappingDetailsId() {
		return this.workflowTemplateUserMappingDetailsId;
	}

	public void setWorkflowTemplateUserMappingDetailsId(long workflowTemplateUserMappingDetailsId) {
		this.workflowTemplateUserMappingDetailsId = workflowTemplateUserMappingDetailsId;
	}

	public WorkflowTemplateUserMapping getWorkflowTemplateUserMapping() {
		return this.workflowTemplateUserMapping;
	}

	public void setWorkflowTemplateUserMapping(WorkflowTemplateUserMapping workflowTemplateUserMapping) {
		this.workflowTemplateUserMapping = workflowTemplateUserMapping;
	}

	public WorkflowTemplateTask getWorkflowTemplateTask() {
		return this.workflowTemplateTask;
	}

	public void setWorkflowTemplateTask(WorkflowTemplateTask workflowTemplateTask) {
		this.workflowTemplateTask = workflowTemplateTask;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	public String getHeadOffUserName() {
		return headOffUserName;
	}

	public void setHeadOffUserName(String headOffUserName) {
		this.headOffUserName = headOffUserName;
	}

	public Tenancy getTenancy() {
		return tenancy;
	}
	public void setTenancy(Tenancy tenancy) {
		this.tenancy = tenancy;
	}

}
