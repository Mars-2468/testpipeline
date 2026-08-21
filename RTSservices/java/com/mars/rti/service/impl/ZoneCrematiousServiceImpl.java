package com.mars.rti.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.ZoneCrematiousDAO;
import com.mars.rti.model.ZoneCrematious;
import com.mars.rti.service.ZoneCrematiousService;

@Service
public class ZoneCrematiousServiceImpl implements ZoneCrematiousService {
	
	@Autowired
	private ZoneCrematiousDAO zoneCrematiousDAO;
	
	@Override
	public List<ZoneCrematious> getAllZoneCrematiousList(Integer zoneNo)
	{
		return zoneCrematiousDAO.getAllZoneCrematiousList(zoneNo);

	}

}
