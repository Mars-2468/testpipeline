package com.mars.rti.controller;

import com.mars.common.model.User;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.AnaesthetistDetails;
import com.mars.rti.model.MTPAssistantDetails;
import com.mars.rti.model.MTPBloodBankDetails;
import com.mars.rti.model.MTPDetails;
import com.mars.rti.model.MTPNurseDetails;
import com.mars.rti.model.MTPRegistrationCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.MTPRegistrationCertificateService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

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

@Controller
public class MTPRegistrationCertificateController {
   private static Log log = LogFactory.getLog(MTPRegistrationCertificateController.class);
   @Autowired
   private MTPRegistrationCertificateService mTPRegistrationCertificateService;
   @Autowired
   private WorkflowProcessDetailsService workflowProcessDetailsService;
   @Autowired
   private UserService userService;
   @Autowired
   private WorkflowService workflowService;
   @Autowired
   private TaskService taskService;
   @Autowired
   private UserRegistrationService userRegistrationService;
   @Autowired
   private RTIApplicationService rtiApplicationService;

   @RequestMapping({"/rtiapplication/saveMTPRegistrationCertificate.do"})
   public ModelAndView saveMTPRegistrationCertificate(HttpServletRequest request, HttpServletResponse response, MTPRegistrationCertificate mTPRegistrationCertificate) throws ServletException, Exception {
      HttpSession session = request.getSession(true);
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      if (log.isDebugEnabled()) {
         log.debug("Invoking MTPChangesApplication");
      }
      String user_name=null;
		Object user_login= request.getSession().getAttribute("name");
		if(user_login!=null) {
			 user_name = (String)user_login;
		}
      String mobileNumber = (String)session.getAttribute("mobileNo");
      if (mobileNumber != null) {
         UserRegistrationDetails user = this.userRegistrationService.getUserByMobileNo(mobileNumber);
			Object as_status=session.getAttribute("as_status");

         if (mTPRegistrationCertificate != null) {
            mTPRegistrationCertificate.setFull_name(mTPRegistrationCertificate.getFull_name());
            RTIApplication rtiApplication = new RTIApplication();
            rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
            rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
            rtiApplication.setTemplateName("mtpRegistrationCertificate");
            rtiApplication.setSubject("MTP-REGISTRATION");
            rtiApplication.setDepartment("HEALTH-DEPARTMENT");
            rtiApplication.setWorkFlowStatus(0);
            rtiApplication.setFinalStatus("0");
            rtiApplication.setRtiserviceid(97);
            rtiApplication.setApplicantName(mTPRegistrationCertificate.getFull_name());
            if(as_status!=null && user_name==null) {
				rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
				
			}
            rtiApplication.setPhoneNumber(mTPRegistrationCertificate.getPhoneNumber());
            rtiApplication.setMobileNumber(mTPRegistrationCertificate.getPhoneNumber());
            rtiApplication.setEmail(mTPRegistrationCertificate.getEmail());
            rtiApplication.setUserRegistrationDetails(user);
//            rtiApplication.setApplicationCost(15.0D);
            rtiApplication.setZone(mTPRegistrationCertificate.getZoneNo());
            rtiApplication.setPdfUploadFromPortal(mTPRegistrationCertificate.getFilesPath());
            List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList();
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
            RTIApplication savedRti = this.rtiApplicationService.merge(rtiApplication);
            if (savedRti.getRtiApplicationId() > 0L) {
               RTIApplication rti = this.rtiApplicationService.get(savedRti.getRtiApplicationId());
               rti.setRtiApplnNumber("RTS/HD/" + savedRti.getRtiApplicationId() + "/" + Year.now());
               mTPRegistrationCertificate.setRtiapplrefno(rti.getRtiApplnNumber());
               mTPRegistrationCertificate.setRti_ref_id(savedRti.getRtiApplicationId());
               long birth_regis_id = this.mTPRegistrationCertificateService.MTPCertificate(mTPRegistrationCertificate);
               rti.setRtiApplicationRefId(birth_regis_id);
               RTIApplication retunRti = this.rtiApplicationService.merge(rti);
               mTPRegistrationCertificate = this.mTPRegistrationCertificateService.get(birth_regis_id);
               String[] medicalPractitionerName = request.getParameterValues("medical_practitoner_name");
               String[] medicalPractitionerQualification = request.getParameterValues("medical_practitoner_qualification");
               String[] medicalPractitionerFullPartTime = request.getParameterValues("medical_practitoner_fullparttime");
               String[] medicalPractitionerExperience = request.getParameterValues("medical_practitoner_experience");
               
               String[] mbbs = request.getParameterValues("mbbsPath");//file mbbs paths
               String[] pg = request.getParameterValues("pgPath");//file pg paths
               String[] mmc = request.getParameterValues("mmcPath");//file mmc paths
               String[] marriageCertificate = request.getParameterValues("marriageCertificatePath");//file marriageCertificate paths

               List<MTPDetails> mTPDetailsList = new ArrayList();
               if (medicalPractitionerName != null) {
                  for(int i = 0; i < medicalPractitionerName.length; ++i) {
                     MTPDetails tt = new MTPDetails();
                     if (medicalPractitionerName != null) {
                        tt.setMedical_practitoner_name(medicalPractitionerName[i]);
                     }

                     if (medicalPractitionerQualification != null) {
                        tt.setMedical_practitoner_qualification(medicalPractitionerQualification[i]);
                     }

                     if (medicalPractitionerFullPartTime != null) {
                        tt.setMedical_practitoner_fullparttime(medicalPractitionerFullPartTime[i]);
                     }

                     if (medicalPractitionerExperience != null) {
                        tt.setMedical_practitoner_experience(medicalPractitionerExperience[i]);
                     }
                     
                     if (mbbs != null) {
                         tt.setMbbs(mbbs[i]);//mbbs file path as per row i
                      }
                     
                     if (pg != null) {
                         tt.setPg(pg[i]); //pg file path as per row i
                      }
                     
                     if (mmc != null) {
                         tt.setMmc(mmc[i]); //mmc file path as per row i
                      }
                     
                     if (marriageCertificate != null) {
                         tt.setMarriageCertificate(marriageCertificate[i]); //marriageCertificate file path as per row i
                      }

                     if (mTPRegistrationCertificate != null) {
                        tt.setmTPRegistrationCertificate(mTPRegistrationCertificate);
                        tt.setRti_ref_id(savedRti.getRtiApplicationId());
                        mTPDetailsList.add(tt);
                        this.mTPRegistrationCertificateService.mergeMTPDetailsList(tt);
                     }
                  }
               }

               String[] assistantName = request.getParameterValues("assistantName");
               String[] assistantQualification = request.getParameterValues("assistantQualification");
               String[] assistantFullparttime = request.getParameterValues("assistantFullparttime");
               String[] assistantExperience = request.getParameterValues("assistantExperience");
               
               String[] mbbsCertificate = request.getParameterValues("mbbsCertificatePath"); //file mbbsCertificate paths
               String[] pgCertificate = request.getParameterValues("pgCertificatePath"); //file pgCertificate paths
               String[] mmcCertificate = request.getParameterValues("mmcCertificatePath"); //file mmcCertificate paths

               List<MTPAssistantDetails> mTPAssistantDetails = new ArrayList();
               if (assistantName != null) {
                  for(int m = 0; m < assistantName.length; ++m) {
                     MTPAssistantDetails matt = new MTPAssistantDetails();
                     if (assistantName != null) {
                        matt.setAssistantName(assistantName[m]);
                     }

                     if (assistantQualification != null) {
                        matt.setAssistantQualification(assistantQualification[m]);
                     }

                     if (assistantFullparttime != null) {
                        matt.setAssistantFullparttime(assistantFullparttime[m]);
                     }

                     if (assistantExperience != null) {
                        matt.setAssistantExperience(assistantExperience[m]);
                     }
                     
                     if (mbbsCertificate != null) {
                         matt.setMbbsCertificate(mbbsCertificate[m]); //mbbsCertificate file path as per row m
                      }
                     
                     if (pgCertificate != null) {
                         matt.setPgCertificate(pgCertificate[m]); // pgCertificate file path as per row m
                      }
                     
                     if (mmcCertificate != null) {
                         matt.setMmcCertificate(mmcCertificate[m]);// mmcCertificate file path as per row m
                      }

                     if (mTPRegistrationCertificate != null) {
                        matt.setmTPRegistrationCertificate(mTPRegistrationCertificate);
                        mTPAssistantDetails.add(matt);
                        this.mTPRegistrationCertificateService.mergeMTPAssistantDetailsList(matt);
                     }
                  }
               }

               String[] anaesthetistName = request.getParameterValues("ancName");
               String[] anesthetistMbbs = request.getParameterValues("anesthetistMbbsPath"); //file anesthetistMbbs paths
               String[] anesthetistPG = request.getParameterValues("anesthetistPGPath"); //file anesthetistPG paths
               String[] anesthetistMMC = request.getParameterValues("anesthetistMMCPath"); //file anesthetistMMC paths

               List<AnaesthetistDetails> anaesthetistDetails = new ArrayList();
               if (anaesthetistName != null) {
                  for(int h = 0; h < anaesthetistName.length; ++h) {
                     AnaesthetistDetails ttA = new AnaesthetistDetails();
                     if (anaesthetistName != null) {
                        ttA.setAncName(anaesthetistName[h]);
                     }
                     
                     if (anesthetistMbbs != null) {
                         ttA.setAnesthetistMbbs(anesthetistMbbs[h]); // anesthetistMbbs file path as per row h
                      }

                     if (anesthetistPG != null) {
                         ttA.setAnesthetistPG(anesthetistPG[h]); // anesthetistPG file path as per row h
                      }
                     
                     if (anesthetistMMC != null) {
                         ttA.setAnesthetistMMC(anesthetistMMC[h]); // anesthetistMMC file path as per row h
                      }
                     
                     if (mTPRegistrationCertificate != null) {
                        ttA.setmTPRegistrationCertificate(mTPRegistrationCertificate);
                        anaesthetistDetails.add(ttA);
                        this.mTPRegistrationCertificateService.mergeMTPAnaesthetistDetails(ttA);
                     }
                  }
               }

               String[] nurseName = request.getParameterValues("nursename");
               String[] nurseFullPartTime = request.getParameterValues("nursefullparttime");
               String[] nurseExperience = request.getParameterValues("nurseexperience");
               
               String[] diplomaCerti = request.getParameterValues("diplomaCertiPath");  //file diplomaCerti paths
               String[] validCerti = request.getParameterValues("validCertiPath"); //file validCerti paths

               List<MTPNurseDetails> mTPNurseDetails = new ArrayList();
               if (nurseName != null) {
                  for(int j = 0; j < nurseName.length; ++j) {
                     MTPNurseDetails ttN = new MTPNurseDetails();
                     if (nurseName != null) {
                        ttN.setNursename(nurseName[j]);
                     }

                     if (nurseFullPartTime != null) {
                        ttN.setNursefullparttime(nurseFullPartTime[j]);
                     }

                     if (nurseExperience != null) {
                        ttN.setNurseexperience(nurseExperience[j]);
                     }
                     
                     if (diplomaCerti != null) {
                         ttN.setDiplomaCerti(diplomaCerti[j]); // diplomaCerti file path as per row j
                      }
                     
                     if (validCerti != null) {
                         ttN.setValidCerti(validCerti[j]); // validCerti file path as per row j
                      }

                     if (mTPRegistrationCertificate != null) {
                        ttN.setmTPRegistrationCertificate(mTPRegistrationCertificate);
                        mTPNurseDetails.add(ttN);
                        this.mTPRegistrationCertificateService.mergeMTPNurseDetails(ttN);
                     }
                  }
               }

               String[] bloodBankName = request.getParameterValues("bloodbankName");
               String[] bloodBankRegistrationNumber = request.getParameterValues("bloodbregistrationNumber");
               String[] bloodBankRegistrationValidity = request.getParameterValues("bloodbregistrationValidity");
               String[] bloodBankDistanceFromApprovedPlace = request.getParameterValues("bloodbdistanceFromApprovedPlace");
               String[] bloodBankMobileNum = request.getParameterValues("bloodbmobilenum");
               
               String[] undertaking = request.getParameterValues("undertakingPath");  //file undertaking paths

               List<MTPBloodBankDetails> mTPBloodBankDetails = new ArrayList();
               if (bloodBankName != null) {
                  for(int k = 0; k < bloodBankName.length; ++k) {
                     MTPBloodBankDetails ttb = new MTPBloodBankDetails();
                     if (bloodBankName != null) {
                        ttb.setBloodbankName(bloodBankName[k]);
                     }

                     if (bloodBankRegistrationNumber != null) {
                        ttb.setBloodbregistrationNumber(bloodBankRegistrationNumber[k]);
                     }

                     if (bloodBankRegistrationValidity != null) {
                        ttb.setBloodbregistrationValidity(bloodBankRegistrationValidity[k]);
                     }

                     if (bloodBankDistanceFromApprovedPlace != null) {
                        ttb.setBloodbdistanceFromApprovedPlace(bloodBankDistanceFromApprovedPlace[k]);
                     }

                     if (bloodBankMobileNum != null) {
                        ttb.setBloodbmobilenum(bloodBankMobileNum[k]);
                     }

                     if (undertaking != null) {
                         ttb.setUndertaking(undertaking[k]); // undertaking file path as per row k
                      }

                     if (mTPRegistrationCertificate != null) {
                        ttb.setmTPRegistrationCertificate(mTPRegistrationCertificate);
                        mTPBloodBankDetails.add(ttb);
                        this.mTPRegistrationCertificateService.mergeMTPBloodBankDetails(ttb);
                     }
                  }
               }

               mTPRegistrationCertificate = this.mTPRegistrationCertificateService.merge(mTPRegistrationCertificate);
               String name = mTPRegistrationCertificate.getFull_name();
               String applnNo = rti.getRtiApplnNumber();
               String mobileNo = mTPRegistrationCertificate.getPhoneNumber();
               String email = mTPRegistrationCertificate.getEmail();
               SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
               return new ModelAndView("redirect:/ws/rtsapplication/newRTSMTPRegistrationSuccess.do?rtsAppNo=" + retunRti.getRtiApplnNumber());
            }
         }
      }

      return new ModelAndView("redirect:/ws/user/login.do");
   }

