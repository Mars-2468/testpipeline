package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.FireDetails;

public interface FireDetailsService {
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	   public void saveFireDetails(FireDetails fireDetails);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	   public List<FireDetails> getFireDetails(long id);
	
	public void delete(long id);
}
