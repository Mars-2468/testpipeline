package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.MarriageProofAge;

@Transactional(readOnly = true)
public interface MarriageProofAgeRestService {

	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<MarriageProofAge> getall();
}
