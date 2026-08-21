package com.mars.rti.controller;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.groovy.runtime.dgmimpl.arrays.IntegerArrayPutAtMetaMethod;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.rti.model.FireBuildingHeight;
import com.mars.rti.model.FireDepartmentWiseLogin;
import com.mars.rti.model.FireFloorName;
import com.mars.rti.model.FireFloorTypes;
import com.mars.rti.model.FireRecommendationTypeOfBuilding;
import com.mars.rti.model.FireSubDepartmentWiseLogin;
import com.mars.rti.model.FireTypeOfConstruction;
import com.mars.rti.model.SubTypeOfbuilding;
import com.mars.rti.model.WaterConnectionPurpose;
import com.mars.rti.model.WaterProposedCategoryType;
import com.mars.rti.model.WaterProposedTapSize;
import com.mars.rti.service.FireBuildingHeightService;
import com.mars.rti.service.FireDepartmentWiseLoginService;
import com.mars.rti.service.FireFloorNameService;
import com.mars.rti.service.FireFloorTypesService;
import com.mars.rti.service.FireRecommendationTypeOfBuildingService;
import com.mars.rti.service.FireSubDepartmentWiseLoginService;
import com.mars.rti.service.FireTypeOfConstructionService;
import com.mars.rti.service.NewWaterConnectionService;
import com.mars.rti.service.SubTypeOfbuildingService;
import com.mars.rti.service.WaterConnectionTypeChangeService;
import com.mars.rti.service.WaterConnectionUsageService;

@Controller
public class AppliSarkarController extends MultiActionController implements InitializingBean {

	private static Log log = LogFactory.getLog(AppliSarkarController.class);

	@Autowired
	private FireBuildingHeightService fireBuildingHeightService;

	@Autowired
	private FireFloorNameService fireFloorNameService;

	@Autowired
	private FireRecommendationTypeOfBuildingService fireRecommendationTypeOfBuildingService;

	@Autowired
	private FireTypeOfConstructionService fireTypeOfConstructionService;

	@Autowired
	private WaterConnectionUsageService waterConnectionUsageService;

	@Autowired
	private WaterConnectionTypeChangeService waterConnectionTypeChangeService;

	@Autowired
	private NewWaterConnectionService newWaterConnectionService;

	@Autowired
	private SubTypeOfbuildingService subTypeOfbuildingService;

	@Autowired
	private FireFloorTypesService fireFloorTypesService;

	@Autowired
	private FireDepartmentWiseLoginService fireDepartmentWiseLoginService;

	@Autowired
	private FireSubDepartmentWiseLoginService fireSubDepartmentWiseLoginService;

	@Autowired
	private UserRegistrationService userService;
	
	
	@Autowired
	private AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;

	@Autowired
	private UserRegistrationService userRegistrationService;
	// Birth
	
	String str = "";
	String serviceId = "";
	long actualMobileNo=0;

	
//	@RequestMapping("/aplesarkar")
//	public void aplesarkar(HttpServletRequest request,HttpServletResponse response) {
//		String str = "1C273EB8FF9134E63E400953BFFD82CA6714E31B3507E1BBAA13BB2497725EC1532DC8022CA7082624BB32ECAC645AD16367F0305D0DA234F89DCE38592D78F35511430BA680563A1A3DA472EC1F2D7D040F29C9EC388FF95AE5C2B8389D3272B318D025BE8056A6DB66B1BAB07804434535A035A940BD5CE225347EAEE17E09";
//		String serviceId = "NMCDeptN";
//		String g = aapleSarkarAuthentication(str,serviceId,request,response);
//		
//	}
	
