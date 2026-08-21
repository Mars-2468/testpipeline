package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fire_building_height", schema="egovrti")
public class FireBuildingHeight {
	
	@Id
	@Column(name = "fire_building_height_id", nullable = false,unique =  true)
	private long fireBuildingHeightId;
	
	@Column(name = "fire_building_height_type")
	private String fireBuildingType;

	public long getFireBuildingHeightId() {
		return fireBuildingHeightId;
	}

	public void setFireBuildingHeightId(long fireBuildingHeightId) {
		this.fireBuildingHeightId = fireBuildingHeightId;
	}

	public String getFireBuildingType() {
		return fireBuildingType;
	}

	public void setFireBuildingType(String fireBuildingType) {
		this.fireBuildingType = fireBuildingType;
	}
	
	
}
