package com.mars.rti.dao;

import com.mars.rti.model.TaxExemptionNonResidential;


public interface TaxExemptionNonResidentialDAO {

public void saveTaxExemptionNonResidential(TaxExemptionNonResidential taxExemptionNonResidential) ;
	
    public long getTaxExemptionNonResidentialId(TaxExemptionNonResidential taxExemptionNonResidential);
	
	public TaxExemptionNonResidential get(long rtiApplicationRefId);
	
	public TaxExemptionNonResidential getDetails(long rtiApplicationId);

	public TaxExemptionNonResidential merge(TaxExemptionNonResidential taxExemptionNonResidential);

}
