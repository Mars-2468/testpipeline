package com.mars.rti.dao;

import com.mars.rti.model.DikshaBhumiMandapPermission;

public interface DikshaBhumiDAO {

	public void saveDikshaBhumiMandapPermission(DikshaBhumiMandapPermission mandapPermission) ;
	public long dikshaBhumiMandapPermissionSave(DikshaBhumiMandapPermission mandapPermission);
	public DikshaBhumiMandapPermission get(long id);
	public DikshaBhumiMandapPermission merge(
			DikshaBhumiMandapPermission gneshMandapPermission);
	public DikshaBhumiMandapPermission getDetails(long rtiApplicationId);
}
