package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.SurgeonDetaisDAO;
import com.mars.rti.model.SurgeonsDetails;
import com.mars.rti.service.SurgeonDetaisService;

@Service
public class SurgeonDetaisServiceImpl implements SurgeonDetaisService{

	
	@Autowired
    private SurgeonDetaisDAO surgeonDetaisDAO;
	
	
	@Override
	public SurgeonsDetails mergeSurgeonDetails(SurgeonsDetails sd) {
		// TODO Auto-generated method stub
		return surgeonDetaisDAO.mergeSurgeonDetails(sd);
	}

	@Override
	public SurgeonsDetails getSurgeonDetails(long id) {
		// TODO Auto-generated method stub
		return surgeonDetaisDAO.getSurgeonDetails(id);
	}

}
