package com.mars.rti.dao;

import com.mars.rti.model.TradeLicenseDuplicateCopy;

public interface TradeLicenseDuplicateCopyDAO {
	
	public void saveTradeLicenseDuplicateCopy(TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy);
	public long tradeLicenseDuplicateCopySave(TradeLicenseDuplicateCopy tradeLicenseDuplicateCopy);
	public TradeLicenseDuplicateCopy get(long id);
	public TradeLicenseDuplicateCopy getDetails(long rtiApplicationId);


}
