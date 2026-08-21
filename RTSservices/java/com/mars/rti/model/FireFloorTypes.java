package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="fire_floor_types",schema="egovrti")
public class FireFloorTypes {

		@Id
		@Column(name = "fire_floor_types_id", nullable = false, unique = true)
		@SequenceGenerator(name = "fire_floor_types_seq", sequenceName = "fire_floor_types_seq")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fire_floor_types_seq")
		private long fireFloorTypesId;
		
		@Column(name ="fire_floor_types_name",nullable= true)
		private String fireFloorTypesName;
		


		public long getFireFloorTypesId() {
			return fireFloorTypesId;
		}

		public void setFireFloorTypesId(long fireFloorTypesId) {
			this.fireFloorTypesId = fireFloorTypesId;
		}

		public String getFireFloorTypesName() {
			return fireFloorTypesName;
		}

		public void setFireFloorTypesName(String fireFloorTypesName) {
			this.fireFloorTypesName = fireFloorTypesName;
		}

		
		
		
}
