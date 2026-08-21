package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.WaterQualityComplaint;


public interface WaterQualityComplaintDAO {

	public void saveWarterQualityComplaint(WaterQualityComplaint waterQualityComplaint) ;
	public long waterQualityComplaintSave(WaterQualityComplaint waterQualityComplaint);
	public WaterQualityComplaint get(long id);
    public List<WaterQualityComplaint> getAll();
	public WaterQualityComplaint getDetails(long rtiApplicationId);
	public WaterQualityComplaint merge(WaterQualityComplaint waterQualityComplaint);
}

 