package com.mars.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.mars.common.model.Role;
import com.mars.common.model.Tenancy;
import com.mars.common.model.User;
import com.mars.common.service.PermissionService;
import com.mars.common.service.RoleService;
import com.mars.common.service.TenancyService;
import com.mars.common.service.UserService;



public class AuthenticationTokenProcessingFilter extends GenericFilterBean {
	private static Log log = LogFactory.getLog(AuthenticationSuccessHandler.class);
	
	@Autowired
	AuthenticationManager authenticationManager;
	
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

    
        @SuppressWarnings("unchecked")
        
        Map<String, String[]> parms = request.getParameterMap();
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpSession session = httpServletRequest.getSession();
        SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
        if(session!=null && (session.getAttribute("Token")==null || sessionUser== null)){
        RestTemplate restTemplate = new RestTemplate();
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
		HttpHeaders headers = new HttpHeaders();
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		UserService userService = (UserService) applicationContext.getBean("userService");
		TenancyService tenancyService = (TenancyService) applicationContext.getBean("tenancyService");
		headers.setAccept(acceptableMediaTypes);
		String servResult="";
		HttpServletResponse servletResponse;
		if(parms != null && parms.get("userdetails")!=null && parms.get("userdetails").length > 0){
			// Send the request as POST
			servResult = restTemplate.getForObject("http://sso.rajasthan.gov.in:8888/SSOREST/GetTokenDetail/"+parms.get("userdetails")[0],String.class);
			session.setAttribute("userdetails", parms.get("userdetails")[0]);
			if(parms != null && parms.get("Establishmentname")!=null && parms.get("Establishmentname").length > 0)
				session.setAttribute("Establishmentname", parms.get("Establishmentname")[0]);
			if(parms != null && parms.get("CategoryofEstablishment")!=null && parms.get("CategoryofEstablishment").length > 0)
				session.setAttribute("CategoryofEstablishment", parms.get("CategoryofEstablishment")[0]);
			if(parms != null && parms.get("Mobile")!=null && parms.get("Mobile").length > 0)
				session.setAttribute("Mobile", parms.get("Mobile")[0]);
			if(parms != null && parms.get("Email")!=null && parms.get("Email").length > 0)
				session.setAttribute("Email", parms.get("Email")[0]);
			if(parms != null && parms.get("PlotNo")!=null && parms.get("PlotNo").length > 0)
				session.setAttribute("PlotNo", parms.get("PlotNo")[0]);
			if(parms != null && parms.get("Street")!=null && parms.get("Street").length > 0)
				session.setAttribute("Street", parms.get("Street")[0]);
			if(parms != null && parms.get("Area")!=null && parms.get("Area").length > 0)
				session.setAttribute("Area", parms.get("Area")[0]);
			if(parms != null && parms.get("City")!=null && parms.get("City").length > 0)
				session.setAttribute("City", parms.get("City")[0]);
			if(parms != null && parms.get("Tehsil")!=null && parms.get("Tehsil").length > 0)
				session.setAttribute("Tehsil", parms.get("Tehsil")[0]);
			//setting tenancyName in session
			if(parms != null && parms.get("District")!=null && parms.get("District").length > 0){
				session.setAttribute("District", parms.get("District")[0]);
				session.setAttribute("ssoTenancyName", parms.get("District")[0]);
				session.setAttribute("loginTenencyName", parms.get("District")[0]);
				if(parms.get("District")!=null && parms.get("District").length > 0 && parms.get("District")[0]!="NA")
					session.setAttribute("loginTenencyId", tenancyService.getTenancyId(parms.get("District")[0]));
				session.setAttribute("loginTenencyId", tenancyService.getTenancyId(parms.get("District")[0]));
			}
			if(parms != null && parms.get("SWSID")!=null && parms.get("SWSID").length > 0)
				session.setAttribute("SWSID", parms.get("SWSID")[0]);
			if(parms != null && parms.get("ActID")!=null && parms.get("ActID").length > 0)
				session.setAttribute("ActID", parms.get("ActID")[0]);
			if(parms != null && parms.get("ActivityID")!=null && parms.get("ActivityID").length > 0)
				session.setAttribute("ActivityID", parms.get("ActivityID")[0]);
			if(parms != null && parms.get("IsNew")!=null && parms.get("IsNew").length > 0)
				session.setAttribute("IsNew", parms.get("IsNew")[0]);
			if(parms != null && parms.get("RegNo")!=null && parms.get("RegNo").length > 0)
				session.setAttribute("RegNo", parms.get("RegNo")[0]);
			if(parms != null && parms.get("STDCode")!=null && parms.get("STDCode").length > 0)
				session.setAttribute("STDCode", parms.get("STDCode")[0]);
			if(parms != null && parms.get("Primary Group")!=null && parms.get("Primary Group").length > 0)
				session.setAttribute("Primary Group", parms.get("Primary Group")[0]);
			if(parms != null && parms.get("BRN")!=null && parms.get("BRN").length > 0)
				session.setAttribute("BRN", parms.get("BRN")[0]);
			if(parms != null && parms.get("PAN")!=null && parms.get("PAN").length > 0)
				session.setAttribute("PAN", parms.get("PAN")[0]);
			if(parms != null && parms.get("TIN")!=null && parms.get("TIN").length > 0)
				session.setAttribute("TIN", parms.get("TIN")[0]);
			if(parms != null && parms.get("VAT")!=null && parms.get("VAT").length > 0)
				session.setAttribute("VAT", parms.get("VAT")[0]);		
		}		
		else if(parms.get("userId")!=null && parms.get("selectedTenancyId")!=null && parms.get("appId")!=null){
		if(Long.parseLong(parms.get("selectedTenancyId")[0]) > 0){
			// condition for portal login
			SessionFactory sessionFactory = null;
    		Session hibernateSession = null;
    		if (log.isDebugEnabled()) {
    			log.debug("Invoking onAuthenticationSuccess Method");
    		}
			sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
			hibernateSession = SessionFactoryUtils.getSession(sessionFactory, true);
			TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(hibernateSession));
			if(sessionUser == null)
				 sessionUser = new SessionUser();
			//To map with egovcommon Users
			try{
			List<User> userList = null; 
			String sqlQuery = "select * from egovcommon.users users  where users.user_id = "+Long.parseLong(parms.get("userId")[0]);
			userList = userService.getEntityListBySQLQuery(sqlQuery, null);
			User user = new User();
			for(User userObj : userList){
				user = userObj;
			}
			
			Tenancy tenancy = null;
			Tenancy tenancy1 = null;
			if (user != null){
				sessionUser.setUserName(user.getUserName());
				sessionUser.setUserId(user.getUserId());
				sessionUser.setTenancyId(Long.parseLong(parms.get("selectedTenancyId")[0]));
				tenancy = tenancyService.get(Long.parseLong(parms.get("selectedTenancyId")[0]));
				/*if(user.getMobileNumber() != null){
					sessionUser.setMobileNumber(user.getMobileNumber());
				}*/
				
			}
			if(tenancy.getName() != null){
				sessionUser.setTenancyName(tenancy.getName());		
			}
			if(tenancy.getMunicipalName() != null){
				sessionUser.setMunicipalName(tenancy.getMunicipalName());
			}
			session.setAttribute("loginTenencyId", tenancy.getTenancyId());
			session.setAttribute("loginTenencyName", tenancy.getName());
			session.setAttribute("tenancyName", tenancy.getName());
			session.setAttribute("ApplnFilledStatus", "Portal");
			session.setAttribute("appId", parms.get("appId")[0].toString());
			session.setAttribute("contextRootPortal", httpServletRequest.getContextPath()+"/smartrajportal/");
			String redirectionUrlToPortal = ((HttpServletRequest) request).getHeader("referer");
			System.out.println("redirectionUrlToPortal---"+redirectionUrlToPortal);
			session.setAttribute("SessionUser", sessionUser);
			session.setAttribute("redirectionUrlToPortal",redirectionUrlToPortal);
			TransactionSynchronizationManager.unbindResource(sessionFactory);
			SessionFactoryUtils.releaseSession(hibernateSession, sessionFactory);
			}
			catch(Exception e){
				PrintWriter pw = new PrintWriter(new File("/root/Desktop/TokenExceptionTxt.txt"));
				  e.printStackTrace(pw);
				  pw.close();
			}
			
		}
		}
    	System.out.println(" Token Number = " + servResult);
    	
        
        if (servResult!=null && !servResult.isEmpty()) {
        	session.setAttribute("Token", parms.get("userdetails")[0]);
        	SessionFactory sessionFactory = null;
    		Session hibernateSession = null;
    		if (log.isDebugEnabled()) {
    			log.debug("Invoking onAuthenticationSuccess Method");
    		}
    		
    		try {
    		
    			if (log.isDebugEnabled()) {
    				log.debug("onAuthenticationSuccess() : Session is created");
    			}
    			VelocityEngine velocityEngine = (VelocityEngine) applicationContext.getBean("velocityEngine");
    			PermissionService permissionService = (PermissionService) applicationContext.getBean("permissionService");
    			sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
    			hibernateSession = SessionFactoryUtils.getSession(sessionFactory, true);
    			TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(hibernateSession));
    		
    			try {
					sessionUser = getSessionUserObject(request, response, servResult);
				} catch (Exception e) {
					PrintWriter pw = new PrintWriter(new File("/root/Desktop/TokenExceptionTxt2.txt"));
					  e.printStackTrace(pw);
					  pw.close();
					e.printStackTrace();
				}
    			/*if(session.getAttribute("loginTenencyId") != null)
    				sessionUser.setTenancyId(Long.parseLong(session.getAttribute("loginTenencyId").toString()));
    			session.setAttribute("ApplnFilledStatus", "SSO");*/
    			//Hashtable hstRolesPermissions = permissionService.getPermissionsByRoleIds("850");
    			Hashtable hstRolesPermissions = permissionService.getPermissionsByRoleNames("CITIZEN");
    			//Storing in session for future use
    				session.setAttribute("rolesPermissions", hstRolesPermissions);
    			
    			Hashtable hstContents = new Hashtable();
    			hstContents.put("contextRoot", httpServletRequest.getContextPath());
    			hstContents.put("rolesPermissions", hstRolesPermissions);
    		
    			
    			//Added by balu for velocityTemplate
    			SessionLocaleResolver localeResolver = (SessionLocaleResolver) applicationContext.getBean("localeResolver");
    			Locale locale = localeResolver.resolveLocale(httpServletRequest);
    			ReloadableResourceBundleMessageSource messageSource= (ReloadableResourceBundleMessageSource)applicationContext.getBean("messageSource");
    			MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(messageSource);
    			hstContents.put("messageSource", messageSourceAccessor);

    			String strContent = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "leftNavigation.vm", hstContents);
    			session.setAttribute("SessionUser", sessionUser);
    			session.setAttribute("leftNavigationContent", strContent);
    		//	super.onAuthenticationSuccess(request, response, object);
    		} finally {
    			TransactionSynchronizationManager.unbindResource(sessionFactory);
    			SessionFactoryUtils.releaseSession(hibernateSession, sessionFactory);
    			if (log.isDebugEnabled()) {
    				log.debug("onAuthenticationSuccess() : Session is relased");
    			}
    		}
    		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_CITIZEN"));
    		HttpServletResponse httpServletResponse=    	(HttpServletResponse)response;
        	//httpServletResponse.sendRedirect("workflow/listTasks.do");
        	UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("Sandesh.salunkhe", "mh432256");
            token.setDetails(new WebAuthenticationDetails((HttpServletRequest) request));
            Authentication authentication = new UsernamePasswordAuthenticationToken("Sandesh.salunkhe", "mh432256", authorities); //this.authenticationProvider.authenticate(token);
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
		
        } else {
        	
            System.out.println("no token found");
        }
        
        // continue thru the filter chain
       
        }else{
        	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_CITIZEN"));
        	UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("Sandesh.salunkhe", "mh432256");
            token.setDetails(new WebAuthenticationDetails((HttpServletRequest) request));
            Authentication authentication = new UsernamePasswordAuthenticationToken("Sandesh.salunkhe", "mh432256", authorities); //this.authenticationProvider.authenticate(token);
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
        	HttpServletResponse httpServletResponse= 	(HttpServletResponse)response;
        	//httpServletResponse.sendRedirect("workflow/listTasks.do");
        }
        
        chain.doFilter(request, response);
    }
    private SessionUser getSessionUserObject(ServletRequest request, ServletResponse response, String servResult) throws Exception {
		SessionUser sessionUser = new SessionUser();
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		RoleService roleService = (RoleService) applicationContext.getBean("roleService");
		//Sample code for display Name

		//String userNameRes = restTemplate.getForObject("http://ssotest.rajasthan.gov.in:8888/SSOREST/GetUserDetail/"+parms.get("userdetails")[0]+"/smartraj.Test/Test@123", String.class);

		try {
			
			String strRoles = "";
			String strRoleNames = "";
			HashMap<String, String> map = new HashMap<String, String>();
			String[] elements = servResult.split(";");
			 for(String s1: elements) {
			     String[] keyValue = s1.split("=");
			     map.put(keyValue[0], keyValue[1]);
			 }
			 if(map.size() > 0){
				 String userName = map.get("sAMAccountName");
				 sessionUser.setUserName(userName);
				 if(userName.contains(".")){
				 String[] userNames = userName.split(".");
				 if(userNames!=null && userNames.length>0){
					 if(userName.contains(".")){
						 StringTokenizer st = new StringTokenizer(userName,".");
						 sessionUser.setFirstName(st.nextToken());
						 sessionUser.setLastName(st.nextToken());
					 }
				 }
				 }
				 else
				 {
					 sessionUser.setFirstName(userName);
					 sessionUser.setLastName(" ");
				 }
				 sessionUser.setRoleNames(map.get("Role"));
				 
				 //sessionUser.setRoleNames("CITIZEN");
			 }
			 Role role = roleService.getByRoleName(sessionUser.getRoleNames().replace("|", ""));
			 sessionUser.setRoleIds(""+role.getRoleId());
			
		} catch(Exception e){
			PrintWriter pw = new PrintWriter(new File("/root/Desktop/TokenExceptionTxt1.txt"));
			  e.printStackTrace(pw);
			  pw.close();
		}
		return sessionUser;
	}
   
}