	@RequestMapping("as/rtiapplication/newRTIBirthApplication.do")
	public ModelAndView newRTIBirthApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIBirthApplication");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
		     

			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}

	}

	// Death
	@RequestMapping("as/rtiapplication/newRTIDeathApplication.do")
	public ModelAndView newRTIDeathApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIDeathApplication");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
		     			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Marriage
	@RequestMapping("as/rtsapplication/newRTIMarriageApplication.do")
	public ModelAndView newRTIMarriageApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIMarriageApplication");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
		     
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// NursingHomeRegistration
	@RequestMapping("as/rtsapplication/newRTSNursingHome.do")
	public ModelAndView newRTSNursingHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTSNursinfHomeRegistration");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// NursingHomeRenewal
	@RequestMapping("as/rtsapplication/newRTSNursingHomeRenewal.do")
	public ModelAndView newRTSNursingHomeRenewal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTSNursinfHomeRenewal");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Change In Beds
	@RequestMapping("as/rtsapplication/newRTSBedsInNursingHomeRegistration.do")
	public ModelAndView newRTSBedsInNursingHomeRegistration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTSBedsInNursingHomeRegistration");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// MTP

	@RequestMapping("as/rtsapplication/newRTSMTPRegistrationCertificate.do")
	public ModelAndView newRTSMTPRegistrationCertificate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("NewRTSMTPRegistrationCertificate");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Dog License
	@RequestMapping("as/rtiapplication/newRTIDogLicence.do")
	public ModelAndView newRTIDogLicence(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIDogLicence");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
		
	}

	// Dog License Renewal
	@RequestMapping("as/rtiapplication/newRTIDogRenewalLicence.do")
	public ModelAndView newRTIDogRenewalLicence(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIDogRenewalLicence");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Property Tax Utara

	@RequestMapping("as/rtiapplication/newRTIPropertyTaxUtara.do")
	public ModelAndView newRTIPropertyTaxUtara(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIPropertyTaxUtara");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}

	}

	// Property Tax No Dues

	@RequestMapping("as/rtiapplication/newRTIPropertyTaxNoDues.do")
	public ModelAndView newRTIPropertyTaxNoDues(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIPropertyTaxNoDues");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// property tax Transfer Registration
	@RequestMapping("as/rtiapplication/newRTIPropertyTransferRegistration.do")
	public ModelAndView newRTIPropertyTransferRegistration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIPropertyTransferRegistration");
			
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}

	}

	// Property tax Mutation
	@RequestMapping("as/rtiapplication/newRTIPropertyTaxRecovery.do")
	public ModelAndView newRTIPropertyTaxRecovery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIPropertyTaxRecovery");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Property tax Assenment
	@RequestMapping("as/rtiapplication/newRTInewRTIPropertyAssessment.do")
	public ModelAndView newRTInewRTIPropertyAssessment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIPropertyAssessmentTranscript");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Property Tax Demand
	@RequestMapping("as/rtiapplication/newRTIPropertyTaxDemand.do")
	public ModelAndView newRTIPropertyTaxDemand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIPropertyTaxDemand");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Property Tax Exemption
	@RequestMapping("as/rtiapplication/newRTIPropertyTaxExemption.do")
	public ModelAndView newRTIPropertyTaxExemption(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIPropertyTaxExemption");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Zone
	@RequestMapping("as/rtiapplication/newRTIZoneApplication.do")
	public ModelAndView newRTIZoneApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIZoneApplication");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
			} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Partmap
	@RequestMapping("as/rtiapplication/newRTIPartMapApplication.do")
	public ModelAndView newRTIPartMapApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIPartMapApplication");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// New Water Connection
	@RequestMapping("as/rtsapplication/newRTINewWaterConnectionApplication.do")
	public ModelAndView newRTINewWaterConnectionApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {
				List<WaterConnectionPurpose> purposeOfWater = newWaterConnectionService.getWaterConnectionPurpose();
				request.setAttribute("purposeOfWater", purposeOfWater);

				List<WaterProposedTapSize> tapSize = waterConnectionTypeChangeService.getProposedTapSize();
				request.setAttribute("tapSize", tapSize);
			ModelAndView modelAndView = new ModelAndView("newRTSWaterNewConnection");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
			} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	@RequestMapping("as/rtiapplication/newRTIChangeInOwnershipType.do")
	public ModelAndView newRTIChangeInOwnershipType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIChangeInOwnershipType");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	@RequestMapping("as/rtiapplication/newRTIWaterConnectionTypeChange.do")
	public ModelAndView newRTIWaterConnectionTypeChange(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {
					List<WaterProposedTapSize> proposedTapSize = waterConnectionTypeChangeService.getProposedTapSize();
				request.setAttribute("proposedTapSize", proposedTapSize);
			ModelAndView modelAndView = new ModelAndView("newRTIWaterConnectionTypeChange");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
			} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Water Disconnection

	@RequestMapping("as/rtiapplication/newRTIWaterDisconnection.do")
	public ModelAndView newRTIWaterDisconnection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIWaterDisconnection");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
			} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// water reconnection
	@RequestMapping("as/rtiapplication/newRTIWaterReconnection.do")
	public ModelAndView newRTIWaterReconnection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIWaterReconnection");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
			} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Water Connection Usage
	@RequestMapping("as/rtiapplication/newRTIWaterConnectionUsage.do")
	public ModelAndView newRTIWaterConnectionUsage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {
					List<WaterProposedCategoryType> proposedCategoryType = waterConnectionUsageService.getProposedCategory();
				request.setAttribute("proposedCategoryType", proposedCategoryType);
				ModelAndView modelAndView = new ModelAndView("newRTIWaterConnectionUsage");
				 modelAndView.addObject("str", str);
			     modelAndView.addObject("serviceId", serviceId);
			     
			     
			     
			     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
			     
			     for (int i = 0; i < fields.length; i++) {
			    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
			    	}

			     modelAndView.addObject("distric", fields[15]);
			     modelAndView.addObject("trackid", fields[0]);
			     modelAndView.addObject("user", fields[2]);
			     modelAndView.addObject("mobile", fields[16]);
			     modelAndView.addObject("name", fields[17]);
			     modelAndView.addObject("fields", fields);
				return modelAndView;
			} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// water
	@RequestMapping("as/rtiapplication/newRTIWaterNoDueApplication.do")
	public ModelAndView newRTIWaterNoDueApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIWaterNoDueApplication");
			 modelAndView.addObject("str", str);
		     modelAndView.addObject("serviceId", serviceId);
		     
		     
		     
		     String[] fields = (String[]) request.getSession().getAttribute("fields_aps");
		     
		     for (int i = 0; i < fields.length; i++) {
		    	 log.debug("Index controller XXX--> " + i + ": " + fields[i]);
		    	}

		     modelAndView.addObject("distric", fields[15]);
		     modelAndView.addObject("trackid", fields[0]);
		     modelAndView.addObject("user", fields[2]);
		     modelAndView.addObject("mobile", fields[16]);
		     modelAndView.addObject("name", fields[17]);
		     modelAndView.addObject("fields", fields);
			return modelAndView;
			} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	@RequestMapping("as/rtiapplication/newRTSFireRecommendationLetter.do")
	public ModelAndView newRTSFireRecommendationLetter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {
					List<FireRecommendationTypeOfBuilding> fireRecommendationTypeOfBuilding = fireRecommendationTypeOfBuildingService
						.getTypeOfFireTypeOfBuilding();
				request.setAttribute("fireRecommendationTypeOfBuilding", fireRecommendationTypeOfBuilding);

				List<FireTypeOfConstruction> fireTypeOfConstruction = fireTypeOfConstructionService
						.getTypeOfConstruction();
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
				ModelAndView modelAndView = new ModelAndView("newRTSFireRecommendationLetter");
				return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Fire Compliance
	@RequestMapping("as/rtiapplication/newRTIFireComplianceCertificateApplication.do")
	public ModelAndView newRTIFireComplianceCertificateApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIFireComplianceCertificateApplication");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Mandap Permission Document
	@RequestMapping("as/rtiapplication/newRTIMandapApplication.do")
	public ModelAndView newRTIMandapApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTIMandapApplication");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Ganesh Mandap Permission
	@RequestMapping("as/rtsapplication/newRTSGaneshApplication")
	public ModelAndView newRTSGaneshApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTSGaneshPermission");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Durga Utsav Mandap Permission
	@RequestMapping("as/rtsapplication/newRTSDurgaUtsavApplication.do")
	public ModelAndView newRTSDurgaUtsavApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTSDurgaUtsavPermission");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Fire Crackers
	// Fire Cracker Shop License
	@RequestMapping("as/rtsapplication/newRTSFireCrackerShopLicense.do")
	public ModelAndView newRTSFireCrackerShopLicense(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTSFireCrackerShopLicense");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
		
	}

	// Diksha Bhoomi Mandap Permission
	@RequestMapping("as/rtsapplication/newRTSDikshaBhoomiApplication.do")
	public ModelAndView newRTSDikshaBhoomiApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTSDikhsaBhomiMandapPermission");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	@RequestMapping("as/rtiapplication/newRTSApplicationFromTreeCuting.do")
	public ModelAndView newRTSApplicationFromTreeCuting(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTSApplicationFromTreeCuting");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Tree Trimming
	@RequestMapping("as/rtiapplication/newRTSTreeTrimmingApplication.do")
	public ModelAndView newRTSTreeTrimmingApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTSTreeTrimmingApplication");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
		
	}
	
	
	// Market Services
	@RequestMapping("as/rtiapplication/newRTINOCOfTradeApplication.do")
	public ModelAndView newRTINOCOfTradeApplication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTINOCOfTradeApplication");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	
	@RequestMapping("as/rtiapplication/newRTITradeLicenceNew.do")
	public ModelAndView newRTITradeLicenceNew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTITradeLicenceNew");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
		
	}

	
	// Trade License Renewal
	@RequestMapping("as/rtiapplication/newRTITradeLicenceRenewal.do")
	public ModelAndView newRTITradeLicenceRenewal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTITradeLicenceRenewal");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}
	
	
	// Trade License Transfer
	@RequestMapping("as/rtiapplication/newRTITradeLicenseTransfer.do")
	public ModelAndView newRTITradeLicenseTransfer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTITradeLicenseTransfer");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}
	
	// Trade License Renewal Copy
	@RequestMapping("as/rtiapplication/newRTITradeLicenseDuplicateCopyApplication.do")
	public ModelAndView newRTITradeLicenseDuplicateCopyApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTITradeLicenseDuplicateCopy");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	// Trade License Name Change
	@RequestMapping("as/rtiapplication/newRTITradeLicenseNameChangeApplication.do")
	public ModelAndView newRTITradeLicenseNameChangeApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTITradeLicenseNameChange");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}
	
	// Trade License Type Change
	@RequestMapping("as/rtiapplication/newRTITradeLicenseTypeChangeApplication.do")
	public ModelAndView newRTITradeLicenseTypeChangeApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTITradeLicenseTypeChange");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}
	
	
	// Trade License Partner Change
	@RequestMapping("as/rtiapplication/newRTITradeLicencePartnerChange.do")
	public ModelAndView newRTITradeLicencePartnerChange(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTITradeLicencePartnerChange");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}

	@RequestMapping("as/rtiapplication/newRTITradePartnerCountUpdate.do")
	public ModelAndView newRTITradePartnerCountUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTITradePartnerCountUpdate");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
		
	}
	
	// Trade License Cancellation
	@RequestMapping("as/rtiapplication/newRTITradeLicenseCancellationApplication.do")
	public ModelAndView newRTITradeLicenseCancellationApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTITradeLicenseCancellation");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
		
	}
	
	// Trade License Outdated Renewal
	@RequestMapping("as/rtiapplication/newRTITradeLicenseOutdatedRenewalApplication.do")
	public ModelAndView newRTITradeLicenseOutdatedRenewalApplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		str = request.getParameter("str");
		serviceId = request.getParameter("ns");
		actualMobileNo = aapleSarkarAuthentication(str, serviceId, request, response);
		if (actualMobileNo > 0) {

			ModelAndView modelAndView = new ModelAndView("newRTITradeLicenseOutdatedRenewal");
			return modelAndView;
		} else {
			request.getSession().removeAttribute("mobileNo");
			return new ModelAndView("userError");
		}
	}
	
	@RequestMapping("as/nmc/dashboard/newApplicationDetails.do")
	public ModelAndView newApplicationDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView modelAndView = new ModelAndView("certificates");
		return modelAndView;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	public long getMobileNumber(String mbno, HttpServletRequest request, HttpServletResponse response) {
		long mobileNo = 0;
		if (log.isDebugEnabled()) {
			log.debug("MobileNo-"+mbno);
		}
		if (mbno != null & !mbno.isEmpty()) {
			UserRegistrationDetails user = userService.getUserByMobileNo(mbno);
			if (log.isDebugEnabled()) {
				log.debug("getting Users Details");
			}
			if (user != null) {
				mobileNo = Long.parseLong(mbno);
				request.getSession().setAttribute("mobileNo", mobileNo);
				request.getSession().setAttribute("as_status", 1);
				request.getSession().setAttribute("logedIn", 1);
				request.getSession().removeAttribute("name");


				if (log.isDebugEnabled()) {
					log.debug("Mobile No Found");
				}
				return mobileNo;
			} else {
				return -1;
				
			}
		}

		return mobileNo;
	}
	
	public long aapleSarkarAuthentication(String str, String serviceId, HttpServletRequest request, HttpServletResponse response)
	{
		long actualMobileNo=-1;
		String xmlResponse = aapleSarkarPortalIntegrationNagpur.authentication(str, serviceId);
		
		log.debug("aapleSarkarAuthentication xmlResponse : " +xmlResponse);
		
		if(!xmlResponse.equalsIgnoreCase("false")) {
		 String[] fields = xmlResponse.split("\\|");
		 HttpSession session = request.getSession();

		 session.setAttribute("fields_aps", fields);

		 String getMobileNumber = fields[16];
		 String name = fields[17];
		 String userId = fields[1];
		// String mobileNumber = "0";
		 long getStatus = getMobileNumber(getMobileNumber, request, response);
		 UserRegistrationDetails userRegistrationDetails = new UserRegistrationDetails();
		 
		 if (getStatus < 0) {
			 //userRegistrationService.getUserByMobileNo(mobileNumber);
			 userRegistrationDetails.setMobileNo(getMobileNumber);
			 userRegistrationDetails.setFirstName(name);
			 userRegistrationDetails.setCreatedDate(LocalDateTime.now()+"");
			 userRegistrationDetails.setEmail("email");
			 userRegistrationDetails.setLastName(name);
			 userRegistrationDetails.setLastLogin("12");
			 userRegistrationService.save(userRegistrationDetails);
			// mobileNumber = getMobileNumber;
			 if(getMobileNumber!=null && !getMobileNumber.isEmpty()) {
				  actualMobileNo = Long.parseLong(getMobileNumber);  

				 //actualMobileNo= Integer.parseInt(mobileNumber);
			 }
			 return actualMobileNo;
		}
		 else {
			 return  getStatus;
		 }
		 
		}else {
			return actualMobileNo;
		}
	}
	
	

	@RequestMapping("/as/rtsapplication/newRTSSuccess.do")
	public ModelAndView newRTSSuccess(HttpServletRequest request, HttpServletResponse response) {

		String appNo = request.getParameter("rtsAppNo");
		String EncyKey = request.getParameter("rtsAppNo");

		ModelAndView model = new ModelAndView("as_success");

		model.addObject("appNo", appNo);
		model.addObject("EncyKey", EncyKey);
		
		request.getSession().removeAttribute("as_status");
		request.getSession().removeAttribute("name");
		return model;

	}
	
}
