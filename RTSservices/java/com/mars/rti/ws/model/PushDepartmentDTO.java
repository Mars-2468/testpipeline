package com.mars.rti.ws.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PushDepartmentDTO {

    @JsonProperty("Department")
    private String department;

    @JsonProperty("Service")
    private Integer service;

    @JsonProperty("Division")
    private Integer division;

    @JsonProperty("District")
    private Integer district;

    @JsonProperty("Taluka")
    private Integer taluka;

    @JsonProperty("Approved")
    private Integer approved;

    @JsonProperty("Rejected")
    private Integer rejected;

    @JsonProperty("OnTimeDelivery")
    private Integer onTimeDelivery;

    @JsonProperty("PendingAtUser")
    private Integer pendingAtUser;

    @JsonProperty("PendingatDepartmentWithinSLA")
    private Integer pendingatDepartmentWithinSLA;
    
    @JsonProperty("PendingatDepartmentAfterSLA")
    private Integer pendingatDepartmentAfterSLA;

    @JsonProperty("NotOnTimeDelivery")
    private Integer notOnTimeDelivery;

    @JsonProperty("PaymentMode")
    private String paymentMode;
    
    @JsonProperty("ApplicationSource")
    private String applicationSource;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getService() {
		return service;
	}

	public void setService(Integer service) {
		this.service = service;
	}

	public Integer getDivision() {
		return division;
	}

	public void setDivision(Integer division) {
		this.division = division;
	}

	public Integer getDistrict() {
		return district;
	}

	public void setDistrict(Integer district) {
		this.district = district;
	}

	public Integer getTaluka() {
		return taluka;
	}

	public void setTaluka(Integer taluka) {
		this.taluka = taluka;
	}

	public Integer getApproved() {
		return approved;
	}

	public void setApproved(Integer approved) {
		this.approved = approved;
	}

	public Integer getRejected() {
		return rejected;
	}

	public void setRejected(Integer rejected) {
		this.rejected = rejected;
	}

	public Integer getOnTimeDelivery() {
		return onTimeDelivery;
	}

	public void setOnTimeDelivery(Integer onTimeDelivery) {
		this.onTimeDelivery = onTimeDelivery;
	}

	public Integer getPendingAtUser() {
		return pendingAtUser;
	}

	public void setPendingAtUser(Integer pendingAtUser) {
		this.pendingAtUser = pendingAtUser;
	}

	public Integer getPendingatDepartmentWithinSLA() {
		return pendingatDepartmentWithinSLA;
	}

	public void setPendingatDepartmentWithinSLA(Integer pendingatDepartmentWithinSLA) {
		this.pendingatDepartmentWithinSLA = pendingatDepartmentWithinSLA;
	}

	public Integer getPendingatDepartmentAfterSLA() {
		return pendingatDepartmentAfterSLA;
	}

	public void setPendingatDepartmentAfterSLA(Integer pendingatDepartmentAfterSLA) {
		this.pendingatDepartmentAfterSLA = pendingatDepartmentAfterSLA;
	}

	public Integer getNotOnTimeDelivery() {
		return notOnTimeDelivery;
	}

	public void setNotOnTimeDelivery(Integer notOnTimeDelivery) {
		this.notOnTimeDelivery = notOnTimeDelivery;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getApplicationSource() {
		return applicationSource;
	}

	public void setApplicationSource(String applicationSource) {
		this.applicationSource = applicationSource;
	}
    
    
    
    
    

    // getters & setters
    
    
}