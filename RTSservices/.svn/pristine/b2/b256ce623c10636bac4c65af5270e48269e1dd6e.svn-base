package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TaxExmeptionDAO;
import com.mars.rti.model.PropertyTaxExemption;
import com.mars.rti.service.TaxExmeptionService;

@Service
public class TaxExmeptionServiceImpl implements TaxExmeptionService{

	@Autowired
	private TaxExmeptionDAO taxExemptionNonResidentialDAO;
	
	
	@Override
	public void saveTaxExemptionNonResidential(PropertyTaxExemption taxExemptionNonResidential) {
		taxExemptionNonResidentialDAO.saveTaxExemptionNonResidential(taxExemptionNonResidential);
		
	}

	@Override
	public long getReferenceId(PropertyTaxExemption taxExemptionNonResidential) {
		return taxExemptionNonResidentialDAO.getTaxExemptionNonResidentialId(taxExemptionNonResidential);
	}

	@Override
	public PropertyTaxExemption get(long rtiApplicationRefId) {
		return taxExemptionNonResidentialDAO.get(rtiApplicationRefId);
	}
	
	@Override
	public PropertyTaxExemption getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return taxExemptionNonResidentialDAO.getDetails(rtiApplicationId);
	}

	@Override
	public PropertyTaxExemption merge(PropertyTaxExemption propertyTaxExemption) {
		// TODO Auto-generated method stub
		return taxExemptionNonResidentialDAO.merge(propertyTaxExemption);
	}
}
