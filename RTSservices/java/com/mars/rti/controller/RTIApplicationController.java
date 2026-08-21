
package com.mars.rti.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.task.TaskImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.Department;
import com.mars.common.model.User;
import com.mars.common.model.Zone;
import com.mars.common.service.DepartmentService;
import com.mars.common.service.DesignationService;
import com.mars.common.service.DocumentMasterService;
import com.mars.common.service.ReceivedModeService;
import com.mars.common.service.TenancyService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonTokenUtils;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SessionUser;
import com.mars.dms.service.DmsDocumentCheckListService;
import com.mars.dms.service.DmsDocumentService;
import com.mars.mail.service.MailService;
import com.mars.rti.model.BirthRegistration;
import com.mars.rti.model.Collection;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.RTIApplicationReAssignAcceptance;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.BirthRegistrationService;
import com.mars.rti.service.ChangeInOwnershipTypeService;
import com.mars.rti.service.FeeMasterService;
import com.mars.rti.service.IllegalWaterConnectionService;
import com.mars.rti.service.InboxService;
import com.mars.rti.service.NewWaterConnectionService;
import com.mars.rti.service.OutboxService;
import com.mars.rti.service.OutwardNumGenarationService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.WaterConnectionNoDueService;
import com.mars.rti.service.WaterConnectionTypeChangeService;
import com.mars.rti.service.WaterConnectionUsageService;
import com.mars.rti.service.WaterDisconnectionService;
import com.mars.rti.service.WaterMeterComplaintService;
import com.mars.rti.service.WaterPressureService;
import com.mars.rti.service.WaterQualityComplaintService;
import com.mars.rti.service.WaterReconnectionService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.model.WorkflowTemplateUserMappingDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.service.WorkflowTemplateTaskService;
import com.mars.workflow.service.WorkflowTemplateUserMappingDetailsService;
import com.mars.workflow.service.WorkflowTemplateUserMappingService;
import com.mars.workflow.utils.WorkflowConstants;

/**
 * <p>
 * Title: RTIApplicationController.java
 * </p>
 * 
 * <p>
 * Description: This is a rtiApplication controller class for controlling
 * rtiApplication related actions
 * </p>
 * 
 * @see com.mars.common.model.RTIApplication
 * 
 *      Copyright (c) 2014 for Mars Telecom India Pvt Ltd
 * 
 * @version: 1.0
 * 
 * @author : eGovernance development team <Mars Telecom Systems Pvt Ltd> listRTI
 */
@Controller
public class RTIApplicationController extends MultiActionController
		implements
			InitializingBean {

	private static String const_OrderBy = "OrderBy";

	private static String const_SortBy = "SortBy";

	private static Log log = LogFactory.getLog(RTIApplicationController.class);

	private String DMS_ENTITY_NAME = CoreConstants.RTI_APPLICATION_NEW;

	private String DMS_ENTITY_FOLDER_PATH = CoreConstants.RTI_APPLICATION_NEW_PATH;

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private WaterConnectionNoDueService waterConnectionNoDueService;

	@Autowired
	private FeeMasterService feeMasterService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private UserService userService;

	@Autowired
	private ReceivedModeService receivedModeService;

	@Autowired
	private DesignationService designationService;
	@Autowired
	private OutwardNumGenarationService outwardNumGenarationService;

	@Autowired
	private OutboxService outboxService;

	@Autowired
	private InboxService inboxService;

	@Autowired
	private WaterMeterComplaintService waterMeterComplaintService;

	@Autowired
	private TenancyService tenancyService;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private WaterDisconnectionService waterDisconnectionService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private MailService mailService;

	@Autowired
	private DmsDocumentService dmsDocumentService;

	@Autowired
	private DocumentMasterService documentMasterService;

	@Autowired
	private DmsDocumentCheckListService dmsDocumentCheckListService;

	@Autowired
	private WorkflowTemplateTaskService workflowTemplateTaskService;

	@Autowired
	private WorkflowTemplateUserMappingDetailsService workflowTemplateUserMappingDetailsService;

	@Autowired
	private BirthRegistrationService birthRegistrationService;

	@Autowired
	private NewWaterConnectionService newWaterConnectionService;
	@Autowired
	private WaterQualityComplaintService waterQualityComplaintService;
	@Autowired
	private WaterConnectionUsageService waterConnectionUsageService;
	@Autowired
	private ChangeInOwnershipTypeService changeInOwnershipTypeService;
	@Autowired
	private IllegalWaterConnectionService illegalWaterConnectionService;

	@Autowired
	private WaterConnectionTypeChangeService waterConnectionTypeChangeService;
	@Autowired
	private WaterPressureService waterPressureService;
	@Autowired
	private WaterReconnectionService waterReconnectionService;

	@Autowired
	private WorkflowTemplateUserMappingService workflowTemplateUserMappingService;

	public void setBirthRegistrationService(
			BirthRegistrationService birthRegistrationService) {
		this.birthRegistrationService = birthRegistrationService;
	}

	public void setWorkflowTemplateUserMappingDetailsService(
			WorkflowTemplateUserMappingDetailsService workflowTemplateUserMappingDetailsService) {
		this.workflowTemplateUserMappingDetailsService = workflowTemplateUserMappingDetailsService;
	}

	public void setWorkflowTemplateTaskService(
			WorkflowTemplateTaskService workflowTemplateTaskService) {
		this.workflowTemplateTaskService = workflowTemplateTaskService;
	}

	/**
	 * @param rtiApplicationService
	 *            sets the RTIApplicationService object.
	 */
	public void setRTIApplicationService(
			RTIApplicationService rtiApplicationService) {
		this.rtiApplicationService = rtiApplicationService;
	}

	public void setFeeMasterService(FeeMasterService feeMasterService) {
		this.feeMasterService = feeMasterService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setWorkflowProcessDetailsService(
			WorkflowProcessDetailsService workflowProcessDetailsService) {
		this.workflowProcessDetailsService = workflowProcessDetailsService;
	}

	public void setWorkflowService(WorkflowService workflowService) {
		this.workflowService = workflowService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public void setDmsDocumentCheckListService(
			DmsDocumentCheckListService dmsDocumentCheckListService) {
		this.dmsDocumentCheckListService = dmsDocumentCheckListService;
	}

	public void setDocumentMasterService(
			DocumentMasterService documentMasterService) {
		this.documentMasterService = documentMasterService;
	}

	public DmsDocumentService getDmsDocumentService() {
		return dmsDocumentService;
	}

	public void setRtiApplicationService(
			RTIApplicationService rtiApplicationService) {
		this.rtiApplicationService = rtiApplicationService;
	}

	public void setOutwardNumGenarationService(
			OutwardNumGenarationService outwardNumGenarationService) {
		this.outwardNumGenarationService = outwardNumGenarationService;
	}

	public void setOutboxService(OutboxService outboxService) {
		this.outboxService = outboxService;
	}

	public void setInboxService(InboxService inboxService) {
		this.inboxService = inboxService;
	}

	public void setTenancyService(TenancyService tenancyService) {
		this.tenancyService = tenancyService;
	}

	public void afterPropertiesSet() throws Exception {

	}

	/**
	 * This method is to bind the date objects in the specifed format.
	 *
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
		df.setLenient(true);
		binder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(df, true));
	}

	@RequestMapping("/rtiapplication/editRTIApplication.do")
	public ModelAndView editRTIApplication(HttpServletRequest request,
			HttpServletResponse response, BirthRegistration birthRegistration)
			throws ServletException {
		System.out.println("Hello");
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");

		if (birthRegistration.getBirthRegistrationId() != 0
				&& request.getParameter("birthRegistrationId") != null) {
			// BirthRegistration birthRegistration=new BirthRegistration();

			birthRegistrationService
					.birthRegistrationCertificate(birthRegistration);
		}
		ModelAndView modelAndView = new ModelAndView("manageRTIApplication");
		return modelAndView;
	}

	public void clearSessionAttributes(HttpSession session) {
		session.setAttribute("workspace", null);
		session.setAttribute("selectedFolderPath", null);
		session.setAttribute("entityName", null);
		session.setAttribute("entityId", "");
		session.setAttribute("uploadType", null);
		session.setAttribute("selectedDocumentType", null);
		session.setAttribute("dmsDocumentCheckListId", "");
		session.setAttribute("documentMasterId", "");
	}

	@RequestMapping("/rtiapplication/saveRTIApplication.do")
	public ModelAndView saveRTIApplication(HttpServletRequest request,
			HttpServletResponse response, RTIApplication rtiApplication)
			throws ServletException, Exception {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		long userId = sessionUser.getUserId();
		User user = userService.get(sessionUser.getUserId());

		if (log.isDebugEnabled()) {
			log.debug("Invoking saveRTIApplication");
		}

		String manageRTIApplicationId = request
				.getParameter("manageRTIApplicationId");

		if (rtiApplication != null) {

			if (request.getParameter("applicationDepartmentId") != null
					&& request.getParameter("applicationDepartmentId")
							.length() > 0) {
				rtiApplication.setApplicationDepartment(
						departmentService.get(Long.parseLong(request
								.getParameter("applicationDepartmentId"))));
			}

			if (request.getParameter("receivedModeId") != null
					&& request.getParameter("receivedModeId").length() > 0) {
				rtiApplication.setReceivedMode(receivedModeService.get(Long
						.parseLong(request.getParameter("receivedModeId"))));
			}

			if (request.getParameter("feeMasterId") != null
					&& request.getParameter("feeMasterId").length() > 0) {
				rtiApplication.setFeeMaster(feeMasterService.get(
						Long.parseLong(request.getParameter("feeMasterId"))));
			}

			if (CommonTokenUtils.allowFormSubmit(request)) {
				int isAssignedToOther = 1;

				if (user.getTenancy() != null) {
					rtiApplication.setTenancy(user.getTenancy());
				}
				if (rtiApplication.getRtiApplicationId() == 0) {
					rtiApplication.setCreatedDate(
							CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setCreatedUserId(user);
				}

				String strWorkflowAction = request
						.getParameter(WorkflowConstants.WORKFLOW_ACTION);
				if (strWorkflowAction != null
						&& strWorkflowAction.equalsIgnoreCase(
								WorkflowConstants.WORKFLOW_ACTION_KILL_JOB)) {
					rtiApplication.setWorkFlowStatus(0);
					rtiApplication.setFinalStatus(
							CoreConstants.APPL_STATUS_DISCARDED);
					session.setAttribute("message",
							"WorkFlow discarded successfully");

				} else if (strWorkflowAction != null
						&& strWorkflowAction.equalsIgnoreCase(
								WorkflowConstants.WORKFLOW_ACTION_CREATE_PROCESS)) {
					rtiApplication
							.setFinalStatus(CoreConstants.APPL_STATUS_CREATE);
					rtiApplication.setWorkFlowStatus(1);
					session.setAttribute("message",
							"Workflow Created Successfully");
					String toUserId = request.getParameter("userId");

					if (toUserId != null && toUserId.length() > 0) {
						User toUser = userService.get(Long.parseLong(toUserId));
						Department department = toUser.getDepartment();
						// Section section = toUser.getSection();
						List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
						RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

						rtiApplicationDetails.setRtiApplication(rtiApplication);
						rtiApplicationDetails
								.setStatus(CoreConstants.RTI_STATUS_FORWARD);
						rtiApplicationDetails.setAssignToStatus(1);
						rtiApplicationDetails.setAssignedStartDate(
								rtiApplication.getCreatedDate());
						rtiApplicationDetails.setAssignedEndDate(
								CommonUtils.getCurrentStringDateAndTime());
						rtiApplicationDetails.setUser(user);
						rtiApplicationDetails.setToUser(toUser);
						rtiApplicationDetails.setComments("WorkFlow Created");// ();
						rtiApplicationDetails.setWorkflowLevel(0);

						RTIApplicationDetails rtiApplicationDetails1 = new RTIApplicationDetails();
						rtiApplicationDetails1
								.setRtiApplication(rtiApplication);
						rtiApplicationDetails1
								.setStatus(CoreConstants.RTI_STATUS_ACTIVE);
						rtiApplicationDetails1.setAssignToStatus(0);
						rtiApplicationDetails1.setAssignedStartDate(
								CommonUtils.getCurrentStringDateAndTime());
						rtiApplicationDetails1.setUser(toUser);
						// rtiApplicationDetails1.setSection(section);
						rtiApplicationDetails1.setDepartment(department);
						rtiApplicationDetails1.setWorkflowLevel(1);
						rtiApplicationDetails1
								.setComments("Assigned for Acceptance");

						rtiApplicationDetailsList.add(rtiApplicationDetails);
						rtiApplicationDetailsList.add(rtiApplicationDetails1);
						/*
						 * rtiApplication.addRtiApplicationDetails(
						 * rtiApplicationDetails);
						 * rtiApplication.addRtiApplicationDetails(
						 * rtiApplicationDetails1);
						 */

						rtiApplication.setRtiApplicationDetails(
								rtiApplicationDetailsList);
						rtiApplication.setAssignedDepartment(department);
						// rtiApplication.setAssignedSection(section);
						rtiApplication.setAssigneeUserId(toUser);
						rtiApplication.setHasAssignedUser(1);

						if (rtiApplication.getRtiApplnNumber() != null
								&& !rtiApplication.getRtiApplnNumber()
										.equals("")) {
							isAssignedToOther = assignToUser(request, response);
						} else {
							isAssignedToOther = 0;
						}
					} else {
						isAssignedToOther = 0;
					}
				} else {
					rtiApplication
							.setFinalStatus(CoreConstants.APPL_STATUS_NEW);
					rtiApplication.setWorkFlowStatus(0);
					session.setAttribute("message",
							"RTI Application Saved Successfully");
				}

				request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED,
						"true");
				request.setAttribute(WorkflowConstants.WORKFLOW_NAME,
						CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME,
						CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID,
						"" + rtiApplication.getRtiApplicationId());

				if (isAssignedToOther == 1) {
					String isBPL = request.getParameter("bplVal");
					String iSFeePaid = request.getParameter("iSFeePaidVal");

					if (isBPL != null && isBPL.length() > 0) {
						rtiApplication.setBpl(1);
					} else {
						rtiApplication.setBpl(0);
					}

					if (iSFeePaid != null && iSFeePaid.length() > 0) {
						rtiApplication.setIsFeePaid(1);
						Collection collection = new Collection();

						String paymentMode = request
								.getParameter("paymentMode");
						collection.setPaymentMode(paymentMode);
						collection.setReceiptNumber(
								request.getParameter("receiptNumber"));
						collection.setReceiptDate(
								request.getParameter("receiptDate"));
						collection.setAmountPaid(Double.parseDouble(
								request.getParameter("amountPaid")));
						collection.setAmount((rtiApplication.getAmountPerCopy()
								* rtiApplication.getNumberOfCopies())
								+ rtiApplication.getFeeMaster().getAmount());
						if (!paymentMode
								.equalsIgnoreCase(CoreConstants.CASH_LABEL)) {
							collection.setChequeDDRTGSNumber(
									request.getParameter("chequeDDRTGSNumber"));
							collection.setChequeDDRTGSDate(
									request.getParameter("chequeDDRTGSDate"));
							collection.setBankName(
									request.getParameter("bankName"));
							collection.setBranchName(
									request.getParameter("branchName"));
						}
						if (request.getParameter("collectionId") != null
								&& request.getParameter("collectionId")
										.length() > 0) {
							collection.setCollectionId(Long.parseLong(
									request.getParameter("collectionId")));
						}
						// collection.setRtiApplication(rtiApplication);
						// rtiApplication.setCollection(collection);

					} else {
						rtiApplication.setIsFeePaid(0);
					}

					rtiApplicationService.save(rtiApplication);
				} else {
					session.setAttribute("errMessage", "Please Try Again");
				}
			}
			// setDMSParameters(request, rtiApplication);
		}

		request.removeAttribute("rtiApplicationId");
		request.setAttribute("receivedFileName", "");
		request.setAttribute("fileName", "");
		request.setAttribute("subject", "");
		return listRTIApplication(request, response);
	}

	public int assignToUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {
		HttpSession session = request.getSession();
		String rtiApplicationId = request.getParameter("rtiApplicationId");
		String assignToUser = request.getParameter("userId");
		if (assignToUser == null || assignToUser.length() == 0) {
			assignToUser = request.getAttribute("userId") == null
					? ""
					: request.getAttribute("userId") + "";
		}
		int returnValue = 0;
		// request.setAttribute("renewLicense", renewLicense);
		if (rtiApplicationId != null && !rtiApplicationId.isEmpty()
				&& !rtiApplicationId.equals("")) {
			if (assignToUser != null && !assignToUser.isEmpty()
					&& !assignToUser.equals("")) {
				String pesonaltaskId = null;
				String processId = null;
				WorkflowProcessDetails workflowProcessDetails = null;
				WorkflowProcessDetails processDetails = null;
				workflowProcessDetails = workflowProcessDetailsService
						.getWorkflowProcessDetailsByEntityDetails(
								Long.parseLong(rtiApplicationId),
								CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);

				if (workflowProcessDetails != null) {
					processId = workflowProcessDetails.getProcessId();
					if (processId != null) {
						processDetails = workflowProcessDetailsService
								.getWorkflowProcessDetailsByProcessId(
										processId);
					}
					if (!workflowService.isProcessEnded(processId)) {
						String taskId = workflowService
								.getCurrentTaskId(processId);
						Task task = null;
						if (taskId != null)
							task = taskService.getTask(taskId);
						if (processDetails != null) {
							PersonalTask personalTask = new PersonalTask();
							personalTask.setTask(task);
							personalTask
									.setEntityId(processDetails.getEntityId());
							personalTask.setEntityName(
									processDetails.getEntityName());
							personalTask.setWorkflowInitator(
									processDetails.getUserName());
							personalTask.setEntityDetails(
									processDetails.getEntityDetails());
							request.setAttribute("personalTask", personalTask);
							pesonaltaskId = personalTask.getTask().getId();
						}
						request.setAttribute("workFlowTask", task);
					}
				}
				if (pesonaltaskId != null && !pesonaltaskId.isEmpty()
						&& !pesonaltaskId.equals("")) {
					if (request.getParameter("selectedTaskIds") != null) {
						User user = userService
								.get(Long.parseLong(assignToUser));
						workflowService.reassignTask(pesonaltaskId,
								user.getUserName());
						session.setAttribute("message",
								"SuccessFully Assigned To User: "
										+ user.getFirstName());
						returnValue = 1;
					}
				}
			}
		}

		return returnValue;
	}

	@RequestMapping("/rtiapplication/listRTIApplication.do")
	public ModelAndView listRTIApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		if (log.isDebugEnabled()) {
			log.debug("Invoking listrtiApplication");
		}
		String year=null;
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if(sessionUser!=null) {
		RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
		setSearchParameters(applicationSearch, request);
		if(request.getAttribute("rtiServiceId")!=null)
		applicationSearch.setRtiserviceid(Integer.parseInt(request.getAttribute("rtiServiceId").toString()));
		User user = userService.get(sessionUser.getUserId());
		String userZone = user.getZone();
		long totalCount=0;
		if(applicationSearch.getYear()!=null) {
			year=applicationSearch.getYear();
		}else {
			year=String.valueOf(Year.now());
		}
		
		//String userDept = user.getDepartment();
		List<WorkflowTemplateUserMappingDetails> workflowTemplateUserMappingDetails=null;
		if(user.getUserName()!=null){
			workflowTemplateUserMappingDetails = workflowTemplateUserMappingDetailsService
					.getByName(user.getUserName());
			}
		if(userZone!=null && !userZone.isEmpty()) {
		applicationSearch.setZone(Integer.parseInt(userZone));
		List<RTIApplication> rtiapplicationList = new ArrayList<RTIApplication>();
		List<RTIApplication> rtiApplicationList=null;
		
		try {
			String userName = sessionUser.getUserName();
			long userDept = sessionUser.getDepartmentId();
			if (applicationSearch.getRtiApplicationNumber() != null && !applicationSearch.getRtiApplicationNumber().isEmpty()) {
				rtiApplicationList = rtiApplicationService.getRTIApplicationList(applicationSearch);
			} else {
				rtiApplicationList = rtiApplicationService.getRTSApplicationList(userName, userDept, userZone,
						applicationSearch.getCurrentPage(), applicationSearch.getRtiserviceid(),
						workflowTemplateUserMappingDetails);

			}
			if (userZone != null && rtiApplicationList != null) {
				rtiapplicationList.addAll(rtiApplicationList);
			}
			if (applicationSearch.getRtiApplicationNumber() != null && !applicationSearch.getRtiApplicationNumber().isEmpty()) {

				totalCount = rtiApplicationService.getRTIApplicationCount(applicationSearch);
			} else {
				totalCount = rtiApplicationService.getRTSApplicationListCount(userName, userDept, userZone,
						applicationSearch.getCurrentPage(), applicationSearch.getRtiserviceid(),
						workflowTemplateUserMappingDetails);
			}
				request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
				request.setAttribute("totalCount", totalCount);
			} catch (Exception e) {
				log.error(e.getMessage());
			}

			if (rtiApplicationList == null) {
				rtiApplicationList = new ArrayList<RTIApplication>();
			}

			request.setAttribute("user", user);
			request.setAttribute("currentPage", applicationSearch.getCurrentPage());
			request.setAttribute(const_OrderBy, applicationSearch.getOrderBy());
			request.setAttribute(const_SortBy, applicationSearch.getSortBy());
			request.setAttribute("SearchfileCreate", applicationSearch);
			request.setAttribute("departmentList", departmentService.getAll());
			request.setAttribute("serviceId", request.getAttribute("rtiServiceId"));

			return new ModelAndView(request.getAttribute("rtiModelName").toString(), "rtiapplicationList",
					rtiapplicationList);
		}else {
			try {
		
			List<RTIApplication> rtiApplicationList = new ArrayList<RTIApplication>();
			if (applicationSearch.getRtiApplicationNumber() != null && !applicationSearch.getRtiApplicationNumber().isEmpty()) {
				rtiApplicationList = rtiApplicationService.getRTIApplicationList(applicationSearch);
			} else {
				rtiApplicationList = rtiApplicationService.getRTSApplicationList(sessionUser.getUserName(),
						sessionUser.getDepartmentId(), userZone, applicationSearch.getCurrentPage(),
						applicationSearch.getRtiserviceid(), workflowTemplateUserMappingDetails);

			}

			if (applicationSearch.getRtiApplicationNumber() != null && !applicationSearch.getRtiApplicationNumber().isEmpty()) {
				totalCount = rtiApplicationService.getRTIApplicationCount(applicationSearch);

			} else {
				totalCount = rtiApplicationService.getRTSApplicationListCount(sessionUser.getUserName(),
						sessionUser.getDepartmentId(), userZone, applicationSearch.getCurrentPage(),
						applicationSearch.getRtiserviceid(), workflowTemplateUserMappingDetails);

			}
			request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);
			if (rtiApplicationList == null) {
				rtiApplicationList = new ArrayList<RTIApplication>();
				
			}
			request.setAttribute("user", user);
			request.setAttribute("currentPage", applicationSearch.getCurrentPage());
			request.setAttribute(const_OrderBy, applicationSearch.getOrderBy());
			request.setAttribute(const_SortBy, applicationSearch.getSortBy());
			request.setAttribute("SearchfileCreate", applicationSearch);
			request.setAttribute("departmentList", departmentService.getAll());
			request.setAttribute("serviceId", request.getAttribute("rtiServiceId"));

			return new ModelAndView(request.getAttribute("rtiModelName").toString(), "rtiapplicationList",
					rtiApplicationList);
			}catch(Exception ex) {
				ex.printStackTrace();
				log.error(ex.getStackTrace(), ex);
			}
		}
		}
		return new ModelAndView("redirect:/login.do");
	
	}
	@RequestMapping("/rtsapplication/listRTSBirthApplication.do")
	public ModelAndView listRTSBirthApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		request.setAttribute("rtiServiceId", 1);
		request.setAttribute("rtiModelName", "listRTSBirthApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSDeathApplication.do")
	public ModelAndView listRTSDeathApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 2);
		request.setAttribute("rtiModelName", "listRTSDeathApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSMandapApplication.do")
	public ModelAndView listRTSMandapApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 23);
		request.setAttribute("rtiModelName", "listRTSMandapApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSMobileTowerApplication.do")
	public ModelAndView listRTSMobileTowerApplication(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 31);
		request.setAttribute("rtiModelName", "listRTSMobileApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSPartMapApplication.do")
	public ModelAndView listRTSPartMapApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 28);
		request.setAttribute("rtiModelName", "listRTSPartMapApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSBuildingApplication.do")
	public ModelAndView listRTSBuildingApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 27);
		request.setAttribute("rtiModelName", "listRTSBuildingApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSFireComplianceCertificate.do")
	public ModelAndView listRTSFireComplianceCertificate(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 70);
		request.setAttribute("rtiModelName",
				"listRTSFireComplianceCertificate");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSOccupancyApplication.do")
	public ModelAndView listRTSOccupancyApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 25);
		request.setAttribute("rtiModelName", "listRTSOccupancyApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSLayoutOfBuildingApplication.do")
	public ModelAndView listRTSLayoutOfBuildingApplication(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 26);
		request.setAttribute("rtiModelName",
				"listRTSLayoutOfBuildingApplication");
		return listRTIApplication(request, response);

	}

	@RequestMapping("/rtsapplication/listRTSDogApplication.do")
	public ModelAndView listRTSDogApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 3);
		request.setAttribute("rtiModelName", "listRTSDogApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSTreeApplication.do")
	public ModelAndView listRTSTreeApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 4);
		request.setAttribute("rtiModelName", "listRTSTreeApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSZoneApplication.do")
	public ModelAndView listRTSZoneApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 5);
		request.setAttribute("rtiModelName", "listRTSZoneApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("//rtsapplication/listRTSTradeLicenceRenewal.do")
	public ModelAndView listRTSTradeLicenceRenewal(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 33);
		request.setAttribute("rtiModelName", "listRTSTradeLicenceRenewal");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSTradeLicenseNameChange.do")
	public ModelAndView listRTSTradeLicenseNameChange(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 34);
		request.setAttribute("rtiModelName", "listRTSTradeLicenseNameChange");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSTradeLicenseTypeChange.do")
	public ModelAndView listRTSTradeLicenseTypeChange(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 35);
		request.setAttribute("rtiModelName", "listRTSTradeLicenseTypeChange");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSTradeLicenseCancellation.do")
	public ModelAndView listRTSTradeLicenseCancellation(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 40);
		request.setAttribute("rtiModelName", "listRTSTradeLicenseCancellation");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSTradeLicenseDuplicateCopy.do")
	public ModelAndView listRTSTradeLicenseDuplicateCopy(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 41);
		request.setAttribute("rtiModelName",
				"listRTSTradeLicenseDuplicateCopy");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSTradeLicenseOutdatedRenewal.do")
	public ModelAndView listRTSTradeLicenseOutdatedRenewal(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 42);
		request.setAttribute("rtiModelName",
				"listRTSTradeLicenseOutdatedRenewal");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSNOCOfTradeApplication.do")
	public ModelAndView listRTSNOCOfTradeApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 32);
		request.setAttribute("rtiModelName", "listRTSNOCOfTradeApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSTradeLicencePartnerChange.do")
	public ModelAndView listRTSTradeLicencePartnerChange(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 36);
		request.setAttribute("rtiModelName",
				"listRTSTradeLicencePartnerChange");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSMTPApplication.do")
	public ModelAndView listRTSMTPApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 97);
		request.setAttribute("rtiModelName", "listRTSMTPApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSBiologicalApplication.do")
	public ModelAndView listRTSBiologicalApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 7);
		request.setAttribute("rtiModelName", "listRTSBiologicalApplication");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSNoDuesApplication.do")
	public ModelAndView listRTSNoDuesApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 10);
		request.setAttribute("rtiModelName", "listRTSWaterNewConnection");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSMarriageApplication.do")
	public ModelAndView listRTSMarriageApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 11);
		request.setAttribute("rtiModelName", "listRTSMarriageApplication");
		return listRTIApplication(request, response);
	}

