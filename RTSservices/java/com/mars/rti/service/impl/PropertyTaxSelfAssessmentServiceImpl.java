package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.PropertyTaxSelfAssessmentDAO;
import com.mars.rti.model.PropertyTaxSefAssessment;
import com.mars.rti.service.PropertyTaxSelfAssessmentService;

@Service
public class PropertyTaxSelfAssessmentServiceImpl implements PropertyTaxSelfAssessmentService{

		
	@Autowired
	private PropertyTaxSelfAssessmentDAO propertyTaxSelfAssessmentDAO;
	
	@Override
	public void savePropertyTaxSelfAssessment(PropertyTaxSefAssessment propertyTaxSelfAssessmentService) {
		// TODO Auto-generated method stub
		propertyTaxSelfAssessmentDAO.savePropertyTaxSelfAssessment(propertyTaxSelfAssessmentService);
	}

	@Override
	public long propertyTaxSelfAssessmentService(PropertyTaxSefAssessment propertyTaxSelfAssessmentService) {
		// TODO Auto-generated method stub
		return propertyTaxSelfAssessmentDAO.propertyTaxSelfAssessmentSave(propertyTaxSelfAssessmentService);
	}

	@Override
	public PropertyTaxSefAssessment get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return propertyTaxSelfAssessmentDAO.get(rtiApplicationRefId);
	}

	@Override
	public PropertyTaxSefAssessment getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return propertyTaxSelfAssessmentDAO.getDetails(rtiApplicationId);
	}

	
}
