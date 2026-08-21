package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.WaterDisconnection;

public interface WaterDisconnectionDAO {

	public void saveWaterDisconnection(WaterDisconnection waterDisconnection) ;
	public long waterDisconnectionSave(WaterDisconnection waterDisconnection);
	public WaterDisconnection get(long id);
	public List<WaterDisconnection> getAllWaterDisconnection();
	public WaterDisconnection getDetails(long rtiApplicationId);
	public WaterDisconnection merge(
			WaterDisconnection waterDisconnection);
}
