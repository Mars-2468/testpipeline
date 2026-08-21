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
import org.jbpm.api.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.PropertyTaxDemand;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.PropertyTaxDemandService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class PropertyTaxDemandController {

	private static Log log = LogFactory.getLog(PropertyTaxDemandController.class);

	String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";
	
	@Autowired
	private PropertyTaxDemandService propertyTaxDemandService;

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
	
	@Autowired
	private AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;



	@RequestMapping("/rtsapplication/savePropertyTaxDemand.do")
	public ModelAndView savePropertyTaxDemand(HttpServletRequest request, HttpServletResponse response,
			PropertyTaxDemand propertyTaxDemand) throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking propertyTaxDemand");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking propertyTaxDemand");
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
			Object as_status=session.getAttribute("as_status");

			if (propertyTaxDemand != null) {
				 
				//String url = "https://nmctax.cybertech.com/GeoCivic/AssessmentReport/AssessmentReport/GenerateReport";
				String url=CoreConstants.TAX_REPORT_API;
				HttpHeaders headers = new HttpHeaders();

				PropertyTaxDemandToken propertyTax = new PropertyTaxDemandToken();
				propertyTax.setClientId(3);

				PropertyTaxDemandToken.RptInput rptInpt = new PropertyTaxDemandToken.RptInput();
				rptInpt.setReportKey("BillReceipt");
                

				PropertyTaxDemandToken.RptInput.ReportParameter reportParameter = new PropertyTaxDemandToken.RptInput.ReportParameter();
				reportParameter.setPtn(propertyTaxDemand.getUpinNo());
				if(propertyTaxDemand.getUpinNo()!=null) {
					reportParameter.setIsOldPin("false");
				}else {
					reportParameter.setIsOldPin("true");
				}
				reportParameter.setClientId(3);
				rptInpt.setReportParameter(reportParameter);
				propertyTax.setRptInpt(rptInpt);

				String token = PropertyTaxTokenGeneration.propertyTaxToken();
				propertyTax.setToken(token);
				

				RestTemplate restTemplate = new RestTemplate();
				ObjectMapper objectMapper = new ObjectMapper();
				String jsonRequestBody = objectMapper.writeValueAsString(propertyTax);

				headers.setContentType(MediaType.APPLICATION_JSON);

				HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

				ResponseEntity<TokenResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, TokenResponse.class);

			    TokenResponse tokenResponse = responseEntity.getBody();
			    String code = tokenResponse.getErrorCode();
			     result = tokenResponse.getResult();
				HttpStatus statusCode = responseEntity.getStatusCode();

				
				if (log.isDebugEnabled()) {
					log.debug("Invoking propertyAssessmentToken = "
							+ token);
					log.debug(statusCode);
					log.debug(code);
					log.debug(result);
				}
			}
				if(result!=null && result.length()>0) {

				RTIApplication rtiApplication = new RTIApplication();
				// tradeLicenseNameChangeRestDTO tradeLicenseNameChangeRestDTO = new
				// tradeLicenseNameChangeRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("PROPERTY-TAX-DEMAND");
				rtiApplication.setDepartment("TAX-DEPARTMENT");
				rtiApplication.setTemplateName("propertytax");
				rtiApplication.setWorkFlowStatus(1);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(72);
				rtiApplication.setApplicantName(propertyTaxDemand.getFullName());
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
				}
				rtiApplication.setPhoneNumber(propertyTaxDemand.getMobileNo());
				rtiApplication.setMobileNumber(propertyTaxDemand.getMobileNo());
				rtiApplication.setZone(propertyTaxDemand.getZoneNo());

				rtiApplication.setEmail(propertyTaxDemand.getEmailId());

				// rtiApplication.setApplicationCost(tradeLicenseNameChange.getFees());

				rtiApplication.setApplicantName(propertyTaxDemand.getFullName());
				rtiApplication.setPdfUploadFromPortal(propertyTaxDemand.getFilesPath());
				rtiApplication.setPdfFilesSavedPath(result);
				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(0);
				rtiApplicationDetails.setAssignToStatus(1);
				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setUserRegistrationDetails(user);
				rtiApplication.setIsApleSarkarApp(0);

				rtiApplicationDetails.setComments("Form Submitted");// ();
				rtiApplicationDetails.setWorkflowLevel(0);
				rtiApplicationDetailsList.add(rtiApplicationDetails);
				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);

				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/PT"  + "/" + savedRti.getRtiApplicationId() + "/" + Year.now());
					propertyTaxDemand.setRtiApplRefNo(rti.getRtiApplnNumber());
					propertyTaxDemand.setRtiRefId(savedRti.getRtiApplicationId());
					long birth_regis_id = propertyTaxDemandService.propertyTaxDemand(propertyTaxDemand);
					rti.setRtiApplicationRefId(birth_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					if(as_status!=null && user_name==null) {
						String serviceId = request.getParameter("serviceId");
						 log.debug("aple sarkar serviceId ="+serviceId);
						
						     String distric = request.getParameter("distric");
							log.debug("aple sarkar distric ="+distric);
						
						    String trackid = request.getParameter("trackid");
							log.debug("aple sarkar trackid ="+trackid);
						    
							String userid = request.getParameter("user");
							log.debug("aple sarkar userid ="+userid);
							
						    String mobile = request.getParameter("mobile");
							log.debug("aple sarkar mobile ="+mobile);
							
						    String name = request.getParameter("name");
							log.debug("aple sarkar name ="+name);
							
							
							//String appId=retunRti.getRtiApplnNumber();
							//log.debug("aple sarkar appId ="+appId);
							
							rti.setAaple_service_id(serviceId);
							//retunRti.setAaple_application_id(appId);
							rti.setAaple_user_id(userid);
							rti.setAaple_user_track_id(trackid);
							rti.setAapleSarkarUserMobileNo(mobile);
							rti.setIsApleSarkarApp(1);

							
					}
					 retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {
						// tradeLicenseNameChangeRestDTO.setResponseStatus("Requested data saved
						// successfully");
						// tradeLicenseNameChangeRestDTO.setResponse(retunRti.getRtiApplicationId());
						// tradeLicenseNameChangeRestDTO.setResult(retunRti.getRtiApplnNumber());
					}
					String name = rti.getApplicantName();
		        	String applnNo = rti.getRtiApplnNumber();
		        	String mobileNo = propertyTaxDemand.getMobileNo();
		        	String email=propertyTaxDemand.getEmailId();
		        	SendSMSEmailController.sendApplicationCompleted(name, mobileNo, applnNo, email);
				}