//	@RequestMapping("/rtsapplication/listRTSNewWaterConnectionApplication.do")
//	public ModelAndView listRTSNewWaterConnectionApplication(
//			HttpServletRequest request, HttpServletResponse response)
//			throws ServletException {
//		HttpSession session = request.getSession();
//		List<NewWaterConnection> records = newWaterConnectionService
//				.getAllNewWaterConnection();
//		long rtiApplicationId = 0;
//		RTIApplication rtiapplication = null;
//		for (NewWaterConnection newWaterConnection : records) {
//			String requestNumber = newWaterConnection.getRtiapplrefno();
//			try {
//				RestTemplate restTemplate = new RestTemplate();
//				String url = "https://sampark.ocwindia.com/aaplesarkar/customer/getRequestStatus?key=6aa083ae54aae4a7fad7659c6fbfd0bc&requestNo="
//						+ requestNumber;
//
//				URL urlObj = new URL(url);
//				HttpURLConnection con = (HttpURLConnection) urlObj
//						.openConnection();
//				con.setRequestMethod("GET");
//				con.setRequestProperty("Accept", "application/json");
//				restTemplate.getMessageConverters()
//						.add(new StringHttpMessageConverter());
//				String result = restTemplate.getForObject(url, String.class);
//				System.out.println("result :" + result);
//				JSONObject document = new JSONObject(result.toString());
//				int find = 0;
//				if (document.has("data")
//						&& document.get("data") instanceof JSONArray) {
//					find = 1;
//					JSONArray array = document.getJSONArray("data");
//					JSONObject data = array.getJSONObject(0);
//					String file = data.isNull("noDuCerificate_file")
//							? null
//							: data.getString("noDuCerificate_file");
//					String request_status = data.isNull("request_status")
//							? null
//							: data.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (newWaterConnection.getRti_ref_id() > 0) {
//						rtiApplicationId = newWaterConnection.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiapplication.setPdfFilesSavedPath(file);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//				} else {
//					JSONObject json = document.getJSONObject("data");
//					String request_status = json.isNull("request_status")
//							? null
//							: json.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (newWaterConnection.getRti_ref_id() > 0) {
//						rtiApplicationId = newWaterConnection.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//
//				}
//
//			} catch (Exception ex) {
//				ex.getMessage();
//			}
//		}
//		request.setAttribute("rtiServiceId", 48);
//		request.setAttribute("rtiModelName", "listRTSWaterNewConnection");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("records", records);
//		return listRTIApplication(request, response);
//	}
	
	
	@RequestMapping("/rtsapplication/listRTSNewWaterConnectionApplication.do")
	public ModelAndView listRTSNewWaterConnectionApplication(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 48);
		request.setAttribute("rtiModelName", "listRTSWaterNewConnection");
		ModelAndView modelAndView = new ModelAndView();
		return listRTIApplication(request, response);
	}
