package com.mars.common.controller;

import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.service.UserRegistrationService;
import com.mars.rti.model.Collection;
import com.mars.rti.model.FireRecommendation;
import com.mars.rti.model.GaneshMandapPermission;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.CollectionService;
import com.mars.rti.service.FireRecommendationService;
import com.mars.rti.service.GaneshMandapPermissionService;
import com.mars.rti.service.RTIApplicationService;


@Controller
public class NMCUserDashboard {
   @Autowired
   private CollectionService collectionService;
   @Autowired
   RTIApplicationService rtiApplicationService;
   @Autowired
   private GaneshMandapPermissionService ganeshMandapPermissionService;
   
   @Autowired
	private FireRecommendationService fireRecommendationService;

	@Autowired
	private UserRegistrationService userService;

   @RequestMapping({"ws/nmc/dashboard.do"})
   public String dashboardhome(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      HttpSession session = request.getSession();
      String name = (String)request.getSession().getAttribute("name");
      request.setAttribute("name", name);
      if (name == null) {
         session.removeAttribute("mobileNo");
         return "redirect:/ws/user/login.do";
      } else {
         return "citizendashboard";
      }
   }

   @RequestMapping({"ws/nmc/dashboard/estateDepartment.do"})
   public String esatDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      HttpSession session = request.getSession();
      String name = (String)request.getSession().getAttribute("name");
      request.setAttribute("name", name);
      if (name == null) {
         session.removeAttribute("mobileNo");
         return "redirect:/ws/user/login.do";
      } else {
         return "estatdepartment";
      }
   }

   @RequestMapping({"ws/nmc/dashboard/fireDepartment.do"})
   public String fireDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      HttpSession session = request.getSession();
      String name = (String)request.getSession().getAttribute("name");
      request.setAttribute("name", name);
      if (name == null) {
         session.removeAttribute("mobileNo");
         return "redirect:/ws/user/login.do";
      } else {
         return "firedepartment";
      }
   }

   @RequestMapping({"ws/nmc/dashboard/healthDepartment.do"})
   public String healthDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      HttpSession session = request.getSession();
      String name = (String)request.getSession().getAttribute("name");
      request.setAttribute("name", name);
      if (name == null) {
         session.removeAttribute("mobileNo");
         return "redirect:/ws/user/login.do";
      } else {
         return "healthdepartments";
      }
   }

   @RequestMapping({"ws/nmc/dashboard/marketDepartment.do"})
   public String marketDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      HttpSession session = request.getSession();
      String name = (String)request.getSession().getAttribute("name");
      request.setAttribute("name", name);
      if (name == null) {
         session.removeAttribute("mobileNo");
         return "redirect:/ws/user/login.do";
      } else {
         return "marketdepartment";
      }
   }

   @RequestMapping({"ws/nmc/dashboard/taxDepartment.do"})
   public String taxDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      HttpSession session = request.getSession();
      String name = (String)request.getSession().getAttribute("name");
      request.setAttribute("name", name);
      if (name == null) {
         session.removeAttribute("mobileNo");
         return "redirect:/ws/user/login.do";
      } else {
         return "taxdepartment";
      }
   }

   @RequestMapping({"ws/nmc/dashboard/townPlanningDepartment.do"})
   public String townPlanningDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      HttpSession session = request.getSession();
      String name = (String)request.getSession().getAttribute("name");
      request.setAttribute("name", name);
      if (name == null) {
         session.removeAttribute("mobileNo");
         return "redirect:/ws/user/login.do";
      } else {
         return "townplanning";
      }
   }

   @RequestMapping({"ws/nmc/dashboard/waterDepartment.do"})
   public String waterDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      HttpSession session = request.getSession();
      String name = (String)request.getSession().getAttribute("name");
      request.setAttribute("name", name);
      if (name == null) {
         session.removeAttribute("mobileNo");
         return "redirect:/ws/user/login.do";
      } else {
         return "water";
      }
   }

   @RequestMapping({"ws/nmc/dashboard/solidWasteManagementDepartment.do"})
   public String solidWasteManagementDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      HttpSession session = request.getSession();
      String name = (String)request.getSession().getAttribute("name");
      request.setAttribute("name", name);
      if (name == null) {
         session.removeAttribute("mobileNo");
         return "redirect:/ws/user/login.do";
      } else {
         return "solidwaste";
      }
   }

   @RequestMapping({"/ws/nmc/dashboard/newApplicationDetails.do"})
   public String newApplicationDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	   HttpSession session = request.getSession();
	      String name = (String)request.getSession().getAttribute("name");
	      request.setAttribute("name", name);
	      if (name == null) {
	         session.removeAttribute("mobileNo");
	         return "redirect:/ws/user/login.do";
	      } else {
	         return "certificates";
	      }
//	      
//	   ModelAndView modelAndView = new ModelAndView("certificates");
//      return modelAndView;
   }

