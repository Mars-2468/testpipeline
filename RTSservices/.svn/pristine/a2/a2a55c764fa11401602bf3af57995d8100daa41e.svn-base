package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.IllegalWaterConnectionDAO;
import com.mars.rti.model.IllegalWaterConnectionComplaint;
import com.mars.rti.service.IllegalWaterConnectionService;
@Service
public class IllegalWaterConnectionServiceImpl implements IllegalWaterConnectionService{
	
	@Autowired
	private IllegalWaterConnectionDAO illegalWaterConnectionDAO;

	@Override
	public void saveIllegalWaterConnectionComplaint(IllegalWaterConnectionComplaint illegalWaterConnection) {
		illegalWaterConnectionDAO.illegalWaterConnectionSave(illegalWaterConnection);

	}

	@Override
	public long illegalWaterConnectionComplaint(IllegalWaterConnectionComplaint illegalWaterConnection) {
		return illegalWaterConnectionDAO.illegalWaterConnectionSave(illegalWaterConnection);
	}

	@Override
	public IllegalWaterConnectionComplaint get(long rtiApplicationRefId) {
		return illegalWaterConnectionDAO.get(rtiApplicationRefId);
	}

	@Override
	public List<IllegalWaterConnectionComplaint> getAllIllegalWaterConnection() {
		
		return illegalWaterConnectionDAO.getAllIllegalWaterConnection();
	}
	
	@Override
	public IllegalWaterConnectionComplaint getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return illegalWaterConnectionDAO.getDetails(rtiApplicationId);
	}
	@Override
	public IllegalWaterConnectionComplaint merge(IllegalWaterConnectionComplaint illegalWaterConnectionComplaint) {
		// TODO Auto-generated method stub
		return illegalWaterConnectionDAO.merge(illegalWaterConnectionComplaint);
	}


}
