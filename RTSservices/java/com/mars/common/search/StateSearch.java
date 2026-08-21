package com.mars.common.search;

public class StateSearch extends BaseSearchObject {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		if((this.name!=null)&&(this.name.length()>0)){
			setSearchParamSet(true);
		}
	}
	
	

}