//   @RequestMapping({"/ws/nmc/dashboard/getApplicationDetails.do"})
//   public ModelAndView getApplicationDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException {
//      RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
//      RTIApplication rtiApplication = new RTIApplication();
//      String applicationNumber = request.getParameter("rtiApplnNumber");
//      request.setAttribute("applicationNumber", applicationNumber);
//      GaneshMandapPermission ganeshPermission = new GaneshMandapPermission();
//      System.out.println("getApplicationDetails is calling");
//
//      try {
//         if (applicationNumber != null && applicationNumber.trim().length() > 0) {
//            applicationSearch.setRtiApplicationNumber(applicationNumber);
//            applicationSearch.setRtiserviceid(0);
//            System.out.println("RtiApplicationService ");
//            rtiApplication = this.rtiApplicationService.findByRTIApplicationNumber(applicationNumber);
//            ganeshPermission = this.ganeshMandapPermissionService.getDetails(rtiApplication.getRtiApplicationId());
//         } else {
//            request.setAttribute("errors", "Record Not Found.Please Enter Valid Application Number!");
//         }
//      } catch (Exception var8) {
//         request.setAttribute("errors", "Record Not Found.Please Enter Valid Application Number!");
//      }
//
//      ModelAndView model = new ModelAndView("certificates", "rtiApplication", rtiApplication);
//      model.addObject("ganeshPermission", ganeshPermission);
//      return model;
//   }
   
   @RequestMapping("/ws/nmc/dashboard/getApplicationDetails.do")
   public ModelAndView getApplicationDetails(HttpServletRequest request,
                                             HttpServletResponse response) throws ServletException {

       HttpSession session = request.getSession(false);

       if (session == null || session.getAttribute("name") == null) {
           return new ModelAndView("redirect:/ws/user/login.do");
       }

       String name = (String) session.getAttribute("name");
       String mobileNumber = (String) session.getAttribute("mobileNo");

       if (mobileNumber == null || mobileNumber.trim().isEmpty()) {
           return new ModelAndView("redirect:/ws/user/login.do");
       }

       request.setAttribute("name", name);

       String applicationNumber = request.getParameter("rtiApplnNumber");
       if (applicationNumber != null) {
           applicationNumber = applicationNumber.trim();
       }

       request.setAttribute("applicationNumber", applicationNumber);

       RTIApplication rtiApplication = null;
       GaneshMandapPermission ganeshPermission = null;
       FireRecommendation fireRecommendation = null ;
       try {

           if (applicationNumber == null || applicationNumber.trim().isEmpty()) {

               request.setAttribute("errors",
                       "Please enter valid application number.");

           } else {

               // 1️⃣ First check if application exists at all
               RTIApplication existingApp =
                       rtiApplicationService.findByRTIApplicationNumber(applicationNumber);

               if (existingApp == null) {

                   // Case 1: Record Not Found
                   request.setAttribute("errors",
                           "Record Not Found. Please enter valid application number.");

               } else {

                   // 2️⃣ Now check if belongs to logged-in user
                   rtiApplication =
                           rtiApplicationService
                                   .findByRTIApplicationNumberUserMobileNo(applicationNumber, mobileNumber);

                   if (rtiApplication == null) {

                       // Case 2: Not Authorized
                       request.setAttribute("errors",
                               "You are not authorized to check this application details.");

                   } else {

                       // Case 3: Valid and Authorized
                       ganeshPermission =
                               ganeshMandapPermissionService
                                       .getDetails(rtiApplication.getRtiApplicationId());
                       fireRecommendation=fireRecommendationService.getDetails(rtiApplication.getRtiApplicationId());
                       String token = generateSecureToken(
                    	        rtiApplication.getRtiApplicationId(),
                    	        rtiApplication.getRtiserviceid(),
                    	        rtiApplication.getMobileNumber()
                    	);

                    	request.setAttribute("encryptedToken", token);
                   }
               }
           }

       } catch (Exception ex) {
           ex.printStackTrace();
           request.setAttribute("errors",
                   "Something went wrong. Please try again.");
       }

       ModelAndView model = new ModelAndView("certificates");
       model.addObject("rtiApplication", rtiApplication);
       model.addObject("ganeshPermission", ganeshPermission);
       model.addObject("fireRecommendation", fireRecommendation);


       return model;
   }
   @RequestMapping({"ws/rtsapplication/getPrintReciept.do"})
   public ModelAndView getPrintReciept(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      ModelAndView modelAndView = new ModelAndView("printReciept");
      return modelAndView;
   }

   @RequestMapping({"ws/nmc/dashboard/gardenDepartment.do"})
   public ModelAndView gardenDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      ModelAndView modelAndView = new ModelAndView("gardenDepartment");
      return modelAndView;
   }

   @RequestMapping({"ws/rtsapplication/printRecieptDownload.do"})
   public ModelAndView printRecieptDownload(HttpServletRequest request, HttpServletResponse response) throws ServletException {
      Collection collection = null;
      RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
      RTIApplication rtiApplication = new RTIApplication();
      String applicationNumber = request.getParameter("rtiApplnNumber");
      ModelAndView model = new ModelAndView();
      System.out.println("getApplicationDetails is calling");

      try {
         if (applicationNumber != null && applicationNumber.trim().length() > 0) {
            applicationSearch.setRtiApplicationNumber(applicationNumber);
            applicationSearch.setRtiserviceid(0);
            rtiApplication = this.rtiApplicationService.findByRTIApplicationNumber(applicationNumber);
            long id = rtiApplication.getRtiApplicationId();
            collection = this.collectionService.getCollection(id);
         } else {
            request.setAttribute("error", "Record Not Found.Please Enter Valid Application Number!");
         }
      } catch (Exception var10) {
         request.setAttribute("error", "Record Not Found.Please Enter Valid Application Number!");
      }

      model.setViewName("printReciept");
      model.addObject("collection", collection);
      model.addObject("rts", rtiApplication);
      return model;
   }
   
   private String generateSecureToken(long applicationId,
           long serviceId,
           String mobileNo) {

String data = applicationId + "|" + serviceId + "|" + mobileNo;
return Base64.getUrlEncoder().encodeToString(data.getBytes());
}
   
}

