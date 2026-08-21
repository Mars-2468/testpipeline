package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.NOCOfTrade;


@Transactional(readOnly = true)
public interface NOCOfTradeService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveNOCOfTrade(NOCOfTrade nocTrade);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long nocTrade(NOCOfTrade nocTrade);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NOCOfTrade get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NOCOfTrade getDetails(long rtiApplicationId);


}
