package com.mars.rti.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.DecimalFormat;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.model.User;
//import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.DepartmentService;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.service.UserService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.Constants;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.BirthCertificate;
import com.mars.rti.model.Collection;
import com.mars.rti.model.FireApplicationDTO;
import com.mars.rti.model.FireBuildingHeight;
import com.mars.rti.model.FireDepartmentWiseLogin;
import com.mars.rti.model.FireDetails;
import com.mars.rti.model.FireFeesMasterUpdated;
import com.mars.rti.model.FireFloorName;
import com.mars.rti.model.FireFloorTypes;
import com.mars.rti.model.FireRecommendation;
import com.mars.rti.model.FireRecommendationTypeOfBuilding;
import com.mars.rti.model.FireSubDepartmentWiseLogin;
import com.mars.rti.model.FireTypeOfConstruction;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.model.SubTypeOfbuilding;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.FireBuildingHeightService;
import com.mars.rti.service.FireDepartmentWiseLoginService;
import com.mars.rti.service.FireDetailsService;
import com.mars.rti.service.FireFeesMasterUpdatedService;
import com.mars.rti.service.FireFloorNameService;
import com.mars.rti.service.FireFloorTypesService;
import com.mars.rti.service.FireRecommendationService;
import com.mars.rti.service.FireRecommendationTypeOfBuildingService;
import com.mars.rti.service.FireSubDepartmentWiseLoginService;
import com.mars.rti.service.FireTypeOfConstructionService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.SubTypeOfbuildingService;
import com.mars.rti.utils.AESUtil;
import com.mars.rti.utils.CoreConstants;
import com.mars.workflow.model.PersonalTask;
import com.mars.workflow.model.WorkflowProcessDetails;
import com.mars.workflow.model.WorkflowTemplateUserMappingDetails;
import com.mars.workflow.service.WorkflowProcessDetailsService;
import com.mars.workflow.service.WorkflowService;
import com.mars.workflow.utils.WorkflowConstants;

@Controller
public class FireRecommendationController {
//	extends MultiActionController implements InitializingBean
	private static Log  log = LogFactory.getLog(FireRecommendationController.class);

	@Autowired
	private FireRecommendationService fireRecommendationService;
	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private DepartmentService departmentService;

	
	@Autowired
	private FireRecommendationTypeOfBuildingService fireRecommendationTypeOfBuildingService;
	
	@Autowired
	private FireTypeOfConstructionService fireTypeOfConstructionService;
	
	@Autowired
	private FireBuildingHeightService fireBuildingHeightService;
	
	@Autowired
	private FireFloorNameService fireFloorNameService;
	
	@Autowired
	private SubTypeOfbuildingService subTypeOfbuildingService;
	
	@Autowired
	private FireFloorTypesService fireFloorTypesService;
	
	private static String const_OrderBy = "OrderBy";

	private static String const_SortBy = "SortBy";

	@Autowired
	private WorkflowProcessDetailsService workflowProcessDetailsService;
//
//	@Autowired
//	AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;
	
	@Autowired
	private UserRegistrationService userService;
	
	@Autowired
	private UserService uService;


	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private FireDetailsService fireDetailsService;
	
	@Autowired
	private FireFeesMasterUpdatedService fireFeesMasterUpdatedService;
	
	@Autowired
	private FireDepartmentWiseLoginService fireDepartmentWiseLoginService;

