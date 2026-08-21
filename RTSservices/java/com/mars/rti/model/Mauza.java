package com.mars.rti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="mauza",schema="egovcommon")

public class Mauza {

	@Id
	@Column(name = "mauzaid", nullable = false, unique = true)
	private long mauzaid;
	
	@Column(name = "mauza", nullable = false)
    private String mauza;

	public long getMauzaid() {
		return mauzaid;
	}

	public void setMauzaid(long mauzaid) {
		this.mauzaid = mauzaid;
	}

	public String getMauza() {
		return mauza;
	}

	public void setMauza(String mauza) {
		this.mauza = mauza;
	}
	
	
}
