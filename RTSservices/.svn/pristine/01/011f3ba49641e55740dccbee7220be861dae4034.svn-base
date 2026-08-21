package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.WaterConnectionTypeChangeDAO;
import com.mars.rti.model.FireRecommendationTypeOfBuilding;
import com.mars.rti.model.WaterConnectionTypeChange;
import com.mars.rti.model.WaterProposedTapSize;
import com.mars.rti.service.WaterConnectionTypeChangeService;

@Service
public class WaterConnectionTypeChangeServiceImpl implements WaterConnectionTypeChangeService {

	@Autowired
	private WaterConnectionTypeChangeDAO waterConnectionTypeChangeDAO;

	
	@Override
	public void saveWaterConnectionType(WaterConnectionTypeChange waterConnectionTypeChange) {
		waterConnectionTypeChangeDAO.saveWaterConnectionType(waterConnectionTypeChange);
		
	}


	@Override
	public long getReferenceId(WaterConnectionTypeChange waterConnectionTypeChange) {
		return waterConnectionTypeChangeDAO.getWaterConnectionTypeChangeId(waterConnectionTypeChange);
	}


	@Override
	public WaterConnectionTypeChange get(long rtiApplicationRefId) {
		return waterConnectionTypeChangeDAO.get(rtiApplicationRefId);
	}


	@Override
	public List<WaterConnectionTypeChange> getAllWaterConnectionType() {
		
		return waterConnectionTypeChangeDAO.getAllWaterConnectionType();
	}

	@Override
	public WaterConnectionTypeChange getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return waterConnectionTypeChangeDAO.getDetails(rtiApplicationId);
	}
	
	@Override
	public WaterConnectionTypeChange merge(WaterConnectionTypeChange waterConnectionTypeChange) {
		// TODO Auto-generated method stub
		return waterConnectionTypeChangeDAO.merge(waterConnectionTypeChange);
	}
	
	public List<WaterProposedTapSize> getProposedTapSize()
	{
		return waterConnectionTypeChangeDAO.getProposedTapSize();
	}

}
