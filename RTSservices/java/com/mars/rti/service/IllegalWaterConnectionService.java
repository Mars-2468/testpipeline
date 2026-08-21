package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.IllegalWaterConnectionComplaint;

@Transactional(readOnly = true)
public interface IllegalWaterConnectionService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveIllegalWaterConnectionComplaint(IllegalWaterConnectionComplaint illegalWaterConnectionComplaint);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long illegalWaterConnectionComplaint(IllegalWaterConnectionComplaint illegalWaterConnectionComplaint);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public IllegalWaterConnectionComplaint get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<IllegalWaterConnectionComplaint> getAllIllegalWaterConnection();

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public IllegalWaterConnectionComplaint getDetails(long rtiApplicationId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public IllegalWaterConnectionComplaint merge(IllegalWaterConnectionComplaint illegalWaterConnectionComplaint);
	
	
}
