package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.TreeCuting;
import com.mars.rti.model.TreesType;
import com.mars.rti.search.RTIApplicationSearch;

public interface TreeCutingDAO {
   
	public void saveTreeCuting(TreeCuting treeCuting) ;
	public long treeCutingSave(TreeCuting treeCuting);
	public  TreeCuting get(long id);
	public TreeCuting merge(TreeCuting treeCuting);
	public TreeCuting getDetails(long rtiApplicationId);
	public void savetreeTypeList(List<TreesType> ttList);
	public List<TreesType> getTreeTypeList(long id);
	public String getfees(String nameOfTree);
	
	 public List<RTIApplication> getTreeApplications(RTIApplicationSearch applicationSearch,String userZone,String userLevel, boolean isZoneUser);
	   

	   public long getTreeApplicationsCount(RTIApplicationSearch applicationSearch,String userZone,String userLevel, boolean isZoneUser);		   
	  


}
