package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.NursingOwnerDetails;

public interface NursingOwnerDetailsService {

	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NursingOwnerDetails mergeNurseOwnerDetails(NursingOwnerDetails sd);
	
	
	public NursingOwnerDetails getNurseOwnerDetails(long id);
}
