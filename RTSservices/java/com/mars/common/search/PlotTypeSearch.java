package com.mars.common.search;

public class PlotTypeSearch extends BaseSearchObject {
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		if(this.description!=null && this.description.length()>0){
			setSearchParamSet(true);
		}
	}
	
	

}
