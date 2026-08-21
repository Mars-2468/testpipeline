package com.mars.rti.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.model.User;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.NewWaterConnection;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.WaterConnectionPurpose;
import com.mars.rti.model.WaterDisconnection;
import com.mars.rti.model.WaterProposedTapSize;
import com.mars.rti.service.NewWaterConnectionService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.WaterConnectionTypeChangeService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.AuthenticationResponseDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class NewWaterConnectionController {
//	extends MultiActionController implements InitializingBean
	private static Log log = LogFactory.getLog(MandapPermissionController.class);
	
	String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";
	
	@Autowired
	private NewWaterConnectionService newWaterConnectionService;
	@Autowired
	private RTIApplicationService rtiApplicationService;
//
//	private static String const_OrderBy = "OrderBy";
//
//	private static String const_SortBy = "SortBy";

	@Autowired
	private WaterConnectionTypeChangeService waterConnectionTypeChangeService;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private UserRegistrationService userRegistrationService;

	@Autowired
	private UserService userService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;

	
	@RequestMapping("/rtsapplication/saveNewWaterConnection.do")
	public ModelAndView saveNewWaterConnection(HttpServletRequest request, HttpServletResponse response,
			NewWaterConnection newWaterConnection) throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking FireCompliance");
		}
		String mobileNumber = "";
		String user_name = null;
		Object user_login = request.getSession().getAttribute("name");
		if (user_login != null) {
			user_name = (String) user_login;
		}
		Object obileNumber = session.getAttribute("mobileNo");
		if (obileNumber != null) {
			mobileNumber = String.valueOf(obileNumber);
		} else {
			mobileNumber = (String) session.getAttribute("mobileNo");
		}
		RTIApplication retunRti = null;
		if (mobileNumber != null) {
			UserRegistrationDetails user = userRegistrationService.getUserByMobileNo(mobileNumber);
			Object as_status = session.getAttribute("as_status");

			if (newWaterConnection != null) {

				RTIApplication rtiApplication = new RTIApplication();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("NEW-WATER-CONNECTION");
				rtiApplication.setDepartment("WATER-DEPARTMENT");
				rtiApplication.setTemplateName("water");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(48);
				rtiApplication.setApplicantName(newWaterConnection.getFirstName() + " "
						+ newWaterConnection.getMiddleName() + " " + newWaterConnection.getLastName());
				rtiApplication.setPhoneNumber(Long.toString(newWaterConnection.getMobileNo()));
				if (as_status != null && user_name == null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);

				}
				rtiApplication.setMobileNumber(Long.toString(newWaterConnection.getMobileNo()));
				rtiApplication.setMobileNumber(String.valueOf(newWaterConnection.getMobileNo()));

				String upload = newWaterConnection.getFilesPath();

				rtiApplication.setPdfUploadFromPortal(newWaterConnection.getFilesPath());

				rtiApplication.setUserRegistrationDetails(user);
				rtiApplication.setZone(newWaterConnection.getZoneNo());
				rtiApplication.setIsApleSarkarApp(0);

				rtiApplication.setEmail(newWaterConnection.getEmail());
				rtiApplication.setApplicantName(newWaterConnection.getFullName());

				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(3);
				rtiApplicationDetails.setAssignToStatus(1);
				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());

				rtiApplicationDetails.setComments("Form Submitted");
				rtiApplicationDetails.setWorkflowLevel(0);
				rtiApplicationDetailsList.add(rtiApplicationDetails);
				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);

				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					String urls = rtiApplication.getPdfUploadFromPortal();

					rti.setRtiApplnNumber("RTS/WD" + "/" + savedRti.getRtiApplicationId() + "/" + Year.now());
					newWaterConnection.setRtiapplrefno(rti.getRtiApplnNumber());
					newWaterConnection.setRti_ref_id(savedRti.getRtiApplicationId());
					long water = newWaterConnectionService.newWaterConnection(newWaterConnection);
					rti.setRtiApplicationRefId(water);
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

					if ((retunRti != null) && (water > 0)) {
						String requestNo = newWaterConnection.getRtiapplrefno();
						LocalDate currentDate = LocalDate.now();
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						String date = format.format(currentDate);
						String salutation = newWaterConnection.getTitle();
						String firstName = newWaterConnection.getFirstName();
						String middleName = newWaterConnection.getMiddleName();
						String lastName = newWaterConnection.getLastName();
						String mobileNo = Long.toString(newWaterConnection.getMobileNo());
						String emailId = newWaterConnection.getEmail();
						String plotNo = newWaterConnection.getPlotNo();
						String layoutName = newWaterConnection.getLayoutName();
						String areaName = newWaterConnection.getRoadName();
						String landmark = newWaterConnection.getLandmark();
						String city = newWaterConnection.getCity();
						String pincode = newWaterConnection.getPinCode();
						String purposeofConnection = newWaterConnection.getPurposeOfWater();
						String zoneNo = newWaterConnection.getZoneNo();
						MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
						formData.add("RequestNo", requestNo);
						formData.add("date", date);
						formData.add("salutation", salutation);
						formData.add("firstName", firstName);
						formData.add("middleName", middleName);
						formData.add("lastName", lastName);
						formData.add("contactNo", mobileNo);
						formData.add("emailId", emailId);
						formData.add("houseNo", plotNo);
						formData.add("layoutName", layoutName);
						formData.add("areaName", areaName);
						formData.add("landmark", landmark);
						formData.add("zone", zoneNo);
						formData.add("city", city);
						formData.add("pin_code", pincode);
						formData.add("purpose_of_connection", purposeofConnection);
						formData.add("type", "newWaterConnection");

						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
						HttpEntity<MultiValueMap<Object, Object>> requestEntity = new HttpEntity<>(formData, headers);
						String url = CoreConstants.NEW_CONNECTION_WATER_TEST_POST;
						RestTemplate restTemplate = new RestTemplate();
						ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST,
								requestEntity, String.class);
						if (log.isDebugEnabled()) {

							log.debug("POST Successfull:-" + serverResponse + "\n" + requestEntity);
						}
					}

					String name = newWaterConnection.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = rti.getMobileNumber();
					String email = newWaterConnection.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}

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
						int estServiceDays=15;
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
						String mobileApla = String.valueOf(newWaterConnection.getMobileNo());
								
						
						
						/*
						 * String[] fields = request.getParameterValues("fields"); for (int i = 0; i <
						 * fields.length; i++) { log.debug("Index controller XXX--> " + i + ": " +
						 * fields[i]); }
						 */

						// String retrurnurl="https://nagpur.egovmars.in/RTSservices/ws/rtsapplication/newRtSNewWaterConnectionSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
						//String retrurnurl="https://nagpur.egovmars.in/RTSservices/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
						 String retrurnurl="https://nmcnagpur.gov.in/RTSservices/ws/rtsapplication/newRtSNewWaterConnectionSuccess.do?rtsAppNo="+appId+ "&isApleSarkar="+ retunRti.getIsApleSarkarApp();

						String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
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
					

				} else {
					return new ModelAndView("redirect:/ws/rtsapplication/newRtSNewWaterConnectionSuccess.do?rtsAppNo="
							+ retunRti.getRtiApplnNumber()
							 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
							);
				}
			}
		}
		return new ModelAndView("redirect:/ws/user/login.do");

	}

	@RequestMapping("ws/rtsapplication/newRtSNewWaterConnectionSuccess.do")
	public ModelAndView newRtSNewWaterConnectionSuccess(HttpServletRequest request, HttpServletResponse response) {

		String appNo = request.getParameter("rtsAppNo");
		String isApleSarkar=request.getParameter("isApleSarkar");

		ModelAndView model = new ModelAndView("newRTSWaterNewConnectionSuccess");

		model.addObject("newWaterConnection", appNo);
		model.addObject("isApleSarkar", isApleSarkar);

		return model;

	}

	@SuppressWarnings("unused")
	@RequestMapping("/rtsapplication/editNewWaterConnection.do")
	public ModelAndView editNewWaterConnection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		HttpSession session = request.getSession();
		NewWaterConnection newWaterConnection = null;
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		request.getSession().setAttribute("refid", request.getParameter("rtiApplicationRefId"));
		long userId = sessionUser.getUserId();

		String a1 = request.getParameter("rtiApplicationRefId");
		if (sessionUser != null) {

			if (request.getParameter("rtiApplicationRefId") != null
					&& request.getParameter("rtiApplicationRefId").length() > 0
					|| session.getAttribute("rtirefId") != null) {
				if (request.getParameter("rtiApplicationRefId") != null
						&& request.getParameter("rtiApplicationRefId").length() > 0) {

					rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
					newWaterConnection = newWaterConnectionService.get(rtiApplicationRefId);
				} else if (session.getAttribute("rtirefId") != null) {
					Object a = session.getAttribute("rtirefId");
					rtiApplicationRefId = (long) a;
					newWaterConnection = newWaterConnectionService.get(rtiApplicationRefId);
				}
				String feees = request.getParameter("fees");
				String paymentStatus = request.getParameter("paymentStatus");
				String higherApprovel = newWaterConnection.getHigherapprovalRemark();

				rtiApplicationId = newWaterConnection.getRti_ref_id();
				rtiapplication = rtiApplicationService.get(rtiApplicationId);

				if (higherApprovel != null && rtiapplication.getWorkFlowStatus() == 9) {
					rtiapplication.setWorkFlowStatus(10);
					rtiapplication = rtiApplicationService.merge(rtiapplication);
				}

				if (newWaterConnection.getRti_ref_id() > 0) {
					rtiApplicationId = newWaterConnection.getRti_ref_id();
					rtiapplication = rtiApplicationService.get(rtiApplicationId);
					if ((rtiapplication.getApplicationCost() == 0.0 || rtiapplication.getApplicationCost() == 0)
							&& rtiapplication.getWorkFlowStatus() != 10) {
						if (feees != null && feees != "" && !feees.isEmpty()) {
							rtiapplication.setApplicationCost(Double.parseDouble(feees));
							rtiapplication.setWorkFlowStatus(9);

							rtiapplication = rtiApplicationService.merge(rtiapplication);
						}
					}
					if (rtiapplication.getWorkFlowStatus() == 3) {
						if (paymentStatus != null && !paymentStatus.isEmpty() && paymentStatus.equals("Paid")) {
							rtiapplication.setWorkFlowStatus(2);
							rtiapplication = rtiApplicationService.merge(rtiapplication);
						}
					}
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
			request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_WATER_WORKFLOW_ENTITY);
			request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_WATER_WORKFLOW_ENTITY);
			request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
			request.setAttribute("rtiApplication", rtiapplication);

			WorkflowProcessDetails workflowProcessDetails = null;
			WorkflowProcessDetails processDetails = null;
			workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(
					rtiApplicationId, CoreConstants.RTI_WATER_WORKFLOW_ENTITY);

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

			request.setAttribute("totalfees", rtiapplication.getApplicationCost());
			request.setAttribute("workFlowStatus", rtiapplication.getWorkFlowStatus());
			newWaterConnection = newWaterConnectionService.get(rtiApplicationRefId);
			String higherapprovel = newWaterConnection.getHigherapprovalRemark();
			User user = userService.get(userId);
			String userLoginId = user.getUserLevel();

			if (userLoginId != null && !userLoginId.isEmpty()) {
				if (newWaterConnection.getDemandfees() == null || newWaterConnection.getApprovalRemark() == null
						|| newWaterConnection.getDemandfees().isEmpty()
						|| newWaterConnection.getApprovalRemark().isEmpty()) {
					request.setAttribute("for2remarks", "hide");
				} else {
					if (userLoginId.equals("L2")) {
						if (rtiapplication.getWorkFlowStatus() == 9) {
							request.setAttribute("for2remarks", "show");
							request.setAttribute("for2ndSave", "show");
						} else {
							request.setAttribute("for2remarks", "show");
							request.setAttribute("for2ndSave", "hide");
						}
					}
				}

				if (userLoginId.equals("L2")) {
					if (newWaterConnection.getDemandfees() != null || newWaterConnection.getApprovalRemark() != null) {
						if (newWaterConnection.getHigherapprovalRemark() != null)
							request.setAttribute("for2ndSave", "hide");
						else
							request.setAttribute("for2ndSave", "show");
					} else {
						request.setAttribute("for2ndSave", "hide");
					}

					if ((newWaterConnection.getPurposeOfWater().equals("Residential (निवासी)")
							|| newWaterConnection.getPurposeOfWater().equals("Slum (झोपडपट्टी)"))
							&& Integer.parseInt(newWaterConnection.getTapSize()) <= 25 && userLoginId.equals("L2")) {
						request.setAttribute("for2remarks", "hide");
						if (rtiapplication.getWorkFlowStatus() == 9 || rtiapplication.getWorkFlowStatus() == 10
								|| rtiapplication.getWorkFlowStatus() == 0 || rtiapplication.getWorkFlowStatus() == 5
								|| rtiapplication.getWorkFlowStatus() == 1) {
							if (newWaterConnection.getDemandfees() != null
									|| newWaterConnection.getApprovalRemark() != null) {
								request.setAttribute("forLogin", "show");
								request.setAttribute("for2ndSave", "hide");
							} else {
								request.setAttribute("forLogin", "hide");
							}
						}
					} else {
						if (rtiapplication.getWorkFlowStatus() == 9 || rtiapplication.getWorkFlowStatus() == 10
								|| rtiapplication.getWorkFlowStatus() == 0) {
							request.setAttribute("forLogin", "hide");
						}
						if (rtiapplication.getWorkFlowStatus() == 5 || rtiapplication.getWorkFlowStatus() == 1) {
							request.setAttribute("forLogin", "show");
						}
					}

				} else if (userLoginId.equals("L3")) {

					if (newWaterConnection.getDemandfees() == null || newWaterConnection.getApprovalRemark() == null
							|| newWaterConnection.getHigherapprovalRemark() == null
							|| newWaterConnection.getDemandfees().isEmpty()
							|| newWaterConnection.getApprovalRemark().isEmpty()
							|| newWaterConnection.getHigherapprovalRemark().isEmpty()) {
						request.setAttribute("forLogin", "hide");
					} else {

						if ((newWaterConnection.getPurposeOfWater().equals("Residential (निवासी)")
								|| newWaterConnection.getPurposeOfWater().equals("Slum (झोपडपट्टी)"))
								&& Integer.parseInt(newWaterConnection.getTapSize()) <= 25
								&& userLoginId.equals("L3")) {
							if (rtiapplication.getWorkFlowStatus() == 9 || rtiapplication.getWorkFlowStatus() == 10
									|| rtiapplication.getWorkFlowStatus() == 0
									|| rtiapplication.getWorkFlowStatus() == 5
									|| rtiapplication.getWorkFlowStatus() == 1) {
								request.setAttribute("forLogin", "hide");
							} else {
								request.setAttribute("for2remarks", "show");
							}
						} else {
							if (rtiapplication.getWorkFlowStatus() == 9 || rtiapplication.getWorkFlowStatus() == 10
									|| rtiapplication.getWorkFlowStatus() == 0
									|| rtiapplication.getWorkFlowStatus() == 5
									|| rtiapplication.getWorkFlowStatus() == 1)
								request.setAttribute("forLogin", "show");
							request.setAttribute("for2remarks", "show");
						}
					}
				} else {
					if (rtiapplication.getWorkFlowStatus() == 9 || rtiapplication.getWorkFlowStatus() == 10
							|| rtiapplication.getWorkFlowStatus() == 0 || rtiapplication.getWorkFlowStatus() == 1) {
						request.setAttribute("forLogin", "hide");
						request.setAttribute("for2remarks", "show");
					} else
						request.setAttribute("forLogin", "show");

					if (rtiapplication.getWorkFlowStatus() == 3)
						request.setAttribute("saveFees", "show");

					if (rtiapplication.getWorkFlowStatus() == 0)
						request.setAttribute("for2ndSave", "show");
					else
						request.setAttribute("for2ndSave", "hide");

					request.setAttribute("forPaidCheckbox", "3");

					if (rtiapplication.getWorkFlowStatus() != 3 && rtiapplication.getWorkFlowStatus() != 0
							&& rtiapplication.getWorkFlowStatus() != 9 && rtiapplication.getWorkFlowStatus() != 10)
						request.setAttribute("forLogin", "show");

					if (higherapprovel != null)
						request.setAttribute("for2remarks", "show");
					else
						request.setAttribute("for2remarks", "hide");

				}

			}

			List<WaterConnectionPurpose> purposeOfWater = newWaterConnectionService.getWaterConnectionPurpose();
			request.setAttribute("purposeOfWater", purposeOfWater);

			List<WaterProposedTapSize> tapSize = waterConnectionTypeChangeService.getProposedTapSize();
			request.setAttribute("tapSize", tapSize);

			ModelAndView modelAndView = new ModelAndView("manageNewWaterConnection", "newWaterConnection",
					newWaterConnection);

			return modelAndView;
		} else {
			return new ModelAndView("redirect:/login.do");
		}
	}

	@RequestMapping("/rtiapplication/createWaterNewConnectionWork.do")
	public ModelAndView createWaterNewConnectionWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_WATER_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		NewWaterConnection newWaterConnection = newWaterConnectionService.get(applicationId);
		String email = newWaterConnection.getEmail();
		String mobileNo = rtiApplication.getMobileNumber();

		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();

		if (newWaterConnection != null) {
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

//					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS_L1);
//					rtiApplication.setWorkflowComments(workflow_comments);
//					
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
							int estServiceDays=15;
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
						log.debug("Final  PushBAck status XXX for send demand-->>>"+pushBackrespose);
						log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
								" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
								" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
								" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
								" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
						);
						}
					 SendSMSEmailController.sendWaterPayment(applicantName, mobileNo, rtiApplnNumber, email);

					if (request.getParameter("WORKFLOW_TRANSISTION").isEmpty()
							|| request.getParameter("WORKFLOW_TRANSISTION") == null) {

					}
					if (task != null && sessionUser.getUserName().equals(task.getAssignee())) {
						request.setAttribute("userAccess", 1);
						request.setAttribute("workFlowTask", task);
					}
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Close-Application")) {

					rtiApplication.setWorkFlowStatus(1);

