package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="treelocation",schema="egovcommon")
public class TreeLocation {

	@Id
	@Column(name = "treelocationid", nullable = false, unique = true)
	private long treelocationid;
	
	@Column(name = "treelocation", nullable = false)
    private String treelocation;

	public long getTreelocationid() {
		return treelocationid;
	}

	public String getTreelocation() {
		return treelocation;
	}

	public void setTreelocationid(long treelocationid) {
		this.treelocationid = treelocationid;
	}

	public void setTreelocation(String treelocation) {
		this.treelocation = treelocation;
	}
	
	
}
