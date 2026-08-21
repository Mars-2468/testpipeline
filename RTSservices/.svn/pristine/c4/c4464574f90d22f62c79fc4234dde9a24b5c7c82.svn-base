package com.mars.rti.search;

import com.mars.common.search.BaseSearchObject;

public class InboxSearch extends BaseSearchObject{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String application;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
		if(userId > 0)
			setSearchParamSet(true);
	}
	
	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
		if(this.application != null  && this.application.length() > 0)
			setSearchParamSet(true);
	}

}

