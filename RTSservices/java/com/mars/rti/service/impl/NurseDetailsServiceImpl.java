package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.NurseDetailsDAO;
import com.mars.rti.model.NurseDetails;
import com.mars.rti.service.NurseDetailsService;

@Service
public class NurseDetailsServiceImpl  implements NurseDetailsService{

	@Autowired
	private NurseDetailsDAO nurseDetailsDAO;
	
	@Override
	public NurseDetails mergeNurseDetails(NurseDetails sd) {
		// TODO Auto-generated method stub
		return nurseDetailsDAO.mergeNurseDetails(sd);
	}

	@Override
	public NurseDetails getNurseDetails(long id) {
		// TODO Auto-generated method stub
		return nurseDetailsDAO.getNurseDetails(id);
	}

	
}
