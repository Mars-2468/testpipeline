package com.mars.rti.search;

import com.mars.common.search.BaseSearchObject;

public class OutboxSearch extends BaseSearchObject {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String application;
	private long id;
	private long userId;
		
	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
		if(this.application != null  && this.application.length() > 0)
			setSearchParamSet(true);
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
		if(userId > 0)
			setSearchParamSet(true);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
		if(id > 0)
			setSearchParamSet(true);
	}
			
}
