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
public class PTNValidationController {

	private static Log log = LogFactory
			.getLog(PTNValidationController.class);
	
	    @RequestMapping("/rtsapplication/propertyTaxTokenValidation.do")
	    public static String propertyTaxTokenValidation(HttpServletRequest request,HttpServletResponse response) throws IOException {
	    	String resultValue=null;
	        String url = "https://geocivicnmcapp.nmcptax.com/GeoCivicMicroServices/CitizenTaxService/CitizenTaxService/AgentCollectionService.svc/ValidatePtnForCollection";

	        RestTemplate restTemplate = new RestTemplate();
            JSONObject json = new JSONObject();
            PrintWriter pw = response.getWriter();
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        String ptn = request.getParameter("ptnNo");
	        String token = PropertyTaxTokenGeneration.propertyTaxToken();
	        String jsonRequestBody = "{ \"input\": \"" + ptn + "\", \"token\": \"" + token + "\" }";

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
	                JsonNode generateTokenResult = jsonNode.get("ValidatePtnForCollectionResult");
	                JsonNode resultList = generateTokenResult.path("ResultList");

	                if(resultList.size()>0) {
	                	json.put("status",true);
	                }else {
	                	json.put("status",false);
	                }
	                pw.print(json.toString());
	                pw.flush();
	                pw.close();
	                System.out.println("Result: " + resultValue);
	            } catch (Exception e) {
	                
	                e.printStackTrace();
	            }
	        
	}
	        return resultValue;

	    }
}
