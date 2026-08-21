package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * Bank 
 */
@Entity
@Table(name = "DICTIONARY", schema = "egovrti")
public class Dictionary implements java.io.Serializable
{

	@Id
	@Column(name = "DICTIONARY_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "DICTIONARY_SEQ", sequenceName = "DICTIONARY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DICTIONARY_SEQ")
    private long dictionaryId;

	@Column(name = "KEY", nullable = false)
    private String key;

	@Column(name = "VALUE", nullable = false)
    private String value;
	
	@Column(name = "TENANCYID", nullable = true)
    private Integer tenancyId;

    public Dictionary()
    {
    }

	/**
	 * @return the dictionaryId
	 */
	public long getDictionaryId() {
		return dictionaryId;
	}

	/**
	 * @param dictionaryId the dictionaryId to set
	 */
	public void setDictionaryId(long dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public Integer getTenancyId() {
		return tenancyId;
	}

	public void setTenancyId(Integer tenancyId) {
		this.tenancyId = tenancyId;
	}
	
    
}
