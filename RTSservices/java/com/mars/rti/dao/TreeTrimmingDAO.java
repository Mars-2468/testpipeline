package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.TreeTrimming;
import com.mars.rti.model.TreeTrimmingDetails;
import com.mars.rti.model.TreesType;

public interface TreeTrimmingDAO {


	public void saveTreeTrimming(TreeTrimming treeTrimming) ;
	public long treeTrimmingSave(TreeTrimming treeTrimming);
	public  TreeTrimming get(long id);
	public TreeTrimming merge(TreeTrimming treeTrimming);
	public TreeTrimming getDetails(long rtiApplicationId);
	public void savetreeTypeList(List<TreeTrimmingDetails> ttList);
	public List<TreeTrimmingDetails> getTreeTypeList(long id);
	public String getfees(String nameOfTree);


}



