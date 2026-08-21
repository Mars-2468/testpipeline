package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.WaterMeterComplaintDAO;
import com.mars.rti.model.WaterMeterComplaint;
import com.mars.rti.service.WaterMeterComplaintService;

@Service
public class WaterMeterComplaintServiceImpl implements WaterMeterComplaintService{
	@Autowired
	private WaterMeterComplaintDAO waterMeterComplaintDAO;


	@Override
	public void saveWaterMeterComplaint(WaterMeterComplaint waterMeterComplaint) {
		waterMeterComplaintDAO.waterMeterComplaintSave(waterMeterComplaint);
		
	}

	@Override
	public long waterMeterComplaint(WaterMeterComplaint waterMeterComplaint) {
		// TODO Auto-generated method stub
		return waterMeterComplaintDAO.waterMeterComplaintSave(waterMeterComplaint);	}

	@Override
	public WaterMeterComplaint get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return waterMeterComplaintDAO.get(rtiApplicationRefId);
	}
	@Override
	public List<WaterMeterComplaint> getAllWaterMeterComplaint() {
		return waterMeterComplaintDAO.getAllWaterMeterComplaint();

	}
	@Override
	public WaterMeterComplaint getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return waterMeterComplaintDAO.getDetails(rtiApplicationId);
	}
	
	@Override
	public WaterMeterComplaint merge(
			WaterMeterComplaint waterMeterComplaint) {
		// TODO Auto-generated method stub
		return waterMeterComplaintDAO.merge(waterMeterComplaint);
	}


}
