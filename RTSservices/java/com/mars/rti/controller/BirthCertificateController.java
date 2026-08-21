package com.mars.rti.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

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

import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.BirthCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.BirthCertificateService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.AuthenticationResponseDTO;
import com.mars.rti.ws.model.BirthRegistrationRestDTO;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Controller
public class BirthCertificateController /* extends MultiActionController implements InitializingBean */{

	private static Log  log = LogFactory.getLog(BirthCertificateController.class);
	
	String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";


	
	@Autowired
	private BirthCertificateService  birthCertificateService;
	
	@Autowired
	private RTIApplicationService rtiApplicationService;
	
	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;
	
	@Autowired
	private BirthCertificateService birCertificateService;
	
	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private UserRegistrationService userService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private FeesMasterController feesMasterController;
	
	
	@Autowired
	private AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;

	
//	@RequestMapping("ws/rtiapplication/newRTIBirthApplication.do")
//	public ModelAndView newRTIBirthApplication(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException {
//		String baseDir = getServletContext().getRealPath("");
//		String folder = "birthCertificates";
//		File file = new File(baseDir, folder);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
//		ModelAndView modelAndView = new ModelAndView("newRTIBirthApplication");
//		modelAndView.addObject("folderName", folder);
//		return modelAndView;
//	}
	
	
	@RequestMapping("/rtiapplication/saveRTIBirthApplication.do")

