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
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.PropertyTaxUtara;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.PropertyTaxUtaraService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.PropertyTaxUtaraRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class PropertyTaxUtaraController {

//	extends MultiActionController implements InitializingBean
	private static Log log = LogFactory.getLog(PropertyTaxUtaraController.class);
	

	String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";
	
	@Autowired
	private PropertyTaxUtaraService propertyTaxUtaraService;
	@Autowired
	private RTIApplicationService rtiApplicationService;
//
//	private static String const_OrderBy = "OrderBy";
//
//	private static String const_SortBy = "SortBy";

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


	@RequestMapping("/rtsapplication/savePropertyTaxUtaraCertificates.do")
	public ModelAndView savePropertyTaxUtara(HttpServletRequest request, HttpServletResponse response,
			PropertyTaxUtara propertyTaxUtara) throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Property Tax Utara");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking PropertyTaxUtara");
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
			if (propertyTaxUtara != null) {
				 
				//String url = "https://nmctax.cybertech.com/GeoCivic/AssessmentReport/AssessmentReport/GenerateReport";
				String url =CoreConstants.TAX_REPORT_API;

				HttpHeaders headers = new HttpHeaders();

				PropertyTaxToken propertyTax = new PropertyTaxToken();
				propertyTax.setClientId(3);

				PropertyTaxToken.RptInput rptInpt = new PropertyTaxToken.RptInput();
				rptInpt.setReportKey("dcb_tax_report");

				PropertyTaxToken.RptInput.ReportParameter reportParameter = new PropertyTaxToken.RptInput.ReportParameter();
				reportParameter.setPtn(propertyTaxUtara.getUpinNo());

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
				PropertyTaxUtaraRestDTO propertyTaxUtaraRestDTO = new PropertyTaxUtaraRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setTemplateName("propertytax");
				rtiApplication.setSubject("PROPERTY-TAX-UTARA-CERTIFICATE");
				rtiApplication.setDepartment("TAX-DEPARTMENT");
				rtiApplication.setWorkFlowStatus(1);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(55);
				rtiApplication.setApplicantName(propertyTaxUtara.getFirstName() + " " + propertyTaxUtara.getMiddleName()
						+ " " + propertyTaxUtara.getLastName());
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
				}
				rtiApplication.setPhoneNumber(propertyTaxUtara.getMobileNo());
				rtiApplication.setMobileNumber(propertyTaxUtara.getMobileNo());
				rtiApplication.setEmail(propertyTaxUtara.getEmail());
				rtiApplication.setZone(propertyTaxUtara.getZoneNo());
				rtiApplication.setUserRegistrationDetails(user);
				rtiApplication.setIsApleSarkarApp(0);

				// rtiApplication.setApplicationCost(propertyTaxUtara.getFeesApplicable());

				rtiApplication.setApplicantName(propertyTaxUtara.getFirstName());
				rtiApplication.setPdfUploadFromPortal(propertyTaxUtara.getFilesPath());
				rtiApplication.setPdfFilesSavedPath(result);
				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(0);
				rtiApplicationDetails.setAssignToStatus(1);
				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());

				rtiApplicationDetails.setComments("Form Submitted");// ();
				rtiApplicationDetails.setWorkflowLevel(0);
				rtiApplicationDetailsList.add(rtiApplicationDetails);
				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);

				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/PT" + "/" + savedRti.getRtiApplicationId()  + "/" + Year.now());
					propertyTaxUtara.setRtiapplrefno(rti.getRtiApplnNumber());
					propertyTaxUtara.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = propertyTaxUtaraService.propertyTaxUtara(propertyTaxUtara);
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
							rti.setApplication_status(2);

							
					}
					 retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {
						propertyTaxUtaraRestDTO.setResponseStatus("Requested data saved successfully");
						propertyTaxUtaraRestDTO.setResponse(retunRti.getRtiApplicationId());
						propertyTaxUtaraRestDTO.setResult(retunRti.getRtiApplnNumber());
					}
					String name = rti.getApplicantName();
		        	String applnNo = rti.getRtiApplnNumber();
		        	String mobileNo = propertyTaxUtara.getMobileNo();
		        	String email=propertyTaxUtara.getEmail();
		        	SendSMSEmailController.sendApplicationCompleted(name, mobileNo, applnNo, email);
				}
