package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.MarriageStatus;

@Transactional(readOnly = true)
public interface MarriageStatusService {

	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<MarriageStatus> getall();
	
}
