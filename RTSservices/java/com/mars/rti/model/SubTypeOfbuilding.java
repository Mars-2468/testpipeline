package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="sub_type_Of_building",schema="egovrti")
public class SubTypeOfbuilding {

		@Id
		@Column(name = "sub_type_Of_building_id", nullable = false, unique = true)
		@SequenceGenerator(name = "sub_type_Of_building_seq", sequenceName = "sub_type_Of_building_seq")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_type_Of_building_seq")
		private long subTypeOfBuildingId;
		
		@Column(name ="sub_type_of_building_name",nullable= true)
		private String subTypeOfBuildingName;
		
		@Column(name = "fire_type_of_building_id")
		private long fireTypeOfBuildingId;
		
		public long getSubTypeOfBuildingId() {
			return subTypeOfBuildingId;
		}

		public void setSubTypeOfBuildingId(long subTypeOfBuildingId) {
			this.subTypeOfBuildingId = subTypeOfBuildingId;
		}

		public String getSubTypeOfBuildingName() {
			return subTypeOfBuildingName;
		}

		public void setSubTypeOfBuildingName(String subTypeOfBuildingName) {
			this.subTypeOfBuildingName = subTypeOfBuildingName;
		}

		public long getFireTypeOfBuildingId() {
			return fireTypeOfBuildingId;
		}

		public void setFireTypeOfBuildingId(long fireTypeOfBuildingId) {
			this.fireTypeOfBuildingId = fireTypeOfBuildingId;
		}
		
		
		
}
