package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.TaxExemptionNonResidential;

@Transactional(readOnly = true)
public interface TaxExemptionNonResidentialService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTaxExemptionNonResidential(TaxExemptionNonResidential taxExemptionNonResidential);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long getReferenceId(TaxExemptionNonResidential taxExemptionNonResidential);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TaxExemptionNonResidential get(long rtiApplicationRefId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TaxExemptionNonResidential getDetails(long rtiApplicationId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TaxExemptionNonResidential merge(TaxExemptionNonResidential taxExemptionNonResidential);

}
