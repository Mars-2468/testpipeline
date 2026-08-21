package com.mars.rti.dao;

import com.mars.rti.model.TradeLicenceNew;


public interface TradeLicenceNewDAO {

	public void saveTradeLicenceNew(TradeLicenceNew tradeLicenceNew) ;
	public long getTradeLicenceId(TradeLicenceNew TradeLicenceNew);
	public TradeLicenceNew get(long rtiApplicationRefId);
	public TradeLicenceNew getDetails(long rtiApplicationId);

	
}
