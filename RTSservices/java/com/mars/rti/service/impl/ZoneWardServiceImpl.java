package com.mars.rti.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.ZoneWardDAO;
import com.mars.rti.model.ZoneWard;
import com.mars.rti.service.ZoneWardService;
@Service
public class ZoneWardServiceImpl implements ZoneWardService {
	
	@Autowired
	private ZoneWardDAO zoneWardDAO;

	@Override
	public List<ZoneWard> getZoneWard(String zoneNo) {
		return zoneWardDAO.getZoneWard(zoneNo);
	}

}