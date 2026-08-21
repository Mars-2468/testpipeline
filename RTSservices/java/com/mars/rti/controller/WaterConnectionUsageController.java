package com.mars.rti.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

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
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.WaterConnectionUsage;
import com.mars.rti.model.WaterDisconnection;
import com.mars.rti.model.WaterDisconnectionPOJO;
import com.mars.rti.model.WaterProposedCategoryType;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.WaterConnectionUsageService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class WaterConnectionUsageController {
	private static Log log = LogFactory.getLog(WaterConnectionUsageController.class);
	
	String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";

	@Autowired
	private WaterConnectionUsageService waterConnectionUsageService;
	@Autowired
	private RTIApplicationService rtiApplicationService;
//
//	private static String const_OrderBy = "OrderBy";
//
//	private static String const_SortBy = "SortBy";

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private UserRegistrationService userRegistrationService;

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
// 	}

	@RequestMapping("/rtsapplication/saveWaterConnectionUsage.do")
	public ModelAndView saveWaterConnectionUsage(HttpServletRequest request, HttpServletResponse response,
			WaterConnectionUsage waterConnectionUsage) throws ServletException, Exception {

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

			if (waterConnectionUsage != null) {

				RTIApplication rtiApplication = new RTIApplication();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("WATER-CONNECTION-USAGE-CERTIFICATE");
				rtiApplication.setDepartment("WATER-DEPARTMENT");
				rtiApplication.setTemplateName("water");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(51);
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
				}
				rtiApplication.setPhoneNumber(waterConnectionUsage.getMobileNo());
				rtiApplication.setMobileNumber(waterConnectionUsage.getMobileNo());
				
				
//				if (waterConnectionUsage.getAlterMobileNo() != null && !waterConnectionUsage.getAlterMobileNo().isEmpty()) {
//					rtiApplication.setMobileNumber(waterConnectionUsage.getAlterMobileNo());
//
//
//				}else {
					rtiApplication.setMobileNumber(waterConnectionUsage.getMobileNo());

				
				
				
				rtiApplication.setEmail(waterConnectionUsage.getEmail());
				rtiApplication.setUserRegistrationDetails(user);
				rtiApplication.setIsApleSarkarApp(0);

				if(waterConnectionUsage.getZoneNo() != null) {			   
					rtiApplication.setZone(
						    waterConnectionUsage.getZoneNo().equals("Zone No.1 - Laxmi Nagar")|| waterConnectionUsage.getZoneNo().equals("Zone No.01 - Laxmi Nagar") ? "1" :
						    waterConnectionUsage.getZoneNo().equals("Zone No.2 - Dharampeth") || waterConnectionUsage.getZoneNo().equals("Zone No.02 - Dharampeth") ? "2" :
						    waterConnectionUsage.getZoneNo().equals("Zone No.3 - Hanuman Nagar")|| waterConnectionUsage.getZoneNo().equals("Zone No.03 - Hanuman Nagar") ? "3" :
						    waterConnectionUsage.getZoneNo().equals("Zone No.4 - Dhantoli")|| waterConnectionUsage.getZoneNo().equals("Zone No.04 - Dhantoli") ? "4" :
						    waterConnectionUsage.getZoneNo().equals("Zone No.5 - Nehru Nagar")|| waterConnectionUsage.getZoneNo().equals("Zone No.05 - Nehru Nagar") ? "5" :
						    waterConnectionUsage.getZoneNo().equals("Zone No.6 - Gandhibagh")|| waterConnectionUsage.getZoneNo().equals("Zone No.06 - Gandhibagh") ? "6" :
						    waterConnectionUsage.getZoneNo().equals("Zone No.7 - Satranjipura")|| waterConnectionUsage.getZoneNo().equals("Zone No.07 - Satranjipura") ? "7" :
						    waterConnectionUsage.getZoneNo().equals("Zone No.8 - Lakadganj")|| waterConnectionUsage.getZoneNo().equals("Zone No.08 - Lakadganj") ? "8" :
						    waterConnectionUsage.getZoneNo().equals("Zone No.9 - Ashi Nagar")|| waterConnectionUsage.getZoneNo().equals("Zone No.09 - Ashi Nagar") ? "9" :
						    waterConnectionUsage.getZoneNo().equals("Zone No.10 - Mangalwari")|| waterConnectionUsage.getZoneNo().equals("Zone No.010 - Mangalwari") ? "10" :
						    "");
					}
				// rtiApplication.setApplicationCost(waterDisconnection.getFeesApplicable());

				rtiApplication.setApplicantName(waterConnectionUsage.getCINNo());
				rtiApplication.setPdfUploadFromPortal(waterConnectionUsage.getFilesPath());
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
					waterConnectionUsage.setRtiapplrefno(rti.getRtiApplnNumber());
					waterConnectionUsage.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = waterConnectionUsageService.waterConnectionUsage(waterConnectionUsage);
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
						if ((retunRti != null) && (waterConnectionUsage.getRti_ref_id() > 0)) {
							String requestNo = waterConnectionUsage.getRtiapplrefno();
							LocalDate currentDate = LocalDate.now();
							DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							String date = format.format(currentDate);
							String mobileNo = waterConnectionUsage.getMobileNo();
							String emailId = waterConnectionUsage.getEmail();
							//String purpose = waterConnectionUsage.getPurpose();
							// String purpose = waterConnectionUsage.getPurpose();
							MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
							formData.add("requestNo", requestNo);
							formData.add("date", date);
							formData.add("contractAccountNo", waterConnectionUsage.getCINNo());
							formData.add("type", "changeOfUsage");
							formData.add("contactNo", mobileNo);
							formData.add("emailId", emailId);
							//formData.add("purpose", purpose);
							HttpHeaders headers = new HttpHeaders();
							headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
							HttpEntity<MultiValueMap<Object, Object>> requestEntity = new HttpEntity<>(formData,
									headers);
							 String url=CoreConstants.CHANGE_USAGE_WATER_TEST_POST;

							//String url = "https://sampark.ocwindia.com/aaplesarkar/customer/request/?key=6aa083ae54aae4a7fad7659c6fbfd0bc";
							RestTemplate restTemplate = new RestTemplate();
							ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST,
									requestEntity, String.class);
							if (log.isDebugEnabled()) {

								log.debug("POST Successfull:-" + serverResponse + "\n" + requestEntity);
							}
						}
					}
					String name = waterConnectionUsage.getCINNo();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = rti.getMobileNumber();
					String email=waterConnectionUsage.getEmail();
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
						int appStatus=1;
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
						String mobileApla = waterConnectionUsage.getMobileNo();
						
						
						/*
						 * String[] fields = request.getParameterValues("fields"); for (int i = 0; i <
						 * fields.length; i++) { log.debug("Index controller XXX--> " + i + ": " +
						 * fields[i]); }
						 */

						 String retrurnurl="https://nmcnagpur.gov.in/RTSservices/ws/rtsapplication/newRtSTWaterConnectionUsageSuccess.do?rtsAppNo="+appId+ "&isApleSarkar="+ retunRti.getIsApleSarkarApp();
						//String retrurnurl="https://nagpur.egovmars.in/RTSservices/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
						
						String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
								 digitalSignStatus,digitalSignDate,estServiceDays, 
								 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
						
					log.debug("Final  PushBAck status XXX-->>>"+pushBackrespose);
					
					return new ModelAndView("redirect:/ws/rtsapplication/newRtSTWaterConnectionUsageSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber()
					 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
							);

				} else {
			return new ModelAndView("redirect:/ws/rtsapplication/newRtSTWaterConnectionUsageSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber()
			 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
					);

		}
	}
}
		return new ModelAndView("redirect:/ws/user/login.do");

	}
	@RequestMapping("ws/rtsapplication/newRtSTWaterConnectionUsageSuccess.do")
	public ModelAndView newRtSTWaterConnectionUsageSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		String isApleSarkar=request.getParameter("isApleSarkar");

		ModelAndView model = new ModelAndView("newRTIWaterConnectionUsageSuccess");
		
		model.addObject("waterConnectionUsage",appNo);
		model.addObject("isApleSarkar", isApleSarkar);

		return model;
				
		
	}

	@RequestMapping("/rtsapplication/getConnectionInuseDetails.do")
	public void getConnectionInuseDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {

	
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
//			String restUrl = "https://samparkdev.ocwindia.com/aaplesarkar/customer/getCan?key=6aa083ae54aae4a7fad7659c6fbfd0bc&contractAccountNo="
//					+ canNumber + "&type=reconnection";
//			
			String restUrl = "https://sampark.ocwindia.com/aaplesarkar/customer/getCan?key=6aa083ae54aae4a7fad7659c6fbfd0bc&contractAccountNo="
					+ canNumber + "&type=changeOfUsage";
		
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

//old
//	@RequestMapping("/rtsapplication/getConnectionInuseDetails.do")
//	public void getConnectionInuseDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
//
//		log.debug(" came inside get water disconnection");
//		JSONObject json = new JSONObject();
//
//			try {
//				// String canNumber = waterDisconnection.getCINNo();
//				String canNumber = request.getParameter("cinNo");
//				StringBuilder response1 = new StringBuilder();
//				log.debug("sadfghjklhgfdsg");
//				String restUrl = "https://samparkdev.ocwindia.com/aaplesarkar/customer/getCan?key=6aa083ae54aae4a7fad7659c6fbfd0bc&contractAccountNo="
//						+ canNumber + "&type=changeOfUsage";
//				// http://13.126.30.25/aaplesarkar/customer/getCan?key=6aa083ae54aae4a7fad7659c6fbfd0bc&contractAccountNo=10000003&type=changeOfUsage
//				log.debug("sadfghjklhgfdsg");
//
//				URL url = new URL(restUrl);
//				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//				conn.setRequestMethod("GET");
//				conn.connect();
//				log.debug("sadfghjklhgfdsg");
//
//				int responseCode = conn.getResponseCode();
//				if (responseCode == HttpURLConnection.HTTP_OK) {
//					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//					String inputLine;
//					while ((inputLine = in.readLine()) != null) {
//						response1.append(inputLine);
//					}
//					in.close();
//
//					log.debug("sadfghjklhgfdsg");
//
//				}
//				String res = response1.toString();
//				log.debug(res);
//				ObjectMapper objectMapper = new ObjectMapper();
//				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//				WaterDisconnectionPOJO responseData = new WaterDisconnectionPOJO();
//				responseData = objectMapper.readValue(res, WaterDisconnectionPOJO.class);
//				System.out.println();
//				ArrayList<String> list = new ArrayList<String>();
//
//				log.debug("ggggggg" + responseData.getData().get(0).getConsumerName());
//				String zone = responseData.getData().get(0).getZone();
//				String zoneName = "Zone No.";
//				if (zone.equals("01") || zone.equals("1")) {
//
//					zoneName = zoneName + zone + " " + "-" + " " + "Laxmi Nagar";
//
//				} else if (zone.equals("2") || zone.equals("02")) {
//					zoneName = zoneName + zone + " " + "-" + " " + "Dharampeth";
//
//				} else if (zone.equals("3") || zone.equals("03")) {
//					zoneName = zoneName + zone + " " + "-" + " " + "Hanuman Nagar";
//
//				} else if (zone.equals("4") || zone.equals("04")) {
//					zoneName = zoneName + zone + " " + "-" + " " + "Dhantoli";
//
//				} else if (zone.equals("5") || zone.equals("05")) {
//					zoneName = zoneName + zone + " " + "-" + " " + "Nehru Nagar";
//
//				} else if (zone.equals("6") || zone.equals("06")) {
//					zoneName = zoneName + zone + " " + "-" + " " + "Gandhibagh";
//
//				} else if (zone.equals("7") || zone.equals("07")) {
//					zoneName = zoneName + zone + " " + "-" + " " + "Satranjipura";
//
//				} else if (zone.equals("8") || zone.equals("08")) {
//					zoneName = zoneName + zone + " " + "-" + " " + "Lakadganj";
//
//				} else if (zone.equals("9") || zone.equals("09")) {
//					zoneName = zoneName + zone + " " + "-" + " " + "Ashi Nagar";
//
//				} else if (zone.equals("10") || zone.equals("010")) {
//					zoneName = zoneName + zone + " " + "-" + " " + "Mangalwari";
//
//				}
//				json.put("zone", zoneName);
//				json.put("esr", responseData.getData().get(0).getCommand_area());
//				json.put("consumername", responseData.getData().get(0).getConsumerName());
//				json.put("address", responseData.getData().get(0).getAddress());
//				json.put("meterno", responseData.getData().get(0).getMeterNo());
//				json.put("meterTapSize", responseData.getData().get(0).getTap_size());
//				json.put("category", responseData.getData().get(0).getCategory());
//				json.put("balance_arrears", responseData.getData().get(0).getBalance_arrears());
//				json.put("cut_off_date", responseData.getData().get(0).getCut_off_date());
//
//				PrintWriter out = response.getWriter();
//	              out.print(json.toString());
//	              out.flush();
//				
//
//			} catch (Exception e) {
//				String error = "Record Not Found! Please Enter Valid CIN No.";
//				request.setAttribute("message", error);
//			}
//		
//	}

	@SuppressWarnings("unused")
	@RequestMapping("/rtsapplication/editWaterChangeUsage.do")
	public ModelAndView editWaterChangeUsage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		HttpSession session = request.getSession();
		WaterConnectionUsage waterConnectionUsage = null;
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		request.getSession().setAttribute("refid",request.getParameter("rtiApplicationRefId"));
		long userId = sessionUser.getUserId();

		String a1 = request.getParameter("rtiApplicationRefId");
		if (sessionUser != null) {

		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0 || session.getAttribute("rtirefId") != null) {
			if (request.getParameter("rtiApplicationRefId") != null && request.getParameter("rtiApplicationRefId").length() > 0) {

			rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
			waterConnectionUsage = waterConnectionUsageService.get(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				waterConnectionUsage = waterConnectionUsageService.get(rtiApplicationRefId);
			}
			 //String feees = request.getParameter("fees");
			 String approvalRemark = request.getParameter("approvalRemark");
			// String paymentStatus = request.getParameter("paymentStatus");
			 String higherApprovel = waterConnectionUsage.getHigherapprovalRemark();
			 

		
			 rtiApplicationId = waterConnectionUsage.getRti_ref_id();
			 rtiapplication = rtiApplicationService.get(rtiApplicationId);
				
			 if(higherApprovel != null && rtiapplication.getWorkFlowStatus() == 9)
			 {
				 rtiapplication.setWorkFlowStatus(10);
				 rtiapplication = rtiApplicationService.merge(rtiapplication);
			 }
			 
		
			if (waterConnectionUsage.getRti_ref_id() > 0) {
				rtiApplicationId = waterConnectionUsage.getRti_ref_id();
				rtiapplication = rtiApplicationService.get(rtiApplicationId);
				if ((rtiapplication.getApplicationCost() == 0.0 || rtiapplication.getApplicationCost() == 0) && rtiapplication.getWorkFlowStatus() != 10) {
					if (approvalRemark != null && approvalRemark != "" && !approvalRemark.isEmpty()) {
						//rtiapplication.setApplicationCost(Double.parseDouble(feees));

							    rtiapplication.setWorkFlowStatus(9);
						rtiapplication = rtiApplicationService.merge(rtiapplication);
					}
				}
//				if (rtiapplication.getWorkFlowStatus() == 3) {
//					if (paymentStatus != null && !paymentStatus.isEmpty() && paymentStatus.equals("Paid")) {
//						rtiapplication.setWorkFlowStatus(2);
//						rtiapplication = rtiApplicationService.merge(rtiapplication);
//					}
//				}
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
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME,CoreConstants.RTI_WATER_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME,CoreConstants.RTI_WATER_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID,rtiApplicationId);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId,CoreConstants.RTI_WATER_WORKFLOW_ENTITY);

		if (workflowProcessDetails != null) {
			String processId = workflowProcessDetails.getProcessId();
			if (processId != null) {
				processDetails = workflowProcessDetailsService
						.getWorkflowProcessDetailsByProcessId(processId);
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
				if (task != null && sessionUser.getUserName()
						.equals(task.getAssignee()))
					request.setAttribute("userAccess", 1);

				request.setAttribute("workFlowTask", task);
			} else {

				request.setAttribute("workFlowCompleted", "1");
			}
		}

		request.setAttribute("totalfees",rtiapplication.getApplicationCost());
		request.setAttribute("workFlowStatus",rtiapplication.getWorkFlowStatus());
	    waterConnectionUsage = waterConnectionUsageService.get(rtiApplicationRefId);
		String higherapprovel = waterConnectionUsage.getHigherapprovalRemark();
		User user = userService.get(userId);
		String userLoginId = user.getUserLevel();
	     if(userLoginId!=null && !userLoginId.isEmpty()) {
			if(waterConnectionUsage.getApprovalRemark() == null || waterConnectionUsage.getApprovalRemark().isEmpty()) {
		    request.setAttribute("for2remarks", "hide");
		} else {
	   
			if(userLoginId.equals("L2")) {
				if(rtiapplication.getWorkFlowStatus() == 9) {
					request.setAttribute("for2remarks", "show");
					request.setAttribute("for2ndSave", "show");
				}
				else
				{
					request.setAttribute("for2remarks", "show");
					request.setAttribute("for2ndSave", "hide");
				}
			}
			
	        
		}

		if(userLoginId.equals("L2")) {
       if(waterConnectionUsage.getApprovalRemark() != null ) {
				if(waterConnectionUsage.getHigherapprovalRemark() != null)
				request.setAttribute("for2ndSave", "hide");
				else
				request.setAttribute("for2ndSave", "show");
			}
			else
			{
				request.setAttribute("for2ndSave", "hide");
			}
		
       String catgory=waterConnectionUsage.getProposedCategory();
       String category=waterConnectionUsage.getProposedCategory();
       String tap=waterConnectionUsage.getTap_size();
       String login=userLoginId;
       
		if((waterConnectionUsage.getProposedCategory().equals("R1") || waterConnectionUsage.getProposedCategory().equals("Slum")) && Integer.parseInt(waterConnectionUsage.getTap_size()) <= 25 && userLoginId.equals("L2"))
		{
			request.setAttribute("for2remarks", "hide");
			if(rtiapplication.getWorkFlowStatus() == 9 || rtiapplication.getWorkFlowStatus() == 10 || rtiapplication.getWorkFlowStatus() == 0 || rtiapplication.getWorkFlowStatus() == 5 || rtiapplication.getWorkFlowStatus() == 1)
			{
				if(waterConnectionUsage.getApprovalRemark() != null ) 
					{
					request.setAttribute("forLogin", "show");
					request.setAttribute("for2ndSave", "hide");
					}
					else
					{
					request.setAttribute("forLogin", "hide");
					}
				}
		}
		else 
		{
			if(rtiapplication.getWorkFlowStatus() == 9 || rtiapplication.getWorkFlowStatus() == 10 || rtiapplication.getWorkFlowStatus() == 0) {
				request.setAttribute("forLogin", "hide");
			}
			if(rtiapplication.getWorkFlowStatus() == 5 || rtiapplication.getWorkFlowStatus() == 1)
			{
				request.setAttribute("forLogin", "show");
			}
		}
		
		}
		else if(userLoginId.equals("L3"))
		{
			
			if(waterConnectionUsage.getApprovalRemark() == null || waterConnectionUsage.getHigherapprovalRemark() == null || waterConnectionUsage.getApprovalRemark().isEmpty() || waterConnectionUsage.getHigherapprovalRemark().isEmpty()) {
			    request.setAttribute("forLogin", "hide");
			}
			else {
				
			if((waterConnectionUsage.getProposedCategory().equals("R1") || waterConnectionUsage.getProposedCategory().equals("Slum")) && Integer.parseInt(waterConnectionUsage.getTap_size()) <= 25 && userLoginId.equals("L3"))
			{
				if(rtiapplication.getWorkFlowStatus() == 9 || rtiapplication.getWorkFlowStatus() == 10 ||  rtiapplication.getWorkFlowStatus() == 0 || rtiapplication.getWorkFlowStatus() == 5 || rtiapplication.getWorkFlowStatus() == 1)
				{
					request.setAttribute("forLogin", "hide");
				}
				else {
					request.setAttribute("for2remarks", "show");
				}
			}
			else 
			{
				if(rtiapplication.getWorkFlowStatus() == 9 || rtiapplication.getWorkFlowStatus() == 10 || rtiapplication.getWorkFlowStatus() == 0 || rtiapplication.getWorkFlowStatus() == 5 || rtiapplication.getWorkFlowStatus() == 1)
				request.setAttribute("forLogin", "show");
				request.setAttribute("for2remarks", "show");
			}
			}
		}
		else
		{
				if(rtiapplication.getWorkFlowStatus() == 9 || rtiapplication.getWorkFlowStatus() == 10 || rtiapplication.getWorkFlowStatus() == 0 || rtiapplication.getWorkFlowStatus() == 1)
				{
					request.setAttribute("forLogin", "hide");
					request.setAttribute("for2remarks", "show");
				}
				else
				request.setAttribute("forLogin", "show");
				
				if(rtiapplication.getWorkFlowStatus() == 3)
				request.setAttribute("saveFees", "show");
				
				if(rtiapplication.getWorkFlowStatus() == 0)
				request.setAttribute("for2ndSave", "show");
				else
				request.setAttribute("for2ndSave", "hide");
				
				request.setAttribute("forPaidCheckbox",  "3");
				
				if(rtiapplication.getWorkFlowStatus() != 3 && rtiapplication.getWorkFlowStatus() != 0  && rtiapplication.getWorkFlowStatus() != 9  && rtiapplication.getWorkFlowStatus() != 10)
					request.setAttribute("forLogin", "show");
				
				if(higherapprovel != null)
					request.setAttribute("for2remarks", "show");
				else
					request.setAttribute("for2remarks", "hide");
				
		}
		
		
	     }
		List<WaterProposedCategoryType> proposedCategoryType = waterConnectionUsageService.getProposedCategory();
		request.setAttribute("proposedCategoryType", proposedCategoryType);
		request.setAttribute("rtiApplication", rtiapplication);

		ModelAndView modelAndView = new ModelAndView("manageWaterChangeUsage", "waterConnectionUsage",
				waterConnectionUsage);

		return modelAndView;
	
	}else {
	return new ModelAndView("redirect:/login.do");
	}
}

	@RequestMapping("/rtiapplication/createWaterConnectionUsageWork.do")
	public ModelAndView createWaterConnectionUsageWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_WATER_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		WaterConnectionUsage waterConnectionUsage = waterConnectionUsageService.get(applicationId);
		String email = waterConnectionUsage.getEmail();
		String mobileNo = rtiApplication.getMobileNumber();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();

		if (waterConnectionUsage != null) {
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

					rtiApplication.setWorkFlowStatus(2);
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
						int appStatus=1;
						String remark="NA";						
						String serviceId= rtiApplication.getAaple_service_id();
						String mobileApla=rtiApplication.getMobileNumber();
						//retunRti.setAaple_application_id(appId);
						String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
								 digitalSignStatus,digitalSignDate,estServiceDays, 
								 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
						log.debug("pushBackrespose"+pushBackrespose);
						log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
								" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
								" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
								" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
								" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
						);
						
						}
					//SendSMSEmailController.sendWaterPayment(applicantName, mobileNo, rtiApplnNumber, email);

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
								 estServiceDate,amount,reqFlag,4,remark,distric,mobileApla); 
					log.debug("pushBackrespose aplesarkar"+pushBackrespose);
					log.debug("data pushing to aple sarkar webservice : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
							" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
							" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
							" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
							" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
					);
					log.debug("appStatus"+4);
					
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
					log.debug("pushBackrespose"+pushBackrespose);
					log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
							" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
							" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
							" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
							" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
					);
					
						}
					SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				}
			}else {
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
					log.debug("pushBackrespose"+pushBackrespose);
					log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
							" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
							" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
							" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
							" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
					);
					
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
		return new ModelAndView("redirect:/rtsapplication/editWaterChangeUsage.do");

