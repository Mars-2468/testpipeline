package com.mars.rti.service;

import org.springframework.web.client.RestTemplate;

import com.mars.rti.ws.model.ApleSarkarValidateRequestDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


public class ApleSarkarPaymentService {

	    public String sendValidateRequest(ApleSarkarValidateRequestDTO requestDTO, String endpointUrl) throws Exception {
	        RestTemplate restTemplate = new RestTemplate();

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

	        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
	        body.add("ClientCode", requestDTO.getClientCode());
	        body.add("CheckSum", requestDTO.getCheckSum());
	        body.add("ServiceID", requestDTO.getServiceID());
	        body.add("ApplicationID", requestDTO.getApplicationID());
	        body.add("Districtid", requestDTO.getDistrictid());
	        body.add("ApplicationDate", requestDTO.getApplicationDate());
	        body.add("TrackID", requestDTO.getTrackID());
	        body.add("UserID", requestDTO.getUserID());
	        body.add("MobileNo", requestDTO.getMobileNo());
	        body.add("Name", requestDTO.getName());
	        body.add("Returnurl", requestDTO.getReturnurl());
	        body.add("UD1", requestDTO.getUD1());
	        body.add("UD2", requestDTO.getUD2());
	        body.add("UD3", requestDTO.getUD3());
	        body.add("UD4", requestDTO.getUD4());
	        body.add("UD5", requestDTO.getUD5());

	        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
	        ResponseEntity<String> response = restTemplate.postForEntity(endpointUrl, request, String.class);
	        return response.getBody();
	    }
	
}
