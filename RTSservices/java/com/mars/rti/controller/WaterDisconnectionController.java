package com.mars.rti.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
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
import org.json.JSONObject;
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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.model.User;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.MTPRegistrationCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.WaterDisconnection;
import com.mars.rti.model.WaterDisconnectionPOJO;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.WaterDisconnectionService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.AuthenticationResponseDTO;
import com.mars.rti.ws.model.WaterDisconnectionRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class WaterDisconnectionController {
	private static Log log = LogFactory.getLog(WaterDisconnectionController.class);
	
	String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";
	
	@Autowired
	private WaterDisconnectionService waterDisconnectionService;
	@Autowired
	private RTIApplicationService rtiApplicationService;
//
//	private static String const_OrderBy = "OrderBy";
//
//	private static String const_SortBy = "SortBy";

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

@Autowired
	private UserRegistrationService userRegistrationService;


	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;

	@Autowired
	private AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;


// 	@RequestMapping("ws/rtiapplication/newRTIMandapApplication.do")
// 	public ModelAndView newRTIMandapApplication(HttpServletRequest request, HttpServletResponse response)
// 			throws ServletException {
// 		String baseDir = getServletContext().getRealPath("");
//		String folder = "mandapPermission";
//		File file = new File(baseDir, folder);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
// 		ModelAndView modelAndView = new ModelAndView("newRTIMandapApplication");
//		modelAndView.addObject("folderName", folder);
// 		return modelAndView;s
// 	}rtsapplication/saveWaterDisconnectionCertificates.do

	@RequestMapping("/rtsapplication/saveWaterDisconnectionCertificates.do")
	public ModelAndView saveWaterDisconnection(HttpServletRequest request, HttpServletResponse response,
			WaterDisconnection waterDisconnection) throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Water Disconnection");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking WaterDisconnection");
		}
		String zone1 = null;
		String mobileNumber = "";
		RTIApplication retunRti = null;
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
			UserRegistrationDetails user = userRegistrationService.getUserByMobileNo(mobileNumber);
			Object as_status=session.getAttribute("as_status");

			if (waterDisconnection != null) {

				RTIApplication rtiApplication = new RTIApplication();
				WaterDisconnectionRestDTO waterDisconnectionRestDTO = new WaterDisconnectionRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("WATER-DISCONNECTION-CERTIFICATE");
				rtiApplication.setDepartment("WATER-DEPARTMENT");
				rtiApplication.setTemplateName("water");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(6);
				rtiApplication.setApplicantName(waterDisconnection.getCINNo());
				rtiApplication.setPhoneNumber(waterDisconnection.getMobileNo());
				rtiApplication.setIsApleSarkarApp(0);

//				if (waterDisconnection.getAlterMobileNo() != null && !waterDisconnection.getAlterMobileNo().isEmpty()) {
//					rtiApplication.setMobileNumber(waterDisconnection.getAlterMobileNo());
//
//
//				}else {
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
				}
					rtiApplication.setMobileNumber(waterDisconnection.getMobileNo());
				
				rtiApplication.setEmail(waterDisconnection.getEmail());
				rtiApplication.setUserRegistrationDetails(user);
				if (waterDisconnection.getZoneNo() != null) {
					rtiApplication.setZone(waterDisconnection.getZoneNo().equals("Zone No.1 - Laxmi Nagar")
							|| waterDisconnection.getZoneNo().equals("Zone No.01 - Laxmi Nagar")
									? "1"
									: waterDisconnection.getZoneNo().equals("Zone No.2 - Dharampeth")
											|| waterDisconnection.getZoneNo().equals("Zone No.02 - Dharampeth")
													? "2"
													: waterDisconnection.getZoneNo().equals("Zone No.3 - Hanuman Nagar")
															|| waterDisconnection.getZoneNo()
																	.equals("Zone No.03 - Hanuman Nagar")
																			? "3"
																			: waterDisconnection.getZoneNo()
																					.equals("Zone No.4 - Dhantoli")
																					|| waterDisconnection.getZoneNo()
																							.equals("Zone No.04 - Dhantoli")
																									? "4"
																									: waterDisconnection
																											.getZoneNo()
																											.equals("Zone No.5 - Nehru Nagar")
																											|| waterDisconnection
																													.getZoneNo()
																													.equals("Zone No.05 - Nehru Nagar")
																															? "5"
																															: waterDisconnection
																																	.getZoneNo()
																																	.equals("Zone No.6 - Gandhibagh")
																																	|| waterDisconnection
																																			.getZoneNo()
																																			.equals("Zone No.06 - Gandhibagh")
																																					? "6"
																																					: waterDisconnection
																																							.getZoneNo()
																																							.equals("Zone No.7 - Satranjipura")
																																							|| waterDisconnection
																																									.getZoneNo()
																																									.equals("Zone No.07 - Satranjipura")
																																											? "7"
																																											: waterDisconnection
																																													.getZoneNo()
																																													.equals("Zone No.8 - Lakadganj")
																																													|| waterDisconnection
																																															.getZoneNo()
																																															.equals("Zone No.08 - Lakadganj")
																																																	? "8"
																																																	: waterDisconnection
																																																			.getZoneNo()
																																																			.equals("Zone No.9 - Ashi Nagar")
																																																			|| waterDisconnection
																																																					.getZoneNo()
																																																					.equals("Zone No.09 - Ashi Nagar")
																																																							? "9"
																																																							: waterDisconnection
																																																									.getZoneNo()
																																																									.equals("Zone No.10 - Mangalwari")
																																																									|| waterDisconnection
																																																											.getZoneNo()
																																																											.equals("Zone No.010 - Mangalwari")
																																																													? "10"
																																																													: "");
				}
				// rtiApplication.setApplicationCost(waterDisconnection.getFeesApplicable());

				rtiApplication.setApplicantName(waterDisconnection.getCINNo());
				rtiApplication.setPdfUploadFromPortal(waterDisconnection.getFilesPath());
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
					rti.setRtiApplnNumber("RTS/WD" + "/" + savedRti.getRtiApplicationId()  + "/" + Year.now());
					waterDisconnection.setRtiapplrefno(rti.getRtiApplnNumber());
					waterDisconnection.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = waterDisconnectionService.waterDisconnection(waterDisconnection);
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

					if ((retunRti != null) && (waterDisconnection.getRti_ref_id() > 0)) {
						String requestNo = waterDisconnection.getRtiapplrefno();
						LocalDate currentDate = LocalDate.now();
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						String date = format.format(currentDate);
						String mobileNo = waterDisconnection.getMobileNo();
						String emailId = waterDisconnection.getEmail();
						// String purpose = waterDisconnection.getPurpose();
						MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
						formData.add("requestNo", requestNo);
						formData.add("date", date);
						formData.add("contractAccountNo", waterDisconnection.getCINNo());
						formData.add("type", "disconnection");
						formData.add("contactNo", mobileNo);
						formData.add("emailId", emailId);
						// formData.add("purpose", purpose);
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
						HttpEntity<MultiValueMap<Object, Object>> requestEntity = new HttpEntity<>(formData, headers);
						 String url=CoreConstants.DISCONNECTION_WATER_TEST_POST;

						//String url = "https://sampark.ocwindia.com/aaplesarkar/customer/request/?key=6aa083ae54aae4a7fad7659c6fbfd0bc";
						RestTemplate restTemplate = new RestTemplate();
						ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST,
								requestEntity, String.class);
						if (log.isDebugEnabled()) {

							log.debug("POST Successfull:-" + serverResponse + "\n" + requestEntity);
						}
					}
