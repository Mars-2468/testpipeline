package com.mars.rti.dao;


import java.util.List;

import com.mars.rti.model.WaterPressure;

public interface WaterPressureDAO {

public void saveWaterConnectionPressure(WaterPressure waterPressure) ;
	
	
	public WaterPressure get(long rtiApplicationRefId);
	
	public List<WaterPressure> getAllWaterPressureComplaint();
	
	public long waterPressureSave(WaterPressure waterPressure);
	
	public WaterPressure getDetails(long rtiApplicationId);

	public WaterPressure merge(
			WaterPressure waterPressure);

}
