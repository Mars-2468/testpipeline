package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.BloodRelationDAO;
import com.mars.rti.model.BloodRelation;
import com.mars.rti.service.BloodRelationService;

@Service
public class BloodRelationServiceImpl implements BloodRelationService{

	@Autowired
	private BloodRelationDAO bloodRelationDAO;
	
	
	@Override
	public List<BloodRelation> getBloodrelation() {
		// TODO Auto-generated method stub
		return bloodRelationDAO.getBloodrelation();
	}

}
