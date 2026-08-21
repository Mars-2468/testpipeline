package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.MarriageLawRestServiceDAO;
import com.mars.rti.model.MarriageLaw;
import com.mars.rti.service.MarriageLawRestService;

@Service
public class MarriageLawRestServiceImpl implements MarriageLawRestService{

	@Autowired
	private MarriageLawRestServiceDAO marriageLawRestServiceDAO;
	
	@Override
	public List<MarriageLaw> getall() {
		// TODO Auto-generated method stub
		return marriageLawRestServiceDAO.getall();
	}

}
