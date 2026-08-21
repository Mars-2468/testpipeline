package com.mars.rti.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class GETPropertyTaxNoDuesCertificateController {

	private static Log log = LogFactory
			.getLog(GETPropertyTaxNoDuesCertificateController.class);
	
	    @RequestMapping("/rtsapplication/getPropertyTaxNoDuesCertitifcate.do")
	    public static String getPropertyTaxNoDuesCertitifcate(HttpServletRequest request,HttpServletResponse response) throws IOException {
	    	String resultValue=null;
	        String url = "http://geocivicnmcapp.nmcptax.com/GeoCivicMicroServices/Collection/DepartmentCollection/CollectionService.svc/GetRTSPropertyCollectionDetail";

	        String isOldPTN="";
	        RestTemplate restTemplate = new RestTemplate();
            JSONObject json = new JSONObject();
            PrintWriter pw = response.getWriter();
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        String ptn = request.getParameter("ptnNo");
	        String token = PropertyTaxTokenGeneration.propertyTaxToken();
	        String apptype = request.getParameter("apptype");
	        if(apptype.equals("2")) {
	        	isOldPTN = "true";
	        }else {
	        	isOldPTN = "false";
	        }
	        String jsonRequestBody = "{\"input\":{\"PTN\":\"" + ptn + "\",\"IsOldPTN\":\"" + isOldPTN + "\",\"SearchText\":\"Search\",\"ClientId\":\"3\"},\"token\":\"" + token + "\"}";

	        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
	        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

	        HttpStatus statusCode = responseEntity.getStatusCode();
	        System.out.println("HTTP Status Code: " + statusCode);
	        if (statusCode == HttpStatus.OK) {
	            String responseBody = responseEntity.getBody();
	            System.out.println("Response Body: " + responseBody);
	            ObjectMapper objectMapper = new ObjectMapper();
	            try {
	                JsonNode jsonNode = objectMapper.readTree(responseBody);
	                JsonNode generateTokenResult = jsonNode.get("GetRTSPropertyCollectionDetailResult");
	                JsonNode result = generateTokenResult.path("Result");

	                if(result!=null) {
	                	 int due=result.get("DueAmount").asInt();
	                	 if(due>0) {
	                	   json.put("duesAmt", due);
	                	   json.put("status",false);
	                     }else {
	                	   json.put("status",true);
	                     }
	                pw.print(json.toString());
	                pw.flush();
	                pw.close();
	                System.out.println("Result: " + resultValue);
	                }
	            } catch (Exception e) {
	                
	                e.printStackTrace();
	            }
	        
	}
	        return resultValue;

	    }
}
