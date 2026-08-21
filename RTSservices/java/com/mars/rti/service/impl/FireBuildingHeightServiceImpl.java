package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FireBuildingHeightDAO;
import com.mars.rti.model.FireBuildingHeight;
import com.mars.rti.service.FireBuildingHeightService;

@Service
public class FireBuildingHeightServiceImpl implements FireBuildingHeightService{

	@Autowired
	private FireBuildingHeightDAO fireBuildingHeightDAO;
	
	public List<FireBuildingHeight> getTypeOfBuildinhHeight()
	{
		return fireBuildingHeightDAO.getTypeOfBuildinhHeight();
	}
}
