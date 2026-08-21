package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.WaterConnectionNoDue;

@Transactional(readOnly = true)
public interface WaterConnectionNoDueService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void waterConnectionSave(WaterConnectionNoDue waterConnectionNoDue);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long fetchWaterCertificate(WaterConnectionNoDue waterConnectionNoDue);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterConnectionNoDue get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public List<WaterConnectionNoDue> getAllWaterNoDueCertificate();
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterConnectionNoDue getDetails(long rtiApplicationId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterConnectionNoDue merge(WaterConnectionNoDue waterConnectionNoDue);
	
}
