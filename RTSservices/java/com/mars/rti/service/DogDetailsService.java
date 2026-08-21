package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.DogDetails;

@Transactional(readOnly = true)
public interface DogDetailsService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	   public void saveDogDetails(DogDetails dogDetails);
}
