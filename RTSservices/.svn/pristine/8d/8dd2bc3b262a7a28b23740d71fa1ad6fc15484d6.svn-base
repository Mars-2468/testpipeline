package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.CitizenZoneDAO;
import com.mars.rti.model.CitizenZone;
import com.mars.rti.service.CitizenZoneService;

@Service
public class CitizenZoneServiceImpl implements CitizenZoneService{
	@Autowired
	private CitizenZoneDAO citizenZoneDAO;
	
	@Override
	public List<CitizenZone> getzones() {
		return citizenZoneDAO.getZones();
	}
}
