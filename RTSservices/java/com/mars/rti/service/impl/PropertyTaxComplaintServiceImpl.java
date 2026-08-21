package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.PropertyComplaintRegistrationDAO;
import com.mars.rti.model.PropertyComplaintRegistration;
import com.mars.rti.service.PropertyTaxComplaintService;

@Service
public class PropertyTaxComplaintServiceImpl implements PropertyTaxComplaintService{

	@Autowired
	private PropertyComplaintRegistrationDAO taxExemptionNonResidentialDAO;
	
	
	@Override
	public void saveTaxExemptionNonResidential(PropertyComplaintRegistration taxExemptionNonResidential) {
		taxExemptionNonResidentialDAO.saveTaxExemptionNonResidential(taxExemptionNonResidential);
		
	}

	@Override
	public long getReferenceId(PropertyComplaintRegistration taxExemptionNonResidential) {
		return taxExemptionNonResidentialDAO.getTaxExemptionNonResidentialId(taxExemptionNonResidential);
	}

	@Override
	public PropertyComplaintRegistration get(long rtiApplicationRefId) {
		return taxExemptionNonResidentialDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public PropertyComplaintRegistration getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return taxExemptionNonResidentialDAO.getDetails(rtiApplicationId);
	}

	@Override
	public PropertyComplaintRegistration merge(PropertyComplaintRegistration propertyComplaintRegistration) {
		// TODO Auto-generated method stub
		return taxExemptionNonResidentialDAO.merge(propertyComplaintRegistration);
	}

	
}
