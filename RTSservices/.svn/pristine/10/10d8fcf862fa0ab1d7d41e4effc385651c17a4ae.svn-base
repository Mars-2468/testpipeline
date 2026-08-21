package com.mars.common.utils;

import java.io.File;

import javax.servlet.http.HttpSessionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.web.session.HttpSessionEventPublisher;

public class SessionListener extends HttpSessionEventPublisher 
{
	
	private static Log log = LogFactory.getLog(SessionListener.class);
	
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		deleteFolders(event);
		super.sessionDestroyed(event);
	}
	
	private void deleteFolders(HttpSessionEvent event)
	{
		try {
			String strSessionId = event.getSession().getId();
			String BaseDir = "";
			if(event.getSession().getAttribute("contextRoot") != null)
    	  	 BaseDir = event.getSession().getServletContext().getRealPath(event.getSession().getAttribute("contextRoot").toString()) + "/uploads/reports/";
    	  	log.debug("SessionListener :: deleteFolders() :: Reports DIR Path = " + BaseDir);
    	  	if (BaseDir != null && BaseDir.length() > 0) {
				BaseDir = BaseDir + strSessionId + "/";
				log.debug("SessionListener :: deleteFolders() :: Reports DIR Path for this Session = " + BaseDir);
				File reportsDir = new File(BaseDir);
				boolean success = true;
		    	 if (reportsDir.isDirectory()) {
		             String[] children = reportsDir.list();
		             log.debug("SessionListener :: deleteFolders() :: It is a directory and no of files in it are = " + children.length);
		             for (int k=0; k<children.length; k++) {
		                new File(reportsDir, children[k]).delete();
		             }
		             success = reportsDir.delete();
		             log.debug("SessionListener :: deleteFolders() :: Report deletion status = " + success);
		             if(success) {
			    		 log.info("Session named Directory deleted. Which was used to generate reports. Session ID : " + strSessionId );
		             }
		    	 } else
		    		 log.debug( BaseDir + " is not a directory");
    		} else {
    			log.info("Directory is not found to delete for Session ID : " + strSessionId );
    		}
    			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Session Dir deletion exception  : ", e);
		}
	} //end of deleteFolders()
	
} //end of file
