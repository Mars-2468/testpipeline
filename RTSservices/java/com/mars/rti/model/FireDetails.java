package com.mars.rti.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//
//@Entity
//@Table(name ="fire_details", schema="egovrti")
//public class FireDetails {
//	
//	@Id
//	@Column(name ="fire_details_id",nullable = false,unique = true)
//	@SequenceGenerator(name = "fire_details_seq", sequenceName = "fire_details_seq")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fire_details_seq")
//	private long fireDetailsId;
//	
//	@Column(name ="floor_Name")
//	private String floorName;
//	
//	//fireFloorTypes
//	@Column(name ="firefloortypes")
//	private String fireFloorTypes;
//	
//	@Column(name ="comm_area")
//	private String commArea;
//	
//	@Column(name ="resid_area")
//	private String residArea;
//	
//	@Column(name ="primumAr")
//	private String primumAr;
//	
//	@Column(name ="other_use")
//	private String otherUse;
//	
//	@Column(name ="total_table")
//	private String totalTable;
//	
//	@Column(name ="row_wise_total")
//	private String rowWiseTotal;
//	
//	
//
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name = "fire_recommendation_id", nullable = false)
//	private FireRecommendation fireRecommendation;
//
//	public long getFireDetailsId() {
//		return fireDetailsId;
//	}
//
//
//	public void setFireDetailsId(long fireDetailsId) {
//		this.fireDetailsId = fireDetailsId;
//	}
//
//
//	public String getFloorName() {
//		return floorName;
//	}
//
//
//	public void setFloorName(String floorName) {
//		this.floorName = floorName;
//	}
//
//
//	public String getCommArea() {
//		return commArea;
//	}
//
//
//	public void setCommArea(String commArea) {
//		this.commArea = commArea;
//	}
//
//
//	public String getResidArea() {
//		return residArea;
//	}
//
//
//	public void setResidArea(String residArea) {
//		this.residArea = residArea;
//	}
//
//
//	public String getPrimumAr() {
//		return primumAr;
//	}
//
//
//	public void setPrimumAr(String primumAr) {
//		this.primumAr = primumAr;
//	}
//
//
//	public String getOtherUse() {
//		return otherUse;
//	}
//
//
//	public void setOtherUse(String otherUse) {
//		this.otherUse = otherUse;
//	}
//
//
//	public String getTotalTable() {
//		return totalTable;
//	}
//
//
//	public void setTotalTable(String totalTable) {
//		this.totalTable = totalTable;
//	}
//
//
//	public FireRecommendation getFireRecommendation() {
//		return fireRecommendation;
//	}
//
//
//	public void setFireRecommendation(FireRecommendation fireRecommendation) {
//		this.fireRecommendation = fireRecommendation;
//	}
//
//
//	public String getRowWiseTotal() {
//		return rowWiseTotal;
//	}
//
//
//	public void setRowWiseTotal(String rowWiseTotal) {
//		this.rowWiseTotal = rowWiseTotal;
//	}
//
//
//	public String getFireFloorTypes() {
//		return fireFloorTypes;
//	}
//
//
//	public void setFireFloorTypes(String fireFloorTypes) {
//		this.fireFloorTypes = fireFloorTypes;
//	}
//	
//	
	
@Entity
@Table(name ="fire_details", schema="egovrti")
public class FireDetails {

	 @Id
	    @Column(name = "fire_details_id", nullable = false, unique = true)
	    @SequenceGenerator(
	            name = "fire_details_seq",
	            sequenceName = "fire_details_seq",
	            allocationSize = 1)
	    @GeneratedValue(
	            strategy = GenerationType.SEQUENCE,
	            generator = "fire_details_seq")
	    private long fireDetailsId;

	    @Column(name = "floor_name")
	    private String floorName;

	    @Column(name = "firefloortypes")
	    private String fireFloorTypes;

	    @Column(name = "comm_area", precision = 15, scale = 4)
	    private BigDecimal commArea;

	    @Column(name = "resid_area", precision = 15, scale = 4)
	    private BigDecimal residArea;

	    @Column(name = "primumar", precision = 15, scale = 4)
	    private BigDecimal primumAr;

	    @Column(name = "other_use", precision = 15, scale = 4)
	    private BigDecimal otherUse;

	    @Column(name = "total_table", precision = 15, scale = 4)
	    private BigDecimal totalTable;

	    @Column(name = "row_wise_total", precision = 15, scale = 4)
	    private BigDecimal rowWiseTotal;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "fire_recommendation_id", nullable = false)
	    private FireRecommendation fireRecommendation;

		public long getFireDetailsId() {
			return fireDetailsId;
		}

		public void setFireDetailsId(long fireDetailsId) {
			this.fireDetailsId = fireDetailsId;
		}

		public String getFloorName() {
			return floorName;
		}

		public void setFloorName(String floorName) {
			this.floorName = floorName;
		}

		public String getFireFloorTypes() {
			return fireFloorTypes;
		}

		public void setFireFloorTypes(String fireFloorTypes) {
			this.fireFloorTypes = fireFloorTypes;
		}

		public BigDecimal getCommArea() {
			return commArea;
		}

		public void setCommArea(BigDecimal commArea) {
			this.commArea = commArea;
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

		public BigDecimal getOtherUse() {
			return otherUse;
		}

		public void setOtherUse(BigDecimal otherUse) {
			this.otherUse = otherUse;
		}

		public BigDecimal getTotalTable() {
			return totalTable;
		}

		public void setTotalTable(BigDecimal totalTable) {
			this.totalTable = totalTable;
		}

		public BigDecimal getRowWiseTotal() {
			return rowWiseTotal;
		}

		public void setRowWiseTotal(BigDecimal rowWiseTotal) {
			this.rowWiseTotal = rowWiseTotal;
		}

		public FireRecommendation getFireRecommendation() {
			return fireRecommendation;
		}

		public void setFireRecommendation(FireRecommendation fireRecommendation) {
			this.fireRecommendation = fireRecommendation;
		}
	    
	    
    
    

}
