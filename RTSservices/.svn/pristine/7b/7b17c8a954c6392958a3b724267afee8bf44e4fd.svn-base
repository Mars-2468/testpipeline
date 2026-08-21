package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FireRecommendationTypeOfBuildingDAO;
import com.mars.rti.model.FireRecommendationTypeOfBuilding;
import com.mars.rti.service.FireRecommendationTypeOfBuildingService;

@Service
public class FireRecommendationTypeOfBuildingServiceImpl implements FireRecommendationTypeOfBuildingService {
	
	@Autowired
	private FireRecommendationTypeOfBuildingDAO fireRecommendationTypeOfBuildingDAO; 
	
	
	public FireRecommendationTypeOfBuildingDAO getFireRecommendationTypeOfBuildingDAO() {
		return fireRecommendationTypeOfBuildingDAO;
	}


	public void setFireRecommendationTypeOfBuildingDAO(
			FireRecommendationTypeOfBuildingDAO fireRecommendationTypeOfBuildingDAO) {
		this.fireRecommendationTypeOfBuildingDAO = fireRecommendationTypeOfBuildingDAO;
	}


	public List<FireRecommendationTypeOfBuilding> getTypeOfFireTypeOfBuilding()
	{
		return fireRecommendationTypeOfBuildingDAO.getTypeOfFireTypeOfBuilding();
	}


	@Override
	public FireRecommendationTypeOfBuilding get(long long1) {
		// TODO Auto-generated method stub
		return fireRecommendationTypeOfBuildingDAO.get(long1);
	}
	
}
