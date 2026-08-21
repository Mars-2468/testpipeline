package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.TradeLicenseOutdatedRenewalNotice;

@Transactional(readOnly = true)
public interface TradeLicenseOutdatedRenewalService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTradeLicenseOutdatedRenewal(TradeLicenseOutdatedRenewalNotice tradeLicenseOutdatedRenewalNotice);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long tradeLicenseOutdatedRenewal(TradeLicenseOutdatedRenewalNotice tradeLicenseOutdatedRenewalNotice);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenseOutdatedRenewalNotice get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenseOutdatedRenewalNotice getDetails(long rtiApplicationId);


	

}
