package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.FireSubDepartmentWiseLogin;

public interface FireSubDepartmentWiseLoginDAO {

	public List<FireSubDepartmentWiseLogin> getFireSubDepartmentWiseLogin();
	
	public List<FireSubDepartmentWiseLogin> getList(long id);

}
