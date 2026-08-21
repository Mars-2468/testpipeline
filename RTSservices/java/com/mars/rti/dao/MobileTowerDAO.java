package com.mars.rti.dao;

import com.mars.rti.model.MobileTower;

public interface MobileTowerDAO {

	public void saveMobileTower(MobileTower mobilTower) ;
	public long mobileTowerSave(MobileTower mobileTower);
	public MobileTower get(long id);
	
}
