package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.NewlyConstructedPropertyDAO;
import com.mars.rti.model.NewlyConstructedProperty;
import com.mars.rti.service.NewlyConstructedPropertyService;

@Service
public class NewlyConstructedPropertyServiceImpl implements NewlyConstructedPropertyService {

	@Autowired
	private NewlyConstructedPropertyDAO newlyConstructedPropertyDAO;

	@Override
	public void saveNewlyConstructedProperty(NewlyConstructedProperty newlyConstructedProperty) {
		newlyConstructedPropertyDAO.saveNewlyConstructedProperty(newlyConstructedProperty);

	}

	@Override
	public long newlyConstructedProperty(NewlyConstructedProperty newlyConstructedProperty) {
		// TODO Auto-generated method stub
		return newlyConstructedPropertyDAO.newlyConstructedPropertySave(newlyConstructedProperty);
	}

	@Override
	public NewlyConstructedProperty get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return newlyConstructedPropertyDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public NewlyConstructedProperty getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return newlyConstructedPropertyDAO.getDetails(rtiApplicationId);
	}

	@Override
	public NewlyConstructedProperty merge(NewlyConstructedProperty newlyConstructedProperty) {
		// TODO Auto-generated method stub
		return newlyConstructedPropertyDAO.merge(newlyConstructedProperty);
	}
}
