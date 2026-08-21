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

import com.mars.common.model.User;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.TreeTrimming;
import com.mars.rti.model.TreeTrimmingDetails;
import com.mars.rti.model.TreesType;
import com.mars.rti.model.WaterDisconnection;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TreeTrimmingService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;
@Controller
public class TreeTrimmingController {
	// extends MultiActionController implements InitializingBean
	private static Log log = LogFactory.getLog(TreeCutingController.class);
	@Autowired
	private TreeTrimmingService treeTrimmingService;
	@Autowired
	private RTIApplicationService rtiApplicationService;
	//
	// private static String const_OrderBy = "OrderBy";
	//
	// private static String const_SortBy = "SortBy";

	@Autowired
	private UserRegistrationService userService;
	
	@Autowired
	private UserService userservice;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;

	// @RequestMapping("ws/rtiapplication/newRTIMandapApplication.do")
	// public ModelAndView newRTIMandapApplication(HttpServletRequest request,
	// HttpServletResponse response)
	// throws ServletException {
	// String baseDir = getServletContext().getRealPath("");
	// String folder = "mandapPermission";
	// File file = new File(baseDir, folder);
	// if (!file.exists()) {
	// file.mkdirs();
	// }
	// ModelAndView modelAndView = new ModelAndView("newRTIMandapApplication");
	// modelAndView.addObject("folderName", folder);
	// return modelAndView;
	// }

