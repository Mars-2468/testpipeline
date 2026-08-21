package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.SubTypeOfbuildingDAO;
import com.mars.rti.model.SubTypeOfbuilding;
import com.mars.rti.service.SubTypeOfbuildingService;

@Service
public class SubTypeOfbuildingServiceImpl implements SubTypeOfbuildingService{

	@Autowired
	private SubTypeOfbuildingDAO subTypeOfbuildingDAO; 
	
	
//	public FireRecommendationTypeOfBuildingDAO getFireRecommendationTypeOfBuildingDAO() {
//		return fireRecommendationTypeOfBuildingDAO;
//	}
//
//
//	public void setFireRecommendationTypeOfBuildingDAO(
//			FireRecommendationTypeOfBuildingDAO fireRecommendationTypeOfBuildingDAO) {
//		this.fireRecommendationTypeOfBuildingDAO = fireRecommendationTypeOfBuildingDAO;
//	}


	public List<SubTypeOfbuilding> getSubTypeOfbuilding()
	{
		return subTypeOfbuildingDAO.getSubTypeOfbuilding();
	}
	public List<SubTypeOfbuilding> getList(long id)
	{
		return subTypeOfbuildingDAO.getList(id);
	}
	
	
}
