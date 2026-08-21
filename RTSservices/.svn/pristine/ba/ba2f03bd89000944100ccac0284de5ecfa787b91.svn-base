package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="title",schema="egovcommon")

public class Title {
	
	@Id
	@Column(name = "titleId", nullable = false, unique = true)
	private long titleId;
	
	@Column(name = "titletype", nullable = false)
    private String title;

	public long getTitleId() {
		return titleId;
	}

	public void setTitleId(long titleId) {
		this.titleId = titleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

}
