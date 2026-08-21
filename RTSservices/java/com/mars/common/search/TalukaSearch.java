package com.mars.common.search;

public class TalukaSearch extends BaseSearchObject {
	
	private String name;
	private long districtId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		if((this.name!=null && this.name.length()>0)){
			setSearchParamSet(true);
		}
	}
	public long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
		if(this.districtId>0){
			setSearchParamSet(true);
		}
	}
	
	

}
