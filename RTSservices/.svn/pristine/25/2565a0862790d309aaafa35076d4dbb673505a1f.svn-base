package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.TradeLicenseDuplicateCopy;


@Transactional(readOnly = true)
public interface TradeLicenseDuplicateCopyService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTradeLicenseDuplicateCopy(TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long tradeLicenseDuplicateCopy(TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenseDuplicateCopy get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenseDuplicateCopy getDetails(long rtiApplicationId);


}
