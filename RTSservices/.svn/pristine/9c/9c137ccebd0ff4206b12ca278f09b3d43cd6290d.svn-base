package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Water_proposed_tap_size",schema="egovrti")
public class WaterProposedTapSize {

	@Id
	@Column(name = "tapsize_id", nullable = false, unique = true)
	@SequenceGenerator(name = "tapsize_seq", sequenceName = "tapsize_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tapsize_seq")
	private long tapSizeId;
	
	@Column(name ="tapsize_name",nullable= true)
	private String tapSizeName;
	
	
	@Column(name ="tapsize_name_value",nullable= true)
	private String tapSizeNameValue;


	public long getTapSizeId() {
		return tapSizeId;
	}


	public void setTapSizeId(long tapSizeId) {
		this.tapSizeId = tapSizeId;
	}


	public String getTapSizeName() {
		return tapSizeName;
	}


	public void setTapSizeName(String tapSizeName) {
		this.tapSizeName = tapSizeName;
	}


	public String getTapSizeNameValue() {
		return tapSizeNameValue;
	}


	public void setTapSizeNameValue(String tapSizeNameValue) {
		this.tapSizeNameValue = tapSizeNameValue;
	}


	


}
