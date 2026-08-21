
package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="water_purpose",schema="egovcommon")

public class NewWaterConnectionPurpose {
	
	@Id
	@Column(name = "purposeid", nullable = false, unique = true)
	private long purposeid;
	
	@Column(name = "purpose", nullable = false)
    private String purpose;

	public long getPurposeid() {
		return purposeid;
	}

	public void setPurposeid(long purposeid) {
		this.purposeid = purposeid;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	

}
