package com.mars.rti.ws.controller;


import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.service.AapleSarkarTrackStatusService;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.ws.model.DeskDetailDTO;
import com.mars.rti.ws.model.TrackStatusMainDTO;
import com.mars.rti.ws.model.TrackStatusRequestDTO;
import com.mars.rti.ws.model.TrackStatusResponseDTO;
import com.mars.workflow.model.TaskHistoryDetails;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
@RequestMapping("/api/aaplesarkar")
public class AapleSarkarTrackStatusController {

	private static Log log = LogFactory.getLog(AapleSarkarTrackStatusController.class);

	@Autowired
	private AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;

	@Autowired
	private AapleSarkarTrackStatusService aapleSarkarTrackStatusService;

	
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";

	@RequestMapping(value = "/trackStatus.do", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json")
	@ResponseBody
	public TrackStatusResponseDTO trackStatus(HttpServletRequest request) {

		try {
			String encryptedStr = request.getParameter("str");
			String serviceId = request.getParameter("ns");

			if (encryptedStr == null || encryptedStr.trim().isEmpty()) {
				return buildErrorResponse("Missing parameter: str");
			}

			String decryptedPipeData = aapleSarkarPortalIntegrationNagpur.simpleTripleDesDecrypt(encryptedStr,
					clientEncryptKey, clientEncryptIV);

			if (decryptedPipeData == null || decryptedPipeData.equalsIgnoreCase("false")) {
				return buildErrorResponse("Authentication Failed");
			}

			String[] fields = decryptedPipeData.split("\\|");

			if (fields.length < 3) {
				return buildErrorResponse("Invalid request format");
			}

			String applicationId = fields[2];
			
			System.out.println("check Application id-"+applicationId);

			RTIApplication rtiApplication = aapleSarkarTrackStatusService.findByRTIApplicationNumber(applicationId);

			if (rtiApplication == null) {
				return buildErrorResponse("Application Not Found");
			}

			TrackStatusResponseDTO response = new TrackStatusResponseDTO();

			response.setApplicationID(applicationId);
			response.setServiceName(rtiApplication.getSubject());
			response.setApplicantName(rtiApplication.getApplicantName());
			response.setEstimatedDisbursalDays(0);

			SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy,HH:mm:ss");

			if (rtiApplication.getCreatedDate() != null && !rtiApplication.getCreatedDate().trim().isEmpty()) {

				Date createdDate = inputFormat.parse(rtiApplication.getCreatedDate());
				response.setApplicationSubmissionDate(outputFormat.format(createdDate));
			} else {
				response.setApplicationSubmissionDate("");
			}

			response.setApplicationPaymentDate("");
			response.setNextActionRequiredDetails("");

			int workflowStatus = rtiApplication.getWorkFlowStatus();
			int finalDecision;

			if (workflowStatus == 5) {
				finalDecision = 1; // Rejected
			} else if (workflowStatus == 1) {
				finalDecision = 0; // Approved
			} else if (workflowStatus == 3) {
				finalDecision = 3; // PendingAtCitizen
			} else {
				finalDecision = 2; // PendingAtDepartment
			}

			response.setFinalDecision(finalDecision);

			response.setTotalNumberOfDesks(0);
			response.setCurrentDeskNumber(0);
			response.setNextDeskNumber(0);
			response.setDeskDetails(new ArrayList<DeskDetailDTO>());
			// -------- Desk Details from Workflow --------

			// entityId = your RTIApplication ID (DB primary key)
			String entityId = String.valueOf(rtiApplication.getRtiApplicationId());

			// entityName = same as used in workflow (very important)
			// Example: "RTIApplication" or whatever your workflow uses
			String entityName=rtiApplication.getTemplateName();
			//String entityName = "RTIApplication";

			List<DeskDetailDTO> desks = buildDeskDetailsFromWorkflow(request, entityId, entityName);

			response.setDeskDetails(desks);
			response.setTotalNumberOfDesks(desks.size());

			// Set current desk as last record
			if (desks.size() > 0) {
				response.setCurrentDeskNumber(desks.size());
			} else {
				response.setCurrentDeskNumber(0);
			}

			// Next desk number (0 if workflow completed)
			response.setNextDeskNumber(0);

			return response;

		} catch (Exception e) {
			log.error("Exception in trackStatus API", e);
			return buildErrorResponse("Internal Server Error");
		}
	}

	private TrackStatusResponseDTO buildErrorResponse(String message) {

		TrackStatusResponseDTO error = new TrackStatusResponseDTO();

		error.setApplicationID("");
		error.setServiceName("");
		error.setApplicantName("");
		error.setEstimatedDisbursalDays(0);
		error.setApplicationSubmissionDate("");
		error.setApplicationPaymentDate("");
		error.setNextActionRequiredDetails(message);
		error.setFinalDecision(1);
		error.setTotalNumberOfDesks(0);
		error.setCurrentDeskNumber(0);
		error.setNextDeskNumber(0);
		error.setDeskDetails(new ArrayList<DeskDetailDTO>());

		return error;
	}
	
	 @RequestMapping(
	            value = "/strEncryption",
	            method = RequestMethod.POST,
	            produces = "application/json")
	    @ResponseBody
	    public String trackStatus(
	            @RequestBody TrackStatusRequestDTO requestDto) throws Exception {

	        ObjectMapper mapper = new ObjectMapper();

	        // Convert DTO to JSON (VERY IMPORTANT)
	        String jsonRequest = mapper.writeValueAsString(requestDto);
	        
	        System.out.println("check json request"+jsonRequest);

	        String encryptedResponse =
	        		aapleSarkarPortalIntegrationNagpur.simpleTripleDes(
	                        jsonRequest,
	                        clientEncryptKey,
	                        clientEncryptIV);

	        return encryptedResponse;
	    }
	
	
	 @RequestMapping(
		        value = "/trackApplicationStatus.do",
		        method = { RequestMethod.POST },
		        produces = "application/json")
		@ResponseBody
		public void trackApplicationStatus(HttpServletRequest request,  HttpServletResponse response1) throws Exception {

		    try {

		        // ✅ STEP 1 — Read encrypted RAW body
		        StringBuilder sb = new StringBuilder();
		        BufferedReader reader = request.getReader();
		        String line;

		        while ((line = reader.readLine()) != null) {
		            sb.append(line);
		        }

		        String encryptedStr = sb.toString().trim();

		        System.out.println("Encrypted Body: " + encryptedStr);

		        if (encryptedStr.isEmpty()) {
		             buildApplicationErrorResponse("Missing encrypted body", response1);
		        }

		        // ✅ STEP 2 — Decrypt
		        String decryptedPipeData =
		        		aapleSarkarPortalIntegrationNagpur.simpleTripleDesDecrypt(
		                        encryptedStr,
		                        clientEncryptKey,
		                        clientEncryptIV);

		        System.out.println("Decrypted Data: " + decryptedPipeData);

		        if (decryptedPipeData == null || decryptedPipeData.equalsIgnoreCase("false")) {
		             buildApplicationErrorResponse("Authentication Failed", response1);
		        }

		        // SAME OLD LOGIC BELOW (unchanged)

		        ObjectMapper mapper = new ObjectMapper();

		        TrackStatusRequestDTO reqDto =
		                mapper.readValue(decryptedPipeData, TrackStatusRequestDTO.class);

		        String applicationId = reqDto.getAppID();

		        System.out.println("Application Id : " + applicationId);

		        RTIApplication rtiApplication =
		                aapleSarkarTrackStatusService.findByRTIApplicationNumber(applicationId);

		        if (rtiApplication == null) {
		             buildApplicationErrorResponse("Application Not Found", response1);
		        }
		        TrackStatusMainDTO mainResponse = new TrackStatusMainDTO();
		        
		        mainResponse.setRecordStatus(true);
		        mainResponse.setMessage("");

		        TrackStatusResponseDTO response = new TrackStatusResponseDTO();

				response.setApplicationID(applicationId);
				response.setServiceName(rtiApplication.getSubject());
				response.setApplicantName(rtiApplication.getApplicantName());
				response.setEstimatedDisbursalDays(0);

				SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy,HH:mm:ss");

				if (rtiApplication.getCreatedDate() != null && !rtiApplication.getCreatedDate().trim().isEmpty()) {

					Date createdDate = inputFormat.parse(rtiApplication.getCreatedDate());
					response.setApplicationSubmissionDate(outputFormat.format(createdDate));
				} else {
					response.setApplicationSubmissionDate("");
				}

				response.setApplicationPaymentDate("");
				response.setNextActionRequiredDetails("");

				int workflowStatus = rtiApplication.getWorkFlowStatus();
				int finalDecision;

				if (workflowStatus == 5) {
					finalDecision = 1; // Rejected
				} else if (workflowStatus == 1) {
					finalDecision = 0; // Approved
				} else if (workflowStatus == 3) {
					finalDecision = 3; // PendingAtCitizen
				} else {
					finalDecision = 2; // PendingAtDepartment
				}

				response.setFinalDecision(finalDecision);

				response.setTotalNumberOfDesks(0);
				response.setCurrentDeskNumber(0);
				response.setNextDeskNumber(0);
				response.setDeskDetails(new ArrayList<DeskDetailDTO>());
				// -------- Desk Details from Workflow --------

				// entityId = your RTIApplication ID (DB primary key)
				String entityId = String.valueOf(rtiApplication.getRtiApplicationId());

				// entityName = same as used in workflow (very important)
				// Example: "RTIApplication" or whatever your workflow uses
				String entityName=rtiApplication.getTemplateName();
				//String entityName = "RTIApplication";

				List<DeskDetailDTO> desks = buildDeskDetailsFromWorkflow(request, entityId, entityName);

				response.setDeskDetails(desks);
				response.setTotalNumberOfDesks(desks.size());

				// Set current desk as last record
				if (desks.size() > 0) {
					response.setCurrentDeskNumber(desks.size());
				} else {
					response.setCurrentDeskNumber(0);
				}

				// Next desk number (0 if workflow completed)
				response.setNextDeskNumber(0);

				//ObjectMapper mapper = new ObjectMapper();
				
				mainResponse.setApplicationStatus(response);

				// Step 1: Convert response DTO to JSON
				String responseJson = mapper.writeValueAsString(mainResponse);

				System.out.println("Plain Response JSON : " + responseJson);

				// Step 2: Encrypt JSON
				String encryptedResponse =
						aapleSarkarPortalIntegrationNagpur.simpleTripleDes(
				                responseJson,
				                clientEncryptKey,
				                clientEncryptIV);

				System.out.println("Encrypted Response : " + encryptedResponse);

				// Step 3: Return encrypted text
				response1.setContentType("text/plain");
				response1.getWriter().write(encryptedResponse);
		    } catch (Exception e) {
		        log.error("Exception in trackStatus API", e);
		         buildApplicationErrorResponse("Internal Server Error", response1);
		    }
		}

	 
	 private void buildApplicationErrorResponse(String message,
             HttpServletResponse response) throws Exception {

		    TrackStatusResponseDTO error = new TrackStatusResponseDTO();

		    error.setApplicationID("");
		    error.setServiceName("");
		    error.setApplicantName("");
		    error.setEstimatedDisbursalDays(0);
		    error.setApplicationSubmissionDate("");
		    error.setApplicationPaymentDate("");
		    error.setNextActionRequiredDetails(message);
		    error.setFinalDecision(1);
		    error.setTotalNumberOfDesks(0);
		    error.setCurrentDeskNumber(0);
		    error.setNextDeskNumber(0);
		    error.setDeskDetails(new ArrayList<DeskDetailDTO>());

		    // ✅ Convert to JSON
		    ObjectMapper mapper = new ObjectMapper();
		    String errorJson = mapper.writeValueAsString(error);

		    // ✅ Encrypt JSON
		    String encryptedError =
		    		aapleSarkarPortalIntegrationNagpur.simpleTripleDes(
		                    errorJson,
		                    clientEncryptKey,
		                    clientEncryptIV);

		    response.setContentType("text/plain");
		    response.getWriter().write(encryptedError);
		}

//    private void loadWorkflowDetails(HttpServletRequest request, String strEntityId, String strEntityName, String strUserName) {
//		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
//		WorkflowProcessDetailsService workflowProcessDetailsService = (WorkflowProcessDetailsService) applicationContext.getBean("workflowProcessDetailsService");
//		WorkflowService workflowService = (WorkflowService) applicationContext.getBean("workflowService");
//
//		WorkflowProcessDetails workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(Long.parseLong(strEntityId), strEntityName);
//		
//
//		if (workflowProcessDetails != null) {
//			long id = workflowProcessDetails.getEntityId();
//			RTIApplication rtiApplication = aapleSarkarTrackStatusService.get(id);
//			
//			Integer status = rtiApplication.getWorkFlowStatus();
//			String processId = workflowProcessDetails.getProcessId();
//			String taskId = workflowService.getCurrentTaskId(processId);
//			String userName = workflowProcessDetails.getUserName();
//			boolean blnJob = false;
//			if (userName.equalsIgnoreCase(strUserName)) {
//				blnJob = true;
//			}
//			// If the Record is created by CFC User then give Edit permission
//			// for all users who has the task.
//			else if (userName.equalsIgnoreCase(WorkflowConstants.WORKFLOW_USER_NAME)) {
//				blnJob = true;
//			}
//			NmmcWorkflowInstance workflowInstance = new NmmcWorkflowInstance();
//			workflowInstance.setId(workflowProcessDetails.getProcessId());
//
//			request.setAttribute(WorkflowConstants.WORKFLOW_JOB_ID, processId);
//			request.setAttribute(WorkflowConstants.WORKFLOW_TASK_ID, taskId);
//
//			request.setAttribute("nmmcWorkflowInstance", workflowInstance);
//			List<List<TaskHistoryDetails>> listTaskHistory = new ArrayList<List<TaskHistoryDetails>>();
//			List<WorkflowProcessDetails> listProcessDetails = workflowProcessDetailsService.getAllWorkflowProcessDetailsByEntityDetails(Long.parseLong(strEntityId), strEntityName);
//			if(listProcessDetails != null)
//			{
//				for (WorkflowProcessDetails process : listProcessDetails) {
//					if (process.getWorkflowStatus() != WorkflowConstants.WORKFLOW_STATUS_ABORTED)
//						listTaskHistory.add(workflowService.getTaskHistory(process.getProcessId()));
//					else
//						listTaskHistory.add(workflowService.getTaskHistoryAll(process.getProcessId()));
//				}
//			}
//			request.setAttribute("TASK_HISTORY", listTaskHistory);
//			request.setAttribute("PROCESS_ENDED", false);
//
//			if (!workflowService.isProcessEnded(processId)) {
//				request.setAttribute("WORKFLOW_TRANSISTIONS", workflowService.getTaskTransitions(taskId));
//				request.setAttribute("WORKFLOW_TASK_DETAILS", workflowService.getTaskDetails(taskId));
//				boolean blnMyTask = workflowService.isMyTask(taskId, strUserName);
//				
//				if (!blnMyTask && status == 2 || !blnMyTask && status == 9 || !blnMyTask && status == 11 || !blnMyTask && status == 12) {
//					request.setAttribute("WORKFLOW_COMMENTS", "Task Details - <span style='color:red'>Currently you do not have permission to work on this task.</span>");
//					request.setAttribute("IS_MY_TASK", blnMyTask);
//					request.setAttribute("IS_MY_JOB", blnJob);
//				}else if(status == 3){
//					request.setAttribute("WORKFLOW_COMMENTS", "Task Details - <span style='color:green'>Please take necessary actions by clicking on action buttons.</span>");
//					blnMyTask = true;
//					request.setAttribute("IS_MY_TASK", blnMyTask);
//					request.setAttribute("IS_MY_JOB", blnJob);
//				}else {
//					
//					request.setAttribute("WORKFLOW_COMMENTS", "Task Details - <span style='color:green'>Please take necessary actions by clicking on action buttons.</span>");
//					request.setAttribute("IS_MY_TASK", blnMyTask);
//					request.setAttribute("IS_MY_JOB", blnJob);
//				}
//				
//			} else {
//				request.setAttribute("WORKFLOW_COMMENTS", "Task Details - <span style='color:green'>Workflow completed successfully.</span>");
//				request.setAttribute("PROCESS_ENDED", true);
//			}
//			
//		}
//	}

	private List<DeskDetailDTO> buildDeskDetailsFromWorkflow(HttpServletRequest request, String entityId,
			String entityName) {

		List<DeskDetailDTO> deskList = new ArrayList<DeskDetailDTO>();

		try {
			ApplicationContext applicationContext = WebApplicationContextUtils
					.getWebApplicationContext(request.getSession().getServletContext());

			WorkflowProcessDetailsService workflowProcessDetailsService = (WorkflowProcessDetailsService) applicationContext
					.getBean("workflowProcessDetailsService");

			WorkflowService workflowService = (WorkflowService) applicationContext.getBean("workflowService");

// Get all workflow process records for this application
			List<WorkflowProcessDetails> listProcessDetails = workflowProcessDetailsService
					.getAllWorkflowProcessDetailsByEntityId(Long.parseLong(entityId));

			if (listProcessDetails != null) {

				SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy,HH:mm:ss");

				for (WorkflowProcessDetails process : listProcessDetails) {

					String processId = process.getProcessId();

					List<TaskHistoryDetails> taskHistoryList;

					if (process.getWorkflowStatus() != WorkflowConstants.WORKFLOW_STATUS_ABORTED) {
						taskHistoryList = workflowService.getTaskHistory(processId);
					} else {
						taskHistoryList = workflowService.getTaskHistoryAll(processId);
					}

					if (taskHistoryList != null) {

						for (TaskHistoryDetails task : taskHistoryList) {

							DeskDetailDTO desk = new DeskDetailDTO();
//							DeskNumber
//							ReviewActionBy
//							ReviewActionDateTime
//							ReviewActionDetails



// Task Id
							desk.setDeskNumber(task.getTaskId());

// Action
							//desk.setAction(task.getActivityName());

// User Name
							//desk.setUserName(task.getUserName());
							desk.setReviewActionBy(task.getAssignee());


// Start Date
							if (task.getCreateTime() != null) {
								desk.setReviewActionDateTime(outputFormat.format(task.getCreateTime()));
							} else {
								desk.setReviewActionDateTime("");
							}

// End Date
							if (task.getEndTime() != null) {
								desk.setReviewActionDateTime(outputFormat.format(task.getEndTime()));
							} else {
								desk.setReviewActionDateTime("");
							}
							desk.setDeskRemark("");

// Number Of Days (difference)
//							if (task.getStartDate() != null && task.getEndDate() != null) {
//								long diffMillis = task.getEndDate().getTime() - task.getStartDate().getTime();
//								long days = diffMillis / (1000 * 60 * 60 * 24);
//								desk.setNumberOfDays(days);
//							} else {
//								desk.setNumberOfDays(0);
//							}

// Comments
							desk.setReviewActionDetails(task.getComments());

							deskList.add(desk);
						}
					}
				}
			}

		} catch (Exception e) {
			log.error("Error while building desk details from workflow", e);
		}

		return deskList;
	}

	
	@RequestMapping(
	        value = "/strDecryption",
	        method = RequestMethod.POST,
	        produces = "application/json")
	@ResponseBody
	public String trackStatus(@RequestBody String encryptedRequest) throws Exception {

	    System.out.println("Encrypted Request: " + encryptedRequest);

	    String decryptedResponse =
	            aapleSarkarPortalIntegrationNagpur.simpleTripleDesDecrypt(
	                    encryptedRequest,
	                    clientEncryptKey,
	                    clientEncryptIV);
	    log.debug("decryptedResponse : "+decryptedResponse);
	    return decryptedResponse;
	}

}
