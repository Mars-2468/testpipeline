package com.mars.rti.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.rti.utils.CoreConstants;

public class PropertyTaxTokenGeneration {
	private static Log log = LogFactory
			.getLog(PropertyTaxTokenGeneration.class);
	    public static String propertyTaxToken() {
	        // Define the URL
	    	String resultValue=null;
	    	//String url="https://nmctax.cybertech.com/GeocivicServices/CommonService/AuthenticationService/Authentication.svc/GenerateToken";
	    	String url=CoreConstants.TAX_TOKEN;
	    	log.debug("Token URL:"+url);
	        RestTemplate restTemplate = new RestTemplate();

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);

	        //String jsonRequestBody = "{ \"Username\": \"apiuser\", \"Password\": \"4kD7s3h8E%1&\" }";
	        String jsonRequestBody = "{ \"Username\": \"NMC-CITIZEN-01\", \"Password\": \"cybertech\" }";
	    	log.debug("Token Response Body:"+jsonRequestBody);

	        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequestBody, headers);
	        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
	    	log.debug("Token Response Body:"+jsonRequestBody);
	        HttpStatus statusCode = responseEntity.getStatusCode();
	    	log.debug("Token Response Code:"+statusCode);
	        System.out.println("HTTP Status Code: " + statusCode);
	        if (statusCode == HttpStatus.OK) {
	            String responseBody = responseEntity.getBody();
	            System.out.println("Response Body: " + responseBody);
	            ObjectMapper objectMapper = new ObjectMapper();
	            try {
	                JsonNode jsonNode = objectMapper.readTree(responseBody);
	    	    	log.debug("Getting Token :"+jsonNode);
	                JsonNode generateTokenResult = jsonNode.get("GenerateTokenResult");
	    	    	log.debug("Getting Token Result:"+generateTokenResult);
	                resultValue = generateTokenResult.get("Result").asText();
	    	    	log.debug("Token:"+resultValue);

	                System.out.println("Result: " + resultValue);
	            } catch (Exception e) {
	                // Handle JSON parsing error
	                e.printStackTrace();
	            }
	        
	}
	        return resultValue;

	    }
}
	


