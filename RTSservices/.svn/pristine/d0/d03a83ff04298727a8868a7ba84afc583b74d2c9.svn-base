package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.PropertyTaxSefAssessment;

@Transactional(readOnly = true)
public interface PropertyTaxSelfAssessmentService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void savePropertyTaxSelfAssessment(PropertyTaxSefAssessment propertyTaxSelfAssessmentService);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long propertyTaxSelfAssessmentService(PropertyTaxSefAssessment propertyTaxSelfAssessmentService);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxSefAssessment get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxSefAssessment getDetails(long rtiApplicationId);
}
