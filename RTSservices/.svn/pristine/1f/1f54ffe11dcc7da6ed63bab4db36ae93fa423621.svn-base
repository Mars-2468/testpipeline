package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * FeeType
 */
@Entity
@Table(name = "fee_type", schema = "egovrti")
public class FeeType implements java.io.Serializable
{

	@Id
	@Column(name = "fee_type_id", nullable = false, unique = true)
	@SequenceGenerator(name = "fee_type_seq", sequenceName = "fee_type_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fee_type_seq")
    private long feeTypeId;

	@Column(name = "name", nullable = false)
    private String name;

	public FeeType()
    {
    }

    public FeeType(String name)
    {
	this.name = name;
    }
    
	public long getFeeTypeId() {
		return feeTypeId;
	}

	public void setFeeTypeId(long feeTypeId) {
		this.feeTypeId = feeTypeId;
	}

	public String getName()
    {
	return this.name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

}