//
//	@RequestMapping("/rtsapplication/listRTSWaterQualityComplaint.do")
//	public ModelAndView listRTSWaterQualityComplaint(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException {
//		HttpSession session = request.getSession();
//		List<WaterQualityComplaint> records = waterQualityComplaintService
//				.getAll();
//		long rtiApplicationId = 0;
//		RTIApplication rtiapplication = null;
//		for (WaterQualityComplaint waterQualityComplaint : records) {
//			String requestNumber = waterQualityComplaint.getRtiapplrefno();
//			try {
//				RestTemplate restTemplate = new RestTemplate();
//				String url = "https://sampark.ocwindia.com/aaplesarkar/customer/getRequestStatus?key=6aa083ae54aae4a7fad7659c6fbfd0bc&requestNo="
//						+ requestNumber;
//
//				URL urlObj = new URL(url);
//				HttpURLConnection con = (HttpURLConnection) urlObj
//						.openConnection();
//				con.setRequestMethod("GET");
//				con.setRequestProperty("Accept", "application/json");
//				restTemplate.getMessageConverters()
//						.add(new StringHttpMessageConverter());
//				String result = restTemplate.getForObject(url, String.class);
//				System.out.println("result :" + result);
//				JSONObject document = new JSONObject(result.toString());
//				int find = 0;
//				if (document.has("data")
//						&& document.get("data") instanceof JSONArray) {
//					find = 1;
//					JSONArray array = document.getJSONArray("data");
//					JSONObject data = array.getJSONObject(0);
//					String file = data.isNull("noDuCerificate_file")
//							? null
//							: data.getString("noDuCerificate_file");
//					String request_status = data.isNull("request_status")
//							? null
//							: data.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (waterQualityComplaint.getRti_ref_id() > 0) {
//						rtiApplicationId = waterQualityComplaint
//								.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiapplication.setPdfFilesSavedPath(file);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//				} else {
//
//					JSONObject json = document.getJSONObject("data");
//					String request_status = json.isNull("request_status")
//							? null
//							: json.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (waterQualityComplaint.getRti_ref_id() > 0) {
//						rtiApplicationId = waterQualityComplaint
//								.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//
//				}
//
//			} catch (Exception ex) {
//				ex.getMessage();
//			}
//		}
//		request.setAttribute("rtiServiceId", 61);
//		request.setAttribute("rtiModelName", "listRTSWaterQualityComplaint");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("records", records);
//		return listRTIApplication(request, response);
//	}
	
	@RequestMapping("/rtsapplication/listRTSWaterQualityComplaint.do")
	public ModelAndView listRTSWaterQualityComplaint(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		
		request.setAttribute("rtiServiceId", 61);
		request.setAttribute("rtiModelName", "listRTSWaterQualityComplaint");
		
		return listRTIApplication(request, response);
	}

//	@RequestMapping("/rtsapplication/listRTSNewWaterConnectionUsageApplication.do")
//	public ModelAndView listRTSNewWaterConnectionUsageApplication(
//			HttpServletRequest request, HttpServletResponse response)
//			throws ServletException {
//		HttpSession session = request.getSession();
//		List<WaterConnectionUsage> records = waterConnectionUsageService
//				.getAllWaterConnectionUsage();
//		long rtiApplicationId = 0;
//		RTIApplication rtiapplication = null;
//		for (WaterConnectionUsage waterConnectionUsage : records) {
//			String requestNumber = waterConnectionUsage.getRtiapplrefno();
//			try {
//				RestTemplate restTemplate = new RestTemplate();
//				String url = "https://sampark.ocwindia.com/aaplesarkar/customer/getRequestStatus?key=6aa083ae54aae4a7fad7659c6fbfd0bc&requestNo="
//						+ requestNumber;
//
//				URL urlObj = new URL(url);
//				HttpURLConnection con = (HttpURLConnection) urlObj
//						.openConnection();
//				con.setRequestMethod("GET");
//				con.setRequestProperty("Accept", "application/json");
//				restTemplate.getMessageConverters()
//						.add(new StringHttpMessageConverter());
//				String result = restTemplate.getForObject(url, String.class);
//				System.out.println("result :" + result);
//				JSONObject document = new JSONObject(result.toString());
//				int find = 0;
//				if (document.has("data")
//						&& document.get("data") instanceof JSONArray) {
//					find = 1;
//					JSONArray array = document.getJSONArray("data");
//					JSONObject data = array.getJSONObject(0);
//					String file = data.isNull("noDuCerificate_file")
//							? null
//							: data.getString("noDuCerificate_file");
//					String request_status = data.isNull("request_status")
//							? null
//							: data.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (waterConnectionUsage.getRti_ref_id() > 0) {
//						rtiApplicationId = waterConnectionUsage.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiapplication.setPdfFilesSavedPath(file);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//				} else {
//
//					JSONObject json = document.getJSONObject("data");
//					String request_status = json.isNull("request_status")
//							? null
//							: json.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (waterConnectionUsage.getRti_ref_id() > 0) {
//						rtiApplicationId = waterConnectionUsage.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//
//				}
//
//			} catch (Exception ex) {
//				ex.getMessage();
//			}
//		}
//		request.setAttribute("rtiServiceId", 51);
//		request.setAttribute("rtiModelName", "listRTSWaterConnectionUsage");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("records", records);
//		return listRTIApplication(request, response);
//	}
	
	//water connection usage
		@RequestMapping("/rtsapplication/listRTSNewWaterConnectionUsageApplication.do")
		public ModelAndView listRTSNewWaterConnectionUsageApplication(HttpServletRequest request,
				HttpServletResponse response) throws ServletException {
			
			request.setAttribute("rtiServiceId", 51);
			request.setAttribute("rtiModelName", "listRTSWaterConnectionUsage");
			
			return listRTIApplication(request, response);
		}

	/*
	 * @RequestMapping("/rtsapplication/listRTSWaterDisconnection.do") public
	 * ModelAndView listRTSWaterDisconnection(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException { HttpSession session =
	 * request.getSession(); List<WaterDisconnection> records =
	 * waterDisconnectionService .getAllWaterDisconnection(); long rtiApplicationId
	 * = 0; RTIApplication rtiapplication = null; for (WaterDisconnection
	 * waterDisconnection : records) { String requestNumber =
	 * waterDisconnection.getRtiapplrefno(); try { RestTemplate restTemplate = new
	 * RestTemplate(); String url =
	 * "https://sampark.ocwindia.com/aaplesarkar/customer/getRequestStatus?key=6aa083ae54aae4a7fad7659c6fbfd0bc&requestNo="
	 * + requestNumber;
	 * 
	 * URL urlObj = new URL(url); HttpURLConnection con = (HttpURLConnection) urlObj
	 * .openConnection(); con.setRequestMethod("GET");
	 * con.setRequestProperty("Accept", "application/json");
	 * restTemplate.getMessageConverters() .add(new StringHttpMessageConverter());
	 * String result = restTemplate.getForObject(url, String.class);
	 * System.out.println("result :" + result); JSONObject document = new
	 * JSONObject(result.toString()); int find = 0; if (document.has("data") &&
	 * document.get("data") instanceof JSONArray) { find = 1; JSONArray array =
	 * document.getJSONArray("data"); JSONObject data = array.getJSONObject(0);
	 * String file = data.isNull("noDuCerificate_file") ? null :
	 * data.getString("noDuCerificate_file"); String request_status =
	 * data.isNull("request_status") ? null : data.getString("request_status");
	 * session.setAttribute("status", request_status); if
	 * (waterDisconnection.getRti_ref_id() > 0) { rtiApplicationId =
	 * waterDisconnection.getRti_ref_id(); rtiapplication = rtiApplicationService
	 * .get(rtiApplicationId); } request.setAttribute("rtiApplication",
	 * rtiapplication); if (request_status.equals("open")) {
	 * rtiapplication.setWorkFlowStatus(3);
	 * rtiApplicationService.save(rtiapplication); } else if
	 * (request_status.equals("closed")) { rtiapplication.setWorkFlowStatus(1);
	 * rtiapplication.setPdfFilesSavedPath(file);
	 * rtiApplicationService.save(rtiapplication); } else if
	 * (request_status.equals("rejected")) { rtiapplication.setWorkFlowStatus(5);
	 * rtiApplicationService.save(rtiapplication); } if (log.isDebugEnabled()) {
	 * log.debug("GET Successfull:-" + request_status); } } else {
	 * 
	 * JSONObject json = document.getJSONObject("data"); String request_status =
	 * json.isNull("request_status") ? null : json.getString("request_status");
	 * session.setAttribute("status", request_status); if
	 * (waterDisconnection.getRti_ref_id() > 0) { rtiApplicationId =
	 * waterDisconnection.getRti_ref_id(); rtiapplication = rtiApplicationService
	 * .get(rtiApplicationId); } request.setAttribute("rtiApplication",
	 * rtiapplication); if (request_status.equals("open")) {
	 * rtiapplication.setWorkFlowStatus(3);
	 * rtiApplicationService.save(rtiapplication); } else if
	 * (request_status.equals("closed")) { rtiapplication.setWorkFlowStatus(1);
	 * rtiApplicationService.save(rtiapplication); } else if
	 * (request_status.equals("rejected")) { rtiapplication.setWorkFlowStatus(5);
	 * rtiApplicationService.save(rtiapplication); } if (log.isDebugEnabled()) {
	 * log.debug("GET Successfull:-" + request_status); }
	 * 
	 * }
	 * 
	 * } catch (Exception ex) { ex.getMessage(); } }
	 * request.setAttribute("rtiServiceId", 6); request.setAttribute("rtiModelName",
	 * "listRTSWaterDisconnection"); ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.addObject("records", records); return
	 * listRTIApplication(request, response); }
	 */
	
	
	@RequestMapping("/rtsapplication/listRTSWaterDisconnection.do")
	public ModelAndView listRTSWaterDisconnection(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		
		request.setAttribute("rtiServiceId", 6);
		request.setAttribute("rtiModelName", "listRTSWaterDisconnection");
		
		return listRTIApplication(request, response);
	}

//	@RequestMapping("/rtsapplication/listRTSWaterReconnection.do")
//	public ModelAndView listRTSWaterReconnection(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException {
//		HttpSession session = request.getSession();
//		List<WaterReconnection> records = waterReconnectionService
//				.getAllwaterReconnection();
//		long rtiApplicationId = 0;
//		RTIApplication rtiapplication = null;
//		for (WaterReconnection waterReconnection : records) {
//			String requestNumber = waterReconnection.getRtiapplrefno();
//			try {
//				RestTemplate restTemplate = new RestTemplate();
//				String url = "https://sampark.ocwindia.com/aaplesarkar/customer/getRequestStatus?key=6aa083ae54aae4a7fad7659c6fbfd0bc&requestNo="
//						+ requestNumber;
//
//				URL urlObj = new URL(url);
//				HttpURLConnection con = (HttpURLConnection) urlObj
//						.openConnection();
//				con.setRequestMethod("GET");
//				con.setRequestProperty("Accept", "application/json");
//				restTemplate.getMessageConverters()
//						.add(new StringHttpMessageConverter());
//				String result = restTemplate.getForObject(url, String.class);
//				System.out.println("result :" + result);
//				JSONObject document = new JSONObject(result.toString());
//				int find = 0;
//				if (document.has("data")
//						&& document.get("data") instanceof JSONArray) {
//					find = 1;
//					JSONArray array = document.getJSONArray("data");
//					JSONObject data = array.getJSONObject(0);
//					String file = data.isNull("noDuCerificate_file")
//							? null
//							: data.getString("noDuCerificate_file");
//					String request_status = data.isNull("request_status")
//							? null
//							: data.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (waterReconnection.getRti_ref_id() > 0) {
//						rtiApplicationId = waterReconnection.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiapplication.setPdfFilesSavedPath(file);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//				} else {
//
//					JSONObject json = document.getJSONObject("data");
//					String request_status = json.isNull("request_status")
//							? null
//							: json.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (waterReconnection.getRti_ref_id() > 0) {
//						rtiApplicationId = waterReconnection.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//
//				}
//
//			} catch (Exception ex) {
//				ex.getMessage();
//			}
//		}
//		request.setAttribute("rtiServiceId", 50);
//		request.setAttribute("rtiModelName", "listRTSWaterReconnection");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("records", records);
//		return listRTIApplication(request, response);
//	}
	
	
	//water reconnection
		@RequestMapping("/rtsapplication/listRTSWaterReconnection.do")
		public ModelAndView listRTSWaterReconnection(HttpServletRequest request,HttpServletResponse response) throws ServletException {
			
			request.setAttribute("rtiServiceId", 50);
			request.setAttribute("rtiModelName", "listRTSWaterReconnection");
			return listRTIApplication(request, response);
		}
//
//	@RequestMapping("/rtsapplication/listRTSChangeInOwnershipType.do")
//	public ModelAndView listRTSChangeInOwnershipType(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException {
//		HttpSession session = request.getSession();
//		List<ChangeInOwnershipType> records = changeInOwnershipTypeService
//				.getAllChangeInOwnershipType();
//		long rtiApplicationId = 0;
//		RTIApplication rtiapplication = null;
//		for (ChangeInOwnershipType changeInOwnershipType : records) {
//			String requestNumber = changeInOwnershipType.getRtiApplRefNo();
//			try {
//				RestTemplate restTemplate = new RestTemplate();
//				String url = "https://sampark.ocwindia.com/aaplesarkar/customer/getRequestStatus?key=6aa083ae54aae4a7fad7659c6fbfd0bc&requestNo="
//						+ requestNumber;
//
//				URL urlObj = new URL(url);
//				HttpURLConnection con = (HttpURLConnection) urlObj
//						.openConnection();
//				con.setRequestMethod("GET");
//				con.setRequestProperty("Accept", "application/json");
//				restTemplate.getMessageConverters()
//						.add(new StringHttpMessageConverter());
//				String result = restTemplate.getForObject(url, String.class);
//				System.out.println("result :" + result);
//				JSONObject document = new JSONObject(result.toString());
//				int find = 0;
//				if (document.has("data")
//						&& document.get("data") instanceof JSONArray) {
//					find = 1;
//					JSONArray array = document.getJSONArray("data");
//					JSONObject data = array.getJSONObject(0);
//					String file = data.isNull("noDuCerificate_file")
//							? null
//							: data.getString("noDuCerificate_file");
//					String request_status = data.isNull("request_status")
//							? null
//							: data.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (changeInOwnershipType.getRtiRefId() > 0) {
//						rtiApplicationId = changeInOwnershipType.getRtiRefId();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiapplication.setPdfFilesSavedPath(file);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//				} else {
//
//					JSONObject json = document.getJSONObject("data");
//					String request_status = json.isNull("request_status")
//							? null
//							: json.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (changeInOwnershipType.getRtiRefId() > 0) {
//						rtiApplicationId = changeInOwnershipType.getRtiRefId();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//
//				}
//
//			} catch (Exception ex) {
//				ex.getMessage();
//			}
//		}
//		request.setAttribute("rtiServiceId", 49);
//		request.setAttribute("rtiModelName", "listRTSChangeInOwnershipType");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("records", records);
//		return listRTIApplication(request, response);
//	}
		
		//water change in ownership type
		@RequestMapping("/rtsapplication/listRTSChangeInOwnershipType.do")
		public ModelAndView listRTSChangeInOwnershipType(HttpServletRequest request,
				HttpServletResponse response) throws ServletException {
			
			request.setAttribute("rtiServiceId", 49);
			request.setAttribute("rtiModelName", "listRTSChangeInOwnershipType");
			
			return listRTIApplication(request, response);
		}