//				ModelAndView modelAndView = new ModelAndView("newRTIPropertyTaxUtaraSuccess", "propertyTaxUtara",
//						propertyTaxUtara);
//
//				return modelAndView;
				
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
						String mobileApla = propertyTaxUtara.getMobileNo();
						
						
						/*
						 * String[] fields = request.getParameterValues("fields"); for (int i = 0; i <
						 * fields.length; i++) { log.debug("Index controller XXX--> " + i + ": " +
						 * fields[i]); }
						 */

						 String retrurnurl="https://nmcnagpur.gov.in/RTSservices/ws/rtsapplication/newRtSPropertyTaxUtaraSuccess.do?rtsAppNo="+appId+"&dcb="+retunRti.getPdfFilesSavedPath()+ "&isApleSarkar="+ retunRti.getIsApleSarkarApp();
						//String retrurnurl="https://nagpur.egovmars.in/RTSservices/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
						
						String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
								 digitalSignStatus,digitalSignDate,estServiceDays, 
								 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
						
					log.debug("Final  PushBAck status XXX-->>>"+pushBackrespose);
					
					return new ModelAndView("redirect:/ws/rtsapplication/newRtSPropertyTaxUtaraSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber()
					 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
							);

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSPropertyTaxUtaraSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber()+"&dcb="+retunRti.getPdfFilesSavedPath()
				 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
						);
				}				
			}else {
				request.setAttribute("message", "PTN no. does not exist!!");
				return new ModelAndView("newRTIPropertyTaxUtara");

			}
			
		}catch(Exception ex){
		
			request.setAttribute("message", "PTN no. does not exist!!");
			return new ModelAndView("newRTIPropertyTaxUtara");
		}
		}
		return new ModelAndView("redirect:/ws/user/login.do");

	}

	
	@RequestMapping("ws/rtsapplication/newRtSPropertyTaxUtaraSuccess.do")
	public ModelAndView newRtSPropertyTaxUtaraSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		String dcb = request.getParameter("dcb");
		String isApleSarkar=request.getParameter("isApleSarkar");

		ModelAndView model = new ModelAndView("newRTIPropertyTaxUtaraSuccess");
		
		model.addObject("propertyTaxUtara",appNo);
		model.addObject("dcb",dcb);
		model.addObject("isApleSarkar", isApleSarkar);

		return model;
				
		
	}
	
	
	@RequestMapping("/rtsapplication/editPropertyTaxUtara.do")
	public ModelAndView editPropertyTaxUtara(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {

		PropertyTaxUtara propertyTaxUtara = null;
		HttpSession session = request.getSession();
		System.out.println("editPropertyTaxUtara");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if(sessionUser!=null) {
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0) {

			rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
			propertyTaxUtara = propertyTaxUtaraService.get(rtiApplicationRefId);

			if (propertyTaxUtara.getRti_ref_id() > 0) {
				rtiApplicationId = propertyTaxUtara.getRti_ref_id();
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

		ModelAndView modelAndView = new ModelAndView("managePropertyTaxUtara", "propertyTaxAssessment", propertyTaxUtara);

		return modelAndView;

	}else {
		return new ModelAndView("/login.do");
	}
	}

	@RequestMapping("/rtiapplication/createPropertyTaxUtaraWork.do")
	public ModelAndView createPropertyTaxUtaraWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		PropertyTaxUtara propertyTaxUtara = propertyTaxUtaraService.get(applicationId);
		String email = propertyTaxUtara.getEmail();
		String mobileNo = propertyTaxUtara.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();

		if (propertyTaxUtara != null) {
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

					rtiApplication.setWorkFlowStatus(3);
					rtiApplicationService.save(rtiApplication);
					if(isApleSarkarApp==1) {
						String distric="NA";
						String trackid=rtiApplication.getAaple_user_track_id();
						String userid=rtiApplication.getAaple_user_id();
						String mobile=rtiApplication.getAapleSarkarUserMobileNo();
						String name=rtiApplication.getApplicantName();
						double amount = rtiApplication.getApplicationCost();
						String str="NA";
						
						String retrurnurl="";
						String appId=rtiApplication.getRtiApplnNumber();				
						appId = appId.replace("/", "");
						String paymentStatus="N";						
						String paymentDate="NA";
						String digitalSignStatus="N";
						String digitalSignDate="NA";
						int estServiceDays=3;
						String estServiceDate="NA";

						int reqFlag=0;
						int appStatus=1;
						String remark="NA";						
						String serviceId= rtiApplication.getAaple_service_id();
						String mobileApla=rtiApplication.getMobileNumber();
						//retunRti.setAaple_application_id(appId);
					String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
								 digitalSignStatus,digitalSignDate,estServiceDays, 
								 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
					}
					String link = CoreConstants.TAX_PAYMENT_LINK;
					String msg = "Dear " + applicantName
							+ " your document verification has been successfully completed. Kindly use this link "+link+" to make a payment in order for your application "
							+ rtiApplnNumber + " to be processed further.Regards, NMCGOV";
					msg.replace("var3", "");
					SendEmail.sendEmail(email, "Payment link for your Appl. No." + mobileNo, msg);
					SendSMS.sendSingleSMS("1507167421309610108", "NMCGov", mobileNo, msg);

					if (request.getParameter("WORKFLOW_TRANSISTION").isEmpty()
							|| request.getParameter("WORKFLOW_TRANSISTION") == null) {

					}
					if (task != null && sessionUser.getUserName().equals(task.getAssignee())) {
						request.setAttribute("userAccess", 1);
						request.setAttribute("workFlowTask", task);
					}
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Close-Application")) {

					rtiApplication.setWorkFlowStatus(1);
					rtiApplicationService.save(rtiApplication);
					if(isApleSarkarApp==1) {
						String distric="NA";
						String trackid=rtiApplication.getAaple_user_track_id();
						String userid=rtiApplication.getAaple_user_id();
						String mobile=rtiApplication.getAapleSarkarUserMobileNo();
						String name=rtiApplication.getApplicantName();
						double amount = rtiApplication.getApplicationCost();
						String str="NA";
						
						String retrurnurl="";
						String appId=rtiApplication.getRtiApplnNumber();				
						appId = appId.replace("/", "");
						String paymentStatus="N";						
						String paymentDate="NA";
						String digitalSignStatus="N";
						String digitalSignDate="NA";
						int estServiceDays=3;
						String estServiceDate="NA";

						int reqFlag=0;
						int appStatus=4;
						String remark="NA";						
						String serviceId= rtiApplication.getAaple_service_id();
						String mobileApla=rtiApplication.getMobileNumber();
						//retunRti.setAaple_application_id(appId);
					String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
								 digitalSignStatus,digitalSignDate,estServiceDays, 
								 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
					}
					String msg = "Dear " + applicantName
							+ " please click on this link https://tinyurl.com/359w8usz to download the Certificate for your application "
							+ rtiApplnNumber + " Regards, NMCGOV";

					msg.replace("var3", "");
					SendEmail.sendEmail(email, "Completion of your Appl. No." + rtiApplnNumber, msg);
					SendSMS.sendSingleSMS("1507167421320245636", "NMCGov", mobileNo, msg);
					request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
					rtiApplication.setWorkFlowStatus(5);
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
					rtiApplication.setWorkflowComments(workflow_comments);
	
					rtiApplicationService.save(rtiApplication);
					if(isApleSarkarApp==1) {
						String distric="NA";
						String trackid=rtiApplication.getAaple_user_track_id();
						String userid=rtiApplication.getAaple_user_id();
						String mobile=rtiApplication.getAapleSarkarUserMobileNo();
						String name=rtiApplication.getApplicantName();
						double amount = rtiApplication.getApplicationCost();
						String str="NA";
						
						String retrurnurl="";
						String appId=rtiApplication.getRtiApplnNumber();				
						appId = appId.replace("/", "");
						String paymentStatus="N";						
						String paymentDate="NA";
						String digitalSignStatus="N";
						String digitalSignDate="NA";
						int estServiceDays=3;
						String estServiceDate="NA";

						int reqFlag=0;
						int appStatus=5;
						String remark="NA";						
						String serviceId= rtiApplication.getAaple_service_id();
						String mobileApla=rtiApplication.getMobileNumber();
						//retunRti.setAaple_application_id(appId);
					String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
								 digitalSignStatus,digitalSignDate,estServiceDays, 
								 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
						}
					String msg = "Dear " + applicantName + " your " + rtiApplnNumber
							+ " has been rejected due to shortfall of documents. Please use this link https://tinyurl.com/359w8usz to know the pending mandatory documents and track the status of your application.Regards, NMCGOV";
					msg.replace("var3", "");
					SendEmail.sendEmail(email, "Rejection of your Appl. No." + rtiApplnNumber, msg);
					SendSMS.sendSingleSMS("1507167421296109813", "NMCGov", mobileNo, msg);
					request.setAttribute("workFlowCompleted", "1");
				}
			}

		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		ModelAndView modelAndView = new ModelAndView("managePropertyTaxUtara", "propertyTaxAssessment", propertyTaxUtara);
		return modelAndView;
	}

}
