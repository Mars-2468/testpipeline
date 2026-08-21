package com.mars.rti.dao;

import com.mars.rti.model.TradeLicenseTypeChange;

public interface TradeLicenseTypeChangeDAO {
	
	public void saveTradeLicenseTypeChange(TradeLicenseTypeChange tradeLicenseTypeChange);
	public long tradeLicenseTypeChangeSave(TradeLicenseTypeChange tradeLicenseTypeChange);
	public TradeLicenseTypeChange get(long id);
	public TradeLicenseTypeChange getDetails(long rtiApplicationId);

}