//					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS_L2);
//					rtiApplication.setWorkflowComments(workflow_comments);
//					
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
						int estServiceDays=15;
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
					SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

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
						int estServiceDays=15;
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
					SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				}
			} else {
				session.setAttribute("rejected", 5);
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
					int estServiceDays=15;
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
				SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

				request.setAttribute("workFlowCompleted", "1");

			}

		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_WATER_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_WATER_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		session.setAttribute("rtirefId", rtirefId);

		return new ModelAndView("redirect:/rtsapplication/editNewWaterConnection.do");
//		
//		ModelAndView modelAndView = new ModelAndView("manageNewWaterConnection", "newWaterConnection",
//				newWaterConnection);
//		return modelAndView;
	}

	// Save Manage Disconnection

	@RequestMapping("/rtsapplication/saveNewConnectionWater.do")
	public ModelAndView saveNewConnectionWater(HttpServletRequest request, HttpServletResponse response,
			NewWaterConnection newWaterConnection) throws ServletException, Exception {
		String fees = request.getParameter("demandfees");
		String tapsize = request.getParameter("tapSize");
		String approvalRemark = request.getParameter("approvalRemark");
		String plotNo = request.getParameter("plotNo");
		String buildingName = request.getParameter("buildingName");
		String layoutName = request.getParameter("layoutName");
		String higherapprovalRemark = request.getParameter("higherapprovalRemark");
		String roadName = request.getParameter("roadName");
		String landmark = request.getParameter("landmark");
		String purposeOfWater = request.getParameter("purposeOfWater");

		String commCategory = request.getParameter("commCategory");
		String instCategory = request.getParameter("instCategory");
		String totalPlotNo = request.getParameter("totalPlotNo");
		String slum = request.getParameter("slum");
		String residential = request.getParameter("residential");

		String address = request.getParameter("address");

		String refid = request.getParameter("newWaterConnectionId");
		long apprefid = 0;
		apprefid = Long.parseLong(refid);

		newWaterConnection = newWaterConnectionService.get(apprefid);
//				waterDisconnection.setSendDemandStatus(1);

		if ((newWaterConnection.getDemandfees() == null && fees != null) && tapsize != null
				&& (newWaterConnection.getApprovalRemark() == null && approvalRemark != null)) {

			newWaterConnection.setDemandfees(fees);
			newWaterConnection.setTapSize(tapsize);
			newWaterConnection.setApprovalRemark(approvalRemark);
			newWaterConnection.setPlotNo(plotNo);
			newWaterConnection.setBuildingName(buildingName);
			newWaterConnection.setLayoutName(layoutName);
			newWaterConnection.setRoadName(roadName);
			newWaterConnection.setLandmark(landmark);
			newWaterConnection.setPurposeOfWater(purposeOfWater);
			newWaterConnection.setResidential(residential);

			newWaterConnection.setCommCategory(commCategory);
			newWaterConnection.setInstCategory(instCategory);
			newWaterConnection.setTotalPlotNo(totalPlotNo);
			newWaterConnection.setSlum(slum);
			newWaterConnection.setAddress(address);

			newWaterConnection = newWaterConnectionService.merge(newWaterConnection);

		} else {
			newWaterConnection.setHigherapprovalRemark(higherapprovalRemark);
			newWaterConnection = newWaterConnectionService.merge(newWaterConnection);

		}

		return new ModelAndView(
				"redirect:/rtsapplication/editNewWaterConnection.do?rtiApplicationRefId=" + apprefid + "&fees=" + fees);
	}

	@RequestMapping("/rtsapplication/saveNewConnectionWaterPayment.do")
	public ModelAndView saveNewConnectionWaterPayment(HttpServletRequest request, HttpServletResponse response,
			NewWaterConnection newWaterConnection) throws ServletException, Exception {
		String payStatus = request.getParameter("paymentStatus");
		String refid = request.getParameter("newWaterConnectionId");
		long apprefid = 0;
		apprefid = Long.parseLong(refid);


		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);
		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();

		newWaterConnection = newWaterConnectionService.get(apprefid);
//				waterDisconnection.setSendDemandStatus(1);
		String status = newWaterConnection.getPaymentStatus();
		if (newWaterConnection.getPaymentStatus() == null && payStatus != null) {
			newWaterConnection.setPaymentStatus(payStatus);
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
				int estServiceDays=15;
				String estServiceDate="NA";

				int reqFlag=0;
				int appStatus=3;
				String remark="NA";						
				String serviceId= rtiApplication.getAaple_service_id();
				String mobileApla=rtiApplication.getMobileNumber();
				//retunRti.setAaple_application_id(appId);
			String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
						 digitalSignStatus,digitalSignDate,estServiceDays, 
						 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
            log.debug("Aple Sarkar pushBackrespose workflow payment completed: " +pushBackrespose);
			log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
					" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
					" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
					" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
					" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
			);
          	}
			newWaterConnection = newWaterConnectionService.merge(newWaterConnection);

		}
		return new ModelAndView("redirect:/rtsapplication/editNewWaterConnection.do?rtiApplicationRefId=" + apprefid
				+ "&paymentStatus=" + payStatus);
	}
}
