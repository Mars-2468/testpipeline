package com.mars.workflow.model;



import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import com.mars.common.model.Area;

/**
 * WorkflowTemplateUserMapping 
 */

    @Entity
    @Table(name = "WORKFLOW_TMPLT_USR_MAPPING", schema = "egovrti")
    @FilterDef(name="tenancyFilter", parameters={
    		@ParamDef( name="tenancyid", type="long" )
    })    
    public class WorkflowTemplateUserMapping  implements java.io.Serializable {

	@Id	
    @Column(name="WORKFLOW_TMPLT_USR_MAPPING_ID", nullable=false ,unique=true)	
    @SequenceGenerator(name="WORKFLOW_TMPLT_USR_MAPPING_seq", sequenceName="WORKFLOW_TMPLT_USR_MAPPING_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="WORKFLOW_TMPLT_USR_MAPPING_seq") 
    private long workflowTemplateUserMappingId;
	
	@ManyToOne
    @JoinColumn(name = "WORKFLOW_TEMPLATE_ID", nullable = false) 	
    private WorkflowTemplate workflowTemplate = new WorkflowTemplate();
	  
	@ManyToOne
	@JoinColumn(name = "AREA_ID", nullable = false) 	
    private Area area = new Area();
	  
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "workflowTemplateUserMapping")
	@Filters({
	    @Filter(name="tenancyFilter", condition=":tenancyid = tenancyId")
	 })
	@OrderBy	
    private Set<WorkflowTemplateUserMappingDetails> workflowTemplateUserMappingDetailsSet = new LinkedHashSet<WorkflowTemplateUserMappingDetails>();

    public WorkflowTemplateUserMapping() {
    }

    public WorkflowTemplateUserMapping(WorkflowTemplate workflowTemplate, Area area, Set<WorkflowTemplateUserMappingDetails> workflowTemplateUserMappingDetailsSet) {
       this.workflowTemplate = workflowTemplate;
       this.area = area;
       this.workflowTemplateUserMappingDetailsSet = workflowTemplateUserMappingDetailsSet;
    }
   
    public long getWorkflowTemplateUserMappingId() {
        return this.workflowTemplateUserMappingId;
    }
    
    public void setWorkflowTemplateUserMappingId(long workflowTemplateUserMappingId) {
        this.workflowTemplateUserMappingId = workflowTemplateUserMappingId;
    }
    public WorkflowTemplate getWorkflowTemplate() {
        return this.workflowTemplate;
    }
    
    public void setWorkflowTemplate(WorkflowTemplate workflowTemplate) {
        this.workflowTemplate = workflowTemplate;
    }
    public Area getArea() {
        return this.area;
    }
    
    public void setArea(Area area) {
        this.area = area;
    }
    public Set<WorkflowTemplateUserMappingDetails> getWorkflowTemplateUserMappingDetailsSet() {
        return this.workflowTemplateUserMappingDetailsSet;
    }
    
    public void setWorkflowTemplateUserMappingDetailsSet(Set<WorkflowTemplateUserMappingDetails> workflowTemplateUserMappingDetailsSet) {
        this.workflowTemplateUserMappingDetailsSet = workflowTemplateUserMappingDetailsSet;
    }



}