   @RequestMapping({"ws/rtsapplication/newRTSMTPRegistrationSuccess.do"})
   public ModelAndView newRTSMTPRegistrationSuccess(HttpServletRequest request, HttpServletResponse response) {
      String appNo = request.getParameter("rtsAppNo");
      ModelAndView model = new ModelAndView("newRTSNursingHomeSuccess");
      model.addObject("rtsNo", appNo);
      return model;
   }

   @RequestMapping({"/rtsapplication/editMTPRegistrationCertificate.do"})
   public ModelAndView editMTPRegistrationCertificate(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      MTPRegistrationCertificate mTPRegistrationCertificate = null;
      HttpSession session = request.getSession();
      System.out.println(" editMandapPermission");
      long rtiApplicationRefId = 0L;
      long rtiApplicationId = 0L;
      RTIApplication rtiapplication = null;
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      request.getSession().setAttribute("refid", request.getParameter("rtiApplicationRefId"));
      List<MTPDetails> mTPDetailsList = null;
      List<MTPAssistantDetails> mTPAssistantDetails = null;
      List<MTPNurseDetails> mTPNurseDetails = null;
      List<MTPBloodBankDetails> mTPBloodBankDetails = null;
      List<AnaesthetistDetails> anaesthetistDetails = null;
      String a1 = request.getParameter("rtiApplicationRefId");
      if (sessionUser == null) {
         return new ModelAndView("redirect:/login.do");
      } else {
         long userId = sessionUser.getUserId();
         Object a;
         if (request.getParameter("rtiApplicationRefId") != null && request.getParameter("rtiApplicationRefId").length() > 0 || session.getAttribute("rtirefId") != null) {
            if (request.getParameter("rtiApplicationRefId") != null && request.getParameter("rtiApplicationRefId").length() > 0) {
               rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
               mTPRegistrationCertificate = this.mTPRegistrationCertificateService.get(rtiApplicationRefId);
            } else if (session.getAttribute("rtirefId") != null) {
               a = session.getAttribute("rtirefId");
               rtiApplicationRefId = (Long)a;
               mTPRegistrationCertificate = this.mTPRegistrationCertificateService.get(rtiApplicationRefId);
            }

            rtiApplicationId = mTPRegistrationCertificate.getRti_ref_id();
            rtiapplication = this.rtiApplicationService.get(rtiApplicationId);
            if (mTPRegistrationCertificate.getRti_ref_id() > 0L) {
               rtiApplicationId = mTPRegistrationCertificate.getRti_ref_id();
               rtiapplication = this.rtiApplicationService.get(rtiApplicationId);
            } else {
               List<RTIApplication> listRTI = this.rtiApplicationService.findByProperty("rtiApplicationRefId", rtiApplicationRefId);
               if (listRTI != null && !listRTI.isEmpty()) {
                  rtiApplicationId = ((RTIApplication)listRTI.get(0)).getRtiApplicationId();
                  rtiapplication = (RTIApplication)listRTI.get(0);
               }
            }

            mTPDetailsList = mTPRegistrationCertificate.getmTPDetails();
            mTPAssistantDetails = mTPRegistrationCertificate.getmTPAssistantDetails();
            mTPNurseDetails = mTPRegistrationCertificate.getmTPNurseDetails();
            mTPBloodBankDetails = mTPRegistrationCertificate.getmTPBloodBankDetails();
            anaesthetistDetails = mTPRegistrationCertificate.getAnaesthetistDetails();
            request.setAttribute("mTPDetailsList", mTPDetailsList);
            request.setAttribute("mTPAssistantDetails", mTPAssistantDetails);
            request.setAttribute("mTPNurseDetails", mTPNurseDetails);
            request.setAttribute("mTPBloodBankDetails", mTPBloodBankDetails);
            request.setAttribute("anaesthetistDetails", anaesthetistDetails);
         }

         request.setAttribute("workflowRequired", "true");
         request.setAttribute("WORKFLOW_NAME", "mtpRegistrationCertificate");
         request.setAttribute("WORKFLOW_ENTITYNAME", "mtpRegistrationCertificate");
         request.setAttribute("WORKFLOW_ENTITYID", rtiApplicationId);
         request.setAttribute("rtiApplication", rtiapplication);
         a = null;
         WorkflowProcessDetails processDetails = null;
         WorkflowProcessDetails workflowProcessDetails = this.workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, "mtpRegistrationCertificate");
         String userLoginId;
         if (workflowProcessDetails != null) {
            String processId = workflowProcessDetails.getProcessId();
            if (processId != null) {
               processDetails = this.workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId);
            }

            if (!this.workflowService.isProcessEnded(processId)) {
               userLoginId = this.workflowService.getCurrentTaskId(processId);
               Task task = null;
               if (userLoginId != null) {
                  task = this.taskService.getTask(userLoginId);
               }

               if (processDetails != null) {
                  PersonalTask personalTask = new PersonalTask();
                  personalTask.setTask(task);
                  personalTask.setEntityId(processDetails.getEntityId());
                  personalTask.setEntityName(processDetails.getEntityName());
                  personalTask.setWorkflowInitator(processDetails.getUserName());
                  personalTask.setEntityDetails(processDetails.getEntityDetails());
                  request.setAttribute("personalTask", personalTask);
               }

               if (task != null && sessionUser.getUserName().equals(task.getAssignee())) {
                  request.setAttribute("userAccess", 1);
               }

               request.setAttribute("workFlowTask", task);
            } else {
               request.setAttribute("workFlowCompleted", "1");
            }
         }

