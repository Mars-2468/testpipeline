package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.NewWaterConnection;
import com.mars.rti.model.WaterConnectionPurpose;
import com.mars.rti.model.WaterProposedCategoryType;

@Transactional(readOnly = true)
public interface NewWaterConnectionService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveNewWaterConnectionForm(NewWaterConnection newWaterConnection);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long newWaterConnection(NewWaterConnection newWaterConnection);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NewWaterConnection get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<NewWaterConnection> getAllNewWaterConnection();
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NewWaterConnection getDetails(long rtiApplicationId);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public NewWaterConnection merge(NewWaterConnection newWaterConnection);
	
	

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public List<WaterConnectionPurpose> getWaterConnectionPurpose();


}
