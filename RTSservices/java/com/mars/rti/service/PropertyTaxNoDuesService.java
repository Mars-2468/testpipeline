package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.PropertyTaxNoDues;
//import com.mars.rti.model.PropertyTaxNoDues;

@Transactional(readOnly = true)
public interface PropertyTaxNoDuesService {
	
				
				@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
				public void savePropertyTaxNoDues(PropertyTaxNoDues propertyTaxNoDues);
				
				@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
				public long propertyTaxNoDues(PropertyTaxNoDues propertyTaxNoDues);
				
				@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
				public PropertyTaxNoDues get(long rtiApplicationRefId);
				
				@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
				public PropertyTaxNoDues getDetails(long rtiApplicationId);

				@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
				public PropertyTaxNoDues merge(PropertyTaxNoDues propertyTaxNoDues);
				


}
