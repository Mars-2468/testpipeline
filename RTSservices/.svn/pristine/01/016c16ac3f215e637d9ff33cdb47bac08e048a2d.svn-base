package com.mars.rti.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.DogDetailsDAO;
import com.mars.rti.model.DogDetails;
import com.mars.rti.service.DogDetailsService;

@Service("dogDetailsService")
public class DogDetailsServiceImpl implements DogDetailsService{

	@Autowired
	DogDetailsDAO dogDetailsDAO;
	
	private static Log log = LogFactory.getLog(DogDetailsServiceImpl.class);
	
	@Override
	public void saveDogDetails(DogDetails dogDetails) {
		
		
		dogDetailsDAO.dogDetailsSave(dogDetails);
		  
	}
	
	

}
