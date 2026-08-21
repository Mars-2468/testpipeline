package com.mars.rti.service;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.FireDepartmentWiseLogin;

public interface FireDepartmentWiseLoginService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<FireDepartmentWiseLogin> getFireDepartmentWiseLogin();
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<FireDepartmentWiseLogin> getList(long id);

}
