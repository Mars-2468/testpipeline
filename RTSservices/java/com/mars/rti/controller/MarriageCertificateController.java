package com.mars.rti.controller;

import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.MarriageCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.MarriageCertificateService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.ws.model.AuthenticationResponseDTO;
import com.mars.rti.ws.model.MarriageCertificateDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Controller
public class MarriageCertificateController {
   private static Log log = LogFactory.getLog(MarriageCertificateController.class);
	String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";
   
   @Autowired
   private MarriageCertificateService marriageCertificateService;
   @Autowired
   private RTIApplicationService rtiApplicationService;
   @Autowired
   private WorkflowProcessDetailsService workflowProcessDetailsService;
   @Autowired
   private UserRegistrationService userService;
   @Autowired
   private WorkflowService workflowService;
   @Autowired
   private TaskService taskService;
   @Autowired
   private FeesMasterController feesMasterController;
	@Autowired
	private AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;


   @RequestMapping(
      method = {RequestMethod.POST},
      value = {"/rtsapplication/saveMarriageCertificates.do"}
   )
   public ModelAndView saveMarriageCertificate(HttpServletRequest request, HttpServletResponse response, MarriageCertificate marriageCertificate) throws ServletException, Exception {
      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      if (log.isDebugEnabled()) {
         log.debug("Invoking marriage");
      }

      String mobileNumber = "";
      double fees = 0.0D;
      RTIApplication retunRti = null;
      String user_name = null;
      Object user_login = request.getSession().getAttribute("name");
      if (user_login != null) {
         user_name = (String)user_login;
      }

      Object obileNumber = session.getAttribute("mobileNo");
      if (obileNumber != null) {
         mobileNumber = String.valueOf(obileNumber);
      } else {
         mobileNumber = (String)session.getAttribute("mobileNo");
      }

      if (mobileNumber != null) {
         UserRegistrationDetails user = this.userService.getUserByMobileNo(mobileNumber);
         Object as_status = session.getAttribute("as_status");
         if (marriageCertificate != null) {
            RTIApplication rtiApplication = new RTIApplication();
            fees = this.feesMasterController.setMarriageFeesApplicable(marriageCertificate.getMarriageDate(), 11L);
            if (fees > 0.0D) {
               log.debug("Date format is correct");
               rtiApplication.setApplicationCost(fees);
               marriageCertificate.setFeeApplicable(fees);
               MarriageCertificateDTO marriageCertificateDTO = new MarriageCertificateDTO();
               rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
               rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
               rtiApplication.setTemplateName("marriageApplication");
               rtiApplication.setSubject("MARRIAGE-CERTIFICATE");
               rtiApplication.setDepartment("HEALTH-DEPARTMENT");
               rtiApplication.setWorkFlowStatus(0);
               rtiApplication.setFinalStatus("0");
               rtiApplication.setRtiserviceid(11);
               StringBuilder fullName = new StringBuilder();
               if (marriageCertificate.getFirstName() != null && !marriageCertificate.getFirstName().trim().isEmpty()) {
                  fullName.append(marriageCertificate.getFirstName().trim());
               }

               if (marriageCertificate.getMiddleName() != null && !marriageCertificate.getMiddleName().trim().isEmpty()) {
                  if (fullName.length() > 0) {
                     fullName.append(" ");
                  }

                  fullName.append(marriageCertificate.getMiddleName().trim());
               }

               if (marriageCertificate.getLastName() != null && !marriageCertificate.getLastName().trim().isEmpty()) {
                  if (fullName.length() > 0) {
                     fullName.append(" ");
                  }

                  fullName.append(marriageCertificate.getLastName().trim());
               }

               rtiApplication.setApplicantName(fullName.toString());
               if (as_status != null && user_name == null) {
                  rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
               }

               rtiApplication.setPhoneNumber(marriageCertificate.getMobileNumber());
               rtiApplication.setMobileNumber(marriageCertificate.getMobileNumber());
               rtiApplication.setEmail(marriageCertificate.getEmail());
               rtiApplication.setZone(marriageCertificate.getZoneNo());
               rtiApplication.setUserRegistrationDetails(user);
				rtiApplication.setIsApleSarkarApp(0);

               marriageCertificate.setMarriageImages(request.getParameter("marriageImages"));
               rtiApplication.setPdfUploadFromPortal(marriageCertificate.getFilesPath());
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
                  marriageCertificate.setRtiapplrefno(rti.getRtiApplnNumber());
                  marriageCertificate.setRti_ref_id(savedRti.getRtiApplicationId());
                  long marriage_regis_id = this.marriageCertificateService.marriageCertificate(marriageCertificate);
                  rti.setRtiApplicationRefId(marriage_regis_id);
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
              	retunRti = this.rtiApplicationService.merge(rti);
                  if (retunRti != null && marriage_regis_id > 0L) {
                     marriageCertificateDTO.setResponseStatus("Requested data saved successfully");
                     marriageCertificateDTO.setResponse(retunRti.getRtiApplicationId());
                     marriageCertificateDTO.setResult(retunRti.getRtiApplnNumber());
                  }

                  String name = marriageCertificate.getFullName();
                  String applnNo = rti.getRtiApplnNumber();
                  String mobileNo = marriageCertificate.getMobileNumber();
                  String email = marriageCertificate.getEmail();
                  SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
               }
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
					int appStatus=2;
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
					String mobileApla = marriageCertificate.getMobileNumber();
					
					
					/*
					 * String[] fields = request.getParameterValues("fields"); for (int i = 0; i <
					 * fields.length; i++) { log.debug("Index controller XXX--> " + i + ": " +
					 * fields[i]); }
					 */

					// String retrurnurl="https://nagpur.egovmars.in/RTSservices/ws/rtsapplication/newRtSMarriageCertificateSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
					//String retrurnurl="https://nagpur.egovmars.in/RTSservices/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
					 String retrurnurl="https://nmcnagpur.gov.in/RTSservices/ws/rtsapplication/newRtSMarriageCertificateSuccess.do?rtsAppNo="+appId+ "&isApleSarkar="+ retunRti.getIsApleSarkarApp();

					String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
							 digitalSignStatus,digitalSignDate,estServiceDays, 
							 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
					
				log.debug("Final  PushBAck status XXX-->>>"+pushBackrespose);
				
				 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			        DocumentBuilder builder = null;
			        String statusValue=null;
			        AuthenticationResponseDTO authenticationResponseDTO=null;
					try {
						builder = factory.newDocumentBuilder();
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			        // Convert string to InputStream
			        ByteArrayInputStream input = null;
					try {
						input = new ByteArrayInputStream(pushBackrespose.getBytes("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        Document doc = null;
					try {
						doc = builder.parse(input);
					} catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			        NodeList nodeList = doc.getElementsByTagName("status");
			        if (nodeList.getLength() > 0) {
			            statusValue = nodeList.item(0).getTextContent();
			            
			            if(statusValue!=null && statusValue.equals("Success")) {
			            	authenticationResponseDTO = aapleSarkarPortalIntegrationNagpur.redirectForAapleSarkarPaymentFinal(distric,trackid,userid,mobile,name,str, serviceId, retunRti.getRtiApplnNumber(),retrurnurl);
							
			            }
			            //System.out.println("Status: " + statusValue);
			        }

				
				
				String EncyKey= authenticationResponseDTO.getKey();		
				log.debug("Final Key XXX-->>>"+EncyKey);
				
				if (!EncyKey.isEmpty()|| EncyKey !=null) {
					String redirectUrl = "https://aaplesarkar.mahaonline.gov.in/en/OutPayment/Pay?webstr="
					        + authenticationResponseDTO.getWebstring()
					        + "&DeptCode=NMCDeptN"
					        + "&Authentication="+EncyKey;
					
					log.debug("redirectUrl-->>>> XXX-->>>"+redirectUrl);

					return new ModelAndView("redirect:" + redirectUrl);
					//return "redirect:http://testcitizenservices.MahaITgov.in/en/OutPayment/Pay?webstr="+authenticationResponseDTO.getWebstring()+"&DeptCode=NGMCN&Authentication="+ EncyKey;
					//return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?EncyKey="+EncyKey+"&rtsAppNo="+retunRti.getRtiApplnNumber());

				} else {
					request.getSession().removeAttribute("mobileNo");
					return new ModelAndView("userError");
				}		
				

			}else {
//               if (as_status != null && user_name == null) {
//                  return new ModelAndView("redirect:/as/rtsapplication/newRTSSuccess.do?rtsAppNo=" + retunRti.getRtiApplnNumber());
//               }

               return new ModelAndView("redirect:/ws/rtsapplication/newRtSMarriageCertificateSuccess.do?rtsAppNo=" + retunRti.getRtiApplnNumber()
				 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
            		   );
            }
            }
         }
      }
            log.debug("Date format is incorrect or invalid date:" + marriageCertificate.getMarriageDate());
            request.setAttribute("message", "Something Went Wrong!!");
//            return new ModelAndView("/ws/rtsapplication/newRTIMarriageApplication.do");
//         }
//      }

      return new ModelAndView("redirect:/ws/user/login.do");
   }

   @RequestMapping({"ws/rtsapplication/newRtSMarriageCertificateSuccess.do"})
   public ModelAndView newRtSBirthSuccess(HttpServletRequest request, HttpServletResponse response) {
      String appNo = request.getParameter("rtsAppNo");
		String isApleSarkar=request.getParameter("isApleSarkar");

      ModelAndView model = new ModelAndView("newRTIMarriageApplicationSuccess");
      model.addObject("appNo", appNo);
		model.addObject("isApleSarkar", isApleSarkar);

      return model;
   }

   @RequestMapping({"/rtiapplication/editMarriageCertificate.do"})
   public ModelAndView editMarriageForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      MarriageCertificate marriageCertificate = null;
      HttpSession session = request.getSession();
      System.out.println(" editMarriageCertificate");
      long rtiApplicationRefId = 0L;
      long rtiApplicationId = 0L;
      RTIApplication rtiapplication = null;
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      if (sessionUser == null) {
         return new ModelAndView("redirect:/login.do");
      } else {
         Object a;
         if (request.getParameter("rtiApplicationRefId") != null && request.getParameter("rtiApplicationRefId").length() > 0 || session.getAttribute("rtirefId") != null) {
            if (request.getParameter("rtiApplicationRefId") != null && request.getParameter("rtiApplicationRefId").length() > 0) {
               rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
               marriageCertificate = this.marriageCertificateService.get(rtiApplicationRefId);
            } else if (session.getAttribute("rtirefId") != null) {
               a = session.getAttribute("rtirefId");
               rtiApplicationRefId = (Long)a;
               marriageCertificate = this.marriageCertificateService.get(rtiApplicationRefId);
            }

            if (marriageCertificate.getRti_ref_id() > 0L) {
               rtiApplicationId = marriageCertificate.getRti_ref_id();
               rtiapplication = this.rtiApplicationService.get(rtiApplicationId);
            } else {
               List<RTIApplication> listRTI = this.rtiApplicationService.findByProperty("rtiApplicationRefId", rtiApplicationRefId);
               if (listRTI != null && !listRTI.isEmpty()) {
                  rtiApplicationId = ((RTIApplication)listRTI.get(0)).getRtiApplicationId();
                  rtiapplication = (RTIApplication)listRTI.get(0);
               }
            }
         }

         request.setAttribute("workflowRequired", "true");
         request.setAttribute("WORKFLOW_NAME", "marriageApplication");
         request.setAttribute("WORKFLOW_ENTITYNAME", "marriageApplication");
         request.setAttribute("WORKFLOW_ENTITYID", rtiApplicationId);
         request.setAttribute("rtiApplication", rtiapplication);
         a = null;
         WorkflowProcessDetails processDetails = null;
         WorkflowProcessDetails workflowProcessDetails = this.workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, "marriageApplication");
         if (workflowProcessDetails != null) {
            String processId = workflowProcessDetails.getProcessId();
            if (processId != null) {
               processDetails = this.workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId);
            }

            if (!this.workflowService.isProcessEnded(processId)) {
               String taskId = this.workflowService.getCurrentTaskId(processId);
               Task task = null;
               if (taskId != null) {
                  task = this.taskService.getTask(taskId);
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

         ModelAndView modelAndView = new ModelAndView("manageMarriageCertificate", "marriageCertificate", marriageCertificate);
         return modelAndView;
      }
   }

   @RequestMapping({"/rtiapplication/saveVisitdate.do"})
   public ModelAndView saveVisitdate(HttpServletRequest request, HttpServletResponse response, MarriageCertificate marriageCertificate) throws ServletException, Exception {
      String visitdate = request.getParameter("visitdate");
      String secondvisitdate = request.getParameter("secondvisitdate");
      String verifiedStatus = request.getParameter("verifiedStatus");
      String remarks = request.getParameter("remarks");
      String visitTime = request.getParameter("visitTime");
      String secondVisistTime = request.getParameter("secondVisitTime");
      long apprefid = 0L;
      RTIApplication rts = null;
      if (request.getParameter("rtiApplicationRefId") == null) {
         request.setAttribute("errMessage", "Something Went Wrong!!");
         return new ModelAndView("redirect:/rtsapplication/listRTSMarriageApplication.do");
      } else {
         String refid = request.getParameter("rtiApplicationRefId");
         apprefid = Long.parseLong(refid);
         marriageCertificate = this.marriageCertificateService.get(apprefid);
         rts = this.rtiApplicationService.get(marriageCertificate.getRti_ref_id());
         String email = marriageCertificate.getEmail();
         String mobileNo = marriageCertificate.getMobileNumber();
         String rtiApplnNumber = rts.getRtiApplnNumber();
         String applicantName = rts.getApplicantName();
         String msg;
         if (visitdate == null || visitdate.isEmpty() || marriageCertificate.getVisitdate() != null && !marriageCertificate.getVisitdate().toString().trim().isEmpty()) {
            if (secondvisitdate == null || secondvisitdate.isEmpty() || marriageCertificate.getSecondvisitdate() != null && !marriageCertificate.getSecondvisitdate().toString().trim().isEmpty()) {
               if (verifiedStatus != null && !verifiedStatus.isEmpty() || remarks != null && !remarks.isEmpty()) {
                  marriageCertificate.setVisitVerification(verifiedStatus);
                  marriageCertificate.setRemarks(remarks);
                  this.marriageCertificateService.merge(marriageCertificate);
               }
            } else {
               marriageCertificate.setSecondvisitdate(secondvisitdate);
               marriageCertificate.setSecondVisitTime(secondVisistTime);
               marriageCertificate = this.marriageCertificateService.merge(marriageCertificate);
               msg = "Dear " + marriageCertificate.getFullName() + ", your document verification has been successfully completed. Your visit is scheduled " + "on " + marriageCertificate.getSecondvisitdate() + " " + marriageCertificate.getSecondVisitTime() + ", for your marriage application " + marriageCertificate.getRtiapplrefno() + " to be processed further. Regards, NMCGOV";
               msg.replace("var3", "");
               SendEmail.sendEmail(email, "Marriage Reschedule date for your Appl. No." + mobileNo, msg);
               SendSMS.sendSMS(mobileNo, msg);
            }
         } else {
            marriageCertificate.setVisitdate(visitdate);
            marriageCertificate.setVisitTime(visitTime);
            marriageCertificate = this.marriageCertificateService.merge(marriageCertificate);
            msg = "Dear " + marriageCertificate.getFullName() + ", your document verification has been successfully completed. Your visit is scheduled " + "on " + marriageCertificate.getVisitdate() + " " + marriageCertificate.getVisitTime() + ", for your marriage application " + marriageCertificate.getRtiapplrefno() + " to be processed further. Regards, NMCGOV";
            msg.replace("var3", "");
            SendEmail.sendEmail(email, "Marriage Schedule date for your Appl. No." + mobileNo, msg);
            SendSMS.sendSMS(mobileNo, msg);
         }

         return new ModelAndView("redirect:/rtiapplication/editMarriageCertificate.do?rtiApplicationRefId=" + apprefid);
      }
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
   @RequestMapping({"/rtiapplication/createMarriageCertificateWork.do"})
   public ModelAndView createMarriageWorkFlow(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
      String rtiApplicationIdString = request.getParameter("WORKFLOW_ENTITYID");
      long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
      RTIApplication rtiApplication = this.rtiApplicationService.get(rtiApplicationId);
      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      WorkflowProcessDetails workflowProcessDetails = null;
      WorkflowProcessDetails processDetails = null;
      workflowProcessDetails = this.workflowProcessDetailsService.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, "marriageApplication");
      String WORKFLOW_TRANSISTION = request.getParameter("WORKFLOW_TRANSISTION");
      String WORKFLOW_ACTION = request.getParameter("WORKFLOW_ACTION");
      String id = request.getParameter("id");
      long applicationId = Long.parseLong(id);
      MarriageCertificate marriageCertificate = this.marriageCertificateService.get(applicationId);
      String email = marriageCertificate.getEmail();
      String mobileNo = marriageCertificate.getMobileNumber();
      String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
      String applicantName = rtiApplication.getApplicantName();
      long rtirefId = rtiApplication.getRtiApplicationRefId();
		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();

      if (marriageCertificate != null) {
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

               rtiApplication.setWorkFlowStatus(3);
               this.rtiApplicationService.save(rtiApplication);
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
					int appStatus=2;
					String remark="NA";						
					String serviceId= rtiApplication.getAaple_service_id();
					String mobileApla=rtiApplication.getMobileNumber();
					//retunRti.setAaple_application_id(appId);
				String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
							 digitalSignStatus,digitalSignDate,estServiceDays, 
							 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
				log.debug("Final  PushBAck status XXX for send demand-->>>"+pushBackrespose);
				log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
						" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
						" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
						" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
						" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
				);
				}
               SendSMSEmailController.sendMarriagePayment(applicantName, mobileNo, rtiApplnNumber, email);
               System.out.println("send demand done");
               log.debug("send demand done");
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

					String paymentStatus="Y";
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
               System.out.println("workflow closed");
               log.debug("workflow closed");
            } else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
               rtiApplication.setWorkFlowStatus(5);
               workflow_comments = request.getParameter("WORKFLOW_COMMENTS");
               rtiApplication.setWorkflowComments(workflow_comments);
               this.rtiApplicationService.save(rtiApplication);
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

					String paymentStatus="Y";
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
               System.out.println("workflow rejected after payment.//2nd reject button.");
               log.debug("workflow rejected after payment.//2nd reject button.");
            }
         } else if (request.getParameter("WORKFLOW_ACTION").equals("KILL_JOB")) {
            rtiApplication.setWorkFlowStatus(5);
            processId = request.getParameter("WORKFLOW_COMMENTS");
            rtiApplication.setWorkflowComments(processId);
            this.rtiApplicationService.save(rtiApplication);
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
            System.out.println("workflow rejected before payment.//1st reject button.");
            log.debug("workflow rejected before payment.//1st reject button.");
         } else {
            log.info("Workflow failed");
            request.setAttribute("error", "Unable to retrieve workflow process details. Please try again later when the network connection is stable.");
            System.out.println("when workflow process details not found.");
            log.debug("when workflow process details not found.");
         }
      }

      request.setAttribute("workflowRequired", "true");
      request.setAttribute("WORKFLOW_NAME", "marriageApplication");
      request.setAttribute("WORKFLOW_ENTITYNAME", "marriageApplication");
      request.setAttribute("WORKFLOW_ENTITYID", rtiApplicationId);
      request.setAttribute("rtiApplication", rtiApplication);
      request.setAttribute("rtiApplicationRefId", rtiApplicationId);
      session.setAttribute("rtirefId", rtirefId);
      return new ModelAndView("redirect:/rtiapplication/editMarriageCertificate.do");
   }

   private String getZone(String zone) {
      String zoneName = "Zone No.";
      if (!zone.equals("1") && !zone.equals("1")) {
         if (!zone.equals("2") && !zone.equals("2")) {
            if (!zone.equals("3") && !zone.equals("3")) {
               if (!zone.equals("4") && !zone.equals("4")) {
                  if (!zone.equals("5") && !zone.equals("5")) {
                     if (!zone.equals("6") && !zone.equals("6")) {
                        if (!zone.equals("7") && !zone.equals("7")) {
                           if (!zone.equals("8") && !zone.equals("8")) {
                              if (!zone.equals("9") && !zone.equals("9")) {
                                 if (zone.equals("10") || zone.equals("10")) {
                                    zoneName = zoneName + zone + " " + "-" + " " + "Mangalwari";
                                 }
                              } else {
                                 zoneName = zoneName + zone + " " + "-" + " " + "Ashi Nagar";
                              }
                           } else {
                              zoneName = zoneName + zone + " " + "-" + " " + "Lakadganj";
                           }
                        } else {
                           zoneName = zoneName + zone + " " + "-" + " " + "Satranjipura";
                        }
                     } else {
                        zoneName = zoneName + zone + " " + "-" + " " + "Gandhibagh";
                     }
                  } else {
                     zoneName = zoneName + zone + " " + "-" + " " + "Nehru Nagar";
                  }
               } else {
                  zoneName = zoneName + zone + " " + "-" + " " + "Dhantoli";
               }
            } else {
               zoneName = zoneName + zone + " " + "-" + " " + "Hanuman Nagar";
            }
         } else {
            zoneName = zoneName + zone + " " + "-" + " " + "Dharampeth";
         }
      } else {
         zoneName = zoneName + zone + " " + "-" + " " + "Laxmi Nagar";
      }

      return zoneName;
   }

   @RequestMapping(
      method = {RequestMethod.POST},
      value = {"/rtsapplication/editMarriageCertificateApp.do"}
   )
   public ModelAndView editMarriageCertificateApp(HttpServletRequest request, HttpServletResponse response, MarriageCertificate marriageCertificate) throws ServletException, Exception {
      HttpSession session = request.getSession();
      SessionUser sessionUser = (SessionUser)session.getAttribute("SessionUser");
      if (log.isDebugEnabled()) {
         log.debug("Editing marriage certificate");
      }

      String rtiApplicationIdString = request.getParameter("WORKFLOW_ENTITYID");
      long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
      RTIApplication rtiApplication = this.rtiApplicationService.get(rtiApplicationId);
      if (rtiApplication == null) {
         log.error("RTI Application not found for ID: " + rtiApplicationId);
         request.setAttribute("errMessage", "RTI Application not found!");
         return new ModelAndView("redirect:/rtsapplication/listRTSMarriageApplication.do");
      } else {
         log.debug("Fetched RTI Application: " + rtiApplication);
         StringBuilder fullName = new StringBuilder();
         if (marriageCertificate.getFirstName() != null && !marriageCertificate.getFirstName().trim().isEmpty()) {
            fullName.append(marriageCertificate.getFirstName().trim());
         }

         if (marriageCertificate.getMiddleName() != null && !marriageCertificate.getMiddleName().trim().isEmpty()) {
            if (fullName.length() > 0) {
               fullName.append(" ");
            }

            fullName.append(marriageCertificate.getMiddleName().trim());
         }

         if (marriageCertificate.getLastName() != null && !marriageCertificate.getLastName().trim().isEmpty()) {
            if (fullName.length() > 0) {
               fullName.append(" ");
            }

            fullName.append(marriageCertificate.getLastName().trim());
         }

         rtiApplication.setApplicantName(fullName.toString());
         rtiApplication.setPhoneNumber(marriageCertificate.getMobileNumber());
         rtiApplication.setMobileNumber(marriageCertificate.getMobileNumber());
         rtiApplication.setEmail(marriageCertificate.getEmail());
         rtiApplication.setZone(marriageCertificate.getZoneNo());
         Long idd = 0L;
         if (request.getParameter("marriageCertificatesId") != null && request.getParameter("marriageCertificatesId").length() > 0) {
            idd = Long.parseLong(request.getParameter("marriageCertificatesId"));
         }

         MarriageCertificate exmarriageCertificate = this.marriageCertificateService.get(idd);
         double fees = this.feesMasterController.setMarriageFeesApplicable(marriageCertificate.getMarriageDate(), 11L);
         if (fees > 0.0D) {
            rtiApplication.setApplicationCost(fees);
            marriageCertificate.setFeeApplicable(fees);
            log.debug("Updated Marriage Certificate details: " + marriageCertificate);
            marriageCertificate.setMarriageImages(exmarriageCertificate.getMarriageImages());
            marriageCertificate.setRtiapplrefno(exmarriageCertificate.getRtiapplrefno());
            marriageCertificate.setRti_ref_id(exmarriageCertificate.getRti_ref_id());
            marriageCertificate.setMarriageCertificateID(idd);
            this.marriageCertificateService.saveOrUpdate(marriageCertificate);
            this.rtiApplicationService.merge(rtiApplication);
            log.debug("Marriage Certificate updated successfully: " + marriageCertificate.getRtiapplrefno());
            session.setAttribute("successMessage", "Marriage Certificate updated successfully!");
            return new ModelAndView("redirect:/rtiapplication/editMarriageCertificate.do?rtiApplicationRefId=" + rtiApplication.getRtiApplicationRefId());
         } else {
            log.debug("Invalid marriage date: " + marriageCertificate.getMarriageDate());
            request.setAttribute("message", "Invalid date provided!");
            return new ModelAndView("/ws/rtsapplication/editRTIMarriageApplication.do");
         }
      }
   }
}

