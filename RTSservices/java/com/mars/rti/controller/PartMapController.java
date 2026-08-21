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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.PartMap;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.PartMapService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.PartMapRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class PartMapController {
	private static Log log = LogFactory.getLog(PartMapController.class);
	
	
	String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";

	@Autowired
	private PartMapService partMapService;
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
	private UserRegistrationService userService;

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;


	private static final int MAX_FILE_SIZE = 1024 * 1024 * 50; // 10MB
	private static final int REQUEST_SIZE = 1024 * 1024 * 100; // 50MB

//
//    @RequestMapping("ws/rtiapplication/newRTIPartMapApplication.do")
//	public ModelAndView newRTIPartMapApplication(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException {
//   	  		String baseDir = getServletContext().getRealPath("");
//   	 		String folder = "partMap";
//   	 		File file = new File(baseDir, folder);
//   	 		if (!file.exists()) {
//   	 			file.mkdirs();
//   	 		}
//		ModelAndView modelAndView = new ModelAndView("newRTIPartMapApplication");
//		modelAndView.addObject("folderName", folder);
//
//		return modelAndView;
//	}
//    
// 	
//
//	@RequestMapping("/rtiapplication/uploadDocumentPart.do")
//	public void uploadDocumentPart(HttpServletRequest request, HttpServletResponse response) throws FileUploadException{
//
//		log.info("Document Uploaded");                     
//		try {
//			String baseDir = getServletContext().getRealPath("") + File.separator + "partMap";
//			File file = new File(baseDir);
//			if (!file.exists()) {
//				file.mkdirs();
//			}
//
//			String[] name = new String[12];
//			if (FileUpload.isMultipartContent(request)) {
//				DiskFileItemFactory factory = new DiskFileItemFactory();
//				factory.setSizeThreshold(MAX_FILE_SIZE);
//				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
//
//				ServletFileUpload upload = new ServletFileUpload(factory);
//				upload.setFileSizeMax(MAX_FILE_SIZE);
//				upload.setSizeMax(REQUEST_SIZE);
//
//				List formItems = upload.parseRequest(request);
//				Iterator iter = formItems.iterator();
//
//				int i = 0;
//
//				while (iter.hasNext()) {
//					FileItem item = (FileItem) iter.next(); // processes
//					if (!item.isFormField() && !item.getName().isEmpty() && item.getName() != null) {
//
//						String fileName = new File(item.getName()).getName();
//						int l = fileName.lastIndexOf(".");
//						String imageext = fileName.substring(l, fileName.length());
//						fileName = fileName.substring(0, l);
//						fileName = fileName.replaceAll("\\W", "");
//						fileName = fileName + "" + imageext;
//						name[i] = item.getName();
//
//						File storeFile = new File(baseDir, i + fileName); // saves the file on disk
//						item.write(storeFile);
//
//					}
//					i++;
//				}
//
//			} else {
//				request.setAttribute("message", "Please contact the system admin");
//			}
//		} catch (Exception ex) {
//			log.error(ex);
//			request.setAttribute("message", "Please contact the system admin");
//			ex.printStackTrace();
//		}
//
//	}

	@RequestMapping("/rtsapplication/savePartMapCertificates.do")
	public ModelAndView savePartMapApplication(HttpServletRequest request, HttpServletResponse response,
			PartMap partmap) throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking PartMap");
		}
		String mobileNumber = "";
		RTIApplication retunRti=null;
		String user_name=null;
		Object user_login= request.getSession().getAttribute("name");
		if(user_login!=null) {
			 user_name = (String)user_login;
		}
		Object obileNumber= session.getAttribute("mobileNo");
		if(obileNumber!=null) {
		mobileNumber=String.valueOf(obileNumber);
		}else {
		mobileNumber = (String) session.getAttribute("mobileNo");
		}
		if (mobileNumber != null) {
			UserRegistrationDetails user = userService.getUserByMobileNo(mobileNumber);
			Object as_status=session.getAttribute("as_status");

			if (partmap != null) {

				RTIApplication rtiApplication = new RTIApplication();
				PartMapRestDTO partMapnRestDTO = new PartMapRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("PARTMAP-CERTIFICATE");
				rtiApplication.setDepartment("TOWN-PLANNING-DEPARTMENT");
				rtiApplication.setTemplateName("townPlanning");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(28);
				rtiApplication.setApplicantName(
						partmap.getFirstName() + " " + partmap.getMiddleName() + " " + partmap.getLastName());
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
					
				}
				rtiApplication.setPhoneNumber(partmap.getMobileNo());
				rtiApplication.setMobileNumber(partmap.getMobileNo());
				rtiApplication.setEmail(partmap.getEmail());
				rtiApplication.setZone(partmap.getMouzaZone());
				rtiApplication.setIsApleSarkarApp(0);


				// rtiApplication.setApplicationCost(15);

				rtiApplication.setApplicantName(
						partmap.getFirstName() + " " + partmap.getMiddleName() + " " + partmap.getLastName());
				rtiApplication.setPdfUploadFromPortal(partmap.getFilesPath());
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
					rti.setRtiApplnNumber("RTS/TPD"  + "/" + savedRti.getRtiApplicationId() + "/" + Year.now());
					partmap.setRtiapplrefno(rti.getRtiApplnNumber());
					partmap.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = partMapService.partMap(partmap);
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

//					if ((retunRti != null) && (birth_regis_id > 0)) {
//						partMapnRestDTO.setResponseStatus("Requested data saved successfully");
//						partMapnRestDTO.setResponse(retunRti.getRtiApplicationId());
//						partMapnRestDTO.setResult(retunRti.getRtiApplnNumber());
//					}

					String name = partmap.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String appId = rti.getRtiApplnNumber();
					String mobileNo = partmap.getMobileNo();
					String email=partmap.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}
