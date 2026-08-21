package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.GardenDetails;
import com.mars.rti.model.GardenFeedBacKDetails;

@Transactional(readOnly = true)
public interface GardenDetailsService {
	
	
	public  GardenDetails getGardenDetails(long zoneId ,long gardenId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public GardenFeedBacKDetails saveGardenFeedBack(GardenFeedBacKDetails gfd);
	

}
