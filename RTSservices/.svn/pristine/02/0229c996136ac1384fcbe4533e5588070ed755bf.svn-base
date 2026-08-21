package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.ZoneEsrDAO;
import com.mars.rti.model.ZoneEsr;
import com.mars.rti.service.ZoneEsrService;

@Service
public class ZoneEsrServiceImpl implements ZoneEsrService{

	
	@Autowired
	private ZoneEsrDAO zoneEsrDAO;
	
	@Override
	public List<ZoneEsr> getZoneWard(long zoneNo) {
		// TODO Auto-generated method stub
		return zoneEsrDAO.getall(zoneNo);
	}

}
