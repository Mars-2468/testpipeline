package com.mars.common.model; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "delivery_mode_fields", schema = "egovrti")
public class DeliveryModeFields implements java.io.Serializable
{
	private static final long serialVersionUID = -4557232123888673028L;

	@Id
	@Column(name = "delivery_mode_fields_id", nullable = false, unique = true)
	@SequenceGenerator(name = "delivery_mode_fields_seq", sequenceName = "delivery_mode_fields_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_mode_fields_seq")
    private long deliveryModeFieldsId;

	@Column(name = "field_name", nullable = false)
    private String fieldName;
	
	@Column(name = "field_type", nullable = false)
    private String fieldType;
	
	@Column(name = "field_data_type", nullable = false)
    private String fieldDataType;
	
	@Column(name = "field_required", nullable = false)
    private Integer fieldRequired;
	
	@ManyToOne
	@JoinColumn(name = "delivery_mode_id")
	private DeliveryMode deliveryMode;
	
	
 	public DeliveryModeFields()
    {
    }


	public long getDeliveryModeFieldsId() {
		return deliveryModeFieldsId;
	}


	public void setDeliveryModeFieldsId(long deliveryModeFieldsId) {
		this.deliveryModeFieldsId = deliveryModeFieldsId;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public String getFieldType() {
		return fieldType;
	}


	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}


	public String getFieldDataType() {
		return fieldDataType;
	}


	public void setFieldDataType(String fieldDataType) {
		this.fieldDataType = fieldDataType;
	}


	public Integer getFieldRequired() {
		return fieldRequired;
	}


	public void setFieldRequired(Integer fieldRequired) {
		this.fieldRequired = fieldRequired;
	}


	public DeliveryMode getDeliveryMode() {
		return deliveryMode;
	}


	public void setDeliveryMode(DeliveryMode deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

 	
}
