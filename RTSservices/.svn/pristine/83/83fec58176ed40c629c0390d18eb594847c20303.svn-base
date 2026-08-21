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
import com.mars.rti.model.NurseDetails;
import com.mars.rti.model.NursingHomes;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.SurgeonsDetails;
import com.mars.rti.service.FeesMasterService;
import com.mars.rti.service.NurseDetailsService;
import com.mars.rti.service.NursingHomesService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.SurgeonDetaisService;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class RenewalNursingHomesController{


	@Autowired
	private UserService userservice;
	
	@Autowired
	private FeesMasterController feesMasterController;
	
	private static Log log = LogFactory.getLog(RenewalNursingHomesController.class);
	
	@Autowired
	private NursingHomesService renewalNursingHomesService;
	
	
	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private UserRegistrationService userService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RTIApplicationService rtiApplicationService;
		    
	@Autowired
    private FeesMasterService feesMasterService ;
	
	
	@Autowired
	private NurseDetailsService nurseDetailsService;
	
	@Autowired
	private SurgeonDetaisService surgeonDetaisService;
		
		  @RequestMapping("/rtiapplication/saveRenewalNursingHome.do")
		  public ModelAndView saveRenewalNursingHome(HttpServletRequest request, HttpServletResponse response,NursingHomes renewalNursingHomes) throws ServletException ,Exception 
		  {
			  HttpSession session = request.getSession(true);
				SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

				if (log.isDebugEnabled()) {
					log.debug("Invoking NursingHomeChangesApplication");
				}
				if (log.isDebugEnabled()) {
					log.debug("Invoking NursingHomeChangesApplication");
				}
				String mobileNumber = "";
				RTIApplication retunRti=null;
				double fees=0;
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
					UserRegistrationDetails user = userService.getUserByMobileNo(mobileNumber);
					Object as_status=session.getAttribute("as_status");

					if (renewalNursingHomes != null) {
						renewalNursingHomes.setName(renewalNursingHomes.getName());
						RTIApplication rtiApplication = new RTIApplication();
						
						 fees=feesMasterController.setNursingHomeRenewalFees(renewalNursingHomes.getMaternityPatients(), renewalNursingHomes.getNoBedOPatient());
			                rtiApplication.setApplicationCost(fees);
			                renewalNursingHomes.setFees(fees);

							// Getting Surgeons Details Data

							String[] doctor_name = request.getParameterValues("doctorName");
							String[] doctor_age = request.getParameterValues("doctorAge");
							String[] doctor_education = request.getParameterValues("doctorEducation");
							String[] doctor_reg_no = request.getParameterValues("doctorRegNo");

							String[] nursing_name = request.getParameterValues("nurseName");
							String[] nursing_age = request.getParameterValues("nurseAge");
							String[] nursing_education = request.getParameterValues("nurseEducation");
							String[] nursing_reg_no = request.getParameterValues("nurseRegNo");

						
						rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
						rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
						rtiApplication.setTemplateName("nursingregistration");
						rtiApplication.setSubject("RENEWAL-NURSING-HOME-REGISTRATION");
						rtiApplication.setDepartment("HEALTH-DEPARTMENT");
						rtiApplication.setWorkFlowStatus(0);
						rtiApplication.setFinalStatus("0");
						rtiApplication.setRtiserviceid(95);
						rtiApplication.setApplicantName(renewalNursingHomes.getName());
						if(as_status!=null && user_name==null) {
							rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
							
						}
						rtiApplication.setPhoneNumber(renewalNursingHomes.getPhone());
						rtiApplication.setMobileNumber(renewalNursingHomes.getPhone());
						rtiApplication.setEmail(renewalNursingHomes.getEmail());
						rtiApplication.setZone(renewalNursingHomes.getZoneNo());
						rtiApplication.setUserRegistrationDetails(user);

						rtiApplication.setApplicationCost(renewalNursingHomes.getFees());

						rtiApplication.setPdfUploadFromPortal(renewalNursingHomes.getFilesPath());
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
							rti.setRtiApplnNumber("RTS/HD"  + "/" + savedRti.getRtiApplicationId() + "/" + Year.now());
							renewalNursingHomes.setRtiApplRefNo(rti.getRtiApplnNumber());
							renewalNursingHomes.setRtiRefId(savedRti.getRtiApplicationId());
							long birth_regis_id = renewalNursingHomesService.nursingHomeApplications(renewalNursingHomes);
							rti.setRtiApplicationRefId(birth_regis_id);
							 retunRti = rtiApplicationService.merge(rti);
							 
							 if(renewalNursingHomes.getRenewalNursingHome()!=null && !renewalNursingHomes.getRenewalNursingHome().isEmpty()) {
								   
								 renewalNursingHomes.setRenewalStatus(1);
							 }
							// Saving Child Tables
							 renewalNursingHomes =	renewalNursingHomesService.getNursingHomes(birth_regis_id);

								for (int i = 0; i < nursing_name.length; i++) {

									NurseDetails nd = new NurseDetails();
									if (nursing_age != null) {

										nd.setNurseAge(nursing_age[i]);
									}

									if (nursing_education != null) {
										nd.setNurseEducation(nursing_education[i]);
									}

									if (nursing_name != null) {
										nd.setNurseName(nursing_name[i]);
									}

									if (nursing_reg_no != null) {
										nd.setNurseRegNo(nursing_reg_no[i]);
									}

									if (renewalNursingHomes != null) {

										// Set Nursig home Id and Save
										nd.setNursingHomes(renewalNursingHomes);
										nurseDetailsService.mergeNurseDetails(nd);
									}

								}

								for (int i = 0; i < doctor_name.length; i++) {

									SurgeonsDetails sd = new SurgeonsDetails();
									if (doctor_age != null) {
										sd.setDoctorAge(doctor_age[i]);
									}

									if (doctor_education != null) {
										sd.setDoctorEducation(doctor_education[i]);
									}

									if (doctor_name != null) {

										sd.setDoctorName(doctor_name[i]);
									}

									if (doctor_reg_no != null) {

										sd.setDoctorRegNo(doctor_reg_no[i]);
									}

									if (renewalNursingHomes != null) {

										// Set Nursig home Id and Save
										sd.setNursingHomes(renewalNursingHomes);
				                        surgeonDetaisService.mergeSurgeonDetails(sd);
									}

								}
							String name = renewalNursingHomes.getName();
							String applnNo = rti.getRtiApplnNumber();
							String mobileNo = renewalNursingHomes.getPhone();
							String email=renewalNursingHomes.getEmail();
							SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
						}
						if(as_status!=null && user_name==null) {
							return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());

						}else {
								return new ModelAndView("redirect:/ws/rtsapplication/newRTSNursingHomeRenewalSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());
						}
						
					}
				}

				return new ModelAndView("redirect:/ws/user/login.do");

			}
		
		
			@RequestMapping("ws/rtsapplication/newRTSNursingHomeRenewalSuccess.do")
			public ModelAndView newRTSNursingHomeRenewalSuccess(HttpServletRequest request,HttpServletResponse response) {
				
				String appNo = request.getParameter("rtsAppNo");
				ModelAndView model = new ModelAndView("newRTSNursingHomeRenewalSuccess");
				
				model.addObject("rtsNo",appNo);
				return model;
						
				
			}
			

			@RequestMapping("/rtsapplication/editRenewalNurshingHome.do")
			   public ModelAndView editRenewalNurshingHome(HttpServletRequest request, HttpServletResponse response) throws ServletException ,Exception{ 

			   NursingHomes renewalNursingHomes = null;
				HttpSession session = request.getSession();
				System.out.println(" editMandapPermission");
				long rtiApplicationRefId = 0;
				long rtiApplicationId = 0;
				RTIApplication rtiapplication = null;
				List<NurseDetails> nd =null;
				List<SurgeonsDetails> sd = null;
				SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
				long userId=0;
				if (sessionUser != null) {
					 userId = sessionUser.getUserId();
					 if (request.getParameter("rtiApplicationRefId") != null
						&& request.getParameter("rtiApplicationRefId").length() > 0
						|| session.getAttribute("rtirefId") != null) {
					if (request.getParameter("rtiApplicationRefId") != null
							&& request.getParameter("rtiApplicationRefId").length() > 0) {
						rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
						renewalNursingHomes = renewalNursingHomesService.get(rtiApplicationRefId);
					} else if (session.getAttribute("rtirefId") != null) {
						Object a = session.getAttribute("rtirefId");
						rtiApplicationRefId = (long) a;
						renewalNursingHomes = renewalNursingHomesService.get(rtiApplicationRefId);
					}
					if (renewalNursingHomes.getRtiRefId() > 0) {
						rtiApplicationId = renewalNursingHomes.getRtiRefId();
						rtiapplication = rtiApplicationService.get(rtiApplicationId);
					} else {
						List<RTIApplication> listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
								rtiApplicationRefId);
						if (listRTI != null && !listRTI.isEmpty()) {
							rtiApplicationId = listRTI.get(0).getRtiApplicationId();
							rtiapplication = listRTI.get(0);
						}
					}
					
					nd=renewalNursingHomes.getNd();
					sd=renewalNursingHomes.getSd();
				}
			            request.setAttribute("nurseDetailsList", nd);
			            request.setAttribute("doctorDetailsList", sd);
				request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
				request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_NURSING_REGISTRATION);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_NURSING_REGISTRATION);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
				request.setAttribute("rtiApplication", rtiapplication);

				WorkflowProcessDetails workflowProcessDetails = null;
				WorkflowProcessDetails processDetails = null;
				workflowProcessDetails = workflowProcessDetailsService
						.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_NURSING_REGISTRATION);

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
				User user = userservice.get(userId);
				String userLoginId = user.getUserLevel();
		        if(userLoginId!=null && !userLoginId.isEmpty()) {

				if(userLoginId.equals("L1")) {
					request.setAttribute("forLogin", "L1");
				}else if (userLoginId.equals("L2")) {
					request.setAttribute("forLogin", "L2");
				}else if (userLoginId.equals("L3")) {
					request.setAttribute("forLogin", "L3");
				}else if (userLoginId.equals("L4")) {
					request.setAttribute("forLogin", "L4");
				}
				else
				{
					request.setAttribute("forLogin", "nothing");
				}
				
		        }
				  ModelAndView modelAndView=new ModelAndView("manageRenewalNurshingHome","nursingHomes",renewalNursingHomes);    	
                return modelAndView;
			   }	return new ModelAndView("redirect:/login.do");
}
			
			
			
			@RequestMapping("/rtsapplication/createNursingHomeRenewal.do")
			public ModelAndView createNursingHomeRenewal(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, Exception {
				String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
				long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
				RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

				HttpSession session = request.getSession();
				SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

				WorkflowProcessDetails workflowProcessDetails = null;
				WorkflowProcessDetails processDetails = null;
				workflowProcessDetails = workflowProcessDetailsService
						.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_NURSING_REGISTRATION);

				String id = request.getParameter("id");
				long applicationId = Long.parseLong(id);
				NursingHomes renewalNursingHomes = renewalNursingHomesService.get(applicationId);
				String email = renewalNursingHomes.getEmail();
				String mobileNo = renewalNursingHomes.getPhone();
				String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
				String applicantName = rtiApplication.getApplicantName();
				long rtirefId = rtiApplication.getRtiApplicationRefId();

				if (renewalNursingHomes != null) {
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
							renewalNursingHomes.setCertificateIssuedDate(CommonUtils.getCurrentStringDateAndTime());
							renewalNursingHomes.setRenewalDate(CommonUtils.getNursingHomeCurrentStringDateAndTime());
							renewalNursingHomesService.saveNursingHome(renewalNursingHomes);
							rtiApplication.setWorkFlowStatus(1);
							rtiApplicationService.save(rtiApplication);
							SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

							request.setAttribute("workFlowCompleted", "1");
						} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
							 if(renewalNursingHomes.getRenewalNursingHome()!=null && !renewalNursingHomes.getRenewalNursingHome().isEmpty()) {
								   
								 renewalNursingHomes.setRenewalStatus(0);
							 }
							 renewalNursingHomes = renewalNursingHomesService.merge(renewalNursingHomes);
							rtiApplication.setWorkFlowStatus(5);
							rtiApplicationService.save(rtiApplication);
							SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

							request.setAttribute("workFlowCompleted", "1");
						}
					} else {
						if(renewalNursingHomes.getRenewalNursingHome()!=null && !renewalNursingHomes.getRenewalNursingHome().isEmpty()) {
							   
							 renewalNursingHomes.setRenewalStatus(0);
						 }
						 renewalNursingHomes = renewalNursingHomesService.merge(renewalNursingHomes);
						session.setAttribute("rejected", 5);
						rtiApplication.setWorkFlowStatus(5);
						rtiApplicationService.save(rtiApplication);
						SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

						request.setAttribute("workFlowCompleted", "1");

					}

				}

				request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
				request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_NURSING_REGISTRATION);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_NURSING_REGISTRATION);
				request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
				request.setAttribute("rtiApplication", rtiApplication);
				request.setAttribute("rtiApplicationRefId", rtiApplicationId);
				session.setAttribute("rtirefId", rtirefId);
				return new ModelAndView("redirect:/rtsapplication/editRenewalNurshingHome.do");
			}
}

	
	
	
	


