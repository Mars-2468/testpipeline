package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.PropertyTaxUtara;
@Transactional(readOnly = true)
public interface PropertyTaxUtaraService {
			
			@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
			public void savePropertyTaxUtara(PropertyTaxUtara propertyTaxUtara);
			
			@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
			public long propertyTaxUtara(PropertyTaxUtara propertyTaxUtara);
			
			@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
			public PropertyTaxUtara get(long rtiApplicationRefId);
			
			@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
			public PropertyTaxUtara getDetails(long rtiApplicationId);
			


	}
//@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
//public void savePropertyTaxUtara(PropertyTaxUtara propertyTaxUtara);
//
//@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
//public long propertyTaxUtara(PropertyTaxUtara propertyTaxUtara);
//
//@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
//public PropertyTaxUtara get(long rtiApplicationRefId);