	public ModelAndView saveRTIBirthApplication(HttpServletRequest request, HttpServletResponse response,BirthCertificate birthCertificate)
			throws ServletException {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		//String path=request.getAttribute("httppath");
		if (log.isDebugEnabled()) {
			log.debug("Invoking birthRegistrationCertificate");
		}
		String mobileNumber ="";
		String user_name=null;
		Object user_login = request.getSession().getAttribute("name");
		if (user_login != null) {
			user_name = (String) user_login;
		}
		Object obileNumber= session.getAttribute("mobileNo");
		mobileNumber=String.valueOf(obileNumber);
        if(mobileNumber!=null) {
            UserRegistrationDetails user=userService.getUserByMobileNo(mobileNumber);
			Object as_status=session.getAttribute("as_status");

		  if(birthCertificate!=null) {
			  
			  RTIApplication rtiApplication=new RTIApplication();
				 BirthRegistrationRestDTO  birthRegistrationRestDTO = new BirthRegistrationRestDTO();
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setTemplateName("birthApplication");
				rtiApplication.setSubject("BIRTH-CERTIFICATE");
				rtiApplication.setDepartment("HEALTH-DEPARTMENT");
				
				rtiApplication.setWorkFlowStatus(0);						
				rtiApplication.setFinalStatus("0");	 
				rtiApplication.setRtiserviceid(1);
				//rtiApplication.setPdf_upload_from_portal(birthRegistrationRestDTO.getPdfsavedpath());
				rtiApplication.setApplicantName(birthCertificate.getApplicantFullName());
				if(as_status!=null && user_name==null) {
					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
					
				}
				rtiApplication.setPhoneNumber(birthCertificate.getPh_no());
				rtiApplication.setMobileNumber(birthCertificate.getPh_no());
				rtiApplication.setEmail(birthCertificate.getEmail());
				rtiApplication.setPdfUploadFromPortal(birthCertificate.getFilesPath());
				 rtiApplication.setZone(birthCertificate.getZone());
					rtiApplication.setUserRegistrationDetails(user);
					rtiApplication.setIsApleSarkarApp(0);

				//rtiApplication.setPdfFilesSavedPath();
				
				//rtiApplication.setWard_name(birthRegistrationRestDTO.getZone_name());
					double amount = feesMasterController.setBirthFeesApplicable(birthCertificate.getCertificateExpectedInDays(), birthCertificate.getNoOfCertificateCopies(),1);
				if(amount>0) {
				rtiApplication.setApplicationCost(amount);
				}else {
					request.getSession().setAttribute("errMessage", "Something Went Wrong!!");
					return new ModelAndView("redirect:/ws/rtiapplication/newRTIBirthApplication.do");

				}
				
				//rtiApplication.setTenancy("1");
				//rtiApplication.setRtiApplnNumber("RTI/2022/BIRTH");
				
				//rtiApplication.setApplicantName(birthRegistrationRestDTO.getName());			
				List<RTIApplicationDetails> rtiApplicationDetailsList  = new ArrayList<RTIApplicationDetails>(); 
				RTIApplicationDetails rtiApplicationDetails=new RTIApplicationDetails();
						
				
				rtiApplicationDetails.setRtiApplication(rtiApplication);
				rtiApplicationDetails.setStatus(0);	
				rtiApplicationDetails.setAssignToStatus(1);	
				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
				
				rtiApplicationDetails.setComments("Form Submitted");//();
				rtiApplicationDetails.setWorkflowLevel(0);			
				rtiApplicationDetailsList.add(rtiApplicationDetails);		
				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
				RTIApplication savedRti=rtiApplicationService.merge(rtiApplication);
				
				
				//birthRegistrationService.getBirthRegistrationList(rTIApplicationSearch);
				
				//if(birthRegistrationService.birthRegistrationCertificate(birthRegistration){
				RTIApplication retunRti = null;
				if(savedRti.getRtiApplicationId()>0){
					RTIApplication rti=rtiApplicationService.get(savedRti.getRtiApplicationId());
					rti.setRtiApplnNumber("RTS/HD"+"/" + savedRti.getRtiApplicationId() +"/"+Year.now());
					birthCertificate.setRtiapplrefno(rti.getRtiApplnNumber());
					birthCertificate.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id=birthCertificateService.birthCertificate(birthCertificate);
					rti.setRtiApplicationRefId(birth_regis_id);
					//rti.setRtiApplicationRefId(birthRegistrationService.);
					
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
					 retunRti=rtiApplicationService.merge(rti);
				
					
					if((retunRti!=null) && (birth_regis_id>0)){
						birthRegistrationRestDTO.setResponseStatus("Requested data saved successfully");
						birthRegistrationRestDTO.setResponse(retunRti.getRtiApplicationId());
						birthRegistrationRestDTO.setResult(retunRti.getRtiApplnNumber());
					}
		 
					String name=birthCertificate.getApplicantFirstName()+" "+birthCertificate.getApplicantMiddleName()+" "+birthCertificate.getApplicantLastName();
					String applnNo = rti.getRtiApplnNumber();
					//String appId = rti.getRtiApplnNumber();

					String mobileNo = birthCertificate.getPh_no();
					String email=birthCertificate.getEmail();
					SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
		 //birthRegistrationService.birthRegistrationCertificate(birthRegistration);
			//  birthCertificateService.birthRegistrationCertificate(birthCertificate);
			  }
//			ModelAndView modelAndView = new ModelAndView("newRTIBirthApplicationSuccess");
//				modelAndView.addObject("result","Save successfully done");
//				return modelAndView;
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
						int estServiceDays=1;
						String estServiceDate="NA";
						double amt=0.0;

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
						String mobileApla = birthCertificate.getPh_no();
						
						
						/*
						 * String[] fields = request.getParameterValues("fields"); for (int i = 0; i <
						 * fields.length; i++) { log.debug("Index controller XXX--> " + i + ": " +
						 * fields[i]); }
						 */

						// String retrurnurl="https://nagpur.egovmars.in/RTSservices/ws/rtsapplication/newRtSBirthSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
						//String retrurnurl="https://nagpur.egovmars.in/RTSservices/as/rtsapplication/newRTSSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber();
						 String retrurnurl="https://nmcnagpur.gov.in/RTSservices/ws/rtsapplication/newRtSBirthSuccess.do?rtsAppNo="+appId+ "&isApleSarkar="+ retunRti.getIsApleSarkarApp();

						String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,
								name, str,serviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
								 digitalSignStatus,digitalSignDate,estServiceDays, 
								 estServiceDate,amount,reqFlag,appStatus,remark,distric,mobileApla); 
						
					log.debug("Final  PushBAck status XXX for form save-->>>"+pushBackrespose);
					log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
							" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
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
				return new ModelAndView("redirect:/ws/rtsapplication/newRtSBirthSuccess.do?rtsAppNo="+retunRti.getRtiApplnNumber()
				 + "&isApleSarkar="+ retunRti.getIsApleSarkarApp() 
						);
				}
		  }
        }
		return new ModelAndView("redirect:/ws/user/login.do");

	}
	
	@RequestMapping("ws/rtsapplication/newRtSBirthSuccess.do")
	public ModelAndView newRtSBirthSuccess(HttpServletRequest
	request,HttpServletResponse response) {

	 String appNo = request.getParameter("rtsAppNo");
	 log.debug("success appno"+appNo);
		String isApleSarkar=request.getParameter("isApleSarkar");

	 ModelAndView model = new
	ModelAndView("newRTIBirthApplicationSuccess");

	 model.addObject("appNo",appNo);
		model.addObject("isApleSarkar", isApleSarkar);

	 return model;


	 } 

	


	
	
	@RequestMapping("/rtiapplication/createBirthCertificateWork.do")
	public ModelAndView createBirthCertificateWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		BirthCertificate birthCertificate = birCertificateService.get(applicationId);
		String email = birthCertificate.getEmail();
		String mobileNo = birthCertificate.getPh_no();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long refNo = rtiApplication.getRtiApplicationRefId();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		long isApleSarkarApp=rtiApplication.getIsApleSarkarApp();

		if (birthCertificate != null) {
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
					log.debug("Final  PushBAck status XXX for send demand-->>>"+pushBackrespose);
					log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
							" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
							" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
							" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
							" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
					);					}
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
					log.debug("Final  PushBAck status XXX for application close-->>>"+pushBackrespose);
					log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
							" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
							" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
							" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
							" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla);
				}
					//else {}
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
				log.debug("Final  PushBAck status XXX for rejected after payment-->>>"+pushBackrespose);
				log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
						" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
						" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
						" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
						" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
				);	
				}
					SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				}
			}else{
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
				log.debug("Final  PushBAck status XXX for rejected before payment-->>>"+pushBackrespose);
				log.debug("data pushing to pushBackrespose : "+ " distric:"+ distric+" trackid :"+trackid+" userid :"+userid+
						" mobile:"+mobile +" name:"+name+"str : "+str +" serviceId :"+serviceId+" appId :"+appId+ " retrurnurl:"+retrurnurl+
						" paymentStatus :"+paymentStatus +"paymentDate :"+paymentDate+" digitalSignStatus :"+digitalSignStatus+
						" digitalSignDate :"+digitalSignDate+" estServiceDays :"+estServiceDays +" estServiceDate :"+estServiceDate+
						" amount :"+amount+" reqFlag :"+reqFlag+" appStatus :"+appStatus+" remark :"+remark +" distric: "+distric+" mobileApla: "+mobileApla
				);	
				}
				SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

				request.setAttribute("workFlowCompleted", "1");
				
			}

		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_BIRTH_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView("redirect:/rtiapplication/editBirthRegistrationCertificate.do");
	}

	public static void setUploadDocsOnEditMode(HttpServletRequest request,ServletContext servletContext,String applicationType,RTIApplication rtiapplication){
		   
		   String appNum = String.valueOf(rtiapplication.getRtiApplicationId());
		   String mainDir = null;
		   ServletContext context = servletContext;
		   String downloadPath = rtiapplication.getPdfUploadFromPortal();
		   System.out.println("@@@@@@@@@@@@@@@@@@@@@@DOwnload Path"+downloadPath);
		   List<String> paths = null;
		   int count=0;
		   if(downloadPath!=null){
			   String[] pathArr = downloadPath.split(",");
			   System.out.println("@@@@@@@@@@@@@@@@@@@@@@pathArr Path"+pathArr);
			   for (String httppath : pathArr) {
				   if(count==0)
					   paths = new ArrayList<>(); 
				   paths.add(httppath);
				   count++;
			}
			   
		   }
		   request.setAttribute("downloadCount",count);
		   request.setAttribute("downloadPath",paths);
		   
		   if(appNum!=null && !appNum.equals("0")){
		    
		    //	if(applicationType.equals("BirthRegistration"))
		    		
		    		mainDir = servletContext.getRealPath("") +"/Upload/"+appNum+"/";
				if(applicationType.equals("DEBRIESPERMISSION"))
					mainDir = servletContext.getRealPath("") +"/DebriesPermissionUploads/"+appNum+"/";
				if(applicationType.equals("COMMUNITYCENTER"))
					mainDir = servletContext.getRealPath("") +"/CommunitycenterUploads/"+appNum+"/";
				if(applicationType.equals("FESTIVALPANDAL"))
					mainDir = servletContext.getRealPath("") +"/FestivalpandalUploads/"+appNum+"/";
				if(applicationType.equals("ROADDIGGING"))
					mainDir = servletContext.getRealPath("") +"/RoaddiggingUploads/"+appNum+"/";
				if(applicationType.equals("STALLFORDIWALI"))
					mainDir = servletContext.getRealPath("") +"/StallfordiwaliUploads/"+appNum+"/";
				if(applicationType.equals("STAGEPANDALINGROUND"))
					mainDir = servletContext.getRealPath("") +"/stagepandalingroundUploads/"+appNum+"/";
				if(applicationType.equals("SUCTIONPERMISSION"))
					mainDir = servletContext.getRealPath("") +"/suctionjettinguploads/"+appNum+"/";
				

			File idProofDir = new File(mainDir+"Upload");
			  if (idProofDir.exists()) {
				File[] idProofNameFiles = idProofDir.listFiles();
				if(idProofNameFiles.length>0){
					 request.setAttribute("idProofRequired",false);
					String[] idProofName = new String[10];
					int i=0;
					for (File file : idProofNameFiles) {
					    if (file.isFile()) {
					    	idProofName[i] = file.getName();
					        System.out.println(file.getName());
					        i++;
					    }
					}
					request.setAttribute("idProofName",idProofName);
				  }else{
					  request.setAttribute("idProofRequired",true);
			     	}
			   }else{
		     		request.setAttribute("idProofRequired",true);
		     	}
			  
			  File inspectionReportoneDir = new File(mainDir+"inspectionReportone");
			  if (inspectionReportoneDir.exists()) {
				File[] inspectionReportoneDirNameFiles = inspectionReportoneDir.listFiles();
				if(inspectionReportoneDirNameFiles.length>0){
					 request.setAttribute("inspectionReportoneRequired",false);
					String[] inspectionReportoneName = new String[10];
					int i=0;
					for (File file : inspectionReportoneDirNameFiles) {
					    if (file.isFile()) {
					    	inspectionReportoneName[i] = file.getName();
					        System.out.println(file.getName());
					        i++;
					    }
					}
					request.setAttribute("inspectionreport1",inspectionReportoneName);
				  }else{
					  request.setAttribute("inspectionReportoneRequired",true);
			     	}
			   }else{
		     		request.setAttribute("inspectionReportoneRequired",true);
		     	}
			  
			  File inspectionReporttwoDir = new File(mainDir+"inspectionReporttwo");
			  if (inspectionReporttwoDir.exists()) {
				File[] inspectionReporttwoDirNameFiles = inspectionReporttwoDir.listFiles();
				if(inspectionReporttwoDirNameFiles.length>0){
					 request.setAttribute("inspectionReporttwoRequired",false);
					String[] inspectionReporttwoName = new String[10];
					int i=0;
					for (File file : inspectionReporttwoDirNameFiles) {
					    if (file.isFile()) {
					    	inspectionReporttwoName[i] = file.getName();
					        System.out.println(file.getName());
					        i++;
					    }
					}
					request.setAttribute("inspectionreport2",inspectionReporttwoName);
				  }else{
					  request.setAttribute("inspectionReporttwoRequired",true);
			     	}
			   }else{
		     		request.setAttribute("inspectionReporttwoRequired",true);
		     	}
			  
			    File residProofDir = new File(mainDir+"dogPhoto");
			    if (residProofDir.exists()) {
				File[] residProofNameFiles = residProofDir.listFiles();
				if(residProofNameFiles.length>0){
					 request.setAttribute("residProofRequired",false);
				    String[] residProofName = new String[10];
					int j=0;
					for (File file : residProofNameFiles) {
					    if (file.isFile()) {
					    	residProofName[j] = file.getName();
					        System.out.println(file.getName());
					        j++;
					    }
					}
					request.setAttribute("residProofName",residProofName);
			     	}else{
			     		request.setAttribute("residProofRequired",true);
			     	}
		         }else{
			     		request.setAttribute("residProofRequired",true);
			     	}

			    File mapofplaceDir = new File(mainDir+"mapofplace");
			    if (mapofplaceDir.exists()) {
				File[] mapofplaceNameFiles = mapofplaceDir.listFiles();
				if(mapofplaceNameFiles.length>0){
					 request.setAttribute("mapofplaceRequired",false);
				    String[] mapofplaceName = new String[10];
					int k=0;
					for (File file : mapofplaceNameFiles) {
					    if (file.isFile()) {
					    	mapofplaceName[k] = file.getName();
					        System.out.println(file.getName());
					        k++;
					    }
					}
					request.setAttribute("mapofplaceName",mapofplaceName);
			     	}else{
			     		request.setAttribute("mapofplaceRequired",true);
			     	}
		         }else{
			     		request.setAttribute("mapofplaceRequired",true);
			     	}
			    File psnocDir = new File(mainDir+"psnoc");
			    if (psnocDir.exists()) {
				File[] psnocNameFiles = psnocDir.listFiles();
				if(psnocNameFiles.length>0){
					 request.setAttribute("psnocRequired",false);
				    String[] psnocName = new String[10];
					int l=0;
					for (File file : psnocNameFiles) {
					    if (file.isFile()) {
					    	psnocName[l] = file.getName();
					        System.out.println(file.getName());
					        l++;
					    }
					}
					request.setAttribute("psnocName",psnocName);
			     	}else{
			     		request.setAttribute("psnocRequired",true);
			     	}
		         }else{
			     		request.setAttribute("psnocRequired",true);
			     	}
			    File firenocDir = new File(mainDir+"firenoc");
			    if (firenocDir.exists()) {
				File[] firenocNameFiles = firenocDir.listFiles();
				if(firenocNameFiles.length>0){
					 request.setAttribute("firenocRequired",false);
				    String[] firenocName = new String[10];
					int l=0;
					for (File file : firenocNameFiles) {
					    if (file.isFile()) {
					    	firenocName[l] = file.getName();
					        System.out.println(file.getName());
					        l++;
					    }
					}
					request.setAttribute("firenocName",firenocName);
			     	}else{
			     		request.setAttribute("firenocRequired",true);
			     	}
		         }else{
			     		request.setAttribute("firenocRequired",true);
			     	}
			    File placenocDir = new File(mainDir+"placenoc");
			    if (placenocDir.exists()) {
				File[] placenocNameFiles = placenocDir.listFiles();
				if(placenocNameFiles.length>0){
					 request.setAttribute("placenocRequired",false);
				    String[] placenocName = new String[10];
					int m=0;
					for (File file : placenocNameFiles) {
					    if (file.isFile()) {
					    	placenocName[m] = file.getName();
					        System.out.println(file.getName());
					        m++;
					    }
					}
					request.setAttribute("placenocName",placenocName);
			     	}else{
			     		request.setAttribute("placenocRequired",true);
			     	}
		         }else{
			     		request.setAttribute("placenocRequired",true);
			     	}
			    File concertDir = new File(mainDir+"concert");
			    if (concertDir.exists()) {
				File[] concertNameFiles = concertDir.listFiles();
				if(concertNameFiles.length>0){
					 request.setAttribute("concertRequired",false);
				    String[] concertName = new String[10];
					int n=0;
					for (File file : concertNameFiles) {
					    if (file.isFile()) {
					    	concertName[n] = file.getName();
					        System.out.println(file.getName());
					        n++;
					    }
					}
					request.setAttribute("concertName",concertName);
			     	}else{
			     		request.setAttribute("concertRequired",true);
			     	}
		         }else{
			     		request.setAttribute("concertRequired",true);
			     	}
	      }else{
	    	  request.setAttribute("residProofRequired",true);
	    	  request.setAttribute("idProofRequired",true);
	    	  request.setAttribute("concertRequired",true);
	    	  request.setAttribute("placenocRequired",true);
	    	  request.setAttribute("psnocRequired",true);
	    	  request.setAttribute("firenocRequired",true);
	    	  request.setAttribute("mapofplaceRequired",true);
	    	  request.setAttribute("inspectionReportoneRequired",true);
	    	  request.setAttribute("inspectionReporttwoRequired",true);
	      }
	 }
	
	
	public static String generateCheckSumValue(String reqStr) {
	    byte[] bytes = reqStr.getBytes(StandardCharsets.US_ASCII);
	    CRC32 crc32 = new CRC32();
	    crc32.update(bytes);
	    long checksumvalue = crc32.getValue();
	    return Long.toString(checksumvalue);
	}
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
	
}
