package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.PropertyTaxUtaraDAO;
import com.mars.rti.model.PropertyTaxUtara;
import com.mars.rti.service.PropertyTaxUtaraService;
//import com.mars.rti.dao.PropertyTaxUtaraDAO;
//import com.mars.rti.model.PropertyTaxUtara;
//import com.mars.rti.service.PropertyTaxUtaraService;
@Service
public class PropertyTaxUtaraServiceImpl implements PropertyTaxUtaraService{
	
		@Autowired
		private PropertyTaxUtaraDAO propertyTaxUtaraDAO;


		@Override
		public void savePropertyTaxUtara(PropertyTaxUtara propertyTaxUtara) {
			propertyTaxUtaraDAO.propertyTaxUtaraSave(propertyTaxUtara);
			
		}

		@Override
		public long propertyTaxUtara(PropertyTaxUtara propertyTaxUtara) {
			// TODO Auto-generated method stub
			return propertyTaxUtaraDAO.propertyTaxUtaraSave(propertyTaxUtara);	}

		@Override
		public PropertyTaxUtara get(long rtiApplicationRefId) {
			// TODO Auto-generated method stub
			return propertyTaxUtaraDAO.get(rtiApplicationRefId);
		}
		@Override
		public PropertyTaxUtara getDetails(long rtiApplicationId) {
			// TODO Auto-generated method stub
			return propertyTaxUtaraDAO.getDetails(rtiApplicationId);
		}

}
