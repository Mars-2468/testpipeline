package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="fire_fees_master_updated",schema="egovrti")
public class FireFeesMasterUpdated {

		@Id
		@Column(name = "fire_fees_master_updated_id", nullable = false, unique = true)
		@SequenceGenerator(name = "fire_fees_master_updated_seq", sequenceName = "fire_fees_master_updated_seq")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fire_fees_master_updated_seq")
		private long fireFeesMasterUpdatedId;
		
		@Column(name ="master_fees",nullable= true)
		private String masterFees;
		
		@Column(name = "categories")
		private long categories;
		
		@Column(name = "type_of_constructions")
		private long typeOfConstructions;
		
		@Column(name = "height_of_building")
		private long heightOfBuilding;
		
		@Column(name = "type_of_building")
		private long typeOfBuilding;
		
		@Column(name = "catagory")
		private long catagory;

		public long getFireFeesMasterUpdatedId() {
			return fireFeesMasterUpdatedId;
		}

		public void setFireFeesMasterUpdatedId(long fireFeesMasterUpdatedId) {
			this.fireFeesMasterUpdatedId = fireFeesMasterUpdatedId;
		}

		public String getMasterFees() {
			return masterFees;
		}

		public void setMasterFees(String masterFees) {
			this.masterFees = masterFees;
		}

		public long getCategories() {
			return categories;
		}

		public void setCategories(long categories) {
			this.categories = categories;
		}

		public long getTypeOfConstructions() {
			return typeOfConstructions;
		}

		public void setTypeOfConstructions(long typeOfConstructions) {
			this.typeOfConstructions = typeOfConstructions;
		}

		public long getHeightOfBuilding() {
			return heightOfBuilding;
		}

		public void setHeightOfBuilding(long heightOfBuilding) {
			this.heightOfBuilding = heightOfBuilding;
		}

		public long getTypeOfBuilding() {
			return typeOfBuilding;
		}

		public void setTypeOfBuilding(long typeOfBuilding) {
			this.typeOfBuilding = typeOfBuilding;
		}

		public long getCatagory() {
			return catagory;
		}

		public void setCatagory(long catagory) {
			this.catagory = catagory;
		}
		
			
}
