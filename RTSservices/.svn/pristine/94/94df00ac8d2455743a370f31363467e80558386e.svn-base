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
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.OccupancyCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.OccupancyCertificateService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.OccupancyCertificateRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class OccupancyCertificateController {

	// extends MultiActionController implements InitializingBean

//	@RequestMapping("/rtiapplication/newRTIOccupancyApplication.do")
//	public ModelAndView newRTIOccupancyApplication(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException {
//	
//		ModelAndView modelAndView = new ModelAndView("newRTIOccupancyApplication");
//		
//		return modelAndView;
//	}

//	
////	@Override
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//
//	}
//
	private static Log log = LogFactory.getLog(OccupancyCertificateController.class);
	@Autowired
	private OccupancyCertificateService occupancyCertificateService;

	@Autowired
	private RTIApplicationService rTIApplicationService;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private UserRegistrationService userService;
	
	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;

	public OccupancyCertificateService getOccupancyCertificateService() {
		return occupancyCertificateService;
	}

	public void setoccupancyCertificatesService(OccupancyCertificateService occupancyCertificateService) {
		this.occupancyCertificateService = occupancyCertificateService;
	}

//	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
//	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10MB
//	private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	@RequestMapping("/rtsapplication/saveOccupancyCertificate.do")
	public ModelAndView saveCertificates(HttpServletRequest request, HttpServletResponse response,
			OccupancyCertificate occupancyCertificate) throws ServletException, Exception {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Birth");
		}
		String mobileNumber = "";
		mobileNumber = (String) session.getAttribute("mobileNo");
		if (mobileNumber != null) {
			UserRegistrationDetails user = userService.getUserByMobileNo(mobileNumber);
			if (occupancyCertificate != null) {
				OccupancyCertificateRestDTO occupancyRegistrationRestDTO = new OccupancyCertificateRestDTO();
				RTIApplication rtiApplication = new RTIApplication();

				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("OCCUPANCY-CERTIFICATE");
				rtiApplication.setTemplateName("townPlanning");
				rtiApplication.setDepartment("TOWN-PLANNING-DEPARTMENT");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(25);
				// occupancyRegistrationRestDTO.setFirstName(occupancyCertificate.getFirstName());
				rtiApplication.setApplicantName(occupancyCertificate.getFullName());
				rtiApplication.setPdfUploadFromPortal(occupancyCertificate.getFilesPath());
				rtiApplication.setApplicationCost(occupancyCertificate.getFeesApplicable());
				rtiApplication.setZone(occupancyCertificate.getMouzaZone());
				rtiApplication.setUserRegistrationDetails(user);

				rtiApplication.setPhoneNumber(occupancyCertificate.getMobileNo());
				rtiApplication.setMobileNumber(occupancyCertificate.getMobileNo());
				rtiApplication.setEmail(occupancyCertificate.getEmail());

				// rtiApplication.setWard_name(zoneRegistrationRestDTO.getZone_name());

				rtiApplication.setApplicationCost(occupancyCertificate.getFeesApplicable());

				// rtiApplication.setTenancy("1");
				// rtiApplication.setRtiApplnNumber("RTI/2022/BIRTH");

//			rtiApplication.setApplicantName(zoneRegistrationRestDTO.getFirstName());
				rtiApplication.setApplicantName(occupancyCertificate.getFirstName());
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
				RTIApplication savedRti = rTIApplicationService.merge(rtiApplication);

				// birthRegistrationService.getBirthRegistrationList(rTIApplicationSearch);

				// if(birthRegistrationService.birthRegistrationCertificate(birthRegistration){
				RTIApplication retunRti = null;
				if (savedRti.getRtiApplicationId() > 0) {
					RTIApplication rti = rTIApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/TPD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					occupancyCertificate.setRtiapplrefno(rti.getRtiApplnNumber());
					occupancyCertificate.setRti_ref_id(savedRti.getRtiApplicationId());
					long occupancy_regis_id = occupancyCertificateService.getReferenceId(occupancyCertificate);
					rti.setRtiApplicationRefId(occupancy_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					 retunRti = rTIApplicationService.merge(rti);

//					if ((retunRti != null) && (occupancy_regis_id > 0)) {
//						occupancyRegistrationRestDTO.setResponseStatus("Requested data saved successfully");
//						occupancyRegistrationRestDTO.setResponse(retunRti.getRtiApplicationId());
//						occupancyRegistrationRestDTO.setResult(retunRti.getRtiApplnNumber());
//
//					}
					String name = occupancyCertificate.getFullName();
					String link = "https://tinyurl.com/4hhhy9w9";
					String applnNo = rti.getRtiApplnNumber();

					String msg = "Dear " + name + " your application with Application No. " + applnNo
							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";

					msg.replace("var3", "");

					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", occupancyCertificate.getMobileNo(), msg);
					SendEmail.sendEmail(occupancyCertificate.getEmail(), "Application Submitted Successfully" + applnNo,
							msg);
				}
//				ModelAndView modelAndView = new ModelAndView("newRTIOccupancySucess");
//				modelAndView.addObject("result", "data successfully saved");
//				return modelAndView;
				return new ModelAndView("redirect:/ws/rtsapplication/newRTIOccupancySucess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

			}
		}

		return new ModelAndView("redirect:/ws/user/login.do");

	}

	
	@RequestMapping("ws/rtsapplication/newRTIOccupancySucess.do")
	public ModelAndView newRTIOccupancySucess(HttpServletRequest
	request,HttpServletResponse response) {

	 String appNo = request.getParameter("rtsAppNo");
	 ModelAndView model = new
	ModelAndView("newRTIOccupancySucess");

	 model.addObject("appNo",appNo);
	 return model;


	 } 
	

	

	@RequestMapping("/rtiapplication/editoccupancyCertificate.do")
	public ModelAndView editoccupancyCertificate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {

		HttpSession session = request.getSession();
		System.out.println("hiiii editoccupancyCertificate");
		long rtiApplicationRefId = 0;
		OccupancyCertificate occupancyCertificate = null;
		long zoneCertificatesid = 0;

		long rtiApplicationId = 0;
		// DeathRegistration deathRegistration=null;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if(sessionUser!=null) {
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0
				|| session.getAttribute("rtirefId") != null) {
			if (request.getParameter("rtiApplicationRefId") != null
					&& request.getParameter("rtiApplicationRefId").length() > 0) {
				rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
				occupancyCertificate = occupancyCertificateService.get(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				occupancyCertificate = occupancyCertificateService.get(rtiApplicationRefId);
			}

			if (occupancyCertificate.getRti_ref_id() > 0) {
				rtiApplicationId = occupancyCertificate.getRti_ref_id();
				rtiapplication = rTIApplicationService.get(rtiApplicationId);
			} else {
				List<RTIApplication> listRTI = rTIApplicationService.findByProperty("rtiApplicationRefId",
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
		ModelAndView modelAndView = new ModelAndView("manageOccupancyCertificate", "occupancyCertificate",
				occupancyCertificate);
		return modelAndView;

	}else {
		return new ModelAndView("/login.do");
	}
	}

//@RequestMapping("/rtiapplication/newRTIOccupancyApplication.do")
//	public ModelAndView newRTIOccupancyApplication(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException {
//		String baseDir = getServletContext().getRealPath("");
//		String folder = "occupancyCertificates";
//		File file = new File(baseDir, folder);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
//		ModelAndView modelAndView = new ModelAndView("newRTIOccupancyApplication");
//		modelAndView.addObject("folderName", folder);
//		return modelAndView;
//	}

//	@RequestMapping("/rtiapplication/uploadDocumentOccupancy.do")
//	public void uploadDocument(HttpServletRequest request, HttpServletResponse response) {
//
//		log.info("Document Uploaded");
//		try {
//			String baseDir = getServletContext().getRealPath("") + File.separator + "occupancyCertificates";
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

	// download
	// for upload

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

	@RequestMapping("/rtiapplication/createOccupancyCertificateWork.do")
	public ModelAndView createMandapPermissionWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rTIApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(
				rtiApplicationId, CoreConstants.RTI_TOWN_PLANNING_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		OccupancyCertificate occupancyCertificate = occupancyCertificateService.get(applicationId);
		String email = occupancyCertificate.getEmail();
		String mobileNo = occupancyCertificate.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();

		if (occupancyCertificate != null) {
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
					rTIApplicationService.save(rtiApplication);
					String link = "https://tinyurl.com/4hhhy9w9";
					String paymentLink=" https://nmcnagpur.gov.in/RTS/ws/pay.do";
					String paymentLink2="rtsNo="+rtiApplnNumber;
					
				    String msg = "Dear "+applicantName+" your document verification has been successfully completed. Kindly use this link "+paymentLink+"?"+paymentLink2+" to make a payment in order for your application "+rtiApplnNumber+" to be processed further. Regards, NMCGOV";

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
					rTIApplicationService.save(rtiApplication);
					String msg = "Dear " + applicantName
							+ " please click on this link https://tinyurl.com/bdemjk8e to download the Certificate for your application "
							+ rtiApplnNumber + " Regards, NMCGOV";

					msg.replace("var3", "");
					SendEmail.sendEmail(email, "Completion of your Appl. No." + rtiApplnNumber, msg);
					SendSMS.sendSingleSMS("1507167421320245636", "NMCGov", mobileNo, msg);
					request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
					rtiApplication.setWorkFlowStatus(5);
					rTIApplicationService.save(rtiApplication);
					String msg = "Dear " + applicantName + " your " + rtiApplnNumber
							+ " has been rejected due to shortfall of documents. Please use this link https://tinyurl.com/bdemjk8e to know the pending mandatory documents and track the status of your application.Regards, NMCGOV";
					msg.replace("var3", "");
					SendEmail.sendEmail(email, "Rejection of your Appl. No." + rtiApplnNumber, msg);
					SendSMS.sendSingleSMS("1507167421296109813", "NMCGov", mobileNo, msg);
					request.setAttribute("workFlowCompleted", "1");
				}
			} else {
				session.setAttribute("rejected", 5);
				rtiApplication.setWorkFlowStatus(5);
				rTIApplicationService.save(rtiApplication);
				String msg = "Dear " + applicantName + " your " + rtiApplnNumber
						+ " has been rejected due to shortfall of documents. Please use this link https://tinyurl.com/bdemjk8e to know the pending mandatory documents and track the status of your application.Regards, NMCGOV";
				msg.replace("var3", "");
				SendEmail.sendEmail(email, "Rejection of your Appl. No." + rtiApplnNumber, msg);
				SendSMS.sendSingleSMS("1507167421296109813", "NMCGov", mobileNo, msg);
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
		return new ModelAndView("redirect:/rtiapplication/editoccupancyCertificate.do");
	}

}
