package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity

@Table(name="tree_trimming_reason",schema="egovcommon")
public class TreeTrimmingReason {

	@Id
	@Column(name = "tree_trimming_id", nullable = false, unique = true)
	private long treeTrimmingReasonId;
	
	@Column(name = "trimming_reason", nullable = false)
    private String treeTrimmingReason;

	public long getTreeTrimmingReasonId() {
		return treeTrimmingReasonId;
	}

	public void setTreeTrimmingReasonId(long treeTrimmingReasonId) {
		this.treeTrimmingReasonId = treeTrimmingReasonId;
	}

	public String getTreeTrimmingReason() {
		return treeTrimmingReason;
	}

	public void setTreeTrimmingReason(String treeTrimmingReason) {
		this.treeTrimmingReason = treeTrimmingReason;
	}

	
	
}
