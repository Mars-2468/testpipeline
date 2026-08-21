package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.FeesMaster;

@Transactional(readOnly = true)
public interface FeesMasterService 
{
	public FeesMaster getFees(long rtiapplicationserviceid);
}