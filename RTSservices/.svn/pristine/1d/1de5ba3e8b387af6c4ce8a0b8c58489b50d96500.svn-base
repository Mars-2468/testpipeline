package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.ChangeInOwnershipTypeDAO;
import com.mars.rti.model.ChangeInOwnershipType;
import com.mars.rti.service.ChangeInOwnershipTypeService;

@Service
public class ChangeInOwnershipServiceImpl implements ChangeInOwnershipTypeService{
	
	@Autowired
	private ChangeInOwnershipTypeDAO changeInOwnershipTypeDAO;

	@Override
	public void saveChangeInOwnershipType(ChangeInOwnershipType changeInOwnershipType) {
		changeInOwnershipTypeDAO.saveChangeInOwnershipType(changeInOwnershipType);
	}

	@Override
	public long changeInOwnershipType(ChangeInOwnershipType changeInOwnershipType) {
		return changeInOwnershipTypeDAO.changeInOwnershipTypeSave(changeInOwnershipType);
	}

	@Override
	public ChangeInOwnershipType get(long rtiApplicationRefId) {
		return changeInOwnershipTypeDAO.get(rtiApplicationRefId);
	}

	@Override
	public List<ChangeInOwnershipType> getAllChangeInOwnershipType() {
		return changeInOwnershipTypeDAO.getAllChangeInOwnershipType();
	}

	@Override
	public ChangeInOwnershipType getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return changeInOwnershipTypeDAO.getDetails(rtiApplicationId);
	}
	
	@Override
	public ChangeInOwnershipType merge(ChangeInOwnershipType changeInOwnershipType) {
		// TODO Auto-generated method stub
		return changeInOwnershipTypeDAO.merge(changeInOwnershipType);
	}


}
