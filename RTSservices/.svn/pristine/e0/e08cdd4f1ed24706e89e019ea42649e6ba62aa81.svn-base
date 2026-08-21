package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.MarriageOccupation;

@Transactional(readOnly = true)
public interface MarriageOccupationService {

	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<MarriageOccupation> getall();
	
}
