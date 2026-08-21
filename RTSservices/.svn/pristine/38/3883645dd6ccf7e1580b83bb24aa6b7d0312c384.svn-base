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
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.DogDetails;
import com.mars.rti.model.DogLicenseCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.DogDetailsService;
import com.mars.rti.service.DogLicenceCertificateService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.DeathRegistrationRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class DogLicenceCertificateController extends MultiActionController implements InitializingBean {

	@Autowired
	private DogLicenceCertificateService dogLicenceCertificateService;

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private UserRegistrationService userService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private DogDetailsService dogDetailsService;
	
	@Autowired
	private FeesMasterController feesMasterController;

	private static Log log = LogFactory.getLog(DogLicenceCertificateController.class);

	@RequestMapping("/rtiapplication/saveDogLicenceCertificate.do")
	public ModelAndView saveDogLicenceCertificate(HttpServletRequest request, HttpServletResponse response,
			DogLicenseCertificate dogLicenseCertificate) throws ServletException, Exception {
		long total = 0;
		RTIApplication retunRti=null;
		List<String> operatedList = new ArrayList<>();
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		String[] dogType = request.getParameterValues("dogType");
		String[] dogSubType = request.getParameterValues("dogSubType");
		String[] dogName = request.getParameterValues("dogName");
		String[] gender = request.getParameterValues("gender");
		String[] dogAge = request.getParameterValues("dogAge");
		String[] dogColor = request.getParameterValues("dogColor");
		String[] dogHeight = request.getParameterValues("dogHeight");
		String[] dogTailLength = request.getParameterValues("dogTailLength");
		String[] amount = request.getParameterValues("amount");
		String[] firstDoseDate = request.getParameterValues("firstDoseDate");
		String[] secondDoseDate = request.getParameterValues("secondDoseDate");
		String[] batchNo = request.getParameterValues("batchNo");
		String[] vaccineName = request.getParameterValues("vaccineName");
		String[] surgeonName = request.getParameterValues("surgeonName");
		String[] operated = request.getParameterValues("operated");
		String[] designation = request.getParameterValues("designation");
		String[] dogImages = request.getParameter("dogImagefiles").split(",");
		System.out.println();

//		for (int i = 0; i < amount.length; i++) {
//
//			total = total + Long.parseLong(amount[i]);
//		}

//		   List<String> dogTypeList= Arrays.asList(dogType);
//		   List<String> dogSubTypeList= Arrays.asList(dogSubType);
//		   List<String> dogNameList= Arrays.asList(dogName);
//		   List<String>genderList= Arrays.asList(gender);
//		   List<String> dogAgeList= Arrays.asList(dogAge);
//		   List<String>dogColorList= Arrays.asList(dogColor);
//		   List<String> dogHeightList= Arrays.asList(dogHeight);
//		   List<String> dogTailLengthList= Arrays.asList(dogTailLength);
//		   List<String> amountList= Arrays.asList(amount);
//		   List<String> firstDoseDateList= Arrays.asList(firstDoseDate);
//		   List<String> secondDoseDateList= Arrays.asList(secondDoseDate);
//		   List<String> batchNoList= Arrays.asList(batchNo);
//		   List<String> vaccineNameList= Arrays.asList(vaccineName);
//		   List<String> surgeonNameList= Arrays.asList(surgeonName);
//		   List<String> designationList= Arrays.asList(designation);
//		   if(operated.length>0) {
//		    operatedList= Arrays.asList(operated);
//		   }

		List<DogDetails> dogList = new ArrayList<>();
//			long userId = sessionUser.getUserId();
//			User user=userService.get(sessionUser.getUserId());
		String mobileNumber = "";
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

			if (dogLicenseCertificate != null) {

				// String fullName =
				// dogLicenseCertificate.getFirstName()+dogLicenseCertificate.getMiddleName()+dogLicenseCertificate.getLastName();

				RTIApplication rtiApplication = new RTIApplication();
				DeathRegistrationRestDTO deathRegistrationRestDTO = new DeathRegistrationRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setTemplateName("dogLicense");
				rtiApplication.setSubject("DOGLICENCE-CERTIFICATE");
				rtiApplication.setDepartment("SOLIDWASTE-DEPARTMENT");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(3);
				rtiApplication.setPdfUploadFromPortal(dogLicenseCertificate.getFilesPath());
				rtiApplication.setApplicantName(dogLicenseCertificate.getName());
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
				}
				rtiApplication.setPhoneNumber(dogLicenseCertificate.getMobileNumber());
				rtiApplication.setMobileNumber(dogLicenseCertificate.getMobileNumber());
				rtiApplication.setEmail(dogLicenseCertificate.getEmailId());
				rtiApplication.setZone(dogLicenseCertificate.getZoneNo());
				// rtiApplication.setWard_name(birthRegistrationRestDTO.getZone_name());
				rtiApplication.setUserRegistrationDetails(user);

				rtiApplication.setApplicationCost(feesMasterController.setDogLicenseFeesApplicable(dogType, operated,3));
				

				// rtiApplication.setTenancy("1");
				// rtiApplication.setRtiApplnNumber("RTI/2022/BIRTH");

				// rtiApplication.setApplicantName(deathRegistrationRestDTO.getApplicantName());
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

				// birthRegistrationService.getBirthRegistrationList(rTIApplicationSearch);

				// if(deathCertificateService.deathRegistrationCertificate(deathCertificate){

				if (savedRti.getRtiApplicationId() > 0) {
					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/SWM"+"/" + savedRti.getRtiApplicationId() +"/"+Year.now());
					dogLicenseCertificate.setRtiapplrefno(rti.getRtiApplnNumber());
					dogLicenseCertificate.setRti_ref_id(savedRti.getRtiApplicationId());
					// dogLicenseCertificate.setDogFiles(dogLicenseCertificate.getDogFiles());
					// DogDetails dogDetails=dogLicenseCertificate.getDogDetails();
					// DogDetails
					// dogDetails=dogLicenceCertificateService.merge(dogLicenseCertificate.getDogDetails());
					// dogLicenseCertificate.setDogDetails(dogDetails);

					// DogDetails dogdetails = new DogDetails();

					// dogDetails.
					// dogLicenseCertificate.setDogDetails(null)

					// dogLicenseCertificate.getDogDetails();

					// dogDetails.setBatchNo(METHOD_GET)

					// dogDetails.setAmount(dogdetails.getAmount());
					// dogDetails.setBatchNo(dogdetails.getBatchNo());

					// dogList=dogLicenseCertificate.getDogDetails();

					// dogLicenseCertificate.setDogDetails(dogList);

					long dogId = dogLicenceCertificateService.saveDogLicenceCertificate(dogLicenseCertificate);
					dogLicenseCertificate.setDogId(dogId);
					// long
					// dogId1=dogLicenceCertificateService.saveDogLicenceCertificate(dogLicenseCertificate);

					rti.setRtiApplicationRefId(dogId);
					// rti.setRtiApplicationRefId(birthRegistrationService.);
					 retunRti = rtiApplicationService.merge(rti);

					for (int i = 0; i < dogType.length; i++) {
						DogDetails dogDetails = new DogDetails();
						if (amount != null)
							dogDetails.setAmount(Double.parseDouble(amount[i]));
						if (dogType != null)
							dogDetails.setDogType(dogType[i]);
						if (dogSubType != null)
							dogDetails.setDogSubType(dogSubType[i]);
						if (dogName != null)
							dogDetails.setDogName(dogName[i]);
						if (gender != null)
							dogDetails.setGender(gender[i]);
						if (dogAge != null)
							dogDetails.setDogAge(dogAge[i]);
						if (dogColor != null)
							dogDetails.setDogColor(dogColor[i]);
						if (dogHeight != null)
							dogDetails.setDogHeight(Long.parseLong(dogHeight[i]));
						if (dogTailLength != null)
							dogDetails.setDogTailLength(Long.parseLong(dogTailLength[i]));
						if (firstDoseDate != null)
							dogDetails.setFirstDoseDate(firstDoseDate[i]);
						if (secondDoseDate != null)
							dogDetails.setSecondDoseDate(secondDoseDate[i]);
						if (batchNo != null)
							dogDetails.setBatchNo(batchNo[i]);
						if (vaccineName != null)
							dogDetails.setVaccineName(vaccineName[i]);
						if (designation != null)
							dogDetails.setDesignation(designation[i]);
						if (surgeonName != null)
							dogDetails.setSurgeonName(surgeonName[i]);
						if(dogImages!=null)
							dogDetails.setDogImagefiles(dogImages[i]);
						if (operated != null) {
							dogDetails.setOperated(operated[i]);
						} else {
							dogDetails.setOperated("");
						}
						if (dogLicenseCertificate != null)
							dogDetails.setDogLicenseCertificate(dogLicenseCertificate);
						// dogDetails.setDogLicenseCertificate(dogLicenseCertificate.getDogId());
						// dogDetails.setDogLicenseCertificate(dogLicenseCertificate);
						dogDetailsService.saveDogDetails(dogDetails);
						// dogList.add(dogDetails);

					}

//					if((retunRti!=null) && (dogId>0)){
//						deathRegistrationRestDTO.setResponseStatus("Requested data saved successfully");
//						deathRegistrationRestDTO.setResponse(retunRti.getRtiApplicationId());
//						deathRegistrationRestDTO.setResult(retunRti.getRtiApplnNumber());
//					}

					String name = dogLicenseCertificate.getFirstName() + " "+dogLicenseCertificate.getMiddleName()
							+" "+ dogLicenseCertificate.getLastName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = dogLicenseCertificate.getMobileNumber();
					String email=dogLicenseCertificate.getEmailId();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
				}
//				ModelAndView modelAndView = new ModelAndView("newRTIDogLicenceSuccess", "dogLicenseCertificate",
//						dogLicenseCertificate);
//				return modelAndView;
				if(as_status!=null && user_name==null) {
					return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

				}else {
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSDogLicenseSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());
				}
				
			}
		}
		return new ModelAndView("redirect:/ws/user/login.do");

	}
	
	
	@RequestMapping("ws/rtsapplication/newRtSDogLicenseSuccess.do")
	public ModelAndView newRtSDogLicenseSuccess(HttpServletRequest request,HttpServletResponse response) {
		
		String appNo = request.getParameter("rtsAppNo");
		ModelAndView model = new ModelAndView("newRTIDogLicenceSuccess");
		
		model.addObject("dogLicenseCertificate",appNo);
		return model;
				
		
	}

	@RequestMapping("/rtiapplication/editDogLicenseCertificate.do")
	public ModelAndView editDogLicenseCertificate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		HttpSession session = request.getSession();
		System.out.println("hiiii editDogLicenseCertificate");
		long rtiApplicationRefId = 0;
		DogLicenseCertificate dogLicenseCertificate = null;
		List<DogDetails> dogDetailsList = new ArrayList<>();

		long dogid = 0;
		long rtiApplicationId = 0;
		// DeathRegistration deathRegistration=null;
		RTIApplication rtiApplication = null;
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0
				|| session.getAttribute("rtirefId") != null) {
			if (request.getParameter("rtiApplicationRefId") != null
					&& request.getParameter("rtiApplicationRefId").length() > 0) {
				rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
				dogLicenseCertificate = dogLicenceCertificateService.get(rtiApplicationRefId);
				dogDetailsList = dogLicenseCertificate.getDogDetails();
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				dogLicenseCertificate = dogLicenceCertificateService.get(rtiApplicationRefId);
				dogDetailsList = dogLicenseCertificate.getDogDetails();
			}
			if (dogLicenseCertificate.getRti_ref_id() > 0) {
				rtiApplicationId = dogLicenseCertificate.getRti_ref_id();
				rtiApplication = rtiApplicationService.get(rtiApplicationId);
			} else {
				List<RTIApplication> listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
						rtiApplicationRefId);
				if (listRTI != null && !listRTI.isEmpty()) {
					rtiApplicationId = listRTI.get(0).getRtiApplicationId();
					rtiApplication = listRTI.get(0);
				}
			}
		}
		// zone
