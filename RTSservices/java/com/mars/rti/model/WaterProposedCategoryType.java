package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Water_proposed_category_Type",schema="egovrti")
public class WaterProposedCategoryType {

	@Id
	@Column(name = "categorytype_id", nullable = false, unique = true)
	@SequenceGenerator(name = "categorytype_seq", sequenceName = "categorytype_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorytype_seq")
	private long categorytypeId;
	
	@Column(name ="categorytype_name",nullable= true)
	private String categorytypeName;
	
	
	@Column(name ="categorytype_name_value",nullable= true)
	private String categorytypeNameValue;


	public long getCategorytypeId() {
		return categorytypeId;
	}


	public void setCategorytypeId(long categorytypeId) {
		this.categorytypeId = categorytypeId;
	}


	public String getCategorytypeName() {
		return categorytypeName;
	}


	public void setCategorytypeName(String categorytypeName) {
		this.categorytypeName = categorytypeName;
	}


	public String getCategorytypeNameValue() {
		return categorytypeNameValue;
	}


	public void setCategorytypeNameValue(String categorytypeNameValue) {
		this.categorytypeNameValue = categorytypeNameValue;
	}
	
	


}