         User user = this.userService.get(userId);
         userLoginId = user.getUserLevel();
         if (userLoginId != null && !userLoginId.isEmpty()) {
            if (userLoginId.equals("L1")) {
               request.setAttribute("login", "L1");
            } else if (userLoginId.equals("L2")) {
               request.setAttribute("login", "L2");
            } else if (userLoginId.equals("L3")) {
               request.setAttribute("login", "L3");
            } else if (userLoginId.equals("L4")) {
               request.setAttribute("login", "L4");
            }
         }

         request.setAttribute("cellRemark", "cellRemark");
         request.setAttribute("mHORemark", "mHORemark");
         request.setAttribute("uploadedDemand", "uploadedDemand");
         ModelAndView modelAndView = new ModelAndView("manageMTPRegistrationCertificate", "mTPRegistrationCertificate", mTPRegistrationCertificate);
         return modelAndView;
      }
   }

   @RequestMapping({"/rtsapplication/saveMTPRemarks.do"})
   public ModelAndView saveMTPRemarks(HttpServletRequest request, HttpServletResponse response, MTPRegistrationCertificate mTPRegistrationCertificate) throws ServletException, Exception {
      String nodaltocellRemark = request.getParameter("nodaltocellRemark");
      String cellRemark = request.getParameter("cellRemark");
      String mHORemark = request.getParameter("mhoRemark");
      String refid = request.getParameter("mtpId");
      long apprefid = 0L;
      apprefid = Long.parseLong(refid);
      mTPRegistrationCertificate = this.mTPRegistrationCertificateService.get(apprefid);
      if (mTPRegistrationCertificate.getNodaltocellRemark() == null && nodaltocellRemark != null) {
         mTPRegistrationCertificate.setNodaltocellRemark(nodaltocellRemark);
         mTPRegistrationCertificate = this.mTPRegistrationCertificateService.merge(mTPRegistrationCertificate);
      }

      if (mTPRegistrationCertificate.getCellRemark() == null && cellRemark != null) {
         mTPRegistrationCertificate.setCellRemark(cellRemark);
         mTPRegistrationCertificate = this.mTPRegistrationCertificateService.merge(mTPRegistrationCertificate);
      }

      if (mTPRegistrationCertificate.getMhoRemark() == null && mHORemark != null) {
         mTPRegistrationCertificate.setMhoRemark(mHORemark);
         this.mTPRegistrationCertificateService.merge(mTPRegistrationCertificate);
      }

      return new ModelAndView("redirect:/rtsapplication/editMTPRegistrationCertificate.do?rtiApplicationRefId=" + apprefid + "&nodaltocellRemark=" + nodaltocellRemark + "&cellRemark=" + cellRemark + "&mHORemark=" + mHORemark);
   }

   @RequestMapping({"/rtsapplication/createWorkflowMtpregistration.do"})
   public ModelAndView createWorkflowMtpregistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      String rtiApplicationIdString = request.getParameter("WORKFLOW_ENTITYID");
      long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
      RTIApplication rtiApplication = this.rtiApplicationService.get(rtiApplicationId);
      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      WorkflowProcessDetails workflowProcessDetails = null;
      WorkflowProcessDetails processDetails = null;
      workflowProcessDetails = this.workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, "mtpRegistrationCertificate");
      String id = request.getParameter("id");
      long applicationId = Long.parseLong(id);
      MTPRegistrationCertificate nursingHomes = this.mTPRegistrationCertificateService.get(applicationId);
      String email = nursingHomes.getEmail();
      String mobileNo = nursingHomes.getPhoneNumber();
      String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
      String applicantName = rtiApplication.getApplicantName();
      long rtirefId = rtiApplication.getRtiApplicationRefId();
      if (nursingHomes != null) {
         String processId;
         if (workflowProcessDetails != null) {
            processId = workflowProcessDetails.getProcessId();
            if (processId != null) {
               processDetails = this.workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId);
            }

            String workflow_comments;
            if (!this.workflowService.isProcessEnded(processId)) {
               workflow_comments = this.workflowService.getCurrentTaskId(processId);
               Task task = null;
               if (workflow_comments != null) {
                  task = this.taskService.getTask(workflow_comments);
               }

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
               this.rtiApplicationService.save(rtiApplication);
               if (!request.getParameter("WORKFLOW_TRANSISTION").isEmpty()) {
                  request.getParameter("WORKFLOW_TRANSISTION");
               }

               if (task != null && sessionUser.getUserName().equals(task.getAssignee())) {
                  request.setAttribute("userAccess", 1);
                  request.setAttribute("workFlowTask", task);
               }
            } else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Close-Application")) {
               rtiApplication.setWorkFlowStatus(1);
               this.rtiApplicationService.save(rtiApplication);
               SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);
               request.setAttribute("workFlowCompleted", "1");
            } else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
               rtiApplication.setWorkFlowStatus(5);
                workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
				rtiApplication.setWorkflowComments(workflow_comments);

               this.rtiApplicationService.save(rtiApplication);
               SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);
               request.setAttribute("workFlowCompleted", "1");
            }
         } else {
            session.setAttribute("rejected", 5);
            rtiApplication.setWorkFlowStatus(5);
            String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
			rtiApplication.setWorkflowComments(workflow_comments);

			this.rtiApplicationService.save(rtiApplication);
            SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);
            request.setAttribute("workFlowCompleted", "1");
         }
      }

      request.setAttribute("workflowRequired", "true");
      request.setAttribute("WORKFLOW_NAME", "mtpRegistrationCertificate");
      request.setAttribute("WORKFLOW_ENTITYNAME", "mtpRegistrationCertificate");
      request.setAttribute("WORKFLOW_ENTITYID", rtiApplicationId);
      request.setAttribute("rtiApplication", rtiApplication);
      request.setAttribute("rtiApplicationRefId", rtiApplicationId);
      session.setAttribute("rtirefId", rtirefId);
      return new ModelAndView("redirect:/rtsapplication/editMTPRegistrationCertificate.do");
   }
}

