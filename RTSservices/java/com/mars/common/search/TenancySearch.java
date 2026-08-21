package com.mars.common.search;

public class TenancySearch extends BaseSearchObject {
	
    private String name;
	
	private String code;
	
	private String category;

	private long cityId;
	
	public TenancySearch(){
	}
	
	public TenancySearch(String name){
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
		if (this.code != null && this.code.length() > 0)
		      setSearchParamSet(true);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
		if (this.category != null && this.category.length() > 0)
		      setSearchParamSet(true);
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}


}