//	@RequestMapping("/rtsapplication/listRTSIllegalWaterConnection.do")
//	public ModelAndView listRTSIllegalWaterConnection(
//			HttpServletRequest request, HttpServletResponse response)
//			throws ServletException {
//		HttpSession session = request.getSession();
//		List<IllegalWaterConnectionComplaint> records = illegalWaterConnectionService
//				.getAllIllegalWaterConnection();
//		long rtiApplicationId = 0;
//		RTIApplication rtiapplication = null;
//		for (IllegalWaterConnectionComplaint illegalWaterConnectionComplaint : records) {
//			String requestNumber = illegalWaterConnectionComplaint
//					.getRtiApplRefNo();
//			try {
//				RestTemplate restTemplate = new RestTemplate();
//				String url = "https://sampark.ocwindia.com/aaplesarkar/customer/getRequestStatus?key=6aa083ae54aae4a7fad7659c6fbfd0bc&requestNo="
//						+ requestNumber;
//
//				URL urlObj = new URL(url);
//				HttpURLConnection con = (HttpURLConnection) urlObj
//						.openConnection();
//				con.setRequestMethod("GET");
//				con.setRequestProperty("Accept", "application/json");
//				restTemplate.getMessageConverters()
//						.add(new StringHttpMessageConverter());
//				String result = restTemplate.getForObject(url, String.class);
//				System.out.println("result :" + result);
//				JSONObject document = new JSONObject(result.toString());
//				int find = 0;
//				if (document.has("data")
//						&& document.get("data") instanceof JSONArray) {
//					find = 1;
//					JSONArray array = document.getJSONArray("data");
//					JSONObject data = array.getJSONObject(0);
//					String file = data.isNull("noDuCerificate_file")
//							? null
//							: data.getString("noDuCerificate_file");
//					String request_status = data.isNull("request_status")
//							? null
//							: data.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (illegalWaterConnectionComplaint.getRtiRefId() > 0) {
//						rtiApplicationId = illegalWaterConnectionComplaint
//								.getRtiRefId();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiapplication.setPdfFilesSavedPath(file);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//				} else {
//
//					JSONObject json = document.getJSONObject("data");
//					String request_status = json.isNull("request_status")
//							? null
//							: json.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (illegalWaterConnectionComplaint.getRtiRefId() > 0) {
//						rtiApplicationId = illegalWaterConnectionComplaint
//								.getRtiRefId();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//
//				}
//
//			} catch (Exception ex) {
//				ex.getMessage();
//			}
//		}
//		request.setAttribute("rtiServiceId", 63);
//		request.setAttribute("rtiModelName", "listRTSIllegalWaterConnection");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("records", records);
//		return listRTIApplication(request, response);
//	}

		@RequestMapping("/rtsapplication/listRTSIllegalWaterConnection.do")
		public ModelAndView listRTSIllegalWaterConnection(
				HttpServletRequest request, HttpServletResponse response)
				throws ServletException {		
			request.setAttribute("rtiServiceId", 63);
			request.setAttribute("rtiModelName", "listRTSIllegalWaterConnection");
			ModelAndView modelAndView = new ModelAndView();
			return listRTIApplication(request, response);
		}
//	@RequestMapping("/rtsapplication/listRTSWaterConnectionTypeChange.do")
//	public ModelAndView listRTSWaterConnectionTypeChange(
//			HttpServletRequest request, HttpServletResponse response)
//			throws ServletException {
//		HttpSession session = request.getSession();
//		List<WaterConnectionTypeChange> records = waterConnectionTypeChangeService
//				.getAllWaterConnectionType();
//		long rtiApplicationId = 0;
//		RTIApplication rtiapplication = null;
//		for (WaterConnectionTypeChange waterConnectionTypeChange : records) {
//			String requestNumber = waterConnectionTypeChange.getRtiapplrefno();
//			try {
//				RestTemplate restTemplate = new RestTemplate();
//				String url = "https://sampark.ocwindia.com/aaplesarkar/customer/getRequestStatus?key=6aa083ae54aae4a7fad7659c6fbfd0bc&requestNo="
//						+ requestNumber;
//
//				URL urlObj = new URL(url);
//				HttpURLConnection con = (HttpURLConnection) urlObj
//						.openConnection();
//				con.setRequestMethod("GET");
//				con.setRequestProperty("Accept", "application/json");
//				restTemplate.getMessageConverters()
//						.add(new StringHttpMessageConverter());
//				String result = restTemplate.getForObject(url, String.class);
//				System.out.println("result :" + result);
//				JSONObject document = new JSONObject(result.toString());
//				int find = 0;
//				if (document.has("data")
//						&& document.get("data") instanceof JSONArray) {
//					find = 1;
//					JSONArray array = document.getJSONArray("data");
//					JSONObject data = array.getJSONObject(0);
//					String file = data.isNull("noDuCerificate_file")
//							? null
//							: data.getString("noDuCerificate_file");
//					String request_status = data.isNull("request_status")
//							? null
//							: data.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (waterConnectionTypeChange.getRti_ref_id() > 0) {
//						rtiApplicationId = waterConnectionTypeChange
//								.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiapplication.setPdfFilesSavedPath(file);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//				} else {
//
//					JSONObject json = document.getJSONObject("data");
//					String request_status = json.isNull("request_status")
//							? null
//							: json.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (waterConnectionTypeChange.getRti_ref_id() > 0) {
//						rtiApplicationId = waterConnectionTypeChange
//								.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//
//				}
//
//			} catch (Exception ex) {
//				ex.getMessage();
//			}
//		}
//		request.setAttribute("rtiServiceId", 47);
//		request.setAttribute("rtiModelName",
//				"listRTSWaterConnectionTypeChange");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("records", records);
//		return listRTIApplication(request, response);
//	}
	
	//water connection type change
		@RequestMapping("/rtsapplication/listRTSWaterConnectionTypeChange.do")
		public ModelAndView listRTSWaterConnectionTypeChange(HttpServletRequest request,
				HttpServletResponse response) throws ServletException {
			
			request.setAttribute("rtiServiceId", 47);
			request.setAttribute("rtiModelName","listRTSWaterConnectionTypeChange");
			return listRTIApplication(request, response);
		}

