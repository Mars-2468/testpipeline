package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.NursingOwnerDetailsChangeDAO;
import com.mars.rti.model.NursingOwnerDetailsChange;
import com.mars.rti.service.NursingOwnerDetailsChangeService;

@Service
public class NursingOwnerDetailsChangeServiceImpl implements NursingOwnerDetailsChangeService{

	
	@Autowired
	private NursingOwnerDetailsChangeDAO nursingOwnerDetailsChangeDAO;
	
	@Override
	public NursingOwnerDetailsChange mergeownerDetails(NursingOwnerDetailsChange sd) {
		// TODO Auto-generated method stub
		return nursingOwnerDetailsChangeDAO.mergeownerDetails(sd);
	}

	@Override
	public NursingOwnerDetailsChange getOwnerDetails(long id) {
		// TODO Auto-generated method stub
		return nursingOwnerDetailsChangeDAO.getOwnerDetails(id);
	}

}
