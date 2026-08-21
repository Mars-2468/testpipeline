package com.mars.rti.controller;

import java.io.File;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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

import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.TradeLicenseDuplicateCopy;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TradeLicenseDuplicateCopyService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class TradeLicenseDuplicateController {

	private static Log log = LogFactory.getLog(TradeLicenseDuplicateController.class);
	@Autowired
	private TradeLicenseDuplicateCopyService tradeLicenseDuplicateCopyService;
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

	@RequestMapping("/rtsapplication/saveTradeLiCenseDuplicateCopy.do")
	public ModelAndView saveTradeLicenseDuplicateCopy(HttpServletRequest request, HttpServletResponse response,
			TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy) throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Trade");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking tradeLicenseDuplicateCopy");
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
			if (tradeLicenseDuplicateCopy != null) {

				RTIApplication rtiApplication = new RTIApplication();
				// tradeLicenseNameChangeRestDTO tradeLicenseNameChangeRestDTO = new
				// tradeLicenseNameChangeRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("TRADE-LICENSE-DUPLICATE");
				rtiApplication.setDepartment("MARKET-DEPARTMENT");
				rtiApplication.setTemplateName("marketDepartment");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(41);
				rtiApplication.setApplicantName(tradeLicenseDuplicateCopy.getFirstName() + " "
						+ tradeLicenseDuplicateCopy.getMiddleName() + " " + tradeLicenseDuplicateCopy.getLastName());
				rtiApplication.setPhoneNumber(tradeLicenseDuplicateCopy.getMobileNumber());
				rtiApplication.setMobileNumber(tradeLicenseDuplicateCopy.getMobileNumber());
				rtiApplication.setZone(tradeLicenseDuplicateCopy.getZoneNo());
				rtiApplication.setUserRegistrationDetails(user);

				rtiApplication.setEmail(tradeLicenseDuplicateCopy.getEmailID());

				rtiApplication.setApplicationCost(tradeLicenseDuplicateCopy.getFeesApplicable());
				// rtiApplication.setApplicationCost(15);

				rtiApplication.setApplicantName(tradeLicenseDuplicateCopy.getFullName());
				rtiApplication.setPdfUploadFromPortal(tradeLicenseDuplicateCopy.getFilesPath());
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
					rti.setRtiApplnNumber("RTS/MD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					tradeLicenseDuplicateCopy.setRtiApplRefNo(rti.getRtiApplnNumber());
					tradeLicenseDuplicateCopy.setRtiRefId(savedRti.getRtiApplicationId());
					long birth_regis_id = tradeLicenseDuplicateCopyService
							.tradeLicenseDuplicateCopy(tradeLicenseDuplicateCopy);
					rti.setRtiApplicationRefId(birth_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
				 retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {
						// tradeLicenseNameChangeRestDTO.setResponseStatus("Requested data saved
						// successfully");
						// tradeLicenseNameChangeRestDTO.setResponse(retunRti.getRtiApplicationId());
						// tradeLicenseNameChangeRestDTO.setResult(retunRti.getRtiApplnNumber());
					}
					String name = tradeLicenseDuplicateCopy.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = tradeLicenseDuplicateCopy.getMobileNumber();
					String email=tradeLicenseDuplicateCopy.getEmailID();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}
			
				Object as_status=session.getAttribute("as_status");
				if(as_status!=null) {
					return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSTradeicenseDulicateCopySuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());
				}
				
				
			}
		}
		return new ModelAndView("redirect:/ws/user/login.do");


	}
	
	
	@RequestMapping("ws/rtsapplication/newRtSTradeicenseDulicateCopySuccess.do")
	public ModelAndView newRtSMandapPermissionSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTITradeLicenseDuplicateCopySuccess");
		
		model.addObject("tradeLicenseDuplicateCopy",appNo);
		return model;
				
		
	}

	@RequestMapping("/rtiapplication/editTradeLicenseDuplicateCopy.do")
	public ModelAndView editTradeLicenseDuplicateCopy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {

		TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy = null;
		HttpSession session = request.getSession();
		System.out.println(" editTradeLicenseDuplicateCopy");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0
				|| session.getAttribute("rtirefId") != null) {
			if (request.getParameter("rtiApplicationRefId") != null
					&& request.getParameter("rtiApplicationRefId").length() > 0) {
				rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
				tradeLicenseDuplicateCopy = tradeLicenseDuplicateCopyService.get(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				tradeLicenseDuplicateCopy = tradeLicenseDuplicateCopyService.get(rtiApplicationRefId);
			}

			if (tradeLicenseDuplicateCopy.getRtiRefId() > 0) {
				rtiApplicationId = tradeLicenseDuplicateCopy.getRtiRefId();
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
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);

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

		ModelAndView modelAndView = new ModelAndView("manageTradeLicenseDuplicateCopy", "tradeLicenseDuplicateCopy",
				tradeLicenseDuplicateCopy);

		return modelAndView;

	}

	public static void setUploadDocsOnEditMode(HttpServletRequest request, ServletContext servletContext,
			String applicationType, RTIApplication rtiapplication) {

		String appNum = String.valueOf(rtiapplication.getRtiApplicationId());
		String mainDir = null;
		ServletContext context = servletContext;
		String downloadPath = rtiapplication.getPdfUploadFromPortal();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@DOwnload Path" + downloadPath);
		List<String> paths = null;
		int count = 0;
		if (downloadPath != null) {
			String[] pathArr = downloadPath.split(",");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@pathArr Path" + pathArr);
			for (String httppath : pathArr) {
				if (count == 0)
					paths = new ArrayList<>();
				paths.add(httppath);
				count++;
			}

		}
		request.setAttribute("downloadCount", count);
		request.setAttribute("downloadPath", paths);

		if (appNum != null && !appNum.equals("0")) {

			// if(applicationType.equals("BirthRegistration"))

			mainDir = servletContext.getRealPath("") + "/Upload/" + appNum + "/";
			if (applicationType.equals("DEBRIESPERMISSION"))
				mainDir = servletContext.getRealPath("") + "/DebriesPermissionUploads/" + appNum + "/";
			if (applicationType.equals("COMMUNITYCENTER"))
				mainDir = servletContext.getRealPath("") + "/CommunitycenterUploads/" + appNum + "/";
			if (applicationType.equals("FESTIVALPANDAL"))
				mainDir = servletContext.getRealPath("") + "/FestivalpandalUploads/" + appNum + "/";
			if (applicationType.equals("ROADDIGGING"))
				mainDir = servletContext.getRealPath("") + "/RoaddiggingUploads/" + appNum + "/";
			if (applicationType.equals("STALLFORDIWALI"))
				mainDir = servletContext.getRealPath("") + "/StallfordiwaliUploads/" + appNum + "/";
			if (applicationType.equals("STAGEPANDALINGROUND"))
				mainDir = servletContext.getRealPath("") + "/stagepandalingroundUploads/" + appNum + "/";
			if (applicationType.equals("SUCTIONPERMISSION"))
				mainDir = servletContext.getRealPath("") + "/suctionjettinguploads/" + appNum + "/";

			File idProofDir = new File(mainDir + "Upload");
			if (idProofDir.exists()) {
				File[] idProofNameFiles = idProofDir.listFiles();
				if (idProofNameFiles.length > 0) {
					request.setAttribute("idProofRequired", false);
					String[] idProofName = new String[10];
					int i = 0;
					for (File file : idProofNameFiles) {
						if (file.isFile()) {
							idProofName[i] = file.getName();
							System.out.println(file.getName());
							i++;
						}
					}
					request.setAttribute("idProofName", idProofName);
				} else {
					request.setAttribute("idProofRequired", true);
				}
			} else {
				request.setAttribute("idProofRequired", true);
			}

			File inspectionReportoneDir = new File(mainDir + "inspectionReportone");
			if (inspectionReportoneDir.exists()) {
				File[] inspectionReportoneDirNameFiles = inspectionReportoneDir.listFiles();
				if (inspectionReportoneDirNameFiles.length > 0) {
					request.setAttribute("inspectionReportoneRequired", false);
					String[] inspectionReportoneName = new String[10];
					int i = 0;
					for (File file : inspectionReportoneDirNameFiles) {
						if (file.isFile()) {
							inspectionReportoneName[i] = file.getName();
							System.out.println(file.getName());
							i++;
						}
					}
					request.setAttribute("inspectionreport1", inspectionReportoneName);
				} else {
					request.setAttribute("inspectionReportoneRequired", true);
				}
			} else {
				request.setAttribute("inspectionReportoneRequired", true);
			}

			File inspectionReporttwoDir = new File(mainDir + "inspectionReporttwo");
			if (inspectionReporttwoDir.exists()) {
				File[] inspectionReporttwoDirNameFiles = inspectionReporttwoDir.listFiles();
				if (inspectionReporttwoDirNameFiles.length > 0) {
					request.setAttribute("inspectionReporttwoRequired", false);
					String[] inspectionReporttwoName = new String[10];
					int i = 0;
					for (File file : inspectionReporttwoDirNameFiles) {
						if (file.isFile()) {
							inspectionReporttwoName[i] = file.getName();
							System.out.println(file.getName());
							i++;
						}
					}
					request.setAttribute("inspectionreport2", inspectionReporttwoName);
				} else {
					request.setAttribute("inspectionReporttwoRequired", true);
				}
			} else {
				request.setAttribute("inspectionReporttwoRequired", true);
			}

			File residProofDir = new File(mainDir + "dogPhoto");
			if (residProofDir.exists()) {
				File[] residProofNameFiles = residProofDir.listFiles();
				if (residProofNameFiles.length > 0) {
					request.setAttribute("residProofRequired", false);
					String[] residProofName = new String[10];
					int j = 0;
					for (File file : residProofNameFiles) {
						if (file.isFile()) {
							residProofName[j] = file.getName();
							System.out.println(file.getName());
							j++;
						}
					}
					request.setAttribute("residProofName", residProofName);
				} else {
					request.setAttribute("residProofRequired", true);
				}
			} else {
				request.setAttribute("residProofRequired", true);
			}

			File mapofplaceDir = new File(mainDir + "mapofplace");
			if (mapofplaceDir.exists()) {
				File[] mapofplaceNameFiles = mapofplaceDir.listFiles();
				if (mapofplaceNameFiles.length > 0) {
					request.setAttribute("mapofplaceRequired", false);
					String[] mapofplaceName = new String[10];
					int k = 0;
					for (File file : mapofplaceNameFiles) {
						if (file.isFile()) {
							mapofplaceName[k] = file.getName();
							System.out.println(file.getName());
							k++;
						}
					}
					request.setAttribute("mapofplaceName", mapofplaceName);
				} else {
					request.setAttribute("mapofplaceRequired", true);
				}
			} else {
				request.setAttribute("mapofplaceRequired", true);
			}
			File psnocDir = new File(mainDir + "psnoc");
			if (psnocDir.exists()) {
				File[] psnocNameFiles = psnocDir.listFiles();
				if (psnocNameFiles.length > 0) {
					request.setAttribute("psnocRequired", false);
					String[] psnocName = new String[10];
					int l = 0;
					for (File file : psnocNameFiles) {
						if (file.isFile()) {
							psnocName[l] = file.getName();
							System.out.println(file.getName());
							l++;
						}
					}
					request.setAttribute("psnocName", psnocName);
				} else {
					request.setAttribute("psnocRequired", true);
				}
			} else {
				request.setAttribute("psnocRequired", true);
			}
			File firenocDir = new File(mainDir + "firenoc");
			if (firenocDir.exists()) {
				File[] firenocNameFiles = firenocDir.listFiles();
				if (firenocNameFiles.length > 0) {
					request.setAttribute("firenocRequired", false);
					String[] firenocName = new String[10];
					int l = 0;
					for (File file : firenocNameFiles) {
						if (file.isFile()) {
							firenocName[l] = file.getName();
							System.out.println(file.getName());
							l++;
						}
					}
					request.setAttribute("firenocName", firenocName);
				} else {
					request.setAttribute("firenocRequired", true);
				}
			} else {
				request.setAttribute("firenocRequired", true);
			}
			File placenocDir = new File(mainDir + "placenoc");
			if (placenocDir.exists()) {
				File[] placenocNameFiles = placenocDir.listFiles();
				if (placenocNameFiles.length > 0) {
					request.setAttribute("placenocRequired", false);
					String[] placenocName = new String[10];
					int m = 0;
					for (File file : placenocNameFiles) {
						if (file.isFile()) {
							placenocName[m] = file.getName();
							System.out.println(file.getName());
							m++;
						}
					}
					request.setAttribute("placenocName", placenocName);
				} else {
					request.setAttribute("placenocRequired", true);
				}
			} else {
				request.setAttribute("placenocRequired", true);
			}
			File concertDir = new File(mainDir + "concert");
			if (concertDir.exists()) {
				File[] concertNameFiles = concertDir.listFiles();
				if (concertNameFiles.length > 0) {
					request.setAttribute("concertRequired", false);
					String[] concertName = new String[10];
					int n = 0;
					for (File file : concertNameFiles) {
						if (file.isFile()) {
							concertName[n] = file.getName();
							System.out.println(file.getName());
							n++;
						}
					}
					request.setAttribute("concertName", concertName);
				} else {
					request.setAttribute("concertRequired", true);
				}
			} else {
				request.setAttribute("concertRequired", true);
			}
		} else {
			request.setAttribute("residProofRequired", true);
			request.setAttribute("idProofRequired", true);
			request.setAttribute("concertRequired", true);
			request.setAttribute("placenocRequired", true);
			request.setAttribute("psnocRequired", true);
			request.setAttribute("firenocRequired", true);
			request.setAttribute("mapofplaceRequired", true);
			request.setAttribute("inspectionReportoneRequired", true);
			request.setAttribute("inspectionReporttwoRequired", true);
		}
	}

	@RequestMapping("/rtiapplication/createTradeLicenseDuplicateCopyWork.do")
	public ModelAndView createTradeLicenseDuplicateCopyWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy = tradeLicenseDuplicateCopyService.get(applicationId);
		String email = tradeLicenseDuplicateCopy.getEmailID();
		String mobileNo = tradeLicenseDuplicateCopy.getMobileNumber();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();

		if (tradeLicenseDuplicateCopy != null) {
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
					SendSMSEmailController.sendPayment(applicantName, mobileNo, rtiApplnNumber, email);

					
					
					if (request.getParameter("WORKFLOW_TRANSISTION").isEmpty()
							|| request.getParameter("WORKFLOW_TRANSISTION") == null) {

					}
					if (task != null && sessionUser.getUserName().equals(task.getAssignee())) {
						request.setAttribute("userAccess", 1);
						request.setAttribute("workFlowTask", task);
					}
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Close-Application")) {

					rtiApplication.setWorkFlowStatus(1);
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
					rtiApplication.setWorkflowComments(workflow_comments);
	
					rtiApplicationService.save(rtiApplication);
					SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
					rtiApplication.setWorkFlowStatus(5);
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
					rtiApplication.setWorkflowComments(workflow_comments);
	
					rtiApplicationService.save(rtiApplication);
					SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				}
			} else {
				session.setAttribute("rejected", 5);
				rtiApplication.setWorkFlowStatus(5);
				String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
				rtiApplication.setWorkflowComments(workflow_comments);

				rtiApplicationService.save(rtiApplication);
				SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

				request.setAttribute("workFlowCompleted", "1");

			}

		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_MARKET_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		// ModelAndView modelAndView = new ModelAndView("manageMandapPermission",
		// "mandapPermission", mandapPermission);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView("redirect:/rtiapplication/editTradeLicenseDuplicateCopy.do");
	}

}
