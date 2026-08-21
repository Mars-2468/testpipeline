package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.NursingOwnerDetailsDAO;
import com.mars.rti.model.NursingOwnerDetails;
import com.mars.rti.service.NursingOwnerDetailsService;

@Service
public class NursingOwnerDetailsServiceImpl implements NursingOwnerDetailsService{

	
	@Autowired
	private NursingOwnerDetailsDAO nursingOwnerDetailsDAO;

	@Override
	public NursingOwnerDetails mergeNurseOwnerDetails(NursingOwnerDetails sd) {
		// TODO Auto-generated method stub
		return nursingOwnerDetailsDAO.mergeownerDetails(sd);
	}

	@Override
	public NursingOwnerDetails getNurseOwnerDetails(long id) {
		// TODO Auto-generated method stub
		return nursingOwnerDetailsDAO.getOwnerDetails(id);
	}
	
	
	
}
