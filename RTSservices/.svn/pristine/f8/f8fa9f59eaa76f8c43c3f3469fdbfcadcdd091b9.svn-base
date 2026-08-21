package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/**
 * FileType
 */
@Entity
@Table(name = "fee_master", schema = "egovrti")
@DataTransferObject(type = "hibernate3")
public class FeeMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "fee_master_id", nullable = false, unique = true)
	@SequenceGenerator(name = "fee_master_seq", sequenceName = "fee_master_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fee_master_seq")
	@RemoteProperty
	private long feeMasterId;
	@Column(name = "fee_name")
	@RemoteProperty
	private String name;
	@RemoteProperty
	@Column(name = "fee_category")
	private int category;
	@RemoteProperty
	@Column(name = "from_date")
	private String fromDate;
	@RemoteProperty
	@Column(name = "to_date")
	private String toDate;
	@RemoteProperty
	@Column(name = "fee_per_copy")
	private Double amountPerCopy;
	@RemoteProperty
	@Column(name = "max_number_ocopy")
	private Integer maxNoOfCopy;
	@RemoteProperty
	@Column(name = "amount")
	private Double amount = new Double(0.0);
	@Column(name = "status")
	@RemoteProperty
	private Integer status = new Integer(1);
	@Column(name = "description")
	@RemoteProperty
	private String description;
 
	@Column(name = "postal_charges")
	@RemoteProperty
	private Double postalCharges;

	public long getFeeMasterId() {
		return feeMasterId;
	}

	public void setFeeMasterId(long feeMasterId) {
		this.feeMasterId = feeMasterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Double getAmountPerCopy() {
		return amountPerCopy;
	}

	public void setAmountPerCopy(Double amountPerCopy) {
		this.amountPerCopy = amountPerCopy;
	}

	public Integer getMaxNoOfCopy() {
		return maxNoOfCopy;
	}

	public void setMaxNoOfCopy(Integer maxNoOfCopy) {
		this.maxNoOfCopy = maxNoOfCopy;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPostalCharges() {
		return postalCharges;
	}

	public void setPostalCharges(Double postalCharges) {
		this.postalCharges = postalCharges;
	}

	 
	
}
