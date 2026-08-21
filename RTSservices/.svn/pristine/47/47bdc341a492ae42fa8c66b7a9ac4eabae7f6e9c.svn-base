package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.WaterConnectionUsageDAO;
import com.mars.rti.model.WaterConnectionUsage;
import com.mars.rti.model.WaterProposedCategoryType;
import com.mars.rti.model.WaterProposedTapSize;
import com.mars.rti.service.WaterConnectionUsageService;
@Service
public class WaterConnectionUsageServiceImpl implements WaterConnectionUsageService{
	
	@Autowired
	private WaterConnectionUsageDAO waterConnectionUsageDAO;


	@Override
	public void saveWaterConnectionUsage(WaterConnectionUsage waterConnectionUsage) {
		waterConnectionUsageDAO.waterConnectionUsageSave(waterConnectionUsage);
		
	}

	@Override
	public long waterConnectionUsage(WaterConnectionUsage waterConnectionUsage) {
		// TODO Auto-generated method stub
		return waterConnectionUsageDAO.waterConnectionUsageSave(waterConnectionUsage);	}

	@Override
	public WaterConnectionUsage get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return waterConnectionUsageDAO.get(rtiApplicationRefId);
	}

	@Override
	public List<WaterConnectionUsage> getAllWaterConnectionUsage() {
		return waterConnectionUsageDAO.getAllWaterConnectionUsage();

	}
	
	@Override
	public WaterConnectionUsage getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return waterConnectionUsageDAO.getDetails(rtiApplicationId);
	}
	
	@Override
	public WaterConnectionUsage merge(WaterConnectionUsage waterConnectionUsage) {
		// TODO Auto-generated method stub
		return waterConnectionUsageDAO.merge(waterConnectionUsage);
	}
	@Override

	public List<WaterProposedCategoryType> getProposedCategory()
	{
		return waterConnectionUsageDAO.getProposedCategory();
	}
}