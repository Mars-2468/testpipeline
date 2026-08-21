package com.mars.rti.dao;


import java.util.List;

import com.mars.rti.model.WaterReconnection;

public interface WaterReconnectionDAO {

public void saveWaterReonnectionType(WaterReconnection waterReconnection) ;
	
    public long getWaterReconnectionId(WaterReconnection waterReconnection);
	
	public WaterReconnection get(long rtiApplicationRefId);
	
	public List<WaterReconnection> getAllWaterReconnection();
	public WaterReconnection getDetails(long rtiApplicationId);
	public WaterReconnection merge(
			WaterReconnection waterReconnection);
}
