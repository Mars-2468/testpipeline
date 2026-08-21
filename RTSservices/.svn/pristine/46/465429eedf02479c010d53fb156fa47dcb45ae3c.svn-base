package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.PropertyTaxMutationDAO;
import com.mars.rti.model.PropertyTaxMutation;
import com.mars.rti.service.PropertyTaxMutationService;

@Service
public class PropertyTaxMutationServiceImpl implements PropertyTaxMutationService{

	@Autowired
	private PropertyTaxMutationDAO  propertyTaxMutationDAO;
	
	
	@Override
	public void savePrpertyTaxMutationForm(PropertyTaxMutation propertytaxMutation) {
		// TODO Auto-generated method stub
		propertyTaxMutationDAO.savePrpertyTaxMutationForm(propertytaxMutation);
	}

	@Override
	public long propertyTaxMutation(PropertyTaxMutation propertytaxMutation) {
		// TODO Auto-generated method stub
		return propertyTaxMutationDAO.propertyTaxMutation(propertytaxMutation);
	}

	@Override
	public PropertyTaxMutation get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return propertyTaxMutationDAO.get(rtiApplicationRefId);
	}

	@Override
	public PropertyTaxMutation getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return propertyTaxMutationDAO.getDeatils(rtiApplicationId);
	}

	@Override
	public PropertyTaxMutation merge(PropertyTaxMutation propertytaxmutation) {
		// TODO Auto-generated method stub
		return propertyTaxMutationDAO.merge(propertytaxmutation);
	}
	
	
}
