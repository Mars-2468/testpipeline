package com.mars.common.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.RTIApplicationService;

@Controller
public class NMCUserMyProfile {
	
	@Autowired
	public RTIApplicationService rtiApplicationService;
	
	@Autowired
	private UserRegistrationService userService;
	
	@RequestMapping("ws/dashboard/myprofile.do")
	public String myProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		HttpSession session = request.getSession();
		String name = (String) request.getSession().getAttribute("name");
		request.setAttribute("name", name);
		if (name == null) {
			session.removeAttribute("mobileNo");
			return "redirect:/ws/user/login.do";
		} else {
			return "userprofile";
		}
	}
	
	@RequestMapping("/ws/dashboard/myapplication.do")
	public ModelAndView myAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String mobileNumber ="";
		HttpSession session = request.getSession(true);
		String name = (String) request.getSession().getAttribute("name");
		request.setAttribute("name", name);
		mobileNumber= (String) session.getAttribute("mobileNo");
		List<RTIApplication> rtiApplicationList = new ArrayList<RTIApplication>();
		if (name == null) {
			session.removeAttribute("mobileNo");
			return new ModelAndView("redirect:/ws/user/login.do");
		} else if ((mobileNumber != null && mobileNumber.trim().length() > 0)) {
	        UserRegistrationDetails user=userService.getUserByMobileNo(mobileNumber); 
			List<RTIApplication> rtiApplicationList2 =rtiApplicationService.getMyApplicationDetails(user.getMobileNo());
			if (rtiApplicationList2 != null) {
				rtiApplicationList.addAll(rtiApplicationList2);
			}
		}		
		
		ModelAndView modelAndView = new ModelAndView("useraccount","rtiApplicationList", rtiApplicationList);
		return modelAndView;
	}
	
	
//	@RequestMapping("/ws/dashboard/myapplication.do")
//	public ModelAndView myAccount(HttpServletRequest request,
//	                              HttpServletResponse response) {
//
//	    HttpSession session = request.getSession(true);
//	    String name = (String) session.getAttribute("name");
//	    String mobileNumber = (String) session.getAttribute("mobileNo");
//
//	    if (name == null) {
//	        session.removeAttribute("mobileNo");
//	        return new ModelAndView("redirect:/ws/user/login.do");
//	    }
//
//	    List<RTIApplication> rtiApplicationList = new ArrayList<>();
//
//	    if (mobileNumber != null && mobileNumber.trim().length() > 0) {
//
//	        UserRegistrationDetails user =
//	                userService.getUserByMobileNo(mobileNumber);
//
//	        rtiApplicationList =
//	                rtiApplicationService.getMyApplicationDetails(user.getMobileNo());
//
//	        // 🔐 Generate token for each application
//	        for (RTIApplication app : rtiApplicationList) {
//
//	            String token = generateSecureToken(
//	                    app.getRtiApplicationId(),
//	                    app.getRtiserviceid(),
//	                    app.getMobileNumber()
//	            );
//
//	            app.setEncryptedToken(token);
//	        }
//	    }
//
//	    return new ModelAndView("useraccount",
//	            "rtiApplicationList",
//	            rtiApplicationList);
//	}
//	
	 private String generateSecureToken(long applicationId,
	           long serviceId,
	           String mobileNo) {

	String data = applicationId + "|" + serviceId + "|" + mobileNo;
	return Base64.getUrlEncoder().encodeToString(data.getBytes());
	}
	   
	
	
	
	
	
	
	
}
