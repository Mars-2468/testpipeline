package com.mars.rti.dao;

import com.mars.rti.model.MandapPermission;


 public interface MandapPermissionDAO {

	public void saveMandapPermission(MandapPermission mandapPermission) ;
	public long mandapPermissionSave(MandapPermission mandapPermission);
	public MandapPermission get(long id);
	public MandapPermission getDetails(long rtiApplicationId);

	public MandapPermission merge(MandapPermission mandapPermission);

}

 