package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.TradeLicenseTransfer;
import com.mars.rti.model.TradeTypes;

public interface TradeLicenseTransferDAO {
	public void saveTradeLicenseTransfer(TradeLicenseTransfer tradeLicenseTransfer) ;
	public long tradeLicenseTransferSave(TradeLicenseTransfer tradeLicenseTransfer);
	public TradeLicenseTransfer get(long id);
	public TradeLicenseTransfer getDetails(long rtiApplicationId);
	public List<TradeTypes> gettradeTypes();

}
