package com.mars.rti.ws.controller;

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

import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.rti.ws.model.AppliSarkarUserDTO;

@Controller
public class AppliSarkarUserController {
	
	@Autowired
	private UserRegistrationService userService;

	private static Log log = LogFactory
			.getLog(AppliSarkarUserController.class);
	
		
		@RequestMapping(method = RequestMethod.POST, value = "/saveRTSUser")
		public @ResponseBody AppliSarkarUserDTO saveRTSUser(
				@RequestBody AppliSarkarUserDTO asut,
				HttpServletRequest request, HttpServletResponse reponse)
				throws ServletException {
			boolean condition = true;
			StringBuilder message = new StringBuilder();
			UserRegistrationDetails uds=null;
			UserRegistrationDetails ud = new UserRegistrationDetails();
			        try {
			        	if(asut!=null) {
			        		uds = userService.getUserByMobileNo(String.valueOf(asut.getUserMobileNo()));
			        	if(uds!=null) {
			        		condition=false;
			        	 String existing = "User already Exist";
					    message.append(existing).append(",");
			        	}else {
			        		if(asut.getEmailId()!=null && !asut.getEmailId().isEmpty()) {
				        		ud.setEmail(asut.getEmailId());
				        		
				        	}else {
				        		condition=false;
				        		String email ="Email is required";
								message.append(email).append(",");

				        	}
				        	
				        	if(asut.getFirstName()!=null && !asut.getFirstName().isEmpty()) {
				        		ud.setFirstName(asut.getFirstName());
				        	}else {
				        		condition=false;
				        		String firstName ="First name is required";
								message.append(firstName).append(",");	
				        	}
				        	
				        	if(asut.getLastName()!=null && !asut.getLastName().isEmpty()) {
				        		ud.setLastName(asut.getLastName());
				        	}else {
				        		condition=false;
				        		String lastName="Last Name is required";
								message.append(lastName).append(",");

				        	}
				        	
				        	if(asut.getUserMobileNo()>0) {
				        		ud.setMobileNo(String.valueOf(asut.getUserMobileNo()));
				        	}else {
				        		condition=false;
				        		String mobileNo="Mobile No. is required";
								message.append(mobileNo).append(",");
				        	}
			        	}
			        	
			        	}else {
			        		condition=false;
			        	}
			        	
			        	if(condition) {
			        		ud.setCreatedDate(CommonUtils.getCurrentStringDate());
			    			userService.save(ud);
			    			ud=userService.getUserByMobileNo(ud.getMobileNo());
			    			asut.setResult("Record saved successfully");
			    			asut.setResponseCode("200 ok");
							reponse.setStatus(HttpStatus.OK.value());
							
			    			
			        	}
			        		if (!condition) {
			    				if (message.charAt(message.length() - 1) == ',') {
			    					message.deleteCharAt(message.length() - 1);
			    					reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                                    asut.setResult(message.toString());
                                    asut.setResponseCode("500");

                                    
			    				}
			    			}
			        				        	
			        	
			        }catch(Exception ex){
			        	
			        	ex.printStackTrace();
			        	log.error(ex.getMessage());
						reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
                        asut.setResult(message.toString());
                        asut.setResponseCode("405");
            			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());


			        	
			        }
			
			
			
					return asut;
		
	

		}
	
}
