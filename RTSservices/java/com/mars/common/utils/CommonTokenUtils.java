package com.mars.common.utils;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**

 * <p>Title: CommonUtils.java </p>
 
 * <p>Description: This class is a common utility functions</p>

 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd 

 * @version: 1.0

 * 
 
 */
public class CommonTokenUtils
{

	public static String TOKEN_KEY = Constants.SESSION_TOKEN_KEY;
	public static String TOKEN_VALUE = "";
	public static String UPLOAD_TOKEN_KEY = Constants.SESSION_UPLOAD_TOKEN_KEY;
	public static String UPLOAD_TOKEN_VALUE = "";
	
    private static synchronized boolean isTokenValid(HttpSession session,  String requestToken) throws Exception {

    	String sessionToken = (String)session.getAttribute(getTokenKey());
        if (requestToken == null) {
            // The hidden field wasn't provided
            throw new Exception("Missing synchronizer token in request");
        }
        if (sessionToken == null) {
            // The session has lost the token.
            throw new Exception("Missing synchronizer token in session");
        }
        if (sessionToken.equals(requestToken)) {
            // Accept the submission and increment the token so this form can't
            // be submitted again ...
        	TOKEN_VALUE=nextToken();
            session.setAttribute(getTokenKey(), TOKEN_VALUE);
            return true;
        }
        return false;
    }
    
    private static synchronized boolean isUploadTokenValid(HttpSession session,  String requestToken) throws Exception {

    	String sessionToken = (String)session.getAttribute(getUploadTokenKey());
        if (requestToken == null) {
            // The hidden field wasn't provided
            throw new Exception("Missing synchronizer token in request");
        }
        if (sessionToken == null) {
            // The session has lost the token.
            throw new Exception("Missing synchronizer token in session");
        }
        if (sessionToken.equals(requestToken)) {
            // Accept the submission and increment the token so this form can't
            // be submitted again ...
        	UPLOAD_TOKEN_VALUE=nextToken();
            session.setAttribute(getUploadTokenKey(), UPLOAD_TOKEN_VALUE);
            return true;
        }
        return false;
    }
    
    private static String nextToken() {
        long seed = System.currentTimeMillis(); 
        Random r = new Random();
        r.setSeed(seed);
        return Long.toString(seed) + Long.toString(Math.abs(r.nextLong()));
    }


    private static String getTokenKey() {
        return TOKEN_KEY;
    }
    
    private static String getUploadTokenKey() {
        return UPLOAD_TOKEN_KEY;
    }
    
    public static void setNewToken(HttpServletRequest request)
    {
    	  HttpSession session = request.getSession();
    	  TOKEN_VALUE=nextToken();
    	  session.setAttribute(getTokenKey(), TOKEN_VALUE);  
    }
    
    public static void setNewUploadToken(HttpServletRequest request)
    {
    	  HttpSession session = request.getSession();
    	  UPLOAD_TOKEN_VALUE=nextToken();
    	  session.setAttribute(getUploadTokenKey(), UPLOAD_TOKEN_VALUE);  
    }
    
    public static void setNewToken(HttpSession session)
    {
    	  TOKEN_VALUE=nextToken();
    	  session.setAttribute(getTokenKey(), TOKEN_VALUE);  
    }
    
   public static boolean allowFormSubmit(HttpServletRequest request)
    {
    	try {
    		HttpSession session = request.getSession();
    		String requestToken = request.getParameter(getTokenKey());
            	if(isTokenValid(session, requestToken))
            		return true;
            
    	
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;    	
    }
    
    public static boolean allowFormSubmit(HttpServletRequest request,Map<String, Object> mapRequestObjects )
    {
    	try {
    		HttpSession session = request.getSession();
    		String requestToken = mapRequestObjects.get("_synchronizerUploadToken").toString();

			if(isUploadTokenValid(session, requestToken))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;    	
    }
    
    
    public static boolean allowFormSubmit(HttpSession session, String requestToken)
    {
    	try {
			if(isTokenValid(session, requestToken))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;    	
    }
    
    public static String getRedirectUrlPath(HttpServletRequest request){
		  String urlPath = request.getRequestURL().toString();
		  urlPath = urlPath.substring(0,urlPath.indexOf(request.getRequestURI()));
			return urlPath;
	 }
    
    public static boolean allowFileUpload(HttpServletRequest request) throws Exception
    {
    		HttpSession session = request.getSession();
    		String requestToken = (String) session.getAttribute("manageUploadToken");
    		if(isManageUploadTokenValid(session, requestToken)){
    			return true;
    		}else
    			return false;    	
    }
    private static synchronized boolean isManageUploadTokenValid(HttpSession session,  String requestToken) throws Exception {

    	String sessionToken = (String)session.getAttribute(getTokenKey());
        if (requestToken == null) {
            // The hidden field wasn't provided
            throw new Exception("Missing synchronizer token in request");
        }
        if (sessionToken == null) {
            // The session has lost the token.
            throw new Exception("Missing synchronizer token in session");
        }
        if (sessionToken.equals(requestToken)) {
            return true;
        }
        return false;
    }
}
