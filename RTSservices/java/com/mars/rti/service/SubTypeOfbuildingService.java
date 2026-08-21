package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.SubTypeOfbuilding;

public interface SubTypeOfbuildingService {


	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<SubTypeOfbuilding> getSubTypeOfbuilding();
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<SubTypeOfbuilding> getList(long id);
}
