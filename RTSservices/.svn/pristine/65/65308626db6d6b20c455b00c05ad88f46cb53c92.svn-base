package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.TradeLicencePartnerChange;


@Transactional(readOnly = true)
public interface TradeLicencePartnerChangeService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTradeLicence(TradeLicencePartnerChange tradeLicencePartnerChange);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long getReferenceId(TradeLicencePartnerChange tradeLicencePartnerChange);	
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicencePartnerChange get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicencePartnerChange getDetails(long rtiApplicationId);

	
	
}
