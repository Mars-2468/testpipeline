package com.mars.common.controller;

import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendSMS;
import com.mars.rti.controller.OccupancyCertificateController;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NMCUserSignUpController {
   private static Log log = LogFactory.getLog(OccupancyCertificateController.class);
   int number = 0;
   @Autowired
   private UserRegistrationService userService;

   @RequestMapping({"ws/user/registration.do"})
   public ModelAndView newRTIZoneApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      ModelAndView modelAndView = new ModelAndView("userRegistration11");
      return modelAndView;
   }

   @RequestMapping({"/nmc/user/registration.do"})
   public ModelAndView userSignIn(HttpServletRequest request, HttpServletResponse response, UserRegistrationDetails user) throws ServletException, IOException {
      UserRegistrationDetails user1 = null;
      UserRegistrationDetails user2 = null;
      this.number = ThreadLocalRandom.current().nextInt(100000, 1000000);
      String email = request.getParameter("email");
      String mobileNo = request.getParameter("mobileNo");
      String fname = request.getParameter("firstName");
      String lname = request.getParameter("lastName");
      //String msg = "One Time Password (OTP) for NMC application logging is " + this.number + " Please use this OTP for logging NMCGov. Pls do not share this with any one, Valid for 5 minutes.";
      String msg= "One Time Password (OTP) for NMC application logging is "+this.number+" Please use this OTP for logging NMCGov. Pls do not share this with any one, Valid for 5 minutes.";
      msg.replace("var3", "");
      if (log.isDebugEnabled()) {
         log.debug("Invoking UserRegistration" + fname + " " + lname);
         log.debug(user.getEmail());
      }

      user1 = this.userService.getUser(email);
      user2 = this.userService.getUserByMobileNo(mobileNo);
      ModelAndView modelAndView;
      if (user1 == null && user2 == null) {
         SendSMS.sendSingleSMS("nmcgov", "1707170780475551415", "NMCGOV", mobileNo, msg);
         modelAndView = new ModelAndView("userRegistration11");
         request.setAttribute("response", "successful");
         request.setAttribute("mobileNo", mobileNo);
         request.setAttribute("email", email);
         request.setAttribute("firstName", fname);
         request.setAttribute("lastName", lname);
         return modelAndView;
      } else {
         modelAndView = new ModelAndView("userRegistration11");
         request.setAttribute("status", 301);
         modelAndView.addObject("msg", "User already exist please login");
         return modelAndView;
      }
   }

   @RequestMapping({"/nmc/user/home.do"})
   public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response, UserRegistrationDetails user) throws ServletException, IOException {
      if (log.isDebugEnabled()) {
         log.debug("Invoking otp seccssioonn jghfddghfgfg");
      }

      int otp = Integer.parseInt(request.getParameter("otp"));
      String fname = user.getFirstName();
      String lname = user.getLastName();
      String mobileNo = user.getMobileNo();
      String email = user.getEmail();
      if (this.number == otp) {
         HttpSession session = request.getSession();
         session.setAttribute("uname", user);
         session.setAttribute("name", fname + " " + lname);
         session.setAttribute("mobileNo", mobileNo);
         session.setAttribute("email", email);
         user.setCreatedDate(CommonUtils.getCurrentStringDate());
         this.userService.save(user);
         ModelAndView modelAndView = new ModelAndView("redirect:/ws/nmc/user/dashboard.do");
         modelAndView.addObject("result", "Data successfully saved");
         return modelAndView;
      } else {
         ModelAndView modelAndView = new ModelAndView("userRegistration11");
         request.setAttribute("status", 301);
         request.setAttribute("mobileNo", mobileNo);
         request.setAttribute("email", email);
         request.setAttribute("firstName", fname);
         request.setAttribute("lastName", lname);
         request.setAttribute("msg", "Please enter valid otp");
         return modelAndView;
      }
   }
}

