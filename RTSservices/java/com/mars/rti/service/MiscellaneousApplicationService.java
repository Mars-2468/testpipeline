package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.MisPurposeWithAmount;
import com.mars.rti.model.MiscellaneousApplication;

@Transactional
public interface MiscellaneousApplicationService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public MiscellaneousApplication saveMiscellaneousApplication(MiscellaneousApplication miscellaneousApplication);

	MiscellaneousApplication findById(Long miscId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<MisPurposeWithAmount> getPurposeWithAmount();

}
