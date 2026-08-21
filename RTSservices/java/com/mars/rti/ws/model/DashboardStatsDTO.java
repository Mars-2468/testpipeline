package com.mars.rti.ws.model;

public class DashboardStatsDTO {
    private double totalApplications;
    private double totalCost;
    private double completedApplications;
    private double completionPercentage;
    private String department;
    private String startDate;
    private String endDate;

    // response metadata
    private int responseCode;
    private String status;
    private String response;

    // getters & setters
  
    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

 
    public double getCompletionPercentage() { return completionPercentage; }
    public void setCompletionPercentage(double completionPercentage) { this.completionPercentage = completionPercentage; }

    public int getResponseCode() { return responseCode; }
    public void setResponseCode(int responseCode) { this.responseCode = responseCode; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public double getTotalApplications() {
		return totalApplications;
	}
	public void setTotalApplications(double totalApplications) {
		this.totalApplications = totalApplications;
	}
	public double getCompletedApplications() {
		return completedApplications;
	}
	public void setCompletedApplications(double completedApplications) {
		this.completedApplications = completedApplications;
	}
	
	
    
    
}
