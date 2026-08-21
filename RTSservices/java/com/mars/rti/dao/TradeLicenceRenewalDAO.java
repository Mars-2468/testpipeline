package com.mars.rti.dao;

import com.mars.rti.model.TradeLicenceRenewal;



public interface TradeLicenceRenewalDAO {
	
	public void saveTradeLicence(TradeLicenceRenewal tradeLicenceRenewal) ;
	public long getTradeLicenceId(TradeLicenceRenewal tradeLicenceRenewal);
	public TradeLicenceRenewal get(long rtiApplicationRefId);
	public TradeLicenceRenewal getDetails(long rtiApplicationId);

}
