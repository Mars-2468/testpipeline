package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.TradeLicencePartnerCountUpdate;
@Transactional(readOnly = true)
public interface TradeLicencePartnerCountUpdateService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTradeLicence(TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long getReferenceId(TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate);	
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicencePartnerCountUpdate get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicencePartnerCountUpdate getDetails(long rtiApplicationId);


	
	
}