package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.WaterPressure;

@Transactional(readOnly = true)
public interface WaterPressureService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveWaterConnectionType(WaterPressure waterPressure);

	

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterPressure get(long rtiApplicationRefId);	
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public List<WaterPressure> getAllWaterPressureComplaint();

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long waterPressure(WaterPressure waterPressure);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterPressure getDetails(long rtiApplicationId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterPressure merge(WaterPressure waterPressure);
	

	
}
