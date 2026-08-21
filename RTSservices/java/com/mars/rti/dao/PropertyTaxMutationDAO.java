package com.mars.rti.dao;

import com.mars.rti.model.PropertyTaxMutation;

public interface PropertyTaxMutationDAO {

	public void savePrpertyTaxMutationForm(PropertyTaxMutation propertytaxMutation);

	public long propertyTaxMutation(PropertyTaxMutation propertytaxMutation);

	public PropertyTaxMutation get(long rtiApplicationRefId);

	public PropertyTaxMutation getDeatils(long rtiApplicationId);

	public PropertyTaxMutation merge(PropertyTaxMutation propertytaxmutation);

	
}