	@Autowired
	private FireSubDepartmentWiseLoginService fireSubDepartmentWiseLoginService;
	
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 50; // 10MB
	private static final int REQUEST_SIZE = 1024 * 1024 * 100; // 50MB

// 	@RequestMapping("ws/rtiapplication/newRTIMandapApplication.do")
// 	public ModelAndView newRTIMandapApplication(HttpServletRequest request, HttpServletResponse response)
// 			throws ServletException {
// 		String baseDir = getServletContext().getRealPath("");
//		String folder = "mandapPermission";
//		File file = new File(baseDir, folder);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
// 		ModelAndView modelAndView = new ModelAndView("newRTIMandapApplication");
//		modelAndView.addObject("folderName", folder);
// 		return modelAndView;l
// 	}

//	@RequestMapping("/rtsapplication/saveFireRecommendationLatter.do")
//	public ModelAndView saveFireRecommendation(HttpServletRequest request, HttpServletResponse response,
//			FireRecommendation fireRecommendation) throws ServletException, Exception {
//
//		HttpSession session = request.getSession(true);
//		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
//
//		if (log.isDebugEnabled()) {
//			log.debug("Invoking Fire");
//		}
//		if (log.isDebugEnabled()) {
//			log.debug("Invoking FireRecommendation");
//		}
//		
////		String str = "1C273EB8FF9134E63E400953BFFD82CA6714E31B3507E1BBAA13BB2497725EC1532DC8022CA708266A12A05C2F358F1AD6411CCE7546EFC3D74618F7DBE16E1E471CB6D015EC0A28DCDCA45FCFECE51ED24D289525FB7C4D24CC5278032D8183DFFBB526BA38D8549A2A7B7B0F4BA3338AFF9B8C6E95DF378D19EB37E92990EC";
////		String serviceId = "NMCDeptN";
////			String Respponse =	aapleSarkarPortalIntegrationNagpur.authentication(str, serviceId);
////			
////			String xmlResponse = apleSarkarController.getXMLResponse(str, serviceId);
//		String mobileNumber = "";
//		String user_name=null;
//		Object user_login= request.getSession().getAttribute("name");
//		if(user_login!=null) {
//			 user_name = (String)user_login;
//		}
//		Object obileNumber= session.getAttribute("mobileNo");
//		if(obileNumber!=null) {
//		mobileNumber=String.valueOf(obileNumber);
//		}else {
//		mobileNumber = (String) session.getAttribute("mobileNo");
//		}
//		if (mobileNumber != null) {
//			UserRegistrationDetails user = userService.getUserByMobileNo(mobileNumber);
//			//Object as_status=session.getAttribute("as_status");
//
//			if (fireRecommendation != null) {
//				
//				
//
//				RTIApplication rtiApplication = new RTIApplication();
//				//MandapPermi mandapPermissionRestDTO = new MandapPermissionRestDTO();
//				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
//				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
//				rtiApplication.setSubject("FIRE-Recommendation");
//				rtiApplication.setDepartment("FIRE-DEPARTMENT");
//				rtiApplication.setTemplateName("fire");	
//				rtiApplication.setWorkFlowStatus(-1);
//				rtiApplication.setFinalStatus("0");
//				rtiApplication.setRtiserviceid(69);
//				rtiApplication.setIsApleSarkarApp(0);
//
//				
//				rtiApplication.setFirstPaymentFees(fireRecommendation.getScrutinyFeesOnAboveTotal());
//				rtiApplication.setApplicantName(fireRecommendation.getFirstName() + " " + fireRecommendation.getMiddleName()
//						+ " " + fireRecommendation.getLastName());
////				if(as_status!=null && user_name==null) {
////					rtiApplication.setAapleSarkarUserMobileNo(mobileNumber);
////					
////				}
//				rtiApplication.setPhoneNumber(fireRecommendation.getMobileNo());
//				rtiApplication.setMobileNumber(fireRecommendation.getMobileNo());
//				
//				if(fireRecommendation.getFireSubDepartmentWiseLogin().equals("2")||fireRecommendation.getFireSubDepartmentWiseLogin().equals("3"))
//				{
//					rtiApplication.setZone("10");
//				}
//				else
//				{
//					rtiApplication.setZone(fireRecommendation.getFireDepartmentWiseLogin());
//				}
//				rtiApplication.setEmail(fireRecommendation.getAppEmail());
////				rtiApplication.setZone(fireRecommendation.getZoneNO());
//				rtiApplication.setUserRegistrationDetails(user);
//
////				rtiApplication.setAppliscationCost((fireRecommendation.getTotalFees()));
//
//				rtiApplication.setApplicantName(fireRecommendation.getFullName());
//				rtiApplication.setPdfUploadFromPortal(fireRecommendation.getFilesPath());
//				List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
//				RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();
//				
//				rtiApplicationDetails.setRtiApplication(rtiApplication);
//				rtiApplicationDetails.setStatus(0);
//				rtiApplicationDetails.setAssignToStatus(1);
//				rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
//				rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());
//
//				rtiApplicationDetails.setComments("Form Submitted");// ();
//				rtiApplicationDetails.setWorkflowLevel(0);
//				rtiApplicationDetailsList.add(rtiApplicationDetails);
//				rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
//				RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);
//
//				if (savedRti.getRtiApplicationId() > 0) {
//
//					RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
//					rti.setRtiApplnNumber("RTS/FD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
//			    	fireRecommendation.setForwardedToL1(false);
//					fireRecommendation.setRtiapplrefno(rti.getRtiApplnNumber());
//					fireRecommendation.setRti_ref_id(savedRti.getRtiApplicationId());
//					long fire_regis_id = fireRecommendationService.fireRecommendation(fireRecommendation);
//					fireRecommendation.setFireRecommendationId(fire_regis_id);
//					rti.setRtiApplicationRefId(fire_regis_id);
//					// rti.setRtiApplicationRefId(birthRegistrationService.);
//					
//
////					 long typeOfBuilding = Long.parseLong(request.getParameter("typeOfBuilding"));
//			          long typeOfConstruction = Long.parseLong(request.getParameter("typeOfConstruction"));
//			          long typeOfHeight = Long.parseLong(request.getParameter("typeOfHeight"));
//			          long catagory = 1;
//
////					String totalTable[] = request.getParameterValues("totalTable");
//			          String fireFloorTypesArr[] = request.getParameterValues("fireFloorTypes[]");
//					BigDecimal commericaial[] = toBigDecimalArray(request.getParameterValues("commArea"));
//					String floorName[] = request.getParameterValues("floorName");
//					BigDecimal residArea[] = toBigDecimalArray(request.getParameterValues("residArea"));
//					BigDecimal primumAr[] = toBigDecimalArray(request.getParameterValues("primumAr"));
//					BigDecimal otherUse[] = toBigDecimalArray(request.getParameterValues("otherUse"));
//					BigDecimal rowWiseTotal[] = toBigDecimalArray(new String [floorName.length]);
//
//					FireFeesMasterUpdated fireFeesMasterUpdated = null;
//					
//					double getFeesFromBackend = 0.0;
//			         double addAreaFromFrontEnd = 0.0;
//			         double rowWisefees = 0.0;
//			         double grandTotal=0.0;
//			         DecimalFormat df = new DecimalFormat("#.####");
//			         double [] rowWiseTotalFeesToBeShown = new double[floorName.length];
//			         
//			         double totalResidAreaaD = 0.0;
//			      	  double totalCommAreaaD = 0.0;
//			      	  double totalPrimumArrD = 0.0;
//			      	  double totalOtherUseeD = 0.0;
//			         
//			      	for (int i = 0; i < floorName.length; i++) {
//
//			      	    FireDetails f = new FireDetails();
//
//
//if (commericaial != null) f.setCommArea(commericaial[i]);
//if (floorName != null)    f.setFloorName(floorName[i]);
//if (residArea != null)    f.setResidArea(residArea[i]);
//if (otherUse != null)     f.setOtherUse(otherUse[i]);
//if (primumAr != null)     f.setPrimumAr(primumAr[i]);
//
////			      	    if (commericaial != null) f.setCommArea(commericaial[i]);
////			      	    if (floorName != null) f.setFloorName(floorName[i]);
////			      	    if (residArea != null) f.setResidArea(residArea[i]);
////			      	    if (otherUse != null) f.setOtherUse(otherUse[i]);
////			      	    if (primumAr != null) f.setPrimumAr(primumAr[i]);
//			      	  if (fireFloorTypesArr != null) {
//			              f.setFireFloorTypes(fireFloorTypesArr[i]);
//			          }
//			      	    f.setFireRecommendation(fireRecommendation);
//
//			      	    long fN = Long.parseLong(floorName[i]);
//
//			      	  //  double rowTotal = 0.0;  // ✅ FIX: use row-wise total
//			      	    
//			      	  BigDecimal rowTotal = BigDecimal.ZERO;
//
//			      	// Commercial
//			      	if (commericaial[i] != null) {
//			      	    fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(3, typeOfConstruction, typeOfHeight, catagory, fN);
//			      	    BigDecimal masterFees = new BigDecimal(fireFeesMasterUpdated.getMasterFees());
//			      	    rowTotal = rowTotal.add(commericaial[i].multiply(masterFees));
//			      	}
//
//			      	// Residential
//			      	if (residArea[i] != null) {
//			      	    fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(1, typeOfConstruction, typeOfHeight, catagory, fN);
//			      	    BigDecimal masterFees = new BigDecimal(fireFeesMasterUpdated.getMasterFees());
//			      	    rowTotal = rowTotal.add(residArea[i].multiply(masterFees));
//			      	}
//
//			      	// Premium
//			      	if (primumAr[i] != null) {
//			      	    fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(2, typeOfConstruction, typeOfHeight, catagory, fN);
//			      	    BigDecimal masterFees = new BigDecimal(fireFeesMasterUpdated.getMasterFees());
//			      	    rowTotal = rowTotal.add(primumAr[i].multiply(masterFees));
//			      	}
//
//			      	// Other
//			      	if (otherUse[i] != null) {
//			      	    fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(4, typeOfConstruction, typeOfHeight, catagory, fN);
//			      	    BigDecimal masterFees = new BigDecimal(fireFeesMasterUpdated.getMasterFees());
//			      	    rowTotal = rowTotal.add(otherUse[i].multiply(masterFees));
//			      	}
//
//			      	rowTotal = rowTotal.setScale(4, RoundingMode.HALF_UP);
//			      	f.setRowWiseTotal(rowTotal);
//			      	
//			      	
//
//			      	    // Commercial
////			      	    if (commericaial[i] != null && !commericaial[i].equals("")) {
////			      	        double comm = Double.parseDouble(commericaial[i]);
////			      	        fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(3, typeOfConstruction, typeOfHeight, catagory, fN);
////			      	        rowTotal += comm * Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
////			      	    }
////
////			      	    // Residential
////			      	    if (residArea[i] != null && !residArea[i].equals("")) {
////			      	        double resid = Double.parseDouble(residArea[i]);
////			      	        fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(1, typeOfConstruction, typeOfHeight, catagory, fN);
////			      	        rowTotal += resid * Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
////			      	    }
////
////			      	    // Premium
////			      	    if (primumAr[i] != null && !primumAr[i].equals("")) {
////			      	        double premium = Double.parseDouble(primumAr[i]);
////			      	        fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(2, typeOfConstruction, typeOfHeight, catagory, fN);
////			      	        rowTotal += premium * Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
////			      	    }
////
////			      	    // Other
////			      	    if (otherUse[i] != null && !otherUse[i].equals("")) {
////			      	        double other = Double.parseDouble(otherUse[i]);
////			      	        fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(4, typeOfConstruction, typeOfHeight, catagory, fN);
////			      	        rowTotal += other * Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
////			      	    }
////
////			      	    rowTotal = Double.parseDouble(df.format(rowTotal));
////
////			      	    f.setRowWiseTotal(rowTotal + "");
////
//			      	    rowWiseTotalFeesToBeShown[i] = rowTotal;
////
//			      	    grandTotal += rowTotal;  // ✅ correct
//
//			      	    fireDetailsService.saveFireDetails(f);
//			      	}
//			              fireRecommendation.setTotalFeess(df.format(grandTotal)+"");
//			              double scrutinyFees = 0.0;
//			              
//			             
//					
//					
//					String name = fireRecommendation.getFullName();
//					String link = "https://tinyurl.com/4hhhy9w9";
//					String applnNo = rti.getRtiApplnNumber();
//
//					String mobileNo = fireRecommendation.getMobileNo();
//					String email=fireRecommendation.getAppEmail();
//					//SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
//
//					
//						scrutinyFees = Double.parseDouble(df.format((grandTotal*2)/100));
//			              rti.setFirstPaymentFees(scrutinyFees+"");
//			              fireRecommendation.setFirstPaymentFees(scrutinyFees+"");
//			              fireRecommendation.setScrutinyFeesOnAboveTotal(scrutinyFees+"");
//			              rti.setApplicationCost(Double.parseDouble(df.format(grandTotal)));
//			              RTIApplication retunRti = rtiApplicationService.merge(rti);
//			              fireRecommendationService.saveFireForm(fireRecommendation);
//
//						rtiApplicationService.save(savedRti);
//					
//						return new ModelAndView("redirect:/ws/search.do?rtsAppNo="+retunRti.getRtiApplicationId());
//				
//					
////
////					String msg = "Dear " + name + " your application with Application No. " + applnNo
////							+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";
////
////					msg.replace("var3", "");
////
////					SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", fireRecommendation.getMobileNo(), msg);
////					SendEmail.sendEmail(fireRecommendation.getAppEmail(), "Application Submitted Successfully" + applnNo,
////							msg);
//				}
//				
//
//			}
//			
//		}
//		
//		
////		ModelAndView modelAndView = new ModelAndView("newRTIMandapPermissionSucess");
////		modelAndView.addObject("result", "Save successfully done");
//		return new ModelAndView("redirect:/ws/user/login.do");
//		
////		 return new ModelAndView( "redirect:/newRTIMandapPermissionSucess.jsp");
//
//		/*
//		 * ModelAndView modelAndView = new ModelAndView("redirect:/abc.htm");
//		 * modelAndView.addObject("newRTIMandapPermissionSucess" , new
//		 * ModelAttribute()); return modelAndView;
//		 */
//	}
//	
	
	
	@RequestMapping("/rtsapplication/saveFireRecommendationLatter.do")
	public ModelAndView saveFireRecommendation(HttpServletRequest request, HttpServletResponse response,
	        FireRecommendation fireRecommendation) throws ServletException, Exception {

	    HttpSession session = request.getSession(true);
	    SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

	    if (log.isDebugEnabled()) {
	        log.debug("Invoking Fire");
	    }
	    if (log.isDebugEnabled()) {
	        log.debug("Invoking FireRecommendation");
	    }

	    String mobileNumber = "";
	    String user_name = null;
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

	        if (fireRecommendation != null) {

	            RTIApplication rtiApplication = new RTIApplication();
	            rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
	            rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
	            rtiApplication.setSubject("FIRE-Recommendation");
	            rtiApplication.setDepartment("FIRE-DEPARTMENT");
	            rtiApplication.setTemplateName("fire");
	            rtiApplication.setWorkFlowStatus(-1);
	            rtiApplication.setFinalStatus("0");
	            rtiApplication.setRtiserviceid(69);
	            rtiApplication.setIsApleSarkarApp(0);

	            rtiApplication.setFirstPaymentFees(fireRecommendation.getScrutinyFeesOnAboveTotal());
	            rtiApplication.setApplicantName(fireRecommendation.getFirstName() + " " + fireRecommendation.getMiddleName()
	                    + " " + fireRecommendation.getLastName());

	            rtiApplication.setPhoneNumber(fireRecommendation.getMobileNo());
	            rtiApplication.setMobileNumber(fireRecommendation.getMobileNo());

//	            if (fireRecommendation.getFireSubDepartmentWiseLogin().equals("2")
//	                    || fireRecommendation.getFireSubDepartmentWiseLogin().equals("3")) {
//	                rtiApplication.setZone("10");
//	            } else {
	                rtiApplication.setZone(fireRecommendation.getFireDepartmentWiseLogin());
	           // }
	            rtiApplication.setEmail(fireRecommendation.getAppEmail());
	            rtiApplication.setUserRegistrationDetails(user);

	            rtiApplication.setApplicantName(fireRecommendation.getFullName());
	            rtiApplication.setPdfUploadFromPortal(fireRecommendation.getFilesPath());
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
	            RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);

	            if (savedRti.getRtiApplicationId() > 0) {

	                RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
	                rti.setRtiApplnNumber("RTS/FD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
	                fireRecommendation.setForwardedToL1(false);
	                fireRecommendation.setRtiapplrefno(rti.getRtiApplnNumber());
	                fireRecommendation.setRti_ref_id(savedRti.getRtiApplicationId());
	                long fire_regis_id = fireRecommendationService.fireRecommendation(fireRecommendation);
	                fireRecommendation.setFireRecommendationId(fire_regis_id);
	                rti.setRtiApplicationRefId(fire_regis_id);

	                long typeOfConstruction = Long.parseLong(request.getParameter("typeOfConstruction"));
	                long typeOfHeight = Long.parseLong(request.getParameter("typeOfHeight"));
	                long catagory = 1;

	                String fireFloorTypesArr[] = request.getParameterValues("fireFloorTypes[]");
	                String floorName[] = request.getParameterValues("floorName");

//	                BigDecimal commericaial[] = toBigDecimalArray(request.getParameterValues("commArea"));
//	                log.debug("commericaial :"+commericaial[]);
//	                BigDecimal residArea[]    = toBigDecimalArray(request.getParameterValues("residArea"));
//	                log.debug("commericaial :"+residArea[]);
//
//	                BigDecimal primumAr[]     = toBigDecimalArray(request.getParameterValues("primumAr"));
//	                log.debug("commericaial :"+primumAr[]);
//
//	                BigDecimal otherUse[]     = toBigDecimalArray(request.getParameterValues("otherUse"));
//	                log.debug("commericaial :"+otherUse[]);
	                String commArea[] = request.getParameterValues("commArea");
	                String residArea[] = request.getParameterValues("residArea");
	                String primumAr[] = request.getParameterValues("primumAr");
	                String otherUse[] = request.getParameterValues("otherUse");

	                BigDecimal rowWiseTotal[] = new BigDecimal[floorName.length];

	                FireFeesMasterUpdated fireFeesMasterUpdated = null;

	                BigDecimal grandTotal = BigDecimal.ZERO;

//	                for (int i = 0; i < floorName.length; i++) {
//
//	                    FireDetails f = new FireDetails();
//
//	                    if (commericaial != null) f.setCommArea(commericaial[i]);
//	                    if (floorName != null)    f.setFloorName(floorName[i]);
//	                    if (residArea != null)    f.setResidArea(residArea[i]);
//	                    if (otherUse != null)     f.setOtherUse(otherUse[i]);
//	                    if (primumAr != null)     f.setPrimumAr(primumAr[i]);
//	                    
//	                    log.debug("Commercial : " + commericaial[i]);
//	                    log.debug("Residential : " + residArea[i]);
//	                    log.debug("Premium : " + primumAr[i]);
//	                    log.debug("Other : " + otherUse[i]);
//	                    
//	                    if (fireFloorTypesArr != null) {
//	                        f.setFireFloorTypes(fireFloorTypesArr[i]);
//	                    }
//	                    f.setFireRecommendation(fireRecommendation);
//
//	                    long fN = Long.parseLong(floorName[i]);
//
//	                    BigDecimal rowTotal = BigDecimal.ZERO;
//
//	                    // Commercial
//	                    if (commericaial[i] != null) {
//	                        fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(3, typeOfConstruction, typeOfHeight, catagory, fN);
//	                        BigDecimal masterFees = new BigDecimal(fireFeesMasterUpdated.getMasterFees());
//	                        rowTotal = rowTotal.add(commericaial[i].multiply(masterFees));
//	                        
//	                    }
//
//	                    // Residential
//	                    if (residArea[i] != null) {
//	                        fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(1, typeOfConstruction, typeOfHeight, catagory, fN);
//	                        BigDecimal masterFees = new BigDecimal(fireFeesMasterUpdated.getMasterFees());
//	                        rowTotal = rowTotal.add(residArea[i].multiply(masterFees));
//	                    }
//
//	                    // Premium
//	                    if (primumAr[i] != null) {
//	                        fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(2, typeOfConstruction, typeOfHeight, catagory, fN);
//	                        BigDecimal masterFees = new BigDecimal(fireFeesMasterUpdated.getMasterFees());
//	                        rowTotal = rowTotal.add(primumAr[i].multiply(masterFees));
//	                    }
//
//	                    // Other
//	                    if (otherUse[i] != null) {
//	                        fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(4, typeOfConstruction, typeOfHeight, catagory, fN);
//	                        BigDecimal masterFees = new BigDecimal(fireFeesMasterUpdated.getMasterFees());
//	                        rowTotal = rowTotal.add(otherUse[i].multiply(masterFees));
//	                    }
//
//	                    rowTotal = rowTotal.setScale(4, RoundingMode.HALF_UP);
//	                    f.setRowWiseTotal(rowTotal);
//	                    rowWiseTotal[i] = rowTotal;
//
//	                    grandTotal = grandTotal.add(rowTotal); // ✅ correct — BigDecimal + BigDecimal
//
//	                    fireDetailsService.saveFireDetails(f);
//	                }
	                
	                for (int i = 0; i < floorName.length; i++) {

	                    FireDetails f = new FireDetails();
//
//	                    BigDecimal commercial = getBigDecimal(commArea[i]);
//	                    BigDecimal residential = getBigDecimal(residArea[i]);
//	                    BigDecimal premium = getBigDecimal(primumAr[i]);
//	                    BigDecimal other = getBigDecimal(otherUse[i]);
//	                    
	                    BigDecimal commercial = (commArea != null && i < commArea.length)
	                            ? getBigDecimal(commArea[i])
	                            : BigDecimal.ZERO;

	                    BigDecimal residential = (residArea != null && i < residArea.length)
	                            ? getBigDecimal(residArea[i])
	                            : BigDecimal.ZERO;

	                    BigDecimal premium = (primumAr != null && i < primumAr.length)
	                            ? getBigDecimal(primumAr[i])
	                            : BigDecimal.ZERO;

	                    BigDecimal other = (otherUse != null && i < otherUse.length)
	                            ? getBigDecimal(otherUse[i])
	                            : BigDecimal.ZERO;

	                    f.setCommArea(commercial);

	                    if (floorName != null)
	                        f.setFloorName(floorName[i]);

	                    f.setResidArea(residential);
	                    f.setOtherUse(other);
	                    f.setPrimumAr(premium);

	                    log.debug("Commercial : " + commercial);
	                    log.debug("Residential : " + residential);
	                    log.debug("Premium : " + premium);
	                    log.debug("Other : " + other);

	                    if (fireFloorTypesArr != null) {
	                        f.setFireFloorTypes(fireFloorTypesArr[i]);
	                    }

	                    f.setFireRecommendation(fireRecommendation);

	                   // long fN = Long.parseLong(floorName[i]);
	                    long fN = 0;

	                    if(floorName != null &&
	                       floorName[i] != null &&
	                       !floorName[i].trim().isEmpty()){

	                        fN = Long.parseLong(floorName[i]);
	                    }

	                    BigDecimal rowTotal = BigDecimal.ZERO;

	                    // Commercial
	                    if (commercial.compareTo(BigDecimal.ZERO) > 0) {

	                        fireFeesMasterUpdated =
	                            fireFeesMasterUpdatedService.getList(
	                                3, typeOfConstruction,
	                                typeOfHeight, catagory, fN);

	                        BigDecimal masterFees =
	                            new BigDecimal(fireFeesMasterUpdated.getMasterFees());

	                        rowTotal = rowTotal.add(
	                            commercial.multiply(masterFees)
	                        );
	                    }

	                    // Residential
	                    if (residential.compareTo(BigDecimal.ZERO) > 0) {

	                        fireFeesMasterUpdated =
	                            fireFeesMasterUpdatedService.getList(
	                                1, typeOfConstruction,
	                                typeOfHeight, catagory, fN);

	                        BigDecimal masterFees =
	                            new BigDecimal(fireFeesMasterUpdated.getMasterFees());

	                        rowTotal = rowTotal.add(
	                            residential.multiply(masterFees)
	                        );
	                    }

	                    // Premium
	                    if (premium.compareTo(BigDecimal.ZERO) > 0) {

	                        fireFeesMasterUpdated =
	                            fireFeesMasterUpdatedService.getList(
	                                2, typeOfConstruction,
	                                typeOfHeight, catagory, fN);

	                        BigDecimal masterFees =
	                            new BigDecimal(fireFeesMasterUpdated.getMasterFees());

	                        rowTotal = rowTotal.add(
	                            premium.multiply(masterFees)
	                        );
	                    }

	                    // Other
	                    if (other.compareTo(BigDecimal.ZERO) > 0) {

	                        fireFeesMasterUpdated =
	                            fireFeesMasterUpdatedService.getList(
	                                4, typeOfConstruction,
	                                typeOfHeight, catagory, fN);

	                        BigDecimal masterFees =
	                            new BigDecimal(fireFeesMasterUpdated.getMasterFees());

	                        rowTotal = rowTotal.add(
	                            other.multiply(masterFees)
	                        );
	                    }

	                    rowTotal = rowTotal.setScale(4, RoundingMode.HALF_UP);

	                    f.setRowWiseTotal(rowTotal);

	                    grandTotal = grandTotal.add(rowTotal);

	                    fireDetailsService.saveFireDetails(f);
	                }

	                grandTotal = grandTotal.setScale(4, RoundingMode.HALF_UP);
	                fireRecommendation.setTotalFeess(grandTotal.toPlainString());

	                String name = fireRecommendation.getFullName();
	                String link = "https://tinyurl.com/4hhhy9w9";
	                String applnNo = rti.getRtiApplnNumber();

	                String mobileNo = fireRecommendation.getMobileNo();
	                String email = fireRecommendation.getAppEmail();

	                BigDecimal scrutinyFees = grandTotal
	                        .multiply(BigDecimal.valueOf(2))
	                        .divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);

	                rti.setFirstPaymentFees(scrutinyFees.toPlainString());
	                fireRecommendation.setFirstPaymentFees(scrutinyFees.toPlainString());
	                fireRecommendation.setScrutinyFeesOnAboveTotal(scrutinyFees.toPlainString());
	                rti.setApplicationCost(grandTotal.doubleValue());

	                RTIApplication retunRti = rtiApplicationService.merge(rti);
	                fireRecommendationService.saveFireForm(fireRecommendation);

	                rtiApplicationService.save(savedRti);
	                String token = AESUtil.encrypt(String.valueOf(retunRti.getRtiApplicationId()));

	                return new ModelAndView("redirect:/ws/search.do?token=" + URLEncoder.encode(token, "UTF-8"));

	               // return new ModelAndView("redirect:/ws/search.do?rtsAppNo=" + retunRti.getRtiApplicationId());
	            }
	        }
	    }

	    return new ModelAndView("redirect:/ws/user/login.do");
	}
	
	private BigDecimal getBigDecimal(String value) {

	    try {
	        if (value == null || value.trim().isEmpty()) {
	            return BigDecimal.ZERO;
	        }

	        return new BigDecimal(value.trim());

	    } catch(Exception e) {
	        return BigDecimal.ZERO;
	    }
	}
