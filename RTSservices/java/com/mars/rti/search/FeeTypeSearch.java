package com.mars.rti.search;
import com.mars.common.search.BaseSearchObject;

public class FeeTypeSearch extends BaseSearchObject {
	
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		if(this.name!=null && this.name.length()>0){
			setSearchParamSet(true);
		}
	}

}
