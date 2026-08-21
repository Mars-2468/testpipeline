package com.mars.rti.controller;

import java.io.PrintWriter;
import java.net.URI;
import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.WaterPressure;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.WaterPressureService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class WaterPressureController {

	private static Log log = LogFactory.getLog(WaterPressureController.class);

	@Autowired
	private WaterPressureService waterPressureService;

	@Autowired
	private UserRegistrationService userService;

	@Autowired
	private RTIApplicationService rTIApplicationService;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@RequestMapping("/rtsapplication/saveWaterPressure.do")
	public ModelAndView saveWaterPressure(HttpServletRequest request, HttpServletResponse response,
			WaterPressure waterPressure) throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking New Water Connection");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking New Water Connection");
		}
		String zone1 = null;
		String mobileNumber = "";
		RTIApplication retunRti=null;
		mobileNumber = (String) session.getAttribute("mobileNo");
		if (mobileNumber != null) {
			UserRegistrationDetails user = userService.getUserByMobileNo(mobileNumber);
			if (waterPressure != null) {

				RTIApplication rtiApplication = new RTIApplication();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("WATER-PRESSURE-COMPLAINT");
				rtiApplication.setDepartment("WATER-DEPARTMENT");
				rtiApplication.setTemplateName("water");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(62);
				rtiApplication.setApplicantName(waterPressure.getCINNo());
						
				rtiApplication.setPhoneNumber(waterPressure.getMobileNo());
				rtiApplication.setMobileNumber(waterPressure.getMobileNo());
				rtiApplication.setPdfUploadFromPortal(waterPressure.getFilesPath());
				if (waterPressure.getZoneNo().isEmpty()) {
					if(waterPressure.getZoneNo() != null) {			   
						rtiApplication.setZone(
								waterPressure.getZoneNo().equals("Zone No.1 - Laxmi Nagar")|| waterPressure.getZoneNo().equals("Zone No.01 - Laxmi Nagar") ? "1" :
								waterPressure.getZoneNo().equals("Zone No.2 - Dharampeth") || waterPressure.getZoneNo().equals("Zone No.02 - Dharampeth") ? "2" :
								waterPressure.getZoneNo().equals("Zone No.3 - Hanuman Nagar")|| waterPressure.getZoneNo().equals("Zone No.03 - Hanuman Nagar") ? "3" :
								waterPressure.getZoneNo().equals("Zone No.4 - Dhantoli")|| waterPressure.getZoneNo().equals("Zone No.04 - Dhantoli") ? "4" :
								waterPressure.getZoneNo().equals("Zone No.5 - Nehru Nagar")|| waterPressure.getZoneNo().equals("Zone No.05 - Nehru Nagar") ? "5" :
								waterPressure.getZoneNo().equals("Zone No.6 - Gandhibagh")|| waterPressure.getZoneNo().equals("Zone No.06 - Gandhibagh") ? "6" :
								waterPressure.getZoneNo().equals("Zone No.7 - Satranjipura")|| waterPressure.getZoneNo().equals("Zone No.07 - Satranjipura") ? "7" :
								waterPressure.getZoneNo().equals("Zone No.8 - Lakadganj")|| waterPressure.getZoneNo().equals("Zone No.08 - Lakadganj") ? "8" :
								waterPressure.getZoneNo().equals("Zone No.9 - Ashi Nagar")|| waterPressure.getZoneNo().equals("Zone No.09 - Ashi Nagar") ? "9" :
								waterPressure.getZoneNo().equals("Zone No.10 - Mangalwari")|| waterPressure.getZoneNo().equals("Zone No.010 - Mangalwari") ? "10" :
							    "");
						}

				} else {			   
						rtiApplication.setZone(
								waterPressure.getZoneNo().equals("Zone No.1 - Laxmi Nagar")|| waterPressure.getZoneNo().equals("Zone No.01 - Laxmi Nagar") ? "1" :
								waterPressure.getZoneNo().equals("Zone No.2 - Dharampeth") || waterPressure.getZoneNo().equals("Zone No.02 - Dharampeth") ? "2" :
								waterPressure.getZoneNo().equals("Zone No.3 - Hanuman Nagar")|| waterPressure.getZoneNo().equals("Zone No.03 - Hanuman Nagar") ? "3" :
								waterPressure.getZoneNo().equals("Zone No.4 - Dhantoli")|| waterPressure.getZoneNo().equals("Zone No.04 - Dhantoli") ? "4" :
								waterPressure.getZoneNo().equals("Zone No.5 - Nehru Nagar")|| waterPressure.getZoneNo().equals("Zone No.05 - Nehru Nagar") ? "5" :
								waterPressure.getZoneNo().equals("Zone No.6 - Gandhibagh")|| waterPressure.getZoneNo().equals("Zone No.06 - Gandhibagh") ? "6" :
								waterPressure.getZoneNo().equals("Zone No.7 - Satranjipura")|| waterPressure.getZoneNo().equals("Zone No.07 - Satranjipura") ? "7" :
								waterPressure.getZoneNo().equals("Zone No.8 - Lakadganj")|| waterPressure.getZoneNo().equals("Zone No.08 - Lakadganj") ? "8" :
								waterPressure.getZoneNo().equals("Zone No.9 - Ashi Nagar")|| waterPressure.getZoneNo().equals("Zone No.09 - Ashi Nagar") ? "9" :
								waterPressure.getZoneNo().equals("Zone No.10 - Mangalwari")|| waterPressure.getZoneNo().equals("Zone No.010 - Mangalwari") ? "10" :
							    "");
						}
				rtiApplication.setEmail(waterPressure.getEmail());
				rtiApplication.setApplicantName(waterPressure.getCINNo());
				rtiApplication.setPdfUploadFromPortal(waterPressure.getFilesPath());
				rtiApplication.setUserRegistrationDetails(user);
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
					rti.setRtiApplnNumber("RTS/WD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					waterPressure.setRtiapplrefno(rti.getRtiApplnNumber());
					waterPressure.setRti_ref_id(savedRti.getRtiApplicationId());
					long water = waterPressureService.waterPressure(waterPressure);
					rti.setRtiApplicationRefId(water);
					 retunRti = rtiApplicationService.merge(rti);
//					String anonymous_status = waterPressure.getConsumer();
//					String a = "false";
//					if ((anonymous_status.equals(a))) {
//					String requestNo = waterPressure.getRtiapplrefno();
//					LocalDateTime currentDateTime = LocalDateTime.now();
//					DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//					String dateTime = format.format(currentDateTime);
//					String title = waterPressure.getTitle();
//					String contractAccountNo = waterPressure.getCINNo();
//					String house_no = waterPressure.getPlotNo();
//					String buildingname = waterPressure.getBuildingName();
//					String landmark = waterPressure.getLandmark();
//					String locality = waterPressure.getAreaName();
//					String zone = waterPressure.getZoneNo();
//					String existingZone = waterPressure.getExistingZone();
//					String	existingEsr = waterPressure.getExistingEsr();
//					String esr = waterPressure.getEsr();
//					String emailId = waterPressure.getEmail();
//					String Nearest_location = waterPressure.getStreetName();
//					String name = waterPressure.getFullName();
//					String contactNo = waterPressure.getMobileNo();
//					MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();

						String requestNo = waterPressure.getRtiapplrefno();
						LocalDateTime currentDateTime = LocalDateTime.now();
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
						String dateTime = format.format(currentDateTime);
						String title = waterPressure.getTitle();
						String contractAccountNo = waterPressure.getCINNo();
						String house_no = waterPressure.getPlotNo();
						String building_name = waterPressure.getBuildingName();
						String landmark = waterPressure.getLandmark();
						String locality = waterPressure.getAreaName();
						String zone = waterPressure.getZoneNo();
						String emailId = waterPressure.getEmail();
						String Nearest_location = waterPressure.getStreetName();
						String name = waterPressure.getFullName();
						String contactNo = waterPressure.getMobileNo();
						String existingZone = waterPressure.getZoneNo();
						String existingEsr = waterPressure.getExistingEsr();
						String problem = waterPressure.getProblemDesc();

//					formData.add("id", "3");
//					formData.add("Request_No", requestNo);
//					formData.add("title", title);
//					formData.add("name", name);
//					formData.add("house_no", house_no);
//					formData.add("building_name", anonymous_status);
//					formData.add("landmark", landmark);
//					formData.add("locality", locality);
//					formData.add("zone", zone);
//					formData.add("esr_code", "esr");
//					formData.add("emailId", emailId);
//					formData.add("contactNo", contactNo);
//					formData.add("Comp_maincat", "technical_complaints");
//					formData.add("Comp_Subcat1", "water_quality");
//					formData.add("Comp_Subcat2", "water_quality");
//					formData.add("Nearest_location", Nearest_location);
//					formData.add("Problem_desc", "test");
//					formData.add("Reg_date", dateTime);
//					formData.add("anonymous_check", anonymous_status);
//					formData.add("type", "anonymous");

						MultiValueMap<Object, Object> formData = new LinkedMultiValueMap<>();
						formData.add("id", "3");
						formData.add("Request_No", requestNo);
						formData.add("contractAccountNo", contractAccountNo);
						formData.add("title", title);
						formData.add("name", name);
						formData.add("house_no", house_no);
						formData.add("building_name", building_name);
						formData.add("landmark", landmark);
						formData.add("locality", locality);
						formData.add("zone", existingZone);
						formData.add("esr_code", existingEsr);
						formData.add("emailId", emailId);
						formData.add("contactNo", contactNo);
						formData.add("Comp_maincat", "technical_complaints");
						formData.add("Comp_Subcat1", "water_pressure");
						formData.add("Comp_Subcat2", "water_pressure");
						formData.add("Nearest_location", Nearest_location);
						formData.add("Problem_desc", problem);
						formData.add("Reg_date", dateTime);
						formData.add("anonymous_check", "false");
						formData.add("type", "non-anonymous");

						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
						HttpEntity<MultiValueMap<Object, Object>> requestEntity = new HttpEntity<>(formData, headers);
						String url = "https://sampark.ocwindia.com/aaplesarkar/customer/Consumer_Complaint/?key=6aa083ae54aae4a7fad7659c6fbfd0bc";
						RestTemplate restTemplate = new RestTemplate();
						ResponseEntity<String> serverResponse = restTemplate.exchange(url, HttpMethod.POST,
								requestEntity, String.class);
						if (log.isDebugEnabled()) {

							log.debug("POST Successfull:-" + serverResponse + "\n" + requestEntity);
						}
					
					String applname = waterPressure.getFullName();
					String link = "https://tinyurl.com/4hhhy9w9";
					String applnNo = rti.getRtiApplnNumber();

					String msg = "Dear " + applname + " your application with Application No. " + applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";

					msg.replace("var3", "");
					String mobile = waterPressure.getMobileNo();
					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", mobile, msg);
					SendEmail.sendEmail(waterPressure.getEmail(), "Application Submitted Successfully" + applnNo, msg);
				}

//				ModelAndView modelAndView = new ModelAndView("newRTIWaterPressureSuccess", "waterPressure",
//						waterPressure);
//				return modelAndView;
				
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSWaterPressureComplaintSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

			}
		}

		return new ModelAndView("redirect:/ws/user/login.do");

	}
	
	
	@RequestMapping("ws/rtsapplication/newRtSWaterPressureComplaintSuccess.do")
	public ModelAndView newRtSWaterPressureComplaintSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTIWaterPressureSuccess");
		
		model.addObject("waterPressure",appNo);
		return model;
				
		
	}
	
	@RequestMapping("/rtsapplication/getWaterComplaintPressure.do")
	public void getWaterPressure(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
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
					+ canNumber + "&type=waterComplaint";

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
	
//	@RequestMapping("/rtsapplication/getWaterComplaintPressure.do")
//	public void getWaterPressure(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
//		log.debug(" came inside get water complaint");
//		JSONObject json = new JSONObject();
//
//
//			try {
//				// String canNumber = waterPressure.getCINNo();
//				String canNumber = request.getParameter("cinNo");
//				StringBuilder response1 = new StringBuilder();
//				log.debug("sadfghjklhgfdsg");
//				String restUrl = "https://sampark.ocwindia.com/aaplesarkar/customer/getCan?key=6aa083ae54aae4a7fad7659c6fbfd0bc&contractAccountNo="
//						+ canNumber + "&type=waterComplaint";
//
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
//
//
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
//			} catch (Exception e) {
//				String error = "Record Not Found! Please Enter Valid CIN No.";
//				request.setAttribute("message", error);
//			}
//	
//	}

	@RequestMapping("/rtsapplication/editWaterPressure.do")
	public ModelAndView editWaterQualityComplaint(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		HttpSession session = request.getSession();
		WaterPressure waterPressure = null;
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		request.getSession().setAttribute("refid",request.getParameter("rtiApplicationRefId"));
		String a1 = request.getParameter("rtiApplicationRefId");

		if (sessionUser != null) {
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0 || session.getAttribute("rtirefId") != null) {

			rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
			waterPressure = waterPressureService.get(rtiApplicationRefId);
		} else if (session.getAttribute("rtirefId") != null) {
			Object a = session.getAttribute("rtirefId");
			rtiApplicationRefId = (long) a;
			waterPressure = waterPressureService.get(rtiApplicationRefId);
		}
		 String feees = request.getParameter("fees");
		 String paymentStatus = request.getParameter("paymentStatus");

			if (waterPressure.getRti_ref_id() > 0) {
				rtiApplicationId = waterPressure.getRti_ref_id();
				rtiapplication = rtiApplicationService.get(rtiApplicationId);
				if (rtiapplication.getApplicationCost() == 0.0 || rtiapplication.getApplicationCost() == 0) {
					if (feees != null && feees != "" && !feees.isEmpty()) {
						rtiapplication.setApplicationCost(Double.parseDouble(feees));
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
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME,CoreConstants.RTI_WATER_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME,CoreConstants.RTI_WATER_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID,rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

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
	
		ModelAndView modelAndView = new ModelAndView("manageWaterPressure", "waterPressure", waterPressure);

		return modelAndView;
	}
	@RequestMapping("/rtiapplication/createWaterPressureWork.do")
	public ModelAndView createWaterPressureWork(HttpServletRequest request, HttpServletResponse response)
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
		WaterPressure waterPressure = waterPressureService.get(applicationId);
		String email = waterPressure.getEmail();
		String mobileNo = waterPressure.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();

		if (waterPressure != null) {
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
					String link = "https://tinyurl.com/4hhhy9w9";
					String paymentLink="https://nmcnagpur.gov.in/RTS/ws/pay.do";
					String paymentLink2="rtsNo="+rtiApplnNumber;
					
				    String msg = "Dear "+applicantName+" Your document verification has been successfully completed. Kindly make a payment to proceed with the processing of your application "+rtiApplnNumber+", Regards,NMCGOV";


					msg.replace("var3", "");
					SendEmail.sendEmail(email, "Payment link for your Appl. No." + mobileNo, msg);
					SendSMS.sendSingleSMS("1707170479457617341", "NMCGov", mobileNo, msg);

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
					String msg = "Dear " + applicantName + " your " + rtiApplnNumber
							+ " has been rejected due to shortfall of documents. Please use this link https://tinyurl.com/359w8usz to know the pending mandatory documents and track the status of your application.Regards, NMCGOV";
					msg.replace("var3", "");
					SendEmail.sendEmail(email, "Rejection of your Appl. No." + rtiApplnNumber, msg);
					SendSMS.sendSingleSMS("1507167421296109813", "NMCGov", mobileNo, msg);
					request.setAttribute("workFlowCompleted", "1");
				}
			}else {
				session.setAttribute("rejected", 5);
				rtiApplication.setWorkFlowStatus(5);
				String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
				rtiApplication.setWorkflowComments(workflow_comments);
				
				rtiApplicationService.save(rtiApplication);
				String msg = "Dear " + applicantName + " your " + rtiApplnNumber
						+ " has been rejected due to shortfall of documents. Please use this link https://tinyurl.com/bdemjk8e to know the pending mandatory documents and track the status of your application.Regards, NMCGOV";
				msg.replace("var3", "");
				SendEmail.sendEmail(email,
						"Rejection of your Appl. No." + rtiApplnNumber, msg);
				SendSMS.sendSingleSMS("1507167421296109813", "NMCGov", mobileNo,
						msg);
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

		ModelAndView modelAndView = new ModelAndView("manageWaterPressure", "waterPressure",
				waterPressure);
		return modelAndView;
	}
	
	//Save Manage Disconnection
		
			@RequestMapping("/rtsapplication/savePressureComplaintWater.do")
			public ModelAndView savePressureComplaintWater(HttpServletRequest request,HttpServletResponse response,WaterPressure waterPressure)
					throws ServletException, Exception {
			    String fees = request.getParameter("demandfees");
	            String refid =request.getParameter("waterPressureId");
				long apprefid = 0;
				apprefid = Long.parseLong(refid);

				waterPressure = waterPressureService.get(apprefid);
//				waterDisconnection.setSendDemandStatus(1);

				if (waterPressure.getDemandfees() == null && fees!=null) {
					waterPressure.setDemandfees(fees);
					waterPressure = waterPressureService.merge(waterPressure);

				}
				return new ModelAndView("redirect:/rtsapplication/editWaterPressure.do?rtiApplicationRefId=" + apprefid + "&fees=" + fees);	
				}

	
			@RequestMapping("/rtsapplication/savePressureComplaintWaterPayment.do")
			public ModelAndView savePressureComplaintWaterPayment(HttpServletRequest request,HttpServletResponse response,WaterPressure waterPressure)
					throws ServletException, Exception {
			    String paymentStatus = request.getParameter("paymentStatus");
	            String refid =request.getParameter("waterPressureId");
				long apprefid = 0;
				apprefid = Long.parseLong(refid);

				waterPressure = waterPressureService.get(apprefid);
//				waterDisconnection.setSendDemandStatus(1);
				String status=waterPressure.getPaymentStatus();
				if (waterPressure.getPaymentStatus() == null && paymentStatus!=null) {
					waterPressure.setPaymentStatus(paymentStatus);
					waterPressure = waterPressureService.merge(waterPressure);

				}
				return new ModelAndView("redirect:/rtsapplication/editWaterPressure.do?rtiApplicationRefId=" + apprefid + "&paymentStatus=" + paymentStatus);	
				}

	

}

