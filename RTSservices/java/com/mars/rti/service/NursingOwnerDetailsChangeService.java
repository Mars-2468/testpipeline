package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.NursingOwnerDetailsChange;


@Transactional(readOnly = true)
public interface NursingOwnerDetailsChangeService {

	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NursingOwnerDetailsChange mergeownerDetails(NursingOwnerDetailsChange sd);
	
	
	public NursingOwnerDetailsChange getOwnerDetails(long id);
}
