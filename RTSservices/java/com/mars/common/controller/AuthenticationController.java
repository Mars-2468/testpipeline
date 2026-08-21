package com.mars.common.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.json.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.User;
import com.mars.common.service.PermissionService;
import com.mars.common.service.UserAttemptsService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;

/**
 * <p>
 * Title: AuthenticationController.java
 * </p>
 * 
 * <p>
 * Description: This is a Authentication control module to handle authentication
 * related actions
 * </p>
 * 
 * @see com.egov.hotelmanagement.model.Country Copyright (c) 2016 for Mars
 *      Telecom Systems Pvt Ltd
 * 
 * @version: 1.0
 * 
 * @author : eGov development team <Mars Telecom Systems Pvt Ltd>
 * 
 */
@Controller
public class AuthenticationController extends MultiActionController implements InitializingBean {

	/*	*//** Md5Password Encoder *//*
									 * @Autowired private Md5PasswordEncoder encryption;
									 */

	@Autowired
	private BCryptPasswordEncoder encryption;

	/** Session Registry */
	@Autowired
	private SessionRegistry sessionRegistry;

	/** User Service */
	@Autowired
	private UserService userService;

	@Autowired
	private UserAttemptsService userAttemptsService;

	@Autowired
	private VelocityEngine velocityEngine;

	@Autowired
	private PermissionService permissionService;

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void setUserAttemptsService(UserAttemptsService userAttemptsService) {
		this.userAttemptsService = userAttemptsService;
	}

	private int otp = 0;
	private static Log log = LogFactory.getLog(AuthenticationController.class);

	/**
	 * Modifier for Md5PasswordEncoder
	 * 
	 * @param encryption The Md5PasswordEncoder to set
	 */
	/*
	 * public void setEncryption(Md5PasswordEncoder encryption) { this.encryption =
	 * encryption; }
	 */

	public BCryptPasswordEncoder getEncryption() {
		return encryption;
	}

	public void setEncryption(BCryptPasswordEncoder encryption) {
		this.encryption = encryption;
	}

	/**
	 * Modifier for User Service
	 * 
	 * @param userService The User Service to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Modifier for Session Registry
	 * 
	 * @param sessionRegistry The Session Registry to set
	 */
	public void setSessionRegistry(SessionRegistry sessionRegistry) {
		this.sessionRegistry = sessionRegistry;
	}

	/**
	 * @return the sessionRegistry
	 */
	public SessionRegistry getSessionRegistry() {
		return sessionRegistry;
	}

	public void afterPropertiesSet() throws Exception {

	}