	@RequestMapping("/rtsapplication/saveTreeTrimming.do")
	public ModelAndView saveTreeTrimming(HttpServletRequest request,
			HttpServletResponse response, TreeTrimming treeTrimming)
			throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking tree");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking TreeTrimming");
		}
		RTIApplication retunRti =null;
		String mobileNumber = "";
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
			UserRegistrationDetails user = userService
					.getUserByMobileNo(mobileNumber);
			Object as_status=session.getAttribute("as_status");

			if (treeTrimming != null) {

				RTIApplication rtiApplication = new RTIApplication();

				rtiApplication.setCreatedDate(
						CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(
						CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("TREE-TRIMMING");
				rtiApplication.setDepartment("GARDEN-DEPARTMENT");
				rtiApplication.setTemplateName("garden");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(75);
				rtiApplication.setApplicantName(treeTrimming.getFirstName() + " "
						+ treeTrimming.getMiddlename() + " "
						+ treeTrimming.getLastname());
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
				}
				rtiApplication.setPhoneNumber(treeTrimming.getMobileNo());
				rtiApplication.setMobileNumber(treeTrimming.getMobileNo());
				rtiApplication.setZone(treeTrimming.getZoneNo());
				rtiApplication.setEmail(treeTrimming.getEmail());
				// rtiApplication.setApplicationCost(treeCuting.getFees());
				rtiApplication.setUserRegistrationDetails(user);

				rtiApplication.setApplicantName(treeTrimming.getFullName());
				rtiApplication.setPdfUploadFromPortal(treeTrimming.getFilesPath());
				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(0);
				rtiApplicationDetails.setAssignToStatus(1);
				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDate());

				rtiApplicationDetails.setComments("Form Submitted");// ();
				rtiApplicationDetails.setWorkflowLevel(0);
				rtiApplicationDetailsList.add(rtiApplicationDetails);
				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);
				

				if (savedRti.getRtiApplicationId() > 0) {

					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
							
					rti.setRtiApplnNumber("RTS/GD"  + "/"
							+ savedRti.getRtiApplicationId() + "/" + Year.now());
					treeTrimming.setRtiapplrefno(rti.getRtiApplnNumber());
					treeTrimming.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = treeTrimmingService.treeTrimming(treeTrimming);
							
					rti.setRtiApplicationRefId(birth_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					retunRti = rtiApplicationService.merge(rti);

					if ((retunRti != null) && (birth_regis_id > 0)) {

					}
					String name = treeTrimming.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = treeTrimming.getMobileNo();
					String email=treeTrimming.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}
				
//				ModelAndView model = new ModelAndView("newRTSTreeTrimmingSuccess",
//						"treeTrimming", treeTrimming);
//				return model;
				if(as_status!=null && user_name==null) {
					return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSTreeTrimmingSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());
				}			}
		}

		// ModelAndView modelAndView = new
		// ModelAndView("newRTIMandapPermissionSucess");
		// modelAndView.addObject("result", "Save successfully done");
		return new ModelAndView("redirect:/ws/user/login.do");
	//	return new ModelAndView("newRTSApplicationforTreeTriming");
		// return new ModelAndView(
		// "redirect:/newRTIMandapPermissionSucess.jsp");

		/*
		 * ModelAndView modelAndView = new ModelAndView("redirect:/abc.htm");
		 * modelAndView.addObject("newRTIMandapPermissionSucess" , new
		 * ModelAttribute()); return modelAndView;
		 */
	}
	
	@RequestMapping("ws/rtsapplication/newRtSTreeTrimmingSuccess.do")
	public ModelAndView newRtSTreeTrimmingSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTSTreeTrimmingSuccess");
		
		model.addObject("treeTrimming",appNo);
		return model;
				
		
	}

	@SuppressWarnings("unused")
	@RequestMapping("/rtiapplication/editTreeTrimming.do")
	public ModelAndView editTreeTrimming(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {

		TreeTrimming treeTrimming = null;
		HttpSession session = request.getSession();
		System.out.println(" editTreeCuting");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		List<TreeTrimmingDetails> tt=null;
		long treeType_heritage=0;
		long treeType_Non_heritage=0;
		RTIApplication rtiapplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
    request.getSession().setAttribute("refid",request.getParameter("rtiApplicationRefId"));

	if (sessionUser != null) {
	    long userId = sessionUser.getUserId();
	if (request.getParameter("rtiApplicationRefId") != null
			&& request.getParameter("rtiApplicationRefId").length() > 0
			|| session.getAttribute("rtirefId") != null) {
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0) {
			rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
			treeTrimming = treeTrimmingService.get(rtiApplicationRefId);
		} else if (session.getAttribute("rtirefId") != null) {
			Object a = session.getAttribute("rtirefId");
			rtiApplicationRefId = (long) a;
			treeTrimming = treeTrimmingService.get(rtiApplicationRefId);
		}
		tt= treeTrimmingService.getTreeTypeList(treeTrimming.getTreeTrimmingId());
		request.setAttribute("treeTrimmingDetails", tt);
		if(tt!=null && tt.size()>0) {
			
			for(TreeTrimmingDetails tp : tt) {
				if(tp.getTypeOfTree().equals("Heritage")){
					treeType_heritage++;
				}else {
					treeType_Non_heritage++;
				}
			}
			request.setAttribute("treeType_heritage", treeType_heritage);
			request.setAttribute("treeType_Non_heritage", treeType_Non_heritage);


		}
			String fees = request.getParameter("fees");
			String treeRemark = request.getParameter("treeRemark");
			if (treeTrimming.getRti_ref_id() > 0) {
				rtiApplicationId = treeTrimming.getRti_ref_id();
				rtiapplication = rtiApplicationService.get(rtiApplicationId);
				if (rtiapplication.getApplicationCost() == 0.0
						|| rtiapplication.getApplicationCost() == 0) {
					if(org.apache.commons.lang.StringUtils.isNotEmpty(fees) && fees!=null) {
					rtiapplication.setApplicationCost(Double.parseDouble(fees));
					rtiapplication = rtiApplicationService.merge(rtiapplication);
							}
	
			}
											
				if(org.apache.commons.lang.StringUtils.isNotEmpty(treeRemark) && treeRemark!=null && rtiapplication.getWorkFlowStatus()!=3 && rtiapplication.getWorkFlowStatus()!=2 && rtiapplication.getWorkFlowStatus()!=1) {
				
				rtiapplication.setWorkFlowStatus(9);
				
				
				rtiapplication = rtiApplicationService.merge(rtiapplication);

			
		}


		}else {
				List<RTIApplication> listRTI = rtiApplicationService
						.findByProperty("rtiApplicationRefId",
								rtiApplicationRefId);
				if (listRTI != null && !listRTI.isEmpty()) {
					rtiApplicationId = listRTI.get(0).getRtiApplicationId();
					rtiapplication = listRTI.get(0);
				}
			}
		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME,
				CoreConstants.RTI_GARDEN_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME,
				CoreConstants.RTI_GARDEN_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID,
				rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId,
						CoreConstants.RTI_GARDEN_WORKFLOW_ENTITY);

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

		
		User user = userservice.get(userId);
		String userLoginId = user.getUserLevel();
		if(userLoginId!=null && !userLoginId.isEmpty()) {
		if(userLoginId.equals("L1")) {
			request.setAttribute("forLogin", "L1");
		}else if (userLoginId.equals("L2")) {
			request.setAttribute("forLogin", "L2");
		}
		else
		{
			request.setAttribute("forLogin", "nothing");
		}
		}

		
		ModelAndView modelAndView = new ModelAndView("manageTreeTrimming",
				"treeTrimming", treeTrimming);

		return modelAndView;
	}else {
	return new ModelAndView("redirect:/login.do");
	}
}
	
	@RequestMapping("/rtsapplication/saveTreeFees.do")
	public ModelAndView saveTreeFrees(HttpServletRequest request,
			HttpServletResponse response, TreeTrimming treeTrimming)
			throws ServletException, Exception {
		String fees = request.getParameter("fees");
		String ownership = request.getParameter("ownership");
		String totalNonHeritage = request.getParameter("totalNonHeritage");
		String totalHeritage = request.getParameter("totalHeritage");
	String actualNumberoftreetrimming = request.getParameter("actualNumberoftreetrimming");
		String saveApproval = request.getParameter("saveApproval");
		String treeRemark = request.getParameter("treeRemark");

		
		//String noOftrees = request.getParameter("numberOfTree");

		String appType = request.getParameter("appType");
		String refid = request.getParameter("treeTrimmingId");
		
		//String refid = (String) request.getSession().getAttribute("refid");
		long apprefid = 0; // Default value if the conversion fails or refid is null
		if(refid!=null)
			apprefid = Long.parseLong(refid);
		treeTrimming = treeTrimmingService.get(apprefid);

			if (appType.equals("1")) {
				String[] nameOfTree = request.getParameterValues("nameOfTree");
				String[] typeOfTree = request.getParameterValues("typeOfTree");
				String[] ageOfTree = request.getParameterValues("ageOfTree");
				String[] girthOfTree = request.getParameterValues("girthOfTree");
				String[] remarks = request.getParameterValues("remarks");

				List<TreeTrimmingDetails> ttList = new ArrayList<>();
				 double totalFees = 0.0; // Total fees accumulator
				for (int i = 0; i <nameOfTree.length; i++) {
					TreeTrimmingDetails tt = new TreeTrimmingDetails();
					tt.setNameOfTree(nameOfTree[i]);
					String fee = treeTrimmingService.getfees(nameOfTree[i]);
					 double feeValue = Double.parseDouble(fee);
				        totalFees += feeValue; // Accumulate fees
					if (nameOfTree != null)
						tt.setNameOfTree(nameOfTree[i]);
					if (typeOfTree != null)
						tt.setTypeOfTree(typeOfTree[i]);
					if (ageOfTree != null)
						tt.setAgeOfTree(ageOfTree[i]);
					if (girthOfTree != null)
						tt.setGirthOfTree(girthOfTree[i]);
					if (remarks != null)
						tt.setRemarks(remarks[i]);
					tt.setTreeTrimming(treeTrimming);
					ttList.add(tt);

				}

				if (ttList != null && ttList.size() > 0) {
	actualNumberoftreetrimming = request.getParameter("actualNumberoftreetrimming");
	treeTrimming.setActualNumberoftreetrimming(actualNumberoftreetrimming);
	treeTrimming.setTotalFeesWithGST(String.valueOf(totalFees));

					treeTrimmingService.savetreeTypeList(ttList);
	treeTrimming = treeTrimmingService.merge(treeTrimming);

				}
				return new ModelAndView("redirect:/rtiapplication/editTreeTrimming.do?rtiApplicationRefId=" + apprefid);

			}
			if (appType.equals("2")) {
				if ((treeTrimming.getTotalFeesWithGST() == null && fees != null) ||
					    (treeTrimming.getOwnership() == null && ownership != null) ||
					    (treeTrimming.getTotalHeritage() == null && totalHeritage != null) ||
					    (treeTrimming.getTotalNonHeritage() == null && totalNonHeritage != null) ||
					    (treeTrimming.getTreeRemark() == null && treeRemark != null) ) {
					treeTrimming.setTotalFeesWithGST(fees);
					treeTrimming.setOwnership(ownership);
					treeTrimming.setTotalHeritage(totalHeritage);
					treeTrimming.setTotalNonHeritage(totalNonHeritage);
					treeTrimming.setTreeRemark(treeRemark);

					treeTrimming = treeTrimmingService.merge(treeTrimming);		
				} 			
				return new ModelAndView("redirect:/rtiapplication/editTreeTrimming.do?rtiApplicationRefId=" + apprefid + "&fees=" + fees + "&treeRemark=" + treeRemark);
			}
			
//					if (appType.equals("3")) {
//			if (treeTrimming.getSaveApproval() == null && saveApproval != null)  {
//				treeTrimming.setSaveApproval(saveApproval);
//				
//					treeTrimming = treeTrimmingService.merge(treeTrimming);		
//			} 			
//			return new ModelAndView("redirect:/rtiapplication/editTreeTrimming.do?rtiApplicationRefId=" + apprefid + "&saveApproval=" + saveApproval);
//}
			return new ModelAndView("redirect:/rtiapplication/editTreeTrimming.do?rtiApplicationRefId=" + apprefid);

			}
			
			
			
			
			
			
			
			@RequestMapping("/rtiapplication/createTreeTrimmingWork.do")
	public ModelAndView createTreeTrimmingWork(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {
		String rtiApplicationIdString = request
				.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService
				.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId,
						CoreConstants.RTI_GARDEN_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		TreeTrimming treeTrimming = treeTrimmingService.get(applicationId);
		String email = treeTrimming.getEmail();
		String mobileNo = treeTrimming.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();

		if (treeTrimming != null) {
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
						personalTask
								.setEntityName(processDetails.getEntityName());
						personalTask.setWorkflowInitator(
								processDetails.getUserName());
						personalTask.setEntityDetails(
								processDetails.getEntityDetails());
						request.setAttribute("personalTask", personalTask);
					}

					rtiApplication.setWorkFlowStatus(3);
					rtiApplicationService.save(rtiApplication);
					SendSMSEmailController.sendPayment(applicantName, mobileNo, rtiApplnNumber, email);


					if (request.getParameter("WORKFLOW_TRANSISTION").isEmpty()
							|| request.getParameter(
									"WORKFLOW_TRANSISTION") == null) {

					}
					if (task != null && sessionUser.getUserName()
							.equals(task.getAssignee())) {
						request.setAttribute("userAccess", 1);
						request.setAttribute("workFlowTask", task);
					}
				} else if (request.getParameter("WORKFLOW_TRANSISTION")
						.equals("Close-Application")) {

					rtiApplication.setWorkFlowStatus(1);
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
					rtiApplication.setWorkflowComments(workflow_comments);
	
					rtiApplicationService.save(rtiApplication);
					SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION")
						.equals("Reject")) {
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
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME,
				CoreConstants.RTI_GARDEN_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME,
				CoreConstants.RTI_GARDEN_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID,
				rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView("redirect:/rtiapplication/editTreeTrimming.do");
	}

}