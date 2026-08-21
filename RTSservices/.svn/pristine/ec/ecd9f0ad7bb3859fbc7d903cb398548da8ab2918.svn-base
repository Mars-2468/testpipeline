package com.mars.common.utils;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Set;

import javax.servlet.ServletException;
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
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.mars.common.model.User;
import com.mars.common.model.UserAttempts;
import com.mars.common.model.UserRole;
import com.mars.common.service.PermissionService;
import com.mars.common.service.UserAttemptsService;
import com.mars.common.service.UserService;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private static Log log = LogFactory.getLog(AuthenticationSuccessHandler.class);
	
	@Autowired
	private UserAttemptsService userAttemptsService;
	
	public void setUserAttemptsService(UserAttemptsService userAttemptsService) {
		this.userAttemptsService = userAttemptsService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication object) throws IOException, ServletException {
		SessionFactory sessionFactory = null;
		Session hibernateSession = null;
		if (log.isDebugEnabled()) {
			log.debug("Invoking onAuthenticationSuccess Method");
		}
		String mobileNo = request.getParameter("mobileNo");
		String optNo = request.getParameter("optNo");
		String userOtp = request.getParameter("userOtp");
		String userName = request.getParameter("j_username");
		String userPassword = request.getParameter("j_password");
		String resentotp = request.getParameter("resentotp");


		if(mobileNo!=null || optNo!=null || userOtp!=null || userName!=null || userPassword!=null){
		request.getSession().setAttribute("mobileNo", mobileNo);
		request.getSession().setAttribute("otp", optNo);
		request.getSession().setAttribute("userOtp", userOtp);
		request.getSession().setAttribute("userName", userName);
		request.getSession().setAttribute("userPassword", userPassword);
		request.getSession().setAttribute("resentotp",resentotp);
		}
		UserAttempts userAttemptsObj = null;
		try {
			HttpSession session = request.getSession();
			if (log.isDebugEnabled()) {
				log.debug("onAuthenticationSuccess() : Session is created");
			}
			ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
			VelocityEngine velocityEngine = (VelocityEngine) applicationContext.getBean("velocityEngine");
			PermissionService permissionService = (PermissionService) applicationContext.getBean("permissionService");
			UserService userService = (UserService) applicationContext.getBean("userService");
			sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
			hibernateSession = SessionFactoryUtils.getSession(sessionFactory, true);
			TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(hibernateSession));

			User user = userService.get(object.getName());
			SessionUser sessionUser = getSessionUserObject(user);
			Hashtable hstRolesPermissions = permissionService.getPermissionsByRoleIds(sessionUser.getRoleIds());
			//Storing in session for future use
			session.setAttribute("rolesPermissions", hstRolesPermissions);
			
			Hashtable hstContents = new Hashtable();
			hstContents.put("contextRoot", request.getContextPath());
			hstContents.put("rolesPermissions", hstRolesPermissions);
			userAttemptsObj = userAttemptsService.getByUserName(user.getUserName());
			if(userAttemptsObj!= null) {
				userAttemptsObj.setAttempts(1);
		        userAttemptsService.merge(userAttemptsObj);
			}
			
			//Added by balu for velocityTemplate
			SessionLocaleResolver localeResolver = (SessionLocaleResolver) applicationContext.getBean("localeResolver");
			Locale locale = localeResolver.resolveLocale(request);
			ReloadableResourceBundleMessageSource messageSource= (ReloadableResourceBundleMessageSource)applicationContext.getBean("messageSource");
			MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(messageSource,locale);
			hstContents.put("messageSource", messageSourceAccessor);

			String strContent = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "leftNavigation.vm", hstContents);
			session.setAttribute("SessionUser", sessionUser);
			session.setAttribute("leftNavigationContent", strContent);
			super.onAuthenticationSuccess(request, response, object);
		}  finally {
			TransactionSynchronizationManager.unbindResource(sessionFactory);
			SessionFactoryUtils.releaseSession(hibernateSession, sessionFactory);
			request.getSession().setAttribute("deptLogin", "deptLogin");
			if (log.isDebugEnabled()) {
				log.debug("onAuthenticationSuccess() : Session is relased");
			}
		}
	}

	private SessionUser getSessionUserObject(User user) {
		SessionUser sessionUser = new SessionUser();
		try {
			sessionUser.setUserId(user.getUserId());
			String strRoles = "";
			String strRoleNames = "";
			Set<UserRole> roleSet = user.getUserRoleSet();
			for (UserRole userRole : roleSet) {
				long roleId = userRole.getRole().getRoleId();
				String roleName = userRole.getRole().getRole_name();
				strRoles = strRoles.equalsIgnoreCase("") ? "" + roleId : strRoles + "," + roleId;
				strRoleNames = strRoleNames.equalsIgnoreCase("") ? "" + roleName : strRoleNames + "," + roleName;
			}

			sessionUser.setRoleIds(strRoles);
		    sessionUser.setUserName(user.getUserName());
		    sessionUser.setFirstName(user.getFirstName());
		    sessionUser.setLastName(user.getLastName());
		    sessionUser.setEmail(user.getEmail());
		    sessionUser.setDepartmentId(user.getDepartment().getDepartmentId());
		    sessionUser.setEmployeeId(user.getEmployeeId());
		    sessionUser.setRoleNames(strRoleNames);
		    
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return sessionUser;
	}
}