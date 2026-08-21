package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.WaterPressureDAO;
import com.mars.rti.model.WaterPressure;
import com.mars.rti.service.WaterPressureService;

@Service
public class WaterPressureServiceImpl implements WaterPressureService {

	@Autowired
	private WaterPressureDAO waterPressureDAO;
	
	@Override
	public void saveWaterConnectionType(WaterPressure waterPressure) {
		waterPressureDAO.saveWaterConnectionPressure(waterPressure);

		
	}


	@Override
	public WaterPressure get(long rtiApplicationRefId) {
		return waterPressureDAO.get(rtiApplicationRefId);
		 
	}

	@Override
	public List<WaterPressure> getAllWaterPressureComplaint() {
		
		return waterPressureDAO.getAllWaterPressureComplaint();
	}

	@Override
	public long waterPressure(WaterPressure waterPressure) {
		// TODO Auto-generated method stub
		return waterPressureDAO.waterPressureSave(waterPressure);
	}

	@Override
	public WaterPressure getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return waterPressureDAO.getDetails(rtiApplicationId);
	}
	@Override
	public WaterPressure merge(
			WaterPressure waterPressure) {
		// TODO Auto-generated method stub
		return waterPressureDAO.merge(waterPressure);
	}


	

	

}
