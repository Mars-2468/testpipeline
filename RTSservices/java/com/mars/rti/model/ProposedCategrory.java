package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="water_proposed_category_type",schema="egovrti")
public class ProposedCategrory {

	@Id
	@Column(name = "categorytype_id", nullable = false, unique = true)
	private long categoryid;
	
	@Column(name = "categorytype_name_value", nullable = false)
    private String categoryname;

	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
}
