package com.mars.common.search;

import org.apache.commons.lang.StringUtils;

public class DepartmentSearch extends BaseSearchObject {
	
	private String name;
	
	private String status;
	
	public DepartmentSearch(){
	}
	
	public DepartmentSearch(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		if (this.name != null && this.name.length() > 0)
		      setSearchParamSet(true);
	}
	
	public String getStatus() {
		return status;
	}

	
	public void setStatus(String status) {
		this.status = status;
		if (StringUtils.isNotEmpty(status))
			setSearchParamSet(true);
	}

}
