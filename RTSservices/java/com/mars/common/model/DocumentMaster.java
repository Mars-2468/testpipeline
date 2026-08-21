package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mars.common.utils.Constants;


@Entity
@Table(name = "document_master", schema = "egovrti")
public class DocumentMaster implements java.io.Serializable
{
	@Id	
    @Column(name="document_master_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="document_master_seq", sequenceName="document_master_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="document_master_seq")
    private long documentMasterId;

	@ManyToOne
	@JoinColumn(name = "stage_id", nullable = false)
	private Stage stage = new Stage();

	@Column(name="description", nullable=true ,unique=true)	
	private String description;

	@Column(name="mandatory", nullable=true ,unique=true)
	private Integer mandatory;
    
	@Column(name="status", nullable=true ,unique=true)
    private Integer status = new Integer(Constants.ACTIVE);
    
	@Column(name="document_type", nullable=true ,unique=true)
    private Integer documentType = new Integer(Constants.DOCUMENT_TYPE_GENERAL);
    
	@Column(name="input_type", nullable=true ,unique=true)
    private Integer inputType;
    
	@Column(name="dms_document_type", nullable=true ,unique=true)
    private String dmsDocumentType;
    
    //Used for DMS related settings
    
    @Transient
	private boolean checked;
    
    @Transient
    private long dmsDocumentCheckListId;
    
    @Transient
    private String dmsUuid; 
    
    @Transient
    private String uploadedDate; 
    
    @Transient
    private String fileName;
    
    @Column(name="tenancyid", nullable=true ,unique=true)
    private long tenancyid;
    
    

    public DocumentMaster()
    {
    }

    public DocumentMaster(Stage stage, String description, Integer mandatory, Integer status,Integer documentType)
    {
	this.stage = stage;
	this.description = description;
	this.mandatory = mandatory;
	this.status = status;
	this.documentType = documentType;
    }

    public long getDocumentMasterId()
    {
	return this.documentMasterId;
    }

    public void setDocumentMasterId(long documentMasterId)
    {
	this.documentMasterId = documentMasterId;
    }

    public Stage getStage()
    {
	return this.stage;
    }

    public void setStage(Stage stage)
    {
	this.stage = stage;
    }

    public String getDescription()
    {
	return this.description;
    }

    public void setDescription(String description)
    {
	this.description = description;
    }

    public Integer getMandatory()
    {
	return this.mandatory;
    }

    public void setMandatory(Integer mandatory)
    {
	this.mandatory = mandatory;
    }

    public Integer getStatus()
    {
	return this.status;
    }

    public void setStatus(Integer status)
    {
	this.status = status;
    }

	 public void setDocumentType(Integer documentType) {
		this.documentType = documentType;
	}
	
    public Integer getDocumentType() {
		return documentType;
	}
	
	public boolean isChecked() {
		return checked;
	}

	public String getDmsDocumentType() {
		return dmsDocumentType;
	}

	public void setDmsDocumentType(String dmsDocumentType) {
		this.dmsDocumentType = dmsDocumentType;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setInputType(Integer inputType) {
		this.inputType = inputType;
	}

	public Integer getInputType() {
		return inputType;
	}

	public long getDmsDocumentCheckListId() {
		return dmsDocumentCheckListId;
	}

	public void setDmsDocumentCheckListId(long dmsDocumentCheckListId) {
		this.dmsDocumentCheckListId = dmsDocumentCheckListId;
	}

	public String getDmsUuid() {
		return dmsUuid;
	}

	public void setDmsUuid(String dmsUuid) {
		this.dmsUuid = dmsUuid;
	}

	public String getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(String uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getTenancyid() {
		return tenancyid;
	}

	public void setTenancyid(long tenancyid) {
		this.tenancyid = tenancyid;
	}

	
	
}
