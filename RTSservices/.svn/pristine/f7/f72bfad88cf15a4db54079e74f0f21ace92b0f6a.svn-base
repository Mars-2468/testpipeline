package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.TradeLicenseTypeChange;

@Transactional(readOnly = true)
public interface TradeLicenseTypeChangeService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTradeLicenseTypeChange(TradeLicenseTypeChange tradeLicenseTypeChange);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long tradeLicenseTypeChange(TradeLicenseTypeChange tradeLicenseTypeChange);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenseTypeChange get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenseTypeChange getDetails(long rtiApplicationId);


}
