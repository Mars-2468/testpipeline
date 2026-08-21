package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.WaterQualityComplaint;
@Transactional(readOnly = true)
public interface WaterQualityComplaintService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveWaterQualityComplaintForm(WaterQualityComplaint waterQualityComplaint);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long waterQualityComplaint(WaterQualityComplaint waterQualityComplaint);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterQualityComplaint get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
    public List<WaterQualityComplaint> getAll();
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterQualityComplaint getDetails(long rtiApplicationId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public WaterQualityComplaint merge(WaterQualityComplaint waterQualityComplaint);
	

}