package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fire_fees_main" , schema = "egovrti")
public class FireFeesMain {

	@Id
	@Column(name ="fire_fees_type_id" , nullable=false, unique=true)
	private long fireFeesTypeId;
	
	@Column(name ="fire_fees")
	private String fireFees;
	
	@Column(name ="type_of_building_id")
	private long typeOfBuildingId;
	
	@Column(name ="fire_height_of_building_id")
	private long fireHeightOfBuildingID;

	public long getFireFeesTypeId() {
		return fireFeesTypeId;
	}

	public void setFireFeesTypeId(long fireFeesTypeId) {
		this.fireFeesTypeId = fireFeesTypeId;
	}

	public String getFireFees() {
		return fireFees;
	}

	public void setFireFees(String fireFees) {
		this.fireFees = fireFees;
	}

	public long getTypeOfBuildingId() {
		return typeOfBuildingId;
	}

	public void setTypeOfBuildingId(long typeOfBuildingId) {
		this.typeOfBuildingId = typeOfBuildingId;
	}

	public long getFireHeightOfBuildingID() {
		return fireHeightOfBuildingID;
	}

	public void setFireHeightOfBuildingID(long fireHeightOfBuildingID) {
		this.fireHeightOfBuildingID = fireHeightOfBuildingID;
	}


	
	
	
}
