package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.PropertyTaxTransferRegistration;

@Transactional(readOnly = false)
public interface PropertyTaxTransferRegistrationService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void savePrpertyTransferRegistrationForm(PropertyTaxTransferRegistration propertyTransferRegistration);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long propertyTaxTransferRegistration(PropertyTaxTransferRegistration propertyTransferRegistration);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxTransferRegistration get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxTransferRegistration getDetails(long rtiApplicationId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxTransferRegistration merge(PropertyTaxTransferRegistration propertyTransferRegistration);
}
