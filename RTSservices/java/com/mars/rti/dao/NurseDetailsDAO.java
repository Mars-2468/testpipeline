package com.mars.rti.dao;

import com.mars.rti.model.NurseDetails;

public interface NurseDetailsDAO {

	
	public NurseDetails mergeNurseDetails(NurseDetails sd);
	
	
	public NurseDetails getNurseDetails(long id);
	
}
