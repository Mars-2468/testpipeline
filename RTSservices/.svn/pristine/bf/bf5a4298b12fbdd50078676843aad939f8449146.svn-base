package com.mars.common.search;

public class DistrictSearch extends BaseSearchObject {
	
	private String name;
	private long stateId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		if((this.name!=null && this.name.length()>0)){
			setSearchParamSet(true);
		}
	}
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
		if(this.stateId>0){
			setSearchParamSet(true);
		}
	}
	
	

}
