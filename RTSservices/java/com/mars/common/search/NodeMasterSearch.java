package com.mars.common.search;

public class NodeMasterSearch extends BaseSearchObject {
	
	private String name;
	private long wardId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		if(this.name!=null && this.name.length()>0){
			setSearchParamSet(true);
		}
	}
	public long getWardId() {
		return wardId;
	}
	public void setWardId(long wardId) {
		this.wardId = wardId;
		if(this.wardId>0){
			setSearchParamSet(true);
		}
	}
	

}
