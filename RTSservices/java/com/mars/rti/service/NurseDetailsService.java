package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.NurseDetails;


@Transactional(readOnly = true)
public interface NurseDetailsService {

	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NurseDetails mergeNurseDetails(NurseDetails sd);
	
	
	public NurseDetails getNurseDetails(long id);
}
