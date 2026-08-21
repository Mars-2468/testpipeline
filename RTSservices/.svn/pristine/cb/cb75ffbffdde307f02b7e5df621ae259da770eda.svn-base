package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.WaterQualityComplaintDAO;
import com.mars.rti.model.WaterQualityComplaint;
import com.mars.rti.service.WaterQualityComplaintService;

@Service
public class WaterQualityComplaintServiceImpl implements WaterQualityComplaintService {

	@Autowired
	private WaterQualityComplaintDAO waterQualityComplaintDAO;

	@Override
	public void saveWaterQualityComplaintForm(WaterQualityComplaint waterQualityComplaint) {
		waterQualityComplaintDAO.saveWarterQualityComplaint(waterQualityComplaint);
		
	}

	@Override
	public long waterQualityComplaint(WaterQualityComplaint waterQualityComplaint) {
		return waterQualityComplaintDAO.waterQualityComplaintSave(waterQualityComplaint);

	}

	@Override
	public WaterQualityComplaint get(long rtiApplicationRefId) {
		return waterQualityComplaintDAO.get(rtiApplicationRefId);

	}

	@Override
	public List<WaterQualityComplaint> getAll() {
		return waterQualityComplaintDAO.getAll();
	}
	

	@Override
	public WaterQualityComplaint getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return waterQualityComplaintDAO.getDetails(rtiApplicationId);
	}

	@Override
	public WaterQualityComplaint merge(WaterQualityComplaint waterQualityComplaint) {
		// TODO Auto-generated method stub
		return waterQualityComplaintDAO.merge(waterQualityComplaint);
	}

}
