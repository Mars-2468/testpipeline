package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.WaterMeterComplaint;
@Transactional(readOnly = true)
public interface WaterMeterComplaintService {

			@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
			public void saveWaterMeterComplaint(WaterMeterComplaint waterMeterComplaint);
			
			@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
			public long waterMeterComplaint(WaterMeterComplaint waterMeterComplaint);
			
			@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
			public WaterMeterComplaint get(long rtiApplicationRefId);

			@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
			public List<WaterMeterComplaint> getAllWaterMeterComplaint();
			
			@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
			public WaterMeterComplaint getDetails(long rtiApplicationId);
			
			@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
			public WaterMeterComplaint merge(WaterMeterComplaint waterMeterComplaint);
			


}
