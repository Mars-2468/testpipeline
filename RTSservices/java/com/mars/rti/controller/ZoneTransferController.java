package com.mars.rti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.BirthCertificate;
import com.mars.rti.model.ChangeInOwnershipType;
import com.mars.rti.model.DeathCertificate;
import com.mars.rti.model.DikshaBhumiMandapPermission;
import com.mars.rti.model.DogLicenseCertificate;
import com.mars.rti.model.DurgaUtsavMandapPermission;
import com.mars.rti.model.FireComplianceCertificate;
import com.mars.rti.model.FireRecommendation;
import com.mars.rti.model.GaneshMandapPermission;
import com.mars.rti.model.IllegalWaterConnectionComplaint;
import com.mars.rti.model.MandapPermission;
import com.mars.rti.model.MarriageCertificate;
import com.mars.rti.model.NOCOfTrade;
import com.mars.rti.model.NewWaterConnection;
import com.mars.rti.model.NewlyConstructedProperty;
import com.mars.rti.model.OccupancyCertificate;
import com.mars.rti.model.PartMap;
import com.mars.rti.model.PartitionOfProperty;
import com.mars.rti.model.PropertyAssessmentTrasScript;
import com.mars.rti.model.PropertyComplaintRegistration;
import com.mars.rti.model.PropertyTaxDemand;
import com.mars.rti.model.PropertyTaxExemption;
import com.mars.rti.model.PropertyTaxNoDues;
import com.mars.rti.model.PropertyTaxUtara;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.TaxExemptionNonResidential;
import com.mars.rti.model.TradeLicenceNew;
import com.mars.rti.model.TradeLicencePartnerChange;
import com.mars.rti.model.TradeLicencePartnerCountUpdate;
import com.mars.rti.model.TradeLicenceRenewal;
import com.mars.rti.model.TradeLicenseCancellation;
import com.mars.rti.model.TradeLicenseDuplicateCopy;
import com.mars.rti.model.TradeLicenseNameChange;
import com.mars.rti.model.TradeLicenseOutdatedRenewalNotice;
import com.mars.rti.model.TradeLicenseTransfer;
import com.mars.rti.model.TradeLicenseTypeChange;
import com.mars.rti.model.TreeCuting;
import com.mars.rti.model.TreeTrimming;
import com.mars.rti.model.WaterConnectionNoDue;
import com.mars.rti.model.WaterConnectionTypeChange;
import com.mars.rti.model.WaterConnectionUsage;
import com.mars.rti.model.WaterDisconnection;
import com.mars.rti.model.WaterMeterComplaint;
import com.mars.rti.model.WaterPressure;
import com.mars.rti.model.WaterQualityComplaint;
import com.mars.rti.model.WaterReconnection;
import com.mars.rti.model.ZoneCertificates;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.BirthCertificateService;
import com.mars.rti.service.ChangeInOwnershipTypeService;
import com.mars.rti.service.DeathCertificateService;
import com.mars.rti.service.DikshaBhumiService;
import com.mars.rti.service.DogLicenceCertificateService;
import com.mars.rti.service.DurgaUtsavService;
import com.mars.rti.service.FireComplianceCertificateService;
import com.mars.rti.service.FireRecommendationService;
import com.mars.rti.service.GaneshMandapPermissionService;
import com.mars.rti.service.IllegalWaterConnectionService;
import com.mars.rti.service.MandapPermissionService;
import com.mars.rti.service.MarriageCertificateService;
import com.mars.rti.service.NOCOfTradeService;
import com.mars.rti.service.NewWaterConnectionService;
import com.mars.rti.service.NewlyConstructedPropertyService;
import com.mars.rti.service.OccupancyCertificateService;
import com.mars.rti.service.PartMapService;
import com.mars.rti.service.PartitionOfPropertyService;
import com.mars.rti.service.PropertyAssessmentService;
import com.mars.rti.service.PropertyTaxComplaintService;
import com.mars.rti.service.PropertyTaxDemandService;
import com.mars.rti.service.PropertyTaxNoDuesService;
import com.mars.rti.service.PropertyTaxUtaraService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TaxExemptionNonResidentialService;
import com.mars.rti.service.TaxExmeptionService;
import com.mars.rti.service.TradeLicenceNewService;
import com.mars.rti.service.TradeLicencePartnerChangeService;
import com.mars.rti.service.TradeLicencePartnerCountUpdateService;
import com.mars.rti.service.TradeLicenceRenewalService;
import com.mars.rti.service.TradeLicenseCancellationService;
import com.mars.rti.service.TradeLicenseDuplicateCopyService;
import com.mars.rti.service.TradeLicenseNameChangeService;
import com.mars.rti.service.TradeLicenseOutdatedRenewalService;
import com.mars.rti.service.TradeLicenseTransferService;
import com.mars.rti.service.TradeLicenseTypeChangeService;
import com.mars.rti.service.TreeCutingService;
import com.mars.rti.service.TreeTrimmingService;
import com.mars.rti.service.WaterConnectionNoDueService;
import com.mars.rti.service.WaterConnectionTypeChangeService;
import com.mars.rti.service.WaterConnectionUsageService;
import com.mars.rti.service.WaterDisconnectionService;
import com.mars.rti.service.WaterMeterComplaintService;
import com.mars.rti.service.WaterPressureService;
import com.mars.rti.service.WaterQualityComplaintService;
import com.mars.rti.service.WaterReconnectionService;
import com.mars.rti.service.ZoneCertificatesService;

