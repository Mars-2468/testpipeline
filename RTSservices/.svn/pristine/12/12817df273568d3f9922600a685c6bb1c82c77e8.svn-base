package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.GardenDetailsDAO;
import com.mars.rti.model.GardenDetails;
import com.mars.rti.model.GardenFeedBacKDetails;
import com.mars.rti.service.GardenDetailsService;

@Service
public class GardenDetailsServiceImpl implements GardenDetailsService{

	@Autowired
	private GardenDetailsDAO gardenDetialsDAO;
	
	@Override
	public GardenDetails getGardenDetails(long zoneId, long gardenId) {
		// TODO Auto-generated method stub
		return gardenDetialsDAO.getGardenDetails(zoneId,gardenId);
	}

	@Override
	public GardenFeedBacKDetails saveGardenFeedBack(GardenFeedBacKDetails gd) {
		// TODO Auto-generated method stub
		return gardenDetialsDAO.saveGardenFeedBack(gd);
	}

}
