package com.mars.rti.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.PartMapDAO;
import com.mars.rti.model.PartMap;
import com.mars.rti.service.PartMapService;
@Service
public class PartMapServiceImpl implements PartMapService{


	@Autowired
	private PartMapDAO partMapDAO;

	@Override
	public void savePartMapForm(PartMap partmap) {
		partMapDAO.savePartMap(partmap);

	}

	@Override
	public long partMap(PartMap partmap) {
		// TODO Auto-generated method stub
		return partMapDAO.partMapSave(partmap);
	}

	@Override
	public PartMap get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return partMapDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public PartMap getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return partMapDAO.getDetails(rtiApplicationId);
	}

}
