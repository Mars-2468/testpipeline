package com.mars.rti.dao;

import com.mars.rti.model.PropertyTaxTransferRegistration;

public interface PropertyTaxTransferRegistrationDAO {

	public void savePropertyTaxTransferRegistrationForm(PropertyTaxTransferRegistration propertyTaxTransferRegistration);

	public long PropertyTaxTransferRegistration(PropertyTaxTransferRegistration propertyTaxTransferRegistration);

	public PropertyTaxTransferRegistration get(long rtiApplicationRefId);

	public PropertyTaxTransferRegistration getDeatils(long rtiApplicationId);

	public PropertyTaxTransferRegistration merge(PropertyTaxTransferRegistration propertyTaxTransferRegistration);
}
