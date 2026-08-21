package com.mars.rti.ws.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Year;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.common.utils.CommonUtils;
import com.mars.rti.controller.PropertyTaxPTNDetailsController;
import com.mars.rti.controller.PropertyTaxTokenGeneration;
import com.mars.rti.controller.SendSMSEmailController;
import com.mars.rti.model.PostPropertyTaxMutation;
import com.mars.rti.model.PropertyTaxTransferRegistration;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.PropertyTaxTransferRegistrationService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.PropertyTaxTransferRegistrationRestDTO;

@Controller
public class PropertyTaxTransferRegistrationRestController {

	private Log log = LogFactory.getLog(PropertyTaxTransferRegistrationRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private PropertyTaxTransferRegistrationService propertyTaxTransferRegistrationService;

	@RequestMapping(method = RequestMethod.POST, value = "/savePropertyTaxTransferRegistration")
	public @ResponseBody PropertyTaxTransferRegistrationRestDTO savePropertyTaxTransferRegistration(
			@RequestBody PropertyTaxTransferRegistrationRestDTO pttr, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		PropertyTaxTransferRegistration ptr = new PropertyTaxTransferRegistration();
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[4];
		String result = null;
		String responseCode = null;
		String responseMessage = null;
        int resultList=0;
		if (log.isDebugEnabled()) {
			log.debug("Invoking savePropertytaxTransferRegistration");
		}

		try {
			if (pttr.getName() != null && !pttr.getName().isEmpty()) {
				ptr.setName(pttr.getName());
			} else {
				String firstName = "Firstname field is Required";
				condition = false;
				message.append(firstName).append(",");
			}

			if (pttr.getEmailid() != null && !pttr.getEmailid().isEmpty()) {
				ptr.setEmailid(pttr.getEmailid());

			} else {
				String email = "Email ID field is Required";
				condition = false;
				message.append(email).append(",");
			}

			if (pttr.getMobileNo() != null && !pttr.getMobileNo().isEmpty()) {
				ptr.setMobileNo(pttr.getMobileNo());

			} else {
				String mobileNo = "Mobile No. field is Required";
				condition = false;
				message.append(mobileNo).append(",");
			}

			if (pttr.getPropertyHolderName() != null && !pttr.getPropertyHolderName().isEmpty()) {
				ptr.setPropertyHolderName(pttr.getPropertyHolderName());

			} else {
				String propertyHolderName = "Property Holder Name field is Required";
				condition = false;
				message.append(propertyHolderName).append(",");
			}

			if (pttr.getZoneNo() >0 ) {
				ptr.setZoneNo(String.valueOf(pttr.getZoneNo()));
			} else {
				String zonenNo = "Zone No. field is Required";
				condition = false;
				message.append(zonenNo).append(",");
			}


			if (pttr.getBlockId() != null && !pttr.getBlockId().isEmpty()) {
				ptr.setBlockId(pttr.getBlockId());
			} else {
				String blockId = "Block Id field is Required";
				condition = false;
				message.append(blockId).append(",");
			}

			if (pttr.getBlockNo() != null && !pttr.getBlockNo().isEmpty()) {
				ptr.setBlockNo(pttr.getBlockNo());
			} else {
				String blockNo = "Block No field is Required";
				condition = false;
				message.append(blockNo).append(",");
			}

			if (pttr.getBlockName() != null && !pttr.getBlockName().isEmpty()) {

				ptr.setBlockName(pttr.getBlockName());
			} else {
				String blockName = "Block Name field is Required";
				condition = false;
				message.append(blockName).append(",");
			}

			if (pttr.getUpinNo() != null && !pttr.getUpinNo().isEmpty()) {

				ptr.setUpinNo(pttr.getUpinNo());
				ptr.setIndexNo(pttr.getIndexNo());

			} else if (pttr.getIndexNo() != null && !pttr.getIndexNo().isEmpty()) {
				ptr.setIndexNo(pttr.getIndexNo());
			} else {
				String indexUpin = "UPIN/Index No. field is Required";
				condition = false;
				message.append(indexUpin).append(",");
			}

			if (pttr.getAddress() != null && !pttr.getAddress().isEmpty()) {

				ptr.setAddress(pttr.getAddress());
			} else {
				String address = "Address field is Required";
				condition = false;
				message.append(address).append(",");
			}

			if (pttr.getOwnerName() != null && !pttr.getOwnerName().isEmpty()) {
				ptr.setOwnerName(pttr.getOwnerName());
			} else {
				String owner_name = "Owner Name field is Required";
				condition = false;
				message.append(owner_name).append(",");
			}

			ptr.setAreasPending(pttr.getAreasPending());

			if (pttr.getAreasPendingStatus() != null && !pttr.getAreasPendingStatus().isEmpty()) {
				ptr.setAreasPendingStatus(pttr.getAreasPendingStatus());
			} else {
				String arreas_pending_status = "Arrears Status field is Required";
				condition = false;
				message.append(arreas_pending_status).append(",");
			}

			if (pttr.getMobileNo() != null && !pttr.getMobileNo().isEmpty()) {
				ptr.setTaxMobileNo(pttr.getTaxMobileNo());
			} else {
				String tax_mobileNo = "Registered Mobile No. field is Required";
				condition = false;
				message.append(tax_mobileNo).append(",");
			}

			if (pttr.getPincode() != null && !pttr.getPincode().isEmpty()) {
				ptr.setTaxPincode(pttr.getPincode());
			} else {
				String pincode = "Pincode field is Required";
				condition = false;
				message.append(pincode).append(",");
			}

			if (pttr.getRequestType() != null && !pttr.getRequestType().isEmpty()) {
				if (pttr.getRequestType().equals("PTRC")) {
					ptr.setMyDropdown("3");
				} else if (pttr.getRequestType().equals("IRPTRC")) {
					ptr.setMyDropdown("4");
				}else {
					String requestTypes = "Request type is Required";
					condition = false;
					message.append(requestTypes).append(",");
				}
			} else {
				String requestType = "Request type is Required";
				condition = false;
				message.append(requestType).append(",");
			}

			ptr.setDuesAmt(pttr.getDuesAmt());

			if (pttr.getAssessmentDetailsId() != null && !pttr.getAssessmentDetailsId().isEmpty()) {

				ptr.setAssessmentDetailsId(pttr.getAssessmentDetailsId());
			} else {
				String assDtlsId = "Assessment Details ID is Required";
				condition = false;
				message.append(assDtlsId).append(",");
			}

			// FILES

			if (pttr.getSelfAttestedIdProofDoc() != null && !pttr.getSelfAttestedIdProofDoc().isEmpty()) {
				files[0] = pttr.getSelfAttestedIdProofDoc();
			} else {
				String selfDoc = "Self Attested Applicant's Id Proof is Required";
				condition = false;
				message.append(selfDoc).append(",");
			}

				files[1] = pttr.getAkhivtaPatrikaofCitySurveyDoc();
			

				files[2] = pttr.getAnyOtherSupportingDoc();
			

			if (pttr.getRequestType().equals("IRPTRC")) {
				if (pttr.getGiftDeedDoc() != null && !pttr.getGiftDeedDoc().isEmpty()) {
					files[3] = pttr.getGiftDeedDoc();
				} else {
					String giftDeed = "Gift Deed, Will Deed, Death Certificate, Partition Deed, Inheritance Document, NIT/Nazul/Lease of Municipal Corporation Document is Required";
					condition = false;
					message.append(giftDeed).append(",");
				}
			}

			RTIApplication rtiApplication = new RTIApplication();
			if (pttr.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(pttr.getUserMobileNumber()));
			} else {
				String userMobilenumber = "User Mobile Number field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}


			if (condition) {
				Map<String,String> savedFilePath = PropertyTaxTransferRegistrationRestController.saveFile(files, request);

                ptr.setFilesPath(savedFilePath.get("filesPath"));
				rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
				rtiApplication.setTemplateName("propertytax");
				if (pttr.getRequestType().equals("PTRC")) {
					rtiApplication.setSubject("PROPERTY-TRANSFER-REGISTRATION-CERTIFICATE");
				} else {
					rtiApplication.setSubject("INHERITANCE-RIGHTS-PROPERTY-REGISTRATION-CERTIFICATE");
				}
				rtiApplication.setDepartment("TAX-DEPARTMENT");
				rtiApplication.setWorkFlowStatus(0);
				rtiApplication.setFinalStatus("0");
				rtiApplication.setRtiserviceid(104);
				rtiApplication.setApplicantName(ptr.getName());
				rtiApplication.setPhoneNumber(ptr.getMobileNo());
				rtiApplication.setMobileNumber(ptr.getMobileNo());
				rtiApplication.setEmail(ptr.getEmailid());
				rtiApplication.setZone(String.valueOf(pttr.getZoneNo()));

				rtiApplication.setApplicantName(ptr.getName());

				rtiApplication.setPdfUploadFromPortal(savedFilePath.get("filesPath"));
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
					rti.setRtiApplnNumber("RTS/PT" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
					ptr.setRtiapplrefno(rti.getRtiApplnNumber());
					ptr.setRti_ref_id(savedRti.getRtiApplicationId());
					long birth_regis_id = propertyTaxTransferRegistrationService.propertyTaxTransferRegistration(ptr);
					rti.setRtiApplicationRefId(birth_regis_id);
					RTIApplication retunRti = rtiApplicationService.merge(rti);

					String url = CoreConstants.TAX_STAGING_SAVE;

					HttpHeaders headers = new HttpHeaders();

					PostPropertyTaxMutation postPropertyTaxMutation = new PostPropertyTaxMutation();
					PostPropertyTaxMutation.CitizenRequest pptm = new PostPropertyTaxMutation.CitizenRequest();
					pptm.setCreatedBy("4377");
					pptm.setDocumentUrl(PropertyTaxPTNDetailsController.getFilesPath(savedFilePath.get("urlPath")));
					pptm.setIndexNo(ptr.getIndexNo());
					pptm.setMeasleNo("");
					pptm.setPtn(ptr.getUpinNo());
					pptm.setRegisteredPhone(ptr.getMobileNo());
					pptm.setRequestAddress(ptr.getAddress());
					pptm.setRequesterHouseNo("");
					pptm.setRequesterLandPlotNo("");
					pptm.setRequesterMail(ptr.getEmailid());
					pptm.setRequesterMauja("");
					pptm.setRequesterMobile(ptr.getTaxMobileNo());
					pptm.setRequesterWard(ptr.getBlockId());
					pptm.setRequestName(ptr.getName());
					pptm.setRequesterMobile(ptr.getTaxMobileNo());
					pptm.setRequestNumber(retunRti.getRtiApplnNumber());
					pptm.setRequestType("RTSPTR");
					postPropertyTaxMutation.setCitizenRequest(pptm);
					String token = PropertyTaxTokenGeneration.propertyTaxToken();
					postPropertyTaxMutation.setToken(token);

					RestTemplate restTemplate = new RestTemplate();
					ObjectMapper objectMapper = new ObjectMapper();
					String jsonRequestBody = objectMapper.writeValueAsString(postPropertyTaxMutation);

					headers.setContentType(MediaType.APPLICATION_JSON);

					HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);

					ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
							String.class);
					HttpStatus statusCode = responseEntity.getStatusCode();
					System.out.println("HTTP Status Code: " + statusCode);
					if (statusCode == HttpStatus.OK) {
						String responseBody = responseEntity.getBody();
						log.debug("Response Body: " + responseBody);
						JsonNode rootNode = objectMapper.readTree(responseBody);

						JsonNode resultNode = rootNode.get("SaveRTSRequestResult").get("Result");
						JsonNode resultListNode = rootNode.get("SaveRTSRequestResult").get("ResultList");
						JsonNode responsecode = rootNode.get("SaveRTSRequestResult").get("ResponseCode");
						JsonNode message1 = rootNode.get("SaveRTSRequestResult").get("ResponseMessage");
						JsonNode uniqueId = resultNode.get("UniqueRecordId");

			            if(uniqueId!=null) 
			             result = uniqueId.asText();
			            
						resultList = resultListNode.size();
						responseCode = responsecode.asText();
						responseMessage = message1.asText();

						if (log.isDebugEnabled()) {
							log.debug(statusCode);
							log.debug(result);
							log.debug(responseCode);
							log.debug(retunRti.getRtiApplnNumber());
						}
					}
					if (responseCode.equals("GCPT10100")) {
						 if(result!=null && !result.isEmpty()) {
					        	ptr.setApi_response_unique_id(result);
					        	ptr=propertyTaxTransferRegistrationService.merge(ptr);
					        	pttr.setResponseStatus("Requested data saved successfully");
								pttr.setResult(retunRti.getRtiApplnNumber());
								pttr.setResponseCode(HttpStatus.OK.value());
								response.setStatus(HttpStatus.OK.value());
								pttr.setStatus("ok");

								pttr.setSelfAttestedIdProofDoc("");
								pttr.setAkhivtaPatrikaofCitySurveyDoc("");
								pttr.setGiftDeedDoc("");
								pttr.setAnyOtherSupportingDoc("");
								String name = ptr.getName();
								String applnNo = rti.getRtiApplnNumber();
								String mobileNo = ptr.getMobileNo();
								String email = ptr.getEmailid();
								SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);
					        	
		                        }else {
		                        	 rtiApplicationService.delete(retunRti.getRtiApplicationId());
		        					 condition=false;
		     						message.append(responseMessage).append(",Error :").append("Something went wrong").append(",");

		                        }
						

					} else {
						rtiApplicationService.delete(retunRti.getRtiApplicationId());
						condition = false;
						message.append(responseMessage).append(",TaxAPIResponseCode :").append(responseCode).append(",");
					}

				}

			}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
					message.deleteCharAt(message.length() - 1);
					pttr.setResult(message.toString());
					pttr.setResponseStatus("Requested data not saved successfully");
					pttr.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					pttr.setStatus("Internal Server Error");
					pttr.setSelfAttestedIdProofDoc("");
					pttr.setAkhivtaPatrikaofCitySurveyDoc("");
					pttr.setGiftDeedDoc("");
					pttr.setAnyOtherSupportingDoc("");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			pttr.setResponseStatus(ex.getMessage());
			pttr.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			pttr.setStatus("Method not Allowed");
			pttr.setSelfAttestedIdProofDoc("");
			pttr.setAkhivtaPatrikaofCitySurveyDoc("");
			pttr.setGiftDeedDoc("");
			pttr.setAnyOtherSupportingDoc("");
		}
		
		return pttr;
	}