//			 String strSql2="select zone_id,name from egovrti.zone  ";
//			  List<ArrayList> zonelist = rtiApplicationService.getListBySQLQuery(strSql2, null);
//			  List<Zone> newzonelist=new ArrayList<>();
//			 for (int i = 0; i < zonelist.size(); i++){
//			 Zone zone= new Zone();
//			 zone.setZoneId( Long.parseLong(zonelist.get(i).get(0).toString()));
//			 zone.setName(zonelist.get(i).get(1).toString());
//			 newzonelist.add(zone);
//			 }
//				 request.setAttribute("zonelist",newzonelist);

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_DOG_LICENSE_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_DOG_LICENSE_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(
				rtiApplicationId, CoreConstants.RTI_DOG_LICENSE_WORKFLOW_ENTITY);

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
		// CommonUtils.setUploadDocsOnEditMode(request,getServletContext(),"dogLicense",rtiApplication);

		ModelAndView modelAndView = new ModelAndView("manageDogLicense");
//	   	  modelAndView.addObject("dogLicenseCertificate", dogLicenseCertificate);
//	   	   modelAndView.addObject("dogDetailsList", dogDetailsList);
		request.setAttribute("dogLicenseCertificate", dogLicenseCertificate);
		request.setAttribute("dogDetailsList", dogDetailsList);

		return modelAndView;

	}

	@RequestMapping("/rtiapplication/createDogLicenceCertificateWork.do")
	public ModelAndView createDogLicenceCertificateWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(
				rtiApplicationId, CoreConstants.RTI_DOG_LICENSE_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		DogLicenseCertificate dogLicenseCertificate = dogLicenceCertificateService.get(applicationId);
		String email = dogLicenseCertificate.getEmailId();
		String mobileNo = dogLicenseCertificate.getMobileNumber();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		if (dogLicenseCertificate != null) {
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

					if (rtiApplication.getApplicationCost() == 0 || rtiApplication.getApplicationCost() == 0.0) {
						rtiApplication.setWorkFlowStatus(2);
						rtiApplicationService.save(rtiApplication);
					} else {

						 rtiApplication.setWorkFlowStatus(3);
							rtiApplicationService.save(rtiApplication);
							SendSMSEmailController.sendPayment(applicantName, mobileNo, rtiApplnNumber, email);

					}
					if (request.getParameter("WORKFLOW_TRANSISTION").isEmpty()
							|| request.getParameter("WORKFLOW_TRANSISTION") == null) {

					}
					if (task != null && sessionUser.getUserName().equals(task.getAssignee())) {
						request.setAttribute("userAccess", 1);
						request.setAttribute("workFlowTask", task);
					}
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Close-Application")) {

					rtiApplication.setWorkFlowStatus(1);
					//Renewal Code
					dogLicenseCertificate.setCertificate_issued(CommonUtils.getCurrentStringDateAndTime());
					dogLicenceCertificateService.saveDogLicenceCertificate(dogLicenseCertificate);
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
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_DOG_LICENSE_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_DOG_LICENSE_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView("redirect:/rtiapplication/editDogLicenseCertificate.do");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

}