//	@RequestMapping("/rtsapplication/listRTSWaterPressure.do")
//	public ModelAndView listRTSWaterPressure(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException {
//		HttpSession session = request.getSession();
//		List<WaterPressure> records = waterPressureService
//				.getAllWaterPressureComplaint();
//		long rtiApplicationId = 0;
//		RTIApplication rtiapplication = null;
//		for (WaterPressure waterPressure : records) {
//			String requestNumber = waterPressure.getRtiapplrefno();
//			try {
//				RestTemplate restTemplate = new RestTemplate();
//				String url = "https://sampark.ocwindia.com/aaplesarkar/customer/getRequestStatus?key=6aa083ae54aae4a7fad7659c6fbfd0bc&requestNo="
//						+ requestNumber;
//
//				URL urlObj = new URL(url);
//				HttpURLConnection con = (HttpURLConnection) urlObj
//						.openConnection();
//				con.setRequestMethod("GET");
//				con.setRequestProperty("Accept", "application/json");
//				restTemplate.getMessageConverters()
//						.add(new StringHttpMessageConverter());
//				String result = restTemplate.getForObject(url, String.class);
//				System.out.println("result :" + result);
//				JSONObject document = new JSONObject(result.toString());
//				int find = 0;
//				if (document.has("data")
//						&& document.get("data") instanceof JSONArray) {
//					find = 1;
//					JSONArray array = document.getJSONArray("data");
//					JSONObject data = array.getJSONObject(0);
//					String file = data.isNull("noDuCerificate_file")
//							? null
//							: data.getString("noDuCerificate_file");
//					String request_status = data.isNull("request_status")
//							? null
//							: data.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (waterPressure.getRti_ref_id() > 0) {
//						rtiApplicationId = waterPressure.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiapplication.setPdfFilesSavedPath(file);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//				} else {
//
//					JSONObject json = document.getJSONObject("data");
//					String request_status = json.isNull("request_status")
//							? null
//							: json.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (waterPressure.getRti_ref_id() > 0) {
//						rtiApplicationId = waterPressure.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//
//				}
//
//			} catch (Exception ex) {
//				ex.getMessage();
//			}
//		}
//		request.setAttribute("rtiServiceId", 62);
//		request.setAttribute("rtiModelName", "listRTSWaterPressure");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("records", records);
//		return listRTIApplication(request, response);
//	}


		@RequestMapping("/rtsapplication/listRTSWaterPressure.do")
		public ModelAndView listRTSWaterPressure(HttpServletRequest request,
				HttpServletResponse response) throws ServletException {
			
			request.setAttribute("rtiServiceId", 62);
			request.setAttribute("rtiModelName", "listRTSWaterPressure");
			return listRTIApplication(request, response);
		}
	@RequestMapping("/rtsapplication/listRTSTradeLicenseTransfer.do")
	public ModelAndView listRTSTradeLicenseTransfer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 38);
		request.setAttribute("rtiModelName", "listRTSTradeLicenseTransfer");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSTradeLicensePartnerCountUpdate.do")
	public ModelAndView listRTSTradeLicensePartnerCountUpdate(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 39);
		request.setAttribute("rtiModelName",
				"listRTSTradeLicensePartnerCountUpdate");
		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtsapplication/listRTSTradeLicenceNew.do")
	public ModelAndView listRTSTradeLicenceNew(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 44);
		request.setAttribute("rtiModelName", "listRTSTradeLicenceNew");
		return listRTIApplication(request, response);
	}

	@RequestMapping("rtiapplication/listRTIApplicationSearch.do")
	public ModelAndView listRTIApplicationSearch(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		long tenancyId = sessionUser.getTenancyId();

		RTIApplicationSearch searchOptions = new RTIApplicationSearch();
		searchOptions.setTenancyId(tenancyId);
		setSearchParameters(searchOptions, request);

		User user = userService.get(sessionUser.getUserId());
		request.setAttribute("user", user);

		request.setAttribute("currentPage", searchOptions.getCurrentPage());
		request.setAttribute(const_OrderBy, searchOptions.getOrderBy());
		request.setAttribute(const_SortBy, searchOptions.getSortBy());
		request.setAttribute("SearchOptions", searchOptions);
		request.setAttribute("departmentList", departmentService.getAll());
		request.setAttribute("tenancyId", tenancyId);

		if (searchOptions.getAssignedDepartment() == 0
				&& searchOptions.getAssignedSection() == 0
				&& searchOptions.getAssignedUser() == 0
				&& (searchOptions.getCreationFromDate() == null
						|| searchOptions.getCreationFromDate().length() == 0)
				&& (searchOptions.getCreationToDate() == null
						|| searchOptions.getCreationToDate().length() == 0)
				&& (searchOptions.getFinalStatus() == null
						|| searchOptions.getFinalStatus().length() == 0)
				&& (searchOptions.getRtiApplicationNumber() == null
						|| searchOptions.getRtiApplicationNumber()
								.length() == 0)
				&& (searchOptions.getReceivedFileRefNo() == null
						|| searchOptions.getReceivedFileRefNo().length() == 0)
				&& (searchOptions.getSubject() == null
						|| searchOptions.getSubject().length() == 0)
				&& (searchOptions.getRtiAplicationReceivedDepartment() == 0)) {

			return new ModelAndView("listRTIApplicationSearch");
		}

		List<RTIApplication> rtiApplicationList = rtiApplicationService
				.getRTIApplicationList(searchOptions);
		try {
			long totalCount = rtiApplicationService
					.getRTIApplicationCount(searchOptions);
			request.setAttribute("maximumPages",
					new Long(CommonUtils.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		if (rtiApplicationList != null) {
			List<PersonalTask> listPersonalTask = new ArrayList<PersonalTask>();
			for (RTIApplication rtiApplication : rtiApplicationList) {
				RTIApplicationDetails rtiApplicationDetails = rtiApplicationService
						.getRTIApplicationDetailsByRTIApplicationIdandStatus(
								rtiApplication.getRtiApplicationId(), 0);
				WorkflowProcessDetails processDetails = workflowProcessDetailsService
						.getWorkflowProcessDetailsByEntityDetails(
								rtiApplication.getRtiApplicationId(),
								CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);

				if (processDetails != null /*
											 * &&
											 * workflowService.isProcessEnded(
											 * processId)
											 */) {
					String processId = processDetails.getProcessId();
					String taskId = workflowService.getCurrentTaskId(processId);
					Task task = null;
					if (taskId != null)
						task = taskService.getTask(taskId);
					// List<Task> list =
					// taskService.createTaskQuery().processInstanceId(processId).list();

					if (task != null) {
						PersonalTask personalTask = new PersonalTask();
						personalTask.setTask(task);
						personalTask.setEntityId(processDetails.getEntityId());
						personalTask
								.setEntityName(processDetails.getEntityName());
						personalTask.setWorkflowInitator(
								processDetails.getUserName());
						personalTask.setEntityDetails(
								processDetails.getEntityDetails());
						personalTask.setRtiApplicationDetails(
								rtiApplicationDetails);
						personalTask.setRtiApplication(rtiApplicationService
								.get(processDetails.getEntityId()));
						// personalTask.setWorkflowName(strExecutionId.split(".")[0].replace("_",
						// " "));
						listPersonalTask.add(personalTask);
					} else {
						task = new TaskImpl();
						PersonalTask personalTask = new PersonalTask();
						personalTask.setTask(task);
						personalTask.setEntityId(processDetails.getEntityId());
						personalTask
								.setEntityName(processDetails.getEntityName());
						personalTask.setWorkflowInitator(
								processDetails.getUserName());
						personalTask.setEntityDetails(
								processDetails.getEntityDetails());
						personalTask.setRtiApplicationDetails(
								rtiApplicationDetails);
						personalTask.setRtiApplication(rtiApplicationService
								.get(processDetails.getEntityId()));
						// personalTask.setWorkflowName(strExecutionId.split(".")[0].replace("_",
						// " "));
						listPersonalTask.add(personalTask);
					}
				} else {
					Task task = new TaskImpl();
					PersonalTask personalTask = new PersonalTask();
					personalTask.setTask(task);
					personalTask
							.setEntityId(rtiApplication.getRtiApplicationId());
					// personalTask.setEntityName(processDetails.getEntityName());
					/// personalTask.setWorkflowInitator(processDetails.getUserName());
					// personalTask.setEntityDetails(processDetails.getEntityDetails());
					personalTask
							.setRtiApplicationDetails(rtiApplicationDetails);
					personalTask.setRtiApplication(rtiApplication);
					// personalTask.setWorkflowName(strExecutionId.split(".")[0].replace("_",
					// " "));
					listPersonalTask.add(personalTask);
				}
			}
			request.setAttribute("PersonalTasksList", listPersonalTask);
		}

		return new ModelAndView("listRTIApplicationSearch");
	}

	private void setSearchParameters(RTIApplicationSearch searchFileCreate,
			HttpServletRequest request) {
		if (log.isDebugEnabled()) {
			log.debug("setSearchParameters Method is called");
		}

		try {
			long longCurrentPage = CommonUtils
					.checkPaginationAttributes(request);
			String orderBy = request.getParameter(const_OrderBy);
			String sortBy = request.getParameter(const_SortBy);

			// setting default order by on fileCreateId
			if (orderBy == null || orderBy.length() < 1) {
				orderBy = "rtiApplicationId";
				sortBy = "desc";
			}
			if (request.getParameter("year") != null
					&& !request.getParameter("year").equals("")) {
				searchFileCreate.setYear(request.getParameter("year"));
			}
			searchFileCreate.setCurrentPage(longCurrentPage);
			searchFileCreate.setOrderBy(orderBy);
			searchFileCreate.setSortBy(sortBy);

			searchFileCreate.setRtiApplicationNumber(
					request.getParameter("searchrtiApplnNumber"));
			searchFileCreate.setRtiserviceid(
					Integer.parseInt(request.getParameter("serviceId")));
			searchFileCreate.setSubject(request.getParameter("subject"));
			searchFileCreate.setCreationToDate(request.getParameter("toDate"));
			searchFileCreate
					.setCreationFromDate(request.getParameter("fromDate"));

			if (request.getParameter("rtiAplicationReceivedDepartment") != null
					&& !request.getParameter("rtiAplicationReceivedDepartment")
							.equals("")) {
				searchFileCreate.setRtiAplicationReceivedDepartment(
						Long.parseLong(request.getParameter(
								"rtiAplicationReceivedDepartment")));
			}
			if (request.getParameter("assignedDepartment") != null
					&& !request.getParameter("assignedDepartment").equals("")) {
				searchFileCreate.setAssignedDepartment(Long
						.parseLong(request.getParameter("assignedDepartment")));
			}
			if (request.getParameter("assignedSection") != null
					&& !request.getParameter("assignedSection").equals("")) {
				searchFileCreate.setAssignedSection(Long
						.parseLong(request.getParameter("assignedSection")));
			}
			if (request.getParameter("assignedUser") != null
					&& !request.getParameter("assignedUser").equals("")) {
				searchFileCreate.setAssignedUser(
						Long.parseLong(request.getParameter("assignedUser")));
			}
			

			searchFileCreate.setReceivedFileRefNo(
					request.getParameter("receivedFileRefNo"));

			String fileStatus = request.getParameter("finalStatus");
			searchFileCreate.setFinalStatus(fileStatus);

			if (request.getParameter("isRTIAppealApplication") != null
					&& !request.getParameter("isRTIAppealApplication")
							.equals("")) {
				searchFileCreate.setIsRTIAppealApplication(Integer.parseInt(
						request.getParameter("isRTIAppealApplication")));
			} else {
				searchFileCreate.setIsRTIAppealApplication(null);
			}

		} catch (Exception err) {
			log.error(err.getMessage());
		}
	}

	@RequestMapping("/rtiapplicationAppeal/viewRTIApplicationAppeal.do")
	public ModelAndView viewRTIApplicationAppeal(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		if (log.isDebugEnabled()) {
			log.debug("Invoking viewRTIApplicationAppeal");
		}

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		RTIApplication rtiApplication = new RTIApplication();

		String rtiApplicationNumber = request
				.getParameter("rtiApplicationRefNumber");

		if (rtiApplicationNumber != null && rtiApplicationNumber.length() > 0) {
			String hqlQuery = "select rtiApplication from RTIApplication rtiApplication Where rtiApplication.rtiApplnNumber = '"
					+ rtiApplicationNumber + "' ";
			List<RTIApplication> listRTIApplication = rtiApplicationService
					.getListByHqlQuery(hqlQuery);
			if (listRTIApplication.isEmpty() || listRTIApplication == null
					|| listRTIApplication.size() == 0) {
				session.setAttribute("errMessage",
						"With Given Reference  Number: " + rtiApplicationNumber
								+ ". No RTI Application Found");
				return new ModelAndView("applyRTIApplicationAppeal");
			} else {
				RTIApplication rtiApplicationData = listRTIApplication.get(0);

				if (rtiApplicationData.getFinalStatus()
						.equalsIgnoreCase(CoreConstants.APPL_STATUS_CLOSED)
						|| rtiApplicationData.getFinalStatus().equalsIgnoreCase(
								CoreConstants.APPL_STATUS_DISCARDED)) {

					rtiApplication.setRtiApplicationRefId(
							rtiApplicationData.getRtiApplicationId());
					rtiApplication
							.setRtiApplicationRefNumber(rtiApplicationNumber);
					rtiApplication.setIsRTIAppealApplication(1);
					rtiApplication.setRtiApplicationId(0);
					rtiApplication.setAddressLine1(
							rtiApplicationData.getAddressLine1());
					rtiApplication.setAddressLine2(
							rtiApplicationData.getAddressLine2());
					rtiApplication.setApplicantName(
							rtiApplicationData.getApplicantName());
					rtiApplication.setApplicationDepartment(
							rtiApplicationData.getApplicationDepartment());
					rtiApplication.setBpl(rtiApplicationData.getBpl());
					rtiApplication.setBplCardNumber(
							rtiApplicationData.getBplCardNumber());
					rtiApplication
							.setDistrict(rtiApplicationData.getDistrict());
					rtiApplication.setEmail(rtiApplicationData.getEmail());
					rtiApplication.setGender(rtiApplicationData.getGender());
					rtiApplication.setMobileNumber(
							rtiApplicationData.getMobileNumber());
					rtiApplication.setPhoneNumber(
							rtiApplicationData.getPhoneNumber());
					rtiApplication.setPincode(rtiApplicationData.getPincode());
					rtiApplication.setState(rtiApplicationData.getState());

					rtiApplication.setReceivedDate("");
					rtiApplication.setReceivedMode(null);
					rtiApplication.setRegistrationDate("");
					rtiApplication.setCreatedDate("");
					rtiApplication.setCreatedUserId(null);
					rtiApplication.setIsFeePaid(0);
					rtiApplication.setIsApplicationParked(0);
					rtiApplication.setAmountPerCopy(0);

					// rtiApplication =
					// rtiApplicationService.get(rtiApplication.getRtiApplicationId());
					/*
					 * request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED,
					 * "true");
					 * request.setAttribute(WorkflowConstants.WORKFLOW_NAME,
					 * CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
					 * request.setAttribute(WorkflowConstants.
					 * WORKFLOW_ENTITYNAME,
					 * CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
					 * request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID,
					 * rtiApplication.getRtiApplicationId());
					 */
				} else {
					session.setAttribute("errMessage",
							"RTI Application Number: " + rtiApplicationNumber
									+ ". Is In Process.");
					return new ModelAndView("applyRTIApplicationAppeal");
				}

			}
		}

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(
						rtiApplication.getRtiApplicationId(),
						CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);

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
					personalTask
							.setWorkflowInitator(processDetails.getUserName());
					personalTask.setEntityDetails(
							processDetails.getEntityDetails());
					request.setAttribute("personalTask", personalTask);
				}
				if (task != null
						&& sessionUser.getUserName().equals(task.getAssignee()))
					request.setAttribute("userAccess", 1);

				request.setAttribute("workFlowTask", task);
			} else {
				request.setAttribute("workFlowCompleted", "1");
			}
		}

		request.setAttribute("receivedModeList", receivedModeService.getAll());
		request.setAttribute("departmentList", departmentService.getAll());
		// request.setAttribute("tenancyList", tenancyService.getAll());
		session.setAttribute("manageUploadToken",
				session.getAttribute(Constants.SESSION_TOKEN_KEY));
		CommonTokenUtils.setNewToken(request);
		// setDMSParameters(request, rtiApplication);

		// FeeMaster feemaster = feeMasterService.getApplicationFeeDetails();
		// rtiApplication.setApplicationCost(feemaster.getAmount());
		// request.setAttribute("totalAmount",
		// (rtiApplication.getApplicationCost()+rtiApplication.getPostalCharges()+(rtiApplication.getAmountPerCopy()*rtiApplication.getNumberOfCopies())));

		return new ModelAndView("manageRTIApplicationAppeal", "rtiApplication",
				rtiApplication);

	}

	@RequestMapping("/rtiapplicationAppeal/applyRTIApplicationAppeal.do")
	public ModelAndView applyRTIApplicationAppeal(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		return new ModelAndView("applyRTIApplicationAppeal");
	}

	@RequestMapping("/rtiapplicationAppeal/saveRTIApplicationAppeal.do")
	public ModelAndView saveRTIApplicationAppeal(HttpServletRequest request,
			HttpServletResponse response, RTIApplication rtiApplication)
			throws ServletException, Exception {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		long userId = sessionUser.getUserId();
		User user = userService.get(sessionUser.getUserId());

		if (log.isDebugEnabled()) {
			log.debug("Invoking saveRTIApplication");
		}

		String manageRTIApplicationId = request
				.getParameter("manageRTIApplicationId");

		if (rtiApplication != null) {

			if (request.getParameter("applicationDepartmentId") != null
					&& request.getParameter("applicationDepartmentId")
							.length() > 0) {
				rtiApplication.setApplicationDepartment(
						departmentService.get(Long.parseLong(request
								.getParameter("applicationDepartmentId"))));
			}

			if (request.getParameter("receivedModeId") != null
					&& request.getParameter("receivedModeId").length() > 0) {
				rtiApplication.setReceivedMode(receivedModeService.get(Long
						.parseLong(request.getParameter("receivedModeId"))));
			}

			if (request.getParameter("feeMasterId") != null
					&& request.getParameter("feeMasterId").length() > 0) {
				rtiApplication.setFeeMaster(feeMasterService.get(
						Long.parseLong(request.getParameter("feeMasterId"))));
			}

			if (CommonTokenUtils.allowFormSubmit(request)) {
				int isAssignedToOther = 1;

				if (user.getTenancy() != null) {
					rtiApplication.setTenancy(user.getTenancy());
				}
				if (rtiApplication.getRtiApplicationId() == 0) {
					rtiApplication.setCreatedDate(
							CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setCreatedUserId(user);
				}

				String strWorkflowAction = request
						.getParameter(WorkflowConstants.WORKFLOW_ACTION);
				if (strWorkflowAction != null
						&& strWorkflowAction.equalsIgnoreCase(
								WorkflowConstants.WORKFLOW_ACTION_KILL_JOB)) {
					rtiApplication.setWorkFlowStatus(0);
					rtiApplication.setFinalStatus(
							CoreConstants.APPL_STATUS_DISCARDED);
					session.setAttribute("message",
							"WorkFlow discarded successfully");

				} else if (strWorkflowAction != null
						&& strWorkflowAction.equalsIgnoreCase(
								WorkflowConstants.WORKFLOW_ACTION_CREATE_PROCESS)) {
					rtiApplication
							.setFinalStatus(CoreConstants.APPL_STATUS_CREATE);
					rtiApplication.setWorkFlowStatus(1);
					session.setAttribute("message",
							"Workflow Created Successfully");
					String toUserId = request.getParameter("userId");

					if (toUserId != null && toUserId.length() > 0) {
						User toUser = userService.get(Long.parseLong(toUserId));
						Department department = toUser.getDepartment();
						// Section section = toUser.getSection();
						List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
						RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

						rtiApplicationDetails.setRtiApplication(rtiApplication);
						rtiApplicationDetails
								.setStatus(CoreConstants.RTI_STATUS_FORWARD);
						rtiApplicationDetails.setAssignToStatus(1);
						rtiApplicationDetails.setAssignedStartDate(
								rtiApplication.getCreatedDate());
						rtiApplicationDetails.setAssignedEndDate(
								CommonUtils.getCurrentStringDateAndTime());
						rtiApplicationDetails.setUser(user);
						rtiApplicationDetails.setToUser(toUser);
						rtiApplicationDetails.setComments("WorkFlow Created");// ();
						rtiApplicationDetails.setWorkflowLevel(0);

						RTIApplicationDetails rtiApplicationDetails1 = new RTIApplicationDetails();
						rtiApplicationDetails1
								.setRtiApplication(rtiApplication);
						rtiApplicationDetails1
								.setStatus(CoreConstants.RTI_STATUS_ACTIVE);
						rtiApplicationDetails1.setAssignToStatus(0);
						rtiApplicationDetails1.setAssignedStartDate(
								CommonUtils.getCurrentStringDateAndTime());
						rtiApplicationDetails1.setUser(toUser);
						// rtiApplicationDetails1.setSection(section);
						rtiApplicationDetails1.setDepartment(department);
						rtiApplicationDetails1.setWorkflowLevel(1);
						rtiApplicationDetails1
								.setComments("Assigned for Acceptance");

						rtiApplicationDetailsList.add(rtiApplicationDetails);
						rtiApplicationDetailsList.add(rtiApplicationDetails1);
						/*
						 * rtiApplication.addRtiApplicationDetails(
						 * rtiApplicationDetails);
						 * rtiApplication.addRtiApplicationDetails(
						 * rtiApplicationDetails1);
						 */

						rtiApplication.setRtiApplicationDetails(
								rtiApplicationDetailsList);
						rtiApplication.setAssignedDepartment(department);
						// rtiApplication.setAssignedSection(section);
						rtiApplication.setAssigneeUserId(toUser);
						rtiApplication.setHasAssignedUser(1);

						if (rtiApplication.getRtiApplnNumber() != null
								&& !rtiApplication.getRtiApplnNumber()
										.equals("")) {
							isAssignedToOther = assignToUser(request, response);
						} else {
							isAssignedToOther = 0;
						}
					} else {
						isAssignedToOther = 0;
					}
				} else {
					rtiApplication
							.setFinalStatus(CoreConstants.APPL_STATUS_NEW);
					rtiApplication.setWorkFlowStatus(0);
					session.setAttribute("message",
							"RTI Application Saved Successfully");
				}

				request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED,
						"true");
				request.setAttribute(WorkflowConstants.WORKFLOW_NAME,
						CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME,
						CoreConstants.RTI_APPLICATION_WORKFLOW_ENTITY);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID,
						"" + rtiApplication.getRtiApplicationId());

				if (isAssignedToOther == 1) {
					String isBPL = request.getParameter("bplVal");
					String iSFeePaid = request.getParameter("iSFeePaidVal");

					if (isBPL != null && isBPL.length() > 0) {
						rtiApplication.setBpl(1);
					} else {
						rtiApplication.setBpl(0);
					}

					if (iSFeePaid != null && iSFeePaid.length() > 0) {
						rtiApplication.setIsFeePaid(1);
						Collection collection = new Collection();

						String paymentMode = request
								.getParameter("paymentMode");
						collection.setPaymentMode(paymentMode);
						collection.setReceiptNumber(
								request.getParameter("receiptNumber"));
						collection.setReceiptDate(
								request.getParameter("receiptDate"));
						collection.setAmount((rtiApplication.getAmountPerCopy()
								* rtiApplication.getNumberOfCopies())
								+ rtiApplication.getFeeMaster().getAmount());
						if (!paymentMode
								.equalsIgnoreCase(CoreConstants.CASH_LABEL)) {
							collection.setChequeDDRTGSNumber(
									request.getParameter("chequeDDRTGSNumber"));
							collection.setChequeDDRTGSDate(
									request.getParameter("chequeDDRTGSDate"));
							collection.setBankName(
									request.getParameter("bankName"));
							collection.setBranchName(
									request.getParameter("branchName"));
						}
						if (request.getParameter("collectionId") != null
								&& request.getParameter("collectionId")
										.length() > 0) {
							collection.setCollectionId(Long.parseLong(
									request.getParameter("collectionId")));
						}
						// collection.setRtiApplication(rtiApplication);
						// rtiApplication.setCollection(collection);

					} else {
						rtiApplication.setIsFeePaid(0);
					}

					rtiApplicationService.save(rtiApplication);
				} else {
					session.setAttribute("errMessage", "Please Try Again");
				}
			}
			// setDMSParameters(request, rtiApplication);
		}

		request.removeAttribute("rtiApplicationId");
		request.setAttribute("receivedFileName", "");
		request.setAttribute("fileName", "");
		request.setAttribute("subject", "");
		return listRTIApplicationAppeal(request, response);
	}

	@RequestMapping("/rtiapplicationAppeal/listRTIApplicationAppeal.do")
	public ModelAndView listRTIApplicationAppeal(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		if (log.isDebugEnabled()) {
			log.debug("Invoking listrtiApplication");
		}
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		long tenancyId = sessionUser.getTenancyId();

		RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
		applicationSearch.setTenancyId(tenancyId);
		setSearchParameters(applicationSearch, request);
		applicationSearch.setRtiApplicationNumber("");
		applicationSearch.setIsRTIAppealApplication(1);

		List<RTIApplication> rtiApplicationList = rtiApplicationService
				.getRTIApplicationList(applicationSearch);
		try {
			long totalCount = rtiApplicationService
					.getRTIApplicationCount(applicationSearch);
			request.setAttribute("maximumPages",
					new Long(CommonUtils.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		// Check if the fileCreateList is null
		if (rtiApplicationList == null) {
			rtiApplicationList = new ArrayList<RTIApplication>();
		}

		User user = userService.get(sessionUser.getUserId());

		request.setAttribute("user", user);
		request.setAttribute("currentPage", applicationSearch.getCurrentPage());
		request.setAttribute(const_OrderBy, applicationSearch.getOrderBy());
		request.setAttribute(const_SortBy, applicationSearch.getSortBy());
		request.setAttribute("SearchfileCreate", applicationSearch);

		return new ModelAndView("listRTIApplicationAppeal",
				"rtiApplicationList", rtiApplicationList);
	}

	@RequestMapping("/rtiapplicationReAssigned/listRTIApplicationReAssignedTask.do")
	public ModelAndView listRTIApplicationReAssignedTask(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		if (log.isDebugEnabled()) {
			log.debug("Invoking listrtiApplication");
		}
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		long tenancyId = sessionUser.getTenancyId();

		List<RTIApplicationReAssignAcceptance> rtiApplicationReAssignAcceptanceList = rtiApplicationService
				.getRTIApplicationReAssignedTask(sessionUser.getUserId(), 0);
		try {
			long totalCount = rtiApplicationReAssignAcceptanceList.size();// rtiApplicationService.getRTIApplicationCount(applicationSearch);
			request.setAttribute("maximumPages",
					new Long(CommonUtils.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		// Check if the fileCreateList is null
		if (rtiApplicationReAssignAcceptanceList == null) {
			rtiApplicationReAssignAcceptanceList = new ArrayList<RTIApplicationReAssignAcceptance>();
			request.setAttribute("totalCount", 0);
		}

		/*
		 * User user= userService.get(sessionUser.getUserId());
		 * request.setAttribute("user",user);
		 * request.setAttribute("currentPage",
		 * applicationSearch.getCurrentPage());
		 * request.setAttribute(const_OrderBy, applicationSearch.getOrderBy());
		 * request.setAttribute(const_SortBy, applicationSearch.getSortBy());
		 * request.setAttribute("SearchfileCreate", applicationSearch);
		 */

		return new ModelAndView("listRTIApplicationReAssignedTask",
				"rtiApplicationReAssignAcceptanceList",
				rtiApplicationReAssignAcceptanceList);
	}

	@RequestMapping("/rtiapplicationReAssigned/listRTIApplicationReAssignedTaskHistory.do")
	public ModelAndView listRTIApplicationReAssignedTaskHistory(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		if (log.isDebugEnabled()) {
			log.debug("Invoking listRTIApplicationReAssignedTaskHistory");
		}
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		long tenancyId = sessionUser.getTenancyId();
		User user = userService.get(sessionUser.getUserId());

		List<RTIApplicationReAssignAcceptance> rtiApplicationReAssignAcceptanceList = rtiApplicationService
				.getRTIApplicationReAssignedTaskHistory(user);
		try {
			long totalCount = rtiApplicationReAssignAcceptanceList.size();// rtiApplicationService.getRTIApplicationCount(applicationSearch);
			request.setAttribute("maximumPages",
					new Long(CommonUtils.getMaxPage(totalCount)));
			request.setAttribute("totalCount", totalCount);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		// Check if the fileCreateList is null
		if (rtiApplicationReAssignAcceptanceList == null) {
			rtiApplicationReAssignAcceptanceList = new ArrayList<RTIApplicationReAssignAcceptance>();
			request.setAttribute("totalCount", 0);
		}

		/*
		 * User user= userService.get(sessionUser.getUserId());
		 * request.setAttribute("user",user);
		 * request.setAttribute("currentPage",
		 * applicationSearch.getCurrentPage());
		 * request.setAttribute(const_OrderBy, applicationSearch.getOrderBy());
		 * request.setAttribute(const_SortBy, applicationSearch.getSortBy());
		 * request.setAttribute("SearchfileCreate", applicationSearch);
		 */

		return new ModelAndView("listRTIApplicationReAssignedTaskHistory",
				"rtiApplicationReAssignAcceptanceList",
				rtiApplicationReAssignAcceptanceList);
	}

	// @RequestMapping("/rtiapplicationReAssigned/rejectAssignedTask.do")
	@RequestMapping("/rtiapplicationReAssigned/acceptAssignedTask.do")
	public ModelAndView acceptAssignedTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		long userId = sessionUser.getUserId();
		User user = userService.get(sessionUser.getUserId());

		if (log.isDebugEnabled()) {
			log.debug("Invoking savertiApplication");
		}

		RTIApplication rtiApplication = null;
		String rtiApplicationId = request.getParameter("rtiApplicationId");
		String rtiApplicationDetailsId = request
				.getParameter("rtiApplicationDetailsId");
		String rtiApplicationDetailsWF_Level = request
				.getParameter("rtiApplicationDetailsWF_Level");
		if (StringUtils.isNotEmpty(rtiApplicationId)
				&& StringUtils.isNotEmpty(rtiApplicationDetailsId)
				&& StringUtils.isNotEmpty(rtiApplicationDetailsWF_Level)
				&& !rtiApplicationId.equals("0")
				&& !rtiApplicationDetailsId.equals("0")) {
			rtiApplication = rtiApplicationService
					.get(Long.parseLong(rtiApplicationId));
			RTIApplicationDetails rtiApplicationDetails1 = null;
			if (rtiApplication != null) {
				int assignStatus = 1;
				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = rtiApplicationService
						.getRTIApplicationDetailsById(
								Long.parseLong(rtiApplicationDetailsId));

				RTIApplicationReAssignAcceptance rtiIApplicationReAssignAcceptance = rtiApplicationService
						.getRTIApplicationReAssignedTaskByRTIApplicationIdAndStatus(
								Long.parseLong(rtiApplicationId), 0);

				if (rtiIApplicationReAssignAcceptance != null) {

					rtiIApplicationReAssignAcceptance
							.setRtiApplication(rtiApplication);
					rtiIApplicationReAssignAcceptance.setAcceptStatus(1);
					rtiIApplicationReAssignAcceptance.setAcceptOrRejectDate(
							CommonUtils.getCurrentStringDate());
					rtiIApplicationReAssignAcceptance
							.setAcceptOrRejectRemarks("Accepted");

					List<RTIApplicationReAssignAcceptance> rtiApplicationReAssignAcceptanceList = new ArrayList<RTIApplicationReAssignAcceptance>();
					rtiApplicationReAssignAcceptanceList
							.add(rtiIApplicationReAssignAcceptance);

					rtiApplication.setHasAssignedUser(1);
					rtiApplication.setRtiApplicationReAssignAcceptance(
							rtiApplicationReAssignAcceptanceList);

					/*
					 * if(sendToReAssign!=null && sendToReAssign.equals("1")){
					 * 
					 * User assignedToUser =
					 * userService.get(Long.parseLong(toUserId)); User
					 * assignedByUser = userService.get(userId);
					 * 
					 * RTIApplicationReAssignAcceptance
					 * rtiIApplicationReAssignAcceptance = new
					 * RTIApplicationReAssignAcceptance();
					 * rtiIApplicationReAssignAcceptance.setRtiApplication(
					 * rtiApplication);
					 * rtiIApplicationReAssignAcceptance.setAcceptStatus(0);
					 * rtiIApplicationReAssignAcceptance.setAssignedBy(
					 * assignedByUser);
					 * rtiIApplicationReAssignAcceptance.setAssignedTo(
					 * assignedToUser);
					 * rtiIApplicationReAssignAcceptance.setAssignedDate(
					 * CommonUtils. getCurrentStringDate());
					 * 
					 * List<RTIApplicationReAssignAcceptance>
					 * rtiApplicationReAssignAcceptanceList = new
					 * ArrayList<RTIApplicationReAssignAcceptance>();
					 * rtiApplicationReAssignAcceptanceList.add(
					 * rtiIApplicationReAssignAcceptance);
					 * 
					 * rtiApplication.setHasAssignedUser(0);
					 * rtiApplication.setRtiApplicationReAssignAcceptance(
					 * rtiApplicationReAssignAcceptanceList); assignStatus = 1;
					 * 
					 * }else if(isAssignedToOther !=null &&
					 * isAssignedToOther.length()>0 &&
					 * isAssignedToOther.equals("1") &&
					 * StringUtils.isNotEmpty(toUserId) ){
					 */
					User toUser = rtiIApplicationReAssignAcceptance
							.getAssignedTo();
					Department department = toUser.getDepartment();
					// Section section = toUser.getSection();

					rtiApplicationDetails.setRtiApplication(rtiApplication);
					rtiApplicationDetails
							.setStatus(CoreConstants.RTI_STATUS_FORWARD);
					rtiApplicationDetails.setAssignToStatus(1);
					rtiApplicationDetails.setAssignedEndDate(
							CommonUtils.getCurrentStringDateAndTime());
					rtiApplicationDetails.setToUser(toUser);

					rtiApplicationDetails1 = new RTIApplicationDetails();
					rtiApplicationDetails1.setRtiApplication(rtiApplication);
					rtiApplicationDetails1
							.setStatus(CoreConstants.RTI_STATUS_ACTIVE);
					rtiApplicationDetails1.setAssignToStatus(0);
					rtiApplicationDetails1.setAssignedStartDate(
							CommonUtils.getCurrentStringDateAndTime());
					rtiApplicationDetails1.setUser(toUser);
					// rtiApplicationDetails1.setSection(section);
					rtiApplicationDetails1.setDepartment(department);
					rtiApplicationDetails1.setWorkflowLevel(
							Integer.parseInt(rtiApplicationDetailsWF_Level));
					rtiApplicationDetails1.setComments("Re-Assign Task");

					rtiApplication.setAssignedDepartment(department);
					// rtiApplication.setAssignedSection(section);
					rtiApplication.setAssigneeUserId(toUser);

					request.setAttribute("userId", toUser.getUserId());
					assignStatus = assignToUser(request, response);
				}

				if (assignStatus == 1) {
					rtiApplicationDetailsList.add(rtiApplicationDetails);
					// rtiApplication.addRtiApplicationDetails(rtiApplicationDetails);
					if (rtiApplicationDetails1 != null) {
						rtiApplicationDetailsList.add(rtiApplicationDetails1);
						// rtiApplication.addRtiApplicationDetails(rtiApplicationDetails1);
					}
					rtiApplication.setRtiApplicationDetails(
							rtiApplicationDetailsList);
					session.setAttribute("message",
							"Assigned RTI Application Successfully Accepted By You...");
					rtiApplicationService.merge(rtiApplication);
				} else {
					session.setAttribute("errMessage", "Please Try Again...");
				}
			}
		} else {
			session.setAttribute("errMessage", "Please Try Again...");
		}

		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtiapplicationReAssigned/rejectAssignedTask.do")
	public ModelAndView rejectAssignedTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		long userId = sessionUser.getUserId();
		User user = userService.get(sessionUser.getUserId());

		if (log.isDebugEnabled()) {
			log.debug("Invoking savertiApplication");
		}

		RTIApplication rtiApplication = null;
		String rtiApplicationId = request.getParameter("rtiApplicationId");
		if (StringUtils.isNotEmpty(rtiApplicationId)
				&& !rtiApplicationId.equals("0")) {
			rtiApplication = rtiApplicationService
					.get(Long.parseLong(rtiApplicationId));

			if (rtiApplication != null) {
				RTIApplicationReAssignAcceptance rtiIApplicationReAssignAcceptance = rtiApplicationService
						.getRTIApplicationReAssignedTaskByRTIApplicationIdAndStatus(
								Long.parseLong(rtiApplicationId), 0);

				if (rtiIApplicationReAssignAcceptance != null) {
					String rejectionRemarks = request
							.getParameter("rejectionRemarks");

					rtiIApplicationReAssignAcceptance
							.setRtiApplication(rtiApplication);
					rtiIApplicationReAssignAcceptance.setAcceptStatus(2); // Reject
																			// Status
					rtiIApplicationReAssignAcceptance.setAcceptOrRejectDate(
							CommonUtils.getCurrentStringDate());
					rtiIApplicationReAssignAcceptance
							.setAcceptOrRejectRemarks(rejectionRemarks);

					List<RTIApplicationReAssignAcceptance> rtiApplicationReAssignAcceptanceList = new ArrayList<RTIApplicationReAssignAcceptance>();
					rtiApplicationReAssignAcceptanceList
							.add(rtiIApplicationReAssignAcceptance);

					rtiApplication.setHasAssignedUser(1);
					rtiApplication.setRtiApplicationReAssignAcceptance(
							rtiApplicationReAssignAcceptanceList);

					session.setAttribute("message",
							"Assigned RTI Application Is Rejected By You...");
					rtiApplicationService.merge(rtiApplication);
					/*
					 * if(sendToReAssign!=null && sendToReAssign.equals("1")){
					 * 
					 * User assignedToUser =
					 * userService.get(Long.parseLong(toUserId)); User
					 * assignedByUser = userService.get(userId);
					 * 
					 * RTIApplicationReAssignAcceptance
					 * rtiIApplicationReAssignAcceptance = new
					 * RTIApplicationReAssignAcceptance();
					 * rtiIApplicationReAssignAcceptance.setRtiApplication(
					 * rtiApplication);
					 * rtiIApplicationReAssignAcceptance.setAcceptStatus(0);
					 * rtiIApplicationReAssignAcceptance.setAssignedBy(
					 * assignedByUser);
					 * rtiIApplicationReAssignAcceptance.setAssignedTo(
					 * assignedToUser);
					 * rtiIApplicationReAssignAcceptance.setAssignedDate(
					 * CommonUtils. getCurrentStringDate());
					 * 
					 * List<RTIApplicationReAssignAcceptance>
					 * rtiApplicationReAssignAcceptanceList = new
					 * ArrayList<RTIApplicationReAssignAcceptance>();
					 * rtiApplicationReAssignAcceptanceList.add(
					 * rtiIApplicationReAssignAcceptance);
					 * 
					 * rtiApplication.setHasAssignedUser(0);
					 * rtiApplication.setRtiApplicationReAssignAcceptance(
					 * rtiApplicationReAssignAcceptanceList); assignStatus = 1;
					 * 
					 * }else if(isAssignedToOther !=null &&
					 * isAssignedToOther.length()>0 &&
					 * isAssignedToOther.equals("1") &&
					 * StringUtils.isNotEmpty(toUserId) ){
					 */

				} else {
					session.setAttribute("errMessage", "Please Try Again...");
				}
			}
		} else {
			session.setAttribute("errMessage", "Please Try Again...");
		}

		return listRTIApplication(request, response);
	}

	@RequestMapping("/rtiapplication/notingSaveEditor.do")

	public ModelAndView notingSaveEditor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("notingSaveEditor");
	}

	@RequestMapping("/rtiapplication/notingUpdateEditor.do")
	public ModelAndView notingUpdateEditor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("notingUpdateEditor");
	}

	// new one
	@RequestMapping("/Certificate/zone_certificate.do")
	public ModelAndView zone_certificate(HttpServletRequest request,
			HttpServletResponse response, Zone zone)
			throws ServletException, Exception {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");
		// long userId = sessionUser.getUserId();
		// User user=userService.get(sessionUser.getUserId());

		if (log.isDebugEnabled()) {
			log.debug("Invoking zone_certificate");
		}
		return new ModelAndView("zone_certificate");
	}

//	@RequestMapping("/rtsapplication/listRTSWaterMeterComplaint.do")
//	public ModelAndView listRTSWaterMeterComplaint(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException {
//		HttpSession session = request.getSession();
//		List<WaterMeterComplaint> records = waterMeterComplaintService
//				.getAllWaterMeterComplaint();
//		long rtiApplicationId = 0;
//		RTIApplication rtiapplication = null;
//		for (WaterMeterComplaint waterMeterComplaint : records) {
//			String requestNumber = waterMeterComplaint.getRtiapplrefno();
//			try {
//				RestTemplate restTemplate = new RestTemplate();
//				String url = "https://sampark.ocwindia.com/aaplesarkar/customer/getRequestStatus?key=6aa083ae54aae4a7fad7659c6fbfd0bc&requestNo="
//						+ requestNumber;
//
//				URL urlObj = new URL(url);
//				HttpURLConnection con = (HttpURLConnection) urlObj
//						.openConnection();
//				con.setRequestMethod("GET");
//				con.setRequestProperty("Accept", "application/json");
//				restTemplate.getMessageConverters()
//						.add(new StringHttpMessageConverter());
//				String result = restTemplate.getForObject(url, String.class);
//				System.out.println("result :" + result);
//				JSONObject document = new JSONObject(result.toString());
//				int find = 0;
//				if (document.has("data")
//						&& document.get("data") instanceof JSONArray) {
//					find = 1;
//					JSONArray array = document.getJSONArray("data");
//					JSONObject data = array.getJSONObject(0);
//					String file = data.isNull("noDuCerificate_file")
//							? null
//							: data.getString("noDuCerificate_file");
//					String request_status = data.isNull("request_status")
//							? null
//							: data.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (waterMeterComplaint.getRti_ref_id() > 0) {
//						rtiApplicationId = waterMeterComplaint.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiapplication.setPdfFilesSavedPath(file);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//				} else {
//
//					String request_status = document.isNull("request_status")
//							? null
//							: document.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (waterMeterComplaint.getRti_ref_id() > 0) {
//						rtiApplicationId = waterMeterComplaint.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//
//				}
//
//			} catch (Exception ex) {
//				ex.getMessage();
//			}
//		}
//		request.setAttribute("rtiServiceId", 64);
//		request.setAttribute("rtiModelName", "listRTSWaterMeterComplaint");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("records", records);
//		return listRTIApplication(request, response);
//	}

	@RequestMapping("/rtsapplication/listRTSWaterMeterComplaint.do")
	public ModelAndView listRTSWaterMeterComplaint(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 64);
		request.setAttribute("rtiModelName", "listRTSWaterMeterComplaint");
		ModelAndView modelAndView = new ModelAndView();
		return listRTIApplication(request, response);
	}


//	@RequestMapping("/rtsapplication/listRTSWaterNoDueApplication.do")
//	public ModelAndView listRTSWaterNoDueApplication(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException {
//		HttpSession session = request.getSession();
//		List<WaterConnectionNoDue> records = waterConnectionNoDueService
//				.getAllWaterNoDueCertificate();
//		long rtiApplicationId = 0;
//		RTIApplication rtiapplication = null;
//		for (WaterConnectionNoDue WaterNoDueCertificate : records) {
//			String requestNumber = WaterNoDueCertificate.getRtiapplrefno();
//			try {
//				RestTemplate restTemplate = new RestTemplate();
//				String url = "https://sampark.ocwindia.com/aaplesarkar/customer/getRequestStatus?key=6aa083ae54aae4a7fad7659c6fbfd0bc&requestNo="
//						+ requestNumber;
//
//				URL urlObj = new URL(url);
//				HttpURLConnection con = (HttpURLConnection) urlObj
//						.openConnection();
//				con.setRequestMethod("GET");
//				con.setRequestProperty("Accept", "application/json");
//				restTemplate.getMessageConverters()
//						.add(new StringHttpMessageConverter());
//				String result = restTemplate.getForObject(url, String.class);
//				System.out.println("result :" + result);
//				JSONObject document = new JSONObject(result.toString());
//				int find = 0;
//				if (document.has("data")
//						&& document.get("data") instanceof JSONArray) {
//					find = 1;
//					JSONArray array = document.getJSONArray("data");
//					JSONObject data = array.getJSONObject(0);
//					String file = data.isNull("noDuCerificate_file")
//							? null
//							: data.getString("noDuCerificate_file");
//					String request_status = data.isNull("request_status")
//							? null
//							: data.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (WaterNoDueCertificate.getRti_ref_id() > 0) {
//						rtiApplicationId = WaterNoDueCertificate
//								.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiapplication.setPdfFilesSavedPath(file);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//				} else {
//
//					JSONObject json = document.getJSONObject("data");
//					String request_status = json.isNull("request_status")
//							? null
//							: json.getString("request_status");
//					session.setAttribute("status", request_status);
//					if (WaterNoDueCertificate.getRti_ref_id() > 0) {
//						rtiApplicationId = WaterNoDueCertificate
//								.getRti_ref_id();
//						rtiapplication = rtiApplicationService
//								.get(rtiApplicationId);
//					}
//					request.setAttribute("rtiApplication", rtiapplication);
//					if (request_status.equals("open")) {
//						rtiapplication.setWorkFlowStatus(3);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("closed")) {
//						rtiapplication.setWorkFlowStatus(1);
//						rtiApplicationService.save(rtiapplication);
//					} else if (request_status.equals("rejected")) {
//						rtiapplication.setWorkFlowStatus(5);
//						rtiApplicationService.save(rtiapplication);
//					}
//					if (log.isDebugEnabled()) {
//						log.debug("GET Successfull:-" + request_status);
//					}
//
//				}
//
//			} catch (Exception ex) {
//				ex.getMessage();
//			}
//		}
//
//		request.setAttribute("rtiServiceId", 68);
//		request.setAttribute("rtiModelName", "listRTSWaterNoDueApplication");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("records", records);
//		return listRTIApplication(request, response);
//	}

	//water No Dues
			@RequestMapping("/rtsapplication/listRTSWaterNoDueApplication.do")
			public ModelAndView listRTSWaterNoDueApplication(HttpServletRequest request,
					HttpServletResponse response) throws ServletException {
				request.setAttribute("rtiServiceId", 68);
				request.setAttribute("rtiModelName", "listRTSWaterNoDueApplication");
				
				
				return listRTIApplication(request, response);
			}
	// DashBoard

	@RequestMapping("/rtiapplication/editAnyRTIApplication.do")
	public ModelAndView editAnyRTIApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		int rtiApplicationId=0;
		if(sessionUser!=null) {
		String rtiApplicationIdStr = request.getParameter("rtiApplicationId");
		if(rtiApplicationIdStr !=null) {
	    rtiApplicationId = Integer.parseInt(rtiApplicationIdStr);
		}
		RTIApplication rtiApplication = rtiApplicationService
				.get(rtiApplicationId);
		String subject = rtiApplication.getSubject();
		
		switch (subject) {
			case "ZONE-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtiapplication/editzoneCertificates.do")
						.forward(request, response);
				break;
			case "BIRTH-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtiapplication/editBirthRegistrationCertificate.do")
						.forward(request, response);
				break;
			case "DEATH-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtiapplication/editDeathRegistrationCertificate.do")
						.forward(request, response);
				break;
			case "MARRIAGE-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtiapplication/editMarriageCertificate.do")
						.forward(request, response);
				break;
			case "DOGLICENCE-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtiapplication/editDogLicenseCertificate.do")
						.forward(request, response);
				break;
			
			case "PROPERTY-TAX-UTARA-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtsapplication/editPropertyTaxUtara.do")
						.forward(request, response);
				break;
			case "PROPERTY-TAX-NO-DUES-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtsapplication/editPropertyTaxNoDues.do")
						.forward(request, response);
				break;
			case "PROPERTY-TRANSFER-REGISTRATION" :
				 request.getRequestDispatcher("/rtiapplication/editzoneCertificates.do").forward(request,
				 response);
				break;
			case "NEW-TAX-RECOVERY" :
				 request.getRequestDispatcher("/rtiapplication/editzoneCertificates.do").forward(request,
				 response);
				break;
			case "PROPERTY-TAX-REASSESSMENT" :
				 request.getRequestDispatcher("/rtiapplication/editPropertyTaxAssessment.do").forward(request,
				 response);
				break;
			case "PROPERTY-TAX-DEMAND" :
				 request.getRequestDispatcher("/rtsapplication/editPropertyTaxDemand.do").forward(request,
				 response);
				break;
			case "TAX-EXEMPTION" :
				 request.getRequestDispatcher("/rtsapplication/editPropertyTaxExemption.do").forward(request,
				 response);
				break;
			case "TAX-EXEMPTION-NON-RESIDENTIAL" :
				 request.getRequestDispatcher("/rtsapplication/editNonResidentialProperty.do").forward(request,
				 response);
				break;
			case "SELF-ASSESMENT" :
				 request.getRequestDispatcher("/rtiapplication/editzoneCertificates.do").forward(request,
				 response);
				break;
			case "PROPERTY-OBJECTION-REGISTRATION" :
				 request.getRequestDispatcher("/rtsapplication/editPropertyComplaint.do").forward(request,
				 response);
				break;
			case "PARTITION-OF-PROPERTY" :
				 request.getRequestDispatcher("/rtsapplication/editPartitionOfProperty.do").forward(request,
				 response);
				break;
			case "REASSESSMENT-FOR-RENOVATION" :
				 request.getRequestDispatcher("/rtsapplication/editNewlyConstructedproperty.do").forward(request,
				 response);
				break;
			case "PARTMAP-CERTIFICATE" :
				request.getRequestDispatcher("/rtiapplication/editPartMap.do")
						.forward(request, response);
				break;
			case "NEW-WATER-CONNECTION" :
				request.getRequestDispatcher(
						"/rtsapplication/editNewWaterConnection.do")
						.forward(request, response);
				break;
			case "WATER-DISCONNECTION-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtsapplication/editWaterDisconnection.do")
						.forward(request, response);
				break;
			case "CHANGE-IN-OWNERSHIP-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtsapplication/editChangeInOwnershipType.do")
						.forward(request, response);
				break;
			case "WATER-CONNECTION-TYPE-CHANGE" :
				request.getRequestDispatcher(
						"/rtsapplication/editWaterConnectionTypeChange.do")
						.forward(request, response);
				break;
			case "WATER-RECONNECTION" :
				request.getRequestDispatcher(
						"/rtsapplication/editWaterReconnection.do")
						.forward(request, response);
				break;
			case "WATER-CONNECTION-USAGE-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtsapplication/editWaterChangeUsage.do")
						.forward(request, response);
				break;
			case "WATER-NO-DUES-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtiapplication/editWaterDueCertificate.do")
						.forward(request, response);
				break;
			case "WATER-METER-COMPLAINT" :
				request.getRequestDispatcher(
						"/rtsapplication/editWaterMeterComplaint.do")
						.forward(request, response);
				break;
			case "ILLEGAL-WATER-CONNECTION" :
				request.getRequestDispatcher(
						"/rtsapplication/editIllegalWaterConnection.do")
						.forward(request, response);
				break;
			case "WATER-PRESSURE-COMPLAINT" :
				request.getRequestDispatcher(
						"/rtsapplication/editWaterPressure.do")
						.forward(request, response);
				break;
			case "WATER-QUALITY-COMPLAINT" :
				request.getRequestDispatcher(
						"/rtsapplication/editWaterQualityComplaint.do")
						.forward(request, response);
				break;
			case "FIRE-NOC" :
				 request.getRequestDispatcher("/rtiapplication/editzoneCertificates.do").forward(request,
				 response);
				break;
			case "FIRE-Recommendation" :
				 request.getRequestDispatcher("/rtiapplication/editFireRecommendation.do").forward(request,
				 response);
				break;
			case "FIRE-NOC-RENEWAL" :
				request.getRequestDispatcher(
						"/rtiapplication/editFireComplianceCertificate.do")
						.forward(request, response);
				break;
			case "MANDAP-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtiapplication/editMandapPermission.do")
						.forward(request, response);
				break;
			case "NOC-OF-TRADE-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtiapplication/editNOCOfTrade.do")
						.forward(request, response);
				break;
			case "TRADE-LICENSE-DUPLICATE" :
				request.getRequestDispatcher(
						"/rtiapplication/editTradeLicenseDuplicateCopy.do")
						.forward(request, response);
				break;
			case "TRADE-LICENCE-RENEWAL" :
				request.getRequestDispatcher(
						"/rtiapplication/editTradeLicenceRenewal.do")
						.forward(request, response);
				break;
			case "TRADE-LICENSE-TRANSFER-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtiapplication/editTradeLicenseTransfer.do")
						.forward(request, response);
				break;
			case "TRADE-LICENCE-NEW" :
				request.getRequestDispatcher(
						"/rtiapplication/editTradeLicenceNew.do")
						.forward(request, response);
				break;
			case "TRADE-LICENSE-NAME-CHANGE" :
				request.getRequestDispatcher(
						"/rtiapplication/edittradeLicenseNameChange.do")
						.forward(request, response);
				break;
			case "TRADE-LICENSE-TYPE-CHANGE" :
				request.getRequestDispatcher(
						"/rtiapplication/editTradeLicenseTypeChange.do")
						.forward(request, response);
				break;
			case "TRADE-LICENCE-PARTNER-CHANGE" :
				request.getRequestDispatcher(
						"/rtiapplication/editTradeLicencePartnerChange.do")
						.forward(request, response);
				break;
			case "TRADE-LICENCE-PARTNEW-COUNT-UPDATE" :
				request.getRequestDispatcher(
						"/rtsapplication/editTradeLicencePartnerCountUpdate.do")
						.forward(request, response);
				break;
			case "TRADE-LICENSE-OutdatedRenewal-NOTICE" :
				request.getRequestDispatcher(
						"/rtiapplication/editTradeLicenseOutdatedRenewal.do")
						.forward(request, response);
				break;
			case "TRADE-LICENSE-CANCELLATION" :
				request.getRequestDispatcher(
						"/rtiapplication/editTradeLicenseCancellation.do")
						.forward(request, response);
				break;
			case "Ganesh Mandap Permission" :
				request.getRequestDispatcher(
						"/rtiapplication/editGaneshMandapPermission.do")
						.forward(request, response);
				break;
			case "Durga Utsav Mandap Permission" :
				request.getRequestDispatcher(
						"/rtsapplication/editDurgaUtsavMandapPermission.do")
						.forward(request, response);
				break;
			case "Diksha Bhumi Mandap Permission" :
				request.getRequestDispatcher(
						"/rtsapplication/editDikshaBhumiMandapPermission.do")
						.forward(request, response);
				break;
			case "OCCUPANCY-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtiapplication/editoccupancyCertificate.do")
						.forward(request, response);
				break;
			case "Fire Crackers Shop License" :
				request.getRequestDispatcher(
						"/rtiapplication/editFireCrackersShopLicense.do")
						.forward(request, response);
				break;
			case "NURSING-HOME-REGISTRATION" :
				request.getRequestDispatcher(
						"/rtsapplication/editNurshingHome.do")
						.forward(request, response);
				break;
			case "RENEWAL-NURSING-HOME-REGISTRATION" :
				request.getRequestDispatcher(
						"/rtsapplication/editRenewalNurshingHome.do")
						.forward(request, response);
				break;
			case "NURSING-HOME-CHANGES-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtsapplication/editNursingHomeChangesApplication.do")
						.forward(request, response);
				break;
			case "DOGLICENCE-RENEWAL-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtsapplication/editDogRenewalLicenseCertificate.do")
						.forward(request, response);
				break;
			case "MTP-REGISTRATION" :
				request.getRequestDispatcher(
						"/rtsapplication/editMTPRegistrationCertificate.do")
						.forward(request, response);
				break;
				
			case "BIO-MEDICAL-WASTE" :
				
				request.getRequestDispatcher(
						"/rtsapplication/editBioMedicalWaste.do")
						.forward(request, response);
				
				break;
			case "PROPERTY-TAX-NEW-ASSESSMENT" :
				request.getRequestDispatcher(
						"/rtsapplication/editPropertyTaxMutation.do")
						.forward(request, response);
				break;
			case "PROPERTY-TAX-NEW-ASSESSMENT-MUTATION" :
				request.getRequestDispatcher(
						"/rtsapplication/editPropertyTaxMutation.do")
						.forward(request, response);
				break;
				
			case "PROPERTY-TRANSFER-REGISTRATION-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtsapplication/editPropertyTaxTransferRegistration.do")
						.forward(request, response);
				break;
				
			case "INHERITANCE-RIGHTS-PROPERTY-REGISTRATION-CERTIFICATE" :
				request.getRequestDispatcher(
						"/rtsapplication/editPropertyTaxTransferRegistration.do")
						.forward(request, response);
				break;
			case "TREE-CUTTING" :
				request.getRequestDispatcher(
						"/rtiapplication/editTreeCuting.do")
						.forward(request, response);
				break;
			case "TREE-TRIMMING" :
				request.getRequestDispatcher(
						"/rtiapplication/editTreeTrimming.do")
						.forward(request, response);
				break;
			case "FIRE-Recommendation+" :
				request.getRequestDispatcher(
						"/rtsapplication/editFireRecommendation.do")
						.forward(request, response);
				break;
			
				
			// write case for each application subject type
			default :
				break;
		}
		}
		return new ModelAndView("redirect:/login.do");
	
	
	}

	// Tree Cutting
	@RequestMapping("/rtsapplication/listRTSTreeCuting.do")
	public ModelAndView listRTSTreeCuting(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 73);
		request.setAttribute("rtiModelName", "listRTSTreeCuting");
		return listRTIApplication(request, response);
	}

	// Fire Recommendation Letter
