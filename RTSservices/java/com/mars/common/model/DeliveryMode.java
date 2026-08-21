package com.mars.common.model; 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
 


/**
 * FileType 
 */
@Entity
@Table(name = "delivery_mode", schema = "egovrti")
public class DeliveryMode implements java.io.Serializable
{

	@Id
	@Column(name = "delivery_mode_id", nullable = false, unique = true)
	@SequenceGenerator(name = "delivery_mode_seq", sequenceName = "delivery_mode_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_mode_seq")
    private long deliveryModeId;

	@Column(name = "delivery_mode_name", nullable = false)
    private String deliveryModeName;
	 
	@Column(name = "status", nullable = false)
    private Integer status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "deliveryMode", cascade = CascadeType.ALL)
	private List<DeliveryModeFields> deliveryModeFields = new ArrayList<DeliveryModeFields>();

	public long getDeliveryModeId() {
		return deliveryModeId;
	}

	public void setDeliveryModeId(long deliveryModeId) {
		this.deliveryModeId = deliveryModeId;
	}

	public String getDeliveryModeName() {
		return deliveryModeName;
	}

	public void setDeliveryModeName(String deliveryModeName) {
		this.deliveryModeName = deliveryModeName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<DeliveryModeFields> getDeliveryModeFields() {
		return deliveryModeFields;
	}

	public void setDeliveryModeFields(List<DeliveryModeFields> deliveryModeFields) {
		this.deliveryModeFields = deliveryModeFields;
	}

	 
  

}
