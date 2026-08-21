package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.WaterConnectionNoDue;

public interface WaterConnectionNoDueDAO {
	
	public void saveWaterConnection(WaterConnectionNoDue waterConnectionNoDue);
	
	public long getWaterCertificate(WaterConnectionNoDue waterConnectionNoDue);
	public WaterConnectionNoDue get(long id);

    public List<WaterConnectionNoDue> getAllWaterNoDueCertificate();
	public WaterConnectionNoDue getDetails(long rtiApplicationId);
	public WaterConnectionNoDue merge(WaterConnectionNoDue waterConnectionNoDue);


}
