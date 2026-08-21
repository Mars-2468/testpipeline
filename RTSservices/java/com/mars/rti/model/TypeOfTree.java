package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="type_of_tree",schema="egovcommon")

public class TypeOfTree {

	@Id
	@Column(name = "type_of_tree_id", nullable = false, unique = true)
	private long typeOfTreeId;
	
	@Column(name = "tree_type", nullable = false)
    private String treeType;

	public long getTypeOfTreeId() {
		return typeOfTreeId;
	}

	public void setTypeOfTreeId(long typeOfTreeId) {
		this.typeOfTreeId = typeOfTreeId;
	}

	public String getTreeType() {
		return treeType;
	}

	public void setTreeType(String treeType) {
		this.treeType = treeType;
	}

	
	
}
