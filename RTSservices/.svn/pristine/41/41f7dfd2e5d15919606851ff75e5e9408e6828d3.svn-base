package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FireDepartmentWiseLoginDAO;
import com.mars.rti.model.FireDepartmentWiseLogin;
import com.mars.rti.service.FireDepartmentWiseLoginService;

@Service
public class FireDepartmentWiseLoginServiceImpl implements FireDepartmentWiseLoginService {

	@Autowired
	private FireDepartmentWiseLoginDAO fireDepartmentWiseLoginDAO; 



	public List<FireDepartmentWiseLogin> getFireDepartmentWiseLogin()
	{
		return fireDepartmentWiseLoginDAO.getFireDepartmentWiseLogin();
	}
	public List<FireDepartmentWiseLogin> getList(long id)
	{
		return fireDepartmentWiseLoginDAO.getList(id);
	}
	
}
