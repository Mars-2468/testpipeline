package com.mars.common.search;

public class RoleSearch extends BaseSearchObject {
	private static final long serialVersionUID = 1L;

	private String roleName;
	
	public RoleSearch() {}

	public RoleSearch(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
		if(this.roleName != null  && this.roleName.length() > 0)setSearchParamSet(true);
	}
}
