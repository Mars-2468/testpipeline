package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.WaterDisconnection;
@Transactional(readOnly = true)
public interface WaterDisconnectionService {
	
		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public void saveWaterDisconnection(WaterDisconnection waterDisconnection);
		
		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public long waterDisconnection(WaterDisconnection waterDisconnection);
		
		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public WaterDisconnection get(long rtiApplicationRefId);

		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public List<WaterDisconnection> getAllWaterDisconnection();
		
		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public WaterDisconnection getDetails(long rtiApplicationId);
		
		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public WaterDisconnection merge(WaterDisconnection waterDisconnection);
		

}