//	private BigDecimal[] toBigDecimalArray(String[] values) {
//	    if (values == null) return null;
//	    BigDecimal[] result = new BigDecimal[values.length];
//	    for (int i = 0; i < values.length; i++) {
//	        if (values[i] != null && !values[i].trim().isEmpty()) {
//	            result[i] = new BigDecimal(values[i].trim());
//	        } else {
//	            result[i] = null;
//	        }
//	    }
//	    return result;
//	}
	
	private BigDecimal[] toBigDecimalArray(String[] values) {

	    if (values == null)
	        return null;

	    BigDecimal[] result = new BigDecimal[values.length];

	    for (int i = 0; i < values.length; i++) {

	        try {

	            if (values[i] == null
	                    || values[i].trim().isEmpty()
	                    || values[i].trim().equalsIgnoreCase("None")) {

	                result[i] = BigDecimal.ZERO;
	            } else {

	                String value = values[i]
	                        .trim()
	                        .replace(",", "");

	                result[i] = new BigDecimal(value)
	                        .setScale(4, RoundingMode.HALF_UP);
	            }

	        } catch (Exception e) {

	            System.out.println("Invalid decimal value : " + values[i]);
	            result[i] = BigDecimal.ZERO;
	        }
	    }

	    return result;
	}
//	@RequestMapping("/rtsapplication/updateFireRecommendationLatter.do")
//	public ModelAndView updateFireRecommendation(HttpServletRequest request,
//	        HttpServletResponse response,
//	        FireRecommendation fireRecommendation) throws Exception {
//
//	    HttpSession session = request.getSession(true);
//
//	    String mobileNumber = (String) session.getAttribute("mobileNo");
//
//	    if (mobileNumber != null && fireRecommendation != null) {
//
//	       
//	        RTIApplication rti = rtiApplicationService.get(fireRecommendation.getRti_ref_id());
//
//	        if (rti == null) {
//	            throw new Exception("Application not found");
//	        }
//
//	       
//	        rti.setApplicantName(fireRecommendation.getFullName());
//	        rti.setMobileNumber(fireRecommendation.getMobileNo());
//	        rti.setPhoneNumber(fireRecommendation.getMobileNo());
//	        rti.setEmail(fireRecommendation.getAppEmail());
//	        rti.setPdfUploadFromPortal(fireRecommendation.getFilesPath());
//
//	        if (fireRecommendation.getFireSubDepartmentWiseLogin().equals("2") 
//	                || fireRecommendation.getFireSubDepartmentWiseLogin().equals("3")) {
//	            rti.setZone("10");
//	        } else {
//	            rti.setZone(fireRecommendation.getFireDepartmentWiseLogin());
//	        }
//
//	      
//	        FireRecommendation existingFire = fireRecommendationService
//	                .get(fireRecommendation.getFireRecommendationId());
//
//	        if (existingFire == null) {
//	            throw new Exception("Fire Recommendation not found");
//	        }
//
//	        // Copy updated fields
//	        existingFire.setFirstName(fireRecommendation.getFirstName());
//	        existingFire.setMiddleName(fireRecommendation.getMiddleName());
//	        existingFire.setLastName(fireRecommendation.getLastName());
//	        existingFire.setMobileNo(fireRecommendation.getMobileNo());
//	        existingFire.setAppEmail(fireRecommendation.getAppEmail());
//	        existingFire.setFilesPath(fireRecommendation.getFilesPath());
//
//	        existingFire.setDieselPump(fireRecommendation.getDieselPump());
//	        existingFire.setDieselPumpCapacity(fireRecommendation.getDieselPumpCapacity());
//	        existingFire.setJockyPump(fireRecommendation.getJockyPump());
//	        existingFire.setJockyPumpCapacity(fireRecommendation.getJockyPumpCapacity());
//	        existingFire.setBoosterPump(fireRecommendation.getBoosterPump());
//	        existingFire.setBoosterPumpCapacity(fireRecommendation.getBoosterPumpCapacity());
//
//	        existingFire.setNumInternalStaircaseProvided(fireRecommendation.getNumInternalStaircaseProvided());
//	        existingFire.setNumberOfExternal(fireRecommendation.getNumberOfExternal());
//	        existingFire.setNoLift(fireRecommendation.getNoLift());
//
//	        existingFire.setFireDepartmentWiseLogin(fireRecommendation.getFireDepartmentWiseLogin());
//	        existingFire.setFireSubDepartmentWiseLogin(fireRecommendation.getFireSubDepartmentWiseLogin());
//
//	       
//	        String[] fireFloorTypesArr = request.getParameterValues("fireFloorTypes[]");
//	        String[] commericaial = request.getParameterValues("commArea");
//	        String[] floorName = request.getParameterValues("floorName");
//	        String[] residArea = request.getParameterValues("residArea");
//	        String[] primumAr = request.getParameterValues("primumAr");
//	        String[] otherUse = request.getParameterValues("otherUse");
//
//	        List<FireDetails> existingList = fireRecommendationService
//	                .findByFireRecommendationId(existingFire.getFireRecommendationId());
//
//	        DecimalFormat df = new DecimalFormat("#.####");
//
//	        long typeOfConstruction = Long.parseLong(request.getParameter("typeOfConstruction"));
//	        long typeOfHeight = Long.parseLong(request.getParameter("typeOfHeight"));
//	        long catagory = 1;
//
//	        double grandTotal = 0.0;
//
//	        for (int i = 0; i < floorName.length; i++) {
//
//	            FireDetails f;
//
//	            // 👉 UPDATE EXISTING ROW (NO DELETE)
//	            if (i < existingList.size()) {
//	                f = existingList.get(i);
//	            } else {
//	                f = new FireDetails();
//	                f.setFireRecommendation(existingFire);
//	            }
//
//	            f.setFloorName(floorName[i]);
//	            f.setResidArea(residArea[i]);
//	            f.setCommArea(commericaial[i]);
//	            f.setPrimumAr(primumAr[i]);
//	            f.setOtherUse(otherUse[i]);
//
//	            if (fireFloorTypesArr != null) {
//	                f.setFireFloorTypes(fireFloorTypesArr[i]);
//	            }
//
//	            double rowTotal = 0.0;
//	            long fN = Long.parseLong(floorName[i]);
//
//	            FireFeesMasterUpdated fireFeesMasterUpdated;
//
//	            // Commercial
//	            if (commericaial[i] != null && !commericaial[i].equals("")) {
//	                double val = Double.parseDouble(commericaial[i]);
//	                fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(3, typeOfConstruction, typeOfHeight, catagory, fN);
//	                rowTotal += val * Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
//	            }
//
//	            // Residential
//	            if (residArea[i] != null && !residArea[i].equals("")) {
//	                double val = Double.parseDouble(residArea[i]);
//	                fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(1, typeOfConstruction, typeOfHeight, catagory, fN);
//	                rowTotal += val * Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
//	            }
//
//	            // Premium
//	            if (primumAr[i] != null && !primumAr[i].equals("")) {
//	                double val = Double.parseDouble(primumAr[i]);
//	                fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(2, typeOfConstruction, typeOfHeight, catagory, fN);
//	                rowTotal += val * Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
//	            }
//
//	            // Other
//	            if (otherUse[i] != null && !otherUse[i].equals("")) {
//	                double val = Double.parseDouble(otherUse[i]);
//	                fireFeesMasterUpdated = fireFeesMasterUpdatedService.getList(4, typeOfConstruction, typeOfHeight, catagory, fN);
//	                rowTotal += val * Double.parseDouble(fireFeesMasterUpdated.getMasterFees());
//	            }
//
//	            rowTotal = Double.parseDouble(df.format(rowTotal));
//	            f.setRowWiseTotal(rowTotal + "");
//
//	            grandTotal += rowTotal;
//
//	            fireDetailsService.saveFireDetails(f);
//	        }
//
//	      
//	        existingFire.setTotalFeess(df.format(grandTotal));
//
//	        double scrutinyFees = Double.parseDouble(df.format((grandTotal * 2) / 100));
//
//	        existingFire.setScrutinyFeesOnAboveTotal(scrutinyFees + "");
//	        existingFire.setFirstPaymentFees(scrutinyFees + "");
//
//	        rti.setFirstPaymentFees(scrutinyFees + "");
//	        rti.setApplicationCost(Double.parseDouble(df.format(grandTotal)));
//
//	   
//	        fireRecommendationService.updateFireForm(existingFire);
//	        rtiApplicationService.merge(rti);
//
//	        // SAME APPLICATION NUMBER
//	        return new ModelAndView("redirect:/ws/search.do?rtsAppNo=" + rti.getRtiApplicationId());
//	    }
//
//	    return null;
//	}
//	
//	@RequestMapping("/rtsapplication/editFireRecommendationLatter.do")
//	public ModelAndView editFireRecommendationLatter(HttpServletRequest request,
//	        HttpServletResponse response,
//	        FireRecommendation fireRecommendation) throws Exception {
//
//	  
//	        if (fireRecommendation != null) {
//
//	            RTIApplication rtiApplication = null;
//	            if (fireRecommendation.getRti_ref_id() != null && fireRecommendation.getRti_ref_id() > 0) {
//
//	                rtiApplication = rtiApplicationService.get(fireRecommendation.getRti_ref_id());
//
//	                String existingAppNo = rtiApplication.getRtiApplnNumber();
//
//	                rtiApplication.setApplicantName(fireRecommendation.getFullName());
//	                rtiApplication.setMobileNumber(fireRecommendation.getMobileNo());
//	                rtiApplication.setEmail(fireRecommendation.getAppEmail());
//	                rtiApplication.setPdfUploadFromPortal(fireRecommendation.getFilesPath());
//
//	                rtiApplicationService.merge(rtiApplication);
//
//	                fireRecommendation.setRtiapplrefno(existingAppNo);
//	                fireRecommendation.setRti_ref_id(rtiApplication.getRtiApplicationId());
//
//	                fireRecommendationService.updateFireForm(fireRecommendation);
//
//	            
//
//	              String[] floorName = request.getParameterValues("floorName");
//	            String[] residArea = request.getParameterValues("residArea");
//	            String[] commericaial = request.getParameterValues("commArea");
//	            String[] primumAr = request.getParameterValues("primumAr");
//	            String[] otherUse = request.getParameterValues("otherUse");
//
//	            for (int i = 0; i < floorName.length; i++) {
//
//	                FireDetails f = new FireDetails();
//
//	                f.setFloorName(floorName[i]);
//	                f.setResidArea(residArea[i]);
//	                f.setCommArea(commericaial[i]);
//	                f.setPrimumAr(primumAr[i]);
//	                f.setOtherUse(otherUse[i]);
//
//	                f.setFireRecommendation(fireRecommendation);
//
//	                fireDetailsService.saveFireDetails(f);
//	            }
//
//	            return new ModelAndView("redirect:/ws/search.do?rtsAppNo="
//	                    + fireRecommendation.getRti_ref_id());
//	        }
//	    }
//	        else
//	        {
//	    		return new ModelAndView("redirect:/login.do");
//	        }
//	    return null;
//	}
//	
	@RequestMapping("/rtsapplication/newRtsFirerecomendationEditable.do")
	public ModelAndView newRtsFirerecomendationEditable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