//	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
//		String filesPath = null;
//		StringBuilder filesPathBuilder = new StringBuilder();
//		String baseDir = CoreConstants.UPLOAD_PATH + "propertyTransfer";
//		File file = new File(baseDir);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
//		if (data != null) {
//			for (String element : data) {
//				if (element != null) {
//					byte[] pdfBytes = Base64.getDecoder().decode(element);
//					String fileName;
//					String uniqueFileName = UUID.randomUUID().toString().substring(0, 8) + ".pdf";
//					int l = uniqueFileName.lastIndexOf(".");
//					String imageext = uniqueFileName.substring(l, uniqueFileName.length());
//					fileName = uniqueFileName.substring(0, l);
//					fileName = fileName.replaceAll("[^a-zA-Z0-9]", "");
//					fileName = fileName.replaceAll("\\W", "");
//					fileName = fileName + "" + imageext;
//					File storeFile = new File(baseDir, fileName);
//					try (FileOutputStream outputStream = new FileOutputStream(storeFile)) {
//						outputStream.write(pdfBytes);
//						outputStream.flush();
//						outputStream.close();
//					}
//					String url = CoreConstants.UPLOAD_PATH;
//					filesPath = url + "propertyTransfer" + File.separator + fileName;
//					filesPathBuilder.append(filesPath).append(",");
//				} else {
//					filesPathBuilder.append("null").append(",");
//
//				}
//			}
//		} else {
//			filesPathBuilder.append("null").append(",");
//		}
//		if (filesPathBuilder != null) {
//			if (filesPathBuilder.charAt(filesPathBuilder.length() - 1) == ',') {
//				filesPathBuilder.deleteCharAt(filesPathBuilder.length() - 1);
//			}
//			filesPath = filesPathBuilder.toString();
//		}
//		return filesPath;
//	}


	public static Map<String,String> saveFile(String data[], HttpServletRequest request) throws IOException {
		Map<String,String> map = new HashMap<String,String>();
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		StringBuilder urldownload = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "propertyTransfer";
		String base64path=null;
		File file = new File(baseDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		if (data != null) {
			for (String element : data) {
				if (element != null) {
					byte[] pdfBytes = Base64.getDecoder().decode(element);
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

					String url = CoreConstants.UPLOAD_PATH;
					filesPath = url + "propertyTransfer" + File.separator + fileName;
					filesPathBuilder.append(filesPath).append(",");
					
					//
				    base64path = Base64.getEncoder().encodeToString(filesPath.getBytes(StandardCharsets.UTF_8));
					String url1 = "https" + "://" + 
							request.getServerName() + "/RTS"+ 
							"/rtsApplication/getPdf.do"+"?fp=" +base64path;
					urldownload.append(url1).append(",");

				} else {
					filesPathBuilder.append("null").append(",");
					urldownload.append("null").append(",");

				}
			}
		} else {
			filesPathBuilder.append("null").append(",");
			urldownload.append("null").append(",");
		}
		if (filesPathBuilder != null) {
			if (filesPathBuilder.charAt(filesPathBuilder.length() - 1) == ',') {
				filesPathBuilder.deleteCharAt(filesPathBuilder.length() - 1);
			}
			filesPath = filesPathBuilder.toString();
		}
		if(urldownload!=null) {
			if (urldownload.charAt(urldownload.length() - 1) == ',') {
				urldownload.deleteCharAt(urldownload.length() - 1);
			}
		}
		
		map.put("urlPath", urldownload.toString());
		map.put("filesPath", filesPath);
		return map;
	}

}
