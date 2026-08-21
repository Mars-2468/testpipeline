package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.WaterConnectionUsage;
import com.mars.rti.model.WaterProposedCategoryType;

public interface WaterConnectionUsageDAO {
	public void saveWaterConnectionUsage(WaterConnectionUsage waterConnectionUsage) ;
	public long waterConnectionUsageSave(WaterConnectionUsage waterConnectionUsage);
	public WaterConnectionUsage get(long id);
	public List<WaterConnectionUsage> getAllWaterConnectionUsage();
	public WaterConnectionUsage getDetails(long rtiApplicationId);
	public WaterConnectionUsage merge(WaterConnectionUsage waterConnectionUsage);
	public List<WaterProposedCategoryType> getProposedCategory();

}
