package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.NewWaterConnectionDAO;
import com.mars.rti.model.NewWaterConnection;
import com.mars.rti.model.WaterConnectionPurpose;
import com.mars.rti.service.NewWaterConnectionService;

@Service
public class NewWaterConnectionServiceImpl implements NewWaterConnectionService {

	@Autowired
	private NewWaterConnectionDAO newWaterConnectionDAO;

	@Override
	public void saveNewWaterConnectionForm(NewWaterConnection newWaterConnection) {
		newWaterConnectionDAO.saveNewWaterConnection(newWaterConnection);
		
	}

	@Override
	public long newWaterConnection(NewWaterConnection newWaterConnection) {
		return newWaterConnectionDAO.newWaterConnectionSave(newWaterConnection);

	}

	@Override
	public NewWaterConnection get(long rtiApplicationRefId) {
		return newWaterConnectionDAO.get(rtiApplicationRefId);

	}

	@Override
	public List<NewWaterConnection> getAllNewWaterConnection() {
		return newWaterConnectionDAO.getAllNewWaterConnection();

	}

	@Override
	public NewWaterConnection getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return newWaterConnectionDAO.getDetails(rtiApplicationId);
	}
	
	@Override
	public NewWaterConnection merge(NewWaterConnection newWaterConnection) {
		return newWaterConnectionDAO.merge(newWaterConnection);

	}
	
	@Override
	public List<WaterConnectionPurpose> getWaterConnectionPurpose(){
		return newWaterConnectionDAO.getWaterConnectionPurpose();

	
	}



	
}