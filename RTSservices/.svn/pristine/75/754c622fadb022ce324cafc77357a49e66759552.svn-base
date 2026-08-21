package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.TradeLicenseTransfer;
import com.mars.rti.model.TradeTypes;
import com.mars.rti.model.WaterConnectionPurpose;


@Transactional(readOnly = true)
public interface TradeLicenseTransferService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTradeLicenseTransfer(TradeLicenseTransfer tradeLicenseTransfer);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long tradeLicenseTransfer(TradeLicenseTransfer tradeLicenseTransfer);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenseTransfer get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TradeLicenseTransfer getDetails(long rtiApplicationId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<TradeTypes> gettradeTypes() ;

	

}
