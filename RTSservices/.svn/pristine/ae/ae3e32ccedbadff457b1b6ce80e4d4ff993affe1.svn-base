package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.PartitionOfPropertyDAO;
import com.mars.rti.model.PartitionOfProperty;
import com.mars.rti.service.PartitionOfPropertyService;

@Service
public class PartitionOfPropertyServiceImpl implements PartitionOfPropertyService {

	@Autowired
	private PartitionOfPropertyDAO partitionOfPropertyDAO;

	@Override
	public void savePartitionOfPropertyForm(PartitionOfProperty partitionOfProperty) {
		partitionOfPropertyDAO.savepartitionOfProperty(partitionOfProperty);

	}

	@Override
	public long partitionOfProperty(PartitionOfProperty partitionOfProperty) {
		return partitionOfPropertyDAO.partitionOfPropertySave(partitionOfProperty);

	}

	@Override
	public PartitionOfProperty get(long rtiApplicationRefId) {
		return partitionOfPropertyDAO.get(rtiApplicationRefId);

	}
	
	@Override
	public PartitionOfProperty getDetails(long rtiApplicationId) {
		// TODO Auto-generated method stub
		return partitionOfPropertyDAO.getDetails(rtiApplicationId);
	}

	@Override
	public PartitionOfProperty merge(PartitionOfProperty partitionOfProperty) {
		// TODO Auto-generated method stub
		return partitionOfPropertyDAO.merge(partitionOfProperty);
	}

}