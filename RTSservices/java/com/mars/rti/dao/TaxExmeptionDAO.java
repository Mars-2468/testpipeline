package com.mars.rti.dao;

import com.mars.rti.model.PropertyTaxExemption;

public interface TaxExmeptionDAO {

public void saveTaxExemptionNonResidential(PropertyTaxExemption taxExemptionNonResidential) ;
	
    public long getTaxExemptionNonResidentialId(PropertyTaxExemption taxExemptionNonResidential);
	
	public PropertyTaxExemption get(long rtiApplicationRefId);
	
	public PropertyTaxExemption getDetails(long rtiApplicationId);

	public PropertyTaxExemption merge(PropertyTaxExemption propertyTaxExemption);

}
