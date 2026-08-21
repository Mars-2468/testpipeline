package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.TradeLicenceNew;

@Transactional(readOnly = true)
public interface TradeLicenceNewService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTradeLicenceNew(TradeLicenceNew tradeLicenceNew);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long getReferenceId(TradeLicenceNew tradeLicenceNew);	
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenceNew get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenceNew getDetails(long rtiApplicationId);


}
