package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FireFloorTypesDAO;
import com.mars.rti.model.FireFloorTypes;
import com.mars.rti.service.FireFloorTypesService;

@Service
public class FireFloorTypesServiceImpl implements FireFloorTypesService{

	@Autowired
	private FireFloorTypesDAO fireFloorTypesDAO; 
	
	
//	public FireRecommendationTypeOfBuildingDAO getFireRecommendationTypeOfBuildingDAO() {
//		return fireRecommendationTypeOfBuildingDAO;
//	}
//
//
//	public void setFireRecommendationTypeOfBuildingDAO(
//			FireRecommendationTypeOfBuildingDAO fireRecommendationTypeOfBuildingDAO) {
//		this.fireRecommendationTypeOfBuildingDAO = fireRecommendationTypeOfBuildingDAO;
//	}


	public List<FireFloorTypes> getFireFloorTypes()
	{
		return fireFloorTypesDAO.getFireFloorTypes();
	}
	public List<FireFloorTypes> getList(long id)
	{
		return fireFloorTypesDAO.getList(id);
	}
	
	
}
