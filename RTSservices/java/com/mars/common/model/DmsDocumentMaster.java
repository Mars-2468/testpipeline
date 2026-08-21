package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

@Entity
@Table(name = "dms_document", schema = "egovrti")
@DataTransferObject(type = "hibernate3")
public class DmsDocumentMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	
    @Column(name="dms_document_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="dms_document_seq", sequenceName="dms_document_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="dms_document_seq")	
	@RemoteProperty
    private long dmsDocumentId;
	
	@Column(name="dms_uuid", nullable=true)
	@RemoteProperty
	private String dmsUuid; 
	
	@Column(name="file_name", nullable=true)
	@RemoteProperty
	private String fileName; 

	@Column(name="entity_name", nullable=true)
	@RemoteProperty
	private String entityName; 
	
	@Column(name="entity_id", nullable=true)
	@RemoteProperty
	private Long entityId; 

	@Column(name="dms_document_type", nullable=true)
	@RemoteProperty
    private String dmsDocumentType;
	
	@Column(name="uploaded_date", nullable=true)
	@RemoteProperty
	private String uploadedDate; 
	
	@Column(name="tenancyid", nullable=true)
    private long tenancyid;

	public DmsDocumentMaster() {
		super();
	}

	public DmsDocumentMaster(long dmsDocumentId, String dmsUuid, String fileName,
			String entityName, Long entityId, String dmsDocumentType,
			String uploadedDate, long tenancyid) {
		super();
		this.dmsDocumentId = dmsDocumentId;
		this.dmsUuid = dmsUuid;
		this.fileName = fileName;
		this.entityName = entityName;
		this.entityId = entityId;
		this.dmsDocumentType = dmsDocumentType;
		this.uploadedDate = uploadedDate;
		this.tenancyid = tenancyid;
	}

	public long getDmsDocumentId() {
		return dmsDocumentId;
	}

	public void setDmsDocumentId(long dmsDocumentId) {
		this.dmsDocumentId = dmsDocumentId;
	}

	public String getDmsUuid() {
		return dmsUuid;
	}

	public void setDmsUuid(String dmsUuid) {
		this.dmsUuid = dmsUuid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getDmsDocumentType() {
		return dmsDocumentType;
	}

	public void setDmsDocumentType(String dmsDocumentType) {
		this.dmsDocumentType = dmsDocumentType;
	}

	public String getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(String uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public long getTenancyid() {
		return tenancyid;
	}

	public void setTenancyid(long tenancyid) {
		this.tenancyid = tenancyid;
	}
}
