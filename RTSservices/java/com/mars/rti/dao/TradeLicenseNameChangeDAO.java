package com.mars.rti.dao;
import com.mars.rti.model.TradeLicenseNameChange;

public interface TradeLicenseNameChangeDAO {
	
	public void saveTradeLicenseNameChange(TradeLicenseNameChange tradeLicenseNameChange);
	public long tradeLicenseNameChangeSave(TradeLicenseNameChange tradeLicenseNameChange);
	public TradeLicenseNameChange get(long id);
	public TradeLicenseNameChange getDetails(long rtiApplicationId);

}
