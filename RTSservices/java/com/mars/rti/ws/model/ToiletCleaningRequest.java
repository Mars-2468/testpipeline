package com.mars.rti.ws.model;


public class ToiletCleaningRequest {

    public ToiletCleaningRequest() {
    }

    private String staffName;
    private String zoneName;
    private String zoneid;
    private String blockNo;
    private String blockUnit;
    private String currentDate;
    private String shift;
    private String toiletType;
    private String condition;
    private String comments;
    private String latitude;
    private String longitude;
    private String beforeImageTime;
    private String afterImageTime;
    private String filesPath;
    private String entryGroupId;
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	public String getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}
	public String getBlockUnit() {
		return blockUnit;
	}
	public void setBlockUnit(String blockUnit) {
		this.blockUnit = blockUnit;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getToiletType() {
		return toiletType;
	}
	public void setToiletType(String toiletType) {
		this.toiletType = toiletType;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
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
	public String getFilesPath() {
		return filesPath;
	}
	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}
	public String getEntryGroupId() {
		return entryGroupId;
	}
	public void setEntryGroupId(String entryGroupId) {
		this.entryGroupId = entryGroupId;
	}

    // getters and setters
    
    
}