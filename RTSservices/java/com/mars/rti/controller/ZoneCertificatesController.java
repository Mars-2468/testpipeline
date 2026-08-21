package com.mars.rti.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.ZoneCertificates;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.ZoneCertificatesService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.AuthenticationResponseDTO;
import com.mars.rti.ws.model.ZoneCertificatesRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class ZoneCertificatesController {

	// extends MultiActionController implements InitializingBean

	private static Log log = LogFactory.getLog(ZoneCertificatesController.class);
	
	String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";
	
	@Autowired
	private ZoneCertificatesService zoneCertificatesService;

	@Autowired
	private RTIApplicationService rTIApplicationService;

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private UserRegistrationService userService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RTIApplicationService rtiApplicationService;
	
	@Autowired
	private FeesMasterController feesMasterController;
	
	@Autowired
	private AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;

	

	public ZoneCertificatesService getZoneCertificatesService() {
		return zoneCertificatesService;
	}

	public void setzoneCertificatesService(ZoneCertificatesService zoneCertificatesService) {
		this.zoneCertificatesService = zoneCertificatesService;
	}

	/*
	 * private static final int THRESHOLD_SIZE = 102410243; // 3MB private static
	 * final int MAX_FILE_SIZE = 1024102410; // 10MB private static final int
	 * REQUEST_SIZE = 1024102450; // 50MB
	 */

	@RequestMapping("/rtsapplication/saveZoneCertificate.do")
	// rtsapplication/saveZoneCertificates.do
	public ModelAndView saveZoneCertificate(HttpServletRequest request, HttpServletResponse response,
			ZoneCertificates zoneCertificates) throws ServletException, Exception {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		if (log.isDebugEnabled()) {
			log.debug("Invoking Birth");
		}

		String mobileNumber = "";
		RTIApplication retunRti=null;
		String user_name=null;
		Object user_login = request.getSession().getAttribute("name");
		if (user_login != null) {
			user_name = (String) user_login;
		}
		Object obileNumber = session.getAttribute("mobileNo");
		if (obileNumber != null) {
			mobileNumber = String.valueOf(obileNumber);
		} else {
			mobileNumber = (String) session.getAttribute("mobileNo");
		}
		if (mobileNumber != null) {
			UserRegistrationDetails user = userService.getUserByMobileNo(mobileNumber);
			Object as_status=session.getAttribute("as_status");

			if (zoneCertificates != null) {
				ZoneCertificatesRestDTO zoneRegistrationRestDTO = new ZoneCertificatesRestDTO();
				RTIApplication rtiApplication = new RTIApplication();

				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setSubject("ZONE-CERTIFICATE");
				rtiApplication.setDepartment("TOWN-PLANNING-DEPARTMENT");
				rtiApplication.setTemplateName("townPlanning");
				rtiApplication.setWorkFlowStatus(-1);
				rtiApplication.setFinalStatus(CoreConstants.RTI_FINALSTATUS_NEW);
				rtiApplication.setRtiserviceid(5);
				// occupancyRegistrationRestDTO.setFirstName(occupancyCertificate.getFirstName());
				rtiApplication.setApplicantName(zoneCertificates.getFullName());
				rtiApplication.setPdfUploadFromPortal(zoneCertificates.getFilesPath());
				rtiApplication.setApplicationCost(feesMasterController.setZoneCertificateFees(zoneCertificates.getCalnumber(),5));
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
				}
				rtiApplication.setPhoneNumber(zoneCertificates.getMobileNo());
				rtiApplication.setMobileNumber(zoneCertificates.getMobileNo());
				rtiApplication.setEmail(zoneCertificates.getEmail());
				rtiApplication.setZone(zoneCertificates.getMouzaZone());
				rtiApplication.setUserRegistrationDetails(user);
				rtiApplication.setIsApleSarkarApp(0);

               if( zoneCertificates.getGatNo().isEmpty() ||  zoneCertificates.getGatNo()==null) {
            	   zoneCertificates.setGatNo(null);
               }
				// rtiApplication.setApplicantName(zoneRegistrationRestDTO.getFirstName());
				rtiApplication.setApplicantName(zoneCertificates.getFullName());
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

				if (savedRti.getRtiApplicationId() > 0) {
					RTIApplication rti = rTIApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/TPD" + "/" + savedRti.getRtiApplicationId()  + "/" + Year.now());
					zoneCertificates.setRtiapplrefno(rti.getRtiApplnNumber());
					zoneCertificates.setRti_ref_id(savedRti.getRtiApplicationId());
					long zone_regis_id = zoneCertificatesService.getReferenceId(zoneCertificates);
					rti.setRtiApplicationRefId(zone_regis_id);
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
							rti.setApplication_status(2);

							
					}
					 retunRti = rTIApplicationService.merge(rti);

					if ((retunRti != null) && (zone_regis_id > 0)) {
						zoneRegistrationRestDTO.setResponseStatus("Requested data saved successfully");
						zoneRegistrationRestDTO.setResponse(retunRti.getRtiApplicationId());
						zoneRegistrationRestDTO.setResult(retunRti.getRtiApplnNumber());

					}
					String name = zoneCertificates.getFullName();
					String applnNo = rti.getRtiApplnNumber();
					String mobileNo = zoneCertificates.getMobileNo();
					String email=zoneCertificates.getEmail();
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
							
						    String uname = request.getParameter("name");
							log.debug("aple sarkar name ="+uname);
							
							
							String appId=retunRti.getRtiApplnNumber();
							appId = appId.replace("/", "");
							log.debug("aple sarkar appId ="+appId);
							
							String paymentStatus="N";
							log.debug("aple sarkar paymentStatus ="+paymentStatus);
							
							String paymentDate="NA";
							String digitalSignStatus="N";
							String digitalSignDate="NA";
							int estServiceDays=1;
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
							String mobileApla = zoneCertificates.getMobileNo();
							
							
							/*
							 * String[] fields = request.getParameterValues("fields"); for (int i = 0; i <
							 * fields.length; i++) { log.debug("Index controller XXX--> " + i + ": " +
							 * fields[i]); }
							 */

							 String retrurnurl="https://nmcnagpur.gov.in/RTSservices/ws/rtsapplication/newRtSZonecertificatesSuccess.do?rtsAppNo="+appId+ "&isApleSarkar="+ retunRti.getIsApleSarkarApp();
							//String retrurnurl="https://nagpur.egovmars.in/RTSservices/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
							
							String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,uname, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
									 digitalSignStatus,digitalSignDate,estServiceDays, 
									 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
							
						log.debug("Final  PushBAck status XXX-->>>"+pushBackrespose);
						log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
								" mobile:"+mobile +" name:"+uname+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
								" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
								" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
								" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
						);

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
					            	authenticationResponseDTO = aapleSarkarPortalIntegrationNagpur.redirectForAapleSarkarPaymentFinal(distric,trackid,userid,mobile,uname,str, serviceId, retunRti.getRtiApplnNumber(),retrurnurl);
									
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
						return new ModelAndView("redirect:/ws/rtsapplication/newRtSZonecertificatesSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber()
						 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
								);

						//return new ModelAndView("redirect:/ws/pay.do?rtsNo="+retunRti.getRtiApplnNumber());

					}
				}