@Controller
public class ZoneTransferController {


	private static String const_OrderBy = "OrderBy";

	private static String const_SortBy = "SortBy";
	
	private static Log log = LogFactory.getLog(ZoneTransferController.class);

	@Autowired
	RTIApplicationService rtiApplicationService;
	
	@Autowired
	GaneshMandapPermissionService ganeshMandapPermissionService;
	
	@Autowired
	DurgaUtsavService  durgaUtsavService;
	
	@Autowired
	DikshaBhumiService dikshaBhumiService;
	
	@Autowired
	private BirthCertificateService  birthCertificateService;

	@Autowired
	private DeathCertificateService deathCertificateService;
	
	@Autowired
	private MarriageCertificateService marriageCertificateService;
	
	@Autowired
	private DogLicenceCertificateService dogLicenceCertificateService;

	@Autowired
	private PropertyTaxUtaraService propertyTaxUtaraService;
	
	@Autowired
	private PropertyTaxNoDuesService propertyTaxNoDuesService;
	
	@Autowired
	private PropertyAssessmentService propertyAssessmentService;

	@Autowired
	private PropertyTaxDemandService propertyTaxDemandService;

	@Autowired
	private TaxExmeptionService taxExemptionNonResidentialService;

	@Autowired
	private TaxExemptionNonResidentialService taxExemptionNonResidentialServices;

	@Autowired
	private PropertyTaxComplaintService propertyTaxComplaintService;

	@Autowired
	private PartitionOfPropertyService partitionOfPropertyService;

	@Autowired
	private NewlyConstructedPropertyService newlyConstructedPropertyService;

	@Autowired
	private ZoneCertificatesService zoneCertificatesService;

	@Autowired
	private OccupancyCertificateService occupancyCertificateService;

	@Autowired
	private PartMapService partMapService;
	
	@Autowired
	private NewWaterConnectionService newWaterConnectionService;

	@Autowired
	private ChangeInOwnershipTypeService changeInOwnershipTypeService;

	@Autowired
	private WaterConnectionTypeChangeService waterConnectionTypeChangeService;

	@Autowired
	private WaterDisconnectionService waterDisconnectionService;

	@Autowired
	private WaterReconnectionService waterReconnectionService;

	@Autowired
	private WaterConnectionUsageService waterConnectionUsageService;

	@Autowired
	private WaterConnectionNoDueService waterConnectionNoDueService;

	@Autowired
	private WaterMeterComplaintService waterMeterComplaintService;
	
	@Autowired
	private IllegalWaterConnectionService illegalWaterConnectionService;

	@Autowired
	private WaterPressureService waterPressureService;

	@Autowired
	private WaterQualityComplaintService waterQualityComplaintService;
	
	@Autowired
	private FireRecommendationService fireRecommendationService;
	
	@Autowired
	private FireComplianceCertificateService fireComplianceCertificateService;

	@Autowired
	private MandapPermissionService mandapPermissionService;
	
	@Autowired
	private NOCOfTradeService nocTradeService;
	
