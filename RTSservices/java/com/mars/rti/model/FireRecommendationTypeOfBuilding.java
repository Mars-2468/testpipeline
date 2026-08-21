package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="fire_recommendation_type_of_building",schema="egovrti")
public class FireRecommendationTypeOfBuilding {

	@Id
	@Column(name = "fire_typeof_building_id", nullable = false, unique = true)
	@SequenceGenerator(name = "rti_firerecommendation_typeof_buidling_seq", sequenceName = "rti_firerecommendation_typeof_buidling_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rti_firerecommendation_typeof_buidling_seq")
	private long fireTypeOfBuildingId;
	
	@Column(name ="firetype_of_building_names",nullable= true)
	private String firetypeofbuildingnames;
	

	
	public long getFireTypeOfBuildingId() {
		return fireTypeOfBuildingId;
	}

	public void setFireTypeOfBuildingId(long fireTypeOfBuildingId) {
		this.fireTypeOfBuildingId = fireTypeOfBuildingId;
	}

	public String getFiretypeofbuildingnames() {
		return firetypeofbuildingnames;
	}

	public void setFiretypeofbuildingnames(String firetypeofbuildingnames) {
		this.firetypeofbuildingnames = firetypeofbuildingnames;
	}


	
}
