package com.mars.rti.ws.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.model.RTIApplication;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.TaxUploadRestDTO;

@Controller
public class TaxUploadRestController {

	private Log log = LogFactory.getLog(TaxUploadRestController.class);

	@Autowired
	private RTIApplicationService rtsService;

	@RequestMapping(method = RequestMethod.POST, value = "/rtsApplication/saveRTSTaxUpload.do")
	public @ResponseBody TaxUploadRestDTO saveRTSTaxUpload(@RequestBody TaxUploadRestDTO taxUpload,
			HttpServletRequest request, HttpServletResponse response) throws ServletException {

		TaxUploadRestDTO taxUploadPdf = new TaxUploadRestDTO();
		RTIApplication rts = null;

		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String fileData = null;

		try {

			if (taxUpload != null) {

				if (taxUpload.getKey().equals(CoreConstants.TAX_UPLOAD_AUTHENTICATION_KEY)) {
					if (taxUpload.getRtsApplicationNumber() != null && !taxUpload.getRtsApplicationNumber().isEmpty()) {

						rts = rtsService.findByRTIApplicationNumber(taxUpload.getRtsApplicationNumber());
						if (rts == null) {

							String rtsNumber = "RTS Application Number is invalid";
							condition = false;
							message.append(rtsNumber).append(",");
						}
					} else {
						String rtsNo = "RTS Application Number is Required";
						condition = false;
						message.append(rtsNo).append(",");
					}

					if (taxUpload.getFilesBase64Data() == null || taxUpload.getFilesBase64Data().isEmpty()) {

						String filesPath = "Files Data is Required";
						condition = false;
						message.append(filesPath).append(",");
					}

					if (taxUpload.getRequestType() != null && !taxUpload.getRequestType().isEmpty()) {
						if (!taxUpload.getRequestType().equals(CoreConstants.RTS_TAX_CITIZEN_UPLOAD)) {

							String requestTypes = "Request Type is invalid";
							condition = false;
							message.append(requestTypes).append(",");
						}
					} else {
						String requestType = "Request Type is Required";
						condition = false;
						message.append(requestType).append(",");
					}

					if (condition) {

						fileData = taxUpload.getFilesBase64Data();
						if (fileData.endsWith(",")) {
							fileData = fileData.substring(0, fileData.length() - 1);
						}
						String[] files = fileData.split(",");
						Map<String,String> savedFilePath = TaxUploadRestController.saveFile(files, request);
						rts.setTaxOtherCitizenDocumentUpload(savedFilePath.get("filesPath"));
						rts = rtsService.merge(rts);
						taxUploadPdf.setFilesBase64Data(savedFilePath.get("urlPath"));
						taxUploadPdf.setKey(taxUpload.getKey());
						taxUploadPdf.setRtsApplicationNumber(rts.getRtiApplnNumber());
						taxUploadPdf.setRequestType(CoreConstants.RTS_TAX_CITIZEN_UPLOAD);
						taxUploadPdf.setResponseCode(HttpStatus.OK.value());
						response.setStatus(HttpStatus.OK.value());
						taxUploadPdf.setResult("200 ok");
						taxUploadPdf.setResponseStatus("SUCCESS");

					}

					if (!condition) {
						if (message.charAt(message.length() - 1) == ',') {
							message.deleteCharAt(message.length() - 1);
							taxUploadPdf.setResult(message.toString());
							taxUploadPdf.setFilesBase64Data("");
							taxUploadPdf.setKey("");
							taxUploadPdf.setRtsApplicationNumber("");
							taxUploadPdf.setRequestType(CoreConstants.RTS_TAX_CITIZEN_UPLOAD);
							taxUploadPdf.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
							response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
							taxUploadPdf.setResult(message.toString());
							taxUploadPdf.setResponseStatus("Internal Server Error");

						}

					}
				} else {

					taxUploadPdf.setFilesBase64Data("");
					taxUploadPdf.setKey("");
					taxUploadPdf.setRtsApplicationNumber("");
					taxUploadPdf.setRequestType("");
					taxUploadPdf.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
					taxUploadPdf.setResult("Authentication Key is invalid!!");
					taxUploadPdf.setResponseStatus("Internal Server Error");
				}
			} else {
				taxUploadPdf.setFilesBase64Data("");
				taxUploadPdf.setKey("");
				taxUploadPdf.setRtsApplicationNumber("");
				taxUploadPdf.setRequestType("");
				taxUploadPdf.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				taxUploadPdf.setResult("Please upload valid pdf base64 data!!");
				taxUploadPdf.setResponseStatus("Internal Server Error");
			}
		} catch (

		Exception ex) {
			log.error(ex.getMessage());
			taxUploadPdf.setResponseStatus(ex.getMessage());
			taxUploadPdf.setFilesBase64Data("");
			taxUploadPdf.setKey("");
			taxUploadPdf.setRtsApplicationNumber("");
			taxUploadPdf.setRequestType("");
			taxUploadPdf.setResponseCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());

		}

		return taxUploadPdf;
	}

	public static Map<String,String> saveFile(String data[], HttpServletRequest request) throws IOException {
		Map<String,String> map = new HashMap<String,String>();
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		StringBuilder urldownload = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "taxOtherDocuments";
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
					filesPath = url + "taxOtherDocuments" + File.separator + fileName;
					filesPathBuilder.append(filesPath).append(",");
					
					//
				    base64path = Base64.getEncoder().encodeToString(filesPath.getBytes());
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
