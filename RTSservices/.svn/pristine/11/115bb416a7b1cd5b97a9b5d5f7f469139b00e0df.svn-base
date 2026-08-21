package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FireSubDepartmentWiseLoginDAO;
import com.mars.rti.model.FireSubDepartmentWiseLogin;
import com.mars.rti.service.FireSubDepartmentWiseLoginService;

@Service
public class FireSubDepartmentWiseLoginServiceImpl implements FireSubDepartmentWiseLoginService {

	@Autowired
	private FireSubDepartmentWiseLoginDAO fireSubDepartmentWiseLoginDAO; 



	public List<FireSubDepartmentWiseLogin> getFireSubDepartmentWiseLogin()
	{
		return fireSubDepartmentWiseLoginDAO.getFireSubDepartmentWiseLogin();
	}
	public List<FireSubDepartmentWiseLogin> getList(long id)
	{
		return fireSubDepartmentWiseLoginDAO.getList(id);
	}
}
