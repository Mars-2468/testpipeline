package com.mars.rti.model;
import com.mars.rti.model.RTIApplication;

public class FireApplicationDTO {

    private RTIApplication application;
    private String applicationStatus;

    public RTIApplication getApplication() {
        return application;
    }

    public void setApplication(RTIApplication application) {
        this.application = application;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    
}