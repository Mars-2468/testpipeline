package com.mars.rti.dao;

import com.mars.rti.model.GaneshMandapPermission;

public interface GaneshMandapPermissionDAO {

	public void saveGaneshMandapPermission(GaneshMandapPermission mandapPermission) ;
	public long ganeshMandapPermissionSave(GaneshMandapPermission mandapPermission);
	public GaneshMandapPermission get(long id);
	public GaneshMandapPermission merge(
			GaneshMandapPermission gneshMandapPermission);
	public GaneshMandapPermission getDetails(long rtiApplicationId);
}
