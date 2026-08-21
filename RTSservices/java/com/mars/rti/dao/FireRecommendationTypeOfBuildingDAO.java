package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.FireRecommendationTypeOfBuilding;

public interface FireRecommendationTypeOfBuildingDAO 
{
	public List<FireRecommendationTypeOfBuilding> getTypeOfFireTypeOfBuilding();

	public FireRecommendationTypeOfBuilding get(long id);
}
