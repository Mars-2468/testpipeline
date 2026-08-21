package com.mars.rti.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.common.controller.AapleSarkarPortalIntegrationNagpur;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.GetRTSPropertyCollectionDetail;
import com.mars.rti.model.GetRTSPropertyListMutation;
import com.mars.rti.model.NewlyConstructedProperty;
import com.mars.rti.model.PartitionOfProperty;
import com.mars.rti.model.PropertyAssessmentTrasScript;
import com.mars.rti.model.PropertyComplaintRegistration;
import com.mars.rti.model.PropertyTaxExemption;
import com.mars.rti.model.PropertyTaxMutation;
import com.mars.rti.model.PropertyTaxTransferRegistration;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.NewlyConstructedPropertyService;
import com.mars.rti.service.PartitionOfPropertyService;
import com.mars.rti.service.PropertyAssessmentService;
import com.mars.rti.service.PropertyTaxComplaintService;
import com.mars.rti.service.PropertyTaxMutationService;
import com.mars.rti.service.PropertyTaxTransferRegistrationService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.service.TaxExmeptionService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.controller.DSCRestController;

@Controller
public class PropertyTaxPTNDetailsController {

	private static Log log = LogFactory.getLog(PropertyTaxPTNDetailsController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private PropertyTaxTransferRegistrationService propertyTaxTransferRegistrationService;

	@Autowired
	private PartitionOfPropertyService partitionOfPropertyService;

	@Autowired
	private PropertyTaxMutationService propertyTaxMutationService;

	@Autowired
	private PropertyTaxComplaintService propertyTaxComplaintService;

	@Autowired
	private PropertyAssessmentService propertyAssessmentService;

	@Autowired
	private TaxExmeptionService taxExemptionNonResidentialService;

	@Autowired
	private NewlyConstructedPropertyService newlyConstructedPropertyService;
	
	@Autowired
	private DSCRestController dscrestcontroller;

	@Autowired
	private AapleSarkarPortalIntegrationNagpur aapleSarkarPortalIntegrationNagpur;



	@Autowired
	private BirthRegistartionController birthRegistartionController;

	


	@Autowired
    private HttpServletRequest request;
	
	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/rtsapplication/getPropertyDetails.do")
	public void getPropertyDetails(HttpServletRequest request, HttpServletResponse response) {

		if (log.isDebugEnabled()) {
			log.debug("Invoking getPropertyDetails get API");
		}
		JSONObject json = new JSONObject();
		// String url =
		//String url = "https://nmctax.cybertech.com/GeocivicServices/CitizentaxService/CitizentaxService/AgentCollectionService.svc/GetRTSPropertyList";
		String url = CoreConstants.TAX_RTS_PROPERTY_LIST;
		String ptnNo = request.getParameter("ptnNo");
		String token = PropertyTaxTokenGeneration.propertyTaxToken();
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		try {
			headers.setContentType(MediaType.APPLICATION_JSON);

			String jsonRequestBody = "{ \"PTN\": \"" + ptnNo + "\", \"token\": \"" + token + "\" }";

			HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
			ResponseEntity<GetRTSPropertyListMutation> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
					requestEntity, GetRTSPropertyListMutation.class);

			GetRTSPropertyListMutation tokenResponse = responseEntity.getBody();
			HttpStatus statusCode = responseEntity.getStatusCode();

			if (tokenResponse.getGetRTSPropertyListResult().getResultList().size() > 0) {
				String address = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getAddress() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getAddress().isEmpty())
								? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getAddress()
								: "0";
				String areaspaymentstatus = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getArrearsPaymentStatus() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getArrearsPaymentStatus()
								.isEmpty())
										? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
												.getArrearsPaymentStatus()
										: "0";
				double arreaspending = tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getArrearsPending();
				String blockNo = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getBlockNo() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getBlockNo().isEmpty())
								? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getBlockNo()
								: "0";
				String blockname = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getBlockName() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getBlockName().isEmpty())
								? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getBlockName()
								: "0";
				String indexNo = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getIndexNumber() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getIndexNumber()
								.isEmpty())
										? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
												.getIndexNumber()
										: "0";
				String occupierName = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getOccupierName() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getOccupierName()
								.isEmpty())
										? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
												.getOccupierName()
										: "0";
				String ownerName = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getOwnerName() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getOwnerName().isEmpty())
								? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getOwnerName()
								: "0";
				String pincode = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getPincode() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getPincode().isEmpty())
								? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getPincode()
								: "0";
				String ptn = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getPtn() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getPtn().isEmpty())
								? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getPtn()
								: "0";
				String totalDemand = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getTotalDemand() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getTotalDemand()
								.isEmpty())
										? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
												.getTotalDemand()
										: "0";
				String zoneName = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getZoneName() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getZoneName().isEmpty())
								? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getZoneName()
								: "0";
				String zoneNo = getZoneName((tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getZoneNo() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getZoneNo().isEmpty())
								? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getZoneNo()
								: "0");
				String mobileNo = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getMobileNo() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getMobileNo().isEmpty())
								? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getMobileNo()
								: "";
				String wardNo = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getWardNo() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getWardNo().isEmpty())
								? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getWardNo()
								: "0";
				String house_no = (tokenResponse.getGetRTSPropertyListResult().getResultList().get(0)
						.getHouseNo() != null
						&& !tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getHouseNo().isEmpty())
								? tokenResponse.getGetRTSPropertyListResult().getResultList().get(0).getHouseNo()
								: "0";

				json.put("address", address);
				json.put("areaspaymentstatus", areaspaymentstatus);
				json.put("arreaspending", arreaspending);
				json.put("blockNo", blockNo);
				json.put("wardNo", wardNo);
				json.put("blockname", blockname);
				json.put("indexNo", indexNo);
				json.put("occupierName", occupierName);
				json.put("ownerName", ownerName);
				json.put("pincode", pincode);
				json.put("ptn", ptn);
				json.put("totalDemand", totalDemand);
				json.put("zoneName", zoneName);
				json.put("zoneNo", zoneNo);
				json.put("mobileNo", mobileNo);
				json.put("zone", zoneNo);
				json.put("status", true);
				json.put("houseNo", house_no);

				if (log.isDebugEnabled()) {
					log.debug("Invoking propertyMutationToken = " + token);
					log.debug(statusCode);
					log.debug(responseEntity.getBody());
					log.debug(address + " " + areaspaymentstatus + " " + arreaspending + " " + blockname + " " + indexNo
							+ " " + occupierName + " " + ownerName + " " + pincode + " " + ptn + " " + totalDemand + " "
							+ zoneName + " " + zoneNo);

				}

			} else {
				json.put("status", false);

			}

			PrintWriter printwriter = response.getWriter();

			printwriter.print(json.toString());
			printwriter.close();
			printwriter.flush();

		} catch (Exception ex) {
			log.error(ex.getMessage().toString());
			ex.printStackTrace();
		}

	}

	public String getZoneName(String zone) {

		String zoneName = "Zone No.";
		if (zone.equals("1") || zone.equals("01") || zone.equals("001")) {

			zoneName = zoneName + "1" + " -" + " " + "Laxmi Nagar";

		} else if (zone.equals("2") || zone.equals("02") || zone.equals("002")) {
			zoneName = zoneName + "2" + " -" + " " + "Dharampeth";

		} else if (zone.equals("3") || zone.equals("03") || zone.equals("003")) {
			zoneName = zoneName + "3" + " -" + " " + "Hanuman Nagar";

		} else if (zone.equals("4") || zone.equals("04") || zone.equals("004")) {
			zoneName = zoneName + "4" + " -" + " " + "Dhantoli";

		} else if (zone.equals("5") || zone.equals("05") || zone.equals("005")) {
			zoneName = zoneName + "5" + " -" + " " + "Nehru Nagar";

		} else if (zone.equals("6") || zone.equals("06") || zone.equals("006")) {
			zoneName = zoneName + "6" + " -" + " " + "Gandhibagh";

		} else if (zone.equals("7") || zone.equals("07") || zone.equals("007")) {
			zoneName = zoneName + "7" + " -" + " " + "Satranjipura";

		} else if (zone.equals("8") || zone.equals("08") || zone.equals("008")) {
			zoneName = zoneName + "8" + " -" + " " + "Lakadganj";

		} else if (zone.equals("9") || zone.equals("09") || zone.equals("009")) {
			zoneName = zoneName + "9" + " -" + " " + "Ashi Nagar";

		} else if (zone.equals("10") || zone.equals("010") || zone.equals("0010")) {
			zoneName = zoneName + "10" + " -" + " " + "Mangalwari";

		}

		return zoneName;
	}

	public static String getZoneNo(String zone) {

		String zoneName = "";
		if (zone.equals("Zone No.1 - Laxmi Nagar")) {

			zoneName = "1";
		} else if (zone.equals("Zone No.2 - Dharampeth")) {
			zoneName = "2";
		} else if (zone.equals("Zone No.3 - Hanuman Nagar")) {
			zoneName = "3";
		} else if (zone.equals("Zone No.4 - Dhantoli")) {
			zoneName = "4";
		} else if (zone.equals("Zone No.5 - Nehru Nagar")) {
			zoneName = "5";
		} else if (zone.equals("Zone No.6 - Gandhibagh")) {
			zoneName = "6";
		} else if (zone.equals("Zone No.7 - Satranjipura")) {
			zoneName = "7";
		} else if (zone.equals("Zone No.8 - Lakadganj")) {
			zoneName = "8";
		} else if (zone.equals("Zone No.9 - Ashi Nagar")) {
			zoneName = "9";
		} else if (zone.equals("Zone No.10 - Mangalwari")) {
			zoneName = "10";
		}

		return zoneName;
	}

	public static String getWard(String ward) {
		String wardNo = "";

		if (ward.equals("Ward No. 16")) {
			wardNo = "16";
		} else if (ward.equals("Ward No. 36")) {
			wardNo = "36";
		} else if (ward.equals("Ward No. 37")) {
			wardNo = "37";
		} else if (ward.equals("Ward No. 38")) {
			wardNo = "38";
		} else if (ward.equals("Ward No. 12")) {
			wardNo = "12";
		} else if (ward.equals("Ward No. 13")) {
			wardNo = "13";
		} else if (ward.equals("Ward No. 14")) {
			wardNo = "14";
		} else if (ward.equals("Ward No. 15")) {
			wardNo = "15";
		} else if (ward.equals("Ward No. 29")) {
			wardNo = "29";
		} else if (ward.equals("Ward No. 31")) {
			wardNo = "31";
		} else if (ward.equals("Ward No. 32")) {
			wardNo = "32";
		} else if (ward.equals("Ward No. 34")) {
			wardNo = "34";
		} else if (ward.equals("Ward No. 17")) {
			wardNo = "17";
		} else if (ward.equals("Ward No. 33")) {
			wardNo = "33";
		} else if (ward.equals("Ward No. 35")) {
			wardNo = "35";
		} else if (ward.equals("Ward No. 26")) {
			wardNo = "26";
		} else if (ward.equals("Ward No. 27")) {
			wardNo = "27";
		} else if (ward.equals("Ward No. 28")) {
			wardNo = "28";
		} else if (ward.equals("Ward No. 30")) {
			wardNo = "30";
		} else if (ward.equals("Ward No. 8")) {
			wardNo = "8";
		} else if (ward.equals("Ward No. 18")) {
			wardNo = "18";
		} else if (ward.equals("Ward No. 19")) {
			wardNo = "19";
		} else if (ward.equals("Ward No. 22")) {
			wardNo = "22";
		} else if (ward.equals("Ward No. 5")) {
			wardNo = "5";
		} else if (ward.equals("Ward No. 20")) {
			wardNo = "20";
		} else if (ward.equals("Ward No. 21")) {
			wardNo = "21";
		} else if (ward.equals("Ward No. 4")) {
			wardNo = "4";
		} else if (ward.equals("Ward No. 23")) {
			wardNo = "23";
		} else if (ward.equals("Ward No. 24")) {
			wardNo = "24";
		} else if (ward.equals("Ward No. 25")) {
			wardNo = "25";
		} else if (ward.equals("Ward No. 2")) {
			wardNo = "2";
		} else if (ward.equals("Ward No. 3")) {
			wardNo = "3";
		} else if (ward.equals("Ward No. 6")) {
			wardNo = "6";
		} else if (ward.equals("Ward No. 7")) {
			wardNo = "7";
		} else if (ward.equals("Ward No. 1")) {
			wardNo = "1";
		} else if (ward.equals("Ward No. 9")) {
			wardNo = "9";
		} else if (ward.equals("Ward No. 10")) {
			wardNo = "10";
		} else if (ward.equals("Ward No. 11")) {
			wardNo = "11";
		}

		return wardNo;
	}

	public static String getFilesPath(String filesPath) {
		String result = null;
		if (filesPath != null && filesPath.length() > 0) {
			String[] parts = filesPath.split(",");

			StringBuilder resultBuilder = new StringBuilder();
			for (String part : parts) {
				if (!part.trim().equals("null") && !part.trim().isEmpty()) {
					resultBuilder.append(part.trim()).append(",");
				}
			}

			result = resultBuilder.toString().replaceAll(",$", "");

		}
		return result;
	}

	@RequestMapping("rtsApplication/getPropertyApplicationStatus.do")
	public ModelAndView getPropertyApplicationStatus(HttpServletRequest request, HttpServletResponse response) {
		String ptnStatus = null;
		Map<String, String> requestStatus = null;
		Map<String, String> finalstatus = null;
		double amount = 0;
		boolean amt = false;
		boolean certificate = false;
		boolean service_mutation_Id = false;
		String certificateStatus = null;
		String finalStatus = null;
		List<RTIApplication> rts = new ArrayList<>();
		PropertyTaxTransferRegistration pt = null;
		String appType = null;
		PartitionOfProperty pp = null;
		PropertyTaxMutation pm = null;
		PropertyComplaintRegistration pc = null;
		PropertyAssessmentTrasScript pa = null;
		PropertyTaxExemption pe = null;
		NewlyConstructedProperty pn = null;
		String mutationId = null;
		String certificatePath = null;
		String ptn=null;
		boolean appRejected = false;
		boolean objection = false;
		String objectionStatus = null;
		boolean pmt = false;
		boolean messageStatus = true;
		boolean certificateUploadStatus=false;
		int existingWorkflowStatus = 0;
		int updatedWorkflowStatus = 0;
		int serviceId = 0;
		String url = request.getParameter("url");
		String refId = request.getParameter("id");
		RTIApplication rtiapplication = null;
		String currentPage = request.getParameter("currentPage");
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");
		if (sessionUser != null) {
			try {

				if (request.getParameter("serviceId") != null || request.getParameter("id") != null) {
					log.debug("Servie ID....XXXX"+request.getParameter("serviceId"));
					log.debug("ApplicationREFID....XXXX"+request.getParameter("id"));

					if (request.getParameter("serviceId") != null)
						serviceId = Integer.parseInt(request.getParameter("serviceId"));

					if (serviceId > 0) {
						log.debug("Servie ID found..XX"+serviceId);
						rts = rtiApplicationService.getListByServiceId(serviceId);

					} else if (refId != null) {
						log.debug("REF ID found..XX"+refId);
						rtiapplication = rtiApplicationService.get(Integer.parseInt(refId));

						log.debug("Getting RTS Application based on RefId...XXX"+refId);

						if (rtiapplication != null)
							rts.add(rtiapplication);

						existingWorkflowStatus = rts.get(0).getWorkFlowStatus();
					}

					for (RTIApplication rtiApplication : rts) {
						log.debug("For Loop Enetered...XXX"+rtiApplication.getRtiApplnNumber());
						serviceId = rtiApplication.getRtiserviceid();
						long isApleSarkarApp=rtiapplication.getIsApleSarkarApp();

						requestStatus = PropertyTaxPTNDetailsController
								.getPropertyTaxPaymentStatus(rtiApplication.getRtiApplnNumber());
						log.debug("getting request Status...XXXX"+requestStatus);
						finalstatus = PropertyTaxPTNDetailsController
								.getFinalCertificate(rtiApplication.getRtiApplnNumber());
						log.debug("getting request Final Status...XXXX"+finalstatus);

						objectionStatus = PropertyTaxPTNDetailsController
								.getObjectionStatus(rtiApplication.getRtiApplnNumber());
						log.debug("getting Objection Status...XXXX"+objectionStatus);

						int workflowStatus = rtiApplication.getWorkFlowStatus();
						if ((requestStatus != null && requestStatus.size() > 0)
								&& (finalstatus != null && finalstatus.size() > 0)) {
							
							log.debug("Request,Final,Objection status true....XXXX");

							// L1
							if (requestStatus.get("AMOUNT") != null && !requestStatus.get("AMOUNT").isEmpty())
								amount = Double.parseDouble(requestStatus.get("AMOUNT"));

							ptnStatus = requestStatus.get("STATUS");

							// L2
							certificateStatus = finalstatus.get("CERTIFICATE_STATUS");
							finalStatus = finalstatus.get("FINAL_STATUS");
							ptn= finalstatus.get("PTN");

							switch (serviceId) {

							case 104:
								service_mutation_Id = true;
								break;

							case 53:
								service_mutation_Id = true;
								break;
							}

							if (ptnStatus != null && ptnStatus.length() > 0) {
								switch (ptnStatus) {

								case "PAYMENT PENDING":

									if (workflowStatus != 3 && workflowStatus != 5 && workflowStatus != 1) {
										amt = true;
									}
									break;

								case "PAYMENT COMPLETED":

									if (workflowStatus != 2 && workflowStatus != 1 && workflowStatus != 5) {
										pmt = true;
									}
									break;

								case "REQUEST REJECTED":
									if (workflowStatus != 5) {
										appRejected = true;
									}
									break;

								case "VERIFICATION PENDING":
									break;

								}

							}

							if (finalStatus != null && finalStatus.length() > 0) {
								switch (finalStatus) {
								case "REJECTED BY ASST. COMMISSIONER":
									if (workflowStatus != 5) {
										appRejected = true;
									}

									break;

								}
							}
							if (certificateStatus != null && certificateStatus.length() > 0) {
								switch (certificateStatus) {

								case "CERTIFICATE GENERATED":
									if (workflowStatus != 1 && workflowStatus != 5) {
										certificate = true;
									}
									log.debug("Certificate Generated...XXX"+certificateStatus);

									break;
								}

							}

							if (service_mutation_Id) {

								// Get the Mutation_Id from GetCollectionDetails API call
								if (serviceId == 104) {
									pt = propertyTaxTransferRegistrationService
											.get(rtiApplication.getRtiApplicationRefId());
								} else {
									pp = partitionOfPropertyService.get(rtiApplication.getRtiApplicationRefId());
								}
								if (pt != null) {
									appType = (pt.getUpinNo() != null && pt.getUpinNo().length() > 0) ? "1" : "2";
									if (appType.equals("1")) {
										mutationId = PropertyTaxPTNDetailsController.getMutationId(request, response,
												appType, pt.getUpinNo());
									} else {
										mutationId = PropertyTaxPTNDetailsController.getMutationId(request, response,
												appType, pt.getIndexNo());
									}
									pt.setMutationId(mutationId);
									propertyTaxTransferRegistrationService.savePrpertyTransferRegistrationForm(pt);
								}

								if (pp != null) {
									appType = (pp.getUpinNo() != null && pp.getUpinNo().length() > 0) ? "1" : "2";
									if (appType.equals("1")) {
										mutationId = PropertyTaxPTNDetailsController.getMutationId(request, response,
												appType, pp.getUpinNo());
									} else {
										mutationId = PropertyTaxPTNDetailsController.getMutationId(request, response,
												appType, pp.getIndexNo());
									}
									pp.setMutationId(mutationId);
									partitionOfPropertyService.savePartitionOfPropertyForm(pp);
								}

							}
							if (amt) {
								if (amount > 0) {
									rtiApplication.setApplicationCost(amount);
								}
								rtiApplication.setWorkFlowStatus(3);
								if(isApleSarkarApp==1) {
									String distric="NA";
									String trackid=rtiApplication.getAaple_user_track_id();
									String userid=rtiApplication.getAaple_user_id();
									String mobile=rtiApplication.getAapleSarkarUserMobileNo();
									String name=rtiApplication.getApplicantName();
									double apleamount = rtiApplication.getApplicationCost();
									String str="NA";
									
									String retrurnurl="";
									String appId=rtiApplication.getRtiApplnNumber();	
									appId = appId.replace("/", "");

									String paymentStatus="N";						
									String paymentDate="NA";
									String digitalSignStatus="N";
									String digitalSignDate="NA";
									int estServiceDays=7;
									String estServiceDate="NA";

									int reqFlag=0;
									int appStatus=2;
									String remark="NA";						
									String apleserviceId= rtiApplication.getAaple_service_id();
									String mobileApla=rtiApplication.getMobileNumber();
									//retunRti.setAaple_application_id(appId);
								String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,apleserviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
											 digitalSignStatus,digitalSignDate,estServiceDays, 
											 estServiceDate,apleamount,reqFlag,appStatus,remark,distric,mobileApla); 
									}
								rtiApplication = rtiApplicationService.merge(rtiApplication);
								if(rtiApplication.getApplicantName()!=null && (rtiApplication.getPhoneNumber()!=null || rtiApplication.getMobileNumber()!=null) && rtiApplication.getRtiApplnNumber()!=null &&  rtiApplication.getEmail()!=null) {
								SendSMSEmailController.sendPaymentOfPropertyTax(
										rtiApplication.getApplicantName(), rtiApplication.getPhoneNumber(),
										rtiApplication.getRtiApplnNumber(), rtiApplication.getEmail());

								}
							}

							if (pmt) {
								if (amount > 0) {
									rtiApplication.setApplicationCost(amount);
								}
								rtiApplication.setWorkFlowStatus(2);
								if(isApleSarkarApp==1) {
									String distric="NA";
									String trackid=rtiApplication.getAaple_user_track_id();
									String userid=rtiApplication.getAaple_user_id();
									String mobile=rtiApplication.getAapleSarkarUserMobileNo();
									String name=rtiApplication.getApplicantName();
									double apleamount = rtiApplication.getApplicationCost();
									String str="NA";
									
									String retrurnurl="";
									String appId=rtiApplication.getRtiApplnNumber();	
									appId = appId.replace("/", "");

									String paymentStatus="Y";						
									String paymentDate="NA";
									String digitalSignStatus="N";
									String digitalSignDate="NA";
									int estServiceDays=7;
									String estServiceDate="NA";

									int reqFlag=0;
									int appStatus=3;
									String remark="NA";						
									String apleserviceId= rtiApplication.getAaple_service_id();
									String mobileApla=rtiApplication.getMobileNumber();
									//retunRti.setAaple_application_id(appId);
								String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,apleserviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
											 digitalSignStatus,digitalSignDate,estServiceDays, 
											 estServiceDate,apleamount,reqFlag,appStatus,remark,distric,mobileApla); 
									}
								rtiApplication = rtiApplicationService.merge(rtiApplication);

							}
							if (certificate) {
								// Certificate API call

								// Mutation Certificate
								if (serviceId == 104) {
									pt = propertyTaxTransferRegistrationService
											.get(rtiApplication.getRtiApplicationRefId());
									certificatePath = getMutationCertificate(pt.getMutationId(),
											pt.getAssessmentDetailsId(), pt.getRti_ref_id());

								} else if (serviceId == 53) {
									pp = partitionOfPropertyService.get(rtiApplication.getRtiApplicationRefId());
									certificatePath = getMutationCertificate(pp.getMutationId(),
											pp.getAssessmentDetailsId(), pp.getRti_ref_id());

								}

								// View Demand
								if (serviceId == 103) {
									pm = propertyTaxMutationService.get(rtiApplication.getRtiApplicationRefId());
									pm.setUpinNo(ptn);
									pm=propertyTaxMutationService.merge(pm);
									appType = (pm.getUpinNo() != null && pm.getUpinNo().length() > 0) ? "1" : "2";
									if (appType.equals("1")) {
										certificatePath = getViewDemand(pm.getUpinNo(), appType, pm.getRti_ref_id());
									} else {
										certificatePath = getViewDemand(pm.getIndexNo(), appType, pm.getRti_ref_id());
									}

								} else if (serviceId == 67) {
									pc = propertyTaxComplaintService.get(rtiApplication.getRtiApplicationRefId());
									appType = (pc.getUpinNo() != null && pc.getUpinNo().length() > 0) ? "1" : "2";
									if (appType.equals("1")) {
										certificatePath = getViewDemand(pc.getUpinNo(), appType, pc.getRti_ref_id());
									} else {
										certificatePath = getViewDemand(pc.getIndexNo(), appType, pc.getRti_ref_id());
									}
								}

								// Special Notice 15/2
								if (serviceId == 58) {
									pa = propertyAssessmentService.get(rtiApplication.getRtiApplicationRefId());
									certificatePath = getSpecialNotice(pa.getUpinNo(), pa.getPropertyId(),
											pa.getRti_ref_id());

								} else if (serviceId == 71) {

									pe = taxExemptionNonResidentialService.get(rtiApplication.getRtiApplicationRefId());
									certificatePath = getSpecialNotice(pe.getUpinNo(), pe.getPropertyId(),
											pe.getRti_ref_id());

								} else if (serviceId == 56) {
									pn = newlyConstructedPropertyService.get(rtiApplication.getRtiApplicationRefId());
									certificatePath = getSpecialNotice(pn.getUpinNo(), pn.getPropertyId(),
											pn.getRti_ref_id());
								}

								if (certificatePath != null && !certificatePath.isEmpty()) {
									rtiApplication.setWorkFlowStatus(1);
									if(isApleSarkarApp==1) {
										String distric="NA";
										String trackid=rtiApplication.getAaple_user_track_id();
										String userid=rtiApplication.getAaple_user_id();
										String mobile=rtiApplication.getAapleSarkarUserMobileNo();
										String name=rtiApplication.getApplicantName();
										double apleamount = rtiApplication.getApplicationCost();
										String str="NA";
										
										String retrurnurl="";
										String appId=rtiApplication.getRtiApplnNumber();	
										appId = appId.replace("/", "");

										String paymentStatus="Y";						
										String paymentDate="NA";
										String digitalSignStatus="N";
										String digitalSignDate="NA";
										int estServiceDays=7;
										String estServiceDate="NA";

										int reqFlag=0;
										int appStatus=4;
										String remark="NA";						
										String apleserviceId= rtiApplication.getAaple_service_id();
										String mobileApla=rtiApplication.getMobileNumber();
										//retunRti.setAaple_application_id(appId);
									String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,apleserviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
												 digitalSignStatus,digitalSignDate,estServiceDays, 
												 estServiceDate,apleamount,reqFlag,appStatus,remark,distric,mobileApla); 
										}
									if (amount > 0) {
										rtiApplication.setApplicationCost(amount);
									}
									
									rtiApplication.setPdfFilesSavedPath(certificatePath);
									rtiApplication = rtiApplicationService.merge(rtiApplication);

									if (rtiApplication != null) {

										SendSMSEmailController.sendApplicationCompleted(
												rtiApplication.getApplicantName(), rtiApplication.getPhoneNumber(),
												rtiApplication.getRtiApplnNumber(), rtiApplication.getEmail());

									}
									request.getSession().setAttribute("message", "The application "
											+ rtiApplication.getRtiApplnNumber()
											+ " has been successfully updated.");
									certificateUploadStatus=true;
									messageStatus = false;
								} else {
									certificateUploadStatus=true;
									messageStatus = false;
//									request.getSession().setAttribute("errMessage",
//											"Please connect the Digital Signature Certificate (DSC) dongle to complete the application "
//													+ rtiapplication.getRtiApplnNumber() + " update process.");
									request.getSession().setAttribute("errMessage", "No updates available for the application "
											+ rtiapplication.getRtiApplnNumber() + " !!");

								}
							}

							if (appRejected) {
								if (amount > 0) {
									rtiApplication.setApplicationCost(amount);
								}
								rtiApplication.setWorkFlowStatus(5);
								if(isApleSarkarApp==1) {
									String distric="NA";
									String trackid=rtiApplication.getAaple_user_track_id();
									String userid=rtiApplication.getAaple_user_id();
									String mobile=rtiApplication.getAapleSarkarUserMobileNo();
									String name=rtiApplication.getApplicantName();
									double apleamount = rtiApplication.getApplicationCost();
									String str="NA";
									
									String retrurnurl="";
									String appId=rtiApplication.getRtiApplnNumber();	
									appId = appId.replace("/", "");

									String paymentStatus="N";						
									String paymentDate="NA";
									String digitalSignStatus="N";
									String digitalSignDate="NA";
									int estServiceDays=7;
									String estServiceDate="NA";

									int reqFlag=0;
									int appStatus=5;
									String remark="NA";						
									String apleserviceId= rtiApplication.getAaple_service_id();
									String mobileApla=rtiApplication.getMobileNumber();
									//retunRti.setAaple_application_id(appId);
								String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,apleserviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
											 digitalSignStatus,digitalSignDate,estServiceDays, 
											 estServiceDate,apleamount,reqFlag,appStatus,remark,distric,mobileApla); 
									}
								rtiApplication = rtiApplicationService.merge(rtiApplication);
								if (rtiApplication != null) {
									SendSMSEmailController.sendApplicationRejected(rtiApplication.getApplicantName(),
											rtiApplication.getPhoneNumber(), rtiApplication.getRtiApplnNumber(),
											rtiApplication.getEmail());

								}else {
									log.debug("SMS not sent due to invalid fullname or phone number or rtiapplicationNumber or email");
								}

							}

						} else if (objectionStatus != null && objectionStatus.length() > 0) {
							log.debug("Objection true....XXXX");

							// Calling Objection API
							if (objectionStatus != null && objectionStatus.length() > 0) {
								switch (objectionStatus) {

								case "APPROVED BY CT-TAX-ADMIN":
									objection = true;
									break;
								}
							}
							if (objection) {
								pc = propertyTaxComplaintService.get(rtiApplication.getRtiApplicationRefId());
								appType = (pc.getUpinNo() != null && pc.getUpinNo().length() > 0) ? "1" : "2";
								if (appType.equals("1")) {
									certificatePath = getViewDemand(pc.getUpinNo(), appType, pc.getRti_ref_id());
								} else {
									certificatePath = getViewDemand(pm.getIndexNo(), appType, pc.getRti_ref_id());
								}
								
								if (certificatePath != null && !certificatePath.isEmpty()) {
									rtiApplication.setWorkFlowStatus(1);
									if(isApleSarkarApp==1) {
										String distric="NA";
										String trackid=rtiApplication.getAaple_user_track_id();
										String userid=rtiApplication.getAaple_user_id();
										String mobile=rtiApplication.getAapleSarkarUserMobileNo();
										String name=rtiApplication.getApplicantName();
										double apleamount = rtiApplication.getApplicationCost();
										String str="NA";
										
										String retrurnurl="";
										String appId=rtiApplication.getRtiApplnNumber();	
										appId = appId.replace("/", "");

										String paymentStatus="Y";						
										String paymentDate="NA";
										String digitalSignStatus="N";
										String digitalSignDate="NA";
										int estServiceDays=7;
										String estServiceDate="NA";

										int reqFlag=0;
										int appStatus=5;
										String remark="NA";						
										String apleserviceId= rtiApplication.getAaple_service_id();
										String mobileApla=rtiApplication.getMobileNumber();
										//retunRti.setAaple_application_id(appId);
									String pushBackrespose = aapleSarkarPortalIntegrationNagpur.redirectPushApi(distric,trackid,userid,mobile,name, str,apleserviceId,  appId,  retrurnurl, paymentStatus, paymentDate,
												 digitalSignStatus,digitalSignDate,estServiceDays, 
												 estServiceDate,apleamount,reqFlag,appStatus,remark,distric,mobileApla); 
										}
									if (amount > 0) {
										rtiApplication.setApplicationCost(amount);
									}
									rtiApplication.setPdfFilesSavedPath(certificatePath);
									rtiApplication = rtiApplicationService.merge(rtiApplication);

									if (rtiApplication != null) {

										SendSMSEmailController.sendApplicationCompleted(
												rtiApplication.getApplicantName(), rtiApplication.getPhoneNumber(),
												rtiApplication.getRtiApplnNumber(), rtiApplication.getEmail());

									}
//									request.getSession().setAttribute("message", "The application "
//											+ rtiApplication.getRtiApplnNumber()
//											+ " has been successfully updated, and the certificate has been uploaded.");
									request.getSession().setAttribute("message", "The application "
											+ rtiApplication.getRtiApplnNumber()
											+ " has been successfully updated.");
									
									certificateUploadStatus=true;
									messageStatus = false;
								} else {
									certificateUploadStatus=true;
									messageStatus = false;
//									request.getSession().setAttribute("errMessage",
//											"Please connect the Digital Signature Certificate (DSC) dongle to complete the application "
//													+ rtiapplication.getRtiApplnNumber() + " update process.");
//									request.getSession().setAttribute("errMessage",
//										    "Please connect the Digital Signature Certificate (DSC) dongle to complete the application "
//										    + rtiapplication.getRtiApplnNumber() + " update process. Or the file status has been generated, but it has not been uploaded."
//										);
									request.getSession().setAttribute("errMessage", "No updates available for the application "
											+ rtiapplication.getRtiApplnNumber() + " !!");
									
								}
							}
						} else {
							log.debug("RTS Application Not found for Update....XXXX");
							messageStatus = false;
							request.getSession().setAttribute("errMessage",
									"Application " + rtiapplication.getRtiApplnNumber() + " not found for update.");
						}

						updatedWorkflowStatus = rtiApplication.getWorkFlowStatus();
					}

					if (existingWorkflowStatus == updatedWorkflowStatus && messageStatus &&!certificateUploadStatus) {
						request.getSession().setAttribute("errMessage", "No updates available for the application "
								+ rtiapplication.getRtiApplnNumber() + " !!");

					} else if (messageStatus) {
						request.getSession().setAttribute("message", "The application "
								+ rtiapplication.getRtiApplnNumber() + " has been successfully updated.");

					}

				} else {
					request.getSession().setAttribute("errMessage",
							"The application " + rts.get(0).getRtiApplnNumber() + " update failed. Please try again.");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				log.error(ex.getMessage());
			}
			request.getSession().setAttribute("servicetaxId", serviceId);
			request.getSession().setAttribute("currentPage", currentPage);
			return new ModelAndView("redirect:" + url);
		} else {
			return new ModelAndView("redirect:/login.do");
		}

	}

	private static String getObjectionStatus(String rtsNo) {
		String resultValue = null;
//        String url = "https://nmctax.cybertech.com/GeocivicServices/CitizentaxService/CitizentaxService/AgentCollectionService.svc/GetRTSRequestStatus";
		String url = CoreConstants.TAX_REQUEST_STATUS;
    	log.debug("Objection Status URL...XXX:"+url);
		String token = PropertyTaxTokenGeneration.propertyTaxToken();
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

		String jsonRequestBody = "{ \"REQUEST_NUMBER\": \"" + rtsNo + "\", \"token\": \"" + token + "\" }";
    	log.debug("Objection Status RequestJson...XXX:"+jsonRequestBody);
		HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
				String.class);
    	log.debug("Objection Status Response...XXX:"+responseEntity);

		HttpStatus statusCode = responseEntity.getStatusCode();
    	log.debug("Objection Status Response Code...XXX:"+statusCode);
		System.out.println("HTTP Status Code: " + statusCode);
		if (statusCode == HttpStatus.OK) {
			String responseBody = responseEntity.getBody();
	    	log.debug("Objection Status Response...XXX:"+responseBody);
			System.out.println("Response Body: " + responseBody);
			ObjectMapper objectMapper = new ObjectMapper();
			try {

				JsonNode jsonNode = objectMapper.readTree(responseBody);
		    	log.debug("Objection Status Response Body...XXX:"+jsonNode);
				JsonNode resultNode = jsonNode.get("GetRTSRequestStatusResult").get("ResultList");
		    	log.debug("Objection Status GetRTSRequestStatusResult...XXX:"+resultNode);
				String amount = resultNode.get(0).get("AMOUNT").asText();
				resultValue = resultNode.get(0).get("STATUS").asText();
		    	log.debug("Objection Status Status...XXX:"+resultValue);

				System.out.println("Result: " + resultValue);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return resultValue;

	}

	public static Map<String, String> getPropertyTaxPaymentStatus(String rtsNo) {

		Map<String, String> map = new HashMap<>();
		String resultValue = null;
		// String url =
		//String url = "https://nmctax.cybertech.com/GeocivicServices/CitizentaxService/CitizentaxService/AgentCollectionService.svc/GetRTSPaymentStatus";
		String url = CoreConstants.TAX_PAYMENT_STATUS;
		log.debug("Payment Status :"+url);
		String token = PropertyTaxTokenGeneration.propertyTaxToken();
		log.debug("Getting token :"+token);
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

		String jsonRequestBody = "{ \"REQUEST_NUMBER\": \"" + rtsNo + "\", \"token\": \"" + token + "\" }";
    	log.debug("Payment Status JsonBody...XXX:"+resultValue);
		HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
				String.class);
    	log.debug("Payment Status Response...XXX:"+responseEntity);

		HttpStatus statusCode = responseEntity.getStatusCode();
    	log.debug("Payment Status Response Code...XXX:"+statusCode);

		System.out.println("HTTP Status Code: " + statusCode);
		if (statusCode == HttpStatus.OK) {
			String responseBody = responseEntity.getBody();
			System.out.println("Response Body: " + responseBody);
			ObjectMapper objectMapper = new ObjectMapper();
			try {

				JsonNode jsonNode = objectMapper.readTree(responseBody);
		    	log.debug("Payment Status ResponseBody...XXX:"+jsonNode);
				JsonNode resultNode = jsonNode.get("GetRTSPaymentStatusResult").get("ResultList");
		    	log.debug("Payment Status GetRTSPaymentStatusResult...XXX:"+resultNode);
				String amount = resultNode.get(0).get("AMOUNT").asText();
		    	log.debug("Payment Status GetRTSPaymentStatusResult---Amount...XXX:"+amount);
				String status = resultNode.get(0).get("STATUS").asText();
		    	log.debug("Payment Status GetRTSPaymentStatusResult---status...XXX:"+status);
				map.put("STATUS", status);
				map.put("AMOUNT", amount);

				System.out.println("Result: " + resultValue);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return map;

	}

	public static Map<String, String> getFinalCertificate(String rtsNo) {
		String resultValue = null;
		String finalstatus = null;
		Map<String, String> map = new HashMap<>();
       String ptn=null;
		try {

			//String url = "https://nmctax.cybertech.com/GeocivicServices/CitizentaxService/CitizentaxService/AgentCollectionService.svc/GetRTSFinalRequestStatus";
			String url = CoreConstants.TAX_FINAL_STATUS;
	    	log.debug("Final Status URL...XXX:"+url);
			String token = PropertyTaxTokenGeneration.propertyTaxToken();
			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);

			String jsonRequestBody = "{ \"REQUEST_NUMBER\": \"" + rtsNo + "\", \"token\": \"" + token + "\" }";
	    	log.debug("Final Status JSONBody...XXX:"+jsonRequestBody);

			HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
					String.class);
	    	log.debug("Final Status Response...XXX:"+responseEntity);


			HttpStatus statusCode = responseEntity.getStatusCode();
			System.out.println("HTTP Status Code: " + statusCode);
			if (statusCode == HttpStatus.OK) {
				String responseBody = responseEntity.getBody();
				System.out.println("Response Body: " + responseBody);
				ObjectMapper objectMapper = new ObjectMapper();

				JsonNode jsonNode = objectMapper.readTree(responseBody);
				String responseCode = jsonNode.get("GetRTSFinalRequestStatusResult").get("ResponseCode").asText();
		    	log.debug("Final Status Response Code...XXX:"+responseCode);
				if (responseCode.equals("GCPT10100")) {
					JsonNode resultNode = jsonNode.get("GetRTSFinalRequestStatusResult").get("ResultList");
			    	log.debug("Final Status GetRTSFinalRequestStatusResult...XXX:"+resultNode);
					resultValue = resultNode.get(0).get("FINAL_REQUEST_STATUS").asText();
			    	log.debug("Final Status FINAL_REQUEST_STATUS...XXX:"+resultValue);
					finalstatus = resultNode.get(0).get("STATUS").asText();
			    	log.debug("Final Status STATUS...XXX:"+finalstatus);
                    ptn = resultNode.get(0).get("PTN").asText();
			    	log.debug("Final Status PTN...XXX:"+ptn);
					map.put("FINAL_STATUS", finalstatus);
					map.put("CERTIFICATE_STATUS", resultValue);
					map.put("PTN", ptn);
				}
				System.out.println("Result: " + resultValue);
			}
		} catch (Exception ex) {
			ex.getMessage();
			ex.printStackTrace();
		}

		return map;
	}

	@RequestMapping("/rtsapplication/getPropertyCollectionDetails.do")
	public void getPropertyCollectionDetails(HttpServletRequest request, HttpServletResponse response) {

		if (log.isDebugEnabled()) {
			log.debug("Invoking getPropertyDetails get API");
		}
		String isOldPTN = "";
		// String url =
		//String url = "https://nmctax.cybertech.com/GeoCivicServices/Collection/DepartmentCollection/CollectionService.svc/GetRTSPropertyCollectionDetail";
		String url=CoreConstants.TAX_COLLECTION_DETAIL;
		try {
			RestTemplate restTemplate = new RestTemplate();
			JSONObject json = new JSONObject();
			PrintWriter pw = response.getWriter();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			String ptn = request.getParameter("ptnNo");
			String token = PropertyTaxTokenGeneration.propertyTaxToken();
			String apptype = request.getParameter("apptype");
			if (apptype.equals("2")) {
				isOldPTN = "true";
			} else {
				isOldPTN = "false";
			}
			String jsonRequestBody = "{\"input\":{\"PTN\":\"" + ptn + "\",\"IsOldPTN\":\"" + isOldPTN
					+ "\",\"SearchText\":\"Search\",\"ClientId\":\"3\"},\"token\":\"" + token + "\"}";

			HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

			ResponseEntity<GetRTSPropertyCollectionDetail> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
					requestEntity, GetRTSPropertyCollectionDetail.class);

			GetRTSPropertyCollectionDetail tokenResponse = responseEntity.getBody();
			ObjectMapper mp = new ObjectMapper();
			String a = mp.writeValueAsString(tokenResponse);
			HttpStatus statusCode = responseEntity.getStatusCode();

			if (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult() != null) {
				String address = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getAddress() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getAddress().isEmpty())
								? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getAddress()
								: "0";
				String areaspaymentstatus = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getArrearsPaymentStatus() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
								.getArrearsPaymentStatus().isEmpty())
										? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
												.getArrearsPaymentStatus()
										: "0";
				String arreaspending = tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getArrearsPending();
				long blockNo = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getBlockNo());
				long propertyId = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getPropertyId());
				long penalityAmount = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getPenalityAmount());
				
				long rebateAmount = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getRebateAmount());

				String blockname = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getBlockName() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getBlockName()
								.isEmpty())
										? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
												.getBlockName()
										: "0";
				String indexNo = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getIndexNumber() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getIndexNumber()
								.isEmpty())
										? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
												.getIndexNumber()
										: "";
				String occupierName = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getOccupierName() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getOccupierName()
								.isEmpty())
										? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
												.getOccupierName()
										: "";
				String ownerName = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getOwnerName() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getOwnerName()
								.isEmpty())
										? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
												.getOwnerName()
										: "";
				String pincode = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getPincode() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getPincode().isEmpty())
								? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getPincode()
								: "";
				ptn = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getPtn() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getPtn().isEmpty())
								? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getPtn()
								: "0";

				String zoneName = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getZoneName() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getZoneName().isEmpty())
								? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getZoneName()
								: "0";
				String zoneNo = getZoneName((tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getZoneNo() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getZoneNo().isEmpty())
								? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getZoneNo()
								: "0");
				String mobileNo = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getMobileNo() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getMobileNo().isEmpty())
								? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getMobileNo()
								: "0";
				String wardNo = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getWardNo() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getWardNo().isEmpty())
								? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getWardNo()
								: "0";
				String house_no = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getHouseNo() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getHouseNo().isEmpty())
								? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getHouseNo()
								: "0";
				String assessmentDetailsId = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
						.getAssessmentDetailsId() != null
						&& !tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getAssessmentDetailsId()
								.isEmpty())
										? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult()
												.getAssessmentDetailsId()
										: "0";

				double duesAmount = tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getDuesAmount();

				json.put("address", address);
				json.put("areaspaymentstatus", areaspaymentstatus);
				json.put("arreaspending", arreaspending);
				json.put("blockNo", blockNo);
				json.put("wardNo", wardNo);
				json.put("blockname", blockname);
				json.put("indexNo", indexNo);
				json.put("occupierName", occupierName);
				json.put("ownerName", ownerName);
				json.put("pincode", pincode);
				json.put("ptn", ptn);
				// json.put("totalDemand", totalDemand);
				json.put("zoneName", zoneName);
				json.put("zoneNo", zoneNo);
				json.put("mobileNo", mobileNo);
				json.put("zone", zoneNo);
				json.put("status", true);
				json.put("houseNo", house_no);
				json.put("DueAmount", duesAmount);
				json.put("assessmentDetailsId", assessmentDetailsId);
				json.put("propertyId", propertyId);
				json.put("penalityAmount", penalityAmount);
				json.put("rebateAmount", rebateAmount);


				if (log.isDebugEnabled()) {
					log.debug("Invoking propertyMutationToken = " + token);
					log.debug(statusCode);
					log.debug(responseEntity.getBody());
					log.debug(address + " " + areaspaymentstatus + " " + arreaspending + " " + blockname + " " + indexNo
							+ " " + occupierName + " " + ownerName + " " + pincode + " " + ptn + " " + duesAmount + " "
							+ zoneName + " " + zoneNo);

				}

			} else {
				json.put("status", false);

			}

			PrintWriter printwriter = response.getWriter();
			printwriter.print(json.toString());
			printwriter.close();
			printwriter.flush();

		} catch (Exception ex) {
			log.error(ex.getMessage().toString());
			ex.printStackTrace();
		}

	}

	// Get Mutation Id
	public static String getMutationId(HttpServletRequest request, HttpServletResponse response, String appType,
			String ptn) {

		if (log.isDebugEnabled()) {
			log.debug("Invoking getPropertyDetails get API");
		}
		long mutationId = 0;
		String isOldPTN = "";
		// String url =
		//String url = "https://nmctax.cybertech.com/GeoCivicServices/Collection/DepartmentCollection/CollectionService.svc/GetRTSPropertyCollectionDetail";
		String url =CoreConstants.TAX_COLLECTION_DETAIL;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			String token = PropertyTaxTokenGeneration.propertyTaxToken();
			if (appType.equals("2")) {
				isOldPTN = "true";
			} else {
				isOldPTN = "false";
			}
			String jsonRequestBody = "{\"input\":{\"PTN\":\"" + ptn + "\",\"IsOldPTN\":\"" + isOldPTN
					+ "\",\"SearchText\":\"Search\",\"ClientId\":\"3\"},\"token\":\"" + token + "\"}";

			HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

			ResponseEntity<GetRTSPropertyCollectionDetail> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
					requestEntity, GetRTSPropertyCollectionDetail.class);

			GetRTSPropertyCollectionDetail tokenResponse = responseEntity.getBody();
			ObjectMapper mp = new ObjectMapper();
			String a = mp.writeValueAsString(tokenResponse);

			if (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult() != null) {

				mutationId = (tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getMutationId() > 0)
						? tokenResponse.getGetRTSPropertyCollectionDetailResult().getResult().getMutationId()
						: 0;
			}

		} catch (Exception ex) {
			log.error(ex.getMessage().toString());
			ex.printStackTrace();
		}
		return String.valueOf(mutationId);

	}

	// Special Notice API
	private String getSpecialNotice(String upinNo, String propertyId, long reirefId) {

		if (log.isDebugEnabled()) {
			log.debug("Invoking getPropertyDetails get API");
		}
		String dscType = "3";
		String dscresult = null;
		String dscOp = null;
		String specialNotice = null;

		String result = null;
		//String url = "https://nmctax.cybertech.com/GeoCivic/AssessmentReport/AssessmentReport/GenerateReport";
		String url =CoreConstants.TAX_REPORT_API;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			String token = PropertyTaxTokenGeneration.propertyTaxToken();

			String jsonRequestBody = "{" + "\"token\": \"" + token + "\", " + "\"clientId\": 3, " + "\"rptInpt\": {"
					+ "\"ReportKey\": \"SpecialNotice\", " + "\"ReportParameter\": {" + "\"PTN\": \"" + upinNo + "\", "
					+ "\"PropertyId\": \"" + propertyId + "\", " + "\"LeaseNumber\": null" + "}" + "}" + "}";
			HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

			ResponseEntity<TokenResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
					TokenResponse.class);

			TokenResponse tokenResponse = responseEntity.getBody();
			result = tokenResponse.getResult();

			/*
			 * // PropertyTaxDSC--Code if (result != null && result.length() > 0) {
			 * dscresult = dscrestcontroller.getPropertyTaxDSC(result, dscType);
			 * 
			 * if (dscresult != null) { dscOp = dscrestcontroller.applyTaxDSC(dscresult);
			 * 
			 * if (dscOp != null) { specialNotice = saveFile(dscOp, servletContext,
			 * reirefId); } } }
			 */

			return result;

			// End

		} catch (Exception ex) {
			log.error(ex.getMessage().toString());
			ex.printStackTrace();
		}
		return null;

	}

	// View Demand
	private String getViewDemand(String upinNo, String appType, long reirefId) {
		String result = null;
		//String url = "https://nmctax.cybertech.com/GeoCivic/AssessmentReport/AssessmentReport/GenerateReport";
		String url =CoreConstants.TAX_REPORT_API;
		HttpHeaders headers = new HttpHeaders();
		String isOldPTN = "";
		String dscType = "2";
		String dscresult = null;
		String dscOp = null;
		String viewDemand = null;
		try {
			if (appType.equals("2")) {
				isOldPTN = "true";
			} else {
				isOldPTN = "false";
			}
			PropertyTaxDemandToken propertyTax = new PropertyTaxDemandToken();
			propertyTax.setClientId(3);

			PropertyTaxDemandToken.RptInput rptInpt = new PropertyTaxDemandToken.RptInput();
			rptInpt.setReportKey("BillReceipt");

			PropertyTaxDemandToken.RptInput.ReportParameter reportParameter = new PropertyTaxDemandToken.RptInput.ReportParameter();
			reportParameter.setPtn(upinNo);
			reportParameter.setIsOldPin(isOldPTN);
			reportParameter.setClientId(3);
			rptInpt.setReportParameter(reportParameter);
			propertyTax.setRptInpt(rptInpt);

			String token = PropertyTaxTokenGeneration.propertyTaxToken();
			propertyTax.setToken(token);

			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonRequestBody = objectMapper.writeValueAsString(propertyTax);

			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

			ResponseEntity<TokenResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
					TokenResponse.class);

			TokenResponse tokenResponse = responseEntity.getBody();
			result = tokenResponse.getResult();

			/*
			 * // PropertyTaxDSC--Code if (result != null && result.length() > 0) {
			 * dscresult = dscrestcontroller.getPropertyTaxDSC(result, dscType);
			 * 
			 * if (dscresult != null) { dscOp = dscrestcontroller.applyTaxDSC(dscresult);
			 * 
			 * if (dscOp != null) { viewDemand = saveFile(dscOp, servletContext, reirefId);
			 * } } }
			 */

			return result;

			// End

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	// Mutation Certificate
	private  String getMutationCertificate(String mutationId, String assessmentDetailsId, long reirefId) {
		if (log.isDebugEnabled()) {
			log.debug("Invoking getPropertyDetails get API");
		}
		String result = null;
		//String url = "https://nmctax.cybertech.com/GeoCivic/AssessmentReport/AssessmentReport/GenerateReport";
		String url =CoreConstants.TAX_REPORT_API;
		String dscType="1";
		String dscresult=null;
		String dscOp=null;
		String mutationCertificate=null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			String token = PropertyTaxTokenGeneration.propertyTaxToken();

			String jsonRequestBody = "{" + "\"token\": \"" + token + "\", " + "\"clientId\": 3, " + "\"rptInpt\": {"
					+ "\"ReportKey\": \"MutationCertificateReport\", " + "\"ReportParameter\": {"
					+ "\"AssessmentMutationId\": \"" + mutationId + "\", " + "\"AssessmentDetailId\": \""
					+ assessmentDetailsId + "\"" + "}" + "}" + "}";

			HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

			ResponseEntity<TokenResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
					TokenResponse.class);

			TokenResponse tokenResponse = responseEntity.getBody();
			result = tokenResponse.getResult();
			
			/*
			 * // PropertyTaxDSC--Code if (result != null && result.length() > 0) {
			 * dscresult = dscrestcontroller.getPropertyTaxDSC(result, dscType);
			 * 
			 * if (dscresult != null) { dscOp = dscrestcontroller.applyTaxDSC(dscresult);
			 * 
			 * if (dscOp != null) { mutationCertificate = saveFile(dscOp, servletContext,
			 * reirefId); } } }
			 */

			return result;

			//End

		} catch (Exception ex) {
			log.error(ex.getMessage().toString());
			ex.printStackTrace();
		}
		return null;

	}
	
	
	public String saveFile(String responseData1, ServletContext servletContext, long rtiapplrefid) throws IOException {
		RTIApplication rtiApplication = null;

		try {

			rtiApplication = rtiApplicationService.get(rtiapplrefid);
			String dataStartTag1 = "<data>";
			String dataEndTag1 = "</data>";

			String updatedResponseBody = "";
			int startIndex1 = responseData1.indexOf(dataStartTag1) + dataStartTag1.length();
			int endIndex1 = responseData1.indexOf(dataEndTag1, startIndex1);
			if (responseData1.startsWith("<![CDATA[", startIndex1)) {
				int cdataStartIndex = startIndex1 + "<![CDATA[".length();
				int cdataEndIndex = responseData1.indexOf("]]>", cdataStartIndex);
				updatedResponseBody = responseData1.substring(cdataStartIndex, cdataEndIndex);
			} else {
				updatedResponseBody = responseData1.substring(startIndex1, endIndex1);
			}

			System.out.println("Updated Response Body: " + updatedResponseBody);
			String filesPath = null;
			StringBuilder filesPathBuilder = new StringBuilder();
			String baseDir = servletContext.getRealPath("") + File.separator + "propertyTax";
			File file = new File(baseDir);
			if (!file.exists()) {
				file.mkdirs();
			}
			if (updatedResponseBody != null) {

				byte[] pdfBytes = Base64.getDecoder().decode(updatedResponseBody);
				String fileName;
				String uniqueFileName = UUID.randomUUID().toString().substring(0, 8) + ".pdf";
				int l = uniqueFileName.lastIndexOf(".");
				String imageext = uniqueFileName.substring(l, uniqueFileName.length());
				fileName = uniqueFileName.substring(0, l);
				fileName = fileName.replaceAll("[^a-zA-Z0-9]", "");
				fileName = fileName.replaceAll("\\W", "");
				fileName = fileName + "" + imageext;
				File storeFile = new File(baseDir, fileName);
				try (FileOutputStream outputStream = new FileOutputStream(storeFile)) {
					outputStream.write(pdfBytes);
					outputStream.flush();
					outputStream.close();

				}

				String url = "https" + "://" + // "http" + "://
						request.getServerName() + request.getRequestURI() + // "/people"
						"?" + // "?"
						request.getQueryString();
				String[] url1 = url.split("/rtsApplication");
				filesPath = url1[0] + "/propertyTax/" + fileName;
				filesPathBuilder.append(filesPath);
				rtiApplication = rtiApplicationService.get(rtiapplrefid);
				rtiApplication.setPdfFilesSavedPath(filesPath);
				rtiApplication.setWorkFlowStatus(1);
				rtiApplication = rtiApplicationService.merge(rtiApplication);
				request.setAttribute("rtiApplication", rtiApplication);

				SendSMSEmailController.sendApplicationCompleted(rtiApplication.getApplicantName(),
						rtiApplication.getPhoneNumber(), rtiApplication.getRtiApplnNumber(), rtiApplication.getEmail());

			}

		} catch (Exception ex) {
		
			ex.getMessage();
			ex.printStackTrace();
		}
		return rtiApplication.getPdfFilesSavedPath();

	
	}
	
	




	// DSC Mutation Certificate
	@RequestMapping("/rtsApplication/getTaxDSC.do")
	private ModelAndView getTaxDSC(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (log.isDebugEnabled()) {
			log.debug("Invoking getPropertyDetails get API");
		}
		String appType = null;
		PartitionOfProperty pp = null;
		PropertyTaxMutation pm = null;
		PropertyComplaintRegistration pc = null;
		PropertyAssessmentTrasScript pa = null;
		PropertyTaxExemption pe = null;
		NewlyConstructedProperty pn = null;
		JSONObject json = new JSONObject();
		PrintWriter pw = response.getWriter();
		PropertyTaxTransferRegistration pt = null;
		String certificatePath = null;
		String dscresult = null;
		String dscType = null;
		try {
			if (request.getParameter("serviceId") != null && request.getParameter("refId") != null) {
				int serviceId = Integer.parseInt(request.getParameter("serviceId"));
				int refId = Integer.parseInt(request.getParameter("refId"));

				RTIApplication rtiApplication  = rtiApplicationService.get(refId);
				
				// mutation
				if (serviceId == 104) {
					pt = propertyTaxTransferRegistrationService.get(rtiApplication.getRtiApplicationRefId());
					certificatePath = getMutationCertificate(pt.getMutationId(), pt.getAssessmentDetailsId(),
							pt.getRti_ref_id());
					dscType = "1";

				} else if (serviceId == 53) {
					pp = partitionOfPropertyService.get(rtiApplication.getRtiApplicationRefId());
					certificatePath = getMutationCertificate(pp.getMutationId(), pp.getAssessmentDetailsId(),
							pp.getRti_ref_id());
					dscType = "1";
					// view demand
				} else if (serviceId == 103) {
					pm = propertyTaxMutationService.get(rtiApplication.getRtiApplicationRefId());
					appType = (pm.getUpinNo() != null && pm.getUpinNo().length() > 0) ? "1" : "2";
					if (appType.equals("1")) {
						certificatePath = getViewDemand(pm.getUpinNo(), appType, pm.getRti_ref_id());
					} else {
						certificatePath = getViewDemand(pm.getIndexNo(), appType, pm.getRti_ref_id());
					}

					dscType = "2";
				} else if (serviceId == 67) {
					pc = propertyTaxComplaintService.get(rtiApplication.getRtiApplicationRefId());
					appType = (pc.getUpinNo() != null && pc.getUpinNo().length() > 0) ? "1" : "2";
					if (appType.equals("1")) {
						certificatePath = getViewDemand(pc.getUpinNo(), appType, pc.getRti_ref_id());
					} else {
						certificatePath = getViewDemand(pc.getIndexNo(), appType, pc.getRti_ref_id());
					}
					dscType = "2";
					// Special Notice 15/2
				} else if (serviceId == 58) {
					pa = propertyAssessmentService.get(rtiApplication.getRtiApplicationRefId());
					certificatePath = getSpecialNotice(pa.getUpinNo(), pa.getPropertyId(), pa.getRti_ref_id());

					dscType = "3";
				} else if (serviceId == 71) {

					pe = taxExemptionNonResidentialService.get(rtiApplication.getRtiApplicationRefId());
					certificatePath = getSpecialNotice(pe.getUpinNo(), pe.getPropertyId(), pe.getRti_ref_id());
					dscType = "3";
				} else if (serviceId == 56) {
					pn = newlyConstructedPropertyService.get(rtiApplication.getRtiApplicationRefId());
					certificatePath = getSpecialNotice(pn.getUpinNo(), pn.getPropertyId(), pn.getRti_ref_id());
					dscType = "3";
				}

				dscresult = dscrestcontroller.getPropertyTaxDSC(certificatePath, dscType);

				json.put("certificatePath", dscresult);
				pw.print(json.toString());
				pw.flush();
				pw.close();

			} else {

				pw.print(json.toString());
				pw.flush();
				pw.close();
			}
		} catch (Exception ex) {
			log.error(ex.getMessage().toString());
			ex.printStackTrace();
		}
		return null;

	}
}
