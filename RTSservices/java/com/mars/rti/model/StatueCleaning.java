package com.mars.rti.model;

import javax.persistence.*;

@Entity
@Table(name = "toilet_cleaning", schema = "egovrti")
public class StatueCleaning {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "toilet_cleaning_seq_gen")
	@SequenceGenerator(name = "toilet_cleaning_seq_gen", sequenceName = "egovrti.toilet_cleaning_seq_gen", allocationSize = 1)
	@Column(name = "cleaning_id")
	private Long cleaningId;

	@Column(name = "zone_name", nullable = false)
	private String zoneName;

	@Column(name = "block_no", nullable = false)
	private String blockNo;

	@Column(name = "currentdate", nullable = false)
	private String currentDate;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "blockunit")
	private String blockUnit;

	@Column(name = "workflowstatus")
	private Integer workFlowStatus;

	@Column(name = "workflow_comments")
	private String workflowComments;

	@Column(name = "files_path")
	private String filesPath;

	@Column(name = "encoded_files_path")
	private String encodedFilesPath;

	@Column(name = "uploadcert_path")
	private String uploadCertPath;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "updated_by")
	private String updatedBy;

	public Long getCleaningId() {
		return cleaningId;
	}

	public void setCleaningId(Long cleaningId) {
		this.cleaningId = cleaningId;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getBlockUnit() {
		return blockUnit;
	}

	public void setBlockUnit(String blockUnit) {
		this.blockUnit = blockUnit;
	}

	public Integer getWorkFlowStatus() {
		return workFlowStatus;
	}

	public void setWorkFlowStatus(Integer workFlowStatus) {
		this.workFlowStatus = workFlowStatus;
	}

	public String getWorkflowComments() {
		return workflowComments;
	}

	public void setWorkflowComments(String workflowComments) {
		this.workflowComments = workflowComments;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	public String getEncodedFilesPath() {
		return encodedFilesPath;
	}

	public void setEncodedFilesPath(String encodedFilesPath) {
		this.encodedFilesPath = encodedFilesPath;
	}

	public String getUploadCertPath() {
		return uploadCertPath;
	}

	public void setUploadCertPath(String uploadCertPath) {
		this.uploadCertPath = uploadCertPath;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	//new fields
	
//	@Column(name = "staffid")
//	private String staffId;
	
	@Column(name = "staffname")
	private String staffName;
	
//	@Column(name = "toiletid")
//	private String toiletId;
	
	@Column(name = "toilettype")
	private String toiletType;
	
	@Column(name = "shift")
	private String shift;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "toilet_condition")
	private String toiletCondition;

//	public String getStaffId() {
//		return staffId;
//	}
//
//	public void setStaffId(String staffId) {
//		this.staffId = staffId;
//	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

//	public String getToiletId() {
//		return toiletId;
//	}
//
//	public void setToiletId(String toiletId) {
//		this.toiletId = toiletId;
//	}

	public String getToiletType() {
		return toiletType;
	}

	public void setToiletType(String toiletType) {
		this.toiletType = toiletType;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getToiletCondition() {
		return toiletCondition;
	}

	public void setToiletCondition(String toiletCondition) {
		this.toiletCondition = toiletCondition;
	}

	
	@Column(name = "zoneid")
	private String zoneid;

	public String getZoneid() {
		return zoneid;
	}

	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	
	
	@Column(name = "savedtime")
	private String savetime;

	public String getSavetime() {
		return savetime;
	}

	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}
	
	@Column(name = "before_image_time")
	private String beforeImageTime;

	@Column(name = "after_image_time")
	private String afterImageTime;
	
	@Column(name = "is_draft")
	private String isDraft;

	
	public String getBeforeImageTime() {
		return beforeImageTime;
	}

	public void setBeforeImageTime(String beforeImageTime) {
		this.beforeImageTime = beforeImageTime;
	}

	public String getAfterImageTime() {
		return afterImageTime;
	}

	public void setAfterImageTime(String afterImageTime) {
		this.afterImageTime = afterImageTime;
	}

	public String getIsDraft() {
		return isDraft;
	}

	public void setIsDraft(String isDraft) {
		this.isDraft = isDraft;
	}
	
	@Transient
	private long rowNumber; 
	
	public long getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(long rowNumber) {
		this.rowNumber = rowNumber;
	}

	@Column(name = "entry_group_id")
	private String entryGroupId;

	public String getEntryGroupId() {
		return entryGroupId;
	}

	public void setEntryGroupId(String entryGroupId) {
		this.entryGroupId = entryGroupId;
	}
	
	


	
	
}
