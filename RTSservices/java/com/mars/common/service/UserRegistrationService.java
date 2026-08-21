package com.mars.common.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.UserRegistrationDetails;

@Transactional(readOnly = true)
public interface UserRegistrationService {
	
	  @Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	    public void save(UserRegistrationDetails entity);
	  
	  @Transactional
	  public UserRegistrationDetails getUser(String email);
	  
	  @Transactional
	  public UserRegistrationDetails getUserByMobileNo(String number);


}
