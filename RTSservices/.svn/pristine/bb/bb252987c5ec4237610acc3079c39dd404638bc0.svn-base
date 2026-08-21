package com.mars.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.common.dao.DepartmentLevelDAO;
import com.mars.common.model.DepartmentLevel;
import com.mars.common.service.DepartmentLevelService;

@Service
public class DepartmentLevelServiceImpl implements DepartmentLevelService{

	@Autowired
	private DepartmentLevelDAO departmentLevelDAO;
	
	
	
	
	@Override
	public List<DepartmentLevel> getAll() {
		// TODO Auto-generated method stub
		return departmentLevelDAO.getAll();
	}

	@Override
	public DepartmentLevel getByName(String name) {
		// TODO Auto-generated method stub
		return departmentLevelDAO.getByName(name);
	}

}