//	@RequestMapping("/rtsapplication/listRTSFireNOCApplication.do")
//	public ModelAndView listRTSFireNOCApplication(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException {
//		request.setAttribute("rtiServiceId", 69);
//		request.setAttribute("rtiModelName", "listRTSFireRecommendation");
//		return listRTIApplication(request, response);
//	}

	// Tree Trimming
	@RequestMapping("/rtsapplication/listRTSTreeTrimming.do")
	public ModelAndView listRTSTreeTrimming(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		request.setAttribute("rtiServiceId", 75);
		request.setAttribute("rtiModelName", "listRTSTreeTrimming");
		return listRTIApplication(request, response);
	}

	// Ganesh Mandap permission
	@RequestMapping("/rtsapplication/listRTSGaneshMandapApplication.do")
	public ModelAndView listRTSGaneshMandapApplication(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 90);
		request.setAttribute("rtiModelName", "listRTSGaneshMandapApplication");
		return listRTIApplication(request, response);
	}
	
	@RequestMapping("/rtsapplication/ganeshReport.do")
	public ModelAndView ganeshReport(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
//		request.setAttribute("rtiServiceId", 91);
		request.setAttribute("rtiModelName", "ganeshReport");
		return listRTIApplication(request, response);
	}
	
	
	//Propertt Tax Utara
	@RequestMapping("/rtsapplication/listRTSProvideTaxUtara.do")
	public ModelAndView listRTSProvideTaxUtara(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 55);
		request.setAttribute("rtiModelName",
				"listRTSProvideTaxUtaraApplication");
		return listRTIApplication(request, response);
		
	}
	
	
	//Property Tax Assessment
	@RequestMapping("/rtsapplication/listRTSPropertyAssessmentTranscriptApplication.do")
	public ModelAndView listRTSPropertyAssessmentTranscriptApplication(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 58);
		request.setAttribute("rtiModelName",
				"listRTSPropertyAssessmentTranscriptApplication");
		return listPropertyTaxRTIApplication(request, response);
	}

	//Property Tax Self Assessment
	@RequestMapping("/rtsapplication/listRTSPropertySelfAssessmentApplication.do")
	public ModelAndView listRTSPropertySelfAssessmentApplication(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 60);
		request.setAttribute("rtiModelName",
				"listRTSPropertySelfAssessmentApplication");
		return listRTIApplication(request, response);
	}

	//Property Tax Non Residential Property
	@RequestMapping("/rtsapplication/listRTSNonResidentialProperty.do")
	public ModelAndView listRTSNonResidentialProperty(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 52);
		request.setAttribute("rtiModelName",
				"listRTSNonResidentialPropertyApplication");
		return listRTIApplication(request, response);
	}

	//Property Tax Exemption
	@RequestMapping("/rtsapplication/listRTSPropertyTaxExemption.do")
	public ModelAndView listRTSPropertyTaxExemption(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 71);
		request.setAttribute("rtiModelName",
				"listRTSPropertyTaxExemption");
		return listPropertyTaxRTIApplication(request, response);
	}

	//Property Tax Property Complaint
	@RequestMapping("/rtsapplication/listRTSPropertyComplaint.do")
	public ModelAndView listRTSPropertyComplaint(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 67);
		request.setAttribute("rtiModelName",
				"listRTSPropertyComplaintApplication");
		return listPropertyTaxRTIApplication(request, response);
	}
	
	
	//Property Tax Demand
	@RequestMapping("/rtsapplication/listRTSPropertyTaxDemand.do")
	public ModelAndView listRTSPropertyTaxDemand(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("rtiServiceId", 72);
		request.setAttribute("rtiModelName",
				"listRTSPropertyTaxDemandApplication");
		return listRTIApplication(request, response);
	}
	
	//Partition Of Property
		@RequestMapping("/rtsapplication/listRTSPartitionOfPropertyApplication.do")
		public ModelAndView listRTSPartitionOfPropertyApplication(
				HttpServletRequest request, HttpServletResponse response)
				throws ServletException {
			request.setAttribute("rtiServiceId", 53);
			request.setAttribute("rtiModelName",
					"listRTSPartitionOfPropertyApplication");
			return listPropertyTaxRTIApplication(request, response);
		}

		//Partition Of Newly Constructed Property
		@RequestMapping("/rtsapplication/listRTSNewlyConstructedPropertyApplication.do")
		public ModelAndView listRTSNewlyConstructedPropertyApplication(
				HttpServletRequest request, HttpServletResponse response)
				throws ServletException {
			request.setAttribute("rtiServiceId", 56);
			request.setAttribute("rtiModelName", "listRTSNewlyConstructedProperty");
			return listPropertyTaxRTIApplication(request, response);
		}


		//Partition Of No Dues
		@RequestMapping("/rtsapplication/listRTSPropertyNoDuesCertificate.do")
		public ModelAndView listRTSPropertyNoDuesCertificate(
				HttpServletRequest request, HttpServletResponse response)
				throws ServletException {
			request.setAttribute("rtiServiceId", 54);
			request.setAttribute("rtiModelName",
					"listRTSPropertyNoDueCertificateApplication");
			return listRTIApplication(request, response);
		}

		//Property Tax Transfer Registration
		@RequestMapping("/rtsapplication/listRTSPropertyTransferRegistration.do")
		public ModelAndView listRTSPropertyTransferRegistration(
				HttpServletRequest request, HttpServletResponse response)
				throws ServletException {
			request.setAttribute("rtiServiceId", 57);
			request.setAttribute("rtiModelName",
					"listRTSropertyTransferRegiistrationApplication");
			return listRTIApplication(request, response);
		}

		//Property Tax New Tax Recovery 
		@RequestMapping("/rtsapplication/listRTSNewTaxRecovery.do")
		public ModelAndView listRTSNewTaxRecovery(
				HttpServletRequest request, HttpServletResponse response)
				throws ServletException {
			request.setAttribute("rtiServiceId", 103);
			request.setAttribute("rtiModelName",
					"listRTSNewTaxRecoveryApplication");
			return listPropertyTaxRTIApplication(request, response);
		}

		//Durga Utsav Mandap Permission
		@RequestMapping("/rtsapplication/listRTSDurgaUtsavMandapApplication.do")
		public ModelAndView listRTSDurgaUtsavMandapApplication(
				HttpServletRequest request, HttpServletResponse response)
				throws ServletException {
			request.setAttribute("rtiServiceId", 91);
			request.setAttribute("rtiModelName", "listRTSDurgaUtsavMandapApplication");
			return listRTIApplication(request, response);
		}
		
		// Diksha Bhumi Mandap Permission
			@RequestMapping("/rtsapplication/listRTSDikshaBhumiMandapApplication.do")
			public ModelAndView listRTSDikshaBhumiMandapApplication(
					HttpServletRequest request, HttpServletResponse response)
					throws ServletException {
				request.setAttribute("rtiServiceId", 92);
				request.setAttribute("rtiModelName", "listRTSDikshaBhumiMandapApplication");
				return listRTIApplication(request, response);
			}
			
			//
			@RequestMapping("/rtsapplication/durgaUtsavReport.do")
			public ModelAndView durgaUtsavReport(HttpServletRequest request, HttpServletResponse response)
					throws ServletException {
				request.setAttribute("rtiModelName", "durgaUtsavReport");
				return listRTIApplication(request, response);
			}
			
			
			
			//Fire Crackers Shop License
			@RequestMapping("/rtsapplication/listRTSFireCrackersShopLicense.do")
			public ModelAndView listRTSFireCrackersShopLicense(
					HttpServletRequest request, HttpServletResponse response)
					throws ServletException {
				request.setAttribute("rtiServiceId", 93);
				request.setAttribute("rtiModelName", "listRTSFireCrackersShopLicense");
				return listRTIApplication(request, response);
			}


		    //Nursing Home
		    @RequestMapping("/rtsapplication/listRTSNursingHome.do")
		    public ModelAndView listRTSNursingHome(HttpServletRequest request, HttpServletResponse response) throws ServletException
		    {
		    	request.setAttribute("rtiServiceId",94);
		    	request.setAttribute("rtiModelName","listRTSNursingHome");
				return listRTIApplication(request, response);
		    }
		    
		    //Renewal Nursing Home
		    @RequestMapping("/rtsapplication/listRTSRenewalNursingHome.do")
		    public ModelAndView listRTSRenewalNursingHome(HttpServletRequest request, HttpServletResponse response) throws ServletException
		    {
		    	request.setAttribute("rtiServiceId",95);
		    	request.setAttribute("rtiModelName","listRTSRenewalNursingHome");
				return listRTIApplication(request, response);
		    }
		   
		    //Nursing Home changes
		    @RequestMapping("/rtsapplication/listNursingHomeChangesApplication.do")
		    public ModelAndView listNursingHomeChangesApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException
		    {
		    	request.setAttribute("rtiServiceId",96);
		    	request.setAttribute("rtiModelName","listNursingHomeChangesApplication");
				return listRTIApplication(request, response);
		    }
		    
		    
		    //Dog License Renewal
		    @RequestMapping("/rtsapplication/listRTSDogRenewalApplication.do")
			public ModelAndView listRTSDogRenewalApplication(HttpServletRequest request,
					HttpServletResponse response) throws ServletException {
				request.setAttribute("rtiServiceId", 102);
				request.setAttribute("rtiModelName", "listRTSDogRenewalApplication");
				return listRTIApplication(request, response);
			}
		    
		    
		    
		    //BioMedical Disposal Waste
		    @RequestMapping("/rtsapplication/listRTSBiologicalWasteDisposal.do")
			public ModelAndView listRTSBiologicalWasteDisposal(
					HttpServletRequest request, HttpServletResponse response)
					throws ServletException {
				request.setAttribute("rtiServiceId",101);
				request.setAttribute("rtiModelName", "listRTSBiologicalMedicalDisposal");
				return listRTIApplication(request, response);
			}
		    
		    
		    //Property Tax Transfer Registration
		    @RequestMapping("/rtsapplication/listRTSPropertyTaxTRansferRegistration.do")
			public ModelAndView listRTSPropertyTaxTRansferRegistration(
					HttpServletRequest request, HttpServletResponse response)
					throws ServletException {
				request.setAttribute("rtiServiceId",104);
				request.setAttribute("rtiModelName", "listRTSPropertyTaxTransferRegistration");
				return listPropertyTaxRTIApplication(request, response);
			}
		    
		    
		    
		    //PropertyTaxListPage
		    @RequestMapping("/rtsapplication/listPropertyTaxRTIApplication.do")
			public ModelAndView listPropertyTaxRTIApplication(HttpServletRequest request, HttpServletResponse response)
					throws ServletException {

				if (log.isDebugEnabled()) {
					log.debug("Invoking listrtiApplication");
				}
				HttpSession session = request.getSession();
				SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
				if(sessionUser!=null) {
				RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
				
				setSearchParameters(applicationSearch, request);
				if(request.getParameter("currentPage")!=null) {
					String a = request.getParameter("currentPage");
					applicationSearch.setCurrentPage(Integer.parseInt(a));
					
				}else if(request.getSession().getAttribute("servicetaxId")!=null && request.getSession().getAttribute("currentPage")!=null) {
					if((int)request.getSession().getAttribute("servicetaxId")==(int)request.getAttribute("rtiServiceId")) {
					applicationSearch.setRtiserviceid((int)request.getSession().getAttribute("servicetaxId"));
					String a = (String)request.getSession().getAttribute("currentPage");
					applicationSearch.setCurrentPage(Integer.parseInt(a));
					}
				}
				String year=null;
				if(request.getAttribute("rtiServiceId")!=null)
				applicationSearch.setRtiserviceid(Integer.parseInt(request.getAttribute("rtiServiceId").toString()));
				User user = userService.get(sessionUser.getUserId());
				String userZone = user.getZone();
				//String userDept = user.getDepartment();
				List<WorkflowTemplateUserMappingDetails> workflowTemplateUserMappingDetails=null;
				if(user.getUserName()!=null){
					workflowTemplateUserMappingDetails = workflowTemplateUserMappingDetailsService
							.getByName(user.getUserName());
					}
				if(applicationSearch.getYear()!=null) {
					year = applicationSearch.getYear();
				}else {
					year=String.valueOf(Year.now());
				}
				if(userZone!=null && !userZone.isEmpty()) {
				applicationSearch.setZone(Integer.parseInt(userZone));
				List<RTIApplication> rtiapplicationList = new ArrayList<RTIApplication>();
				List<RTIApplication> rtiApplicationList=null;
				
				try {
					String userName = sessionUser.getUserName();
					long userDept = sessionUser.getDepartmentId();
				 rtiApplicationList = rtiApplicationService.getRTSApplicationList(userName,userDept,userZone,applicationSearch.getCurrentPage(),applicationSearch.getRtiserviceid(), workflowTemplateUserMappingDetails);
				if (userZone != null && rtiApplicationList!=null) {
					rtiapplicationList.addAll(rtiApplicationList);
				}
						long totalCount = rtiApplicationService.getRTSApplicationListCount(userName,userDept,userZone,applicationSearch.getCurrentPage(),applicationSearch.getRtiserviceid(),workflowTemplateUserMappingDetails);
						request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
						request.setAttribute("totalCount", totalCount);
					} catch (Exception e) {
						log.error(e.getMessage());
					}

					if (rtiApplicationList == null) {
						rtiApplicationList = new ArrayList<RTIApplication>();
					}

					request.setAttribute("user", user);
					request.setAttribute("currentPage", applicationSearch.getCurrentPage());
					request.setAttribute(const_OrderBy, applicationSearch.getOrderBy());
					request.setAttribute(const_SortBy, applicationSearch.getSortBy());
					request.setAttribute("SearchfileCreate", applicationSearch);
					request.setAttribute("departmentList", departmentService.getAll());
					request.setAttribute("serviceId", request.getAttribute("rtiServiceId"));

					return new ModelAndView(request.getAttribute("rtiModelName").toString(), "rtiapplicationList",
							rtiapplicationList);
				}else {
					try {
				
					List<RTIApplication> rtiApplicationList = new ArrayList<RTIApplication>();
					rtiApplicationList = rtiApplicationService.getRTSApplicationList(sessionUser.getUserName(),sessionUser.getDepartmentId(),userZone,applicationSearch.getCurrentPage(),applicationSearch.getRtiserviceid(),workflowTemplateUserMappingDetails);
					long totalCount = rtiApplicationService.getRTSApplicationListCount(sessionUser.getUserName(),sessionUser.getDepartmentId(),userZone,applicationSearch.getCurrentPage(),applicationSearch.getRtiserviceid(),workflowTemplateUserMappingDetails);
					request.setAttribute("maximumPages", new Long(CommonUtils.getMaxPage(totalCount)));
					request.setAttribute("totalCount", totalCount);
					if (rtiApplicationList == null) {
						rtiApplicationList = new ArrayList<RTIApplication>();
						
					}
					request.setAttribute("user", user);
					request.setAttribute("currentPage", applicationSearch.getCurrentPage());
					request.setAttribute(const_OrderBy, applicationSearch.getOrderBy());
					request.setAttribute(const_SortBy, applicationSearch.getSortBy());
					request.setAttribute("SearchfileCreate", applicationSearch);
					request.setAttribute("departmentList", departmentService.getAll());
					request.setAttribute("serviceId", request.getAttribute("rtiServiceId"));

					if(request.getParameter("currentPage")!=null) {
					request.getSession().removeAttribute("servicetaxId");
					request.getSession().removeAttribute("pg");
					}

					return new ModelAndView(request.getAttribute("rtiModelName").toString(), "rtiapplicationList",
							rtiApplicationList);
					}catch(Exception ex) {
						ex.printStackTrace();
						log.error(ex.getStackTrace(), ex);
					}
				}
				}
				return new ModelAndView("redirect:/login.do");
			
			}
		    
}
		    
		    
		  