//				return new ModelAndView("newRTIPartMapSucess");
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
						String mobileApla = partmap.getMobileNo();
						
						
						/*
						 * String[] fields = request.getParameterValues("fields"); for (int i = 0; i <
						 * fields.length; i++) { log.debug("Index controller XXX--> " + i + ": " +
						 * fields[i]); }
						 */

						 //String retrurnurl="https://nagpur.egovmars.in/RTSservices/ws/rtsapplication/newRtSPartMapSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
						//String retrurnurl="https://nagpur.egovmars.in/RTSservices/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
						 String retrurnurl="https://nmcnagpur.gov.in/RTSservices/ws/rtsapplication/newRtSPartMapSuccess.do?rtsAppNo="+appId+ "&isApleSarkar="+ retunRti.getIsApleSarkarApp();

						String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
								 digitalSignStatus,digitalSignDate,estServiceDays, 
								 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
						
					log.debug("Final  PushBAck status XXX-->>>"+pushBackrespose);
					
					return new ModelAndView("redirect:/ws/rtsapplication/newRtSPartMapSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber()
					 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
							);

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSPartMapSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber()
				 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
						);
				}

			}
		}
//		ModelAndView modelAndView = new ModelAndView("newRTIMandapPermissionSucess");
//		modelAndView.addObject("result", "Save successfully done");
		return new ModelAndView("redirect:/ws/user/login.do");
	}

	
	
	
	@RequestMapping("ws/rtsapplication/newRtSPartMapSuccess.do")
	public ModelAndView newRtSPartMapSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		String isApleSarkar=request.getParameter("isApleSarkar");

		ModelAndView model = new ModelAndView("newRTIPartMapSucess");
		model.addObject("isApleSarkar", isApleSarkar);

		model.addObject("partmap",appNo);
		return model;
				
		
	}

	@RequestMapping("/rtiapplication/editPartMap.do")
	public ModelAndView editPartMap(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {

		PartMap partMap = null;
		HttpSession session = request.getSession();
		System.out.println(" editPartMap");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if(sessionUser!=null) {
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0
				|| session.getAttribute("rtirefId") != null) {
			if (request.getParameter("rtiApplicationRefId") != null
					&& request.getParameter("rtiApplicationRefId").length() > 0) {
				rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
				partMap = partMapService.get(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				partMap = partMapService.get(rtiApplicationRefId);
			}

			if (partMap.getRti_ref_id() > 0) {
				rtiApplicationId = partMap.getRti_ref_id();
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
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_TOWN_PLANNING_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_TOWN_PLANNING_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(
				rtiApplicationId, CoreConstants.RTI_TOWN_PLANNING_WORKFLOW_ENTITY);

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

		ModelAndView modelAndView = new ModelAndView("managePartMap", "partMap", partMap);

		return modelAndView;

	}else {
		return new ModelAndView("/login.do");
	}
	}

	@RequestMapping("/rtiapplication/createPartMapWork.do")
	public ModelAndView createPartMapWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(
				rtiApplicationId, CoreConstants.RTI_TOWN_PLANNING_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		PartMap partMap = partMapService.get(applicationId);
		String email = partMap.getEmail();
		String mobileNo = partMap.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();

		if (partMap != null) {
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
				SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

				request.setAttribute("workFlowCompleted", "1");

			}

		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_TOWN_PLANNING_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_TOWN_PLANNING_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		// ModelAndView modelAndView = new ModelAndView("manageMandapPermission",
		// "mandapPermission", mandapPermission);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView("redirect:/rtiapplication/editPartMap.do");
	}

}
