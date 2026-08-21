package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.LayoutOfBuilding;


@Transactional(readOnly = true)
public interface LayoutOfBuildingService {
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void layoutRegistrationCertificateService(LayoutOfBuilding layOutOfBuilding);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long layoutOfBuilding(LayoutOfBuilding layOutOfBuilding);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public LayoutOfBuilding get(long rtiApplicationRefId);

}