//		request.getSession().removeAttribute("as_status");

		FireRecommendation fireRecommendation = null;
		List<FireDetails> fireDetails = null;

		request.getParameter("fireRecommendationRtsId");
		String formId = request.getParameter("fireRecommendationRtsId");

		fireRecommendationService.get(0);
		List<FireRecommendationTypeOfBuilding> fireRecommendationTypeOfBuilding = fireRecommendationTypeOfBuildingService
				.getTypeOfFireTypeOfBuilding();
		request.setAttribute("fireRecommendationTypeOfBuilding", fireRecommendationTypeOfBuilding);

		List<FireTypeOfConstruction> fireTypeOfConstruction = fireTypeOfConstructionService.getTypeOfConstruction();
		request.setAttribute("fireTypeOfConstruction", fireTypeOfConstruction);

		List<FireBuildingHeight> fireBuildingHeight = fireBuildingHeightService.getTypeOfBuildinhHeight();
		request.setAttribute("fireBuildingHeight", fireBuildingHeight);

		List<FireFloorName> fireFloorName = fireFloorNameService.getFireFloorName();
		request.setAttribute("fireFloorName", fireFloorName);

		List<SubTypeOfbuilding> subTypeOfbuilding = subTypeOfbuildingService.getSubTypeOfbuilding();
		request.setAttribute("subTypeOfbuilding", subTypeOfbuilding);

		List<FireDepartmentWiseLogin> fireDepartmentWiseLogin = fireDepartmentWiseLoginService
				.getFireDepartmentWiseLogin();
		request.setAttribute("fireDepartmentWiseLogin", fireDepartmentWiseLogin);

		List<FireSubDepartmentWiseLogin> fireSubDepartmentWiseLogin = fireSubDepartmentWiseLoginService
				.getFireSubDepartmentWiseLogin();
		request.setAttribute("fireSubDepartmentWiseLogin", fireSubDepartmentWiseLogin);

		List<FireFloorTypes> fireFloorTypes = fireFloorTypesService.getFireFloorTypes();
		request.setAttribute("fireFloorTypes", fireFloorTypes);

		//fireRecommendation = fireRecommendationService.getApplicationId(formId);
		fireRecommendation = fireRecommendationService.getApplicationId(formId);

		fireDetails = fireDetailsService.getFireDetails(fireRecommendation.getFireRecommendationId());

		request.setAttribute("fireApplicationId", fireRecommendation);
		ModelAndView modelAndView = new ModelAndView("newRtsFirerecomendationEditable");
		modelAndView.addObject("fireDetails", fireDetails);


		return modelAndView;
	}

	@RequestMapping("/rtsapplication/editFireRecommendation.do")
	public ModelAndView editFireRecommendation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		FireRecommendation fireRecommendation = null;
		List<FireDetails> fireDetails = null;
		HttpSession session = request.getSession();
		System.out.println("editFireRecommendation");
		long rtiApplicationRefId = 0;
		long rtiApplicationId = 0;
		RTIApplication rtiapplication = null; 
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		long userId = sessionUser.getUserId();

		if (request.getParameter("rtiApplicationRefId") != null
				&& request.getParameter("rtiApplicationRefId").length() > 0
				|| session.getAttribute("rtirefId") != null) {
			if (request.getParameter("rtiApplicationRefId") != null
					&& request.getParameter("rtiApplicationRefId").length() > 0) {
				rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
				fireRecommendation = fireRecommendationService.get(rtiApplicationRefId);
				fireDetails = fireDetailsService.getFireDetails(rtiApplicationRefId);
			} else if (session.getAttribute("rtirefId") != null) {
				Object a = session.getAttribute("rtirefId");
				rtiApplicationRefId = (long) a;
				fireRecommendation = fireRecommendationService.get(rtiApplicationRefId);
				fireDetails = fireDetailsService.getFireDetails(rtiApplicationRefId);
			}
			if (fireRecommendation.getRti_ref_id() > 0) {
				rtiApplicationId = fireRecommendation.getRti_ref_id();
				rtiapplication = rtiApplicationService.get(rtiApplicationId);
			} else {
				List<RTIApplication> listRTI = rtiApplicationService.findByProperty("rtiApplicationRefId",
						rtiApplicationRefId);
				if (listRTI != null && !listRTI.isEmpty()) {
					rtiApplicationId = listRTI.get(0).getRtiApplicationId();
					rtiapplication = listRTI.get(0);
				}
			}
		}
		

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_FIRE_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_FIRE_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiapplication);
		long rtiRefId = rtiapplication.getRtiApplicationRefId();
		request.setAttribute("workflowStatus", rtiapplication.getWorkFlowStatus());
		request.setAttribute("rtiRefId", rtiapplication.getRtiApplicationRefId());

	
	
		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_FIRE_WORKFLOW_ENTITY);

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
		
		List<FireDepartmentWiseLogin> fireDepartmentWiseLogin = fireDepartmentWiseLoginService.getFireDepartmentWiseLogin();
		request.setAttribute("fireDepartmentWiseLogin", fireDepartmentWiseLogin);
		
		List<FireSubDepartmentWiseLogin> fireSubDepartmentWiseLogin = fireSubDepartmentWiseLoginService.getFireSubDepartmentWiseLogin();
		request.setAttribute("fireSubDepartmentWiseLogin", fireSubDepartmentWiseLogin);
		
		
		User user = uService.get(userId);
		String userMiddleName = user.getMiddleName();

		boolean isZoneUser = userMiddleName != null 
		        && userMiddleName.trim().equalsIgnoreCase("HQ");

		request.setAttribute("isZoneUser", isZoneUser);
		String userLoginId = user.getUserLevel();

		

		if (userLoginId != null && !userLoginId.isEmpty()) {

		    if (userLoginId.equals("L1")) {
		        request.setAttribute("forLogin", "L1");
		    } 
		    else if (userLoginId.equals("L2")) {
		        request.setAttribute("forLogin", "L2");
		    } 
		    else {
		        request.setAttribute("forLogin", "nothing");
		    }

		}
        
        ModelAndView modelAndView = new ModelAndView("manageFireRecommendation");
		modelAndView.addObject("fireRecommendation", fireRecommendation); // Set the entity class
		
