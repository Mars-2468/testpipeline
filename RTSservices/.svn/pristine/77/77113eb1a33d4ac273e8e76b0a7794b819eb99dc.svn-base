package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.PropertyTaxNoDuesDAO;
import com.mars.rti.model.PropertyTaxNoDues;
import com.mars.rti.service.PropertyTaxNoDuesService;
//import com.mars.rti.model.PropertyTaxNoDues;
//import com.mars.rti.service.PropertyTaxNoDuesService;
@Service
public class PropertyTaxNoDuesServiceImpl implements PropertyTaxNoDuesService{
	
	@Autowired
	private PropertyTaxNoDuesDAO propertyTaxNoDuesDAO;


	@Override
	public void savePropertyTaxNoDues(PropertyTaxNoDues propertyTaxNoDues) {
		propertyTaxNoDuesDAO.propertyTaxNoDuesSave(propertyTaxNoDues);
		
	}

	@Override
	public long propertyTaxNoDues(PropertyTaxNoDues propertyTaxNoDues) {
		// TODO Auto-generated method stub
		return propertyTaxNoDuesDAO.propertyTaxNoDuesSave(propertyTaxNoDues);	}

	@Override
	public PropertyTaxNoDues get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return propertyTaxNoDuesDAO.get(rtiApplicationRefId);
	}
	@Override
	public PropertyTaxNoDues getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return propertyTaxNoDuesDAO.getDetails(rtiApplicationId);
	}

	@Override
	public PropertyTaxNoDues merge(PropertyTaxNoDues propertyTaxNoDues) {
		// TODO Auto-generated method stub
		return propertyTaxNoDuesDAO.merge(propertyTaxNoDues);
	}

}
