package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.WaterReconnection;

@Transactional(readOnly = true)
public interface WaterReconnectionService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveWaterReconnection(WaterReconnection waterReconnection);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long getReferenceId(WaterReconnection waterReconnection);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterReconnection get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<WaterReconnection> getAllwaterReconnection();
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterReconnection getDetails(long rtiApplicationId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterReconnection merge(WaterReconnection waterReconnection);
	

}
