package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.ConstructionOfBuilding;
@Transactional(readOnly = true)
public interface ConstructionOfBuildlingService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void buildRegistrationCertificate(ConstructionOfBuilding constructionOfBuilding);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long constructionOfBuilding(ConstructionOfBuilding constructionOfBuilding);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public ConstructionOfBuilding get(long rtiApplicationRefId);
}
