package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FireTypeOfConstructionDAO;
import com.mars.rti.model.FireTypeOfConstruction;
import com.mars.rti.service.FireTypeOfConstructionService;

@Service
public class FireTypeOfConstructionServiceImpl implements FireTypeOfConstructionService{
	
	@Autowired
	private FireTypeOfConstructionDAO fireTypeOfConstructionDAO;

	public List<FireTypeOfConstruction> getTypeOfConstruction(){
	return fireTypeOfConstructionDAO.getTypeOfConstruction();
	}
	
	
	public FireTypeOfConstruction getTypeOfConstruction(long buildingConstructionId){
		return fireTypeOfConstructionDAO.getTypeOfConstruction(buildingConstructionId);
		}
}