//					String requestNo = waterDisconnection.getRtiapplrefno();
//					LocalDate currentDate = LocalDate.now();
//					DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//					String date = format.format(currentDate);
//					MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
//					formData.add("RequestNo", requestNo);
//					formData.add("date", date);
//					formData.add("salutation", waterDisconnection.getTitle());
//					formData.add("firstName", waterDisconnection.getFirstName());
//					formData.add("middleName", waterDisconnection.getMiddleName());
//					formData.add("lastName", waterDisconnection.getLastName());
//					formData.add("type", "dissconnection");
//					formData.add("contactNo", waterDisconnection.getLastName());
//					formData.add("emailId", waterDisconnection.getEmail());
//					formData.add("houseNo", waterDisconnection.getPlotNo());
//					formData.add("buildingName", waterDisconnection.getBuildingName());
//					formData.add("streetName", waterDisconnection.getStreetName() );
//					formData.add("areaName", waterDisconnection.getAreaName() );
//					formData.add("landmark",  waterDisconnection.getLandmark());
//					formData.add("pincode", waterDisconnection.getPincode());
//					formData.add("aadhaarNo", waterDisconnection.getAadhaarNo());
//					formData.add("address", waterDisconnection.getAddress());
//					formData.add("CINNo", waterDisconnection.getCINNo());
//					formData.add("zoneNo", waterDisconnection.getZoneNo());
//					formData.add("consumerName", waterDisconnection.getConsumerName());
//					formData.add("consumerAddress", waterDisconnection.getConsumerAddress());
//					formData.add("consumerNo", waterDisconnection.getConsumerNo());
//					formData.add("meterNo", waterDisconnection.getMeterNo());
//					formData.add("dreceiptNo", waterDisconnection.getDreceiptNo());
//					formData.add("receiptDate", waterDisconnection.getReceiptDate());
//					//formData.add("purpose_of_connection", purposeofConnection);
//					HttpHeaders headers = new HttpHeaders();
//					headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//					HttpEntity<MultiValueMap<Object, Object>> requestEntity = new HttpEntity<>(formData, headers);
//					String url = "http://13.126.30.25/aaplesarkar/customer/newConnection/?key=6aa083ae54aae4a7fad7659c6fbfd0bc";
//					RestTemplate restTemplate = new RestTemplate();
//					ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
//							String.class);
//					if (log.isDebugEnabled()) {
//
//						log.debug("POST Successfull:-" + serverResponse + "\n" + requestEntity);
//					}
//				}

					String name = waterDisconnection.getCINNo();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = rti.getMobileNumber();
					String email=waterDisconnection.getEmail();
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
						int estServiceDays=7;
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
						String mobileApla = waterDisconnection.getMobileNo();
						
						
						/*
						 * String[] fields = request.getParameterValues("fields"); for (int i = 0; i <
						 * fields.length; i++) { log.debug("Index controller XXX--> " + i + ": " +
						 * fields[i]); }
						 */

						 String retrurnurl="https://nmcnagpur.gov.in/RTSservices/ws/rtsapplication/newRTIWaterDisconnectionSuccess.do?rtsAppNo="+appId+ "&isApleSarkar="+ retunRti.getIsApleSarkarApp();
						//String retrurnurl="https://nagpur.egovmars.in/RTSservices/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
						
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
					

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRTIWaterDisconnectionSuccess.do?rtsAppNo="+ retunRti.getRtiApplnNumber()
				 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
				);
				}
			}

		}
		return new ModelAndView("redirect:/ws/user/login.do");

	}

	@RequestMapping("ws/rtsapplication/newRTIWaterDisconnectionSuccess.do")
	public ModelAndView newRTIWaterDisconnectionSuccess(HttpServletRequest request, HttpServletResponse response) {

		String appNo = request.getParameter("rtsAppNo");
		String isApleSarkar=request.getParameter("isApleSarkar");
		ModelAndView model = new ModelAndView("newRTIWaterDisconnectionSuccess");
		model.addObject("waterDisconnection", appNo);

		model.addObject("isApleSarkar", isApleSarkar);
		return model;

	}

	@RequestMapping("/rtsapplication/getApplicationDetails.do")
	public void getApplicationDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {

		log.debug(" came inside get water reconnection");
		JSONObject json = new JSONObject();
		String msgNode = null;
		PrintWriter out = response.getWriter();
		String status = null;
		try {
			// String canNumber = waterDisconnection.getCINNo();
			String canNumber = request.getParameter("cinNo");
			StringBuilder response1 = new StringBuilder();
			log.debug("sadfghjklhgfdsg");
//			String restUrl = "https://sampark.ocwindia.com/aaplesarkar/customer/getCan?key=6aa083ae54aae4a7fad7659c6fbfd0bc&contractAccountNo="
//					+ canNumber + "&type=reconnection";
//			
			String restUrl = "https://sampark.ocwindia.com/aaplesarkar/customer/getCan?key=6aa083ae54aae4a7fad7659c6fbfd0bc&contractAccountNo="
					+ canNumber + "&type=disconnection";

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			String res = response1.toString();
			log.debug(res);
			ObjectMapper objectMapper = new ObjectMapper();
			RestTemplate restTemplate = new RestTemplate();
			URI uri = URI.create(restUrl);

			ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

			JsonNode rootNode = objectMapper.readTree(responseEntity.getBody().toString());
			msgNode = rootNode.get("msg").asText();
			status = rootNode.get("status").asText();
			System.out.println();
				

				JsonNode responseData = rootNode.get("data");
				if (responseData.isArray() && status.equals("1")) {
					
					for (JsonNode item : responseData) {
						String zone = item.path("zone").asText();
						String zoneName = "Zone No.";
						if (zone.equals("01") || zone.equals("1")) {

							zoneName = zoneName + zone + " " + "-" + " " + "Laxmi Nagar";

						} else if (zone.equals("2") || zone.equals("02")) {
							zoneName = zoneName + zone + " " + "-" + " " + "Dharampeth";

						} else if (zone.equals("3") || zone.equals("03")) {
							zoneName = zoneName + zone + " " + "-" + " " + "Hanuman Nagar";

						} else if (zone.equals("4") || zone.equals("04")) {
							zoneName = zoneName + zone + " " + "-" + " " + "Dhantoli";

						} else if (zone.equals("5") || zone.equals("05")) {
							zoneName = zoneName + zone + " " + "-" + " " + "Nehru Nagar";

						} else if (zone.equals("6") || zone.equals("06")) {
							zoneName = zoneName + zone + " " + "-" + " " + "Gandhibagh";

						} else if (zone.equals("7") || zone.equals("07")) {
							zoneName = zoneName + zone + " " + "-" + " " + "Satranjipura";

						} else if (zone.equals("8") || zone.equals("08")) {
							zoneName = zoneName + zone + " " + "-" + " " + "Lakadganj";

						} else if (zone.equals("9") || zone.equals("09")) {
							zoneName = zoneName + zone + " " + "-" + " " + "Ashi Nagar";

						} else if (zone.equals("10") || zone.equals("010")) {
							zoneName = zoneName + zone + " " + "-" + " " + "Mangalwari";

						}
						String esr = item.path("command_area").asText();
						String consumerName = item.path("consumerName").asText();
						String address = item.path("address").asText();
						String meterNo = item.path("meterNo").asText();
						String tapSize = item.path("tap_size").asText();
						String category = item.path("category").asText();
						String balanceArrears = item.path("balance_arrears").asText();
						String cutOffDate = item.path("cut_off_date").asText();
						String contact_no = item.path("contact_no").asText();
						String email_id = item.path("email_id").asText();

						esr = esr != null ? esr : "";
						consumerName = consumerName != null ? consumerName : "";
						address = address != null ? address : "";
						meterNo = meterNo != null ? meterNo : "";
						tapSize = tapSize != null ? tapSize : "";
						category = category != null ? category : "";
						balanceArrears = balanceArrears != null ? balanceArrears : "";
						// Set contact_no to "0" if it's null or empty
						contact_no = contact_no != null && contact_no != "" ? contact_no : "0";

						// Set email_id to "0" if it's null or empty
						email_id = email_id != null && email_id != "" ? email_id : "0" ;


						json.put("zone", zoneName);
						json.put("esr", esr);
						json.put("consumername", consumerName);
						json.put("address", address);
						json.put("meterno", meterNo);
						json.put("meterTapSize", tapSize);
						json.put("category", category);
						json.put("balance_arrears", balanceArrears);
						json.put("cut_off_date", cutOffDate);
						json.put("contact_no", contact_no);
						json.put("email_id", email_id);
						out.print(json.toString());
						out.flush();
					}
				}

			

			else if (status.equals("0")) {
				json.put("errormsg", msgNode);
				out.print(json.toString());
				out.flush();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	/*
	 * @RequestMapping("/rtsapplication/getApplicationDetails.do") public void
	 * getApplicationDetails(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, Exception {
	 * 
	 * log.debug(" came inside get water disconnection"); JSONObject json = new
	 * JSONObject();
	 * 
	 * 
	 * try { // String canNumber = waterDisconnection.getCINNo(); String canNumber =
	 * request.getParameter("cinNo"); StringBuilder response1 = new StringBuilder();
	 * log.debug("sadfghjklhgfdsg"); String restUrl =
	 * "https://sampark.ocwindia.com/aaplesarkar/customer/getCan?key=6aa083ae54aae4a7fad7659c6fbfd0bc&contractAccountNo="
	 * + canNumber + "&type=disconnection";
	 * 
	 * log.debug("sadfghjklhgfdsg");
	 * 
	 * URL url = new URL(restUrl); HttpURLConnection conn = (HttpURLConnection)
	 * url.openConnection(); conn.setRequestMethod("GET"); conn.connect();
	 * log.debug("sadfghjklhgfdsg");
	 * 
	 * int responseCode = conn.getResponseCode(); if (responseCode ==
	 * HttpURLConnection.HTTP_OK) { BufferedReader in = new BufferedReader(new
	 * InputStreamReader(conn.getInputStream())); String inputLine; while
	 * ((inputLine = in.readLine()) != null) { response1.append(inputLine); }
	 * in.close();
	 * 
	 * log.debug("sadfghjklhgfdsg");
	 * 
	 * } String res = response1.toString(); log.debug(res); ObjectMapper
	 * objectMapper = new ObjectMapper();
	 * objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
	 * false); WaterDisconnectionPOJO responseData = new WaterDisconnectionPOJO();
	 * responseData = objectMapper.readValue(res, WaterDisconnectionPOJO.class);
	 * System.out.println(); ArrayList<String> list = new ArrayList<String>();
	 * 
	 * log.debug("ggggggg" + responseData.getData().get(0).getConsumerName());
	 * 
	 * String zone = responseData.getData().get(0).getZone(); String zoneName =
	 * "Zone No."; if (zone.equals("01") || zone.equals("1")) {
	 * 
	 * zoneName = zoneName + zone + " " + "-" + " " + "Laxmi Nagar";
	 * 
	 * } else if (zone.equals("2") || zone.equals("02")) { zoneName = zoneName +
	 * zone + " " + "-" + " " + "Dharampeth";
	 * 
	 * } else if (zone.equals("3") || zone.equals("03")) { zoneName = zoneName +
	 * zone + " " + "-" + " " + "Hanuman Nagar";
	 * 
	 * } else if (zone.equals("4") || zone.equals("04")) { zoneName = zoneName +
	 * zone + " " + "-" + " " + "Dhantoli";
	 * 
	 * } else if (zone.equals("5") || zone.equals("05")) { zoneName = zoneName +
	 * zone + " " + "-" + " " + "Nehru Nagar";
	 * 
	 * } else if (zone.equals("6") || zone.equals("06")) { zoneName = zoneName +
	 * zone + " " + "-" + " " + "Gandhibagh";
	 * 
	 * } else if (zone.equals("7") || zone.equals("07")) { zoneName = zoneName +
	 * zone + " " + "-" + " " + "Satranjipura";
	 * 
	 * } else if (zone.equals("8") || zone.equals("08")) { zoneName = zoneName +
	 * zone + " " + "-" + " " + "Lakadganj";
	 * 
	 * } else if (zone.equals("9") || zone.equals("09")) { zoneName = zoneName +
	 * zone + " " + "-" + " " + "Ashi Nagar";
	 * 
	 * } else if (zone.equals("10") || zone.equals("010")) { zoneName = zoneName +
	 * zone + " " + "-" + " " + "Mangalwari";
	 * 
	 * }
	 * 
	 * json.put("zone", zoneName); json.put("esr",
	 * responseData.getData().get(0).getCommand_area()); json.put("consumername",
	 * responseData.getData().get(0).getConsumerName()); json.put("address",
	 * responseData.getData().get(0).getAddress()); json.put("meterno",
	 * responseData.getData().get(0).getMeterNo()); json.put("meterTapSize",
	 * responseData.getData().get(0).getTap_size()); json.put("category",
	 * responseData.getData().get(0).getCategory()); json.put("balance_arrears",
	 * responseData.getData().get(0).getBalance_arrears()); json.put("cut_off_date",
	 * responseData.getData().get(0).getCut_off_date());
	 * 
	 * PrintWriter out = response.getWriter(); out.print(json.toString());
	 * out.flush(); } catch (Exception e) { String error =
	 * "Record Not Found! Please Enter Valid CAN No.";
	 * request.setAttribute("message", error); }
	 * 
	 * 
	 * }
	 */

	@SuppressWarnings("unused")
//	@RequestMapping("/rtsapplication/editWaterDisconnection.do")
//	public ModelAndView editWaterDisconnection(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, Exception {
//		HttpSession session = request.getSession();
//
//		WaterDisconnection waterDisconnection = null;
//		long rtiApplicationRefId = 0;
//		long rtiApplicationId = 0;
//		RTIApplication rtiapplication = null;
//		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
//		request.getSession().setAttribute("refid",request.getParameter("rtiApplicationRefId"));
//	
//		if (request.getParameter("rtiApplicationRefId") != null
//				&& request.getParameter("rtiApplicationRefId").length() > 0) {
//
//			rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
//			waterDisconnection = waterDisconnectionService.get(rtiApplicationRefId);
//
//			if (waterDisconnection.getRti_ref_id() > 0) {
//				rtiApplicationId = waterDisconnection.getRti_ref_id();
//				rtiapplication = rtiApplicationService.get(rtiApplicationId);
//			} 
//		    String fees = request.getParameter("demandfees");
//			if (waterDisconnection.getRti_ref_id() > 0) {
//				rtiApplicationId = waterDisconnection.getRti_ref_id();
//				rtiapplication = rtiApplicationService.get(rtiApplicationId);
//				if (rtiapplication.getApplicationCost() == 0.0
//						|| rtiapplication.getApplicationCost() == 0) {
//					if(fees!=null) {
//					rtiapplication.setApplicationCost(Double.parseDouble(fees));
//					rtiapplication = rtiApplicationService.merge(rtiapplication);
//					}
//				}
//
//			}
//			else {
//				List<RTIApplication> listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
//						rtiApplicationRefId);
//				if (listRTI != null && !listRTI.isEmpty()) {
//					rtiApplicationId = listRTI.get(0).getRtiApplicationId();
//					rtiapplication = listRTI.get(0);
//				}
//			}
//			request.setAttribute("rtiApplication", rtiapplication);
//
//		}
//
//		ModelAndView modelAndView = new ModelAndView("manageWaterDisconnection", "waterDisconnection",
//				waterDisconnection);
//
//		return modelAndView;
//	}
	//
	@RequestMapping("/rtsapplication/editWaterDisconnection.do")
	public ModelAndView editWaterDisconnection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		HttpSession session = request.getSession();
		WaterDisconnection waterDisconnection = null;
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
					waterDisconnection = waterDisconnectionService.get(rtiApplicationRefId);
				} else if (session.getAttribute("rtirefId") != null) {
					Object a = session.getAttribute("rtirefId");
					rtiApplicationRefId = (long) a;
					waterDisconnection = waterDisconnectionService.get(rtiApplicationRefId);
				}
				String feees = request.getParameter("fees");
 String uploadedDemand = waterDisconnection.getUploadedDemand();
				String paymentStatus = request.getParameter("paymentStatus");
			

				if (waterDisconnection.getRti_ref_id() > 0) {
					rtiApplicationId = waterDisconnection.getRti_ref_id();
					rtiapplication = rtiApplicationService.get(rtiApplicationId);
					if (rtiapplication.getApplicationCost() == 0.0 || rtiapplication.getApplicationCost() == 0) {
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
request.setAttribute("workFlowStatus",rtiapplication.getWorkFlowStatus());

		User user = userService.get(userId);
		String userLoginId = user.getUserLevel();
        if(userLoginId!=null && !userLoginId.isEmpty()) {
		if(userLoginId.equals("L2")) {
			request.setAttribute("forLogin", "L2");
		}else if (userLoginId.equals("L3")) {
			request.setAttribute("forLogin", "L3");
		}
		else
		{
			request.setAttribute("forLogin", "nothing");
		}
        }
		
			ModelAndView modelAndView = new ModelAndView("manageWaterDisconnection", "waterDisconnection",
					waterDisconnection);

			return modelAndView;
		}else {
		return new ModelAndView("redirect:/login.do");
		}
	}

	@RequestMapping("/rtiapplication/createWaterDisconnectionWork.do")
	public ModelAndView createWaterDisconnectionWork(HttpServletRequest request, HttpServletResponse response)
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
		WaterDisconnection waterDisconnection = waterDisconnectionService.get(applicationId);
		String email = waterDisconnection.getEmail();
		String mobileNo = rtiApplication.getMobileNumber();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();

		if (waterDisconnection != null) {
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
						int estServiceDays=7;
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
						int estServiceDays=7;
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
						int estServiceDays=7;
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
					int estServiceDays=7;
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
		return new ModelAndView("redirect:/rtsapplication/editWaterDisconnection.do");

//		ModelAndView modelAndView = new ModelAndView("manageWaterDisconnection", "waterDisconnection",
//				waterDisconnection);
//		return modelAndView;
	}

	// Save Manage Disconnection

	@RequestMapping("/rtsapplication/saveDisconnectionWater.do")
	public ModelAndView saveDisconnectionWater(HttpServletRequest request, HttpServletResponse response,
			WaterDisconnection waterDisconnection) throws ServletException, Exception {
		String fees = request.getParameter("demandfees");
	    String approvalRemark = request.getParameter("approvalRemark");

		String refid = request.getParameter("waterDisconnectionId");
		long apprefid = 0;
		apprefid = Long.parseLong(refid);
		
		waterDisconnection = waterDisconnectionService.get(apprefid);
//				waterDisconnection.setSendDemandStatus(1);

		if ((waterDisconnection.getDemandfees() == null && fees != null) || approvalRemark !=null) {
			waterDisconnection.setDemandfees(fees);
			waterDisconnection.setApprovalRemark(approvalRemark);
		
			waterDisconnection = waterDisconnectionService.merge(waterDisconnection);

		}
		return new ModelAndView(
				"redirect:/rtsapplication/editWaterDisconnection.do?rtiApplicationRefId=" + apprefid + "&fees=" + fees);
	}

	@RequestMapping("/rtsapplication/saveDisconnectionWaterPayment.do")
	public ModelAndView saveDisconnectionWaterPayment(HttpServletRequest request, HttpServletResponse response,
			WaterDisconnection waterDisconnection) throws ServletException, Exception {
		String payStatus = request.getParameter("paymentStatus");
		String refid = request.getParameter("waterDisconnectionId");
		long apprefid = 0;
		apprefid = Long.parseLong(refid);
		
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);
		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();

		waterDisconnection = waterDisconnectionService.get(apprefid);
//				waterDisconnection.setSendDemandStatus(1);
		String status = waterDisconnection.getPaymentStatus();
		if (waterDisconnection.getPaymentStatus() == null && payStatus != null) {
			waterDisconnection.setPaymentStatus(payStatus);
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
				int estServiceDays=7;
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
			waterDisconnection = waterDisconnectionService.merge(waterDisconnection);

		}
		return new ModelAndView("redirect:/rtsapplication/editWaterDisconnection.do?rtiApplicationRefId=" + apprefid
				+ "&paymentStatus=" + payStatus);
	}

}
