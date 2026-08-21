package com.mars.rti.dao;

import com.mars.rti.model.TradeLicencePartnerCountUpdate;


public interface TradeLicencePartnerCountUpdateDAO {

	public void saveTradeLicence(TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate) ;
	public long getTradeLicenceId(TradeLicencePartnerCountUpdate tradeLicencePartnerCountUpdate);
	public TradeLicencePartnerCountUpdate get(long rtiApplicationRefId);
	public TradeLicencePartnerCountUpdate getDetails(long rtiApplicationId);

	
}
