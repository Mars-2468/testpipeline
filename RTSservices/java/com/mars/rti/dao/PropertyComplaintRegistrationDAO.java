package com.mars.rti.dao;

import com.mars.rti.model.PropertyComplaintRegistration;

public interface PropertyComplaintRegistrationDAO {

public void saveTaxExemptionNonResidential(PropertyComplaintRegistration taxExemptionNonResidential) ;
	
    public long getTaxExemptionNonResidentialId(PropertyComplaintRegistration taxExemptionNonResidential);
	
	public PropertyComplaintRegistration get(long rtiApplicationRefId);
	
	public PropertyComplaintRegistration getDetails(long rtiApplicationId);

	public PropertyComplaintRegistration merge(PropertyComplaintRegistration propertyComplaintRegistration);

}
