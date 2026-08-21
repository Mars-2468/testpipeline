package com.mars.rti.dao;

import com.mars.rti.model.GardenDetails;
import com.mars.rti.model.GardenFeedBacKDetails;

public interface GardenDetailsDAO {

	public  GardenDetails getGardenDetails(long zoneId ,long gardenId);
	
	public GardenFeedBacKDetails saveGardenFeedBack(GardenFeedBacKDetails gfd);
}
