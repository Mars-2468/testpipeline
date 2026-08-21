package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="water_proposed_tap_size",schema="egovrti")

public class ProposedTapSize {

	@Id
	@Column(name = "tapsize_id", nullable = false, unique = true)
	private long propertapsizeid;
	
	@Column(name = "tapsize_name_value", nullable = false)
    private String propertapsize;

	public long getPropertapsizeid() {
		return propertapsizeid;
	}

	public void setPropertapsizeid(long propertapsizeid) {
		this.propertapsizeid = propertapsizeid;
	}

	public String getPropertapsize() {
		return propertapsize;
	}

	public void setPropertapsize(String propertapsize) {
		this.propertapsize = propertapsize;
	}
	
	
}
