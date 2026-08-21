package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.FireTypeOfConstruction;

public interface FireTypeOfConstructionService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<FireTypeOfConstruction> getTypeOfConstruction();
	
	
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public FireTypeOfConstruction getTypeOfConstruction(long buildingConstructionId);
	
	
}
