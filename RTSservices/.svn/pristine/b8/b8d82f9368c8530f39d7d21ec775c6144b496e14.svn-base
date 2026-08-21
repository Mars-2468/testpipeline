package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.FireFeesMasterUpdated;

public interface FireFeesMasterUpdatedService {


	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<FireFeesMasterUpdated> getFireFeesMasterUpdated(long typeOfBuilding,long typeOfConstruction,long typeOfHeight,long catagory,long floorName);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public FireFeesMasterUpdated getList(long typeOfBuilding,long typeOfConstruction,long typeOfHeight,long catagory,long floorName);
}
