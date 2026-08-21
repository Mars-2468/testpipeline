package com.mars.common.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.UserRegistrationDAO;
import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;

@Service("UserRegistrationService")
public class UserRegistrationImpl implements UserRegistrationService {
	
	private static final Log log = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	private UserRegistrationDAO userDAO;
	
	

	@Override
	public void save(UserRegistrationDetails entity) {
		// TODO Auto-generated method stub
		if (log.isDebugEnabled()) {
			log.debug("save Method is called 88 ");
		}
		userDAO.save(entity);
	}



	@Override
	public UserRegistrationDetails getUser(String email) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (log.isDebugEnabled()) {
			log.debug("save Method is called ");
		}
		return userDAO.getUser(email);
	}



	@Override
	public UserRegistrationDetails getUserByMobileNo(String number) {
		// TODO Auto-generated method stub
		if (log.isDebugEnabled()) {
			log.debug("save Method is called 888");
		}
		
		return userDAO.getUserByMobileNo(number);
	}


}