//		String type = "PWD License";
//		String applnNo = rtiapplication.getRtiApplnNumber();
//		String link = "http://tinyurl.com/yc3b9dp8";
//		String msg = "Dear Applicant, your application "
//				+ applnNo
//				+ " for "
//				+ type
//				+ " Is submitted successfully. Kindly pay registration fees using link "
//				+ link + " Regards,NMCGOV";
//
//		msg.replace("var3", "");
//
//		SendSMS.sendSingleSMS("1707170505869519444", "NMCGov",
//				rtiapplication.getMobileNumber(), msg);

		// Add other attributes or data to the model
		modelAndView.addObject("fireDetails", fireDetails);

		return modelAndView;

	}
	
	@RequestMapping("/rtsapplication/updateDepartment.do")
	public ModelAndView updateDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		
		FireRecommendation fireRecommendation = null;
		RTIApplication rtiapplication = null; 
		long rtiApplicationRefId = Long.parseLong(request.getParameter("rtiApplicationRefId"));
		fireRecommendation = fireRecommendationService.get(rtiApplicationRefId);
		
		long rtiapplicationId = fireRecommendation.getRti_ref_id();
		
		rtiapplication = rtiApplicationService.get(rtiapplicationId);
		String firstD = request.getParameter("fireDepartmentWiseLogin");
		String SecondD = request.getParameter("fireSubDepartmentWiseLogin");
		
	if(firstD != null && SecondD != null) {
		rtiapplication.setZone(request.getParameter("fireDepartmentWiseLogin"));
		fireRecommendation.setFireDepartmentWiseLogin(request.getParameter("fireDepartmentWiseLogin"));
		fireRecommendation.setFireSubDepartmentWiseLogin(request.getParameter("fireSubDepartmentWiseLogin"));
		fireRecommendation.setZoneNO(request.getParameter("fireDepartmentWiseLogin"));
		fireRecommendationService.merge(fireRecommendation);
		rtiApplicationService.merge(rtiapplication);

	}
    return new ModelAndView("redirect:/rtsapplication/listRTSfireApplication.do");
	}
	
	@RequestMapping("/rtiapplication/createFireRecommendationWork.do")
	public ModelAndView createFireRecommendationWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

		WorkflowProcessDetails workflowProcessDetails = null;
		WorkflowProcessDetails processDetails = null;
		workflowProcessDetails = workflowProcessDetailsService
				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_FIRE_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		FireRecommendation fireRecommendation = fireRecommendationService.get(applicationId);
		String email = fireRecommendation.getAppEmail();
		String mobileNo = fireRecommendation.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		
	
		if (fireRecommendation != null) {
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
					fireRecommendation.setSentToCitizen(0); 
				    fireRecommendationService.saveFireForm(fireRecommendation);

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
					fireRecommendation.setSentToCitizen(0); // 👈 pending with citizen
				    fireRecommendationService.saveFireForm(fireRecommendation);

					SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
					rtiApplication.setWorkFlowStatus(5);
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
					rtiApplication.setWorkflowComments(workflow_comments);
	
					rtiApplicationService.save(rtiApplication);
					fireRecommendation.setSentToCitizen(0); // 👈 pending with citizen
				    fireRecommendationService.saveFireForm(fireRecommendation);

					SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				}
			}else{
				if (request.getParameter("WORKFLOW_TRANSISTION").equals("Send-Remark")) {
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
					fireRecommendation.setRemarkforCitizen(workflow_comments);
					fireRecommendation.setSentToCitizen(1); // 👈 pending with citizen
				   // rtiApplication.setWorkflowComments(workflow_comments);
				   // rtiApplicationService.save(rtiApplication);
				    fireRecommendationService.saveFireForm(fireRecommendation);
				   // SendSMSEmailController.sendRemarkToCitizen(applicantName, mobileNo, rtiApplnNumber, email);

				    //request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Forward-To-L2")) {
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);

				    // ✅ Validate documents at backend also
				    if (fireRecommendation.getCfoNoc() == null ||
				        fireRecommendation.getInspectionReport() == null ||
				        fireRecommendation.getScrutinyReport() == null) {

				        request.setAttribute("errorMsg", "All documents are mandatory before sending to L2");
				        return new ModelAndView("redirect:/rtsapplication/editFireRecommendation.do");
				    }
			    	fireRecommendation.setForwardedToL1(false);

					fireRecommendation.setRemarkforL2(workflow_comments);
					fireRecommendation.setSentToCitizen(0); // 👈 pending with citizen

				    //rtiApplication.setWorkFlowStatus(4); // 👈 sent to L2
				    //rtiApplication.setWorkflowComments(workflow_comments);
				    //rtiApplicationService.save(rtiApplication);
				    fireRecommendationService.saveFireForm(fireRecommendation);

				   // SendSMSEmailController.sendToL2(applicantName, mobileNo, rtiApplnNumber, email);

				   // request.setAttribute("workFlowCompleted", "1");
				}else {
				session.setAttribute("rejected", 5);
				rtiApplication.setWorkFlowStatus(5);
				String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
				rtiApplication.setWorkflowComments(workflow_comments);

				rtiApplicationService.save(rtiApplication);
				fireRecommendation.setSentToCitizen(0); // 👈 pending with citizen
				fireRecommendationService.saveFireForm(fireRecommendation);
				
				SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

				request.setAttribute("workFlowCompleted", "1");
				
			}

		}
		}

		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_FIRE_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_FIRE_WORKFLOW_ENTITY);
		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView("redirect:/rtsapplication/editFireRecommendation.do");
	}
	

	@RequestMapping("/rtiapplication/createFireRecommendationWorkL1.do")
	public ModelAndView createFireRecommendationWorkL1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		
		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);

		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

