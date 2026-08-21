package com.mars.rti.dao;

import com.mars.rti.model.PropertyTaxUtara;

public interface PropertyTaxUtaraDAO {

	public void savePropertyTaxUtara(PropertyTaxUtara propertyTaxUtara) ;
	public long propertyTaxUtaraSave(PropertyTaxUtara propertyTaxUtara);
	public PropertyTaxUtara get(long id);
	public PropertyTaxUtara getDetails(long rtiApplicationId);

}
//public void savePropertyTaxUtara(PropertyTaxUtara propertyTaxUtara) ;
//public long propertyTaxUtaraSave(PropertyTaxUtara propertyTaxUtara);
//public PropertyTaxUtara get(long id);
