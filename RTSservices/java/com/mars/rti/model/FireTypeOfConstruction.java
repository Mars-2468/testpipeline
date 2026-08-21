package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "fire_type_of_construction", schema ="egovrti")
public class FireTypeOfConstruction {
	
	@Id
	@Column(name = "fire_building_construction_type_id", nullable = false, unique = true)
	private long fireBuildingconstructionTypeId;
	
	@Column( name = "fire_building_construction_type_name")
	private String fireBuildingConstructionTypeName;
	
	@Column( name = "fire_building_construction_type_fees")
	private String fireBuildingConstructionTypeFees;
	
	@Column( name = "b_c_class_municipal_councils_nagar_panchayats_special_planning")
	private String bCClassMunicipalCouncilsNagarPanchayatsSpecialPlanning;
	
	@Column( name = "all_municipal_councils")
	private String allMunicipalCouncils;
	
	@Column( name = "all_wards_rural")
	private String allWardsRural;

	public long getFireBuildingconstructionTypeId() {
		return fireBuildingconstructionTypeId;
	}

	public void setFireBuildingconstructionTypeId(long fireBuildingconstructionTypeId) {
		this.fireBuildingconstructionTypeId = fireBuildingconstructionTypeId;
	}

	

	public String getFireBuildingConstructionTypeName() {
		return fireBuildingConstructionTypeName;
	}

	public void setFireBuildingConstructionTypeName(String fireBuildingConstructionTypeName) {
		this.fireBuildingConstructionTypeName = fireBuildingConstructionTypeName;
	}

	public String getFireBuildingConstructionTypeFees() {
		return fireBuildingConstructionTypeFees;
	}

	public void setFireBuildingConstructionTypeFees(String fireBuildingConstructionTypeFees) {
		this.fireBuildingConstructionTypeFees = fireBuildingConstructionTypeFees;
	}

	public String getbCClassMunicipalCouncilsNagarPanchayatsSpecialPlanning() {
		return bCClassMunicipalCouncilsNagarPanchayatsSpecialPlanning;
	}

	public void setbCClassMunicipalCouncilsNagarPanchayatsSpecialPlanning(
			String bCClassMunicipalCouncilsNagarPanchayatsSpecialPlanning) {
		this.bCClassMunicipalCouncilsNagarPanchayatsSpecialPlanning = bCClassMunicipalCouncilsNagarPanchayatsSpecialPlanning;
	}

	public String getAllMunicipalCouncils() {
		return allMunicipalCouncils;
	}

	public void setAllMunicipalCouncils(String allMunicipalCouncils) {
		this.allMunicipalCouncils = allMunicipalCouncils;
	}

	public String getAllWardsRural() {
		return allWardsRural;
	}

	public void setAllWardsRural(String allWardsRural) {
		this.allWardsRural = allWardsRural;
	}

	
	

	
	
}
