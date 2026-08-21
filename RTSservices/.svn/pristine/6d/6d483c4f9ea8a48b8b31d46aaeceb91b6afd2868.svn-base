package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.BiologicalWasteDisposalDAO;
import com.mars.rti.model.BiologicalWasteDisposal;
import com.mars.rti.service.BiologicalWasteService;

@Service("BiologicalWasteService")
public class BiologicalWasteDiposalServiceImpl implements BiologicalWasteService {
  
	
	
	@Autowired
	private BiologicalWasteDisposalDAO biologicalWasteDisposalDAO;

	@Override
	public void saveBiologicalWasteForm(BiologicalWasteDisposal biologicalWasteDisposal) {
		biologicalWasteDisposalDAO.saveBiologicalDisposal(biologicalWasteDisposal);
	}

	@Override
	public BiologicalWasteDisposal get(long rtiApplicationRefId) {
		// TODO Auto-generated method stub
		return biologicalWasteDisposalDAO.get(rtiApplicationRefId);
	}
		@Override
		public long BiologicalWasteDisposal(BiologicalWasteDisposal biologicalWasteDisposal) {
			// TODO Auto-generated method stub
			return biologicalWasteDisposalDAO.biologicalDisposalSave(biologicalWasteDisposal);
		}

		@Override
		public BiologicalWasteDisposal merge(
				BiologicalWasteDisposal biologicalWasteDisposal) {
			// TODO Auto-generated method stub
			return biologicalWasteDisposalDAO.merge(biologicalWasteDisposal);
		}

		@Override
		public long BiologicalWasteDisposalSave(BiologicalWasteDisposal biologicalWasteDisposal) {
			// TODO Auto-generated method stub
			return biologicalWasteDisposalDAO.BiologicalWasteDisposalSave(biologicalWasteDisposal);

		}

	
}
