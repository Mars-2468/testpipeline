package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.PropertyTaxExemption;

@Transactional(readOnly = true)
public interface TaxExmeptionService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTaxExemptionNonResidential(PropertyTaxExemption taxExemptionNonResidential);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long getReferenceId(PropertyTaxExemption taxExemptionNonResidential);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxExemption get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxExemption getDetails(long rtiApplicationId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public PropertyTaxExemption merge(PropertyTaxExemption propertyTaxExemption);

}
