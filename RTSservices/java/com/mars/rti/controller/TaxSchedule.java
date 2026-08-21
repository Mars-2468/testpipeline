package com.mars.rti.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.common.utils.SessionUser;
import com.mars.rti.model.GetRTSPropertyCollectionDetail;
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

/* created on 26 feb 2013
 * @Author Anshu Gupta
 * 
 * This class ScheduleBill which extends Timertask which
 *  helps to schedule task at particular interval
 *   the method run is overridden method from timetask 
 *   
 */
public class TaxSchedule extends TimerTask
{
	
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
	

	private static final Log log = LogFactory.getLog(TaxSchedule.class);

	@Override
	public void run()
	{
		//System.out.println("In run method....");

		//LOG.info("updating via scheduler");
		//get_UpdateBillApproval();

	}

	
	
	@RequestMapping("rtsApplication/getPropertyApplicationStatus.do")
	public void getPropertyApplicationStatus(HttpServletRequest request, HttpServletResponse response) {
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

					if (request.getParameter("serviceId") != null)
						serviceId = Integer.parseInt(request.getParameter("serviceId"));

					if (serviceId > 0) {

						rts = rtiApplicationService.getListByServiceId(serviceId);

					} else if (refId != null) {
						rtiapplication = rtiApplicationService.get(Integer.parseInt(refId));
						if (rtiapplication != null)
							rts.add(rtiapplication);

						existingWorkflowStatus = rts.get(0).getWorkFlowStatus();
					}

					for (RTIApplication rtiApplication : rts) {

						serviceId = rtiApplication.getRtiserviceid();

						requestStatus = TaxSchedule
								.getPropertyTaxPaymentStatus(rtiApplication.getRtiApplnNumber());
						finalstatus = TaxSchedule
								.getFinalCertificate(rtiApplication.getRtiApplnNumber());
						objectionStatus = TaxSchedule
								.getObjectionStatus(rtiApplication.getRtiApplnNumber());
						int workflowStatus = rtiApplication.getWorkFlowStatus();
						if ((requestStatus != null && requestStatus.size() > 0)
								&& (finalstatus != null && finalstatus.size() > 0)) {

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
										mutationId = TaxSchedule.getMutationId(request, response,
												appType, pt.getUpinNo());
									} else {
										mutationId = TaxSchedule.getMutationId(request, response,
												appType, pt.getIndexNo());
									}
									pt.setMutationId(mutationId);
									propertyTaxTransferRegistrationService.savePrpertyTransferRegistrationForm(pt);
								}

								if (pp != null) {
									appType = (pp.getUpinNo() != null && pp.getUpinNo().length() > 0) ? "1" : "2";
									if (appType.equals("1")) {
										mutationId = TaxSchedule.getMutationId(request, response,
												appType, pp.getUpinNo());
									} else {
										mutationId = TaxSchedule.getMutationId(request, response,
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
								rtiApplication = rtiApplicationService.merge(rtiApplication);

							}

							if (pmt) {
								if (amount > 0) {
									rtiApplication.setApplicationCost(amount);
								}
								rtiApplication.setWorkFlowStatus(2);
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
								rtiApplication = rtiApplicationService.merge(rtiApplication);
								if (rtiApplication != null) {
									SendSMSEmailController.sendApplicationRejected(rtiApplication.getApplicantName(),
											rtiApplication.getPhoneNumber(), rtiApplication.getRtiApplnNumber(),
											rtiApplication.getEmail());

								}

							}

						} else if (objectionStatus != null && objectionStatus.length() > 0) {
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
		} else {
		}

	}

	
	private static String getObjectionStatus(String rtsNo) {
		String resultValue = null;
		String url = "https://nmctax.cybertech.com/GeocivicServices/CitizentaxService/CitizentaxService/AgentCollectionService.svc/GetRTSRequestStatus";

		String token = PropertyTaxTokenGeneration.propertyTaxToken();
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

		String jsonRequestBody = "{ \"REQUEST_NUMBER\": \"" + rtsNo + "\", \"token\": \"" + token + "\" }";

		HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
				String.class);

		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println("HTTP Status Code: " + statusCode);
		if (statusCode == HttpStatus.OK) {
			String responseBody = responseEntity.getBody();
			System.out.println("Response Body: " + responseBody);
			ObjectMapper objectMapper = new ObjectMapper();
			try {

				JsonNode jsonNode = objectMapper.readTree(responseBody);
				JsonNode resultNode = jsonNode.get("GetRTSRequestStatusResult").get("ResultList");
				String amount = resultNode.get(0).get("AMOUNT").asText();
				resultValue = resultNode.get(0).get("STATUS").asText();

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
		// "https://geocivicnmcapp.nmcptax.com/GeoCivicMicroServices/CitizentaxService/CitizentaxService/AgentCollectionService.svc/GetRTSPaymentStatus";
		String url = "https://nmctax.cybertech.com/GeocivicServices/CitizentaxService/CitizentaxService/AgentCollectionService.svc/GetRTSPaymentStatus";

		String token = PropertyTaxTokenGeneration.propertyTaxToken();
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

		String jsonRequestBody = "{ \"REQUEST_NUMBER\": \"" + rtsNo + "\", \"token\": \"" + token + "\" }";

		HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
				String.class);

		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println("HTTP Status Code: " + statusCode);
		if (statusCode == HttpStatus.OK) {
			String responseBody = responseEntity.getBody();
			System.out.println("Response Body: " + responseBody);
			ObjectMapper objectMapper = new ObjectMapper();
			try {

				JsonNode jsonNode = objectMapper.readTree(responseBody);
				JsonNode resultNode = jsonNode.get("GetRTSPaymentStatusResult").get("ResultList");
				String amount = resultNode.get(0).get("AMOUNT").asText();
				String status = resultNode.get(0).get("STATUS").asText();

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

			String url = "https://nmctax.cybertech.com/GeocivicServices/CitizentaxService/CitizentaxService/AgentCollectionService.svc/GetRTSFinalRequestStatus";

			String token = PropertyTaxTokenGeneration.propertyTaxToken();
			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);

			String jsonRequestBody = "{ \"REQUEST_NUMBER\": \"" + rtsNo + "\", \"token\": \"" + token + "\" }";

			HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
					String.class);

			HttpStatus statusCode = responseEntity.getStatusCode();
			System.out.println("HTTP Status Code: " + statusCode);
			if (statusCode == HttpStatus.OK) {
				String responseBody = responseEntity.getBody();
				System.out.println("Response Body: " + responseBody);
				ObjectMapper objectMapper = new ObjectMapper();

				JsonNode jsonNode = objectMapper.readTree(responseBody);
				String responseCode = jsonNode.get("GetRTSFinalRequestStatusResult").get("ResponseCode").asText();
				if (responseCode.equals("GCPT10100")) {
					JsonNode resultNode = jsonNode.get("GetRTSFinalRequestStatusResult").get("ResultList");
					resultValue = resultNode.get(0).get("FINAL_REQUEST_STATUS").asText();
					finalstatus = resultNode.get(0).get("STATUS").asText();
                    ptn = resultNode.get(0).get("PTN").asText();
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

	
	// Get Mutation Id
		public static String getMutationId(HttpServletRequest request, HttpServletResponse response, String appType,
				String ptn) {

			if (log.isDebugEnabled()) {
				log.debug("Invoking getPropertyDetails get API");
			}
			long mutationId = 0;
			String isOldPTN = "";
			// String url =
			// "http://geocivicnmcapp.nmcptax.com/GeoCivicMicroServices/Collection/DepartmentCollection/CollectionService.svc/GetRTSPropertyCollectionDetail";
			String url = "https://nmctax.cybertech.com/GeoCivicServices/Collection/DepartmentCollection/CollectionService.svc/GetRTSPropertyCollectionDetail";
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
			String url = "https://nmctax.cybertech.com/GeoCivic/AssessmentReport/AssessmentReport/GenerateReport";
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
			String url = "https://nmctax.cybertech.com/GeoCivic/AssessmentReport/AssessmentReport/GenerateReport";
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
			String url = "https://nmctax.cybertech.com/GeoCivic/AssessmentReport/AssessmentReport/GenerateReport";
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
		
		
}
