package com.mars.rti.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.ConstructionOfBuildingDAO;
import com.mars.rti.model.ConstructionOfBuilding;
import com.mars.rti.service.ConstructionOfBuildlingService;

@Service
public class ConstructionOfBuildlingServiceImpl implements ConstructionOfBuildlingService {
	
	private static final Log log =LogFactory.getLog(ConstructionOfBuildlingServiceImpl.class);
	
	@Autowired
	private ConstructionOfBuildingDAO constructionOfBuildlingDAO;

	@Override
	public void buildRegistrationCertificate(ConstructionOfBuilding constructionOfBuilding) {
		constructionOfBuildlingDAO.buildingRegistrationCerfificate(constructionOfBuilding);
	}

	@Override
	public long constructionOfBuilding(ConstructionOfBuilding constructionOfBuilding) {
		// TODO Auto-generated method stub
		return constructionOfBuildlingDAO.constructionOfBuildingSave(constructionOfBuilding);
	}

	@Override
	public ConstructionOfBuilding get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return constructionOfBuildlingDAO.get(rtiApplicationRefId);
	}
}
