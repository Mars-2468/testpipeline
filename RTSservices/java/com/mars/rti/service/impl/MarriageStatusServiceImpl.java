package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.MarriageStatusDAO;
import com.mars.rti.model.MarriageStatus;
import com.mars.rti.service.MarriageStatusService;

@Service
public class MarriageStatusServiceImpl implements MarriageStatusService{

	
	@Autowired
	private MarriageStatusDAO marriageStatusDAO;
	
	@Override
	public List<MarriageStatus> getall() {
		// TODO Auto-generated method stub
		return marriageStatusDAO.getall();
	}

}
