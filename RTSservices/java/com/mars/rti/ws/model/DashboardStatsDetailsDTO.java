package com.mars.rti.ws.model;

public class DashboardStatsDetailsDTO {
	  private String department;
	    private String serviceName;
	    private int serviceId;

	    private double applicationsReceived;
	    private double applicationsInProgress;
	    private double applicationsPendingForPayment;
	    private double applicationsPaymentCompleted;
	    private double applicationsCompleted;
	    private double applicationsRejected;
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getServiceName() {
			return serviceName;
		}
		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}
		public int getServiceId() {
			return serviceId;
		}
		public void setServiceId(int serviceId) {
			this.serviceId = serviceId;
		}
		public double getApplicationsReceived() {
			return applicationsReceived;
		}
		public void setApplicationsReceived(double applicationsReceived) {
			this.applicationsReceived = applicationsReceived;
		}
		public double getApplicationsInProgress() {
			return applicationsInProgress;
		}
		public void setApplicationsInProgress(double applicationsInProgress) {
			this.applicationsInProgress = applicationsInProgress;
		}
		public double getApplicationsPendingForPayment() {
			return applicationsPendingForPayment;
		}
		public void setApplicationsPendingForPayment(double applicationsPendingForPayment) {
			this.applicationsPendingForPayment = applicationsPendingForPayment;
		}
		public double getApplicationsPaymentCompleted() {
			return applicationsPaymentCompleted;
		}
		public void setApplicationsPaymentCompleted(double applicationsPaymentCompleted) {
			this.applicationsPaymentCompleted = applicationsPaymentCompleted;
		}
		public double getApplicationsCompleted() {
			return applicationsCompleted;
		}
		public void setApplicationsCompleted(double applicationsCompleted) {
			this.applicationsCompleted = applicationsCompleted;
		}
		public double getApplicationsRejected() {
			return applicationsRejected;
		}
		public void setApplicationsRejected(double applicationsRejected) {
			this.applicationsRejected = applicationsRejected;
		}
	    
	    
	   
}
