package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.PropertyTaxMutation;

@Transactional(readOnly = false)
public interface PropertyTaxMutationService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void savePrpertyTaxMutationForm(PropertyTaxMutation propertytaxMutation);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long propertyTaxMutation(PropertyTaxMutation propertytaxMutation);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxMutation get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxMutation getDetails(long rtiApplicationId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxMutation merge(PropertyTaxMutation propertytaxmutation);
	
}