//		WorkflowProcessDetails workflowProcessDetails = null;
//		WorkflowProcessDetails processDetails = null;
//		workflowProcessDetails = workflowProcessDetailsService
//				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_FIRE_WORKFLOW_ENTITY);

		String id = request.getParameter("id");
		long applicationId = Long.parseLong(id);
		FireRecommendation fireRecommendation = fireRecommendationService.get(applicationId);
		String email = fireRecommendation.getAppEmail();
		String mobileNo = fireRecommendation.getMobileNo();
		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
		String applicantName = rtiApplication.getApplicantName();
		long rtirefId = rtiApplication.getRtiApplicationRefId();
		
	
		if (fireRecommendation != null) {
		
			if (request.getParameter("WORKFLOW_TRANSISTION").equals("Send-Remark")) {
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
					fireRecommendation.setRemarkforCitizen(workflow_comments);
					fireRecommendation.setSentToCitizen(1); // 👈 pending with citizen
				   // rtiApplication.setWorkflowComments(workflow_comments);
				   // rtiApplicationService.save(rtiApplication);
				    fireRecommendationService.saveFireForm(fireRecommendation);
				   // SendSMSEmailController.sendRemarkToCitizen(applicantName, mobileNo, rtiApplnNumber, email);

				    //request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Forward-To-L2")) {
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);

				    // ✅ Validate documents at backend also
				    if (fireRecommendation.getCfoNoc() == null ||
				        fireRecommendation.getInspectionReport() == null ||
				        fireRecommendation.getScrutinyReport() == null) {

				        request.setAttribute("errorMsg", "All documents are mandatory before sending to L2");
				        return new ModelAndView("redirect:/rtsapplication/editFireRecommendation.do");
				    }
					fireRecommendation.setRemarkforCitizen(workflow_comments);
			    	fireRecommendation.setForwardedToL1(false);


				    //rtiApplication.setWorkFlowStatus(4); // 👈 sent to L2
				    //rtiApplication.setWorkflowComments(workflow_comments);
				    //rtiApplicationService.save(rtiApplication);
				    fireRecommendationService.saveFireForm(fireRecommendation);

				   // SendSMSEmailController.sendToL2(applicantName, mobileNo, rtiApplnNumber, email);

				   // request.setAttribute("workFlowCompleted", "1");
				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
					rtiApplication.setWorkFlowStatus(5);
					String workflow_comments = request.getParameter(WorkflowConstants.WORKFLOW_COMMENTS);
					rtiApplication.setWorkflowComments(workflow_comments);
	
					rtiApplicationService.save(rtiApplication);
					
					SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);

					request.setAttribute("workFlowCompleted", "1");
				}
			}

		request.setAttribute("rtiApplication", rtiApplication);
		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
		session.setAttribute("rtirefId", rtirefId);
		return new ModelAndView("redirect:/rtsapplication/editFireRecommendation.do");
	}

	
