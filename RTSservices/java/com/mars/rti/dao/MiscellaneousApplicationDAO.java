package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.MisPurposeWithAmount;
import com.mars.rti.model.MiscellaneousApplication;

public interface MiscellaneousApplicationDAO {

	public MiscellaneousApplication saveMiscellaneousApplication(MiscellaneousApplication miscellaneousApplication) ;
	
	MiscellaneousApplication findById(Long miscId);
	public List<MisPurposeWithAmount> getPurposeWithAmount() ;

}
