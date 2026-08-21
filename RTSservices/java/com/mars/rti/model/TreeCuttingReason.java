package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity

@Table(name="tree_cutting_reason",schema="egovcommon")
public class TreeCuttingReason {

	@Id
	@Column(name = "tree_cutting_id", nullable = false, unique = true)
	private long treeCuttingId;
	
	@Column(name = "cutting_reason", nullable = false)
    private String treeCuttingReason;

	public long getTreeCuttingId() {
		return treeCuttingId;
	}

	public void setTreeCuttingId(long treeCuttingId) {
		this.treeCuttingId = treeCuttingId;
	}

	public String getTreeCuttingReason() {
		return treeCuttingReason;
	}

	public void setTreeCuttingReason(String treeCuttingReason) {
		this.treeCuttingReason = treeCuttingReason;
	}

	
	
	
}