//				ModelAndView modelAndView = new ModelAndView("newRTIZoneSucess");
//				return modelAndView;
//				modelAndView.setViewName("redirect:ws/pay.do");
//				return new ModelAndView("redirect:/ws/rtsapplication/newRtSZonecertificatesSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber());


			}
		
		// occupancyCertificateService.saveOccupancyForm(occupancyCertificate);

		return new ModelAndView("redirect:/ws/user/login.do");

	}
	@RequestMapping("ws/rtsapplication/newRtSZonecertificatesSuccess.do")
	public ModelAndView newRtSZonecertificatesSuccess(HttpServletRequest
	request,HttpServletResponse response) {

	 String appNo = request.getParameter("rtsAppNo");
		String isApleSarkar=request.getParameter("isApleSarkar");

	 log.debug("success appno"+appNo);
	 ModelAndView model = new ModelAndView("newRTIZoneSucess");
		model.addObject("isApleSarkar", isApleSarkar);


	 model.addObject("appNo",appNo);
	 return model;


	 } 
//	@RequestMapping("ws/rtsapplication/newRtSZonecertificatesSuccess.do")
//	public ModelAndView newRtSZonecertificatesSuccess(HttpServletRequest request,HttpServletResponse response) {
//		
//		String appNo = request.getParameter("rtsAppNo");
//		RTIApplication rtiApplication=new RTIApplication();
//		rtiApplication = rtiApplicationService.findByRTIApplicationNumber(appNo);
//
//		
//		String mobileNo = rtiApplication.getMobileNumber();
//		String name = rtiApplication.getApplicantName();
//		String applnNo = rtiApplication.getRtiApplnNumber();
//		String email=rtiApplication.getEmail();
//
//		
//		//SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
//
//		ModelAndView model = new ModelAndView("newRTIZoneSucess");
//		
//		model.addObject("appNo",appNo);
//		return model;
//				
//		
//	}
	
	@RequestMapping("/rtsapplication/saveUseOfLand.do")
	public ModelAndView saveUseOfLand(HttpServletRequest request,
			HttpServletResponse response, ZoneCertificates zoneCertificates)
			throws ServletException, Exception {
		String useOfLand = request.getParameter("useOfLand");
		String refid = request.getParameter("zoneCertificatesId");

		//String refid = (String) request.getSession().getAttribute("zoneCertificatesId");
		long apprefid = 0; // Default value if the conversion fails or refid is null
		apprefid = Long.parseLong(refid);
		
		zoneCertificates = zoneCertificatesService.get(apprefid);
		if (zoneCertificates.getUseOfLand() == null && useOfLand!=null) {
			zoneCertificates.setUseOfLand(useOfLand);
			zoneCertificates = zoneCertificatesService.merge(zoneCertificates);
		}
		return new ModelAndView("redirect:/rtiapplication/editzoneCertificates.do?rtiApplicationRefId=" + apprefid + "&useOfLand=" + useOfLand);	
		
	}

	@RequestMapping("/rtiapplication/editzoneCertificates.do")
	public ModelAndView editzoneCertificate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		log.info("Document Uploaded");
		HttpSession session = request.getSession();
		System.out.println("hiiii editzoneCertificate");
		long rtiApplicationRefId = 0;
		ZoneCertificates zoneCertificates = null;
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
				zoneCertificates = zoneCertificatesService.get(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				zoneCertificates = zoneCertificatesService.get(rtiApplicationRefId);
			}

			if (zoneCertificates.getRti_ref_id() > 0) {
				rtiApplicationId = zoneCertificates.getRti_ref_id();
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
		ModelAndView modelAndView = new ModelAndView("manageZonecertificate", "zoneCertificates", zoneCertificates);
		log.info("success");
		return modelAndView;

	}else {
		return new ModelAndView("/login.do");
	}
	}

	@RequestMapping("/rtiapplication/createZoneCertificatesWork.do")
	public ModelAndView createMandapPermissionWork(HttpServletRequest request, HttpServletResponse response)
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
		ZoneCertificates zoneCertificates = zoneCertificatesService.get(applicationId);
		String email = zoneCertificates.getEmail();
		String mobileNo = zoneCertificates.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();

		if (zoneCertificates != null) {
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
						int estServiceDays=1;
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
					log.debug("Zone workflow close status push to aple sarkar: "+pushBackrespose);
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
						String paymentStatus="Y";						
						String paymentDate="NA";
						String digitalSignStatus="N";
						String digitalSignDate="NA";
						int estServiceDays=1;
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
					log.debug("Zone workflow close status push to aple sarkar: "+pushBackrespose);
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
						String paymentStatus="Y";						
						String paymentDate="NA";
						String digitalSignStatus="N";
						String digitalSignDate="NA";
						int estServiceDays=1;
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
					int estServiceDays=1;
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
		return new ModelAndView("redirect:/rtiapplication/editzoneCertificates.do");
	}

	/*
	 * @RequestMapping("/rtiapplication/uploadDocument.do") public void
	 * uploadDocument(HttpServletRequest request, HttpServletResponse response) {
	 * log.info("Document Uploaded"); try { // String baseDir =
	 * getServletContext().getRealPath("") + File.separator + "zoneCertificates";
	 * File file = new File(baseDir); if (!file.exists()) { file.mkdirs(); }
	 * 
	 * String[] name = new String[12]; if (FileUpload.isMultipartContent(request)) {
	 * DiskFileItemFactory factory = new DiskFileItemFactory();
	 * factory.setSizeThreshold(MAX_FILE_SIZE); factory.setRepository(new
	 * File(System.getProperty("java.io.tmpdir")));
	 * 
	 * ServletFileUpload upload = new ServletFileUpload(factory);
	 * upload.setFileSizeMax(MAX_FILE_SIZE); upload.setSizeMax(REQUEST_SIZE);
	 * 
	 * List formItems = upload.parseRequest(request); Iterator iter =
	 * formItems.iterator(); int i = 0;
	 * 
	 * while (iter.hasNext()) { FileItem item = (FileItem) iter.next(); // processes
	 * if (!item.isFormField() && !item.getName().isEmpty() && item.getName() !=
	 * null) { String fileName = new File(item.getName()).getName(); int l =
	 * fileName.lastIndexOf("."); String imageext = fileName.substring(l,
	 * fileName.length()); fileName = fileName.substring(0, l); fileName =
	 * fileName.replaceAll("\\W", ""); fileName = fileName + "" + imageext; name[i]
	 * = item.getName();
	 * 
	 * File storeFile = new File(baseDir, i + fileName); // saves the file on disk
	 * item.write(storeFile);
	 * 
	 * } i++; }
	 * 
	 * } else { request.setAttribute("message", "Please contact the system admin");
	 * } } catch (Exception ex) { log.error(ex); request.setAttribute("message",
	 * "Please contact the system admin"); ex.printStackTrace(); }
	 * 
	 * }
	 * 
	 * @Override public void afterPropertiesSet() throws Exception { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */

