package com.mars.common.search;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Base class for Model objects. This is basically for the toString, equals and
 * hashCode methods.
 * 
 */
public class BaseSearchObject implements Serializable
{

    private long currentPage = 1;

    private String orderBy = "ctid";

    private String sortBy = "desc";

    private boolean searchParamSet = false;

    /**
     * Fields
     */
    private static final long serialVersionUID = 1L;

    public String toString()
    {
	return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public boolean equals(Object o)
    {
	return EqualsBuilder.reflectionEquals(this, o);
    }

    public long getCurrentPage()
    {
	return currentPage;
    }

    public void setCurrentPage(long currentPage)
    {
	this.currentPage = currentPage;
    }

    public String getOrderBy()
    {
	return orderBy;
    }

    public void setOrderBy(String orderBy)
    {
	this.orderBy = orderBy;
    }

    public String getSortBy()
    {
	return sortBy;
    }

    public void setSortBy(String sortBy)
    {
	this.sortBy = sortBy;
    }

    /**
     * @return the searchParamSet
     */
    public boolean isSearchParamSet()
    {
	return searchParamSet;
    }

    /**
     * @param searchParamSet the searchParamSet to set
     */
    public void setSearchParamSet(boolean searchParamSet)
    {
	this.searchParamSet = searchParamSet;
    }
}
