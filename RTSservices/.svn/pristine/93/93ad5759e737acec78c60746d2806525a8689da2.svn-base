package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.PropertyTaxDemandDAO;
import com.mars.rti.model.PropertyTaxDemand;
import com.mars.rti.service.PropertyTaxDemandService;

@Service
public class PropertyTaxDemandServiceImpl  implements PropertyTaxDemandService{

	@Autowired
	private PropertyTaxDemandDAO propertyTaxDemandDAO;

	@Override
	public void savePropertyTaxDemand(PropertyTaxDemand propertyTaxDemand) {
		propertyTaxDemandDAO.savePropertyTaxDemand(propertyTaxDemand);

	}

	@Override
	public long propertyTaxDemand(PropertyTaxDemand propertyTaxDemand) {
		return propertyTaxDemandDAO.propertyTaxDemandSave(propertyTaxDemand);
	}

	@Override
	public PropertyTaxDemand get(long rtiApplicationRefId) {
		return propertyTaxDemandDAO.get(rtiApplicationRefId);
	}

	@Override
	public PropertyTaxDemand getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return propertyTaxDemandDAO.getDetails(rtiApplicationId);
	}
}