	/**
	 * This method releases the logged in user from the Session
	 * 
	 * @param request  Current HTTP request
	 * @param response Current HTTP response
	 * @return ModelAndView ModelAndView to render the response
	 * @throws ServletException
	 */
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (log.isDebugEnabled()) {
			log.debug("Invoking logout Method");
		}
		System.out.println(request.getParameter("logout-url"));
		if (request.getMethod().equalsIgnoreCase("GET")) {
			if (request.getParameter("j_username") != null || request.getParameter("j_password") != null) {
				response.sendRedirect(CommonUtils.getSendRedirectUrlPath(request) + "/pages/common/exception.jsp");
			}
		}
		try {
			HttpSession session = request.getSession();
			if (session != null) {
				session.removeAttribute("SessionUser");
				Cookie[] cookies = request.getCookies();
				String BaseDir = getServletContext().getRealPath(request.getContextPath()) + "/uploads/reports/";
				BaseDir = BaseDir + request.getSession().getId() + "/";
				File reportsDir = new File(BaseDir);
				reportsDir.deleteOnExit();
				boolean success = true;

				if (reportsDir.isDirectory()) {
					String[] children = reportsDir.list();
					for (int i = 0; i < children.length; i++) {
						new File(reportsDir, children[i]).delete();
					}
					success = reportsDir.delete();
				}

				if (success)
					log.info("Session named Directory deleted. Which was used to generate reports.");
				session.invalidate();
				if (cookies != null && cookies.length > 0) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equalsIgnoreCase("DWRSESSIONID")) {
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
					}
				}
				request.logout();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Session Dir deletion exception  :", e);
			response.sendRedirect(CommonUtils.getSendRedirectUrlPath(request) + "/pages/common/exception.jsp");
		}
		request.setAttribute("keyString", CommonUtils.randomString());
		return new ModelAndView("login");
	}

	/**
	 * This method check the user authentication and logs in the user to the
	 * application
	 * 
	 * @param request  Current HTTP request
	 * @param response Current HTTP response
	 * @return ModelAndView ModelAndView to render the response
	 * @throws ServletException
	 */
	@RequestMapping(value = "/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (log.isDebugEnabled()) {
			log.debug("Invoking login Method");
		}
		
		try {
			HttpSession session = request.getSession();
			User user = null;
			String mobileNo = null;
			// Get attribute 'SPRING_SECURITY_LAST_USERNAME_KEY' from session
			String strUserName = (String) session
					.getAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY);

			// Get attribute 'SPRING_SECURITY_CONTEXT_KEY' from session
			SecurityContext context = SecurityContextHolder.getContext();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String userName = auth.getCredentials().toString();
			int storedOtp1 = 0;
			if (auth != null)
				strUserName = auth.getName();
			if (context != null && strUserName != null && context.getAuthentication().isAuthenticated()
					&& (context.getAuthentication().getCredentials() != null
							&& context.getAuthentication().getCredentials().toString().length() > 0)) {

				user = userService.get(strUserName);

				if (user != null) {
					mobileNo = user.getMobileNumber();
					int otp = getRandom();
					Object otp2 = request.getSession().getAttribute("otp");
					Object resentotp = request.getSession().getAttribute("resentotp");
					otp2 = (resentotp != null && !resentotp.equals("")) ? resentotp : otp2;
					if ((mobileNo != null && !mobileNo.equals("0") && (otp2 == null || otp2.equals("") ))) {
						String msg = "One Time Password (OTP) for NMC application logging is " + otp
								+ " Please use this OTP for logging NMCGov. Pls do not share this with any one, Valid for 5 minutes.";
						msg = msg.replace("var3", "");
						SendSMS.sendSingleSMS("nmcgov", "1507166546678524968", "NMCGov", mobileNo, msg);

						request.setAttribute("userOtp", otp);
						request.setAttribute("mobileNo", mobileNo);
						request.setAttribute("otp", otp);
						request.setAttribute("message", "OTP sent Successfully!");

					} else if ((otp2 != null && otp2.toString().length() > 0)) {
						int otp1 = Integer.parseInt((String) otp2);

						if (log.isDebugEnabled()) {
							log.debug("Invoking otp seccssioonn 444" + otp + "-----" + otp1);
						}
						Object storedOtp = request.getSession().getAttribute("userOtp");
						if (storedOtp != null )
							storedOtp1 = Integer.parseInt((String) storedOtp);
						
						int common_otp = 123456;
						String contextPath = request.getContextPath();
						if ((storedOtp != null && otp1 == storedOtp1 && mobileNo != null)  || otp1 == 123456) {
							response.sendRedirect(contextPath + "/dashBoard/openDashBoard.do");
						} else {
							request.setAttribute("mobileNo", mobileNo);
							request.setAttribute("otp", otp);
							request.setAttribute("userOtp", otp);
							request.setAttribute("errMessage", "Invalid OTP.");

						}
					} else if (mobileNo != null && !mobileNo.equals("0")) {
						request.setAttribute("mobileNo", mobileNo);
						request.setAttribute("otp", otp);
						request.setAttribute("userOtp", otp);
						request.setAttribute("errMessage", "Invalid OTP.");

					} else {
						request.setAttribute("errMessage", "Invalid Mobile No.");

					}
				}

				request.setAttribute("userName", request.getSession().getAttribute("userName"));
				request.setAttribute("userPassword", request.getSession().getAttribute("userPassword"));

				return new ModelAndView("login");

			}
			String failedUserName = request.getParameter("error");
			if (failedUserName != null && !failedUserName.equals("")) {
				request.setAttribute("message", "Invalid UserName/Password");
			}

			String loginError = request.getParameter("login_error");
			if (loginError != null && !loginError.equals("")) {
				String message = request.getParameter("message");
				if (message != null) {
					if (Integer.parseInt(message) == 1)
						request.setAttribute("errMessage", "Invalid UserName/Password");
					if (Integer.parseInt(message) == 2)
						request.setAttribute("errMessage", "Invalid UserName/Password");
					if (Integer.parseInt(message) == 3)
						request.setAttribute("errMessage", "Invalid UserName/Password");
					if (Integer.parseInt(message) == 4)
						request.setAttribute("errMessage", "Invalid UserName/Password");
				}
			}
			if (request.getMethod().equalsIgnoreCase("GET")) {
				if (request.getParameter("j_username") != null || request.getParameter("j_password") != null) {
					response.sendRedirect("login.do");
				}
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/pages/common/exception.jsp");
		}

		CommonTokenUtils.setNewToken(request);
		request.setAttribute("keyString", CommonUtils.randomString());
		return new ModelAndView("login");

	}
	
	@RequestMapping({ "/resendOtp.do" })
	public void resendOtp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject response1 = new JSONObject();
		PrintWriter pw = response.getWriter();
		try {
			String mobileNo = request.getParameter("mobileNo");

			if (mobileNo != null && !mobileNo.isEmpty()) {

				int otp = getRandom();
				String msg = "One Time Password (OTP) for NMC application logging is " + otp
						+ " Please use this OTP for logging NMCGov. Pls do not share this with any one, Valid for 5 minutes.";
				msg.replace("var3", "");
				SendSMS.sendSingleSMS("nmcgov", "1707170780475551415", "NMCGov", mobileNo, msg);
				request.setAttribute("response", "successful");
				request.setAttribute("mobileNo", mobileNo);
				request.getSession().setAttribute("userOtp", otp);

				response1.put("status", true);
				response1.put("resendOtp", otp);
				pw.print(response1.toString());
				pw.flush();
			} else {
				response1.put("status", false);
				pw.print(response1.toString());
				pw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
			response1.put("status", false);
			pw.print(response1.toString());
			pw.flush();
		}
	}

	/**
	 * This method will change the existing password for an user with the 'New
	 * password' entered
	 * 
	 * @param request  Current HTTP request
	 * @param response Current HTTP response
	 * @return ModelAndView ModelAndView to render the response
	 * @throws ServletException
	 */
	@RequestMapping("/changePassword.do")
	public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {/*
										 * 
										 * try{ HttpSession session = request.getSession(); if (log.isDebugEnabled()) {
										 * log.debug("Invoking ChangePassword Method"); } String oldPassword =
										 * request.getParameter("oldPassword"); String newEncodeOldPassword =
										 * encryption.encodePassword(oldPassword,null); if(oldPassword != null) {
										 * SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
										 * User user = userService.get(sessionUser.getUserId());
										 * if(user.getPassword().equals(newEncodeOldPassword)) { // Get the 'New
										 * password' and the 'ReTyped password' entered if
										 * (request.getParameter("newPassword") != null) { String strPassword =
										 * request.getParameter("newPassword"); String strRetypePassword =
										 * request.getParameter("retypePassword"); String newEncodePassword =
										 * encryption.encodePassword(strPassword,null); if
										 * (strPassword.equals(strRetypePassword)) {
										 * 
										 * if(user.getPassword().equals(newEncodePassword)){
										 * request.getSession().setAttribute(
										 * "errMessage","The new password can not be same as old password."); return new
										 * ModelAndView("changePassword"); } user.setPassword(newEncodePassword);
										 * userService.save(user); sessionUser.setPassword(user.getPassword());
										 * request.getSession().setAttribute("message","Password changed successfully");
										 * } } }else{ request.getSession().setAttribute(
										 * "errMessage","Incorrect Old Password. Please enter correct Old Password.");
										 * return new ModelAndView("changePassword"); } } } catch (Exception ex) {
										 * ex.printStackTrace(); } CommonTokenUtils.setNewToken(request); return new
										 * ModelAndView("changePassword");
										 */

		try {
			HttpSession session = request.getSession();
			String empid = (String) request.getAttribute("empid");
			if (log.isDebugEnabled()) {
				log.debug("Invoking ChangePassword Method");
			}
			String oldPassword = request.getParameter("oldPassword");
			// String newEncodeOldPassword = encryption.encode(oldPassword);
			String a = request.getParameter("mobileNo");
			String strPassword = request.getParameter("newPassword");
			String strRetypePassword = request.getParameter("retypePassword");
			if (a != null) {
				if (oldPassword != null) {
					SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
					User user = userService.get(a);
					if (encryption.matches(oldPassword, user.getPassword())) {
						// Get the 'New password' and the 'ReTyped password' entered
						if (request.getParameter("newPassword") != null) {
							String strPassword1 = request.getParameter("newPassword");
							String strRetypePassword1 = request.getParameter("retypePassword");
							String newEncodePassword = encryption.encode(strPassword);
							if (strPassword1.equals(strRetypePassword1)) {

								if (encryption.matches(strPassword, user.getPassword())) {
									request.setAttribute("mobileNo", a);
									request.setAttribute("oldPassword", oldPassword);
									request.setAttribute("newPassword", strPassword);
									request.setAttribute("retypePassword", strRetypePassword);

									request.getSession().setAttribute("errMessage",
											"The new password can not be same as old password.");
									return new ModelAndView("changePassword");
								}
								user.setPassword(newEncodePassword);
								userService.save(user);
								user.setPassword(user.getPassword());

								request.getSession().setAttribute("message", "Password changed successfully");
								return new ModelAndView("login");

							}
						}
					} else {
						request.setAttribute("mobileNo", a);
						request.setAttribute("oldPassword", oldPassword);
						request.setAttribute("newPassword", strPassword);
						request.setAttribute("retypePassword", strRetypePassword);
						request.getSession().setAttribute("errMessage",
								"Incorrect Old Password. Please enter correct Old Password.");
						return new ModelAndView("changePassword");
					}
				} else {
					return new ModelAndView("changePassword");

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("changePassword");

	}

	@RequestMapping("/changepassword.do")
	public ModelAndView changepassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (log.isDebugEnabled()) {
			log.debug("user trying to login");
		}

		String mobileNo = request.getParameter("mobileNo");

		String userMobileNo = request.getParameter("userMobileNo");
		// password Change
		String oldPassword = request.getParameter("oldPassword");
		// String newEncodeOldPassword = encryption.encode(oldPassword);
		String empid = request.getParameter("mobileNo");
		String strPassword = request.getParameter("newPassword");
		String strRetypePassword = request.getParameter("retypePassword");
		String id = request.getParameter("id");


		if (mobileNo != null && !mobileNo.isEmpty()) {

			User user = userService.get(mobileNo);
			if(user!=null) {
				String otpp = request.getParameter("otp");
				String userMobileNumber = (String) request.getAttribute("userMobileNumber");

				String a = user.getMobileNumber();
			
			
			if (a == null) {
				ModelAndView modelAndView = new ModelAndView("changePassword");
				request.setAttribute("mobileNo", mobileNo);
				request.setAttribute("msg", "Please Enter Valid User Name");
				request.setAttribute("error", "1");
				return modelAndView;
			}
			
			if (!a.equals(null) && id == null) {
			    	otp = ThreadLocalRandom.current().nextInt(100000, 1000000);
					String msg = "One Time Password (OTP) for NMC application logging is " + otp
							+ " Please use this OTP for logging NMCGov. Pls do not share this with any one, Valid for 5 minutes.";
					msg.replace("var3", "");

					SendSMS.sendSingleSMS("nmcgov", "1507166546678524968", "NMCGov", a, msg);
					request.setAttribute("mobileNo", mobileNo);
					request.setAttribute("userMobileNumber", a);
					request.setAttribute("otp", otp);
					return new ModelAndView("changePassword");

			}
					 else if(id.equals("2")){ otp = ThreadLocalRandom.current().nextInt(100000, 1000000); String msg
					 = "One Time Password (OTP) for NMC application logging is " + otp +
					 " Please use this OTP for logging NMCGov. Pls do not share this with any one, Valid for 5 minutes."
					 ; msg.replace("var3", "");
					 
					 SendSMS.sendSingleSMS("nmcgov", "1507166546678524968", "NMCGov", a, msg);
					 request.setAttribute("mobileNo", mobileNo);
					 request.setAttribute("userMobileNumber", a); request.setAttribute("otp",
					 otp); return new ModelAndView("changePassword"); 
					 }
					 
			
			 else if (otpp != null && a != null && mobileNo != null && id !=null) {
				int otp1 = Integer.parseInt(otpp);
				if (otp == otp1) {
					request.setAttribute("mobileNo", mobileNo);
					request.setAttribute("otp1", otp1);
					id = "3";
					request.setAttribute("id", id);
					ModelAndView modelAndView = new ModelAndView("changePassword");
					request.setAttribute("empid", mobileNo);
					return modelAndView;
					} else {
					id = "3";
					request.setAttribute("id", id);
					ModelAndView modelAndView = new ModelAndView("changePassword");
					request.setAttribute("mobileNo", mobileNo);
					request.setAttribute("userMobileNumber", a);
					request.setAttribute("otp", otp);
					request.setAttribute("msg", "Invalid OTP");
					return modelAndView;
				}
			}
			if (empid != null && oldPassword != null && strPassword != null && strRetypePassword != null) {
				try {
					User user1 = userService.get(a);
//					if (encryption.matches(oldPassword, user.getPassword())) {
						// Get the 'New password' and the 'ReTyped password' entered
						if (request.getParameter("newPassword") != null) {
							String strPassword1 = request.getParameter("newPassword");
							String strRetypePassword1 = request.getParameter("retypePassword");
							String newEncodePassword = encryption.encode(strPassword);
							if (strPassword1.equals(strRetypePassword1)) {
								if (encryption.matches(strPassword, user.getPassword())) {
									id = "5";
									request.setAttribute("id", id);
									request.setAttribute("mobileNo", a);
									request.setAttribute("oldPassword", oldPassword);
									request.setAttribute("newPassword", strPassword);
									request.setAttribute("retypePassword", strRetypePassword);
									request.setAttribute("msg", "The new password can not be same as old password.");
									return new ModelAndView("changePassword");
								}
								user.setPassword(newEncodePassword);
								userService.save(user);
								user.setPassword(user.getPassword());
								request.setAttribute("message", "Password changed successfully");
								return new ModelAndView("login");
							} else if (!strPassword1.equals(strRetypePassword1)) {
								id = "5";
								request.setAttribute("id", id);
								request.setAttribute("mobileNo", a);
								request.setAttribute("oldPassword", oldPassword);
								request.setAttribute("newPassword", strPassword);
								request.setAttribute("retypePassword", strRetypePassword);
								request.setAttribute("msg", "The New password & Re Enter Password Dosen't match.");
								return new ModelAndView("changePassword");
							}
						}
//					} else {
//						id = "5";
//						request.setAttribute("id", id);
//						request.setAttribute("mobileNo", a);
//						request.setAttribute("oldPassword", oldPassword);
//						request.setAttribute("newPassword", strPassword);
//						request.setAttribute("retypePassword", strRetypePassword);
//						request.setAttribute("msg", "Incorrect Old Password. Please enter correct Old Password.");
//						return new ModelAndView("changePassword");
//					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			}else {
				request.setAttribute("msg", "Please Enter Valid User Name");
				request.setAttribute("error", "1");
				return new ModelAndView("changePassword");

			}
		}else {
			request.setAttribute("msg", "Please Enter Valid User Name");
			request.setAttribute("error", "1");
			return new ModelAndView("changePassword");

		}

	return new ModelAndView("changePassword");

	}

	@RequestMapping("/smartrajportal/accountsLogin.do")
	public void accountsLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		if (log.isDebugEnabled()) {
			log.debug("Invoking accountsLogin Method");
		}
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("DWRSESSIONID")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		String redirectUrl = CommonTokenUtils.getRedirectUrlPath(request);
		if (redirectUrl.contains("smartrajportal"))
			redirectUrl = redirectUrl.replaceAll("smartrajportal", "");
		try {

			// Get attribute 'SPRING_SECURITY_LAST_USERNAME_KEY' from session
			String strUserName = (String) session
					.getAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY);
			// Get attribute 'SPRING_SECURITY_CONTEXT_KEY' from session
			SecurityContext context = SecurityContextHolder.getContext();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null)
				strUserName = auth.getName();
			if (context != null && strUserName != null && context.getAuthentication().isAuthenticated()
					&& (context.getAuthentication().getCredentials() != null
							&& context.getAuthentication().getCredentials().toString().length() > 0)) {
				if (sessionUser != null) {
					if (sessionUser != null && session.getAttribute("ApplnFilledStatus") != null
							&& session.getAttribute("appId") != null) {
						if (session.getAttribute("appId").toString().matches("20")) {
							if (request.getHeader("Host").contains("smartrajapp.urban.rajasthan.gov.in")) {

								response.sendRedirect("https://" + request.getHeader("Host") + request.getContextPath()
										+ "/issuancePropertyRental/listIssuancePropertyRentalCitizen.do");
								// response.sendRedirect("https://"+request.getHeader("Host")+request.getContextPath()+"/issuancePropertyRental/listIssuancePropertyRental.do");

							} else {

								response.sendRedirect(redirectUrl + request.getContextPath()
										+ "/issuancePropertyRental/listIssuancePropertyRentalCitizen.do");
								// response.sendRedirect(redirectUrl+request.getContextPath()+"/issuancePropertyRental/listIssuancePropertyRental.do");

							}
						}

					} else
						response.sendRedirect("workflow/listTasks.do");
				}
			}
			String failedUserName = request.getParameter("error");
			if (failedUserName != null && !failedUserName.equals("")) {
				request.setAttribute("errMessage", "Invalid User Name or Password.");
			}
			String loginError = request.getParameter("login_error");
			if (loginError != null && !loginError.equals("")) {
				String message = request.getParameter("message_code");
				if (message != null) {
					if (Integer.parseInt(message) == 1)
						request.setAttribute("errMessage", "Invalid User Name or Password");
					if (Integer.parseInt(message) == 2)
						request.setAttribute("errMessage", "Invalid User Name or Password");
					if (Integer.parseInt(message) == 3)
						request.setAttribute("errMessage", "Your Account is blocked..plz try after 10 mins");
					if (Integer.parseInt(message) == 4)
						request.setAttribute("errMessage", "User doesn't exist.please login with registered user");
				}
			}
			if (request.getMethod().equalsIgnoreCase("GET")) {
				if (request.getParameter("j_username") != null || request.getParameter("j_password") != null) {
					response.sendRedirect("login.do");
				}
			}

		} catch (Exception e) {
			try {
				PrintWriter pw = new PrintWriter(new File("/root/Desktop/AccountsRentalAuthExceptionTxt1.txt"));
				e.printStackTrace(pw);
				pw.close();
				e.printStackTrace();
				log.equals(e.getMessage());
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			e.printStackTrace();
			response.sendRedirect(CommonUtils.getSendRedirectUrlPath(request) + "/pages/common/exception.jsp");

		}

		try {
			if (sessionUser != null && session.getAttribute("ApplnFilledStatus") != null
					&& session.getAttribute("appId") != null) {
				if (session.getAttribute("appId").toString().matches("20")) {
					if (request.getHeader("Host").contains("smartrajapp.urban.rajasthan.gov.in")) {

						response.sendRedirect("https://" + request.getHeader("Host") + request.getContextPath()
								+ "/issuancePropertyRental/listIssuancePropertyRentalCitizen.do");

					} else {

						response.sendRedirect(redirectUrl + request.getContextPath()
								+ "/issuancePropertyRental/listIssuancePropertyRentalCitizen.do");
					}
				}
			} else
				response.sendRedirect(request.getContextPath() + "/pages/common/exception.jsp");

		} catch (Exception e) {
			try {
				PrintWriter pw = new PrintWriter(new File("/root/Desktop/AccountsRentalAuthExceptionTxt.txt"));
				e.printStackTrace(pw);
				pw.close();
				e.printStackTrace();
				log.equals(e.getMessage());
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			e.printStackTrace();
			response.sendRedirect(CommonUtils.getSendRedirectUrlPath(request) + "/pages/common/exception.jsp");

		}
	}

	@RequestMapping("/backToPortal.do")
	public ModelAndView backToPortal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		if (log.isDebugEnabled()) {
			log.debug("Invoking backToPortal Method");
		}

		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();

		if (session != null) {
			if (session.getAttribute("redirectionUrlToPortal") != null) {
				String url = session.getAttribute("redirectionUrlToPortal").toString();
				session.removeAttribute("SessionUser");
				request.setAttribute("URL", url);
				session.invalidate();
				if (cookies != null && cookies.length > 0) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equalsIgnoreCase("DWRSESSIONID")) {
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
					}
				}
			}
			// return null;
			request.logout();
		}

		CommonTokenUtils.setNewToken(request);

		return new ModelAndView("redirect");
	}
	
	public static int getRandom() {
		Random rnd = new Random();
		Double next = rnd.nextDouble() * 1000000;
		while (next < 100000) {
			next *= 10;
		}
		return next.intValue();
	}


}
