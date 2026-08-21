package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.WaterDisconnectionDAO;
import com.mars.rti.model.WaterDisconnection;
import com.mars.rti.service.WaterDisconnectionService;

@Service
public class WaterDisconnectionServiceImpl implements WaterDisconnectionService{
	
	@Autowired
	private WaterDisconnectionDAO waterDisconnectionDAO;


	@Override
	public void saveWaterDisconnection(WaterDisconnection waterDisconnection) {
		waterDisconnectionDAO.waterDisconnectionSave(waterDisconnection);
		
	}

	@Override
	public long waterDisconnection(WaterDisconnection waterDisconnection) {
		// TODO Auto-generated method stub
		return waterDisconnectionDAO.waterDisconnectionSave(waterDisconnection);	}

	@Override
	public WaterDisconnection get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return waterDisconnectionDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public List<WaterDisconnection> getAllWaterDisconnection() {
		return waterDisconnectionDAO.getAllWaterDisconnection();

	}
	@Override
	public WaterDisconnection getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return waterDisconnectionDAO.getDetails(rtiApplicationId);
	}
	@Override
	public WaterDisconnection merge(
			WaterDisconnection waterDisconnection) {
		// TODO Auto-generated method stub
		return waterDisconnectionDAO.merge(waterDisconnection);
	}

}
