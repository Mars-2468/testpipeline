package com.mars.rti.ws.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletResponse;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.common.service.UserRegistrationService;
import com.mars.rti.service.AapleSarkarDataPushService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.ws.model.PushDepartmentWrapperDTO;
import com.mars.rti.ws.model.TokenResponseDTO;

@Controller
public class AapleSarkarDataPushController {

	@Autowired
	private UserRegistrationService userService;

	@Autowired
	private AapleSarkarDataPushService aapleSarkarDataPushService;

	private static final String TOKEN_URL = "https://rtsdashboarddeptapi.mahaitgov.in/api/Token/GetToken";

	private static final String PUSH_URL = "https://rtsdashboarddeptapi.mahaitgov.in/api/Dashboard/PushDepartmentDetails";

	@RequestMapping("/rtsapplication/pushAapleSarkarData.do")
	public ModelAndView pushAapleSarkarData() {

		ModelAndView modelAndView = new ModelAndView("pushAapleSarkarData");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/rtsapplication/pushData.do", method = RequestMethod.POST)
	public void pushRTSData(HttpServletResponse response) throws IOException {

		response.setContentType("text/html");

		RestTemplate restTemplate = new RestTemplate();

		try {

			HttpHeaders tokenHeaders = new HttpHeaders();
			  tokenHeaders.set("DepartmentCode", "NMCDeptN");
		      tokenHeaders.set("ClientSecretKey", "EE46B5A5-0711-414D-AC8A-C8A9E195CA0C");
		      
		
			tokenHeaders.set("Content-Type", "application/json");

			HttpEntity<Void> tokenEntity = new HttpEntity<Void>(tokenHeaders);

			ResponseEntity<TokenResponseDTO> tokenResponse = restTemplate.exchange(TOKEN_URL, HttpMethod.GET,
					tokenEntity, TokenResponseDTO.class);

			String token = tokenResponse.getBody().getData();

			PushDepartmentWrapperDTO wrapper = new PushDepartmentWrapperDTO();
			LocalDate today = LocalDate.now();
			
			

			wrapper.setYear(today.getYear());
			wrapper.setMonth(today.getMonthValue());
			wrapper.setRowData(aapleSarkarDataPushService.getRowDataForRTS());
			
			ObjectMapper mapper = new ObjectMapper();
			  
			  String json =
			  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(wrapper);
			  
			  System.out.println("RTS JSON = " + json);

			HttpHeaders pushHeaders = new HttpHeaders();
			pushHeaders.set("Content-Type", "application/json");
			pushHeaders.set("Authorization", "Bearer " + token);

			HttpEntity<PushDepartmentWrapperDTO> pushEntity = new HttpEntity<PushDepartmentWrapperDTO>(wrapper,
					pushHeaders);

			ResponseEntity<String> apiResponse = restTemplate.postForEntity(PUSH_URL, pushEntity, String.class);
			
			System.out.println("check response " + apiResponse.getBody());
			Log.debug("apiResponse"+apiResponse.getBody());
			response.getWriter().write("SUCCESS\n\nAPI RESPONSE:\n" + apiResponse.getBody());

		} catch (Exception e) {
			e.printStackTrace(); // now you will see error in
			response.getWriter().write("ERROR:\n" + e.getMessage());
		}
	}
	


}