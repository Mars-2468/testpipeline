package com.mars.common.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.mars.common.model.User;
import com.mars.common.model.UserAttempts;
import com.mars.common.service.UserAttemptsService;
import com.mars.common.service.UserService;

public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Log log = LogFactory.getLog(AuthenticationFailureHandler.class);

	public String defaultFailureUrl = null;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserAttemptsService userAttemptsService;

	@Autowired
	private UserService userService;

	public void setUserAttemptsService(UserAttemptsService userAttemptsService) {
		this.userAttemptsService = userAttemptsService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

	public AuthenticationFailureHandler() {
		super();
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
	try {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		int attempts = 0;
		String userName = request.getParameter("j_username");
		String userPassword = request.getParameter("j_password");
		UserAttempts userAttemptsObj = null;
		if (userName != null) {
			User user = userService.get(userName);
			if (user != null) {
				userAttemptsObj = userAttemptsService.getByUserName(userName);
				if(userAttemptsObj!=null){
					attempts = userAttemptsObj.getAttempts();
				}else{
					UserAttempts ua = new UserAttempts();
					ua.setAttempts(1);
					ua.setUpdateTime(CommonUtils.getCurrentStringDateAndTime());
					ua.setUserName(user.getUserName());
					userAttemptsObj = userAttemptsService.merge(ua);
				}
				if (userAttemptsObj != null) {
					long time = getDiffTime(dateFormat.format(date), userAttemptsObj.getUpdateTime(), dateFormat);
					
					    if (time > 10 && attempts==4) {
					        user.setStatus(Constants.ACTIVE);
					        userService.merge(user);
					        userAttemptsObj.setUpdateTime(dateFormat.format(date));
					        userAttemptsObj.setAttempts(1);
					        userAttemptsService.merge(userAttemptsObj);
					        defaultFailureUrl = "/login.do?login_error=true&message=5";
					        setDefaultFailureUrl(defaultFailureUrl);
					        this.getRedirectStrategy().sendRedirect(request, response, defaultFailureUrl);
					       
					    
					} else {
						if (attempts < 4) {
							attempts = attempts + 1;
							userAttemptsObj.setAttempts(attempts);
							userAttemptsObj.setUpdateTime(dateFormat.format(date));
							userAttemptsService.merge(userAttemptsObj);
							defaultFailureUrl = "/login.do?login_error=true&message=2";
							setDefaultFailureUrl(defaultFailureUrl);
							this.getRedirectStrategy().sendRedirect(request, response, defaultFailureUrl);
						} else {
							if (user != null) {
								if (user.getStatus() != Constants.INACTIVE) {
									user.setStatus(Constants.INACTIVE);
									userService.merge(user);
								}
								defaultFailureUrl = "/login.do?login_error=true&&message=3";
								setDefaultFailureUrl(defaultFailureUrl);
								this.getRedirectStrategy().sendRedirect(request, response, defaultFailureUrl);
							}
						}
					}
				} else {
					attempts = attempts + 1;
					userAttemptsObj = new UserAttempts();
					userAttemptsObj.setUserName(userName);
					userAttemptsObj.setAttempts(attempts);
					userAttemptsObj.setUpdateTime(dateFormat.format(date));
					userAttemptsService.save(userAttemptsObj);
					defaultFailureUrl = "/login.do?login_error=true&&message=1";
					setDefaultFailureUrl(defaultFailureUrl);
					this.getRedirectStrategy().sendRedirect(request, response, defaultFailureUrl);
				}
			} else {
				defaultFailureUrl = "/login.do?login_error=true&&message=4";
				setDefaultFailureUrl(defaultFailureUrl);
				this.getRedirectStrategy().sendRedirect(request, response, defaultFailureUrl);
			}
		} else if (userName == null) {
			response.sendRedirect(request.getContextPath() + "/pages/common/exception.jsp");
		}
	} catch (Exception e) {
		e.printStackTrace();
		response.sendRedirect(request.getContextPath() + "/pages/common/exception.jsp");
	} finally {
		if (log.isDebugEnabled()) {
			log.debug("onAuthenticationFailure() : Session is relased");
		}
	}
}

	public long getDiffTime(String date2, String date1, DateFormat dateFormat) {

		Date d1 = null;
		Date d2 = null;
		try {
			d1 = dateFormat.parse(date1);
			d2 = dateFormat.parse(date2);

			// in milliseconds
			long diff = d2.getTime() - d1.getTime();
			long diffMinutes = diff / (60 * 1000) % 60;

			return diffMinutes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

}