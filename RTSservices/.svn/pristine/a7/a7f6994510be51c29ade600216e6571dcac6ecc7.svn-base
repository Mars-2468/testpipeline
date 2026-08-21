package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FireFeesMainDAO;
import com.mars.rti.model.FireFeesMain;
import com.mars.rti.service.FireFeesMainService;

@Service
public class FireFeesMainServiceImpl implements FireFeesMainService {
	@Autowired
	private FireFeesMainDAO feesMainDAO;
	public FireFeesMain getFireMainFees(long fireBuildingType, long fireBuildingHeight) {
		return feesMainDAO.getFireMainFees(fireBuildingType, fireBuildingHeight);
	}
}
