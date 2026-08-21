package com.mars.workflow.search;

import com.mars.common.search.BaseSearchObject;

public class WorkflowTemplateSearch extends BaseSearchObject {
	
	private static final long serialVersionUID = 1L;
	private long tenancyId;
	
	public long getTenancyId() {
		return tenancyId;
	}
	public void setTenancyId(long tenancyId) {
		this.tenancyId = tenancyId;
		if (tenancyId > -1)
			setSearchParamSet(true);
	}
	
}