	@Autowired
	private TradeLicenseDuplicateCopyService tradeLicenseDuplicateCopyService;
	
	@Autowired
	private TradeLicenceRenewalService tradeLicenceRenewalService;

	@Autowired
	private TradeLicenseTransferService tradeLicenseTransferService;
	
	@Autowired
	private TradeLicenceNewService tradeLicenceNewService;

	@Autowired
	private TradeLicenseNameChangeService tradeLicenseNameChangeService;

	@Autowired
	private TradeLicenseTypeChangeService tradeLicenseTypeChangeService;

	@Autowired
	private TradeLicencePartnerChangeService tradeLicencePartnerChangeService;

	@Autowired
	private TradeLicencePartnerCountUpdateService tradeLicencePartnerCountUpdateService;

	@Autowired
	private TradeLicenseOutdatedRenewalService tradeLicenseOutdatedRenewalService;

	@Autowired
	private TradeLicenseCancellationService tradeLicenseCancellationService;
	
	@Autowired
	private TreeCutingService treeCutingService;

	@Autowired
	private TreeTrimmingService treeTrimmingService;

	@Autowired
	private TaxExmeptionService taxExmeptionService;


	@SuppressWarnings("unused")
	@RequestMapping("/rtsapplication/listApplicationTransfer.do")
	public ModelAndView listApplicationTransfer(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		try {
		if(sessionUser!=null) {
		RTIApplicationSearch applicationSearch = new RTIApplicationSearch();
		setSearchParameters(applicationSearch,request);
		RTIApplication rtiapplicationSearch=null;
		//FireRecommendation fireRecommendation=null;
		Object a = request.getSession().getAttribute("rtsNo");
		String temZone = request.getParameter("id1");
		String updatedZOne = request.getParameter("id2");
		
		String zone=null;
		if(applicationSearch.getRtiApplicationNumber()!=null) {
		 rtiapplicationSearch = rtiApplicationService.findZOneTransferApplicationNumber(applicationSearch.getRtiApplicationNumber());
		// fireRecommendation = fireRecommendationService.getApplicationId(applicationSearch.getRtiApplicationNumber());

		}else if(a!=null) {
			 rtiapplicationSearch = rtiApplicationService.findZOneTransferApplicationNumber((String) a);
             request.getSession().removeAttribute("rtsNo");
		}
         if(rtiapplicationSearch!=null) {
			request.setAttribute("currentPage", applicationSearch.getCurrentPage());
			request.setAttribute(const_OrderBy, applicationSearch.getOrderBy());
			request.setAttribute(const_SortBy, applicationSearch.getSortBy());
			request.setAttribute("SearchfileCreate", applicationSearch);
			request.setAttribute("data", rtiapplicationSearch);
			request.setAttribute("tempzone", temZone);
			request.setAttribute("updatedzone", updatedZOne);

			if(rtiapplicationSearch.getRtiserviceid() == 69){

			    FireRecommendation fireRecommendation =
			            fireRecommendationService.getApplicationId(
			                    rtiapplicationSearch.getRtiApplnNumber());
			    //String category=(String)request.getAttribute("tempcategory");
			    if(fireRecommendation != null){

			        request.setAttribute(
			                "tempcategory",
			                fireRecommendation.getFireSubDepartmentWiseLogin());

			        request.setAttribute(
			                "updatedzone",
			                fireRecommendation.getZoneNO());
			     //   String forwardedUser=fireRecommendationService.getForwardedUserName(zone, category);

			       // request.setAttribute("forwardedUser", forwardedUser);
			    }

			}
			else if(rtiapplicationSearch.getRtiserviceid() == 70){

			    FireComplianceCertificate fireComplianceCertificate =
			            fireComplianceCertificateService.get(
			                    rtiapplicationSearch.getRtiApplicationId());

			    if(fireComplianceCertificate != null){

//			        request.setAttribute(
//			                "tempcategory",
//			                fireComplianceCertificate.getFireSubDepartmentWiseLogin());
//
//			        request.setAttribute(
//			                "updatedzone",
//			                fireComplianceCertificate.getZoneNO());
			    }
			}
			

			

		   return new ModelAndView("applicationTransfer","rTIApplication",rtiapplicationSearch);
		
         }else {
  			request.setAttribute("searchParamSet", "true");
  			if(applicationSearch.getRtiApplicationNumber()!=null)
			request.setAttribute("errMessage", "Record Not Found.Please Enter Valid Application Number!");

         }
		return new ModelAndView("applicationTransfer");	
	}else {
		return new ModelAndView("redirect:/login.do");
	}
		}catch(Exception ex) {
  			request.setAttribute("searchParamSet", "true");
			request.setAttribute("errMessage", "Record Not Found.Please Enter Valid Application Number!");
	}
		
		 return new ModelAndView("applicationTransfer");
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

			searchFileCreate.setCurrentPage(longCurrentPage);
			searchFileCreate.setOrderBy(orderBy);
			searchFileCreate.setSortBy(sortBy);

			searchFileCreate.setRtiApplicationNumber(
					request.getParameter("searchrtiApplnNumber"));
			
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
	
	
	@RequestMapping("/rtsapplication/saveApplicationTransfer.do")
	public ModelAndView saveApplicationTransfer(HttpServletRequest request,HttpServletResponse repsonse) {
		
		long rtiApplicationID = Long.parseLong(request.getParameter("rtiapplicationId"));
		long rtiServiceId = Long.parseLong(request.getParameter("rtiServiceId"));
		String zoneNo = request.getParameter("zone");
		String tempZone= request.getParameter("tempzone");

		RTIApplication rTIApplication=null;
		if (rtiServiceId >0 && zoneNo != null) {
		     rTIApplication = rtiApplicationService.get(rtiApplicationID);
		    rTIApplication.setZone(zoneNo);
		    rTIApplication=rtiApplicationService.merge(rTIApplication);

		    if (rtiServiceId == 90) {
		        GaneshMandapPermission ganeshMandapPermission = ganeshMandapPermissionService.getDetails(rtiApplicationID);
		        ganeshMandapPermission.setZoneNo(zoneNo);
		        ganeshMandapPermissionService.saveGaneshMandapForm(ganeshMandapPermission);
		    } else if (rtiServiceId == 91) {
		        DurgaUtsavMandapPermission durgaUtsavMandapPermission = durgaUtsavService.getDetails(rtiApplicationID);
		        durgaUtsavMandapPermission.setZoneNo(zoneNo);
		        durgaUtsavService.saveDurgaUtsavMandapForm(durgaUtsavMandapPermission);
		    } else if (rtiServiceId == 92) {
		        DikshaBhumiMandapPermission dikshaBhumiMandapPermission = dikshaBhumiService.getDetails(rtiApplicationID);
		        dikshaBhumiMandapPermission.setZoneNo(zoneNo);
		        dikshaBhumiService.saveDikshaBhumiMandapPermission(dikshaBhumiMandapPermission);
		    }else if (rtiServiceId == 1) {//birth
		    	BirthCertificate birthCertificate = birthCertificateService.getDetails(rtiApplicationID);
		    	birthCertificate.setZone(zoneNo);
		        birthCertificateService.birthRegistrationCertificate(birthCertificate);
		    }
		    else if (rtiServiceId == 2) {//death
		    	DeathCertificate deathCertificate = deathCertificateService.getDetails(rtiApplicationID);
		    	deathCertificate.setZone(zoneNo);
		        deathCertificateService.deathRegistrationCertificate(deathCertificate);
		    }else if (rtiServiceId == 11) {//Marriage
		    	MarriageCertificate marriageCertificate = marriageCertificateService.getDetails(rtiApplicationID);
		       marriageCertificate.setZoneNo(zoneNo);
		       marriageCertificateService.saveMarriageCertificate(marriageCertificate);
		    }else if (rtiServiceId == 3) {//Dog License
		    	DogLicenseCertificate dogLicenceCertificate = dogLicenceCertificateService.getDetails(rtiApplicationID);
		        dogLicenceCertificate.setZoneNo(zoneNo);
		        dogLicenceCertificateService.saveDogLicenceCertificate(dogLicenceCertificate);
		    }else if (rtiServiceId == 65) {//Dog License renewal
		    	DogLicenseCertificate dogLicenceCertificate = dogLicenceCertificateService.getDetails(rtiApplicationID);
		        dogLicenceCertificate.setZoneNo(zoneNo);
		        dogLicenceCertificateService.saveDogLicenceCertificate(dogLicenceCertificate);
		    }else if (rtiServiceId == 55) {//Tax Utara
		    	PropertyTaxUtara propertyTaxUtara = propertyTaxUtaraService.getDetails(rtiApplicationID);
		    	propertyTaxUtara.setZoneNo(zoneNo);
		    	propertyTaxUtaraService.savePropertyTaxUtara(propertyTaxUtara);
		    }else if (rtiServiceId == 54) {//Tax No Dues
		    	PropertyTaxNoDues propertyTaxNoDues = propertyTaxNoDuesService.getDetails(rtiApplicationID);
		    	propertyTaxNoDues.setZoneNo(zoneNo);
		    	propertyTaxNoDuesService.savePropertyTaxNoDues(propertyTaxNoDues);
//		    }else if (rtiServiceId == 57) {//Property Transfer Registration
//		        DikshaBhumiMandapPermission dikshaBhumiMandapPermission = dikshaBhumiService.getDetails(rtiApplicationID);
//		        dikshaBhumiMandapPermission.setZoneNo(zoneNo);
//		        dikshaBhumiService.saveDikshaBhumiMandapPermission(dikshaBhumiMandapPermission);
//	    }else if (rtiServiceId == 66) {//New Tax Recovery (Mutation)
//		        DikshaBhumiMandapPermission dikshaBhumiMandapPermission = dikshaBhumiService.getDetails(rtiApplicationID);
//		        dikshaBhumiMandapPermission.setZoneNo(zoneNo);
//		        dikshaBhumiService.saveDikshaBhumiMandapPermission(dikshaBhumiMandapPermission);
		    }else if (rtiServiceId == 58) {//Property Assessment Transcript
		    	PropertyAssessmentTrasScript propertyAssessmentTrasScript = propertyAssessmentService.getDetails(rtiApplicationID);
		    	propertyAssessmentTrasScript.setZoneNo(zoneNo);
		    	propertyAssessmentService.savePropertyAssessment(propertyAssessmentTrasScript);
		    }else if (rtiServiceId == 72) {//Property Tax Demand
		    	PropertyTaxDemand propertyTaxDemand = propertyTaxDemandService.getDetails(rtiApplicationID);
		    	propertyTaxDemand.setZoneNo(zoneNo);
		    	propertyTaxDemandService.savePropertyTaxDemand(propertyTaxDemand);
		    }else if (rtiServiceId == 71) {//Tax Exemption
		    	PropertyTaxExemption propertyTaxExemption = taxExmeptionService.getDetails(rtiApplicationID);
		    	propertyTaxExemption.setZoneNo(zoneNo);
		    	taxExemptionNonResidentialService.saveTaxExemptionNonResidential(propertyTaxExemption);
		    }else if (rtiServiceId == 52) {//Tax Exemption For Non-Residential Property
		    	TaxExemptionNonResidential taxExemptionNonResidential = taxExemptionNonResidentialServices.getDetails(rtiApplicationID);
		    	taxExemptionNonResidential.setZoneNo(zoneNo);
		    	taxExemptionNonResidentialServices.saveTaxExemptionNonResidential(taxExemptionNonResidential);
//		    }else if (rtiServiceId == 60) {//Self Assessment
//		    	DikshaBhumiMandapPermission dikshaBhumiMandapPermission = dikshaBhumiService.getDetails(rtiApplicationID);
//		        dikshaBhumiMandapPermission.setZoneNo(zoneNo);
//		        dikshaBhumiService.saveDikshaBhumiMandapPermission(dikshaBhumiMandapPermission);
		    }else if (rtiServiceId == 67) {//Property Complaint Registration
		    	PropertyComplaintRegistration propertyComplaintRegistration = propertyTaxComplaintService.getDetails(rtiApplicationID);
		    	propertyComplaintRegistration.setZoneNo(zoneNo);
		    	propertyTaxComplaintService.saveTaxExemptionNonResidential(propertyComplaintRegistration);
		    }else if (rtiServiceId == 53) {//Partition Of Property
		    	PartitionOfProperty partitionOfProperty = partitionOfPropertyService.getDetails(rtiApplicationID);
		    	partitionOfProperty.setZoneNo(zoneNo);
		    	partitionOfPropertyService.savePartitionOfPropertyForm(partitionOfProperty);
		    }else if (rtiServiceId == 56) {//Newly Constructed Property
		    	NewlyConstructedProperty newlyConstructedProperty = newlyConstructedPropertyService.getDetails(rtiApplicationID);
		    	newlyConstructedProperty.setZoneNo(zoneNo);
		    	newlyConstructedPropertyService.saveNewlyConstructedProperty(newlyConstructedProperty);
		    }else if (rtiServiceId == 5) {//Zone Certificate
		    	ZoneCertificates zoneCertificates = zoneCertificatesService.getDetails(rtiApplicationID);
		    	zoneCertificates.setZoneNo(zoneNo);
		    	zoneCertificatesService.saveZoneForm(zoneCertificates);
		    }else if (rtiServiceId == 28) {//Part Map Certificate
		    	PartMap partMap = partMapService.getDetails(rtiApplicationID);
		    	partMap.setZoneNo(zoneNo);
		    	partMapService.savePartMapForm(partMap);
		    }else if (rtiServiceId == 25) {//Occupancy Certificate
		    	OccupancyCertificate occupancyCertificate = occupancyCertificateService.getDetails(rtiApplicationID);
		    	occupancyCertificate.setZoneNo(zoneNo);
		    	occupancyCertificateService.saveOccupancyForm(occupancyCertificate);
		    }else if (rtiServiceId == 48) {//New Water Connection
		    	NewWaterConnection newWaterConnection = newWaterConnectionService.getDetails(rtiApplicationID);
		    	newWaterConnection.setZoneNo(zoneNo);
		    	newWaterConnectionService.saveNewWaterConnectionForm(newWaterConnection);
		    }else if (rtiServiceId == 49) {//Change In Ownership Type
		    	ChangeInOwnershipType changeInOwnershipType = changeInOwnershipTypeService.getDetails(rtiApplicationID);
		    	changeInOwnershipType.setZoneNo(zoneNo);
		    	changeInOwnershipTypeService.saveChangeInOwnershipType(changeInOwnershipType);
		    }else if (rtiServiceId == 47) {//Change In Water Connection Type
		    	WaterConnectionTypeChange waterConnectionTypeChange = waterConnectionTypeChangeService.getDetails(rtiApplicationID);
		    	waterConnectionTypeChange.setZoneNo(zoneNo);
		    	waterConnectionTypeChangeService.saveWaterConnectionType(waterConnectionTypeChange);
		    }else if (rtiServiceId == 6) {//Discontinue Water Connection
		    	WaterDisconnection waterDisconnection = waterDisconnectionService.getDetails(rtiApplicationID);
		    	waterDisconnection.setZoneNo(zoneNo);
		        waterDisconnectionService.saveWaterDisconnection(waterDisconnection);
		    }else if (rtiServiceId == 50) {//Reconnection Of Water Line
		    	WaterReconnection waterReconnection = waterReconnectionService.getDetails(rtiApplicationID);
		    	waterReconnection.setZoneNo(zoneNo);
		    	waterReconnectionService.saveWaterReconnection(waterReconnection);
		    }else if (rtiServiceId == 51) {//Change In Water Connection Usage
		    	WaterConnectionUsage waterConnectionUsage = waterConnectionUsageService.getDetails(rtiApplicationID);
		    	waterConnectionUsage.setZoneNo(zoneNo);
		    	waterConnectionUsageService.saveWaterConnectionUsage(waterConnectionUsage);
		    }else if (rtiServiceId == 68) {//Water No Dues Certificate
		    	WaterConnectionNoDue waterConnectionNoDue = waterConnectionNoDueService.getDetails(rtiApplicationID);
		    	waterConnectionNoDue.setZoneNo(zoneNo);
		    	waterConnectionNoDueService.waterConnectionSave(waterConnectionNoDue);
		    }else if (rtiServiceId == 64) {//Complaints Against Water Meter
		    	WaterMeterComplaint waterMeterComplaint = waterMeterComplaintService.getDetails(rtiApplicationID);
		    	waterMeterComplaint.setZoneNo(zoneNo);
		    	waterMeterComplaintService.saveWaterMeterComplaint(waterMeterComplaint);
		    }else if (rtiServiceId == 63) {//Illegal Water Connection Complaint
		    	IllegalWaterConnectionComplaint illegalWaterConnectionComplaint = illegalWaterConnectionService.getDetails(rtiApplicationID);
		    	illegalWaterConnectionComplaint.setZoneNo(zoneNo);
		    	illegalWaterConnectionService.saveIllegalWaterConnectionComplaint(illegalWaterConnectionComplaint);
		    }else if (rtiServiceId == 62) {//Water Force Complaint
		    	WaterPressure waterPressure = waterPressureService.getDetails(rtiApplicationID);
		    	waterPressure.setZoneNo(zoneNo);
		    	waterPressureService.saveWaterConnectionType(waterPressure);
		    }else if (rtiServiceId == 61) {//Complaint Against Water Quality
		    	WaterQualityComplaint waterQualityComplaint = waterQualityComplaintService.getDetails(rtiApplicationID);
		    	waterQualityComplaint.setZoneNo(zoneNo);
		    	waterQualityComplaintService.saveWaterQualityComplaintForm(waterQualityComplaint);
		    }else if (rtiServiceId == 69) {//Fire NOC(Fire Recommendation)
				String category= request.getParameter("category");

		    	FireRecommendation fireRecommendation = fireRecommendationService.getDetails(rtiApplicationID);
		    	fireRecommendation.setZoneNO(zoneNo);
		    	fireRecommendation.setFireDepartmentWiseLogin(zoneNo);
		    	fireRecommendation.setFireSubDepartmentWiseLogin(category);	    	

		    	fireRecommendation.setForwardedToL1(true);
		    	fireRecommendationService.saveFireForm(fireRecommendation);
		    }else if (rtiServiceId == 70) {//Fire NOC Renewal
				String category= request.getParameter("category");

		    	FireComplianceCertificate fireComplianceCertificate = fireComplianceCertificateService.get(rtiApplicationID);
//		    	fireComplianceCertificate.setZoneNO(zoneNo);
//		    	fireComplianceCertificate.setFireDepartmentWiseLogin(zoneNo);
//		    	fireComplianceCertificate.setFireSubDepartmentWiseLogin(zoneNo);	
		    	fireComplianceCertificateService.savefireComplianceCertificateForm(fireComplianceCertificate);
		    }else if (rtiServiceId == 23) {//Mandap Permisssion
		    	MandapPermission mandapPermission = mandapPermissionService.getDetails(rtiApplicationID);
		    	mandapPermission.setZoneNo(zoneNo);
		        mandapPermissionService.saveMandapForm(mandapPermission);
		    }
		    else if (rtiServiceId == 32) {//trade NOC
		    	NOCOfTrade nocTrade = nocTradeService.getDetails(rtiApplicationID);
		    	nocTrade.setZoneNo(zoneNo);
		        nocTradeService.saveNOCOfTrade(nocTrade);
		    }
		    else if (rtiServiceId == 41) {//Trade License Duplication
		    	TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy = tradeLicenseDuplicateCopyService.getDetails(rtiApplicationID);
		    	tradeLicenseDuplicateCopy.setZoneNo(zoneNo);
		    	tradeLicenseDuplicateCopyService.saveTradeLicenseDuplicateCopy(tradeLicenseDuplicateCopy);
		    }
		    else if (rtiServiceId == 33) {//Trade License Renewal
		    	TradeLicenceRenewal tradeLicenceRenewal = tradeLicenceRenewalService.getDetails(rtiApplicationID);
		    	tradeLicenceRenewal.setZoneNo(zoneNo);
		    	tradeLicenceRenewalService.saveTradeLicence(tradeLicenceRenewal);
		    }
		    else if (rtiServiceId == 38) {//Trade License Transfer
		    	TradeLicenseTransfer tradeLicenseTransfer = tradeLicenseTransferService.getDetails(rtiApplicationID);
		    	tradeLicenseTransfer.setZoneNo(zoneNo);
		    	tradeLicenseTransferService.saveTradeLicenseTransfer(tradeLicenseTransfer);
		    }
		    else if (rtiServiceId == 44) {//Trade License New
		    	TradeLicenceNew tradeLicenceNew = tradeLicenceNewService.getDetails(rtiApplicationID);
		    	tradeLicenceNew.setZoneNo(zoneNo);
		    	tradeLicenceNewService.saveTradeLicenceNew(tradeLicenceNew);
		    }
		    else if (rtiServiceId == 34) {//Trade License Name Change
		    	TradeLicenseNameChange tradeLicenseNameChange = tradeLicenseNameChangeService.getDetails(rtiApplicationID);
		    	tradeLicenseNameChange.setZoneNo(zoneNo);
		    	tradeLicenseNameChangeService.saveTradeLicenseNameChange(tradeLicenseNameChange);
		    }
		    else if (rtiServiceId == 35) {//Trade License Type Change
		    	TradeLicenseTypeChange tradeLicenseTypeChange = tradeLicenseTypeChangeService.getDetails(rtiApplicationID);
		    	tradeLicenseTypeChange.setZoneNo(zoneNo);
		        tradeLicenseTypeChangeService.saveTradeLicenseTypeChange(tradeLicenseTypeChange);
		    }
		    else if (rtiServiceId == 36) {//Trade License Owner/Partner Change
		    	TradeLicencePartnerChange tradeLicencePartnerChange = tradeLicencePartnerChangeService.getDetails(rtiApplicationID);
		    	tradeLicencePartnerChange.setZoneNo(zoneNo);
		        tradeLicencePartnerChangeService.saveTradeLicence(tradeLicencePartnerChange);
		    }
		    else if (rtiServiceId == 39) {//License Partner Count Update
		    	TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate = tradeLicencePartnerCountUpdateService.getDetails(rtiApplicationID);
		    	tradeLicencePartnerCountUpdate.setZoneNo(zoneNo);
		    	tradeLicencePartnerCountUpdateService.saveTradeLicence(tradeLicencePartnerCountUpdate);
		    }
		    else if (rtiServiceId == 42) {//Trade License Outdated Renewal Notice
		    	TradeLicenseOutdatedRenewalNotice tradeLicenseOutdatedRenewalNotice = tradeLicenseOutdatedRenewalService.getDetails(rtiApplicationID);
		    	tradeLicenseOutdatedRenewalNotice.setZoneNo(zoneNo);
		    	tradeLicenseOutdatedRenewalService.saveTradeLicenseOutdatedRenewal(tradeLicenseOutdatedRenewalNotice);
		    }
		    else if (rtiServiceId == 40) {//Trade License Cancellation
		    	TradeLicenseCancellation tradeLicenseCancellation = tradeLicenseCancellationService.getDetails(rtiApplicationID);
		    	tradeLicenseCancellation.setZoneNo(zoneNo);
		    	tradeLicenseCancellationService.saveTradeLicenseCancel(tradeLicenseCancellation);
		    }
		    else if (rtiServiceId == 73) {//Tree Cutting
		    	TreeCuting treeCuting = treeCutingService.getDetails(rtiApplicationID);
		    	treeCuting.setZoneNo(zoneNo);
		    	treeCutingService.saveTreeCutingForm(treeCuting);
		    }
		    else if (rtiServiceId == 75) {//Tree Trimming
		    	TreeTrimming treeTrimming = treeTrimmingService.getDetails(rtiApplicationID);
		    	treeTrimming.setZoneNo(zoneNo);
		    	treeTrimmingService.saveTreeTrimmingForm(treeTrimming);
		    }
		   
		}
		  String responseMessage="Entries  updated Successfully!! ";
    	 request.getSession().setAttribute("message", responseMessage);	
		request.getSession().setAttribute("rtsNo", rTIApplication.getRtiApplnNumber());
		return new ModelAndView("redirect:/rtsapplication/listApplicationTransfer.do?id1="+tempZone+"&id2="+rTIApplication.getZone());
	}




	private char[] setZoneno(String zoneNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/rtsapplication/getForwardUser.do")
	public void getForwardUser(
	        HttpServletRequest request,
	        HttpServletResponse response)
	throws Exception{

	    response.setContentType("text/plain");

	    String zone=request.getParameter("zone");
	    String category=request.getParameter("category");

	    String userName=
	            fireRecommendationService.getForwardUser(
	                    zone,
	                    category);

	    response.getWriter()
	            .write(userName!=null ? userName : "");
	}
	
}
