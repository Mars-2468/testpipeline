package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.PropertyTaxDemand;

@Transactional(readOnly = true)
public interface PropertyTaxDemandService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void savePropertyTaxDemand(PropertyTaxDemand propertyTaxDemand);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long propertyTaxDemand(PropertyTaxDemand propertyTaxDemand);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxDemand get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxDemand getDetails(long rtiApplicationId);
	


}