//				ModelAndView model = new ModelAndView("newRTIPropertyTaxDemandSuccess");
//				return model;
				
				if(as_status!=null && user_name==null) {
					String str = request.getParameter("str");
					log.debug("aple sarkar str ="+str);
					 String serviceId = request.getParameter("serviceId");
					log.debug("aple sarkar serviceId ="+serviceId);
					
					     String distric = request.getParameter("distric");
						log.debug("aple sarkar distric ="+distric);
					
					    String trackid = request.getParameter("trackid");
						log.debug("aple sarkar trackid ="+trackid);
					    
						String userid = request.getParameter("user");
						log.debug("aple sarkar userid ="+userid);
						
					    String mobile = request.getParameter("mobile");
						log.debug("aple sarkar mobile ="+mobile);
						
					    String name = request.getParameter("name");
						log.debug("aple sarkar name ="+name);
						
						
						String appId=retunRti.getRtiApplnNumber();
						appId = appId.replace("/", "");

						log.debug("aple sarkar appId ="+appId);
						
						String paymentStatus="N";
						log.debug("aple sarkar paymentStatus ="+paymentStatus);
						
						String paymentDate="NA";
						String digitalSignStatus="N";
						String digitalSignDate="NA";
						int estServiceDays=3;
						String estServiceDate="NA";
						double amount=0.0;

						int reqFlag=0;
						int appStatus=4;
						String remark="NA";
						String UD1=request.getParameter("ULBId");
						String UD2= request.getParameter("ULBDistrict");
						
						int ud = 0;
						int ud1 = 0;
						
						if (UD1 != null && !UD1.trim().isEmpty()) {
						    try {
						    	ud = Integer.parseInt(UD1.trim());
						    } catch (NumberFormatException e) {
						        // Handle the invalid number case
						        System.err.println("Invalid ULBId: " + UD1);
						        // Optional: throw custom exception or return error response
						    }
						}
						    
						    if (UD2 != null && !UD2.trim().isEmpty()) {
							    try {
							    	ud1 = Integer.parseInt(UD2.trim());
							    } catch (NumberFormatException e) {
							        // Handle the invalid number case
							        System.err.println("Invalid ULBId : " + UD2);
							        // Optional: throw custom exception or return error response
							    }
						    }
						 String UD3="NA";
						String UD4="NA";
						String UD5="NA";
						String CheckSum="NA";
						String mobileApla = propertyTaxDemand.getMobileNo();
						
						
						/*
						 * String[] fields = request.getParameterValues("fields"); for (int i = 0; i <
						 * fields.length; i++) { log.debug("Index controller XXX--> " + i + ": " +
						 * fields[i]); }
						 */

						 String retrurnurl="https://nmcnagpur.gov.in/RTSservices/ws/rtsapplication/newRtSPropertyTaxDemandSuccess.do?rtsAppNo="+appId+"&dmd="+retunRti.getPdfFilesSavedPath()+ "&isApleSarkar="+ retunRti.getIsApleSarkarApp();;
						//String retrurnurl="https://nagpur.egovmars.in/RTSservices/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
						
						String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
								 digitalSignStatus,digitalSignDate,estServiceDays, 
								 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
						
					log.debug("Final  PushBAck status XXX-->>>"+pushBackrespose);
					
					return new ModelAndView("redirect:/ws/rtsapplication/newRtSPropertyTaxDemandSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSPropertyTaxDemandSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber()+"&dmd="+retunRti.getPdfFilesSavedPath()
				 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
						);
				}
				}else {
					request.setAttribute("message", "PTN no. does not exist!!");
					return new ModelAndView("newRTIPropertyTaxDemand");

				}
				
			}catch(Exception ex){
			
				request.setAttribute("message", "PTN no. does not exist!!");
				return new ModelAndView("newRTIPropertyTaxDemand");
			}
			}
			return new ModelAndView("redirect:/ws/user/login.do");

		}
	
	
	@RequestMapping("ws/rtsapplication/newRtSPropertyTaxDemandSuccess.do")
	public ModelAndView newRtSPropertyTaxDemandSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		String demand = request.getParameter("dmd");
		String isApleSarkar=request.getParameter("isApleSarkar");

		ModelAndView model = new ModelAndView("newRTIPropertyTaxDemandSuccess");
		
		model.addObject("propertyTaxDemand",appNo);
		model.addObject("demand",demand);
		model.addObject("isApleSarkar", isApleSarkar);

		return model;
				
		
	}
	
	@RequestMapping("/rtsapplication/editPropertyTaxDemand.do")
	public ModelAndView editPropertyTaxDemand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {

		PropertyTaxDemand demand = null;
		HttpSession session = request.getSession();
		System.out.println("editPropertyTaxDemand");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if(sessionUser!=null) {
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0) {

			rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
			demand = propertyTaxDemandService.get(rtiApplicationRefId);

			if (demand.getRtiRefId() > 0) {
				rtiApplicationId = demand.getRtiRefId();
				rtiapplication = rtiApplicationService.get(rtiApplicationId);
			} else {
				List<RTIApplication> listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
						rtiApplicationRefId);
				if (listRTI != null && !listRTI.isEmpty()) {
					rtiApplicationId = listRTI.get(0).getRtiApplicationId();
					rtiapplication = listRTI.get(0);
				}
			}
		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);

		if (workflowProcessDetails != null) {
			String processId = workflowProcessDetails.getProcessId();
			if (processId != null) {
				processDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId);
			}
			if (!workflowService.isProcessEnded(processId)) {
				String taskId = workflowService.getCurrentTaskId(processId);
				Task task = null;
				if (taskId != null)
					task = taskService.getTask(taskId);
				if (processDetails != null) {
					PersonalTask personalTask = new PersonalTask();
					personalTask.setTask(task);
					personalTask.setEntityId(processDetails.getEntityId());
					personalTask.setEntityName(processDetails.getEntityName());
					personalTask.setWorkflowInitator(processDetails.getUserName());
					personalTask.setEntityDetails(processDetails.getEntityDetails());
					request.setAttribute("personalTask", personalTask);
				}
				if (task != null && sessionUser.getUserName().equals(task.getAssignee()))
					request.setAttribute("userAccess", 1);

				request.setAttribute("workFlowTask", task);
			} else {

				request.setAttribute("workFlowCompleted", "1");
			}
		}

		ModelAndView modelAndView = new ModelAndView("managePropertyTaxDemand", "propertyTaxAssessment", demand);

		return modelAndView;

	}else {
		return new ModelAndView("/login.do");
	}
	}


}
