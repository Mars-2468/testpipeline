package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.TradeLicenseNameChange;

@Transactional(readOnly = true)
public interface TradeLicenseNameChangeService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTradeLicenseNameChange(TradeLicenseNameChange tradeLicenseNameChange);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long tradeLicenseNameChange(TradeLicenseNameChange tradeLicenseNameChange);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenseNameChange get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenseNameChange getDetails(long rtiApplicationId);


}
