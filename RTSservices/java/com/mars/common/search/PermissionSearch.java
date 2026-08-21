package com.mars.common.search;

public class PermissionSearch extends BaseSearchObject {
	private static final long serialVersionUID = 1L;

	private String name;
	private String url;
	private long groupId;
	
	public PermissionSearch() {}

	public PermissionSearch(String name, String url, long groupId) {
		this.name = name;
		this.url = url;
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		if(this.name != null  && this.name.length() > 0)setSearchParamSet(true);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		if(this.url != null  && this.url.length() > 0)setSearchParamSet(true);
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
		if(this.groupId != 0)setSearchParamSet(true);
	}
}
