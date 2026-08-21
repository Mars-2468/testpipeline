package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.WaterConnectionNoDueDAO;
import com.mars.rti.model.WaterConnectionNoDue;
import com.mars.rti.service.WaterConnectionNoDueService;
@Service
public class WaterConnectionNoDueServiceImpl implements WaterConnectionNoDueService{
	
	@Autowired
	private WaterConnectionNoDueDAO waterConnectionNoDueDAO;

	public void waterConnectionSave(WaterConnectionNoDue waterConnectionNoDue) {
		waterConnectionNoDueDAO.saveWaterConnection(waterConnectionNoDue);
	}
	

	@Override
	public long fetchWaterCertificate(WaterConnectionNoDue WaterConnectionNoDue) {
		return waterConnectionNoDueDAO.getWaterCertificate(WaterConnectionNoDue);
		
	}

	@Override
	public WaterConnectionNoDue get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return waterConnectionNoDueDAO.get(rtiApplicationRefId);
	}


	@Override
	public List<WaterConnectionNoDue> getAllWaterNoDueCertificate() {
		// TODO Auto-generated method stub
		return waterConnectionNoDueDAO.getAllWaterNoDueCertificate();
	}
	
	@Override
	public WaterConnectionNoDue getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return waterConnectionNoDueDAO.getDetails(rtiApplicationId);
	}
	@Override
	public WaterConnectionNoDue merge(
			WaterConnectionNoDue waterConnectionNoDue) {
		// TODO Auto-generated method stub
		return waterConnectionNoDueDAO.merge(waterConnectionNoDue);
	}




}
