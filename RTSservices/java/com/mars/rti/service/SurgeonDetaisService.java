package com.mars.rti.service;


import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.SurgeonsDetails;

@Transactional(readOnly = true)
public interface SurgeonDetaisService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public SurgeonsDetails mergeSurgeonDetails(SurgeonsDetails sd);
	
	
	public SurgeonsDetails getSurgeonDetails(long id);
}
