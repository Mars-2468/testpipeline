package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.TreeCuting;
import com.mars.rti.model.TreesType;
import com.mars.rti.search.RTIApplicationSearch;



public interface TreeCutingService {
  

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveTreeCutingForm(TreeCuting treeCuting);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public long treeCuting(TreeCuting treeCuting);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TreeCuting get(long rtiApplicationRefId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TreeCuting merge(TreeCuting treeCuting);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public TreeCuting getDetails(long rtiApplicationId);

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void savetreeTypeList(List<TreesType> ttList);

	public List<TreesType> getTreeTypeList(long id);
	
	//public String getfees(String treeCuting);
	
	public String getfees(String nameOfTree);
	
//
	 public List<RTIApplication> getTreeApplications(RTIApplicationSearch applicationSearch,String userZone,String userLevel, boolean isZoneUser);
	   

	   public long getTreeApplicationsCount(RTIApplicationSearch applicationSearch,String userZone,String userLevel, boolean isZoneUser);		   
	  

}