//		ModelAndView modelAndView = new ModelAndView("manageWaterChangeUsage", "waterConnectionUsage",
//				waterConnectionUsage);
//		return modelAndView;
	}
	
	//Save Manage Disconnection
		
			@RequestMapping("/rtsapplication/saveConnectionUsageWater.do")
			public ModelAndView saveConnectionUsageWater(HttpServletRequest request,HttpServletResponse response,WaterConnectionUsage waterConnectionUsage)
					throws ServletException, Exception {
			    String fees = request.getParameter("demandfees");
			    String proposedCategory = request.getParameter("proposedCategory");
			    String totalNumberOfResidentialFlats = request.getParameter("totalNumberOfResidentialFlats");
			    String approvalRemark = request.getParameter("approvalRemark");
 String higherapprovalRemark = request.getParameter("higherapprovalRemark");

	            String refid =request.getParameter("waterConnectionUsageId");
				long apprefid = 0;
				apprefid = Long.parseLong(refid);

rtiApplicationService.get(apprefid);
				waterConnectionUsage = waterConnectionUsageService.get(apprefid);
//				waterDisconnection.setSendDemandStatus(1);

				if ((waterConnectionUsage.getDemandfees() == null && fees!=null) || proposedCategory != null || totalNumberOfResidentialFlats != null || approvalRemark !=null || higherapprovalRemark !=null){
					waterConnectionUsage.setDemandfees(fees);
					waterConnectionUsage.setProposedCategory(proposedCategory);
					waterConnectionUsage.setTotalNumberOfResidentialFlats(totalNumberOfResidentialFlats);
					waterConnectionUsage.setApprovalRemark(approvalRemark);
	waterConnectionUsage.setHigherapprovalRemark(higherapprovalRemark);
					waterConnectionUsage = waterConnectionUsageService.merge(waterConnectionUsage);

				}
				return new ModelAndView("redirect:/rtsapplication/editWaterChangeUsage.do?rtiApplicationRefId=" + apprefid + "&approvalRemark=" + approvalRemark);	
				}

	
			@RequestMapping("/rtsapplication/saveConnectionUsageWaterPayment.do")
			public ModelAndView saveConnectionUsageWaterPayment(HttpServletRequest request,HttpServletResponse response,WaterConnectionUsage waterConnectionUsage)
					throws ServletException, Exception {
			    String paymentStatus = request.getParameter("paymentStatus");
	            String refid =request.getParameter("waterConnectionUsageId");
				long apprefid = 0;
				apprefid = Long.parseLong(refid);

				waterConnectionUsage = waterConnectionUsageService.get(apprefid);
//				waterDisconnection.setSendDemandStatus(1);
				String status=waterConnectionUsage.getPaymentStatus();
				if (waterConnectionUsage.getPaymentStatus() == null && paymentStatus!=null) {
					waterConnectionUsage.setPaymentStatus(paymentStatus);
					waterConnectionUsage = waterConnectionUsageService.merge(waterConnectionUsage);

				}
				return new ModelAndView("redirect:/rtsapplication/editWaterChangeUsage.do?rtiApplicationRefId=" + apprefid + "&paymentStatus=" + paymentStatus);	
				}

	

}
