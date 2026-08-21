package com.mars.rti.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="misc_purpose_with_amount",schema="egovrti")
public class MisPurposeWithAmount {


	@Id
	@Column(name = "purpose_id", nullable = false, unique = true)
	@SequenceGenerator(name = "purpose_seq", sequenceName = "purpose_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purpose_seq")
	private long purposeId;
	
	@Column(name ="purpose",nullable= true)
	private String purpose;
	
	
	@Column(name ="amount",nullable= true)
	private long amount;


	public long getPurposeId() {
		return purposeId;
	}


	public void setPurposeId(long purposeId) {
		this.purposeId = purposeId;
	}


	public String getPurpose() {
		return purpose;
	}


	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}


	public long getAmount() {
		return amount;
	}


	public void setAmount(long amount) {
		this.amount = amount;
	}


	


	

	


}
