package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.WaterReconnectionDAO;
import com.mars.rti.model.WaterReconnection;
import com.mars.rti.service.WaterReconnectionService;

@Service
public class WaterReconnectionServiceImpl implements WaterReconnectionService {

	@Autowired
	private WaterReconnectionDAO waterReconnectionDAO;
	
	@Override
	public void saveWaterReconnection(WaterReconnection waterReconnection) {
		waterReconnectionDAO.saveWaterReonnectionType(waterReconnection);
		
	}

	@Override
	public long getReferenceId(WaterReconnection waterReconnection) {
		
		return waterReconnectionDAO.getWaterReconnectionId(waterReconnection);
	}

	@Override
	public WaterReconnection get(long rtiApplicationRefId) {
		return waterReconnectionDAO.get(rtiApplicationRefId);
		
	}

	@Override
	public List<WaterReconnection> getAllwaterReconnection() {
		return waterReconnectionDAO.getAllWaterReconnection();
	}
	
	@Override
	public WaterReconnection getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return waterReconnectionDAO.getDetails(rtiApplicationId);
	}
	@Override
	public WaterReconnection merge(WaterReconnection waterReconnection) {
	
		return waterReconnectionDAO.merge(waterReconnection);

}


}
