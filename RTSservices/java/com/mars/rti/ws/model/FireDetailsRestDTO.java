package com.mars.rti.ws.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("serial")
@JsonPropertyOrder({ "floorName", "fireFloorType", "residArea", "primumAr", "commArea", "otherUse", "totalFees"})

public class FireDetailsRestDTO {

	    private String floorName;
	    private String fireFloorType;
	    private BigDecimal residArea;
	    private BigDecimal primumAr;
	    private BigDecimal commArea;
	    private BigDecimal otherUse;
	    private BigDecimal totalFees;
		public String getFloorName() {
			return floorName;
		}
		public void setFloorName(String floorName) {
			this.floorName = floorName;
		}
		public String getFireFloorType() {
			return fireFloorType;
		}
		public void setFireFloorType(String fireFloorType) {
			this.fireFloorType = fireFloorType;
		}
		public BigDecimal getResidArea() {
			return residArea;
		}
		public void setResidArea(BigDecimal residArea) {
			this.residArea = residArea;
		}
		public BigDecimal getPrimumAr() {
			return primumAr;
		}
		public void setPrimumAr(BigDecimal primumAr) {
			this.primumAr = primumAr;
		}
		public BigDecimal getCommArea() {
			return commArea;
		}
		public void setCommArea(BigDecimal commArea) {
			this.commArea = commArea;
		}
		public BigDecimal getOtherUse() {
			return otherUse;
		}
		public void setOtherUse(BigDecimal otherUse) {
			this.otherUse = otherUse;
		}
		public BigDecimal getTotalFees() {
			return totalFees;
		}
		public void setTotalFees(BigDecimal totalFees) {
			this.totalFees = totalFees;
		}

	    // Getters and Setters
		
	    
	    
	}


