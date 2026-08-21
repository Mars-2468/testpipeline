package com.mars.common.search;

public class CitySearch extends BaseSearchObject {
	
	private String name;
	private long talukaId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		if(this.name!=null && this.name.length()>0){
			setSearchParamSet(true);
		}
	}
	public long getTalukaId() {
		return talukaId;
	}
	public void setTalukaId(long talukaId) {
		this.talukaId = talukaId;
		if(this.talukaId>0){
			setSearchParamSet(true);
		}
	}
	
	

}
