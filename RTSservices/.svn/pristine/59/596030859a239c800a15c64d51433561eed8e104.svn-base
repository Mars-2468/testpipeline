package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.BiologicalWasteDisposal;



public interface BiologicalWasteService {

	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveBiologicalWasteForm(BiologicalWasteDisposal biologicalWasteDisposal);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long BiologicalWasteDisposal(BiologicalWasteDisposal biologicalWasteDisposal);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public BiologicalWasteDisposal get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public BiologicalWasteDisposal merge(BiologicalWasteDisposal biologicalWasteDisposal);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long BiologicalWasteDisposalSave(BiologicalWasteDisposal biologicalWasteDisposal);
}
