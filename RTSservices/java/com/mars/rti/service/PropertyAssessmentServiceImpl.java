package com.mars.rti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.PropertyAssessmentDAO;
import com.mars.rti.model.PropertyAssessmentTrasScript;

@Service
public class PropertyAssessmentServiceImpl implements PropertyAssessmentService{
	
	@Autowired
	private PropertyAssessmentDAO propertyAssessmentDAO;

	@Override
	public void savePropertyAssessment(PropertyAssessmentTrasScript propertyAssessmentTrasScript) {
		propertyAssessmentDAO.savePropertyAssessment(propertyAssessmentTrasScript);

	}

	@Override
	public long propertyAssessment(PropertyAssessmentTrasScript propertyAssessmentTrasScript) {
		return propertyAssessmentDAO.propertyAssessmentSave(propertyAssessmentTrasScript);
	}

	@Override
	public PropertyAssessmentTrasScript get(long rtiApplicationRefId) {
		return propertyAssessmentDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public PropertyAssessmentTrasScript getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return propertyAssessmentDAO.getDetails(rtiApplicationId);
	}

	@Override
	public PropertyAssessmentTrasScript merge(PropertyAssessmentTrasScript propertyAssessmentTrasScript) {
		// TODO Auto-generated method stub
		return propertyAssessmentDAO.merge(propertyAssessmentTrasScript);
	}

}
