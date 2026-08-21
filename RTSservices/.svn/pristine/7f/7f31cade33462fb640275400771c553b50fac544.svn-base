package com.mars.rti.controller;

import java.io.PrintWriter;
import java.net.URI;
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
import com.mars.rti.model.IllegalWaterConnectionComplaint;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.IllegalWaterConnectionService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class IllegalWaterConnectionController {

	private static Log log = LogFactory.getLog(IllegalWaterConnectionController.class);

	@Autowired
	private IllegalWaterConnectionService illegalWaterConnectionService;
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

	@RequestMapping("/rtsapplication/saveIllegalWaterConnection.do")
	public ModelAndView saveIllegalWaterConnection(HttpServletRequest request, HttpServletResponse response,
			IllegalWaterConnectionComplaint illegalWaterConnection) throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking illegalWaterConnection");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking illegalWaterConnection");
		}
		String zone1 = null;
		String mobileNumber = "";
		mobileNumber = (String) session.getAttribute("mobileNo");
		if (mobileNumber != null) {
			UserRegistrationDetails user = userService.getUserByMobileNo(mobileNumber);
			if (illegalWaterConnection != null) {

				RTIApplication rtiApplication = new RTIApplication();
				// tradeLicenseNameChangeRestDTO tradeLicenseNameChangeRestDTO = new
				// tradeLicenseNameChangeRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("ILLEGAL-WATER-CONNECTION");
				rtiApplication.setDepartment("WATER-DEPARTMENT");
				rtiApplication.setTemplateName("water");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(63);
				rtiApplication.setApplicantName(illegalWaterConnection.getCinNo());
				rtiApplication.setPhoneNumber(illegalWaterConnection.getMobileNo());
				rtiApplication.setMobileNumber(illegalWaterConnection.getMobileNo());
				rtiApplication.setUserRegistrationDetails(user);

				if (illegalWaterConnection.getZoneNo().isEmpty()) {
					if(illegalWaterConnection.getZoneNo() != null) {			   
						rtiApplication.setZone(
								illegalWaterConnection.getZoneNo().equals("Zone No.1 - Laxmi Nagar")|| illegalWaterConnection.getZoneNo().equals("Zone No.01 - Laxmi Nagar") ? "1" :
								illegalWaterConnection.getZoneNo().equals("Zone No.2 - Dharampeth") || illegalWaterConnection.getZoneNo().equals("Zone No.02 - Dharampeth") ? "2" :
								illegalWaterConnection.getZoneNo().equals("Zone No.3 - Hanuman Nagar")|| illegalWaterConnection.getZoneNo().equals("Zone No.03 - Hanuman Nagar") ? "3" :
								illegalWaterConnection.getZoneNo().equals("Zone No.4 - Dhantoli")|| illegalWaterConnection.getZoneNo().equals("Zone No.04 - Dhantoli") ? "4" :
								illegalWaterConnection.getZoneNo().equals("Zone No.5 - Nehru Nagar")|| illegalWaterConnection.getZoneNo().equals("Zone No.05 - Nehru Nagar") ? "5" :
							    illegalWaterConnection.getZoneNo().equals("Zone No.6 - Gandhibagh")|| illegalWaterConnection.getZoneNo().equals("Zone No.06 - Gandhibagh") ? "6" :
								illegalWaterConnection.getZoneNo().equals("Zone No.7 - Satranjipura")|| illegalWaterConnection.getZoneNo().equals("Zone No.07 - Satranjipura") ? "7" :
								illegalWaterConnection.getZoneNo().equals("Zone No.8 - Lakadganj")|| illegalWaterConnection.getZoneNo().equals("Zone No.08 - Lakadganj") ? "8" :
								illegalWaterConnection.getZoneNo().equals("Zone No.9 - Ashi Nagar")|| illegalWaterConnection.getZoneNo().equals("Zone No.09 - Ashi Nagar") ? "9" :
								illegalWaterConnection.getZoneNo().equals("Zone No.10 - Mangalwari")|| illegalWaterConnection.getZoneNo().equals("Zone No.010 - Mangalwari") ? "10" :
							    "");
						}

				} else {			   
						rtiApplication.setZone(
								illegalWaterConnection.getZoneNo().equals("Zone No.1 - Laxmi Nagar")|| illegalWaterConnection.getZoneNo().equals("Zone No.01 - Laxmi Nagar") ? "1" :
								illegalWaterConnection.getZoneNo().equals("Zone No.2 - Dharampeth") || illegalWaterConnection.getZoneNo().equals("Zone No.02 - Dharampeth") ? "2" :
								illegalWaterConnection.getZoneNo().equals("Zone No.3 - Hanuman Nagar")|| illegalWaterConnection.getZoneNo().equals("Zone No.03 - Hanuman Nagar") ? "3" :
								illegalWaterConnection.getZoneNo().equals("Zone No.4 - Dhantoli")|| illegalWaterConnection.getZoneNo().equals("Zone No.04 - Dhantoli") ? "4" :
								illegalWaterConnection.getZoneNo().equals("Zone No.5 - Nehru Nagar")|| illegalWaterConnection.getZoneNo().equals("Zone No.05 - Nehru Nagar") ? "5" :
								illegalWaterConnection.getZoneNo().equals("Zone No.6 - Gandhibagh")|| illegalWaterConnection.getZoneNo().equals("Zone No.06 - Gandhibagh") ? "6" :
								illegalWaterConnection.getZoneNo().equals("Zone No.7 - Satranjipura")|| illegalWaterConnection.getZoneNo().equals("Zone No.07 - Satranjipura") ? "7" :
								illegalWaterConnection.getZoneNo().equals("Zone No.8 - Lakadganj")|| illegalWaterConnection.getZoneNo().equals("Zone No.08 - Lakadganj") ? "8" :
								illegalWaterConnection.getZoneNo().equals("Zone No.9 - Ashi Nagar")|| illegalWaterConnection.getZoneNo().equals("Zone No.09 - Ashi Nagar") ? "9" :
								illegalWaterConnection.getZoneNo().equals("Zone No.10 - Mangalwari")|| illegalWaterConnection.getZoneNo().equals("Zone No.010 - Mangalwari") ? "10" :
							    "");
						}
				
				
				rtiApplication.setEmail(illegalWaterConnection.getEmailId());

				// rtiApplication.setApplicationCost(tradeLicenseNameChange.getFees());

				rtiApplication.setApplicantName(illegalWaterConnection.getCinNo());
				rtiApplication.setPdfUploadFromPortal(illegalWaterConnection.getFilesPath());
				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(0);
				rtiApplicationDetails.setAssignToStatus(1);
				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());

				rtiApplicationDetails.setComments("Form Submitted");
				rtiApplicationDetails.setWorkflowLevel(0);
				rtiApplicationDetailsList.add(rtiApplicationDetails);
				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);
				RTIApplication retunRti = null;
				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/WD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					illegalWaterConnection.setRtiApplRefNo(rti.getRtiApplnNumber());
					illegalWaterConnection.setRtiRefId(savedRti.getRtiApplicationId());
					long birth_regis_id = illegalWaterConnectionService
							.illegalWaterConnectionComplaint(illegalWaterConnection);
					rti.setRtiApplicationRefId(birth_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					 retunRti = rtiApplicationService.merge(rti);
					
				
						String requestNo = illegalWaterConnection.getRtiApplRefNo();
						LocalDate currentDate = LocalDate.now();
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						String dateTime = format.format(currentDate);
						String title = illegalWaterConnection.getTitle();
						String contractAccountNo = illegalWaterConnection.getCinNo();
						String house_no = illegalWaterConnection.getPlotNo();
						String building_name = illegalWaterConnection.getBuildingName();
						String landmark = illegalWaterConnection.getLandmark();
						String locality = illegalWaterConnection.getAreaName();
						String zone = illegalWaterConnection.getZoneNo();
						String emailId = illegalWaterConnection.getEmailId();
						String Nearest_location = illegalWaterConnection.getStreetName();
						String name = illegalWaterConnection.getFullName();
						String contactNo = illegalWaterConnection.getMobileNo();
						String problem = illegalWaterConnection.getPurposeOfIllegalConn();
						String esr = illegalWaterConnection.getEsr();
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
						formData.add("zone", zone);
						formData.add("esr_code", esr);
						formData.add("emailId", emailId);
						formData.add("contactNo", contactNo);
						formData.add("Comp_maincat", "technical_complaints");
						formData.add("Comp_Subcat1", "illegal_connection");
						formData.add("Comp_Subcat2", "illegal_connection");
						formData.add("Nearest_location", Nearest_location);
						formData.add("Problem_desc", problem);
						formData.add("Reg_date", dateTime);
						formData.add("anonymous_check", "false");
						formData.add("type", "anonymous");

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

					

					String applname = illegalWaterConnection.getFullName();
					String link = "https://tinyurl.com/4hhhy9w9";
					String applnNo = rti.getRtiApplnNumber();

					String msg = "Dear " + applname + " your application with Application No. " + applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";

					msg.replace("var3", "");

					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", illegalWaterConnection.getMobileNo(), msg);
					SendEmail.sendEmail(illegalWaterConnection.getEmailId(),
							"Application Submitted Successfully" + applnNo, msg);
				}
				
