package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.FireSubDepartmentWiseLogin;

public interface FireSubDepartmentWiseLoginService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<FireSubDepartmentWiseLogin> getFireSubDepartmentWiseLogin();
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<FireSubDepartmentWiseLogin> getList(long id);

}
