package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.WaterConnectionUsage;
import com.mars.rti.model.WaterProposedCategoryType;
@Transactional(readOnly = true)
public interface WaterConnectionUsageService {
	
		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public void saveWaterConnectionUsage(WaterConnectionUsage waterConnectionUsage);
		
		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public long waterConnectionUsage(WaterConnectionUsage waterConnectionUsage);
		
		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public WaterConnectionUsage get(long rtiApplicationRefId);

		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public List<WaterConnectionUsage> getAllWaterConnectionUsage();

		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public WaterConnectionUsage getDetails(long rtiApplicationId);
		
		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public WaterConnectionUsage merge(WaterConnectionUsage waterConnectionUsage);

		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public List<WaterProposedCategoryType> getProposedCategory();
		


}