package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.PropertyTaxTransferRegistrationDAO;
import com.mars.rti.model.PropertyTaxTransferRegistration;
import com.mars.rti.service.PropertyTaxTransferRegistrationService;

@Service
public class PropertyTaxTransferRegistrationServiceImpl implements PropertyTaxTransferRegistrationService{

	@Autowired
	private PropertyTaxTransferRegistrationDAO propertyTaxTransferRegistrationDAO;
	@Override
	public void savePrpertyTransferRegistrationForm(PropertyTaxTransferRegistration propertyTransferRegistration) {
		propertyTaxTransferRegistrationDAO.savePropertyTaxTransferRegistrationForm(propertyTransferRegistration);
		
	}

	@Override
	public long propertyTaxTransferRegistration(PropertyTaxTransferRegistration propertyTransferRegistration) {
		// TODO Auto-generated method stub
		return propertyTaxTransferRegistrationDAO.PropertyTaxTransferRegistration(propertyTransferRegistration);
	}

	@Override
	public PropertyTaxTransferRegistration get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return propertyTaxTransferRegistrationDAO.get(rtiApplicationRefId);
	}

	@Override
	public PropertyTaxTransferRegistration getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return propertyTaxTransferRegistrationDAO.getDeatils(rtiApplicationId);
	}

	@Override
	public PropertyTaxTransferRegistration merge(PropertyTaxTransferRegistration propertyTransferRegistration) {
		// TODO Auto-generated method stub
		return propertyTaxTransferRegistrationDAO.merge(propertyTransferRegistration);
	}

}
