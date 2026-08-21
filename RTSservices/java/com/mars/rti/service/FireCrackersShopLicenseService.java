package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.FireCrackersShopLicense;

@Transactional(readOnly = true)
public interface FireCrackersShopLicenseService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveFireCrackersShopLicense(FireCrackersShopLicense fireCrackersShopLicense) ;
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long fireCrackersShopLicenseSave(FireCrackersShopLicense fireCrackersShopLicense);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public FireCrackersShopLicense get(long id);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public FireCrackersShopLicense merge(FireCrackersShopLicense fireCrackersShopLicense);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public FireCrackersShopLicense getDetails(long rtiApplicationId);
	
}