//	-----------------------------------------------------------------------------------------------------------------------

//	@RequestMapping("/rtiapplication/uploadDocument.do") 
//	public void  uploadDocument(HttpServletRequest request, HttpServletResponse response) {
//	 
//	  log.info("Document Uploaded"); 
//	  try {  String baseDir = getServletContext().getRealPath("") + File.separator + "zoneCertificates";
//	  File file = new File(baseDir);
//	  if (!file.exists()) { file.mkdirs(); }
//	  
//	  String[] name = new String[12]; 
//	  if (FileUpload.isMultipartContent(request)) {
//	  DiskFileItemFactory factory = new DiskFileItemFactory();
//	  factory.setSizeThreshold(MAX_FILE_SIZE); 
//	  factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
//	  
//	  
//	  ServletFileUpload upload = new ServletFileUpload(factory);
//	  upload.setFileSizeMax(MAX_FILE_SIZE); upload.setSizeMax(REQUEST_SIZE);
//	  
//	  List formItems = upload.parseRequest(request); 
//	  Iterator iter =  formItems.iterator(); 
//	
//	  int i = 0;
//	  
//	  while (iter.hasNext()) { 
//		  FileItem item = (FileItem) iter.next(); // processes
//	  if (!item.isFormField() && !item.getName().isEmpty() && item.getName() != null) {
//	 
//		  String fileName = new File(item.getName()).getName();
//				  int l =  fileName.lastIndexOf("."); 
//				  String imageext = fileName.substring(l,fileName.length()); 
//				  fileName = fileName.substring(0, l);
//				  fileName = fileName.replaceAll("\\W", ""); 
//				  fileName = fileName + "" + imageext; 
//						  name[i]  = item.getName();
//	  
//	  File storeFile = new File(baseDir, i + fileName); // saves the file on disk
//	  item.write(storeFile);
//	  
//	  } i++; }
//	  
//	  } else { request.setAttribute("message", "Please contact the system admin");
//	  } } catch (Exception ex) { log.error(ex); request.setAttribute("message",
//	  "Please contact the system admin"); ex.printStackTrace(); }
//	  
//	  }
//
//	@Override public void afterPropertiesSet() throws Exception { 
//	 // Auto-generated method stub
//	  
//	  }

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
}