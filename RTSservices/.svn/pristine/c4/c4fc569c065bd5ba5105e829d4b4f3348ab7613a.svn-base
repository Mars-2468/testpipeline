package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.MarriageLaw;

@Transactional(readOnly = true)
public interface MarriageLawRestService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<MarriageLaw> getall();
}
