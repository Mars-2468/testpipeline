package com.mars.rti.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.api.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.PropertyTaxSefAssessment;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.PropertyTaxSelfAssessmentService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;

@Controller
public class PropertyTaxSelfAssessmentController {


	private static Log log = LogFactory.getLog(PropertyTaxSelfAssessmentController.class);

	@Autowired
	private PropertyTaxSelfAssessmentService propertyTaxSelfAssessmentService;

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private UserRegistrationService userService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;

	@RequestMapping(method = RequestMethod.POST,value = "/rtsapplication/savePropertySelfAssessment.do")
	public ModelAndView savePropertySelfAssessment(HttpServletRequest request, HttpServletResponse response,
			PropertyTaxSefAssessment propertyTaxSefAssessment) throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking propertyTaxSelfAssessment");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking propertyTaxSelfAssessment");
		}
		String mobileNumber = "";
		RTIApplication retunRti=null;
		String result=null;
		String user_name=null;
		Object user_login = request.getSession().getAttribute("name");
		if (user_login != null) {
			user_name = (String) user_login;
		}
		Object obileNumber= session.getAttribute("mobileNo");
		if(obileNumber!=null) {
		mobileNumber=String.valueOf(obileNumber);
		}else {
		mobileNumber = (String) session.getAttribute("mobileNo");
		}
		if (mobileNumber != null) {
			try {
			UserRegistrationDetails user = userService.getUserByMobileNo(mobileNumber);
			if (propertyTaxSefAssessment != null) {
				 
				//String url = "https://geocivicnmcapp.nmcptax.com/CitizenServices/CitizenTax/SelfAssessmentExcel/SelfAssessment_Calculator.xlsx";
				 String url="https://nmctax.cybertech.com/GeocivicServices/CitizentaxService/CitizentaxService/AgentCollectionService.svc/SaveRTSRequest";


				RTIApplication rtiApplication = new RTIApplication();
				// tradeLicenseNameChangeRestDTO tradeLicenseNameChangeRestDTO = new
				// tradeLicenseNameChangeRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("PROPERTY-TAX-SELF-ASSESSMENT");
				rtiApplication.setDepartment("TAX-DEPARTMENT");
				rtiApplication.setTemplateName("propertytax");
				rtiApplication.setWorkFlowStatus(1);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(60);
				rtiApplication.setApplicantName(propertyTaxSefAssessment.getName());
				rtiApplication.setPhoneNumber(propertyTaxSefAssessment.getMobileNo());
				rtiApplication.setMobileNumber(propertyTaxSefAssessment.getMobileNo());
				rtiApplication.setZone(PropertyTaxPTNDetailsController.getZoneNo(propertyTaxSefAssessment.getZoneNo()));

				rtiApplication.setEmail(propertyTaxSefAssessment.getEmailid());

				// rtiApplication.setApplicationCost(tradeLicenseNameChange.getFees());

				rtiApplication.setApplicantName(propertyTaxSefAssessment.getName());
				rtiApplication.setPdfUploadFromPortal(propertyTaxSefAssessment.getFilesPath());
				rtiApplication.setPdfFilesSavedPath(url);
				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(0);
				rtiApplicationDetails.setAssignToStatus(1);
				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setUserRegistrationDetails(user);

				rtiApplicationDetails.setComments("Form Submitted");// ();
				rtiApplicationDetails.setWorkflowLevel(0);
				rtiApplicationDetailsList.add(rtiApplicationDetails);
				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);

				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/PT" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					propertyTaxSefAssessment.setRtiapplrefno(rti.getRtiApplnNumber());
					propertyTaxSefAssessment.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = propertyTaxSelfAssessmentService.propertyTaxSelfAssessmentService(propertyTaxSefAssessment);
					rti.setRtiApplicationRefId(birth_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					 retunRti = rtiApplicationService.merge(rti);

					String name = propertyTaxSefAssessment.getName();
		        	String applnNo = rti.getRtiApplnNumber();
		        	String mobileNo = propertyTaxSefAssessment.getMobileNo();
		        	String email=propertyTaxSefAssessment.getEmailid();
		        	SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}

				Object as_status=session.getAttribute("as_status");
				if(as_status!=null && user_name==null) {
					return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSPropertyTaxSelfAssessmentSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());
				}
				
				}
				
			}catch(Exception ex){
			
				request.setAttribute("message", "Something Went Wrong!!");
				return new ModelAndView("newRTIPropertyTaxSelfAssessment");
			}
			}
			return new ModelAndView("redirect:/ws/user/login.do");

		}
	
	
	@RequestMapping("ws/rtsapplication/newRtSPropertyTaxSelfAssessmentSuccess.do")
	public ModelAndView newRtSPropertyTaxSelfAssessmentSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTIPropertyTaxSelfAssessmentSuccess");
		
		model.addObject("propertyTaxDemand",appNo);
		return model;
				
		
	}
}
