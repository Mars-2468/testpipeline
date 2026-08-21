package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.TaxExemptionNonResidentialDAO;
import com.mars.rti.model.TaxExemptionNonResidential;
import com.mars.rti.service.TaxExemptionNonResidentialService;

@Service
public class TaxExemptionNonResidentialServiceImpl implements TaxExemptionNonResidentialService{

	@Autowired
	private TaxExemptionNonResidentialDAO taxExemptionNonResidentialDAO;
	
	
	@Override
	public void saveTaxExemptionNonResidential(TaxExemptionNonResidential taxExemptionNonResidential) {
		taxExemptionNonResidentialDAO.saveTaxExemptionNonResidential(taxExemptionNonResidential);
		
	}

	@Override
	public long getReferenceId(TaxExemptionNonResidential taxExemptionNonResidential) {
		return taxExemptionNonResidentialDAO.getTaxExemptionNonResidentialId(taxExemptionNonResidential);
	}

	@Override
	public TaxExemptionNonResidential get(long rtiApplicationRefId) {
		return taxExemptionNonResidentialDAO.get(rtiApplicationRefId);
	}

	@Override
	public TaxExemptionNonResidential getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return taxExemptionNonResidentialDAO.getDetails(rtiApplicationId);
	}

	@Override
	public TaxExemptionNonResidential merge(TaxExemptionNonResidential taxExemptionNonResidential) {
		// TODO Auto-generated method stub
		return taxExemptionNonResidentialDAO.merge(taxExemptionNonResidential);
	}

}
