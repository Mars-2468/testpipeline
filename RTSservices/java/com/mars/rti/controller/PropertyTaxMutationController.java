package com.mars.rti.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.PostPropertyTaxMutation;
import com.mars.rti.model.PropertyTaxMutation;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.PropertyTaxMutationService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.AuthenticationResponseDTO;
import com.mars.rti.ws.model.PropertyTaxUtaraRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class PropertyTaxMutationController {

	private static Log log = LogFactory.getLog(PropertyTaxMutationController.class);
	
	String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";

	@Autowired
	private PropertyTaxMutationService propertyTaxMutationService;
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
	private PropertyTaxPTNDetailsController propertyTaxPTNDetailsController;
	
	@Autowired
	private AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;


	@RequestMapping("/rtsapplication/savePropertyTaxMutation.do")
	public ModelAndView savePropertyTaxMutation(HttpServletRequest request, HttpServletResponse response,
			PropertyTaxMutation propertyTaxMutation) throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Property Tax Mutation");
		}
		
		String mobileNumber = "";
		RTIApplication retunRti=null;
		String result=null;
		int resultList=0;
		String responseCode=null;
		String responseMessage=null;
		String mydropdown=null;
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

			if (propertyTaxMutation != null) {
				 
				RTIApplication rtiApplication = new RTIApplication();
				PropertyTaxUtaraRestDTO propertyTaxUtaraRestDTO = new PropertyTaxUtaraRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setTemplateName("propertytax");
				
					rtiApplication.setSubject("PROPERTY-TAX-NEW-ASSESSMENT");
			
				rtiApplication.setDepartment("TAX-DEPARTMENT");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(103);
				rtiApplication.setApplicantName(propertyTaxMutation.getName());
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
				}
				rtiApplication.setPhoneNumber(propertyTaxMutation.getMobileNo());
				rtiApplication.setMobileNumber(propertyTaxMutation.getMobileNo());
				rtiApplication.setEmail(propertyTaxMutation.getEmailid());
				rtiApplication.setZone(PropertyTaxPTNDetailsController.getZoneNo(propertyTaxMutation.getZoneNo()));
				rtiApplication.setUserRegistrationDetails(user);
				rtiApplication.setIsApleSarkarApp(0);

				// rtiApplication.setApplicationCost(propertyTaxUtara.getFeesApplicable());

				rtiApplication.setApplicantName(propertyTaxMutation.getName());
				rtiApplication.setPdfUploadFromPortal(propertyTaxMutation.getFilesPath());
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
					rti.setRtiApplnNumber("RTS/PT"+ "/" + savedRti.getRtiApplicationId()  + "/" + Year.now() );
					propertyTaxMutation.setRtiapplrefno(rti.getRtiApplnNumber());
					propertyTaxMutation.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = propertyTaxMutationService.propertyTaxMutation(propertyTaxMutation);
					rti.setRtiApplicationRefId(birth_regis_id);
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
					 mydropdown=propertyTaxMutation.getMyDropdown();

					 String url=CoreConstants.TAX_STAGING_SAVE;
						//String url = "https://geocivicnmcapp.nmcptax.com/GeoCivicMicroServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/SaveRTSRequest";
						HttpHeaders headers = new HttpHeaders();

						PostPropertyTaxMutation postPropertyTaxMutation = new PostPropertyTaxMutation();
						PostPropertyTaxMutation.CitizenRequest pptm = new PostPropertyTaxMutation.CitizenRequest();
						pptm.setCreatedBy("4377");
						pptm.setDocumentUrl(PropertyTaxUploadURLGenerationController.generateTaxUploadURL(PropertyTaxPTNDetailsController.getFilesPath(propertyTaxMutation.getFilesPath()), request));
						pptm.setIndexNo("");
						pptm.setMeasleNo(propertyTaxMutation.getMeasleNo());
						pptm.setPtn("");
						pptm.setRegisteredPhone(propertyTaxMutation.getMobileNo());
						pptm.setRequestAddress(propertyTaxMutation.getAddress());
						pptm.setRequesterHouseNo(propertyTaxMutation.getHouseNo());
						pptm.setRequesterLandPlotNo(propertyTaxMutation.getPlotNo());
						pptm.setRequesterMail(propertyTaxMutation.getEmailid());
						pptm.setRequesterMauja(propertyTaxMutation.getMouje());
						pptm.setRequesterMobile(propertyTaxMutation.getTaxMobileNo());
						pptm.setRequesterWard(propertyTaxMutation.getWardNo());
						pptm.setRequestName(propertyTaxMutation.getPropertyHolderName());
						pptm.setRequesterMobile(propertyTaxMutation.getMobileNo());
						pptm.setRequestNumber(retunRti.getRtiApplnNumber());
					    pptm.setRequestType("RTSNA");
						
						
						postPropertyTaxMutation.setCitizenRequest(pptm);
						String token = PropertyTaxTokenGeneration.propertyTaxToken();
						postPropertyTaxMutation.setToken(token);

						RestTemplate restTemplate = new RestTemplate();
						ObjectMapper objectMapper = new ObjectMapper();
						String jsonRequestBody = objectMapper.writeValueAsString(postPropertyTaxMutation);

						headers.setContentType(MediaType.APPLICATION_JSON);

						HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

						ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
						HttpStatus statusCode = responseEntity.getStatusCode();
				        System.out.println("HTTP Status Code: " + statusCode);
				        if (statusCode == HttpStatus.OK) {
				            String responseBody = responseEntity.getBody();
				            log.debug("Response Body: " + responseBody);
				            JsonNode rootNode = objectMapper.readTree(responseBody);
				            JsonNode resultNode = rootNode.get("SaveRTSRequestResult").get("Result");
				            JsonNode resultListNode = rootNode.get("SaveRTSRequestResult").get("ResultList");
				            JsonNode responsecode = rootNode.get("SaveRTSRequestResult").get("ResponseCode");
				            JsonNode message = rootNode.get("SaveRTSRequestResult").get("ResponseMessage");
                            JsonNode uniqueId = resultNode.get("UniqueRecordId");

                            if(uniqueId!=null) 
   				             result = uniqueId.asText();
                            
				             resultList = resultListNode.size();
				             responseCode=responsecode.asText();
				             responseMessage=message.asText();
				           

				         
				             if (log.isDebugEnabled()) {
									log.debug(statusCode);
									log.debug(result);
									log.debug(responseCode);
									log.debug(retunRti.getRtiApplnNumber());
								}
					}
				        if(responseCode.equals("GCPT10100")) {
                        if(result!=null && !result.isEmpty()) {
				        propertyTaxMutation.setApi_response_unique_id(result);
				       propertyTaxMutation= propertyTaxMutationService.merge(propertyTaxMutation);
                        }else {
                        	 rtiApplicationService.delete(retunRti.getRtiApplicationId());
        					 request.setAttribute("message", "Something went wrong.Please try again!!");
        					 return new ModelAndView("newRTIPropertyTaxRecovery");
                        }
					if ((retunRti != null) && (birth_regis_id > 0)) {
						propertyTaxUtaraRestDTO.setResponseStatus("Requested data saved successfully");
						propertyTaxUtaraRestDTO.setResponse(retunRti.getRtiApplicationId());
						propertyTaxUtaraRestDTO.setResult(retunRti.getRtiApplnNumber());
					}
					String name = propertyTaxMutation.getName();
		        	String applnNo = rti.getRtiApplnNumber();
		        	String mobileNo = propertyTaxMutation.getMobileNo();
		        	String email=propertyTaxMutation.getEmailid();
		        	SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
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
							
						    String uname = request.getParameter("name");
							log.debug("aple sarkar name ="+uname);
							
							
							String appId=retunRti.getRtiApplnNumber();
							
							appId = appId.replace("/", "");

							log.debug("aple sarkar appId ="+appId);
							
							String paymentStatus="N";
							log.debug("aple sarkar paymentStatus ="+paymentStatus);
							
							String paymentDate="NA";
							String digitalSignStatus="N";
							String digitalSignDate="NA";
							int estServiceDays=25;
							String estServiceDate="NA";
							double amount=0.0;

							int reqFlag=0;
							int appStatus=2;
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
							String mobileApla = propertyTaxMutation.getMobileNo();
							
							
							/*
							 * String[] fields = request.getParameterValues("fields"); for (int i = 0; i <
							 * fields.length; i++) { log.debug("Index controller XXX--> " + i + ": " +
							 * fields[i]); }
							 */

							 String retrurnurl="https://nmcnagpur.gov.in/RTSservices/ws/rtsapplication/newRtSPropertyTaxMutationSuccess.do?rtsAppNo="+appId+ "&isApleSarkar="+ retunRti.getIsApleSarkarApp();
							//String retrurnurl="https://nagpur.egovmars.in/RTSservices/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
							
							String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,uname, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
									 digitalSignStatus,digitalSignDate,estServiceDays, 
									 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
							
						log.debug("Final  PushBAck status XXX-->>>"+pushBackrespose);
						
						 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					        DocumentBuilder builder = null;
					        String statusValue=null;
					        AuthenticationResponseDTO authenticationResponseDTO=null;
							try {
								builder = factory.newDocumentBuilder();
							} catch (ParserConfigurationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

					        // Convert string to InputStream
					        ByteArrayInputStream input = null;
							try {
								input = new ByteArrayInputStream(pushBackrespose.getBytes("UTF-8"));
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					        Document doc = null;
							try {
								doc = builder.parse(input);
							} catch (SAXException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

					        NodeList nodeList = doc.getElementsByTagName("status");
					        if (nodeList.getLength() > 0) {
					            statusValue = nodeList.item(0).getTextContent();
					            
					            if(statusValue!=null && statusValue.equals("Success")) {
					            	authenticationResponseDTO = aapleSarkarPortalIntegrationNagpur.redirectForAapleSarkarPaymentFinal(distric,trackid,userid,mobile,name,str, serviceId, retunRti.getRtiApplnNumber(),retrurnurl);
									
					            }
					            //System.out.println("Status: " + statusValue);
					        }

						
						
						String EncyKey= authenticationResponseDTO.getKey();		
						log.debug("Final Key XXX-->>>"+EncyKey);
						
						if (!EncyKey.isEmpty()|| EncyKey !=null) {
							String redirectUrl = "https://aaplesarkar.mahaonline.gov.in/en/OutPayment/Pay?webstr="
							        + authenticationResponseDTO.getWebstring()
							        + "&DeptCode=NMCDeptN"
							        + "&Authentication="+EncyKey;
							
							log.debug("redirectUrl-->>>> XXX-->>>"+redirectUrl);

							return new ModelAndView("redirect:" + redirectUrl);
							//return "redirect:http://testcitizenservices.MahaITgov.in/en/OutPayment/Pay?webstr="+authenticationResponseDTO.getWebstring()+"&DeptCode=NGMCN&Authentication="+ EncyKey;
							//return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?EncyKey="+EncyKey+"&rtsAppNo="+retunRti.getRtiApplnNumber());

						} else {
							request.getSession().removeAttribute("mobileNo");
							return new ModelAndView("userError");
						}		
						

					}else {
						return new ModelAndView("redirect:/ws/rtsapplication/newRtSPropertyTaxMutationSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber()
						 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
								);
					}
				 }else {
					 
					 rtiApplicationService.delete(retunRti.getRtiApplicationId());
					 request.setAttribute("message", responseMessage);
					 return new ModelAndView("newRTIPropertyTaxRecovery");
				 }
				}
			}
		}catch(Exception ex){
			 rtiApplicationService.delete(retunRti.getRtiApplicationId());
			 request.setAttribute("message", responseMessage);
			 return new ModelAndView("newRTIPropertyTaxRecovery");
		}
			
		}
		
		return new ModelAndView("redirect:/ws/user/login.do");

	}

	
	@RequestMapping("ws/rtsapplication/newRtSPropertyTaxMutationSuccess.do")
	public ModelAndView newRtSPropertyTaxMutationSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		String isApleSarkar=request.getParameter("isApleSarkar");

		ModelAndView model = new ModelAndView("newRTIPropertyTaxMutationSuccess");
		
		model.addObject("propertyTaxMutation",appNo);
		model.addObject("isApleSarkar", isApleSarkar);

		return model;
				
		
	}
	
	
	
	@RequestMapping("/rtiapplication/savePropertyTaxMutationFees.do")
	public ModelAndView savePropertyTaxMutationFees(HttpServletRequest request,
			HttpServletResponse response, PropertyTaxMutation propertyTaxMutation)
			throws ServletException, Exception {
		String fees = request.getParameter("fees");
		long apprefid = Long.parseLong(request.getParameter("id")); 
		RTIApplication rtsapplication;
		propertyTaxMutation = propertyTaxMutationService.get(apprefid);
		if (propertyTaxMutation.getFees() == 0.0 && fees!=null && fees.length()>0) {
			apprefid = propertyTaxMutation.getRti_ref_id();
			rtsapplication = rtiApplicationService.get(propertyTaxMutation.getRti_ref_id());
			propertyTaxMutation.setFees(Double.parseDouble(fees));
			propertyTaxMutation = propertyTaxMutationService.merge(propertyTaxMutation);
			rtsapplication.setApplicationCost(propertyTaxMutation.getFees());
			rtiApplicationService.save(rtsapplication);
		}
		return new ModelAndView("redirect:/rtsapplication/editPropertyTaxMutation.do?rtiApplicationRefId=" + propertyTaxMutation.getPropertyTaxMutationId());	
		}
	
		/*
		 * @RequestMapping("/rtsapplication/editPropertyTaxMutation.do") public
		 * ModelAndView editPropertyTaxMutation(HttpServletRequest request,
		 * HttpServletResponse response) throws ServletException, Exception {
		 * 
		 * PropertyTaxMutation propertyTaxMutation = null; HttpSession session =
		 * request.getSession(); System.out.println("editPropertyTaxUtara"); long
		 * rtiApplicationRefId = 0; long rtiApplicationId = 0; RTIApplication
		 * rtiapplication = null; SessionUser sessionUser = (SessionUser)
		 * session.getAttribute("SessionUser"); if(sessionUser!=null) { if
		 * (request.getParameter("rtiApplicationRefId") != null &&
		 * request.getParameter("rtiApplicationRefId").length() > 0) {
		 * 
		 * rtiApplicationRefId =
		 * Long.parseLong(request.getParameter("rtiApplicationRefId"));
		 * propertyTaxMutation = propertyTaxMutationService.get(rtiApplicationRefId);
		 * 
		 * if (propertyTaxMutation.getRti_ref_id() > 0) { rtiApplicationId =
		 * propertyTaxMutation.getRti_ref_id(); rtiapplication =
		 * rtiApplicationService.get(rtiApplicationId); } else { List<RTIApplication>
		 * listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
		 * rtiApplicationRefId); if (listRTI != null && !listRTI.isEmpty()) {
		 * rtiApplicationId = listRTI.get(0).getRtiApplicationId(); rtiapplication =
		 * listRTI.get(0); } } }
		 * 
		 * request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		 * request.setAttribute(WorkflowConstants.WORKFLOW_NAME,
		 * CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
		 * request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME,
		 * CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
		 * request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		 * request.setAttribute("rtiApplication", rtiapplication);
		 * 
		 * WorkflowProcessDetails workflowProcessDetails = null; WorkflowProcessDetails
		 * processDetails = null; workflowProcessDetails = workflowProcessDetailsService
		 * .getWorkflowProcessDetailsByEntityDetails(rtiApplicationId,
		 * CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
		 * 
		 * if (workflowProcessDetails != null) { String processId =
		 * workflowProcessDetails.getProcessId(); if (processId != null) {
		 * processDetails =
		 * workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId)
		 * ; } if (!workflowService.isProcessEnded(processId)) { String taskId =
		 * workflowService.getCurrentTaskId(processId); Task task = null; if (taskId !=
		 * null) task = taskService.getTask(taskId); if (processDetails != null) {
		 * PersonalTask personalTask = new PersonalTask(); personalTask.setTask(task);
		 * personalTask.setEntityId(processDetails.getEntityId());
		 * personalTask.setEntityName(processDetails.getEntityName());
		 * personalTask.setWorkflowInitator(processDetails.getUserName());
		 * personalTask.setEntityDetails(processDetails.getEntityDetails());
		 * request.setAttribute("personalTask", personalTask); } if (task != null &&
		 * sessionUser.getUserName().equals(task.getAssignee()))
		 * request.setAttribute("userAccess", 1);
		 * 
		 * request.setAttribute("workFlowTask", task); } else {
		 * 
		 * request.setAttribute("workFlowCompleted", "1"); } }
		 * 
		 * ModelAndView modelAndView = new ModelAndView("managePropertyTaxMutation",
		 * "propertyTaxMutation", propertyTaxMutation);
		 * 
		 * return modelAndView;
		 * 
		 * }else { return new ModelAndView("/login.do"); } }
		 */

	@RequestMapping("/rtiapplication/createPropertyTaxMutationWork.do")
	public ModelAndView createPropertyTaxMutationWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_TAX_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		PropertyTaxMutation propertyTaxMutation = propertyTaxMutationService.get(applicationId);
		String email = propertyTaxMutation.getEmailid();
		String mobileNo = propertyTaxMutation.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();

		if (propertyTaxMutation != null) {
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
						int estServiceDays=25;
						String estServiceDate="NA";

						int reqFlag=0;
						int appStatus=2;
						String remark="NA";						
						String serviceId= rtiApplication.getAaple_service_id();
						String mobileApla=rtiApplication.getMobileNumber();
						//retunRti.setAaple_application_id(appId);
					String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
								 digitalSignStatus,digitalSignDate,estServiceDays, 
								 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
					}
					String paymentLink="http://tinyurl.com";
					String paymentLink2="ysvdjecd";
					
				    String msg = "Dear "+applicantName+" your document verification has been successfully completed. Kindly use this link "+paymentLink+"/"+paymentLink2+" to make a payment in order for your application "+rtiApplnNumber+" to be processed further. Regards, NMCGOV";

				    
					msg.replace("var3", "");
					SendEmail.sendEmail(email, "Payment link for your Appl. No." + mobileNo, msg);
					SendSMS.sendSingleSMS("1707168751764084788", "NMCGov", mobileNo, msg);
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
						String paymentStatus="Y";
						String paymentDate="NA";
						String digitalSignStatus="N";
						String digitalSignDate="NA";
						int estServiceDays=25;
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
						String paymentStatus="Y";
						String paymentDate="NA";
						String digitalSignStatus="N";
						String digitalSignDate="NA";
						int estServiceDays=25;
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
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_TAX_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		return new ModelAndView("redirect:/rtsapplication/editPropertyTaxMutation.do?rtiApplicationRefId="+rtirefId);
	}
	
	
	
	
	@RequestMapping("/rtsapplication/editPropertyTaxMutation.do")
	public ModelAndView editPropertyTaxMutation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
			
        PropertyTaxMutation propertyTaxMutation = null;
		HttpSession session = request.getSession();
		System.out.println("editPropertyTaxUtara");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if (sessionUser != null) {
			if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0) {

			rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
			propertyTaxMutation = propertyTaxMutationService.get(rtiApplicationRefId);

			if (propertyTaxMutation.getRti_ref_id() > 0) {
				rtiApplicationId = propertyTaxMutation.getRti_ref_id();
				rtiapplication = rtiApplicationService.get(rtiApplicationId);
			} else {
				List<RTIApplication> listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
						rtiApplicationRefId);
				if (listRTI != null && !listRTI.isEmpty()) {
					rtiApplicationId = listRTI.get(0).getRtiApplicationId();
					rtiapplication = listRTI.get(0);
				}
			}

      			request.setAttribute("rtiApplication", rtiapplication);



			} 
		}else {
			return new ModelAndView("redirect:/login.do");
			}
		return  new ModelAndView("managePropertyTaxMutation", "propertyTaxMutation", propertyTaxMutation);

	}
}
