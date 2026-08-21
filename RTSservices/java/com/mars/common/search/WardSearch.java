package com.mars.common.search;

public class WardSearch extends BaseSearchObject {

	 private String name;
	 private long cityId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		if(this.name!=null && this.name.length()>0){
			setSearchParamSet(true);
		}
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
		if(this.cityId>0){
			setSearchParamSet(true);
		}
	}
	 
 }
