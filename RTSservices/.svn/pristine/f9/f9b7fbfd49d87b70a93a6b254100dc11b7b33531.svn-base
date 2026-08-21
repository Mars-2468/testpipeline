package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.PropertyComplaintRegistration;

@Transactional(readOnly = true)
public interface PropertyTaxComplaintService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTaxExemptionNonResidential(PropertyComplaintRegistration taxExemptionNonResidential);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long getReferenceId(PropertyComplaintRegistration taxExemptionNonResidential);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyComplaintRegistration get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyComplaintRegistration getDetails(long rtiApplicationId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyComplaintRegistration merge(PropertyComplaintRegistration propertyComplaintRegistration);

}

