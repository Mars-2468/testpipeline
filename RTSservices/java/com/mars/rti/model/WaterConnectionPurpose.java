package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Water_Connection_Purpose",schema="egovrti")
public class WaterConnectionPurpose {
	@Id
	@Column(name = "purpose_id", nullable = false, unique = true)
	@SequenceGenerator(name = "purpose_seq", sequenceName = "purpose_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purpose_seq")
	private long purposeId;
	
	@Column(name ="purpose_name",nullable= true)
	private String purposeName;
	
	
	@Column(name ="purpose_name_value",nullable= true)
	private String purposeNameValue;


	public long getPurposeId() {
		return purposeId;
	}


	public void setPurposeId(long purposeId) {
		this.purposeId = purposeId;
	}


	public String getPurposeName() {
		return purposeName;
	}


	public void setPurposeName(String purposeName) {
		this.purposeName = purposeName;
	}


	public String getPurposeNameValue() {
		return purposeNameValue;
	}


	public void setPurposeNameValue(String purposeNameValue) {
		this.purposeNameValue = purposeNameValue;
	}



	


}