//				ModelAndView model = new ModelAndView("newRTIIllegalWaterConnectionSuccess", "illegalWaterConnection",
//						illegalWaterConnection);
//				return model;
				return new ModelAndView("redirect:/ws/rtsapplication/newRTIIllegalWaterConnectionSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

			}
		}
		return new ModelAndView("redirect:/ws/user/login.do");


	}
	
	@RequestMapping("ws/rtsapplication/newRTIIllegalWaterConnectionSuccess.do")
	public ModelAndView newRTIIllegalWaterConnectionSuccess(HttpServletRequest
	request,HttpServletResponse response) {

	 String appNo = request.getParameter("rtsAppNo");
	 ModelAndView model = new ModelAndView("newRTIIllegalWaterConnectionSuccess");

	 model.addObject("appNo",appNo);
	 return model;


	 } 
	
	@RequestMapping("/rtsapplication/getIllegalWaterConnection.do")
	public void getIllegalWaterConnection(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
	
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

//	@RequestMapping("/rtsapplication/getIllegalWaterConnection.do")
//	public void getIllegalWaterConnection(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
//		log.debug(" came inside get water complaint");
//		JSONObject json = new JSONObject();
//
//
//			try {
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
//			} catch (Exception e) {
//				String error = "Record Not Found! Please Enter Valid CIN No.";
//				request.setAttribute("message", error);
//			}
//		
//
//	}

	@SuppressWarnings("unused")
	@RequestMapping("/rtsapplication/editIllegalWaterConnection.do")
	public ModelAndView editIllegalWaterConnection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		HttpSession session = request.getSession();
		IllegalWaterConnectionComplaint illegalWaterConnection = null;
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		request.getSession().setAttribute("refid",request.getParameter("rtiApplicationRefId"));
		String a1 = request.getParameter("rtiApplicationRefId");
		if (sessionUser != null) {

		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0 || session.getAttribute("rtirefId") != null) {
			if (request.getParameter("rtiApplicationRefId") != null && request.getParameter("rtiApplicationRefId").length() > 0) {

			rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
			illegalWaterConnection = illegalWaterConnectionService.get(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				illegalWaterConnection = illegalWaterConnectionService.get(rtiApplicationRefId);
			}
			 String feees = request.getParameter("fees");
			 String paymentStatus = request.getParameter("paymentStatus");

			if (illegalWaterConnection.getRtiRefId() > 0) {
				rtiApplicationId = illegalWaterConnection.getRtiRefId();
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
	
		ModelAndView modelAndView = new ModelAndView("manageIllegalWaterConnection", "illegalWaterConnection",
				illegalWaterConnection);

		return modelAndView;
	}
		return new ModelAndView("redirect:/login.do");
	}
	
	@RequestMapping("/rtiapplication/createWaterIllegalComplaintWork.do")
	public ModelAndView createWaterIllegalComplaintWork(HttpServletRequest request, HttpServletResponse response)
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
		IllegalWaterConnectionComplaint illegalWaterConnection = illegalWaterConnectionService.get(applicationId);
		String email = illegalWaterConnection.getEmailId();
		String mobileNo = illegalWaterConnection.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();

		if (illegalWaterConnection != null) {
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

		ModelAndView modelAndView = new ModelAndView("manageIllegalWaterConnection", "illegalWaterConnection",illegalWaterConnection);
		return modelAndView;
	}
	
	//Save Manage Disconnection
		
			@RequestMapping("/rtsapplication/saveIllegalComplaintWater.do")
			public ModelAndView saveIllegalComplaintWater(HttpServletRequest request,HttpServletResponse response,IllegalWaterConnectionComplaint illegalWaterConnection)
					throws ServletException, Exception {
			    String fees = request.getParameter("demandfees");
	            String refid =request.getParameter("illegalWaterConnectionID");
				long apprefid = 0;
				apprefid = Long.parseLong(refid);

				illegalWaterConnection = illegalWaterConnectionService.get(apprefid);
//				waterDisconnection.setSendDemandStatus(1);

				if (illegalWaterConnection.getDemandfees() == null && fees!=null) {
					illegalWaterConnection.setDemandfees(fees);
					illegalWaterConnection = illegalWaterConnectionService.merge(illegalWaterConnection);

				}
				return new ModelAndView("redirect:/rtsapplication/editIllegalWaterConnection.do?rtiApplicationRefId=" + apprefid + "&fees=" + fees);	
				}

	
			@RequestMapping("/rtsapplication/saveIllegalComplaintWaterPayment.do")
			public ModelAndView saveIllegalComplaintWaterPayment(HttpServletRequest request,HttpServletResponse response,IllegalWaterConnectionComplaint illegalWaterConnection)
					throws ServletException, Exception {
			    String paymentStatus = request.getParameter("paymentStatus");
	            String refid =request.getParameter("illegalWaterConnectionID");
				long apprefid = 0;
				apprefid = Long.parseLong(refid);

				illegalWaterConnection = illegalWaterConnectionService.get(apprefid);
//				waterDisconnection.setSendDemandStatus(1);
				String status=illegalWaterConnection.getPaymentStatus();
				if (illegalWaterConnection.getPaymentStatus() == null && paymentStatus!=null) {
					illegalWaterConnection.setPaymentStatus(paymentStatus);
					illegalWaterConnection = illegalWaterConnectionService.merge(illegalWaterConnection);

				}
				return new ModelAndView("redirect:/rtsapplication/editIllegalWaterConnection.do?rtiApplicationRefId=" + apprefid + "&paymentStatus=" + paymentStatus);	
				}

	

}
