package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.BloodGroupDAO;
import com.mars.rti.model.BloodGroup;
import com.mars.rti.service.BloodGroupService;

@Service
public class BloodGroupServiceImpl implements BloodGroupService{

	@Autowired
	private BloodGroupDAO  bloodGroupDAO;
	
	
	@Override
	public List<BloodGroup> getBloodGroup() {
		// TODO Auto-generated method stub
		return bloodGroupDAO.getBloodGroup();
	}

	
	
}
