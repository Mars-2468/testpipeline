package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.FireFloorNameDAO;
import com.mars.rti.model.FireFloorName;
import com.mars.rti.service.FireFloorNameService;
@Service
public class FireFloorNameServiceImpl implements FireFloorNameService{
	@Autowired
	private FireFloorNameDAO fireFloorNameDAO;
	public List<FireFloorName> getFireFloorName()
	{
		return fireFloorNameDAO.getFireFloorName();
	}
	
	public List<FireFloorName> getList(long id)
	{
		return fireFloorNameDAO.getList(id);
	}
}
