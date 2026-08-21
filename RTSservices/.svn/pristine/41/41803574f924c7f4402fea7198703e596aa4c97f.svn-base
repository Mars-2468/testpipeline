package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.TradeLicenceRenewal;

@Transactional(readOnly = true)
public interface TradeLicenceRenewalService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTradeLicence(TradeLicenceRenewal tradeLicenceRenewal);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long getReferenceId(TradeLicenceRenewal tradeLicenceRenewal);	
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenceRenewal get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenceRenewal getDetails(long rtiApplicationId);

	
}
