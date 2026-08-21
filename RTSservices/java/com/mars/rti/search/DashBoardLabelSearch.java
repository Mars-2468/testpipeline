package com.mars.rti.search;

import com.mars.common.search.BaseSearchObject;

public class DashBoardLabelSearch extends BaseSearchObject {
	
	private String receiptSatus;
	private String registrationFromDate;
	private String registrationToDate;
	private String category;
	private String departments;
    private String services;
    private String currentYear;
    
    
	public String getCurrentYear() {
		return currentYear;
	}
	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}
	public String getDepartments() {
		return departments;
	}
	public String getServices() {
		return services;
	}
	public void setDepartments(String departments) {
		this.departments = departments;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getReceiptSatus() {
		return receiptSatus;
	}
	public void setReceiptSatus(String receiptSatus) {
		this.receiptSatus = receiptSatus;
		if(this.receiptSatus!=null && this.receiptSatus.length()>0){
			setSearchParamSet(true);
		}
	}
	public String getRegistrationFromDate() {
		return registrationFromDate;
	}
	public void setRegistrationFromDate(String registrationFromDate) {
		this.registrationFromDate = registrationFromDate;
		if(this.registrationFromDate!=null && this.registrationFromDate.length()>0){
			setSearchParamSet(true);
		}
	}
	public String getRegistrationToDate() {
		return registrationToDate;
	}
	public void setRegistrationToDate(String registrationToDate) {
		this.registrationToDate = registrationToDate;
		if(this.registrationToDate!=null && this.registrationToDate.length()>0){
			setSearchParamSet(true);
		}
		
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
		if(this.category!=null && this.category.length()>0){
			setSearchParamSet(true);
		}
	}
	
	

}
