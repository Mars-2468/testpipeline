package com.mars.rti.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.model.User;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.Collection;
import com.mars.rti.model.FireDetails;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.TreeCuting;
import com.mars.rti.model.TreesType;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TreeCutingService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

@Controller
public class TreeCutingController {
	// extends MultiActionController implements InitializingBean
	private static Log log = LogFactory.getLog(TreeCutingController.class);
	@Autowired
	private TreeCutingService treeCutingService;
	@Autowired
	private RTIApplicationService rtiApplicationService;
	//
	// private static String const_OrderBy = "OrderBy";
	//
	// private static String const_SortBy = "SortBy";

	@Autowired
	private UserService userService;
	
	

@Autowired
	private UserRegistrationService userRegistrationService;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;
	
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 50; // 10MB
	private static final int REQUEST_SIZE = 1024 * 1024 * 100; // 50MB

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

	
	private static String const_OrderBy = "OrderBy";

	private static String const_SortBy = "SortBy";
	
	@RequestMapping("/rtsapplication/saveTreeCuting.do")
	public ModelAndView saveTreeCuting(HttpServletRequest request,
			HttpServletResponse response, TreeCuting treeCuting)
			throws ServletException, Exception {

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking tree");
		}
		if (log.isDebugEnabled()) {
			log.debug("Invoking TreeCuting");
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
			UserRegistrationDetails user = userRegistrationService
					.getUserByMobileNo(mobileNumber);
			Object as_status=session.getAttribute("as_status");
			if (treeCuting != null) {

				RTIApplication rtiApplication = new RTIApplication();

				rtiApplication.setCreatedDate(
						CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(
						CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("TREE-CUTTING");
				rtiApplication.setDepartment("GARDEN-DEPARTMENT");
				//rtiApplication.setTemplateName("garden");
				rtiApplication.setTemplateName("Tree_Cutting_Workflow");
				rtiApplication.setIsApleSarkarApp(0);

				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(73);
				rtiApplication.setApplicantName(treeCuting.getFirstName() + " "
						+ treeCuting.getMiddlename() + " "
						+ treeCuting.getLastname());
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(user_name);
					
				}
				rtiApplication.setPhoneNumber(treeCuting.getMobileNo());
				rtiApplication.setMobileNumber(treeCuting.getMobileNo());
				rtiApplication.setZone(treeCuting.getZoneNo());
				rtiApplication.setEmail(treeCuting.getEmail());
				// rtiApplication.setApplicationCost(treeCuting.getFees());
				rtiApplication.setUserRegistrationDetails(user);

				rtiApplication.setApplicantName(treeCuting.getFullName());
				rtiApplication.setPdfUploadFromPortal(treeCuting.getFilesPath());
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
				
					rti.setRtiApplnNumber("RTS/GD" + "/" + savedRti.getRtiApplicationId()  + "/" + Year.now());
					treeCuting.setRtiapplrefno(rti.getRtiApplnNumber());
					treeCuting.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = treeCutingService.treeCuting(treeCuting);
					rti.setRtiApplicationRefId(birth_regis_id);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					 retunRti = rtiApplicationService.merge(rti);
                    
					if ((retunRti != null) && (birth_regis_id > 0)) {

					}
					String name = treeCuting.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = treeCuting.getMobileNo();
					String email=treeCuting.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}
//				ModelAndView model = new ModelAndView("newRTSTreeCutingSuccess",
//						"treeCuting", treeCuting);
//				return model;
				
				if(as_status!=null && user_name==null) {
					return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSTreeCuttingSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());
				}			}
		}

		// ModelAndView modelAndView = new
		// ModelAndView("newRTIMandapPermissionSucess");
		// modelAndView.addObject("result", "Save successfully done");
		//return new ModelAndView("newRTSApplicationforTreeTriming");
		return new ModelAndView("redirect:/ws/user/login.do");
		// return new ModelAndView(
		// "redirect:/newRTIMandapPermissionSucess.jsp");

		/*
		 * ModelAndView modelAndView = new ModelAndView("redirect:/abc.htm");
		 * modelAndView.addObject("newRTIMandapPermissionSucess" , new
		 * ModelAttribute()); return modelAndView;
		 */
	}

	@RequestMapping("ws/rtsapplication/newRtSTreeCuttingSuccess.do")
	public ModelAndView newRtSTreeCuttingSuccess(HttpServletRequest request,HttpServletResponse response) {

		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTSTreeCutingSuccess");

		model.addObject("treeCuting",appNo);
		return model;


	}
	@SuppressWarnings("unused")
	@RequestMapping("/rtiapplication/editTreeCuting.do")
	public ModelAndView editTreeCuting(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, Exception {

		TreeCuting treeCuting = null;
		HttpSession session = request.getSession();
		System.out.println(" editTreeCuting");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		List<TreesType> tt=null;
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
				treeCuting = treeCutingService.get(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				treeCuting = treeCutingService.get(rtiApplicationRefId);
				
			}
			tt= treeCutingService.getTreeTypeList(treeCuting.getTreecutingId());
			request.setAttribute("treestype", tt);
			if(tt!=null && tt.size()>0) {
				
				for(TreesType tp : tt) {
					if(tp.getTypeOfTree().equals("Heritage")){
						treeType_heritage++;
					}else {
						treeType_Non_heritage++;
					}
				}
				request.setAttribute("treeType_heritage", treeType_heritage);
				request.setAttribute("treeType_Non_heritage", treeType_Non_heritage);


			}
			//String fees = request.getParameter("fees");
			String treeRemark = request.getParameter("treeRemark");

			
			if (treeCuting.getRti_ref_id() > 0) {
				rtiApplicationId = treeCuting.getRti_ref_id();
				rtiapplication = rtiApplicationService.get(rtiApplicationId);
//				if (rtiapplication.getApplicationCost() == 0.0
//						|| rtiapplication.getApplicationCost() == 0) {
//					if(org.apache.commons.lang.StringUtils.isNotEmpty(fees) && fees!=null) {
//					rtiapplication.setApplicationCost(Double.parseDouble(fees));
//
//					rtiapplication = rtiApplicationService.merge(rtiapplication);
//					}
//				}
				if(org.apache.commons.lang.StringUtils.isNotEmpty(treeRemark) && treeRemark!=null && rtiapplication.getWorkFlowStatus()!=3 && rtiapplication.getWorkFlowStatus()!=2 && rtiapplication.getWorkFlowStatus()!=1) {
					
					//rtiapplication.setWorkFlowStatus(9);
					
					
					rtiapplication = rtiApplicationService.merge(rtiapplication);

				
			}


			} 
//			if (treeCuting.getRti_ref_id() > 0) {
//				rtiApplicationId = treeCuting.getRti_ref_id();
//				rtiapplication = rtiApplicationService.get(rtiApplicationId);
//				
//				
//				String email = treeCuting.getEmail();
//				String mobileNo = treeCuting.getMobileNo();
//				String rtiApplnNumber = rtiapplication.getRtiApplnNumber();
//				String applicantName = rtiapplication.getApplicantName();
//				long rtirefId = rtiapplication.getRtiApplicationRefId();
//				
//				if(org.apache.commons.lang.StringUtils.isNotEmpty(treeRemark) && treeRemark!=null) {
//				
//						rtiapplication.setWorkFlowStatus(9);
//						
//						
//						rtiapplication = rtiApplicationService.merge(rtiapplication);
//
//					
//				}
//
//			}
			else {
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
		User user = userService.get(userId);
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

		ModelAndView modelAndView = new ModelAndView("manageTreeCuting",
				"treeCuting", treeCuting);

		return modelAndView;

	}else {
		return new ModelAndView("redirect:/login.do");
	}
	}
	
	@RequestMapping("/rtsapplication/saveApprovalStatus.do")
	public ModelAndView saveApprovalStatus(HttpServletRequest request, HttpServletResponse response,
			TreeCuting treeCuting) throws ServletException, Exception {
		String saveApproval = request.getParameter("saveApproval");
		String refid = request.getParameter("rtiApplicationRefIds");

		//String refid = request.getParameter("waterDisconnectionId");
		long apprefid = 0;
		apprefid = Long.parseLong(refid);

		treeCuting = treeCutingService.get(apprefid);
//				waterDisconnection.setSendDemandStatus(1);
		String status = treeCuting.getSaveApproval();
		if (treeCuting.getSaveApproval() == null && saveApproval != null) {
			treeCuting.setSaveApproval(saveApproval);
			treeCuting = treeCutingService.merge(treeCuting);

		}
		return new ModelAndView("redirect:/rtiapplication/editTreeCuting.do?rtiApplicationRefId=" + apprefid);

	}

	
	@RequestMapping("/rtiapplication/saveTree.do")
	public ModelAndView saveTree(HttpServletRequest request, HttpServletResponse response, TreeCuting treeCuting)
			throws ServletException, Exception {
		String fees = request.getParameter("fees");
		//String ownership = request.getParameter("ownership");
		String totalNonHeritage = request.getParameter("totalNonHeritage");
		String totalHeritage = request.getParameter("totalHeritage");
		String actualNumberoftreetrimming = request.getParameter("actualNumberoftreetrimming");
		String treeRemark = request.getParameter("treeRemark");

		
		//String noOftrees = request.getParameter("numberOfTree");
		String appType = request.getParameter("appType");
		String refid = request.getParameter("treecutingId");
		
		long apprefid = 0; 
		if(refid!=null)
		apprefid = Long.parseLong(refid);
		treeCuting = treeCutingService.get(apprefid);

		if (appType.equals("1")) {
			String[] nameOfTree = request.getParameterValues("nameOfTree");
			String[] typeOfTree = request.getParameterValues("typeOfTree");
			String[] ageOfTree = request.getParameterValues("ageOfTree");
			String[] girthOfTree = request.getParameterValues("girthOfTree");
			String[] remarks = request.getParameterValues("remarks");
		    String[] treeImagePath = request.getParameterValues("treeImagePath"); // NEW

			List<TreesType> ttList = new ArrayList<>();
			 double totalFees = 0.0; // Total fees accumulator
			    double totalAge = 0.0; // Total age accumulator
			for (int i = 0; i <nameOfTree.length; i++) {
				TreesType tt = new TreesType();
				if (nameOfTree != null)
					tt.setNameOfTree(nameOfTree[i]);
				if (typeOfTree != null)
					tt.setTypeOfTree(typeOfTree[i]);
				if (ageOfTree != null) {
					 double age = Double.parseDouble(ageOfTree[i]);
	            totalAge += age;
					tt.setAgeOfTree(ageOfTree[i]);
				}
				if (girthOfTree != null)
					tt.setGirthOfTree(girthOfTree[i]);
				if (remarks != null)
					tt.setRemarks(remarks[i]);
				
				// NEW: set tree photo path if present and not blank/"null"
		        if (treeImagePath != null && i < treeImagePath.length
		                && treeImagePath[i] != null
		                && !treeImagePath[i].isEmpty()
		                && !treeImagePath[i].equalsIgnoreCase("null")) {
		            tt.setTreeImage(treeImagePath[i]);
		        }
				
				 double treeFee = totalAge * 1000;
			        double gst = treeFee * 0.10;
			        totalFees = treeFee + gst; // Fixed the calculation here
					
			        treeCuting.setTotalFeesWithGST(String.valueOf(totalFees));
				tt.setTreeCutting(treeCuting);
				ttList.add(tt);
			    System.out.println("Total fees for all trees: " + totalFees); // Output total fees
			    if (treeCuting.getRti_ref_id() > 0) {

			        RTIApplication rtiApplication =
			                rtiApplicationService.get(treeCuting.getRti_ref_id());

			        if (rtiApplication != null) {
			            rtiApplication.setApplicationCost((double) totalFees);
			            rtiApplicationService.merge(rtiApplication);
			        }
			    }

			  

			}

			if (ttList != null && ttList.size() > 0) {
				actualNumberoftreetrimming = request.getParameter("actualNumberoftreetrimming");
				treeCuting.setActualNumberoftreetrimming(actualNumberoftreetrimming);
				treeCutingService.savetreeTypeList(ttList);
				treeCuting = treeCutingService.merge(treeCuting);	
				request.setAttribute("totalFees", totalFees);



			}
			return new ModelAndView("redirect:/rtiapplication/editTreeCuting.do?rtiApplicationRefId=" + apprefid);

		}
		if (appType.equals("2")) {

		    treeCuting.setTotalFeesWithGST(fees);
		   // treeCuting.setOwnership(ownership);
		    treeCuting.setTotalHeritage(totalHeritage);
		    treeCuting.setTotalNonHeritage(totalNonHeritage);
		    treeCuting.setTreeRemark(treeRemark);

		    treeCuting = treeCutingService.merge(treeCuting);

		    // Save in RTIApplication also
		    if (treeCuting.getRti_ref_id() > 0) {

		        RTIApplication rtiApplication =
		                rtiApplicationService.get(treeCuting.getRti_ref_id());

		        if (rtiApplication != null) {

		            if (fees != null && !fees.trim().isEmpty()) {
		                rtiApplication.setApplicationCost(Double.parseDouble(fees));
		            }

		            // If you want workflow to move to L2 after saving fees
		            // rtiApplication.setWorkFlowStatus(9);

		            rtiApplicationService.merge(rtiApplication);
		        }
		    }

		    return new ModelAndView(
		            "redirect:/rtiapplication/editTreeCuting.do?rtiApplicationRefId=" + apprefid);
		}
		if (appType.equals("5")) {

		    // Basic presence check
		    if (fees == null || fees.trim().isEmpty()) {
		        return new ModelAndView(
		                "redirect:/rtiapplication/editTreeCuting.do?rtiApplicationRefId=" + apprefid);
		    }

		    String feesTrimmed = fees.trim();

		    // Mirrors client-side validateFees(): digits only, non-zero, max 8 digits, max value 99999999
		    if (!feesTrimmed.matches("^\\d+$")) {
		        return new ModelAndView(
		                "redirect:/rtiapplication/editTreeCuting.do?rtiApplicationRefId=" + apprefid);
		    }
		    if (feesTrimmed.length() > 8) {
		        return new ModelAndView(
		                "redirect:/rtiapplication/editTreeCuting.do?rtiApplicationRefId=" + apprefid);
		    }

		    long feeValue;
		    try {
		        feeValue = Long.parseLong(feesTrimmed);
		    } catch (NumberFormatException nfe) {
		        return new ModelAndView(
		                "redirect:/rtiapplication/editTreeCuting.do?rtiApplicationRefId=" + apprefid);
		    }

		    if (feeValue <= 0 || feeValue > 99999999L) {
		        return new ModelAndView(
		                "redirect:/rtiapplication/editTreeCuting.do?rtiApplicationRefId=" + apprefid);
		    }

		    treeCuting.setTotalFeesWithGST(feesTrimmed);
		    treeCuting = treeCutingService.merge(treeCuting);

		    // Keep RTIApplication.applicationCost in sync with the fee just saved
		    if (treeCuting.getRti_ref_id() > 0) {

		        RTIApplication rtiApplication =
		                rtiApplicationService.get(treeCuting.getRti_ref_id());

		        if (rtiApplication != null) {
		            rtiApplication.setApplicationCost((double) feeValue);
		            rtiApplicationService.merge(rtiApplication);
		        }
		    }

		    return new ModelAndView(
		            "redirect:/rtiapplication/editTreeCuting.do?rtiApplicationRefId=" + apprefid);
		}
		
//			if (appType.equals("3")) {
//				if (treeCuting.getTreeRemark() == null && treeRemark != null)  {
//					treeCuting.setTreeRemark(treeRemark);
//					
//					treeCuting = treeCutingService.merge(treeCuting);		
//				} 			
//				return new ModelAndView("redirect:/rtiapplication/editTreeCuting.do?rtiApplicationRefId=" + apprefid + "&treeRemark=" + treeRemark);
//			}
		
		return new ModelAndView("redirect:/rtiapplication/editTreeCuting.do?rtiApplicationRefId=" + apprefid);

	}

	@RequestMapping("/rtiapplication/createTreeCutingWork.do")
	public ModelAndView createTreeCutingWork(HttpServletRequest request,
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
	    workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId,
	                    CoreConstants.RTI_GARDEN_WORKFLOW_ENTITY);

	    String id = request.getParameter("id");
	    long applicationId = Long.parseLong(id);
	    TreeCuting treeCuting = treeCutingService.get(applicationId);
	    String email = treeCuting.getEmail();
	    String mobileNo = treeCuting.getMobileNo();
	    String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
	    String applicantName = rtiApplication.getApplicantName();
	    long rtirefId = rtiApplication.getRtiApplicationRefId();

	    // Read the transition parameter ONCE, safely, up front.
	    // (Original code called request.getParameter("WORKFLOW_TRANSISTION")
	    // repeatedly and even called .isEmpty()/.equals() directly on a value
	    // that can be null - that's an NPE risk. We just cache it safely here;
	    // no other logic is changed.)
	    String workflowTransition = request.getParameter("WORKFLOW_TRANSISTION");

	    if (treeCuting != null) {
	        if (workflowProcessDetails != null) {
	            String processId = workflowProcessDetails.getProcessId();
	            if (processId != null) {
	                processDetails = workflowProcessDetailsService
	                        .getWorkflowProcessDetailsByProcessId(processId);
	            }

	            boolean processEnded = workflowService.isProcessEnded(processId);

	            // ---- Original "still running" block: task/assignee display setup ----
	            // This used to be the ONLY branch that ran when the process
	            // hadn't ended, and it never looked at WORKFLOW_TRANSISTION at all.
	            // We keep it exactly as-is, just no longer gating the status
	            // updates below on it.
	            if (!processEnded) {
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

	                rtiApplication.setWorkFlowStatus(0);
	                rtiApplicationService.save(rtiApplication);
	                //SendSMSEmailController.sendPayment(applicantName, mobileNo, rtiApplnNumber, email);

	                if (task != null && sessionUser.getUserName()
	                        .equals(task.getAssignee())) {
	                    request.setAttribute("userAccess", 1);
	                    request.setAttribute("workFlowTask", task);
	                }
	            }

	            // ---- Transition handling: now runs regardless of processEnded ----
	            // This is the fix: previously this whole chain was inside
	            // "else if (!processEnded) {...} else if (transition == X) {...}"
	            // so Approve / Send-For-Verification / Send-For-Approval /
	            // send-demand (all mid-process transitions) never got evaluated
	            // because isProcessEnded() was still false at that point.
	            // Close-Application and Reject happened to work only because
	            // both of those transitions go straight to "end" in the JPDL.
	            if (workflowTransition != null && !workflowTransition.isEmpty()) {

	            	if (workflowTransition.equals("L1Approve")) {

	                    rtiApplication.setWorkFlowStatus(9);
	                    String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
	                    rtiApplication.setWorkflowComments(workflow_comments);

	                    rtiApplicationService.save(rtiApplication);
	                    //SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

	                    request.setAttribute("workFlowCompleted", "1");
	                }else if (workflowTransition.equals("Approve")) {

	                    rtiApplication.setWorkFlowStatus(9);
	                    rtiApplication.setFinalStatus("L2");
	                    String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
	                    rtiApplication.setWorkflowComments(workflow_comments);

	                    rtiApplicationService.save(rtiApplication);
	                    //SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

	                    request.setAttribute("workFlowCompleted", "1");
	                }
	                else if (workflowTransition.equals("L2Approve")) {

	                    rtiApplication.setWorkFlowStatus(10);
	                    String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
	                    rtiApplication.setWorkflowComments(workflow_comments);

	                    rtiApplicationService.save(rtiApplication);
	                    //SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

	                    request.setAttribute("workFlowCompleted", "1");
	                }
	                else if (workflowTransition.equals("Verified")) {

	                    rtiApplication.setWorkFlowStatus(9);
	                    rtiApplication.setFinalStatus("L2");

	                    String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
	                    rtiApplication.setWorkflowComments(workflow_comments);

	                    rtiApplicationService.save(rtiApplication);
	                    //SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

	                    request.setAttribute("workFlowCompleted", "1");
	                }
	                else if (workflowTransition.equals("Send-For-Approval")) {

	                    rtiApplication.setWorkFlowStatus(11);
	                    String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
	                    rtiApplication.setWorkflowComments(workflow_comments);

	                    rtiApplicationService.save(rtiApplication);
	                    //SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

	                    request.setAttribute("workFlowCompleted", "1");
	                }
	                else if (workflowTransition.equals("send-demand")) {

	                    rtiApplication.setWorkFlowStatus(3);
	                    String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
	                    rtiApplication.setWorkflowComments(workflow_comments);

	                    rtiApplicationService.save(rtiApplication);
	                    SendSMSEmailController.sendPayment(applicantName, mobileNo, rtiApplnNumber, email);

	                    request.setAttribute("workFlowCompleted", "1");
	                }
	                else if (workflowTransition.equals("Close-Application")) {

	                    rtiApplication.setWorkFlowStatus(1);
	                    String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
	                    rtiApplication.setWorkflowComments(workflow_comments);

	                    rtiApplicationService.save(rtiApplication);
	                    SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

	                    request.setAttribute("workFlowCompleted", "1");
	                }
	                else if (workflowTransition.equals("Reject")) {

	                    rtiApplication.setWorkFlowStatus(5);
	                    String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
	                    rtiApplication.setWorkflowComments(workflow_comments);
	                    rtiApplicationService.save(rtiApplication);
	                    SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

	                    request.setAttribute("workFlowCompleted", "1");
	                }
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
	    return new ModelAndView(
	            "redirect:/rtiapplication/editTreeCuting.do");
	}
	
	@RequestMapping(value = "/rtsapplication/uploadTreeImages.do", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public void uploadTreeImages(HttpServletRequest request, HttpServletResponse response) throws IOException {

	    JSONObject json = new JSONObject();
	    PrintWriter out = response.getWriter();

	    try {
	        StringBuilder sb = new StringBuilder();
	        try (java.io.BufferedReader reader = request.getReader()) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                sb.append(line);
	            }
	        }

	        JSONObject bodyJson = new JSONObject(sb.toString());
	        String uniqueId = bodyJson.optString("UID", null);
	        String rowIndex = bodyJson.optString("rowIndex", null);
	        String fileName = bodyJson.optString("fileName", "image.jpg");
	        String base64Data = bodyJson.optString("data", null);

	        if (uniqueId == null || uniqueId.trim().isEmpty()
	                || rowIndex == null
	                || base64Data == null || base64Data.trim().isEmpty()) {
	            json.put("status", false);
	            json.put("message", "Missing UID, rowIndex, or image data");
	            out.print(json.toString());
	            out.flush();
	            return;
	        }

	        // Strip the "data:image/jpeg;base64," prefix if present
	        int commaIdx = base64Data.indexOf(",");
	        if (base64Data.startsWith("data:") && commaIdx != -1) {
	            base64Data = base64Data.substring(commaIdx + 1);
	        }

	        byte[] fileBytes = java.util.Base64.getDecoder().decode(base64Data);

	        String baseDir = CoreConstants.UPLOAD_PATH + "TreeCutingApplication" + File.separator + "TreeImages" + File.separator + uniqueId;
	        File dir = new File(baseDir);
	        log.info("Resolved tree image upload dir ABSOLUTE PATH: " + dir.getAbsolutePath());
	        if (!dir.exists()) {
	            boolean created = dir.mkdirs();
	            log.info("Directory created: " + created + " exists now: " + dir.exists());
	        }

	        String ext = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".") + 1) : "jpg";
	        String cleanName = uniqueId + "_" + rowIndex + "_" + System.currentTimeMillis() + "." + ext;
	        File storeFile = new File(baseDir, cleanName);

	        try (java.io.FileOutputStream fos = new java.io.FileOutputStream(storeFile)) {
	            fos.write(fileBytes);
	        }
	        log.info("Saved tree image (base64): " + storeFile.getAbsolutePath());

	        json.put("status", true);
	        json.put("path", storeFile.getAbsolutePath());
	        json.put("rowIndex", rowIndex);

	    } catch (Exception ex) {
	        log.error("uploadTreeImages failed", ex);
	        json.put("status", false);
	        json.put("message", ex.getMessage());
	    }

	    out.print(json.toString());
	    out.flush();
	}
	// Helper: parse a single query-string parameter without touching request.getParameter(),
	// which can prematurely consume a multipart body on some containers.
	private String extractQueryParam(HttpServletRequest request, String key) {
	    String qs = request.getQueryString();
	    if (qs == null) return null;
	    for (String pair : qs.split("&")) {
	        int idx = pair.indexOf('=');
	        if (idx > 0) {
	            String k = pair.substring(0, idx);
	            String v = pair.substring(idx + 1);
	            if (k.equals(key)) {
	                try {
	                    return java.net.URLDecoder.decode(v, "UTF-8");
	                } catch (Exception e) {
	                    return v;
	                }
	            }
	        }
	    }
	    return null;
	}
	
	
	@RequestMapping("/rtsapplication/listRTSTreeCuttingApplication.do")
	public ModelAndView listRTSTreeCuttingApplication(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException {

	    if (log.isDebugEnabled()) {
	        log.debug("Invoking listRTSfireApplication");
	    }

	    HttpSession session = request.getSession();
	    SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

	    if (sessionUser == null) {
	        return new ModelAndView("redirect:/login.do");
	    }

	    RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
	    setSearchParameters(applicationSearch, request);

	    try {

	        if (request.getAttribute("rtiServiceId") != null) {
	            applicationSearch.setRtiserviceid(
	                    Integer.parseInt(request.getAttribute("rtiServiceId").toString()));
	        }

	        User user = userService.get(sessionUser.getUserId());

	        String userZone = user.getZone();
	        String userLevel = user.getUserLevel();
			String userMiddleName = user.getMiddleName();

			boolean isZoneUser = userMiddleName != null 
			        && userMiddleName.trim().equalsIgnoreCase("HQ");


	        long totalCount = 0;

	        // ✅ CALL SERVICE (FIXED)
	        List<RTIApplication> rtiapplicationList =
	        		treeCutingService.getTreeApplications(applicationSearch, userZone, userLevel, isZoneUser);

	        totalCount =
	        		treeCutingService.getTreeApplicationsCount(applicationSearch, userZone, userLevel, isZoneUser);
	      
	    
	        
	        if (rtiapplicationList == null) {
	            rtiapplicationList = new ArrayList<>();
	        }

	        // ✅ Pagination
	        request.setAttribute("maximumPages", CommonUtils.getMaxPage(totalCount));
	        request.setAttribute("totalCount", totalCount);

	        // ✅ UI Attributes
	        request.setAttribute("user", user);
	        request.setAttribute("currentPage", applicationSearch.getCurrentPage());
	        request.setAttribute(const_OrderBy, applicationSearch.getOrderBy());
	        request.setAttribute(const_SortBy, applicationSearch.getSortBy());
	        request.setAttribute("SearchfileCreate", applicationSearch);
	       // request.setAttribute("departmentList", departmentService.getAll());
	        request.setAttribute("serviceId", request.getAttribute("rtiServiceId"));

	        return new ModelAndView(
"listRTSTreeCuting",
	                "rtiapplicationList",
	                rtiapplicationList);

	    } catch (Exception e) {
	        log.error("Error in listRTSfireApplication", e);
	        e.printStackTrace();
	    }

	    return new ModelAndView("redirect:/login.do");
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
	
	

	@RequestMapping("/rtsapplication/uploadsmanagetreecutting.do")
	public void uploadsmanagetreecutting(HttpServletRequest request, HttpServletResponse response) throws IOException {

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");

	    JSONObject json = new JSONObject();
	    PrintWriter pw = response.getWriter();

	    try {
	        String appType = extractQueryParam(request, "appType");
	        String uniqueId = extractQueryParam(request, "UID");

	        if (appType == null || appType.trim().isEmpty()) {
	            json.put("status", false);
	            json.put("message", "Missing appType");
	            pw.print(json.toString());
	            pw.flush();
	            return;
	        }

	        if (uniqueId == null || uniqueId.trim().isEmpty()) {
	            json.put("status", false);
	            json.put("message", "Missing UID");
	            pw.print(json.toString());
	            pw.flush();
	            return;
	        }

	        if (!(request instanceof MultipartHttpServletRequest)) {
	            json.put("status", false);
	            json.put("message", "Request is not multipart");
	            pw.print(json.toString());
	            pw.flush();
	            return;
	        }

	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

	        String baseDir = null;
	        String moduleFolder = null;

	        if ("1".equals(appType)) {
	            moduleFolder = "DemandLetter";
	        } else if ("2".equals(appType)) {
	            moduleFolder = "TreeNOC";
	        } else if ("3".equals(appType)) {
	            moduleFolder = "RejectionLetter";
	        } else if ("4".equals(appType)) {
	            moduleFolder = "Pachanama";
	        } else if ("5".equals(appType)) {
	            moduleFolder = "CitizenNoc";
	        } else if ("6".equals(appType)) {
	            moduleFolder = "MissingDocs";
	        } else {
	            json.put("status", false);
	            json.put("message", "Invalid appType");
	            pw.print(json.toString());
	            pw.flush();
	            return;
	        }

	        baseDir = CoreConstants.UPLOAD_PATH + File.separator + moduleFolder + File.separator + uniqueId;

	        File parentDirectory = new File(baseDir);
	        if (!parentDirectory.exists()) {
	            parentDirectory.mkdirs();
	        }

	        Map<String, MultipartFile> rawFileMap = multipartRequest.getFileMap();
	        Map<String, MultipartFile> files = new LinkedHashMap<String, MultipartFile>();

	        for (Map.Entry<String, MultipartFile> entry : rawFileMap.entrySet()) {
	            MultipartFile mf = entry.getValue();
	            if (mf != null && !mf.isEmpty()) {
	                files.put(entry.getKey(), mf);
	            }
	        }

	        if (files.isEmpty()) {
	            json.put("status", false);
	            json.put("message", "No files received.");
	            pw.print(json.toString());
	            pw.flush();
	            return;
	        }

	        if ("6".equals(appType)) {
	            String missingDocLabelsStr = multipartRequest.getParameter("missingDocLabels");
	            String[] labels = (missingDocLabelsStr != null && !missingDocLabelsStr.trim().isEmpty())
	                    ? missingDocLabelsStr.split("\\|")
	                    : new String[0];

	            TreeCuting treeCuting = treeCutingService.get(Long.parseLong(uniqueId));

	            JSONArray existingDocs;
	            if (treeCuting.getMissingDocs() != null && !treeCuting.getMissingDocs().trim().isEmpty()) {
	                existingDocs = new JSONArray(treeCuting.getMissingDocs());
	            } else {
	                existingDocs = new JSONArray();
	            }

	            int index = 0;

	            for (MultipartFile multipartFile : files.values()) {
	                if (multipartFile == null || multipartFile.isEmpty()) {
	                    continue;
	                }

	                String original = multipartFile.getOriginalFilename();
	                if (original == null) {
	                    original = "file";
	                }

	                original = new File(original).getName();

	                int dot = original.lastIndexOf(".");
	                String ext = dot >= 0 ? original.substring(dot) : "";
	                String baseName = dot >= 0 ? original.substring(0, dot) : original;

	                baseName = baseName.replaceAll("[^a-zA-Z0-9_-]", "");
	                if (baseName.isEmpty()) {
	                    baseName = "file";
	                }

	                String storedFileName = uniqueId + "_" + System.currentTimeMillis() + "_" + index + "_" + baseName + ext;

	                File dest = new File(parentDirectory, storedFileName);
	                multipartFile.transferTo(dest);

	                // IMPORTANT:
	                // This is the value to save in DB/JSON, always with forward slash
	                String storedPath = CoreConstants.UPLOAD_PATH.replace("\\", "/");
	                if (!storedPath.endsWith("/")) {
	                    storedPath = storedPath + "/";
	                }
	                storedPath = storedPath + moduleFolder + "/" + uniqueId + "/" + storedFileName;
	                storedPath = storedPath.replace("\\", "/");

	                JSONObject obj = new JSONObject();
	                obj.put("label", index < labels.length ? labels[index] : "Document " + (index + 1));
	                obj.put("path", storedPath);

	                existingDocs.put(obj);
	                index++;
	            }

	            treeCuting.setMissingDocs(existingDocs.toString());
	            treeCutingService.saveTreeCutingForm(treeCuting);

	            json.put("status", true);
	            json.put("savedCount", index);
	            json.put("data", existingDocs);

	        } else {
	            TreeCuting treeCuting = treeCutingService.get(Long.parseLong(uniqueId));

	            int i = 0;
	            int savedCount = 0;

	            for (MultipartFile multipartFile : files.values()) {
	                if (multipartFile == null || multipartFile.isEmpty()) {
	                    continue;
	                }

	                String original = multipartFile.getOriginalFilename();
	                if (original == null) {
	                    original = "file";
	                }

	                original = new File(original).getName();

	                int dot = original.lastIndexOf(".");
	                String ext = dot >= 0 ? original.substring(dot) : "";
	                String baseName = dot >= 0 ? original.substring(0, dot) : original;

	                baseName = baseName.replaceAll("[^a-zA-Z0-9_-]", "");
	                if (baseName.isEmpty()) {
	                    baseName = "file";
	                }

	                String storedFileName = i + "_" + baseName + ext;

	                File storeFile = new File(parentDirectory, storedFileName);
	                multipartFile.transferTo(storeFile);

	                String storedPath = CoreConstants.UPLOAD_PATH.replace("\\", "/");
	                if (!storedPath.endsWith("/")) {
	                    storedPath = storedPath + "/";
	                }
	                storedPath = storedPath + moduleFolder + "/" + uniqueId + "/" + storedFileName;
	                storedPath = storedPath.replace("\\", "/");

	                if ("1".equals(appType)) {
	                    treeCuting.setDemandletter(storedPath);
	                } else if ("2".equals(appType)) {
	                    treeCuting.setNoc(storedPath);
	                } else if ("3".equals(appType)) {
	                    treeCuting.setRejectionletter(storedPath);
	                } else if ("4".equals(appType)) {
	                    treeCuting.setPachanamaletter(storedPath);
	                } else if ("5".equals(appType)) {
	                    treeCuting.setCitizenNoc(storedPath);
	                }

	                treeCutingService.saveTreeCutingForm(treeCuting);

	                RTIApplication rts = rtiApplicationService.get(treeCuting.getRti_ref_id());
	                if ("1".equals(appType)) {
	                    rts.setDemandletter(storedPath);
	                } else if ("2".equals(appType)) {
	                    rts.setNoc(storedPath);
	                } else if ("3".equals(appType)) {
	                    rts.setRejectionletter(storedPath);
	                } else if ("4".equals(appType)) {
	                    rts.setPlantationletter(storedPath);
	                } else if ("5".equals(appType)) {
	                    rts.setCitizenNoc(storedPath);
	                }

	                rtiApplicationService.save(rts);

	                savedCount++;
	                break;
	            }

	            if (savedCount == 0) {
	                json.put("status", false);
	                json.put("message", "No file was received by the server.");
	            } else {
	                json.put("status", true);
	                json.put("savedCount", savedCount);
	            }
	        }

	    } catch (Exception ex) {
	        json.put("status", false);
	        json.put("message", ex.getMessage() != null ? ex.getMessage() : "Upload failed");
	        log.error("uploadmanagetreecutting failed", ex);
	    } finally {
	        pw.print(json.toString());
	        pw.flush();
	        pw.close();
	    }
	}

	@RequestMapping("/rtsapplication/uploadsManageTree.do")
	public void uploadManageTree(HttpServletRequest request, HttpServletResponse response)
	        throws IOException {

	    JSONObject json = new JSONObject();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();

	    try {
	        String appType = request.getParameter("appType");
	        String uniqueId = request.getParameter("UID");

	        if (uniqueId != null) {
	            uniqueId = uniqueId.trim();
	        }

	        if (uniqueId == null || uniqueId.isEmpty()) {
	            json.put("status", false);
	            json.put("message", "Invalid UID");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        if (appType == null || appType.trim().isEmpty()) {
	            json.put("status", false);
	            json.put("message", "Missing appType");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        Long id;
	        try {
	            id = Long.parseLong(uniqueId);
	        } catch (NumberFormatException nfe) {
	            json.put("status", false);
	            json.put("message", "Invalid UID format");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        // ✅ Use Spring's already-parsed multipart request instead of re-parsing manually
	        if (!(request instanceof MultipartHttpServletRequest)) {
	            json.put("status", false);
	            json.put("message", "Request is not multipart");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

	        String moduleFolder;
	        if ("1".equals(appType)) {
	            moduleFolder = "plantationletter";
	        } else if ("2".equals(appType)) {
	            moduleFolder = "siteVisit";
	        } else if ("3".equals(appType)) {
	            moduleFolder = "hearingNotice";
	        } else {
	            json.put("status", false);
	            json.put("message", "Invalid appType");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        // ✅ Fixed: File.separator was missing between UPLOAD_PATH and "TreeCuttingUploads"
	        String baseDir = CoreConstants.UPLOAD_PATH + File.separator
	                + "TreeCuttingUploads" + File.separator
	                + moduleFolder + File.separator + uniqueId;

	        File dir = new File(baseDir);
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }

	        TreeCuting tree = treeCutingService.get(id);
	        if (tree == null) {
	            json.put("status", false);
	            json.put("message", "Tree cutting record not found for UID: " + uniqueId);
	            out.print(json);
	            out.flush();
	            return;
	        }

	        // ✅ Pull the first non-empty uploaded file (front-end always sends one file field)
	        MultipartFile multipartFile = null;
	        for (MultipartFile mf : multipartRequest.getFileMap().values()) {
	            if (mf != null && !mf.isEmpty()) {
	                multipartFile = mf;
	                break;
	            }
	        }

	        if (multipartFile == null) {
	            json.put("status", false);
	            json.put("message", "No file was received by the server.");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        String originalName = multipartFile.getOriginalFilename();
	        if (originalName == null) {
	            originalName = "file.pdf";
	        }
	        originalName = new File(originalName).getName();

	        // 🔒 Only PDF
	        if (!originalName.toLowerCase().endsWith(".pdf")) {
	            json.put("status", false);
	            json.put("message", "Only PDF allowed");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        // 🔒 Double extension check
	        if (originalName.substring(0, originalName.lastIndexOf(".")).contains(".")) {
	            json.put("status", false);
	            json.put("message", "Invalid file (double extension not allowed)");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        // ✅ Clean filename
	        String fileName = originalName.replaceAll("[^a-zA-Z0-9.]", "");
	        String storedFileName = System.currentTimeMillis() + "_" + fileName;

	        File storeFile = new File(dir, storedFileName);
	        multipartFile.transferTo(storeFile);

	        // ✅ Fixed: normalize stored path to forward slashes so getPdf.do/docDownload works
	        // consistently with the rest of the app (same convention as uploadsmanagetreecutting)
	        String storedPath = CoreConstants.UPLOAD_PATH.replace("\\", "/");
	        if (!storedPath.endsWith("/")) {
	            storedPath = storedPath + "/";
	        }
	        storedPath = storedPath + "TreeCuttingUploads/" + moduleFolder + "/" + uniqueId + "/" + storedFileName;
	        storedPath = storedPath.replace("\\", "/");

	        // ✅ Save to DB
	        if ("1".equals(appType)) {
	            tree.setPlantationletter(storedPath);
	        } else if ("2".equals(appType)) {
	            tree.setSiteVisit(storedPath);
	        } else if ("3".equals(appType)) {
	            tree.setHearingNotice(storedPath);
	        }

	        treeCutingService.saveTreeCutingForm(tree);

	        json.put("status", true);
	        json.put("message", "File uploaded successfully");
	        json.put("path", storedPath);

	    } catch (Exception e) {
	        log.error("uploadManageTree failed", e);
	        json.put("status", false);
	        json.put("message", e.getMessage() != null ? e.getMessage() : "Upload failed");
	    } finally {
	        out.print(json);
	        out.flush();
	    }
	}


	@RequestMapping("/rtsapplication/uploadsManageTreeService.do")
	public void uploadsManageTreeService(HttpServletRequest request, HttpServletResponse response)
	        throws IOException {

	    JSONObject json = new JSONObject();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();

	    try {
	        String appType = request.getParameter("appType");
	        String uniqueId = request.getParameter("UID");

	        if (uniqueId != null) {
	            uniqueId = uniqueId.trim();
	        }

	        if (uniqueId == null || uniqueId.isEmpty()) {
	            json.put("status", false);
	            json.put("message", "Invalid UID");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        if (appType == null || appType.trim().isEmpty()) {
	            json.put("status", false);
	            json.put("message", "Missing appType");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        Long id;
	        try {
	            id = Long.parseLong(uniqueId);
	        } catch (NumberFormatException nfe) {
	            json.put("status", false);
	            json.put("message", "Invalid UID format");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        // ✅ Use Spring's already-parsed multipart request instead of re-parsing manually
	        if (!(request instanceof MultipartHttpServletRequest)) {
	            json.put("status", false);
	            json.put("message", "Request is not multipart");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

	        String moduleFolder;
	        if ("1".equals(appType)) {
	            moduleFolder = "publicNotice";
	        } else if ("2".equals(appType)) {
	            moduleFolder = "advertisementNotice";
	        } else {
	            json.put("status", false);
	            json.put("message", "Invalid appType");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        // ✅ Fixed: File.separator was missing between UPLOAD_PATH and "TreeCuttingUploads"
	        String baseDir = CoreConstants.UPLOAD_PATH + File.separator
	                + "TreeCuttingUploads" + File.separator
	                + moduleFolder + File.separator + uniqueId;

	        File dir = new File(baseDir);
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }

	        TreeCuting tree = treeCutingService.get(id);
	        if (tree == null) {
	            json.put("status", false);
	            json.put("message", "Tree cutting record not found for UID: " + uniqueId);
	            out.print(json);
	            out.flush();
	            return;
	        }

	        // ✅ Pull the first non-empty uploaded file (front-end always sends one file field)
	        MultipartFile multipartFile = null;
	        for (MultipartFile mf : multipartRequest.getFileMap().values()) {
	            if (mf != null && !mf.isEmpty()) {
	                multipartFile = mf;
	                break;
	            }
	        }

	        if (multipartFile == null) {
	            json.put("status", false);
	            json.put("message", "No file was received by the server.");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        String originalName = multipartFile.getOriginalFilename();
	        if (originalName == null) {
	            originalName = "file.pdf";
	        }
	        originalName = new File(originalName).getName();

	        // 🔒 Only PDF
	        if (!originalName.toLowerCase().endsWith(".pdf")) {
	            json.put("status", false);
	            json.put("message", "Only PDF allowed");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        // 🔒 Double extension check
	        if (originalName.substring(0, originalName.lastIndexOf(".")).contains(".")) {
	            json.put("status", false);
	            json.put("message", "Invalid file (double extension not allowed)");
	            out.print(json);
	            out.flush();
	            return;
	        }

	        // ✅ Clean filename
	        String fileName = originalName.replaceAll("[^a-zA-Z0-9.]", "");
	        String storedFileName = System.currentTimeMillis() + "_" + fileName;

	        File storeFile = new File(dir, storedFileName);
	        multipartFile.transferTo(storeFile);

	        // ✅ Fixed: normalize stored path to forward slashes so getPdf.do/docDownload works
	        // consistently with the rest of the app (same convention as uploadsmanagetreecutting)
	        String storedPath = CoreConstants.UPLOAD_PATH.replace("\\", "/");
	        if (!storedPath.endsWith("/")) {
	            storedPath = storedPath + "/";
	        }
	        storedPath = storedPath + "TreeCuttingUploads/" + moduleFolder + "/" + uniqueId + "/" + storedFileName;
	        storedPath = storedPath.replace("\\", "/");

	        // ✅ Save to DB
	        if ("1".equals(appType)) {
	            tree.setPublicNotice(storedPath);
	        } else if ("2".equals(appType)) {
	            tree.setAdvertisementNotice(storedPath);
	        }

	        treeCutingService.saveTreeCutingForm(tree);

	        json.put("status", true);
	        json.put("message", "File uploaded successfully");
	        json.put("path", storedPath);

	    } catch (Exception e) {
	        log.error("uploadsManageTreeService failed", e);
	        json.put("status", false);
	        json.put("message", e.getMessage() != null ? e.getMessage() : "Upload failed");
	    } finally {
	        out.print(json);
	        out.flush();
	    }
	}
	
	@RequestMapping("/rtiapplication/uploadCuttingCertificateDocs.do")
	public void uploadCFCLicenseDocs(HttpServletRequest request, HttpServletResponse response) throws IOException {

		JSONObject json = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		RTIApplication rtiApplication = null;
		String[] name = new String[12];
		String idName = "";
		String appType = request.getParameter("appType");
		String uniqueId = request.getParameter("UID");
		String baseDirForAttr = null;

		try {

			if (appType == null || appType.trim().isEmpty()) {
				json.put("status", false);
				json.put("message", "Missing appType");
				return;
			}

			if (uniqueId == null || uniqueId.trim().isEmpty()) {
				json.put("status", false);
				json.put("message", "Invalid UID");
				return;
			}

			Long rtiId;
			try {
				rtiId = Long.parseLong(uniqueId);
			} catch (NumberFormatException nfe) {
				json.put("status", false);
				json.put("message", "Invalid UID format");
				return;
			}

			// ✅ Use Spring's already-parsed multipart request instead of re-parsing manually
			if (!(request instanceof MultipartHttpServletRequest)) {
				json.put("status", false);
				json.put("message", "Request is not multipart");
				return;
			}

			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

			String baseDir;
			if ("1".equals(appType)) {
				baseDir = CoreConstants.UPLOAD_PATH + "CertificateUpload/";
			} else {
				baseDir = CoreConstants.UPLOAD_PATH + "Uploads/" + appType + "/";
			}

			baseDir = baseDir + uniqueId + File.separator;
			baseDirForAttr = baseDir;

			File dir = new File(baseDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			rtiApplication = rtiApplicationService.get(rtiId);
			if (rtiApplication == null) {
				json.put("status", false);
				json.put("message", "RTI application not found for UID: " + uniqueId);
				return;
			}

			int i = 0;
			String lastHttpPath = null;

			// ✅ Only iterate actual uploaded files (skips any stray form fields safely)
			for (Map.Entry<String, MultipartFile> entry : multipartRequest.getFileMap().entrySet()) {
				MultipartFile multipartFile = entry.getValue();
				if (multipartFile == null || multipartFile.isEmpty()) {
					continue;
				}

				String originalName = multipartFile.getOriginalFilename();
				if (originalName == null) {
					originalName = "file";
				}
				originalName = new File(originalName).getName();

				int l = originalName.lastIndexOf(".");
				String imageext = l >= 0 ? originalName.substring(l) : "";
				String fileNameNoExt = l >= 0 ? originalName.substring(0, l) : originalName;
				fileNameNoExt = fileNameNoExt.replaceAll("\\W", "");
				String fileName = fileNameNoExt + imageext;

				name[i] = multipartFile.getOriginalFilename();

				String filePath = baseDir + i + fileName;
				File storeFile = new File(filePath);
				File parentDirectory = storeFile.getParentFile();
				if (!parentDirectory.exists()) {
					parentDirectory.mkdirs();
				}

				multipartFile.transferTo(storeFile);

				String url = CoreConstants.UPLOAD_PATH;
				String httppath = url + "CertificateUpload/" + uniqueId + File.separator + i + fileName;

				rtiApplication.setPdfFilesSavedPath(httppath);
				rtiApplication = rtiApplicationService.merge(rtiApplication);
				lastHttpPath = httppath;

				i++;
				if (i >= name.length) {
					break; // safety: don't overflow the fixed-size name[] array
				}
			}

			if (i == 0) {
				json.put("status", false);
				json.put("message", "No file was received by the server.");
				return;
			}

			json.put("status", true);
			json.put("message", "Upload has been done successfully!");
			json.put("savedCount", i);
			json.put("path", lastHttpPath);

		} catch (Exception ex) {
			log.error("uploadCFCLicenseDocs failed", ex);
			json.put("status", false);
			json.put("message", "There was an error: " + (ex.getMessage() != null ? ex.getMessage() : "Upload failed"));
		} finally {
			out.print(json);
			out.flush();

			request.setAttribute("fileName", name);
			request.setAttribute("idName", idName);
			request.setAttribute("appType", appType);
			if (baseDirForAttr != null) {
				request.setAttribute("filePath", new File(baseDirForAttr).getAbsolutePath());
			}
			request.setAttribute("SetEncType", false);
			request.setAttribute("serviceId", request.getParameter("serviceId"));
		}
	} // for download


}