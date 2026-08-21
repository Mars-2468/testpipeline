package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.PropertyAssessmentTrasScript;

@Transactional(readOnly = true)
public interface PropertyAssessmentService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void savePropertyAssessment(PropertyAssessmentTrasScript propertyAssessmentTrasScript);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long propertyAssessment(PropertyAssessmentTrasScript propertyAssessmentTrasScript);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyAssessmentTrasScript get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyAssessmentTrasScript getDetails(long rtiApplicationId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyAssessmentTrasScript merge(PropertyAssessmentTrasScript propertyAssessmentTrasScript);
	

}
