package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.TradeLicenseCancellation;

@Transactional(readOnly = true)
public interface TradeLicenseCancellationService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTradeLicenseCancel(TradeLicenseCancellation tradeLicenseCancellation);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long tradeLicenseCancellation(TradeLicenseCancellation tradeLicenseCancellation);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenseCancellation get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenseCancellation getDetails(long rtiApplicationId);


}