//	
//	@RequestMapping("/rtiapplication/createFireRecommendationWork.do")
//	public ModelAndView createFireRecommendationWork(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, Exception {
//		String rtiApplicationIdString = request.getParameter(WorkflowConstants.WORKFLOW_ENTITYID);
//		long rtiApplicationId = Long.parseLong(rtiApplicationIdString);
//		RTIApplication rtiApplication = rtiApplicationService.get(rtiApplicationId);
//
//		HttpSession session = request.getSession();
//		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
//
//		WorkflowProcessDetails workflowProcessDetails = null;
//		WorkflowProcessDetails processDetails = null;
//		workflowProcessDetails = workflowProcessDetailsService
//				.getWorkflowProcessDetailsByEntityDetails(rtiApplicationId, CoreConstants.RTI_FIRE_WORKFLOW_ENTITY);
//
//		String id = request.getParameter("id");
//		long applicationId = Long.parseLong(id);
//		FireRecommendation fireRecommendation = fireRecommendationService.get(applicationId);
//		String email = fireRecommendation.getAppEmail();
//		String mobileNo = fireRecommendation.getMobileNo();
//		String rtiApplnNumber = rtiApplication.getRtiApplnNumber();
//		String applicantName = rtiApplication.getApplicantName();
//		long rtirefId = rtiApplication.getRtiApplicationRefId();
//
//		if (fireRecommendation != null) {
//			if (workflowProcessDetails != null) {
//				String processId = workflowProcessDetails.getProcessId();
//				if (processId != null) {
//					processDetails = workflowProcessDetailsService.getWorkflowProcessDetailsByProcessId(processId);
//				}
//				if (!workflowService.isProcessEnded(processId)) {
//					String taskId = workflowService.getCurrentTaskId(processId);
//					Task task = null;
//					if (taskId != null)
//						task = taskService.getTask(taskId);
//					if (processDetails != null) {
//						PersonalTask personalTask = new PersonalTask();
//						personalTask.setTask(task);
//						personalTask.setEntityId(processDetails.getEntityId());
//						personalTask.setEntityName(processDetails.getEntityName());
//						personalTask.setWorkflowInitator(processDetails.getUserName());
//						personalTask.setEntityDetails(processDetails.getEntityDetails());
//						request.setAttribute("personalTask", personalTask);
//					}
//
//					rtiApplication.setWorkFlowStatus(3);
//					rtiApplicationService.save(rtiApplication);
////					String link = "https://tinyurl.com/4hhhy9w9";
////					String msg = "Dear " + applicantName
////							+ " your document verification has been successfully completed. Kindly use this link https://tinyurl.com/3ntc2jae  to make a payment in order for your application "
////							+ rtiApplnNumber + " to be processed further.Regards, NMCGOV";
////
////					msg.replace("var3", "");
////					SendEmail.sendEmail(email, "Payment link for your Appl. No." + mobileNo, msg);
////					SendSMS.sendSingleSMS("1507167421309610108", "NMCGov", mobileNo, msg);
//					SendSMSEmailController.sendPayment(applicantName, mobileNo, rtiApplnNumber, email);
//
//				
//					if (request.getParameter("WORKFLOW_TRANSISTION").isEmpty()
//							|| request.getParameter("WORKFLOW_TRANSISTION") == null) {
//
//					}
//					if (task != null && sessionUser.getUserName().equals(task.getAssignee())) {
//						request.setAttribute("userAccess", 1);
//						request.setAttribute("workFlowTask", task);
//					}
//				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Close-Application")) {
//
//					rtiApplication.setWorkFlowStatus(1);
//					rtiApplicationService.save(rtiApplication);
////					String msg = "Dear " + applicantName
////							+ " please click on this link https://tinyurl.com/5emnw6u7 to download the Certificate for your application "
////							+ rtiApplnNumber + " Regards, NMCGOV";
////
////					msg.replace("var3", "");
////					SendEmail.sendEmail(email, "Completion of your Appl. No." + rtiApplnNumber, msg);
////					SendSMS.sendSingleSMS("1507167421320245636", "NMCGov", mobileNo, msg);
//					SendSMSEmailController.sendApplicationCompleted(applicantName, mobileNo, rtiApplnNumber, email);
//					request.setAttribute("workFlowCompleted", "1");
//				} else if (request.getParameter("WORKFLOW_TRANSISTION").equals("Reject")) {
//					rtiApplication.setWorkFlowStatus(5);
//					rtiApplicationService.save(rtiApplication);
////					String msg = "Dear " + applicantName + " your " + rtiApplnNumber
////							+ " has been rejected due to shortfall of documents. Please use this link https://tinyurl.com/5emnw6u7 to know the pending mandatory documents and track the status of your application.Regards, NMCGOV";
////					msg.replace("var3", "");
////					SendEmail.sendEmail(email, "Rejection of your Appl. No." + rtiApplnNumber, msg);
////					SendSMS.sendSingleSMS("1507167421296109813", "NMCGov", mobileNo, msg);
//					SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);
//
//					request.setAttribute("workFlowCompleted", "1");
//				}
//			} else {
//				session.setAttribute("rejected", 5);
//				rtiApplication.setWorkFlowStatus(5);
//				rtiApplicationService.save(rtiApplication);
////				String msg = "Dear " + applicantName + " your " + rtiApplnNumber
////						+ " has been rejected due to shortfall of documents. Please use this link https://tinyurl.com/5emnw6u7 to know the pending mandatory documents and track the status of your application.Regards, NMCGOV";
////				msg.replace("var3", "");
////				SendEmail.sendEmail(email, "Rejection of your Appl. No." + rtiApplnNumber, msg);
////				SendSMS.sendSingleSMS("1507167421296109813", "NMCGov", mobileNo, msg);
//				SendSMSEmailController.sendApplicationRejected(applicantName, mobileNo, rtiApplnNumber, email);
//				request.setAttribute("workFlowCompleted", "1");
//
//			}
//
//		}
//
//		request.setAttribute(WorkflowConstants.WORKFLOW_REQUIRED, "true");
//		request.setAttribute(WorkflowConstants.WORKFLOW_NAME, CoreConstants.RTI_FIRE_WORKFLOW_ENTITY);
//		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYNAME, CoreConstants.RTI_FIRE_WORKFLOW_ENTITY);
//		request.setAttribute(WorkflowConstants.WORKFLOW_ENTITYID, rtiApplicationId);
//		request.setAttribute("rtiApplication", rtiApplication);
//		request.setAttribute("rtiApplicationRefId", rtiApplicationId);
//		// ModelAndView modelAndView = new ModelAndView("manageMandapPermission",
//		// "mandapPermission", mandapPermission);
//		session.setAttribute("rtirefId", rtirefId);
//		return new ModelAndView("redirect:/rtsapplication/editFireRecommendation.do");
//	}

	@RequestMapping("/ws/rtsapplication/firePaymentSucess.do")
	public ModelAndView firePaymentSucess(HttpServletRequest request,
			HttpServletResponse response) {
		String applicationNumber = request.getParameter("rtiApplicationNumber");

try {
		String status = request.getSession().getAttribute("status").toString();
		if (status.equals("2") && applicationNumber != null) {
			RTIApplication rtsapp = rtiApplicationService
					.get(Long.parseLong(applicationNumber));
			RTIApplication rts = rtiApplicationService.merge(rtsapp);
			String mobileNo = rts.getMobileNumber();
			String name = rts.getApplicantName();
			String link = "https://tinyurl.com/4hhhy9w9";
			String applnNo = rts.getRtiApplnNumber();
		
			//String name = fireRecommendation.getFullName();
			//String link = "https://tinyurl.com/4hhhy9w9";
			//String applnNo = rti.getRtiApplnNumber();

			//String mobileNo = fireRecommendation.getMobileNo();
			String email=rts.getEmail();
			SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);


//			String msg = "Dear " + name
//					+ " your application with Application No. " + applnNo
//					+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";
//
//			msg.replace("var3", "");
//
//			SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", mobileNo,
//					msg);
//			SendEmail.sendEmail(rts.getEmail(),
//					"Application Submitted Successfully" + applnNo, msg);
			request.setAttribute("rtiapplrefid", rts.getRtiApplicationId());

			request.setAttribute("rtiApplicationNumberi", rts.getRtiApplnNumber());
			ModelAndView model = new ModelAndView(
					"newRTIFireRecommendationSuccess", "fireRecommendation",
					rts);
			return model;
		} else {
			RTIApplication rtsapp = rtiApplicationService
					.get(Long.parseLong(applicationNumber));
			rtsapp.setRtiserviceid(0);
			RTIApplication rts = rtiApplicationService.merge(rtsapp);
			throw new NullPointerException("Somthing went wrong.");
		}

	
	}catch(Exception ex) {
		ex.printStackTrace();
		RTIApplication rtsapp = rtiApplicationService
				.get(Long.parseLong(applicationNumber));
		rtiApplicationService.delete(rtsapp.getRtiApplicationId());
		throw new NullPointerException("Somthing went wrong.");
	}
	}
	
	
	@RequestMapping("/rtsapplication/listRTSfireApplication.do")
	public ModelAndView listRTSfireApplication(HttpServletRequest request, HttpServletResponse response)
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

	        User user = uService.get(sessionUser.getUserId());

	        String userZone = user.getZone();
	        String userLevel = user.getUserLevel();
			String userMiddleName = user.getMiddleName();

			boolean isZoneUser = userMiddleName != null 
			        && userMiddleName.trim().equalsIgnoreCase("HQ");


	        long totalCount = 0;

	        // ✅ CALL SERVICE (FIXED)
	        List<RTIApplication> rtiapplicationList =
	                fireRecommendationService.getFireApplications(applicationSearch, userZone, userLevel, isZoneUser);

	        totalCount =
	                fireRecommendationService.getFireApplicationsCount(applicationSearch, userZone, userLevel, isZoneUser);
	      
	        Map<Long, List<Collection>> paymentMap =
	                fireRecommendationService.getPaymentMap(rtiapplicationList);

	        request.setAttribute("paymentMap", paymentMap);
	        
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
	        request.setAttribute("departmentList", departmentService.getAll());
	        request.setAttribute("serviceId", request.getAttribute("rtiServiceId"));

	        return new ModelAndView(
"listRTSFireRecommendation",
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
	
	// ===================== CONTROLLER METHOD =====================

	@RequestMapping(value = "/rtsapplication/saveUpdatedFees.do", method = RequestMethod.POST)
	public ModelAndView saveUpdatedFees(
	        HttpServletRequest request,
	        HttpServletResponse response) {

	    ModelAndView model = new ModelAndView();

	
	        String rtiApplnId = request.getParameter("rtiApplnId");
	        try {
			RTIApplication rtiApplication = rtiApplicationService.get(Long.valueOf(rtiApplnId));

	        String fireId = request.getParameter("fireId");

	        String feesRemarks = request.getParameter("remarks");

	        String updatedScrutinyFees =
	                request.getParameter("updatedScrutinyFees");

	        String updatedTotalFees =
	                request.getParameter("updatedTotalFees");

	        fireRecommendationService.saveUpdatedFees(
	                Long.parseLong(fireId),
	                feesRemarks,
	                updatedScrutinyFees,
	                updatedTotalFees);
	        
	    	rtiApplication.setApplicationCost(Double.valueOf(updatedTotalFees));
			rtiApplicationService.save(rtiApplication);

	        model.addObject("msg", "Fees Updated Successfully");

	    } catch (Exception e) {

	        e.printStackTrace();

	        model.addObject("msg", "Failed To Update Fees");
	    }

	   // model.setViewName("redirect:/yourPage");
		//return new ModelAndView("redirect:/rtsapplication/editFireRecommendation.do?rtiApplicationId="+ rtiApplnId);
	        return new ModelAndView(
	        	    "redirect:/rtsapplication/editFireRecommendation.do?rtiApplicationRefId="
	        	    + request.getParameter("fireId"));
	    //return model;
	}

	@RequestMapping("/rtiapplication/uploadsFireRecommendation.do")
	public void uploadsFireRecommendation(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		log.info("Document Uploaded");
		JSONObject json = new JSONObject();

		try {
			// String baseDir = getServletContext().getRealPath("") + File.separator +
			// "deathCertificates";
			String baseDir = CoreConstants.UPLOAD_PATH + "FireRecommendationLatter";

			File file = new File(baseDir);
			if (!file.exists()) {
				file.mkdirs();
			}

			log.info("Resolved upload directory ABSOLUTE PATH: " + file.getAbsolutePath());

			if (ServletFileUpload.isMultipartContent(request)) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(MAX_FILE_SIZE);
				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setFileSizeMax(MAX_FILE_SIZE);
				upload.setSizeMax(REQUEST_SIZE);

				List<FileItem> formItems = upload.parseRequest(request);
				int counter = 0; // Counter variable to add before filename
				for (FileItem item : formItems) {
					if (!item.isFormField() && item.getName() != null && !item.getName().isEmpty()) {
						String fileName = new File(item.getName()).getName();

						// Split on ".pdf" to remove it
						String[] fileNameParts = fileName.split("\\.pdf");
						if (fileNameParts.length > 0) {
							fileName = fileNameParts[0];
						}

						fileName = fileName.replaceAll("[^a-zA-Z0-9]", "");
						fileName = fileName.replaceAll("\\W", "");
						fileName = id + fileName + ".pdf"; // Add "new.pdf" after the cleaned filename

						File storeFile = new File(baseDir, fileName);
						item.write(storeFile);

						counter++; // Increment the counter for the next file
					}
				}
				json.put("status", true);
				PrintWriter out = response.getWriter();
				out.print(json.toString());
				out.flush();
			} else {
				request.setAttribute("message", "Please contact the system admin");

				json.put("status", false);
				PrintWriter out = response.getWriter();
				out.print(json.toString());
				out.flush();

			}
		} catch (Exception ex) {
			log.error(ex);
			request.setAttribute("message", "Please contact the system admin");
			ex.printStackTrace();
			json.put("status", false);
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.flush();

		}

	}
	

	@RequestMapping("/rtsapplication/listRTSFireServiceBifurgation.do")
	public ModelAndView listRTSFireServiceBifurgation(
	        HttpServletRequest request,
	        HttpServletResponse response) throws ServletException {

	    HttpSession session = request.getSession();
	    SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

	    if (sessionUser == null) {
	        return new ModelAndView("redirect:/login.do");
	    }

	    RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
	    setSearchParameters(applicationSearch, request);

	    // ---------------------------------------------------------------
	    // FIX: the DAO list methods (getCitizenApplications, getL1Applications,
	    // getForwardedApplications, getCompletedApplications, getTotalApplications)
	    // apply DB-level pagination (setFirstResult/setMaxResults) whenever
	    // currentPage != Constants.DEFAULT_PAGINATION_ALL_ROWS. The matching
	    // *Count methods never apply that cap, so the card counts were showing
	    // the true total (e.g. 222) while the tables only ever received one
	    // page's worth of rows (e.g. 20).
	    //
	    // The JSP already does its own client-side pagination
	    // (initTablePagination in the <script> block), so we want the DAO to
	    // hand back the COMPLETE list for each bucket and let the browser
	    // paginate/search it. Force "all rows" mode here.
	    // ---------------------------------------------------------------
	    applicationSearch.setCurrentPage((long) Constants.DEFAULT_PAGINATION_ALL_ROWS);

	    try {
	        User user = uService.get(sessionUser.getUserId());

	        String userZone = user.getZone();
	        String userLevel = user.getUserLevel();
	        String userMiddleName = user.getMiddleName();

	        boolean isZoneUser = userMiddleName != null
	                && userMiddleName.equalsIgnoreCase("HQ");

	        List<FireApplicationDTO> totalList =
	                fireRecommendationService.getTotalApplications(
	                        applicationSearch,
	                        userZone,
	                        userLevel,
	                        isZoneUser);

	        List<RTIApplication> citizenList =
	                fireRecommendationService.getCitizenApplications(
	                        applicationSearch, userZone, userLevel, isZoneUser);

	        List<RTIApplication> l1List =
	                fireRecommendationService.getL1Applications(
	                        applicationSearch, userZone, userLevel, isZoneUser);

	        List<RTIApplication> forwardedList =
	                fireRecommendationService.getForwardedApplications(
	                        applicationSearch, userZone, userLevel, isZoneUser);

	        List<RTIApplication> completedList =
	                fireRecommendationService.getCompletedApplications(
	                        applicationSearch, userZone, userLevel, isZoneUser);

	        long citizenCount =
	                fireRecommendationService.getCitizenApplicationsCount(
	                        applicationSearch, userZone, userLevel, isZoneUser);

	        long totalCount =
	                fireRecommendationService.getTotalApplicationsCount(
	                        applicationSearch, userZone, userLevel, isZoneUser);

	        long l1Count =
	                fireRecommendationService.getL1ApplicationsCount(
	                        applicationSearch, userZone, userLevel, isZoneUser);

	        long forwardedCount =
	                fireRecommendationService.getForwardedApplicationsCount(
	                        applicationSearch, userZone, userLevel, isZoneUser);

	        long completedCount =
	                fireRecommendationService.getCompletedApplicationsCount(
	                        applicationSearch, userZone, userLevel, isZoneUser);

	        List<RTIApplication> allApplications = new ArrayList<>();
	        if (citizenList != null) {
	            allApplications.addAll(citizenList);
	        }
	        if (l1List != null) {
	            allApplications.addAll(l1List);
	        }
	        if (forwardedList != null) {
	            allApplications.addAll(forwardedList);
	        }
	        if (completedList != null) {
	            allApplications.addAll(completedList);
	        }

	        for (FireApplicationDTO dto : totalList) {
	            allApplications.add(dto.getApplication());
	        }

	        Map<Long, List<Collection>> paymentMap = fireRecommendationService.getPaymentMap(allApplications);

	        request.setAttribute("pageTitle", "All Fire Applications");
	        request.setAttribute("departmentList", departmentService.getAll());
	        request.setAttribute("maximumPages", CommonUtils.getMaxPage(totalCount));
	        request.setAttribute("totalCount", totalCount);
	        request.setAttribute("completedCount", completedCount);
	        request.setAttribute("citizenCount", citizenCount);
	        request.setAttribute("l1Count", l1Count);
	        request.setAttribute("forwardedCount", forwardedCount);

	        // Needed by the corrected JSP so the "Application No." link/plain-text
	        // branch works correctly in every section (Total/Citizen/Forwarded/L1/Completed)
	        request.setAttribute("forLogin", userLevel);
	        request.setAttribute("isZoneUser", isZoneUser);

	        ModelAndView mv = new ModelAndView("fireServiceBifurgation");
	        mv.addObject("totalList", totalList);
	        mv.addObject("citizenList", citizenList);
	        mv.addObject("l1List", l1List);
	        mv.addObject("forwardedList", forwardedList);
	        mv.addObject("completedList", completedList);
	        mv.addObject("paymentMap", paymentMap);

	        return mv;

	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	    }

	    return new ModelAndView("redirect:/login.do");
	}

	
	

	@RequestMapping("/rtsapplication/uploadsManageFire.do")
	public void uploadsManageFire(HttpServletRequest request, HttpServletResponse response)
	        throws IOException {
log.debug("upload started");
	    JSONObject json = new JSONObject();
	    response.setContentType("application/json");
	    PrintWriter out = response.getWriter();

	    String appType = request.getParameter("appType");
        log.debug("rts appType" +appType);

	    String uniqueId = request.getParameter("UID");
        log.debug("rts UID" +uniqueId);


	    try {

	        // ✅ Trim & Validate UID
	        if (uniqueId != null) {
	            uniqueId = uniqueId.trim();
	        }

	        if (uniqueId == null || uniqueId.isEmpty()) {
	            json.put("status", false);
	            json.put("message", "Invalid UID");
	            out.print(json);
	            return;
	        }

	        Long id = Long.parseLong(uniqueId);
	        log.debug("rts id" +id);

	        // ✅ Set base directory
	        String baseDir = CoreConstants.UPLOAD_PATH + "FireNocUploads";
	        log.debug("rts baseDir" +baseDir);

	        if ("1".equals(appType)) {
	            baseDir += File.separator + "ScrutinyUpload";
		        log.debug("rts ScrutinyUpload baseDir" +baseDir);
 
	        } else if ("2".equals(appType)) {
	            baseDir += File.separator + "InspectionUpload";
		        log.debug("rts InspectionUpload baseDir" +baseDir);

	        } else if ("3".equals(appType)) {
	            baseDir += File.separator + "CfoNocUpload";
		        log.debug("rts CfoNocUpload baseDir" +baseDir);

	        }

	        baseDir += File.separator + uniqueId;
	        log.debug("rts last baseDir" +baseDir);


	        // ✅ Multipart check
	        if (!FileUpload.isMultipartContent(request)) {
	            json.put("status", false);
	            json.put("message", "Invalid request");
		        log.debug("request invalid" +request);

	            out.print(json);
	            return;
	        }

	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        factory.setSizeThreshold(5 * 1024 * 1024);

	        ServletFileUpload upload = new ServletFileUpload(factory);
	        upload.setFileSizeMax(5 * 1024 * 1024);

	        List<FileItem> items = upload.parseRequest(request);
	        log.debug("request FileItem" +items);

	        // ✅ Fetch entity once
	        FireRecommendation fire = fireRecommendationService.get(id);

	        for (FileItem item : items) {

	            if (!item.isFormField() && item.getName() != null && !item.getName().isEmpty()) {

	                String originalName = new File(item.getName()).getName();

	                // 🔒 Only PDF
	                if (!originalName.toLowerCase().endsWith(".pdf")) {
	                    throw new Exception("Only PDF allowed");
	                }

	                // 🔒 Double extension check
	                if (originalName.substring(0, originalName.lastIndexOf(".")).contains(".")) {
	                    throw new Exception("Invalid file (double extension not allowed)");
	                }

	                // ✅ Clean filename
	                String fileName = originalName.replaceAll("[^a-zA-Z0-9.]", "");

	                // ✅ Create directory
	                File dir = new File(baseDir);
	                if (!dir.exists()) {
	                    dir.mkdirs();
	                }

	                // ✅ Create file path
	                String filePath = baseDir + File.separator + System.currentTimeMillis() + "_" + fileName;
        	        log.debug("filePath before" +filePath);

	                File storeFile = new File(filePath);
	                item.write(storeFile);

	                // ✅ Save to DB
	                if ("1".equals(appType)) {
	                    fire.setScrutinyReport(filePath);
	        	        log.debug("setScrutinyReport FileItem" +filePath);


	                } else if ("2".equals(appType)) {
	                    fire.setInspectionReport(filePath);
	        	        log.debug("setInspectionReport FileItem" +filePath);


//	                    RTIApplication rts = rTIApplicationService.get(fire.getRti_ref_id());
//	                    rts.setPdfFilesSavedPath(filePath);
//	                    rTIApplicationService.save(rts);

	                } else if ("3".equals(appType)) {
	                    fire.setCfoNoc(filePath);
	        	        log.debug("setCfoNoc FileItem" +filePath);

	                }
	            }
	        }

	        log.debug("before saving in table" );

	        fireRecommendationService.saveFireForm(fire);
	        log.debug("after saving in table object"  +fire);


	        json.put("status", true);
	        json.put("message", "File 123 uploaded successfully");


	    } catch (Exception e) {
	        e.printStackTrace();
	        json.put("status", false);
	        json.put("message", e.getMessage());
	        log.debug("Exception" +e);

	    }

	    out.print(json);
	    out.flush();
	}
	

	@RequestMapping("/rtsapplication/uploadsManageFireService.do")
	public void uploadsManageFireService(HttpServletRequest request, HttpServletResponse response)
	        throws IOException {

	    JSONObject json = new JSONObject();
	    response.setContentType("application/json");
	    PrintWriter out = response.getWriter();

	    String appType = request.getParameter("appType");
	    String uniqueId = request.getParameter("UID");

	    try {

	        // ✅ Trim & Validate UID
	        if (uniqueId != null) {
	            uniqueId = uniqueId.trim();
	        }

	        if (uniqueId == null || uniqueId.isEmpty()) {
	            json.put("status", false);
	            json.put("message", "Invalid UID");
	            out.print(json);
	            return;
	        }

	        Long id = Long.parseLong(uniqueId);

	        // ✅ Set base directory
	        String baseDir = CoreConstants.UPLOAD_PATH + "FireNocUploads";

	        if ("1".equals(appType)) {
	            baseDir += File.separator + "FireNOCUpload";
	        } else if ("2".equals(appType)) {
	            baseDir += File.separator + "BuildingPlanMap";
	        } 

	        baseDir += File.separator + uniqueId;

	        // ✅ Multipart check
	        if (!FileUpload.isMultipartContent(request)) {
	            json.put("status", false);
	            json.put("message", "Invalid request");
	            out.print(json);
	            return;
	        }

	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        factory.setSizeThreshold(10 * 1024 * 1024);

	        ServletFileUpload upload = new ServletFileUpload(factory);
	        upload.setFileSizeMax(10 * 1024 * 1024);

	        List<FileItem> items = upload.parseRequest(request);

	        // ✅ Fetch entity once
	        FireRecommendation fire = fireRecommendationService.get(id);

	        for (FileItem item : items) {

	            if (!item.isFormField() && item.getName() != null && !item.getName().isEmpty()) {

	                String originalName = new File(item.getName()).getName();

	                // 🔒 Only PDF
	                if (!originalName.toLowerCase().endsWith(".pdf")) {
	                    throw new Exception("Only PDF allowed");
	                }

	                // 🔒 Double extension check
	                if (originalName.substring(0, originalName.lastIndexOf(".")).contains(".")) {
	                    throw new Exception("Invalid file (double extension not allowed)");
	                }

	                // ✅ Clean filename
	                String fileName = originalName.replaceAll("[^a-zA-Z0-9.]", "");

	                // ✅ Create directory
	                File dir = new File(baseDir);
	                if (!dir.exists()) {
	                    dir.mkdirs();
	                }

	                // ✅ Create file path
	                String filePath = baseDir + File.separator + System.currentTimeMillis() + "_" + fileName;

	                File storeFile = new File(filePath);
	                item.write(storeFile);

	                // ✅ Save to DB
	                if ("1".equals(appType)) {
	                    fire.setFireNoc(filePath);
	                    
	                } else if ("2".equals(appType)) {
	                    fire.setBuildingPlanMap(filePath);

//	                    RTIApplication rts = rTIApplicationService.get(fire.getRti_ref_id());
//	                    rts.setPdfFilesSavedPath(filePath);
//	                    rTIApplicationService.save(rts);

	                } 
	            }
	        }

	        fireRecommendationService.saveFireForm(fire);

	        json.put("status", true);
	        json.put("message", "File uploaded successfully");

	    } catch (Exception e) {
	        e.printStackTrace();
	        json.put("status", false);
	        json.put("message", e.getMessage());
	    }

	    out.print(json);
	    out.flush();
	}
	
}
