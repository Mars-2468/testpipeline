package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FireFeesMasterUpdatedDAO;
import com.mars.rti.model.FireFeesMasterUpdated;
import com.mars.rti.service.FireFeesMasterUpdatedService;

@Service
public class FireFeesMasterUpdatedServiceImpl implements FireFeesMasterUpdatedService{

	@Autowired
	private FireFeesMasterUpdatedDAO fireFeesMasterUpdatedDAO; 
	
	
//	public FireRecommendationTypeOfBuildingDAO getFireRecommendationTypeOfBuildingDAO() {
//		return fireRecommendationTypeOfBuildingDAO;
//	}
//
//
//	public void setFireRecommendationTypeOfBuildingDAO(
//			FireRecommendationTypeOfBuildingDAO fireRecommendationTypeOfBuildingDAO) {
//		this.fireRecommendationTypeOfBuildingDAO = fireRecommendationTypeOfBuildingDAO;
//	}


	public List<FireFeesMasterUpdated> getFireFeesMasterUpdated(long typeOfBuilding,long typeOfConstruction,long typeOfHeight,long catagory,long floorName)
	{
		return fireFeesMasterUpdatedDAO.getFireFeesMasterUpdated(typeOfBuilding,typeOfConstruction,typeOfHeight,catagory,floorName);
	}
	public FireFeesMasterUpdated getList(long typeOfBuilding,long typeOfConstruction,long typeOfHeight,long catagory,long floorName)
	{
		return fireFeesMasterUpdatedDAO.getList(typeOfBuilding,typeOfConstruction,typeOfHeight,catagory,floorName);
	}
	
	
}
