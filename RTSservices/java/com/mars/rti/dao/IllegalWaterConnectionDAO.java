package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.IllegalWaterConnectionComplaint;

public interface IllegalWaterConnectionDAO {
	
	public void saveIllegalWaterConnection(IllegalWaterConnectionComplaint illegalWaterConnection);

	public long illegalWaterConnectionSave(IllegalWaterConnectionComplaint illegalWaterConnection);

	public IllegalWaterConnectionComplaint get(long rtiApplicationRefId);
	
	public List<IllegalWaterConnectionComplaint> getAllIllegalWaterConnection();

	public IllegalWaterConnectionComplaint getDetails(long rtiApplicationId);
	
	public IllegalWaterConnectionComplaint merge(IllegalWaterConnectionComplaint illegalWaterConnection);


}
