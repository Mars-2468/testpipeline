package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.WaterConnectionTypeChange;
import com.mars.rti.model.WaterProposedTapSize;



@Transactional(readOnly = true)
public interface WaterConnectionTypeChangeService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveWaterConnectionType(WaterConnectionTypeChange waterConnectionTypeChange);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long getReferenceId(WaterConnectionTypeChange waterConnectionTypeChange);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterConnectionTypeChange get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<WaterConnectionTypeChange> getAllWaterConnectionType();

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterConnectionTypeChange getDetails(long rtiApplicationId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterConnectionTypeChange merge(WaterConnectionTypeChange waterConnectionTypeChange);
	

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<WaterProposedTapSize> getProposedTapSize();

	
}
